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

package com.lc.survey.service.persistence;

import com.lc.survey.model.SurveyResult;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the survey result service. This utility wraps {@link SurveyResultPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyResultPersistence
 * @see SurveyResultPersistenceImpl
 * @generated
 */
public class SurveyResultUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SurveyResult surveyResult) {
		getPersistence().clearCache(surveyResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SurveyResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyResult> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyResult update(SurveyResult surveyResult)
		throws SystemException {
		return getPersistence().update(surveyResult);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyResult update(SurveyResult surveyResult,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyResult, serviceContext);
	}

	/**
	* Returns all the survey results where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId);
	}

	/**
	* Returns a range of all the survey results where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @return the range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId, start, end);
	}

	/**
	* Returns an ordered range of all the survey results where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId(surveyMainId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the survey results before and after the current survey result in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyResultId the primary key of the current survey result
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult[] findBySurveyMainId_PrevAndNext(
		long surveyResultId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_PrevAndNext(surveyResultId,
			surveyMainId, orderByComparator);
	}

	/**
	* Removes all the survey results where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyMainId(surveyMainId);
	}

	/**
	* Returns the number of survey results where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyMainId(surveyMainId);
	}

	/**
	* Returns all the survey results where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @return the matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findBySurveyWriterId(
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyWriterId(surveyWriterId);
	}

	/**
	* Returns a range of all the survey results where surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @return the range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findBySurveyWriterId(
		long surveyWriterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyWriterId(surveyWriterId, start, end);
	}

	/**
	* Returns an ordered range of all the survey results where surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findBySurveyWriterId(
		long surveyWriterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId(surveyWriterId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findBySurveyWriterId_First(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId_First(surveyWriterId, orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchBySurveyWriterId_First(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyWriterId_First(surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findBySurveyWriterId_Last(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId_Last(surveyWriterId, orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchBySurveyWriterId_Last(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyWriterId_Last(surveyWriterId, orderByComparator);
	}

	/**
	* Returns the survey results before and after the current survey result in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyResultId the primary key of the current survey result
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult[] findBySurveyWriterId_PrevAndNext(
		long surveyResultId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId_PrevAndNext(surveyResultId,
			surveyWriterId, orderByComparator);
	}

	/**
	* Removes all the survey results where surveyWriterId = &#63; from the database.
	*
	* @param surveyWriterId the survey writer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyWriterId(surveyWriterId);
	}

	/**
	* Returns the number of survey results where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @return the number of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyWriterId(surveyWriterId);
	}

	/**
	* Returns all the survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @return the matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByP_W(
		long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByP_W(surveyPageId, surveyWriterId);
	}

	/**
	* Returns a range of all the survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @return the range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByP_W(
		long surveyPageId, long surveyWriterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_W(surveyPageId, surveyWriterId, start, end);
	}

	/**
	* Returns an ordered range of all the survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByP_W(
		long surveyPageId, long surveyWriterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_W(surveyPageId, surveyWriterId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByP_W_First(
		long surveyPageId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_W_First(surveyPageId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByP_W_First(
		long surveyPageId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_W_First(surveyPageId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByP_W_Last(
		long surveyPageId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_W_Last(surveyPageId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByP_W_Last(
		long surveyPageId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByP_W_Last(surveyPageId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the survey results before and after the current survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyResultId the primary key of the current survey result
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult[] findByP_W_PrevAndNext(
		long surveyResultId, long surveyPageId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByP_W_PrevAndNext(surveyResultId, surveyPageId,
			surveyWriterId, orderByComparator);
	}

	/**
	* Removes all the survey results where surveyPageId = &#63; and surveyWriterId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByP_W(long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByP_W(surveyPageId, surveyWriterId);
	}

	/**
	* Returns the number of survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param surveyWriterId the survey writer ID
	* @return the number of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByP_W(long surveyPageId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByP_W(surveyPageId, surveyWriterId);
	}

	/**
	* Returns all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @return the matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_W(
		long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQ_W(surveyQuestionId, surveyWriterId);
	}

	/**
	* Returns a range of all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @return the range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_W(
		long surveyQuestionId, long surveyWriterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_W(surveyQuestionId, surveyWriterId, start, end);
	}

	/**
	* Returns an ordered range of all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_W(
		long surveyQuestionId, long surveyWriterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_W(surveyQuestionId, surveyWriterId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByQ_W_First(
		long surveyQuestionId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_W_First(surveyQuestionId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByQ_W_First(
		long surveyQuestionId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQ_W_First(surveyQuestionId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByQ_W_Last(
		long surveyQuestionId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_W_Last(surveyQuestionId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByQ_W_Last(
		long surveyQuestionId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQ_W_Last(surveyQuestionId, surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the survey results before and after the current survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyResultId the primary key of the current survey result
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult[] findByQ_W_PrevAndNext(
		long surveyResultId, long surveyQuestionId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_W_PrevAndNext(surveyResultId, surveyQuestionId,
			surveyWriterId, orderByComparator);
	}

	/**
	* Removes all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63; from the database.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQ_W(long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQ_W(surveyQuestionId, surveyWriterId);
	}

	/**
	* Returns the number of survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyWriterId the survey writer ID
	* @return the number of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQ_W(long surveyQuestionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQ_W(surveyQuestionId, surveyWriterId);
	}

	/**
	* Returns all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @return the matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_O(
		long surveyQuestionId, long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQ_O(surveyQuestionId, surveyOptionId);
	}

	/**
	* Returns a range of all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @return the range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_O(
		long surveyQuestionId, long surveyOptionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_O(surveyQuestionId, surveyOptionId, start, end);
	}

	/**
	* Returns an ordered range of all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findByQ_O(
		long surveyQuestionId, long surveyOptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_O(surveyQuestionId, surveyOptionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByQ_O_First(
		long surveyQuestionId, long surveyOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_O_First(surveyQuestionId, surveyOptionId,
			orderByComparator);
	}

	/**
	* Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByQ_O_First(
		long surveyQuestionId, long surveyOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQ_O_First(surveyQuestionId, surveyOptionId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByQ_O_Last(
		long surveyQuestionId, long surveyOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_O_Last(surveyQuestionId, surveyOptionId,
			orderByComparator);
	}

	/**
	* Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByQ_O_Last(
		long surveyQuestionId, long surveyOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQ_O_Last(surveyQuestionId, surveyOptionId,
			orderByComparator);
	}

	/**
	* Returns the survey results before and after the current survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyResultId the primary key of the current survey result
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult[] findByQ_O_PrevAndNext(
		long surveyResultId, long surveyQuestionId, long surveyOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_O_PrevAndNext(surveyResultId, surveyQuestionId,
			surveyOptionId, orderByComparator);
	}

	/**
	* Removes all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63; from the database.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQ_O(long surveyQuestionId, long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQ_O(surveyQuestionId, surveyOptionId);
	}

	/**
	* Returns the number of survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param surveyOptionId the survey option ID
	* @return the number of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQ_O(long surveyQuestionId, long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQ_O(surveyQuestionId, surveyOptionId);
	}

	/**
	* Returns the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; or throws a {@link com.lc.survey.NoSuchSurveyResultException} if it could not be found.
	*
	* @param surveyOptionId the survey option ID
	* @param surveyWriterId the survey writer ID
	* @return the matching survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByO_W(
		long surveyOptionId, long surveyWriterId)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByO_W(surveyOptionId, surveyWriterId);
	}

	/**
	* Returns the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param surveyOptionId the survey option ID
	* @param surveyWriterId the survey writer ID
	* @return the matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByO_W(
		long surveyOptionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByO_W(surveyOptionId, surveyWriterId);
	}

	/**
	* Returns the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param surveyOptionId the survey option ID
	* @param surveyWriterId the survey writer ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching survey result, or <code>null</code> if a matching survey result could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByO_W(
		long surveyOptionId, long surveyWriterId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByO_W(surveyOptionId, surveyWriterId, retrieveFromCache);
	}

	/**
	* Removes the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; from the database.
	*
	* @param surveyOptionId the survey option ID
	* @param surveyWriterId the survey writer ID
	* @return the survey result that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult removeByO_W(
		long surveyOptionId, long surveyWriterId)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByO_W(surveyOptionId, surveyWriterId);
	}

	/**
	* Returns the number of survey results where surveyOptionId = &#63; and surveyWriterId = &#63;.
	*
	* @param surveyOptionId the survey option ID
	* @param surveyWriterId the survey writer ID
	* @return the number of matching survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countByO_W(long surveyOptionId, long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByO_W(surveyOptionId, surveyWriterId);
	}

	/**
	* Caches the survey result in the entity cache if it is enabled.
	*
	* @param surveyResult the survey result
	*/
	public static void cacheResult(
		com.lc.survey.model.SurveyResult surveyResult) {
		getPersistence().cacheResult(surveyResult);
	}

	/**
	* Caches the survey results in the entity cache if it is enabled.
	*
	* @param surveyResults the survey results
	*/
	public static void cacheResult(
		java.util.List<com.lc.survey.model.SurveyResult> surveyResults) {
		getPersistence().cacheResult(surveyResults);
	}

	/**
	* Creates a new survey result with the primary key. Does not add the survey result to the database.
	*
	* @param surveyResultId the primary key for the new survey result
	* @return the new survey result
	*/
	public static com.lc.survey.model.SurveyResult create(long surveyResultId) {
		return getPersistence().create(surveyResultId);
	}

	/**
	* Removes the survey result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result that was removed
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult remove(long surveyResultId)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(surveyResultId);
	}

	public static com.lc.survey.model.SurveyResult updateImpl(
		com.lc.survey.model.SurveyResult surveyResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyResult);
	}

	/**
	* Returns the survey result with the primary key or throws a {@link com.lc.survey.NoSuchSurveyResultException} if it could not be found.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result
	* @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult findByPrimaryKey(
		long surveyResultId)
		throws com.lc.survey.NoSuchSurveyResultException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(surveyResultId);
	}

	/**
	* Returns the survey result with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyResultId the primary key of the survey result
	* @return the survey result, or <code>null</code> if a survey result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyResult fetchByPrimaryKey(
		long surveyResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(surveyResultId);
	}

	/**
	* Returns all the survey results.
	*
	* @return the survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.lc.survey.model.SurveyResult> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the survey results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey results
	* @param end the upper bound of the range of survey results (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey results
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyResult> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey results from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey results.
	*
	* @return the number of survey results
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SurveyResultPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyResultPersistence)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyResultPersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyResultUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyResultPersistence persistence) {
	}

	private static SurveyResultPersistence _persistence;
}