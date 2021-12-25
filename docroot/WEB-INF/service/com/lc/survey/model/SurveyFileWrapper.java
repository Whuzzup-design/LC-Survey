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
 * This class is a wrapper for {@link SurveyFile}.
 * </p>
 *
 * @author kevin
 * @see SurveyFile
 * @generated
 */
public class SurveyFileWrapper implements SurveyFile, ModelWrapper<SurveyFile> {
	public SurveyFileWrapper(SurveyFile surveyFile) {
		_surveyFile = surveyFile;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyFile.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyFileId", getSurveyFileId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("fileName", getFileName());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyFileId = (Long)attributes.get("surveyFileId");

		if (surveyFileId != null) {
			setSurveyFileId(surveyFileId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
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
	* Returns the primary key of this survey file.
	*
	* @return the primary key of this survey file
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey file.
	*
	* @param primaryKey the primary key of this survey file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey file ID of this survey file.
	*
	* @return the survey file ID of this survey file
	*/
	@Override
	public long getSurveyFileId() {
		return _surveyFile.getSurveyFileId();
	}

	/**
	* Sets the survey file ID of this survey file.
	*
	* @param surveyFileId the survey file ID of this survey file
	*/
	@Override
	public void setSurveyFileId(long surveyFileId) {
		_surveyFile.setSurveyFileId(surveyFileId);
	}

	/**
	* Returns the survey main ID of this survey file.
	*
	* @return the survey main ID of this survey file
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyFile.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey file.
	*
	* @param surveyMainId the survey main ID of this survey file
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyFile.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the file name of this survey file.
	*
	* @return the file name of this survey file
	*/
	@Override
	public java.lang.String getFileName() {
		return _surveyFile.getFileName();
	}

	/**
	* Sets the file name of this survey file.
	*
	* @param fileName the file name of this survey file
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_surveyFile.setFileName(fileName);
	}

	/**
	* Returns the creator ID of this survey file.
	*
	* @return the creator ID of this survey file
	*/
	@Override
	public long getCreatorId() {
		return _surveyFile.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey file.
	*
	* @param creatorId the creator ID of this survey file
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyFile.setCreatorId(creatorId);
	}

	/**
	* Returns the create date of this survey file.
	*
	* @return the create date of this survey file
	*/
	@Override
	public long getCreateDate() {
		return _surveyFile.getCreateDate();
	}

	/**
	* Sets the create date of this survey file.
	*
	* @param createDate the create date of this survey file
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyFile.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _surveyFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyFileWrapper((SurveyFile)_surveyFile.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyFile surveyFile) {
		return _surveyFile.compareTo(surveyFile);
	}

	@Override
	public int hashCode() {
		return _surveyFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyFile> toCacheModel() {
		return _surveyFile.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyFile toEscapedModel() {
		return new SurveyFileWrapper(_surveyFile.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyFile toUnescapedModel() {
		return new SurveyFileWrapper(_surveyFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyFile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyFileWrapper)) {
			return false;
		}

		SurveyFileWrapper surveyFileWrapper = (SurveyFileWrapper)obj;

		if (Validator.equals(_surveyFile, surveyFileWrapper._surveyFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyFile getWrappedSurveyFile() {
		return _surveyFile;
	}

	@Override
	public SurveyFile getWrappedModel() {
		return _surveyFile;
	}

	@Override
	public void resetOriginalValues() {
		_surveyFile.resetOriginalValues();
	}

	private SurveyFile _surveyFile;
}