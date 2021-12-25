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
public class SurveyPageSoap implements Serializable {
	public static SurveyPageSoap toSoapModel(SurveyPage model) {
		SurveyPageSoap soapModel = new SurveyPageSoap();

		soapModel.setSurveyPageId(model.getSurveyPageId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setNo(model.getNo());
		soapModel.setTitle(model.getTitle());
		soapModel.setPageDirectId(model.getPageDirectId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setModifierId(model.getModifierId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SurveyPageSoap[] toSoapModels(SurveyPage[] models) {
		SurveyPageSoap[] soapModels = new SurveyPageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyPageSoap[][] toSoapModels(SurveyPage[][] models) {
		SurveyPageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyPageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyPageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyPageSoap[] toSoapModels(List<SurveyPage> models) {
		List<SurveyPageSoap> soapModels = new ArrayList<SurveyPageSoap>(models.size());

		for (SurveyPage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyPageSoap[soapModels.size()]);
	}

	public SurveyPageSoap() {
	}

	public long getPrimaryKey() {
		return _surveyPageId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyPageId(pk);
	}

	public long getSurveyPageId() {
		return _surveyPageId;
	}

	public void setSurveyPageId(long surveyPageId) {
		_surveyPageId = surveyPageId;
	}

	public long getSurveyMainId() {
		return _surveyMainId;
	}

	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;
	}

	public int getNo() {
		return _no;
	}

	public void setNo(int no) {
		_no = no;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getPageDirectId() {
		return _pageDirectId;
	}

	public void setPageDirectId(long pageDirectId) {
		_pageDirectId = pageDirectId;
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

	private long _surveyPageId;
	private long _surveyMainId;
	private int _no;
	private String _title;
	private long _pageDirectId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
}