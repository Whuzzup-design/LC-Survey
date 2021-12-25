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

import com.lc.survey.model.SurveyWriteSequence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey write sequence service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyWriteSequencePersistenceImpl
 * @see SurveyWriteSequenceUtil
 * @generated
 */
public interface SurveyWriteSequencePersistence extends BasePersistence<SurveyWriteSequence> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyWriteSequenceUtil} to access the survey write sequence persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey write sequences where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @return the matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyWriteSequence> findBySurveyWriterId(
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey write sequences where surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey write sequences
	* @param end the upper bound of the range of survey write sequences (not inclusive)
	* @return the range of matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyWriteSequence> findBySurveyWriterId(
		long surveyWriterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey write sequences where surveyWriterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyWriterId the survey writer ID
	* @param start the lower bound of the range of survey write sequences
	* @param end the upper bound of the range of survey write sequences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyWriteSequence> findBySurveyWriterId(
		long surveyWriterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence findBySurveyWriterId_First(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence fetchBySurveyWriterId_First(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence findBySurveyWriterId_Last(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence fetchBySurveyWriterId_Last(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey write sequences before and after the current survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriteSequenceId the primary key of the current survey write sequence
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence[] findBySurveyWriterId_PrevAndNext(
		long surveyWriteSequenceId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey write sequences where surveyWriterId = &#63; from the database.
	*
	* @param surveyWriterId the survey writer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey write sequences where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @return the number of matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or throws a {@link com.lc.survey.NoSuchSurveyWriteSequenceException} if it could not be found.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the matching survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence findByS_P(
		long surveyWriterId, long pageId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence fetchByS_P(
		long surveyWriterId, long pageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence fetchByS_P(
		long surveyWriterId, long pageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the survey write sequence where surveyWriterId = &#63; and pageId = &#63; from the database.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the survey write sequence that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence removeByS_P(
		long surveyWriterId, long pageId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey write sequences where surveyWriterId = &#63; and pageId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the number of matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_P(long surveyWriterId, long pageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey write sequence in the entity cache if it is enabled.
	*
	* @param surveyWriteSequence the survey write sequence
	*/
	public void cacheResult(
		com.lc.survey.model.SurveyWriteSequence surveyWriteSequence);

	/**
	* Caches the survey write sequences in the entity cache if it is enabled.
	*
	* @param surveyWriteSequences the survey write sequences
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyWriteSequence> surveyWriteSequences);

	/**
	* Creates a new survey write sequence with the primary key. Does not add the survey write sequence to the database.
	*
	* @param surveyWriteSequenceId the primary key for the new survey write sequence
	* @return the new survey write sequence
	*/
	public com.lc.survey.model.SurveyWriteSequence create(
		long surveyWriteSequenceId);

	/**
	* Removes the survey write sequence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyWriteSequenceId the primary key of the survey write sequence
	* @return the survey write sequence that was removed
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence remove(
		long surveyWriteSequenceId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyWriteSequence updateImpl(
		com.lc.survey.model.SurveyWriteSequence surveyWriteSequence)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey write sequence with the primary key or throws a {@link com.lc.survey.NoSuchSurveyWriteSequenceException} if it could not be found.
	*
	* @param surveyWriteSequenceId the primary key of the survey write sequence
	* @return the survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence findByPrimaryKey(
		long surveyWriteSequenceId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey write sequence with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyWriteSequenceId the primary key of the survey write sequence
	* @return the survey write sequence, or <code>null</code> if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyWriteSequence fetchByPrimaryKey(
		long surveyWriteSequenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey write sequences.
	*
	* @return the survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyWriteSequence> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey write sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey write sequences
	* @param end the upper bound of the range of survey write sequences (not inclusive)
	* @return the range of survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyWriteSequence> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey write sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey write sequences
	* @param end the upper bound of the range of survey write sequences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyWriteSequence> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey write sequences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey write sequences.
	*
	* @return the number of survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}