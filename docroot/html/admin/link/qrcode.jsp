<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/jquery.qrcode.min.js"></script>

<%
	String linkURL = ParamUtil.getString(request, "linkURL");
%>

<div class="qrcode" id="qrcode"></div>

<aui:script>

	var pageWidth = $('#p_p_id' + '<portlet:namespace/>').css('width');
	var canvasWidth = pageWidth.substring(0, pageWidth.length - 2) * 0.4;
	
	$('#qrcode').qrcode(
		{
			render : "canvas",
			width: canvasWidth,
			height: canvasWidth,
			foreground: '#426282',
			text: '<%=linkURL %>'
		}		
	);
	
</aui:script>