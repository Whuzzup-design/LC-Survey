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

import com.lc.survey.model.SurveyFile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyFilePersistenceImpl
 * @see SurveyFileUtil
 * @generated
 */
public interface SurveyFilePersistence extends BasePersistence<SurveyFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyFileUtil} to access the survey file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey files where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyFile> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey files where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey files
	* @param end the upper bound of the range of survey files (not inclusive)
	* @return the range of matching survey files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyFile> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey files where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey files
	* @param end the upper bound of the range of survey files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyFile> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey file in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey file
	* @throws com.lc.survey.NoSuchSurveyFileException if a matching survey file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey file in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey file, or <code>null</code> if a matching survey file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey file in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey file
	* @throws com.lc.survey.NoSuchSurveyFileException if a matching survey file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey file in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey file, or <code>null</code> if a matching survey file could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey files before and after the current survey file in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyFileId the primary key of the current survey file
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey file
	* @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile[] findBySurveyMainId_PrevAndNext(
		long surveyFileId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey files where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey files where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey files
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey file in the entity cache if it is enabled.
	*
	* @param surveyFile the survey file
	*/
	public void cacheResult(com.lc.survey.model.SurveyFile surveyFile);

	/**
	* Caches the survey files in the entity cache if it is enabled.
	*
	* @param surveyFiles the survey files
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyFile> surveyFiles);

	/**
	* Creates a new survey file with the primary key. Does not add the survey file to the database.
	*
	* @param surveyFileId the primary key for the new survey file
	* @return the new survey file
	*/
	public com.lc.survey.model.SurveyFile create(long surveyFileId);

	/**
	* Removes the survey file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyFileId the primary key of the survey file
	* @return the survey file that was removed
	* @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile remove(long surveyFileId)
		throws com.lc.survey.NoSuchSurveyFileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyFile updateImpl(
		com.lc.survey.model.SurveyFile surveyFile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey file with the primary key or throws a {@link com.lc.survey.NoSuchSurveyFileException} if it could not be found.
	*
	* @param surveyFileId the primary key of the survey file
	* @return the survey file
	* @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile findByPrimaryKey(long surveyFileId)
		throws com.lc.survey.NoSuchSurveyFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyFileId the primary key of the survey file
	* @return the survey file, or <code>null</code> if a survey file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyFile fetchByPrimaryKey(long surveyFileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey files.
	*
	* @return the survey files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyFile> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey files
	* @param end the upper bound of the range of survey files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyFile> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey files.
	*
	* @return the number of survey files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}