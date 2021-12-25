/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lc.survey.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lc.survey.NoSuchSurveyPageException;
import com.lc.survey.model.SurveyPage;
import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.model.SurveyResult;
import com.lc.survey.service.base.SurveyResultLocalServiceBaseImpl;
import com.lc.survey.utils.SurveyConstants;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the survey result local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyResultLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyResultLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyResultLocalServiceUtil
 */
public class SurveyResultLocalServiceImpl extends
		SurveyResultLocalServiceBaseImpl {

	public void updateSurveyResult(SurveyResult surveyResult,
			long surveyMainId, long surveyPageId, long surveyQuestionId,
			long surveyOptionId, long surveyWriterId, String ans,
			long creatorId, long createDate) throws SystemException {

		surveyResult.setSurveyMainId(surveyMainId);
		surveyResult.setSurveyPageId(surveyPageId);
		surveyResult.setSurveyQuestionId(surveyQuestionId);
		surveyResult.setSurveyOptionId(surveyOptionId);
		surveyResult.setSurveyWriterId(surveyWriterId);
		surveyResult.setAns(ans);

		surveyResult.setCreatorId(creatorId);
		surveyResult.setCreateDate(createDate);

		surveyResultPersistence.update(surveyResult);
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException {

		surveyResultPersistence.removeBySurveyMainId(surveyMainId);
	}

	public void removeBySurveyWriterId(long surveyWriterId)
			throws SystemException {

		surveyResultPersistence.removeBySurveyWriterId(surveyWriterId);
	}

	public void removeByP_W(long surveyPageId, long surveyWriterId)
			throws SystemException {

		surveyResultPersistence.removeByP_W(surveyPageId, surveyWriterId);
	}

	public void removeByM_C_N_W(long surveyMainId, long currentPageId,
			long nextPageId, long surveyWriterId) throws SystemException,
			NoSuchSurveyPageException {

		int currentPageNo = surveyPageLocalService
				.getPageNoByPageId(currentPageId);
		// 假設是跳轉到結束填寫，刪除當前頁以後的所有結果檔
		int nextPageNo = nextPageId == -1 ? (surveyPagePersistence
				.countBySurveyMainId(surveyMainId) + 1)
				: surveyPageLocalService.getPageNoByPageId(nextPageId);

		// 往回跳轉就不刪
		if (currentPageNo > nextPageNo)
			return;

		for (int i = currentPageNo + 1; i < nextPageNo; i++) {

			SurveyPage s_page = surveyPagePersistence.findBySurveyMainIdAndNo(
					surveyMainId, i);

			surveyResultPersistence.removeByP_W(s_page.getSurveyPageId(),
					surveyWriterId);
		}
	}

	public List<SurveyResult> findByQ_W(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		return surveyResultPersistence.findByQ_W(surveyQuestionId,
				surveyWriterId);
	}

	public SurveyResult findByO_W(long surveyOptionId, long surveyWriterId)
			throws SystemException {

		return surveyResultPersistence.fetchByO_W(surveyOptionId,
				surveyWriterId);
	}

	public int countByP_W(long surveyPageId, long surveyWriterId)
			throws SystemException {

		return surveyResultPersistence.countByP_W(surveyPageId, surveyWriterId);
	}

	public int countByQ_O(long surveyQuestionId, long surveyOptionId)
			throws SystemException {

		return surveyResultPersistence.countByQ_O(surveyQuestionId,
				surveyOptionId);
	}

	public Map<String, String> getResultByQ_W(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		Map<String, String> result = null;

		SurveyQuestion s_question = surveyQuestionPersistence
				.fetchByPrimaryKey(surveyQuestionId);

		if (s_question.getType().equals(SurveyConstants.QUESTION_TYPE_TEXT)
				|| s_question.getType().equals(
						SurveyConstants.QUESTION_TYPE_DATE)) {

			result = this
					.getTextAndDateResult(surveyQuestionId, surveyWriterId);

		} else if (s_question.getType().equals(
				SurveyConstants.QUESTION_TYPE_STAR)) {

			result = this.getStarResult(surveyQuestionId, surveyWriterId);

		} else if (s_question.getType().equals(
				SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE)
				|| s_question.getType().equals(
						SurveyConstants.QUESTION_TYPE_CHECKBOX)
				|| s_question.getType().equals(
						SurveyConstants.QUESTION_TYPE_DROPDOWN_LIST)
				|| s_question.getType().equals(
						SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)
				|| s_question.getType().equals(
						SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)) {

			result = this.getMultipleChoiceResult(surveyQuestionId,
					surveyWriterId);
		}

		return result;
	}

	private Map<String, String> getTextAndDateResult(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		Map<String, String> result = new HashMap<String, String>();
		String answer = "";

		List<SurveyResult> s_results = surveyResultPersistence.findByQ_W(
				surveyQuestionId, surveyWriterId);

		if (s_results.size() != 0)
			answer = s_results.get(0).getAns();

		result.put("answer", answer);

		return result;
	}

	private Map<String, String> getStarResult(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		Map<String, String> result = new HashMap<String, String>();
		SurveyQuestion s_question = surveyQuestionPersistence
				.fetchByPrimaryKey(surveyQuestionId);
		int answer = 0;

		List<SurveyResult> s_results = surveyResultPersistence.findByQ_W(
				surveyQuestionId, surveyWriterId);

		if (s_results.size() != 0)
			answer = Integer.parseInt(s_results.get(0).getAns());

		// avoid editor change starsCount
		if (s_question.getStarsCount() < answer)
			answer = s_question.getStarsCount();

		result.put("answer", String.valueOf(answer));

		return result;
	}

	private Map<String, String> getMultipleChoiceResult(long surveyQuestionId,
			long surveyWriterId) throws SystemException {

		Map<String, String> result = new HashMap<String, String>();
		List<SurveyResult> s_results = surveyResultPersistence.findByQ_W(
				surveyQuestionId, surveyWriterId);
		String optionIds = "";
		String answer = "";

		if (s_results.size() != 0) {
			for (int i = 0; i < s_results.size(); i++) {

				// check option is existed
				if (s_results.get(i).getSurveyOptionId() != -1
						&& !surveyOptionLocalService.isExisted(s_results.get(i)
								.getSurveyOptionId()))
					continue;

				if (!optionIds.equals(""))
					optionIds += ",";

				optionIds += String.valueOf(s_results.get(i)
						.getSurveyOptionId());

				// put "other" option answer
				if (s_results.get(i).getSurveyOptionId() == -1)
					answer = s_results.get(i).getAns();
			}
		}
		result.put("optionIds", optionIds);
		result.put("answer", answer);

		return result;
	}
}