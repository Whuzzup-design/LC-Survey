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

import com.lc.survey.model.SurveyPage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the survey page service. This utility wraps {@link SurveyPagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyPagePersistence
 * @see SurveyPagePersistenceImpl
 * @generated
 */
public class SurveyPageUtil {
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
	public static void clearCache(SurveyPage surveyPage) {
		getPersistence().clearCache(surveyPage);
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
	public static List<SurveyPage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyPage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyPage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyPage update(SurveyPage surveyPage)
		throws SystemException {
		return getPersistence().update(surveyPage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyPage update(SurveyPage surveyPage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyPage, serviceContext);
	}

	/**
	* Returns all the survey pages where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId);
	}

	/**
	* Returns a range of all the survey pages where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey pages
	* @param end the upper bound of the range of survey pages (not inclusive)
	* @return the range of matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId, start, end);
	}

	/**
	* Returns an ordered range of all the survey pages where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey pages
	* @param end the upper bound of the range of survey pages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId(surveyMainId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the first survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the survey pages before and after the current survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyPageId the primary key of the current survey page
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage[] findBySurveyMainId_PrevAndNext(
		long surveyPageId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_PrevAndNext(surveyPageId, surveyMainId,
			orderByComparator);
	}

	/**
	* Removes all the survey pages where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyMainId(surveyMainId);
	}

	/**
	* Returns the number of survey pages where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyMainId(surveyMainId);
	}

	/**
	* Returns the survey page where surveyMainId = &#63; and no = &#63; or throws a {@link com.lc.survey.NoSuchSurveyPageException} if it could not be found.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the matching survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage findBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainIdAndNo(surveyMainId, no);
	}

	/**
	* Returns the survey page where surveyMainId = &#63; and no = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage fetchBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySurveyMainIdAndNo(surveyMainId, no);
	}

	/**
	* Returns the survey page where surveyMainId = &#63; and no = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage fetchBySurveyMainIdAndNo(
		long surveyMainId, int no, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainIdAndNo(surveyMainId, no, retrieveFromCache);
	}

	/**
	* Removes the survey page where surveyMainId = &#63; and no = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the survey page that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage removeBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBySurveyMainIdAndNo(surveyMainId, no);
	}

	/**
	* Returns the number of survey pages where surveyMainId = &#63; and no = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the number of matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainIdAndNo(long surveyMainId, int no)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyMainIdAndNo(surveyMainId, no);
	}

	/**
	* Caches the survey page in the entity cache if it is enabled.
	*
	* @param surveyPage the survey page
	*/
	public static void cacheResult(com.lc.survey.model.SurveyPage surveyPage) {
		getPersistence().cacheResult(surveyPage);
	}

	/**
	* Caches the survey pages in the entity cache if it is enabled.
	*
	* @param surveyPages the survey pages
	*/
	public static void cacheResult(
		java.util.List<com.lc.survey.model.SurveyPage> surveyPages) {
		getPersistence().cacheResult(surveyPages);
	}

	/**
	* Creates a new survey page with the primary key. Does not add the survey page to the database.
	*
	* @param surveyPageId the primary key for the new survey page
	* @return the new survey page
	*/
	public static com.lc.survey.model.SurveyPage create(long surveyPageId) {
		return getPersistence().create(surveyPageId);
	}

	/**
	* Removes the survey page with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page that was removed
	* @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage remove(long surveyPageId)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(surveyPageId);
	}

	public static com.lc.survey.model.SurveyPage updateImpl(
		com.lc.survey.model.SurveyPage surveyPage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyPage);
	}

	/**
	* Returns the survey page with the primary key or throws a {@link com.lc.survey.NoSuchSurveyPageException} if it could not be found.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage findByPrimaryKey(
		long surveyPageId)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(surveyPageId);
	}

	/**
	* Returns the survey page with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page, or <code>null</code> if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyPage fetchByPrimaryKey(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(surveyPageId);
	}

	/**
	* Returns all the survey pages.
	*
	* @return the survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyPage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.lc.survey.model.SurveyPage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the survey pages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey pages
	* @param end the upper bound of the range of survey pages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyPage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey pages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey pages.
	*
	* @return the number of survey pages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SurveyPagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyPagePersistence)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyPagePersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyPageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyPagePersistence persistence) {
	}

	private static SurveyPagePersistence _persistence;
}