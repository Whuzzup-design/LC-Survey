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

import java.util.List;

import com.lc.survey.NoSuchSurveyPageException;
import com.lc.survey.model.SurveyPage;
import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.service.base.SurveyPageLocalServiceBaseImpl;
import com.lc.survey.utils.SurveyConstants;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;

/**
 * The implementation of the survey page local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyPageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyPageLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyPageLocalServiceUtil
 */
public class SurveyPageLocalServiceImpl extends SurveyPageLocalServiceBaseImpl {

	public void updateSurveyPage(SurveyPage surveyPage, long surveyMainId,
			int no, String title, long pageDirectId, long userId,
			long modifiedDate, String action) throws SystemException {

		surveyPage.setSurveyMainId(surveyMainId);
		surveyPage.setNo(no);
		surveyPage.setTitle(title);
		surveyPage.setPageDirectId(pageDirectId);

		if (action.equals(Constants.ADD)) {
			surveyPage.setCreatorId(userId);
			surveyPage.setCreateDate(modifiedDate);
		}
		surveyPage.setModifiedDate(modifiedDate);
		surveyPage.setModifierId(userId);

		surveyPagePersistence.update(surveyPage);
	}

	public boolean isExisted(long surveyPageId) throws SystemException {

		SurveyPage s_page = surveyPagePersistence
				.fetchByPrimaryKey(surveyPageId);

		return s_page == null ? false : true;
	}

	public List<SurveyPage> findBySurveyMainId(long surveyMainId)
			throws SystemException {
		return surveyPagePersistence.findBySurveyMainId(surveyMainId);
	}

	public int countBySurveyMainId(long surveyMainId) throws SystemException {
		return surveyPagePersistence.countBySurveyMainId(surveyMainId);
	}

	public SurveyPage findBySurveyMainIdAndNo(long surveyMainId, int no)
			throws NoSuchSurveyPageException, SystemException {
		return surveyPagePersistence.findBySurveyMainIdAndNo(surveyMainId, no);
	}

	public int getPageNoByPageId(long surveyPageId) throws SystemException {

		int pageNo = 0;

		if (surveyPageId == -1 || surveyPageId == 0) {
			if (surveyPageId == -1)
				pageNo = -1;
		} else {
			pageNo = surveyPagePersistence.fetchByPrimaryKey(surveyPageId)
					.getNo();
		}
		return pageNo;
	}

	public int getChoiceQuestionCountsByPageId(long surveyPageId)
			throws SystemException {

		int count = 0;
		List<SurveyQuestion> s_questions = surveyQuestionPersistence
				.findBySurveyPageIdAndParentId(surveyPageId, 0);

		for (SurveyQuestion s_question : s_questions) {

			if (s_question.getType().equals(
					SurveyConstants.QUESTION_TYPE_CHECKBOX)
					|| s_question.getType().equals(
							SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE)
					|| s_question
							.getType()
							.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)
					|| s_question.getType().equals(
							SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE))
				count++;
		}

		return count;
	}

	public long getPageDirectIdByPageId(long surveyPageId)
			throws SystemException {

		return surveyPagePersistence.fetchByPrimaryKey(surveyPageId)
				.getPageDirectId();
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException {

		surveyPagePersistence.removeBySurveyMainId(surveyMainId);
	}
}