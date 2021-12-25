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
import com.lc.survey.service.SurveyResponseLocalServiceUtil;

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
public class SurveyResponseClp extends BaseModelImpl<SurveyResponse>
	implements SurveyResponse {
	public SurveyResponseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyResponse.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyResponse.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _surveyResponseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyResponseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyResponseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyResponseId", getSurveyResponseId());
		attributes.put("surveyMainId", getSurveyMainId());
		attributes.put("writerId", getWriterId());
		attributes.put("response", getResponse());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyResponseId = (Long)attributes.get("surveyResponseId");

		if (surveyResponseId != null) {
			setSurveyResponseId(surveyResponseId);
		}

		Long surveyMainId = (Long)attributes.get("surveyMainId");

		if (surveyMainId != null) {
			setSurveyMainId(surveyMainId);
		}

		Long writerId = (Long)attributes.get("writerId");

		if (writerId != null) {
			setWriterId(writerId);
		}

		String response = (String)attributes.get("response");

		if (response != null) {
			setResponse(response);
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
	public long getSurveyResponseId() {
		return _surveyResponseId;
	}

	@Override
	public void setSurveyResponseId(long surveyResponseId) {
		_surveyResponseId = surveyResponseId;

		if (_surveyResponseRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResponseRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyResponseId",
						long.class);

				method.invoke(_surveyResponseRemoteModel, surveyResponseId);
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

		if (_surveyResponseRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResponseRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyResponseRemoteModel, surveyMainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWriterId() {
		return _writerId;
	}

	@Override
	public void setWriterId(long writerId) {
		_writerId = writerId;

		if (_surveyResponseRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResponseRemoteModel.getClass();

				Method method = clazz.getMethod("setWriterId", long.class);

				method.invoke(_surveyResponseRemoteModel, writerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResponse() {
		return _response;
	}

	@Override
	public void setResponse(String response) {
		_response = response;

		if (_surveyResponseRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResponseRemoteModel.getClass();

				Method method = clazz.getMethod("setResponse", String.class);

				method.invoke(_surveyResponseRemoteModel, response);
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

		if (_surveyResponseRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResponseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyResponseRemoteModel, creatorId);
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

		if (_surveyResponseRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResponseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyResponseRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyResponseRemoteModel() {
		return _surveyResponseRemoteModel;
	}

	public void setSurveyResponseRemoteModel(
		BaseModel<?> surveyResponseRemoteModel) {
		_surveyResponseRemoteModel = surveyResponseRemoteModel;
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

		Class<?> remoteModelClass = _surveyResponseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyResponseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyResponseLocalServiceUtil.addSurveyResponse(this);
		}
		else {
			SurveyResponseLocalServiceUtil.updateSurveyResponse(this);
		}
	}

	@Override
	public SurveyResponse toEscapedModel() {
		return (SurveyResponse)ProxyUtil.newProxyInstance(SurveyResponse.class.getClassLoader(),
			new Class[] { SurveyResponse.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyResponseClp clone = new SurveyResponseClp();

		clone.setSurveyResponseId(getSurveyResponseId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setWriterId(getWriterId());
		clone.setResponse(getResponse());
		clone.setCreatorId(getCreatorId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyResponse surveyResponse) {
		int value = 0;

		if (getCreateDate() < surveyResponse.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > surveyResponse.getCreateDate()) {
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

		if (!(obj instanceof SurveyResponseClp)) {
			return false;
		}

		SurveyResponseClp surveyResponse = (SurveyResponseClp)obj;

		long primaryKey = surveyResponse.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{surveyResponseId=");
		sb.append(getSurveyResponseId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", writerId=");
		sb.append(getWriterId());
		sb.append(", response=");
		sb.append(getResponse());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyResponse");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyResponseId</column-name><column-value><![CDATA[");
		sb.append(getSurveyResponseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyMainId</column-name><column-value><![CDATA[");
		sb.append(getSurveyMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writerId</column-name><column-value><![CDATA[");
		sb.append(getWriterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>response</column-name><column-value><![CDATA[");
		sb.append(getResponse());
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

	private long _surveyResponseId;
	private long _surveyMainId;
	private long _writerId;
	private String _response;
	private long _creatorId;
	private long _createDate;
	private BaseModel<?> _surveyResponseRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}