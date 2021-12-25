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
import com.lc.survey.service.SurveyPageLocalServiceUtil;

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
public class SurveyPageClp extends BaseModelImpl<SurveyPage>
	implements SurveyPage {
	public SurveyPageClp() {
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
	public long getPrimaryKey() {
		return _surveyPageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyPageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyPageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyPageId() {
		return _surveyPageId;
	}

	@Override
	public void setSurveyPageId(long surveyPageId) {
		_surveyPageId = surveyPageId;

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyPageId", long.class);

				method.invoke(_surveyPageRemoteModel, surveyPageId);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyPageRemoteModel, surveyMainId);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setNo", int.class);

				method.invoke(_surveyPageRemoteModel, no);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_surveyPageRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPageDirectId() {
		return _pageDirectId;
	}

	@Override
	public void setPageDirectId(long pageDirectId) {
		_pageDirectId = pageDirectId;

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setPageDirectId", long.class);

				method.invoke(_surveyPageRemoteModel, pageDirectId);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyPageRemoteModel, creatorId);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifierId", long.class);

				method.invoke(_surveyPageRemoteModel, modifierId);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyPageRemoteModel, createDate);
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

		if (_surveyPageRemoteModel != null) {
			try {
				Class<?> clazz = _surveyPageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", long.class);

				method.invoke(_surveyPageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyPageRemoteModel() {
		return _surveyPageRemoteModel;
	}

	public void setSurveyPageRemoteModel(BaseModel<?> surveyPageRemoteModel) {
		_surveyPageRemoteModel = surveyPageRemoteModel;
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

		Class<?> remoteModelClass = _surveyPageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyPageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyPageLocalServiceUtil.addSurveyPage(this);
		}
		else {
			SurveyPageLocalServiceUtil.updateSurveyPage(this);
		}
	}

	@Override
	public SurveyPage toEscapedModel() {
		return (SurveyPage)ProxyUtil.newProxyInstance(SurveyPage.class.getClassLoader(),
			new Class[] { SurveyPage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyPageClp clone = new SurveyPageClp();

		clone.setSurveyPageId(getSurveyPageId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setNo(getNo());
		clone.setTitle(getTitle());
		clone.setPageDirectId(getPageDirectId());
		clone.setCreatorId(getCreatorId());
		clone.setModifierId(getModifierId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyPage surveyPage) {
		int value = 0;

		if (getNo() < surveyPage.getNo()) {
			value = -1;
		}
		else if (getNo() > surveyPage.getNo()) {
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

		if (!(obj instanceof SurveyPageClp)) {
			return false;
		}

		SurveyPageClp surveyPage = (SurveyPageClp)obj;

		long primaryKey = surveyPage.getPrimaryKey();

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

		sb.append("{surveyPageId=");
		sb.append(getSurveyPageId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", no=");
		sb.append(getNo());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", pageDirectId=");
		sb.append(getPageDirectId());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyPage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyPageId</column-name><column-value><![CDATA[");
		sb.append(getSurveyPageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyMainId</column-name><column-value><![CDATA[");
		sb.append(getSurveyMainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>no</column-name><column-value><![CDATA[");
		sb.append(getNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageDirectId</column-name><column-value><![CDATA[");
		sb.append(getPageDirectId());
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

	private long _surveyPageId;
	private long _surveyMainId;
	private int _no;
	private String _title;
	private long _pageDirectId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
	private BaseModel<?> _surveyPageRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}