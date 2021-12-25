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
import com.lc.survey.service.SurveyFileLocalServiceUtil;

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
public class SurveyFileClp extends BaseModelImpl<SurveyFile>
	implements SurveyFile {
	public SurveyFileClp() {
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
	public long getPrimaryKey() {
		return _surveyFileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyFileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyFileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyFileId() {
		return _surveyFileId;
	}

	@Override
	public void setSurveyFileId(long surveyFileId) {
		_surveyFileId = surveyFileId;

		if (_surveyFileRemoteModel != null) {
			try {
				Class<?> clazz = _surveyFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyFileId", long.class);

				method.invoke(_surveyFileRemoteModel, surveyFileId);
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

		if (_surveyFileRemoteModel != null) {
			try {
				Class<?> clazz = _surveyFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyFileRemoteModel, surveyMainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_surveyFileRemoteModel != null) {
			try {
				Class<?> clazz = _surveyFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_surveyFileRemoteModel, fileName);
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

		if (_surveyFileRemoteModel != null) {
			try {
				Class<?> clazz = _surveyFileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyFileRemoteModel, creatorId);
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

		if (_surveyFileRemoteModel != null) {
			try {
				Class<?> clazz = _surveyFileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyFileRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyFileRemoteModel() {
		return _surveyFileRemoteModel;
	}

	public void setSurveyFileRemoteModel(BaseModel<?> surveyFileRemoteModel) {
		_surveyFileRemoteModel = surveyFileRemoteModel;
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

		Class<?> remoteModelClass = _surveyFileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyFileLocalServiceUtil.addSurveyFile(this);
		}
		else {
			SurveyFileLocalServiceUtil.updateSurveyFile(this);
		}
	}

	@Override
	public SurveyFile toEscapedModel() {
		return (SurveyFile)ProxyUtil.newProxyInstance(SurveyFile.class.getClassLoader(),
			new Class[] { SurveyFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyFileClp clone = new SurveyFileClp();

		clone.setSurveyFileId(getSurveyFileId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setFileName(getFileName());
		clone.setCreatorId(getCreatorId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyFile surveyFile) {
		int value = 0;

		if (getCreateDate() < surveyFile.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > surveyFile.getCreateDate()) {
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

		if (!(obj instanceof SurveyFileClp)) {
			return false;
		}

		SurveyFileClp surveyFile = (SurveyFileClp)obj;

		long primaryKey = surveyFile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{surveyFileId=");
		sb.append(getSurveyFileId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyFileId</column-name><column-value><![CDATA[");
		sb.append(getSurveyFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyMainId</column-name><column-value><![CDATA[");
		sb.append(getSurveyMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
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

	private long _surveyFileId;
	private long _surveyMainId;
	private String _fileName;
	private long _creatorId;
	private long _createDate;
	private BaseModel<?> _surveyFileRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}