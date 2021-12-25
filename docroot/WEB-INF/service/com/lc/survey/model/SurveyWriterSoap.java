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
public class SurveyWriterSoap implements Serializable {
	public static SurveyWriterSoap toSoapModel(SurveyWriter model) {
		SurveyWriterSoap soapModel = new SurveyWriterSoap();

		soapModel.setSurveyWriterId(model.getSurveyWriterId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setIsPreview(model.getIsPreview());
		soapModel.setIsComplete(model.getIsComplete());
		soapModel.setCompletionTime(model.getCompletionTime());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SurveyWriterSoap[] toSoapModels(SurveyWriter[] models) {
		SurveyWriterSoap[] soapModels = new SurveyWriterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyWriterSoap[][] toSoapModels(SurveyWriter[][] models) {
		SurveyWriterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyWriterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyWriterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyWriterSoap[] toSoapModels(List<SurveyWriter> models) {
		List<SurveyWriterSoap> soapModels = new ArrayList<SurveyWriterSoap>(models.size());

		for (SurveyWriter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyWriterSoap[soapModels.size()]);
	}

	public SurveyWriterSoap() {
	}

	public long getPrimaryKey() {
		return _surveyWriterId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyWriterId(pk);
	}

	public long getSurveyWriterId() {
		return _surveyWriterId;
	}

	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriterId = surveyWriterId;
	}

	public long getSurveyMainId() {
		return _surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;
	}

	public Boolean getIsPreview() {
		return _isPreview;
	}

	public void setIsPreview(Boolean isPreview) {
		_isPreview = isPreview;
	}

	public Boolean getIsComplete() {
		return _isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		_isComplete = isComplete;
	}

	public long getCompletionTime() {
		return _completionTime;
	}

	public void setCompletionTime(long completionTime) {
		_completionTime = completionTime;
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

	private long _surveyWriterId;
	private long _surveyMainId;
	private Boolean _isPreview;
	private Boolean _isComplete;
	private long _completionTime;
	private long _creatorId;
	private long _createDate;
}