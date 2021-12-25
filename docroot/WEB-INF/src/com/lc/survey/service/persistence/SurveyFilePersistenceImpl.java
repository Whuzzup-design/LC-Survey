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

import com.lc.survey.NoSuchSurveyFileException;
import com.lc.survey.model.SurveyFile;
import com.lc.survey.model.impl.SurveyFileImpl;
import com.lc.survey.model.impl.SurveyFileModelImpl;

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
 * The persistence implementation for the survey file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyFilePersistence
 * @see SurveyFileUtil
 * @generated
 */
public class SurveyFilePersistenceImpl extends BasePersistenceImpl<SurveyFile>
	implements SurveyFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyFileUtil} to access the survey file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileModelImpl.FINDER_CACHE_ENABLED, SurveyFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileModelImpl.FINDER_CACHE_ENABLED, SurveyFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileModelImpl.FINDER_CACHE_ENABLED, SurveyFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileModelImpl.FINDER_CACHE_ENABLED, SurveyFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyFileModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyFileModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey files where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyFile> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey files where surveyMainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyMainId the survey main ID
	 * @param start the lower bound of the range of survey files
	 * @param end the upper bound of the range of survey files (not inclusive)
	 * @return the range of matching survey files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyFile> findBySurveyMainId(long surveyMainId, int start,
		int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey files where surveyMainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param surveyMainId the survey main ID
	 * @param start the lower bound of the range of survey files
	 * @param end the upper bound of the range of survey files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching survey files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyFile> findBySurveyMainId(long surveyMainId, int start,
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

		List<SurveyFile> list = (List<SurveyFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyFile surveyFile : list) {
				if ((surveyMainId != surveyFile.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYFILE_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyFile>(list);
				}
				else {
					list = (List<SurveyFile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey file in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey file
	 * @throws com.lc.survey.NoSuchSurveyFileException if a matching survey file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyFileException, SystemException {
		SurveyFile surveyFile = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyFile != null) {
			return surveyFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyFileException(msg.toString());
	}

	/**
	 * Returns the first survey file in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey file, or <code>null</code> if a matching survey file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyFile> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last survey file in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey file
	 * @throws com.lc.survey.NoSuchSurveyFileException if a matching survey file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyFileException, SystemException {
		SurveyFile surveyFile = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyFile != null) {
			return surveyFile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyFileException(msg.toString());
	}

	/**
	 * Returns the last survey file in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey file, or <code>null</code> if a matching survey file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyFile> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the survey files before and after the current survey file in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyFileId the primary key of the current survey file
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next survey file
	 * @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile[] findBySurveyMainId_PrevAndNext(long surveyFileId,
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyFileException, SystemException {
		SurveyFile surveyFile = findByPrimaryKey(surveyFileId);

		Session session = null;

		try {
			session = openSession();

			SurveyFile[] array = new SurveyFileImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyFile,
					surveyMainId, orderByComparator, true);

			array[1] = surveyFile;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyFile,
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

	protected SurveyFile getBySurveyMainId_PrevAndNext(Session session,
		SurveyFile surveyFile, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYFILE_WHERE);

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
			query.append(SurveyFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey files where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyFile surveyFile : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyFile);
		}
	}

	/**
	 * Returns the number of survey files where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey files
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

			query.append(_SQL_COUNT_SURVEYFILE_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyFile.surveyMainId = ?";

	public SurveyFilePersistenceImpl() {
		setModelClass(SurveyFile.class);
	}

	/**
	 * Caches the survey file in the entity cache if it is enabled.
	 *
	 * @param surveyFile the survey file
	 */
	@Override
	public void cacheResult(SurveyFile surveyFile) {
		EntityCacheUtil.putResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileImpl.class, surveyFile.getPrimaryKey(), surveyFile);

		surveyFile.resetOriginalValues();
	}

	/**
	 * Caches the survey files in the entity cache if it is enabled.
	 *
	 * @param surveyFiles the survey files
	 */
	@Override
	public void cacheResult(List<SurveyFile> surveyFiles) {
		for (SurveyFile surveyFile : surveyFiles) {
			if (EntityCacheUtil.getResult(
						SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
						SurveyFileImpl.class, surveyFile.getPrimaryKey()) == null) {
				cacheResult(surveyFile);
			}
			else {
				surveyFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyFile surveyFile) {
		EntityCacheUtil.removeResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileImpl.class, surveyFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyFile> surveyFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyFile surveyFile : surveyFiles) {
			EntityCacheUtil.removeResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
				SurveyFileImpl.class, surveyFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey file with the primary key. Does not add the survey file to the database.
	 *
	 * @param surveyFileId the primary key for the new survey file
	 * @return the new survey file
	 */
	@Override
	public SurveyFile create(long surveyFileId) {
		SurveyFile surveyFile = new SurveyFileImpl();

		surveyFile.setNew(true);
		surveyFile.setPrimaryKey(surveyFileId);

		return surveyFile;
	}

	/**
	 * Removes the survey file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyFileId the primary key of the survey file
	 * @return the survey file that was removed
	 * @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile remove(long surveyFileId)
		throws NoSuchSurveyFileException, SystemException {
		return remove((Serializable)surveyFileId);
	}

	/**
	 * Removes the survey file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey file
	 * @return the survey file that was removed
	 * @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile remove(Serializable primaryKey)
		throws NoSuchSurveyFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyFile surveyFile = (SurveyFile)session.get(SurveyFileImpl.class,
					primaryKey);

			if (surveyFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyFile);
		}
		catch (NoSuchSurveyFileException nsee) {
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
	protected SurveyFile removeImpl(SurveyFile surveyFile)
		throws SystemException {
		surveyFile = toUnwrappedModel(surveyFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyFile)) {
				surveyFile = (SurveyFile)session.get(SurveyFileImpl.class,
						surveyFile.getPrimaryKeyObj());
			}

			if (surveyFile != null) {
				session.delete(surveyFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyFile != null) {
			clearCache(surveyFile);
		}

		return surveyFile;
	}

	@Override
	public SurveyFile updateImpl(com.lc.survey.model.SurveyFile surveyFile)
		throws SystemException {
		surveyFile = toUnwrappedModel(surveyFile);

		boolean isNew = surveyFile.isNew();

		SurveyFileModelImpl surveyFileModelImpl = (SurveyFileModelImpl)surveyFile;

		Session session = null;

		try {
			session = openSession();

			if (surveyFile.isNew()) {
				session.save(surveyFile);

				surveyFile.setNew(false);
			}
			else {
				session.merge(surveyFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyFileModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyFileModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
			SurveyFileImpl.class, surveyFile.getPrimaryKey(), surveyFile);

		return surveyFile;
	}

	protected SurveyFile toUnwrappedModel(SurveyFile surveyFile) {
		if (surveyFile instanceof SurveyFileImpl) {
			return surveyFile;
		}

		SurveyFileImpl surveyFileImpl = new SurveyFileImpl();

		surveyFileImpl.setNew(surveyFile.isNew());
		surveyFileImpl.setPrimaryKey(surveyFile.getPrimaryKey());

		surveyFileImpl.setSurveyFileId(surveyFile.getSurveyFileId());
		surveyFileImpl.setSurveyMainId(surveyFile.getSurveyMainId());
		surveyFileImpl.setFileName(surveyFile.getFileName());
		surveyFileImpl.setCreatorId(surveyFile.getCreatorId());
		surveyFileImpl.setCreateDate(surveyFile.getCreateDate());

		return surveyFileImpl;
	}

	/**
	 * Returns the survey file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey file
	 * @return the survey file
	 * @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyFileException, SystemException {
		SurveyFile surveyFile = fetchByPrimaryKey(primaryKey);

		if (surveyFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyFile;
	}

	/**
	 * Returns the survey file with the primary key or throws a {@link com.lc.survey.NoSuchSurveyFileException} if it could not be found.
	 *
	 * @param surveyFileId the primary key of the survey file
	 * @return the survey file
	 * @throws com.lc.survey.NoSuchSurveyFileException if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile findByPrimaryKey(long surveyFileId)
		throws NoSuchSurveyFileException, SystemException {
		return findByPrimaryKey((Serializable)surveyFileId);
	}

	/**
	 * Returns the survey file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey file
	 * @return the survey file, or <code>null</code> if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyFile surveyFile = (SurveyFile)EntityCacheUtil.getResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
				SurveyFileImpl.class, primaryKey);

		if (surveyFile == _nullSurveyFile) {
			return null;
		}

		if (surveyFile == null) {
			Session session = null;

			try {
				session = openSession();

				surveyFile = (SurveyFile)session.get(SurveyFileImpl.class,
						primaryKey);

				if (surveyFile != null) {
					cacheResult(surveyFile);
				}
				else {
					EntityCacheUtil.putResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
						SurveyFileImpl.class, primaryKey, _nullSurveyFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyFileModelImpl.ENTITY_CACHE_ENABLED,
					SurveyFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyFile;
	}

	/**
	 * Returns the survey file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyFileId the primary key of the survey file
	 * @return the survey file, or <code>null</code> if a survey file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyFile fetchByPrimaryKey(long surveyFileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyFileId);
	}

	/**
	 * Returns all the survey files.
	 *
	 * @return the survey files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the survey files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey files
	 * @param end the upper bound of the range of survey files (not inclusive)
	 * @return the range of survey files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the survey files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of survey files
	 * @param end the upper bound of the range of survey files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of survey files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyFile> findAll(int start, int end,
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

		List<SurveyFile> list = (List<SurveyFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYFILE;

				if (pagination) {
					sql = sql.concat(SurveyFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyFile>(list);
				}
				else {
					list = (List<SurveyFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the survey files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyFile surveyFile : findAll()) {
			remove(surveyFile);
		}
	}

	/**
	 * Returns the number of survey files.
	 *
	 * @return the number of survey files
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYFILE);

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
	 * Initializes the survey file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyFile>> listenersList = new ArrayList<ModelListener<SurveyFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYFILE = "SELECT surveyFile FROM SurveyFile surveyFile";
	private static final String _SQL_SELECT_SURVEYFILE_WHERE = "SELECT surveyFile FROM SurveyFile surveyFile WHERE ";
	private static final String _SQL_COUNT_SURVEYFILE = "SELECT COUNT(surveyFile) FROM SurveyFile surveyFile";
	private static final String _SQL_COUNT_SURVEYFILE_WHERE = "SELECT COUNT(surveyFile) FROM SurveyFile surveyFile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyFilePersistenceImpl.class);
	private static SurveyFile _nullSurveyFile = new SurveyFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyFile> toCacheModel() {
				return _nullSurveyFileCacheModel;
			}
		};

	private static CacheModel<SurveyFile> _nullSurveyFileCacheModel = new CacheModel<SurveyFile>() {
			@Override
			public SurveyFile toEntityModel() {
				return _nullSurveyFile;
			}
		};
}