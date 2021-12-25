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

import com.lc.survey.model.SurveyFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyFile in entity cache.
 *
 * @author kevin
 * @see SurveyFile
 * @generated
 */
public class SurveyFileCacheModel implements CacheModel<SurveyFile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{surveyFileId=");
		sb.append(surveyFileId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyFile toEntityModel() {
		SurveyFileImpl surveyFileImpl = new SurveyFileImpl();

		surveyFileImpl.setSurveyFileId(surveyFileId);
		surveyFileImpl.setSurveyMainId(surveyMainId);

		if (fileName == null) {
			surveyFileImpl.setFileName(StringPool.BLANK);
		}
		else {
			surveyFileImpl.setFileName(fileName);
		}

		surveyFileImpl.setCreatorId(creatorId);
		surveyFileImpl.setCreateDate(createDate);

		surveyFileImpl.resetOriginalValues();

		return surveyFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyFileId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		fileName = objectInput.readUTF();
		creatorId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyFileId);
		objectOutput.writeLong(surveyMainId);

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(createDate);
	}

	public long surveyFileId;
	public long surveyMainId;
	public String fileName;
	public long creatorId;
	public long createDate;
}