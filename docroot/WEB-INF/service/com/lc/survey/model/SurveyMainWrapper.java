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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SurveyMain}.
 * </p>
 *
 * @author kevin
 * @see SurveyMain
 * @generated
 */
public class SurveyMainWrapper implements SurveyMain, ModelWrapper<SurveyMain> {
	public SurveyMainWrapper(SurveyMain surveyMain) {
		_surveyMain = surveyMain;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyMain.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyMain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("epilog", getEpilog());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("needAuth", getNeedAuth());
		attributes.put("calculateScore", getCalculateScore());
		attributes.put("viewAnswer", getViewAnswer());
		attributes.put("color", getColor());
		attributes.put("creatorId", getCreatorId());
		attributes.put("modifierId", getModifierId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String epilog = (String)attributes.get("epilog");

		if (epilog != null) {
			setEpilog(epilog);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean needAuth = (Boolean)attributes.get("needAuth");

		if (needAuth != null) {
			setNeedAuth(needAuth);
		}

		Boolean calculateScore = (Boolean)attributes.get("calculateScore");

		if (calculateScore != null) {
			setCalculateScore(calculateScore);
		}

		Boolean viewAnswer = (Boolean)attributes.get("viewAnswer");

		if (viewAnswer != null) {
			setViewAnswer(viewAnswer);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long modifierId = (Long)attributes.get("modifierId");

		if (modifierId != null) {
			setModifierId(modifierId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this survey main.
	*
	* @return the primary key of this survey main
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyMain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey main.
	*
	* @param primaryKey the primary key of this survey main
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyMain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey main ID of this survey main.
	*
	* @return the survey main ID of this survey main
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyMain.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey main.
	*
	* @param surveyMainId the survey main ID of this survey main
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyMain.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the title of this survey main.
	*
	* @return the title of this survey main
	*/
	@Override
	public java.lang.String getTitle() {
		return _surveyMain.getTitle();
	}

	/**
	* Sets the title of this survey main.
	*
	* @param title the title of this survey main
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_surveyMain.setTitle(title);
	}

	/**
	* Returns the description of this survey main.
	*
	* @return the description of this survey main
	*/
	@Override
	public java.lang.String getDescription() {
		return _surveyMain.getDescription();
	}

	/**
	* Sets the description of this survey main.
	*
	* @param description the description of this survey main
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_surveyMain.setDescription(description);
	}

	/**
	* Returns the epilog of this survey main.
	*
	* @return the epilog of this survey main
	*/
	@Override
	public java.lang.String getEpilog() {
		return _surveyMain.getEpilog();
	}

	/**
	* Sets the epilog of this survey main.
	*
	* @param epilog the epilog of this survey main
	*/
	@Override
	public void setEpilog(java.lang.String epilog) {
		_surveyMain.setEpilog(epilog);
	}

	/**
	* Returns the start date of this survey main.
	*
	* @return the start date of this survey main
	*/
	@Override
	public java.util.Date getStartDate() {
		return _surveyMain.getStartDate();
	}

	/**
	* Sets the start date of this survey main.
	*
	* @param startDate the start date of this survey main
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_surveyMain.setStartDate(startDate);
	}

	/**
	* Returns the end date of this survey main.
	*
	* @return the end date of this survey main
	*/
	@Override
	public java.util.Date getEndDate() {
		return _surveyMain.getEndDate();
	}

	/**
	* Sets the end date of this survey main.
	*
	* @param endDate the end date of this survey main
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_surveyMain.setEndDate(endDate);
	}

	/**
	* Returns the need auth of this survey main.
	*
	* @return the need auth of this survey main
	*/
	@Override
	public java.lang.Boolean getNeedAuth() {
		return _surveyMain.getNeedAuth();
	}

	/**
	* Sets the need auth of this survey main.
	*
	* @param needAuth the need auth of this survey main
	*/
	@Override
	public void setNeedAuth(java.lang.Boolean needAuth) {
		_surveyMain.setNeedAuth(needAuth);
	}

	/**
	* Returns the calculate score of this survey main.
	*
	* @return the calculate score of this survey main
	*/
	@Override
	public java.lang.Boolean getCalculateScore() {
		return _surveyMain.getCalculateScore();
	}

	/**
	* Sets the calculate score of this survey main.
	*
	* @param calculateScore the calculate score of this survey main
	*/
	@Override
	public void setCalculateScore(java.lang.Boolean calculateScore) {
		_surveyMain.setCalculateScore(calculateScore);
	}

	/**
	* Returns the view answer of this survey main.
	*
	* @return the view answer of this survey main
	*/
	@Override
	public java.lang.Boolean getViewAnswer() {
		return _surveyMain.getViewAnswer();
	}

	/**
	* Sets the view answer of this survey main.
	*
	* @param viewAnswer the view answer of this survey main
	*/
	@Override
	public void setViewAnswer(java.lang.Boolean viewAnswer) {
		_surveyMain.setViewAnswer(viewAnswer);
	}

	/**
	* Returns the color of this survey main.
	*
	* @return the color of this survey main
	*/
	@Override
	public java.lang.String getColor() {
		return _surveyMain.getColor();
	}

	/**
	* Sets the color of this survey main.
	*
	* @param color the color of this survey main
	*/
	@Override
	public void setColor(java.lang.String color) {
		_surveyMain.setColor(color);
	}

	/**
	* Returns the creator ID of this survey main.
	*
	* @return the creator ID of this survey main
	*/
	@Override
	public long getCreatorId() {
		return _surveyMain.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey main.
	*
	* @param creatorId the creator ID of this survey main
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyMain.setCreatorId(creatorId);
	}

	/**
	* Returns the modifier ID of this survey main.
	*
	* @return the modifier ID of this survey main
	*/
	@Override
	public long getModifierId() {
		return _surveyMain.getModifierId();
	}

	/**
	* Sets the modifier ID of this survey main.
	*
	* @param modifierId the modifier ID of this survey main
	*/
	@Override
	public void setModifierId(long modifierId) {
		_surveyMain.setModifierId(modifierId);
	}

	/**
	* Returns the create date of this survey main.
	*
	* @return the create date of this survey main
	*/
	@Override
	public long getCreateDate() {
		return _surveyMain.getCreateDate();
	}

	/**
	* Sets the create date of this survey main.
	*
	* @param createDate the create date of this survey main
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyMain.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this survey main.
	*
	* @return the modified date of this survey main
	*/
	@Override
	public long getModifiedDate() {
		return _surveyMain.getModifiedDate();
	}

	/**
	* Sets the modified date of this survey main.
	*
	* @param modifiedDate the modified date of this survey main
	*/
	@Override
	public void setModifiedDate(long modifiedDate) {
		_surveyMain.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _surveyMain.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyMain.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyMain.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyMain.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyMain.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyMain.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyMain.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyMain.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyMain.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyMain.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyMain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyMainWrapper((SurveyMain)_surveyMain.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyMain surveyMain) {
		return _surveyMain.compareTo(surveyMain);
	}

	@Override
	public int hashCode() {
		return _surveyMain.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyMain> toCacheModel() {
		return _surveyMain.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyMain toEscapedModel() {
		return new SurveyMainWrapper(_surveyMain.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyMain toUnescapedModel() {
		return new SurveyMainWrapper(_surveyMain.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyMain.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyMain.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyMain.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyMainWrapper)) {
			return false;
		}

		SurveyMainWrapper surveyMainWrapper = (SurveyMainWrapper)obj;

		if (Validator.equals(_surveyMain, surveyMainWrapper._surveyMain)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyMain getWrappedSurveyMain() {
		return _surveyMain;
	}

	@Override
	public SurveyMain getWrappedModel() {
		return _surveyMain;
	}

	@Override
	public void resetOriginalValues() {
		_surveyMain.resetOriginalValues();
	}

	private SurveyMain _surveyMain;
}