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

import com.lc.survey.NoSuchSurveyPageException;
import com.lc.survey.model.SurveyPage;
import com.lc.survey.model.impl.SurveyPageImpl;
import com.lc.survey.model.impl.SurveyPageModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the survey page service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyPagePersistence
 * @see SurveyPageUtil
 * @generated
 */
public class SurveyPagePersistenceImpl extends BasePersistenceImpl<SurveyPage>
	implements SurveyPagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyPageUtil} to access the survey page persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyPageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, SurveyPageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, SurveyPageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, SurveyPageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, SurveyPageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyPageModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyPageModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey pages where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyPage> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey pages where surveyMainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyMainId the survey main ID
	 * @param start the lower bound of the range of survey pages
	 * @param end the upper bound of the range of survey pages (not inclusive)
	 * @return the range of matching survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyPage> findBySurveyMainId(long surveyMainId, int start,
		int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey pages where surveyMainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyMainId the survey main ID
	 * @param start the lower bound of the range of survey pages
	 * @param end the upper bound of the range of survey pages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyPage> findBySurveyMainId(long surveyMainId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID;
			finderArgs = new Object[] { surveyMainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID;
			finderArgs = new Object[] {
					surveyMainId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyPage> list = (List<SurveyPage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyPage surveyPage : list) {
				if ((surveyMainId != surveyPage.getSurveyMainId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SURVEYPAGE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyPageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyPage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyPage>(list);
				}
				else {
					list = (List<SurveyPage>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first survey page in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey page
	 * @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyPageException, SystemException {
		SurveyPage surveyPage = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyPage != null) {
			return surveyPage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyPageException(msg.toString());
	}

	/**
	 * Returns the first survey page in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey page, or <code>null</code> if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyPage> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey page in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey page
	 * @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyPageException, SystemException {
		SurveyPage surveyPage = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyPage != null) {
			return surveyPage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyPageException(msg.toString());
	}

	/**
	 * Returns the last survey page in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey page, or <code>null</code> if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyPage> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey pages before and after the current survey page in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyPageId the primary key of the current survey page
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey page
	 * @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage[] findBySurveyMainId_PrevAndNext(long surveyPageId,
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyPageException, SystemException {
		SurveyPage surveyPage = findByPrimaryKey(surveyPageId);

		Session session = null;

		try {
			session = openSession();

			SurveyPage[] array = new SurveyPageImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyPage,
					surveyMainId, orderByComparator, true);

			array[1] = surveyPage;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyPage,
					surveyMainId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyPage getBySurveyMainId_PrevAndNext(Session session,
		SurveyPage surveyPage, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYPAGE_WHERE);

		query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SurveyPageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyPage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyPage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey pages where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyPage surveyPage : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyPage);
		}
	}

	/**
	 * Returns the number of survey pages where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyMainId(long surveyMainId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYMAINID;

		Object[] finderArgs = new Object[] { surveyMainId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYPAGE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyPage.surveyMainId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO = new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, SurveyPageImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySurveyMainIdAndNo",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SurveyPageModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyPageModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINIDANDNO = new FinderPath(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySurveyMainIdAndNo",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the survey page where surveyMainId = &#63; and no = &#63; or throws a {@link com.lc.survey.NoSuchSurveyPageException} if it could not be found.
	 *
	 * @param surveyMainId the survey main ID
	 * @param no the no
	 * @return the matching survey page
	 * @throws com.lc.survey.NoSuchSurveyPageException if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage findBySurveyMainIdAndNo(long surveyMainId, int no)
		throws NoSuchSurveyPageException, SystemException {
		SurveyPage surveyPage = fetchBySurveyMainIdAndNo(surveyMainId, no);

		if (surveyPage == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("surveyMainId=");
			msg.append(surveyMainId);

			msg.append(", no=");
			msg.append(no);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSurveyPageException(msg.toString());
		}

		return surveyPage;
	}

	/**
	 * Returns the survey page where surveyMainId = &#63; and no = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param surveyMainId the survey main ID
	 * @param no the no
	 * @return the matching survey page, or <code>null</code> if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage fetchBySurveyMainIdAndNo(long surveyMainId, int no)
		throws SystemException {
		return fetchBySurveyMainIdAndNo(surveyMainId, no, true);
	}

	/**
	 * Returns the survey page where surveyMainId = &#63; and no = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param surveyMainId the survey main ID
	 * @param no the no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching survey page, or <code>null</code> if a matching survey page could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage fetchBySurveyMainIdAndNo(long surveyMainId, int no,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { surveyMainId, no };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
					finderArgs, this);
		}

		if (result instanceof SurveyPage) {
			SurveyPage surveyPage = (SurveyPage)result;

			if ((surveyMainId != surveyPage.getSurveyMainId()) ||
					(no != surveyPage.getNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SURVEYPAGE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINIDANDNO_SURVEYMAINID_2);

			query.append(_FINDER_COLUMN_SURVEYMAINIDANDNO_NO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				qPos.add(no);

				List<SurveyPage> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SurveyPagePersistenceImpl.fetchBySurveyMainIdAndNo(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SurveyPage surveyPage = list.get(0);

					result = surveyPage;

					cacheResult(surveyPage);

					if ((surveyPage.getSurveyMainId() != surveyMainId) ||
							(surveyPage.getNo() != no)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
							finderArgs, surveyPage);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SurveyPage)result;
		}
	}

	/**
	 * Removes the survey page where surveyMainId = &#63; and no = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @param no the no
	 * @return the survey page that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage removeBySurveyMainIdAndNo(long surveyMainId, int no)
		throws NoSuchSurveyPageException, SystemException {
		SurveyPage surveyPage = findBySurveyMainIdAndNo(surveyMainId, no);

		return remove(surveyPage);
	}

	/**
	 * Returns the number of survey pages where surveyMainId = &#63; and no = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param no the no
	 * @return the number of matching survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyMainIdAndNo(long surveyMainId, int no)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYMAINIDANDNO;

		Object[] finderArgs = new Object[] { surveyMainId, no };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYPAGE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINIDANDNO_SURVEYMAINID_2);

			query.append(_FINDER_COLUMN_SURVEYMAINIDANDNO_NO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				qPos.add(no);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SURVEYMAINIDANDNO_SURVEYMAINID_2 = "surveyPage.surveyMainId = ? AND ";
	private static final String _FINDER_COLUMN_SURVEYMAINIDANDNO_NO_2 = "surveyPage.no = ?";

	public SurveyPagePersistenceImpl() {
		setModelClass(SurveyPage.class);
	}

	/**
	 * Caches the survey page in the entity cache if it is enabled.
	 *
	 * @param surveyPage the survey page
	 */
	@Override
	public void cacheResult(SurveyPage surveyPage) {
		EntityCacheUtil.putResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageImpl.class, surveyPage.getPrimaryKey(), surveyPage);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
			new Object[] { surveyPage.getSurveyMainId(), surveyPage.getNo() },
			surveyPage);

		surveyPage.resetOriginalValues();
	}

	/**
	 * Caches the survey pages in the entity cache if it is enabled.
	 *
	 * @param surveyPages the survey pages
	 */
	@Override
	public void cacheResult(List<SurveyPage> surveyPages) {
		for (SurveyPage surveyPage : surveyPages) {
			if (EntityCacheUtil.getResult(
						SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
						SurveyPageImpl.class, surveyPage.getPrimaryKey()) == null) {
				cacheResult(surveyPage);
			}
			else {
				surveyPage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey pages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyPageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyPageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey page.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyPage surveyPage) {
		EntityCacheUtil.removeResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageImpl.class, surveyPage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(surveyPage);
	}

	@Override
	public void clearCache(List<SurveyPage> surveyPages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyPage surveyPage : surveyPages) {
			EntityCacheUtil.removeResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
				SurveyPageImpl.class, surveyPage.getPrimaryKey());

			clearUniqueFindersCache(surveyPage);
		}
	}

	protected void cacheUniqueFindersCache(SurveyPage surveyPage) {
		if (surveyPage.isNew()) {
			Object[] args = new Object[] {
					surveyPage.getSurveyMainId(), surveyPage.getNo()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SURVEYMAINIDANDNO,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
				args, surveyPage);
		}
		else {
			SurveyPageModelImpl surveyPageModelImpl = (SurveyPageModelImpl)surveyPage;

			if ((surveyPageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyPage.getSurveyMainId(), surveyPage.getNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SURVEYMAINIDANDNO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
					args, surveyPage);
			}
		}
	}

	protected void clearUniqueFindersCache(SurveyPage surveyPage) {
		SurveyPageModelImpl surveyPageModelImpl = (SurveyPageModelImpl)surveyPage;

		Object[] args = new Object[] {
				surveyPage.getSurveyMainId(), surveyPage.getNo()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINIDANDNO,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
			args);

		if ((surveyPageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO.getColumnBitmask()) != 0) {
			args = new Object[] {
					surveyPageModelImpl.getOriginalSurveyMainId(),
					surveyPageModelImpl.getOriginalNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINIDANDNO,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SURVEYMAINIDANDNO,
				args);
		}
	}

	/**
	 * Creates a new survey page with the primary key. Does not add the survey page to the database.
	 *
	 * @param surveyPageId the primary key for the new survey page
	 * @return the new survey page
	 */
	@Override
	public SurveyPage create(long surveyPageId) {
		SurveyPage surveyPage = new SurveyPageImpl();

		surveyPage.setNew(true);
		surveyPage.setPrimaryKey(surveyPageId);

		return surveyPage;
	}

	/**
	 * Removes the survey page with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyPageId the primary key of the survey page
	 * @return the survey page that was removed
	 * @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage remove(long surveyPageId)
		throws NoSuchSurveyPageException, SystemException {
		return remove((Serializable)surveyPageId);
	}

	/**
	 * Removes the survey page with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey page
	 * @return the survey page that was removed
	 * @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage remove(Serializable primaryKey)
		throws NoSuchSurveyPageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyPage surveyPage = (SurveyPage)session.get(SurveyPageImpl.class,
					primaryKey);

			if (surveyPage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyPageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyPage);
		}
		catch (NoSuchSurveyPageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SurveyPage removeImpl(SurveyPage surveyPage)
		throws SystemException {
		surveyPage = toUnwrappedModel(surveyPage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyPage)) {
				surveyPage = (SurveyPage)session.get(SurveyPageImpl.class,
						surveyPage.getPrimaryKeyObj());
			}

			if (surveyPage != null) {
				session.delete(surveyPage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyPage != null) {
			clearCache(surveyPage);
		}

		return surveyPage;
	}

	@Override
	public SurveyPage updateImpl(com.lc.survey.model.SurveyPage surveyPage)
		throws SystemException {
		surveyPage = toUnwrappedModel(surveyPage);

		boolean isNew = surveyPage.isNew();

		SurveyPageModelImpl surveyPageModelImpl = (SurveyPageModelImpl)surveyPage;

		Session session = null;

		try {
			session = openSession();

			if (surveyPage.isNew()) {
				session.save(surveyPage);

				surveyPage.setNew(false);
			}
			else {
				session.merge(surveyPage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyPageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyPageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyPageModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyPageModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
			SurveyPageImpl.class, surveyPage.getPrimaryKey(), surveyPage);

		clearUniqueFindersCache(surveyPage);
		cacheUniqueFindersCache(surveyPage);

		return surveyPage;
	}

	protected SurveyPage toUnwrappedModel(SurveyPage surveyPage) {
		if (surveyPage instanceof SurveyPageImpl) {
			return surveyPage;
		}

		SurveyPageImpl surveyPageImpl = new SurveyPageImpl();

		surveyPageImpl.setNew(surveyPage.isNew());
		surveyPageImpl.setPrimaryKey(surveyPage.getPrimaryKey());

		surveyPageImpl.setSurveyPageId(surveyPage.getSurveyPageId());
		surveyPageImpl.setSurveyMainId(surveyPage.getSurveyMainId());
		surveyPageImpl.setNo(surveyPage.getNo());
		surveyPageImpl.setTitle(surveyPage.getTitle());
		surveyPageImpl.setPageDirectId(surveyPage.getPageDirectId());
		surveyPageImpl.setCreatorId(surveyPage.getCreatorId());
		surveyPageImpl.setModifierId(surveyPage.getModifierId());
		surveyPageImpl.setCreateDate(surveyPage.getCreateDate());
		surveyPageImpl.setModifiedDate(surveyPage.getModifiedDate());

		return surveyPageImpl;
	}

	/**
	 * Returns the survey page with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey page
	 * @return the survey page
	 * @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyPageException, SystemException {
		SurveyPage surveyPage = fetchByPrimaryKey(primaryKey);

		if (surveyPage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyPageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyPage;
	}

	/**
	 * Returns the survey page with the primary key or throws a {@link com.lc.survey.NoSuchSurveyPageException} if it could not be found.
	 *
	 * @param surveyPageId the primary key of the survey page
	 * @return the survey page
	 * @throws com.lc.survey.NoSuchSurveyPageException if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage findByPrimaryKey(long surveyPageId)
		throws NoSuchSurveyPageException, SystemException {
		return findByPrimaryKey((Serializable)surveyPageId);
	}

	/**
	 * Returns the survey page with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey page
	 * @return the survey page, or <code>null</code> if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyPage surveyPage = (SurveyPage)EntityCacheUtil.getResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
				SurveyPageImpl.class, primaryKey);

		if (surveyPage == _nullSurveyPage) {
			return null;
		}

		if (surveyPage == null) {
			Session session = null;

			try {
				session = openSession();

				surveyPage = (SurveyPage)session.get(SurveyPageImpl.class,
						primaryKey);

				if (surveyPage != null) {
					cacheResult(surveyPage);
				}
				else {
					EntityCacheUtil.putResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
						SurveyPageImpl.class, primaryKey, _nullSurveyPage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyPageModelImpl.ENTITY_CACHE_ENABLED,
					SurveyPageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyPage;
	}

	/**
	 * Returns the survey page with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyPageId the primary key of the survey page
	 * @return the survey page, or <code>null</code> if a survey page with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyPage fetchByPrimaryKey(long surveyPageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyPageId);
	}

	/**
	 * Returns all the survey pages.
	 *
	 * @return the survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyPage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey pages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey pages
	 * @param end the upper bound of the range of survey pages (not inclusive)
	 * @return the range of survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyPage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey pages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyPageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey pages
	 * @param end the upper bound of the range of survey pages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyPage> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SurveyPage> list = (List<SurveyPage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYPAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYPAGE;

				if (pagination) {
					sql = sql.concat(SurveyPageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyPage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyPage>(list);
				}
				else {
					list = (List<SurveyPage>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the survey pages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyPage surveyPage : findAll()) {
			remove(surveyPage);
		}
	}

	/**
	 * Returns the number of survey pages.
	 *
	 * @return the number of survey pages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SURVEYPAGE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the survey page persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyPage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyPage>> listenersList = new ArrayList<ModelListener<SurveyPage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyPage>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SurveyPageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYPAGE = "SELECT surveyPage FROM SurveyPage surveyPage";
	private static final String _SQL_SELECT_SURVEYPAGE_WHERE = "SELECT surveyPage FROM SurveyPage surveyPage WHERE ";
	private static final String _SQL_COUNT_SURVEYPAGE = "SELECT COUNT(surveyPage) FROM SurveyPage surveyPage";
	private static final String _SQL_COUNT_SURVEYPAGE_WHERE = "SELECT COUNT(surveyPage) FROM SurveyPage surveyPage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyPage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyPage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyPage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyPagePersistenceImpl.class);
	private static SurveyPage _nullSurveyPage = new SurveyPageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyPage> toCacheModel() {
				return _nullSurveyPageCacheModel;
			}
		};

	private static CacheModel<SurveyPage> _nullSurveyPageCacheModel = new CacheModel<SurveyPage>() {
			@Override
			public SurveyPage toEntityModel() {
				return _nullSurveyPage;
			}
		};
}