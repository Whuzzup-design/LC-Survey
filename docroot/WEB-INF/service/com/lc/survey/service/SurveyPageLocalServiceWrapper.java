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
 * Provides a wrapper for {@link SurveyPageLocalService}.
 *
 * @author kevin
 * @see SurveyPageLocalService
 * @generated
 */
public class SurveyPageLocalServiceWrapper implements SurveyPageLocalService,
	ServiceWrapper<SurveyPageLocalService> {
	public SurveyPageLocalServiceWrapper(
		SurveyPageLocalService surveyPageLocalService) {
		_surveyPageLocalService = surveyPageLocalService;
	}

	/**
	* Adds the survey page to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyPage the survey page
	* @return the survey page that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyPage addSurveyPage(
		com.lc.survey.model.SurveyPage surveyPage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.addSurveyPage(surveyPage);
	}

	/**
	* Creates a new survey page with the primary key. Does not add the survey page to the database.
	*
	* @param surveyPageId the primary key for the new survey page
	* @return the new survey page
	*/
	@Override
	public com.lc.survey.model.SurveyPage createSurveyPage(long surveyPageId) {
		return _surveyPageLocalService.createSurveyPage(surveyPageId);
	}

	/**
	* Deletes the survey page with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page that was removed
	* @throws PortalException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyPage deleteSurveyPage(long surveyPageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.deleteSurveyPage(surveyPageId);
	}

	/**
	* Deletes the survey page from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyPage the survey page
	* @return the survey page that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyPage deleteSurveyPage(
		com.lc.survey.model.SurveyPage surveyPage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.deleteSurveyPage(surveyPage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyPageLocalService.dynamicQuery();
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
		return _surveyPageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyPageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyPageLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _surveyPageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyPageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyPage fetchSurveyPage(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.fetchSurveyPage(surveyPageId);
	}

	/**
	* Returns the survey page with the primary key.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page
	* @throws PortalException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyPage getSurveyPage(long surveyPageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getSurveyPage(surveyPageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey pages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey pages
	* @param end the upper bound of the range of survey pages (not inclusive)
	* @return the range of survey pages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.lc.survey.model.SurveyPage> getSurveyPages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getSurveyPages(start, end);
	}

	/**
	* Returns the number of survey pages.
	*
	* @return the number of survey pages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyPagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getSurveyPagesCount();
	}

	/**
	* Updates the survey page in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyPage the survey page
	* @return the survey page that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyPage updateSurveyPage(
		com.lc.survey.model.SurveyPage surveyPage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.updateSurveyPage(surveyPage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyPageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyPageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyPageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyPage(com.lc.survey.model.SurveyPage surveyPage,
		long surveyMainId, int no, java.lang.String title, long pageDirectId,
		long userId, long modifiedDate, java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyPageLocalService.updateSurveyPage(surveyPage, surveyMainId, no,
			title, pageDirectId, userId, modifiedDate, action);
	}

	@Override
	public boolean isExisted(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.isExisted(surveyPageId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.findBySurveyMainId(surveyMainId);
	}

	@Override
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.countBySurveyMainId(surveyMainId);
	}

	@Override
	public com.lc.survey.model.SurveyPage findBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.findBySurveyMainIdAndNo(surveyMainId, no);
	}

	@Override
	public int getPageNoByPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getPageNoByPageId(surveyPageId);
	}

	@Override
	public int getChoiceQuestionCountsByPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getChoiceQuestionCountsByPageId(surveyPageId);
	}

	@Override
	public long getPageDirectIdByPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyPageLocalService.getPageDirectIdByPageId(surveyPageId);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyPageLocalService.removeBySurveyMainId(surveyMainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyPageLocalService getWrappedSurveyPageLocalService() {
		return _surveyPageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyPageLocalService(
		SurveyPageLocalService surveyPageLocalService) {
		_surveyPageLocalService = surveyPageLocalService;
	}

	@Override
	public SurveyPageLocalService getWrappedService() {
		return _surveyPageLocalService;
	}

	@Override
	public void setWrappedService(SurveyPageLocalService surveyPageLocalService) {
		_surveyPageLocalService = surveyPageLocalService;
	}

	private SurveyPageLocalService _surveyPageLocalService;
}