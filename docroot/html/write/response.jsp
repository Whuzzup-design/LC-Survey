<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/question.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/response.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long writerId = ParamUtil.getLong(request, "writerId");
	String color = ParamUtil.getString(request, "color");
%>

<style>
	
	.survey-write-textarea:FOCUS +.survey-write-textarea-baseline{
		background-color: <%=color %>;
	}
	
	.survey-step-btn:HOVER{
		color: <%=color %>;
		border-color: <%=color %>;
	}

</style>

<portlet:actionURL var="updateWriterResponseURL" name="updateWriterResponse">
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
	<portlet:param name="writerId" value="<%=String.valueOf(writerId) %>"/>
	<portlet:param name="color" value="<%=color %>"/>
</portlet:actionURL>

<aui:layout>
	
	<aui:form id="fm" action="${updateWriterResponseURL }">
	
		<div id="survey_reponse_container">
		
			<textarea id="<portlet:namespace/>survey_response_textarea" name="<portlet:namespace/>response" rows="1" class="survey-write-textarea"></textarea>
		
			<div class="survey-write-textarea-baseline"></div>
		
		</div>
	
	</aui:form>
	
	<div class="survey-step-btn-container">
				
		<span id="survey_update_btn" class="survey-step-btn">
		
			<i class="icon-ok"></i>
			
		</span>
		
	</div>
	
</aui:layout>

<aui:script use="survey-tips">
	
	var responseArea = $("#<portlet:namespace/>survey_response_textarea");
	var updateBtn = $("#survey_update_btn");
	
	var resizeTextArea = function(){
		
		responseArea.css({'height': 'auto'});
		
		responseArea.css({'height': responseArea.get(0).scrollHeight + "px"});
	}
	
	var limitResponseLength = function(){
		
		var responseVal = responseArea.val();
		
		if(responseVal.length > 400){
			
			var surveyAlert = new Liferay.SurveyAlertMessage(
				{
					message: '<i class="icon-warning-sign"></i>' + '<%=LanguageUtil.get(pageContext, "feedback-length-can-not-exceed-400") %>',
					status: "danger",
					autoClose: 2500
				}
			);
			surveyAlert.show();
			responseArea.val(responseVal.substring(0, 400));
		}
	}
	
	responseArea.on("input ", resizeTextArea);
	responseArea.on("input", limitResponseLength);
	
	updateBtn.on(
		"click", function(){
			
			if(responseArea.val() == ''){
				var surveyAlert = new Liferay.SurveyAlertMessage(
					{
						message: '<i class="icon-warning-sign"></i>' + '<%=LanguageUtil.get(pageContext, "please-input-feedback") %>',
						status: "info",
						autoClose: 2500
					}		
				);
				surveyAlert.show();
				return;
			}
			
			$("#<portlet:namespace/>fm").submit();
		}	
	);
	
	resizeTextArea();
	
</aui:script>