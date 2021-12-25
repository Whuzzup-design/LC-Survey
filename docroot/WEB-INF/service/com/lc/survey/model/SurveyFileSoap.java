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

package com.lc.survey.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author kevin
 * @generated
 */
public class SurveyFileSoap implements Serializable {
	public static SurveyFileSoap toSoapModel(SurveyFile model) {
		SurveyFileSoap soapModel = new SurveyFileSoap();

		soapModel.setSurveyFileId(model.getSurveyFileId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setFileName(model.getFileName());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SurveyFileSoap[] toSoapModels(SurveyFile[] models) {
		SurveyFileSoap[] soapModels = new SurveyFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyFileSoap[][] toSoapModels(SurveyFile[][] models) {
		SurveyFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyFileSoap[] toSoapModels(List<SurveyFile> models) {
		List<SurveyFileSoap> soapModels = new ArrayList<SurveyFileSoap>(models.size());

		for (SurveyFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyFileSoap[soapModels.size()]);
	}

	public SurveyFileSoap() {
	}

	public long getPrimaryKey() {
		return _surveyFileId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyFileId(pk);
	}

	public long getSurveyFileId() {
		return _surveyFileId;
	}

	public void setSurveyFileId(long surveyFileId) {
		_surveyFileId = surveyFileId;
	}

	public long getSurveyMainId() {
		return _surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	private long _surveyFileId;
	private long _surveyMainId;
	private String _fileName;
	private long _creatorId;
	private long _createDate;
}