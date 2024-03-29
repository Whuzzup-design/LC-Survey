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
 * Provides a wrapper for {@link SurveyMainLocalService}.
 *
 * @author kevin
 * @see SurveyMainLocalService
 * @generated
 */
public class SurveyMainLocalServiceWrapper implements SurveyMainLocalService,
	ServiceWrapper<SurveyMainLocalService> {
	public SurveyMainLocalServiceWrapper(
		SurveyMainLocalService surveyMainLocalService) {
		_surveyMainLocalService = surveyMainLocalService;
	}

	/**
	* Adds the survey main to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyMain the survey main
	* @return the survey main that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyMain addSurveyMain(
		com.lc.survey.model.SurveyMain surveyMain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.addSurveyMain(surveyMain);
	}

	/**
	* Creates a new survey main with the primary key. Does not add the survey main to the database.
	*
	* @param surveyMainId the primary key for the new survey main
	* @return the new survey main
	*/
	@Override
	public com.lc.survey.model.SurveyMain createSurveyMain(long surveyMainId) {
		return _surveyMainLocalService.createSurveyMain(surveyMainId);
	}

	/**
	* Deletes the survey main with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyMainId the primary key of the survey main
	* @return the survey main that was removed
	* @throws PortalException if a survey main with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyMain deleteSurveyMain(long surveyMainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.deleteSurveyMain(surveyMainId);
	}

	/**
	* Deletes the survey main from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyMain the survey main
	* @return the survey main that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyMain deleteSurveyMain(
		com.lc.survey.model.SurveyMain surveyMain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.deleteSurveyMain(surveyMain);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyMainLocalService.dynamicQuery();
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
		return _surveyMainLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyMainLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyMainLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _surveyMainLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyMainLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyMain fetchSurveyMain(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.fetchSurveyMain(surveyMainId);
	}

	/**
	* Returns the survey main with the primary key.
	*
	* @param surveyMainId the primary key of the survey main
	* @return the survey main
	* @throws PortalException if a survey main with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyMain getSurveyMain(long surveyMainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.getSurveyMain(surveyMainId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey mains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey mains
	* @param end the upper bound of the range of survey mains (not inclusive)
	* @return the range of survey mains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyMain> getSurveyMains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.getSurveyMains(start, end);
	}

	/**
	* Returns the number of survey mains.
	*
	* @return the number of survey mains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyMainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.getSurveyMainsCount();
	}

	/**
	* Updates the survey main in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyMain the survey main
	* @return the survey main that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyMain updateSurveyMain(
		com.lc.survey.model.SurveyMain surveyMain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.updateSurveyMain(surveyMain);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyMainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyMainLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyMainLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyMain(com.lc.survey.model.SurveyMain surveyMain,
		java.lang.String title, java.lang.String description,
		java.lang.String epilog, java.util.Date startDate,
		java.util.Date endDate, boolean needAuth, boolean calculateScore,
		boolean viewAnswer, java.lang.String color, long userId,
		long modifiedDate, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyMainLocalService.updateSurveyMain(surveyMain, title,
			description, epilog, startDate, endDate, needAuth, calculateScore,
			viewAnswer, color, userId, modifiedDate, action);
	}

	@Override
	public boolean isExisted(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyMainLocalService.isExisted(surveyMainId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyMain> findForSearch(
		long creatorId, java.lang.String openTime,
		java.lang.String calculateScore, java.lang.String title) {
		return _surveyMainLocalService.findForSearch(creatorId, openTime,
			calculateScore, title);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyMainLocalService getWrappedSurveyMainLocalService() {
		return _surveyMainLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyMainLocalService(
		SurveyMainLocalService surveyMainLocalService) {
		_surveyMainLocalService = surveyMainLocalService;
	}

	@Override
	public SurveyMainLocalService getWrappedService() {
		return _surveyMainLocalService;
	}

	@Override
	public void setWrappedService(SurveyMainLocalService surveyMainLocalService) {
		_surveyMainLocalService = surveyMainLocalService;
	}

	private SurveyMainLocalService _surveyMainLocalService;
}