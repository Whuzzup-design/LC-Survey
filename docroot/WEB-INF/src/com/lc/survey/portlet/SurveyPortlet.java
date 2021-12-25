package com.lc.survey.portlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.lc.survey.NoSuchSurveyPageException;
import com.lc.survey.model.SurveyFile;
import com.lc.survey.model.SurveyMain;
import com.lc.survey.model.SurveyOption;
import com.lc.survey.model.SurveyPage;
import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.model.SurveyResponse;
import com.lc.survey.model.SurveyResult;
import com.lc.survey.model.SurveyWriter;
import com.lc.survey.service.SurveyFileLocalServiceUtil;
import com.lc.survey.service.SurveyMainLocalServiceUtil;
import com.lc.survey.service.SurveyOptionLocalServiceUtil;
import com.lc.survey.service.SurveyPageLocalServiceUtil;
import com.lc.survey.service.SurveyQuestionLocalServiceUtil;
import com.lc.survey.service.SurveyResponseLocalServiceUtil;
import com.lc.survey.service.SurveyResultLocalServiceUtil;
import com.lc.survey.service.SurveyWriterLocalServiceUtil;
import com.lc.survey.utils.SurveyConstants;
import com.lc.survey.utils.SurveyPageDirectUtils;
import com.lc.survey.utils.SurveyResultUtils;
import com.lc.survey.utils.SurveyUtils;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SurveyPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(SurveyPortlet.class);

	private static final SimpleDateFormat _ymd = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static final SimpleDateFormat _sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		String resourceId = request.getResourceID();

		try {
			if (resourceId.equals("createSurvey")) {
				createSurvey(request, response);
			} else if (resourceId.equals("updateSurvey")) {
				updateSurvey(request, response);
			} else if (resourceId.equals("getFile")) {
				getFile(request, response);
			} else if (resourceId.equals("createResultExcel")) {
				createResultExcel(request, response);
			} else if (resourceId.equals("createResponseExcel")) {
				createResponseExcel(request, response);
			} else if (resourceId.equals("downloadExcel")) {
				downloadExcel(request, response);
			} else {
				super.serveResource(request, response);
			}
		} catch (Exception e) {
			_log.warn(e);
		}
	}

	private void createSurvey(ResourceRequest request, ResourceResponse response)
			throws IOException, SystemException, ParseException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		long mainId = CounterLocalServiceUtil.increment(SurveyMain.class
				.getName());
		long pageId = CounterLocalServiceUtil.increment(SurveyPage.class
				.getName());
		long modifiedDate = System.currentTimeMillis();
		Date startDate = _sdf.parse(_ymd.format(modifiedDate) + " 00:00:00");
		Date endDate = _sdf.parse(_ymd.format(modifiedDate) + " 23:59:59");

		SurveyMain surveyMain = SurveyMainLocalServiceUtil
				.createSurveyMain(mainId);
		SurveyPage surveyPage = SurveyPageLocalServiceUtil
				.createSurveyPage(pageId);

		SurveyMainLocalServiceUtil.updateSurveyMain(surveyMain,
				LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
						"untitled-survey"), "", "", startDate, endDate, false,
				false, false, SurveyConstants.SURVEY_DEFAULT_COLOR,
				themeDisplay.getUserId(), modifiedDate, Constants.ADD);

		SurveyPageLocalServiceUtil.updateSurveyPage(surveyPage, mainId, 1,
				LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
						"untitled-page"), 0, themeDisplay.getUserId(),
				modifiedDate, Constants.ADD);

		this.createSurveyFolder(themeDisplay, mainId);

		jsonObject.put("mainId", mainId);

		writeJSON(request, response, jsonObject);
	}

	private void updateSurvey(ResourceRequest request, ResourceResponse response)
			throws SystemException, ParseException, IOException,
			NoSuchSurveyPageException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		long modifiedDate = System.currentTimeMillis();

		long mainId = ParamUtil.getLong(request, "mainId");
		String title = ParamUtil.getString(request, "title");
		String description = ParamUtil.getString(request, "description");
		String epilog = ParamUtil.getString(request, "epilog");
		Date startDate = _sdf.parse(ParamUtil.getString(request, "startDate")
				+ " 00:00:00");
		Date endDate = _sdf.parse(ParamUtil.getString(request, "endDate")
				+ " 23:59:59");
		boolean needAuth = ParamUtil.getBoolean(request, "needAuth");
		boolean calculateScore = ParamUtil
				.getBoolean(request, "calculateScore");
		boolean viewAnswer = ParamUtil.getBoolean(request, "viewAnswer");
		String color = ParamUtil.getString(request, "color");

		SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);

		SurveyMainLocalServiceUtil.updateSurveyMain(s_main, title, description,
				epilog, startDate, endDate, needAuth, calculateScore,
				viewAnswer, color, themeDisplay.getUserId(), modifiedDate,
				Constants.UPDATE);

		int pageCount = ParamUtil.getInteger(request, "pageCount");
		for (int pageNo = 1; pageNo <= pageCount; pageNo++) {

			SurveyPage s_page = null;
			long surveyPageId = ParamUtil.getLong(request, "page" + pageNo
					+ "_id");
			String pageTitle = ParamUtil.getString(request, "page" + pageNo
					+ "_title");
			long pageDirect = ParamUtil.getLong(request, "page" + pageNo
					+ "_pageDirect");
			String pageAction = Constants.ADD;

			if (surveyPageId == 0) {
				surveyPageId = CounterLocalServiceUtil
						.increment(SurveyPage.class.getName());
				s_page = SurveyPageLocalServiceUtil
						.createSurveyPage(surveyPageId);

				// create response object
				String elementId = ParamUtil.getString(request, "page" + pageNo
						+ "_elementId");
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("type", "page");
				jsonObject.put("elementId", elementId);
				jsonObject.put("id", surveyPageId);
				jsonArray.put(jsonObject);
			} else {
				s_page = SurveyPageLocalServiceUtil
						.fetchSurveyPage(surveyPageId);
				pageAction = Constants.UPDATE;
			}
			SurveyPageLocalServiceUtil.updateSurveyPage(s_page, mainId, pageNo,
					pageTitle, pageDirect, themeDisplay.getUserId(),
					modifiedDate, pageAction);

			int questionCount = ParamUtil.getInteger(request, "questionCount"
					+ pageNo);
			for (int questionNo = 1; questionNo <= questionCount; questionNo++) {

				SurveyQuestion s_question = null;
				long surveyQuestionId = ParamUtil.getLong(request, "question"
						+ pageNo + "_" + questionNo + "_id");
				String question = ParamUtil.getString(request, "question"
						+ pageNo + "_" + questionNo + "_question");
				String type = ParamUtil.getString(request, "question" + pageNo
						+ "_" + questionNo + "_type");
				boolean isRequired = ParamUtil.getBoolean(request, "question"
						+ pageNo + "_" + questionNo + "_isRequired");
				long questionFileId = ParamUtil.getLong(request, "question"
						+ pageNo + "_" + questionNo + "_fileId");
				boolean hasOther = false;
				boolean optionDirect = false;
				String points = "0";
				int starsCount = 0;
				String questionAction = Constants.ADD;

				if (surveyQuestionId == 0) {
					surveyQuestionId = CounterLocalServiceUtil
							.increment(SurveyQuestion.class.getName());
					s_question = SurveyQuestionLocalServiceUtil
							.createSurveyQuestion(surveyQuestionId);

					// create response object
					String elementId = ParamUtil.getString(request, "question"
							+ pageNo + "_" + questionNo + "_elementId");
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("type", "question");
					jsonObject.put("elementId", elementId);
					jsonObject.put("id", surveyQuestionId);
					jsonArray.put(jsonObject);
				} else {
					s_question = SurveyQuestionLocalServiceUtil
							.fetchSurveyQuestion(surveyQuestionId);
					questionAction = Constants.UPDATE;
				}

				if (type.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE)
						|| type.equals(SurveyConstants.QUESTION_TYPE_CHECKBOX)
						|| type.equals(SurveyConstants.QUESTION_TYPE_DROPDOWN_LIST)
						|| type.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)
						|| type.equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)) {

					hasOther = ParamUtil.getBoolean(request, "question"
							+ pageNo + "_" + questionNo + "_hasOther");
					optionDirect = ParamUtil.getBoolean(request, "question"
							+ pageNo + "_" + questionNo + "_optionDirect");
					points = ParamUtil.getString(request, "question" + pageNo
							+ "_" + questionNo + "_points");

					int optionCount = ParamUtil.getInteger(request,
							"optionCount" + pageNo + "_" + questionNo);

					for (int optionNo = 1; optionNo <= optionCount; optionNo++) {

						SurveyOption s_option = null;
						String optionAction = Constants.ADD;

						long surveyOptionId = ParamUtil.getLong(request,
								"option" + pageNo + "_" + questionNo + "_"
										+ optionNo + "_id");
						String option = ParamUtil.getString(request, "option"
								+ pageNo + "_" + questionNo + "_" + optionNo
								+ "_option");
						boolean isAns = ParamUtil.getBoolean(request, "option"
								+ pageNo + "_" + questionNo + "_" + optionNo
								+ "_isAns");
						long optionPageDirect = ParamUtil.getLong(request,
								"option" + pageNo + "_" + questionNo + "_"
										+ optionNo + "_pageDirect");
						long optionFileId = ParamUtil.getLong(request, "option"
								+ pageNo + "_" + questionNo + "_" + optionNo
								+ "_fileId");

						if (surveyOptionId == 0) {

							surveyOptionId = CounterLocalServiceUtil
									.increment(SurveyOption.class.getName());

							s_option = SurveyOptionLocalServiceUtil
									.createSurveyOption(surveyOptionId);

							// create response object
							String elementId = ParamUtil.getString(request,
									"option" + pageNo + "_" + questionNo + "_"
											+ optionNo + "_elementId");
							JSONObject jsonObject = JSONFactoryUtil
									.createJSONObject();
							jsonObject.put("type", "option");
							jsonObject.put("elementId", elementId);
							jsonObject.put("id", surveyOptionId);
							jsonArray.put(jsonObject);
						} else {
							s_option = SurveyOptionLocalServiceUtil
									.fetchSurveyOption(surveyOptionId);
							optionAction = Constants.UPDATE;
						}
						SurveyOptionLocalServiceUtil.updateSurveyOption(
								s_option, mainId, surveyPageId,
								surveyQuestionId, optionNo, option, isAns,
								optionPageDirect, optionFileId,
								themeDisplay.getUserId(), modifiedDate,
								optionAction);
					}

					// update sub question
					if (type.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)
							|| type.equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)) {

						int subQuestionCount = ParamUtil.getInteger(request,
								"subQuestionCount" + pageNo + "_" + questionNo);

						for (int subQuestionNo = 1; subQuestionNo <= subQuestionCount; subQuestionNo++) {

							SurveyQuestion sub_question = null;
							String subQuestionAction = Constants.ADD;

							long subQuestionId = ParamUtil.getLong(request,
									"subQuestion" + pageNo + "_" + questionNo
											+ "_" + subQuestionNo + "_id");
							String subQuestionText = ParamUtil.getString(
									request, "subQuestion" + pageNo + "_"
											+ questionNo + "_" + subQuestionNo
											+ "_question");

							if (subQuestionId == 0) {

								subQuestionId = CounterLocalServiceUtil
										.increment(SurveyQuestion.class
												.getName());

								sub_question = SurveyQuestionLocalServiceUtil
										.createSurveyQuestion(subQuestionId);

								// create response object
								String elementId = ParamUtil.getString(request,
										"subQuestion" + pageNo + "_"
												+ questionNo + "_"
												+ subQuestionNo + "_elementId");
								JSONObject jsonObject = JSONFactoryUtil
										.createJSONObject();
								jsonObject.put("type", "subQuestion");
								jsonObject.put("elementId", elementId);
								jsonObject.put("id", subQuestionId);
								jsonArray.put(jsonObject);
							} else {
								sub_question = SurveyQuestionLocalServiceUtil
										.fetchSurveyQuestion(subQuestionId);
								subQuestionAction = Constants.UPDATE;
							}
							SurveyQuestionLocalServiceUtil
									.updateSurveyQuestion(sub_question, mainId,
											surveyPageId, surveyQuestionId,
											subQuestionNo, subQuestionText,
											type, isRequired, false, false,
											"0", 0, 0,
											themeDisplay.getUserId(),
											modifiedDate, subQuestionAction);
						}
					}

				} else if (type.equals(SurveyConstants.QUESTION_TYPE_STAR)) {

					starsCount = ParamUtil.getInteger(request, "question"
							+ pageNo + "_" + questionNo + "_starsCount");
				}
				SurveyQuestionLocalServiceUtil.updateSurveyQuestion(s_question,
						mainId, surveyPageId, 0, questionNo, question, type,
						isRequired, hasOther, optionDirect, points, starsCount,
						questionFileId, themeDisplay.getUserId(), modifiedDate,
						questionAction);
			}
		}
		removeOldP_Q_O(mainId, modifiedDate);
		// 將page和option的pageDirectId轉為pageId
		SurveyUtils.translatePageDirectToId(mainId);

		writeJSON(request, response, jsonArray);
	}

	// 移除舊資料
	private void removeOldP_Q_O(long mainId, long modifiedDate)
			throws SystemException {

		List<SurveyPage> s_pages = SurveyPageLocalServiceUtil
				.findBySurveyMainId(mainId);
		List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
				.findBySurveyMainId(mainId);
		List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
				.findBySurveyMainId(mainId);

		for (SurveyPage s_page : s_pages) {
			if (s_page.getModifiedDate() != modifiedDate) {
				SurveyPageLocalServiceUtil.deleteSurveyPage(s_page);
			}
		}

		for (SurveyQuestion s_question : s_questions) {
			if (s_question.getModifiedDate() != modifiedDate) {
				SurveyQuestionLocalServiceUtil.deleteSurveyQuestion(s_question);
			}
		}

		for (SurveyOption s_option : s_options) {
			if (s_option.getModifiedDate() != modifiedDate) {
				SurveyOptionLocalServiceUtil.deleteSurveyOption(s_option);
			}
		}
	}

	private void createSurveyFolder(ThemeDisplay themeDisplay, long mainId)
			throws PortalException, SystemException {

		if (!DLStoreUtil.hasDirectory(themeDisplay.getCompanyId(),
				CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME)) {

			DLStoreUtil
					.addDirectory(themeDisplay.getCompanyId(),
							CompanyConstants.SYSTEM,
							SurveyConstants.SURVEY_FOLDER_NAME);
		}
		DLStoreUtil.addDirectory(themeDisplay.getCompanyId(),
				CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
						+ StringPool.SLASH + mainId);
	}

	public void removeSurvey(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		String redirect = getRedirect(request, response);

		ServiceContext context = ServiceContextFactory.getInstance(
				SurveyFile.class.getName(), request);

		long mainId = ParamUtil.getLong(request, "mainId");

		SurveyMainLocalServiceUtil.deleteSurveyMain(mainId);
		SurveyPageLocalServiceUtil.removeBySurveyMainId(mainId);
		SurveyQuestionLocalServiceUtil.removeBySurveyMainId(mainId);
		SurveyOptionLocalServiceUtil.removeBySurveyMainId(mainId);
		SurveyResultLocalServiceUtil.removeBySurveyMainId(mainId);
		SurveyWriterLocalServiceUtil.removeBySurveyMainId(mainId);
		SurveyResponseLocalServiceUtil.removeBySurveyMainId(mainId);
		SurveyFileLocalServiceUtil.removeBySurveyMainId(mainId);

		// remove folder
		DLStoreUtil.deleteDirectory(context.getCompanyId(),
				CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
						+ StringPool.SLASH + mainId);

		request.setAttribute(WebKeys.REDIRECT, redirect);
	}

	private void getFile(ResourceRequest request, ResourceResponse response)
			throws PortalException, SystemException {

		ServiceContext context = ServiceContextFactory.getInstance(
				SurveyFile.class.getName(), request);

		HttpServletRequest httpRequest = PortalUtil
				.getHttpServletRequest(request);

		HttpServletResponse httpResponse = PortalUtil
				.getHttpServletResponse(response);

		long mainId = ParamUtil.getLong(request, "mainId");
		long fileId = ParamUtil.getLong(request, "fileId");

		InputStream inputStream = null;
		try {
			inputStream = DLStoreUtil.getFileAsStream(context.getCompanyId(),
					CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
							+ StringPool.SLASH + mainId + StringPool.SLASH
							+ fileId);
			long contentLength = DLStoreUtil.getFileSize(
					context.getCompanyId(), CompanyConstants.SYSTEM,
					SurveyConstants.SURVEY_FOLDER_NAME + StringPool.SLASH
							+ mainId + StringPool.SLASH + fileId);

			SurveyFile surveyFile = SurveyFileLocalServiceUtil
					.getSurveyFile(fileId);

			String fileName = surveyFile.getFileName();

			String contentType = MimeTypesUtil.getContentType(fileName);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, fileName,
					inputStream, contentLength, contentType);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void createResultExcel(ResourceRequest request,
			ResourceResponse response) throws IOException, PortalException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		long mainId = ParamUtil.getLong(request, "mainId");

		int completedWriterCounts = SurveyWriterLocalServiceUtil.countByM_P_C(
				mainId, false, true);

		// 判斷是否有結果檔
		if (completedWriterCounts == 0) {
			jsonObject.put("hasResult", false);
		} else {

			SurveyMain s_main = SurveyMainLocalServiceUtil
					.fetchSurveyMain(mainId);
			List<SurveyPage> s_pages = SurveyPageLocalServiceUtil
					.findBySurveyMainId(mainId);
			List<SurveyWriter> s_writers = SurveyWriterLocalServiceUtil
					.findByM_P_C(mainId, false, true);
			// 例:XXX問卷_結果.xls
			String fileName = s_main.getTitle()
					+ StringPool.UNDERLINE
					+ LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
							"results") + ".xls";

			response.setContentType("application/vnd.ms-excel");
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + fileName);

			Workbook wb = new HSSFWorkbook();

			Sheet sheet = wb.createSheet(s_main.getTitle());

			CellStyle titleStyle = wb.createCellStyle();
			Font titleFont = wb.createFont();
			titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titleStyle.setFont(titleFont);

			// 問卷標題行
			Row titleRow = sheet.createRow(0);

			Cell titleHeaderCell = titleRow.createCell(0);
			titleHeaderCell.setCellValue(LanguageUtil.get(portletConfig,
					themeDisplay.getLocale(), "survey-title")
					+ StringPool.COLON);
			titleHeaderCell.setCellStyle(titleStyle);

			Cell titleCell = titleRow.createCell(1);
			titleCell.setCellValue(s_main.getTitle());
			titleCell.setCellStyle(titleStyle);

			// 問題標題行
			Row questionHeaderRow = sheet.createRow(2);
			int questionHeaderCount = 0;

			Cell completionTimeHeaderCell = questionHeaderRow
					.createCell(questionHeaderCount);
			completionTimeHeaderCell.setCellValue(LanguageUtil.get(
					portletConfig, themeDisplay.getLocale(), "completion-time")
					+ StringPool.COLON);
			completionTimeHeaderCell.setCellStyle(titleStyle);
			questionHeaderCount++;

			// 顯示分數列
			if (s_main.getCalculateScore()) {
				Cell scoreHeaderCell = questionHeaderRow
						.createCell(questionHeaderCount);
				scoreHeaderCell.setCellValue(LanguageUtil.get(portletConfig,
						themeDisplay.getLocale(), "points") + StringPool.COLON);
				scoreHeaderCell.setCellStyle(titleStyle);
				questionHeaderCount++;
			}

			// 問題列；呈現方式：page No + question No + question (例：1-1. 第一題題目)
			for (SurveyPage s_page : s_pages) {

				List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
						.findBySurveyPageIdAndParentId(
								s_page.getSurveyPageId(), 0);

				for (SurveyQuestion s_question : s_questions) {

					if (s_question
							.getType()
							.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)
							|| s_question
									.getType()
									.equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)) {

						List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil
								.findByParentId(s_question
										.getSurveyQuestionId());

						for (SurveyQuestion sub_question : sub_questions) {

							Cell subQuestionCell = questionHeaderRow
									.createCell(questionHeaderCount);
							subQuestionCell.setCellValue(s_page.getNo()
									+ StringPool.DASH + s_question.getNo()
									+ StringPool.PERIOD + StringPool.SPACE
									+ s_question.getQuestion()
									+ StringPool.UNDERLINE
									+ sub_question.getQuestion());
							subQuestionCell.setCellStyle(titleStyle);
							questionHeaderCount++;
						}

					} else {

						Cell questionCell = questionHeaderRow
								.createCell(questionHeaderCount);
						questionCell.setCellValue(s_page.getNo()
								+ StringPool.DASH + s_question.getNo()
								+ StringPool.PERIOD + StringPool.SPACE
								+ s_question.getQuestion());
						questionCell.setCellStyle(titleStyle);
						questionHeaderCount++;
					}
				}
			}

			// 結果行
			int resultRowCount = 3;

			for (SurveyWriter s_writer : s_writers) {

				Row resultRow = sheet.createRow(resultRowCount);
				int columnCount = 0;

				Cell completionTimeCell = resultRow.createCell(columnCount);
				completionTimeCell.setCellValue(_sdf.format(s_writer
						.getCompletionTime()));
				columnCount++;

				if (s_main.getCalculateScore()) {
					Cell scoreCell = resultRow.createCell(columnCount);
					scoreCell.setCellValue(SurveyResultUtils
							.calculateScoreByWriterId(s_writer
									.getSurveyWriterId()));
					columnCount++;
				}

				// 問題結果列
				for (SurveyPage s_page : s_pages) {

					List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
							.findBySurveyPageIdAndParentId(
									s_page.getSurveyPageId(), 0);

					for (SurveyQuestion s_question : s_questions) {

						Cell resultCell = resultRow.createCell(columnCount);
						String resultCellValue = "";
						Map<String, String> result = SurveyResultLocalServiceUtil
								.getResultByQ_W(
										s_question.getSurveyQuestionId(),
										s_writer.getSurveyWriterId());

						if (s_question.getType().equals(
								SurveyConstants.QUESTION_TYPE_TEXT)
								|| s_question.getType().equals(
										SurveyConstants.QUESTION_TYPE_DATE)
								|| s_question.getType().equals(
										SurveyConstants.QUESTION_TYPE_STAR)) {

							resultCellValue = result.get("answer");

						} else if (s_question.getType().equals(
								SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE)
								|| s_question.getType().equals(
										SurveyConstants.QUESTION_TYPE_CHECKBOX)) {

							String[] optionIds = StringUtil.split(
									result.get("optionIds"), StringPool.COMMA);

							if (optionIds.length != 0) {

								for (int i = 0; i < optionIds.length; i++) {

									// "其他選項"
									if (optionIds[i].equals("-1")
											&& s_question.getHasOther()) {

										resultCellValue += LanguageUtil.get(
												portletConfig,
												themeDisplay.getLocale(),
												"other-option-text")
												+ result.get("answer");

									} else if (SurveyOptionLocalServiceUtil
											.isExisted(Long
													.parseLong(optionIds[i]))) {

										resultCellValue += SurveyOptionLocalServiceUtil
												.fetchSurveyOption(
														Long.parseLong(optionIds[i]))
												.getOption();
									}
									// 每個選項間空3格
									resultCellValue += "   ";
								}
							}
						} else if (s_question
								.getType()
								.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)) {

							List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil
									.findByParentId(s_question
											.getSurveyQuestionId());

							for (SurveyQuestion sub_question : sub_questions) {

								Cell subResultCell = resultRow
										.createCell(columnCount);
								Map<String, String> subResult = SurveyResultLocalServiceUtil
										.getResultByQ_W(sub_question
												.getSurveyQuestionId(),
												s_writer.getSurveyWriterId());

								String subResultCellValue = "";
								String optionId = subResult.get("optionIds");

								if (!optionId.equals("")
										&& SurveyOptionLocalServiceUtil
												.isExisted(Long
														.parseLong(optionId)))
									subResultCellValue = SurveyOptionLocalServiceUtil
											.fetchSurveyOption(
													Long.parseLong(optionId))
											.getOption();

								subResultCell.setCellValue(subResultCellValue);
								columnCount++;
							}
							continue;
						} else if (s_question.getType().equals(
								SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)) {

							List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil
									.findByParentId(s_question
											.getSurveyQuestionId());

							for (SurveyQuestion sub_question : sub_questions) {

								Cell subResultCell = resultRow
										.createCell(columnCount);
								Map<String, String> subResult = SurveyResultLocalServiceUtil
										.getResultByQ_W(sub_question
												.getSurveyQuestionId(),
												s_writer.getSurveyWriterId());

								String subResultCellValue = "";
								String[] optionIds = StringUtil.split(
										subResult.get("optionIds"),
										StringPool.COMMA);

								if (optionIds.length != 0) {

									for (int i = 0; i < optionIds.length; i++) {

										if (SurveyOptionLocalServiceUtil
												.isExisted(Long
														.parseLong(optionIds[i]))) {

											subResultCellValue += (SurveyOptionLocalServiceUtil
													.fetchSurveyOption(
															Long.parseLong(optionIds[i]))
													.getOption() + "   ");
										}
									}
									subResultCell
											.setCellValue(subResultCellValue);
									columnCount++;
								}
							}
							continue;
						}
						resultCell.setCellValue(resultCellValue);
						columnCount++;
					}
				}
				resultRowCount++;
			}

			// 統計行
			Row statisticsRow = sheet.createRow(resultRowCount + 2);

			// 結果檔數列
			Cell totalCell = statisticsRow.createCell(0);
			totalCell.setCellValue(LanguageUtil.get(portletConfig,
					themeDisplay.getLocale(), "total")
					+ StringPool.COLON + completedWriterCounts);

			// 平均分數列
			if (s_main.getCalculateScore()) {
				Cell averageScoreCell = statisticsRow.createCell(1);
				averageScoreCell.setCellValue(LanguageUtil.get(portletConfig,
						themeDisplay.getLocale(), "average-score")
						+ StringPool.COLON
						+ SurveyResultUtils.calculateAverageScore(mainId));
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wb.write(baos);
			DLStoreUtil.addFile(themeDisplay.getCompanyId(),
					CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
							+ StringPool.SLASH + mainId + StringPool.SLASH
							+ fileName, false, baos.toByteArray());

			jsonObject.put("hasResult", true);
		}
		writeJSON(request, response, jsonObject);
	}

	private void createResponseExcel(ResourceRequest request,
			ResourceResponse response) throws PortalException, SystemException,
			IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		long mainId = ParamUtil.getLong(request, "mainId");

		int responseCounts = SurveyResponseLocalServiceUtil
				.countBySurveyMainId(mainId);

		// 判斷是否有結果檔
		if (responseCounts == 0) {
			jsonObject.put("hasResult", false);
		} else {

			SurveyMain s_main = SurveyMainLocalServiceUtil
					.fetchSurveyMain(mainId);
			List<SurveyResponse> s_responses = SurveyResponseLocalServiceUtil
					.findBySurveyMainId(mainId);
			// 例:XXX問卷_意見回饋.xls
			String fileName = s_main.getTitle()
					+ StringPool.UNDERLINE
					+ LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
							"survey-feedback") + ".xls";

			response.setContentType("application/vnd.ms-excel");
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=" + fileName);

			Workbook wb = new HSSFWorkbook();

			Sheet sheet = wb.createSheet(s_main.getTitle());

			CellStyle titleStyle = wb.createCellStyle();
			Font titleFont = wb.createFont();
			titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
			titleStyle.setFont(titleFont);

			// 問卷標題行
			Row titleRow = sheet.createRow(0);

			Cell titleHeaderCell = titleRow.createCell(0);
			titleHeaderCell.setCellValue(LanguageUtil.get(portletConfig,
					themeDisplay.getLocale(), "survey-title")
					+ StringPool.COLON);
			titleHeaderCell.setCellStyle(titleStyle);

			Cell titleCell = titleRow.createCell(1);
			titleCell.setCellValue(s_main.getTitle());
			titleCell.setCellStyle(titleStyle);

			// 回覆標題行
			Row headerRow = sheet.createRow(2);

			Cell createDateHeaderCell = headerRow.createCell(0);
			createDateHeaderCell.setCellValue(LanguageUtil.get(portletConfig,
					themeDisplay.getLocale(), "create-time"));
			createDateHeaderCell.setCellStyle(titleStyle);

			Cell responseHeaderCell = headerRow.createCell(1);
			responseHeaderCell.setCellValue(LanguageUtil.get(portletConfig,
					themeDisplay.getLocale(), "survey-feedback"));
			responseHeaderCell.setCellStyle(titleStyle);

			int responseRowCount = 3;
			for (SurveyResponse s_response : s_responses) {

				Row responseRow = sheet.createRow(responseRowCount);

				Cell createDateCell = responseRow.createCell(0);
				createDateCell.setCellValue(_sdf.format(s_response
						.getCreateDate()));

				Cell responseCell = responseRow.createCell(1);
				responseCell.setCellValue(s_response.getResponse());

				responseRowCount++;
			}

			Row statisticsRow = sheet.createRow(responseRowCount + 2);

			// 回覆數列
			Cell totalCell = statisticsRow.createCell(0);
			totalCell.setCellValue(LanguageUtil.get(portletConfig,
					themeDisplay.getLocale(), "total")
					+ StringPool.COLON + responseCounts);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wb.write(baos);
			DLStoreUtil.addFile(themeDisplay.getCompanyId(),
					CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
							+ StringPool.SLASH + mainId + StringPool.SLASH
							+ fileName, false, baos.toByteArray());

			jsonObject.put("hasResult", true);
		}
		writeJSON(request, response, jsonObject);
	}

	private void downloadExcel(ResourceRequest request,
			ResourceResponse response) throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		HttpServletRequest httpRequest = PortalUtil
				.getHttpServletRequest(request);

		HttpServletResponse httpResponse = PortalUtil
				.getHttpServletResponse(response);

		long mainId = ParamUtil.getLong(request, "mainId");
		String type = ParamUtil.getString(request, "type");

		SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);

		String fileName = s_main.getTitle();
		if (type.equals("result"))
			fileName += (StringPool.UNDERLINE
					+ LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
							"results") + ".xls");
		else
			fileName += (StringPool.UNDERLINE
					+ LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
							"survey-feedback") + ".xls");

		InputStream inputStream = null;
		try {
			inputStream = DLStoreUtil.getFileAsStream(
					themeDisplay.getCompanyId(), CompanyConstants.SYSTEM,
					SurveyConstants.SURVEY_FOLDER_NAME + StringPool.SLASH
							+ mainId + StringPool.SLASH + fileName);

			long contentLength = DLStoreUtil.getFileSize(
					themeDisplay.getCompanyId(), CompanyConstants.SYSTEM,
					SurveyConstants.SURVEY_FOLDER_NAME + StringPool.SLASH
							+ mainId + StringPool.SLASH + fileName);

			String contentType = MimeTypesUtil.getContentType(fileName);

			ServletResponseUtil.sendFile(httpRequest, httpResponse, fileName,
					inputStream, contentLength, contentType);

			DLStoreUtil.deleteDirectory(themeDisplay.getCompanyId(),
					CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
							+ StringPool.SLASH + mainId + StringPool.SLASH
							+ fileName);

			// 以防刪除結果檔時，如果結果檔為最後一個檔案會一起刪掉母資料夾，如刪除再建回來
			if (!DLStoreUtil.hasDirectory(themeDisplay.getCompanyId(),
					CompanyConstants.SYSTEM, SurveyConstants.SURVEY_FOLDER_NAME
							+ StringPool.SLASH + mainId)) {
				DLStoreUtil.addDirectory(themeDisplay.getCompanyId(),
						CompanyConstants.SYSTEM,
						SurveyConstants.SURVEY_FOLDER_NAME + StringPool.SLASH
								+ mainId);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void updateFile(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, IOException,
			WindowStateException {

		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);

		ServiceContext context = ServiceContextFactory.getInstance(
				SurveyFile.class.getName(), request);

		long createDate = System.currentTimeMillis();

		long mainId = ParamUtil.getLong(request, "mainId");
		long selectedFileId = ParamUtil.getLong(request, "selectedFileId");
		File file = uploadRequest.getFile("file");
		String fileName = uploadRequest.getFileName("file");

		long surveyFileId = CounterLocalServiceUtil.increment(SurveyFile.class
				.getName());

		SurveyFile surveyFile = SurveyFileLocalServiceUtil
				.createSurveyFile(surveyFileId);
		SurveyFileLocalServiceUtil.updateSurveyFile(surveyFile, mainId,
				fileName, context.getUserId(), createDate);

		DLStoreUtil.addFile(context.getCompanyId(), CompanyConstants.SYSTEM,
				SurveyConstants.SURVEY_FOLDER_NAME + StringPool.SLASH + mainId
						+ StringPool.SLASH + surveyFileId, false, file);

		SessionMessages.add(request, PortalUtil.getPortletId(request)
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				(String) request.getAttribute(WebKeys.PORTLET_ID),
				context.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("jspPage", "/html/admin/edit/album.jsp");
		portletURL.setParameter("mainId", String.valueOf(mainId));
		portletURL.setParameter("selectedFileId",
				String.valueOf(selectedFileId));

		response.sendRedirect(portletURL.toString());
	}

	public void removeFile(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, WindowStateException,
			IOException {

		ServiceContext context = ServiceContextFactory.getInstance(
				SurveyFile.class.getName(), request);

		long mainId = ParamUtil.getLong(request, "mainId");
		long selectedFileId = ParamUtil.getLong(request, "selectedFileId");
		long fileId = ParamUtil.getLong(request, "fileId");

		SurveyFileLocalServiceUtil.deleteSurveyFile(fileId);

		DLStoreUtil.deleteFile(context.getCompanyId(), CompanyConstants.SYSTEM,
				SurveyConstants.SURVEY_FOLDER_NAME + StringPool.SLASH + mainId
						+ StringPool.SLASH + fileId);

		SessionMessages.add(request, PortalUtil.getPortletId(request)
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				(String) request.getAttribute(WebKeys.PORTLET_ID),
				context.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("jspPage", "/html/admin/edit/album.jsp");
		portletURL.setParameter("mainId", String.valueOf(mainId));
		portletURL.setParameter("selectedFileId",
				String.valueOf(selectedFileId));
		portletURL.setParameter("removedFileId", String.valueOf(fileId));

		response.sendRedirect(portletURL.toString());
	}

	public void authenticateWriter(ActionRequest request,
			ActionResponse response) throws WindowStateException,
			PortalException, SystemException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		String login = ParamUtil.getString(request, "login");

		String password = ParamUtil.getString(request, "password");

		String color = ParamUtil.getString(request, "color");

		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				(String) request.getAttribute(WebKeys.PORTLET_ID),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("jspPage", "/html/write/auth.jsp");
		portletURL.setParameter("color", color);

		HttpServletRequest httpServletrequest = PortalUtil
				.getHttpServletRequest(request);

		Company company = PortalUtil.getCompany(httpServletrequest);

		boolean authResult = SurveyUtils.authenticateWriter(httpServletrequest,
				login, password, company.getAuthType());

		if (authResult) {
			SessionMessages.add(request, PortalUtil.getPortletId(request)
					+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			portletURL.setParameter("authResult", String.valueOf(authResult));
		} else {
			SessionMessages.add(request, PortalUtil.getPortletId(request)
					+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(request, "authenticateFailMessage");
			portletURL.setParameter("login", login);
			portletURL.setParameter("password", password);
		}
		response.sendRedirect(portletURL.toString());
	}

	public void initializeWriterInfo(ActionRequest request,
			ActionResponse response) throws WindowStateException, IOException,
			SystemException, NoSuchSurveyPageException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		long mainId = ParamUtil.getLong(request, "mainId");
		long writerId = ParamUtil.getLong(request, "writerId");
		boolean isPreview = ParamUtil.getBoolean(request, "isPreview");

		long firstPageId = SurveyPageLocalServiceUtil.findBySurveyMainIdAndNo(
				mainId, 1).getSurveyPageId();
		long createDate = System.currentTimeMillis();

		SurveyWriter s_writer = SurveyWriterLocalServiceUtil
				.fetchSurveyWriter(writerId);

		if (s_writer == null) {

			writerId = CounterLocalServiceUtil.increment(SurveyWriter.class
					.getName());
			s_writer = SurveyWriterLocalServiceUtil
					.createSurveyWriter(writerId);

			SurveyWriterLocalServiceUtil.updateSurveyWriter(s_writer, mainId,
					isPreview, false, 0, themeDisplay.getUserId(), createDate);
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				(String) request.getAttribute(WebKeys.PORTLET_ID),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("jspPage", "/html/write/question.jsp");
		portletURL.setParameter("mainId", String.valueOf(mainId));
		portletURL.setParameter("pageId", String.valueOf(firstPageId));
		portletURL.setParameter("writerId", String.valueOf(writerId));

		SessionMessages.add(request, PortalUtil.getPortletId(request)
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		response.sendRedirect(portletURL.toString());
	}

	public void updateSurveyResult(ActionRequest request,
			ActionResponse response) throws WindowStateException, IOException,
			SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		long userId = themeDisplay.getUserId();
		long createDate = System.currentTimeMillis();
		long nextPageId = 0;

		long writerId = ParamUtil.getLong(request, "writerId");
		long mainId = ParamUtil.getLong(request, "mainId");
		long pageId = ParamUtil.getLong(request, "pageId");

		PortletURL portletURL = null;

		// 檢查問卷和頁面是否存在
		if (!SurveyMainLocalServiceUtil.isExisted(mainId)
				|| !SurveyPageLocalServiceUtil.isExisted(pageId)) {

			portletURL = SurveyPageDirectUtils.getErrorPageURL(request,
					LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
							"something-went-wrong-please-try-it-again"),
					writerId);
			response.sendRedirect(portletURL.toString());
			return;
		}

		nextPageId = SurveyPageLocalServiceUtil.getPageDirectIdByPageId(pageId);

		SurveyResultLocalServiceUtil.removeByP_W(pageId, writerId);

		long[] questionIds = StringUtil.split(
				ParamUtil.getString(request, "questionIds"), 0l);

		for (long questionId : questionIds) {

			if (!SurveyQuestionLocalServiceUtil.isExisted(questionId))
				continue;

			String answer = "";
			String type = SurveyQuestionLocalServiceUtil
					.getTypeBySurveyQuestionId(questionId);

			if (type.equals(SurveyConstants.QUESTION_TYPE_TEXT)
					|| type.equals(SurveyConstants.QUESTION_TYPE_DATE)
					|| type.equals(SurveyConstants.QUESTION_TYPE_STAR)) {

				answer = ParamUtil.getString(request, questionId + "_answer");

				if (answer.equals(""))
					continue;

				SurveyResult s_result = SurveyResultLocalServiceUtil
						.createSurveyResult(CounterLocalServiceUtil
								.increment(SurveyResult.class.getName()));
				SurveyResultLocalServiceUtil.updateSurveyResult(s_result,
						mainId, pageId, questionId, 0, writerId, answer,
						userId, createDate);
			} else {

				long[] optionIds = StringUtil
						.split(ParamUtil.getString(request, questionId
								+ "_optionIds"), 0l);

				for (long optionId : optionIds) {

					answer = "";

					if (optionId == -1) {

						answer = ParamUtil.getString(request, questionId
								+ "_answer");
					} else {

						if (!SurveyOptionLocalServiceUtil.isExisted(optionId))
							continue;
						else {
							long optionDirectId = SurveyOptionLocalServiceUtil
									.getPageDirectIdByOptionId(optionId);
							nextPageId = (optionDirectId != 0 ? optionDirectId
									: nextPageId);
						}
					}
					SurveyResult s_result = SurveyResultLocalServiceUtil
							.createSurveyResult(CounterLocalServiceUtil
									.increment(SurveyResult.class.getName()));

					SurveyResultLocalServiceUtil.updateSurveyResult(s_result,
							mainId, pageId, questionId, optionId, writerId,
							answer, userId, createDate);
				}
			}
		}

		// 如跳題則需要刪除兩頁之間的結果檔
		if (nextPageId != 0)
			SurveyResultLocalServiceUtil.removeByM_C_N_W(mainId, pageId,
					nextPageId, writerId);

		portletURL = SurveyPageDirectUtils.getNextPageURL(request, pageId,
				nextPageId, mainId, writerId);

		SessionMessages.add(request, PortalUtil.getPortletId(request)
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		response.sendRedirect(portletURL.toString());
	}

	public void redirectPrePage(ActionRequest request, ActionResponse response)
			throws WindowStateException, IOException, SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig = (PortletConfig) request
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		long writerId = ParamUtil.getLong(request, "writerId");
		long pageId = ParamUtil.getLong(request, "pageId");
		long mainId = ParamUtil.getLong(request, "mainId");

		PortletURL portletURL = null;

		if (SurveyMainLocalServiceUtil.isExisted(mainId)) {
			portletURL = SurveyPageDirectUtils.getPrePageURL(request, pageId,
					mainId, writerId);
		} else {
			portletURL = SurveyPageDirectUtils.getErrorPageURL(request,
					LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
							"something-went-wrong-please-try-it-again"),
					writerId);
		}

		SessionMessages.add(request, PortalUtil.getPortletId(request)
				+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

		response.sendRedirect(portletURL.toString());
	}

	public void updateWriterResponse(ActionRequest request,
			ActionResponse response) throws SystemException, PortalException,
			WindowStateException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext context = ServiceContextFactory.getInstance(
				SurveyResponse.class.getName(), request);

		long writerId = ParamUtil.getLong(request, "writerId");
		long mainId = ParamUtil.getLong(request, "mainId");
		String color = ParamUtil.getString(request, "color");
		String writerResponse = ParamUtil.getString(request, "response");

		SurveyResponse s_response = SurveyResponseLocalServiceUtil
				.createSurveyResponse(CounterLocalServiceUtil
						.increment(SurveyResponse.class.getName()));

		SurveyResponseLocalServiceUtil.updateSurveyResponse(s_response, mainId,
				writerId, writerResponse, themeDisplay.getUserId(),
				System.currentTimeMillis());

		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				(String) request.getAttribute(WebKeys.PORTLET_ID),
				context.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		portletURL.setParameter("jspPage", "/html/write/response.jsp");
		portletURL.setParameter("mainId", String.valueOf(mainId));
		portletURL.setParameter("writerId", String.valueOf(writerId));
		portletURL.setParameter("color", color);

		response.sendRedirect(portletURL.toString());
	}
}
