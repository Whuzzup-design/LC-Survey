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

import com.lc.survey.model.SurveyWriteSequence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyWriteSequence in entity cache.
 *
 * @author kevin
 * @see SurveyWriteSequence
 * @generated
 */
public class SurveyWriteSequenceCacheModel implements CacheModel<SurveyWriteSequence>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{surveyWriteSequenceId=");
		sb.append(surveyWriteSequenceId);
		sb.append(", surveyWriterId=");
		sb.append(surveyWriterId);
		sb.append(", pageId=");
		sb.append(pageId);
		sb.append(", prePageId=");
		sb.append(prePageId);
		sb.append(", isDirect=");
		sb.append(isDirect);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyWriteSequence toEntityModel() {
		SurveyWriteSequenceImpl surveyWriteSequenceImpl = new SurveyWriteSequenceImpl();

		surveyWriteSequenceImpl.setSurveyWriteSequenceId(surveyWriteSequenceId);
		surveyWriteSequenceImpl.setSurveyWriterId(surveyWriterId);
		surveyWriteSequenceImpl.setPageId(pageId);
		surveyWriteSequenceImpl.setPrePageId(prePageId);
		surveyWriteSequenceImpl.setIsDirect(isDirect);
		surveyWriteSequenceImpl.setCreatorId(creatorId);
		surveyWriteSequenceImpl.setCreateDate(createDate);

		surveyWriteSequenceImpl.resetOriginalValues();

		return surveyWriteSequenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyWriteSequenceId = objectInput.readLong();
		surveyWriterId = objectInput.readLong();
		pageId = objectInput.readLong();
		prePageId = objectInput.readLong();
		isDirect = objectInput.readBoolean();
		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyWriteSequenceId);
		objectOutput.writeLong(surveyWriterId);
		objectOutput.writeLong(pageId);
		objectOutput.writeLong(prePageId);
		objectOutput.writeBoolean(isDirect);
		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
	}

	public long surveyWriteSequenceId;
	public long surveyWriterId;
	public long pageId;
	public long prePageId;
	public Boolean isDirect;
	public long creatorId;
	public long createDate;
}