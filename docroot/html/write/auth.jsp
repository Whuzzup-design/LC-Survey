<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/auth.css" rel="stylesheet" type="text/css">

<%
	boolean authResult = ParamUtil.getBoolean(request, "authResult", false);
	String color = ParamUtil.getString(request, "color");
	String login = ParamUtil.getString(request, "login");
	String password = ParamUtil.getString(request, "password");
	
	String errorMessage = LanguageUtil.get(pageContext, "authenticate-failed-please-try-again");
	String authType = company.getAuthType();
	String loginLabel = "";
			
	if(authType.equals(CompanyConstants.AUTH_TYPE_SN)){
		loginLabel = LanguageUtil.get(locale, "screen-name");
	}else if(authType.equals(CompanyConstants.AUTH_TYPE_EA)){
		loginLabel = LanguageUtil.get(locale, "email-address");
	}else if(authType.equals(CompanyConstants.AUTH_TYPE_ID)){
		loginLabel = LanguageUtil.get(locale, "id");
	}
%>

<style>
	
	.survey-auth-success-bg {
	    background-color: <%=color %>;
	}
	
	.survey-auth-input:FOCUS +.survey-auth-input-label {
		color: <%=color %>;
	}
	
	.survey-auth-input:FOCUS ~.survey-auth-input-baseline {
		background-color: <%=color %>;
	}
	
	.survey-step-btn:HOVER {
		color: <%=color %>;
		border-color:<%=color %>;
	}
	
</style>

<portlet:actionURL var="authenticateWriterURL" name="authenticateWriter">
	<portlet:param name="color" value="<%=color %>"/>
</portlet:actionURL>

<liferay-ui:error key="authenticateFailMessage" message="<%=errorMessage %>"/>

<aui:layout>

	<c:choose>
	
		<c:when test="<%=!authResult %>">
		
			<aui:form action="${authenticateWriterURL }">
				
				<div class="survey-auth-row">
						
					<i class="icon-user"></i>	
					
					<div class="survey-auth-input-row">
					
						<input id="<portlet:namespace/>login" name="<portlet:namespace/>login" value="<%=login %>" class="survey-auth-input" required autocomplete="off">
					
						<span class="survey-auth-input-label"><%=loginLabel %></span>
						
						<div class="survey-auth-input-baseline"></div>
						
						<div id="<portlet:namespace/>login-required" class="survey-auth-input-required">
								
							<font><%=LanguageUtil.get(pageContext, "this-field-is-required") %></font>
							
						</div>
						
					</div>
								
				</div>
				
				<div class="survey-auth-row">
						
					<i class="icon-lock"></i>	
					
					<div class="survey-auth-input-row">
					
						<input id="<portlet:namespace/>password" name="<portlet:namespace/>password" value="<%=password %>" class="survey-auth-input" required autocomplete="off">
					
						<span class="survey-auth-input-label"><%=LanguageUtil.get(locale, "password") %></span>
						
						<div class="survey-auth-input-baseline"></div>
						
						<div id="<portlet:namespace/>password-required" class="survey-auth-input-required">
								
							<font><%=LanguageUtil.get(pageContext, "this-field-is-required") %></font>
							
						</div>
					
					</div>
								
				</div>
				
			</aui:form>
			
			<div class="survey-step-btn-container">
				
				<span id="survey_authenticate_btn" class="survey-step-btn">
				
					<i class="icon-signin"></i>
					
				</span>
				
			</div>
		
		</c:when>
		
		<c:otherwise>
		
			<div class="survey-auth-success-container" align="center">
				
				<div class="survey-auth-success-bg">
				
					<div class="survey-auth-success-mark"></div>
				
				</div>
				
				<p><%=LanguageUtil.get(pageContext, "authenticate-successfully") %></p>
				
			</div>
		
		</c:otherwise>
		
	</c:choose>

</aui:layout>

<aui:script use="aui-base,liferay-util-window">
	
	$('.survey-auth-input').on(
		'focus', function(){
			$(this).closest('.survey-auth-row').find('i').css('color', '<%=color %>');
		}		
	);
	
	$('.survey-auth-input').blur(
		function(){
			var requiredLabel = $(this).closest('.survey-auth-row')
				.find('.survey-auth-input-required-show.survey-auth-input-required');
			$(this).closest('.survey-auth-row').find('i').css('color', '#c6c6c6');
			if($(this).val() != "" && requiredLabel.length > 0){
				requiredLabel.removeClass('survey-auth-input-required-show');
			}
		}		
	);
	
	function startAuth(){
		$('.alert-error.alert').hide();
		var login = $('#<portlet:namespace/>login');
		var loginRequired = $('#<portlet:namespace/>login-required');
		var password = $('#<portlet:namespace/>password');
		var passwordRequired = $('#<portlet:namespace/>password-required');
		loginRequired.removeClass('survey-auth-input-required-show');
		passwordRequired.removeClass('survey-auth-input-required-show');
		if(login.val() != ''){
			if(password.val() != ''){
				submitForm(document.<portlet:namespace/>fm);
			}else{
				password.focus();
				passwordRequired.addClass('survey-auth-input-required-show');
			}
		}else{
			login.focus();
			loginRequired.addClass('survey-auth-input-required-show');
		}
	}
	
	$('#survey_authenticate_btn').click(
		function(){
			startAuth();
		}		
	)
	
	var Opener = Liferay.Util.getOpener();
	
	Liferay.provide(window, '<portlet:namespace/>authSuccess',
		function(){			
			setTimeout(function(){
				Opener.<portlet:namespace />closePopup();
			}, 1800);
		}
	)
	
	if(<%=authResult%>){
		<portlet:namespace/>authSuccess();
	}
	
	// prevent user press "esc" to close login popup window
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
	
	// bind "enter" to submit
	A.one('body').on('key', 
		function(){
			startAuth();
		}, 'enter'	
	);
	
</aui:script>