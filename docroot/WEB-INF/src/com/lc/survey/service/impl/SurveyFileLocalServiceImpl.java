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

import com.lc.survey.model.SurveyFile;
import com.lc.survey.service.base.SurveyFileLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the survey file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyFileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyFileLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyFileLocalServiceUtil
 */
public class SurveyFileLocalServiceImpl extends SurveyFileLocalServiceBaseImpl {

	public void updateSurveyFile(SurveyFile surveyFile, long surveyMainId,
			String fileName, long creatorId, long createDate)
			throws SystemException {

		surveyFile.setSurveyMainId(surveyMainId);
		surveyFile.setFileName(fileName);

		surveyFile.setCreatorId(creatorId);
		surveyFile.setCreateDate(createDate);

		surveyFilePersistence.update(surveyFile);
	}

	public List<SurveyFile> findBySurveyMainId(long surveyMainId)
			throws SystemException {
		return surveyFilePersistence.findBySurveyMainId(surveyMainId);
	}

	public boolean isExisted(long surveyFileId) throws SystemException {

		SurveyFile s_File = surveyFilePersistence
				.fetchByPrimaryKey(surveyFileId);

		return s_File == null ? false : true;
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException {

		surveyFilePersistence.removeBySurveyMainId(surveyMainId);
	}
}