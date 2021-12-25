<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long randomNumber = ParamUtil.getLong(request, "randomNumber");
	long randomDefaultNumber = ParamUtil.getLong(request, "randomDefaultNumber");
	
	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
	List<SurveyPage> s_pages = SurveyPageLocalServiceUtil.findBySurveyMainId(mainId);
%>

<%
	for(SurveyPage s_page : s_pages){
		List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil.findBySurveyPageIdAndParentId(s_page.getSurveyPageId(), 0);
%>
	<div id="<%=SurveyConstants.SURVEY_PAGE_ITEM_NAMESPACE + (randomNumber * s_page.getSurveyPageId()) %>" class="survey-page"
		data-sort="<%=s_page.getNo() %>">

		<input name="pageTitle" class="survey-input survey-large-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-the-title-of-this-page") %>' 
			value="<%=s_page.getTitle() %>">
		
		<div class="survey-question-container">
		
			<%
				for(SurveyQuestion s_question : s_questions){
					
					String questionImageURL = "";
					
					List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
						.findBySurveyQuestionId(s_question.getSurveyQuestionId());
					
					List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil
						.findByParentId(s_question.getSurveyQuestionId());
					
					boolean questionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_question.getUploadFileId());
					
					if(questionImgExisted){
						
						ResourceURL questionImgURL = renderResponse.createResourceURL();
						questionImgURL.setResourceID("getFile");
						questionImgURL.setParameter("fileId", String.valueOf(s_question.getUploadFileId()));
						questionImgURL.setParameter("mainId", String.valueOf(mainId));
						
						questionImageURL = questionImgURL.toString();
					}
			%>
				<c:choose>
	
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_TEXT) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question"
							data-sort="<%=s_question.getNo() %>">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-pencil"></i><%=LanguageUtil.get(pageContext, "text-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
						</div>
					
					</c:when>
	
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question"
							data-sort="<%=s_question.getNo() %>">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-ok-sign"></i><%=LanguageUtil.get(pageContext, "single-choice-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
										
										<span class='label label-warning <%=s_question.getHasOther() ? "" : "label-hidden" %>'>
											<i class="icon-certificate"></i><%=LanguageUtil.get(pageContext, "other-option") %>
										</span>
										
										<span class='label label-info <%=s_main.getCalculateScore() ? "" : "label-hidden" %>'> 
											<i class="icon-asterisk"></i><%=LanguageUtil.get(pageContext, "points") %>：<%=s_question.getPoints() %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
							<div class="survey-option-container">
							
							<%
								for(SurveyOption s_option : s_options){
									
									String directText = "";
									String optionImageURL = "";
									String answerClass = "";
									String answerTips = "";
									
									if(s_main.getCalculateScore()){
										
										answerClass += "survey-answer";
										
										if(s_option.getIsAns()){
											answerClass += " survey-correct-answer";
											answerTips = LanguageUtil.get(pageContext, "correct-answer");
										}else{
											answerTips = LanguageUtil.get(pageContext, "incorrect-answer");
										}
									}
									
									boolean optionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_option.getUploadFileId());
									if(optionImgExisted){
										
										ResourceURL optionImgURL = renderResponse.createResourceURL();
										optionImgURL.setResourceID("getFile");
										optionImgURL.setParameter("fileId", String.valueOf(s_option.getUploadFileId()));
										optionImgURL.setParameter("mainId", String.valueOf(mainId));
										
										optionImageURL = optionImgURL.toString();
									}
							%>
								<div id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>" class="survey-option">
									
									<i class="icon-circle survey-option-mark <%=answerClass %>" data-tips="<%=answerTips %>"></i>
									
									<input name="optionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-option") %>' value="<%=s_option.getOption() %>">
									
									<span class="survey-option-tool-bar">
									
										<i class="icon-remove survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-picture survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										
									</span>
									
									<span class='survey-option-direct <%=s_question.getOptionDirect() ? "" : "survey-option-direct-hidden" %>'>
										<%=SurveyUtils.getDirectTextByPageId(pageContext, s_option.getPageDirectId()) %>
									</span>
									
									<div class='survey-option-image <%=!optionImgExisted ? "image-hidden" : "" %>'>
							
										<img src="<%=optionImageURL %>">
										
										<div class="remove-img-btn">
										
											<i class="icon-remove-sign"></i>
										
										</div>
									
									</div>
								
								</div>
							<%
								}
							%>
							
							</div>
							
							<a class="survey-plus-option-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-option") %></a>
							
						</div>
					
					</c:when>
	
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question"
							data-sort="<%=s_question.getNo() %>">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-check-sign"></i><%=LanguageUtil.get(pageContext, "checkbox-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
										
										<span class='label label-warning <%=s_question.getHasOther() ? "" : "label-hidden" %>'>
											<i class="icon-certificate"></i><%=LanguageUtil.get(pageContext, "other-option") %>
										</span>
										
										<span class='label label-info <%=s_main.getCalculateScore() ? "" : "label-hidden" %>'> 
											<i class="icon-asterisk"></i><%=LanguageUtil.get(pageContext, "points") %>：<%=s_question.getPoints() %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
							<div class="survey-option-container">
							
							<%
								for(SurveyOption s_option : s_options){
									
									String directText = "";
									String optionImageURL = "";
									String answerClass = "";
									String answerTips = "";
									
									if(s_main.getCalculateScore()){
										
										answerClass += "survey-answer";
										
										if(s_option.getIsAns()){
											answerClass += " survey-correct-answer";
											answerTips = LanguageUtil.get(pageContext, "correct-answer");
										}else{
											answerTips = LanguageUtil.get(pageContext, "incorrect-answer");
										}
									}
									
									boolean optionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_option.getUploadFileId());
									if(optionImgExisted){
										
										ResourceURL optionImgURL = renderResponse.createResourceURL();
										optionImgURL.setResourceID("getFile");
										optionImgURL.setParameter("fileId", String.valueOf(s_option.getUploadFileId()));
										optionImgURL.setParameter("mainId", String.valueOf(mainId));
										
										optionImageURL = optionImgURL.toString();
									}
							%>
								<div id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>" class="survey-option">
									
									<i class="icon-sign-blank survey-option-mark <%=answerClass %>" data-tips="<%=answerTips %>"></i>
									
									<input name="optionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-option") %>' value="<%=s_option.getOption() %>">
									
									<span class="survey-option-tool-bar">
									
										<i class="icon-remove survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-picture survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
									
									</span>
									
									<span class='survey-option-direct <%=s_question.getOptionDirect() ? "" : "survey-option-direct-hidden" %>'>
										<%=SurveyUtils.getDirectTextByPageId(pageContext, s_option.getPageDirectId()) %>
									</span>
									
									<div class='survey-option-image <%=!optionImgExisted ? "image-hidden" : "" %>'>
							
										<img src="<%=optionImageURL %>">
										
										<div class="remove-img-btn">
										
											<i class="icon-remove-sign"></i>
										
										</div>
									
									</div>
									
								</div>
							<%
								}
							%>
							
							</div>
							
							<a class="survey-plus-option-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-option") %></a>
							
						</div>
					
					</c:when>
					
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DROPDOWN_LIST) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question"
							data-sort="<%=s_question.getNo() %>">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-list-ul"></i><%=LanguageUtil.get(pageContext, "dropdown-list-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
										
										<span class='label label-info <%=s_main.getCalculateScore() ? "" : "label-hidden" %>'> 
											<i class="icon-asterisk"></i><%=LanguageUtil.get(pageContext, "points") %>：<%=s_question.getPoints() %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
							<div class="survey-option-container">
							
							<%
								for(SurveyOption s_option : s_options){
									
									String directText = "";
									String optionImageURL = "";
									String answerClass = "";
									String answerTips = "";
									
									if(s_main.getCalculateScore()){
										
										answerClass += "survey-answer";
										
										if(s_option.getIsAns()){
											answerClass += " survey-correct-answer";
											answerTips = LanguageUtil.get(pageContext, "correct-answer");
										}else{
											answerTips = LanguageUtil.get(pageContext, "incorrect-answer");
										}
									}
							%>
								<div id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>" class="survey-option">
									
									<i class="icon-list-ul survey-option-mark <%=answerClass %>" data-tips="<%=answerTips %>"></i>
									
									<input name="optionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-option") %>' value="<%=s_option.getOption() %>">
									
									<span class="survey-option-tool-bar">
									
										<i class="icon-remove survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										
									</span>
									
									<span class='survey-option-direct <%=s_question.getOptionDirect() ? "" : "survey-option-direct-hidden" %>'>
										<%=SurveyUtils.getDirectTextByPageId(pageContext, s_option.getPageDirectId()) %>
									</span>
								
								</div>
							<%
								}
							%>
							
							</div>
							
							<a class="survey-plus-option-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-option") %></a>
							
						</div>
					
					</c:when>
					
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DATE) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question"
							data-sort="<%=s_question.getNo() %>">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-calendar"></i><%=LanguageUtil.get(pageContext, "date-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
						</div>
					
					</c:when>
	
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_STAR) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question"
							data-sort="<%=s_question.getNo() %>">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-star"></i><%=LanguageUtil.get(pageContext, "star-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
										
										<span class='label label-inverse'>
											<i class="icon-sort-by-order"></i><%=LanguageUtil.get(pageContext, "stars-count") %>：<%=s_question.getStarsCount() %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
						</div>
					
					</c:when>
					
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-th"></i><%=LanguageUtil.get(pageContext, "single-choice-lattice-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
							<div class="survey-option-container">
							
								<p><%=LanguageUtil.get(pageContext, "options") %></p>
								
								<%
									for(SurveyOption s_option : s_options){
								%>
								
									<div id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>" class="survey-option">
									
										<i class="icon-ok-sign survey-option-mark"></i>
										
										<input name="optionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-option") %>' value="<%=s_option.getOption() %>">
										
										<span class="survey-option-tool-bar">
		
											<i class="icon-remove survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
											
										</span>
										
									</div>
								
								<%
									}
								%>
							
							</div>
							
							<a class="survey-plus-option-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-option") %></a>
							
							<div class="survey-sub-question-container">
							
								<p><%=LanguageUtil.get(pageContext, "questions") %></p>
								
								<%
									for(SurveyQuestion sub_question : sub_questions){
								%>
								
									<div id="<%=SurveyConstants.SURVEY_SUB_QUESTION_ITEM_NAMESPACE + (randomNumber * sub_question.getSurveyQuestionId()) %>" class="survey-sub-question">
									
										<i class="icon-align-justify survey-sub-question-mark"></i>
										
										<input name="subQuestionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=sub_question.getQuestion() %>">
										
										<span class="survey-sub-question-tool-bar">
		
											<i class="icon-remove survey-sub-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
											
										</span>
										
									</div>
									
								<%
									}
								%>
							
							</div>
							
							<a class="survey-plus-sub-question-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-question") %></a>
							
						</div>
					
					</c:when>
					
					<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE) %>">
					
						<div id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" class="survey-question">
		
							<div class="survey-question-bar">
							
								<div class="survey-question-bar-container">
								
									<div class="survey-question-tip-bar">
									
										<span class="label label-success">
											<i class="icon-th-large"></i><%=LanguageUtil.get(pageContext, "checkbox-lattice-question") %>
										</span>
										
										<span class='label label-important <%=s_question.getIsRequired() ? "" : "label-hidden" %>'>
											<i class="icon-exclamation-sign"></i><%=LanguageUtil.get(pageContext, "required") %>
										</span>
									
									</div>
									
									<div class="survey-question-tool-bar">
									
										<i class="icon-picture survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "add-picture") %>'></i>
										<i class="icon-trash survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
										<i class="icon-cog survey-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "setting") %>'></i>
									
									</div>
								
								</div>
							
							</div>
						
							<input name="questionTitle" class="survey-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=s_question.getQuestion()%>">
							
							<div class='survey-question-image <%=!questionImgExisted ? "image-hidden" : "" %>'>
							
								<img src="<%=questionImageURL %>">
								
								<div class="remove-img-btn">
								
									<i class="icon-remove-sign"></i>
								
								</div>
							
							</div>
							
							<div class="survey-option-container">
							
								<p><%=LanguageUtil.get(pageContext, "options") %></p>
								
								<%
									for(SurveyOption s_option : s_options){
								%>
								
									<div id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>" class="survey-option">
									
										<i class="icon-sign-blank survey-option-mark"></i>
										
										<input name="optionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-option") %>' value="<%=s_option.getOption() %>">
										
										<span class="survey-option-tool-bar">
		
											<i class="icon-remove survey-option-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
											
										</span>
										
									</div>
								
								<%
									}
								%>
							
							</div>
							
							<a class="survey-plus-option-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-option") %></a>
							
							<div class="survey-sub-question-container">
							
								<p><%=LanguageUtil.get(pageContext, "questions") %></p>
								
								<%
									for(SurveyQuestion sub_question : sub_questions){
								%>
								
									<div id="<%=SurveyConstants.SURVEY_SUB_QUESTION_ITEM_NAMESPACE + (randomNumber * sub_question.getSurveyQuestionId()) %>" class="survey-sub-question">
									
										<i class="icon-align-justify survey-sub-question-mark"></i>
										
										<input name="subQuestionTitle" class="survey-input survey-medium-input" placeholder='<%=LanguageUtil.get(pageContext, "please-enter-a-question") %>' value="<%=sub_question.getQuestion() %>">
										
										<span class="survey-sub-question-tool-bar">
		
											<i class="icon-remove survey-sub-question-tool-btn" data-tips='<%=LanguageUtil.get(pageContext, "delete") %>'></i>
											
										</span>
										
									</div>
									
								<%
									}
								%>
							
							</div>
							
							<a class="survey-plus-sub-question-btn"><i class="icon-plus-sign"></i><%=LanguageUtil.get(pageContext, "create-question") %></a>
							
						</div>
					
					</c:when>
				
				</c:choose>
			<%
				}
			%>
			
		</div>
		
	</div>
<%
	}
%>