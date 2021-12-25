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
 * This class is a wrapper for {@link SurveyPage}.
 * </p>
 *
 * @author kevin
 * @see SurveyPage
 * @generated
 */
public class SurveyPageWrapper implements SurveyPage, ModelWrapper<SurveyPage> {
	public SurveyPageWrapper(SurveyPage surveyPage) {
		_surveyPage = surveyPage;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyPage.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyPage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyPageId", getSurveyPageId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("no", getNo());
		attributes.put("title", getTitle());
		attributes.put("pageDirectId", getPageDirectId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("modifierId", getModifierId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyPageId = (Long)attributes.get("surveyPageId");

		if (surveyPageId != null) {
			setSurveyPageId(surveyPageId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		Integer no = (Integer)attributes.get("no");

		if (no != null) {
			setNo(no);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long pageDirectId = (Long)attributes.get("pageDirectId");

		if (pageDirectId != null) {
			setPageDirectId(pageDirectId);
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
	* Returns the primary key of this survey page.
	*
	* @return the primary key of this survey page
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyPage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey page.
	*
	* @param primaryKey the primary key of this survey page
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyPage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey page ID of this survey page.
	*
	* @return the survey page ID of this survey page
	*/
	@Override
	public long getSurveyPageId() {
		return _surveyPage.getSurveyPageId();
	}

	/**
	* Sets the survey page ID of this survey page.
	*
	* @param surveyPageId the survey page ID of this survey page
	*/
	@Override
	public void setSurveyPageId(long surveyPageId) {
		_surveyPage.setSurveyPageId(surveyPageId);
	}

	/**
	* Returns the survey main ID of this survey page.
	*
	* @return the survey main ID of this survey page
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyPage.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey page.
	*
	* @param surveyMainId the survey main ID of this survey page
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyPage.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the no of this survey page.
	*
	* @return the no of this survey page
	*/
	@Override
	public int getNo() {
		return _surveyPage.getNo();
	}

	/**
	* Sets the no of this survey page.
	*
	* @param no the no of this survey page
	*/
	@Override
	public void setNo(int no) {
		_surveyPage.setNo(no);
	}

	/**
	* Returns the title of this survey page.
	*
	* @return the title of this survey page
	*/
	@Override
	public java.lang.String getTitle() {
		return _surveyPage.getTitle();
	}

	/**
	* Sets the title of this survey page.
	*
	* @param title the title of this survey page
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_surveyPage.setTitle(title);
	}

	/**
	* Returns the page direct ID of this survey page.
	*
	* @return the page direct ID of this survey page
	*/
	@Override
	public long getPageDirectId() {
		return _surveyPage.getPageDirectId();
	}

	/**
	* Sets the page direct ID of this survey page.
	*
	* @param pageDirectId the page direct ID of this survey page
	*/
	@Override
	public void setPageDirectId(long pageDirectId) {
		_surveyPage.setPageDirectId(pageDirectId);
	}

	/**
	* Returns the creator ID of this survey page.
	*
	* @return the creator ID of this survey page
	*/
	@Override
	public long getCreatorId() {
		return _surveyPage.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey page.
	*
	* @param creatorId the creator ID of this survey page
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyPage.setCreatorId(creatorId);
	}

	/**
	* Returns the modifier ID of this survey page.
	*
	* @return the modifier ID of this survey page
	*/
	@Override
	public long getModifierId() {
		return _surveyPage.getModifierId();
	}

	/**
	* Sets the modifier ID of this survey page.
	*
	* @param modifierId the modifier ID of this survey page
	*/
	@Override
	public void setModifierId(long modifierId) {
		_surveyPage.setModifierId(modifierId);
	}

	/**
	* Returns the create date of this survey page.
	*
	* @return the create date of this survey page
	*/
	@Override
	public long getCreateDate() {
		return _surveyPage.getCreateDate();
	}

	/**
	* Sets the create date of this survey page.
	*
	* @param createDate the create date of this survey page
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyPage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this survey page.
	*
	* @return the modified date of this survey page
	*/
	@Override
	public long getModifiedDate() {
		return _surveyPage.getModifiedDate();
	}

	/**
	* Sets the modified date of this survey page.
	*
	* @param modifiedDate the modified date of this survey page
	*/
	@Override
	public void setModifiedDate(long modifiedDate) {
		_surveyPage.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _surveyPage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyPage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyPage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyPage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyPage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyPage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyPage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyPage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyPage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyPage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyPage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyPageWrapper((SurveyPage)_surveyPage.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyPage surveyPage) {
		return _surveyPage.compareTo(surveyPage);
	}

	@Override
	public int hashCode() {
		return _surveyPage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyPage> toCacheModel() {
		return _surveyPage.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyPage toEscapedModel() {
		return new SurveyPageWrapper(_surveyPage.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyPage toUnescapedModel() {
		return new SurveyPageWrapper(_surveyPage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyPage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyPage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyPage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyPageWrapper)) {
			return false;
		}

		SurveyPageWrapper surveyPageWrapper = (SurveyPageWrapper)obj;

		if (Validator.equals(_surveyPage, surveyPageWrapper._surveyPage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyPage getWrappedSurveyPage() {
		return _surveyPage;
	}

	@Override
	public SurveyPage getWrappedModel() {
		return _surveyPage;
	}

	@Override
	public void resetOriginalValues() {
		_surveyPage.resetOriginalValues();
	}

	private SurveyPage _surveyPage;
}