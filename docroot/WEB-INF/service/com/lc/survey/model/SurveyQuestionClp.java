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

import com.lc.survey.service.ClpSerializer;
import com.lc.survey.service.SurveyQuestionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 */
public class SurveyQuestionClp extends BaseModelImpl<SurveyQuestion>
	implements SurveyQuestion {
	public SurveyQuestionClp() {
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
	public long getPrimaryKey() {
		return _surveyQuestionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyQuestionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyQuestionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyQuestionId() {
		return _surveyQuestionId;
	}

	@Override
	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyQuestionId = surveyQuestionId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyQuestionId",
						long.class);

				method.invoke(_surveyQuestionRemoteModel, surveyQuestionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSurveyMainId() {
		return _surveyMainId;
	}

	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyQuestionRemoteModel, surveyMainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSurveyPageId() {
		return _surveyPageId;
	}

	@Override
	public void setSurveyPageId(long surveyPageId) {
		_surveyPageId = surveyPageId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyPageId", long.class);

				method.invoke(_surveyQuestionRemoteModel, surveyPageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_surveyQuestionRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNo() {
		return _no;
	}

	@Override
	public void setNo(int no) {
		_no = no;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setNo", int.class);

				method.invoke(_surveyQuestionRemoteModel, no);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestion() {
		return _question;
	}

	@Override
	public void setQuestion(String question) {
		_question = question;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion", String.class);

				method.invoke(_surveyQuestionRemoteModel, question);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_surveyQuestionRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIsRequired() {
		return _isRequired;
	}

	@Override
	public void setIsRequired(Boolean isRequired) {
		_isRequired = isRequired;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsRequired", Boolean.class);

				method.invoke(_surveyQuestionRemoteModel, isRequired);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getHasOther() {
		return _hasOther;
	}

	@Override
	public void setHasOther(Boolean hasOther) {
		_hasOther = hasOther;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setHasOther", Boolean.class);

				method.invoke(_surveyQuestionRemoteModel, hasOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getOptionDirect() {
		return _optionDirect;
	}

	@Override
	public void setOptionDirect(Boolean optionDirect) {
		_optionDirect = optionDirect;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionDirect", Boolean.class);

				method.invoke(_surveyQuestionRemoteModel, optionDirect);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPoints() {
		return _points;
	}

	@Override
	public void setPoints(String points) {
		_points = points;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setPoints", String.class);

				method.invoke(_surveyQuestionRemoteModel, points);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStarsCount() {
		return _starsCount;
	}

	@Override
	public void setStarsCount(int starsCount) {
		_starsCount = starsCount;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setStarsCount", int.class);

				method.invoke(_surveyQuestionRemoteModel, starsCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUploadFileId() {
		return _uploadFileId;
	}

	@Override
	public void setUploadFileId(long uploadFileId) {
		_uploadFileId = uploadFileId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadFileId", long.class);

				method.invoke(_surveyQuestionRemoteModel, uploadFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyQuestionRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifierId() {
		return _modifierId;
	}

	@Override
	public void setModifierId(long modifierId) {
		_modifierId = modifierId;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifierId", long.class);

				method.invoke(_surveyQuestionRemoteModel, modifierId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		_createDate = createDate;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyQuestionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", long.class);

				method.invoke(_surveyQuestionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyQuestionRemoteModel() {
		return _surveyQuestionRemoteModel;
	}

	public void setSurveyQuestionRemoteModel(
		BaseModel<?> surveyQuestionRemoteModel) {
		_surveyQuestionRemoteModel = surveyQuestionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _surveyQuestionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_surveyQuestionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyQuestionLocalServiceUtil.addSurveyQuestion(this);
		}
		else {
			SurveyQuestionLocalServiceUtil.updateSurveyQuestion(this);
		}
	}

	@Override
	public SurveyQuestion toEscapedModel() {
		return (SurveyQuestion)ProxyUtil.newProxyInstance(SurveyQuestion.class.getClassLoader(),
			new Class[] { SurveyQuestion.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyQuestionClp clone = new SurveyQuestionClp();

		clone.setSurveyQuestionId(getSurveyQuestionId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setSurveyPageId(getSurveyPageId());
		clone.setParentId(getParentId());
		clone.setNo(getNo());
		clone.setQuestion(getQuestion());
		clone.setType(getType());
		clone.setIsRequired(getIsRequired());
		clone.setHasOther(getHasOther());
		clone.setOptionDirect(getOptionDirect());
		clone.setPoints(getPoints());
		clone.setStarsCount(getStarsCount());
		clone.setUploadFileId(getUploadFileId());
		clone.setCreatorId(getCreatorId());
		clone.setModifierId(getModifierId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyQuestion surveyQuestion) {
		int value = 0;

		if (getNo() < surveyQuestion.getNo()) {
			value = -1;
		}
		else if (getNo() > surveyQuestion.getNo()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyQuestionClp)) {
			return false;
		}

		SurveyQuestionClp surveyQuestion = (SurveyQuestionClp)obj;

		long primaryKey = surveyQuestion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{surveyQuestionId=");
		sb.append(getSurveyQuestionId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", surveyPageId=");
		sb.append(getSurveyPageId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", no=");
		sb.append(getNo());
		sb.append(", question=");
		sb.append(getQuestion());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", isRequired=");
		sb.append(getIsRequired());
		sb.append(", hasOther=");
		sb.append(getHasOther());
		sb.append(", optionDirect=");
		sb.append(getOptionDirect());
		sb.append(", points=");
		sb.append(getPoints());
		sb.append(", starsCount=");
		sb.append(getStarsCount());
		sb.append(", uploadFileId=");
		sb.append(getUploadFileId());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", modifierId=");
		sb.append(getModifierId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyQuestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyQuestionId</column-name><column-value><![CDATA[");
		sb.append(getSurveyQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyMainId</column-name><column-value><![CDATA[");
		sb.append(getSurveyMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyPageId</column-name><column-value><![CDATA[");
		sb.append(getSurveyPageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>no</column-name><column-value><![CDATA[");
		sb.append(getNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question</column-name><column-value><![CDATA[");
		sb.append(getQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isRequired</column-name><column-value><![CDATA[");
		sb.append(getIsRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasOther</column-name><column-value><![CDATA[");
		sb.append(getHasOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionDirect</column-name><column-value><![CDATA[");
		sb.append(getOptionDirect());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>points</column-name><column-value><![CDATA[");
		sb.append(getPoints());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>starsCount</column-name><column-value><![CDATA[");
		sb.append(getStarsCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadFileId</column-name><column-value><![CDATA[");
		sb.append(getUploadFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifierId</column-name><column-value><![CDATA[");
		sb.append(getModifierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _surveyQuestionId;
	private long _surveyMainId;
	private long _surveyPageId;
	private long _parentId;
	private int _no;
	private String _question;
	private String _type;
	private Boolean _isRequired;
	private Boolean _hasOther;
	private Boolean _optionDirect;
	private String _points;
	private int _starsCount;
	private long _uploadFileId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
	private BaseModel<?> _surveyQuestionRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}