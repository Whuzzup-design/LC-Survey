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

import com.lc.survey.model.SurveyWriter;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the survey writer service. This utility wraps {@link SurveyWriterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyWriterPersistence
 * @see SurveyWriterPersistenceImpl
 * @generated
 */
public class SurveyWriterUtil {
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
	public static void clearCache(SurveyWriter surveyWriter) {
		getPersistence().clearCache(surveyWriter);
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
	public static List<SurveyWriter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyWriter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyWriter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyWriter update(SurveyWriter surveyWriter)
		throws SystemException {
		return getPersistence().update(surveyWriter);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyWriter update(SurveyWriter surveyWriter,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyWriter, serviceContext);
	}

	/**
	* Returns all the survey writers where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId);
	}

	/**
	* Returns a range of all the survey writers where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @return the range of matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId, start, end);
	}

	/**
	* Returns an ordered range of all the survey writers where surveyMainId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId(surveyMainId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey writer in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the first survey writer in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey writer, or <code>null</code> if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey writer in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey writer in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey writer, or <code>null</code> if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the survey writers before and after the current survey writer in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyWriterId the primary key of the current survey writer
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter[] findBySurveyMainId_PrevAndNext(
		long surveyWriterId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_PrevAndNext(surveyWriterId,
			surveyMainId, orderByComparator);
	}

	/**
	* Removes all the survey writers where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyMainId(surveyMainId);
	}

	/**
	* Returns the number of survey writers where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyMainId(surveyMainId);
	}

	/**
	* Returns all the survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @return the matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findByM_P_C(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByM_P_C(surveyMainId, isPreview, isComplete);
	}

	/**
	* Returns a range of all the survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @return the range of matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findByM_P_C(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_P_C(surveyMainId, isPreview, isComplete, start, end);
	}

	/**
	* Returns an ordered range of all the survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findByM_P_C(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_P_C(surveyMainId, isPreview, isComplete, start,
			end, orderByComparator);
	}

	/**
	* Returns the first survey writer in the ordered set where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter findByM_P_C_First(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_P_C_First(surveyMainId, isPreview, isComplete,
			orderByComparator);
	}

	/**
	* Returns the first survey writer in the ordered set where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey writer, or <code>null</code> if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter fetchByM_P_C_First(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByM_P_C_First(surveyMainId, isPreview, isComplete,
			orderByComparator);
	}

	/**
	* Returns the last survey writer in the ordered set where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter findByM_P_C_Last(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_P_C_Last(surveyMainId, isPreview, isComplete,
			orderByComparator);
	}

	/**
	* Returns the last survey writer in the ordered set where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey writer, or <code>null</code> if a matching survey writer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter fetchByM_P_C_Last(
		long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByM_P_C_Last(surveyMainId, isPreview, isComplete,
			orderByComparator);
	}

	/**
	* Returns the survey writers before and after the current survey writer in the ordered set where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyWriterId the primary key of the current survey writer
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter[] findByM_P_C_PrevAndNext(
		long surveyWriterId, long surveyMainId, java.lang.Boolean isPreview,
		java.lang.Boolean isComplete,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_P_C_PrevAndNext(surveyWriterId, surveyMainId,
			isPreview, isComplete, orderByComparator);
	}

	/**
	* Removes all the survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByM_P_C(long surveyMainId,
		java.lang.Boolean isPreview, java.lang.Boolean isComplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByM_P_C(surveyMainId, isPreview, isComplete);
	}

	/**
	* Returns the number of survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param isPreview the is preview
	* @param isComplete the is complete
	* @return the number of matching survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByM_P_C(long surveyMainId,
		java.lang.Boolean isPreview, java.lang.Boolean isComplete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByM_P_C(surveyMainId, isPreview, isComplete);
	}

	/**
	* Caches the survey writer in the entity cache if it is enabled.
	*
	* @param surveyWriter the survey writer
	*/
	public static void cacheResult(
		com.lc.survey.model.SurveyWriter surveyWriter) {
		getPersistence().cacheResult(surveyWriter);
	}

	/**
	* Caches the survey writers in the entity cache if it is enabled.
	*
	* @param surveyWriters the survey writers
	*/
	public static void cacheResult(
		java.util.List<com.lc.survey.model.SurveyWriter> surveyWriters) {
		getPersistence().cacheResult(surveyWriters);
	}

	/**
	* Creates a new survey writer with the primary key. Does not add the survey writer to the database.
	*
	* @param surveyWriterId the primary key for the new survey writer
	* @return the new survey writer
	*/
	public static com.lc.survey.model.SurveyWriter create(long surveyWriterId) {
		return getPersistence().create(surveyWriterId);
	}

	/**
	* Removes the survey writer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyWriterId the primary key of the survey writer
	* @return the survey writer that was removed
	* @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter remove(long surveyWriterId)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(surveyWriterId);
	}

	public static com.lc.survey.model.SurveyWriter updateImpl(
		com.lc.survey.model.SurveyWriter surveyWriter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyWriter);
	}

	/**
	* Returns the survey writer with the primary key or throws a {@link com.lc.survey.NoSuchSurveyWriterException} if it could not be found.
	*
	* @param surveyWriterId the primary key of the survey writer
	* @return the survey writer
	* @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter findByPrimaryKey(
		long surveyWriterId)
		throws com.lc.survey.NoSuchSurveyWriterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(surveyWriterId);
	}

	/**
	* Returns the survey writer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyWriterId the primary key of the survey writer
	* @return the survey writer, or <code>null</code> if a survey writer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyWriter fetchByPrimaryKey(
		long surveyWriterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(surveyWriterId);
	}

	/**
	* Returns all the survey writers.
	*
	* @return the survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the survey writers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @return the range of survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the survey writers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyWriterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey writers
	* @param end the upper bound of the range of survey writers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyWriter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey writers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey writers.
	*
	* @return the number of survey writers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SurveyWriterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyWriterPersistence)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyWriterPersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyWriterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyWriterPersistence persistence) {
	}

	private static SurveyWriterPersistence _persistence;
}