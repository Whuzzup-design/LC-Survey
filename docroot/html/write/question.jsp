<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/html/init.jsp" %>

<link href="<%=request.getContextPath() %>/css/write/layout.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/write/question.css" rel="stylesheet" type="text/css">

<%
	long mainId = ParamUtil.getLong(request, "mainId");
	long pageId = ParamUtil.getLong(request, "pageId");
	long writerId = ParamUtil.getLong(request, "writerId");
	long randomNumber = SurveyUtils.randomNumber();
	
	SurveyMain s_main = SurveyMainLocalServiceUtil.fetchSurveyMain(mainId);
	SurveyPage s_page = SurveyPageLocalServiceUtil.fetchSurveyPage(pageId);
	
	List<SurveyQuestion> s_questions = SurveyQuestionLocalServiceUtil.findBySurveyPageId(pageId);
	List<SurveyOption> pageOptions = SurveyOptionLocalServiceUtil.findBySurveyPageId(pageId);
%>

<portlet:actionURL var="updateSurveyResultURL" name="updateSurveyResult">
	<portlet:param name="writerId" value="<%=String.valueOf(writerId) %>"/>
	<portlet:param name="pageId" value="<%=String.valueOf(pageId) %>"/>
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
</portlet:actionURL>

<portlet:actionURL var="redirectPrePageURL" name="redirectPrePage">
	<portlet:param name="writerId" value="<%=String.valueOf(writerId) %>"/>
	<portlet:param name="pageId" value="<%=String.valueOf(pageId) %>"/>
	<portlet:param name="mainId" value="<%=String.valueOf(mainId) %>"/>
</portlet:actionURL>

<liferay-util:include page="/html/write/css/main_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=s_main.getColor() %>"/>
</liferay-util:include>

<liferay-util:include page="/html/write/css/question_css.jsp" servletContext="<%=application %>">
	<liferay-util:param name="color" value="<%=s_main.getColor() %>"/>
</liferay-util:include>

<aui:layout>

	<div id="survey_write_layout">
	
		<p class="survey-write-title"><%=s_main.getTitle() %></p>
		
		<div class="survey-write-container">
		
			<div class="survey-write-container-header">
			
				<p><%=SurveyUtils.getOrdinalNumber(s_page.getNo()) %></p>
				
			</div>
			
			<div class="survey-write-container-body">
				
				<div class="survey-write-page"><%=s_page.getTitle() %></div>
				
				<%
					for(SurveyQuestion s_question : s_questions){
						
						if(s_question.getParentId() != 0)
							continue;
						
						String questionImageURL = "";
						boolean questionImgExisted = SurveyFileLocalServiceUtil.isExisted(s_question.getUploadFileId());
						
						if(questionImgExisted){
							ResourceURL questionImgURL = renderResponse.createResourceURL();
							questionImgURL.setResourceID("getFile");
							questionImgURL.setParameter("fileId", String.valueOf(s_question.getUploadFileId()));
							questionImgURL.setParameter("mainId", String.valueOf(mainId));
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
											class="survey-write-textarea" rows="1"><%=answer %></textarea>
							 
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
													optionImgURL.setParameter("mainId", String.valueOf(mainId));
													optionImageURL = optionImgURL.toString();
												}
												
												String checkedStatus = result.get("optionIds").equals(String.valueOf(s_option.getSurveyOptionId())) ? "checked" : "";
										%>
											<label class="survey-write-single-choice">
											
												<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>"
													type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %>>
												
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
													type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %>>
												
												<span class="survey-write-single-choice-checkmark-container">
												
													<span class="survey-write-single-choice-checkmark"></span>
												
												</span>
												
												<font><%=LanguageUtil.get(pageContext, "other-option-text") %></font>
												
												<span class="survey-other-option-input">
												
													<textarea id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" 
														class="survey-write-textarea" rows="1"><%=result.get("answer") %></textarea>
										 
													<span class="survey-write-textarea-baseline"></span>
												
												</span>
												
											</label>
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
													optionImgURL.setParameter("mainId", String.valueOf(mainId));
													optionImageURL = optionImgURL.toString();
												}
												
												String checkedStatus = StringUtil.contains(optionIds, String.valueOf(s_option.getSurveyOptionId()), ",") ? "checked" : "";
										%>
											<label class="survey-write-checkbox">
											
												<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + (randomNumber * s_option.getSurveyOptionId()) %>"
													type="checkbox" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %>>
												
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
													type="checkbox" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=checkedStatus %>>
												
												<span class="survey-write-checkbox-checkmark-container">
												
													<span class="survey-write-checkbox-checkmark"></span>
												
												</span>
												
												<font><%=LanguageUtil.get(pageContext, "other-option-text") %></font>
												
												<span class="survey-other-option-input">
												
													<textarea id="<%=SurveyConstants.SURVEY_QUESTION_ITEM_NAMESPACE + (randomNumber * s_question.getSurveyQuestionId()) %>" 
														class="survey-write-textarea" rows="1"><%=result.get("answer") %></textarea>
										 
													<span class="survey-write-textarea-baseline"></span>
												
												</span>
												
											</label>
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
									
									</c:when>
									
									<c:when test="<%=s_question.getType().equals(SurveyConstants.QUESTION_TYPE_STAR) %>">
									
										<%
											int answer = Integer.parseInt(SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId).get("answer"));
											
											for(int i = 1; i <= s_question.getStarsCount(); i++){
										%>
											<label class="survey-write-star">
											
												<input id="<%=SurveyConstants.SURVEY_OPTION_ITEM_NAMESPACE + s_question.getNo() + "_" + i %>"
													type="radio" class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * s_question.getSurveyQuestionId() %>" <%=answer == i ? "checked" : "" %>>
													
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
																		class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * sub_question.getSurveyQuestionId() %>" <%=checkedStatus %>>
																	
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
																		class="survey-hidden-input" name="<portlet:namespace/><%=randomNumber * sub_question.getSurveyQuestionId() %>" <%=checkedStatus %>>
																	
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
			
			<div class="survey-step-btn-container">
				
				<span id="survey_pre_btn" class="survey-step-btn">
				
					<i class="icon-chevron-left"></i>
					
				</span>
				
				<span id="survey_next_btn" class="survey-step-btn">
				
					<i class="icon-chevron-right"></i>
					
				</span>
				
			</div>
		
		</div>
		
	</div>
	
</aui:layout>

<script>
	
	//覆寫上一頁歷史瀏覽紀錄
	history.pushState(null, null, document.URL);
	history.back();
	history.forward();
	window.addEventListener('popstate', function () {
			history.go(1);
		}
	);

</script>

<aui:script use="survey-instance">
	
	<%
		for(SurveyQuestion s_question : s_questions){
			
			// 矩陣題的母題目不新增物件
			if((s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE)
				|| s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)) && s_question.getParentId() == 0)
				continue;
			
			String no = String.valueOf(s_question.getNo());
			
			if(s_question.getType().equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) || s_question.getType().equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE))
				no = String.valueOf(SurveyQuestionLocalServiceUtil.fetchSurveyQuestion(s_question.getParentId()).getNo())
					+ "_" + String.valueOf(s_question.getNo());
			
			Map<String, String> result = SurveyResultLocalServiceUtil.getResultByQ_W(s_question.getSurveyQuestionId(), writerId);
	%>
			new Liferay.SurveyWriteQuestion(
				{
					Id: '<%=s_question.getSurveyQuestionId() %>',
					elementId: '<%=randomNumber * s_question.getSurveyQuestionId() %>',
					no: '<%=no %>',
					type: '<%=s_question.getType() %>',
					hasOther: <%=s_question.getHasOther() %>,
					isRequired: <%=s_question.getIsRequired() %>,
					parentId: <%=s_question.getParentId() %>,
					starsCount: <%=s_question.getStarsCount() %>,
					answer: '<%=result.get("answer") %>',
					optionIds: '<%=result.get("optionIds") %>'
				}		
			).initialize();
	<%	
			// 下拉式選單要多一個"請選擇"的option object
			if(s_question.getType().equals(SurveyConstants.QUESTION_TYPE_DROPDOWN_LIST)){
	%>
				new Liferay.SurveyWriteOption(
					{
						Id: '',
						elementId: '<%=s_question.getSurveyQuestionId() * -1 %>',
						questionElementId: '<%=randomNumber * s_question.getSurveyQuestionId() %>'
					}		
				).initialize();
	<%
			}
		}
	%>
	
	<%
		for(SurveyOption s_option : pageOptions){
			
			String questionType = SurveyQuestionLocalServiceUtil.getTypeBySurveyQuestionId(s_option.getSurveyQuestionId());
			
			if(questionType.equals(SurveyConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE) || questionType.equals(SurveyConstants.QUESTION_TYPE_CHECKBOX_LATTICE)){
				
				List<SurveyQuestion> sub_questions = SurveyQuestionLocalServiceUtil.findByParentId(s_option.getSurveyQuestionId());
				int rowCount = 1;
				
				for(SurveyQuestion sub_question : sub_questions){
	%>
					new Liferay.SurveyWriteOption(
						{
							Id: '<%=s_option.getSurveyOptionId() %>',
							elementId: '<%=rowCount + "_" + randomNumber * s_option.getSurveyOptionId() %>',
							questionElementId: '<%=randomNumber * sub_question.getSurveyQuestionId() %>'
						}		
					).initialize();
	<%
					rowCount++;
				}
				
			}else{
	%>
				new Liferay.SurveyWriteOption(
					{
						Id: '<%=s_option.getSurveyOptionId() %>',
						elementId: '<%=randomNumber * s_option.getSurveyOptionId() %>',
						questionElementId: '<%=randomNumber * s_option.getSurveyQuestionId() %>'
					}		
				).initialize();
	<%
			}
		}
	%>
	
	var writeTool = new Liferay.SurveyWriteTool(
		{
			updateTrigger: '#survey_next_btn',
			prePageTrigger: '#survey_pre_btn',
			updateURL: '<%=updateSurveyResultURL %>',
			prePageURL: '<%=redirectPrePageURL %>'
		}		
	);
	writeTool.initialize();

</aui:script>