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

import com.lc.survey.model.SurveyOption;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyOption in entity cache.
 *
 * @author kevin
 * @see SurveyOption
 * @generated
 */
public class SurveyOptionCacheModel implements CacheModel<SurveyOption>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{surveyOptionId=");
		sb.append(surveyOptionId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", surveyPageId=");
		sb.append(surveyPageId);
		sb.append(", surveyQuestionId=");
		sb.append(surveyQuestionId);
		sb.append(", no=");
		sb.append(no);
		sb.append(", option=");
		sb.append(option);
		sb.append(", isAns=");
		sb.append(isAns);
		sb.append(", pageDirectId=");
		sb.append(pageDirectId);
		sb.append(", uploadFileId=");
		sb.append(uploadFileId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", modifierId=");
		sb.append(modifierId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyOption toEntityModel() {
		SurveyOptionImpl surveyOptionImpl = new SurveyOptionImpl();

		surveyOptionImpl.setSurveyOptionId(surveyOptionId);
		surveyOptionImpl.setSurveyMainId(surveyMainId);
		surveyOptionImpl.setSurveyPageId(surveyPageId);
		surveyOptionImpl.setSurveyQuestionId(surveyQuestionId);
		surveyOptionImpl.setNo(no);

		if (option == null) {
			surveyOptionImpl.setOption(StringPool.BLANK);
		}
		else {
			surveyOptionImpl.setOption(option);
		}

		surveyOptionImpl.setIsAns(isAns);
		surveyOptionImpl.setPageDirectId(pageDirectId);
		surveyOptionImpl.setUploadFileId(uploadFileId);
		surveyOptionImpl.setCreatorId(creatorId);
		surveyOptionImpl.setModifierId(modifierId);
		surveyOptionImpl.setCreateDate(createDate);
		surveyOptionImpl.setModifiedDate(modifiedDate);

		surveyOptionImpl.resetOriginalValues();

		return surveyOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyOptionId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		surveyPageId = objectInput.readLong();
		surveyQuestionId = objectInput.readLong();
		no = objectInput.readInt();
		option = objectInput.readUTF();
		isAns = objectInput.readBoolean();
		pageDirectId = objectInput.readLong();
		uploadFileId = objectInput.readLong();
		creatorId = objectInput.readLong();
		modifierId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyOptionId);
		objectOutput.writeLong(surveyMainId);
		objectOutput.writeLong(surveyPageId);
		objectOutput.writeLong(surveyQuestionId);
		objectOutput.writeInt(no);

		if (option == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(option);
		}

		objectOutput.writeBoolean(isAns);
		objectOutput.writeLong(pageDirectId);
		objectOutput.writeLong(uploadFileId);
		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(modifierId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long surveyOptionId;
	public long surveyMainId;
	public long surveyPageId;
	public long surveyQuestionId;
	public int no;
	public String option;
	public Boolean isAns;
	public long pageDirectId;
	public long uploadFileId;
	public long creatorId;
	public long modifierId;
	public long createDate;
	public long modifiedDate;
}