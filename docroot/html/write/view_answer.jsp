<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/question.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/view_answer.css" rel="stylesheet" type="text/css">

<%
	long writerId = ParamUtil.getLong(request, "writerId");
	
	long randomNumber = SurveyUtils.randomNumber();
	
	SurveyWriter s_writer = SurveyWriterLocalServiceUtil.fetchSurveyWriter(writerId);
	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(s_writer.getSurveyMainId());
	List<SurveyPage> s_pages = SurveyPageLocalServiceUtil.findBySurveyMainId(s_writer.getSurveyMainId());
%>

<liferay-util:include page="/html/write/css/main_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=s_main.getColor() %>"/>
</liferay-util:include>

<liferay-util:include page="/html/write/css/question_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=s_main.getColor() %>"/>
</liferay-util:include>

<aui:layout>

	<div id="survey_write_layout">
	
		<p class="survey-write-title"><%=s_main.getTitle() %></p>
		
		<c:if test="<%=s_main.getCalculateScore() %>">
		
			<p class="survey-write-score">
			
				<%=LanguageUtil.get(pageContext, "points") + "：" + SurveyResultUtils.calculateScoreByWriterId(writerId) + " / " + SurveyResultUtils.calculateTotalScore(s_writer.getSurveyMainId()) %>
				
			</p>
		
		</c:if>
		
		<%
			for(SurveyPage s_page : s_pages){
				
				if(SurveyResultLocalServiceUtil.countByP_W(s_page.getSurveyPageId(), writerId) == 0)
					continue;
				
				List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil.findBySurveyPageIdAndParentId(s_page.getSurveyPageId(), 0);
		%>
		
			<div class="survey-write-container">
			
				<div class="survey-write-container-header">
				
					<p><%=SurveyUtils.getOrdinalNumber(s_page.getNo()) %></p>
					
				</div>
			
				<div class="survey-write-container-body">
					
					<div class="survey-write-page"><%=s_page.getTitle() %></div>
					
					<%
						for(SurveyQuestion s_question : s_questions){
							
							String questionImageURL = "";
							boolean questionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_question.getUploadFileId());
							
							if(questionImgExisted){
								ResourceURL questionImgURL = renderResponse.createResourceURL();
								questionImgURL.setResourceID("getFile");
								questionImgURL.setParameter("fileId", String.valueOf(s_question.getUploadFileId()));
								questionImgURL.setParameter("mainId", String.valueOf(s_writer.getSurveyMainId()));
								questionImageURL = questionImgURL.toString();
							}
					%>
						<div id='<%="survey_write_question_" + s_question.getNo() %>' class="survey-write-question <%=s_question.getType() %>">
						
							<div class="survey-write-question-no">
								
								<c:if test="<%=s_question.getIsRequired() %>">
								
									<span class="survey-required-mark">
									
										<i class="icon-asterisk"></i>
										
									</span>
								
								</c:if>
							
								<%=s_question.getNo() %>
								
							</div>
							
							<div class="survey-write-question-content">
							
								<div class="survey-write-question-title"><%=s_question.getQuestion() %></div>
								
								<c:if test="<%=questionImgExisted %>">
								
									<img src="<%=questionImageURL %>">
								
								</c:if>
								
								<div class="survey-write-answer-container">
								
									<c:choose>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_TEXT) 
											|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DATE)%>">
										
											<%
												String answer = SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId).get("answer");
											%>
											
											<textarea id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" 
												class="survey-write-textarea" rows="1" disabled="disabled"><%=answer %></textarea>
								 
											<div class="survey-write-textarea-baseline"></div>
										
										</c:when>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE) %>">
											
											<%
												List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
													.findBySurveyQuestionId(s_question.getSurveyQuestionId());
											
												Map<String, String> result = SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId);
											
												for(SurveyOption s_option : s_options){
													
													String optionImageURL = "";
													boolean optionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_option.getUploadFileId());
													
													if(optionImgExisted){
														ResourceURL optionImgURL = renderResponse.createResourceURL();
														optionImgURL.setResourceID("getFile");
														optionImgURL.setParameter("fileId", String.valueOf(s_option.getUploadFileId()));
														optionImgURL.setParameter("mainId", String.valueOf(s_writer.getSurveyMainId()));
														optionImageURL = optionImgURL.toString();
													}
													
													String checkedStatus = result.get("optionIds").equals(String.valueOf(s_option.getSurveyOptionId())) ? "checked" : "";
											%>
												<label class="survey-write-single-choice">
												
													<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>"
														type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %> disabled="disabled">
													
													<span class="survey-write-single-choice-checkmark-container">
													
														<span class="survey-write-single-choice-checkmark"></span>
													
													</span>
													
													<font><%=s_option.getOption() %></font>
													
												</label>
												
												<c:if test="<%=optionImgExisted %>">
												
													<img src="<%=optionImageURL %>">
												
												</c:if>
											<%
												}
												if(s_question.getHasOther()){
													
													String checkedStatus = result.get("optionIds").equals("-1") ? "checked" : "";
											%>
												<label class="survey-write-single-choice other-option">
												
													<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (s_question.getSurveyQuestionId() * -1) %>"
														type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %> disabled="disabled">
													
													<span class="survey-write-single-choice-checkmark-container">
													
														<span class="survey-write-single-choice-checkmark"></span>
													
													</span>
													
													<font><%=LanguageUtil.get(pageContext, "other-option-text") %></font>
													
													<span class="survey-other-option-input">
													
														<textarea id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" 
															class="survey-write-textarea" rows="1" disabled="disabled"><%=result.get("answer") %></textarea>
											 
														<span class="survey-write-textarea-baseline"></span>
													
													</span>
													
												</label>
											<%
												}
											%>
											
											<%
												if(s_main.getCalculateScore()){
													
													Map<String, Object> r_map = SurveyResultUtils.getResultInfoByQ_W(s_question.getSurveyQuestionId(), writerId);
											%>
											
												<div class='result-text <%=(Boolean)r_map.get("isCorrect") ? "result-correct" : "result-wrong" %>'>
												
													<i class='<%=(Boolean)r_map.get("isCorrect") ? "icon-ok" : "icon-remove" %>'></i>
													
													<%=(Boolean)r_map.get("isCorrect") ? LanguageUtil.get(pageContext, "correct") : LanguageUtil.get(pageContext, "wrong") %>
													
												</div>
												
												<%
													if(!(Boolean)r_map.get("isCorrect")){
														
														String[] correctOptionIds = StringUtil.split((String)r_map.get("correctOptionIds"));
												%>
												
													<div class="survey-correct-container well well-large">
														
														<div><%=LanguageUtil.get(pageContext, "correct-answer-title") %></div>
														
														<%
															for(String correctOptionId : correctOptionIds){
																
																SurveyOption correctOption = SurveyOptionLocalServiceUtil.fetchSurveyOption(Long.parseLong(correctOptionId));
														%>
															<div class="correct-answer"><%=correctOption.getOption() %></div>
														
														<%
															}
														%>
															
													</div>
												
												<%
													}
												%>
											
											<%
												}
											%>
											
										</c:when>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX) %>">
										
											<%
												List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
													.findBySurveyQuestionId(s_question.getSurveyQuestionId());
												
												Map<String, String> result = SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId);
											
												String optionIds = result.get("optionIds");
											
												for(SurveyOption s_option : s_options){
													
													String optionImageURL = "";
													boolean optionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_option.getUploadFileId());
													
													if(optionImgExisted){
														ResourceURL optionImgURL = renderResponse.createResourceURL();
														optionImgURL.setResourceID("getFile");
														optionImgURL.setParameter("fileId", String.valueOf(s_option.getUploadFileId()));
														optionImgURL.setParameter("mainId", String.valueOf(s_writer.getSurveyMainId()));
														optionImageURL = optionImgURL.toString();
													}
													
													String checkedStatus = StringUtil.contains(optionIds, String.valueOf(s_option.getSurveyOptionId()), ",") ? "checked" : "";
											%>
												<label class="survey-write-checkbox">
												
													<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>"
														type="checkbox" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %> disabled="disabled">
													
													<span class="survey-write-checkbox-checkmark-container">
													
														<span class="survey-write-checkbox-checkmark"></span>
													
													</span>
													
													<font><%=s_option.getOption() %></font>
													
												</label>
												
												<c:if test="<%=optionImgExisted %>">
												
													<img src="<%=optionImageURL %>">
												
												</c:if>
											<%
												}
												if(s_question.getHasOther()){
													
													String checkedStatus = StringUtil.contains(optionIds, String.valueOf(-1), ",") ? "checked" : "";
											%>
												<label class="survey-write-checkbox other-option">
												
													<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (s_question.getSurveyQuestionId() * -1) %>"
														type="checkbox" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %> disabled="disabled">
													
													<span class="survey-write-checkbox-checkmark-container">
													
														<span class="survey-write-checkbox-checkmark"></span>
													
													</span>
													
													<font><%=LanguageUtil.get(pageContext, "other-option-text") %></font>
													
													<span class="survey-other-option-input">
													
														<textarea id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" 
															class="survey-write-textarea" rows="1" disabled="disabled"><%=result.get("answer") %></textarea>
											 
														<span class="survey-write-textarea-baseline"></span>
													
													</span>
													
												</label>
											<%
												}
											%>
											
											<%
												if(s_main.getCalculateScore()){
													
													Map<String, Object> r_map = SurveyResultUtils.getResultInfoByQ_W(s_question.getSurveyQuestionId(), writerId);
											%>
											
												<div class='result-text <%=(Boolean)r_map.get("isCorrect") ? "result-correct" : "result-wrong" %>'>
												
													<i class='<%=(Boolean)r_map.get("isCorrect") ? "icon-ok" : "icon-remove" %>'></i>
													
													<%=(Boolean)r_map.get("isCorrect") ? LanguageUtil.get(pageContext, "correct") : LanguageUtil.get(pageContext, "wrong") %>
													
												</div>
												
												<%
													if(!(Boolean)r_map.get("isCorrect")){
														
														String[] correctOptionIds = StringUtil.split((String)r_map.get("correctOptionIds"));
												%>
												
													<div class="survey-correct-container well well-large">
													
														<div><%=LanguageUtil.get(pageContext, "correct-answer-title") %></div>
														
														<%
															for(String correctOptionId : correctOptionIds){
																
																SurveyOption correctOption = SurveyOptionLocalServiceUtil.fetchSurveyOption(Long.parseLong(correctOptionId));
														%>
															<div class="correct-answer"><%=correctOption.getOption() %></div>
														
														<%
															}
														%>
															
													</div>
												
												<%
													}
												%>
											
											<%
												}
											%>
											
										</c:when>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DROPDOWN_LIST) %>">
										
											<%
												List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
													.findBySurveyQuestionId(s_question.getSurveyQuestionId());
											
												Map<String, String> result = SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId);
											
												String selectTitle = LanguageUtil.get(pageContext, "please-choose");
												
												if(!result.get("optionIds").equals("")){
													
													selectTitle = SurveyOptionLocalServiceUtil.fetchSurveyOption(Long.parseLong(result.get("optionIds"))).getOption();
												}
											%>
											
											<div class="survey-dropdown">
	
												<div class="survey-dropdown-title-row"> 
												
													<font class="survey-dropdown-title"><%=selectTitle %></font> 
													
													<i class="icon-caret-down"></i> 
													
												</div> 
												
												<div class="survey-dropdown-option-container"> 
													
													<label> 
													
														<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (s_question.getSurveyQuestionId() * -1) %>" 
															type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" data-text="<%=LanguageUtil.get(pageContext, "please-choose") %>" <%=result.get("optionIds").equals("") ? "checked" : "" %>>
														
														<%=LanguageUtil.get(pageContext, "please-choose") %>
														
													</label>
													
													<%
														for(SurveyOption s_option : s_options){
															
															String checkedStatus = result.get("optionIds").equals(String.valueOf(s_option.getSurveyOptionId())) ? "checked" : "";
													%>
														<label> 
													
															<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>" 
																type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" data-text="<%=s_option.getOption() %>" <%=checkedStatus %>>
															
															<%=s_option.getOption() %>
															
														</label>
													<%
														}
													%>
													
												</div> 
												
											</div>
											
											<%
												if(s_main.getCalculateScore()){
													
													Map<String, Object> r_map = SurveyResultUtils.getResultInfoByQ_W(s_question.getSurveyQuestionId(), writerId);
											%>
											
												<div class='result-text <%=(Boolean)r_map.get("isCorrect") ? "result-correct" : "result-wrong" %>'>
												
													<i class='<%=(Boolean)r_map.get("isCorrect") ? "icon-ok" : "icon-remove" %>'></i>
													
													<%=(Boolean)r_map.get("isCorrect") ? LanguageUtil.get(pageContext, "correct") : LanguageUtil.get(pageContext, "wrong") %>
													
												</div>
												
												<%
													if(!(Boolean)r_map.get("isCorrect")){
														
														String[] correctOptionIds = StringUtil.split((String)r_map.get("correctOptionIds"));
												%>
												
													<div class="survey-correct-container well well-large">
														
														<div><%=LanguageUtil.get(pageContext, "correct-answer-title") %></div>
														
														<%
															for(String correctOptionId : correctOptionIds){
																
																SurveyOption correctOption = SurveyOptionLocalServiceUtil.fetchSurveyOption(Long.parseLong(correctOptionId));
														%>
															<div class="correct-answer"><%=correctOption.getOption() %></div>
														
														<%
															}
														%>
															
													</div>
												
												<%
													}
												%>
											
											<%
												}
											%>
										
										</c:when>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_STAR) %>">
										
											<%
												int answer = Integer.parseInt(SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId).get("answer"));
												
												for(int i = 1; i <= s_question.getStarsCount(); i++){
											%>
												<label class="survey-write-star">
												
													<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + s_question.getNo() + "_" + i %>"
														type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=answer == i ? "checked" : "" %> disabled="disabled">
														
													<i class='<%=answer >= i ? "icon-star" : "icon-star-empty" %>'></i>
												
												</label>
											<%
												}
											%>
										
										</c:when>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) %>">
										
											<%
												List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
													.findBySurveyQuestionId(s_question.getSurveyQuestionId());
												List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil
													.findByParentId(s_question.getSurveyQuestionId());
												
												int rowCount = 1;
											%>
											
											<table>
											
												<tbody>
												
													<tr>
														<td></td>
														<%
															for(SurveyOption s_option : s_options){
														%>
															<td><%=s_option.getOption() %></td>
														<%
															}
														%>
													</tr>
													
													<%
														for(SurveyQuestion sub_question : sub_questions){
															
															Map<String, String> result = SurveyResultLocalServiceUtil.getResultByQ_W(sub_question.getSurveyQuestionId(), writerId);
													%>
														<tr id='<%="survey_write_question_" + s_question.getNo() + "_" + sub_question.getNo() %>'>
															<td><%=sub_question.getQuestion() %></td>
															<%
																for(SurveyOption s_option : s_options){
																	
																	String checkedStatus = result.get("optionIds").equals(String.valueOf(s_option.getSurveyOptionId())) ? "checked" : "";
															%>
																<td>
																
																	<label class="survey-write-single-choice">
												
																		<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + rowCount + "_" + (randomNumber * s_option.getSurveyOptionId()) %>" type="radio" 
																			class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * sub_question.getSurveyQuestionId() %>" <%=checkedStatus %> disabled="disabled">
																		
																		<span class="survey-write-single-choice-checkmark-container">
																		
																			<span class="survey-write-single-choice-checkmark"></span>
																		
																		</span>
																		
																	</label>
																	
																</td>
															<%
																}
															%>
														</tr>
													<%
															rowCount++;
														}
													%>
													
												</tbody>
												
											</table>
										
										</c:when>
										
										<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE) %>">
										
											<%
												List<SurveyOption> s_options = SurveyOptionLocalServiceUtil
													.findBySurveyQuestionId(s_question.getSurveyQuestionId());
												List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil
													.findByParentId(s_question.getSurveyQuestionId());
												
												int rowCount = 1;
											%>
											
											<table>
											
												<tbody>
												
													<tr>
														<td></td>
														<%
															for(SurveyOption s_option : s_options){
														%>
															<td><%=s_option.getOption() %></td>
														<%
															}
														%>
													</tr>
													
													<%
														for(SurveyQuestion sub_question : sub_questions){
															
															Map<String, String> result = SurveyResultLocalServiceUtil.getResultByQ_W(sub_question.getSurveyQuestionId(), writerId);
													
															String optionIds = result.get("optionIds");
													%>
														<tr id='<%="survey_write_question_" + s_question.getNo() + "_" + sub_question.getNo() %>'>
															<td><%=sub_question.getQuestion() %></td>
															<%
																for(SurveyOption s_option : s_options){
																	
																	String checkedStatus = StringUtil.contains(optionIds, String.valueOf(s_option.getSurveyOptionId())) ? "checked" : "";
															%>
																<td>
																
																	<label class="survey-write-checkbox">
												
																		<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + rowCount + "_" + (randomNumber * s_option.getSurveyOptionId()) %>" type="checkbox" 
																			class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * sub_question.getSurveyQuestionId() %>" <%=checkedStatus %> disabled="disabled">
																		
																		<span class="survey-write-checkbox-checkmark-container">
																		
																			<span class="survey-write-checkbox-checkmark"></span>
																		
																		</span>
																		
																	</label>
																	
																</td>
															<%
																}
															%>
														</tr>
													<%
															rowCount++;
														}
													%>
													
												</tbody>
												
											</table>
										
										</c:when>
									
									</c:choose>
								
								</div>
							
							</div>
						
						</div>
					<%
						}
					%>
					
				</div>
				
			</div>
		<%
			}
		%>
		
	</div>

</aui:layout>

<aui:script>
	
	var windowWidth = $(window).width();
	var spacingLength = 17;
	
	if(windowWidth <= 767){
		spacingLength = 24;
	}else if(windowWidth < 1200 && windowWidth > 767){
		spacingLength = 19;
	}
	
	$.each(
		$("textarea"), function(index, textarea){
			$(textarea).next().css('bottom', (spacingLength - 2) + 'px');
			$(textarea).height('auto');
			$(textarea).height($(textarea).get(0).scrollHeight + (spacingLength - 2) + 'px');
		}
	);
	
	// drop down list title event
	$('.survey-dropdown-title-row').on(
			
		'click', function(){
			
			var optionContainer = $(this).next();
			
			if(optionContainer.hasClass('open'))
				optionContainer.removeClass('open');
			else
				optionContainer.addClass('open');
		}	
	);

</aui:script>