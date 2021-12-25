<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long randomNumber = ParamUtil.getLong(request, "randomNumber");
	
	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
	List<SurveyPage> s_pages = SurveyPageLocalServiceUtil.findBySurveyMainId(mainId);
%>

<div id="survey_setting_arch" class="survey-architecture-item">
			
	<i class="icon-cog"></i>
	
	<span class="survey-page-text"><%=s_main.getTitle() %></span>
	
</div>

<div class="survey-page-architecture-container">

<%
	for(SurveyPage s_page : s_pages){
		
		List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil
				.findBySurveyPageIdAndParentId(s_page.getSurveyPageId(), 0);
%>
	<div id="<%=SurveyConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + (randomNumber * s_page.getSurveyPageId()) %>" 
		class="survey-architecture-item survey-page-architecture" data-page-sort="<%=s_page.getNo() %>">
		
		<i class="icon-chevron-sign-right page-collapse-btn"></i>
		
		<span class="survey-page-text"><%=s_page.getTitle() %></span>
		
		<div class="survey-ques-architecture-container">
		
			<%
				for(SurveyQuestion s_question : s_questions){
			%>
				<div id="<%=SurveyConstants.SURVEY_QUESTION_ARCHITECTURE_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" 
					class="survey-architecture-item survey-ques-architecture"  data-question-sort="<%=s_question.getNo() %>">
				
					<%=s_question.getQuestion() %>
					
				</div>
			<%
				}
			%>
		
		</div>
	
	</div>			
<%
	}
%>

</div>