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
import com.lc.survey.service.SurveyResultLocalServiceUtil;

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
public class SurveyResultClp extends BaseModelImpl<SurveyResult>
	implements SurveyResult {
	public SurveyResultClp() {
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
	public long getPrimaryKey() {
		return _surveyResultId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyResultId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyResultId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyResultId() {
		return _surveyResultId;
	}

	@Override
	public void setSurveyResultId(long surveyResultId) {
		_surveyResultId = surveyResultId;

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyResultId", long.class);

				method.invoke(_surveyResultRemoteModel, surveyResultId);
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

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyResultRemoteModel, surveyMainId);
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

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyPageId", long.class);

				method.invoke(_surveyResultRemoteModel, surveyPageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSurveyQuestionId() {
		return _surveyQuestionId;
	}

	@Override
	public void setSurveyQuestionId(long surveyQuestionId) {
		_surveyQuestionId = surveyQuestionId;

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyQuestionId",
						long.class);

				method.invoke(_surveyResultRemoteModel, surveyQuestionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSurveyOptionId() {
		return _surveyOptionId;
	}

	@Override
	public void setSurveyOptionId(long surveyOptionId) {
		_surveyOptionId = surveyOptionId;

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyOptionId", long.class);

				method.invoke(_surveyResultRemoteModel, surveyOptionId);
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

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyWriterId", long.class);

				method.invoke(_surveyResultRemoteModel, surveyWriterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAns() {
		return _ans;
	}

	@Override
	public void setAns(String ans) {
		_ans = ans;

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setAns", String.class);

				method.invoke(_surveyResultRemoteModel, ans);
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

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyResultRemoteModel, creatorId);
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

		if (_surveyResultRemoteModel != null) {
			try {
				Class<?> clazz = _surveyResultRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyResultRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyResultRemoteModel() {
		return _surveyResultRemoteModel;
	}

	public void setSurveyResultRemoteModel(BaseModel<?> surveyResultRemoteModel) {
		_surveyResultRemoteModel = surveyResultRemoteModel;
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

		Class<?> remoteModelClass = _surveyResultRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyResultRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyResultLocalServiceUtil.addSurveyResult(this);
		}
		else {
			SurveyResultLocalServiceUtil.updateSurveyResult(this);
		}
	}

	@Override
	public SurveyResult toEscapedModel() {
		return (SurveyResult)ProxyUtil.newProxyInstance(SurveyResult.class.getClassLoader(),
			new Class[] { SurveyResult.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyResultClp clone = new SurveyResultClp();

		clone.setSurveyResultId(getSurveyResultId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setSurveyPageId(getSurveyPageId());
		clone.setSurveyQuestionId(getSurveyQuestionId());
		clone.setSurveyOptionId(getSurveyOptionId());
		clone.setSurveyWriterId(getSurveyWriterId());
		clone.setAns(getAns());
		clone.setCreatorId(getCreatorId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyResult surveyResult) {
		int value = 0;

		if (getCreateDate() < surveyResult.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > surveyResult.getCreateDate()) {
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

		if (!(obj instanceof SurveyResultClp)) {
			return false;
		}

		SurveyResultClp surveyResult = (SurveyResultClp)obj;

		long primaryKey = surveyResult.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{surveyResultId=");
		sb.append(getSurveyResultId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", surveyPageId=");
		sb.append(getSurveyPageId());
		sb.append(", surveyQuestionId=");
		sb.append(getSurveyQuestionId());
		sb.append(", surveyOptionId=");
		sb.append(getSurveyOptionId());
		sb.append(", surveyWriterId=");
		sb.append(getSurveyWriterId());
		sb.append(", ans=");
		sb.append(getAns());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyResultId</column-name><column-value><![CDATA[");
		sb.append(getSurveyResultId());
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
			"<column><column-name>surveyQuestionId</column-name><column-value><![CDATA[");
		sb.append(getSurveyQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyOptionId</column-name><column-value><![CDATA[");
		sb.append(getSurveyOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyWriterId</column-name><column-value><![CDATA[");
		sb.append(getSurveyWriterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ans</column-name><column-value><![CDATA[");
		sb.append(getAns());
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

	private long _surveyResultId;
	private long _surveyMainId;
	private long _surveyPageId;
	private long _surveyQuestionId;
	private long _surveyOptionId;
	private long _surveyWriterId;
	private String _ans;
	private long _creatorId;
	private long _createDate;
	private BaseModel<?> _surveyResultRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}