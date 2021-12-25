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

import com.lc.survey.model.SurveyResponse;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyResponse in entity cache.
 *
 * @author kevin
 * @see SurveyResponse
 * @generated
 */
public class SurveyResponseCacheModel implements CacheModel<SurveyResponse>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{surveyResponseId=");
		sb.append(surveyResponseId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", writerId=");
		sb.append(writerId);
		sb.append(", response=");
		sb.append(response);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyResponse toEntityModel() {
		SurveyResponseImpl surveyResponseImpl = new SurveyResponseImpl();

		surveyResponseImpl.setSurveyResponseId(surveyResponseId);
		surveyResponseImpl.setSurveyMainId(surveyMainId);
		surveyResponseImpl.setWriterId(writerId);

		if (response == null) {
			surveyResponseImpl.setResponse(StringPool.BLANK);
		}
		else {
			surveyResponseImpl.setResponse(response);
		}

		surveyResponseImpl.setCreatorId(creatorId);
		surveyResponseImpl.setCreateDate(createDate);

		surveyResponseImpl.resetOriginalValues();

		return surveyResponseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyResponseId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		writerId = objectInput.readLong();
		response = objectInput.readUTF();
		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyResponseId);
		objectOutput.writeLong(surveyMainId);
		objectOutput.writeLong(writerId);

		if (response == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(response);
		}

		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
	}

	public long surveyResponseId;
	public long surveyMainId;
	public long writerId;
	public String response;
	public long creatorId;
	public long createDate;
}