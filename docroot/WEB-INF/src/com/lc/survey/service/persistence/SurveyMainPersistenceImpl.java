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

import com.lc.survey.NoSuchSurveyMainException;
import com.lc.survey.model.SurveyMain;
import com.lc.survey.model.impl.SurveyMainImpl;
import com.lc.survey.model.impl.SurveyMainModelImpl;

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
 * The persistence implementation for the survey main service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyMainPersistence
 * @see SurveyMainUtil
 * @generated
 */
public class SurveyMainPersistenceImpl extends BasePersistenceImpl<SurveyMain>
	implements SurveyMainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyMainUtil} to access the survey main persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyMainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainModelImpl.FINDER_CACHE_ENABLED, SurveyMainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainModelImpl.FINDER_CACHE_ENABLED, SurveyMainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainModelImpl.FINDER_CACHE_ENABLED, SurveyMainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreatorId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainModelImpl.FINDER_CACHE_ENABLED, SurveyMainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreatorId",
			new String[] { Long.class.getName() },
			SurveyMainModelImpl.CREATORID_COLUMN_BITMASK |
			SurveyMainModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATORID = new FinderPath(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreatorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey mains where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyMain> findByCreatorId(long creatorId)
		throws SystemException {
		return findByCreatorId(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the survey mains where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of survey mains
	 * @param end the upper bound of the range of survey mains (not inclusive)
	 * @return the range of matching survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyMain> findByCreatorId(long creatorId, int start, int end)
		throws SystemException {
		return findByCreatorId(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey mains where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of survey mains
	 * @param end the upper bound of the range of survey mains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyMain> findByCreatorId(long creatorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID;
			finderArgs = new Object[] { creatorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORID;
			finderArgs = new Object[] { creatorId, start, end, orderByComparator };
		}

		List<SurveyMain> list = (List<SurveyMain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyMain surveyMain : list) {
				if ((creatorId != surveyMain.getCreatorId())) {
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

			query.append(_SQL_SELECT_SURVEYMAIN_WHERE);

			query.append(_FINDER_COLUMN_CREATORID_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyMainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

				if (!pagination) {
					list = (List<SurveyMain>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyMain>(list);
				}
				else {
					list = (List<SurveyMain>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey main in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey main
	 * @throws com.lc.survey.NoSuchSurveyMainException if a matching survey main could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain findByCreatorId_First(long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyMainException, SystemException {
		SurveyMain surveyMain = fetchByCreatorId_First(creatorId,
				orderByComparator);

		if (surveyMain != null) {
			return surveyMain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyMainException(msg.toString());
	}

	/**
	 * Returns the first survey main in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey main, or <code>null</code> if a matching survey main could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain fetchByCreatorId_First(long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyMain> list = findByCreatorId(creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey main in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey main
	 * @throws com.lc.survey.NoSuchSurveyMainException if a matching survey main could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain findByCreatorId_Last(long creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyMainException, SystemException {
		SurveyMain surveyMain = fetchByCreatorId_Last(creatorId,
				orderByComparator);

		if (surveyMain != null) {
			return surveyMain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyMainException(msg.toString());
	}

	/**
	 * Returns the last survey main in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey main, or <code>null</code> if a matching survey main could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain fetchByCreatorId_Last(long creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreatorId(creatorId);

		if (count == 0) {
			return null;
		}

		List<SurveyMain> list = findByCreatorId(creatorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey mains before and after the current survey main in the ordered set where creatorId = &#63;.
	 *
	 * @param surveyMainId the primary key of the current survey main
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey main
	 * @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain[] findByCreatorId_PrevAndNext(long surveyMainId,
		long creatorId, OrderByComparator orderByComparator)
		throws NoSuchSurveyMainException, SystemException {
		SurveyMain surveyMain = findByPrimaryKey(surveyMainId);

		Session session = null;

		try {
			session = openSession();

			SurveyMain[] array = new SurveyMainImpl[3];

			array[0] = getByCreatorId_PrevAndNext(session, surveyMain,
					creatorId, orderByComparator, true);

			array[1] = surveyMain;

			array[2] = getByCreatorId_PrevAndNext(session, surveyMain,
					creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyMain getByCreatorId_PrevAndNext(Session session,
		SurveyMain surveyMain, long creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYMAIN_WHERE);

		query.append(_FINDER_COLUMN_CREATORID_CREATORID_2);

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
			query.append(SurveyMainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creatorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyMain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyMain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey mains where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreatorId(long creatorId) throws SystemException {
		for (SurveyMain surveyMain : findByCreatorId(creatorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyMain);
		}
	}

	/**
	 * Returns the number of survey mains where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreatorId(long creatorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATORID;

		Object[] finderArgs = new Object[] { creatorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYMAIN_WHERE);

			query.append(_FINDER_COLUMN_CREATORID_CREATORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_CREATORID_CREATORID_2 = "surveyMain.creatorId = ?";

	public SurveyMainPersistenceImpl() {
		setModelClass(SurveyMain.class);
	}

	/**
	 * Caches the survey main in the entity cache if it is enabled.
	 *
	 * @param surveyMain the survey main
	 */
	@Override
	public void cacheResult(SurveyMain surveyMain) {
		EntityCacheUtil.putResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainImpl.class, surveyMain.getPrimaryKey(), surveyMain);

		surveyMain.resetOriginalValues();
	}

	/**
	 * Caches the survey mains in the entity cache if it is enabled.
	 *
	 * @param surveyMains the survey mains
	 */
	@Override
	public void cacheResult(List<SurveyMain> surveyMains) {
		for (SurveyMain surveyMain : surveyMains) {
			if (EntityCacheUtil.getResult(
						SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
						SurveyMainImpl.class, surveyMain.getPrimaryKey()) == null) {
				cacheResult(surveyMain);
			}
			else {
				surveyMain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey mains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyMainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyMainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey main.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyMain surveyMain) {
		EntityCacheUtil.removeResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainImpl.class, surveyMain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyMain> surveyMains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyMain surveyMain : surveyMains) {
			EntityCacheUtil.removeResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
				SurveyMainImpl.class, surveyMain.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey main with the primary key. Does not add the survey main to the database.
	 *
	 * @param surveyMainId the primary key for the new survey main
	 * @return the new survey main
	 */
	@Override
	public SurveyMain create(long surveyMainId) {
		SurveyMain surveyMain = new SurveyMainImpl();

		surveyMain.setNew(true);
		surveyMain.setPrimaryKey(surveyMainId);

		return surveyMain;
	}

	/**
	 * Removes the survey main with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyMainId the primary key of the survey main
	 * @return the survey main that was removed
	 * @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain remove(long surveyMainId)
		throws NoSuchSurveyMainException, SystemException {
		return remove((Serializable)surveyMainId);
	}

	/**
	 * Removes the survey main with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey main
	 * @return the survey main that was removed
	 * @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain remove(Serializable primaryKey)
		throws NoSuchSurveyMainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyMain surveyMain = (SurveyMain)session.get(SurveyMainImpl.class,
					primaryKey);

			if (surveyMain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyMainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyMain);
		}
		catch (NoSuchSurveyMainException nsee) {
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
	protected SurveyMain removeImpl(SurveyMain surveyMain)
		throws SystemException {
		surveyMain = toUnwrappedModel(surveyMain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyMain)) {
				surveyMain = (SurveyMain)session.get(SurveyMainImpl.class,
						surveyMain.getPrimaryKeyObj());
			}

			if (surveyMain != null) {
				session.delete(surveyMain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyMain != null) {
			clearCache(surveyMain);
		}

		return surveyMain;
	}

	@Override
	public SurveyMain updateImpl(com.lc.survey.model.SurveyMain surveyMain)
		throws SystemException {
		surveyMain = toUnwrappedModel(surveyMain);

		boolean isNew = surveyMain.isNew();

		SurveyMainModelImpl surveyMainModelImpl = (SurveyMainModelImpl)surveyMain;

		Session session = null;

		try {
			session = openSession();

			if (surveyMain.isNew()) {
				session.save(surveyMain);

				surveyMain.setNew(false);
			}
			else {
				session.merge(surveyMain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyMainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyMainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyMainModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);

				args = new Object[] { surveyMainModelImpl.getCreatorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
			SurveyMainImpl.class, surveyMain.getPrimaryKey(), surveyMain);

		return surveyMain;
	}

	protected SurveyMain toUnwrappedModel(SurveyMain surveyMain) {
		if (surveyMain instanceof SurveyMainImpl) {
			return surveyMain;
		}

		SurveyMainImpl surveyMainImpl = new SurveyMainImpl();

		surveyMainImpl.setNew(surveyMain.isNew());
		surveyMainImpl.setPrimaryKey(surveyMain.getPrimaryKey());

		surveyMainImpl.setSurveyMainId(surveyMain.getSurveyMainId());
		surveyMainImpl.setTitle(surveyMain.getTitle());
		surveyMainImpl.setDescription(surveyMain.getDescription());
		surveyMainImpl.setEpilog(surveyMain.getEpilog());
		surveyMainImpl.setStartDate(surveyMain.getStartDate());
		surveyMainImpl.setEndDate(surveyMain.getEndDate());
		surveyMainImpl.setNeedAuth(surveyMain.getNeedAuth());
		surveyMainImpl.setCalculateScore(surveyMain.getCalculateScore());
		surveyMainImpl.setViewAnswer(surveyMain.getViewAnswer());
		surveyMainImpl.setColor(surveyMain.getColor());
		surveyMainImpl.setCreatorId(surveyMain.getCreatorId());
		surveyMainImpl.setModifierId(surveyMain.getModifierId());
		surveyMainImpl.setCreateDate(surveyMain.getCreateDate());
		surveyMainImpl.setModifiedDate(surveyMain.getModifiedDate());

		return surveyMainImpl;
	}

	/**
	 * Returns the survey main with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey main
	 * @return the survey main
	 * @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyMainException, SystemException {
		SurveyMain surveyMain = fetchByPrimaryKey(primaryKey);

		if (surveyMain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyMainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyMain;
	}

	/**
	 * Returns the survey main with the primary key or throws a {@link com.lc.survey.NoSuchSurveyMainException} if it could not be found.
	 *
	 * @param surveyMainId the primary key of the survey main
	 * @return the survey main
	 * @throws com.lc.survey.NoSuchSurveyMainException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain findByPrimaryKey(long surveyMainId)
		throws NoSuchSurveyMainException, SystemException {
		return findByPrimaryKey((Serializable)surveyMainId);
	}

	/**
	 * Returns the survey main with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey main
	 * @return the survey main, or <code>null</code> if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyMain surveyMain = (SurveyMain)EntityCacheUtil.getResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
				SurveyMainImpl.class, primaryKey);

		if (surveyMain == _nullSurveyMain) {
			return null;
		}

		if (surveyMain == null) {
			Session session = null;

			try {
				session = openSession();

				surveyMain = (SurveyMain)session.get(SurveyMainImpl.class,
						primaryKey);

				if (surveyMain != null) {
					cacheResult(surveyMain);
				}
				else {
					EntityCacheUtil.putResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
						SurveyMainImpl.class, primaryKey, _nullSurveyMain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyMainModelImpl.ENTITY_CACHE_ENABLED,
					SurveyMainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyMain;
	}

	/**
	 * Returns the survey main with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyMainId the primary key of the survey main
	 * @return the survey main, or <code>null</code> if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain fetchByPrimaryKey(long surveyMainId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyMainId);
	}

	/**
	 * Returns all the survey mains.
	 *
	 * @return the survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyMain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey mains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey mains
	 * @param end the upper bound of the range of survey mains (not inclusive)
	 * @return the range of survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyMain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey mains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey mains
	 * @param end the upper bound of the range of survey mains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyMain> findAll(int start, int end,
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

		List<SurveyMain> list = (List<SurveyMain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYMAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYMAIN;

				if (pagination) {
					sql = sql.concat(SurveyMainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyMain>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyMain>(list);
				}
				else {
					list = (List<SurveyMain>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the survey mains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyMain surveyMain : findAll()) {
			remove(surveyMain);
		}
	}

	/**
	 * Returns the number of survey mains.
	 *
	 * @return the number of survey mains
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYMAIN);

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
	 * Initializes the survey main persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyMain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyMain>> listenersList = new ArrayList<ModelListener<SurveyMain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyMain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyMainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYMAIN = "SELECT surveyMain FROM SurveyMain surveyMain";
	private static final String _SQL_SELECT_SURVEYMAIN_WHERE = "SELECT surveyMain FROM SurveyMain surveyMain WHERE ";
	private static final String _SQL_COUNT_SURVEYMAIN = "SELECT COUNT(surveyMain) FROM SurveyMain surveyMain";
	private static final String _SQL_COUNT_SURVEYMAIN_WHERE = "SELECT COUNT(surveyMain) FROM SurveyMain surveyMain WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyMain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyMain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyMain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyMainPersistenceImpl.class);
	private static SurveyMain _nullSurveyMain = new SurveyMainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyMain> toCacheModel() {
				return _nullSurveyMainCacheModel;
			}
		};

	private static CacheModel<SurveyMain> _nullSurveyMainCacheModel = new CacheModel<SurveyMain>() {
			@Override
			public SurveyMain toEntityModel() {
				return _nullSurveyMain;
			}
		};
}