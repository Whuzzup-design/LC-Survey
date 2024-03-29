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

package com.lc.survey.service.base;

import com.lc.survey.model.SurveyMain;
import com.lc.survey.service.SurveyMainLocalService;
import com.lc.survey.service.persistence.SurveyFilePersistence;
import com.lc.survey.service.persistence.SurveyMainFinder;
import com.lc.survey.service.persistence.SurveyMainPersistence;
import com.lc.survey.service.persistence.SurveyOptionPersistence;
import com.lc.survey.service.persistence.SurveyPagePersistence;
import com.lc.survey.service.persistence.SurveyQuestionPersistence;
import com.lc.survey.service.persistence.SurveyResponsePersistence;
import com.lc.survey.service.persistence.SurveyResultPersistence;
import com.lc.survey.service.persistence.SurveyWriteSequencePersistence;
import com.lc.survey.service.persistence.SurveyWriterPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the survey main local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.lc.survey.service.impl.SurveyMainLocalServiceImpl}.
 * </p>
 *
 * @author kevin
 * @see com.lc.survey.service.impl.SurveyMainLocalServiceImpl
 * @see com.lc.survey.service.SurveyMainLocalServiceUtil
 * @generated
 */
public abstract class SurveyMainLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SurveyMainLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.lc.survey.service.SurveyMainLocalServiceUtil} to access the survey main local service.
	 */

	/**
	 * Adds the survey main to the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyMain the survey main
	 * @return the survey main that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SurveyMain addSurveyMain(SurveyMain surveyMain)
		throws SystemException {
		surveyMain.setNew(true);

		return surveyMainPersistence.update(surveyMain);
	}

	/**
	 * Creates a new survey main with the primary key. Does not add the survey main to the database.
	 *
	 * @param surveyMainId the primary key for the new survey main
	 * @return the new survey main
	 */
	@Override
	public SurveyMain createSurveyMain(long surveyMainId) {
		return surveyMainPersistence.create(surveyMainId);
	}

	/**
	 * Deletes the survey main with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyMainId the primary key of the survey main
	 * @return the survey main that was removed
	 * @throws PortalException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SurveyMain deleteSurveyMain(long surveyMainId)
		throws PortalException, SystemException {
		return surveyMainPersistence.remove(surveyMainId);
	}

	/**
	 * Deletes the survey main from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyMain the survey main
	 * @return the survey main that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SurveyMain deleteSurveyMain(SurveyMain surveyMain)
		throws SystemException {
		return surveyMainPersistence.remove(surveyMain);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SurveyMain.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return surveyMainPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return surveyMainPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyMainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return surveyMainPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return surveyMainPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return surveyMainPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SurveyMain fetchSurveyMain(long surveyMainId)
		throws SystemException {
		return surveyMainPersistence.fetchByPrimaryKey(surveyMainId);
	}

	/**
	 * Returns the survey main with the primary key.
	 *
	 * @param surveyMainId the primary key of the survey main
	 * @return the survey main
	 * @throws PortalException if a survey main with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyMain getSurveyMain(long surveyMainId)
		throws PortalException, SystemException {
		return surveyMainPersistence.findByPrimaryKey(surveyMainId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return surveyMainPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<SurveyMain> getSurveyMains(int start, int end)
		throws SystemException {
		return surveyMainPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of survey mains.
	 *
	 * @return the number of survey mains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSurveyMainsCount() throws SystemException {
		return surveyMainPersistence.countAll();
	}

	/**
	 * Updates the survey main in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param surveyMain the survey main
	 * @return the survey main that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SurveyMain updateSurveyMain(SurveyMain surveyMain)
		throws SystemException {
		return surveyMainPersistence.update(surveyMain);
	}

	/**
	 * Returns the survey file local service.
	 *
	 * @return the survey file local service
	 */
	public com.lc.survey.service.SurveyFileLocalService getSurveyFileLocalService() {
		return surveyFileLocalService;
	}

	/**
	 * Sets the survey file local service.
	 *
	 * @param surveyFileLocalService the survey file local service
	 */
	public void setSurveyFileLocalService(
		com.lc.survey.service.SurveyFileLocalService surveyFileLocalService) {
		this.surveyFileLocalService = surveyFileLocalService;
	}

	/**
	 * Returns the survey file persistence.
	 *
	 * @return the survey file persistence
	 */
	public SurveyFilePersistence getSurveyFilePersistence() {
		return surveyFilePersistence;
	}

	/**
	 * Sets the survey file persistence.
	 *
	 * @param surveyFilePersistence the survey file persistence
	 */
	public void setSurveyFilePersistence(
		SurveyFilePersistence surveyFilePersistence) {
		this.surveyFilePersistence = surveyFilePersistence;
	}

	/**
	 * Returns the survey main local service.
	 *
	 * @return the survey main local service
	 */
	public com.lc.survey.service.SurveyMainLocalService getSurveyMainLocalService() {
		return surveyMainLocalService;
	}

	/**
	 * Sets the survey main local service.
	 *
	 * @param surveyMainLocalService the survey main local service
	 */
	public void setSurveyMainLocalService(
		com.lc.survey.service.SurveyMainLocalService surveyMainLocalService) {
		this.surveyMainLocalService = surveyMainLocalService;
	}

	/**
	 * Returns the survey main persistence.
	 *
	 * @return the survey main persistence
	 */
	public SurveyMainPersistence getSurveyMainPersistence() {
		return surveyMainPersistence;
	}

	/**
	 * Sets the survey main persistence.
	 *
	 * @param surveyMainPersistence the survey main persistence
	 */
	public void setSurveyMainPersistence(
		SurveyMainPersistence surveyMainPersistence) {
		this.surveyMainPersistence = surveyMainPersistence;
	}

	/**
	 * Returns the survey main finder.
	 *
	 * @return the survey main finder
	 */
	public SurveyMainFinder getSurveyMainFinder() {
		return surveyMainFinder;
	}

	/**
	 * Sets the survey main finder.
	 *
	 * @param surveyMainFinder the survey main finder
	 */
	public void setSurveyMainFinder(SurveyMainFinder surveyMainFinder) {
		this.surveyMainFinder = surveyMainFinder;
	}

	/**
	 * Returns the survey option local service.
	 *
	 * @return the survey option local service
	 */
	public com.lc.survey.service.SurveyOptionLocalService getSurveyOptionLocalService() {
		return surveyOptionLocalService;
	}

	/**
	 * Sets the survey option local service.
	 *
	 * @param surveyOptionLocalService the survey option local service
	 */
	public void setSurveyOptionLocalService(
		com.lc.survey.service.SurveyOptionLocalService surveyOptionLocalService) {
		this.surveyOptionLocalService = surveyOptionLocalService;
	}

	/**
	 * Returns the survey option persistence.
	 *
	 * @return the survey option persistence
	 */
	public SurveyOptionPersistence getSurveyOptionPersistence() {
		return surveyOptionPersistence;
	}

	/**
	 * Sets the survey option persistence.
	 *
	 * @param surveyOptionPersistence the survey option persistence
	 */
	public void setSurveyOptionPersistence(
		SurveyOptionPersistence surveyOptionPersistence) {
		this.surveyOptionPersistence = surveyOptionPersistence;
	}

	/**
	 * Returns the survey page local service.
	 *
	 * @return the survey page local service
	 */
	public com.lc.survey.service.SurveyPageLocalService getSurveyPageLocalService() {
		return surveyPageLocalService;
	}

	/**
	 * Sets the survey page local service.
	 *
	 * @param surveyPageLocalService the survey page local service
	 */
	public void setSurveyPageLocalService(
		com.lc.survey.service.SurveyPageLocalService surveyPageLocalService) {
		this.surveyPageLocalService = surveyPageLocalService;
	}

	/**
	 * Returns the survey page persistence.
	 *
	 * @return the survey page persistence
	 */
	public SurveyPagePersistence getSurveyPagePersistence() {
		return surveyPagePersistence;
	}

	/**
	 * Sets the survey page persistence.
	 *
	 * @param surveyPagePersistence the survey page persistence
	 */
	public void setSurveyPagePersistence(
		SurveyPagePersistence surveyPagePersistence) {
		this.surveyPagePersistence = surveyPagePersistence;
	}

	/**
	 * Returns the survey question local service.
	 *
	 * @return the survey question local service
	 */
	public com.lc.survey.service.SurveyQuestionLocalService getSurveyQuestionLocalService() {
		return surveyQuestionLocalService;
	}

	/**
	 * Sets the survey question local service.
	 *
	 * @param surveyQuestionLocalService the survey question local service
	 */
	public void setSurveyQuestionLocalService(
		com.lc.survey.service.SurveyQuestionLocalService surveyQuestionLocalService) {
		this.surveyQuestionLocalService = surveyQuestionLocalService;
	}

	/**
	 * Returns the survey question persistence.
	 *
	 * @return the survey question persistence
	 */
	public SurveyQuestionPersistence getSurveyQuestionPersistence() {
		return surveyQuestionPersistence;
	}

	/**
	 * Sets the survey question persistence.
	 *
	 * @param surveyQuestionPersistence the survey question persistence
	 */
	public void setSurveyQuestionPersistence(
		SurveyQuestionPersistence surveyQuestionPersistence) {
		this.surveyQuestionPersistence = surveyQuestionPersistence;
	}

	/**
	 * Returns the survey response local service.
	 *
	 * @return the survey response local service
	 */
	public com.lc.survey.service.SurveyResponseLocalService getSurveyResponseLocalService() {
		return surveyResponseLocalService;
	}

	/**
	 * Sets the survey response local service.
	 *
	 * @param surveyResponseLocalService the survey response local service
	 */
	public void setSurveyResponseLocalService(
		com.lc.survey.service.SurveyResponseLocalService surveyResponseLocalService) {
		this.surveyResponseLocalService = surveyResponseLocalService;
	}

	/**
	 * Returns the survey response persistence.
	 *
	 * @return the survey response persistence
	 */
	public SurveyResponsePersistence getSurveyResponsePersistence() {
		return surveyResponsePersistence;
	}

	/**
	 * Sets the survey response persistence.
	 *
	 * @param surveyResponsePersistence the survey response persistence
	 */
	public void setSurveyResponsePersistence(
		SurveyResponsePersistence surveyResponsePersistence) {
		this.surveyResponsePersistence = surveyResponsePersistence;
	}

	/**
	 * Returns the survey result local service.
	 *
	 * @return the survey result local service
	 */
	public com.lc.survey.service.SurveyResultLocalService getSurveyResultLocalService() {
		return surveyResultLocalService;
	}

	/**
	 * Sets the survey result local service.
	 *
	 * @param surveyResultLocalService the survey result local service
	 */
	public void setSurveyResultLocalService(
		com.lc.survey.service.SurveyResultLocalService surveyResultLocalService) {
		this.surveyResultLocalService = surveyResultLocalService;
	}

	/**
	 * Returns the survey result persistence.
	 *
	 * @return the survey result persistence
	 */
	public SurveyResultPersistence getSurveyResultPersistence() {
		return surveyResultPersistence;
	}

	/**
	 * Sets the survey result persistence.
	 *
	 * @param surveyResultPersistence the survey result persistence
	 */
	public void setSurveyResultPersistence(
		SurveyResultPersistence surveyResultPersistence) {
		this.surveyResultPersistence = surveyResultPersistence;
	}

	/**
	 * Returns the survey writer local service.
	 *
	 * @return the survey writer local service
	 */
	public com.lc.survey.service.SurveyWriterLocalService getSurveyWriterLocalService() {
		return surveyWriterLocalService;
	}

	/**
	 * Sets the survey writer local service.
	 *
	 * @param surveyWriterLocalService the survey writer local service
	 */
	public void setSurveyWriterLocalService(
		com.lc.survey.service.SurveyWriterLocalService surveyWriterLocalService) {
		this.surveyWriterLocalService = surveyWriterLocalService;
	}

	/**
	 * Returns the survey writer persistence.
	 *
	 * @return the survey writer persistence
	 */
	public SurveyWriterPersistence getSurveyWriterPersistence() {
		return surveyWriterPersistence;
	}

	/**
	 * Sets the survey writer persistence.
	 *
	 * @param surveyWriterPersistence the survey writer persistence
	 */
	public void setSurveyWriterPersistence(
		SurveyWriterPersistence surveyWriterPersistence) {
		this.surveyWriterPersistence = surveyWriterPersistence;
	}

	/**
	 * Returns the survey write sequence local service.
	 *
	 * @return the survey write sequence local service
	 */
	public com.lc.survey.service.SurveyWriteSequenceLocalService getSurveyWriteSequenceLocalService() {
		return surveyWriteSequenceLocalService;
	}

	/**
	 * Sets the survey write sequence local service.
	 *
	 * @param surveyWriteSequenceLocalService the survey write sequence local service
	 */
	public void setSurveyWriteSequenceLocalService(
		com.lc.survey.service.SurveyWriteSequenceLocalService surveyWriteSequenceLocalService) {
		this.surveyWriteSequenceLocalService = surveyWriteSequenceLocalService;
	}

	/**
	 * Returns the survey write sequence persistence.
	 *
	 * @return the survey write sequence persistence
	 */
	public SurveyWriteSequencePersistence getSurveyWriteSequencePersistence() {
		return surveyWriteSequencePersistence;
	}

	/**
	 * Sets the survey write sequence persistence.
	 *
	 * @param surveyWriteSequencePersistence the survey write sequence persistence
	 */
	public void setSurveyWriteSequencePersistence(
		SurveyWriteSequencePersistence surveyWriteSequencePersistence) {
		this.surveyWriteSequencePersistence = surveyWriteSequencePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.lc.survey.model.SurveyMain",
			surveyMainLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.lc.survey.model.SurveyMain");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SurveyMain.class;
	}

	protected String getModelClassName() {
		return SurveyMain.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = surveyMainPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.lc.survey.service.SurveyFileLocalService.class)
	protected com.lc.survey.service.SurveyFileLocalService surveyFileLocalService;
	@BeanReference(type = SurveyFilePersistence.class)
	protected SurveyFilePersistence surveyFilePersistence;
	@BeanReference(type = com.lc.survey.service.SurveyMainLocalService.class)
	protected com.lc.survey.service.SurveyMainLocalService surveyMainLocalService;
	@BeanReference(type = SurveyMainPersistence.class)
	protected SurveyMainPersistence surveyMainPersistence;
	@BeanReference(type = SurveyMainFinder.class)
	protected SurveyMainFinder surveyMainFinder;
	@BeanReference(type = com.lc.survey.service.SurveyOptionLocalService.class)
	protected com.lc.survey.service.SurveyOptionLocalService surveyOptionLocalService;
	@BeanReference(type = SurveyOptionPersistence.class)
	protected SurveyOptionPersistence surveyOptionPersistence;
	@BeanReference(type = com.lc.survey.service.SurveyPageLocalService.class)
	protected com.lc.survey.service.SurveyPageLocalService surveyPageLocalService;
	@BeanReference(type = SurveyPagePersistence.class)
	protected SurveyPagePersistence surveyPagePersistence;
	@BeanReference(type = com.lc.survey.service.SurveyQuestionLocalService.class)
	protected com.lc.survey.service.SurveyQuestionLocalService surveyQuestionLocalService;
	@BeanReference(type = SurveyQuestionPersistence.class)
	protected SurveyQuestionPersistence surveyQuestionPersistence;
	@BeanReference(type = com.lc.survey.service.SurveyResponseLocalService.class)
	protected com.lc.survey.service.SurveyResponseLocalService surveyResponseLocalService;
	@BeanReference(type = SurveyResponsePersistence.class)
	protected SurveyResponsePersistence surveyResponsePersistence;
	@BeanReference(type = com.lc.survey.service.SurveyResultLocalService.class)
	protected com.lc.survey.service.SurveyResultLocalService surveyResultLocalService;
	@BeanReference(type = SurveyResultPersistence.class)
	protected SurveyResultPersistence surveyResultPersistence;
	@BeanReference(type = com.lc.survey.service.SurveyWriterLocalService.class)
	protected com.lc.survey.service.SurveyWriterLocalService surveyWriterLocalService;
	@BeanReference(type = SurveyWriterPersistence.class)
	protected SurveyWriterPersistence surveyWriterPersistence;
	@BeanReference(type = com.lc.survey.service.SurveyWriteSequenceLocalService.class)
	protected com.lc.survey.service.SurveyWriteSequenceLocalService surveyWriteSequenceLocalService;
	@BeanReference(type = SurveyWriteSequencePersistence.class)
	protected SurveyWriteSequencePersistence surveyWriteSequencePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SurveyMainLocalServiceClpInvoker _clpInvoker = new SurveyMainLocalServiceClpInvoker();
}