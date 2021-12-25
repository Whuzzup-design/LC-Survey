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
public class SurveyResponseSoap implements Serializable {
	public static SurveyResponseSoap toSoapModel(SurveyResponse model) {
		SurveyResponseSoap soapModel = new SurveyResponseSoap();

		soapModel.setSurveyResponseId(model.getSurveyResponseId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setWriterId(model.getWriterId());
		soapModel.setResponse(model.getResponse());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SurveyResponseSoap[] toSoapModels(SurveyResponse[] models) {
		SurveyResponseSoap[] soapModels = new SurveyResponseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyResponseSoap[][] toSoapModels(SurveyResponse[][] models) {
		SurveyResponseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyResponseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyResponseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyResponseSoap[] toSoapModels(List<SurveyResponse> models) {
		List<SurveyResponseSoap> soapModels = new ArrayList<SurveyResponseSoap>(models.size());

		for (SurveyResponse model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyResponseSoap[soapModels.size()]);
	}

	public SurveyResponseSoap() {
	}

	public long getPrimaryKey() {
		return _surveyResponseId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyResponseId(pk);
	}

	public long getSurveyResponseId() {
		return _surveyResponseId;
	}

	public void setSurveyResponseId(long surveyResponseId) {
		_surveyResponseId = surveyResponseId;
	}

	public long getSurveyMainId() {
		return _surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;
	}

	public long getWriterId() {
		return _writerId;
	}

	public void setWriterId(long writerId) {
		_writerId = writerId;
	}

	public String getResponse() {
		return _response;
	}

	public void setResponse(String response) {
		_response = response;
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

	private long _surveyResponseId;
	private long _surveyMainId;
	private long _writerId;
	private String _response;
	private long _creatorId;
	private long _createDate;
}