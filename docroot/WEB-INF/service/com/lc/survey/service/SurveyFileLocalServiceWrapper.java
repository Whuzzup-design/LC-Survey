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
 * Provides a wrapper for {@link SurveyFileLocalService}.
 *
 * @author kevin
 * @see SurveyFileLocalService
 * @generated
 */
public class SurveyFileLocalServiceWrapper implements SurveyFileLocalService,
	ServiceWrapper<SurveyFileLocalService> {
	public SurveyFileLocalServiceWrapper(
		SurveyFileLocalService surveyFileLocalService) {
		_surveyFileLocalService = surveyFileLocalService;
	}

	/**
	* Adds the survey file to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyFile the survey file
	* @return the survey file that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyFile addSurveyFile(
		com.lc.survey.model.SurveyFile surveyFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.addSurveyFile(surveyFile);
	}

	/**
	* Creates a new survey file with the primary key. Does not add the survey file to the database.
	*
	* @param surveyFileId the primary key for the new survey file
	* @return the new survey file
	*/
	@Override
	public com.lc.survey.model.SurveyFile createSurveyFile(long surveyFileId) {
		return _surveyFileLocalService.createSurveyFile(surveyFileId);
	}

	/**
	* Deletes the survey file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyFileId the primary key of the survey file
	* @return the survey file that was removed
	* @throws PortalException if a survey file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyFile deleteSurveyFile(long surveyFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.deleteSurveyFile(surveyFileId);
	}

	/**
	* Deletes the survey file from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyFile the survey file
	* @return the survey file that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyFile deleteSurveyFile(
		com.lc.survey.model.SurveyFile surveyFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.deleteSurveyFile(surveyFile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyFileLocalService.dynamicQuery();
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
		return _surveyFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyFileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyFileLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _surveyFileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyFileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyFile fetchSurveyFile(long surveyFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.fetchSurveyFile(surveyFileId);
	}

	/**
	* Returns the survey file with the primary key.
	*
	* @param surveyFileId the primary key of the survey file
	* @return the survey file
	* @throws PortalException if a survey file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyFile getSurveyFile(long surveyFileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.getSurveyFile(surveyFileId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey files
	* @param end the upper bound of the range of survey files (not inclusive)
	* @return the range of survey files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyFile> getSurveyFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.getSurveyFiles(start, end);
	}

	/**
	* Returns the number of survey files.
	*
	* @return the number of survey files
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.getSurveyFilesCount();
	}

	/**
	* Updates the survey file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyFile the survey file
	* @return the survey file that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyFile updateSurveyFile(
		com.lc.survey.model.SurveyFile surveyFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.updateSurveyFile(surveyFile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyFileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyFile(com.lc.survey.model.SurveyFile surveyFile,
		long surveyMainId, java.lang.String fileName, long creatorId,
		long createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyFileLocalService.updateSurveyFile(surveyFile, surveyMainId,
			fileName, creatorId, createDate);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyFile> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.findBySurveyMainId(surveyMainId);
	}

	@Override
	public boolean isExisted(long surveyFileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyFileLocalService.isExisted(surveyFileId);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyFileLocalService.removeBySurveyMainId(surveyMainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyFileLocalService getWrappedSurveyFileLocalService() {
		return _surveyFileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyFileLocalService(
		SurveyFileLocalService surveyFileLocalService) {
		_surveyFileLocalService = surveyFileLocalService;
	}

	@Override
	public SurveyFileLocalService getWrappedService() {
		return _surveyFileLocalService;
	}

	@Override
	public void setWrappedService(SurveyFileLocalService surveyFileLocalService) {
		_surveyFileLocalService = surveyFileLocalService;
	}

	private SurveyFileLocalService _surveyFileLocalService;
}