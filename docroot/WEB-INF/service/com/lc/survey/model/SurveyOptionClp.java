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
import com.lc.survey.service.SurveyOptionLocalServiceUtil;

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
public class SurveyOptionClp extends BaseModelImpl<SurveyOption>
	implements SurveyOption {
	public SurveyOptionClp() {
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
	public long getPrimaryKey() {
		return _surveyOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveyOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyOptionId() {
		return _surveyOptionId;
	}

	@Override
	public void setSurveyOptionId(long surveyOptionId) {
		_surveyOptionId = surveyOptionId;

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyOptionId", long.class);

				method.invoke(_surveyOptionRemoteModel, surveyOptionId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyMainId", long.class);

				method.invoke(_surveyOptionRemoteModel, surveyMainId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyPageId", long.class);

				method.invoke(_surveyOptionRemoteModel, surveyPageId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyQuestionId",
						long.class);

				method.invoke(_surveyOptionRemoteModel, surveyQuestionId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setNo", int.class);

				method.invoke(_surveyOptionRemoteModel, no);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOption() {
		return _option;
	}

	@Override
	public void setOption(String option) {
		_option = option;

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setOption", String.class);

				method.invoke(_surveyOptionRemoteModel, option);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIsAns() {
		return _isAns;
	}

	@Override
	public void setIsAns(Boolean isAns) {
		_isAns = isAns;

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsAns", Boolean.class);

				method.invoke(_surveyOptionRemoteModel, isAns);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPageDirectId", long.class);

				method.invoke(_surveyOptionRemoteModel, pageDirectId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadFileId", long.class);

				method.invoke(_surveyOptionRemoteModel, uploadFileId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_surveyOptionRemoteModel, creatorId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifierId", long.class);

				method.invoke(_surveyOptionRemoteModel, modifierId);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", long.class);

				method.invoke(_surveyOptionRemoteModel, createDate);
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

		if (_surveyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", long.class);

				method.invoke(_surveyOptionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyOptionRemoteModel() {
		return _surveyOptionRemoteModel;
	}

	public void setSurveyOptionRemoteModel(BaseModel<?> surveyOptionRemoteModel) {
		_surveyOptionRemoteModel = surveyOptionRemoteModel;
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

		Class<?> remoteModelClass = _surveyOptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyOptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyOptionLocalServiceUtil.addSurveyOption(this);
		}
		else {
			SurveyOptionLocalServiceUtil.updateSurveyOption(this);
		}
	}

	@Override
	public SurveyOption toEscapedModel() {
		return (SurveyOption)ProxyUtil.newProxyInstance(SurveyOption.class.getClassLoader(),
			new Class[] { SurveyOption.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyOptionClp clone = new SurveyOptionClp();

		clone.setSurveyOptionId(getSurveyOptionId());
		clone.setSurveyMainId(getSurveyMainId());
		clone.setSurveyPageId(getSurveyPageId());
		clone.setSurveyQuestionId(getSurveyQuestionId());
		clone.setNo(getNo());
		clone.setOption(getOption());
		clone.setIsAns(getIsAns());
		clone.setPageDirectId(getPageDirectId());
		clone.setUploadFileId(getUploadFileId());
		clone.setCreatorId(getCreatorId());
		clone.setModifierId(getModifierId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyOption surveyOption) {
		int value = 0;

		if (getNo() < surveyOption.getNo()) {
			value = -1;
		}
		else if (getNo() > surveyOption.getNo()) {
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

		if (!(obj instanceof SurveyOptionClp)) {
			return false;
		}

		SurveyOptionClp surveyOption = (SurveyOptionClp)obj;

		long primaryKey = surveyOption.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{surveyOptionId=");
		sb.append(getSurveyOptionId());
		sb.append(", surveyMainId=");
		sb.append(getSurveyMainId());
		sb.append(", surveyPageId=");
		sb.append(getSurveyPageId());
		sb.append(", surveyQuestionId=");
		sb.append(getSurveyQuestionId());
		sb.append(", no=");
		sb.append(getNo());
		sb.append(", option=");
		sb.append(getOption());
		sb.append(", isAns=");
		sb.append(getIsAns());
		sb.append(", pageDirectId=");
		sb.append(getPageDirectId());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.lc.survey.model.SurveyOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveyOptionId</column-name><column-value><![CDATA[");
		sb.append(getSurveyOptionId());
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
			"<column><column-name>no</column-name><column-value><![CDATA[");
		sb.append(getNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>option</column-name><column-value><![CDATA[");
		sb.append(getOption());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isAns</column-name><column-value><![CDATA[");
		sb.append(getIsAns());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageDirectId</column-name><column-value><![CDATA[");
		sb.append(getPageDirectId());
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

	private long _surveyOptionId;
	private long _surveyMainId;
	private long _surveyPageId;
	private long _surveyQuestionId;
	private int _no;
	private String _option;
	private Boolean _isAns;
	private long _pageDirectId;
	private long _uploadFileId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
	private BaseModel<?> _surveyOptionRemoteModel;
	private Class<?> _clpSerializerClass = com.lc.survey.service.ClpSerializer.class;
}