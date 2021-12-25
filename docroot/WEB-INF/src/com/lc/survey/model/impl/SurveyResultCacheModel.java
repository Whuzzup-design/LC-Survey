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

import com.lc.survey.model.SurveyResult;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyResult in entity cache.
 *
 * @author kevin
 * @see SurveyResult
 * @generated
 */
public class SurveyResultCacheModel implements CacheModel<SurveyResult>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{surveyResultId=");
		sb.append(surveyResultId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", surveyPageId=");
		sb.append(surveyPageId);
		sb.append(", surveyQuestionId=");
		sb.append(surveyQuestionId);
		sb.append(", surveyOptionId=");
		sb.append(surveyOptionId);
		sb.append(", surveyWriterId=");
		sb.append(surveyWriterId);
		sb.append(", ans=");
		sb.append(ans);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyResult toEntityModel() {
		SurveyResultImpl surveyResultImpl = new SurveyResultImpl();

		surveyResultImpl.setSurveyResultId(surveyResultId);
		surveyResultImpl.setSurveyMainId(surveyMainId);
		surveyResultImpl.setSurveyPageId(surveyPageId);
		surveyResultImpl.setSurveyQuestionId(surveyQuestionId);
		surveyResultImpl.setSurveyOptionId(surveyOptionId);
		surveyResultImpl.setSurveyWriterId(surveyWriterId);

		if (ans == null) {
			surveyResultImpl.setAns(StringPool.BLANK);
		}
		else {
			surveyResultImpl.setAns(ans);
		}

		surveyResultImpl.setCreatorId(creatorId);
		surveyResultImpl.setCreateDate(createDate);

		surveyResultImpl.resetOriginalValues();

		return surveyResultImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyResultId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		surveyPageId = objectInput.readLong();
		surveyQuestionId = objectInput.readLong();
		surveyOptionId = objectInput.readLong();
		surveyWriterId = objectInput.readLong();
		ans = objectInput.readUTF();
		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyResultId);
		objectOutput.writeLong(surveyMainId);
		objectOutput.writeLong(surveyPageId);
		objectOutput.writeLong(surveyQuestionId);
		objectOutput.writeLong(surveyOptionId);
		objectOutput.writeLong(surveyWriterId);

		if (ans == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ans);
		}

		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
	}

	public long surveyResultId;
	public long surveyMainId;
	public long surveyPageId;
	public long surveyQuestionId;
	public long surveyOptionId;
	public long surveyWriterId;
	public String ans;
	public long creatorId;
	public long createDate;
}