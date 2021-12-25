<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	String color = ParamUtil.getString(request, "color");
%>

<style>
	
	.survey-write-question-no {
		background-color: <%=color %>;
	}
	
	.survey-write-textarea:FOCUS +.survey-write-textarea-baseline {
		background-color: <%=color %>;
	}
	
	.survey-write-single-choice .survey-hidden-input:checked ~ .survey-write-single-choice-checkmark-container {
		border-color: <%=color %>;
		background-color: <%=color %>;
	}
	
	.survey-write-checkbox .survey-hidden-input:checked ~ .survey-write-checkbox-checkmark-container {
		border-color: <%=color %>;
	}
	
	.survey-write-checkbox .survey-hidden-input:checked ~ .survey-write-checkbox-checkmark-container .survey-write-checkbox-checkmark {
		background-color: <%=color %>;
	}
	
	.survey-dropdown-option-container label:HOVER {
		background-color: <%=color %>;
		border-color: <%=color %>;
	}
	
	.survey-write-star i {
		color: <%=color %>; 
	}
	
	.single-choice-lattice table tr:nth-of-type(odd) {
		background-color: <%=SurveyUtils.getDilutedColor(color, "0.15") %>;
	}
	
	.checkbox-lattice table tr:nth-of-type(odd) {
		background-color: <%=SurveyUtils.getDilutedColor(color, "0.15") %>;
	}
	
	.survey-correct-container {
		background-color: <%=SurveyUtils.getCorrectAreaBackgroundColor(color) %> !important;
		border-color: <%=SurveyUtils.getCorrectAreaBackgroundColor(color) %> !important;
	}
	
</style>