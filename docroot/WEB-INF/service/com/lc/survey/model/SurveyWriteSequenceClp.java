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
import com.lc.survey.service.SurveyWriteSequenceLocalServiceUtil;

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
public class SurveyWriteSequenceClp extends BaseModelImpl<SurveyWriteSequence>
	implements SurveyWriteSequence {
	public SurveyWriteSequenceClp() {
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
	public long getPrimaryKey() {
		return _surveyWriteSequenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyWriteSequenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyWriteSequenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyWriteSequenceId() {
		return _surveyWriteSequenceId;
	}

	@Override
	public void setSurveyWriteSequenceId(long surveyWriteSequenceId) {
		_surveyWriteSequenceId = surveyWriteSequenceId;

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyWriteSequenceId",
						long.class);

				method.invoke(_surveyWriteSequenceRemoteModel,
					surveyWriteSequenceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSurveyWriterId() {
		return _surveyWriterId;
	}

	@Override
	public void setSurveyWriterId(long surveyWriterId) {
		_surveyWriterId = surveyWriterId;

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyWriterId", long.class);

				method.invoke(_surveyWriteSequenceRemoteModel, surveyWriterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPageId() {
		return _pageId;
	}

	@Override
	public void setPageId(long pageId) {
		_pageId = pageId;

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPageId", long.class);

				method.invoke(_surveyWriteSequenceRemoteModel, pageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPrePageId() {
		return _prePageId;
	}

	@Override
	public void setPrePageId(long prePageId) {
		_prePageId = prePageId;

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPrePageId", long.class);

				method.invoke(_surveyWriteSequenceRemoteModel, prePageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIsDirect() {
		return _isDirect;
	}

	@Override
	public void setIsDirect(Boolean isDirect) {
		_isDirect = isDirect;

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setIsDirect", Boolean.class);

				method.invoke(_surveyWriteSequenceRemoteModel, isDirect);
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

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyWriteSequenceRemoteModel, creatorId);
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

		if (_surveyWriteSequenceRemoteModel != null) {
			try {
				Class<?> clazz = _surveyWriteSequenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyWriteSequenceRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyWriteSequenceRemoteModel() {
		return _surveyWriteSequenceRemoteModel;
	}

	public void setSurveyWriteSequenceRemoteModel(
		BaseModel<?> surveyWriteSequenceRemoteModel) {
		_surveyWriteSequenceRemoteModel = surveyWriteSequenceRemoteModel;
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

		Class<?> remoteModelClass = _surveyWriteSequenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyWriteSequenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyWriteSequenceLocalServiceUtil.addSurveyWriteSequence(this);
		}
		else {
			SurveyWriteSequenceLocalServiceUtil.updateSurveyWriteSequence(this);
		}
	}

	@Override
	public SurveyWriteSequence toEscapedModel() {
		return (SurveyWriteSequence)ProxyUtil.newProxyInstance(SurveyWriteSequence.class.getClassLoader(),
			new Class[] { SurveyWriteSequence.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyWriteSequenceClp clone = new SurveyWriteSequenceClp();

		clone.setSurveyWriteSequenceId(getSurveyWriteSequenceId());
		clone.setSurveyWriterId(getSurveyWriterId());
		clone.setPageId(getPageId());
		clone.setPrePageId(getPrePageId());
		clone.setIsDirect(getIsDirect());
		clone.setCreatorId(getCreatorId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyWriteSequence surveyWriteSequence) {
		int value = 0;

		if (getCreateDate() < surveyWriteSequence.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > surveyWriteSequence.getCreateDate()) {
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

		if (!(obj instanceof SurveyWriteSequenceClp)) {
			return false;
		}

		SurveyWriteSequenceClp surveyWriteSequence = (SurveyWriteSequenceClp)obj;

		long primaryKey = surveyWriteSequence.getPrimaryKey();

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

		sb.append("{surveyWriteSequenceId=");
		sb.append(getSurveyWriteSequenceId());
		sb.append(", surveyWriterId=");
		sb.append(getSurveyWriterId());
		sb.append(", pageId=");
		sb.append(getPageId());
		sb.append(", prePageId=");
		sb.append(getPrePageId());
		sb.append(", isDirect=");
		sb.append(getIsDirect());
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
		sb.append("com.lc.survey.model.SurveyWriteSequence");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyWriteSequenceId</column-name><column-value><![CDATA[");
		sb.append(getSurveyWriteSequenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyWriterId</column-name><column-value><![CDATA[");
		sb.append(getSurveyWriterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageId</column-name><column-value><![CDATA[");
		sb.append(getPageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prePageId</column-name><column-value><![CDATA[");
		sb.append(getPrePageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDirect</column-name><column-value><![CDATA[");
		sb.append(getIsDirect());
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

	private long _surveyWriteSequenceId;
	private long _surveyWriterId;
	private long _pageId;
	private long _prePageId;
	private Boolean _isDirect;
	private long _creatorId;
	private long _createDate;
	private BaseModel<?> _surveyWriteSequenceRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}