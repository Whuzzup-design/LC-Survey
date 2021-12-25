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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the survey write sequence service. This utility wraps {@link SurveyWriteSequencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyWriteSequencePersistence
 * @see SurveyWriteSequencePersistenceImpl
 * @generated
 */
public class SurveyWriteSequenceUtil {
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
	public static void clearCache(SurveyWriteSequence surveyWriteSequence) {
		getPersistence().clearCache(surveyWriteSequence);
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
	public static List<SurveyWriteSequence> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyWriteSequence> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyWriteSequence> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyWriteSequence update(
		SurveyWriteSequence surveyWriteSequence) throws SystemException {
		return getPersistence().update(surveyWriteSequence);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyWriteSequence update(
		SurveyWriteSequence surveyWriteSequence, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(surveyWriteSequence, serviceContext);
	}

	/**
	* Returns all the survey write sequences where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @return the matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriteSequence> findBySurveyWriterId(
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyWriterId(surveyWriterId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyWriteSequence> findBySurveyWriterId(
		long surveyWriterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyWriterId(surveyWriterId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyWriteSequence> findBySurveyWriterId(
		long surveyWriterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId(surveyWriterId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence findBySurveyWriterId_First(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId_First(surveyWriterId, orderByComparator);
	}

	/**
	* Returns the first survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence fetchBySurveyWriterId_First(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyWriterId_First(surveyWriterId,
			orderByComparator);
	}

	/**
	* Returns the last survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence findBySurveyWriterId_Last(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId_Last(surveyWriterId, orderByComparator);
	}

	/**
	* Returns the last survey write sequence in the ordered set where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence fetchBySurveyWriterId_Last(
		long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyWriterId_Last(surveyWriterId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyWriteSequence[] findBySurveyWriterId_PrevAndNext(
		long surveyWriteSequenceId, long surveyWriterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyWriterId_PrevAndNext(surveyWriteSequenceId,
			surveyWriterId, orderByComparator);
	}

	/**
	* Removes all the survey write sequences where surveyWriterId = &#63; from the database.
	*
	* @param surveyWriterId the survey writer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyWriterId(surveyWriterId);
	}

	/**
	* Returns the number of survey write sequences where surveyWriterId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @return the number of matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyWriterId(long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyWriterId(surveyWriterId);
	}

	/**
	* Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or throws a {@link com.lc.survey.NoSuchSurveyWriteSequenceException} if it could not be found.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the matching survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence findByS_P(
		long surveyWriterId, long pageId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_P(surveyWriterId, pageId);
	}

	/**
	* Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence fetchByS_P(
		long surveyWriterId, long pageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS_P(surveyWriterId, pageId);
	}

	/**
	* Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence fetchByS_P(
		long surveyWriterId, long pageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_P(surveyWriterId, pageId, retrieveFromCache);
	}

	/**
	* Removes the survey write sequence where surveyWriterId = &#63; and pageId = &#63; from the database.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the survey write sequence that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence removeByS_P(
		long surveyWriterId, long pageId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByS_P(surveyWriterId, pageId);
	}

	/**
	* Returns the number of survey write sequences where surveyWriterId = &#63; and pageId = &#63;.
	*
	* @param surveyWriterId the survey writer ID
	* @param pageId the page ID
	* @return the number of matching survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_P(long surveyWriterId, long pageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_P(surveyWriterId, pageId);
	}

	/**
	* Caches the survey write sequence in the entity cache if it is enabled.
	*
	* @param surveyWriteSequence the survey write sequence
	*/
	public static void cacheResult(
		com.lc.survey.model.SurveyWriteSequence surveyWriteSequence) {
		getPersistence().cacheResult(surveyWriteSequence);
	}

	/**
	* Caches the survey write sequences in the entity cache if it is enabled.
	*
	* @param surveyWriteSequences the survey write sequences
	*/
	public static void cacheResult(
		java.util.List<com.lc.survey.model.SurveyWriteSequence> surveyWriteSequences) {
		getPersistence().cacheResult(surveyWriteSequences);
	}

	/**
	* Creates a new survey write sequence with the primary key. Does not add the survey write sequence to the database.
	*
	* @param surveyWriteSequenceId the primary key for the new survey write sequence
	* @return the new survey write sequence
	*/
	public static com.lc.survey.model.SurveyWriteSequence create(
		long surveyWriteSequenceId) {
		return getPersistence().create(surveyWriteSequenceId);
	}

	/**
	* Removes the survey write sequence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyWriteSequenceId the primary key of the survey write sequence
	* @return the survey write sequence that was removed
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence remove(
		long surveyWriteSequenceId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(surveyWriteSequenceId);
	}

	public static com.lc.survey.model.SurveyWriteSequence updateImpl(
		com.lc.survey.model.SurveyWriteSequence surveyWriteSequence)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyWriteSequence);
	}

	/**
	* Returns the survey write sequence with the primary key or throws a {@link com.lc.survey.NoSuchSurveyWriteSequenceException} if it could not be found.
	*
	* @param surveyWriteSequenceId the primary key of the survey write sequence
	* @return the survey write sequence
	* @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence findByPrimaryKey(
		long surveyWriteSequenceId)
		throws com.lc.survey.NoSuchSurveyWriteSequenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(surveyWriteSequenceId);
	}

	/**
	* Returns the survey write sequence with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyWriteSequenceId the primary key of the survey write sequence
	* @return the survey write sequence, or <code>null</code> if a survey write sequence with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriteSequence fetchByPrimaryKey(
		long surveyWriteSequenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(surveyWriteSequenceId);
	}

	/**
	* Returns all the survey write sequences.
	*
	* @return the survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriteSequence> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.lc.survey.model.SurveyWriteSequence> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyWriteSequence> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey write sequences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey write sequences.
	*
	* @return the number of survey write sequences
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SurveyWriteSequencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyWriteSequencePersistence)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyWriteSequencePersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyWriteSequenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyWriteSequencePersistence persistence) {
	}

	private static SurveyWriteSequencePersistence _persistence;
}