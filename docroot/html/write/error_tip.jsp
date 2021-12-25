<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/error_tip.css" rel="stylesheet" type="text/css">

<%
	String errorMessage = ParamUtil.getString(request, "errorMessage");
%>

<aui:layout>

	<div class="survey-error-row">
	
		<font><%=errorMessage %></font>
	
	</div>

</aui:layout>

<aui:script use="liferay-util-window">

	//prevent user press "esc" to close login popup window
	A.one('body').on('key', 
		function(event){
			Liferay.Util.getWindow('<portlet:namespace/>popUpWindow').once('visibleChange', function(event) {
					if(event.prevVal === true){
	                	event.newVal = true;
					}
				}
			);
		}, 'esc'	
	);

</aui:script>