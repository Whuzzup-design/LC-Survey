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

package com.lc.survey.model.impl;

import com.lc.survey.model.SurveyPage;
import com.lc.survey.model.SurveyPageModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SurveyPage service. Represents a row in the &quot;lc_SurveyPage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.lc.survey.model.SurveyPageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SurveyPageImpl}.
 * </p>
 *
 * @author kevin
 * @see SurveyPageImpl
 * @see com.lc.survey.model.SurveyPage
 * @see com.lc.survey.model.SurveyPageModel
 * @generated
 */
public class SurveyPageModelImpl extends BaseModelImpl<SurveyPage>
	implements SurveyPageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a survey page model instance should use the {@link com.lc.survey.model.SurveyPage} interface instead.
	 */
	public static final String TABLE_NAME = "lc_SurveyPage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "surveyPageId", Types.BIGINT },
			{ "surveyMainId", Types.BIGINT },
			{ "no", Types.INTEGER },
			{ "title", Types.VARCHAR },
			{ "pageDirectId", Types.BIGINT },
			{ "creatorId", Types.BIGINT },
			{ "modifierId", Types.BIGINT },
			{ "createDate", Types.BIGINT },
			{ "modifiedDate", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table lc_SurveyPage (surveyPageId LONG not null primary key,surveyMainId LONG,no INTEGER,title VARCHAR(200) null,pageDirectId LONG,creatorId LONG,modifierId LONG,createDate LONG,modifiedDate LONG)";
	public static final String TABLE_SQL_DROP = "drop table lc_SurveyPage";
	public static final String ORDER_BY_JPQL = " ORDER BY surveyPage.no ASC";
	public static final String ORDER_BY_SQL = " ORDER BY lc_SurveyPage.no ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.lc.survey.model.SurveyPage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.lc.survey.model.SurveyPage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.lc.survey.model.SurveyPage"),
			true);
	public static long NO_COLUMN_BITMASK = 1L;
	public static long SURVEYMAINID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.lc.survey.model.SurveyPage"));

	public SurveyPageModelImpl() {
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
	public Class<?> getModelClass() {
		return SurveyPage.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyPage.class.getName();
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
	}

	@Override
	public long getSurveyMainId() {
		return _surveyMainId;
	}

	@Override
	public void setSurveyMainId(long surveyMainId) {
		_columnBitmask |= SURVEYMAINID_COLUMN_BITMASK;

		if (!_setOriginalSurveyMainId) {
			_setOriginalSurveyMainId = true;

			_originalSurveyMainId = _surveyMainId;
		}

		_surveyMainId = surveyMainId;
	}

	public long getOriginalSurveyMainId() {
		return _originalSurveyMainId;
	}

	@Override
	public int getNo() {
		return _no;
	}

	@Override
	public void setNo(int no) {
		_columnBitmask = -1L;

		if (!_setOriginalNo) {
			_setOriginalNo = true;

			_originalNo = _no;
		}

		_no = no;
	}

	public int getOriginalNo() {
		return _originalNo;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public long getPageDirectId() {
		return _pageDirectId;
	}

	@Override
	public void setPageDirectId(long pageDirectId) {
		_pageDirectId = pageDirectId;
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;
	}

	@Override
	public long getModifierId() {
		return _modifierId;
	}

	@Override
	public void setModifierId(long modifierId) {
		_modifierId = modifierId;
	}

	@Override
	public long getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	@Override
	public long getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SurveyPage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SurveyPage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SurveyPage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SurveyPageImpl surveyPageImpl = new SurveyPageImpl();

		surveyPageImpl.setSurveyPageId(getSurveyPageId());
		surveyPageImpl.setSurveyMainId(getSurveyMainId());
		surveyPageImpl.setNo(getNo());
		surveyPageImpl.setTitle(getTitle());
		surveyPageImpl.setPageDirectId(getPageDirectId());
		surveyPageImpl.setCreatorId(getCreatorId());
		surveyPageImpl.setModifierId(getModifierId());
		surveyPageImpl.setCreateDate(getCreateDate());
		surveyPageImpl.setModifiedDate(getModifiedDate());

		surveyPageImpl.resetOriginalValues();

		return surveyPageImpl;
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

		if (!(obj instanceof SurveyPage)) {
			return false;
		}

		SurveyPage surveyPage = (SurveyPage)obj;

		long primaryKey = surveyPage.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SurveyPageModelImpl surveyPageModelImpl = this;

		surveyPageModelImpl._originalSurveyMainId = surveyPageModelImpl._surveyMainId;

		surveyPageModelImpl._setOriginalSurveyMainId = false;

		surveyPageModelImpl._originalNo = surveyPageModelImpl._no;

		surveyPageModelImpl._setOriginalNo = false;

		surveyPageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SurveyPage> toCacheModel() {
		SurveyPageCacheModel surveyPageCacheModel = new SurveyPageCacheModel();

		surveyPageCacheModel.surveyPageId = getSurveyPageId();

		surveyPageCacheModel.surveyMainId = getSurveyMainId();

		surveyPageCacheModel.no = getNo();

		surveyPageCacheModel.title = getTitle();

		String title = surveyPageCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			surveyPageCacheModel.title = null;
		}

		surveyPageCacheModel.pageDirectId = getPageDirectId();

		surveyPageCacheModel.creatorId = getCreatorId();

		surveyPageCacheModel.modifierId = getModifierId();

		surveyPageCacheModel.createDate = getCreateDate();

		surveyPageCacheModel.modifiedDate = getModifiedDate();

		return surveyPageCacheModel;
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

	private static ClassLoader _classLoader = SurveyPage.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SurveyPage.class
		};
	private long _surveyPageId;
	private long _surveyMainId;
	private long _originalSurveyMainId;
	private boolean _setOriginalSurveyMainId;
	private int _no;
	private int _originalNo;
	private boolean _setOriginalNo;
	private String _title;
	private long _pageDirectId;
	private long _creatorId;
	private long _modifierId;
	private long _createDate;
	private long _modifiedDate;
	private long _columnBitmask;
	private SurveyPage _escapedModel;
}