<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/admin/edit/page_direct.css" rel="stylesheet" type="text/css">

<%
	int pagesCount = ParamUtil.getInteger(request, "pagesCount");
	long pageDirectId = ParamUtil.getLong(request, "pageDirectId");
	long currentPageId = ParamUtil.getLong(request, "currentPageId");
%>

<aui:layout>
	
	<div class="survey-page-direct-item-container">
	
		<input id="survey_page_direct_0" name="pageDirect" type="radio" class="survey-hidden-input survey-page-direct-input" value="0" <%=pageDirectId == 0 ? "checked" : "" %>>
		
		<label for="survey_page_direct_0" class="survey-page-direct-item">
		
			<font><%=LanguageUtil.get(pageContext, "no-setting") %></font>
			
		</label>
		
	</div>
	
	<%
		for(int i = 0; i < pagesCount; i++){
			long pageElementId = ParamUtil.getLong(request, "pageElementId" + i);
			String pageTitle = ParamUtil.getString(request, "pageTitle" + i);
			
			// 避免user選到instance隸屬的頁面Id
			if(pageElementId == currentPageId)
				continue;
			
	%>
		<div class="survey-page-direct-item-container">
	
			<input id='<%="survey_page_direct_" + pageElementId %>' name="pageDirect" type="radio" class="survey-hidden-input survey-page-direct-input" value="<%=pageElementId %>" <%=pageDirectId == pageElementId ? "checked" : "" %>>
			
			<label for='<%="survey_page_direct_" + pageElementId %>' class="survey-page-direct-item">
			
				<font><%=pageTitle %></font>
				
			</label>
			
		</div>
	<%
		}
	%>
	
	<div class="survey-page-direct-item-container">
	
		<input id="survey_page_direct_-1" name="pageDirect" type="radio" class="survey-hidden-input survey-page-direct-input" value="-1" <%=pageDirectId == -1 ? "checked" : "" %>>
		
		<label for="survey_page_direct_-1" class="survey-page-direct-item">
		
			<font><%=LanguageUtil.get(pageContext, "submit-form") %></font>
			
		</label>
		
	</div>
	
	<div class="survey-step-btn-container">
	
		<span id="survey_page_direct_check" class="survey-step-btn" onclick='<%=renderResponse.getNamespace() + "setDirect();" %>'>
		
			<i class="icon-ok"></i>
		
		</span>
	
	</div>

</aui:layout>

<aui:script use="aui-base">

	var openerWindow = Liferay.Util.getOpener();
	
	Liferay.provide(
		window, '<portlet:namespace/>setDirect',
		function(){
			var pageId = $("input[name=pageDirect]:checked").val();
			openerWindow.<portlet:namespace />setDirect(pageId);
		}
	)

</aui:script>