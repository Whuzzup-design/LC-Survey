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
import com.lc.survey.service.SurveyMainLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 */
public class SurveyMainClp extends BaseModelImpl<SurveyMain>
	implements SurveyMain {
	public SurveyMainClp() {
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
	public long getPrimaryKey() {
		return _surveyMainId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyMainId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyMainId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyMainId() {
		return _surveyMainId;
	}

	@Override
	public void setSurveyMainId(long surveyMainId) {
		_surveyMainId = surveyMainId;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyMainRemoteModel, surveyMainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_surveyMainRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_surveyMainRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEpilog() {
		return _epilog;
	}

	@Override
	public void setEpilog(String epilog) {
		_epilog = epilog;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setEpilog", String.class);

				method.invoke(_surveyMainRemoteModel, epilog);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_surveyMainRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_surveyMainRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getNeedAuth() {
		return _needAuth;
	}

	@Override
	public void setNeedAuth(Boolean needAuth) {
		_needAuth = needAuth;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setNeedAuth", Boolean.class);

				method.invoke(_surveyMainRemoteModel, needAuth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getCalculateScore() {
		return _calculateScore;
	}

	@Override
	public void setCalculateScore(Boolean calculateScore) {
		_calculateScore = calculateScore;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setCalculateScore",
						Boolean.class);

				method.invoke(_surveyMainRemoteModel, calculateScore);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getViewAnswer() {
		return _viewAnswer;
	}

	@Override
	public void setViewAnswer(Boolean viewAnswer) {
		_viewAnswer = viewAnswer;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setViewAnswer", Boolean.class);

				method.invoke(_surveyMainRemoteModel, viewAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColor() {
		return _color;
	}

	@Override
	public void setColor(String color) {
		_color = color;

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setColor", String.class);

				method.invoke(_surveyMainRemoteModel, color);
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

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyMainRemoteModel, creatorId);
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

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setModifierId", long.class);

				method.invoke(_surveyMainRemoteModel, modifierId);
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

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyMainRemoteModel, createDate);
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

		if (_surveyMainRemoteModel != null) {
			try {
				Class<?> clazz = _surveyMainRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", long.class);

				method.invoke(_surveyMainRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyMainRemoteModel() {
		return _surveyMainRemoteModel;
	}

	public void setSurveyMainRemoteModel(BaseModel<?> surveyMainRemoteModel) {
		_surveyMainRemoteModel = surveyMainRemoteModel;
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

		Class<?> remoteModelClass = _surveyMainRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyMainRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyMainLocalServiceUtil.addSurveyMain(this);
		}
		else {
			SurveyMainLocalServiceUtil.updateSurveyMain(this);
		}
	}

	@Override
	public SurveyMain toEscapedModel() {
		return (SurveyMain)ProxyUtil.newProxyInstance(SurveyMain.class.getClassLoader(),
			new Class[] { SurveyMain.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyMainClp clone = new SurveyMainClp();

		clone.setSurveyMainId(getSurveyMainId());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setEpilog(getEpilog());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setNeedAuth(getNeedAuth());
		clone.setCalculateScore(getCalculateScore());
		clone.setViewAnswer(getViewAnswer());
		clone.setColor(getColor());
		clone.setCreatorId(getCreatorId());
		clone.setModifierId(getModifierId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyMain surveyMain) {
		int value = 0;

		if (getModifiedDate() < surveyMain.getModifiedDate()) {
			value = -1;
		}
		else if (getModifiedDate() > surveyMain.getModifiedDate()) {
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

		if (!(obj instanceof SurveyMainClp)) {
			return false;
		}

		SurveyMainClp surveyMain = (SurveyMainClp)obj;

		long primaryKey = surveyMain.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", epilog=");
		sb.append(getEpilog());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", needAuth=");
		sb.append(getNeedAuth());
		sb.append(", calculateScore=");
		sb.append(getCalculateScore());
		sb.append(", viewAnswer=");
		sb.append(getViewAnswer());
		sb.append(", color=");
		sb.append(getColor());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyMain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyMainId</column-name><column-value><![CDATA[");
		sb.append(getSurveyMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>epilog</column-name><column-value><![CDATA[");
		sb.append(getEpilog());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>needAuth</column-name><column-value><![CDATA[");
		sb.append(getNeedAuth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calculateScore</column-name><column-value><![CDATA[");
		sb.append(getCalculateScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewAnswer</column-name><column-value><![CDATA[");
		sb.append(getViewAnswer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
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

	private long _surveyMainId;
	private String _title;
	private String _description;
	private String _epilog;
	private Date _startDate;
	private Date _endDate;
	private Boolean _needAuth;
	private Boolean _calculateScore;
	private Boolean _viewAnswer;
	private String _color;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
	private BaseModel<?> _surveyMainRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}