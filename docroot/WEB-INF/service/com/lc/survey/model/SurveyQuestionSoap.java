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
public class SurveyQuestionSoap implements Serializable {
	public static SurveyQuestionSoap toSoapModel(SurveyQuestion model) {
		SurveyQuestionSoap soapModel = new SurveyQuestionSoap();

		soapModel.setSurveyQuestionId(model.getSurveyQuestionId());
		soapModel.setSurveyMainId(model.getSurveyMainId());
		soapModel.setSurveyPageId(model.getSurveyPageId());
		soapModel.setParentId(model.getParentId());
		soapModel.setNo(model.getNo());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setType(model.getType());
		soapModel.setIsRequired(model.getIsRequired());
		soapModel.setHasOther(model.getHasOther());
		soapModel.setOptionDirect(model.getOptionDirect());
		soapModel.setPoints(model.getPoints());
		soapModel.setStarsCount(model.getStarsCount());
		soapModel.setUploadFileId(model.getUploadFileId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setModifierId(model.getModifierId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SurveyQuestionSoap[] toSoapModels(SurveyQuestion[] models) {
		SurveyQuestionSoap[] soapModels = new SurveyQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyQuestionSoap[][] toSoapModels(SurveyQuestion[][] models) {
		SurveyQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyQuestionSoap[] toSoapModels(List<SurveyQuestion> models) {
		List<SurveyQuestionSoap> soapModels = new ArrayList<SurveyQuestionSoap>(models.size());

		for (SurveyQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyQuestionSoap[soapModels.size()]);
	}

	public SurveyQuestionSoap() {
	}

	public long getPrimaryKey() {
		return _surveyQuestionId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyQuestionId(pk);
	}

	public long getSurveyQuestionId() {
		return _surveyQuestionId;
	}

	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyQuestionId = surveyQuestionId;
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

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public int getNo() {
		return _no;
	}

	public void setNo(int no) {
		_no = no;
	}

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public Boolean getIsRequired() {
		return _isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		_isRequired = isRequired;
	}

	public Boolean getHasOther() {
		return _hasOther;
	}

	public void setHasOther(Boolean hasOther) {
		_hasOther = hasOther;
	}

	public Boolean getOptionDirect() {
		return _optionDirect;
	}

	public void setOptionDirect(Boolean optionDirect) {
		_optionDirect = optionDirect;
	}

	public String getPoints() {
		return _points;
	}

	public void setPoints(String points) {
		_points = points;
	}

	public int getStarsCount() {
		return _starsCount;
	}

	public void setStarsCount(int starsCount) {
		_starsCount = starsCount;
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

	private long _surveyQuestionId;
	private long _surveyMainId;
	private long _surveyPageId;
	private long _parentId;
	private int _no;
	private String _question;
	private String _type;
	private Boolean _isRequired;
	private Boolean _hasOther;
	private Boolean _optionDirect;
	private String _points;
	private int _starsCount;
	private long _uploadFileId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
}