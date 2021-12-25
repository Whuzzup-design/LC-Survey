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

package com.lc.survey.model.impl;

import com.lc.survey.model.SurveyWriter;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyWriter in entity cache.
 *
 * @author kevin
 * @see SurveyWriter
 * @generated
 */
public class SurveyWriterCacheModel implements CacheModel<SurveyWriter>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{surveyWriterId=");
		sb.append(surveyWriterId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", isPreview=");
		sb.append(isPreview);
		sb.append(", isComplete=");
		sb.append(isComplete);
		sb.append(", completionTime=");
		sb.append(completionTime);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyWriter toEntityModel() {
		SurveyWriterImpl surveyWriterImpl = new SurveyWriterImpl();

		surveyWriterImpl.setSurveyWriterId(surveyWriterId);
		surveyWriterImpl.setSurveyMainId(surveyMainId);
		surveyWriterImpl.setIsPreview(isPreview);
		surveyWriterImpl.setIsComplete(isComplete);
		surveyWriterImpl.setCompletionTime(completionTime);
		surveyWriterImpl.setCreatorId(creatorId);
		surveyWriterImpl.setCreateDate(createDate);

		surveyWriterImpl.resetOriginalValues();

		return surveyWriterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyWriterId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		isPreview = objectInput.readBoolean();
		isComplete = objectInput.readBoolean();
		completionTime = objectInput.readLong();
		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyWriterId);
		objectOutput.writeLong(surveyMainId);
		objectOutput.writeBoolean(isPreview);
		objectOutput.writeBoolean(isComplete);
		objectOutput.writeLong(completionTime);
		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
	}

	public long surveyWriterId;
	public long surveyMainId;
	public Boolean isPreview;
	public Boolean isComplete;
	public long completionTime;
	public long creatorId;
	public long createDate;
}