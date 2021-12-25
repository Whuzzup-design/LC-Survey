<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/error.css" rel="stylesheet" type="text/css">

<%
	String color = ParamUtil.getString(request, "color");
	String errorMessage = ParamUtil.getString(request, "errorMessage");
%>

<liferay-util:include page="/html/write/css/main_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=color %>"/>
</liferay-util:include>

<aui:layout>

	<div id="survey_write_layout">
		
		<p class="survey-write-title"></p>
		
		<div class="survey-write-container">
		
			<div class="survey-write-container-header">
			
				<p><%=LanguageUtil.get(pageContext, "error") %></p>
				
			</div>
				
			<div class="survey-write-container-body ">
			
				<div class="survey-error-row">
	
					<font><%=errorMessage %></font>
				
				</div>
			
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