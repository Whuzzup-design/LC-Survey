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

import com.lc.survey.service.SurveyQuestionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author kevin
 * @generated
 */
public class SurveyQuestionLocalServiceClpInvoker {
	public SurveyQuestionLocalServiceClpInvoker() {
		_methodName0 = "addSurveyQuestion";

		_methodParameterTypes0 = new String[] {
				"com.lc.survey.model.SurveyQuestion"
			};

		_methodName1 = "createSurveyQuestion";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSurveyQuestion";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSurveyQuestion";

		_methodParameterTypes3 = new String[] {
				"com.lc.survey.model.SurveyQuestion"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSurveyQuestion";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSurveyQuestion";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSurveyQuestions";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSurveyQuestionsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSurveyQuestion";

		_methodParameterTypes15 = new String[] {
				"com.lc.survey.model.SurveyQuestion"
			};

		_methodName66 = "getBeanIdentifier";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "setBeanIdentifier";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName72 = "updateSurveyQuestion";

		_methodParameterTypes72 = new String[] {
				"com.lc.survey.model.SurveyQuestion", "long", "long", "long",
				"int", "java.lang.String", "java.lang.String", "boolean",
				"boolean", "boolean", "java.lang.String", "int", "long", "long",
				"long", "java.lang.String"
			};

		_methodName73 = "isExisted";

		_methodParameterTypes73 = new String[] { "long" };

		_methodName74 = "countByType";

		_methodParameterTypes74 = new String[] { "java.lang.String" };

		_methodName75 = "findByParentId";

		_methodParameterTypes75 = new String[] { "long" };

		_methodName76 = "findBySurveyPageIdAndParentId";

		_methodParameterTypes76 = new String[] { "long", "long" };

		_methodName77 = "findBySurveyPageId";

		_methodParameterTypes77 = new String[] { "long" };

		_methodName78 = "findBySurveyMainId";

		_methodParameterTypes78 = new String[] { "long" };

		_methodName79 = "findSubQuestionBySurveyMainId";

		_methodParameterTypes79 = new String[] { "long" };

		_methodName80 = "findByType";

		_methodParameterTypes80 = new String[] { "java.lang.String" };

		_methodName81 = "getTypeBySurveyQuestionId";

		_methodParameterTypes81 = new String[] { "long" };

		_methodName82 = "removeBySurveyMainId";

		_methodParameterTypes82 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.addSurveyQuestion((com.lc.survey.model.SurveyQuestion)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.createSurveyQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.deleteSurveyQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.deleteSurveyQuestion((com.lc.survey.model.SurveyQuestion)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.fetchSurveyQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.getSurveyQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.getSurveyQuestions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.getSurveyQuestionsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.updateSurveyQuestion((com.lc.survey.model.SurveyQuestion)arguments[0]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			SurveyQuestionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			SurveyQuestionLocalServiceUtil.updateSurveyQuestion((com.lc.survey.model.SurveyQuestion)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				((Boolean)arguments[8]).booleanValue(),
				((Boolean)arguments[9]).booleanValue(),
				(java.lang.String)arguments[10],
				((Integer)arguments[11]).intValue(),
				((Long)arguments[12]).longValue(),
				((Long)arguments[13]).longValue(),
				((Long)arguments[14]).longValue(),
				(java.lang.String)arguments[15]);

			return null;
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.isExisted(((Long)arguments[0]).longValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.countByType((java.lang.String)arguments[0]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.findByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.findBySurveyPageIdAndParentId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.findBySurveyPageId(((Long)arguments[0]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.findBySurveyMainId(((Long)arguments[0]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.findSubQuestionBySurveyMainId(((Long)arguments[0]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.findByType((java.lang.String)arguments[0]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SurveyQuestionLocalServiceUtil.getTypeBySurveyQuestionId(((Long)arguments[0]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			SurveyQuestionLocalServiceUtil.removeBySurveyMainId(((Long)arguments[0]).longValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
}