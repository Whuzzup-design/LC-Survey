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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the survey option service. This utility wraps {@link SurveyOptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyOptionPersistence
 * @see SurveyOptionPersistenceImpl
 * @generated
 */
public class SurveyOptionUtil {
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
	public static void clearCache(SurveyOption surveyOption) {
		getPersistence().clearCache(surveyOption);
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
	public static List<SurveyOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyOption update(SurveyOption surveyOption)
		throws SystemException {
		return getPersistence().update(surveyOption);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyOption update(SurveyOption surveyOption,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyOption, serviceContext);
	}

	/**
	* Returns all the survey options where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyQuestionId(surveyQuestionId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyQuestionId(surveyQuestionId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyQuestionId(
		long surveyQuestionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyQuestionId(surveyQuestionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findBySurveyQuestionId_First(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyQuestionId_First(surveyQuestionId,
			orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchBySurveyQuestionId_First(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyQuestionId_First(surveyQuestionId,
			orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findBySurveyQuestionId_Last(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyQuestionId_Last(surveyQuestionId,
			orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchBySurveyQuestionId_Last(
		long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyQuestionId_Last(surveyQuestionId,
			orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyOption[] findBySurveyQuestionId_PrevAndNext(
		long surveyOptionId, long surveyQuestionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyQuestionId_PrevAndNext(surveyOptionId,
			surveyQuestionId, orderByComparator);
	}

	/**
	* Removes all the survey options where surveyQuestionId = &#63; from the database.
	*
	* @param surveyQuestionId the survey question ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyQuestionId(long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyQuestionId(surveyQuestionId);
	}

	/**
	* Returns the number of survey options where surveyQuestionId = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyQuestionId(long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyQuestionId(surveyQuestionId);
	}

	/**
	* Returns all the survey options where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyPageId(surveyPageId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyPageId(surveyPageId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyPageId(
		long surveyPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId(surveyPageId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId_First(surveyPageId, orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyPageId_First(surveyPageId, orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId_Last(surveyPageId, orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyPageId_Last(surveyPageId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyOption[] findBySurveyPageId_PrevAndNext(
		long surveyOptionId, long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId_PrevAndNext(surveyOptionId,
			surveyPageId, orderByComparator);
	}

	/**
	* Removes all the survey options where surveyPageId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyPageId(surveyPageId);
	}

	/**
	* Returns the number of survey options where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyPageId(surveyPageId);
	}

	/**
	* Returns all the survey options where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId(surveyMainId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyOption[] findBySurveyMainId_PrevAndNext(
		long surveyOptionId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_PrevAndNext(surveyOptionId,
			surveyMainId, orderByComparator);
	}

	/**
	* Removes all the survey options where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyMainId(surveyMainId);
	}

	/**
	* Returns the number of survey options where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyMainId(surveyMainId);
	}

	/**
	* Returns all the survey options where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @return the matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, java.lang.Boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQ_I(surveyQuestionId, isAns);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, java.lang.Boolean isAns, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQ_I(surveyQuestionId, isAns, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findByQ_I(
		long surveyQuestionId, java.lang.Boolean isAns, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_I(surveyQuestionId, isAns, start, end,
			orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyOption findByQ_I_First(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_I_First(surveyQuestionId, isAns, orderByComparator);
	}

	/**
	* Returns the first survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchByQ_I_First(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQ_I_First(surveyQuestionId, isAns, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyOption findByQ_I_Last(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_I_Last(surveyQuestionId, isAns, orderByComparator);
	}

	/**
	* Returns the last survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchByQ_I_Last(
		long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQ_I_Last(surveyQuestionId, isAns, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyOption[] findByQ_I_PrevAndNext(
		long surveyOptionId, long surveyQuestionId, java.lang.Boolean isAns,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQ_I_PrevAndNext(surveyOptionId, surveyQuestionId,
			isAns, orderByComparator);
	}

	/**
	* Removes all the survey options where surveyQuestionId = &#63; and isAns = &#63; from the database.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQ_I(long surveyQuestionId,
		java.lang.Boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQ_I(surveyQuestionId, isAns);
	}

	/**
	* Returns the number of survey options where surveyQuestionId = &#63; and isAns = &#63;.
	*
	* @param surveyQuestionId the survey question ID
	* @param isAns the is ans
	* @return the number of matching survey options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQ_I(long surveyQuestionId, java.lang.Boolean isAns)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQ_I(surveyQuestionId, isAns);
	}

	/**
	* Caches the survey option in the entity cache if it is enabled.
	*
	* @param surveyOption the survey option
	*/
	public static void cacheResult(
		com.lc.survey.model.SurveyOption surveyOption) {
		getPersistence().cacheResult(surveyOption);
	}

	/**
	* Caches the survey options in the entity cache if it is enabled.
	*
	* @param surveyOptions the survey options
	*/
	public static void cacheResult(
		java.util.List<com.lc.survey.model.SurveyOption> surveyOptions) {
		getPersistence().cacheResult(surveyOptions);
	}

	/**
	* Creates a new survey option with the primary key. Does not add the survey option to the database.
	*
	* @param surveyOptionId the primary key for the new survey option
	* @return the new survey option
	*/
	public static com.lc.survey.model.SurveyOption create(long surveyOptionId) {
		return getPersistence().create(surveyOptionId);
	}

	/**
	* Removes the survey option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option that was removed
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption remove(long surveyOptionId)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(surveyOptionId);
	}

	public static com.lc.survey.model.SurveyOption updateImpl(
		com.lc.survey.model.SurveyOption surveyOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyOption);
	}

	/**
	* Returns the survey option with the primary key or throws a {@link com.lc.survey.NoSuchSurveyOptionException} if it could not be found.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option
	* @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption findByPrimaryKey(
		long surveyOptionId)
		throws com.lc.survey.NoSuchSurveyOptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(surveyOptionId);
	}

	/**
	* Returns the survey option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyOptionId the primary key of the survey option
	* @return the survey option, or <code>null</code> if a survey option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyOption fetchByPrimaryKey(
		long surveyOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(surveyOptionId);
	}

	/**
	* Returns all the survey options.
	*
	* @return the survey options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey options.
	*
	* @return the number of survey options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SurveyOptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyOptionPersistence)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyOptionPersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyOptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyOptionPersistence persistence) {
	}

	private static SurveyOptionPersistence _persistence;
}