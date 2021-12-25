<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
	
	String title = s_main.getTitle();
	String description = s_main.getDescription();
	String epilog = s_main.getEpilog();
	String startDate = _ymd.format(s_main.getStartDate());
	String endDate = _ymd.format(s_main.getEndDate());
	boolean needAuth = s_main.getNeedAuth();
	boolean calculateScore = s_main.getCalculateScore();
	boolean viewAnswer = s_main.getViewAnswer();
	String color = s_main.getColor();
%>

<div id="survey_main_page" class="survey-page survey-page-active" data-sort="0">
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-title") %></p>
		
		<input name="title" class="survey-input survey-medium-input" autocomplete="off" placeholder='<%=LanguageUtil.get(pageContext, "please-enter") %>' value="<%=title %>">
	
	</div>
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-opening-time") %></p>
		
		<input name="startDate" class="survey-input" autocomplete="off" placeholder='<%=LanguageUtil.get(pageContext, "please-enter") %>' value="<%=startDate %>">
		
		<i class="icon-arrow-right" style="margin: 0 7px;"></i>
		
		<input name="endDate" class="survey-input" autocomplete="off" placeholder='<%=LanguageUtil.get(pageContext, "please-enter") %>' value="<%=endDate %>">
	
	</div>
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-authenticate-user") %></p>
		
		<label class="survey-toggle-container">
		
			<input type="checkbox" name="needAuth" class="survey-hidden-input" <%=needAuth ? "checked" : "" %>>
			
			<span class="survey-toggle-checkmark-container">
			
				<span class="survey-toggle-checkmark"></span>
			
			</span>
			
		</label>
		
	</div>
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-calculate-score") %></p>
		
		<label class="survey-toggle-container">
		
			<input type="checkbox" name="calculateScore" class="survey-hidden-input" <%=calculateScore ? "checked" : "" %>>
			
			<span class="survey-toggle-checkmark-container">
			
				<span class="survey-toggle-checkmark"></span>
			
			</span>
			
		</label>
		
	</div>
	
	<div class="survey-main-item" style='display:<%=calculateScore ? "block;" : "none;" %>'>
	
		<p><%=LanguageUtil.get(pageContext, "survey-able-to-view-answer") %></p>
		
		<label class="survey-toggle-container">
		
			<input type="checkbox" name="viewAnswer" class="survey-hidden-input" <%=viewAnswer ? "checked" : "" %>>
			
			<span class="survey-toggle-checkmark-container">
			
				<span class="survey-toggle-checkmark"></span>
			
			</span>
			
		</label>
		
	</div>
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-preface") %><liferay-ui:icon-help message="if-not-entered-the-system-will-automatically-display-the-default-text"/></p>		
		
		<liferay-ui:input-editor initMethod="descriptionEditor" name="description" toolbarSet="liferay">
			<script type="text/javascript">
        			function <portlet:namespace />descriptionEditor() {
        				return "<%=UnicodeFormatter.toString(description) %>";
        			}
			</script>
		</liferay-ui:input-editor>
		
	</div>
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-epilog") %><liferay-ui:icon-help message="if-not-entered-the-system-will-automatically-display-the-default-text"/></p>
		
		<liferay-ui:input-editor initMethod="epilogEditor" name="epilog" toolbarSet="liferay">
			<script type="text/javascript">
        			function <portlet:namespace />epilogEditor() {
        				return "<%=UnicodeFormatter.toString(epilog)%>"; 
        			}
			</script>
		</liferay-ui:input-editor>
		
	</div>
	
	<div class="survey-main-item">
	
		<p><%=LanguageUtil.get(pageContext, "survey-theme-color") %></p>
		
		<div class="survey-color-setting-container">
		
			<div id="survey_color_setting">
			
				<i class="icon-magic"></i>
			
			</div>
		
		</div>
		
	</div>
	
</div>

<aui:script use="aui-base,survey-instance">
	
	CKEDITOR.editorConfig = function(config)
	{
	    config.toolbar_liferay = [
	        ['Bold', 'Italic', 'Underline'],
	        ['Undo', 'Redo', '-', 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'SelectAll', 'RemoveFormat'],
	        ['Styles', 'FontSize', '-', 'TextColor', 'BGColor'],
	        ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock']
	    ];
	};
	
	new Liferay.SurveyMainSetting(
		{
			title: '<%=title %>',
			description: '<%=description %>',
			epilog: '<%=epilog %>',
			startDate: '<%=startDate %>',
			endDate: '<%=endDate %>',
			needAuth: <%=needAuth %>,
			calculateScore: <%=calculateScore %>,
			viewAnswer: <%=viewAnswer %>,
			color: '<%=color %>',
		}		
	).initialize();
	
</aui:script>