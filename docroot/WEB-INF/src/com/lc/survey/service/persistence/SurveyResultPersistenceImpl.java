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

import com.lc.survey.NoSuchSurveyResultException;
import com.lc.survey.model.SurveyResult;
import com.lc.survey.model.impl.SurveyResultImpl;
import com.lc.survey.model.impl.SurveyResultModelImpl;

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
 * The persistence implementation for the survey result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyResultPersistence
 * @see SurveyResultUtil
 * @generated
 */
public class SurveyResultPersistenceImpl extends BasePersistenceImpl<SurveyResult>
	implements SurveyResultPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyResultUtil} to access the survey result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyResultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyResultModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyResultModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey results where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey results where surveyMainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyMainId the survey main ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @return the range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findBySurveyMainId(long surveyMainId, int start,
		int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey results where surveyMainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyMainId the survey main ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findBySurveyMainId(long surveyMainId, int start,
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

		List<SurveyResult> list = (List<SurveyResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResult surveyResult : list) {
				if ((surveyMainId != surveyResult.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResult>(list);
				}
				else {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey result in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the first survey result in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyResult> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey result in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the last survey result in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyResult> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey results before and after the current survey result in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyResultId the primary key of the current survey result
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult[] findBySurveyMainId_PrevAndNext(long surveyResultId,
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = findByPrimaryKey(surveyResultId);

		Session session = null;

		try {
			session = openSession();

			SurveyResult[] array = new SurveyResultImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyResult,
					surveyMainId, orderByComparator, true);

			array[1] = surveyResult;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyResult,
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

	protected SurveyResult getBySurveyMainId_PrevAndNext(Session session,
		SurveyResult surveyResult, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

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
			query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey results where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyResult surveyResult : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResult);
		}
	}

	/**
	 * Returns the number of survey results where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey results
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

			query.append(_SQL_COUNT_SURVEYRESULT_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyResult.surveyMainId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYWRITERID =
		new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyWriterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID =
		new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyWriterId",
			new String[] { Long.class.getName() },
			SurveyResultModelImpl.SURVEYWRITERID_COLUMN_BITMASK |
			SurveyResultModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYWRITERID = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyWriterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey results where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @return the matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findBySurveyWriterId(long surveyWriterId)
		throws SystemException {
		return findBySurveyWriterId(surveyWriterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey results where surveyWriterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @return the range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findBySurveyWriterId(long surveyWriterId,
		int start, int end) throws SystemException {
		return findBySurveyWriterId(surveyWriterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey results where surveyWriterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findBySurveyWriterId(long surveyWriterId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID;
			finderArgs = new Object[] { surveyWriterId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYWRITERID;
			finderArgs = new Object[] {
					surveyWriterId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyResult> list = (List<SurveyResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResult surveyResult : list) {
				if ((surveyWriterId != surveyResult.getSurveyWriterId())) {
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

			query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_SURVEYWRITERID_SURVEYWRITERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyWriterId);

				if (!pagination) {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResult>(list);
				}
				else {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey result in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findBySurveyWriterId_First(long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchBySurveyWriterId_First(surveyWriterId,
				orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the first survey result in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchBySurveyWriterId_First(long surveyWriterId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyResult> list = findBySurveyWriterId(surveyWriterId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey result in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findBySurveyWriterId_Last(long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchBySurveyWriterId_Last(surveyWriterId,
				orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the last survey result in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchBySurveyWriterId_Last(long surveyWriterId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyWriterId(surveyWriterId);

		if (count == 0) {
			return null;
		}

		List<SurveyResult> list = findBySurveyWriterId(surveyWriterId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey results before and after the current survey result in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyResultId the primary key of the current survey result
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult[] findBySurveyWriterId_PrevAndNext(
		long surveyResultId, long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = findByPrimaryKey(surveyResultId);

		Session session = null;

		try {
			session = openSession();

			SurveyResult[] array = new SurveyResultImpl[3];

			array[0] = getBySurveyWriterId_PrevAndNext(session, surveyResult,
					surveyWriterId, orderByComparator, true);

			array[1] = surveyResult;

			array[2] = getBySurveyWriterId_PrevAndNext(session, surveyResult,
					surveyWriterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyResult getBySurveyWriterId_PrevAndNext(Session session,
		SurveyResult surveyResult, long surveyWriterId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

		query.append(_FINDER_COLUMN_SURVEYWRITERID_SURVEYWRITERID_2);

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
			query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyWriterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey results where surveyWriterId = &#63; from the database.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyWriterId(long surveyWriterId)
		throws SystemException {
		for (SurveyResult surveyResult : findBySurveyWriterId(surveyWriterId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResult);
		}
	}

	/**
	 * Returns the number of survey results where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @return the number of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyWriterId(long surveyWriterId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYWRITERID;

		Object[] finderArgs = new Object[] { surveyWriterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_SURVEYWRITERID_SURVEYWRITERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyWriterId);

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

	private static final String _FINDER_COLUMN_SURVEYWRITERID_SURVEYWRITERID_2 = "surveyResult.surveyWriterId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_W",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_W",
			new String[] { Long.class.getName(), Long.class.getName() },
			SurveyResultModelImpl.SURVEYPAGEID_COLUMN_BITMASK |
			SurveyResultModelImpl.SURVEYWRITERID_COLUMN_BITMASK |
			SurveyResultModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_W",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @return the matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByP_W(long surveyPageId, long surveyWriterId)
		throws SystemException {
		return findByP_W(surveyPageId, surveyWriterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @return the range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByP_W(long surveyPageId, long surveyWriterId,
		int start, int end) throws SystemException {
		return findByP_W(surveyPageId, surveyWriterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByP_W(long surveyPageId, long surveyWriterId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W;
			finderArgs = new Object[] { surveyPageId, surveyWriterId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_W;
			finderArgs = new Object[] {
					surveyPageId, surveyWriterId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyResult> list = (List<SurveyResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResult surveyResult : list) {
				if ((surveyPageId != surveyResult.getSurveyPageId()) ||
						(surveyWriterId != surveyResult.getSurveyWriterId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_P_W_SURVEYPAGEID_2);

			query.append(_FINDER_COLUMN_P_W_SURVEYWRITERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

				qPos.add(surveyWriterId);

				if (!pagination) {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResult>(list);
				}
				else {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByP_W_First(long surveyPageId, long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByP_W_First(surveyPageId,
				surveyWriterId, orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(", surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the first survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByP_W_First(long surveyPageId,
		long surveyWriterId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SurveyResult> list = findByP_W(surveyPageId, surveyWriterId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByP_W_Last(long surveyPageId, long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByP_W_Last(surveyPageId,
				surveyWriterId, orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(", surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the last survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByP_W_Last(long surveyPageId, long surveyWriterId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByP_W(surveyPageId, surveyWriterId);

		if (count == 0) {
			return null;
		}

		List<SurveyResult> list = findByP_W(surveyPageId, surveyWriterId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey results before and after the current survey result in the ordered set where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyResultId the primary key of the current survey result
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult[] findByP_W_PrevAndNext(long surveyResultId,
		long surveyPageId, long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = findByPrimaryKey(surveyResultId);

		Session session = null;

		try {
			session = openSession();

			SurveyResult[] array = new SurveyResultImpl[3];

			array[0] = getByP_W_PrevAndNext(session, surveyResult,
					surveyPageId, surveyWriterId, orderByComparator, true);

			array[1] = surveyResult;

			array[2] = getByP_W_PrevAndNext(session, surveyResult,
					surveyPageId, surveyWriterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyResult getByP_W_PrevAndNext(Session session,
		SurveyResult surveyResult, long surveyPageId, long surveyWriterId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

		query.append(_FINDER_COLUMN_P_W_SURVEYPAGEID_2);

		query.append(_FINDER_COLUMN_P_W_SURVEYWRITERID_2);

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
			query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyPageId);

		qPos.add(surveyWriterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey results where surveyPageId = &#63; and surveyWriterId = &#63; from the database.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByP_W(long surveyPageId, long surveyWriterId)
		throws SystemException {
		for (SurveyResult surveyResult : findByP_W(surveyPageId,
				surveyWriterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResult);
		}
	}

	/**
	 * Returns the number of survey results where surveyPageId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param surveyWriterId the survey writer ID
	 * @return the number of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByP_W(long surveyPageId, long surveyWriterId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_P_W;

		Object[] finderArgs = new Object[] { surveyPageId, surveyWriterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_P_W_SURVEYPAGEID_2);

			query.append(_FINDER_COLUMN_P_W_SURVEYWRITERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

				qPos.add(surveyWriterId);

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

	private static final String _FINDER_COLUMN_P_W_SURVEYPAGEID_2 = "surveyResult.surveyPageId = ? AND ";
	private static final String _FINDER_COLUMN_P_W_SURVEYWRITERID_2 = "surveyResult.surveyWriterId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_Q_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQ_W",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQ_W",
			new String[] { Long.class.getName(), Long.class.getName() },
			SurveyResultModelImpl.SURVEYQUESTIONID_COLUMN_BITMASK |
			SurveyResultModelImpl.SURVEYWRITERID_COLUMN_BITMASK |
			SurveyResultModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_Q_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQ_W",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @return the matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByQ_W(long surveyQuestionId,
		long surveyWriterId) throws SystemException {
		return findByQ_W(surveyQuestionId, surveyWriterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @return the range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByQ_W(long surveyQuestionId,
		long surveyWriterId, int start, int end) throws SystemException {
		return findByQ_W(surveyQuestionId, surveyWriterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByQ_W(long surveyQuestionId,
		long surveyWriterId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_W;
			finderArgs = new Object[] { surveyQuestionId, surveyWriterId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_Q_W;
			finderArgs = new Object[] {
					surveyQuestionId, surveyWriterId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyResult> list = (List<SurveyResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResult surveyResult : list) {
				if ((surveyQuestionId != surveyResult.getSurveyQuestionId()) ||
						(surveyWriterId != surveyResult.getSurveyWriterId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_Q_W_SURVEYQUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_W_SURVEYWRITERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				qPos.add(surveyWriterId);

				if (!pagination) {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResult>(list);
				}
				else {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByQ_W_First(long surveyQuestionId,
		long surveyWriterId, OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByQ_W_First(surveyQuestionId,
				surveyWriterId, orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(", surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByQ_W_First(long surveyQuestionId,
		long surveyWriterId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SurveyResult> list = findByQ_W(surveyQuestionId, surveyWriterId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByQ_W_Last(long surveyQuestionId,
		long surveyWriterId, OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByQ_W_Last(surveyQuestionId,
				surveyWriterId, orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(", surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByQ_W_Last(long surveyQuestionId,
		long surveyWriterId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByQ_W(surveyQuestionId, surveyWriterId);

		if (count == 0) {
			return null;
		}

		List<SurveyResult> list = findByQ_W(surveyQuestionId, surveyWriterId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey results before and after the current survey result in the ordered set where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyResultId the primary key of the current survey result
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult[] findByQ_W_PrevAndNext(long surveyResultId,
		long surveyQuestionId, long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = findByPrimaryKey(surveyResultId);

		Session session = null;

		try {
			session = openSession();

			SurveyResult[] array = new SurveyResultImpl[3];

			array[0] = getByQ_W_PrevAndNext(session, surveyResult,
					surveyQuestionId, surveyWriterId, orderByComparator, true);

			array[1] = surveyResult;

			array[2] = getByQ_W_PrevAndNext(session, surveyResult,
					surveyQuestionId, surveyWriterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyResult getByQ_W_PrevAndNext(Session session,
		SurveyResult surveyResult, long surveyQuestionId, long surveyWriterId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

		query.append(_FINDER_COLUMN_Q_W_SURVEYQUESTIONID_2);

		query.append(_FINDER_COLUMN_Q_W_SURVEYWRITERID_2);

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
			query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyQuestionId);

		qPos.add(surveyWriterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey results where surveyQuestionId = &#63; and surveyWriterId = &#63; from the database.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQ_W(long surveyQuestionId, long surveyWriterId)
		throws SystemException {
		for (SurveyResult surveyResult : findByQ_W(surveyQuestionId,
				surveyWriterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResult);
		}
	}

	/**
	 * Returns the number of survey results where surveyQuestionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyWriterId the survey writer ID
	 * @return the number of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQ_W(long surveyQuestionId, long surveyWriterId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_Q_W;

		Object[] finderArgs = new Object[] { surveyQuestionId, surveyWriterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_Q_W_SURVEYQUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_W_SURVEYWRITERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				qPos.add(surveyWriterId);

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

	private static final String _FINDER_COLUMN_Q_W_SURVEYQUESTIONID_2 = "surveyResult.surveyQuestionId = ? AND ";
	private static final String _FINDER_COLUMN_Q_W_SURVEYWRITERID_2 = "surveyResult.surveyWriterId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_Q_O = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQ_O",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_O = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQ_O",
			new String[] { Long.class.getName(), Long.class.getName() },
			SurveyResultModelImpl.SURVEYQUESTIONID_COLUMN_BITMASK |
			SurveyResultModelImpl.SURVEYOPTIONID_COLUMN_BITMASK |
			SurveyResultModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_Q_O = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQ_O",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @return the matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByQ_O(long surveyQuestionId,
		long surveyOptionId) throws SystemException {
		return findByQ_O(surveyQuestionId, surveyOptionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @return the range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByQ_O(long surveyQuestionId,
		long surveyOptionId, int start, int end) throws SystemException {
		return findByQ_O(surveyQuestionId, surveyOptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findByQ_O(long surveyQuestionId,
		long surveyOptionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_O;
			finderArgs = new Object[] { surveyQuestionId, surveyOptionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_Q_O;
			finderArgs = new Object[] {
					surveyQuestionId, surveyOptionId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyResult> list = (List<SurveyResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResult surveyResult : list) {
				if ((surveyQuestionId != surveyResult.getSurveyQuestionId()) ||
						(surveyOptionId != surveyResult.getSurveyOptionId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_Q_O_SURVEYQUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_O_SURVEYOPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				qPos.add(surveyOptionId);

				if (!pagination) {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResult>(list);
				}
				else {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByQ_O_First(long surveyQuestionId,
		long surveyOptionId, OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByQ_O_First(surveyQuestionId,
				surveyOptionId, orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(", surveyOptionId=");
		msg.append(surveyOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the first survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByQ_O_First(long surveyQuestionId,
		long surveyOptionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SurveyResult> list = findByQ_O(surveyQuestionId, surveyOptionId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByQ_O_Last(long surveyQuestionId,
		long surveyOptionId, OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByQ_O_Last(surveyQuestionId,
				surveyOptionId, orderByComparator);

		if (surveyResult != null) {
			return surveyResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(", surveyOptionId=");
		msg.append(surveyOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResultException(msg.toString());
	}

	/**
	 * Returns the last survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByQ_O_Last(long surveyQuestionId,
		long surveyOptionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByQ_O(surveyQuestionId, surveyOptionId);

		if (count == 0) {
			return null;
		}

		List<SurveyResult> list = findByQ_O(surveyQuestionId, surveyOptionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey results before and after the current survey result in the ordered set where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyResultId the primary key of the current survey result
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult[] findByQ_O_PrevAndNext(long surveyResultId,
		long surveyQuestionId, long surveyOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = findByPrimaryKey(surveyResultId);

		Session session = null;

		try {
			session = openSession();

			SurveyResult[] array = new SurveyResultImpl[3];

			array[0] = getByQ_O_PrevAndNext(session, surveyResult,
					surveyQuestionId, surveyOptionId, orderByComparator, true);

			array[1] = surveyResult;

			array[2] = getByQ_O_PrevAndNext(session, surveyResult,
					surveyQuestionId, surveyOptionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyResult getByQ_O_PrevAndNext(Session session,
		SurveyResult surveyResult, long surveyQuestionId, long surveyOptionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

		query.append(_FINDER_COLUMN_Q_O_SURVEYQUESTIONID_2);

		query.append(_FINDER_COLUMN_Q_O_SURVEYOPTIONID_2);

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
			query.append(SurveyResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyQuestionId);

		qPos.add(surveyOptionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey results where surveyQuestionId = &#63; and surveyOptionId = &#63; from the database.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQ_O(long surveyQuestionId, long surveyOptionId)
		throws SystemException {
		for (SurveyResult surveyResult : findByQ_O(surveyQuestionId,
				surveyOptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResult);
		}
	}

	/**
	 * Returns the number of survey results where surveyQuestionId = &#63; and surveyOptionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param surveyOptionId the survey option ID
	 * @return the number of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQ_O(long surveyQuestionId, long surveyOptionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_Q_O;

		Object[] finderArgs = new Object[] { surveyQuestionId, surveyOptionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_Q_O_SURVEYQUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_O_SURVEYOPTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				qPos.add(surveyOptionId);

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

	private static final String _FINDER_COLUMN_Q_O_SURVEYQUESTIONID_2 = "surveyResult.surveyQuestionId = ? AND ";
	private static final String _FINDER_COLUMN_Q_O_SURVEYOPTIONID_2 = "surveyResult.surveyOptionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_O_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, SurveyResultImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByO_W",
			new String[] { Long.class.getName(), Long.class.getName() },
			SurveyResultModelImpl.SURVEYOPTIONID_COLUMN_BITMASK |
			SurveyResultModelImpl.SURVEYWRITERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_O_W = new FinderPath(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByO_W",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; or throws a {@link com.lc.survey.NoSuchSurveyResultException} if it could not be found.
	 *
	 * @param surveyOptionId the survey option ID
	 * @param surveyWriterId the survey writer ID
	 * @return the matching survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByO_W(long surveyOptionId, long surveyWriterId)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByO_W(surveyOptionId, surveyWriterId);

		if (surveyResult == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("surveyOptionId=");
			msg.append(surveyOptionId);

			msg.append(", surveyWriterId=");
			msg.append(surveyWriterId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSurveyResultException(msg.toString());
		}

		return surveyResult;
	}

	/**
	 * Returns the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param surveyOptionId the survey option ID
	 * @param surveyWriterId the survey writer ID
	 * @return the matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByO_W(long surveyOptionId, long surveyWriterId)
		throws SystemException {
		return fetchByO_W(surveyOptionId, surveyWriterId, true);
	}

	/**
	 * Returns the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param surveyOptionId the survey option ID
	 * @param surveyWriterId the survey writer ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching survey result, or <code>null</code> if a matching survey result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByO_W(long surveyOptionId, long surveyWriterId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { surveyOptionId, surveyWriterId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_O_W,
					finderArgs, this);
		}

		if (result instanceof SurveyResult) {
			SurveyResult surveyResult = (SurveyResult)result;

			if ((surveyOptionId != surveyResult.getSurveyOptionId()) ||
					(surveyWriterId != surveyResult.getSurveyWriterId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_O_W_SURVEYOPTIONID_2);

			query.append(_FINDER_COLUMN_O_W_SURVEYWRITERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyOptionId);

				qPos.add(surveyWriterId);

				List<SurveyResult> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_O_W,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SurveyResultPersistenceImpl.fetchByO_W(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SurveyResult surveyResult = list.get(0);

					result = surveyResult;

					cacheResult(surveyResult);

					if ((surveyResult.getSurveyOptionId() != surveyOptionId) ||
							(surveyResult.getSurveyWriterId() != surveyWriterId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_O_W,
							finderArgs, surveyResult);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_O_W,
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
			return (SurveyResult)result;
		}
	}

	/**
	 * Removes the survey result where surveyOptionId = &#63; and surveyWriterId = &#63; from the database.
	 *
	 * @param surveyOptionId the survey option ID
	 * @param surveyWriterId the survey writer ID
	 * @return the survey result that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult removeByO_W(long surveyOptionId, long surveyWriterId)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = findByO_W(surveyOptionId, surveyWriterId);

		return remove(surveyResult);
	}

	/**
	 * Returns the number of survey results where surveyOptionId = &#63; and surveyWriterId = &#63;.
	 *
	 * @param surveyOptionId the survey option ID
	 * @param surveyWriterId the survey writer ID
	 * @return the number of matching survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByO_W(long surveyOptionId, long surveyWriterId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_O_W;

		Object[] finderArgs = new Object[] { surveyOptionId, surveyWriterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYRESULT_WHERE);

			query.append(_FINDER_COLUMN_O_W_SURVEYOPTIONID_2);

			query.append(_FINDER_COLUMN_O_W_SURVEYWRITERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyOptionId);

				qPos.add(surveyWriterId);

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

	private static final String _FINDER_COLUMN_O_W_SURVEYOPTIONID_2 = "surveyResult.surveyOptionId = ? AND ";
	private static final String _FINDER_COLUMN_O_W_SURVEYWRITERID_2 = "surveyResult.surveyWriterId = ?";

	public SurveyResultPersistenceImpl() {
		setModelClass(SurveyResult.class);
	}

	/**
	 * Caches the survey result in the entity cache if it is enabled.
	 *
	 * @param surveyResult the survey result
	 */
	@Override
	public void cacheResult(SurveyResult surveyResult) {
		EntityCacheUtil.putResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultImpl.class, surveyResult.getPrimaryKey(), surveyResult);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_O_W,
			new Object[] {
				surveyResult.getSurveyOptionId(),
				surveyResult.getSurveyWriterId()
			}, surveyResult);

		surveyResult.resetOriginalValues();
	}

	/**
	 * Caches the survey results in the entity cache if it is enabled.
	 *
	 * @param surveyResults the survey results
	 */
	@Override
	public void cacheResult(List<SurveyResult> surveyResults) {
		for (SurveyResult surveyResult : surveyResults) {
			if (EntityCacheUtil.getResult(
						SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
						SurveyResultImpl.class, surveyResult.getPrimaryKey()) == null) {
				cacheResult(surveyResult);
			}
			else {
				surveyResult.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey results.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyResultImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyResultImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey result.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyResult surveyResult) {
		EntityCacheUtil.removeResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultImpl.class, surveyResult.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(surveyResult);
	}

	@Override
	public void clearCache(List<SurveyResult> surveyResults) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyResult surveyResult : surveyResults) {
			EntityCacheUtil.removeResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
				SurveyResultImpl.class, surveyResult.getPrimaryKey());

			clearUniqueFindersCache(surveyResult);
		}
	}

	protected void cacheUniqueFindersCache(SurveyResult surveyResult) {
		if (surveyResult.isNew()) {
			Object[] args = new Object[] {
					surveyResult.getSurveyOptionId(),
					surveyResult.getSurveyWriterId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_O_W, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_O_W, args,
				surveyResult);
		}
		else {
			SurveyResultModelImpl surveyResultModelImpl = (SurveyResultModelImpl)surveyResult;

			if ((surveyResultModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_O_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResult.getSurveyOptionId(),
						surveyResult.getSurveyWriterId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_O_W, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_O_W, args,
					surveyResult);
			}
		}
	}

	protected void clearUniqueFindersCache(SurveyResult surveyResult) {
		SurveyResultModelImpl surveyResultModelImpl = (SurveyResultModelImpl)surveyResult;

		Object[] args = new Object[] {
				surveyResult.getSurveyOptionId(),
				surveyResult.getSurveyWriterId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_W, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_O_W, args);

		if ((surveyResultModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_O_W.getColumnBitmask()) != 0) {
			args = new Object[] {
					surveyResultModelImpl.getOriginalSurveyOptionId(),
					surveyResultModelImpl.getOriginalSurveyWriterId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_O_W, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_O_W, args);
		}
	}

	/**
	 * Creates a new survey result with the primary key. Does not add the survey result to the database.
	 *
	 * @param surveyResultId the primary key for the new survey result
	 * @return the new survey result
	 */
	@Override
	public SurveyResult create(long surveyResultId) {
		SurveyResult surveyResult = new SurveyResultImpl();

		surveyResult.setNew(true);
		surveyResult.setPrimaryKey(surveyResultId);

		return surveyResult;
	}

	/**
	 * Removes the survey result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyResultId the primary key of the survey result
	 * @return the survey result that was removed
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult remove(long surveyResultId)
		throws NoSuchSurveyResultException, SystemException {
		return remove((Serializable)surveyResultId);
	}

	/**
	 * Removes the survey result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey result
	 * @return the survey result that was removed
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult remove(Serializable primaryKey)
		throws NoSuchSurveyResultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyResult surveyResult = (SurveyResult)session.get(SurveyResultImpl.class,
					primaryKey);

			if (surveyResult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyResult);
		}
		catch (NoSuchSurveyResultException nsee) {
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
	protected SurveyResult removeImpl(SurveyResult surveyResult)
		throws SystemException {
		surveyResult = toUnwrappedModel(surveyResult);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyResult)) {
				surveyResult = (SurveyResult)session.get(SurveyResultImpl.class,
						surveyResult.getPrimaryKeyObj());
			}

			if (surveyResult != null) {
				session.delete(surveyResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyResult != null) {
			clearCache(surveyResult);
		}

		return surveyResult;
	}

	@Override
	public SurveyResult updateImpl(
		com.lc.survey.model.SurveyResult surveyResult)
		throws SystemException {
		surveyResult = toUnwrappedModel(surveyResult);

		boolean isNew = surveyResult.isNew();

		SurveyResultModelImpl surveyResultModelImpl = (SurveyResultModelImpl)surveyResult;

		Session session = null;

		try {
			session = openSession();

			if (surveyResult.isNew()) {
				session.save(surveyResult);

				surveyResult.setNew(false);
			}
			else {
				session.merge(surveyResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyResultModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResultModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyResultModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}

			if ((surveyResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResultModelImpl.getOriginalSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYWRITERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID,
					args);

				args = new Object[] { surveyResultModelImpl.getSurveyWriterId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYWRITERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID,
					args);
			}

			if ((surveyResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResultModelImpl.getOriginalSurveyPageId(),
						surveyResultModelImpl.getOriginalSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W,
					args);

				args = new Object[] {
						surveyResultModelImpl.getSurveyPageId(),
						surveyResultModelImpl.getSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_W,
					args);
			}

			if ((surveyResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_W.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResultModelImpl.getOriginalSurveyQuestionId(),
						surveyResultModelImpl.getOriginalSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_Q_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_W,
					args);

				args = new Object[] {
						surveyResultModelImpl.getSurveyQuestionId(),
						surveyResultModelImpl.getSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_Q_W, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_W,
					args);
			}

			if ((surveyResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResultModelImpl.getOriginalSurveyQuestionId(),
						surveyResultModelImpl.getOriginalSurveyOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_Q_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_O,
					args);

				args = new Object[] {
						surveyResultModelImpl.getSurveyQuestionId(),
						surveyResultModelImpl.getSurveyOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_Q_O, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_O,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResultImpl.class, surveyResult.getPrimaryKey(), surveyResult);

		clearUniqueFindersCache(surveyResult);
		cacheUniqueFindersCache(surveyResult);

		return surveyResult;
	}

	protected SurveyResult toUnwrappedModel(SurveyResult surveyResult) {
		if (surveyResult instanceof SurveyResultImpl) {
			return surveyResult;
		}

		SurveyResultImpl surveyResultImpl = new SurveyResultImpl();

		surveyResultImpl.setNew(surveyResult.isNew());
		surveyResultImpl.setPrimaryKey(surveyResult.getPrimaryKey());

		surveyResultImpl.setSurveyResultId(surveyResult.getSurveyResultId());
		surveyResultImpl.setSurveyMainId(surveyResult.getSurveyMainId());
		surveyResultImpl.setSurveyPageId(surveyResult.getSurveyPageId());
		surveyResultImpl.setSurveyQuestionId(surveyResult.getSurveyQuestionId());
		surveyResultImpl.setSurveyOptionId(surveyResult.getSurveyOptionId());
		surveyResultImpl.setSurveyWriterId(surveyResult.getSurveyWriterId());
		surveyResultImpl.setAns(surveyResult.getAns());
		surveyResultImpl.setCreatorId(surveyResult.getCreatorId());
		surveyResultImpl.setCreateDate(surveyResult.getCreateDate());

		return surveyResultImpl;
	}

	/**
	 * Returns the survey result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey result
	 * @return the survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyResultException, SystemException {
		SurveyResult surveyResult = fetchByPrimaryKey(primaryKey);

		if (surveyResult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyResult;
	}

	/**
	 * Returns the survey result with the primary key or throws a {@link com.lc.survey.NoSuchSurveyResultException} if it could not be found.
	 *
	 * @param surveyResultId the primary key of the survey result
	 * @return the survey result
	 * @throws com.lc.survey.NoSuchSurveyResultException if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult findByPrimaryKey(long surveyResultId)
		throws NoSuchSurveyResultException, SystemException {
		return findByPrimaryKey((Serializable)surveyResultId);
	}

	/**
	 * Returns the survey result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey result
	 * @return the survey result, or <code>null</code> if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyResult surveyResult = (SurveyResult)EntityCacheUtil.getResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
				SurveyResultImpl.class, primaryKey);

		if (surveyResult == _nullSurveyResult) {
			return null;
		}

		if (surveyResult == null) {
			Session session = null;

			try {
				session = openSession();

				surveyResult = (SurveyResult)session.get(SurveyResultImpl.class,
						primaryKey);

				if (surveyResult != null) {
					cacheResult(surveyResult);
				}
				else {
					EntityCacheUtil.putResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
						SurveyResultImpl.class, primaryKey, _nullSurveyResult);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyResultModelImpl.ENTITY_CACHE_ENABLED,
					SurveyResultImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyResult;
	}

	/**
	 * Returns the survey result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyResultId the primary key of the survey result
	 * @return the survey result, or <code>null</code> if a survey result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResult fetchByPrimaryKey(long surveyResultId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyResultId);
	}

	/**
	 * Returns all the survey results.
	 *
	 * @return the survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @return the range of survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey results
	 * @param end the upper bound of the range of survey results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of survey results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResult> findAll(int start, int end,
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

		List<SurveyResult> list = (List<SurveyResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYRESULT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYRESULT;

				if (pagination) {
					sql = sql.concat(SurveyResultModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResult>(list);
				}
				else {
					list = (List<SurveyResult>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the survey results from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyResult surveyResult : findAll()) {
			remove(surveyResult);
		}
	}

	/**
	 * Returns the number of survey results.
	 *
	 * @return the number of survey results
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYRESULT);

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
	 * Initializes the survey result persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyResult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyResult>> listenersList = new ArrayList<ModelListener<SurveyResult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyResult>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyResultImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYRESULT = "SELECT surveyResult FROM SurveyResult surveyResult";
	private static final String _SQL_SELECT_SURVEYRESULT_WHERE = "SELECT surveyResult FROM SurveyResult surveyResult WHERE ";
	private static final String _SQL_COUNT_SURVEYRESULT = "SELECT COUNT(surveyResult) FROM SurveyResult surveyResult";
	private static final String _SQL_COUNT_SURVEYRESULT_WHERE = "SELECT COUNT(surveyResult) FROM SurveyResult surveyResult WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyResult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyResult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyResult exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyResultPersistenceImpl.class);
	private static SurveyResult _nullSurveyResult = new SurveyResultImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyResult> toCacheModel() {
				return _nullSurveyResultCacheModel;
			}
		};

	private static CacheModel<SurveyResult> _nullSurveyResultCacheModel = new CacheModel<SurveyResult>() {
			@Override
			public SurveyResult toEntityModel() {
				return _nullSurveyResult;
			}
		};
}