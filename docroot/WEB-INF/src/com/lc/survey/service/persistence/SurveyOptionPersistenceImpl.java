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

import com.lc.survey.NoSuchSurveyOptionException;
import com.lc.survey.model.SurveyOption;
import com.lc.survey.model.impl.SurveyOptionImpl;
import com.lc.survey.model.impl.SurveyOptionModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the survey option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyOptionPersistence
 * @see SurveyOptionUtil
 * @generated
 */
public class SurveyOptionPersistenceImpl extends BasePersistenceImpl<SurveyOption>
	implements SurveyOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyOptionUtil} to access the survey option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYQUESTIONID =
		new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyQuestionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYQUESTIONID =
		new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySurveyQuestionId", new String[] { Long.class.getName() },
			SurveyOptionModelImpl.SURVEYQUESTIONID_COLUMN_BITMASK |
			SurveyOptionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYQUESTIONID = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySurveyQuestionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the survey options where surveyQuestionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @return the matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyOption> findBySurveyQuestionId(long surveyQuestionId)
		throws SystemException {
		return findBySurveyQuestionId(surveyQuestionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyOption> findBySurveyQuestionId(long surveyQuestionId,
		int start, int end) throws SystemException {
		return findBySurveyQuestionId(surveyQuestionId, start, end, null);
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
	@Override
	public List<SurveyOption> findBySurveyQuestionId(long surveyQuestionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYQUESTIONID;
			finderArgs = new Object[] { surveyQuestionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYQUESTIONID;
			finderArgs = new Object[] {
					surveyQuestionId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyOption> list = (List<SurveyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyOption surveyOption : list) {
				if ((surveyQuestionId != surveyOption.getSurveyQuestionId())) {
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

			query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYQUESTIONID_SURVEYQUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				if (!pagination) {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyOption>(list);
				}
				else {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey option in the ordered set where surveyQuestionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption findBySurveyQuestionId_First(long surveyQuestionId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchBySurveyQuestionId_First(surveyQuestionId,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
	}

	/**
	 * Returns the first survey option in the ordered set where surveyQuestionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchBySurveyQuestionId_First(long surveyQuestionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyOption> list = findBySurveyQuestionId(surveyQuestionId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption findBySurveyQuestionId_Last(long surveyQuestionId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchBySurveyQuestionId_Last(surveyQuestionId,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
	}

	/**
	 * Returns the last survey option in the ordered set where surveyQuestionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchBySurveyQuestionId_Last(long surveyQuestionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyQuestionId(surveyQuestionId);

		if (count == 0) {
			return null;
		}

		List<SurveyOption> list = findBySurveyQuestionId(surveyQuestionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption[] findBySurveyQuestionId_PrevAndNext(
		long surveyOptionId, long surveyQuestionId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = findByPrimaryKey(surveyOptionId);

		Session session = null;

		try {
			session = openSession();

			SurveyOption[] array = new SurveyOptionImpl[3];

			array[0] = getBySurveyQuestionId_PrevAndNext(session, surveyOption,
					surveyQuestionId, orderByComparator, true);

			array[1] = surveyOption;

			array[2] = getBySurveyQuestionId_PrevAndNext(session, surveyOption,
					surveyQuestionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyOption getBySurveyQuestionId_PrevAndNext(Session session,
		SurveyOption surveyOption, long surveyQuestionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

		query.append(_FINDER_COLUMN_SURVEYQUESTIONID_SURVEYQUESTIONID_2);

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
			query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyQuestionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyOption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey options where surveyQuestionId = &#63; from the database.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyQuestionId(long surveyQuestionId)
		throws SystemException {
		for (SurveyOption surveyOption : findBySurveyQuestionId(
				surveyQuestionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyOption);
		}
	}

	/**
	 * Returns the number of survey options where surveyQuestionId = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @return the number of matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyQuestionId(long surveyQuestionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYQUESTIONID;

		Object[] finderArgs = new Object[] { surveyQuestionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYQUESTIONID_SURVEYQUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

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

	private static final String _FINDER_COLUMN_SURVEYQUESTIONID_SURVEYQUESTIONID_2 =
		"surveyOption.surveyQuestionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYPAGEID =
		new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyPageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID =
		new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyPageId",
			new String[] { Long.class.getName() },
			SurveyOptionModelImpl.SURVEYPAGEID_COLUMN_BITMASK |
			SurveyOptionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYPAGEID = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyPageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey options where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @return the matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyOption> findBySurveyPageId(long surveyPageId)
		throws SystemException {
		return findBySurveyPageId(surveyPageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyOption> findBySurveyPageId(long surveyPageId, int start,
		int end) throws SystemException {
		return findBySurveyPageId(surveyPageId, start, end, null);
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
	@Override
	public List<SurveyOption> findBySurveyPageId(long surveyPageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID;
			finderArgs = new Object[] { surveyPageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYPAGEID;
			finderArgs = new Object[] {
					surveyPageId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyOption> list = (List<SurveyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyOption surveyOption : list) {
				if ((surveyPageId != surveyOption.getSurveyPageId())) {
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

			query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYPAGEID_SURVEYPAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

				if (!pagination) {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyOption>(list);
				}
				else {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey option in the ordered set where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption findBySurveyPageId_First(long surveyPageId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchBySurveyPageId_First(surveyPageId,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
	}

	/**
	 * Returns the first survey option in the ordered set where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchBySurveyPageId_First(long surveyPageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyOption> list = findBySurveyPageId(surveyPageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption findBySurveyPageId_Last(long surveyPageId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchBySurveyPageId_Last(surveyPageId,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
	}

	/**
	 * Returns the last survey option in the ordered set where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchBySurveyPageId_Last(long surveyPageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyPageId(surveyPageId);

		if (count == 0) {
			return null;
		}

		List<SurveyOption> list = findBySurveyPageId(surveyPageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption[] findBySurveyPageId_PrevAndNext(long surveyOptionId,
		long surveyPageId, OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = findByPrimaryKey(surveyOptionId);

		Session session = null;

		try {
			session = openSession();

			SurveyOption[] array = new SurveyOptionImpl[3];

			array[0] = getBySurveyPageId_PrevAndNext(session, surveyOption,
					surveyPageId, orderByComparator, true);

			array[1] = surveyOption;

			array[2] = getBySurveyPageId_PrevAndNext(session, surveyOption,
					surveyPageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyOption getBySurveyPageId_PrevAndNext(Session session,
		SurveyOption surveyOption, long surveyPageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

		query.append(_FINDER_COLUMN_SURVEYPAGEID_SURVEYPAGEID_2);

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
			query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyPageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyOption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey options where surveyPageId = &#63; from the database.
	 *
	 * @param surveyPageId the survey page ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyPageId(long surveyPageId)
		throws SystemException {
		for (SurveyOption surveyOption : findBySurveyPageId(surveyPageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyOption);
		}
	}

	/**
	 * Returns the number of survey options where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @return the number of matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyPageId(long surveyPageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYPAGEID;

		Object[] finderArgs = new Object[] { surveyPageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYPAGEID_SURVEYPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

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

	private static final String _FINDER_COLUMN_SURVEYPAGEID_SURVEYPAGEID_2 = "surveyOption.surveyPageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyOptionModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyOptionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey options where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyOption> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyOption> findBySurveyMainId(long surveyMainId, int start,
		int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
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
	@Override
	public List<SurveyOption> findBySurveyMainId(long surveyMainId, int start,
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

		List<SurveyOption> list = (List<SurveyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyOption surveyOption : list) {
				if ((surveyMainId != surveyOption.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyOption>(list);
				}
				else {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey option in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
	}

	/**
	 * Returns the first survey option in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option, or <code>null</code> if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyOption> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
	}

	/**
	 * Returns the last survey option in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey option, or <code>null</code> if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyOption> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption[] findBySurveyMainId_PrevAndNext(long surveyOptionId,
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = findByPrimaryKey(surveyOptionId);

		Session session = null;

		try {
			session = openSession();

			SurveyOption[] array = new SurveyOptionImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyOption,
					surveyMainId, orderByComparator, true);

			array[1] = surveyOption;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyOption,
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

	protected SurveyOption getBySurveyMainId_PrevAndNext(Session session,
		SurveyOption surveyOption, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

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
			query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyOption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey options where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyOption surveyOption : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyOption);
		}
	}

	/**
	 * Returns the number of survey options where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey options
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

			query.append(_SQL_COUNT_SURVEYOPTION_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyOption.surveyMainId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_Q_I = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQ_I",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_I = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, SurveyOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQ_I",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SurveyOptionModelImpl.SURVEYQUESTIONID_COLUMN_BITMASK |
			SurveyOptionModelImpl.ISANS_COLUMN_BITMASK |
			SurveyOptionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_Q_I = new FinderPath(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQ_I",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the survey options where surveyQuestionId = &#63; and isAns = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param isAns the is ans
	 * @return the matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyOption> findByQ_I(long surveyQuestionId, Boolean isAns)
		throws SystemException {
		return findByQ_I(surveyQuestionId, isAns, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyOption> findByQ_I(long surveyQuestionId, Boolean isAns,
		int start, int end) throws SystemException {
		return findByQ_I(surveyQuestionId, isAns, start, end, null);
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
	@Override
	public List<SurveyOption> findByQ_I(long surveyQuestionId, Boolean isAns,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_I;
			finderArgs = new Object[] { surveyQuestionId, isAns };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_Q_I;
			finderArgs = new Object[] {
					surveyQuestionId, isAns,
					
					start, end, orderByComparator
				};
		}

		List<SurveyOption> list = (List<SurveyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyOption surveyOption : list) {
				if ((surveyQuestionId != surveyOption.getSurveyQuestionId()) ||
						!Validator.equals(isAns, surveyOption.getIsAns())) {
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

			query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_Q_I_SURVEYQUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_I_ISANS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				qPos.add(isAns.booleanValue());

				if (!pagination) {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyOption>(list);
				}
				else {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey option in the ordered set where surveyQuestionId = &#63; and isAns = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param isAns the is ans
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey option
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a matching survey option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption findByQ_I_First(long surveyQuestionId, Boolean isAns,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchByQ_I_First(surveyQuestionId, isAns,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(", isAns=");
		msg.append(isAns);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
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
	@Override
	public SurveyOption fetchByQ_I_First(long surveyQuestionId, Boolean isAns,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyOption> list = findByQ_I(surveyQuestionId, isAns, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption findByQ_I_Last(long surveyQuestionId, Boolean isAns,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchByQ_I_Last(surveyQuestionId, isAns,
				orderByComparator);

		if (surveyOption != null) {
			return surveyOption;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyQuestionId=");
		msg.append(surveyQuestionId);

		msg.append(", isAns=");
		msg.append(isAns);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyOptionException(msg.toString());
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
	@Override
	public SurveyOption fetchByQ_I_Last(long surveyQuestionId, Boolean isAns,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQ_I(surveyQuestionId, isAns);

		if (count == 0) {
			return null;
		}

		List<SurveyOption> list = findByQ_I(surveyQuestionId, isAns, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyOption[] findByQ_I_PrevAndNext(long surveyOptionId,
		long surveyQuestionId, Boolean isAns,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = findByPrimaryKey(surveyOptionId);

		Session session = null;

		try {
			session = openSession();

			SurveyOption[] array = new SurveyOptionImpl[3];

			array[0] = getByQ_I_PrevAndNext(session, surveyOption,
					surveyQuestionId, isAns, orderByComparator, true);

			array[1] = surveyOption;

			array[2] = getByQ_I_PrevAndNext(session, surveyOption,
					surveyQuestionId, isAns, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyOption getByQ_I_PrevAndNext(Session session,
		SurveyOption surveyOption, long surveyQuestionId, Boolean isAns,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYOPTION_WHERE);

		query.append(_FINDER_COLUMN_Q_I_SURVEYQUESTIONID_2);

		query.append(_FINDER_COLUMN_Q_I_ISANS_2);

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
			query.append(SurveyOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyQuestionId);

		qPos.add(isAns.booleanValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyOption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey options where surveyQuestionId = &#63; and isAns = &#63; from the database.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param isAns the is ans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQ_I(long surveyQuestionId, Boolean isAns)
		throws SystemException {
		for (SurveyOption surveyOption : findByQ_I(surveyQuestionId, isAns,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyOption);
		}
	}

	/**
	 * Returns the number of survey options where surveyQuestionId = &#63; and isAns = &#63;.
	 *
	 * @param surveyQuestionId the survey question ID
	 * @param isAns the is ans
	 * @return the number of matching survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQ_I(long surveyQuestionId, Boolean isAns)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_Q_I;

		Object[] finderArgs = new Object[] { surveyQuestionId, isAns };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYOPTION_WHERE);

			query.append(_FINDER_COLUMN_Q_I_SURVEYQUESTIONID_2);

			query.append(_FINDER_COLUMN_Q_I_ISANS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyQuestionId);

				qPos.add(isAns.booleanValue());

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

	private static final String _FINDER_COLUMN_Q_I_SURVEYQUESTIONID_2 = "surveyOption.surveyQuestionId = ? AND ";
	private static final String _FINDER_COLUMN_Q_I_ISANS_2 = "surveyOption.isAns = ?";

	public SurveyOptionPersistenceImpl() {
		setModelClass(SurveyOption.class);
	}

	/**
	 * Caches the survey option in the entity cache if it is enabled.
	 *
	 * @param surveyOption the survey option
	 */
	@Override
	public void cacheResult(SurveyOption surveyOption) {
		EntityCacheUtil.putResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionImpl.class, surveyOption.getPrimaryKey(), surveyOption);

		surveyOption.resetOriginalValues();
	}

	/**
	 * Caches the survey options in the entity cache if it is enabled.
	 *
	 * @param surveyOptions the survey options
	 */
	@Override
	public void cacheResult(List<SurveyOption> surveyOptions) {
		for (SurveyOption surveyOption : surveyOptions) {
			if (EntityCacheUtil.getResult(
						SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
						SurveyOptionImpl.class, surveyOption.getPrimaryKey()) == null) {
				cacheResult(surveyOption);
			}
			else {
				surveyOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyOption surveyOption) {
		EntityCacheUtil.removeResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionImpl.class, surveyOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyOption> surveyOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyOption surveyOption : surveyOptions) {
			EntityCacheUtil.removeResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
				SurveyOptionImpl.class, surveyOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey option with the primary key. Does not add the survey option to the database.
	 *
	 * @param surveyOptionId the primary key for the new survey option
	 * @return the new survey option
	 */
	@Override
	public SurveyOption create(long surveyOptionId) {
		SurveyOption surveyOption = new SurveyOptionImpl();

		surveyOption.setNew(true);
		surveyOption.setPrimaryKey(surveyOptionId);

		return surveyOption;
	}

	/**
	 * Removes the survey option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyOptionId the primary key of the survey option
	 * @return the survey option that was removed
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption remove(long surveyOptionId)
		throws NoSuchSurveyOptionException, SystemException {
		return remove((Serializable)surveyOptionId);
	}

	/**
	 * Removes the survey option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey option
	 * @return the survey option that was removed
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption remove(Serializable primaryKey)
		throws NoSuchSurveyOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyOption surveyOption = (SurveyOption)session.get(SurveyOptionImpl.class,
					primaryKey);

			if (surveyOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyOption);
		}
		catch (NoSuchSurveyOptionException nsee) {
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
	protected SurveyOption removeImpl(SurveyOption surveyOption)
		throws SystemException {
		surveyOption = toUnwrappedModel(surveyOption);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyOption)) {
				surveyOption = (SurveyOption)session.get(SurveyOptionImpl.class,
						surveyOption.getPrimaryKeyObj());
			}

			if (surveyOption != null) {
				session.delete(surveyOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyOption != null) {
			clearCache(surveyOption);
		}

		return surveyOption;
	}

	@Override
	public SurveyOption updateImpl(
		com.lc.survey.model.SurveyOption surveyOption)
		throws SystemException {
		surveyOption = toUnwrappedModel(surveyOption);

		boolean isNew = surveyOption.isNew();

		SurveyOptionModelImpl surveyOptionModelImpl = (SurveyOptionModelImpl)surveyOption;

		Session session = null;

		try {
			session = openSession();

			if (surveyOption.isNew()) {
				session.save(surveyOption);

				surveyOption.setNew(false);
			}
			else {
				session.merge(surveyOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyOptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYQUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyOptionModelImpl.getOriginalSurveyQuestionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYQUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYQUESTIONID,
					args);

				args = new Object[] { surveyOptionModelImpl.getSurveyQuestionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYQUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYQUESTIONID,
					args);
			}

			if ((surveyOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyOptionModelImpl.getOriginalSurveyPageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYPAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID,
					args);

				args = new Object[] { surveyOptionModelImpl.getSurveyPageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYPAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID,
					args);
			}

			if ((surveyOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyOptionModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyOptionModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}

			if ((surveyOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_I.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyOptionModelImpl.getOriginalSurveyQuestionId(),
						surveyOptionModelImpl.getOriginalIsAns()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_Q_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_I,
					args);

				args = new Object[] {
						surveyOptionModelImpl.getSurveyQuestionId(),
						surveyOptionModelImpl.getIsAns()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_Q_I, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_Q_I,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyOptionImpl.class, surveyOption.getPrimaryKey(), surveyOption);

		return surveyOption;
	}

	protected SurveyOption toUnwrappedModel(SurveyOption surveyOption) {
		if (surveyOption instanceof SurveyOptionImpl) {
			return surveyOption;
		}

		SurveyOptionImpl surveyOptionImpl = new SurveyOptionImpl();

		surveyOptionImpl.setNew(surveyOption.isNew());
		surveyOptionImpl.setPrimaryKey(surveyOption.getPrimaryKey());

		surveyOptionImpl.setSurveyOptionId(surveyOption.getSurveyOptionId());
		surveyOptionImpl.setSurveyMainId(surveyOption.getSurveyMainId());
		surveyOptionImpl.setSurveyPageId(surveyOption.getSurveyPageId());
		surveyOptionImpl.setSurveyQuestionId(surveyOption.getSurveyQuestionId());
		surveyOptionImpl.setNo(surveyOption.getNo());
		surveyOptionImpl.setOption(surveyOption.getOption());
		surveyOptionImpl.setIsAns(surveyOption.getIsAns());
		surveyOptionImpl.setPageDirectId(surveyOption.getPageDirectId());
		surveyOptionImpl.setUploadFileId(surveyOption.getUploadFileId());
		surveyOptionImpl.setCreatorId(surveyOption.getCreatorId());
		surveyOptionImpl.setModifierId(surveyOption.getModifierId());
		surveyOptionImpl.setCreateDate(surveyOption.getCreateDate());
		surveyOptionImpl.setModifiedDate(surveyOption.getModifiedDate());

		return surveyOptionImpl;
	}

	/**
	 * Returns the survey option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey option
	 * @return the survey option
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyOptionException, SystemException {
		SurveyOption surveyOption = fetchByPrimaryKey(primaryKey);

		if (surveyOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyOption;
	}

	/**
	 * Returns the survey option with the primary key or throws a {@link com.lc.survey.NoSuchSurveyOptionException} if it could not be found.
	 *
	 * @param surveyOptionId the primary key of the survey option
	 * @return the survey option
	 * @throws com.lc.survey.NoSuchSurveyOptionException if a survey option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption findByPrimaryKey(long surveyOptionId)
		throws NoSuchSurveyOptionException, SystemException {
		return findByPrimaryKey((Serializable)surveyOptionId);
	}

	/**
	 * Returns the survey option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey option
	 * @return the survey option, or <code>null</code> if a survey option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyOption surveyOption = (SurveyOption)EntityCacheUtil.getResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
				SurveyOptionImpl.class, primaryKey);

		if (surveyOption == _nullSurveyOption) {
			return null;
		}

		if (surveyOption == null) {
			Session session = null;

			try {
				session = openSession();

				surveyOption = (SurveyOption)session.get(SurveyOptionImpl.class,
						primaryKey);

				if (surveyOption != null) {
					cacheResult(surveyOption);
				}
				else {
					EntityCacheUtil.putResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
						SurveyOptionImpl.class, primaryKey, _nullSurveyOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyOptionModelImpl.ENTITY_CACHE_ENABLED,
					SurveyOptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyOption;
	}

	/**
	 * Returns the survey option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyOptionId the primary key of the survey option
	 * @return the survey option, or <code>null</code> if a survey option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyOption fetchByPrimaryKey(long surveyOptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyOptionId);
	}

	/**
	 * Returns all the survey options.
	 *
	 * @return the survey options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SurveyOption> findAll(int start, int end,
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

		List<SurveyOption> list = (List<SurveyOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYOPTION;

				if (pagination) {
					sql = sql.concat(SurveyOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyOption>(list);
				}
				else {
					list = (List<SurveyOption>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the survey options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyOption surveyOption : findAll()) {
			remove(surveyOption);
		}
	}

	/**
	 * Returns the number of survey options.
	 *
	 * @return the number of survey options
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYOPTION);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the survey option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyOption>> listenersList = new ArrayList<ModelListener<SurveyOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyOption>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyOptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYOPTION = "SELECT surveyOption FROM SurveyOption surveyOption";
	private static final String _SQL_SELECT_SURVEYOPTION_WHERE = "SELECT surveyOption FROM SurveyOption surveyOption WHERE ";
	private static final String _SQL_COUNT_SURVEYOPTION = "SELECT COUNT(surveyOption) FROM SurveyOption surveyOption";
	private static final String _SQL_COUNT_SURVEYOPTION_WHERE = "SELECT COUNT(surveyOption) FROM SurveyOption surveyOption WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyOption exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyOption exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyOptionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"option"
			});
	private static SurveyOption _nullSurveyOption = new SurveyOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyOption> toCacheModel() {
				return _nullSurveyOptionCacheModel;
			}
		};

	private static CacheModel<SurveyOption> _nullSurveyOptionCacheModel = new CacheModel<SurveyOption>() {
			@Override
			public SurveyOption toEntityModel() {
				return _nullSurveyOption;
			}
		};
}