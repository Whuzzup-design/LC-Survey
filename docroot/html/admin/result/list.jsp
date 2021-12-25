<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	int pageCount = ParamUtil.getInteger(request, "pageCount", 1);
	
	int totalPageCount = 1;
	int listStartCount = 0;
	int listEndCount = pageCount * 12 - 1;
	long randomNumber = SurveyUtils.randomNumber();
	String score = "";
	
	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
	List<SurveyWriter> s_writers = SurveyWriterLocalServiceUtil.findByM_P_C(mainId, false, true);
	
	if(s_writers != null && s_writers.size() != 0){
		
		// get total page count
		totalPageCount = s_writers.size() / 12;
		if(s_writers.size() % 12 != 0)
			totalPageCount++;
		
		// get listStartCount 
		if(pageCount != 1){
			listStartCount = (pageCount - 1) * 12;
		}
		// get listEndCount
		if(pageCount == totalPageCount){
			listEndCount = s_writers.size() - 1;
		}
		
		s_writers = ListUtil.subList(s_writers, listStartCount, listEndCount + 1);
	}
%>

<div class="survey-result-pagination-container">
	
	<div class="survey-result-count">
		
		<%=LanguageUtil.get(pageContext, "total") + "：" + SurveyWriterLocalServiceUtil.countByM_P_C(mainId, false, true) %>
		
		<c:if test="<%=s_main.getCalculateScore() %>">
		
			&nbsp;&nbsp;&nbsp;&nbsp;<%=LanguageUtil.get(pageContext, "average-score") + "：" + SurveyResultUtils.calculateAverageScore(mainId) %>
		
		</c:if>
		
	</div>
	
	<div class="survey-result-pagination">
		
		<span id="survey_download_results" class="survey-filter-btn"><%=LanguageUtil.get(pageContext, "download-results") %></span>

		<span id="survey_download_feedbacks" class="survey-filter-btn"><%=LanguageUtil.get(pageContext, "download-feedbacks") %></span>
		
		<div id="survey_result_pre_btn" class="survey-filter-btn survey-pagination-btn">
		
			<i class="icon-caret-left"></i>
			
		</div>
		
		<font class="survey-admin-pagination-font"><%=pageCount + StringPool.SPACE + StringPool.SLASH + StringPool.SPACE + totalPageCount + StringPool.SPACE + LanguageUtil.get(pageContext, "page") %></font>
		
		<div id="survey_result_next_btn" class="survey-filter-btn survey-pagination-btn">
			
			<i class="icon-caret-right"></i>
			
		</div>
	
	</div>

</div>

<%
	for(SurveyWriter s_writer : s_writers){
%>
	<div id="<%=SurveyConstants.SURVEY_RESULT_ITEM_NAMESPACE + (randomNumber * s_writer.getSurveyWriterId()) %>" class="survey-result-list-item">
		
		<%
			if(s_main.getCalculateScore()){
				
				score = SurveyResultUtils.calculateScoreByWriterId(s_writer.getSurveyWriterId());
		%>
		
			<div class="survey-result-score-row">
				
				<div class="survey-result-score"><%=score %></div>
				
				<div class="survey-result-defined-text"><%=LanguageUtil.get(pageContext, "points") %></div>
			
			</div>
		
		<%
			}
		%>
		
		<div class="survey-result-completion-time-row">
		
			<div class="survey-result-defined-text"><%=LanguageUtil.get(pageContext, "completion-time") %></div>
		
			<div class="survey-result-completion-time"><%=_ymd.format(s_writer.getCompletionTime()) %></div>
		
		</div>
		
		<div class="survey-result-tool-row">
		
			<span class="survey-result-tool-btn">
			
				<%=LanguageUtil.get(pageContext, "survey-manage") %>
				
				<i class="icon-caret-down"></i>
			
			</span>
		
		</div>
		
	</div>
<%
	}
%>

<aui:script use="aui-base,liferay-portlet-url,survey-components,survey-tips">
	
	Liferay.SurveyToolConstants.bindWindowCloseTool();
	
	<%
		for(SurveyWriter s_writer : s_writers){
	%>
			new Liferay.SurveyResultTool(
				{
					trigger: '<%="#" + SurveyConstants.SURVEY_RESULT_ITEM_NAMESPACE + (randomNumber * s_writer.getSurveyWriterId()) %>',
					writerId: "<%=s_writer.getSurveyWriterId() %>",
					hasResponse: <%=SurveyResponseLocalServiceUtil.countByWriterId(s_writer.getSurveyWriterId()) == 0 ? false : true %>
				}
			);
	<%
		}
	%>
	
	$('#survey_result_next_btn').on(
		'click', function(){
			
			if(<%=pageCount == totalPageCount %>){
				return;
			}
			
			var nextPageURL = Liferay.PortletURL.createRenderURL();
			nextPageURL.setWindowState("pop_up");
			nextPageURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
			nextPageURL.setParameter("jspPage", "/html/admin/result/home.jsp");
			nextPageURL.setParameter("mainId", "<%=mainId %>");
			nextPageURL.setParameter("pageCount", "<%=pageCount + 1 %>");
			
			location.href = nextPageURL.toString();
		}	
	);
	
	$('#survey_result_pre_btn').on(
		'click', function(){
			
			if(<%=pageCount == 1 %>){
				return;
			}
			
			var prePageURL = Liferay.PortletURL.createRenderURL();
			prePageURL.setWindowState("pop_up");
			prePageURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
			prePageURL.setParameter("jspPage", "/html/admin/result/home.jsp");
			prePageURL.setParameter("mainId", "<%=mainId %>");
			prePageURL.setParameter("pageCount", "<%=pageCount - 1 %>");
			
			location.href = prePageURL.toString();
		}	
	);
	
	$('#survey_download_results').on(
		'click', function(){
			
			var surveyAlert = new Liferay.SurveyAlertMessage(
				{
					message: '<i class="icon-globe"></i>' + '<%=LanguageUtil.get(pageContext, "request-is-in-progress") %>',
					status: 'info',
					autoClose: 0
				}	
			);
			surveyAlert.show();
			
			var createResultExcelURL = Liferay.PortletURL.createResourceURL();
			createResultExcelURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId() %>');
			createResultExcelURL.setPlid('<%=themeDisplay.getLayout().getPlid()%>');
			createResultExcelURL.setResourceId('createResultExcel');
			createResultExcelURL.setParameter("mainId", '<%=mainId %>');
			
			A.io.request(
				createResultExcelURL.toString(),
				{
					method: 'POST',
					dataType: 'json',
					after: {
						success: function(event, id, obj){
							var result = this.get('responseData');
							if(result.hasResult){
								
								surveyAlert.close();
								
								var downloadResultExcelURL = Liferay.PortletURL.createResourceURL();
								downloadResultExcelURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId() %>');
								downloadResultExcelURL.setPlid('<%=themeDisplay.getLayout().getPlid()%>');
								downloadResultExcelURL.setResourceId("downloadExcel");
								downloadResultExcelURL.setParameter("mainId", '<%=mainId %>');
								downloadResultExcelURL.setParameter("type", "result");
								
								location.href = downloadResultExcelURL.toString();
							}else{
								surveyAlert.change('<i class="icon-warning-sign"></i>' + '<%=LanguageUtil.get(pageContext, "there-are-no-results") %>', 'danger', 2500);
							}
						}
					}
				}
			);
		}	
	);
	
	$('#survey_download_feedbacks').on(
		'click', function(){
			
			var surveyAlert = new Liferay.SurveyAlertMessage(
				{
					message: '<i class="icon-globe"></i>' + '<%=LanguageUtil.get(pageContext, "request-is-in-progress") %>',
					status: 'info',
					autoClose: 0
				}	
			);
			surveyAlert.show();
			
			var createResponseExcelURL = Liferay.PortletURL.createResourceURL();
			createResponseExcelURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId() %>');
			createResponseExcelURL.setPlid('<%=themeDisplay.getLayout().getPlid()%>');
			createResponseExcelURL.setResourceId('createResponseExcel');
			createResponseExcelURL.setParameter("mainId", '<%=mainId %>');
			
			A.io.request(
				createResponseExcelURL.toString(),
				{
					method: 'POST',
					dataType: 'json',
					after: {
						success: function(event, id, obj){
							var result = this.get('responseData');
							if(result.hasResult){
								
								surveyAlert.close();
								
								var downloadResponseExcelURL = Liferay.PortletURL.createResourceURL();
								downloadResponseExcelURL.setPortletId('<%=themeDisplay.getPortletDisplay().getId() %>');
								downloadResponseExcelURL.setPlid('<%=themeDisplay.getLayout().getPlid()%>');
								downloadResponseExcelURL.setResourceId('downloadExcel');
								downloadResponseExcelURL.setParameter("mainId", '<%=mainId %>');
								downloadResponseExcelURL.setParameter("type", "response");
								
								location.href = downloadResponseExcelURL.toString();
							}else{
								surveyAlert.change('<i class="icon-warning-sign"></i>' + '<%=LanguageUtil.get(pageContext, "there-are-no-results") %>', 'danger', 2500);
							}
						}
					}
				}
			);
		}	
	);

</aui:script>