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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the survey question service. This utility wraps {@link SurveyQuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyQuestionPersistence
 * @see SurveyQuestionPersistenceImpl
 * @generated
 */
public class SurveyQuestionUtil {
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
	public static void clearCache(SurveyQuestion surveyQuestion) {
		getPersistence().clearCache(surveyQuestion);
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
	public static List<SurveyQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyQuestion update(SurveyQuestion surveyQuestion)
		throws SystemException {
		return getPersistence().update(surveyQuestion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyQuestion update(SurveyQuestion surveyQuestion,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyQuestion, serviceContext);
	}

	/**
	* Returns all the survey questions where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId_First(parentId, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentId_First(parentId, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId_Last(parentId, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByParentId_Last(parentId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion[] findByParentId_PrevAndNext(
		long surveyQuestionId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId_PrevAndNext(surveyQuestionId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the survey questions where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentId(parentId);
	}

	/**
	* Returns the number of survey questions where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentId(parentId);
	}

	/**
	* Returns all the survey questions where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageIdAndParentId(surveyPageId, parentId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageIdAndParentId(surveyPageId, parentId,
			start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageIdAndParentId(surveyPageId, parentId,
			start, end, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion findBySurveyPageIdAndParentId_First(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageIdAndParentId_First(surveyPageId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyPageIdAndParentId_First(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyPageIdAndParentId_First(surveyPageId,
			parentId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion findBySurveyPageIdAndParentId_Last(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageIdAndParentId_Last(surveyPageId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyPageIdAndParentId_Last(
		long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyPageIdAndParentId_Last(surveyPageId, parentId,
			orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion[] findBySurveyPageIdAndParentId_PrevAndNext(
		long surveyQuestionId, long surveyPageId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageIdAndParentId_PrevAndNext(surveyQuestionId,
			surveyPageId, parentId, orderByComparator);
	}

	/**
	* Removes all the survey questions where surveyPageId = &#63; and parentId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyPageIdAndParentId(long surveyPageId,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyPageIdAndParentId(surveyPageId, parentId);
	}

	/**
	* Returns the number of survey questions where surveyPageId = &#63; and parentId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param parentId the parent ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyPageIdAndParentId(long surveyPageId,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySurveyPageIdAndParentId(surveyPageId, parentId);
	}

	/**
	* Returns all the survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyMainId(surveyMainId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId(surveyMainId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyMainId_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_First(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyMainId_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainId_Last(surveyMainId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion[] findBySurveyMainId_PrevAndNext(
		long surveyQuestionId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainId_PrevAndNext(surveyQuestionId,
			surveyMainId, orderByComparator);
	}

	/**
	* Removes all the survey questions where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyMainId(surveyMainId);
	}

	/**
	* Returns the number of survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyMainId(surveyMainId);
	}

	/**
	* Returns all the survey questions where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyPageId(surveyPageId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySurveyPageId(surveyPageId, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId(surveyPageId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId_First(surveyPageId, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyPageId_First(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyPageId_First(surveyPageId, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId_Last(surveyPageId, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyPageId_Last(
		long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyPageId_Last(surveyPageId, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion[] findBySurveyPageId_PrevAndNext(
		long surveyQuestionId, long surveyPageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyPageId_PrevAndNext(surveyQuestionId,
			surveyPageId, orderByComparator);
	}

	/**
	* Removes all the survey questions where surveyPageId = &#63; from the database.
	*
	* @param surveyPageId the survey page ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyPageId(surveyPageId);
	}

	/**
	* Returns the number of survey questions where surveyPageId = &#63;.
	*
	* @param surveyPageId the survey page ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyPageId(long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySurveyPageId(surveyPageId);
	}

	/**
	* Returns all the survey questions where type = &#63;.
	*
	* @param type the type
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion[] findByType_PrevAndNext(
		long surveyQuestionId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_PrevAndNext(surveyQuestionId, type,
			orderByComparator);
	}

	/**
	* Removes all the survey questions where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of survey questions where type = &#63;.
	*
	* @param type the type
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns all the survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainIdAndParentIdNotZero(surveyMainId);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainIdAndParentIdNotZero(surveyMainId, start,
			end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainIdAndParentIdNotZero(surveyMainId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findBySurveyMainIdAndParentIdNotZero_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainIdAndParentIdNotZero_First(surveyMainId,
			orderByComparator);
	}

	/**
	* Returns the first survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyMainIdAndParentIdNotZero_First(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainIdAndParentIdNotZero_First(surveyMainId,
			orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findBySurveyMainIdAndParentIdNotZero_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainIdAndParentIdNotZero_Last(surveyMainId,
			orderByComparator);
	}

	/**
	* Returns the last survey question in the ordered set where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchBySurveyMainIdAndParentIdNotZero_Last(
		long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySurveyMainIdAndParentIdNotZero_Last(surveyMainId,
			orderByComparator);
	}

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
	public static com.lc.survey.model.SurveyQuestion[] findBySurveyMainIdAndParentIdNotZero_PrevAndNext(
		long surveyQuestionId, long surveyMainId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySurveyMainIdAndParentIdNotZero_PrevAndNext(surveyQuestionId,
			surveyMainId, orderByComparator);
	}

	/**
	* Removes all the survey questions where surveyMainId = &#63; from the database.
	*
	* @param surveyMainId the survey main ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySurveyMainIdAndParentIdNotZero(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySurveyMainIdAndParentIdNotZero(surveyMainId);
	}

	/**
	* Returns the number of survey questions where surveyMainId = &#63;.
	*
	* @param surveyMainId the survey main ID
	* @return the number of matching survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySurveyMainIdAndParentIdNotZero(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySurveyMainIdAndParentIdNotZero(surveyMainId);
	}

	/**
	* Caches the survey question in the entity cache if it is enabled.
	*
	* @param surveyQuestion the survey question
	*/
	public static void cacheResult(
		com.lc.survey.model.SurveyQuestion surveyQuestion) {
		getPersistence().cacheResult(surveyQuestion);
	}

	/**
	* Caches the survey questions in the entity cache if it is enabled.
	*
	* @param surveyQuestions the survey questions
	*/
	public static void cacheResult(
		java.util.List<com.lc.survey.model.SurveyQuestion> surveyQuestions) {
		getPersistence().cacheResult(surveyQuestions);
	}

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param surveyQuestionId the primary key for the new survey question
	* @return the new survey question
	*/
	public static com.lc.survey.model.SurveyQuestion create(
		long surveyQuestionId) {
		return getPersistence().create(surveyQuestionId);
	}

	/**
	* Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question that was removed
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion remove(
		long surveyQuestionId)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(surveyQuestionId);
	}

	public static com.lc.survey.model.SurveyQuestion updateImpl(
		com.lc.survey.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyQuestion);
	}

	/**
	* Returns the survey question with the primary key or throws a {@link com.lc.survey.NoSuchSurveyQuestionException} if it could not be found.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question
	* @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion findByPrimaryKey(
		long surveyQuestionId)
		throws com.lc.survey.NoSuchSurveyQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(surveyQuestionId);
	}

	/**
	* Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.lc.survey.model.SurveyQuestion fetchByPrimaryKey(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(surveyQuestionId);
	}

	/**
	* Returns all the survey questions.
	*
	* @return the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.lc.survey.model.SurveyQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SurveyQuestionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyQuestionPersistence)PortletBeanLocatorUtil.locate(com.lc.survey.service.ClpSerializer.getServletContextName(),
					SurveyQuestionPersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyQuestionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyQuestionPersistence persistence) {
	}

	private static SurveyQuestionPersistence _persistence;
}