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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author kevin
 * @generated
 */
public class SurveyMainSoap implements Serializable {
	public static SurveyMainSoap toSoapModel(SurveyMain model) {
		SurveyMainSoap soapModel = new SurveyMainSoap();

		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setEpilog(model.getEpilog());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setNeedAuth(model.getNeedAuth());
		soapModel.setCalculateScore(model.getCalculateScore());
		soapModel.setViewAnswer(model.getViewAnswer());
		soapModel.setColor(model.getColor());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setModifierId(model.getModifierId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SurveyMainSoap[] toSoapModels(SurveyMain[] models) {
		SurveyMainSoap[] soapModels = new SurveyMainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyMainSoap[][] toSoapModels(SurveyMain[][] models) {
		SurveyMainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyMainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyMainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyMainSoap[] toSoapModels(List<SurveyMain> models) {
		List<SurveyMainSoap> soapModels = new ArrayList<SurveyMainSoap>(models.size());

		for (SurveyMain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyMainSoap[soapModels.size()]);
	}

	public SurveyMainSoap() {
	}

	public long getPrimaryKey() {
		return _surveyMainId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyMainId(pk);
	}

	public long getSurveyMainId() {
		return _surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getEpilog() {
		return _epilog;
	}

	public void setEpilog(String epilog) {
		_epilog = epilog;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Boolean getNeedAuth() {
		return _needAuth;
	}

	public void setNeedAuth(Boolean needAuth) {
		_needAuth = needAuth;
	}

	public Boolean getCalculateScore() {
		return _calculateScore;
	}

	public void setCalculateScore(Boolean calculateScore) {
		_calculateScore = calculateScore;
	}

	public Boolean getViewAnswer() {
		return _viewAnswer;
	}

	public void setViewAnswer(Boolean viewAnswer) {
		_viewAnswer = viewAnswer;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public long getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	public long getModifierId() {
		return _modifierId;
	}

	public void setModifierId(long modifierId) {
		_modifierId = modifierId;
	}

	public long getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	public long getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _surveyMainId;
	private String _title;
	private String _description;
	private String _epilog;
	private Date _startDate;
	private Date _endDate;
	private Boolean _needAuth;
	private Boolean _calculateScore;
	private Boolean _viewAnswer;
	private String _color;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
}