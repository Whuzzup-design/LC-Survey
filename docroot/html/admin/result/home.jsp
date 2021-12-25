<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/admin/result/result.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	int pageCount = ParamUtil.getInteger(request, "pageCount", 1);
%>

<aui:layout cssClass="survey-admin-layout">

	<div class="survey-admin-filter">
			
		<div class="survey-admin-view-mode">
		
			<div id="list_btn" class="survey-filter-btn active">
			
				<i class="icon-list-ul"></i><%=LanguageUtil.get(pageContext, "individual-result-list") %>
				
			</div>
			
			<div id="chart_btn" class="survey-filter-btn">
				
				<i class="icon-bar-chart"></i><%=LanguageUtil.get(pageContext, "chart-statistics") %>
				
			</div>			
		
		</div>
		
		<div class="survey-admin-filter-baseline"></div>
	
	</div>
	
	<div id="list_area">			
		<liferay-util:include page="/html/admin/result/list.jsp" servletContext="<%=application %>">
			<liferay-util:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
			<liferay-util:param name="pageCount" value="<%=String.valueOf(pageCount) %>"/>
		</liferay-util:include>			
	</div>
	
	<div id="chart_area" class="area-hidden">
		<liferay-util:include page="/html/admin/result/chart.jsp" servletContext="<%=application %>">
			<liferay-util:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
		</liferay-util:include>		
	</div>

</aui:layout>

<aui:script>
	
	var listBtn = $('#list_btn');
	var chartBtn = $('#chart_btn');
	var listArea = $('#list_area');
	var chartArea = $('#chart_area');
	
	listBtn.on(
		'click', function(){
			listBtn.addClass("active");
			listArea.removeClass('area-hidden');
			chartBtn.removeClass("active");
			chartArea.addClass('area-hidden');
		}		
	);
	
	chartBtn.on(
		'click', function(){
			chartBtn.addClass("active");
			chartArea.removeClass('area-hidden');
			listBtn.removeClass("active");
			listArea.addClass('area-hidden');
		}		
	);

</aui:script>