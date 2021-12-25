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
 * This class is a wrapper for {@link SurveyWriter}.
 * </p>
 *
 * @author kevin
 * @see SurveyWriter
 * @generated
 */
public class SurveyWriterWrapper implements SurveyWriter,
	ModelWrapper<SurveyWriter> {
	public SurveyWriterWrapper(SurveyWriter surveyWriter) {
		_surveyWriter = surveyWriter;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyWriter.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyWriter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyWriterId", getSurveyWriterId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("isPreview", getIsPreview());
		attributes.put("isComplete", getIsComplete());
		attributes.put("completionTime", getCompletionTime());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyWriterId = (Long)attributes.get("surveyWriterId");

		if (surveyWriterId != null) {
			setSurveyWriterId(surveyWriterId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		Boolean isPreview = (Boolean)attributes.get("isPreview");

		if (isPreview != null) {
			setIsPreview(isPreview);
		}

		Boolean isComplete = (Boolean)attributes.get("isComplete");

		if (isComplete != null) {
			setIsComplete(isComplete);
		}

		Long completionTime = (Long)attributes.get("completionTime");

		if (completionTime != null) {
			setCompletionTime(completionTime);
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
	* Returns the primary key of this survey writer.
	*
	* @return the primary key of this survey writer
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyWriter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey writer.
	*
	* @param primaryKey the primary key of this survey writer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyWriter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey writer ID of this survey writer.
	*
	* @return the survey writer ID of this survey writer
	*/
	@Override
	public long getSurveyWriterId() {
		return _surveyWriter.getSurveyWriterId();
	}

	/**
	* Sets the survey writer ID of this survey writer.
	*
	* @param surveyWriterId the survey writer ID of this survey writer
	*/
	@Override
	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriter.setSurveyWriterId(surveyWriterId);
	}

	/**
	* Returns the survey main ID of this survey writer.
	*
	* @return the survey main ID of this survey writer
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyWriter.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey writer.
	*
	* @param surveyMainId the survey main ID of this survey writer
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyWriter.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the is preview of this survey writer.
	*
	* @return the is preview of this survey writer
	*/
	@Override
	public java.lang.Boolean getIsPreview() {
		return _surveyWriter.getIsPreview();
	}

	/**
	* Sets the is preview of this survey writer.
	*
	* @param isPreview the is preview of this survey writer
	*/
	@Override
	public void setIsPreview(java.lang.Boolean isPreview) {
		_surveyWriter.setIsPreview(isPreview);
	}

	/**
	* Returns the is complete of this survey writer.
	*
	* @return the is complete of this survey writer
	*/
	@Override
	public java.lang.Boolean getIsComplete() {
		return _surveyWriter.getIsComplete();
	}

	/**
	* Sets the is complete of this survey writer.
	*
	* @param isComplete the is complete of this survey writer
	*/
	@Override
	public void setIsComplete(java.lang.Boolean isComplete) {
		_surveyWriter.setIsComplete(isComplete);
	}

	/**
	* Returns the completion time of this survey writer.
	*
	* @return the completion time of this survey writer
	*/
	@Override
	public long getCompletionTime() {
		return _surveyWriter.getCompletionTime();
	}

	/**
	* Sets the completion time of this survey writer.
	*
	* @param completionTime the completion time of this survey writer
	*/
	@Override
	public void setCompletionTime(long completionTime) {
		_surveyWriter.setCompletionTime(completionTime);
	}

	/**
	* Returns the creator ID of this survey writer.
	*
	* @return the creator ID of this survey writer
	*/
	@Override
	public long getCreatorId() {
		return _surveyWriter.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey writer.
	*
	* @param creatorId the creator ID of this survey writer
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyWriter.setCreatorId(creatorId);
	}

	/**
	* Returns the create date of this survey writer.
	*
	* @return the create date of this survey writer
	*/
	@Override
	public long getCreateDate() {
		return _surveyWriter.getCreateDate();
	}

	/**
	* Sets the create date of this survey writer.
	*
	* @param createDate the create date of this survey writer
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyWriter.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _surveyWriter.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyWriter.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyWriter.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyWriter.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyWriter.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyWriter.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyWriter.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyWriter.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyWriter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyWriter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyWriter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyWriterWrapper((SurveyWriter)_surveyWriter.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyWriter surveyWriter) {
		return _surveyWriter.compareTo(surveyWriter);
	}

	@Override
	public int hashCode() {
		return _surveyWriter.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyWriter> toCacheModel() {
		return _surveyWriter.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyWriter toEscapedModel() {
		return new SurveyWriterWrapper(_surveyWriter.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyWriter toUnescapedModel() {
		return new SurveyWriterWrapper(_surveyWriter.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyWriter.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyWriter.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyWriter.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyWriterWrapper)) {
			return false;
		}

		SurveyWriterWrapper surveyWriterWrapper = (SurveyWriterWrapper)obj;

		if (Validator.equals(_surveyWriter, surveyWriterWrapper._surveyWriter)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyWriter getWrappedSurveyWriter() {
		return _surveyWriter;
	}

	@Override
	public SurveyWriter getWrappedModel() {
		return _surveyWriter;
	}

	@Override
	public void resetOriginalValues() {
		_surveyWriter.resetOriginalValues();
	}

	private SurveyWriter _surveyWriter;
}