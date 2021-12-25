<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/admin/link/link.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
%>

<portlet:renderURL var="linkURL">
	<portlet:param name="mvcPath" value="/html/write/introduction.jsp"/>
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
</portlet:renderURL>

<aui:layout cssClass="text-center">

	<div class="survey-admin-filter">
			
		<div class="survey-admin-view-mode">
		
			<div id="url_btn" class='survey-filter-btn active'>
				
				<i class="icon-link"></i>URL
				
			</div>
			
			<div id="qrcode_btn" class='survey-filter-btn'>
			
				<i class="icon-qrcode"></i>Qrcode
				
			</div>
		
		</div>
		
		<div class="survey-admin-filter-baseline"></div>
	
	</div>
	
	<div id="url_area" class="survey-link-area ">			
		<liferay-util:include page="/html/admin/link/url.jsp" servletContext="<%=application %>">
			<liferay-util:param name="linkURL" value="<%=linkURL %>"/>
		</liferay-util:include>			
	</div>
	
	<div id="qrcode_area" class="survey-link-area area-hidden">
		<liferay-util:include page="/html/admin/link/qrcode.jsp" servletContext="<%=application %>">
			<liferay-util:param name="linkURL" value="<%=linkURL %>"/>
		</liferay-util:include>		
	</div>

</aui:layout>

<aui:script>
	
	var urlBtn = $('#url_btn');
	var qrcodeBtn = $('#qrcode_btn');
	var urlArea = $('#url_area');
	var qrcodeArea = $('#qrcode_area');
	
	urlBtn.on(
		'click', function(){
			urlBtn.addClass("active");
			urlArea.removeClass('area-hidden');
			qrcodeBtn.removeClass("active");
			qrcodeArea.addClass('area-hidden');
		}		
	);
	
	qrcodeBtn.on(
		'click', function(){
			qrcodeBtn.addClass("active");
			qrcodeArea.removeClass('area-hidden');
			urlBtn.removeClass("active");
			urlArea.addClass('area-hidden');
		}		
	);

</aui:script>