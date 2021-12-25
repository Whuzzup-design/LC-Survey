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

import com.lc.survey.model.SurveyQuestion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyQuestionPersistenceImpl
 * @see SurveyQuestionUtil
 * @generated
 */
public interface SurveyQuestionPersistence extends BasePersistence<SurveyQuestion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyQuestionUtil} to access the survey question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey questions where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey questions before and after the current survey question in the ordered set where parentId = &#63;.
	*
	* @param surveyQuestionId the primary key of the current survey question
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion[] findByParentId_PrevAndNext(
		long surveyQuestionId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions where surveyPageId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions where surveyPageId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyPageIdAndParentId_First(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyPageIdAndParentId_First(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyPageIdAndParentId_Last(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyPageIdAndParentId_Last(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey questions before and after the current survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyQuestionId the primary key of the current survey question
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion[] findBySurveyPageIdAndParentId_PrevAndNext(
		long surveyQuestionId, long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions where surveyPageId = &#63; and parentId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyPageIdAndParentId(long surveyPageId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyPageIdAndParentId(long surveyPageId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey questions before and after the current survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyQuestionId the primary key of the current survey question
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion[] findBySurveyMainId_PrevAndNext(
		long surveyQuestionId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions where surveyPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions where surveyPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyPageId the survey page ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey questions before and after the current survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyQuestionId the primary key of the current survey question
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion[] findBySurveyPageId_PrevAndNext(
		long surveyQuestionId, long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions where surveyPageId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions where type = &#63;.
	*
	* @param type the type
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey questions before and after the current survey question in the ordered set where type = &#63;.
	*
	* @param surveyQuestionId the primary key of the current survey question
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion[] findByType_PrevAndNext(
		long surveyQuestionId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions where type = &#63;.
	*
	* @param type the type
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyMainIdAndParentIdNotZero_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyMainIdAndParentIdNotZero_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findBySurveyMainIdAndParentIdNotZero_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchBySurveyMainIdAndParentIdNotZero_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey questions before and after the current survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyQuestionId the primary key of the current survey question
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion[] findBySurveyMainIdAndParentIdNotZero_PrevAndNext(
		long surveyQuestionId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyMainIdAndParentIdNotZero(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainIdAndParentIdNotZero(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey question in the entity cache if it is enabled.
	*
	* @param surveyQuestion the survey question
	*/
	public void cacheResult(com.lc.survey.model.SurveyQuestion surveyQuestion);

	/**
	* Caches the survey questions in the entity cache if it is enabled.
	*
	* @param surveyQuestions the survey questions
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyQuestion> surveyQuestions);

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param surveyQuestionId the primary key for the new survey question
	* @return the new survey question
	*/
	public com.lc.survey.model.SurveyQuestion create(long surveyQuestionId);

	/**
	* Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question that was removed
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion remove(long surveyQuestionId)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyQuestion updateImpl(
		com.lc.survey.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey question with the primary key or throws a {@link com.lc.survey.NoSuchSurveyQuestionException} if it could not be found.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion findByPrimaryKey(
		long surveyQuestionId)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyQuestion fetchByPrimaryKey(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions.
	*
	* @return the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}