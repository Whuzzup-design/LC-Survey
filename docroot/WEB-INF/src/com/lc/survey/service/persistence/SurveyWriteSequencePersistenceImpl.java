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

import com.lc.survey.NoSuchSurveyWriteSequenceException;
import com.lc.survey.model.SurveyWriteSequence;
import com.lc.survey.model.impl.SurveyWriteSequenceImpl;
import com.lc.survey.model.impl.SurveyWriteSequenceModelImpl;

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
 * The persistence implementation for the survey write sequence service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyWriteSequencePersistence
 * @see SurveyWriteSequenceUtil
 * @generated
 */
public class SurveyWriteSequencePersistenceImpl extends BasePersistenceImpl<SurveyWriteSequence>
	implements SurveyWriteSequencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyWriteSequenceUtil} to access the survey write sequence persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyWriteSequenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYWRITERID =
		new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyWriterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID =
		new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyWriterId",
			new String[] { Long.class.getName() },
			SurveyWriteSequenceModelImpl.SURVEYWRITERID_COLUMN_BITMASK |
			SurveyWriteSequenceModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYWRITERID = new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyWriterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey write sequences where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @return the matching survey write sequences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyWriteSequence> findBySurveyWriterId(long surveyWriterId)
		throws SystemException {
		return findBySurveyWriterId(surveyWriterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyWriteSequence> findBySurveyWriterId(long surveyWriterId,
		int start, int end) throws SystemException {
		return findBySurveyWriterId(surveyWriterId, start, end, null);
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
	@Override
	public List<SurveyWriteSequence> findBySurveyWriterId(long surveyWriterId,
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

		List<SurveyWriteSequence> list = (List<SurveyWriteSequence>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyWriteSequence surveyWriteSequence : list) {
				if ((surveyWriterId != surveyWriteSequence.getSurveyWriterId())) {
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

			query.append(_SQL_SELECT_SURVEYWRITESEQUENCE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYWRITERID_SURVEYWRITERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyWriteSequenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyWriterId);

				if (!pagination) {
					list = (List<SurveyWriteSequence>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyWriteSequence>(list);
				}
				else {
					list = (List<SurveyWriteSequence>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first survey write sequence in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey write sequence
	 * @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence findBySurveyWriterId_First(long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		SurveyWriteSequence surveyWriteSequence = fetchBySurveyWriterId_First(surveyWriterId,
				orderByComparator);

		if (surveyWriteSequence != null) {
			return surveyWriteSequence;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyWriteSequenceException(msg.toString());
	}

	/**
	 * Returns the first survey write sequence in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence fetchBySurveyWriterId_First(
		long surveyWriterId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SurveyWriteSequence> list = findBySurveyWriterId(surveyWriterId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyWriteSequence findBySurveyWriterId_Last(long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		SurveyWriteSequence surveyWriteSequence = fetchBySurveyWriterId_Last(surveyWriterId,
				orderByComparator);

		if (surveyWriteSequence != null) {
			return surveyWriteSequence;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyWriterId=");
		msg.append(surveyWriterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyWriteSequenceException(msg.toString());
	}

	/**
	 * Returns the last survey write sequence in the ordered set where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence fetchBySurveyWriterId_Last(long surveyWriterId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyWriterId(surveyWriterId);

		if (count == 0) {
			return null;
		}

		List<SurveyWriteSequence> list = findBySurveyWriterId(surveyWriterId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyWriteSequence[] findBySurveyWriterId_PrevAndNext(
		long surveyWriteSequenceId, long surveyWriterId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		SurveyWriteSequence surveyWriteSequence = findByPrimaryKey(surveyWriteSequenceId);

		Session session = null;

		try {
			session = openSession();

			SurveyWriteSequence[] array = new SurveyWriteSequenceImpl[3];

			array[0] = getBySurveyWriterId_PrevAndNext(session,
					surveyWriteSequence, surveyWriterId, orderByComparator, true);

			array[1] = surveyWriteSequence;

			array[2] = getBySurveyWriterId_PrevAndNext(session,
					surveyWriteSequence, surveyWriterId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyWriteSequence getBySurveyWriterId_PrevAndNext(
		Session session, SurveyWriteSequence surveyWriteSequence,
		long surveyWriterId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYWRITESEQUENCE_WHERE);

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
			query.append(SurveyWriteSequenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyWriterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyWriteSequence);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyWriteSequence> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey write sequences where surveyWriterId = &#63; from the database.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyWriterId(long surveyWriterId)
		throws SystemException {
		for (SurveyWriteSequence surveyWriteSequence : findBySurveyWriterId(
				surveyWriterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyWriteSequence);
		}
	}

	/**
	 * Returns the number of survey write sequences where surveyWriterId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @return the number of matching survey write sequences
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

			query.append(_SQL_COUNT_SURVEYWRITESEQUENCE_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYWRITERID_SURVEYWRITERID_2 = "surveyWriteSequence.surveyWriterId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_S_P = new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByS_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			SurveyWriteSequenceModelImpl.SURVEYWRITERID_COLUMN_BITMASK |
			SurveyWriteSequenceModelImpl.PAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_P = new FinderPath(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or throws a {@link com.lc.survey.NoSuchSurveyWriteSequenceException} if it could not be found.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param pageId the page ID
	 * @return the matching survey write sequence
	 * @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a matching survey write sequence could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence findByS_P(long surveyWriterId, long pageId)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		SurveyWriteSequence surveyWriteSequence = fetchByS_P(surveyWriterId,
				pageId);

		if (surveyWriteSequence == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("surveyWriterId=");
			msg.append(surveyWriterId);

			msg.append(", pageId=");
			msg.append(pageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSurveyWriteSequenceException(msg.toString());
		}

		return surveyWriteSequence;
	}

	/**
	 * Returns the survey write sequence where surveyWriterId = &#63; and pageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param pageId the page ID
	 * @return the matching survey write sequence, or <code>null</code> if a matching survey write sequence could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence fetchByS_P(long surveyWriterId, long pageId)
		throws SystemException {
		return fetchByS_P(surveyWriterId, pageId, true);
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
	@Override
	public SurveyWriteSequence fetchByS_P(long surveyWriterId, long pageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { surveyWriterId, pageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_S_P,
					finderArgs, this);
		}

		if (result instanceof SurveyWriteSequence) {
			SurveyWriteSequence surveyWriteSequence = (SurveyWriteSequence)result;

			if ((surveyWriterId != surveyWriteSequence.getSurveyWriterId()) ||
					(pageId != surveyWriteSequence.getPageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SURVEYWRITESEQUENCE_WHERE);

			query.append(_FINDER_COLUMN_S_P_SURVEYWRITERID_2);

			query.append(_FINDER_COLUMN_S_P_PAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyWriterId);

				qPos.add(pageId);

				List<SurveyWriteSequence> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_P,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SurveyWriteSequencePersistenceImpl.fetchByS_P(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SurveyWriteSequence surveyWriteSequence = list.get(0);

					result = surveyWriteSequence;

					cacheResult(surveyWriteSequence);

					if ((surveyWriteSequence.getSurveyWriterId() != surveyWriterId) ||
							(surveyWriteSequence.getPageId() != pageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_P,
							finderArgs, surveyWriteSequence);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_P,
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
			return (SurveyWriteSequence)result;
		}
	}

	/**
	 * Removes the survey write sequence where surveyWriterId = &#63; and pageId = &#63; from the database.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param pageId the page ID
	 * @return the survey write sequence that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence removeByS_P(long surveyWriterId, long pageId)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		SurveyWriteSequence surveyWriteSequence = findByS_P(surveyWriterId,
				pageId);

		return remove(surveyWriteSequence);
	}

	/**
	 * Returns the number of survey write sequences where surveyWriterId = &#63; and pageId = &#63;.
	 *
	 * @param surveyWriterId the survey writer ID
	 * @param pageId the page ID
	 * @return the number of matching survey write sequences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_P(long surveyWriterId, long pageId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_P;

		Object[] finderArgs = new Object[] { surveyWriterId, pageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYWRITESEQUENCE_WHERE);

			query.append(_FINDER_COLUMN_S_P_SURVEYWRITERID_2);

			query.append(_FINDER_COLUMN_S_P_PAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyWriterId);

				qPos.add(pageId);

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

	private static final String _FINDER_COLUMN_S_P_SURVEYWRITERID_2 = "surveyWriteSequence.surveyWriterId = ? AND ";
	private static final String _FINDER_COLUMN_S_P_PAGEID_2 = "surveyWriteSequence.pageId = ?";

	public SurveyWriteSequencePersistenceImpl() {
		setModelClass(SurveyWriteSequence.class);
	}

	/**
	 * Caches the survey write sequence in the entity cache if it is enabled.
	 *
	 * @param surveyWriteSequence the survey write sequence
	 */
	@Override
	public void cacheResult(SurveyWriteSequence surveyWriteSequence) {
		EntityCacheUtil.putResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class, surveyWriteSequence.getPrimaryKey(),
			surveyWriteSequence);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_P,
			new Object[] {
				surveyWriteSequence.getSurveyWriterId(),
				surveyWriteSequence.getPageId()
			}, surveyWriteSequence);

		surveyWriteSequence.resetOriginalValues();
	}

	/**
	 * Caches the survey write sequences in the entity cache if it is enabled.
	 *
	 * @param surveyWriteSequences the survey write sequences
	 */
	@Override
	public void cacheResult(List<SurveyWriteSequence> surveyWriteSequences) {
		for (SurveyWriteSequence surveyWriteSequence : surveyWriteSequences) {
			if (EntityCacheUtil.getResult(
						SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
						SurveyWriteSequenceImpl.class,
						surveyWriteSequence.getPrimaryKey()) == null) {
				cacheResult(surveyWriteSequence);
			}
			else {
				surveyWriteSequence.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey write sequences.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyWriteSequenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyWriteSequenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey write sequence.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyWriteSequence surveyWriteSequence) {
		EntityCacheUtil.removeResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class, surveyWriteSequence.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(surveyWriteSequence);
	}

	@Override
	public void clearCache(List<SurveyWriteSequence> surveyWriteSequences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyWriteSequence surveyWriteSequence : surveyWriteSequences) {
			EntityCacheUtil.removeResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
				SurveyWriteSequenceImpl.class,
				surveyWriteSequence.getPrimaryKey());

			clearUniqueFindersCache(surveyWriteSequence);
		}
	}

	protected void cacheUniqueFindersCache(
		SurveyWriteSequence surveyWriteSequence) {
		if (surveyWriteSequence.isNew()) {
			Object[] args = new Object[] {
					surveyWriteSequence.getSurveyWriterId(),
					surveyWriteSequence.getPageId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_P, args,
				surveyWriteSequence);
		}
		else {
			SurveyWriteSequenceModelImpl surveyWriteSequenceModelImpl = (SurveyWriteSequenceModelImpl)surveyWriteSequence;

			if ((surveyWriteSequenceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_S_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyWriteSequence.getSurveyWriterId(),
						surveyWriteSequence.getPageId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_P, args,
					surveyWriteSequence);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SurveyWriteSequence surveyWriteSequence) {
		SurveyWriteSequenceModelImpl surveyWriteSequenceModelImpl = (SurveyWriteSequenceModelImpl)surveyWriteSequence;

		Object[] args = new Object[] {
				surveyWriteSequence.getSurveyWriterId(),
				surveyWriteSequence.getPageId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_P, args);

		if ((surveyWriteSequenceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_S_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					surveyWriteSequenceModelImpl.getOriginalSurveyWriterId(),
					surveyWriteSequenceModelImpl.getOriginalPageId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_P, args);
		}
	}

	/**
	 * Creates a new survey write sequence with the primary key. Does not add the survey write sequence to the database.
	 *
	 * @param surveyWriteSequenceId the primary key for the new survey write sequence
	 * @return the new survey write sequence
	 */
	@Override
	public SurveyWriteSequence create(long surveyWriteSequenceId) {
		SurveyWriteSequence surveyWriteSequence = new SurveyWriteSequenceImpl();

		surveyWriteSequence.setNew(true);
		surveyWriteSequence.setPrimaryKey(surveyWriteSequenceId);

		return surveyWriteSequence;
	}

	/**
	 * Removes the survey write sequence with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyWriteSequenceId the primary key of the survey write sequence
	 * @return the survey write sequence that was removed
	 * @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence remove(long surveyWriteSequenceId)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		return remove((Serializable)surveyWriteSequenceId);
	}

	/**
	 * Removes the survey write sequence with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey write sequence
	 * @return the survey write sequence that was removed
	 * @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence remove(Serializable primaryKey)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyWriteSequence surveyWriteSequence = (SurveyWriteSequence)session.get(SurveyWriteSequenceImpl.class,
					primaryKey);

			if (surveyWriteSequence == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyWriteSequenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyWriteSequence);
		}
		catch (NoSuchSurveyWriteSequenceException nsee) {
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
	protected SurveyWriteSequence removeImpl(
		SurveyWriteSequence surveyWriteSequence) throws SystemException {
		surveyWriteSequence = toUnwrappedModel(surveyWriteSequence);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyWriteSequence)) {
				surveyWriteSequence = (SurveyWriteSequence)session.get(SurveyWriteSequenceImpl.class,
						surveyWriteSequence.getPrimaryKeyObj());
			}

			if (surveyWriteSequence != null) {
				session.delete(surveyWriteSequence);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyWriteSequence != null) {
			clearCache(surveyWriteSequence);
		}

		return surveyWriteSequence;
	}

	@Override
	public SurveyWriteSequence updateImpl(
		com.lc.survey.model.SurveyWriteSequence surveyWriteSequence)
		throws SystemException {
		surveyWriteSequence = toUnwrappedModel(surveyWriteSequence);

		boolean isNew = surveyWriteSequence.isNew();

		SurveyWriteSequenceModelImpl surveyWriteSequenceModelImpl = (SurveyWriteSequenceModelImpl)surveyWriteSequence;

		Session session = null;

		try {
			session = openSession();

			if (surveyWriteSequence.isNew()) {
				session.save(surveyWriteSequence);

				surveyWriteSequence.setNew(false);
			}
			else {
				session.merge(surveyWriteSequence);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyWriteSequenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyWriteSequenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyWriteSequenceModelImpl.getOriginalSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYWRITERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID,
					args);

				args = new Object[] {
						surveyWriteSequenceModelImpl.getSurveyWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYWRITERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYWRITERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriteSequenceImpl.class, surveyWriteSequence.getPrimaryKey(),
			surveyWriteSequence);

		clearUniqueFindersCache(surveyWriteSequence);
		cacheUniqueFindersCache(surveyWriteSequence);

		return surveyWriteSequence;
	}

	protected SurveyWriteSequence toUnwrappedModel(
		SurveyWriteSequence surveyWriteSequence) {
		if (surveyWriteSequence instanceof SurveyWriteSequenceImpl) {
			return surveyWriteSequence;
		}

		SurveyWriteSequenceImpl surveyWriteSequenceImpl = new SurveyWriteSequenceImpl();

		surveyWriteSequenceImpl.setNew(surveyWriteSequence.isNew());
		surveyWriteSequenceImpl.setPrimaryKey(surveyWriteSequence.getPrimaryKey());

		surveyWriteSequenceImpl.setSurveyWriteSequenceId(surveyWriteSequence.getSurveyWriteSequenceId());
		surveyWriteSequenceImpl.setSurveyWriterId(surveyWriteSequence.getSurveyWriterId());
		surveyWriteSequenceImpl.setPageId(surveyWriteSequence.getPageId());
		surveyWriteSequenceImpl.setPrePageId(surveyWriteSequence.getPrePageId());
		surveyWriteSequenceImpl.setIsDirect(surveyWriteSequence.getIsDirect());
		surveyWriteSequenceImpl.setCreatorId(surveyWriteSequence.getCreatorId());
		surveyWriteSequenceImpl.setCreateDate(surveyWriteSequence.getCreateDate());

		return surveyWriteSequenceImpl;
	}

	/**
	 * Returns the survey write sequence with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey write sequence
	 * @return the survey write sequence
	 * @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		SurveyWriteSequence surveyWriteSequence = fetchByPrimaryKey(primaryKey);

		if (surveyWriteSequence == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyWriteSequenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyWriteSequence;
	}

	/**
	 * Returns the survey write sequence with the primary key or throws a {@link com.lc.survey.NoSuchSurveyWriteSequenceException} if it could not be found.
	 *
	 * @param surveyWriteSequenceId the primary key of the survey write sequence
	 * @return the survey write sequence
	 * @throws com.lc.survey.NoSuchSurveyWriteSequenceException if a survey write sequence with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence findByPrimaryKey(long surveyWriteSequenceId)
		throws NoSuchSurveyWriteSequenceException, SystemException {
		return findByPrimaryKey((Serializable)surveyWriteSequenceId);
	}

	/**
	 * Returns the survey write sequence with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey write sequence
	 * @return the survey write sequence, or <code>null</code> if a survey write sequence with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyWriteSequence surveyWriteSequence = (SurveyWriteSequence)EntityCacheUtil.getResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
				SurveyWriteSequenceImpl.class, primaryKey);

		if (surveyWriteSequence == _nullSurveyWriteSequence) {
			return null;
		}

		if (surveyWriteSequence == null) {
			Session session = null;

			try {
				session = openSession();

				surveyWriteSequence = (SurveyWriteSequence)session.get(SurveyWriteSequenceImpl.class,
						primaryKey);

				if (surveyWriteSequence != null) {
					cacheResult(surveyWriteSequence);
				}
				else {
					EntityCacheUtil.putResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
						SurveyWriteSequenceImpl.class, primaryKey,
						_nullSurveyWriteSequence);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyWriteSequenceModelImpl.ENTITY_CACHE_ENABLED,
					SurveyWriteSequenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyWriteSequence;
	}

	/**
	 * Returns the survey write sequence with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyWriteSequenceId the primary key of the survey write sequence
	 * @return the survey write sequence, or <code>null</code> if a survey write sequence with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriteSequence fetchByPrimaryKey(long surveyWriteSequenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyWriteSequenceId);
	}

	/**
	 * Returns all the survey write sequences.
	 *
	 * @return the survey write sequences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyWriteSequence> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyWriteSequence> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SurveyWriteSequence> findAll(int start, int end,
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

		List<SurveyWriteSequence> list = (List<SurveyWriteSequence>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYWRITESEQUENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYWRITESEQUENCE;

				if (pagination) {
					sql = sql.concat(SurveyWriteSequenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyWriteSequence>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyWriteSequence>(list);
				}
				else {
					list = (List<SurveyWriteSequence>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the survey write sequences from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyWriteSequence surveyWriteSequence : findAll()) {
			remove(surveyWriteSequence);
		}
	}

	/**
	 * Returns the number of survey write sequences.
	 *
	 * @return the number of survey write sequences
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYWRITESEQUENCE);

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
	 * Initializes the survey write sequence persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyWriteSequence")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyWriteSequence>> listenersList = new ArrayList<ModelListener<SurveyWriteSequence>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyWriteSequence>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyWriteSequenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYWRITESEQUENCE = "SELECT surveyWriteSequence FROM SurveyWriteSequence surveyWriteSequence";
	private static final String _SQL_SELECT_SURVEYWRITESEQUENCE_WHERE = "SELECT surveyWriteSequence FROM SurveyWriteSequence surveyWriteSequence WHERE ";
	private static final String _SQL_COUNT_SURVEYWRITESEQUENCE = "SELECT COUNT(surveyWriteSequence) FROM SurveyWriteSequence surveyWriteSequence";
	private static final String _SQL_COUNT_SURVEYWRITESEQUENCE_WHERE = "SELECT COUNT(surveyWriteSequence) FROM SurveyWriteSequence surveyWriteSequence WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyWriteSequence.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyWriteSequence exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyWriteSequence exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyWriteSequencePersistenceImpl.class);
	private static SurveyWriteSequence _nullSurveyWriteSequence = new SurveyWriteSequenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyWriteSequence> toCacheModel() {
				return _nullSurveyWriteSequenceCacheModel;
			}
		};

	private static CacheModel<SurveyWriteSequence> _nullSurveyWriteSequenceCacheModel =
		new CacheModel<SurveyWriteSequence>() {
			@Override
			public SurveyWriteSequence toEntityModel() {
				return _nullSurveyWriteSequence;
			}
		};
}