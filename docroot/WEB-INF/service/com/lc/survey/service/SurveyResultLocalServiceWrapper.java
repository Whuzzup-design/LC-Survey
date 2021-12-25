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
 * Provides a wrapper for {@link SurveyResultLocalService}.
 *
 * @author kevin
 * @see SurveyResultLocalService
 * @generated
 */
public class SurveyResultLocalServiceWrapper implements SurveyResultLocalService,
	ServiceWrapper<SurveyResultLocalService> {
	public SurveyResultLocalServiceWrapper(
		SurveyResultLocalService surveyResultLocalService) {
		_surveyResultLocalService = surveyResultLocalService;
	}

	/**
	* Adds the survey result to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResult the survey result
	* @return the survey result that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResult addSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.addSurveyResult(surveyResult);
	}

	/**
	* Creates a new survey result with the primary key. Does not add the survey result to the database.
	*
	* @param surveyResultId the primary key for the new survey result
	* @return the new survey result
	*/
	@Override
	public com.lc.survey.model.SurveyResult createSurveyResult(
		long surveyResultId) {
		return _surveyResultLocalService.createSurveyResult(surveyResultId);
	}

	/**
	* Deletes the survey result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result that was removed
	* @throws PortalException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResult deleteSurveyResult(
		long surveyResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.deleteSurveyResult(surveyResultId);
	}

	/**
	* Deletes the survey result from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResult the survey result
	* @return the survey result that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResult deleteSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.deleteSurveyResult(surveyResult);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyResultLocalService.dynamicQuery();
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
		return _surveyResultLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyResultLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyResultLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _surveyResultLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyResultLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyResult fetchSurveyResult(
		long surveyResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.fetchSurveyResult(surveyResultId);
	}

	/**
	* Returns the survey result with the primary key.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result
	* @throws PortalException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResult getSurveyResult(long surveyResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.getSurveyResult(surveyResultId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @return the range of survey results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyResult> getSurveyResults(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.getSurveyResults(start, end);
	}

	/**
	* Returns the number of survey results.
	*
	* @return the number of survey results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyResultsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.getSurveyResultsCount();
	}

	/**
	* Updates the survey result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyResult the survey result
	* @return the survey result that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyResult updateSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.updateSurveyResult(surveyResult);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyResultLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyResultLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyResultLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult, long surveyMainId,
		long surveyPageId, long surveyQuestionId, long surveyOptionId,
		long surveyWriterId, java.lang.String ans, long creatorId,
		long createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResultLocalService.updateSurveyResult(surveyResult,
			surveyMainId, surveyPageId, surveyQuestionId, surveyOptionId,
			surveyWriterId, ans, creatorId, createDate);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResultLocalService.removeBySurveyMainId(surveyMainId);
	}

	@Override
	public void removeBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResultLocalService.removeBySurveyWriterId(surveyWriterId);
	}

	@Override
	public void removeByP_W(long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyResultLocalService.removeByP_W(surveyPageId, surveyWriterId);
	}

	@Override
	public void removeByM_C_N_W(long surveyMainId, long currentPageId,
		long nextPageId, long surveyWriterId)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		_surveyResultLocalService.removeByM_C_N_W(surveyMainId, currentPageId,
			nextPageId, surveyWriterId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyResult> findByQ_W(
		long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.findByQ_W(surveyQuestionId,
			surveyWriterId);
	}

	@Override
	public com.lc.survey.model.SurveyResult findByO_W(long surveyOptionId,
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.findByO_W(surveyOptionId,
			surveyWriterId);
	}

	@Override
	public int countByP_W(long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.countByP_W(surveyPageId, surveyWriterId);
	}

	@Override
	public int countByQ_O(long surveyQuestionId, long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.countByQ_O(surveyQuestionId,
			surveyOptionId);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getResultByQ_W(
		long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyResultLocalService.getResultByQ_W(surveyQuestionId,
			surveyWriterId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyResultLocalService getWrappedSurveyResultLocalService() {
		return _surveyResultLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyResultLocalService(
		SurveyResultLocalService surveyResultLocalService) {
		_surveyResultLocalService = surveyResultLocalService;
	}

	@Override
	public SurveyResultLocalService getWrappedService() {
		return _surveyResultLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyResultLocalService surveyResultLocalService) {
		_surveyResultLocalService = surveyResultLocalService;
	}

	private SurveyResultLocalService _surveyResultLocalService;
}