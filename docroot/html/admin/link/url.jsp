<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	String linkURL = ParamUtil.getString(request, "linkURL");
%>

	
<input id="linkURL" class="survey-input survey-large-input" value="<%=linkURL %>">

<div class="survey-step-btn-container">

	<span id="survey_copy_btn" class="survey-step-btn">
			
		<i class="icon-copy"></i>
	
	</span>

</div>

<aui:script use="aui-base,survey-tips">
 	
 	// copy linkURL
    $("#survey_copy_btn").click(
    	function(){
    		
	    	var linkInput = document.getElementById("linkURL");
	    	
	    	linkInput.select();
	        
	        document.execCommand("copy");
	        
	        var surveyAlert = new Liferay.SurveyAlertMessage(
	        	{
	        		message: '<i class="icon-ok"></i>' + '<%=LanguageUtil.get(pageContext, "copied-successfully") %>',
	        		status: 'success',
	        		autoClose: 2500
	        	}		
	        );
	        surveyAlert.show();
    	}
    );
    
</aui:script>