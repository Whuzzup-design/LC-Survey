<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/question.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");

	long randomNumber = SurveyUtils.randomNumber();

	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
	List<SurveyPage> s_pages = SurveyPageLocalServiceUtil.findBySurveyMainId(mainId);
%>

<style>
	
	.survey-write-container-header {
		background-color: <%=s_main.getColor() %>;
	}
	
</style>

<liferay-util:include page="/html/write/css/question_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=s_main.getColor() %>"/>
</liferay-util:include>

<%
	for(SurveyPage s_page : s_pages){
		
		if(SurveyPageLocalServiceUtil.getChoiceQuestionCountsByPageId(s_page.getSurveyPageId()) == 0)
			continue;
		
		List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil.findBySurveyPageIdAndParentId(s_page.getSurveyPageId(), 0);
%>
	<div class="survey-write-container">
			
		<div class="survey-write-container-header">
		
			<p><%=SurveyUtils.getOrdinalNumber(s_page.getNo()) %></p>
			
		</div>
	
		<div class="survey-write-container-body">
			
			<div class="survey-write-page"><%=s_page.getTitle() %></div>
			
			<%
				for(SurveyQuestion s_question : s_questions){
					
					if(s_question.getType().equals(SurveyConstants.QUESTION_TYPE_TEXT) 
						|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DATE)
						|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_STAR))
						continue;
			%>
				<div id='<%="survey_write_question_" + s_question.getNo() %>' class="survey-write-question <%=s_question.getType() %>">
				
					<div class="survey-write-question-no">
					
						<%=s_question.getNo() %>
						
					</div>
					
					<div class="survey-write-question-content">
					
						<div class="survey-write-question-title"><%=s_question.getQuestion() %></div>
						
						<div class="survey-result-chart-container">
							
							<c:if test="<%=!s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) 
								&& !s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE) %>">
							
								<canvas id='<%=SurveyConstants.SURVEY_RESULT_CHART_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>' 
									width="700" height="<%=SurveyUtils.calculateCanvasHeight(s_question.getSurveyQuestionId()) %>"></canvas>
								
							</c:if>
							
							<c:if test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) 
								|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE) %>">
							
								<%
									List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil.findByParentId(s_question.getSurveyQuestionId());
								
									for(SurveyQuestion sub_question : sub_questions){
								%>
									<p><%=sub_question.getQuestion() %></p>
									
									<canvas id='<%=SurveyConstants.SURVEY_RESULT_CHART_ITEM_NAMESPACE + (randomNumber * sub_question.getSurveyQuestionId()) %>' 
										width="700" height="<%=SurveyUtils.calculateCanvasHeight(s_question.getSurveyQuestionId()) %>"></canvas>
								<%
									}
								%>
							
							</c:if>
							
						</div>
					
					</div>
				
				</div>
			<%
				}
			%>
			
		</div>
		
	</div>
<%
	}
%>

<aui:script use="survey-charts">
	
	<%
		for(SurveyPage s_page : s_pages){
			
			if(SurveyPageLocalServiceUtil.getChoiceQuestionCountsByPageId(s_page.getSurveyPageId()) == 0)
				continue;
			
			List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil.findBySurveyPageIdAndParentId(s_page.getSurveyPageId(), 0);
			
			for(SurveyQuestion s_question : s_questions){
				
				if(s_question.getType().equals(SurveyConstants.QUESTION_TYPE_TEXT) 
					|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DATE)
					|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_STAR))
					continue;
				
				List<SurveyOption> s_options = SurveyOptionLocalServiceUtil.findBySurveyQuestionId(s_question.getSurveyQuestionId());
				
				if(!s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) 
					&& !s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)){
	%>
					new Liferay.SurveyChart(
						{
							container: '<%=SurveyConstants.SURVEY_RESULT_CHART_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>',
							data: [
								<%
									for(SurveyOption s_option : s_options){
										
										int amount = SurveyResultLocalServiceUtil.countByQ_O(s_question.getSurveyQuestionId(), s_option.getSurveyOptionId());
								%>
									{
										text: '<%=s_option.getOption() %>',
										amount: <%=amount %>
									},
								<%
									}
									if(s_question.getHasOther()){
										
										int amount = SurveyResultLocalServiceUtil.countByQ_O(s_question.getSurveyQuestionId(), -1);
								%>
									{
										text: '<%=LanguageUtil.get(pageContext, "other") %>',
										amount: <%=amount %>
									},
								<%
									}
								%>
							]
						}	
					).show();
	<%
				}else{
					
					List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil.findByParentId(s_question.getSurveyQuestionId());
					
					for(SurveyQuestion sub_question : sub_questions){
	%>
						new Liferay.SurveyChart(
								{
									container: '<%=SurveyConstants.SURVEY_RESULT_CHART_ITEM_NAMESPACE + (randomNumber * sub_question.getSurveyQuestionId()) %>',
									data: [
										<%
											for(SurveyOption s_option : s_options){
												
												int amount = SurveyResultLocalServiceUtil.countByQ_O(sub_question.getSurveyQuestionId(), s_option.getSurveyOptionId());
										%>
											{
												text: '<%=s_option.getOption() %>',
												amount: <%=amount %>
											},
										<%
											}
										%>
									]
								}	
						).show();
	<%
					}
				}
			}
		}
	%>
	
</aui:script>