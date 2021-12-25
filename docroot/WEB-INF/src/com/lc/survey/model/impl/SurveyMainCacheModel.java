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

import com.lc.survey.model.SurveyMain;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SurveyMain in entity cache.
 *
 * @author kevin
 * @see SurveyMain
 * @generated
 */
public class SurveyMainCacheModel implements CacheModel<SurveyMain>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", epilog=");
		sb.append(epilog);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", needAuth=");
		sb.append(needAuth);
		sb.append(", calculateScore=");
		sb.append(calculateScore);
		sb.append(", viewAnswer=");
		sb.append(viewAnswer);
		sb.append(", color=");
		sb.append(color);
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
	public SurveyMain toEntityModel() {
		SurveyMainImpl surveyMainImpl = new SurveyMainImpl();

		surveyMainImpl.setSurveyMainId(surveyMainId);

		if (title == null) {
			surveyMainImpl.setTitle(StringPool.BLANK);
		}
		else {
			surveyMainImpl.setTitle(title);
		}

		if (description == null) {
			surveyMainImpl.setDescription(StringPool.BLANK);
		}
		else {
			surveyMainImpl.setDescription(description);
		}

		if (epilog == null) {
			surveyMainImpl.setEpilog(StringPool.BLANK);
		}
		else {
			surveyMainImpl.setEpilog(epilog);
		}

		if (startDate == Long.MIN_VALUE) {
			surveyMainImpl.setStartDate(null);
		}
		else {
			surveyMainImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			surveyMainImpl.setEndDate(null);
		}
		else {
			surveyMainImpl.setEndDate(new Date(endDate));
		}

		surveyMainImpl.setNeedAuth(needAuth);
		surveyMainImpl.setCalculateScore(calculateScore);
		surveyMainImpl.setViewAnswer(viewAnswer);

		if (color == null) {
			surveyMainImpl.setColor(StringPool.BLANK);
		}
		else {
			surveyMainImpl.setColor(color);
		}

		surveyMainImpl.setCreatorId(creatorId);
		surveyMainImpl.setModifierId(modifierId);
		surveyMainImpl.setCreateDate(createDate);
		surveyMainImpl.setModifiedDate(modifiedDate);

		surveyMainImpl.resetOriginalValues();

		return surveyMainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyMainId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		epilog = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		needAuth = objectInput.readBoolean();
		calculateScore = objectInput.readBoolean();
		viewAnswer = objectInput.readBoolean();
		color = objectInput.readUTF();
		creatorId = objectInput.readLong();
		modifierId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyMainId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (epilog == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(epilog);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeBoolean(needAuth);
		objectOutput.writeBoolean(calculateScore);
		objectOutput.writeBoolean(viewAnswer);

		if (color == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color);
		}

		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(modifierId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long surveyMainId;
	public String title;
	public String description;
	public String epilog;
	public long startDate;
	public long endDate;
	public Boolean needAuth;
	public Boolean calculateScore;
	public Boolean viewAnswer;
	public String color;
	public long creatorId;
	public long modifierId;
	public long createDate;
	public long modifiedDate;
}