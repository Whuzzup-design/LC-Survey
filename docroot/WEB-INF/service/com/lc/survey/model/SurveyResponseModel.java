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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SurveyResponse service. Represents a row in the &quot;lc_SurveyResponse&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.lc.survey.model.impl.SurveyResponseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.lc.survey.model.impl.SurveyResponseImpl}.
 * </p>
 *
 * @author kevin
 * @see SurveyResponse
 * @see com.lc.survey.model.impl.SurveyResponseImpl
 * @see com.lc.survey.model.impl.SurveyResponseModelImpl
 * @generated
 */
public interface SurveyResponseModel extends BaseModel<SurveyResponse> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a survey response model instance should use the {@link SurveyResponse} interface instead.
	 */

	/**
	 * Returns the primary key of this survey response.
	 *
	 * @return the primary key of this survey response
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this survey response.
	 *
	 * @param primaryKey the primary key of this survey response
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the survey response ID of this survey response.
	 *
	 * @return the survey response ID of this survey response
	 */
	public long getSurveyResponseId();

	/**
	 * Sets the survey response ID of this survey response.
	 *
	 * @param surveyResponseId the survey response ID of this survey response
	 */
	public void setSurveyResponseId(long surveyResponseId);

	/**
	 * Returns the survey main ID of this survey response.
	 *
	 * @return the survey main ID of this survey response
	 */
	public long getSurveyMainId();

	/**
	 * Sets the survey main ID of this survey response.
	 *
	 * @param surveyMainId the survey main ID of this survey response
	 */
	public void setSurveyMainId(long surveyMainId);

	/**
	 * Returns the writer ID of this survey response.
	 *
	 * @return the writer ID of this survey response
	 */
	public long getWriterId();

	/**
	 * Sets the writer ID of this survey response.
	 *
	 * @param writerId the writer ID of this survey response
	 */
	public void setWriterId(long writerId);

	/**
	 * Returns the response of this survey response.
	 *
	 * @return the response of this survey response
	 */
	@AutoEscape
	public String getResponse();

	/**
	 * Sets the response of this survey response.
	 *
	 * @param response the response of this survey response
	 */
	public void setResponse(String response);

	/**
	 * Returns the creator ID of this survey response.
	 *
	 * @return the creator ID of this survey response
	 */
	public long getCreatorId();

	/**
	 * Sets the creator ID of this survey response.
	 *
	 * @param creatorId the creator ID of this survey response
	 */
	public void setCreatorId(long creatorId);

	/**
	 * Returns the create date of this survey response.
	 *
	 * @return the create date of this survey response
	 */
	public long getCreateDate();

	/**
	 * Sets the create date of this survey response.
	 *
	 * @param createDate the create date of this survey response
	 */
	public void setCreateDate(long createDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.lc.survey.model.SurveyResponse surveyResponse);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.lc.survey.model.SurveyResponse> toCacheModel();

	@Override
	public com.lc.survey.model.SurveyResponse toEscapedModel();

	@Override
	public com.lc.survey.model.SurveyResponse toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}