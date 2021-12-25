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

import com.lc.survey.NoSuchSurveyWriterException;
import com.lc.survey.model.SurveyWriter;
import com.lc.survey.service.base.SurveyWriterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the survey writer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyWriterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyWriterLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyWriterLocalServiceUtil
 */
public class SurveyWriterLocalServiceImpl extends
		SurveyWriterLocalServiceBaseImpl {

	public void updateSurveyWriter(SurveyWriter surveyWriter,
			long surveyMainId, boolean isPreview, boolean isComplete,
			long completionTime, long creatorId, long createDate)
			throws SystemException {

		surveyWriter.setSurveyMainId(surveyMainId);
		surveyWriter.setIsPreview(isPreview);
		surveyWriter.setIsComplete(isComplete);
		surveyWriter.setCompletionTime(completionTime);

		surveyWriter.setCreatorId(creatorId);
		surveyWriter.setCreateDate(createDate);

		surveyWriterPersistence.update(surveyWriter);
	}

	public void updateToCompleted(long surveyWriterId) throws SystemException {

		SurveyWriter s_writer = surveyWriterPersistence
				.fetchByPrimaryKey(surveyWriterId);

		s_writer.setIsComplete(true);
		s_writer.setCompletionTime(System.currentTimeMillis());
		surveyWriterPersistence.update(s_writer);
	}

	public List<SurveyWriter> findBySurveyMainId(long surveyMainId)
			throws SystemException {

		return surveyWriterPersistence.findBySurveyMainId(surveyMainId);
	}

	public List<SurveyWriter> findByM_P_C(long surveyMainId, boolean isPreview,
			boolean isComplete) throws SystemException {

		return surveyWriterPersistence.findByM_P_C(surveyMainId, isPreview,
				isComplete);
	}

	public int countByM_P_C(long surveyMainId, boolean isPreview,
			boolean isComplete) throws SystemException {

		return surveyWriterPersistence.countByM_P_C(surveyMainId, isPreview,
				isComplete);
	}

	public void removeBySurveyMainId(long surveyMainId) throws SystemException,
			NoSuchSurveyWriterException {

		List<SurveyWriter> s_writers = surveyWriterPersistence
				.findBySurveyMainId(surveyMainId);

		for (SurveyWriter s_writer : s_writers) {

			surveyWriteSequencePersistence.removeBySurveyWriterId(s_writer
					.getSurveyWriterId());

			surveyWriterPersistence.remove(s_writer.getSurveyWriterId());
		}
	}
}