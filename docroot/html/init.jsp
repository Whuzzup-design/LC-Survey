<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@page import="com.lc.survey.model.SurveyMain"%>
<%@page import="com.lc.survey.model.SurveyPage"%>
<%@page import="com.lc.survey.model.SurveyQuestion"%>
<%@page import="com.lc.survey.model.SurveyOption"%>
<%@page import="com.lc.survey.model.SurveyFile"%>
<%@page import="com.lc.survey.model.SurveyWriter"%>
<%@page import="com.lc.survey.model.SurveyResult"%>
<%@page import="com.lc.survey.model.SurveyResponse"%>

<%@page import="com.lc.survey.service.SurveyMainLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyPageLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyQuestionLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyOptionLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyFileLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyWriterLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyResultLocalServiceUtil"%>
<%@page import="com.lc.survey.service.SurveyResponseLocalServiceUtil"%>

<%@page import="com.lc.survey.utils.SurveyUtils"%>
<%@page import="com.lc.survey.utils.SurveyConstants"%>
<%@page import="com.lc.survey.utils.SurveyResultUtils"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@page import="com.liferay.portal.model.CompanyConstants"%>

<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />
123
<%
	PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest
			, liferayPortletResponse);
	String currentURL = currentURLObj.toString();
	
	DateFormat _ymd = new SimpleDateFormat("yyyy-MM-dd");
%>