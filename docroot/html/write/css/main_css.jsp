<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	String color = ParamUtil.getString(request, "color");
	String backgroundColor = SurveyUtils.getDilutedColor(color, "0.5");
%>

<style>

	.aui{
		background-color: <%=backgroundColor %>;
	}
	
	#survey_write_layout{
		background-color: <%=backgroundColor %>;
	}
	
	.survey-write-container-header{
		background-color: <%=color %>;
	}
	
	.survey-step-btn:HOVER{
		color: <%=color %>;
		border-color: <%=color %>;
	}
	
</style>