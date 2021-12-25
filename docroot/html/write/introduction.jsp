<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long writerId = ParamUtil.getLong(request, "writerId");
	boolean isPreview = ParamUtil.getBoolean(request, "isPreview");
	
	String title = "";
	String description = "";
	String color = SurveyConstants.WRITE_PAGE_DEFAULT_COLOR;
	String errorMessage = "";
	boolean needAuth = true;
	boolean showErrorMessage = false;
	Date now = new Date();
	
	if(SurveyMainLocalServiceUtil.isExisted(mainId)){
		
		SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
		
		title = s_main.getTitle();
		description = s_main.getDescription().equals("") ? "<p class=\"survey-default-text\">" + LanguageUtil.get(pageContext, "survey-default-introdunction") + "</p>" : s_main.getDescription();;
		color = s_main.getColor();
		
		if(isPreview){
			
			needAuth = false;
			
			showErrorMessage = false;
			
		}else{
			
			// open time
			if(now.before(s_main.getStartDate()) || now.after(s_main.getEndDate())){
				showErrorMessage = true;
				errorMessage = LanguageUtil.get(pageContext, "sorry-it-is-not-in-opening-time-please-close-the-page");
			}
			
			// need authenticate
			if(writerId != 0 || !s_main.getNeedAuth() || (s_main.getNeedAuth() && themeDisplay.isSignedIn()))
				needAuth = false;
		}
		
	}else{
		
		showErrorMessage = true;
		
		errorMessage = LanguageUtil.get(pageContext, "sorry-this-survey-is-not-existed-please-close-the-page");
	}
%>

<portlet:actionURL var="initializeWriterInfoURL" name="initializeWriterInfo">
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
	<portlet:param name="writerId" value="<%=String.valueOf(writerId) %>"/>
	<portlet:param name="isPreview" value="<%=String.valueOf(isPreview) %>"/>
</portlet:actionURL>

<portlet:renderURL var="authURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/write/auth.jsp"/>
	<portlet:param name="color" value="<%=color %>"/>
</portlet:renderURL>

<portlet:renderURL var="errorPageURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/write/error_tip.jsp"/>
	<portlet:param name="errorMessage" value="<%=errorMessage %>"/>
</portlet:renderURL>

<liferay-util:include page="/html/write/css/main_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=color %>"/>
</liferay-util:include>

<aui:layout>

	<div id="survey_write_layout">
	
		<p class="survey-write-title"><%=title %></p>
		
		<div class="survey-write-container">
		
			<div class="survey-write-container-header">
			
				<p><%=LanguageUtil.get(pageContext, "survey-preface") %></p>
				
			</div>
				
			<div class="survey-write-container-body">
			
				<%=description %>
			
			</div>
			
			<div class="survey-step-btn-container">
				
				<span id="survey_next_btn" class="survey-step-btn">
				
					<i class="icon-chevron-right"></i>
					
				</span>
				
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

<aui:script use="aui-base,liferay-util-window,aui-io-plugin-deprecated,aui-dialog-iframe-deprecated,liferay-portlet-url,survey-instance">
	
	var windowWidth = $(window).width();
	var isAuthenticated = false;
	
	if(<%=!needAuth %>)
		isAuthenticated = true;
		
	
	var popUpWindow = null;
	Liferay.provide(
		window, '<portlet:namespace/>popUp', function(renderURL, popupTitle, width, height){
			if(popUpWindow){
				popUpWindow.destroy();
				popUpWindow = null;
			}
			popUpWindow = Liferay.Util.Window.getWindow(
				{
					id: '<portlet:namespace/>popUpWindow',
					dialog: {
			           	draggable: false,
			           	centered: true,
			           	resizable: false,
			           	width: width,
			           	height: height,
						constrain2view: true,
			           	modal: true,
			           	destroyOnHide: true,
						toolbars: false,
						colse: true
			       	}
				}
			).plug(
				A.Plugin.DialogIframe,
				{
					autoLoad: false,
		            iframeCssClass: 'dialog-iframe',
		            uri: renderURL
				}
			);
			popUpWindow.titleNode.html(popupTitle);
			popUpWindow.show();
			
			// prevent user press "esc" to close login popup window
			A.all('body').on('key', 
				function(event){
					popUpWindow.once('visibleChange', function(event) {
							if(event.prevVal === true){
			                	event.newVal = true;
							}
						}
					);
				}, 'esc'	
			);
		}		
	);
	
	Liferay.provide(
		window, '<portlet:namespace/>closePopup', function() {
			popUpWindow.hide();
			isAuthenticated = true;
	    }
	);
	
	$('#survey_next_btn').click(
		function(){
			if(isAuthenticated)
 				location.href = '<%=initializeWriterInfoURL.toString() %>';
		}		
	);
	
	<%
		if(!showErrorMessage){
			if(needAuth){
	%>
				var authWindowWidth = '300px';
				var authWindowHeight = '500px';
				
				if(windowWidth < 1200){
					authWindowWidth = '';
					authWindowHeight = '';
				}
				
				<portlet:namespace/>popUp('<%=authURL.toString() %>', '<%=LanguageUtil.get(pageContext, "authenticate") %>', authWindowWidth, authWindowHeight);		
	<%
			}
		}else{
	%>
			var errorWindowWidth = '500px';
			var errorWindowHeight = '300px';
			
			if(windowWidth < 1200){
				errorWindowWidth = '';
				errorWindowHeight = '';
			}
			
			<portlet:namespace/>popUp('<%=errorPageURL.toString() %>', '<%=LanguageUtil.get(pageContext, "tip") %>', errorWindowWidth, errorWindowHeight);
	<%
		}
	%>

</aui:script>