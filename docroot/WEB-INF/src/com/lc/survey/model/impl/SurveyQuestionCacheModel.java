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

import com.lc.survey.model.SurveyQuestion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyQuestion in entity cache.
 *
 * @author kevin
 * @see SurveyQuestion
 * @generated
 */
public class SurveyQuestionCacheModel implements CacheModel<SurveyQuestion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{surveyQuestionId=");
		sb.append(surveyQuestionId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", surveyPageId=");
		sb.append(surveyPageId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", no=");
		sb.append(no);
		sb.append(", question=");
		sb.append(question);
		sb.append(", type=");
		sb.append(type);
		sb.append(", isRequired=");
		sb.append(isRequired);
		sb.append(", hasOther=");
		sb.append(hasOther);
		sb.append(", optionDirect=");
		sb.append(optionDirect);
		sb.append(", points=");
		sb.append(points);
		sb.append(", starsCount=");
		sb.append(starsCount);
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
	public SurveyQuestion toEntityModel() {
		SurveyQuestionImpl surveyQuestionImpl = new SurveyQuestionImpl();

		surveyQuestionImpl.setSurveyQuestionId(surveyQuestionId);
		surveyQuestionImpl.setSurveyMainId(surveyMainId);
		surveyQuestionImpl.setSurveyPageId(surveyPageId);
		surveyQuestionImpl.setParentId(parentId);
		surveyQuestionImpl.setNo(no);

		if (question == null) {
			surveyQuestionImpl.setQuestion(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion(question);
		}

		if (type == null) {
			surveyQuestionImpl.setType(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setType(type);
		}

		surveyQuestionImpl.setIsRequired(isRequired);
		surveyQuestionImpl.setHasOther(hasOther);
		surveyQuestionImpl.setOptionDirect(optionDirect);

		if (points == null) {
			surveyQuestionImpl.setPoints(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setPoints(points);
		}

		surveyQuestionImpl.setStarsCount(starsCount);
		surveyQuestionImpl.setUploadFileId(uploadFileId);
		surveyQuestionImpl.setCreatorId(creatorId);
		surveyQuestionImpl.setModifierId(modifierId);
		surveyQuestionImpl.setCreateDate(createDate);
		surveyQuestionImpl.setModifiedDate(modifiedDate);

		surveyQuestionImpl.resetOriginalValues();

		return surveyQuestionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyQuestionId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		surveyPageId = objectInput.readLong();
		parentId = objectInput.readLong();
		no = objectInput.readInt();
		question = objectInput.readUTF();
		type = objectInput.readUTF();
		isRequired = objectInput.readBoolean();
		hasOther = objectInput.readBoolean();
		optionDirect = objectInput.readBoolean();
		points = objectInput.readUTF();
		starsCount = objectInput.readInt();
		uploadFileId = objectInput.readLong();
		creatorId = objectInput.readLong();
		modifierId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyQuestionId);
		objectOutput.writeLong(surveyMainId);
		objectOutput.writeLong(surveyPageId);
		objectOutput.writeLong(parentId);
		objectOutput.writeInt(no);

		if (question == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeBoolean(isRequired);
		objectOutput.writeBoolean(hasOther);
		objectOutput.writeBoolean(optionDirect);

		if (points == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(points);
		}

		objectOutput.writeInt(starsCount);
		objectOutput.writeLong(uploadFileId);
		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(modifierId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long surveyQuestionId;
	public long surveyMainId;
	public long surveyPageId;
	public long parentId;
	public int no;
	public String question;
	public String type;
	public Boolean isRequired;
	public Boolean hasOther;
	public Boolean optionDirect;
	public String points;
	public int starsCount;
	public long uploadFileId;
	public long creatorId;
	public long modifierId;
	public long createDate;
	public long modifiedDate;
}