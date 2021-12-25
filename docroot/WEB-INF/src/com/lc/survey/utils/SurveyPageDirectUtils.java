package com.lc.survey.utils;

import java.util.Date;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import com.lc.survey.model.SurveyWriteSequence;
import com.lc.survey.service.SurveyPageLocalServiceUtil;
import com.lc.survey.service.SurveyResultLocalServiceUtil;
import com.lc.survey.service.SurveyWriteSequenceLocalServiceUtil;
import com.lc.survey.service.SurveyWriterLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;

public class SurveyPageDirectUtils {

	private static PortletURL createURL(PortletRequest request)
			throws WindowStateException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				(String) request.getAttribute(WebKeys.PORTLET_ID),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(LiferayWindowState.POP_UP);

		return portletURL;
	}

	private static PortletURL getFinishPageURL(PortletRequest request,
			long mainId, long writerId) throws WindowStateException,
			SystemException {

		PortletURL portletURL = createURL(request);

		portletURL.setParameter("jspPage", "/html/write/finish.jsp");
		portletURL.setParameter("mainId", String.valueOf(mainId));
		portletURL.setParameter("writerId", String.valueOf(writerId));

		// update survey writer to completed
		SurveyWriterLocalServiceUtil.updateToCompleted(writerId);

		// remove survey write sequence record
		SurveyWriteSequenceLocalServiceUtil.removeBySurveyWriterId(writerId);

		return portletURL;
	}

	public static PortletURL getPrePageURL(PortletRequest request,
			long currentPageId, long mainId, long writerId)
			throws WindowStateException, SystemException {

		PortletURL portletURL = createURL(request);

		long pageId = currentPageId;
		boolean loopStatus = true;

		SurveyWriteSequence s_sequence = null;

		while (loopStatus) {

			s_sequence = SurveyWriteSequenceLocalServiceUtil.findByS_P(
					writerId, pageId);

			if (s_sequence != null) {
				pageId = s_sequence.getPrePageId();
				// 判斷前一頁是否還存在
				if (SurveyPageLocalServiceUtil.isExisted(s_sequence
						.getPrePageId())) {
					loopStatus = false;

					portletURL.setParameter("jspPage",
							"/html/write/question.jsp");
					portletURL.setParameter("pageId", String.valueOf(pageId));
				}
			}
			// 找不到record就回到前言頁
			else {
				portletURL.setParameter("jspPage",
						"/html/write/introduction.jsp");
				break;
			}
		}

		portletURL.setParameter("mainId", String.valueOf(mainId));
		portletURL.setParameter("writerId", String.valueOf(writerId));

		return portletURL;
	}

	public static PortletURL getNextPageURL(PortletRequest request,
			long currentPageId, long nextPageId, long mainId, long writerId)
			throws WindowStateException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		boolean needDirect = false;

		PortletURL portletURL = createURL(request);

		if (nextPageId == 0) {

			int lastPageNo = SurveyPageLocalServiceUtil
					.countBySurveyMainId(mainId);
			int currentPageNo = SurveyPageLocalServiceUtil
					.getPageNoByPageId(currentPageId);

			// 如目前為最後一頁跳轉至完成頁
			if (currentPageNo == lastPageNo) {

				portletURL = getFinishPageURL(request, mainId, writerId);

			} else {

				nextPageId = SurveyPageLocalServiceUtil
						.findBySurveyMainIdAndNo(mainId, currentPageNo + 1)
						.getSurveyPageId();

				portletURL.setParameter("jspPage", "/html/write/question.jsp");
				portletURL.setParameter("pageId", String.valueOf(nextPageId));
				portletURL.setParameter("mainId", String.valueOf(mainId));
				portletURL.setParameter("writerId", String.valueOf(writerId));
			}
		} else {
			// 導向結束頁
			if (nextPageId == -1) {

				portletURL = getFinishPageURL(request, mainId, writerId);

			} else {

				// 檢查跳轉的pageId是否存在，不存在回傳錯誤頁面的URL
				if (SurveyPageLocalServiceUtil.isExisted(nextPageId)) {

					needDirect = true;

					portletURL.setParameter("jspPage",
							"/html/write/question.jsp");
					portletURL.setParameter("pageId",
							String.valueOf(nextPageId));
					portletURL.setParameter("mainId", String.valueOf(mainId));
					portletURL.setParameter("writerId",
							String.valueOf(writerId));
				} else {

					nextPageId = 0;

					PortletConfig portletConfig = (PortletConfig) request
							.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

					portletURL = getErrorPageURL(request, LanguageUtil.get(
							portletConfig, themeDisplay.getLocale(),
							"something-went-wrong-please-try-it-again"),
							writerId);
				}
			}
		}

		if (nextPageId != 0 && nextPageId != -1) {

			SurveyWriteSequence s_sequence = SurveyWriteSequenceLocalServiceUtil
					.findByS_P(writerId, nextPageId);
			String action = Constants.EDIT;

			if (s_sequence == null) {

				action = Constants.ADD;

				s_sequence = SurveyWriteSequenceLocalServiceUtil
						.createSurveyWriteSequence(CounterLocalServiceUtil
								.increment(SurveyWriteSequence.class.getName()));
			}
			SurveyWriteSequenceLocalServiceUtil.updateSurveyWriteSequence(
					s_sequence, writerId, nextPageId, currentPageId,
					needDirect, themeDisplay.getUserId(), new Date().getTime(),
					action);
		}

		return portletURL;
	}

	public static PortletURL getErrorPageURL(PortletRequest request,
			String errorMessage, long writerId) throws WindowStateException,
			SystemException, PortalException {

		PortletURL portletURL = createURL(request);

		portletURL.setParameter("jspPage", "/html/write/error.jsp");
		portletURL.setParameter("color",
				SurveyConstants.WRITE_PAGE_DEFAULT_COLOR);
		portletURL.setParameter("errorMessage", errorMessage);

		// remove survey result
		SurveyResultLocalServiceUtil.removeBySurveyWriterId(writerId);

		// remove survey writer record
		SurveyWriterLocalServiceUtil.deleteSurveyWriter(writerId);

		// remove survey write sequence record
		SurveyWriteSequenceLocalServiceUtil.removeBySurveyWriterId(writerId);

		return portletURL;
	}
}
