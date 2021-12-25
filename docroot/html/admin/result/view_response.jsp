<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	long writerId = ParamUtil.getLong(request, "writerId");
	List<SurveyResponse> s_responses = SurveyResponseLocalServiceUtil.findByWriterId(writerId);
%>

<style>

	.survey-response-content{
		padding: 10px 0;
		border-bottom: 1.5px solid #eee;
	}

</style>

<aui:layout>

	<%
		for(SurveyResponse s_response : s_responses){
	%>
		<div>
		
			<div class="survey-response-content">
			
				<%=s_response.getResponse() %>
			
			</div>
		
		</div>
	<%
		}
	%>

</aui:layout>