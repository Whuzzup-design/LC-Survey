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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SurveyResult. This utility wraps
 * {@link com.lc.survey.service.impl.SurveyResultLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author kevin
 * @see SurveyResultLocalService
 * @see com.lc.survey.service.base.SurveyResultLocalServiceBaseImpl
 * @see com.lc.survey.service.impl.SurveyResultLocalServiceImpl
 * @generated
 */
public class SurveyResultLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.lc.survey.service.impl.SurveyResultLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the survey result to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResult the survey result
	* @return the survey result that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult addSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSurveyResult(surveyResult);
	}

	/**
	* Creates a new survey result with the primary key. Does not add the survey result to the database.
	*
	* @param surveyResultId the primary key for the new survey result
	* @return the new survey result
	*/
	public static com.lc.survey.model.SurveyResult createSurveyResult(
		long surveyResultId) {
		return getService().createSurveyResult(surveyResultId);
	}

	/**
	* Deletes the survey result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result that was removed
	* @throws PortalException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult deleteSurveyResult(
		long surveyResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurveyResult(surveyResultId);
	}

	/**
	* Deletes the survey result from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResult the survey result
	* @return the survey result that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult deleteSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurveyResult(surveyResult);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.lc.survey.model.SurveyResult fetchSurveyResult(
		long surveyResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSurveyResult(surveyResultId);
	}

	/**
	* Returns the survey result with the primary key.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result
	* @throws PortalException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult getSurveyResult(
		long surveyResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyResult(surveyResultId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.lc.survey.model.SurveyResult> getSurveyResults(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyResults(start, end);
	}

	/**
	* Returns the number of survey results.
	*
	* @return the number of survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyResultsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyResultsCount();
	}

	/**
	* Updates the survey result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyResult the survey result
	* @return the survey result that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult updateSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSurveyResult(surveyResult);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void updateSurveyResult(
		com.lc.survey.model.SurveyResult surveyResult, long surveyMainId,
		long surveyPageId, long surveyQuestionId, long surveyOptionId,
		long surveyWriterId, java.lang.String ans, long creatorId,
		long createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateSurveyResult(surveyResult, surveyMainId, surveyPageId,
			surveyQuestionId, surveyOptionId, surveyWriterId, ans, creatorId,
			createDate);
	}

	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeBySurveyMainId(surveyMainId);
	}

	public static void removeBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeBySurveyWriterId(surveyWriterId);
	}

	public static void removeByP_W(long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByP_W(surveyPageId, surveyWriterId);
	}

	public static void removeByM_C_N_W(long surveyMainId, long currentPageId,
		long nextPageId, long surveyWriterId)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.removeByM_C_N_W(surveyMainId, currentPageId, nextPageId,
			surveyWriterId);
	}

	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_W(
		long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByQ_W(surveyQuestionId, surveyWriterId);
	}

	public static com.lc.survey.model.SurveyResult findByO_W(
		long surveyOptionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByO_W(surveyOptionId, surveyWriterId);
	}

	public static int countByP_W(long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByP_W(surveyPageId, surveyWriterId);
	}

	public static int countByQ_O(long surveyQuestionId, long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByQ_O(surveyQuestionId, surveyOptionId);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getResultByQ_W(
		long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResultByQ_W(surveyQuestionId, surveyWriterId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SurveyResultLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SurveyResultLocalService.class.getName());

			if (invokableLocalService instanceof SurveyResultLocalService) {
				_service = (SurveyResultLocalService)invokableLocalService;
			}
			else {
				_service = new SurveyResultLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SurveyResultLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SurveyResultLocalService service) {
	}

	private static SurveyResultLocalService _service;
}