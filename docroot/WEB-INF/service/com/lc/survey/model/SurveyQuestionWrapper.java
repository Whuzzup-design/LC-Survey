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
 * This class is a wrapper for {@link SurveyQuestion}.
 * </p>
 *
 * @author kevin
 * @see SurveyQuestion
 * @generated
 */
public class SurveyQuestionWrapper implements SurveyQuestion,
	ModelWrapper<SurveyQuestion> {
	public SurveyQuestionWrapper(SurveyQuestion surveyQuestion) {
		_surveyQuestion = surveyQuestion;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyQuestion.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyQuestion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyQuestionId", getSurveyQuestionId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("surveyPageId", getSurveyPageId());
		attributes.put("parentId", getParentId());
		attributes.put("no", getNo());
		attributes.put("question", getQuestion());
		attributes.put("type", getType());
		attributes.put("isRequired", getIsRequired());
		attributes.put("hasOther", getHasOther());
		attributes.put("optionDirect", getOptionDirect());
		attributes.put("points", getPoints());
		attributes.put("starsCount", getStarsCount());
		attributes.put("uploadFileId", getUploadFileId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("modifierId", getModifierId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyQuestionId = (Long)attributes.get("surveyQuestionId");

		if (surveyQuestionId != null) {
			setSurveyQuestionId(surveyQuestionId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		Long surveyPageId = (Long)attributes.get("surveyPageId");

		if (surveyPageId != null) {
			setSurveyPageId(surveyPageId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Integer no = (Integer)attributes.get("no");

		if (no != null) {
			setNo(no);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean isRequired = (Boolean)attributes.get("isRequired");

		if (isRequired != null) {
			setIsRequired(isRequired);
		}

		Boolean hasOther = (Boolean)attributes.get("hasOther");

		if (hasOther != null) {
			setHasOther(hasOther);
		}

		Boolean optionDirect = (Boolean)attributes.get("optionDirect");

		if (optionDirect != null) {
			setOptionDirect(optionDirect);
		}

		String points = (String)attributes.get("points");

		if (points != null) {
			setPoints(points);
		}

		Integer starsCount = (Integer)attributes.get("starsCount");

		if (starsCount != null) {
			setStarsCount(starsCount);
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
	* Returns the primary key of this survey question.
	*
	* @return the primary key of this survey question
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyQuestion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey question.
	*
	* @param primaryKey the primary key of this survey question
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyQuestion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey question ID of this survey question.
	*
	* @return the survey question ID of this survey question
	*/
	@Override
	public long getSurveyQuestionId() {
		return _surveyQuestion.getSurveyQuestionId();
	}

	/**
	* Sets the survey question ID of this survey question.
	*
	* @param surveyQuestionId the survey question ID of this survey question
	*/
	@Override
	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyQuestion.setSurveyQuestionId(surveyQuestionId);
	}

	/**
	* Returns the survey main ID of this survey question.
	*
	* @return the survey main ID of this survey question
	*/
	@Override
	public long getSurveyMainId() {
		return _surveyQuestion.getSurveyMainId();
	}

	/**
	* Sets the survey main ID of this survey question.
	*
	* @param surveyMainId the survey main ID of this survey question
	*/
	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyQuestion.setSurveyMainId(surveyMainId);
	}

	/**
	* Returns the survey page ID of this survey question.
	*
	* @return the survey page ID of this survey question
	*/
	@Override
	public long getSurveyPageId() {
		return _surveyQuestion.getSurveyPageId();
	}

	/**
	* Sets the survey page ID of this survey question.
	*
	* @param surveyPageId the survey page ID of this survey question
	*/
	@Override
	public void setSurveyPageId(long surveyPageId) {
		_surveyQuestion.setSurveyPageId(surveyPageId);
	}

	/**
	* Returns the parent ID of this survey question.
	*
	* @return the parent ID of this survey question
	*/
	@Override
	public long getParentId() {
		return _surveyQuestion.getParentId();
	}

	/**
	* Sets the parent ID of this survey question.
	*
	* @param parentId the parent ID of this survey question
	*/
	@Override
	public void setParentId(long parentId) {
		_surveyQuestion.setParentId(parentId);
	}

	/**
	* Returns the no of this survey question.
	*
	* @return the no of this survey question
	*/
	@Override
	public int getNo() {
		return _surveyQuestion.getNo();
	}

	/**
	* Sets the no of this survey question.
	*
	* @param no the no of this survey question
	*/
	@Override
	public void setNo(int no) {
		_surveyQuestion.setNo(no);
	}

	/**
	* Returns the question of this survey question.
	*
	* @return the question of this survey question
	*/
	@Override
	public java.lang.String getQuestion() {
		return _surveyQuestion.getQuestion();
	}

	/**
	* Sets the question of this survey question.
	*
	* @param question the question of this survey question
	*/
	@Override
	public void setQuestion(java.lang.String question) {
		_surveyQuestion.setQuestion(question);
	}

	/**
	* Returns the type of this survey question.
	*
	* @return the type of this survey question
	*/
	@Override
	public java.lang.String getType() {
		return _surveyQuestion.getType();
	}

	/**
	* Sets the type of this survey question.
	*
	* @param type the type of this survey question
	*/
	@Override
	public void setType(java.lang.String type) {
		_surveyQuestion.setType(type);
	}

	/**
	* Returns the is required of this survey question.
	*
	* @return the is required of this survey question
	*/
	@Override
	public java.lang.Boolean getIsRequired() {
		return _surveyQuestion.getIsRequired();
	}

	/**
	* Sets the is required of this survey question.
	*
	* @param isRequired the is required of this survey question
	*/
	@Override
	public void setIsRequired(java.lang.Boolean isRequired) {
		_surveyQuestion.setIsRequired(isRequired);
	}

	/**
	* Returns the has other of this survey question.
	*
	* @return the has other of this survey question
	*/
	@Override
	public java.lang.Boolean getHasOther() {
		return _surveyQuestion.getHasOther();
	}

	/**
	* Sets the has other of this survey question.
	*
	* @param hasOther the has other of this survey question
	*/
	@Override
	public void setHasOther(java.lang.Boolean hasOther) {
		_surveyQuestion.setHasOther(hasOther);
	}

	/**
	* Returns the option direct of this survey question.
	*
	* @return the option direct of this survey question
	*/
	@Override
	public java.lang.Boolean getOptionDirect() {
		return _surveyQuestion.getOptionDirect();
	}

	/**
	* Sets the option direct of this survey question.
	*
	* @param optionDirect the option direct of this survey question
	*/
	@Override
	public void setOptionDirect(java.lang.Boolean optionDirect) {
		_surveyQuestion.setOptionDirect(optionDirect);
	}

	/**
	* Returns the points of this survey question.
	*
	* @return the points of this survey question
	*/
	@Override
	public java.lang.String getPoints() {
		return _surveyQuestion.getPoints();
	}

	/**
	* Sets the points of this survey question.
	*
	* @param points the points of this survey question
	*/
	@Override
	public void setPoints(java.lang.String points) {
		_surveyQuestion.setPoints(points);
	}

	/**
	* Returns the stars count of this survey question.
	*
	* @return the stars count of this survey question
	*/
	@Override
	public int getStarsCount() {
		return _surveyQuestion.getStarsCount();
	}

	/**
	* Sets the stars count of this survey question.
	*
	* @param starsCount the stars count of this survey question
	*/
	@Override
	public void setStarsCount(int starsCount) {
		_surveyQuestion.setStarsCount(starsCount);
	}

	/**
	* Returns the upload file ID of this survey question.
	*
	* @return the upload file ID of this survey question
	*/
	@Override
	public long getUploadFileId() {
		return _surveyQuestion.getUploadFileId();
	}

	/**
	* Sets the upload file ID of this survey question.
	*
	* @param uploadFileId the upload file ID of this survey question
	*/
	@Override
	public void setUploadFileId(long uploadFileId) {
		_surveyQuestion.setUploadFileId(uploadFileId);
	}

	/**
	* Returns the creator ID of this survey question.
	*
	* @return the creator ID of this survey question
	*/
	@Override
	public long getCreatorId() {
		return _surveyQuestion.getCreatorId();
	}

	/**
	* Sets the creator ID of this survey question.
	*
	* @param creatorId the creator ID of this survey question
	*/
	@Override
	public void setCreatorId(long creatorId) {
		_surveyQuestion.setCreatorId(creatorId);
	}

	/**
	* Returns the modifier ID of this survey question.
	*
	* @return the modifier ID of this survey question
	*/
	@Override
	public long getModifierId() {
		return _surveyQuestion.getModifierId();
	}

	/**
	* Sets the modifier ID of this survey question.
	*
	* @param modifierId the modifier ID of this survey question
	*/
	@Override
	public void setModifierId(long modifierId) {
		_surveyQuestion.setModifierId(modifierId);
	}

	/**
	* Returns the create date of this survey question.
	*
	* @return the create date of this survey question
	*/
	@Override
	public long getCreateDate() {
		return _surveyQuestion.getCreateDate();
	}

	/**
	* Sets the create date of this survey question.
	*
	* @param createDate the create date of this survey question
	*/
	@Override
	public void setCreateDate(long createDate) {
		_surveyQuestion.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this survey question.
	*
	* @return the modified date of this survey question
	*/
	@Override
	public long getModifiedDate() {
		return _surveyQuestion.getModifiedDate();
	}

	/**
	* Sets the modified date of this survey question.
	*
	* @param modifiedDate the modified date of this survey question
	*/
	@Override
	public void setModifiedDate(long modifiedDate) {
		_surveyQuestion.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _surveyQuestion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyQuestion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyQuestion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyQuestion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyQuestion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyQuestion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyQuestion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyQuestion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyQuestion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyQuestion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyQuestion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyQuestionWrapper((SurveyQuestion)_surveyQuestion.clone());
	}

	@Override
	public int compareTo(com.lc.survey.model.SurveyQuestion surveyQuestion) {
		return _surveyQuestion.compareTo(surveyQuestion);
	}

	@Override
	public int hashCode() {
		return _surveyQuestion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lc.survey.model.SurveyQuestion> toCacheModel() {
		return _surveyQuestion.toCacheModel();
	}

	@Override
	public com.lc.survey.model.SurveyQuestion toEscapedModel() {
		return new SurveyQuestionWrapper(_surveyQuestion.toEscapedModel());
	}

	@Override
	public com.lc.survey.model.SurveyQuestion toUnescapedModel() {
		return new SurveyQuestionWrapper(_surveyQuestion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyQuestion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyQuestion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyQuestionWrapper)) {
			return false;
		}

		SurveyQuestionWrapper surveyQuestionWrapper = (SurveyQuestionWrapper)obj;

		if (Validator.equals(_surveyQuestion,
					surveyQuestionWrapper._surveyQuestion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyQuestion getWrappedSurveyQuestion() {
		return _surveyQuestion;
	}

	@Override
	public SurveyQuestion getWrappedModel() {
		return _surveyQuestion;
	}

	@Override
	public void resetOriginalValues() {
		_surveyQuestion.resetOriginalValues();
	}

	private SurveyQuestion _surveyQuestion;
}