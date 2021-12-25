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

import com.lc.survey.NoSuchSurveyWriterException;
import com.lc.survey.model.SurveyWriter;
import com.lc.survey.model.impl.SurveyWriterImpl;
import com.lc.survey.model.impl.SurveyWriterModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the survey writer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyWriterPersistence
 * @see SurveyWriterUtil
 * @generated
 */
public class SurveyWriterPersistenceImpl extends BasePersistenceImpl<SurveyWriter>
	implements SurveyWriterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyWriterUtil} to access the survey writer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyWriterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, SurveyWriterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, SurveyWriterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, SurveyWriterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, SurveyWriterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyWriterModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyWriterModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey writers where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey writers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyWriter> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyWriter> findBySurveyMainId(long surveyMainId, int start,
		int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
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
	@Override
	public List<SurveyWriter> findBySurveyMainId(long surveyMainId, int start,
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

		List<SurveyWriter> list = (List<SurveyWriter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyWriter surveyWriter : list) {
				if ((surveyMainId != surveyWriter.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYWRITER_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyWriterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyWriter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyWriter>(list);
				}
				else {
					list = (List<SurveyWriter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first survey writer in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey writer
	 * @throws com.lc.survey.NoSuchSurveyWriterException if a matching survey writer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyWriter != null) {
			return surveyWriter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyWriterException(msg.toString());
	}

	/**
	 * Returns the first survey writer in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey writer, or <code>null</code> if a matching survey writer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyWriter> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyWriter findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyWriter != null) {
			return surveyWriter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyWriterException(msg.toString());
	}

	/**
	 * Returns the last survey writer in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey writer, or <code>null</code> if a matching survey writer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyWriter> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyWriter[] findBySurveyMainId_PrevAndNext(long surveyWriterId,
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = findByPrimaryKey(surveyWriterId);

		Session session = null;

		try {
			session = openSession();

			SurveyWriter[] array = new SurveyWriterImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyWriter,
					surveyMainId, orderByComparator, true);

			array[1] = surveyWriter;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyWriter,
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

	protected SurveyWriter getBySurveyMainId_PrevAndNext(Session session,
		SurveyWriter surveyWriter, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYWRITER_WHERE);

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
			query.append(SurveyWriterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyWriter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyWriter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey writers where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyWriter surveyWriter : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyWriter);
		}
	}

	/**
	 * Returns the number of survey writers where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey writers
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

			query.append(_SQL_COUNT_SURVEYWRITER_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyWriter.surveyMainId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_M_P_C = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, SurveyWriterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByM_P_C",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_P_C = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, SurveyWriterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByM_P_C",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			SurveyWriterModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyWriterModelImpl.ISPREVIEW_COLUMN_BITMASK |
			SurveyWriterModelImpl.ISCOMPLETE_COLUMN_BITMASK |
			SurveyWriterModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_M_P_C = new FinderPath(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_P_C",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param isPreview the is preview
	 * @param isComplete the is complete
	 * @return the matching survey writers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyWriter> findByM_P_C(long surveyMainId, Boolean isPreview,
		Boolean isComplete) throws SystemException {
		return findByM_P_C(surveyMainId, isPreview, isComplete,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyWriter> findByM_P_C(long surveyMainId, Boolean isPreview,
		Boolean isComplete, int start, int end) throws SystemException {
		return findByM_P_C(surveyMainId, isPreview, isComplete, start, end, null);
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
	@Override
	public List<SurveyWriter> findByM_P_C(long surveyMainId, Boolean isPreview,
		Boolean isComplete, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_P_C;
			finderArgs = new Object[] { surveyMainId, isPreview, isComplete };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_M_P_C;
			finderArgs = new Object[] {
					surveyMainId, isPreview, isComplete,
					
					start, end, orderByComparator
				};
		}

		List<SurveyWriter> list = (List<SurveyWriter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyWriter surveyWriter : list) {
				if ((surveyMainId != surveyWriter.getSurveyMainId()) ||
						!Validator.equals(isPreview, surveyWriter.getIsPreview()) ||
						!Validator.equals(isComplete,
							surveyWriter.getIsComplete())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SURVEYWRITER_WHERE);

			query.append(_FINDER_COLUMN_M_P_C_SURVEYMAINID_2);

			query.append(_FINDER_COLUMN_M_P_C_ISPREVIEW_2);

			query.append(_FINDER_COLUMN_M_P_C_ISCOMPLETE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyWriterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				qPos.add(isPreview.booleanValue());

				qPos.add(isComplete.booleanValue());

				if (!pagination) {
					list = (List<SurveyWriter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyWriter>(list);
				}
				else {
					list = (List<SurveyWriter>)QueryUtil.list(q, getDialect(),
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
	@Override
	public SurveyWriter findByM_P_C_First(long surveyMainId, Boolean isPreview,
		Boolean isComplete, OrderByComparator orderByComparator)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = fetchByM_P_C_First(surveyMainId, isPreview,
				isComplete, orderByComparator);

		if (surveyWriter != null) {
			return surveyWriter;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(", isPreview=");
		msg.append(isPreview);

		msg.append(", isComplete=");
		msg.append(isComplete);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyWriterException(msg.toString());
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
	@Override
	public SurveyWriter fetchByM_P_C_First(long surveyMainId,
		Boolean isPreview, Boolean isComplete,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyWriter> list = findByM_P_C(surveyMainId, isPreview,
				isComplete, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyWriter findByM_P_C_Last(long surveyMainId, Boolean isPreview,
		Boolean isComplete, OrderByComparator orderByComparator)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = fetchByM_P_C_Last(surveyMainId, isPreview,
				isComplete, orderByComparator);

		if (surveyWriter != null) {
			return surveyWriter;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(", isPreview=");
		msg.append(isPreview);

		msg.append(", isComplete=");
		msg.append(isComplete);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyWriterException(msg.toString());
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
	@Override
	public SurveyWriter fetchByM_P_C_Last(long surveyMainId, Boolean isPreview,
		Boolean isComplete, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByM_P_C(surveyMainId, isPreview, isComplete);

		if (count == 0) {
			return null;
		}

		List<SurveyWriter> list = findByM_P_C(surveyMainId, isPreview,
				isComplete, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyWriter[] findByM_P_C_PrevAndNext(long surveyWriterId,
		long surveyMainId, Boolean isPreview, Boolean isComplete,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = findByPrimaryKey(surveyWriterId);

		Session session = null;

		try {
			session = openSession();

			SurveyWriter[] array = new SurveyWriterImpl[3];

			array[0] = getByM_P_C_PrevAndNext(session, surveyWriter,
					surveyMainId, isPreview, isComplete, orderByComparator, true);

			array[1] = surveyWriter;

			array[2] = getByM_P_C_PrevAndNext(session, surveyWriter,
					surveyMainId, isPreview, isComplete, orderByComparator,
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

	protected SurveyWriter getByM_P_C_PrevAndNext(Session session,
		SurveyWriter surveyWriter, long surveyMainId, Boolean isPreview,
		Boolean isComplete, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYWRITER_WHERE);

		query.append(_FINDER_COLUMN_M_P_C_SURVEYMAINID_2);

		query.append(_FINDER_COLUMN_M_P_C_ISPREVIEW_2);

		query.append(_FINDER_COLUMN_M_P_C_ISCOMPLETE_2);

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
			query.append(SurveyWriterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		qPos.add(isPreview.booleanValue());

		qPos.add(isComplete.booleanValue());

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyWriter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyWriter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey writers where surveyMainId = &#63; and isPreview = &#63; and isComplete = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @param isPreview the is preview
	 * @param isComplete the is complete
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByM_P_C(long surveyMainId, Boolean isPreview,
		Boolean isComplete) throws SystemException {
		for (SurveyWriter surveyWriter : findByM_P_C(surveyMainId, isPreview,
				isComplete, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyWriter);
		}
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
	@Override
	public int countByM_P_C(long surveyMainId, Boolean isPreview,
		Boolean isComplete) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_M_P_C;

		Object[] finderArgs = new Object[] { surveyMainId, isPreview, isComplete };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SURVEYWRITER_WHERE);

			query.append(_FINDER_COLUMN_M_P_C_SURVEYMAINID_2);

			query.append(_FINDER_COLUMN_M_P_C_ISPREVIEW_2);

			query.append(_FINDER_COLUMN_M_P_C_ISCOMPLETE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				qPos.add(isPreview.booleanValue());

				qPos.add(isComplete.booleanValue());

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

	private static final String _FINDER_COLUMN_M_P_C_SURVEYMAINID_2 = "surveyWriter.surveyMainId = ? AND ";
	private static final String _FINDER_COLUMN_M_P_C_ISPREVIEW_2 = "surveyWriter.isPreview = ? AND ";
	private static final String _FINDER_COLUMN_M_P_C_ISCOMPLETE_2 = "surveyWriter.isComplete = ?";

	public SurveyWriterPersistenceImpl() {
		setModelClass(SurveyWriter.class);
	}

	/**
	 * Caches the survey writer in the entity cache if it is enabled.
	 *
	 * @param surveyWriter the survey writer
	 */
	@Override
	public void cacheResult(SurveyWriter surveyWriter) {
		EntityCacheUtil.putResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterImpl.class, surveyWriter.getPrimaryKey(), surveyWriter);

		surveyWriter.resetOriginalValues();
	}

	/**
	 * Caches the survey writers in the entity cache if it is enabled.
	 *
	 * @param surveyWriters the survey writers
	 */
	@Override
	public void cacheResult(List<SurveyWriter> surveyWriters) {
		for (SurveyWriter surveyWriter : surveyWriters) {
			if (EntityCacheUtil.getResult(
						SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
						SurveyWriterImpl.class, surveyWriter.getPrimaryKey()) == null) {
				cacheResult(surveyWriter);
			}
			else {
				surveyWriter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey writers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyWriterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyWriterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey writer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyWriter surveyWriter) {
		EntityCacheUtil.removeResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterImpl.class, surveyWriter.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyWriter> surveyWriters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyWriter surveyWriter : surveyWriters) {
			EntityCacheUtil.removeResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
				SurveyWriterImpl.class, surveyWriter.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey writer with the primary key. Does not add the survey writer to the database.
	 *
	 * @param surveyWriterId the primary key for the new survey writer
	 * @return the new survey writer
	 */
	@Override
	public SurveyWriter create(long surveyWriterId) {
		SurveyWriter surveyWriter = new SurveyWriterImpl();

		surveyWriter.setNew(true);
		surveyWriter.setPrimaryKey(surveyWriterId);

		return surveyWriter;
	}

	/**
	 * Removes the survey writer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyWriterId the primary key of the survey writer
	 * @return the survey writer that was removed
	 * @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter remove(long surveyWriterId)
		throws NoSuchSurveyWriterException, SystemException {
		return remove((Serializable)surveyWriterId);
	}

	/**
	 * Removes the survey writer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey writer
	 * @return the survey writer that was removed
	 * @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter remove(Serializable primaryKey)
		throws NoSuchSurveyWriterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyWriter surveyWriter = (SurveyWriter)session.get(SurveyWriterImpl.class,
					primaryKey);

			if (surveyWriter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyWriterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyWriter);
		}
		catch (NoSuchSurveyWriterException nsee) {
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
	protected SurveyWriter removeImpl(SurveyWriter surveyWriter)
		throws SystemException {
		surveyWriter = toUnwrappedModel(surveyWriter);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyWriter)) {
				surveyWriter = (SurveyWriter)session.get(SurveyWriterImpl.class,
						surveyWriter.getPrimaryKeyObj());
			}

			if (surveyWriter != null) {
				session.delete(surveyWriter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyWriter != null) {
			clearCache(surveyWriter);
		}

		return surveyWriter;
	}

	@Override
	public SurveyWriter updateImpl(
		com.lc.survey.model.SurveyWriter surveyWriter)
		throws SystemException {
		surveyWriter = toUnwrappedModel(surveyWriter);

		boolean isNew = surveyWriter.isNew();

		SurveyWriterModelImpl surveyWriterModelImpl = (SurveyWriterModelImpl)surveyWriter;

		Session session = null;

		try {
			session = openSession();

			if (surveyWriter.isNew()) {
				session.save(surveyWriter);

				surveyWriter.setNew(false);
			}
			else {
				session.merge(surveyWriter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyWriterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyWriterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyWriterModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyWriterModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}

			if ((surveyWriterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_P_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyWriterModelImpl.getOriginalSurveyMainId(),
						surveyWriterModelImpl.getOriginalIsPreview(),
						surveyWriterModelImpl.getOriginalIsComplete()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_M_P_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_P_C,
					args);

				args = new Object[] {
						surveyWriterModelImpl.getSurveyMainId(),
						surveyWriterModelImpl.getIsPreview(),
						surveyWriterModelImpl.getIsComplete()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_M_P_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_M_P_C,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
			SurveyWriterImpl.class, surveyWriter.getPrimaryKey(), surveyWriter);

		return surveyWriter;
	}

	protected SurveyWriter toUnwrappedModel(SurveyWriter surveyWriter) {
		if (surveyWriter instanceof SurveyWriterImpl) {
			return surveyWriter;
		}

		SurveyWriterImpl surveyWriterImpl = new SurveyWriterImpl();

		surveyWriterImpl.setNew(surveyWriter.isNew());
		surveyWriterImpl.setPrimaryKey(surveyWriter.getPrimaryKey());

		surveyWriterImpl.setSurveyWriterId(surveyWriter.getSurveyWriterId());
		surveyWriterImpl.setSurveyMainId(surveyWriter.getSurveyMainId());
		surveyWriterImpl.setIsPreview(surveyWriter.getIsPreview());
		surveyWriterImpl.setIsComplete(surveyWriter.getIsComplete());
		surveyWriterImpl.setCompletionTime(surveyWriter.getCompletionTime());
		surveyWriterImpl.setCreatorId(surveyWriter.getCreatorId());
		surveyWriterImpl.setCreateDate(surveyWriter.getCreateDate());

		return surveyWriterImpl;
	}

	/**
	 * Returns the survey writer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey writer
	 * @return the survey writer
	 * @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyWriterException, SystemException {
		SurveyWriter surveyWriter = fetchByPrimaryKey(primaryKey);

		if (surveyWriter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyWriterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyWriter;
	}

	/**
	 * Returns the survey writer with the primary key or throws a {@link com.lc.survey.NoSuchSurveyWriterException} if it could not be found.
	 *
	 * @param surveyWriterId the primary key of the survey writer
	 * @return the survey writer
	 * @throws com.lc.survey.NoSuchSurveyWriterException if a survey writer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter findByPrimaryKey(long surveyWriterId)
		throws NoSuchSurveyWriterException, SystemException {
		return findByPrimaryKey((Serializable)surveyWriterId);
	}

	/**
	 * Returns the survey writer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey writer
	 * @return the survey writer, or <code>null</code> if a survey writer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyWriter surveyWriter = (SurveyWriter)EntityCacheUtil.getResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
				SurveyWriterImpl.class, primaryKey);

		if (surveyWriter == _nullSurveyWriter) {
			return null;
		}

		if (surveyWriter == null) {
			Session session = null;

			try {
				session = openSession();

				surveyWriter = (SurveyWriter)session.get(SurveyWriterImpl.class,
						primaryKey);

				if (surveyWriter != null) {
					cacheResult(surveyWriter);
				}
				else {
					EntityCacheUtil.putResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
						SurveyWriterImpl.class, primaryKey, _nullSurveyWriter);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyWriterModelImpl.ENTITY_CACHE_ENABLED,
					SurveyWriterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyWriter;
	}

	/**
	 * Returns the survey writer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyWriterId the primary key of the survey writer
	 * @return the survey writer, or <code>null</code> if a survey writer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyWriter fetchByPrimaryKey(long surveyWriterId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyWriterId);
	}

	/**
	 * Returns all the survey writers.
	 *
	 * @return the survey writers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyWriter> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyWriter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SurveyWriter> findAll(int start, int end,
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

		List<SurveyWriter> list = (List<SurveyWriter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYWRITER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYWRITER;

				if (pagination) {
					sql = sql.concat(SurveyWriterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyWriter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyWriter>(list);
				}
				else {
					list = (List<SurveyWriter>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the survey writers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyWriter surveyWriter : findAll()) {
			remove(surveyWriter);
		}
	}

	/**
	 * Returns the number of survey writers.
	 *
	 * @return the number of survey writers
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYWRITER);

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
	 * Initializes the survey writer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyWriter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyWriter>> listenersList = new ArrayList<ModelListener<SurveyWriter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyWriter>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyWriterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYWRITER = "SELECT surveyWriter FROM SurveyWriter surveyWriter";
	private static final String _SQL_SELECT_SURVEYWRITER_WHERE = "SELECT surveyWriter FROM SurveyWriter surveyWriter WHERE ";
	private static final String _SQL_COUNT_SURVEYWRITER = "SELECT COUNT(surveyWriter) FROM SurveyWriter surveyWriter";
	private static final String _SQL_COUNT_SURVEYWRITER_WHERE = "SELECT COUNT(surveyWriter) FROM SurveyWriter surveyWriter WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyWriter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyWriter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyWriter exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyWriterPersistenceImpl.class);
	private static SurveyWriter _nullSurveyWriter = new SurveyWriterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyWriter> toCacheModel() {
				return _nullSurveyWriterCacheModel;
			}
		};

	private static CacheModel<SurveyWriter> _nullSurveyWriterCacheModel = new CacheModel<SurveyWriter>() {
			@Override
			public SurveyWriter toEntityModel() {
				return _nullSurveyWriter;
			}
		};
}