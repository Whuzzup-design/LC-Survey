<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/admin/list.css" rel="stylesheet" type="text/css">

<%
	int pageCount = ParamUtil.getInteger(request, "pageCount", 1);
	String listMode = ParamUtil.getString(request, "listMode", "card");
	String openTime = ParamUtil.getString(request, "openTime");
	String calculateScore = ParamUtil.getString(request, "calculateScore");
	String title = ParamUtil.getString(request, "title");
	
	int totalPageCount = 1;
	int listStartCount = 0;
	int listEndCount = pageCount * 10 - 1;
	long randomNumber = SurveyUtils.randomNumber();
	
	List<SurveyMain> s_mains = SurveyMainLocalServiceUtil.findForSearch(themeDisplay.getUserId(), openTime
			, calculateScore, title);
		
	if(s_mains.size() != 0){
		
		// get total page count
		totalPageCount = s_mains.size() / 10;
		if(s_mains.size() % 10 != 0)
			totalPageCount++;
		
		// get listStartCount 
		if(pageCount != 1)
			listStartCount = (pageCount - 1) * 10;
		
		// get listEndCount
		if(pageCount == totalPageCount)
			listEndCount = s_mains.size() - 1;
		
		s_mains = ListUtil.subList(s_mains, listStartCount, listEndCount + 1);
	}
%>

<portlet:resourceURL var="createSurveyURL" id="createSurvey" />

<portlet:renderURL var="nextPageURL">
	<portlet:param name="jspPage" value="/html/admin/list.jsp"/>
	<portlet:param name="pageCount" value="<%=String.valueOf(pageCount + 1) %>"/>
	<portlet:param name="listMode" value="<%=listMode %>"/>
	<portlet:param name="openTime" value="<%=openTime %>"/>
	<portlet:param name="calculateScore" value="<%=calculateScore %>"/>
	<portlet:param name="ParamUtil" value="<%=title %>"/>
</portlet:renderURL>

<portlet:renderURL var="prePageURL">
	<portlet:param name="jspPage" value="/html/admin/list.jsp"/>
	<portlet:param name="pageCount" value="<%=String.valueOf(pageCount - 1) %>"/>
	<portlet:param name="listMode" value="<%=listMode %>"/>
	<portlet:param name="openTime" value="<%=openTime %>"/>
	<portlet:param name="calculateScore" value="<%=calculateScore %>"/>
	<portlet:param name="ParamUtil" value="<%=title %>"/>
</portlet:renderURL>

<aui:layout cssClass='<%=themeDisplay.isSignedIn() ? "survey-admin-layout" : "" %>'>
	
	<c:choose>
		
		<c:when test="<%=!themeDisplay.isSignedIn() %>">
	
			<div class="alert alert-info">
			
				<liferay-ui:message key="please-sign-in-to-access-this-application" />
				
			</div>
		
		</c:when>
		
		<c:otherwise>
			
			<div class="survey-admin-filter">
				
				<div class="survey-admin-view-mode">
				
					<div id="card_btn" class='survey-filter-btn <%=listMode.equals("card") ? "active" : ""%>'>
					
						<i class="icon-th-large"></i><%=LanguageUtil.get(pageContext, "survey-view-mode-card") %>
						
					</div>
					
					<div id="list_btn" class='survey-filter-btn <%=listMode.equals("list") ? "active" : ""%>'>
						
						<i class="icon-th-list"></i><%=LanguageUtil.get(pageContext, "survey-view-mode-list") %>
						
					</div>
				
				</div>
				
				<div class="survey-admin-pagination">
					
					<div id="survey_admin_filter_btn" class="survey-filter-btn">
					
						<i class="icon-filter"></i><%=LanguageUtil.get(pageContext, "survey-filter") %>
												
					</div>
					
					<div id="survey_admin_pre_btn" class="survey-filter-btn survey-pagination-btn">
					
						<i class="icon-caret-left"></i>
						
					</div>
					
					<font class="survey-admin-pagination-font"><%=pageCount + StringPool.SPACE + StringPool.SLASH + StringPool.SPACE + totalPageCount + StringPool.SPACE + LanguageUtil.get(pageContext, "page") %></font>
					
					<div id="survey_admin_next_btn" class="survey-filter-btn survey-pagination-btn">
						
						<i class="icon-caret-right"></i>
						
					</div>
				
				</div>
				
				<div class="survey-admin-filter-baseline"></div>
			
			</div>
			
			<div id="survey-admin-area" class='<%=listMode.equals("card") ? "card-mode" : "list-mode" %>'>
				
				<div id="survey-list-title" class="survey-item">
		
					<div class="survey-result-count-row">
							
						<%=LanguageUtil.get(pageContext, "survey-result-count") %>
					
					</div>
					
					<div class="survey-title-row">
						
						<%=LanguageUtil.get(pageContext, "survey-title") %>
					
					</div>
					
					<div class="survey-time-row">
						
						<%=LanguageUtil.get(pageContext, "survey-opening-time") %>
					
					</div>
					
					<div class="survey-admin-tool-row">
						
						<%=LanguageUtil.get(pageContext, "action") %>
						
					</div>
				
				</div>
				
				<%
					for(SurveyMain s_main : s_mains){
						
						int surveyResultCount = SurveyWriterLocalServiceUtil.countByM_P_C(s_main.getSurveyMainId(), false, true);
				%>			
					<div id="<%=SurveyConstants.SURVEY_MAIN_ITEM_NAMESPACE + (s_main.getSurveyMainId() * randomNumber) %>"
						class="survey-item">
			
						<div class="survey-result-count-row">
								
							<div class="survey-result-count"><%=surveyResultCount %></div>
							
							<div class="survey-defined-text"><%=LanguageUtil.get(pageContext, "result-count-font") %></div>
						
						</div>
						
						<div class="survey-title-row">
							
							<div class="survey-title"><%=s_main.getTitle() %></div>
						
						</div>
						
						<div class="survey-time-row">
							
							<div class="survey-defined-text"><%=LanguageUtil.get(pageContext, "survey-opening-time") %></div>
							
							<div class="survey-time"><%=_ymd.format(s_main.getStartDate()) + " ~ " + _ymd.format(s_main.getEndDate())%></div>
						
						</div>
						
						<div class="survey-admin-tool-row">
							
							<span class="survey-admin-tool-btn">
							
								<%=LanguageUtil.get(pageContext, "survey-manage") %>
								
								<i class="icon-caret-down"></i>
								
							</span>
						
						</div>
					
					</div>
				<%
					}
				%>
				
				<div id="survey_create_btn" class="survey-item">
				
					<i class="icon-plus-sign"></i>
				
				</div>
			
			</div>
			
		</c:otherwise>
		
	</c:choose>
	
</aui:layout>

<aui:script use="aui-base,survey-components,survey-instance,survey-tips">
	
	<%
		if(themeDisplay.isSignedIn()){ 
	%>
		Liferay.SurveyToolConstants.bindWindowCloseTool();
	
		<%
			for(SurveyMain s_main : s_mains){
				
				PortletURL removeURL = renderResponse.createActionURL();
				removeURL.setParameter("javax.portlet.action", "removeSurvey");
				removeURL.setParameter("mainId", String.valueOf(s_main.getSurveyMainId()));
				removeURL.setParameter("redirect", currentURL);
		%>
				new Liferay.SurveyAdminTool(
					{
						trigger: '<%="#" + SurveyConstants.SURVEY_MAIN_ITEM_NAMESPACE + (s_main.getSurveyMainId() * randomNumber) %>',
						mainId: <%=s_main.getSurveyMainId() %>,
						removeURL: "<%=removeURL.toString() %>"
					}		
				);
		<%
			}
		%>
		
		var adminArea = $("#survey-admin-area");
		var cardBtn = $("#card_btn");
		var listBtn = $("#list_btn");
		
		cardBtn.on(
			"click", function(){
				
				var $this = $(this);
				
				if(!$this.hasClass("active")){
					
					listBtn.removeClass("active");
					cardBtn.addClass("active");
					adminArea.fadeToggle(200, function(){
							adminArea.removeClass("list-mode");
							adminArea.addClass("card-mode");
						}
					);
					adminArea.fadeToggle(200);
				}
			}		
		);
		
		listBtn.on(
			"click", function(){
				
				var $this = $(this);
				
				if(!$this.hasClass("active")){
					
					cardBtn.removeClass("active");
					listBtn.addClass("active");
					adminArea.fadeToggle(200, function(){
							adminArea.removeClass("card-mode");
							adminArea.addClass("list-mode");
						}
					);
					adminArea.fadeToggle(200);
				}
			}		
		);
		
		var createStatus = true;
		var createSurveyWindow = null;
		
		$("#survey_create_btn").on(
			"click", function(){
				
				if(Liferay.Session.get("sessionState") == "expired"){
					var surveyAlert = new Liferay.SurveyAlertMessage(
						{
							message: '<i class="icon-warning-sign"></i>' + Liferay.Language.get("please-sign-in-to-access-this-application"),
							status: "info",
							autoClose: 2500
						}		
					);
					surveyAlert.show();
					return;
				}
				
				if(!createStatus)
					return;
				
				createStatus = false;
				
				var listMode = 'card';
				if($(".active.survey-filter-btn").attr("id") == "list_btn"){
					listMode = "list";
				}
				
				var updateURL = Liferay.PortletURL.createRenderURL();
				updateURL.setWindowState("pop_up");
				updateURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
				updateURL.setParameter("jspPage", "/html/admin/edit/home.jsp");
				
				A.io.request(
					"<%=createSurveyURL.toString() %>",
					{
						dataType: "json",
						after: {
							success: function(event, id, obj) {
								
								var mainId = this.get("responseData").mainId;
								
								updateURL.setParameter("mainId", mainId);
								
					 			if(createSurveyWindow){
					 				createSurveyWindow.destroy();
					 				createSurveyWindow = null;
					 			}
					 			createSurveyWindow = Liferay.Util.Window.getWindow(
					 				{
					 					id: "<portlet:namespace/>survey_dialog_window",
					 					dialog: {
					 			           	draggable: false,
					 			           	centered: true,
					 			           	resizable: false,
					 			           	width: screen.width * 0.95,
					 			           	height: screen.height * 0.9,
					 			           	modal: true,
					 			           	destroyOnHide: true,
					 						constrain2view: true,
					 						after: {
					 				        	destroy: function(event) {
					 				        		Liferay.Portlet.refresh("#p_p_id<portlet:namespace/>",
					 				        			{
					 				        				<portlet:namespace/>listMode: listMode
					 				        			}		
					 				        		);
					 				        	}
					 				    	}
					 			       	}
					 				}
					 			).plug(
					 				A.Plugin.DialogIframe,
					 				{
					 					autoLoad: false,
					 		            iframeCssClass: "dialog-iframe",
					 		            uri: updateURL
					 				}
					 			);
					  			createSurveyWindow.titleNode.html('<%=LanguageUtil.get(pageContext, "create-survey") %>');
					 			createSurveyWindow.show();
					 			createStatus = true;
							}
						}
					}
				);
			}		
		);
		
		new Liferay.SurveyAdminFilter(
			{
				trigger: '#survey_admin_filter_btn',
				openTime: '<%=openTime %>',
				calculateScore: '<%=calculateScore %>',
				title: '<%=title %>'
			}	
		);
		
		$('#survey_admin_next_btn').on(
			'click', function(){
				
				if(<%=pageCount == totalPageCount %>){
					return;
				}
				
				location.href = '<%=nextPageURL %>';
			}	
		);
		
		$('#survey_admin_pre_btn').on(
			'click', function(){
				
				if(<%=pageCount == 1 %>){
					return;
				}
				
				location.href = '<%=prePageURL %>';
			}	
		);
	
	<%
		}
	%>

</aui:script>