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

import com.lc.survey.model.SurveyOption;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyOptionPersistenceImpl
 * @see SurveyOptionUtil
 * @generated
 */
public interface SurveyOptionPersistence extends BasePersistence<SurveyOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyOptionUtil} to access the survey option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey options where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey options where surveyQuestionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @return the range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey options where surveyQuestionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findBySurveyQuestionId_First(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchBySurveyQuestionId_First(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findBySurveyQuestionId_Last(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchBySurveyQuestionId_Last(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey options before and after the current survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyOptionId the primary key of the current survey option
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption[] findBySurveyQuestionId_PrevAndNext(
		long surveyOptionId, long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey options where surveyQuestionId = &#63; from the database.
	*
	* @param surveyQuestionId the survey question ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyQuestionId(long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey options where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyQuestionId(long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey options where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey options where surveyPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @return the range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey options where surveyPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey options before and after the current survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyOptionId the primary key of the current survey option
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption[] findBySurveyPageId_PrevAndNext(
		long surveyOptionId, long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey options where surveyPageId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey options where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey options where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey options where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @return the range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey options where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey options before and after the current survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyOptionId the primary key of the current survey option
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption[] findBySurveyMainId_PrevAndNext(
		long surveyOptionId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey options where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey options where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey options where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, java.lang.Boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey options where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @return the range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, java.lang.Boolean isAns, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey options where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, java.lang.Boolean isAns, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findByQ_I_First(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchByQ_I_First(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findByQ_I_Last(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchByQ_I_Last(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey options before and after the current survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyOptionId the primary key of the current survey option
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption[] findByQ_I_PrevAndNext(
		long surveyOptionId, long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey options where surveyQuestionId = &#63; and isAns = &#63; from the database.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQ_I(long surveyQuestionId, java.lang.Boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey options where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public int countByQ_I(long surveyQuestionId, java.lang.Boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey option in the entity cache if it is enabled.
	*
	* @param surveyOption the survey option
	*/
	public void cacheResult(com.lc.survey.model.SurveyOption surveyOption);

	/**
	* Caches the survey options in the entity cache if it is enabled.
	*
	* @param surveyOptions the survey options
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyOption> surveyOptions);

	/**
	* Creates a new survey option with the primary key. Does not add the survey option to the database.
	*
	* @param surveyOptionId the primary key for the new survey option
	* @return the new survey option
	*/
	public com.lc.survey.model.SurveyOption create(long surveyOptionId);

	/**
	* Removes the survey option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option that was removed
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption remove(long surveyOptionId)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyOption updateImpl(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey option with the primary key or throws a {@link com.lc.survey.NoSuchSurveyOptionException} if it could not be found.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption findByPrimaryKey(
		long surveyOptionId)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option, or <code>null</code> if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyOption fetchByPrimaryKey(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey options.
	*
	* @return the survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lc.survey.model.SurveyOption> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey options
	* @param end the upper bound of the range of survey options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyOption> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey options.
	*
	* @return the number of survey options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}