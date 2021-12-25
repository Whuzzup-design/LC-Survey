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
 * Provides the local service utility for SurveyOption. This utility wraps
 * {@link com.lc.survey.service.impl.SurveyOptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author kevin
 * @see SurveyOptionLocalService
 * @see com.lc.survey.service.base.SurveyOptionLocalServiceBaseImpl
 * @see com.lc.survey.service.impl.SurveyOptionLocalServiceImpl
 * @generated
 */
public class SurveyOptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.lc.survey.service.impl.SurveyOptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the survey option to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOption the survey option
	* @return the survey option that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption addSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSurveyOption(surveyOption);
	}

	/**
	* Creates a new survey option with the primary key. Does not add the survey option to the database.
	*
	* @param surveyOptionId the primary key for the new survey option
	* @return the new survey option
	*/
	public static com.lc.survey.model.SurveyOption createSurveyOption(
		long surveyOptionId) {
		return getService().createSurveyOption(surveyOptionId);
	}

	/**
	* Deletes the survey option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option that was removed
	* @throws PortalException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption deleteSurveyOption(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurveyOption(surveyOptionId);
	}

	/**
	* Deletes the survey option from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOption the survey option
	* @return the survey option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption deleteSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurveyOption(surveyOption);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.lc.survey.model.SurveyOption fetchSurveyOption(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSurveyOption(surveyOptionId);
	}

	/**
	* Returns the survey option with the primary key.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option
	* @throws PortalException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption getSurveyOption(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyOption(surveyOptionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.lc.survey.model.SurveyOption> getSurveyOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyOptions(start, end);
	}

	/**
	* Returns the number of survey options.
	*
	* @return the number of survey options
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyOptionsCount();
	}

	/**
	* Updates the survey option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyOption the survey option
	* @return the survey option that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption updateSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSurveyOption(surveyOption);
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

	public static void updateSurveyOption(
		com.lc.survey.model.SurveyOption surveyOption, long surveyMainId,
		long surveyPageId, long surveyQuestionId, int no,
		java.lang.String option, boolean isAns, long pageDirectId,
		long uploadFileId, long userId, long modifiedDate,
		java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateSurveyOption(surveyOption, surveyMainId, surveyPageId,
			surveyQuestionId, no, option, isAns, pageDirectId, uploadFileId,
			userId, modifiedDate, action);
	}

	public static boolean isExisted(long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isExisted(surveyOptionId);
	}

	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBySurveyQuestionId(surveyQuestionId);
	}

	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBySurveyPageId(surveyPageId);
	}

	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBySurveyMainId(surveyMainId);
	}

	public static java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByQ_I(surveyQuestionId, isAns);
	}

	public static long getPageDirectIdByOptionId(long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPageDirectIdByOptionId(surveyOptionId);
	}

	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeBySurveyMainId(surveyMainId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SurveyOptionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SurveyOptionLocalService.class.getName());

			if (invokableLocalService instanceof SurveyOptionLocalService) {
				_service = (SurveyOptionLocalService)invokableLocalService;
			}
			else {
				_service = new SurveyOptionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SurveyOptionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SurveyOptionLocalService service) {
	}

	private static SurveyOptionLocalService _service;
}