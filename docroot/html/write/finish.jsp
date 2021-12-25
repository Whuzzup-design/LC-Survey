<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long writerId = ParamUtil.getLong(request, "writerId");
	
	String title = "";
	String epilog = "";
	String color = SurveyConstants.WRITE_PAGE_DEFAULT_COLOR;
	boolean viewAnswer = false;
	SurveyMain s_main = null;
	
	if(SurveyMainLocalServiceUtil.isExisted(mainId)){
		
		s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
		
		title = s_main.getTitle();
		epilog = s_main.getEpilog().equals("") ? "<p class=\"survey-default-text\">" + LanguageUtil.get(pageContext, "survey-default-epilog") + "</p>" : s_main.getEpilog();
		color = s_main.getColor();
		viewAnswer = s_main.getViewAnswer();
	}
%>

<liferay-util:include page="/html/write/css/main_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=color %>"/>
</liferay-util:include>

<portlet:renderURL var="responseURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/write/response.jsp"/>
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
	<portlet:param name="writerId" value="<%=String.valueOf(writerId) %>"/>
	<portlet:param name="color" value="<%=color %>"/>
</portlet:renderURL>

<portlet:renderURL var="viewAnswerURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/write/view_answer.jsp"/>
	<portlet:param name="writerId" value="<%=String.valueOf(writerId) %>"/>
</portlet:renderURL>

<aui:layout>

	<div id="survey_write_layout">
	
		<p class="survey-write-title"><%=title %></p>
		
		<div class="survey-write-container">
		
			<div class="survey-write-container-header">
			
				<p><%=LanguageUtil.get(pageContext, "survey-epilog") %></p>
				
			</div>
				
			<div class="survey-write-container-body">
			
				<%=epilog %>
			
			</div>
			
			<div class="survey-step-btn-container">
				
				<span id="survey_response_btn" class="survey-step-btn" data-tips="<%=LanguageUtil.get(pageContext, "provide-feedback") %>">
				
					<i class="icon-comments-alt"></i>
				
				</span>
				
				<c:if test="<%=s_main.getViewAnswer() %>">
				
					<span id="survey_view_answer_btn" class="survey-step-btn" data-tips="<%=LanguageUtil.get(pageContext, "view-answer") %>">
				
						<i class="icon-eye-open"></i>
						
					</span>
				
				</c:if>
				
			</div>
			
		</div>
	
	</div>

</aui:layout>

<script>
	
	// 覆寫上一頁歷史瀏覽紀錄
	history.pushState(null, null, document.URL);
	history.back(); 
	history.forward();
	window.addEventListener('popstate', function () {
			history.go(1);
		}
	);

</script>

<aui:script use="aui-base,survey-tips">
	
	var responseWindow = null;
	
	new Liferay.SurveyTips(
		{
			trigger: '.survey-step-btn'
		}		
	);
	
	var openResponseWindow = function(){
		
		var responseWindowWidth = '700px';
		var responseWindowHeight = '600px';
		
		if($(window).width() < 1200){
			responseWindowWidth = '';
			responseWindowHeight = '';
		}
		
		if(responseWindow){
			responseWindow.destroy();
			responseWindow = null;
		}
		responseWindow = Liferay.Util.Window.getWindow(
			{
				id: '<portlet:namespace/>survey_dialog_window',
				dialog: {
		           	draggable: false,
		           	centered: true,
		           	resizable: false,
		           	width: responseWindowWidth,
		           	height: responseWindowHeight,
		           	modal: true,
		           	destroyOnHide: true,
					constrain2view: true
		       	},
		       	title: "<%=LanguageUtil.get(pageContext, "provide-feedback") %>"
			}
		).plug(
			A.Plugin.DialogIframe,
			{
				autoLoad: false,
	            iframeCssClass: 'dialog-iframe',
	            uri: '<%=responseURL %>'
			}
		).show();
	}
	
	$('#survey_response_btn').on("click", openResponseWindow);
	
	$('#survey_view_answer_btn').on("click",
		function(){
			window.open("<%=viewAnswerURL %>");
		}
	);
	
</aui:script>