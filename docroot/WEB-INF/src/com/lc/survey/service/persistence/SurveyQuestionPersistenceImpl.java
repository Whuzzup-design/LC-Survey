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

import com.lc.survey.NoSuchSurveyQuestionException;
import com.lc.survey.model.SurveyQuestion;
import com.lc.survey.model.impl.SurveyQuestionImpl;
import com.lc.survey.model.impl.SurveyQuestionModelImpl;

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
 * The persistence implementation for the survey question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kevin
 * @see SurveyQuestionPersistence
 * @see SurveyQuestionUtil
 * @generated
 */
public class SurveyQuestionPersistenceImpl extends BasePersistenceImpl<SurveyQuestion>
	implements SurveyQuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyQuestionUtil} to access the survey question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyQuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			SurveyQuestionModelImpl.PARENTID_COLUMN_BITMASK |
			SurveyQuestionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey questions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findByParentId(long parentId)
		throws SystemException {
		return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SurveyQuestion> findByParentId(long parentId, int start, int end)
		throws SystemException {
		return findByParentId(parentId, start, end, null);
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
	@Override
	public List<SurveyQuestion> findByParentId(long parentId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyQuestion surveyQuestion : list) {
				if ((parentId != surveyQuestion.getParentId())) {
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

			query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Returns the first survey question in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findByParentId_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchByParentId_First(parentId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the first survey question in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByParentId_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyQuestion> list = findByParentId(parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion findByParentId_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchByParentId_Last(parentId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the last survey question in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByParentId_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentId(parentId);

		if (count == 0) {
			return null;
		}

		List<SurveyQuestion> list = findByParentId(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion[] findByParentId_PrevAndNext(long surveyQuestionId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = findByPrimaryKey(surveyQuestionId);

		Session session = null;

		try {
			session = openSession();

			SurveyQuestion[] array = new SurveyQuestionImpl[3];

			array[0] = getByParentId_PrevAndNext(session, surveyQuestion,
					parentId, orderByComparator, true);

			array[1] = surveyQuestion;

			array[2] = getByParentId_PrevAndNext(session, surveyQuestion,
					parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyQuestion getByParentId_PrevAndNext(Session session,
		SurveyQuestion surveyQuestion, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey questions where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentId(long parentId) throws SystemException {
		for (SurveyQuestion surveyQuestion : findByParentId(parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentId(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "surveyQuestion.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySurveyPageIdAndParentId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySurveyPageIdAndParentId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SurveyQuestionModelImpl.SURVEYPAGEID_COLUMN_BITMASK |
			SurveyQuestionModelImpl.PARENTID_COLUMN_BITMASK |
			SurveyQuestionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYPAGEIDANDPARENTID = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySurveyPageIdAndParentId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the survey questions where surveyPageId = &#63; and parentId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param parentId the parent ID
	 * @return the matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId) throws SystemException {
		return findBySurveyPageIdAndParentId(surveyPageId, parentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId, int start, int end)
		throws SystemException {
		return findBySurveyPageIdAndParentId(surveyPageId, parentId, start,
			end, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID;
			finderArgs = new Object[] { surveyPageId, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID;
			finderArgs = new Object[] {
					surveyPageId, parentId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyQuestion surveyQuestion : list) {
				if ((surveyPageId != surveyQuestion.getSurveyPageId()) ||
						(parentId != surveyQuestion.getParentId())) {
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

			query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_SURVEYPAGEID_2);

			query.append(_FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Returns the first survey question in the ordered set where surveyPageId = &#63; and parentId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findBySurveyPageIdAndParentId_First(
		long surveyPageId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyPageIdAndParentId_First(surveyPageId,
				parentId, orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
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
	@Override
	public SurveyQuestion fetchBySurveyPageIdAndParentId_First(
		long surveyPageId, long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SurveyQuestion> list = findBySurveyPageIdAndParentId(surveyPageId,
				parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion findBySurveyPageIdAndParentId_Last(
		long surveyPageId, long parentId, OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyPageIdAndParentId_Last(surveyPageId,
				parentId, orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
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
	@Override
	public SurveyQuestion fetchBySurveyPageIdAndParentId_Last(
		long surveyPageId, long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySurveyPageIdAndParentId(surveyPageId, parentId);

		if (count == 0) {
			return null;
		}

		List<SurveyQuestion> list = findBySurveyPageIdAndParentId(surveyPageId,
				parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion[] findBySurveyPageIdAndParentId_PrevAndNext(
		long surveyQuestionId, long surveyPageId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = findByPrimaryKey(surveyQuestionId);

		Session session = null;

		try {
			session = openSession();

			SurveyQuestion[] array = new SurveyQuestionImpl[3];

			array[0] = getBySurveyPageIdAndParentId_PrevAndNext(session,
					surveyQuestion, surveyPageId, parentId, orderByComparator,
					true);

			array[1] = surveyQuestion;

			array[2] = getBySurveyPageIdAndParentId_PrevAndNext(session,
					surveyQuestion, surveyPageId, parentId, orderByComparator,
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

	protected SurveyQuestion getBySurveyPageIdAndParentId_PrevAndNext(
		Session session, SurveyQuestion surveyQuestion, long surveyPageId,
		long parentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

		query.append(_FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_SURVEYPAGEID_2);

		query.append(_FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_PARENTID_2);

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
			query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyPageId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey questions where surveyPageId = &#63; and parentId = &#63; from the database.
	 *
	 * @param surveyPageId the survey page ID
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyPageIdAndParentId(long surveyPageId, long parentId)
		throws SystemException {
		for (SurveyQuestion surveyQuestion : findBySurveyPageIdAndParentId(
				surveyPageId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions where surveyPageId = &#63; and parentId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param parentId the parent ID
	 * @return the number of matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyPageIdAndParentId(long surveyPageId, long parentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYPAGEIDANDPARENTID;

		Object[] finderArgs = new Object[] { surveyPageId, parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_SURVEYPAGEID_2);

			query.append(_FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_SURVEYPAGEID_2 =
		"surveyQuestion.surveyPageId = ? AND ";
	private static final String _FINDER_COLUMN_SURVEYPAGEIDANDPARENTID_PARENTID_2 =
		"surveyQuestion.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySurveyMainId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyMainId",
			new String[] { Long.class.getName() },
			SurveyQuestionModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyQuestionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINID = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyMainId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey questions where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findBySurveyMainId(long surveyMainId)
		throws SystemException {
		return findBySurveyMainId(surveyMainId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyMainId(long surveyMainId,
		int start, int end) throws SystemException {
		return findBySurveyMainId(surveyMainId, start, end, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyMainId(long surveyMainId,
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

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyQuestion surveyQuestion : list) {
				if ((surveyMainId != surveyQuestion.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Returns the first survey question in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyMainId_First(surveyMainId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the first survey question in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchBySurveyMainId_First(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyQuestion> list = findBySurveyMainId(surveyMainId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion findBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyMainId_Last(surveyMainId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the last survey question in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchBySurveyMainId_Last(long surveyMainId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyMainId(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyQuestion> list = findBySurveyMainId(surveyMainId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion[] findBySurveyMainId_PrevAndNext(
		long surveyQuestionId, long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = findByPrimaryKey(surveyQuestionId);

		Session session = null;

		try {
			session = openSession();

			SurveyQuestion[] array = new SurveyQuestionImpl[3];

			array[0] = getBySurveyMainId_PrevAndNext(session, surveyQuestion,
					surveyMainId, orderByComparator, true);

			array[1] = surveyQuestion;

			array[2] = getBySurveyMainId_PrevAndNext(session, surveyQuestion,
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

	protected SurveyQuestion getBySurveyMainId_PrevAndNext(Session session,
		SurveyQuestion surveyQuestion, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

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
			query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey questions where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws SystemException {
		for (SurveyQuestion surveyQuestion : findBySurveyMainId(surveyMainId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey questions
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

			query.append(_SQL_COUNT_SURVEYQUESTION_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYMAINID_SURVEYMAINID_2 = "surveyQuestion.surveyMainId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYPAGEID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySurveyPageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySurveyPageId",
			new String[] { Long.class.getName() },
			SurveyQuestionModelImpl.SURVEYPAGEID_COLUMN_BITMASK |
			SurveyQuestionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYPAGEID = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySurveyPageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey questions where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @return the matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findBySurveyPageId(long surveyPageId)
		throws SystemException {
		return findBySurveyPageId(surveyPageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyPageId(long surveyPageId,
		int start, int end) throws SystemException {
		return findBySurveyPageId(surveyPageId, start, end, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyPageId(long surveyPageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyQuestion surveyQuestion : list) {
				if ((surveyPageId != surveyQuestion.getSurveyPageId())) {
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

			query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYPAGEID_SURVEYPAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyPageId);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Returns the first survey question in the ordered set where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findBySurveyPageId_First(long surveyPageId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyPageId_First(surveyPageId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the first survey question in the ordered set where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchBySurveyPageId_First(long surveyPageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyQuestion> list = findBySurveyPageId(surveyPageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion findBySurveyPageId_Last(long surveyPageId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyPageId_Last(surveyPageId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyPageId=");
		msg.append(surveyPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the last survey question in the ordered set where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchBySurveyPageId_Last(long surveyPageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySurveyPageId(surveyPageId);

		if (count == 0) {
			return null;
		}

		List<SurveyQuestion> list = findBySurveyPageId(surveyPageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion[] findBySurveyPageId_PrevAndNext(
		long surveyQuestionId, long surveyPageId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = findByPrimaryKey(surveyQuestionId);

		Session session = null;

		try {
			session = openSession();

			SurveyQuestion[] array = new SurveyQuestionImpl[3];

			array[0] = getBySurveyPageId_PrevAndNext(session, surveyQuestion,
					surveyPageId, orderByComparator, true);

			array[1] = surveyQuestion;

			array[2] = getBySurveyPageId_PrevAndNext(session, surveyQuestion,
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

	protected SurveyQuestion getBySurveyPageId_PrevAndNext(Session session,
		SurveyQuestion surveyQuestion, long surveyPageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

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
			query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyPageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey questions where surveyPageId = &#63; from the database.
	 *
	 * @param surveyPageId the survey page ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyPageId(long surveyPageId)
		throws SystemException {
		for (SurveyQuestion surveyQuestion : findBySurveyPageId(surveyPageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions where surveyPageId = &#63;.
	 *
	 * @param surveyPageId the survey page ID
	 * @return the number of matching survey questions
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

			query.append(_SQL_COUNT_SURVEYQUESTION_WHERE);

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

	private static final String _FINDER_COLUMN_SURVEYPAGEID_SURVEYPAGEID_2 = "surveyQuestion.surveyPageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			SurveyQuestionModelImpl.TYPE_COLUMN_BITMASK |
			SurveyQuestionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the survey questions where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findByType(String type)
		throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyQuestion> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
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
	@Override
	public List<SurveyQuestion> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyQuestion surveyQuestion : list) {
				if (!Validator.equals(type, surveyQuestion.getType())) {
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

			query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Returns the first survey question in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchByType_First(type,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the first survey question in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<SurveyQuestion> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchByType_Last(type, orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the last survey question in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<SurveyQuestion> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion[] findByType_PrevAndNext(long surveyQuestionId,
		String type, OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = findByPrimaryKey(surveyQuestionId);

		Session session = null;

		try {
			session = openSession();

			SurveyQuestion[] array = new SurveyQuestionImpl[3];

			array[0] = getByType_PrevAndNext(session, surveyQuestion, type,
					orderByComparator, true);

			array[1] = surveyQuestion;

			array[2] = getByType_PrevAndNext(session, surveyQuestion, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyQuestion getByType_PrevAndNext(Session session,
		SurveyQuestion surveyQuestion, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

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
			query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey questions where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(String type) throws SystemException {
		for (SurveyQuestion surveyQuestion : findByType(type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYQUESTION_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "surveyQuestion.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "surveyQuestion.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(surveyQuestion.type IS NULL OR surveyQuestion.type = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySurveyMainIdAndParentIdNotZero",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySurveyMainIdAndParentIdNotZero",
			new String[] { Long.class.getName() },
			SurveyQuestionModelImpl.SURVEYMAINID_COLUMN_BITMASK |
			SurveyQuestionModelImpl.NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SURVEYMAINIDANDPARENTIDNOTZERO =
		new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySurveyMainIdAndParentIdNotZero",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the survey questions where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId) throws SystemException {
		return findBySurveyMainIdAndParentIdNotZero(surveyMainId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId, int start, int end) throws SystemException {
		return findBySurveyMainIdAndParentIdNotZero(surveyMainId, start, end,
			null);
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
	@Override
	public List<SurveyQuestion> findBySurveyMainIdAndParentIdNotZero(
		long surveyMainId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO;
			finderArgs = new Object[] { surveyMainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO;
			finderArgs = new Object[] {
					surveyMainId,
					
					start, end, orderByComparator
				};
		}

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SurveyQuestion surveyQuestion : list) {
				if ((surveyMainId != surveyQuestion.getSurveyMainId())) {
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

			query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINIDANDPARENTIDNOTZERO_SURVEYMAINID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(surveyMainId);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Returns the first survey question in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findBySurveyMainIdAndParentIdNotZero_First(
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyMainIdAndParentIdNotZero_First(surveyMainId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the first survey question in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchBySurveyMainIdAndParentIdNotZero_First(
		long surveyMainId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SurveyQuestion> list = findBySurveyMainIdAndParentIdNotZero(surveyMainId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion findBySurveyMainIdAndParentIdNotZero_Last(
		long surveyMainId, OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchBySurveyMainIdAndParentIdNotZero_Last(surveyMainId,
				orderByComparator);

		if (surveyQuestion != null) {
			return surveyQuestion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("surveyMainId=");
		msg.append(surveyMainId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSurveyQuestionException(msg.toString());
	}

	/**
	 * Returns the last survey question in the ordered set where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching survey question, or <code>null</code> if a matching survey question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchBySurveyMainIdAndParentIdNotZero_Last(
		long surveyMainId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySurveyMainIdAndParentIdNotZero(surveyMainId);

		if (count == 0) {
			return null;
		}

		List<SurveyQuestion> list = findBySurveyMainIdAndParentIdNotZero(surveyMainId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SurveyQuestion[] findBySurveyMainIdAndParentIdNotZero_PrevAndNext(
		long surveyQuestionId, long surveyMainId,
		OrderByComparator orderByComparator)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = findByPrimaryKey(surveyQuestionId);

		Session session = null;

		try {
			session = openSession();

			SurveyQuestion[] array = new SurveyQuestionImpl[3];

			array[0] = getBySurveyMainIdAndParentIdNotZero_PrevAndNext(session,
					surveyQuestion, surveyMainId, orderByComparator, true);

			array[1] = surveyQuestion;

			array[2] = getBySurveyMainIdAndParentIdNotZero_PrevAndNext(session,
					surveyQuestion, surveyMainId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SurveyQuestion getBySurveyMainIdAndParentIdNotZero_PrevAndNext(
		Session session, SurveyQuestion surveyQuestion, long surveyMainId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SURVEYQUESTION_WHERE);

		query.append(_FINDER_COLUMN_SURVEYMAINIDANDPARENTIDNOTZERO_SURVEYMAINID_2);

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
			query.append(SurveyQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(surveyMainId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(surveyQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SurveyQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the survey questions where surveyMainId = &#63; from the database.
	 *
	 * @param surveyMainId the survey main ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySurveyMainIdAndParentIdNotZero(long surveyMainId)
		throws SystemException {
		for (SurveyQuestion surveyQuestion : findBySurveyMainIdAndParentIdNotZero(
				surveyMainId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions where surveyMainId = &#63;.
	 *
	 * @param surveyMainId the survey main ID
	 * @return the number of matching survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySurveyMainIdAndParentIdNotZero(long surveyMainId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SURVEYMAINIDANDPARENTIDNOTZERO;

		Object[] finderArgs = new Object[] { surveyMainId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SURVEYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_SURVEYMAINIDANDPARENTIDNOTZERO_SURVEYMAINID_2);

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

	private static final String _FINDER_COLUMN_SURVEYMAINIDANDPARENTIDNOTZERO_SURVEYMAINID_2 =
		"surveyQuestion.surveyMainId = ? AND surveyQuestion.parentId!=0";

	public SurveyQuestionPersistenceImpl() {
		setModelClass(SurveyQuestion.class);
	}

	/**
	 * Caches the survey question in the entity cache if it is enabled.
	 *
	 * @param surveyQuestion the survey question
	 */
	@Override
	public void cacheResult(SurveyQuestion surveyQuestion) {
		EntityCacheUtil.putResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey(),
			surveyQuestion);

		surveyQuestion.resetOriginalValues();
	}

	/**
	 * Caches the survey questions in the entity cache if it is enabled.
	 *
	 * @param surveyQuestions the survey questions
	 */
	@Override
	public void cacheResult(List<SurveyQuestion> surveyQuestions) {
		for (SurveyQuestion surveyQuestion : surveyQuestions) {
			if (EntityCacheUtil.getResult(
						SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
						SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey()) == null) {
				cacheResult(surveyQuestion);
			}
			else {
				surveyQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyQuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyQuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyQuestion surveyQuestion) {
		EntityCacheUtil.removeResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyQuestion> surveyQuestions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyQuestion surveyQuestion : surveyQuestions) {
			EntityCacheUtil.removeResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
				SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey question with the primary key. Does not add the survey question to the database.
	 *
	 * @param surveyQuestionId the primary key for the new survey question
	 * @return the new survey question
	 */
	@Override
	public SurveyQuestion create(long surveyQuestionId) {
		SurveyQuestion surveyQuestion = new SurveyQuestionImpl();

		surveyQuestion.setNew(true);
		surveyQuestion.setPrimaryKey(surveyQuestionId);

		return surveyQuestion;
	}

	/**
	 * Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyQuestionId the primary key of the survey question
	 * @return the survey question that was removed
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion remove(long surveyQuestionId)
		throws NoSuchSurveyQuestionException, SystemException {
		return remove((Serializable)surveyQuestionId);
	}

	/**
	 * Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey question
	 * @return the survey question that was removed
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion remove(Serializable primaryKey)
		throws NoSuchSurveyQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyQuestion surveyQuestion = (SurveyQuestion)session.get(SurveyQuestionImpl.class,
					primaryKey);

			if (surveyQuestion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyQuestion);
		}
		catch (NoSuchSurveyQuestionException nsee) {
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
	protected SurveyQuestion removeImpl(SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyQuestion = toUnwrappedModel(surveyQuestion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyQuestion)) {
				surveyQuestion = (SurveyQuestion)session.get(SurveyQuestionImpl.class,
						surveyQuestion.getPrimaryKeyObj());
			}

			if (surveyQuestion != null) {
				session.delete(surveyQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyQuestion != null) {
			clearCache(surveyQuestion);
		}

		return surveyQuestion;
	}

	@Override
	public SurveyQuestion updateImpl(
		com.lc.survey.model.SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyQuestion = toUnwrappedModel(surveyQuestion);

		boolean isNew = surveyQuestion.isNew();

		SurveyQuestionModelImpl surveyQuestionModelImpl = (SurveyQuestionModelImpl)surveyQuestion;

		Session session = null;

		try {
			session = openSession();

			if (surveyQuestion.isNew()) {
				session.save(surveyQuestion);

				surveyQuestion.setNew(false);
			}
			else {
				session.merge(surveyQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SurveyQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((surveyQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyQuestionModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { surveyQuestionModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((surveyQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyQuestionModelImpl.getOriginalSurveyPageId(),
						surveyQuestionModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYPAGEIDANDPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID,
					args);

				args = new Object[] {
						surveyQuestionModelImpl.getSurveyPageId(),
						surveyQuestionModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYPAGEIDANDPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEIDANDPARENTID,
					args);
			}

			if ((surveyQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyQuestionModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);

				args = new Object[] { surveyQuestionModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINID,
					args);
			}

			if ((surveyQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyQuestionModelImpl.getOriginalSurveyPageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYPAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID,
					args);

				args = new Object[] { surveyQuestionModelImpl.getSurveyPageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYPAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYPAGEID,
					args);
			}

			if ((surveyQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyQuestionModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { surveyQuestionModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((surveyQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						surveyQuestionModelImpl.getOriginalSurveyMainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINIDANDPARENTIDNOTZERO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO,
					args);

				args = new Object[] { surveyQuestionModelImpl.getSurveyMainId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SURVEYMAINIDANDPARENTIDNOTZERO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SURVEYMAINIDANDPARENTIDNOTZERO,
					args);
			}
		}

		EntityCacheUtil.putResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey(),
			surveyQuestion);

		return surveyQuestion;
	}

	protected SurveyQuestion toUnwrappedModel(SurveyQuestion surveyQuestion) {
		if (surveyQuestion instanceof SurveyQuestionImpl) {
			return surveyQuestion;
		}

		SurveyQuestionImpl surveyQuestionImpl = new SurveyQuestionImpl();

		surveyQuestionImpl.setNew(surveyQuestion.isNew());
		surveyQuestionImpl.setPrimaryKey(surveyQuestion.getPrimaryKey());

		surveyQuestionImpl.setSurveyQuestionId(surveyQuestion.getSurveyQuestionId());
		surveyQuestionImpl.setSurveyMainId(surveyQuestion.getSurveyMainId());
		surveyQuestionImpl.setSurveyPageId(surveyQuestion.getSurveyPageId());
		surveyQuestionImpl.setParentId(surveyQuestion.getParentId());
		surveyQuestionImpl.setNo(surveyQuestion.getNo());
		surveyQuestionImpl.setQuestion(surveyQuestion.getQuestion());
		surveyQuestionImpl.setType(surveyQuestion.getType());
		surveyQuestionImpl.setIsRequired(surveyQuestion.getIsRequired());
		surveyQuestionImpl.setHasOther(surveyQuestion.getHasOther());
		surveyQuestionImpl.setOptionDirect(surveyQuestion.getOptionDirect());
		surveyQuestionImpl.setPoints(surveyQuestion.getPoints());
		surveyQuestionImpl.setStarsCount(surveyQuestion.getStarsCount());
		surveyQuestionImpl.setUploadFileId(surveyQuestion.getUploadFileId());
		surveyQuestionImpl.setCreatorId(surveyQuestion.getCreatorId());
		surveyQuestionImpl.setModifierId(surveyQuestion.getModifierId());
		surveyQuestionImpl.setCreateDate(surveyQuestion.getCreateDate());
		surveyQuestionImpl.setModifiedDate(surveyQuestion.getModifiedDate());

		return surveyQuestionImpl;
	}

	/**
	 * Returns the survey question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey question
	 * @return the survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchByPrimaryKey(primaryKey);

		if (surveyQuestion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyQuestion;
	}

	/**
	 * Returns the survey question with the primary key or throws a {@link com.lc.survey.NoSuchSurveyQuestionException} if it could not be found.
	 *
	 * @param surveyQuestionId the primary key of the survey question
	 * @return the survey question
	 * @throws com.lc.survey.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findByPrimaryKey(long surveyQuestionId)
		throws NoSuchSurveyQuestionException, SystemException {
		return findByPrimaryKey((Serializable)surveyQuestionId);
	}

	/**
	 * Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey question
	 * @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyQuestion surveyQuestion = (SurveyQuestion)EntityCacheUtil.getResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
				SurveyQuestionImpl.class, primaryKey);

		if (surveyQuestion == _nullSurveyQuestion) {
			return null;
		}

		if (surveyQuestion == null) {
			Session session = null;

			try {
				session = openSession();

				surveyQuestion = (SurveyQuestion)session.get(SurveyQuestionImpl.class,
						primaryKey);

				if (surveyQuestion != null) {
					cacheResult(surveyQuestion);
				}
				else {
					EntityCacheUtil.putResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
						SurveyQuestionImpl.class, primaryKey,
						_nullSurveyQuestion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
					SurveyQuestionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyQuestion;
	}

	/**
	 * Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyQuestionId the primary key of the survey question
	 * @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByPrimaryKey(long surveyQuestionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)surveyQuestionId);
	}

	/**
	 * Returns all the survey questions.
	 *
	 * @return the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SurveyQuestion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SurveyQuestion> findAll(int start, int end,
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

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYQUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYQUESTION;

				if (pagination) {
					sql = sql.concat(SurveyQuestionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
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
	 * Removes all the survey questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyQuestion surveyQuestion : findAll()) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions.
	 *
	 * @return the number of survey questions
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYQUESTION);

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
	 * Initializes the survey question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lc.survey.model.SurveyQuestion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyQuestion>> listenersList = new ArrayList<ModelListener<SurveyQuestion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyQuestion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SurveyQuestionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SURVEYQUESTION = "SELECT surveyQuestion FROM SurveyQuestion surveyQuestion";
	private static final String _SQL_SELECT_SURVEYQUESTION_WHERE = "SELECT surveyQuestion FROM SurveyQuestion surveyQuestion WHERE ";
	private static final String _SQL_COUNT_SURVEYQUESTION = "SELECT COUNT(surveyQuestion) FROM SurveyQuestion surveyQuestion";
	private static final String _SQL_COUNT_SURVEYQUESTION_WHERE = "SELECT COUNT(surveyQuestion) FROM SurveyQuestion surveyQuestion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyQuestion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyQuestion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SurveyQuestion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyQuestionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static SurveyQuestion _nullSurveyQuestion = new SurveyQuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyQuestion> toCacheModel() {
				return _nullSurveyQuestionCacheModel;
			}
		};

	private static CacheModel<SurveyQuestion> _nullSurveyQuestionCacheModel = new CacheModel<SurveyQuestion>() {
			@Override
			public SurveyQuestion toEntityModel() {
				return _nullSurveyQuestion;
			}
		};
}