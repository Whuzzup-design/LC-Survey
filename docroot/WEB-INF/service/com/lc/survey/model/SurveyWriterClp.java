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
import com.lc.survey.service.SurveyWriterLocalServiceUtil;

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
public class SurveyWriterClp extends BaseModelImpl<SurveyWriter>
	implements SurveyWriter {
	public SurveyWriterClp() {
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
	public long getPrimaryKey() {
		return _surveyWriterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyWriterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyWriterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyWriterId() {
		return _surveyWriterId;
	}

	@Override
	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriterId = surveyWriterId;

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyWriterId", long.class);

				method.invoke(_surveyWriterRemoteModel, surveyWriterId);
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

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyWriterRemoteModel, surveyMainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIsPreview() {
		return _isPreview;
	}

	@Override
	public void setIsPreview(Boolean isPreview) {
		_isPreview = isPreview;

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPreview", Boolean.class);

				method.invoke(_surveyWriterRemoteModel, isPreview);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIsComplete() {
		return _isComplete;
	}

	@Override
	public void setIsComplete(Boolean isComplete) {
		_isComplete = isComplete;

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setIsComplete", Boolean.class);

				method.invoke(_surveyWriterRemoteModel, isComplete);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompletionTime() {
		return _completionTime;
	}

	@Override
	public void setCompletionTime(long completionTime) {
		_completionTime = completionTime;

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setCompletionTime", long.class);

				method.invoke(_surveyWriterRemoteModel, completionTime);
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

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyWriterRemoteModel, creatorId);
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

		if (_surveyWriterRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyWriterRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyWriterRemoteModel() {
		return _surveyWriterRemoteModel;
	}

	public void setSurveyWriterRemoteModel(BaseModel<?> surveyWriterRemoteModel) {
		_surveyWriterRemoteModel = surveyWriterRemoteModel;
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

		Class<?> remoteModelClass = _surveyWriterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyWriterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyWriterLocalServiceUtil.addSurveyWriter(this);
		}
		else {
			SurveyWriterLocalServiceUtil.updateSurveyWriter(this);
		}
	}

	@Override
	public SurveyWriter toEscapedModel() {
		return (SurveyWriter)ProxyUtil.newProxyInstance(SurveyWriter.class.getClassLoader(),
			new Class[] { SurveyWriter.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyWriterClp clone = new SurveyWriterClp();

		clone.setSurveyWriterId(getSurveyWriterId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setIsPreview(getIsPreview());
		clone.setIsComplete(getIsComplete());
		clone.setCompletionTime(getCompletionTime());
		clone.setCreatorId(getCreatorId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyWriter surveyWriter) {
		int value = 0;

		if (getCreateDate() < surveyWriter.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > surveyWriter.getCreateDate()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof SurveyWriterClp)) {
			return false;
		}

		SurveyWriterClp surveyWriter = (SurveyWriterClp)obj;

		long primaryKey = surveyWriter.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{surveyWriterId=");
		sb.append(getSurveyWriterId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", isPreview=");
		sb.append(getIsPreview());
		sb.append(", isComplete=");
		sb.append(getIsComplete());
		sb.append(", completionTime=");
		sb.append(getCompletionTime());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyWriter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyWriterId</column-name><column-value><![CDATA[");
		sb.append(getSurveyWriterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyMainId</column-name><column-value><![CDATA[");
		sb.append(getSurveyMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPreview</column-name><column-value><![CDATA[");
		sb.append(getIsPreview());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isComplete</column-name><column-value><![CDATA[");
		sb.append(getIsComplete());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completionTime</column-name><column-value><![CDATA[");
		sb.append(getCompletionTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _surveyWriterId;
	private long _surveyMainId;
	private Boolean _isPreview;
	private Boolean _isComplete;
	private long _completionTime;
	private long _creatorId;
	private long _createDate;
	private BaseModel<?> _surveyWriterRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}