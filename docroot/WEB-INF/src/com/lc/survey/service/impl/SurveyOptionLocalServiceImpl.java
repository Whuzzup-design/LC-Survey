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

import com.lc.survey.model.SurveyOption;
import com.lc.survey.service.base.SurveyOptionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;

/**
 * The implementation of the survey option local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyOptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyOptionLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyOptionLocalServiceUtil
 */
public class SurveyOptionLocalServiceImpl extends
		SurveyOptionLocalServiceBaseImpl {

	public void updateSurveyOption(SurveyOption surveyOption,
			long surveyMainId, long surveyPageId, long surveyQuestionId,
			int no, String option, boolean isAns, long pageDirectId,
			long uploadFileId, long userId, long modifiedDate, String action)
			throws SystemException {

		surveyOption.setSurveyMainId(surveyMainId);
		surveyOption.setSurveyPageId(surveyPageId);
		surveyOption.setSurveyQuestionId(surveyQuestionId);
		surveyOption.setNo(no);
		surveyOption.setOption(option);
		surveyOption.setIsAns(isAns);
		surveyOption.setPageDirectId(pageDirectId);
		surveyOption.setUploadFileId(uploadFileId);

		if (action.equals(Constants.ADD)) {
			surveyOption.setCreatorId(userId);
			surveyOption.setCreateDate(modifiedDate);
		}
		surveyOption.setModifiedDate(modifiedDate);
		surveyOption.setModifierId(userId);

		surveyOptionPersistence.update(surveyOption);
	}

	public boolean isExisted(long surveyOptionId) throws SystemException {

		SurveyOption s_option = surveyOptionPersistence
				.fetchByPrimaryKey(surveyOptionId);

		return s_option == null ? false : true;
	}

	public List<SurveyOption> findBySurveyQuestionId(long surveyQuestionId)
			throws SystemException {

		return surveyOptionPersistence.findBySurveyQuestionId(surveyQuestionId);
	}

	public List<SurveyOption> findBySurveyPageId(long surveyPageId)
			throws SystemException {

		return surveyOptionPersistence.findBySurveyPageId(surveyPageId);
	}

	public List<SurveyOption> findBySurveyMainId(long surveyMainId)
			throws SystemException {

		return surveyOptionPersistence.findBySurveyMainId(surveyMainId);
	}

	public List<SurveyOption> findByQ_I(long surveyQuestionId, boolean isAns)
			throws SystemException {

		return surveyOptionPersistence.findByQ_I(surveyQuestionId, isAns);
	}

	public long getPageDirectIdByOptionId(long surveyOptionId)
			throws SystemException {

		return surveyOptionPersistence.fetchByPrimaryKey(surveyOptionId)
				.getPageDirectId();
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException {

		surveyOptionPersistence.removeBySurveyMainId(surveyMainId);
	}
}