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
 * This class is a wrapper for {@link SurveyWriteSequence}.
 * </p>
 *
 * @author kevin
 * @see SurveyWriteSequence
 * @generated
 */
public class SurveyWriteSequenceWrapper implements SurveyWriteSequence,
	ModelWrapper<SurveyWriteSequence> {
	public SurveyWriteSequenceWrapper(SurveyWriteSequence surveyWriteSequence) {
		_surveyWriteSequence = surveyWriteSequence;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyWriteSequence.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyWriteSequence.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyWriteSequenceId", getSurveyWriteSequenceId());
		attributes.put("surveyWriterId", getSurveyWriterId());
		attributes.put("pageId", getPageId());
		attributes.put("prePageId", getPrePageId());
		attributes.put("isDirect", getIsDirect());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyWriteSequenceId = (Long)attributes.get(
				"surveyWriteSequenceId");

		if (surveyWriteSequenceId != null) {
			setSurveyWriteSequenceId(surveyWriteSequenceId);
		}

		Long surveyWriterId = (Long)attributes.get("surveyWriterId");

		if (surveyWriterId != null) {
			setSurveyWriterId(surveyWriterId);
		}

		Long pageId = (Long)attributes.get("pageId");

		if (pageId != null) {
			setPageId(pageId);
		}

		Long prePageId = (Long)attributes.get("prePageId");

		if (prePageId != null) {
			setPrePageId(prePageId);
		}

		Boolean isDirect = (Boolean)attributes.get("isDirect");

		if (isDirect != null) {
			setIsDirect(isDirect);
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
	* Returns the primary key of this survey write sequence.
	*
	* @return the primary key of this survey write sequence
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyWriteSequence.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey write sequence.
	*
	* @param primaryKey the primary key of this survey write sequence
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyWriteSequence.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey write sequence ID of this survey write sequence.
	*
	* @return the survey write sequence ID of this survey write sequence
	*/
	@Override
	public long getSurveyWriteSequenceId() {
		return _surveyWriteSequence.getSurveyWriteSequenceId();
	}

	/**
	* Sets the survey write sequence ID of this survey write sequence.
	*
	* @param surveyWriteSequenceId the survey write sequence ID of this survey write sequence
	*/
	@Override
	public void setSurveyWriteSequenceId(long surveyWriteSequenceId) {
		_surveyWriteSequence.setSurveyWriteSequenceId(surveyWriteSequenceId);
	}

	/**
	* Returns the survey writer ID of this survey write sequence.
	*
	* @return the survey writer ID of this survey write sequence
	*/
	@Override
	public long getSurveyWriterId() {
		return _surveyWriteSequence.getSurveyWriterId();
	}

	/**
	* Sets the survey writer ID of this survey write sequence.
	*
	* @param surveyWriterId the survey writer ID of this survey write sequence
	*/
	@Override
	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriteSequence.setSurveyWriterId(surveyWriterId);
	}

	/**
	* Returns the page ID of this survey write sequence.
	*
	* @return the page ID of this survey write sequence
	*/
	@Override
	public long getPageId() {
		return _surveyWriteSequence.getPageId();
	}

	/**
	* Sets the page ID of this survey write sequence.
	*
	* @param pageId the page ID of this survey write sequence
	*/
	@Override
	public void setPageId(long pageId) {
		_surveyWriteSequence.setPageId(pageId);
	}

	/**
	* Returns the pre page ID of this survey write sequence.
	*
	* @return the pre page ID of this survey write sequence
	*/
	@Override
	public long getPrePageId() {
		return _surveyWriteSequence.getPrePageId();
	}

	/**
	* Sets the pre page ID of this survey write sequence.
	*
	* @param prePageId the pre page ID of this survey write sequence
	*/
	@Override
	public void setPrePageId(long prePageId) {
		_surveyWriteSequence.setPrePageId(prePageId);
	}

	/**
	* Returns the is direct of this survey write sequence.
	*
	* @return the is direct of this survey write sequence
	*/
	@Override
	public java.lang.Boolean getIsDirect() {
		return _surveyWriteSequence.getIsDirect();
	}

	/**
	* Sets the is direct of this survey write sequence.
	*
	* @param isDirect the is direct of this survey write sequence
	*/
	@Override
	public void setIsDirect(java.lang.Boolean isDirect) {
		_surveyWriteSequence.setIsDirect(isDirect);
	}

	/**
	* Returns the creator ID of this survey write sequence.
	*
	* @return the creator ID of this survey write sequence
	*/
	@Override
	public long getCreatorId() {
		return _surveyWriteSequence.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey write sequence.
	*
	* @param creatorId the creator ID of this survey write sequence
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyWriteSequence.setCreatorId(creatorId);
	}

	/**
	* Returns the create date of this survey write sequence.
	*
	* @return the create date of this survey write sequence
	*/
	@Override
	public long getCreateDate() {
		return _surveyWriteSequence.getCreateDate();
	}

	/**
	* Sets the create date of this survey write sequence.
	*
	* @param createDate the create date of this survey write sequence
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyWriteSequence.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _surveyWriteSequence.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyWriteSequence.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyWriteSequence.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyWriteSequence.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyWriteSequence.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyWriteSequence.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyWriteSequence.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyWriteSequence.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyWriteSequence.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyWriteSequence.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyWriteSequence.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyWriteSequenceWrapper((SurveyWriteSequence)_surveyWriteSequence.clone());
	}

	@Override
	public int compareTo(
		com.lc.survey.model.SurveyWriteSequence surveyWriteSequence) {
		return _surveyWriteSequence.compareTo(surveyWriteSequence);
	}

	@Override
	public int hashCode() {
		return _surveyWriteSequence.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyWriteSequence> toCacheModel() {
		return _surveyWriteSequence.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyWriteSequence toEscapedModel() {
		return new SurveyWriteSequenceWrapper(_surveyWriteSequence.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyWriteSequence toUnescapedModel() {
		return new SurveyWriteSequenceWrapper(_surveyWriteSequence.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyWriteSequence.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyWriteSequence.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyWriteSequence.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyWriteSequenceWrapper)) {
			return false;
		}

		SurveyWriteSequenceWrapper surveyWriteSequenceWrapper = (SurveyWriteSequenceWrapper)obj;

		if (Validator.equals(_surveyWriteSequence,
					surveyWriteSequenceWrapper._surveyWriteSequence)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyWriteSequence getWrappedSurveyWriteSequence() {
		return _surveyWriteSequence;
	}

	@Override
	public SurveyWriteSequence getWrappedModel() {
		return _surveyWriteSequence;
	}

	@Override
	public void resetOriginalValues() {
		_surveyWriteSequence.resetOriginalValues();
	}

	private SurveyWriteSequence _surveyWriteSequence;
}