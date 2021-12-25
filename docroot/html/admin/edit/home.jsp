<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/admin/edit/edit.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long randomNumber = SurveyUtils.randomNumber();
	
	List<SurveyPage> s_pages = SurveyPageLocalServiceUtil.findBySurveyMainId(mainId);
	List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil.findBySurveyMainId(mainId);
	List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil.findSubQuestionBySurveyMainId(mainId);
	List<SurveyOption> s_options = SurveyOptionLocalServiceUtil.findBySurveyMainId(mainId);
%>

<aui:layout>

	<div id="survey_update_layout">
		
		<div class="survey-architecture-container survey-architecture-container-extend">
			
			<liferay-util:include page="/html/admin/edit/architecture.jsp" servletContext="<%=this.getServletContext() %>">
				<liferay-util:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
				<liferay-util:param name="randomNumber" value="<%=String.valueOf(randomNumber) %>"/>
			</liferay-util:include>
		
		</div>
		
		<div class="survey-page-container">
			
			<div class="survey-edit-tool-bar">
			
				<div id="toggle_architecture_btn" class="survey-edit-tool-btn show-tips close-architecture-btn" data-tips="<%=LanguageUtil.get(pageContext, "collapse") %>">
				
					<i class="icon-arrow-left"></i>
				
				</div>
				
				<div id="tool_bar_collapse_btn" class="survey-edit-tool-btn show-tips" data-tips="<%=LanguageUtil.get(pageContext, "tool-bar") %>">
				
					<i class="icon-wrench"></i>
				
				</div>
				
			</div>
			
			<liferay-util:include page="/html/admin/edit/setting.jsp" servletContext="<%=this.getServletContext() %>">
				<liferay-util:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
			</liferay-util:include>
			
			<liferay-util:include page="/html/admin/edit/page.jsp" servletContext="<%=this.getServletContext() %>">
				<liferay-util:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
				<liferay-util:param name="randomNumber" value="<%=String.valueOf(randomNumber) %>"/>
			</liferay-util:include>
		
		</div>
		
	</div>

</aui:layout>

<aui:script use="survey-tips,survey-instance,survey-conponents">
	
	Liferay.SurveyInstanceConstants.SURVEY_TODAY_DATE = '<%=_ymd.format(new Date()) %>';
	
	Liferay.SurveyToolConstants.SURVEY_MAIN_ID = <%=mainId %>;
	Liferay.SurveyToolConstants.bindWindowCloseTool();
	
	new Liferay.SurveyTips(
		{
			trigger: '.show-tips, .survey-question-tool-btn, .survey-option-tool-btn, .survey-sub-question-tool-btn, .survey-answer'
		}		
	);
	
	<%
		for(SurveyPage s_page : s_pages){
			long pageDirectId = s_page.getPageDirectId();
			if(pageDirectId != 0 && pageDirectId != -1){
				pageDirectId = pageDirectId * randomNumber;
			}
	%>
			new Liferay.SurveyPage(
				{
					id: <%=s_page.getSurveyPageId() %>,
					elementId: '<%=randomNumber * s_page.getSurveyPageId() %>',
					archId: '<%=SurveyConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + (randomNumber * s_page.getSurveyPageId()) %>',
					no: <%=s_page.getNo() %>,
					title: '<%=s_page.getTitle() %>',
					pageDirect: <%=SurveyPageLocalServiceUtil.getPageNoByPageId(s_page.getPageDirectId()) %>,
					pageDirectId: <%=pageDirectId %>
				}		
			).initialize();
	<%
		}
	%>
	
	<%
		if(s_questions != null){
			for(SurveyQuestion s_question : s_questions){
				
				if(s_question.getParentId() != 0)
					continue;
				
				long fileId = SurveyFileLocalServiceUtil.isExisted(s_question.getUploadFileId()) ? s_question.getUploadFileId() : 0;
	%>
				new Liferay.SurveyQuestion(
					{
						id: <%=s_question.getSurveyQuestionId() %>,
						elementId: '<%=randomNumber * s_question.getSurveyQuestionId() %>',
						archId: '<%=SurveyConstants.SURVEY_QUESTION_ARCHITECTURE_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>',
						pageId: '<%=randomNumber * s_question.getSurveyPageId() %>',
						no: <%=s_question.getNo() %>,
						question: '<%=s_question.getQuestion() %>',
						type: '<%=s_question.getType() %>',
						isRequired: <%=s_question.getIsRequired() %>,
						hasOther: <%=s_question.getHasOther() %>,
						optionDirect: <%=s_question.getOptionDirect() %>,
						points: <%=s_question.getPoints() %>,
						starsCount: <%=s_question.getStarsCount() %>,
						fileId: <%=fileId %>
					}	
				).initialize();
	<%
			}	
		}
	%>
	
	<%
		if(sub_questions != null){
			for(SurveyQuestion sub_question : sub_questions){
	%>
				new Liferay.SurveySubQuestion(
					{
						id: <%=sub_question.getSurveyQuestionId() %>,
						elementId: '<%=randomNumber * sub_question.getSurveyQuestionId() %>',
						pageId: '<%=randomNumber * sub_question.getSurveyPageId() %>',
						no: <%=sub_question.getNo() %>,
						question: '<%=sub_question.getQuestion() %>',
						parentElementId: '<%=randomNumber * sub_question.getParentId() %>'
					}		
				).initialize();
	<%
			}
		}
	%>
	
	<%
		if(s_options != null){
			for(SurveyOption s_option : s_options){
				long pageDirectId = s_option.getPageDirectId();
				if(pageDirectId != 0 && pageDirectId != -1){
					pageDirectId = pageDirectId * randomNumber;
				}
				long fileId = SurveyFileLocalServiceUtil.isExisted(s_option.getUploadFileId()) ? s_option.getUploadFileId() : 0;
	%>
				new Liferay.SurveyOption(
					{
						id: <%=s_option.getSurveyOptionId() %>,
						elementId: '<%=randomNumber * s_option.getSurveyOptionId() %>',
						pageId: '<%=randomNumber * s_option.getSurveyPageId() %>',
						questionId: '<%=randomNumber * s_option.getSurveyQuestionId() %>',
						no: <%=s_option.getNo() %>,
						option: '<%=s_option.getOption() %>',
						isAns: <%=s_option.getIsAns() %>,
						pageDirect: <%=SurveyPageLocalServiceUtil.getPageNoByPageId(s_option.getPageDirectId()) %>,
						pageDirectId: <%=pageDirectId %>,
						fileId: <%=fileId %>
					}	
				).initialize();
	<%
			}	
		}
	%>
	
	new Liferay.SurveyPageTool(
		{
			trigger: '#tool_bar_collapse_btn'
		}		
	);
	
	Liferay.provide(
		window, '<portlet:namespace/>setDirect',
		function(pageId){
			Liferay.SurveyToolConstants.setPageDirectId(pageId);
		}
	);
	
	Liferay.provide(
		window, '<portlet:namespace/>setRemovedFileId',
		function(removedFileId){
			Liferay.SurveyToolConstants.setRemovedFileId(removedFileId);
		}
	);

</aui:script>