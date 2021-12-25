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

import com.lc.survey.model.SurveyFileClp;
import com.lc.survey.model.SurveyMainClp;
import com.lc.survey.model.SurveyOptionClp;
import com.lc.survey.model.SurveyPageClp;
import com.lc.survey.model.SurveyQuestionClp;
import com.lc.survey.model.SurveyResponseClp;
import com.lc.survey.model.SurveyResultClp;
import com.lc.survey.model.SurveyWriteSequenceClp;
import com.lc.survey.model.SurveyWriterClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"LC-Survey-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"LC-Survey-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "LC-Survey-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SurveyFileClp.class.getName())) {
			return translateInputSurveyFile(oldModel);
		}

		if (oldModelClassName.equals(SurveyMainClp.class.getName())) {
			return translateInputSurveyMain(oldModel);
		}

		if (oldModelClassName.equals(SurveyOptionClp.class.getName())) {
			return translateInputSurveyOption(oldModel);
		}

		if (oldModelClassName.equals(SurveyPageClp.class.getName())) {
			return translateInputSurveyPage(oldModel);
		}

		if (oldModelClassName.equals(SurveyQuestionClp.class.getName())) {
			return translateInputSurveyQuestion(oldModel);
		}

		if (oldModelClassName.equals(SurveyResponseClp.class.getName())) {
			return translateInputSurveyResponse(oldModel);
		}

		if (oldModelClassName.equals(SurveyResultClp.class.getName())) {
			return translateInputSurveyResult(oldModel);
		}

		if (oldModelClassName.equals(SurveyWriterClp.class.getName())) {
			return translateInputSurveyWriter(oldModel);
		}

		if (oldModelClassName.equals(SurveyWriteSequenceClp.class.getName())) {
			return translateInputSurveyWriteSequence(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputSurveyFile(BaseModel<?> oldModel) {
		SurveyFileClp oldClpModel = (SurveyFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyMain(BaseModel<?> oldModel) {
		SurveyMainClp oldClpModel = (SurveyMainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyMainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyOption(BaseModel<?> oldModel) {
		SurveyOptionClp oldClpModel = (SurveyOptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyOptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyPage(BaseModel<?> oldModel) {
		SurveyPageClp oldClpModel = (SurveyPageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyPageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyQuestion(BaseModel<?> oldModel) {
		SurveyQuestionClp oldClpModel = (SurveyQuestionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyQuestionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyResponse(BaseModel<?> oldModel) {
		SurveyResponseClp oldClpModel = (SurveyResponseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyResponseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyResult(BaseModel<?> oldModel) {
		SurveyResultClp oldClpModel = (SurveyResultClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyResultRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyWriter(BaseModel<?> oldModel) {
		SurveyWriterClp oldClpModel = (SurveyWriterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyWriterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyWriteSequence(
		BaseModel<?> oldModel) {
		SurveyWriteSequenceClp oldClpModel = (SurveyWriteSequenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyWriteSequenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.lc.survey.model.impl.SurveyFileImpl")) {
			return translateOutputSurveyFile(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lc.survey.model.impl.SurveyMainImpl")) {
			return translateOutputSurveyMain(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.lc.survey.model.impl.SurveyOptionImpl")) {
			return translateOutputSurveyOption(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals("com.lc.survey.model.impl.SurveyPageImpl")) {
			return translateOutputSurveyPage(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.lc.survey.model.impl.SurveyQuestionImpl")) {
			return translateOutputSurveyQuestion(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.lc.survey.model.impl.SurveyResponseImpl")) {
			return translateOutputSurveyResponse(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.lc.survey.model.impl.SurveyResultImpl")) {
			return translateOutputSurveyResult(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.lc.survey.model.impl.SurveyWriterImpl")) {
			return translateOutputSurveyWriter(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.lc.survey.model.impl.SurveyWriteSequenceImpl")) {
			return translateOutputSurveyWriteSequence(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyFileException")) {
			return new com.lc.survey.NoSuchSurveyFileException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyMainException")) {
			return new com.lc.survey.NoSuchSurveyMainException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyOptionException")) {
			return new com.lc.survey.NoSuchSurveyOptionException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyPageException")) {
			return new com.lc.survey.NoSuchSurveyPageException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyQuestionException")) {
			return new com.lc.survey.NoSuchSurveyQuestionException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyResponseException")) {
			return new com.lc.survey.NoSuchSurveyResponseException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyResultException")) {
			return new com.lc.survey.NoSuchSurveyResultException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyWriterException")) {
			return new com.lc.survey.NoSuchSurveyWriterException();
		}

		if (className.equals("com.lc.survey.NoSuchSurveyWriteSequenceException")) {
			return new com.lc.survey.NoSuchSurveyWriteSequenceException();
		}

		return throwable;
	}

	public static Object translateOutputSurveyFile(BaseModel<?> oldModel) {
		SurveyFileClp newModel = new SurveyFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyMain(BaseModel<?> oldModel) {
		SurveyMainClp newModel = new SurveyMainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyMainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyOption(BaseModel<?> oldModel) {
		SurveyOptionClp newModel = new SurveyOptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyOptionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyPage(BaseModel<?> oldModel) {
		SurveyPageClp newModel = new SurveyPageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyPageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyQuestion(BaseModel<?> oldModel) {
		SurveyQuestionClp newModel = new SurveyQuestionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyQuestionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyResponse(BaseModel<?> oldModel) {
		SurveyResponseClp newModel = new SurveyResponseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyResponseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyResult(BaseModel<?> oldModel) {
		SurveyResultClp newModel = new SurveyResultClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyResultRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyWriter(BaseModel<?> oldModel) {
		SurveyWriterClp newModel = new SurveyWriterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyWriterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyWriteSequence(
		BaseModel<?> oldModel) {
		SurveyWriteSequenceClp newModel = new SurveyWriteSequenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyWriteSequenceRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}