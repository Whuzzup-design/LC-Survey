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

import com.lc.survey.NoSuchSurveyResponseException;
import com.lc.survey.model.SurveyResponse;
import com.lc.survey.model.impl.SurveyResponseImpl;
import com.lc.survey.model.impl.SurveyResponseModelImpl;

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
 * The persistence implementation for the survey response service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyResponsePersistence
 * @see SurveyResponseUtil
 * @generated
 */
public class SurveyResponsePersistenceImpl extends BasePersistenceImpl<SurveyResponse>
	implements SurveyResponsePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyResponseUtil} to access the survey response persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyResponseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED,
			SurveyResponseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED,
			SurveyResponseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED,
			SurveyResponseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED,
			SurveyResponseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyResponseModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyResponseModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey responses where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey responses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResponse> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SurveyResponse> findBySurveyMainId(long surveyMainId,
		int start, int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
	}

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
	@Override
	public List<SurveyResponse> findBySurveyMainId(long surveyMainId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<SurveyResponse> list = (List<SurveyResponse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResponse surveyResponse : list) {
				if ((surveyMainId != surveyResponse.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYRESPONSE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResponseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyResponse>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResponse>(list);
				}
				else {
					list = (List<SurveyResponse>)QueryUtil.list(q,
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
	 * Returns the first survey response in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey response
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyResponse != null) {
			return surveyResponse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResponseException(msg.toString());
	}

	/**
	 * Returns the first survey response in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey response, or <code>null</code> if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyResponse> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey response in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey response
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyResponse != null) {
			return surveyResponse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResponseException(msg.toString());
	}

	/**
	 * Returns the last survey response in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey response, or <code>null</code> if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyResponse> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public SurveyResponse[] findBySurveyMainId_PrevAndNext(
		long surveyResponseId, long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = findByPrimaryKey(surveyResponseId);

		Session session = null;

		try {
			session = openSession();

			SurveyResponse[] array = new SurveyResponseImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyResponse,
					surveyMainId, orderByComparator, true);

			array[1] = surveyResponse;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyResponse,
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

	protected SurveyResponse getBySurveyMainId_PrevAndNext(Session session,
		SurveyResponse surveyResponse, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESPONSE_WHERE);

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
			query.append(SurveyResponseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResponse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResponse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey responses where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyResponse surveyResponse : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResponse);
		}
	}

	/**
	 * Returns the number of survey responses where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey responses
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

			query.append(_SQL_COUNT_SURVEYRESPONSE_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyResponse.surveyMainId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WRITERID = new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED,
			SurveyResponseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWriterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WRITERID =
		new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED,
			SurveyResponseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWriterId",
			new String[] { Long.class.getName() },
			SurveyResponseModelImpl.WRITERID_COLUMN_BITMASK |
			SurveyResponseModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WRITERID = new FinderPath(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWriterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey responses where writerId = &#63;.
	 *
	 * @param writerId the writer ID
	 * @return the matching survey responses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResponse> findByWriterId(long writerId)
		throws SystemException {
		return findByWriterId(writerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<SurveyResponse> findByWriterId(long writerId, int start, int end)
		throws SystemException {
		return findByWriterId(writerId, start, end, null);
	}

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
	@Override
	public List<SurveyResponse> findByWriterId(long writerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WRITERID;
			finderArgs = new Object[] { writerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WRITERID;
			finderArgs = new Object[] { writerId, start, end, orderByComparator };
		}

		List<SurveyResponse> list = (List<SurveyResponse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyResponse surveyResponse : list) {
				if ((writerId != surveyResponse.getWriterId())) {
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

			query.append(_SQL_SELECT_SURVEYRESPONSE_WHERE);

			query.append(_FINDER_COLUMN_WRITERID_WRITERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyResponseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(writerId);

				if (!pagination) {
					list = (List<SurveyResponse>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResponse>(list);
				}
				else {
					list = (List<SurveyResponse>)QueryUtil.list(q,
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
	 * Returns the first survey response in the ordered set where writerId = &#63;.
	 *
	 * @param writerId the writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey response
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse findByWriterId_First(long writerId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = fetchByWriterId_First(writerId,
				orderByComparator);

		if (surveyResponse != null) {
			return surveyResponse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("writerId=");
		msg.append(writerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResponseException(msg.toString());
	}

	/**
	 * Returns the first survey response in the ordered set where writerId = &#63;.
	 *
	 * @param writerId the writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey response, or <code>null</code> if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse fetchByWriterId_First(long writerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyResponse> list = findByWriterId(writerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey response in the ordered set where writerId = &#63;.
	 *
	 * @param writerId the writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey response
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse findByWriterId_Last(long writerId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = fetchByWriterId_Last(writerId,
				orderByComparator);

		if (surveyResponse != null) {
			return surveyResponse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("writerId=");
		msg.append(writerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyResponseException(msg.toString());
	}

	/**
	 * Returns the last survey response in the ordered set where writerId = &#63;.
	 *
	 * @param writerId the writer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey response, or <code>null</code> if a matching survey response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse fetchByWriterId_Last(long writerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWriterId(writerId);

		if (count == 0) {
			return null;
		}

		List<SurveyResponse> list = findByWriterId(writerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public SurveyResponse[] findByWriterId_PrevAndNext(long surveyResponseId,
		long writerId, OrderByComparator orderByComparator)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = findByPrimaryKey(surveyResponseId);

		Session session = null;

		try {
			session = openSession();

			SurveyResponse[] array = new SurveyResponseImpl[3];

			array[0] = getByWriterId_PrevAndNext(session, surveyResponse,
					writerId, orderByComparator, true);

			array[1] = surveyResponse;

			array[2] = getByWriterId_PrevAndNext(session, surveyResponse,
					writerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyResponse getByWriterId_PrevAndNext(Session session,
		SurveyResponse surveyResponse, long writerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYRESPONSE_WHERE);

		query.append(_FINDER_COLUMN_WRITERID_WRITERID_2);

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
			query.append(SurveyResponseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(writerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyResponse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyResponse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey responses where writerId = &#63; from the database.
	 *
	 * @param writerId the writer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWriterId(long writerId) throws SystemException {
		for (SurveyResponse surveyResponse : findByWriterId(writerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyResponse);
		}
	}

	/**
	 * Returns the number of survey responses where writerId = &#63;.
	 *
	 * @param writerId the writer ID
	 * @return the number of matching survey responses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWriterId(long writerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WRITERID;

		Object[] finderArgs = new Object[] { writerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYRESPONSE_WHERE);

			query.append(_FINDER_COLUMN_WRITERID_WRITERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(writerId);

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

	private static final String _FINDER_COLUMN_WRITERID_WRITERID_2 = "surveyResponse.writerId = ?";

	public SurveyResponsePersistenceImpl() {
		setModelClass(SurveyResponse.class);
	}

	/**
	 * Caches the survey response in the entity cache if it is enabled.
	 *
	 * @param surveyResponse the survey response
	 */
	@Override
	public void cacheResult(SurveyResponse surveyResponse) {
		EntityCacheUtil.putResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseImpl.class, surveyResponse.getPrimaryKey(),
			surveyResponse);

		surveyResponse.resetOriginalValues();
	}

	/**
	 * Caches the survey responses in the entity cache if it is enabled.
	 *
	 * @param surveyResponses the survey responses
	 */
	@Override
	public void cacheResult(List<SurveyResponse> surveyResponses) {
		for (SurveyResponse surveyResponse : surveyResponses) {
			if (EntityCacheUtil.getResult(
						SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
						SurveyResponseImpl.class, surveyResponse.getPrimaryKey()) == null) {
				cacheResult(surveyResponse);
			}
			else {
				surveyResponse.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey responses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyResponseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyResponseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey response.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyResponse surveyResponse) {
		EntityCacheUtil.removeResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseImpl.class, surveyResponse.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyResponse> surveyResponses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyResponse surveyResponse : surveyResponses) {
			EntityCacheUtil.removeResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
				SurveyResponseImpl.class, surveyResponse.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey response with the primary key. Does not add the survey response to the database.
	 *
	 * @param surveyResponseId the primary key for the new survey response
	 * @return the new survey response
	 */
	@Override
	public SurveyResponse create(long surveyResponseId) {
		SurveyResponse surveyResponse = new SurveyResponseImpl();

		surveyResponse.setNew(true);
		surveyResponse.setPrimaryKey(surveyResponseId);

		return surveyResponse;
	}

	/**
	 * Removes the survey response with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyResponseId the primary key of the survey response
	 * @return the survey response that was removed
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse remove(long surveyResponseId)
		throws NoSuchSurveyResponseException, SystemException {
		return remove((Serializable)surveyResponseId);
	}

	/**
	 * Removes the survey response with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey response
	 * @return the survey response that was removed
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse remove(Serializable primaryKey)
		throws NoSuchSurveyResponseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyResponse surveyResponse = (SurveyResponse)session.get(SurveyResponseImpl.class,
					primaryKey);

			if (surveyResponse == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyResponseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyResponse);
		}
		catch (NoSuchSurveyResponseException nsee) {
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
	protected SurveyResponse removeImpl(SurveyResponse surveyResponse)
		throws SystemException {
		surveyResponse = toUnwrappedModel(surveyResponse);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyResponse)) {
				surveyResponse = (SurveyResponse)session.get(SurveyResponseImpl.class,
						surveyResponse.getPrimaryKeyObj());
			}

			if (surveyResponse != null) {
				session.delete(surveyResponse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyResponse != null) {
			clearCache(surveyResponse);
		}

		return surveyResponse;
	}

	@Override
	public SurveyResponse updateImpl(
		com.lc.survey.model.SurveyResponse surveyResponse)
		throws SystemException {
		surveyResponse = toUnwrappedModel(surveyResponse);

		boolean isNew = surveyResponse.isNew();

		SurveyResponseModelImpl surveyResponseModelImpl = (SurveyResponseModelImpl)surveyResponse;

		Session session = null;

		try {
			session = openSession();

			if (surveyResponse.isNew()) {
				session.save(surveyResponse);

				surveyResponse.setNew(false);
			}
			else {
				session.merge(surveyResponse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyResponseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyResponseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResponseModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyResponseModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}

			if ((surveyResponseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WRITERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyResponseModelImpl.getOriginalWriterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WRITERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WRITERID,
					args);

				args = new Object[] { surveyResponseModelImpl.getWriterId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WRITERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WRITERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
			SurveyResponseImpl.class, surveyResponse.getPrimaryKey(),
			surveyResponse);

		return surveyResponse;
	}

	protected SurveyResponse toUnwrappedModel(SurveyResponse surveyResponse) {
		if (surveyResponse instanceof SurveyResponseImpl) {
			return surveyResponse;
		}

		SurveyResponseImpl surveyResponseImpl = new SurveyResponseImpl();

		surveyResponseImpl.setNew(surveyResponse.isNew());
		surveyResponseImpl.setPrimaryKey(surveyResponse.getPrimaryKey());

		surveyResponseImpl.setSurveyResponseId(surveyResponse.getSurveyResponseId());
		surveyResponseImpl.setSurveyMainId(surveyResponse.getSurveyMainId());
		surveyResponseImpl.setWriterId(surveyResponse.getWriterId());
		surveyResponseImpl.setResponse(surveyResponse.getResponse());
		surveyResponseImpl.setCreatorId(surveyResponse.getCreatorId());
		surveyResponseImpl.setCreateDate(surveyResponse.getCreateDate());

		return surveyResponseImpl;
	}

	/**
	 * Returns the survey response with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey response
	 * @return the survey response
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyResponseException, SystemException {
		SurveyResponse surveyResponse = fetchByPrimaryKey(primaryKey);

		if (surveyResponse == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyResponseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyResponse;
	}

	/**
	 * Returns the survey response with the primary key or throws a {@link com.lc.survey.NoSuchSurveyResponseException} if it could not be found.
	 *
	 * @param surveyResponseId the primary key of the survey response
	 * @return the survey response
	 * @throws com.lc.survey.NoSuchSurveyResponseException if a survey response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse findByPrimaryKey(long surveyResponseId)
		throws NoSuchSurveyResponseException, SystemException {
		return findByPrimaryKey((Serializable)surveyResponseId);
	}

	/**
	 * Returns the survey response with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey response
	 * @return the survey response, or <code>null</code> if a survey response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyResponse surveyResponse = (SurveyResponse)EntityCacheUtil.getResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
				SurveyResponseImpl.class, primaryKey);

		if (surveyResponse == _nullSurveyResponse) {
			return null;
		}

		if (surveyResponse == null) {
			Session session = null;

			try {
				session = openSession();

				surveyResponse = (SurveyResponse)session.get(SurveyResponseImpl.class,
						primaryKey);

				if (surveyResponse != null) {
					cacheResult(surveyResponse);
				}
				else {
					EntityCacheUtil.putResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
						SurveyResponseImpl.class, primaryKey,
						_nullSurveyResponse);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyResponseModelImpl.ENTITY_CACHE_ENABLED,
					SurveyResponseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyResponse;
	}

	/**
	 * Returns the survey response with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyResponseId the primary key of the survey response
	 * @return the survey response, or <code>null</code> if a survey response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyResponse fetchByPrimaryKey(long surveyResponseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyResponseId);
	}

	/**
	 * Returns all the survey responses.
	 *
	 * @return the survey responses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyResponse> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<SurveyResponse> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<SurveyResponse> findAll(int start, int end,
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

		List<SurveyResponse> list = (List<SurveyResponse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYRESPONSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYRESPONSE;

				if (pagination) {
					sql = sql.concat(SurveyResponseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyResponse>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyResponse>(list);
				}
				else {
					list = (List<SurveyResponse>)QueryUtil.list(q,
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
	 * Removes all the survey responses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyResponse surveyResponse : findAll()) {
			remove(surveyResponse);
		}
	}

	/**
	 * Returns the number of survey responses.
	 *
	 * @return the number of survey responses
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYRESPONSE);

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
	 * Initializes the survey response persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyResponse")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyResponse>> listenersList = new ArrayList<ModelListener<SurveyResponse>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyResponse>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyResponseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYRESPONSE = "SELECT surveyResponse FROM SurveyResponse surveyResponse";
	private static final String _SQL_SELECT_SURVEYRESPONSE_WHERE = "SELECT surveyResponse FROM SurveyResponse surveyResponse WHERE ";
	private static final String _SQL_COUNT_SURVEYRESPONSE = "SELECT COUNT(surveyResponse) FROM SurveyResponse surveyResponse";
	private static final String _SQL_COUNT_SURVEYRESPONSE_WHERE = "SELECT COUNT(surveyResponse) FROM SurveyResponse surveyResponse WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyResponse.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyResponse exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyResponse exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyResponsePersistenceImpl.class);
	private static SurveyResponse _nullSurveyResponse = new SurveyResponseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyResponse> toCacheModel() {
				return _nullSurveyResponseCacheModel;
			}
		};

	private static CacheModel<SurveyResponse> _nullSurveyResponseCacheModel = new CacheModel<SurveyResponse>() {
			@Override
			public SurveyResponse toEntityModel() {
				return _nullSurveyResponse;
			}
		};
}