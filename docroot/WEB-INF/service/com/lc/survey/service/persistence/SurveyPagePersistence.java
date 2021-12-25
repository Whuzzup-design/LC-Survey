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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey page service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyPagePersistenceImpl
 * @see SurveyPageUtil
 * @generated
 */
public interface SurveyPagePersistence extends BasePersistence<SurveyPage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyPageUtil} to access the survey page persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey pages where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyPage> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey page in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.lc.survey.model.SurveyPage[] findBySurveyMainId_PrevAndNext(
		long surveyPageId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey pages where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey pages where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey page where surveyMainId = &#63; and no = &#63; or throws a {@link com.lc.survey.NoSuchSurveyPageException} if it could not be found.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the matching survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage findBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey page where surveyMainId = &#63; and no = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage fetchBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey page where surveyMainId = &#63; and no = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching survey page, or <code>null</code> if a matching survey page could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage fetchBySurveyMainIdAndNo(
		long surveyMainId, int no, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the survey page where surveyMainId = &#63; and no = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the survey page that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage removeBySurveyMainIdAndNo(
		long surveyMainId, int no)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey pages where surveyMainId = &#63; and no = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param no the no
	* @return the number of matching survey pages
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainIdAndNo(long surveyMainId, int no)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey page in the entity cache if it is enabled.
	*
	* @param surveyPage the survey page
	*/
	public void cacheResult(com.lc.survey.model.SurveyPage surveyPage);

	/**
	* Caches the survey pages in the entity cache if it is enabled.
	*
	* @param surveyPages the survey pages
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyPage> surveyPages);

	/**
	* Creates a new survey page with the primary key. Does not add the survey page to the database.
	*
	* @param surveyPageId the primary key for the new survey page
	* @return the new survey page
	*/
	public com.lc.survey.model.SurveyPage create(long surveyPageId);

	/**
	* Removes the survey page with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page that was removed
	* @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage remove(long surveyPageId)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyPage updateImpl(
		com.lc.survey.model.SurveyPage surveyPage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey page with the primary key or throws a {@link com.lc.survey.NoSuchSurveyPageException} if it could not be found.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page
	* @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage findByPrimaryKey(long surveyPageId)
		throws com.lc.survey.NoSuchSurveyPageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey page with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyPageId the primary key of the survey page
	* @return the survey page, or <code>null</code> if a survey page with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyPage fetchByPrimaryKey(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey pages.
	*
	* @return the survey pages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyPage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyPage> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyPage> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey pages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey pages.
	*
	* @return the number of survey pages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}