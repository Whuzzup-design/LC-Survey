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
 * Provides a wrapper for {@link SurveyOptionLocalService}.
 *
 * @author kevin
 * @see SurveyOptionLocalService
 * @generated
 */
public class SurveyOptionLocalServiceWrapper implements SurveyOptionLocalService,
	ServiceWrapper<SurveyOptionLocalService> {
	public SurveyOptionLocalServiceWrapper(
		SurveyOptionLocalService surveyOptionLocalService) {
		_surveyOptionLocalService = surveyOptionLocalService;
	}

	/**
	* Adds the survey option to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOption the survey option
	* @return the survey option that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyOption addSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.addSurveyOption(surveyOption);
	}

	/**
	* Creates a new survey option with the primary key. Does not add the survey option to the database.
	*
	* @param surveyOptionId the primary key for the new survey option
	* @return the new survey option
	*/
	@Override
	public com.lc.survey.model.SurveyOption createSurveyOption(
		long surveyOptionId) {
		return _surveyOptionLocalService.createSurveyOption(surveyOptionId);
	}

	/**
	* Deletes the survey option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option that was removed
	* @throws PortalException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyOption deleteSurveyOption(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.deleteSurveyOption(surveyOptionId);
	}

	/**
	* Deletes the survey option from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOption the survey option
	* @return the survey option that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyOption deleteSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.deleteSurveyOption(surveyOption);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyOptionLocalService.dynamicQuery();
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
		return _surveyOptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyOptionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyOptionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _surveyOptionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyOptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyOption fetchSurveyOption(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.fetchSurveyOption(surveyOptionId);
	}

	/**
	* Returns the survey option with the primary key.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option
	* @throws PortalException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyOption getSurveyOption(long surveyOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.getSurveyOption(surveyOptionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @return the range of survey options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyOption> getSurveyOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.getSurveyOptions(start, end);
	}

	/**
	* Returns the number of survey options.
	*
	* @return the number of survey options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.getSurveyOptionsCount();
	}

	/**
	* Updates the survey option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyOption the survey option
	* @return the survey option that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyOption updateSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.updateSurveyOption(surveyOption);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyOptionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyOptionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyOptionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption, long surveyMainId,
		long surveyPageId, long surveyQuestionId, int no,
		java.lang.String option, boolean isAns, long pageDirectId,
		long uploadFileId, long userId, long modifiedDate,
		java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyOptionLocalService.updateSurveyOption(surveyOption,
			surveyMainId, surveyPageId, surveyQuestionId, no, option, isAns,
			pageDirectId, uploadFileId, userId, modifiedDate, action);
	}

	@Override
	public boolean isExisted(long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.isExisted(surveyOptionId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.findBySurveyQuestionId(surveyQuestionId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.findBySurveyPageId(surveyPageId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.findBySurveyMainId(surveyMainId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.findByQ_I(surveyQuestionId, isAns);
	}

	@Override
	public long getPageDirectIdByOptionId(long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyOptionLocalService.getPageDirectIdByOptionId(surveyOptionId);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyOptionLocalService.removeBySurveyMainId(surveyMainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyOptionLocalService getWrappedSurveyOptionLocalService() {
		return _surveyOptionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyOptionLocalService(
		SurveyOptionLocalService surveyOptionLocalService) {
		_surveyOptionLocalService = surveyOptionLocalService;
	}

	@Override
	public SurveyOptionLocalService getWrappedService() {
		return _surveyOptionLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyOptionLocalService surveyOptionLocalService) {
		_surveyOptionLocalService = surveyOptionLocalService;
	}

	private SurveyOptionLocalService _surveyOptionLocalService;
}