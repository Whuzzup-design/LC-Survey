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

import com.lc.survey.model.SurveyResponse;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the survey response service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyResponsePersistenceImpl
 * @see SurveyResponseUtil
 * @generated
 */
public interface SurveyResponsePersistence extends BasePersistence<SurveyResponse> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyResponseUtil} to access the survey response persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the survey responses where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey responses where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @return the range of matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey responses where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey response in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey response in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey response, or <code>null</code> if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey response in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey response in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey response, or <code>null</code> if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey responses before and after the current survey response in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyResponseId the primary key of the current survey response
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse[] findBySurveyMainId_PrevAndNext(
		long surveyResponseId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey responses where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey responses where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey responses where writerId = &#63;.
	*
	* @param writerId the writer ID
	* @return the matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findByWriterId(
		long writerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey responses where writerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param writerId the writer ID
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @return the range of matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findByWriterId(
		long writerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey responses where writerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param writerId the writer ID
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findByWriterId(
		long writerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey response in the ordered set where writerId = &#63;.
	*
	* @param writerId the writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse findByWriterId_First(
		long writerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first survey response in the ordered set where writerId = &#63;.
	*
	* @param writerId the writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey response, or <code>null</code> if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse fetchByWriterId_First(
		long writerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey response in the ordered set where writerId = &#63;.
	*
	* @param writerId the writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse findByWriterId_Last(
		long writerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last survey response in the ordered set where writerId = &#63;.
	*
	* @param writerId the writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey response, or <code>null</code> if a matching survey response could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse fetchByWriterId_Last(
		long writerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey responses before and after the current survey response in the ordered set where writerId = &#63;.
	*
	* @param surveyResponseId the primary key of the current survey response
	* @param writerId the writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse[] findByWriterId_PrevAndNext(
		long surveyResponseId, long writerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey responses where writerId = &#63; from the database.
	*
	* @param writerId the writer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWriterId(long writerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey responses where writerId = &#63;.
	*
	* @param writerId the writer ID
	* @return the number of matching survey responses
	* @throws SystemException if a system exception occurred
	*/
	public int countByWriterId(long writerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the survey response in the entity cache if it is enabled.
	*
	* @param surveyResponse the survey response
	*/
	public void cacheResult(com.lc.survey.model.SurveyResponse surveyResponse);

	/**
	* Caches the survey responses in the entity cache if it is enabled.
	*
	* @param surveyResponses the survey responses
	*/
	public void cacheResult(
		java.util.List<com.lc.survey.model.SurveyResponse> surveyResponses);

	/**
	* Creates a new survey response with the primary key. Does not add the survey response to the database.
	*
	* @param surveyResponseId the primary key for the new survey response
	* @return the new survey response
	*/
	public com.lc.survey.model.SurveyResponse create(long surveyResponseId);

	/**
	* Removes the survey response with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyResponseId the primary key of the survey response
	* @return the survey response that was removed
	* @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse remove(long surveyResponseId)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.lc.survey.model.SurveyResponse updateImpl(
		com.lc.survey.model.SurveyResponse surveyResponse)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey response with the primary key or throws a {@link com.lc.survey.NoSuchSurveyResponseException} if it could not be found.
	*
	* @param surveyResponseId the primary key of the survey response
	* @return the survey response
	* @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse findByPrimaryKey(
		long surveyResponseId)
		throws com.lc.survey.NoSuchSurveyResponseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey response with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyResponseId the primary key of the survey response
	* @return the survey response, or <code>null</code> if a survey response with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lc.survey.model.SurveyResponse fetchByPrimaryKey(
		long surveyResponseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey responses.
	*
	* @return the survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey responses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @return the range of survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey responses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResponseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey responses
	* @param end the upper bound of the range of survey responses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey responses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lc.survey.model.SurveyResponse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey responses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey responses.
	*
	* @return the number of survey responses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}