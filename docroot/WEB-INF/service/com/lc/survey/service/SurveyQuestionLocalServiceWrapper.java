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

package com.lc.survey.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SurveyQuestionLocalService}.
 *
 * @author kevin
 * @see SurveyQuestionLocalService
 * @generated
 */
public class SurveyQuestionLocalServiceWrapper
	implements SurveyQuestionLocalService,
		ServiceWrapper<SurveyQuestionLocalService> {
	public SurveyQuestionLocalServiceWrapper(
		SurveyQuestionLocalService surveyQuestionLocalService) {
		_surveyQuestionLocalService = surveyQuestionLocalService;
	}

	/**
	* Adds the survey question to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyQuestion addSurveyQuestion(
		com.lc.survey.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.addSurveyQuestion(surveyQuestion);
	}

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param surveyQuestionId the primary key for the new survey question
	* @return the new survey question
	*/
	@Override
	public com.lc.survey.model.SurveyQuestion createSurveyQuestion(
		long surveyQuestionId) {
		return _surveyQuestionLocalService.createSurveyQuestion(surveyQuestionId);
	}

	/**
	* Deletes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question that was removed
	* @throws PortalException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyQuestion deleteSurveyQuestion(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.deleteSurveyQuestion(surveyQuestionId);
	}

	/**
	* Deletes the survey question from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyQuestion deleteSurveyQuestion(
		com.lc.survey.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.deleteSurveyQuestion(surveyQuestion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyQuestionLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lc.survey.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.lc.survey.model.SurveyQuestion fetchSurveyQuestion(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.fetchSurveyQuestion(surveyQuestionId);
	}

	/**
	* Returns the survey question with the primary key.
	*
	* @param surveyQuestionId the primary key of the survey question
	* @return the survey question
	* @throws PortalException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyQuestion getSurveyQuestion(
		long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyQuestion(surveyQuestionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.lc.survey.model.SurveyQuestion> getSurveyQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyQuestions(start, end);
	}

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyQuestionsCount();
	}

	/**
	* Updates the survey question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.lc.survey.model.SurveyQuestion updateSurveyQuestion(
		com.lc.survey.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.updateSurveyQuestion(surveyQuestion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyQuestionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyQuestionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyQuestionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateSurveyQuestion(
		com.lc.survey.model.SurveyQuestion surveyQuestion, long surveyMainId,
		long surveyPageId, long parentId, int no, java.lang.String question,
		java.lang.String type, boolean isRequired, boolean hasOther,
		boolean optionDirect, java.lang.String points, int starsCount,
		long uploadFileId, long userId, long modifiedDate,
		java.lang.String action)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.updateSurveyQuestion(surveyQuestion,
			surveyMainId, surveyPageId, parentId, no, question, type,
			isRequired, hasOther, optionDirect, points, starsCount,
			uploadFileId, userId, modifiedDate, action);
	}

	@Override
	public boolean isExisted(long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.isExisted(surveyQuestionId);
	}

	@Override
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.countByType(type);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.findByParentId(parentId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageIdAndParentId(
		long surveyPageId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.findBySurveyPageIdAndParentId(surveyPageId,
			parentId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyPageId(
		long surveyPageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.findBySurveyPageId(surveyPageId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyQuestion> findBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.findBySurveyMainId(surveyMainId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyQuestion> findSubQuestionBySurveyMainId(
		long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.findSubQuestionBySurveyMainId(surveyMainId);
	}

	@Override
	public java.util.List<com.lc.survey.model.SurveyQuestion> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.findByType(type);
	}

	@Override
	public java.lang.String getTypeBySurveyQuestionId(long surveyQuestionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getTypeBySurveyQuestionId(surveyQuestionId);
	}

	@Override
	public void removeBySurveyMainId(long surveyMainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.removeBySurveyMainId(surveyMainId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyQuestionLocalService getWrappedSurveyQuestionLocalService() {
		return _surveyQuestionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyQuestionLocalService(
		SurveyQuestionLocalService surveyQuestionLocalService) {
		_surveyQuestionLocalService = surveyQuestionLocalService;
	}

	@Override
	public SurveyQuestionLocalService getWrappedService() {
		return _surveyQuestionLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyQuestionLocalService surveyQuestionLocalService) {
		_surveyQuestionLocalService = surveyQuestionLocalService;
	}

	private SurveyQuestionLocalService _surveyQuestionLocalService;
}