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
public class SurveyResultSoap implements Serializable {
	public static SurveyResultSoap toSoapModel(SurveyResult model) {
		SurveyResultSoap soapModel = new SurveyResultSoap();

		soapModel.setSurveyResultId(model.getSurveyResultId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setSurveyPageId(model.getSurveyPageId());
		soapModel.setSurveyQuestionId(model.getSurveyQuestionId());
		soapModel.setSurveyOptionId(model.getSurveyOptionId());
		soapModel.setSurveyWriterId(model.getSurveyWriterId());
		soapModel.setAns(model.getAns());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SurveyResultSoap[] toSoapModels(SurveyResult[] models) {
		SurveyResultSoap[] soapModels = new SurveyResultSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyResultSoap[][] toSoapModels(SurveyResult[][] models) {
		SurveyResultSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyResultSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyResultSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyResultSoap[] toSoapModels(List<SurveyResult> models) {
		List<SurveyResultSoap> soapModels = new ArrayList<SurveyResultSoap>(models.size());

		for (SurveyResult model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyResultSoap[soapModels.size()]);
	}

	public SurveyResultSoap() {
	}

	public long getPrimaryKey() {
		return _surveyResultId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyResultId(pk);
	}

	public long getSurveyResultId() {
		return _surveyResultId;
	}

	public void setSurveyResultId(long surveyResultId) {
		_surveyResultId = surveyResultId;
	}

	public long getSurveyMainId() {
		return _surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;
	}

	public long getSurveyPageId() {
		return _surveyPageId;
	}

	public void setSurveyPageId(long surveyPageId) {
		_surveyPageId = surveyPageId;
	}

	public long getSurveyQuestionId() {
		return _surveyQuestionId;
	}

	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyQuestionId = surveyQuestionId;
	}

	public long getSurveyOptionId() {
		return _surveyOptionId;
	}

	public void setSurveyOptionId(long surveyOptionId) {
		_surveyOptionId = surveyOptionId;
	}

	public long getSurveyWriterId() {
		return _surveyWriterId;
	}

	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriterId = surveyWriterId;
	}

	public String getAns() {
		return _ans;
	}

	public void setAns(String ans) {
		_ans = ans;
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

	private long _surveyResultId;
	private long _surveyMainId;
	private long _surveyPageId;
	private long _surveyQuestionId;
	private long _surveyOptionId;
	private long _surveyWriterId;
	private String _ans;
	private long _creatorId;
	private long _createDate;
}