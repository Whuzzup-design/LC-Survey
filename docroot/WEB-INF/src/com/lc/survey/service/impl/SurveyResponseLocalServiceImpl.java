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

import com.lc.survey.model.SurveyResponse;
import com.lc.survey.service.base.SurveyResponseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the survey response local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyResponseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyResponseLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyResponseLocalServiceUtil
 */
public class SurveyResponseLocalServiceImpl extends
		SurveyResponseLocalServiceBaseImpl {

	public void updateSurveyResponse(SurveyResponse surveyResponse,
			long surveyMainId, long writerId, String response, long userId,
			long date) throws SystemException {

		surveyResponse.setSurveyMainId(surveyMainId);
		surveyResponse.setWriterId(writerId);
		surveyResponse.setResponse(response);

		surveyResponse.setCreatorId(userId);
		surveyResponse.setCreateDate(date);

		surveyResponsePersistence.update(surveyResponse);
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException {

		surveyResponsePersistence.removeBySurveyMainId(surveyMainId);
	}

	public List<SurveyResponse> findByWriterId(long writerId)
			throws SystemException {

		return surveyResponsePersistence.findByWriterId(writerId);
	}

	public List<SurveyResponse> findBySurveyMainId(long surveyMainId)
			throws SystemException {

		return surveyResponsePersistence.findBySurveyMainId(surveyMainId);
	}

	public int countByWriterId(long writerId) throws SystemException {

		return surveyResponsePersistence.countByWriterId(writerId);
	}

	public int countBySurveyMainId(long surveyMainId) throws SystemException {

		return surveyResponsePersistence.countBySurveyMainId(surveyMainId);
	}
}