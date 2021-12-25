package com.lc.survey.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lc.survey.model.SurveyOption;
import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.model.SurveyResult;
import com.lc.survey.model.SurveyWriter;
import com.lc.survey.service.SurveyOptionLocalServiceUtil;
import com.lc.survey.service.SurveyQuestionLocalServiceUtil;
import com.lc.survey.service.SurveyResultLocalServiceUtil;
import com.lc.survey.service.SurveyWriterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;

public class SurveyResultUtils {

	public static Map<String, Object> getResultInfoByQ_W(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("isCorrect",
				determineResultIsCorrect(surveyQuestionId, surveyWriterId));
		map.put("correctOptionIds",
				getCorrectOptionIdsByQuestionId(surveyQuestionId));

		return map;
	}

	public static String calculateTotalScore(long surveyMainId)
			throws SystemException {

		float score = 0;
		List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
				.findBySurveyMainId(surveyMainId);

		for (SurveyQuestion s_question : s_questions) {

			score += Float.parseFloat(s_question.getPoints());
		}

		return SurveyUtils.transferToScoreFormat(score);
	}

	public static String calculateAverageScore(long surveyMainId)
			throws SystemException {

		float totalScore = 0;
		List<SurveyWriter> s_writers = SurveyWriterLocalServiceUtil
				.findByM_P_C(surveyMainId, false, true);

		for (SurveyWriter s_writer : s_writers) {
			totalScore += Float.parseFloat(calculateScoreByWriterId(s_writer
					.getSurveyWriterId()));
		}

		return SurveyUtils.transferToScoreFormat(totalScore / s_writers.size());
	}

	public static String calculateScoreByWriterId(long surveyWriterId)
			throws SystemException {

		float score = 0;

		SurveyWriter s_writer = SurveyWriterLocalServiceUtil
				.fetchSurveyWriter(surveyWriterId);
		List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
				.findBySurveyMainId(s_writer.getSurveyMainId());

		for (SurveyQuestion s_question : s_questions) {
			if (determineResultIsCorrect(s_question.getSurveyQuestionId(),
					surveyWriterId))
				score += Float.parseFloat(s_question.getPoints());
		}

		return SurveyUtils.transferToScoreFormat(score);
	}

	private static boolean determineResultIsCorrect(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		boolean isCorrect = false;
		String correctOptionIds = getCorrectOptionIdsByQuestionId(surveyQuestionId);

		String questionType = SurveyQuestionLocalServiceUtil
				.getTypeBySurveyQuestionId(surveyQuestionId);
		List<SurveyResult> s_results = SurveyResultLocalServiceUtil.findByQ_W(
				surveyQuestionId, surveyWriterId);

		if (!correctOptionIds.equals("")) {

			// 單選題、下拉式選單
			if (questionType
					.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE)
					|| questionType
							.equals(SurveyConstants.QUESTION_TYPE_DROPDOWN_LIST)) {
				for (SurveyResult s_result : s_results) {
					// 有符合其中一個就算對
					if (correctOptionIds.contains(String.valueOf(s_result
							.getSurveyOptionId()))) {
						isCorrect = true;
						break;
					}
				}
			}
			// 多選題
			else if (questionType
					.equals(SurveyConstants.QUESTION_TYPE_CHECKBOX)) {

				isCorrect = true;

				// 假設都沒有選也算錯
				if (s_results == null || s_results.size() == 0)
					isCorrect = false;

				for (SurveyResult s_result : s_results) {
					// 其中一個不符合就算錯
					if (!correctOptionIds.contains(String.valueOf(s_result
							.getSurveyOptionId()))) {
						isCorrect = false;
						break;
					}
				}
			}
		}

		return isCorrect;
	}

	private static String getCorrectOptionIdsByQuestionId(long surveyQuestionId)
			throws SystemException {

		String correctOptionIds = "";
		List<SurveyOption> correctOptions = SurveyOptionLocalServiceUtil
				.findByQ_I(surveyQuestionId, true);

		for (int i = 0; i < correctOptions.size(); i++) {

			if (i != 0) {
				correctOptionIds += StringPool.COMMA;
			}
			correctOptionIds += String.valueOf(correctOptions.get(i)
					.getSurveyOptionId());
		}

		return correctOptionIds;
	}
}
