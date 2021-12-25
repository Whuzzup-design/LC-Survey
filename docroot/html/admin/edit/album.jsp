<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/admin/edit/album.css" rel="stylesheet" type="text/css">

<%
	long selectedFileId = ParamUtil.getLong(request, "selectedFileId");
	long mainId = ParamUtil.getLong(request, "mainId");
	// 須回寫opener
	long removedFileId = ParamUtil.getLong(request, "removedFileId");
	
	List<SurveyFile> s_files = SurveyFileLocalServiceUtil.findBySurveyMainId(mainId);
%>

<portlet:actionURL var="updateFileURL" name="updateFile">
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
	<portlet:param name="selectedFileId" value="<%=String.valueOf(selectedFileId) %>"/>
</portlet:actionURL>

<aui:layout>
	
	<div style="margin-left: 30px; margin-top: 10px;">
	
		<liferay-ui:icon image="activate" label="true" message="double-click-the-image-to-select-image" cssClass="alert alert-warning"/>
	
	</div>
	
	<div class="survey-img-layout">
		
		<%
			for(SurveyFile s_file : s_files){
		%>
			<div id="<%=SurveyConstants.SURVEY_IMG_ITEM_NAMESPACE + s_file.getSurveyFileId() %>" class="survey-img-container">
		
				<div class="survey-img"></div>
				
				<%
					if(s_file.getSurveyFileId() == selectedFileId){
				%>
					<div class="survey-img-btn survey-img-choose-staus">
					
						<i class="icon-ok"></i>
					
					</div>
				<%
					}
				%>
				
				<div class="survey-img-btn survey-img-remove">
				
					<i class="icon-remove"></i>
				
				</div>
			
			</div>
		<%
			}
		%>
		
	</div>
	
	<div class="survey-image-upload-container">
		
		<aui:form id="fm" action="${updateFileURL }" enctype="multipart/form-data" 
			onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "onSubmit();"%>'>
			
			<aui:input label="<%=StringPool.BLANK %>" name="file" type="file" />
			
			<aui:button type="submit" value="submit" />
		
		</aui:form>
	
	</div>

</aui:layout>

<aui:script use="aui-base,survey-instance">
	
	var openerWindow = Liferay.Util.getOpener();
	
	<%
		if(removedFileId != 0){
	%>
		openerWindow.<portlet:namespace />setRemovedFileId('<%=removedFileId %>');
	<%
		}
	%>
		
	<%
		for(SurveyFile s_file : s_files){
			
			ResourceURL imgURL = renderResponse.createResourceURL();
			imgURL.setResourceID("getFile");
			imgURL.setParameter("fileId", String.valueOf(s_file.getSurveyFileId()));
			imgURL.setParameter("mainId", String.valueOf(mainId));
			
			PortletURL removeURL = renderResponse.createActionURL();
			removeURL.setParameter("javax.portlet.action", "removeFile");
			removeURL.setParameter("fileId", String.valueOf(s_file.getSurveyFileId()));
			removeURL.setParameter("mainId", String.valueOf(mainId));
			removeURL.setParameter("selectedFileId", String.valueOf(selectedFileId));
	%>
		new Liferay.SurveyImage(
			{
				fileId: <%=s_file.getSurveyFileId() %>,
				imgURL: '<%=imgURL.toString() %>',
				removeURL: '<%=removeURL.toString() %>',
				openerWindow: openerWindow
			}		
		).initialize();
	<%		
		}
	%>
	
	$('#<portlet:namespace/>file').on(
			
		'change', function(e){
		
			var fileName = e.target.files[0].name;
			
			if(fileName){
			
				var fileType = fileName.split(".")[1];
				
				if(fileType !== 'jpg' && fileType !== 'png'){
					alertMessage = new Liferay.SurveyAlertMessage(
						{
							message: '<i class="icon-warning-sign"></i>' + '<%=LanguageUtil.get(pageContext, "please-select-an-image-file") %>',
							status: 'danger',
							autoClose: 2500
						}	
					);
					alertMessage.show();
					$(this).val("");
				}
			}
		}
	);
	
	Liferay.provide(window, '<portlet:namespace/>onSubmit',
	
		function(){
			
			var file = $('#<portlet:namespace/>file');
			
			if(file.get(0).files.length === 0){
				
				alertMessage = new Liferay.SurveyAlertMessage(
					{
						message: '<i class="icon-warning-sign"></i>' + '<%=LanguageUtil.get(pageContext, "please-select-a-file") %>',
						status: 'danger',
						autoClose: 2500
					}	
				);
				alertMessage.show();
			}else{
				
				submitForm(document.<portlet:namespace/>fm);
			}
		}
	);

</aui:script>