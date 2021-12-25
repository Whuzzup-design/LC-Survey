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

import com.lc.survey.model.SurveyWriteSequence;
import com.lc.survey.service.base.SurveyWriteSequenceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;

/**
 * The implementation of the survey write sequence local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyWriteSequenceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyWriteSequenceLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyWriteSequenceLocalServiceUtil
 */
public class SurveyWriteSequenceLocalServiceImpl extends
		SurveyWriteSequenceLocalServiceBaseImpl {

	public void updateSurveyWriteSequence(
			SurveyWriteSequence surveyWriteSequence, long surveyWriterId,
			long pageId, long prePageId, boolean isDirect, long creatorId,
			long createDate, String action) throws SystemException {

		surveyWriteSequence.setSurveyWriterId(surveyWriterId);
		surveyWriteSequence.setPageId(pageId);
		surveyWriteSequence.setPrePageId(prePageId);
		surveyWriteSequence.setIsDirect(isDirect);

		if (action.equals(Constants.ADD)) {
			surveyWriteSequence.setCreatorId(creatorId);
			surveyWriteSequence.setCreateDate(createDate);
		}

		surveyWriteSequencePersistence.update(surveyWriteSequence);
	}

	public SurveyWriteSequence findByS_P(long surveyWriterId, long pageId)
			throws SystemException {

		return surveyWriteSequencePersistence
				.fetchByS_P(surveyWriterId, pageId);
	}

	public void removeBySurveyWriterId(long surveyWriterId)
			throws SystemException {

		surveyWriteSequencePersistence.removeBySurveyWriterId(surveyWriterId);
	}
}