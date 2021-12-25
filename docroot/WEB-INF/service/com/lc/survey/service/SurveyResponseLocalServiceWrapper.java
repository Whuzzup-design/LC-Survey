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

package com.lc.survey.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SurveyResponseLocalService}.
 *
 * @author kevin
 * @see SurveyResponseLocalService
 * @generated
 */
public class SurveyResponseLocalServiceWrapper
	implements SurveyResponseLocalService,
		ServiceWrapper<SurveyResponseLocalService> {
	public SurveyResponseLocalServiceWrapper(
		SurveyResponseLocalService surveyResponseLocalService) {
		_surveyResponseLocalService = surveyResponseLocalService;
	}

	/**
	* Adds the survey response to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResponse the survey response
	* @return the survey response that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResponse addSurveyResponse(
		com.lc.survey.model.SurveyResponse surveyResponse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.addSurveyResponse(surveyResponse);
	}

	/**
	* Creates a new survey response with the primary key. Does not add the survey response to the database.
	*
	* @param surveyResponseId the primary key for the new survey response
	* @return the new survey response
	*/
	@Override
	public com.lc.survey.model.SurveyResponse createSurveyResponse(
		long surveyResponseId) {
		return _surveyResponseLocalService.createSurveyResponse(surveyResponseId);
	}

	/**
	* Deletes the survey response with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResponseId the primary key of the survey response
	* @return the survey response that was removed
	* @throws PortalException if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResponse deleteSurveyResponse(
		long surveyResponseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.deleteSurveyResponse(surveyResponseId);
	}

	/**
	* Deletes the survey response from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResponse the survey response
	* @return the survey response that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResponse deleteSurveyResponse(
		com.lc.survey.model.SurveyResponse surveyResponse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.deleteSurveyResponse(surveyResponse);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyResponseLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyResponse fetchSurveyResponse(
		long surveyResponseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.fetchSurveyResponse(surveyResponseId);
	}

	/**
	* Returns the survey response with the primary key.
	*
	* @param surveyResponseId the primary key of the survey response
	* @return the survey response
	* @throws PortalException if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResponse getSurveyResponse(
		long surveyResponseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.getSurveyResponse(surveyResponseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey responses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @return the range of survey responses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyResponse> getSurveyResponses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.getSurveyResponses(start, end);
	}

	/**
	* Returns the number of survey responses.
	*
	* @return the number of survey responses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyResponsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.getSurveyResponsesCount();
	}

	/**
	* Updates the survey response in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyResponse the survey response
	* @return the survey response that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResponse updateSurveyResponse(
		com.lc.survey.model.SurveyResponse surveyResponse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.updateSurveyResponse(surveyResponse);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyResponseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyResponseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyResponseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyResponse(
		com.lc.survey.model.SurveyResponse surveyResponse, long surveyMainId,
		long writerId, java.lang.String response, long userId, long date)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResponseLocalService.updateSurveyResponse(surveyResponse,
			surveyMainId, writerId, response, userId, date);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResponseLocalService.removeBySurveyMainId(surveyMainId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyResponse> findByWriterId(
		long writerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.findByWriterId(writerId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyResponse> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.findBySurveyMainId(surveyMainId);
	}

	@Override
	public int countByWriterId(long writerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.countByWriterId(writerId);
	}

	@Override
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResponseLocalService.countBySurveyMainId(surveyMainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyResponseLocalService getWrappedSurveyResponseLocalService() {
		return _surveyResponseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyResponseLocalService(
		SurveyResponseLocalService surveyResponseLocalService) {
		_surveyResponseLocalService = surveyResponseLocalService;
	}

	@Override
	public SurveyResponseLocalService getWrappedService() {
		return _surveyResponseLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyResponseLocalService surveyResponseLocalService) {
		_surveyResponseLocalService = surveyResponseLocalService;
	}

	private SurveyResponseLocalService _surveyResponseLocalService;
}