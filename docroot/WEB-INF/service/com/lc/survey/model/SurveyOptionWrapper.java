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
 * This class is a wrapper for {@link SurveyOption}.
 * </p>
 *
 * @author kevin
 * @see SurveyOption
 * @generated
 */
public class SurveyOptionWrapper implements SurveyOption,
	ModelWrapper<SurveyOption> {
	public SurveyOptionWrapper(SurveyOption surveyOption) {
		_surveyOption = surveyOption;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyOption.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyOptionId", getSurveyOptionId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("surveyPageId", getSurveyPageId());
		attributes.put("surveyQuestionId", getSurveyQuestionId());
		attributes.put("no", getNo());
		attributes.put("option", getOption());
		attributes.put("isAns", getIsAns());
		attributes.put("pageDirectId", getPageDirectId());
		attributes.put("uploadFileId", getUploadFileId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("modifierId", getModifierId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyOptionId = (Long)attributes.get("surveyOptionId");

		if (surveyOptionId != null) {
			setSurveyOptionId(surveyOptionId);
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

		Integer no = (Integer)attributes.get("no");

		if (no != null) {
			setNo(no);
		}

		String option = (String)attributes.get("option");

		if (option != null) {
			setOption(option);
		}

		Boolean isAns = (Boolean)attributes.get("isAns");

		if (isAns != null) {
			setIsAns(isAns);
		}

		Long pageDirectId = (Long)attributes.get("pageDirectId");

		if (pageDirectId != null) {
			setPageDirectId(pageDirectId);
		}

		Long uploadFileId = (Long)attributes.get("uploadFileId");

		if (uploadFileId != null) {
			setUploadFileId(uploadFileId);
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
	* Returns the primary key of this survey option.
	*
	* @return the primary key of this survey option
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey option.
	*
	* @param primaryKey the primary key of this survey option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey option ID of this survey option.
	*
	* @return the survey option ID of this survey option
	*/
	@Override
	public long getSurveyOptionId() {
		return _surveyOption.getSurveyOptionId();
	}

	/**
	* Sets the survey option ID of this survey option.
	*
	* @param surveyOptionId the survey option ID of this survey option
	*/
	@Override
	public void setSurveyOptionId(long surveyOptionId) {
		_surveyOption.setSurveyOptionId(surveyOptionId);
	}

	/**
	* Returns the survey main ID of this survey option.
	*
	* @return the survey main ID of this survey option
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyOption.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey option.
	*
	* @param surveyMainId the survey main ID of this survey option
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyOption.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the survey page ID of this survey option.
	*
	* @return the survey page ID of this survey option
	*/
	@Override
	public long getSurveyPageId() {
		return _surveyOption.getSurveyPageId();
	}

	/**
	* Sets the survey page ID of this survey option.
	*
	* @param surveyPageId the survey page ID of this survey option
	*/
	@Override
	public void setSurveyPageId(long surveyPageId) {
		_surveyOption.setSurveyPageId(surveyPageId);
	}

	/**
	* Returns the survey question ID of this survey option.
	*
	* @return the survey question ID of this survey option
	*/
	@Override
	public long getSurveyQuestionId() {
		return _surveyOption.getSurveyQuestionId();
	}

	/**
	* Sets the survey question ID of this survey option.
	*
	* @param surveyQuestionId the survey question ID of this survey option
	*/
	@Override
	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyOption.setSurveyQuestionId(surveyQuestionId);
	}

	/**
	* Returns the no of this survey option.
	*
	* @return the no of this survey option
	*/
	@Override
	public int getNo() {
		return _surveyOption.getNo();
	}

	/**
	* Sets the no of this survey option.
	*
	* @param no the no of this survey option
	*/
	@Override
	public void setNo(int no) {
		_surveyOption.setNo(no);
	}

	/**
	* Returns the option of this survey option.
	*
	* @return the option of this survey option
	*/
	@Override
	public java.lang.String getOption() {
		return _surveyOption.getOption();
	}

	/**
	* Sets the option of this survey option.
	*
	* @param option the option of this survey option
	*/
	@Override
	public void setOption(java.lang.String option) {
		_surveyOption.setOption(option);
	}

	/**
	* Returns the is ans of this survey option.
	*
	* @return the is ans of this survey option
	*/
	@Override
	public java.lang.Boolean getIsAns() {
		return _surveyOption.getIsAns();
	}

	/**
	* Sets the is ans of this survey option.
	*
	* @param isAns the is ans of this survey option
	*/
	@Override
	public void setIsAns(java.lang.Boolean isAns) {
		_surveyOption.setIsAns(isAns);
	}

	/**
	* Returns the page direct ID of this survey option.
	*
	* @return the page direct ID of this survey option
	*/
	@Override
	public long getPageDirectId() {
		return _surveyOption.getPageDirectId();
	}

	/**
	* Sets the page direct ID of this survey option.
	*
	* @param pageDirectId the page direct ID of this survey option
	*/
	@Override
	public void setPageDirectId(long pageDirectId) {
		_surveyOption.setPageDirectId(pageDirectId);
	}

	/**
	* Returns the upload file ID of this survey option.
	*
	* @return the upload file ID of this survey option
	*/
	@Override
	public long getUploadFileId() {
		return _surveyOption.getUploadFileId();
	}

	/**
	* Sets the upload file ID of this survey option.
	*
	* @param uploadFileId the upload file ID of this survey option
	*/
	@Override
	public void setUploadFileId(long uploadFileId) {
		_surveyOption.setUploadFileId(uploadFileId);
	}

	/**
	* Returns the creator ID of this survey option.
	*
	* @return the creator ID of this survey option
	*/
	@Override
	public long getCreatorId() {
		return _surveyOption.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey option.
	*
	* @param creatorId the creator ID of this survey option
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyOption.setCreatorId(creatorId);
	}

	/**
	* Returns the modifier ID of this survey option.
	*
	* @return the modifier ID of this survey option
	*/
	@Override
	public long getModifierId() {
		return _surveyOption.getModifierId();
	}

	/**
	* Sets the modifier ID of this survey option.
	*
	* @param modifierId the modifier ID of this survey option
	*/
	@Override
	public void setModifierId(long modifierId) {
		_surveyOption.setModifierId(modifierId);
	}

	/**
	* Returns the create date of this survey option.
	*
	* @return the create date of this survey option
	*/
	@Override
	public long getCreateDate() {
		return _surveyOption.getCreateDate();
	}

	/**
	* Sets the create date of this survey option.
	*
	* @param createDate the create date of this survey option
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyOption.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this survey option.
	*
	* @return the modified date of this survey option
	*/
	@Override
	public long getModifiedDate() {
		return _surveyOption.getModifiedDate();
	}

	/**
	* Sets the modified date of this survey option.
	*
	* @param modifiedDate the modified date of this survey option
	*/
	@Override
	public void setModifiedDate(long modifiedDate) {
		_surveyOption.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _surveyOption.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyOption.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyOption.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyOption.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyOption.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyOption.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyOption.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyOption.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyOption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyOption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyOptionWrapper((SurveyOption)_surveyOption.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyOption surveyOption) {
		return _surveyOption.compareTo(surveyOption);
	}

	@Override
	public int hashCode() {
		return _surveyOption.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyOption> toCacheModel() {
		return _surveyOption.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyOption toEscapedModel() {
		return new SurveyOptionWrapper(_surveyOption.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyOption toUnescapedModel() {
		return new SurveyOptionWrapper(_surveyOption.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyOption.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyOption.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyOption.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyOptionWrapper)) {
			return false;
		}

		SurveyOptionWrapper surveyOptionWrapper = (SurveyOptionWrapper)obj;

		if (Validator.equals(_surveyOption, surveyOptionWrapper._surveyOption)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyOption getWrappedSurveyOption() {
		return _surveyOption;
	}

	@Override
	public SurveyOption getWrappedModel() {
		return _surveyOption;
	}

	@Override
	public void resetOriginalValues() {
		_surveyOption.resetOriginalValues();
	}

	private SurveyOption _surveyOption;
}