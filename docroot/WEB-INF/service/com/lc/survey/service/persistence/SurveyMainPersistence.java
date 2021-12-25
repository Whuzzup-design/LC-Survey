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

import com.lc.survey.model.SurveyMain;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey main service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyMainPersistenceImpl
 * @see SurveyMainUtil
 * @generated
 */
public interface SurveyMainPersistence extends BasePersistence<SurveyMain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyMainUtil} to access the survey main persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey mains where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching survey mains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyMain> findByCreatorId(
		long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey mains where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of survey mains
	* @param end the upper bound of the range of survey mains (not inclusive)
	* @return the range of matching survey mains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyMain> findByCreatorId(
		long creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey mains where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of survey mains
	* @param end the upper bound of the range of survey mains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey mains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyMain> findByCreatorId(
		long creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey main in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey main
	* @throws com.lc.survey.NoSuchSurveyMainException if a matching survey main could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain findByCreatorId_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyMainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey main in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey main, or <code>null</code> if a matching survey main could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain fetchByCreatorId_First(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey main in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey main
	* @throws com.lc.survey.NoSuchSurveyMainException if a matching survey main could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain findByCreatorId_Last(long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyMainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey main in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey main, or <code>null</code> if a matching survey main could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain fetchByCreatorId_Last(
		long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey mains before and after the current survey main in the ordered set where creatorId = &#63;.
	*
	* @param surveyMainId the primary key of the current survey main
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey main
	* @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain[] findByCreatorId_PrevAndNext(
		long surveyMainId, long creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyMainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey mains where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreatorId(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey mains where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching survey mains
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreatorId(long creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey main in the entity cache if it is enabled.
	*
	* @param surveyMain the survey main
	*/
	public void cacheResult(com.lc.survey.model.SurveyMain surveyMain);

	/**
	* Caches the survey mains in the entity cache if it is enabled.
	*
	* @param surveyMains the survey mains
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyMain> surveyMains);

	/**
	* Creates a new survey main with the primary key. Does not add the survey main to the database.
	*
	* @param surveyMainId the primary key for the new survey main
	* @return the new survey main
	*/
	public com.lc.survey.model.SurveyMain create(long surveyMainId);

	/**
	* Removes the survey main with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyMainId the primary key of the survey main
	* @return the survey main that was removed
	* @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain remove(long surveyMainId)
		throws com.lc.survey.NoSuchSurveyMainException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyMain updateImpl(
		com.lc.survey.model.SurveyMain surveyMain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey main with the primary key or throws a {@link com.lc.survey.NoSuchSurveyMainException} if it could not be found.
	*
	* @param surveyMainId the primary key of the survey main
	* @return the survey main
	* @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain findByPrimaryKey(long surveyMainId)
		throws com.lc.survey.NoSuchSurveyMainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey main with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyMainId the primary key of the survey main
	* @return the survey main, or <code>null</code> if a survey main with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyMain fetchByPrimaryKey(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey mains.
	*
	* @return the survey mains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyMain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyMain> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey mains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey mains
	* @param end the upper bound of the range of survey mains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey mains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyMain> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey mains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey mains.
	*
	* @return the number of survey mains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}