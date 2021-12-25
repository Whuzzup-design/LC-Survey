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
 * Provides a wrapper for {@link SurveyWriterLocalService}.
 *
 * @author kevin
 * @see SurveyWriterLocalService
 * @generated
 */
public class SurveyWriterLocalServiceWrapper implements SurveyWriterLocalService,
	ServiceWrapper<SurveyWriterLocalService> {
	public SurveyWriterLocalServiceWrapper(
		SurveyWriterLocalService surveyWriterLocalService) {
		_surveyWriterLocalService = surveyWriterLocalService;
	}

	/**
	* Adds the survey writer to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyWriter the survey writer
	* @return the survey writer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyWriter addSurveyWriter(
		com.lc.survey.model.SurveyWriter surveyWriter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.addSurveyWriter(surveyWriter);
	}

	/**
	* Creates a new survey writer with the primary key. Does not add the survey writer to the database.
	*
	* @param surveyWriterId the primary key for the new survey writer
	* @return the new survey writer
	*/
	@Override
	public com.lc.survey.model.SurveyWriter createSurveyWriter(
		long surveyWriterId) {
		return _surveyWriterLocalService.createSurveyWriter(surveyWriterId);
	}

	/**
	* Deletes the survey writer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyWriterId the primary key of the survey writer
	* @return the survey writer that was removed
	* @throws PortalException if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyWriter deleteSurveyWriter(
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.deleteSurveyWriter(surveyWriterId);
	}

	/**
	* Deletes the survey writer from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyWriter the survey writer
	* @return the survey writer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyWriter deleteSurveyWriter(
		com.lc.survey.model.SurveyWriter surveyWriter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.deleteSurveyWriter(surveyWriter);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyWriterLocalService.dynamicQuery();
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
		return _surveyWriterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyWriterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyWriterLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _surveyWriterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyWriterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyWriter fetchSurveyWriter(
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.fetchSurveyWriter(surveyWriterId);
	}

	/**
	* Returns the survey writer with the primary key.
	*
	* @param surveyWriterId the primary key of the survey writer
	* @return the survey writer
	* @throws PortalException if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyWriter getSurveyWriter(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.getSurveyWriter(surveyWriterId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey writers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @return the range of survey writers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyWriter> getSurveyWriters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.getSurveyWriters(start, end);
	}

	/**
	* Returns the number of survey writers.
	*
	* @return the number of survey writers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyWritersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.getSurveyWritersCount();
	}

	/**
	* Updates the survey writer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyWriter the survey writer
	* @return the survey writer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyWriter updateSurveyWriter(
		com.lc.survey.model.SurveyWriter surveyWriter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.updateSurveyWriter(surveyWriter);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyWriterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyWriterLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyWriterLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyWriter(
		com.lc.survey.model.SurveyWriter surveyWriter, long surveyMainId,
		boolean isPreview, boolean isComplete, long completionTime,
		long creatorId, long createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyWriterLocalService.updateSurveyWriter(surveyWriter,
			surveyMainId, isPreview, isComplete, completionTime, creatorId,
			createDate);
	}

	@Override
	public void updateToCompleted(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyWriterLocalService.updateToCompleted(surveyWriterId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyWriter> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.findBySurveyMainId(surveyMainId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyWriter> findByM_P_C(
		long surveyMainId, boolean isPreview, boolean isComplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.findByM_P_C(surveyMainId, isPreview,
			isComplete);
	}

	@Override
	public int countByM_P_C(long surveyMainId, boolean isPreview,
		boolean isComplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyWriterLocalService.countByM_P_C(surveyMainId, isPreview,
			isComplete);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		_surveyWriterLocalService.removeBySurveyMainId(surveyMainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyWriterLocalService getWrappedSurveyWriterLocalService() {
		return _surveyWriterLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyWriterLocalService(
		SurveyWriterLocalService surveyWriterLocalService) {
		_surveyWriterLocalService = surveyWriterLocalService;
	}

	@Override
	public SurveyWriterLocalService getWrappedService() {
		return _surveyWriterLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyWriterLocalService surveyWriterLocalService) {
		_surveyWriterLocalService = surveyWriterLocalService;
	}

	private SurveyWriterLocalService _surveyWriterLocalService;
}