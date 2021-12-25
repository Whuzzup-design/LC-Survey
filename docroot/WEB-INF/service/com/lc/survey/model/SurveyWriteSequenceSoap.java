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
public class SurveyWriteSequenceSoap implements Serializable {
	public static SurveyWriteSequenceSoap toSoapModel(SurveyWriteSequence model) {
		SurveyWriteSequenceSoap soapModel = new SurveyWriteSequenceSoap();

		soapModel.setSurveyWriteSequenceId(model.getSurveyWriteSequenceId());
		soapModel.setSurveyWriterId(model.getSurveyWriterId());
		soapModel.setPageId(model.getPageId());
		soapModel.setPrePageId(model.getPrePageId());
		soapModel.setIsDirect(model.getIsDirect());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SurveyWriteSequenceSoap[] toSoapModels(
		SurveyWriteSequence[] models) {
		SurveyWriteSequenceSoap[] soapModels = new SurveyWriteSequenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyWriteSequenceSoap[][] toSoapModels(
		SurveyWriteSequence[][] models) {
		SurveyWriteSequenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyWriteSequenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyWriteSequenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyWriteSequenceSoap[] toSoapModels(
		List<SurveyWriteSequence> models) {
		List<SurveyWriteSequenceSoap> soapModels = new ArrayList<SurveyWriteSequenceSoap>(models.size());

		for (SurveyWriteSequence model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyWriteSequenceSoap[soapModels.size()]);
	}

	public SurveyWriteSequenceSoap() {
	}

	public long getPrimaryKey() {
		return _surveyWriteSequenceId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyWriteSequenceId(pk);
	}

	public long getSurveyWriteSequenceId() {
		return _surveyWriteSequenceId;
	}

	public void setSurveyWriteSequenceId(long surveyWriteSequenceId) {
		_surveyWriteSequenceId = surveyWriteSequenceId;
	}

	public long getSurveyWriterId() {
		return _surveyWriterId;
	}

	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriterId = surveyWriterId;
	}

	public long getPageId() {
		return _pageId;
	}

	public void setPageId(long pageId) {
		_pageId = pageId;
	}

	public long getPrePageId() {
		return _prePageId;
	}

	public void setPrePageId(long prePageId) {
		_prePageId = prePageId;
	}

	public Boolean getIsDirect() {
		return _isDirect;
	}

	public void setIsDirect(Boolean isDirect) {
		_isDirect = isDirect;
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

	private long _surveyWriteSequenceId;
	private long _surveyWriterId;
	private long _pageId;
	private long _prePageId;
	private Boolean _isDirect;
	private long _creatorId;
	private long _createDate;
}