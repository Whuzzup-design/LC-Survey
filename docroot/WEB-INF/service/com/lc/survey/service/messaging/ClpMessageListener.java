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

package com.lc.survey.service.messaging;

import com.lc.survey.service.ClpSerializer;
import com.lc.survey.service.SurveyFileLocalServiceUtil;
import com.lc.survey.service.SurveyMainLocalServiceUtil;
import com.lc.survey.service.SurveyOptionLocalServiceUtil;
import com.lc.survey.service.SurveyPageLocalServiceUtil;
import com.lc.survey.service.SurveyQuestionLocalServiceUtil;
import com.lc.survey.service.SurveyResponseLocalServiceUtil;
import com.lc.survey.service.SurveyResultLocalServiceUtil;
import com.lc.survey.service.SurveyWriteSequenceLocalServiceUtil;
import com.lc.survey.service.SurveyWriterLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author kevin
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			SurveyFileLocalServiceUtil.clearService();

			SurveyMainLocalServiceUtil.clearService();

			SurveyOptionLocalServiceUtil.clearService();

			SurveyPageLocalServiceUtil.clearService();

			SurveyQuestionLocalServiceUtil.clearService();

			SurveyResponseLocalServiceUtil.clearService();

			SurveyResultLocalServiceUtil.clearService();

			SurveyWriterLocalServiceUtil.clearService();

			SurveyWriteSequenceLocalServiceUtil.clearService();
		}
	}
}