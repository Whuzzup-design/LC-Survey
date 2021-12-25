package com.lc.survey.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.lc.survey.NoSuchSurveyPageException;
import com.lc.survey.model.SurveyOption;
import com.lc.survey.model.SurveyPage;
import com.lc.survey.service.SurveyOptionLocalServiceUtil;
import com.lc.survey.service.SurveyPageLocalServiceUtil;
import com.lc.survey.service.SurveyResultLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class SurveyUtils {

	public static long randomNumber() {
		return (long) (Math.random() * 100000);
	}

	public static String getDirectTextByPageId(PageContext pageContext,
			long surveyPageId) throws NoSuchSurveyPageException,
			SystemException {

		String directText = LanguageUtil.get(pageContext,
				"guide-to-prefix-word");

		if (surveyPageId == 0) {
			directText += LanguageUtil.get(pageContext, "no-setting");
		} else if (surveyPageId == -1) {
			directText += LanguageUtil.get(pageContext, "submit-form");
		} else {
			SurveyPage s_page = SurveyPageLocalServiceUtil
					.fetchSurveyPage(surveyPageId);
			directText += s_page.getTitle();
		}

		return directText;
	}

	public static void translatePageDirectToId(long mainId)
			throws SystemException, NoSuchSurveyPageException {

		List<SurveyPage> s_pages = SurveyPageLocalServiceUtil
				.findBySurveyMainId(mainId);
		List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
				.findBySurveyMainId(mainId);

		for (SurveyPage s_page : s_pages) {

			if (s_page.getPageDirectId() == 0 || s_page.getPageDirectId() == -1)
				continue;
			s_page.setPageDirectId(SurveyPageLocalServiceUtil
					.findBySurveyMainIdAndNo(mainId,
							(int) s_page.getPageDirectId()).getSurveyPageId());
			SurveyPageLocalServiceUtil.updateSurveyPage(s_page);
		}

		for (SurveyOption s_option : s_options) {

			if (s_option.getPageDirectId() == 0
					|| s_option.getPageDirectId() == -1)
				continue;
			s_option.setPageDirectId(SurveyPageLocalServiceUtil
					.findBySurveyMainIdAndNo(mainId,
							(int) s_option.getPageDirectId()).getSurveyPageId());
			SurveyOptionLocalServiceUtil.updateSurveyOption(s_option);
		}
	}

	public static String getDilutedColor(String color, String dilution) {
		
		String backgroundColor = color.substring(0, color.lastIndexOf(","))
				.toString().concat(", ").concat(dilution).concat(")");

		return backgroundColor;
	}

	public static String getCorrectAreaBackgroundColor(String color) {
		
		String backgroundColor = color.substring(0, color.lastIndexOf(","))
				.toString().concat(", 0.05)");

		return backgroundColor;
	}

	public static boolean authenticateWriter(HttpServletRequest request,
			String login, String password, String authType)
			throws PortalException, SystemException {

		Company company = PortalUtil.getCompany(request);

		Enumeration<String> enu1 = request.getHeaderNames();

		Map<String, String[]> headerMap = new HashMap<String, String[]>();

		Map<String, String[]> parameterMap = request.getParameterMap();

		Map<String, Object> resultsMap = new HashMap<String, Object>();

		int authResult = Authenticator.FAILURE;

		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();

			Enumeration<String> enu2 = request.getHeaders(name);

			List<String> headers = new ArrayList<String>();

			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();

				headers.add(value);
			}

			headerMap.put(name, headers.toArray(new String[headers.size()]));
		}

		long userId = GetterUtil.getLong(login);

		if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
			authResult = UserLocalServiceUtil.authenticateByEmailAddress(
					company.getCompanyId(), login, password, headerMap,
					parameterMap, resultsMap);
		} else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
			authResult = UserLocalServiceUtil.authenticateByScreenName(
					company.getCompanyId(), login, password, headerMap,
					parameterMap, resultsMap);
		} else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
			authResult = UserLocalServiceUtil.authenticateByUserId(
					company.getCompanyId(), userId, password, headerMap,
					parameterMap, resultsMap);
		}

		return authResult == Authenticator.SUCCESS ? true : false;
	}

	public static String getOrdinalNumber(int number) {

		String ordinalNumber = String.valueOf(number);
		int remainder = number % 10;

		if (remainder == 1) {
			ordinalNumber += "st";
		} else if (remainder == 2) {
			ordinalNumber += "nd";
		} else if (remainder == 3) {
			ordinalNumber += "rd";
		} else {
			ordinalNumber += "th";
		}

		return ordinalNumber;
	}

	public static String transferToScoreFormat(float score) {

		String rtn = String.valueOf(score);
		boolean isFloat = false;
		String decimalNumbers = rtn.substring(rtn.lastIndexOf(".") + 1,
				rtn.length());

		for (String decimalNumber : StringUtil.split(decimalNumbers)) {
			if (!decimalNumber.equals("0")) {
				isFloat = true;
				break;
			}
		}

		// 如果是整數就把.之後的數字都拿掉(包括.)
		if (!isFloat)
			rtn = rtn.substring(0, rtn.lastIndexOf("."));

		return rtn;
	}

	// canvas用javascript set height會刷新畫布，所以要先算出高度(預設高度為250，從離畫布上方25距離開始算)
	public static int calculateCanvasHeight(long surveyQuestionId)
			throws SystemException {

		int height = 25;
		List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
				.findBySurveyQuestionId(surveyQuestionId);

		for (SurveyOption s_option : s_options) {

			// 連百分比及選項結果個數一起計算
			int optionLength = s_option.getOption().length()
					+ SurveyResultLocalServiceUtil.countByQ_O(surveyQuestionId,
							s_option.getSurveyOptionId()) + 10;

			// 每行30個字
			int rowCount = optionLength % 30 == 0 ? optionLength / 30
					: optionLength / 30 + 1;

			// 同一個選項內，每行文字的高度為14；每個選項相隔30距離
			height += (rowCount * 14 + 30);
		}
		
		// 預留"其他"選項的空間
		height += (14 + 30);

		return height > 250 ? height : 250;
	}
}
