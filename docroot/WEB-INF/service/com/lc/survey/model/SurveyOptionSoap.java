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
public class SurveyOptionSoap implements Serializable {
	public static SurveyOptionSoap toSoapModel(SurveyOption model) {
		SurveyOptionSoap soapModel = new SurveyOptionSoap();

		soapModel.setSurveyOptionId(model.getSurveyOptionId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setSurveyPageId(model.getSurveyPageId());
		soapModel.setSurveyQuestionId(model.getSurveyQuestionId());
		soapModel.setNo(model.getNo());
		soapModel.setOption(model.getOption());
		soapModel.setIsAns(model.getIsAns());
		soapModel.setPageDirectId(model.getPageDirectId());
		soapModel.setUploadFileId(model.getUploadFileId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setModifierId(model.getModifierId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SurveyOptionSoap[] toSoapModels(SurveyOption[] models) {
		SurveyOptionSoap[] soapModels = new SurveyOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyOptionSoap[][] toSoapModels(SurveyOption[][] models) {
		SurveyOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyOptionSoap[] toSoapModels(List<SurveyOption> models) {
		List<SurveyOptionSoap> soapModels = new ArrayList<SurveyOptionSoap>(models.size());

		for (SurveyOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyOptionSoap[soapModels.size()]);
	}

	public SurveyOptionSoap() {
	}

	public long getPrimaryKey() {
		return _surveyOptionId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyOptionId(pk);
	}

	public long getSurveyOptionId() {
		return _surveyOptionId;
	}

	public void setSurveyOptionId(long surveyOptionId) {
		_surveyOptionId = surveyOptionId;
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

	public int getNo() {
		return _no;
	}

	public void setNo(int no) {
		_no = no;
	}

	public String getOption() {
		return _option;
	}

	public void setOption(String option) {
		_option = option;
	}

	public Boolean getIsAns() {
		return _isAns;
	}

	public void setIsAns(Boolean isAns) {
		_isAns = isAns;
	}

	public long getPageDirectId() {
		return _pageDirectId;
	}

	public void setPageDirectId(long pageDirectId) {
		_pageDirectId = pageDirectId;
	}

	public long getUploadFileId() {
		return _uploadFileId;
	}

	public void setUploadFileId(long uploadFileId) {
		_uploadFileId = uploadFileId;
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

	private long _surveyOptionId;
	private long _surveyMainId;
	private long _surveyPageId;
	private long _surveyQuestionId;
	private int _no;
	private String _option;
	private Boolean _isAns;
	private long _pageDirectId;
	private long _uploadFileId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
}