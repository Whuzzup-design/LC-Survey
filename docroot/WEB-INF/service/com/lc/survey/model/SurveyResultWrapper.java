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
 * This class is a wrapper for {@link SurveyResult}.
 * </p>
 *
 * @author kevin
 * @see SurveyResult
 * @generated
 */
public class SurveyResultWrapper implements SurveyResult,
	ModelWrapper<SurveyResult> {
	public SurveyResultWrapper(SurveyResult surveyResult) {
		_surveyResult = surveyResult;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyResult.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyResultId", getSurveyResultId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("surveyPageId", getSurveyPageId());
		attributes.put("surveyQuestionId", getSurveyQuestionId());
		attributes.put("surveyOptionId", getSurveyOptionId());
		attributes.put("surveyWriterId", getSurveyWriterId());
		attributes.put("ans", getAns());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyResultId = (Long)attributes.get("surveyResultId");

		if (surveyResultId != null) {
			setSurveyResultId(surveyResultId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		Long surveyPageId = (Long)attributes.get("surveyPageId");

		if (surveyPageId != null) {
			setSurveyPageId(surveyPageId);
		}

		Long surveyQuestionId = (Long)attributes.get("surveyQuestionId");

		if (surveyQuestionId != null) {
			setSurveyQuestionId(surveyQuestionId);
		}

		Long surveyOptionId = (Long)attributes.get("surveyOptionId");

		if (surveyOptionId != null) {
			setSurveyOptionId(surveyOptionId);
		}

		Long surveyWriterId = (Long)attributes.get("surveyWriterId");

		if (surveyWriterId != null) {
			setSurveyWriterId(surveyWriterId);
		}

		String ans = (String)attributes.get("ans");

		if (ans != null) {
			setAns(ans);
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
	* Returns the primary key of this survey result.
	*
	* @return the primary key of this survey result
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyResult.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey result.
	*
	* @param primaryKey the primary key of this survey result
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyResult.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey result ID of this survey result.
	*
	* @return the survey result ID of this survey result
	*/
	@Override
	public long getSurveyResultId() {
		return _surveyResult.getSurveyResultId();
	}

	/**
	* Sets the survey result ID of this survey result.
	*
	* @param surveyResultId the survey result ID of this survey result
	*/
	@Override
	public void setSurveyResultId(long surveyResultId) {
		_surveyResult.setSurveyResultId(surveyResultId);
	}

	/**
	* Returns the survey main ID of this survey result.
	*
	* @return the survey main ID of this survey result
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyResult.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey result.
	*
	* @param surveyMainId the survey main ID of this survey result
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyResult.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the survey page ID of this survey result.
	*
	* @return the survey page ID of this survey result
	*/
	@Override
	public long getSurveyPageId() {
		return _surveyResult.getSurveyPageId();
	}

	/**
	* Sets the survey page ID of this survey result.
	*
	* @param surveyPageId the survey page ID of this survey result
	*/
	@Override
	public void setSurveyPageId(long surveyPageId) {
		_surveyResult.setSurveyPageId(surveyPageId);
	}

	/**
	* Returns the survey question ID of this survey result.
	*
	* @return the survey question ID of this survey result
	*/
	@Override
	public long getSurveyQuestionId() {
		return _surveyResult.getSurveyQuestionId();
	}

	/**
	* Sets the survey question ID of this survey result.
	*
	* @param surveyQuestionId the survey question ID of this survey result
	*/
	@Override
	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyResult.setSurveyQuestionId(surveyQuestionId);
	}

	/**
	* Returns the survey option ID of this survey result.
	*
	* @return the survey option ID of this survey result
	*/
	@Override
	public long getSurveyOptionId() {
		return _surveyResult.getSurveyOptionId();
	}

	/**
	* Sets the survey option ID of this survey result.
	*
	* @param surveyOptionId the survey option ID of this survey result
	*/
	@Override
	public void setSurveyOptionId(long surveyOptionId) {
		_surveyResult.setSurveyOptionId(surveyOptionId);
	}

	/**
	* Returns the survey writer ID of this survey result.
	*
	* @return the survey writer ID of this survey result
	*/
	@Override
	public long getSurveyWriterId() {
		return _surveyResult.getSurveyWriterId();
	}

	/**
	* Sets the survey writer ID of this survey result.
	*
	* @param surveyWriterId the survey writer ID of this survey result
	*/
	@Override
	public void setSurveyWriterId(long surveyWriterId) {
		_surveyResult.setSurveyWriterId(surveyWriterId);
	}

	/**
	* Returns the ans of this survey result.
	*
	* @return the ans of this survey result
	*/
	@Override
	public java.lang.String getAns() {
		return _surveyResult.getAns();
	}

	/**
	* Sets the ans of this survey result.
	*
	* @param ans the ans of this survey result
	*/
	@Override
	public void setAns(java.lang.String ans) {
		_surveyResult.setAns(ans);
	}

	/**
	* Returns the creator ID of this survey result.
	*
	* @return the creator ID of this survey result
	*/
	@Override
	public long getCreatorId() {
		return _surveyResult.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey result.
	*
	* @param creatorId the creator ID of this survey result
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyResult.setCreatorId(creatorId);
	}

	/**
	* Returns the create date of this survey result.
	*
	* @return the create date of this survey result
	*/
	@Override
	public long getCreateDate() {
		return _surveyResult.getCreateDate();
	}

	/**
	* Sets the create date of this survey result.
	*
	* @param createDate the create date of this survey result
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyResult.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _surveyResult.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyResult.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyResult.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyResult.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyResult.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyResult.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyResult.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyResult.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyResult.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyResult.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyResult.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyResultWrapper((SurveyResult)_surveyResult.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyResult surveyResult) {
		return _surveyResult.compareTo(surveyResult);
	}

	@Override
	public int hashCode() {
		return _surveyResult.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyResult> toCacheModel() {
		return _surveyResult.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyResult toEscapedModel() {
		return new SurveyResultWrapper(_surveyResult.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyResult toUnescapedModel() {
		return new SurveyResultWrapper(_surveyResult.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyResult.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyResult.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResult.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyResultWrapper)) {
			return false;
		}

		SurveyResultWrapper surveyResultWrapper = (SurveyResultWrapper)obj;

		if (Validator.equals(_surveyResult, surveyResultWrapper._surveyResult)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyResult getWrappedSurveyResult() {
		return _surveyResult;
	}

	@Override
	public SurveyResult getWrappedModel() {
		return _surveyResult;
	}

	@Override
	public void resetOriginalValues() {
		_surveyResult.resetOriginalValues();
	}

	private SurveyResult _surveyResult;
}