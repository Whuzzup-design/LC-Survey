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

import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.service.base.SurveyQuestionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;

/**
 * The implementation of the survey question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyQuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyQuestionLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyQuestionLocalServiceUtil
 */
public class SurveyQuestionLocalServiceImpl extends
		SurveyQuestionLocalServiceBaseImpl {

	public void updateSurveyQuestion(SurveyQuestion surveyQuestion,
			long surveyMainId, long surveyPageId, long parentId, int no,
			String question, String type, boolean isRequired, boolean hasOther,
			boolean optionDirect, String points, int starsCount,
			long uploadFileId, long userId, long modifiedDate, String action)
			throws SystemException {

		surveyQuestion.setSurveyMainId(surveyMainId);
		surveyQuestion.setSurveyPageId(surveyPageId);
		surveyQuestion.setParentId(parentId);
		surveyQuestion.setNo(no);
		surveyQuestion.setQuestion(question);
		surveyQuestion.setType(type);
		surveyQuestion.setIsRequired(isRequired);
		surveyQuestion.setHasOther(hasOther);
		surveyQuestion.setOptionDirect(optionDirect);
		surveyQuestion.setPoints(points);
		surveyQuestion.setStarsCount(starsCount);
		surveyQuestion.setUploadFileId(uploadFileId);

		if (action.equals(Constants.ADD)) {
			surveyQuestion.setCreatorId(userId);
			surveyQuestion.setCreateDate(modifiedDate);
		}
		surveyQuestion.setModifiedDate(modifiedDate);
		surveyQuestion.setModifierId(userId);

		surveyQuestionPersistence.update(surveyQuestion);
	}

	public boolean isExisted(long surveyQuestionId) throws SystemException {

		SurveyQuestion s_question = surveyQuestionPersistence
				.fetchByPrimaryKey(surveyQuestionId);

		return s_question == null ? false : true;
	}

	public int countByType(String type) throws SystemException {

		return surveyQuestionPersistence.countByType(type);
	}

	public List<SurveyQuestion> findByParentId(long parentId)
			throws SystemException {

		return surveyQuestionPersistence.findByParentId(parentId);
	}

	public List<SurveyQuestion> findBySurveyPageIdAndParentId(
			long surveyPageId, long parentId) throws SystemException {

		return surveyQuestionPersistence.findBySurveyPageIdAndParentId(
				surveyPageId, parentId);
	}

	public List<SurveyQuestion> findBySurveyPageId(long surveyPageId)
			throws SystemException {

		return surveyQuestionPersistence.findBySurveyPageId(surveyPageId);
	}

	public List<SurveyQuestion> findBySurveyMainId(long surveyMainId)
			throws SystemException {

		return surveyQuestionPersistence.findBySurveyMainId(surveyMainId);
	}

	public List<SurveyQuestion> findSubQuestionBySurveyMainId(long surveyMainId)
			throws SystemException {

		return surveyQuestionPersistence
				.findBySurveyMainIdAndParentIdNotZero(surveyMainId);
	}

	public List<SurveyQuestion> findByType(String type) throws SystemException {

		return surveyQuestionPersistence.findByType(type);
	}

	public String getTypeBySurveyQuestionId(long surveyQuestionId)
			throws SystemException {

		return surveyQuestionPersistence.fetchByPrimaryKey(surveyQuestionId)
				.getType();
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException {

		surveyQuestionPersistence.removeBySurveyMainId(surveyMainId);
	}
}