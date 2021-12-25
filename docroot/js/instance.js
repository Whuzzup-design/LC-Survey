AUI.add(

	'survey-instance', function(A){
		
		var SurveyInstanceConstants = {
			
			SURVEY_TODAY_DATE: '',
				
			SURVEY_MAIN_ITEM_NAMESPACE: "survey_main_item_",
			
			SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE: "survey_page_arch_",
			
			SURVEY_QUESTION_ARCHITECTURE_ITEM_NAMESPACE: "survey_question_arch_",
			
			SURVEY_PAGE_ITEM_NAMESPACE: "survey_page_item_",
			
			SURVEY_QUESTION_ITEM_NAMESPACE: "survey_question_item_",
			
			SURVEY_SUB_QUESTION_ITEM_NAMESPACE: "survey_sub_question_item_",
			
			SURVEY_OPTION_ITEM_NAMESPACE: "survey_option_item_",
			
			SURVEY_IMG_ITEM_NAMESPACE: "survey_img_item_",
			
			SURVEY_RESULT_ITEM_NAMESPACE: "survey_result_item_",
			
			QUESTION_TYPE_TEXT: "text",
			
			QUESTION_TYPE_SINGLE_CHOICE: "single-choice",
			
			QUESTION_TYPE_CHECKBOX: "checkbox",
			
			QUESTION_TYPE_DROPDOWN_LIST: "dropdown-list",
			
			QUESTION_TYPE_DATE: "date",
			
			QUESTION_TYPE_STAR: "star",
			
			QUESTION_TYPE_SINGLE_CHOICE_LATTICE: "single-choice-lattice",
			
			QUESTION_TYPE_CHECKBOX_LATTICE: "checkbox-lattice",
			
			TEXT_FONT: Liferay.Language.get('text-question'),
			
			SINGLE_CHOICE_FONT: Liferay.Language.get('single-choice-question'),
			
			CHECKBOX_FONT: Liferay.Language.get('checkbox-question'),
			
			DROPDOWN_LIST_FONT: Liferay.Language.get('dropdown-list-question'),
			
			DATE_FONT: Liferay.Language.get('date-question'),
			
			STAR_FONT: Liferay.Language.get('star-question'),
			
			SINGLE_CHOICE_LATTICE_FONT: Liferay.Language.get('single-choice-lattice-question'),
			
			CHECKBOX_LATTICE_FONT: Liferay.Language.get('checkbox-lattice-question'),
			
			IS_REQUIRED: Liferay.Language.get('required'),
			
			OTHER_OPTION: Liferay.Language.get('other-option'),

			POINTS: Liferay.Language.get('points'),
			
			STARS_COUNT: Liferay.Language.get('stars-count'),
			
			ADD_PICTURE: Liferay.Language.get('add-picture'),
			
			DELETE: Liferay.Language.get('delete'),
			
			SETTING: Liferay.Language.get('setting'),
			
			UNTITLED_SURVEY: Liferay.Language.get('untitled-survey'),
			
			UNTITLED_PAGE: Liferay.Language.get('untitled-page'),
			
			UNDEFINED_QUESTION: Liferay.Language.get('undefined-question'),
			
			DELETE_CONFIRM_FONT: Liferay.Language.get('delete-confirm'),
			
			PLEASE_ENTER_PAGE: Liferay.Language.get('please-enter-the-title-of-this-page'),
			
			PLEASE_ENTER_QUESTION: Liferay.Language.get('please-enter-a-question'),
			
			PLEASE_ENTER_OPTION: Liferay.Language.get('please-enter-a-option'),
			
			CREATE_OPTION: Liferay.Language.get('create-option'),
			
			CREATE_QUESTION: Liferay.Language.get('create-question'),
			
			GUIDE_TO: Liferay.Language.get('guide-to-prefix-word'),
			
			NO_SETTING: Liferay.Language.get('no-setting'),
			
			SUBMIT_FORM: Liferay.Language.get('submit-form'),
			
			CORRECT_ANSWER: Liferay.Language.get('correct-answer'),
			
			INCORRECT_ANSWER: Liferay.Language.get('incorrect-answer'),
			
			SURVEY_TITLE_LENGTH_WARNING_TEXT: Liferay.Language.get('survey-title-length-can-not-exceed-200'),
			
			PAGE_TITLE_LENGTH_WARNING_TEXT: Liferay.Language.get('page-title-length-can-not-exceed-200'),
			
			QUESTION_LENGTH_WARNING_TEXT: Liferay.Language.get('question-length-can-not-exceed-500'),
			
			OPTION_LENGTH_WARNING_TEXT: Liferay.Language.get('option-length-can-not-exceed-200'),
			
			QUESTION_IS_REQUIRED: Liferay.Language.get('this-question-is-required'),
			
			PAGE_ARCHITECTURE_UI: function(archId, dataSort){
				
				var instance = this;
				
				return '<div id="'
						+ archId + '" class="survey-architecture-item survey-page-architecture" data-page-sort="'
						+ dataSort + '"> <i class="icon-chevron-sign-right page-collapse-btn"></i> <span class="survey-page-text">'
						+ instance.UNTITLED_PAGE + '</span> <div class="survey-ques-architecture-container"></div> </div>'
			},
			
			QUESTION_ARCHITECTURE_UI: function(archId, dataSort){
				
				var instance = this;
				
				return '<div id="' 
						+ archId + '" class="survey-architecture-item survey-ques-architecture" data-question-sort="' 
						+ dataSort + '">' 
						+ instance.UNDEFINED_QUESTION + '</div>'
			},
			
			PAGE_UI: function(elementId, dataSort){
				
				var instance = this;
				
				return '<div id="'
						+ instance.SURVEY_PAGE_ITEM_NAMESPACE
						+ elementId + '" class="survey-page" data-sort="'
						+ dataSort + '"> <input name="pageTitle" class="survey-input survey-large-input" placeholder="'
						+ instance.PLEASE_ENTER_PAGE + '" value="'
						+ instance.UNTITLED_PAGE + '"> <div class="survey-question-container"></div> </div>'
			},
			
			TEXT_QUESTION_UI: function(elementId, dataSort){
				
				var instance = this;
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="' 
						+ dataSort + '"> <div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-pencil"></i>'
						+ instance.TEXT_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> </div>'
			},
			
			SINGLE_CHOICE_QUESTION_UI: function(elementId, dataSort, calculateScore){
				
				var instance = this;
				var hiddenPointsClass = calculateScore ? "" : "label-hidden";
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="'
						+ dataSort + '"><div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-ok-sign"></i>'
						+ instance.SINGLE_CHOICE_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> <span class="label label-warning label-hidden"> <i class="icon-certificate"></i>'
						+ instance.OTHER_OPTION + '</span> <span class="label label-info '
						+ hiddenPointsClass + '" <i class="icon-asterisk"></i>'
						+ instance.POINTS + '：0 </span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> <div class="survey-option-container"></div> <a class="survey-plus-option-btn"><i class="icon-plus-sign"></i>'
						+ instance.CREATE_OPTION + '</a> </div>'
			},
			
			CHECKBOX_QUESTION_UI: function(elementId, dataSort, calculateScore){

				var instance = this;
				var hiddenPointsClass = calculateScore ? "" : "label-hidden";
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="'
						+ dataSort + '"><div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-sign-blank"></i>'
						+ instance.CHECKBOX_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> <span class="label label-warning label-hidden"> <i class="icon-certificate"></i>'
						+ instance.OTHER_OPTION + '</span> <span class="label label-info '
						+ hiddenPointsClass + '" <i class="icon-asterisk"></i>'
						+ instance.POINTS + '：0 </span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> <div class="survey-option-container"></div> <a class="survey-plus-option-btn"><i class="icon-plus-sign"></i>'
						+ instance.CREATE_OPTION + '</a> </div>'
			},
			
			DROPDOWN_LIST_QUESTION_UI: function(elementId, dataSort, calculateScore){

				var instance = this;
				var hiddenPointsClass = calculateScore ? "" : "label-hidden";
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="'
						+ dataSort + '"><div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-list-ul"></i>'
						+ instance.DROPDOWN_LIST_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> <span class="label label-info '
						+ hiddenPointsClass + '" <i class="icon-asterisk"></i>'
						+ instance.POINTS + '：0 </span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> <div class="survey-option-container"></div> <a class="survey-plus-option-btn"><i class="icon-plus-sign"></i>'
						+ instance.CREATE_OPTION + '</a> </div>'
			},
			
			DATE_QUESTION_UI: function(elementId, dataSort){
				
				var instance = this;
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="' 
						+ dataSort + '"> <div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-calendar"></i>'
						+ instance.DATE_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> </div>'
			},
			
			STAR_QUESTION_UI: function(elementId, dataSort){

				var instance = this;
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="' 
						+ dataSort + '"> <div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-star"></i>'
						+ instance.STAR_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> <span class="label label-inverse"> <i class="icon-sort-by-order"></i>'
						+ instance.STARS_COUNT + '：1 </span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> </div>'
			},
			
			SINGLE_CHOICE_LATTICE_QUESTION_UI: function(elementId, dataSort){
				
				var instance = this;
				
				return '<div id="' 
						+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-question" data-sort="' 
						+ dataSort + '"> <div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-th"></i>'
						+ instance.SINGLE_CHOICE_LATTICE_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
						+ instance.IS_REQUIRED + '</span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
						+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
						+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
						+ instance.PLEASE_ENTER_QUESTION + '" value="' 
						+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> <div class="survey-option-container"> <p>' 
						+ Liferay.Language.get("options") + '</p> </div> <a class="survey-plus-option-btn"><i class="icon-plus-sign"></i>'
						+ instance.CREATE_OPTION + '</a> <div class="survey-sub-question-container"> <p>' 
						+ Liferay.Language.get("questions") + '</p> </div> <a class="survey-plus-sub-question-btn"><i class="icon-plus-sign"></i>' 
						+ instance.CREATE_QUESTION + '</a> </div>'
			},
			
			CHECKBOX_LATTICE_QUESTION_UI: function(elementId, dataSort){
				
				var instance = this;
				
				return '<div id="' 
				+ instance.SURVEY_QUESTION_ITEM_NAMESPACE 
				+ elementId + '" class="survey-question" data-sort="' 
				+ dataSort + '"> <div class="survey-question-bar"> <div class="survey-question-bar-container"> <div class="survey-question-tip-bar"> <span class="label label-success"> <i class="icon-th-large"></i>'
				+ instance.CHECKBOX_LATTICE_FONT + '</span> <span class="label label-important label-hidden"> <i class="icon-exclamation-sign"></i>'
				+ instance.IS_REQUIRED + '</span> </div> <div class="survey-question-tool-bar"> <i class="icon-picture survey-question-tool-btn" data-tips="'
				+ instance.ADD_PICTURE + '"></i> <i class="icon-trash survey-question-tool-btn" data-tips="'
				+ instance.DELETE + '"></i> <i class="icon-cog survey-question-tool-btn" data-tips="'
				+ instance.SETTING + '"></i> </div> </div> </div> <input name="questionTitle" class="survey-input" placeholder="' 
				+ instance.PLEASE_ENTER_QUESTION + '" value="' 
				+ instance.UNDEFINED_QUESTION + '"> <div class="survey-question-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> <div class="survey-option-container"> <p>' 
				+ Liferay.Language.get("options") + '</p> </div> <a class="survey-plus-option-btn"><i class="icon-plus-sign"></i>'
				+ instance.CREATE_OPTION + '</a> <div class="survey-sub-question-container"> <p>' 
				+ Liferay.Language.get("questions") + '</p> </div> <a class="survey-plus-sub-question-btn"><i class="icon-plus-sign"></i>' 
				+ instance.CREATE_QUESTION + '</a> </div>'
			},
			
			OPTION_UI: function(elementId, showPageGuide, questionType, calculateScore){
				
				var instance = this;
				var hiddenPageGuideClass = "survey-option-direct-hidden";
				var iconClass = "icon-circle";
				var optionImageIcon = '<i class="icon-picture survey-option-tool-btn" data-tips="' + instance.ADD_PICTURE + '"></i>';
				var answerClass = "";
				var answerDataTips = "";
				
				// page guide
				if(showPageGuide)
					hiddenPageGuideClass = "";
				
				// option icon
				if(questionType == instance.QUESTION_TYPE_CHECKBOX)
					iconClass = "icon-sign-blank";
				else if(questionType == instance.QUESTION_TYPE_DROPDOWN_LIST)
					iconClass = "icon-list-ul";
				
				// image icon
				if(questionType == instance.QUESTION_TYPE_DROPDOWN_LIST)
					optionImageIcon = "";
				
				// answer class
				if(calculateScore){
					answerClass = "survey-answer";
					answerDataTips = instance.INCORRECT_ANSWER;
				}
				
				return '<div id="' 
						+ instance.SURVEY_OPTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-option"> <i class="' 
						+ iconClass + ' survey-option-mark ' 
						+ answerClass + '" data-tips="' 
						+ answerDataTips + '"></i> <input name="optionTitle" class="survey-input survey-medium-input" placeholder="'
						+ instance.PLEASE_ENTER_OPTION + '"> <span class="survey-option-tool-bar"> <i class="icon-remove survey-option-tool-btn" data-tips="'
						+ instance.DELETE + '"></i>' 
						+ optionImageIcon + ' </span> <span class="survey-option-direct '
						+ hiddenPageGuideClass + '">' 
						+ instance.GUIDE_TO
						+ instance.NO_SETTING + '</span> <div class="survey-option-image image-hidden"> <img src=""> <div class="remove-img-btn"> <i class="icon-remove-sign"></i> </div> </div> </div>'
			},
			
			SINGLE_CHOICE_LATTICE_OPTION_UI: function(elementId){
				
				var instance = this;
				
				return '<div id="' 
						+ instance.SURVEY_OPTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-option"> <i class="icon-ok-sign survey-option-mark"></i> <input name="optionTitle" class="survey-input survey-medium-input" placeholder="'
						+ instance.PLEASE_ENTER_OPTION + '"> <span class="survey-option-tool-bar"> <i class="icon-remove survey-option-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> </span> </div>'
			},
			
			CHECKBOX_LATTICE_OPTION_UI: function(elementId){
				
				var instance = this;
				
				return '<div id="' 
				+ instance.SURVEY_OPTION_ITEM_NAMESPACE 
				+ elementId + '" class="survey-option"> <i class="icon-sign-blank survey-option-mark"></i> <input name="optionTitle" class="survey-input survey-medium-input" placeholder="'
				+ instance.PLEASE_ENTER_OPTION + '"> <span class="survey-option-tool-bar"> <i class="icon-remove survey-option-tool-btn" data-tips="'
				+ instance.DELETE + '"></i> </span> </div>'
			},
			
			LATTICE_SUB_QUESTION_UI: function(elementId){
				
				var instance = this;
				
				return '<div id="' 
						+ instance.SURVEY_SUB_QUESTION_ITEM_NAMESPACE 
						+ elementId + '" class="survey-sub-question"> <i class="icon-align-justify survey-sub-question-mark"></i> <input name="subQuestionTitle" class="survey-input survey-medium-input" placeholder="'
						+ instance.PLEASE_ENTER_QUESTION + '"> <span class="survey-sub-question-tool-bar"> <i class="icon-remove survey-sub-question-tool-btn" data-tips="'
						+ instance.DELETE + '"></i> </span> </div>'
			},
			
			QUESTION_IS_REQUIRED_UI: function(){
				
				return '<div class="survey-write-question-required-font">' + this.QUESTION_IS_REQUIRED + '</div>'
			},
		}
		Liferay.SurveyInstanceConstants = SurveyInstanceConstants;
		
		var SurveyInstanceCollection = {
			
			surveyMainSetting: null,
				
			pageArray: [],
			
			questionArray: [],
			
			subQuestionArray: [],
			
			optionArray: [],
			
			writeQuestionArray: [],
			
			writeOptionArray: [],
			
			getInstanceByElementId: function(type ,elementId){
				
				var instance = this;
				var obj = null;
				
				if(type == 'page'){
					for(var v = 0; v < instance.pageArray.length; v++){
						if(instance.pageArray[v].elementId == elementId){
							obj = instance.pageArray[v];
							break;
						}
					}
				}else if(type == 'question'){
					for(var v = 0; v < instance.questionArray.length; v++){
						if(instance.questionArray[v].elementId == elementId){
							obj = instance.questionArray[v];
							break;
						}
					}
				}else if(type == 'subQuestion'){
					for(var v = 0; v < instance.subQuestionArray.length; v++){
						if(instance.subQuestionArray[v].elementId == elementId){
							obj = instance.subQuestionArray[v];
							break;
						}
					}
				}else if(type == 'option'){
					for(var v = 0; v < instance.optionArray.length; v++){
						if(instance.optionArray[v].elementId == elementId){
							obj = instance.optionArray[v];
							break;
						}
					}
				}else if(type == 'write_question'){
					for(var v = 0; v < instance.writeQuestionArray.length; v++){
						if(instance.writeQuestionArray[v].elementId == elementId){
							obj = instance.writeQuestionArray[v];
							break;
						}
					}
				}else{
					for(var v = 0; v < instance.writeOptionArray.length; v++){
						if(instance.writeOptionArray[v].elementId == elementId){
							obj = instance.writeOptionArray[v];
							break;
						}
					}
				}
				
				return obj;
			},
			
			getLastPageIndex: function(){
				
				var lastIndex = 1;
				var instance = this;
				
				for(var v = 0; v < instance.pageArray.length; v++){
					if(instance.pageArray[v].no > lastIndex){
						lastIndex = instance.pageArray[v].no;
					}
				}
				return lastIndex
			},
			
			getLastQuestionIndexByPageId: function(pageId){
				
				var lastIndex = 1;
				var instance = this;
				
				var questions = instance.questionArray.filter(
					function(question){
						return question.pageId == pageId;
					}	
				);
				
				if(questions.length == 0)
					return 0;
				
				for(var v = 0; v < questions.length; v++){
					if(questions[v].no > lastIndex){
						lastIndex = questions[v].no;
					}
				}
				return lastIndex
			},
			
			getLastSubQuestionIndexByQuestionId: function(questionId){
				
				var lastIndex = 1;
				var instance = this;
				
				var subQuesitons = instance.subQuestionArray.filter(
					function(subQuesiton){
						return subQuesiton.parentElementId == questionId;
					}	
				);
				
				if(subQuesitons.length == 0)
					return 0;
				
				for(var v = 0; v < subQuesitons.length; v++){
					if(subQuesitons[v].no > lastIndex){
						lastIndex = subQuesitons[v].no;
					}
				}
				return lastIndex
			},
			
			getLastOptionIndexByQuestionId: function(questionId){
				
				var lastIndex = 1;
				var instance = this;
				
				var options = instance.optionArray.filter(
					function(option){
						return option.questionId == questionId;
					}	
				);
				
				if(options.length == 0)
					return 0;
				
				for(var v = 0; v < options.length; v++){
					if(options[v].no > lastIndex){
						lastIndex = options[v].no;
					}
				}
				return lastIndex
			},
			
			removeArrayObject: function(array, obj){
				
				array.splice(array.indexOf(obj), 1);
			},
			
			removeQuestionsByPageId: function(pageId){
				
				var instance = this;
				
				for(var v = 0; v < instance.questionArray.length; v++){
					if(instance.questionArray[v].pageId == pageId){
						instance.removeArrayObject(instance.questionArray, instance.questionArray[v]);
						v--;
					}
				}
			},
			
			removeSubQuestionByPageId: function(pageId){
				
				var instance = this;
				
				for(var v = 0; v < instance.subQuestionArray.length; v++){
					if(instance.subQuestionArray[v].pageId == pageId){
						instance.removeArrayObject(instance.subQuestionArray, instance.subQuestionArray[v]);
						v--;
					}
				}
			},
			
			removeSubQuestionByQuestionId: function(questionId){
				
				var instance = this;
				
				for(var v = 0; v < instance.subQuestionArray.length; v++){
					if(instance.subQuestionArray[v].parentElementId == questionId){
						instance.removeArrayObject(instance.subQuestionArray, instance.subQuestionArray[v]);
						v--;
					}
				}
			},
			
			removeOptionsByPageId: function(pageId){
				
				var instance = this;
				
				for(var v = 0; v < instance.optionArray.length; v++){
					if(instance.optionArray[v].pageId == pageId){
						instance.removeArrayObject(instance.optionArray, instance.optionArray[v]);
						v--;
					}
				}
			},
			
			removeOptionsByQuestionId: function(questionId){
				
				var instance = this;
				
				for(var v = 0; v < instance.optionArray.length; v++){
					if(instance.optionArray[v].questionId == questionId){
						instance.removeArrayObject(instance.optionArray, instance.optionArray[v]);
						v--;
					}
				}
			},
			
			refreshPageNo: function(){
				
				var instance = this;
				var pageArchs = $('.survey-page-architecture-container').find('.survey-page-architecture');
				
				// set survey main setting data sort
				$('#survey_main_page').attr('data-sort', 0);
				
				for(var v = 0; v < pageArchs.length; v++){
					
					var pageId = $(pageArchs[v]).attr('id');
					var instanceElementId = pageId.substring(pageId.lastIndexOf("_") + 1, pageId.length);
					
					instance.getInstanceByElementId('page', instanceElementId).no = (v + 1);
					
					// set page architecture data-page-sort
					$(pageArchs[v]).attr('data-page-sort', v + 1);
					
					// set page data-sort
					$("#" + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instanceElementId)
						.attr('data-sort', v + 1);
				}
			},
			
			refreshQuestionsNoByPageId: function(pageId){
				
				var instance = this;
				var questionArchs = $('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + pageId)
					.find('.survey-ques-architecture');
				
				for(var v = 0; v < questionArchs.length; v++){
					
					var questionIdArchId = $(questionArchs[v]).attr('id');
					var instanceElementId = questionIdArchId.substring(questionIdArchId.lastIndexOf("_") + 1, questionIdArchId.length);
					
					instance.getInstanceByElementId('question', instanceElementId).no = (v + 1);
					
					// set question architecture data-question-sort
					$(questionArchs[v]).attr('data-question-sort', v + 1);
					
					// set question data-sort
					$("#" + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instanceElementId)
						.attr('data-sort', v + 1);
				}
			},
			
			refreshSubQuestionsNoByQuestionId: function(questionId){
				
				var instance = this;
				var subQuestions = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + questionId)
					.find('.survey-sub-question');
				
				for(var v = 0; v < subQuestions.length; v++){
					
					var subQuestionId = $(subQuestions[v]).attr('id');
					var instanceElementId = subQuestionId.substring(subQuestionId.lastIndexOf("_") + 1, subQuestionId.length);
					
					instance.getInstanceByElementId('subQuestion', instanceElementId).no = (v + 1);
				}
			},
			
			refreshOptionsNoByQuestionId: function(questionId){
				
				var instance = this;
				var options = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + questionId)
					.find('.survey-option');
				
				for(var v = 0; v < options.length; v++){
					
					var optionId = $(options[v]).attr('id');
					var instanceElementId = optionId.substring(optionId.lastIndexOf("_") + 1, optionId.length);
					
					instance.getInstanceByElementId('option', instanceElementId).no = (v + 1);
				}
			},
			
			resetPageDirectFont: function(pageDirectId, pageTitle){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + pageDirectId)
					.find('.survey-page-text')
					.html(pageTitle);
				
				for(var v = 0; v < instance.optionArray.length; v++){
					
					if(instance.optionArray[v].pageDirectId == pageDirectId){
						
						$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.optionArray[v].elementId)
							.find('.survey-option-direct')
							.html(Liferay.SurveyInstanceConstants.GUIDE_TO + pageTitle);
					}
				}
			},
			
			resetOptionPageDirect: function(quesElementId){
				
				var instance = this;
				
				var options = instance.optionArray.filter(
					function(item){
						return item.questionId == quesElementId;
					}
				)
				
				for(var v = 0; v < options.length; v++){
					
					options[v].pageDirect = 0;
					options[v].pageDirectId = 0;
					
					$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + options[v].elementId)
						.find('.survey-option-direct')
						.html(Liferay.SurveyInstanceConstants.GUIDE_TO + Liferay.SurveyInstanceConstants.NO_SETTING);
				}
			},
			
			// refresh page and option page direct when user click save button
			refreshPageDirect: function(){
				
				var instance = this;
				
				$.each(
					instance.pageArray, function(index, page){
						
						if(page.pageDirectId != 0 && page.pageDirectId != -1){
							page.pageDirect = instance.getInstanceByElementId('page', page.pageDirectId).no;
						}else{
							page.pageDirect = page.pageDirectId;
						}
					}
				);
				$.each(
					instance.optionArray, function(index, option){
						
						if(option.pageDirectId != 0 && option.pageDirectId != -1){
							option.pageDirect = instance.getInstanceByElementId('page', option.pageDirectId).no;
						}else{
							option.pageDirect = option.pageDirectId;
						}
					}
				);
			},
			
			removeInstanceFileId: function(removedFileId){
				
				var instance = this;
				
				var removedFileIdAry = removedFileId.split(",");
				
				$.each(
					instance.questionArray, function(index, question){
						
						var equal = removedFileIdAry.some(
							function(item, index, array){
								return item == question.fileId;
							}	
						);
						
						if(equal)
							question.resetFileId();
					}
				);
				$.each(
					instance.optionArray, function(index, option){
						
						var equal = removedFileIdAry.some(
							function(item, index, array){
								return item == option.fileId;
							}	
						);
						
						if(equal)
							option.resetFileId();
					}
				);
			},
			
			// when delete page will call
			removePageDirect: function(pageDirectId){
				
				var instance = this;
				
				$.each(
					instance.pageArray, function(index, page){
						
						if(pageDirectId == page.pageDirectId)
							page.setPageDirect(0);
					}
				);
				
				$.each(
					instance.optionArray, function(index, option){
						
						if(pageDirectId == option.pageDirectId)
							option.setPageDirect(0);
					}
				);
			},
			
			// get write questions by parentId
			getWriteQuestionsByParentId: function(parentId){
				
				var instance = this;
				var ary = [];
				
				for(var v = 0; v < instance.writeQuestionArray.length; v++){
					if(instance.writeQuestionArray[v].parentId == parentId){
						ary.push(instance.writeQuestionArray[v]);
					}
				}
				
				return ary;
			}
		}
		Liferay.SurveyInstanceCollection = SurveyInstanceCollection;
		
		var SurveyUtils = {
			
			createRandomNumber: function(){
				
				var number = "";
				var possible = "0123456789";
				
				for (var i = 0; i <= 10; i++)
					number += possible.charAt(Math.floor(Math.random() * possible.length));
				
				return number;
			}
		}
		Liferay.SurveyUtils = SurveyUtils;
		
		var SurveyMainSetting = function(){
			
			var instance = this;
			
			instance.title = arguments[0].title;
			
			instance.description = arguments[0].description;
			
			instance.epilog = arguments[0].epilog;
			
			instance.startDate = arguments[0].startDate;
			
			instance.endDate = arguments[0].endDate;
			
			instance.needAuth = arguments[0].needAuth;
			
			instance.calculateScore = arguments[0].calculateScore;
			
			instance.viewAnswer = arguments[0].viewAnswer;
			
			instance.color = arguments[0].color;
			
			Liferay.SurveyInstanceCollection.surveyMainSetting = instance;
		}
		
		SurveyMainSetting.prototype = {
				
			initialize: function(){
				
				var instance = this;
				
				instance._settingArchitectureClick();
				
				instance._pageArchitectureMove();
				
				instance._titleInputChange();
				
				instance._dateInputClick();
				
				instance._toggleInputChange();
				
				instance._openColorPicker();
				
				instance.setColor(instance.color);
			},
			
			setColor: function(color){
				
				var instance = this;
				
				instance.color = color;
				
				$('#survey_color_setting').css(
					{
						'background-color': color
					}
				);
			},
			
			_settingArchitectureClick: function(){
				
				$('#survey_setting_arch').on(
					'click', function(){
						var settingPage = $('#survey_main_page');
						if(!settingPage.hasClass('survey-page-active')){
							settingPage.addClass('survey-page-active');
							var otherPages = $('div[class*="survey-page"][id!="survey_main_page"]');
							$.each(
								otherPages, function(index, otherPage){
									if($(otherPage).hasClass('survey-page-active')){
										$(otherPage).removeClass('survey-page-active');
									}
								}		
							);
						}
					}
				)
			},
			
			_pageArchitectureMove: function(){
				
				var pageContainer = $('.survey-page-container');
				
				$('.survey-page-architecture-container').sortable(
					{
						axis: 'y',
						items: "> div",
						cursor: 'move',
						update: function(){
							
							Liferay.SurveyInstanceCollection.refreshPageNo();
							
							var pages = $('.survey-page');
							
							pages.sort(
								function(page_one, page_two){
									
									return $(page_one).attr('data-sort') - $(page_two).attr('data-sort');
								}
							);
							
							pages.appendTo(pageContainer);
							
							Liferay.SurveyInstanceCollection.pageArray.sort(
									function(page_one, page_two){
										return page_one.no - page_two.no;
									}
							);
						}
					}	
				);
			},
			
			_titleInputChange: function(){
				
				var instance = this;
				var titleInput = $('input[name="title"]');
				var titleArch = $('#survey_setting_arch').find('.survey-page-text');
				
				titleInput.on(
					'input', function(){
						
						var titleVal = $(this).val();
						
						// title length limit
						if(titleVal.length > 200){
							
							new Liferay.SurveyAlertMessage(
								{
									message: '<i class="icon-warning-sign"></i>' + Liferay.SurveyInstanceConstants.SURVEY_TITLE_LENGTH_WARNING_TEXT,
									status: "danger",
									autoClose: 2500
								}		
							).show();
							
							titleVal = titleVal.substring(0, 200);
							
							$(this).val(titleVal);
						}
						
						titleArch.html(titleVal);
						 
						instance.title = titleVal;
					}
				);
				
				titleInput.on(
					'blur', function(){
						
						 if($(this).val() == ''){
							 
							 var untitledSurvey = Liferay.SurveyInstanceConstants.UNTITLED_SURVEY;
							 
							 titleInput.val(untitledSurvey);
							 
							 titleArch.html(untitledSurvey);
						 
							 instance.title = untitledSurvey;
						 }
					}
				);
			},
			
			_dateInputClick: function(){
				
				var instance = this;
				var startDate = $('input[name="startDate"]');
				var endDate = $('input[name="endDate"]');
				
				new A.DatePicker(
					{
						trigger : 'input[name="startDate"]',
						mask : '%Y-%m-%d',
						popover : {
							zIndex : 1
						},
						on: {
							selectionChange: function(event){
								
								var selectedDate = new Date(event.newSelection);
								
								Liferay.SurveyInstanceCollection.surveyMainSetting.startDate = selectedDate.getFullYear() 
									+ "-" + (selectedDate.getMonth() + 1) + "-" + selectedDate.getDate();
							}
						}
					}
				);
				
				new A.DatePicker(
					{
						trigger : 'input[name="endDate"]',
						mask : '%Y-%m-%d',
						popover : {
							zIndex : 1
						},
						on: {
							selectionChange: function(event){

								var selectedDate = new Date(event.newSelection);
								
								Liferay.SurveyInstanceCollection.surveyMainSetting.endDate = selectedDate.getFullYear() 
									+ "-" + (selectedDate.getMonth() + 1) + "-" + selectedDate.getDate();
							}
						}
					}
				);
			},
			
			_toggleInputChange: function(){
				
				var instance = this;
				
				$('input[name="needAuth"], [name="calculateScore"], [name="viewAnswer"]').on(
					'change', function(){
						
						var $this = $(this);
						
						if($this.attr('name') == 'needAuth'){
							
							instance.needAuth = $this.prop('checked');
						
						}else if($this.attr('name') == 'calculateScore'){
							
							var optionMarks = $('.survey-option-mark');
							
							instance.calculateScore = $this.prop('checked');
							
							var viewAnswer = $('input[name="viewAnswer"]');
							
							if($(this).prop('checked')){
								
								// show viewAnswer area
								viewAnswer.closest(".survey-main-item").css("display", "block");
								
								// hide question score label
								$('.label-info').removeClass('label-hidden');
								
								// set option answer class and data-tips
								optionMarks.addClass('survey-answer');
								
								$.each(
									optionMarks, function(index, optionMark){
										
										var optionId = $(optionMark).closest('.survey-option').attr('id');
										var instanceElementId = optionId.substring(optionId.lastIndexOf("_") + 1, optionId.length);
										var optionIntance = Liferay.SurveyInstanceCollection.getInstanceByElementId('option', instanceElementId);
										
										if(optionIntance.isAns){
											$(optionMark).addClass('survey-correct-answer').attr('data-tips', Liferay.SurveyInstanceConstants.CORRECT_ANSWER);
										}else{
											$(optionMark).attr('data-tips', Liferay.SurveyInstanceConstants.INCORRECT_ANSWER);
										}
									}
								);
							}else{
								
								// hide viewAnswer area and set viewAnswer to false
								viewAnswer.closest(".survey-main-item").css("display", "none");
								
								viewAnswer.prop('checked', false);
								
								instance.viewAnswer = false;
								
								$('.label-info').addClass('label-hidden');
								
								optionMarks.removeClass('survey-answer survey-correct-answer').attr('data-tips', '');
							}
						}else{
							instance.viewAnswer = $this.prop('checked');
						}
					}
				);
			},
			
			_openColorPicker: function(){
				
				var instance = this;
				
				$('#survey_color_setting').on(
					'click', function(){
						
						new Liferay.SurveyColorPicker(
							{
								trigger: $(this),
								settingInstance: instance
							}
						);
					}
				)
			}
		}
		Liferay.SurveyMainSetting = SurveyMainSetting;
		
		var SurveyPage = function(){
			
			var instance = this;
			
			instance.id = arguments[0].id;
			
			instance.elementId = arguments[0].elementId;
			
			instance.archId = arguments[0].archId;
			
			instance.no = arguments[0].no;
			
			instance.title = arguments[0].title;
			
			instance.pageDirect = arguments[0].pageDirect;
			
			instance.pageDirectId = arguments[0].pageDirectId;
			
			Liferay.SurveyInstanceCollection.pageArray.push(instance);
		}
		
		SurveyPage.prototype = {
			
			initialize: function(){
				
				var instance = this;
				
				instance._pageArchitectureClick();
				
				instance._questionArchitectureOnMove();
				
				instance._titleOnChange();
			},
			
			createUI: function(){
				
				var instance = this;
				var pageUI = Liferay.SurveyInstanceConstants.PAGE_UI(instance.elementId, instance.no);
				var pageArch = Liferay.SurveyInstanceConstants.PAGE_ARCHITECTURE_UI(instance.archId, instance.no);
				
				$('.survey-page-architecture-container').append(pageArch);
				$('.survey-page-container').append(pageUI);
				
				var page = $('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instance.elementId);
				var otherPages = $('div[class*="survey-page"][id!="' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instance.elementId + '"]');
				if(!page.hasClass('survey-page-active')){
					page.addClass('survey-page-active');
					$.each(otherPages,
						function(index, otherPage){
							if($(otherPage).hasClass('survey-page-active')){
								$(otherPage).removeClass('survey-page-active');
							}
						}
					);
				}
				page.find('input[name="pageTitle"]').focus().select();
				
				instance.initialize();
			},
			
			setPageDirect: function(pageDirectId){
				
				var instance = this;
				
				instance.pageDirectId = pageDirectId;
			},
			
			_pageArchitectureClick: function(){
				
				var instance = this;
				var pageArchitectureItem = '#' + instance.archId;
				
				// page architecture collapse
				$(pageArchitectureItem).on(
					'click', '.page-collapse-btn', function(){
						var directIcon = $(this);
						var questionContainer = directIcon.closest('.survey-page-architecture.survey-architecture-item')
							.find('.survey-ques-architecture-container');
						questionContainer.animate(
							{
								height: 'toggle'
							}, 
							100,
							function(){
								if(questionContainer.css('display') != 'none'){
									directIcon.removeClass('icon-chevron-sign-right');
									directIcon.addClass('icon-chevron-sign-down');
								}else{
									directIcon.removeClass('icon-chevron-sign-down');
									directIcon.addClass('icon-chevron-sign-right');
								}
							}
						);
					}
				)
				
				// change editing page 
				$(pageArchitectureItem).on(
					'click', function(event){
						if($(event.target).hasClass('page-collapse-btn'))
							return;
						var page = $('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instance.elementId);
						var otherPages = $('div[class*="survey-page"][id!="' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instance.elementId + '"]');
						if(!page.hasClass('survey-page-active')){
							page.addClass('survey-page-active');
							$.each(otherPages,
								function(index, otherPage){
									if($(otherPage).hasClass('survey-page-active')){
										$(otherPage).removeClass('survey-page-active');
									}
								}
							)
						}
					}
				)
			},
			
			_questionArchitectureOnMove: function(){
				
				var instance = this;	
				var page = $("#" + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instance.elementId);
				var questionContainer = $(page.find('.survey-question-container'));
				
				$('#' + instance.archId).find('.survey-ques-architecture-container')
					.sortable(
						{
							axis: 'y',
							items: "> div",
							cursor: 'move',
							update: function(){
								
								Liferay.SurveyInstanceCollection.refreshQuestionsNoByPageId(instance.elementId);	
								
								var questions = $(page.find('.survey-question'));
								
								questions.sort(
									function(question_one, question_two){
										return $(question_one).attr('data-sort') - $(question_two).attr('data-sort');
									}
								)
								questions.appendTo(questionContainer);
							}
						}
					);
			},
			
			_titleOnChange: function(){
				
				var instance = this;
				
				var titleInput = $('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="pageTitle"]');
				
				titleInput.on(
					'input', function(){
						
						var titleVal = $(this).val();
						
						if(titleVal.length > 200){
							
							new Liferay.SurveyAlertMessage(
								{
									message: '<i class="icon-warning-sign"></i>' + Liferay.SurveyInstanceConstants.PAGE_TITLE_LENGTH_WARNING_TEXT,
									status: "danger",
									autoClose: 2500
								}		
							).show();
							
							titleVal = titleVal.substring(0, 200);
							
							$(this).val(titleVal);
						}
						
						Liferay.SurveyInstanceCollection.resetPageDirectFont(instance.elementId, titleVal);
						 
						instance.title = titleVal;
					}
				);
				
				titleInput.on(
					'blur', function(){
						 if($(this).val() == ''){
							 
							 var untitledPage = Liferay.SurveyInstanceConstants.UNTITLED_PAGE;
							 
							 titleInput.val(untitledPage);
							 
							 Liferay.SurveyInstanceCollection.resetPageDirectFont(instance.elementId, untitledPage);
						 
							 instance.title = untitledPage;
						 }
					}
				);
			}
		}
		Liferay.SurveyPage = SurveyPage;
		
		var SurveyQuestion = function(){
			
			var instance = this;
			
			instance.id = arguments[0].id;
			
			instance.elementId = arguments[0].elementId;
			
			instance.archId = arguments[0].archId;
			
			instance.pageId = arguments[0].pageId;
			
			instance.no = arguments[0].no;
			
			instance.question = arguments[0].question;
			
			instance.type = arguments[0].type;
			
			instance.isRequired = arguments[0].isRequired;
			
			instance.hasOther = arguments[0].hasOther;
			
			instance.optionDirect = arguments[0].optionDirect;
			
			instance.points = arguments[0].points;
			
			instance.starsCount = arguments[0].starsCount;
			
			instance.fileId = arguments[0].fileId;
			
			Liferay.SurveyInstanceCollection.questionArray.push(instance);
		}
		
		SurveyQuestion.prototype = {
			
			initialize: function(){
				
				var instance = this;
				
				instance._titleOnChange();
				
				instance._bindToolBarItem();
				
				instance._removeImage();
				
				if(instance.type == SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE 
					|| instance.type == SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
					|| instance.type == SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST
					|| instance.type == SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
					|| instance.type == SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
					
					instance._addOption();
					
					instance._bindOptionSortable();
					
					if(instance.type == SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
						|| instance.type == SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
						
						instance._addSubQuestion();
						
						instance._bindSubQuestionSortable();
					}
				}
			},
			
			createUI: function(activePage){
				
				var instance = this;
				var questionUI = "";
				var questionArch = Liferay.SurveyInstanceConstants.QUESTION_ARCHITECTURE_UI(instance.archId, instance.no);
				var calculateScore = Liferay.SurveyInstanceCollection.surveyMainSetting.calculateScore;
				
				if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_TEXT){
					
					questionUI = Liferay.SurveyInstanceConstants.TEXT_QUESTION_UI(instance.elementId, instance.no);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE){
					
					questionUI = Liferay.SurveyInstanceConstants.SINGLE_CHOICE_QUESTION_UI(instance.elementId, instance.no, calculateScore);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX){
					
					questionUI = Liferay.SurveyInstanceConstants.CHECKBOX_QUESTION_UI(instance.elementId, instance.no, calculateScore);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
					
					questionUI = Liferay.SurveyInstanceConstants.DROPDOWN_LIST_QUESTION_UI(instance.elementId, instance.no, calculateScore);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DATE){
					
					questionUI = Liferay.SurveyInstanceConstants.DATE_QUESTION_UI(instance.elementId, instance.no);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR){
					
					questionUI = Liferay.SurveyInstanceConstants.STAR_QUESTION_UI(instance.elementId, instance.no);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE){
					
					questionUI = Liferay.SurveyInstanceConstants.SINGLE_CHOICE_LATTICE_QUESTION_UI(instance.elementId, instance.no);
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
					
					questionUI = Liferay.SurveyInstanceConstants.CHECKBOX_LATTICE_QUESTION_UI(instance.elementId, instance.no);
				}
				
				// insert html element
				activePage.find('.survey-question-container').append(questionUI);
				
				$("#" + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + instance.pageId)
					.find('.survey-ques-architecture-container').append(questionArch);
				
				// focus new question
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="questionTitle"]').focus().select();
				
				instance.initialize();
			},
			
			setFileId: function(fileId, imgURL){
				
				var instance = this;
				
				instance.fileId = fileId;
				
				var questionImg = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId).find('.survey-question-image');
				
				questionImg.find('img').attr('src', imgURL);
				
				questionImg.removeClass('image-hidden');
			},
			
			resetFileId: function(){
				
				var instance = this;
				
				instance.fileId = 0;
				
				var questionImg = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId).find('.survey-question-image');
				
				questionImg.find('img').attr('src', '');
				
				questionImg.addClass('image-hidden');
			},
			
			_titleOnChange: function(){
				
				var instance = this;
				
				var titleInput = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="questionTitle"]');
				
				titleInput.on('input',
					function(){
					
						var questionVal = $(this).val();
						
						if(questionVal.length > 500){
							
							new Liferay.SurveyAlertMessage(
								{
									message: '<i class="icon-warning-sign"></i>' + Liferay.SurveyInstanceConstants.QUESTION_LENGTH_WARNING_TEXT,
									status: "danger",
									autoClose: 2500
								}		
							).show();
							
							questionVal = questionVal.substring(0, 500);
							
							$(this).val(questionVal);
						}
					
						$('#' + instance.archId).text(questionVal);
						
						instance.question = questionVal;
					}
				);
				
				titleInput.on('blur',
					function(){
						
						if($(this).val() == ''){
							
							var undefinedQuestion = Liferay.SurveyInstanceConstants.UNDEFINED_QUESTION;
							
							$('#' + instance.archId).text(undefinedQuestion);
							$(this).val(undefinedQuestion);
							
							instance.question = undefinedQuestion;
						}
					}
				);
			},
			
			_bindToolBarItem: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-question-tool-bar').children().each(
						
						function(index, child){
							
							var $child = $(child);
							
							if($child.hasClass('icon-picture')){
								
								$child.on(
									'click', function(){
										instance._openPictureAlbum();
									}
								);
								
							}else if($child.hasClass('icon-trash')){
								
								$child.on(
									'click', function(){
										instance._removeQuestion();
									}
								);
								
							}else if($child.hasClass('icon-cog')){
								
								$child.on(
									'click', function(){
										instance._toggleQuestionSetting();
									}
								);
								
							}
						}
				);
				
				// mouse move in event
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId).on(
					'mouseover', function(){
						$(this).find('.survey-question-tool-bar').css('display', 'block');
					}
				);
				
				// mouse move out event
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId).on(
					'mouseleave', function(){
						$(this).find('.survey-question-tool-bar').css('display', 'none');
						Liferay.SurveyToolConstants.closeSurveyQuesSettingTool();
					}
				);
				
				// click other area to close setting tool
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId).on(
					'click', function(e){
						var parentClassName = $(e.target).context.parentElement.className;
						if(!e.target.matches('.icon-cog')
							&& !e.target.matches('.survey-question-setting')
							&& parentClassName != 'survey-toggle-container'
							&& parentClassName != 'survey-toggle-checkmark-container'
							&& parentClassName != 'survey-question-setting-row'
							&& parentClassName != 'survey-question-setting'
							&& parentClassName != 'append-row'
							&& parentClassName.indexOf('append-btn') == -1){
							Liferay.SurveyToolConstants.closeSurveyQuesSettingTool();
						}
					}
				);
			},
			
			_openPictureAlbum: function(){
				
				var instance = this;
				
				new Liferay.SurveyPictureAlbum(
					{
						triggerInstance: instance
					}
				);
			},
			
			_removeQuestion: function(){
				
				if(confirm(Liferay.SurveyInstanceConstants.DELETE_CONFIRM_FONT)){
					
					var instance = this;
					
					// remove UI and architecture
					$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId 
						+ ", #" + instance.archId).remove();
					
					Liferay.SurveyInstanceCollection.removeArrayObject(
						Liferay.SurveyInstanceCollection.questionArray, instance);
					
					if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE 
						|| instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
						|| instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST
						|| instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
						|| instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
						
						Liferay.SurveyInstanceCollection.removeOptionsByQuestionId(instance.elementId);
					}
					
					if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
						|| instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
						
						Liferay.SurveyInstanceCollection.removeSubQuestionByQuestionId(instance.elementId);
					}
					
					Liferay.SurveyInstanceCollection.refreshQuestionsNoByPageId(instance.pageId);
					
					// remove survey tips
					Liferay.SurveyTipsUtils.closeSurveyTips();
				}
			},
			
			_toggleQuestionSetting: function(){
				
				var instance = this;
				
				new Liferay.SurveyQuesSettingTool(
					{
						questionInstance: instance
					}
				)
			},
			
			_addOption: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-plus-option-btn').on('click',
						function(){
						
							var optionElementId = Liferay.SurveyUtils.createRandomNumber();
							var lastOptionIndex = Liferay.SurveyInstanceCollection.getLastOptionIndexByQuestionId(instance.elementId);
							
							new Liferay.SurveyOption(
								{
									id: 0,
									elementId: optionElementId,
									pageId: instance.pageId,
									questionId: instance.elementId,
									no: lastOptionIndex + 1,
									option: '',
									isAns: false,
									pageDirect: 0,
									pageDirectId: 0,
									fileId: 0
								}
							).createUI();
					}
				);
			},
			
			_addSubQuestion: function(){

				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-plus-sub-question-btn').on('click',
						function(){
						
							var subQuestionElementId = Liferay.SurveyUtils.createRandomNumber();
							var lastSubQuestionIndex = Liferay.SurveyInstanceCollection.getLastSubQuestionIndexByQuestionId(instance.elementId);
							
							new Liferay.SurveySubQuestion(
								{
									id: 0,
									elementId: subQuestionElementId,
									pageId: instance.pageId,
									no: lastSubQuestionIndex + 1,
									question: '',
									parentElementId: instance.elementId
								}
							).createUI();
					}
				);
			},
			
			_bindOptionSortable: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-option-container')
					.sortable(
						{
							axis: 'y',
							items: "> div",
							cursor: 'move',
							handle: '.survey-option-mark',
							update: function(){
								Liferay.SurveyInstanceCollection.refreshOptionsNoByQuestionId(instance.elementId);
							}
						}
					);
			},
			
			_bindSubQuestionSortable: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-sub-question-container')
					.sortable(
						{
							axis: 'y',
							items: "> div",
							cursor: 'move',
							handle: '.survey-sub-question-mark',
							update: function(){
								Liferay.SurveyInstanceCollection.refreshSubQuestionsNoByQuestionId(instance.elementId);
							}
						}
					);
			},
			
			_removeImage: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-question-image').find('.remove-img-btn').on(
					
						'click', function(){
							instance.resetFileId();
						}
					);
			}
		}
		Liferay.SurveyQuestion = SurveyQuestion;
		
		var SurveySubQuestion = function(){
			
			var instance = this;
			
			instance.id = arguments[0].id;
			
			instance.elementId = arguments[0].elementId;
			
			instance.no = arguments[0].no;
			
			instance.question = arguments[0].question;
			
			instance.parentElementId = arguments[0].parentElementId;
			
			Liferay.SurveyInstanceCollection.subQuestionArray.push(instance);
		}
		
		SurveySubQuestion.prototype = {
				
			initialize: function(){
				
				var instance = this;
				
				instance._questionOnChange();
				
				instance._bindToolBarItem();
			},
			
			createUI: function(){
				
				var instance = this;
				
				$("#" + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.parentElementId)
					.find('.survey-sub-question-container').append(Liferay.SurveyInstanceConstants.LATTICE_SUB_QUESTION_UI(instance.elementId));
				
				$("#" + Liferay.SurveyInstanceConstants.SURVEY_SUB_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="subQuestionTitle"]').focus();
				
				instance.initialize();
			},
			
			_questionOnChange: function(){
				
				var instance = this;
				var titleInput = $('#' + Liferay.SurveyInstanceConstants.SURVEY_SUB_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="subQuestionTitle"]');
				
				titleInput.on('input',
					function(){
					
						var questionVal = $(this).val();
						
						if(questionVal.length > 500){
							
							new Liferay.SurveyAlertMessage(
								{
									message: '<i class="icon-warning-sign"></i>' + Liferay.SurveyInstanceConstants.QUESTION_LENGTH_WARNING_TEXT,
									status: "danger",
									autoClose: 2500
								}		
							).show();
							
							questionVal = questionVal.substring(0, 500);
							
							$(this).val(questionVal);
						}
						
						instance.question = questionVal;
					}
				);
			},
			
			_bindToolBarItem: function(){
				
				var instance = this;
				var deleteIcon = $('#' + Liferay.SurveyInstanceConstants.SURVEY_SUB_QUESTION_ITEM_NAMESPACE + instance.elementId)
					.find('.icon-remove');
				
				deleteIcon.on('click',
						
					function(){
					
						var subQuestion = $('#' + Liferay.SurveyInstanceConstants.SURVEY_SUB_QUESTION_ITEM_NAMESPACE + instance.elementId);
						
						if(subQuestion.closest('.survey-sub-question-container').find('.survey-sub-question').length == 1)
							return;
						
						if(confirm(Liferay.SurveyInstanceConstants.DELETE_CONFIRM_FONT)){
							
							subQuestion.remove();
							
							Liferay.SurveyInstanceCollection.removeArrayObject(
								Liferay.SurveyInstanceCollection.subQuestionArray, instance);
							
							Liferay.SurveyInstanceCollection.refreshSubQuestionsNoByQuestionId(instance.parentElementId);
							
							// remove survey tips
							Liferay.SurveyTipsUtils.closeSurveyTips();
						}
					}
				);
			}
		}
		Liferay.SurveySubQuestion = SurveySubQuestion;
		
		var SurveyOption = function(){

			var instance = this;
			
			instance.id = arguments[0].id;
			
			instance.elementId = arguments[0].elementId;
			
			instance.pageId = arguments[0].pageId;
			
			instance.questionId = arguments[0].questionId;		
			
			instance.no = arguments[0].no;
			
			instance.option = arguments[0].option;
			
			instance.isAns = arguments[0].isAns;
			
			instance.pageDirect = arguments[0].pageDirect;
			
			instance.pageDirectId = arguments[0].pageDirectId;
			
			instance.fileId = arguments[0].fileId;
			
			instance.questionInstance = Liferay.SurveyInstanceCollection.getInstanceByElementId('question', instance.questionId);
			
			Liferay.SurveyInstanceCollection.optionArray.push(instance);
		}
		
		SurveyOption.prototype = {
			
			initialize: function(){
				
				var instance = this;
				
				if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE 
					|| instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
					|| instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
					
					instance._openPageDirect();
					
					instance._answerIconClick();
					
					if(instance.questionInstance.type != Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST)
						instance._removeImage();
				}
				
				instance._optionOnChange();
				
				instance._bindToolBarItem();
			},
			
			createUI: function(){
				
				var instance = this;
				var optionUI = "";
				
				if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE 
					|| instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
					|| instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
					
					optionUI = Liferay.SurveyInstanceConstants.OPTION_UI(instance.elementId, instance.questionInstance.optionDirect
						, instance.questionInstance.type, Liferay.SurveyInstanceCollection.surveyMainSetting.calculateScore);
					
				}else if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE){
					
					optionUI = Liferay.SurveyInstanceConstants.SINGLE_CHOICE_LATTICE_OPTION_UI(instance.elementId);
					
				}else if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
					
					optionUI = Liferay.SurveyInstanceConstants.CHECKBOX_LATTICE_OPTION_UI(instance.elementId);
				}
				
				$("#" + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.questionId)
					.find('.survey-option-container').append(optionUI);
				
				$("#" + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="optionTitle"]').focus();
				
				instance.initialize();
			},
			
			setPageDirect: function(pageDirectId){
				
				var instance = this;
				var pageTitle = "";
				
				instance.pageDirectId = pageDirectId;
				
				if(pageDirectId == 0){
					
					pageTitle = Liferay.SurveyInstanceConstants.NO_SETTING;
					
				}else if(pageDirectId == -1){
					
					pageTitle = Liferay.SurveyInstanceConstants.SUBMIT_FORM;
					
				}else{
					
					pageTitle = Liferay.SurveyInstanceCollection.getInstanceByElementId('page', pageDirectId).title;
					
				}
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-option-direct').html(Liferay.SurveyInstanceConstants.GUIDE_TO + pageTitle);
			},
			
			setFileId: function(fileId, imgURL){
				
				var instance = this;
				
				instance.fileId = fileId;
				
				var optionImg = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).find('.survey-option-image');
				
				optionImg.find('img').attr('src', imgURL);
				
				optionImg.removeClass('image-hidden');
			},
			
			resetFileId: function(){
				
				var instance = this;
				
				instance.fileId = 0;
				
				var optionImg = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).find('.survey-option-image');
				
				optionImg.find('img').attr('src', '');
				
				optionImg.addClass('image-hidden');
			},
			
			_optionOnChange: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('input[name="optionTitle"]')
					.on('input',
						function(){
							
							var optionVal = $(this).val();
							
							if(optionVal.length > 200){
								
								new Liferay.SurveyAlertMessage(
									{
										message: '<i class="icon-warning-sign"></i>' + Liferay.SurveyInstanceConstants.OPTION_LENGTH_WARNING_TEXT,
										status: "danger",
										autoClose: 2500
									}		
								).show();
								
								optionVal = optionVal.substring(0, 200);
								
								$(this).val(optionVal);
							}
						
							instance.option = optionVal;
						}
					);
			},
			
			_bindToolBarItem: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-option-tool-bar').children().each(
					
					function(index, child){
						
						var $child = $(child);
						
						if($child.hasClass('icon-picture')){
							
							$child.on(
								'click', function(){
									instance._openPictureAlbum();
								}
							);
						}else if($child.hasClass('icon-remove')){
							
							$child.on(
								'click', function(){
									instance._removeOption();
								}
							);
						}
					}
				);
			},
			
			_removeOption: function(){
				
				var instance = this;
				var option = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId);
				
				// 剩一個選項就不刪
				if(option.closest('.survey-option-container').find('.survey-option').length == 1)
					return;
				
				if(confirm(Liferay.SurveyInstanceConstants.DELETE_CONFIRM_FONT)){
					
					option.remove();
					
					Liferay.SurveyInstanceCollection.removeArrayObject(
						Liferay.SurveyInstanceCollection.optionArray, instance);
					
					Liferay.SurveyInstanceCollection.refreshOptionsNoByQuestionId(instance.questionId);
					
					// remove survey tips
					Liferay.SurveyTipsUtils.closeSurveyTips();
				}
			},
			
			_openPageDirect: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-option-direct')
					.on(
						'click', function(){
							
							new Liferay.SurveyPageDirect(
								{
									triggerInstance: instance,
									currentPageId: instance.pageId
								}
							);
						}
					);
			},
			
			_answerIconClick: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('.survey-option-mark')
					.on(
						'click', function(){
							
							var $this = $(this);
							
							if(!$this.hasClass('survey-answer'))
								return;
							
							var surveyTips = $('#survey_tips');
							
							if(instance.isAns){
								instance.isAns = false;
								$this.removeClass('survey-correct-answer').attr('data-tips', Liferay.SurveyInstanceConstants.INCORRECT_ANSWER);
								surveyTips.text(Liferay.SurveyInstanceConstants.INCORRECT_ANSWER);
							}else{
								instance.isAns = true;
								$this.addClass('survey-correct-answer').attr('data-tips', Liferay.SurveyInstanceConstants.CORRECT_ANSWER);
								surveyTips.text(Liferay.SurveyInstanceConstants.CORRECT_ANSWER);
							}
						}
					);
			},
			
			_openPictureAlbum: function(){
				
				var instance = this;
				
				new Liferay.SurveyPictureAlbum(
					{
						triggerInstance: instance
					}
				);
			},
			
			_removeImage: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId)
					.find('.remove-img-btn').on(
					
						'click', function(){
							instance.resetFileId();
						}
					);
			}
		}
		Liferay.SurveyOption = SurveyOption;
		
		var SurveyImage = function(){
			
			var instance = this;
			
			instance.fileId = arguments[0].fileId;
			
			instance.imgURL = arguments[0].imgURL;
			
			instance.removeURL = arguments[0].removeURL;
			
			instance.openerWindow = arguments[0].openerWindow;
		}
		
		SurveyImage.prototype = {
			
			initialize: function(){
				
				var instance = this;
				
				instance._setImage();
				
				instance._imgDbckick();
				
				instance._removeButtonClick();
			},
			
			_setImage: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_IMG_ITEM_NAMESPACE + instance.fileId).find('.survey-img')
					.css('background-image', 'url(' + instance.imgURL + ')');
			},
			
			_imgDbckick: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_IMG_ITEM_NAMESPACE + instance.fileId).on(
					'dblclick', function(){
						instance.openerWindow.Liferay.SurveyToolConstants.setFileId(instance.fileId, instance.imgURL);
					}
				);
			},
			
			_removeButtonClick: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_IMG_ITEM_NAMESPACE + instance.fileId).find('.survey-img-remove').on(
					'click', function(){
						if(confirm(Liferay.SurveyInstanceConstants.DELETE_CONFIRM_FONT)){
							
							location.href = instance.removeURL;
						}
					}
				);
			}
		}
		Liferay.SurveyImage = SurveyImage;
		
		var SurveyWriteQuestion = function(){
			
			var instance = this;
			
			instance.Id = arguments[0].Id;
			
			instance.elementId = arguments[0].elementId;
			
			instance.no = arguments[0].no;
			
			instance.type = arguments[0].type;
			
			instance.hasOther = arguments[0].hasOther;
			
			instance.isRequired = arguments[0].isRequired;
			
			instance.parentId = arguments[0].parentId;
			
			instance.starsCount = arguments[0].starsCount;
			
			instance.answer = arguments[0].answer;
			
			instance.optionIds = arguments[0].optionIds;
			
			Liferay.SurveyInstanceCollection.writeQuestionArray.push(instance);
		}
		
		SurveyWriteQuestion.prototype = {
				
			initialize: function(){
				
				var instance = this;
				
				if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_TEXT){
					
					instance._textQuestionEvent();
					
					instance._resizeTextArea($('#' + SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId));
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DATE){
					
					instance._dateQuestionEvent();
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR){
					
					instance._starQuestionEvent();
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE && instance.hasOther){
					
					instance._radioOtherOptionEvent();
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX && instance.hasOther){
					
					instance._checkBoxOtherOptionEvent();
					
				}else if(instance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
					
					instance._dropdownTitleEvent();
				}
			},
			
			addOptionId: function(optionId){
				
				var instance = this;
				
				if(instance.optionIds == ''){
					
					instance.optionIds = optionId;
					
					return;
				}
				
				var optionArray = instance.optionIds.split(",");
				
				if(optionArray.indexOf(optionId) == -1)
					instance.optionIds += ("," + optionId);
			},
			
			removeOptionId: function(optionId){
				
				var instance = this;
				var optionArray = instance.optionIds.split(",");
				var optionIds = "";
				
				// resort optionIds string
				for(var v = 0; v < optionArray.length; v++){
					
					if(optionArray[v] == optionId)
						continue;
					
					if(optionIds == "")
						optionIds += optionArray[v];
					else
						optionIds += ("," + optionArray[v]);
				}
				instance.optionIds = optionIds;
			},
			
			removeRequiredStatus: function(element){
				
				var title = element.closest('.survey-write-question').find('.survey-write-question-title');
				
				if(title.hasClass('survey-write-question-required')){
					title.removeClass('survey-write-question-required');
					title.find('.survey-write-question-required-font').remove();
				}
			},
			
			_textQuestionEvent: function(){
				
				var instance = this;
				
				$('#' + SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId).on(
					'input', function(){
						
						instance._resizeTextArea($(this));
						instance.answer = $(this).val();
						
						instance.removeRequiredStatus($(this));
					}	
				);
			},
			
			_dateQuestionEvent: function(){
				
				var instance = this;
				var input = $('#' + SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId);
				
				input.on(
					'focusout', function(){
						
						var date = new Date($(this).val());
						
						if(date == 'Invalid Date'){
							$(this).val('');
							instance.answer = '';
						}else{
							instance.answer = $(this).val();
							instance.removeRequiredStatus($(this));
						}
					}	
				);
				
				new A.DatePicker(
					{
						trigger : '#' + SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId,
						mask : '%Y-%m-%d',
						popover : {
							zIndex : 1
						},
						on: {
							selectionChange: function(event){
								
								var selectedDate = new Date(event.newSelection);
								
								instance.answer = selectedDate.getFullYear() + "-" + (selectedDate.getMonth() + 1) + "-" + selectedDate.getDate();
								
								instance.removeRequiredStatus($('#' + SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId));
							}
						}
					}
				);
			},
			
			_starQuestionEvent: function(){
				
				var instance = this;
				
				for(var v = 1; v <= instance.starsCount; v++){
					
					var star = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.no + "_" + v);
					const starIndex = v;
					
					star.on(
						'change', function(){
							instance.answer = starIndex;
							instance._setStarStatus(starIndex);
							instance.removeRequiredStatus($(this));
						}
					);
				}
			},
			
			_radioOtherOptionEvent: function(){
				
				var instance = this;
				var otherOptionInput = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + "-" + instance.Id);
				var otherOptionTextArea = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId);
				
				// initialize textarea
				instance._resizeTextArea(otherOptionTextArea);
				
				otherOptionInput.on(
					'change', function(){
						instance.optionIds = "-1";
						instance.removeRequiredStatus($(this));
					}
				);
				
				otherOptionTextArea.on(
					'input', function(){
						
						instance._resizeTextArea($(this));
						instance.answer = $(this).val();
						
						// if user type in "other" option textarea set optionId = -1
						instance.optionIds = "-1";
						otherOptionInput.prop('checked', true);
						
						instance.removeRequiredStatus($(this));
					}	
				);
			},
			
			_checkBoxOtherOptionEvent: function(){
				
				var instance = this;
				
				var otherOptionInput = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + "-" + instance.Id);
				var otherOptionTextArea = $('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.elementId);
				
				// initialize textarea
				instance._resizeTextArea(otherOptionTextArea);
				
				otherOptionInput.on(
					'change', function(){
						
						if($(this).prop("checked")){
							instance.addOptionId("-1");
							instance.removeRequiredStatus($(this));
						}else{
							instance.removeOptionId("-1");
						}
					}
				);
				
				otherOptionTextArea.on(
					'input', function(){
						
						instance._resizeTextArea($(this));
						instance.answer = $(this).val();
						
						// if user type in "other" option textarea set add -1 to instance optionIds
						instance.addOptionId("-1");
						otherOptionInput.prop('checked', true);
						
						instance.removeRequiredStatus($(this));
					}	
				);
			},
			
			_dropdownTitleEvent: function(){
				
				var instance = this;
				var optionContainer = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + (instance.Id * -1))
					.closest('.survey-dropdown-option-container');
				var dropdownTitle = optionContainer.prev();
				
				dropdownTitle.on(
					
					'click', function(){
						
						if(optionContainer.hasClass('open'))
							optionContainer.removeClass('open');
						else
							optionContainer.addClass('open');
					}
				);
			},
			
			_resizeTextArea: function(textarea){
				
				textarea.height('auto');
				
			 	textarea.height(textarea.get(0).scrollHeight);
			},
			
			_setStarStatus: function(starIndex){
				
				var instance = this;
				
				for(var v = 1; v <= instance.starsCount; v++){
					
					var starMark = $('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.no + "_" + v).next();
					
					if(v > starIndex){
						starMark.addClass('icon-star-empty');
						starMark.removeClass('icon-star');
					}else{
						starMark.addClass('icon-star');
						starMark.removeClass('icon-star-empty');
					}
				}
			}
		}
		Liferay.SurveyWriteQuestion = SurveyWriteQuestion;
		
		var SurveyWriteOption = function(){
			
			var instance = this;
			
			instance.Id = arguments[0].Id;
			
			instance.elementId = arguments[0].elementId;
			
			instance.questionElementId = arguments[0].questionElementId;
			
			instance.questionInstance = Liferay.SurveyInstanceCollection.getInstanceByElementId("write_question", instance.questionElementId);
			
			Liferay.SurveyInstanceCollection.writeOptionArray.push(instance);
		}
		
		SurveyWriteOption.prototype = {
			
			initialize: function(){
				
				var instance = this;
				
				if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE){
					
					instance._singleChoiceOptionEvent();
					
				}else if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX){
					
					instance._checkBoxOptionEvent();
					
				}else if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
					
					instance._dropdownListOptionEvent();
					
				}else if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE){
					
					instance._singleChoiceLatticeOptionEvent();
					
				}else if(instance.questionInstance.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
					
					instance._checkboxLatticeOptionEvent();
				}
			},
			
			_singleChoiceOptionEvent: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).on(
					'change', function(){
						
						instance.questionInstance.optionIds = instance.Id;
						
						instance.questionInstance.removeRequiredStatus($(this));
					}
				);
			},
			
			_checkBoxOptionEvent: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).on(
					'change', function(){

						var checked = $(this).prop("checked");
						
						if(checked)
							instance.questionInstance.addOptionId(instance.Id);
						else
							instance.questionInstance.removeOptionId(instance.Id);
						
						instance.questionInstance.removeRequiredStatus($(this));
					}
				);
			},
			
			_dropdownListOptionEvent: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).on(
					'click', function(){
						
						var $this = $(this);
						
						$this.closest('.survey-dropdown').find('.survey-dropdown-title').html($this.attr('data-text'));
						
						$this.closest('.survey-dropdown-option-container').removeClass('open');
						
						instance.questionInstance.optionIds = instance.Id;
						
						if(instance.Id != '')
							instance.questionInstance.removeRequiredStatus($(this));
					}
				);
			},
			
			_singleChoiceLatticeOptionEvent: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).on(
					'change', function(){
						
						instance.questionInstance.optionIds = instance.Id;
						
						// check all sub questions have been writed, then remove required status
						if(instance.questionInstance.isRequired){
							
							var subQuestions = SurveyInstanceCollection.getWriteQuestionsByParentId(instance.questionInstance.parentId);
							var writedQuestionCount = 0;
							
							for(var v = 0; v < subQuestions.length; v++){
								
								if(subQuestions[v].optionIds != "")
									writedQuestionCount++;
							}
							
							if(writedQuestionCount == subQuestions.length)
								instance.questionInstance.removeRequiredStatus($(this));
						}
					}
				);
			},
			
			_checkboxLatticeOptionEvent: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_OPTION_ITEM_NAMESPACE + instance.elementId).on(
					'change', function(){
						
						var checked = $(this).prop("checked");
						
						if(checked)
							instance.questionInstance.addOptionId(instance.Id);
						else
							instance.questionInstance.removeOptionId(instance.Id);
						
						// check all sub questions have been writed, then remove required status
						if(instance.questionInstance.isRequired){
							
							var subQuestions = SurveyInstanceCollection.getWriteQuestionsByParentId(instance.questionInstance.parentId);
							var writedQuestionCount = 0;
							
							for(var v = 0; v < subQuestions.length; v++){
								
								if(subQuestions[v].optionIds != "")
									writedQuestionCount++;
							}
							
							if(writedQuestionCount == subQuestions.length)
								instance.questionInstance.removeRequiredStatus($(this));
						}
					}
				);
			}
		}
		Liferay.SurveyWriteOption = SurveyWriteOption;
		
	}, '', 
	{
		requires: ['aui-base', 'aui-datepicker', 'liferay-util-window', 'survey-components']
	}
);