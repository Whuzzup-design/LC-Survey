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

import com.lc.survey.model.SurveyPage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyPage in entity cache.
 *
 * @author kevin
 * @see SurveyPage
 * @generated
 */
public class SurveyPageCacheModel implements CacheModel<SurveyPage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{surveyPageId=");
		sb.append(surveyPageId);
		sb.append(", surveyMainId=");
		sb.append(surveyMainId);
		sb.append(", no=");
		sb.append(no);
		sb.append(", title=");
		sb.append(title);
		sb.append(", pageDirectId=");
		sb.append(pageDirectId);
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
	public SurveyPage toEntityModel() {
		SurveyPageImpl surveyPageImpl = new SurveyPageImpl();

		surveyPageImpl.setSurveyPageId(surveyPageId);
		surveyPageImpl.setSurveyMainId(surveyMainId);
		surveyPageImpl.setNo(no);

		if (title == null) {
			surveyPageImpl.setTitle(StringPool.BLANK);
		}
		else {
			surveyPageImpl.setTitle(title);
		}

		surveyPageImpl.setPageDirectId(pageDirectId);
		surveyPageImpl.setCreatorId(creatorId);
		surveyPageImpl.setModifierId(modifierId);
		surveyPageImpl.setCreateDate(createDate);
		surveyPageImpl.setModifiedDate(modifiedDate);

		surveyPageImpl.resetOriginalValues();

		return surveyPageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyPageId = objectInput.readLong();
		surveyMainId = objectInput.readLong();
		no = objectInput.readInt();
		title = objectInput.readUTF();
		pageDirectId = objectInput.readLong();
		creatorId = objectInput.readLong();
		modifierId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveyPageId);
		objectOutput.writeLong(surveyMainId);
		objectOutput.writeInt(no);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(pageDirectId);
		objectOutput.writeLong(creatorId);
		objectOutput.writeLong(modifierId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long surveyPageId;
	public long surveyMainId;
	public int no;
	public String title;
	public long pageDirectId;
	public long creatorId;
	public long modifierId;
	public long createDate;
	public long modifiedDate;
}