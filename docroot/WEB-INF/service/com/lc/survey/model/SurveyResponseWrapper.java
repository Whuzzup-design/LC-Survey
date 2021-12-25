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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SurveyResponse}.
 * </p>
 *
 * @author kevin
 * @see SurveyResponse
 * @generated
 */
public class SurveyResponseWrapper implements SurveyResponse,
	ModelWrapper<SurveyResponse> {
	public SurveyResponseWrapper(SurveyResponse surveyResponse) {
		_surveyResponse = surveyResponse;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyResponse.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyResponse.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyResponseId", getSurveyResponseId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("writerId", getWriterId());
		attributes.put("response", getResponse());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyResponseId = (Long)attributes.get("surveyResponseId");

		if (surveyResponseId != null) {
			setSurveyResponseId(surveyResponseId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		Long writerId = (Long)attributes.get("writerId");

		if (writerId != null) {
			setWriterId(writerId);
		}

		String response = (String)attributes.get("response");

		if (response != null) {
			setResponse(response);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this survey response.
	*
	* @return the primary key of this survey response
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyResponse.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey response.
	*
	* @param primaryKey the primary key of this survey response
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyResponse.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey response ID of this survey response.
	*
	* @return the survey response ID of this survey response
	*/
	@Override
	public long getSurveyResponseId() {
		return _surveyResponse.getSurveyResponseId();
	}

	/**
	* Sets the survey response ID of this survey response.
	*
	* @param surveyResponseId the survey response ID of this survey response
	*/
	@Override
	public void setSurveyResponseId(long surveyResponseId) {
		_surveyResponse.setSurveyResponseId(surveyResponseId);
	}

	/**
	* Returns the survey main ID of this survey response.
	*
	* @return the survey main ID of this survey response
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyResponse.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey response.
	*
	* @param surveyMainId the survey main ID of this survey response
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyResponse.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the writer ID of this survey response.
	*
	* @return the writer ID of this survey response
	*/
	@Override
	public long getWriterId() {
		return _surveyResponse.getWriterId();
	}

	/**
	* Sets the writer ID of this survey response.
	*
	* @param writerId the writer ID of this survey response
	*/
	@Override
	public void setWriterId(long writerId) {
		_surveyResponse.setWriterId(writerId);
	}

	/**
	* Returns the response of this survey response.
	*
	* @return the response of this survey response
	*/
	@Override
	public java.lang.String getResponse() {
		return _surveyResponse.getResponse();
	}

	/**
	* Sets the response of this survey response.
	*
	* @param response the response of this survey response
	*/
	@Override
	public void setResponse(java.lang.String response) {
		_surveyResponse.setResponse(response);
	}

	/**
	* Returns the creator ID of this survey response.
	*
	* @return the creator ID of this survey response
	*/
	@Override
	public long getCreatorId() {
		return _surveyResponse.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey response.
	*
	* @param creatorId the creator ID of this survey response
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyResponse.setCreatorId(creatorId);
	}

	/**
	* Returns the create date of this survey response.
	*
	* @return the create date of this survey response
	*/
	@Override
	public long getCreateDate() {
		return _surveyResponse.getCreateDate();
	}

	/**
	* Sets the create date of this survey response.
	*
	* @param createDate the create date of this survey response
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyResponse.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _surveyResponse.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyResponse.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyResponse.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyResponse.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyResponse.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyResponse.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyResponse.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyResponse.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyResponse.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyResponse.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyResponse.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyResponseWrapper((SurveyResponse)_surveyResponse.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyResponse surveyResponse) {
		return _surveyResponse.compareTo(surveyResponse);
	}

	@Override
	public int hashCode() {
		return _surveyResponse.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyResponse> toCacheModel() {
		return _surveyResponse.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyResponse toEscapedModel() {
		return new SurveyResponseWrapper(_surveyResponse.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyResponse toUnescapedModel() {
		return new SurveyResponseWrapper(_surveyResponse.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyResponse.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyResponse.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResponse.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyResponseWrapper)) {
			return false;
		}

		SurveyResponseWrapper surveyResponseWrapper = (SurveyResponseWrapper)obj;

		if (Validator.equals(_surveyResponse,
					surveyResponseWrapper._surveyResponse)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyResponse getWrappedSurveyResponse() {
		return _surveyResponse;
	}

	@Override
	public SurveyResponse getWrappedModel() {
		return _surveyResponse;
	}

	@Override
	public void resetOriginalValues() {
		_surveyResponse.resetOriginalValues();
	}

	private SurveyResponse _surveyResponse;
}