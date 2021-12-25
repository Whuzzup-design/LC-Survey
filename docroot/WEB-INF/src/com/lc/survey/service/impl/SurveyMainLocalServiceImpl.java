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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lc.survey.model.SurveyMain;
import com.lc.survey.service.base.SurveyMainLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Constants;

/**
 * The implementation of the survey main local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lc.survey.service.SurveyMainLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.base.SurveyMainLocalServiceBaseImpl
 * @see com.lc.survey.service.SurveyMainLocalServiceUtil
 */
public class SurveyMainLocalServiceImpl extends SurveyMainLocalServiceBaseImpl {

	public void updateSurveyMain(SurveyMain surveyMain, String title,
			String description, String epilog, Date startDate, Date endDate,
			boolean needAuth, boolean calculateScore, boolean viewAnswer,
			String color, long userId, long modifiedDate, String action)
			throws SystemException {

		surveyMain.setTitle(title);
		surveyMain.setDescription(description);
		surveyMain.setEpilog(epilog);
		surveyMain.setStartDate(startDate);
		surveyMain.setEndDate(endDate);
		surveyMain.setNeedAuth(needAuth);
		surveyMain.setCalculateScore(calculateScore);
		surveyMain.setViewAnswer(viewAnswer);
		surveyMain.setColor(color);

		if (action.equals(Constants.ADD)) {
			surveyMain.setCreatorId(userId);
			surveyMain.setCreateDate(modifiedDate);
		}
		surveyMain.setModifiedDate(modifiedDate);
		surveyMain.setModifierId(userId);

		surveyMainPersistence.update(surveyMain);
	}

	public boolean isExisted(long surveyMainId) throws SystemException {

		SurveyMain s_main = surveyMainPersistence
				.fetchByPrimaryKey(surveyMainId);

		return s_main == null ? false : true;
	}

	public List<SurveyMain> findForSearch(long creatorId, String openTime,
			String calculateScore, String title) {

		List<SurveyMain> s_mains = surveyMainFinder.findForSearch(creatorId,
				openTime, calculateScore, title);

		return s_mains == null ? new ArrayList<SurveyMain>() : s_mains;
	}

}