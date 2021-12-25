AUI.add(
		
	'survey-components', function(A){
		
		var surveyAdminTool = null;
		var surveyAdminFilter = null;
		var surveyPageTool = null;
		var surveyQuestionTool = null;
		var surveyQuesSettingTool = null;
		var surveyPageDirectTool = null;
		var surveyPageDirect = null;
		var surveyPageDirectWindow = null;
		var surveyColorPicker = null;
		var surveyPictureAlbum = null;
		var surveyPictureAlbumWindow = null;
		var surveyResultTool = null;
		
		var submitStatus = true;
		
		var SurveyToolConstants = {
			
			SURVEY_MAIN_ID: 0,
				
			PORTLET_NAMESPACE: '_LCSurvey_WAR_LCSurveyportlet_',
			
			FORM_ID: '_LCSurvey_WAR_LCSurveyportlet_fm',
			
			SURVEY_TOOL_CLASS_NAME: 'survey-tool',
			
			QUESTION_SETTING_TOOL_CLASS_NAME: 'survey-question-setting',
			
			DIALOG_WINDOW_STATE: 'pop_up',
			
			ADMIN_TOOL_ID: 'survey_admin_tool',
			
			ADMIN_FILTER_TOOL_ID: 'survey_admin_filter_tool',
			
			PAGE_TOOL_ID: 'survey_page_tool',
			
			QUESTION_TOOL_ID: 'survey_question_tool',
			
			PAGE_DIRECT_TOOL_ID: 'survey_page_direct_tool',
			
			QUESTION_SETTING_TOOL_ID: 'survey_question_setting',
			
			COLOR_PICKER_ID: 'survey_color_picker',
			
			RESULT_TOOL_ID: 'survey_result_tool',
			
			getPortletId: function(){
				
				var instance = this;
				
				return instance.PORTLET_NAMESPACE.substring(1, instance.PORTLET_NAMESPACE.length - 1);
			},
			
			bindWindowCloseTool: function(){
				
				var instance = this;
				
				$(window).on(
					'click', function(e){
						
						var parentElement = e.target.parentElement;
						
						if(parentElement == null){
							
							if(surveyAdminTool != null){
								surveyAdminTool.close();
							}
							
							if(surveyAdminFilter != null){
								surveyAdminFilter.close();
							}
							
							if(surveyQuestionTool != null){
								surveyQuestionTool.close();
							}
							
							if(surveyPageDirectTool != null){
								surveyPageDirectTool.close();
							}
							
							if(surveyColorPicker != null){
								surveyColorPicker.close();
							}
							
							if(surveyResultTool != null){
								surveyResultTool.close();
							}
							
							return;
						}
						
						// admin tool
						if(!e.target.matches(".survey-admin-tool-btn")
								&& parentElement.className != 'survey-admin-tool-btn'){
							
							if(surveyAdminTool != null){
								surveyAdminTool.close();
							}
						}
						
						// admin filter tool
						if(!e.target.matches('#survey_admin_filter_btn')
								&& parentElement.className != 'survey-filter-tool'
								&& parentElement.className != 'survey-filter-btn'
								&& parentElement.className != 'survey-filter-row'
								&& parentElement.className != 'survey-dropdown'
								&& parentElement.className != 'survey-dropdown-title-row'
								&& parentElement.className != 'survey-dropdown-option-container open'
								&& parentElement.className != 'survey-dropdown-option'
								&& parentElement.className != 'survey-filter-row survey-filter-button-row'
								&& parentElement.id != 'survey_filter_btn'
								&& parentElement.id != 'survey_clear_btn'){
							
							if(surveyAdminFilter != null){
								surveyAdminFilter.close();
							}
						}
						
						// add question tool
						if(!e.target.matches('#' + PageTool.prototype.ATTRS.SURVEY_ADD_QUESTION_ID)
								&& parentElement.id != PageTool.prototype.ATTRS.SURVEY_ADD_QUESTION_ID
								&& parentElement.id != instance.QUESTION_TOOL_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_TEXT_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_SINGLE_CHOICE_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_CHECKBOX_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_DROPDOWN_LIST_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_DATE_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_STAR_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_SINGLE_CHOICE_LATTICE_BTN_ID
								&& parentElement.id != QuestionTool.prototype.ATTRS.ADD_CHECKBOX_LATTICE_BTN_ID){
							
							if(surveyQuestionTool != null){
								surveyQuestionTool.close();
							}
						}
						
						// page direct tool
						if(!e.target.matches('#' + PageTool.prototype.ATTRS.SURVEY_PAGE_GUIDE_BTN_ID)
								&& parentElement.id != PageTool.prototype.ATTRS.SURVEY_PAGE_GUIDE_BTN_ID
								&& parentElement.id != instance.PAGE_DIRECT_TOOL_ID){
							
							if(surveyPageDirectTool != null){
								surveyPageDirectTool.close();
							}
						}
						
						// color picker
						if(!e.target.matches('#survey_color_setting')
								&& !e.target.matches('#survey_color_picker')
								&& parentElement.id != 'survey_color_setting'
								&& parentElement.id != 'survey_color_picker'
								&& parentElement.className != 'survey-color-row'
								&& parentElement.className != 'survey-color'){
							
							if(surveyColorPicker != null){
								surveyColorPicker.close();
							}
						}
						
						// result tool
						if(!e.target.matches(".survey-result-tool-btn")
								&& parentElement.className != 'survey-result-tool-btn'){
							
							if(surveyResultTool != null){
								surveyResultTool.close();
							}
						}
					}		
				);
			},
			
			closeSurveyQuesSettingTool: function(){
				
				if(surveyQuesSettingTool != null){
					surveyQuesSettingTool.save();
					surveyQuesSettingTool.close();
				}
			},
			
			setPageDirectId: function(pageId){
				
				if(surveyPageDirect != null){
					surveyPageDirect.setPageDirect(pageId);
				}
			},
			
			setFileId: function(fileId, imgURL){
				
				if(surveyPictureAlbum != null){
					surveyPictureAlbum.setFileId(fileId, imgURL);
				}
			},
			
			setRemovedFileId: function(removedFileId){
				
				if(surveyPictureAlbum != null){
					surveyPictureAlbum.setRemovedFileId(removedFileId);
				}
			}
		}
		Liferay.SurveyToolConstants = SurveyToolConstants;
		
		var SurveyAdminTool = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
			
			instance.mainId = arguments[0].mainId;
			
			instance.removeURL = arguments[0].removeURL;
			
			var toolBtn = $(instance.trigger).find('.survey-admin-tool-btn');
			
			toolBtn.on(
				'click', function(){
					var $this = $(this);
					var top = $this.offset().top;
					var left = $this.offset().left;
					var width = $this.width();
					var triggerId = $this.closest('.survey-item').attr('id');
					
					if(surveyAdminTool != null){
						var orgTriggerId = surveyAdminTool.triggerId;
						surveyAdminTool.close();
						if(orgTriggerId == triggerId)
							return false;
					}
					surveyAdminTool = new AdminTool(
						{
							triggerId: triggerId,
							top: top,
							left: left,
							width: width,
							mainId: instance.mainId,
							removeURL: instance.removeURL
						}
					);
					surveyAdminTool.show();
				}
			);
		}
		Liferay.SurveyAdminTool = SurveyAdminTool;
				
		var AdminTool = function(){
			
			var instance = this;
			
			instance.triggerId = arguments[0].triggerId;
			
			instance.top = arguments[0].top;
			
			instance.left = arguments[0].left;
			
			instance.width = arguments[0].width;
			
			instance.mainId = arguments[0].mainId;
			
			instance.removeURL = arguments[0].removeURL;
		}
		
		AdminTool.prototype = {
				
			ATTRS: {
				
				dialogWindow: null,
				
				SURVEY_ADMIN_VIEW_RESULT: 'survey_admin_view_result',
				
				SURVEY_ADMIN_EDIT: 'survey_admin_edit',
				
				SURVEY_ADMIN_LINK: 'survey_admin_link',
				
				SURVEY_ADMIN_REMOVE: 'survey_admin_remove',
				
				SURVEY_ADMIN_VIEW_RESULT_FONT: Liferay.Language.get('view-survey-result'),
				
				SURVEY_ADMIN_EDIT_FONT: Liferay.Language.get('edit-survey'),
				
				SURVEY_ADMIN_LINK_FONT: Liferay.Language.get('survey-link'),
				
				SURVEY_ADMIN_REMOVE_FONT: Liferay.Language.get('remove-survey'),
				
				DELETE_CONFIRM_FONT: Liferay.Language.get('delete-confirm'),
				
				UI: function(){
					return '<div id="' + Liferay.SurveyToolConstants.ADMIN_TOOL_ID + '" class="' + Liferay.SurveyToolConstants.SURVEY_TOOL_CLASS_NAME + '">'
							+ '<div class="' + this.SURVEY_ADMIN_VIEW_RESULT + '"><i class="icon-eye-open"></i>' + this.SURVEY_ADMIN_VIEW_RESULT_FONT + '</div>'
							+ '<div class="' + this.SURVEY_ADMIN_EDIT + '"><i class="icon-edit"></i>' + this.SURVEY_ADMIN_EDIT_FONT + '</div>' 
							+ '<div class="' + this.SURVEY_ADMIN_LINK + '"><i class="icon-qrcode"></i>' + this.SURVEY_ADMIN_LINK_FONT + '</div>' 
							+ '<div class="' + this.SURVEY_ADMIN_REMOVE + '"><i class="icon-trash"></i>' + this.SURVEY_ADMIN_REMOVE_FONT + '</div>' 
							+ '</div>'
				}
			},
			
			show: function(){
				
				var instance = this;
				var toolId = "#" + Liferay.SurveyToolConstants.ADMIN_TOOL_ID;
				var sreenWidth = $(window).width();
				var toolLeft = 0;
				var toolTop = instance.top;
				
				$('html').append(instance.ATTRS.UI());
				
				// 判斷當前的觸發元件的位置是否會使工具畫面太擠
				var toolWidth = $(toolId).width();
				
				if((sreenWidth - (instance.left + instance.width + 14)) > toolWidth){
					toolLeft = instance.left + instance.width + 14;
				}else if(instance.left > toolWidth){
					toolLeft = instance.left - toolWidth - 5;
				}else{
					toolLeft = instance.left + (instance.width + 14) / 2 - toolWidth / 2;
					toolTop = toolTop + 25;
				}
				
				$(toolId).css(
					{
						'top': toolTop,
						'left': toolLeft,
					}		
				);
				instance._initializeItem(toolId);
				$(toolId).animate(
					{
						opacity: 1
					}, 150
				);
			},
			
			close: function(){
				
				var toolId = "#" + Liferay.SurveyToolConstants.ADMIN_TOOL_ID;
				
				surveyAdminTool = null;
				
				$(toolId).remove()
			},
			
			_initializeItem: function(toolId){
				
				var instance = this;
				
				var children = $(toolId).children();
				
				children.each(
						
					function(index, child){
						
						var childClass = $(child).attr('class');
						
						if (childClass == instance.ATTRS.SURVEY_ADMIN_VIEW_RESULT){
							
							$(child).on(
								'click', function(){
									instance._openDialog(instance.ATTRS.SURVEY_ADMIN_VIEW_RESULT_FONT, instance._getViewResultURL()
											, screen.width * 0.95, screen.height * 0.9, false);
								}
							)
							
						} else if (childClass == instance.ATTRS.SURVEY_ADMIN_EDIT){
							
							$(child).on(
								'click', function(){
									
									if(Liferay.Session.get('sessionState') == 'expired'){
										var surveyAlert = new Liferay.SurveyAlertMessage(
											{
												message: '<i class="icon-warning-sign"></i>' + Liferay.Language.get('please-sign-in-to-access-this-application'),
												status: 'info',
												autoClose: 2500
											}	
										);
										surveyAlert.show();
										return;
									}
									
									instance._openDialog(instance.ATTRS.SURVEY_ADMIN_EDIT_FONT, instance._getEditURL() , '', '', true);
								}
							)
							
						} else if (childClass == instance.ATTRS.SURVEY_ADMIN_LINK){
							
							$(child).on(
								'click', function(){
									
									var linkWindowWidth = '960px';
									var linkWindowHeight = '648px';
									
									if(screen.width <= 1280) {
										linkWindowWidth = screen.width * 0.5 + "px";
										linkWindowHeight = screen.height * 0.7 + "px";
									}
									
									instance._openDialog(instance.ATTRS.SURVEY_ADMIN_LINK_FONT, instance._getLinkURL()
											, linkWindowWidth, linkWindowHeight, false);
								}
							)
							
						} else if (childClass == instance.ATTRS.SURVEY_ADMIN_REMOVE){
							
							$(child).on(
								'click', function(){
									instance._removeSurvey();
								}
							)
							
						}
					}
				)
			},
			
			_openDialog: function(title, renderURL, width, height, refreshPortlet){
				
				var instance = this;
				var dialogWindow = instance.ATTRS.dialogWindow;
				
				if(dialogWindow){
					dialogWindow.destroy();
					dialogWindow = null;
				}
				dialogWindow = Liferay.Util.Window.getWindow(
					{
						id: Liferay.SurveyToolConstants.PORTLET_NAMESPACE + 'survey_dialog_window',
						dialog: {
				           	draggable: false,
				           	centered: true,
				           	resizable: false,
				           	width: width,
				           	height: height,
				           	modal: true,
				           	destroyOnHide: true,
							constrain2view: true,
							after: {
					        	destroy: function(event) {
					        		if (refreshPortlet) {
					        			var listMode = "card";
					        			if($('.active.survey-filter-btn').attr('id') == 'list_btn'){
					        				listMode = 'list';
					        			}
					        			Liferay.Portlet.refresh("#p_p_id" + Liferay.SurveyToolConstants.PORTLET_NAMESPACE,
					        				{
					        					_LCSurvey_WAR_LCSurveyportlet_listMode: listMode
					        				}
					        			);
					        		}
					        	}
					    	}
				       	},
				       	title: title
					}
				).plug(
					A.Plugin.DialogIframe,
					{
						autoLoad: false,
			            iframeCssClass: 'dialog-iframe',
			            uri: renderURL
					}
				).show();
			},
			
			_getViewResultURL: function(){
				
				var instance = this;
				var viewResultURL = Liferay.PortletURL.createRenderURL();
				viewResultURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				viewResultURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				viewResultURL.setParameter("jspPage", "/html/admin/result/home.jsp");
				viewResultURL.setParameter("mainId", instance.mainId);
				
				return viewResultURL.toString();
			},
			
			_getEditURL: function(){
				var instance = this;
				var editURL = Liferay.PortletURL.createRenderURL();
				editURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				editURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				editURL.setParameter("jspPage", "/html/admin/edit/home.jsp");
				editURL.setParameter("mainId", instance.mainId);
				
				return editURL.toString();
			},
			
			_getLinkURL: function(){
				
				var instance = this;
				var linkURL = Liferay.PortletURL.createRenderURL();
				linkURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				linkURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				linkURL.setParameter("jspPage", "/html/admin/link/home.jsp");
				linkURL.setParameter("mainId", instance.mainId);
				
				return linkURL.toString();
			},
			
			_removeSurvey: function(){
				
				var instance = this;
				
				if(confirm(instance.ATTRS.DELETE_CONFIRM_FONT)){
					
					location.href = instance.removeURL;
				}
			}
		}
		
		var SurveyAdminFilter = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
			
			instance.openTime = arguments[0].openTime;
			
			instance.calculateScore = arguments[0].calculateScore;
			
			instance.title = arguments[0].title;
			
			$(instance.trigger).on(
					
				'click', function(){
					
					var $this = $(this);
					
					if(surveyAdminFilter != null){
						
						surveyAdminFilter.close();
						
					}else{
						surveyAdminFilter = new AdminFilter(
							{
								top: $this.offset().top,
								left: $this.offset().left,
								height: $this.outerHeight(),
								width: $this.outerWidth(),
								openTime: instance.openTime,
								calculateScore: instance.calculateScore,
								title: instance.title
							}
						);
						surveyAdminFilter.show();
					}
				}
			);
		}
		Liferay.SurveyAdminFilter = SurveyAdminFilter;
		
		var AdminFilter = function(){
			
			var instance = this;
			
			instance.top = arguments[0].top;
			
			instance.left = arguments[0].left;
			
			instance.height = arguments[0].height;
			
			instance.width = arguments[0].width;
			
			instance.openTime = arguments[0].openTime;
			
			instance.calculateScore = arguments[0].calculateScore;
			
			instance.title = arguments[0].title;
		}
		
		AdminFilter.prototype = {
			
			ATTRS: {
				
				ALL_FONT: Liferay.Language.get('all'),
				
				OPEN_TIME_FONT: Liferay.Language.get('survey-opening-time'),
				
				ACTIVE_FONT: Liferay.Language.get('survey-active'),
				
				EXPIRED_FONT: Liferay.Language.get('survey-expired'),
				
				NOT_YET_STARTED_FONT: Liferay.Language.get('survey-not-yet-started'),
				
				CALCULATE_SCORE_FONT: Liferay.Language.get('survey-calculate-score'),
				
				YES_FONT: Liferay.Language.get('yes'),
				
				NO_FONT: Liferay.Language.get('no'),
				
				TITLE_FONT: Liferay.Language.get('survey-title'),
				
				FILTER_FONT: Liferay.Language.get('filter'),
				
				CLEAR_FONT: Liferay.Language.get('clear'),
				
				UI: function(openingTime, calculateScore, title){
					
					var instance = this;
					var openingTimeSelectTitle = instance.ALL_FONT;
					var calculateScoreSelectTitle = instance.ALL_FONT;
					
					// opening time select title
					if(openingTime == '0')
						openingTimeSelectTitle = instance.ACTIVE_FONT;
					
					else if(openingTime == '1')
						openingTimeSelectTitle = instance.EXPIRED_FONT;
					
					else if(openingTime == '2')
						openingTimeSelectTitle = instance.NOT_YET_STARTED_FONT;
					
					// calculate score select title
					if(calculateScore == '0')
						calculateScoreSelectTitle = instance.YES_FONT;
					
					else if(calculateScore == '1')
						calculateScoreSelectTitle = instance.NO_FONT;
					
					return '<div id="' + Liferay.SurveyToolConstants.ADMIN_FILTER_TOOL_ID + '" class="survey-filter-tool"> <div class="survey-filter-row"> <p>'
						+ instance.OPEN_TIME_FONT + '</p> <div class="survey-dropdown"> <div class="survey-dropdown-title-row"> <font class="survey-dropdown-title">'
						+ openingTimeSelectTitle + '</font> <i class="icon-caret-down"></i> </div> <div class="survey-dropdown-option-container"> <label class="survey-dropdown-option"> <input name="s_openTime" class="survey-hidden-input" type="radio" value="" data-text="'
						+ instance.ALL_FONT + '"' + (openingTime == '' ? 'checked>' : '>') + instance.ALL_FONT + '</label> <label class="survey-dropdown-option"> <input name="s_openTime" class="survey-hidden-input" type="radio" value="0" data-text="'
						+ instance.ACTIVE_FONT + '"' + (openingTime == '0' ? 'checked>' : '>') + instance.ACTIVE_FONT + '</label> <label class="survey-dropdown-option"> <input name="s_openTime" class="survey-hidden-input" type="radio" value="1" data-text="'
						+ instance.EXPIRED_FONT + '"' + (openingTime == '1' ? 'checked>' : '>') + instance.EXPIRED_FONT + '</label> <label class="survey-dropdown-option"> <input name="s_openTime" class="survey-hidden-input" type="radio" value="2" data-text="'
						+ instance.NOT_YET_STARTED_FONT + '"' + (openingTime == '2' ? 'checked>' : '>') + instance.NOT_YET_STARTED_FONT + '</label> </div> </div> </div> <div class="survey-filter-row"> <p>'
						+ instance.CALCULATE_SCORE_FONT + '</p> <div class="survey-dropdown"> <div class="survey-dropdown-title-row"> <font class="survey-dropdown-title">'
						+ calculateScoreSelectTitle + '</font> <i class="icon-caret-down"></i> </div> <div class="survey-dropdown-option-container"> <label class="survey-dropdown-option"> <input name="s_calculateScore" class="survey-hidden-input" type="radio" value="" data-text="'
						+ instance.ALL_FONT + '"' + (calculateScore == '' ? 'checked>' : '>') + instance.ALL_FONT + '</label> <label class="survey-dropdown-option"> <input name="s_calculateScore" class="survey-hidden-input" type="radio" value="0" data-text="'
						+ instance.YES_FONT + '"' + (calculateScore == '0' ? 'checked>' : '>') + instance.YES_FONT + '</label> <label class="survey-dropdown-option"> <input name="s_calculateScore" class="survey-hidden-input" type="radio" value="1" data-text="'
						+ instance.NO_FONT + '"' + (calculateScore == '1' ? 'checked>' : '>') + instance.NO_FONT + '</label> </div> </div> </div> <div class="survey-filter-row"> <p>'
						+ instance.TITLE_FONT + '</p> <input name="s_title" value="' + title + '"> </div> <div class="survey-filter-row survey-filter-button-row"> <button id="survey_filter_btn" class="btn btn-primary"> <i class="icon-refresh"></i> '
						+ instance.FILTER_FONT + ' </button> <button id="survey_clear_btn" class="btn btn-default"> <i class="icon-trash"></i> ' 
						+ instance.CLEAR_FONT + ' </button> </div> </div>'
				}
			},	
				
			show: function(){
				
				var instance = this;
				
				$('html').append(instance.ATTRS.UI(instance.openTime, instance.calculateScore, instance.title));
				
				var filterWidth = $('#' + Liferay.SurveyToolConstants.ADMIN_FILTER_TOOL_ID).width();
				
				$('#' + Liferay.SurveyToolConstants.ADMIN_FILTER_TOOL_ID).css(
					{
						'top': instance.top + instance.height + 10,
						'left': instance.left + instance.width / 2 - filterWidth / 2
					}		
				);
				
				instance._initializeItem();
				
				$('#' + Liferay.SurveyToolConstants.ADMIN_FILTER_TOOL_ID).animate(
					{
						opacity: 1
					}, 150
				);
			},
				
			close: function(){
				
				surveyAdminFilter = null;
				
				$('#' + Liferay.SurveyToolConstants.ADMIN_FILTER_TOOL_ID).remove();
			},
			
			_initializeItem: function(){
				
				var instance = this;
				
				instance._selectEvent();
				
				instance._filterBtnEvent();
				
				instance._clearBtnEvent();
			},
			
			_selectEvent: function(){
				
				$('.survey-dropdown-title-row').on(
						
					'click', function(){
						
						var optionContainer = $(this).next();
						
						if(optionContainer.hasClass('open'))
							optionContainer.removeClass('open');
						else
							optionContainer.addClass('open');
					}	
				);
				
				$('input[name="s_openTime"], input[name="s_calculateScore"]').on(
						
					'click', function(){
					
						var $this = $(this);
						
						$this.closest('.survey-dropdown').find('.survey-dropdown-title').html($this.attr('data-text'));
						
						$this.closest('.survey-dropdown-option-container').removeClass('open');
					}	
				);
			},
			
			_filterBtnEvent: function(){
				
				$('#survey_filter_btn').on(
					
					'click', function(){
						
						var listMode = 'card';
						
						if($('.active.survey-filter-btn').attr('id') == 'list_btn')
							listMode = 'list';
						
						Liferay.Portlet.refresh("#p_p_id" + Liferay.SurveyToolConstants.PORTLET_NAMESPACE,
	        				{
	        					_LCSurvey_WAR_LCSurveyportlet_listMode: listMode,
	        					_LCSurvey_WAR_LCSurveyportlet_openTime: $('input[name="s_openTime"]:checked').val(),
	        					_LCSurvey_WAR_LCSurveyportlet_calculateScore: $('input[name="s_calculateScore"]:checked').val(),
	        					_LCSurvey_WAR_LCSurveyportlet_title: $('input[name="s_title"]').val()
	        				}
	        			);
					}
				);
			},
			
			_clearBtnEvent: function(){
				
				var instance = this;
				
				$('#survey_clear_btn').on(
						
					'click', function(){
						
						$('.survey-dropdown-title').html(instance.ATTRS.ALL_FONT);
						
						$('input[name="s_openTime"][value=""]').prop("checked", true);
						
						$('input[name="s_calculateScore"][value=""]').prop("checked", true);
						
						$('input[name="s_title"]').val("");
					}
				);
			}
		}
		
		var SurveyPageTool = function(){
			
			var instance = this;
			
			instance.triggerId = arguments[0].trigger;
			
			$(instance.triggerId).on(
				'click', function(){
					if(surveyPageTool == null){
						surveyPageTool = new PageTool(
							{
								triggerId: instance.triggerId
							}
						);
						surveyPageTool.show();
					} else {
						if(surveyQuestionTool != null){
							surveyQuestionTool.close();
						}
						surveyPageTool.close();
					}
				}	
			);
			
			$(instance.triggerId).prev().on(
				'click', function(){
					
					var $this = $(this);
					
					if($('.survey-page-container').css('width') != $('#survey_update_layout').css('width')){
						
						$('.survey-architecture-container').removeClass('survey-architecture-container-extend', 200);
						$('.survey-page-container').addClass('survey-page-container-extend', 200);
						
						$this.find('i').removeClass('icon-arrow-left');
						$this.find('i').addClass('icon-arrow-right');
						$this.attr('data-tips', Liferay.Language.get('open'));
						
					}else{
						
						$('.survey-architecture-container').addClass('survey-architecture-container-extend', 200);
						$('.survey-page-container').removeClass('survey-page-container-extend', 200);
						
						$this.find('i').removeClass('icon-arrow-right');
						$this.find('i').addClass('icon-arrow-left');
						$this.attr('data-tips', Liferay.Language.get('collapse'));
					}
				}	
			);
		}
		Liferay.SurveyPageTool = SurveyPageTool;
		
		var PageTool = function(){
			
			var instance = this;
			
			instance.triggerId = arguments[0].triggerId;
		}
		
		PageTool.prototype = {
			
			ATTRS: {
				
				SURVEY_SAVE_BTN_ID: 'survey_save_btn',
				
				SURVEY_PREVIEW_BTN_ID: 'survey_preview_btn',
				
				SURVEY_DELETE_PAGE_BTN_ID: 'survey_delete_page_btn',
				
				SURVEY_PAGE_GUIDE_BTN_ID: 'survey_page_guide_btn',
				
				SURVEY_ADD_PAGE_BTN_ID: 'survey_add_page_btn',
				
				SURVEY_ADD_QUESTION_ID: 'survey_add_question_btn',
				
				SURVEY_SAVE_BTN_TIPS: Liferay.Language.get('save'),
				
				SURVEY_PREVIEW_BTN_TIPS: Liferay.Language.get('preview'),
				
				SURVEY_DELETE_PAGE_BTN_TIPS: Liferay.Language.get('delete'),
				
				SURVEY_PAGE_GUIDE_BTN_TIPS: Liferay.Language.get('page-guide'),
				
				SURVEY_ADD_PAGE_BTN_TIPS: Liferay.Language.get('create-page'),
				
				SURVEY_ADD_QUESTION_TIPS: Liferay.Language.get('create-question'),
				
				SAVED_SUCCESSFULLY: Liferay.Language.get('saved-successfully'),
				
				REQUEST_IS_IN_PROGRESS: Liferay.Language.get('request-is-in-progress'),
				
				DATE_ERROR_MESSAGE: Liferay.Language.get('starting-date-cannot-be-later-than-the-ending-date'),
				
				PLEASE_SIGN_IN: Liferay.Language.get('please-sign-in-to-access-this-application'),
				
				PAGE_TOOL_UI: function(){
					return '<div id="' 
							+ Liferay.SurveyToolConstants.PAGE_TOOL_ID + '">'
							+ '<div id="' + this.SURVEY_SAVE_BTN_ID + '" class="survey-edit-tool-btn show-tips" data-tips="' + this.SURVEY_SAVE_BTN_TIPS + '"><i class="icon-save"></i></div>'
							+ '<div id="' + this.SURVEY_PREVIEW_BTN_ID + '" class="survey-edit-tool-btn show-tips" data-tips="' + this.SURVEY_PREVIEW_BTN_TIPS + '"><i class="icon-eye-open"></i></div>'
							+ '<div id="' + this.SURVEY_DELETE_PAGE_BTN_ID + '" class="survey-edit-tool-btn show-tips" data-tips="' + this.SURVEY_DELETE_PAGE_BTN_TIPS + '"><i class="icon-trash"></i></div>'
							+ '<div id="' + this.SURVEY_PAGE_GUIDE_BTN_ID + '" class="survey-edit-tool-btn show-tips" data-tips="' + this.SURVEY_PAGE_GUIDE_BTN_TIPS + '"><i class="icon-signout"></i></div>'
							+ '<div id="' + this.SURVEY_ADD_PAGE_BTN_ID + '" class="survey-edit-tool-btn show-tips" data-tips="' + this.SURVEY_ADD_PAGE_BTN_TIPS + '"><i class="icon-plus"></i></div>'
							+ '<div id="' + this.SURVEY_ADD_QUESTION_ID + '" class="survey-edit-tool-btn show-tips" data-tips="' + this.SURVEY_ADD_QUESTION_TIPS + '"><i class="icon-list-ol"></i></div></div>'
				}
			},
			
			show: function(){
				var instance = this;
				var trigger = $(instance.triggerId);
				
				trigger.after(instance.ATTRS.PAGE_TOOL_UI());
				instance._initializeItem();
				
				$("#" + Liferay.SurveyToolConstants.PAGE_TOOL_ID).fadeIn(100,
					function(){
						trigger.addClass("tool-bar-active-btn");
					}
				);
			},
			
			close: function(){
				
				var instance = this;
				
				$("#" + Liferay.SurveyToolConstants.PAGE_TOOL_ID).remove();
				$(instance.triggerId).removeClass("tool-bar-active-btn");
				
				surveyPageTool = null;
			},
			
			_initializeItem: function(){
				
				var instance = this;
				var trigger = $(instance.triggerId);
				
				$('#' + Liferay.SurveyToolConstants.PAGE_TOOL_ID).children().each(
						
					function(index, child){
						
						var childId = $(child).attr('id');
						
						if(childId == instance.ATTRS.SURVEY_SAVE_BTN_ID){
							
							$(child).on(
								'click', function(){
									instance._saveEvent("save");
								}
							);
							
						}else if(childId == instance.ATTRS.SURVEY_PREVIEW_BTN_ID){
							
							$(child).on(
								'click', function(){
									instance._previewEvent();
								}
							);
							
						}else if(childId == instance.ATTRS.SURVEY_DELETE_PAGE_BTN_ID){
							
							$(child).on(
								'click', function(){
									instance._deletePageEvent();
								}
							);
							
						}else if(childId == instance.ATTRS.SURVEY_PAGE_GUIDE_BTN_ID){
							
							$(child).on(
								'click', function(){
									instance._pageGuideEvent($(this));
								}
							);
							
						}else if(childId == instance.ATTRS.SURVEY_ADD_PAGE_BTN_ID){
							
							$(child).on(
								'click', function(){
									instance._addPageEvent();
								}
							);
							
						}else if(childId == instance.ATTRS.SURVEY_ADD_QUESTION_ID){
	
							$(child).on(
								'click', function(e){
									instance._addQuestionEvent($(this), e);
								}
							);
						}
					}
				);
			},
			
			_saveEvent: function(action){
				
				var instance = this;
				var mainSetting = Liferay.SurveyInstanceCollection.surveyMainSetting;
				var startDateObj = new Date(mainSetting.startDate);
				var endDateObj = new Date(mainSetting.endDate);
				var surveyAlert = null;
				
				// check start date
				if(endDateObj.getTime() < startDateObj.getTime()){
					surveyAlert = new Liferay.SurveyAlertMessage(
						{
							message: '<i class="icon-warning-sign"></i>' + instance.ATTRS.DATE_ERROR_MESSAGE,
							status: 'danger',
							autoClose: 2500
						}	
					);
					surveyAlert.show();
					return;
				}
				
				// check user is sign in
				if(Liferay.Session.get('sessionState') == 'expired'){
					surveyAlert = new Liferay.SurveyAlertMessage(
						{
							message: '<i class="icon-warning-sign"></i>' + instance.ATTRS.PLEASE_SIGN_IN,
							status: 'info',
							autoClose: 2500
						}	
					);
					surveyAlert.show();
					return;
				}
				
				// avoid continuous click save button
				if(!submitStatus)
					return;
				
				// change submit status
				submitStatus = false;
				
				// show alert message
				surveyAlert = new Liferay.SurveyAlertMessage(
					{
						message: '<i class="icon-globe"></i>' + instance.ATTRS.REQUEST_IS_IN_PROGRESS,
						status: 'info',
						autoClose: 0
					}	
				);
				surveyAlert.show();
				
				Liferay.SurveyInstanceCollection.refreshPageDirect();
				
				instance._initializeForm();
				
				var resourceURL = Liferay.PortletURL.createResourceURL();
				resourceURL.setResourceId('updateSurvey');
				resourceURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				resourceURL.setPlid(themeDisplay.getPlid());
				resourceURL.setParameter('mainId', Liferay.SurveyToolConstants.SURVEY_MAIN_ID);
				
				// subhmit form
				A.io.request(
					resourceURL.toString(),
					{
						method: 'POST',
						dataType: 'json',
						form: {
							id: Liferay.SurveyToolConstants.FORM_ID 
						},
						after: {
							success: function(event, id, obj) {
								
								instance._resetInstanceIdAfterSubmit(this.get('responseData'));
								$('#' + Liferay.SurveyToolConstants.FORM_ID ).remove();
								submitStatus = true;
								
								surveyAlert.change('<i class="icon-ok"></i>' + instance.ATTRS.SAVED_SUCCESSFULLY, 'success', 2500);
								
								if(action == "preview"){
									
									var previewURL = Liferay.PortletURL.createRenderURL();
									previewURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
									previewURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
									previewURL.setParameter("jspPage", "/html/write/introduction.jsp");
									previewURL.setParameter("mainId", Liferay.SurveyToolConstants.SURVEY_MAIN_ID);
									previewURL.setParameter("isPreview", 1);
									
									window.open(previewURL.toString());
								}
							}
						}
					}
				);
			},
			
			_previewEvent: function(){
				
				var instance = this;
				
				instance._saveEvent('preview');
			},
			
			_deletePageEvent: function(){
				
				var activePage = $('.survey-page.survey-page-active');
				var activePageId = activePage.attr('id');
				
				if(activePageId == 'survey_main_page' || Liferay.SurveyInstanceCollection.pageArray.length == 1)
					return;
				
				if(confirm(Liferay.SurveyInstanceConstants.DELETE_CONFIRM_FONT)){
					
					var pageId = activePageId.substring(activePageId.lastIndexOf("_") + 1, activePageId.length);
					var pageInstance = Liferay.SurveyInstanceCollection.getInstanceByElementId('page', pageId);
					
					// remove page architecture
					$('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + pageId).remove();
					
					activePage.removeClass('survey-page-active');
					activePage.prev().addClass('survey-page-active');
					
					// remove page
					$('#' + Liferay.SurveyInstanceConstants.SURVEY_PAGE_ITEM_NAMESPACE + pageId).remove();
					
					// remove page instance
					Liferay.SurveyInstanceCollection.removeArrayObject(Liferay.SurveyInstanceCollection.pageArray, pageInstance);
					
					// remove question instance
					Liferay.SurveyInstanceCollection.removeQuestionsByPageId(pageId);
					
					// remove sub question instance
					Liferay.SurveyInstanceCollection.removeSubQuestionByPageId(pageId);
					
					// remove option instance
					Liferay.SurveyInstanceCollection.removeOptionsByPageId(pageId);
					
					// reset page and option instances pageDirectId
					Liferay.SurveyInstanceCollection.removePageDirect(pageId);
					
					Liferay.SurveyInstanceCollection.refreshPageNo();
				}
			},
			
			_pageGuideEvent: function(trigger){
				
				var activePage = $('.survey-page.survey-page-active');
				var activePageId = activePage.attr('id');
				
				if(activePageId == 'survey_main_page')
					return;
				
				if(surveyPageDirectTool == null){
					
					var pageId = activePageId.substring(activePageId.lastIndexOf("_") + 1, activePageId.length);
					
					var pageInstance = Liferay.SurveyInstanceCollection.getInstanceByElementId('page', pageId);
					
					surveyPageDirectTool = new PageDirectTool(
						{
							pageInstance: pageInstance,
							trigger: trigger
							
						}
					);
					surveyPageDirectTool.show();
				}else{
					surveyPageDirectTool.close();
				}
			},
			
			_addPageEvent: function(){
				
				var elementId = Liferay.SurveyUtils.createRandomNumber();
				
				new Liferay.SurveyPage(
					{
						id: 0,
						elementId: elementId,
						archId: Liferay.SurveyInstanceConstants.SURVEY_PAGE_ARCHITECTURE_ITEM_NAMESPACE + elementId,
						no: Liferay.SurveyInstanceCollection.getLastPageIndex() + 1,
						title: '',
						pageDirect: 0,
						pageDirectId: 0
					}
				).createUI();
			},
			
			_addQuestionEvent: function(trigger, event){
				
				if(surveyQuestionTool == null){
					surveyQuestionTool = new QuestionTool(
						{
							trigger: trigger
						}
					);
					surveyQuestionTool.show();
				}else{
					if(event.target.id != this.ATTRS.SURVEY_ADD_QUESTION_ID 
						&& event.target.parentElement.id != this.ATTRS.SURVEY_ADD_QUESTION_ID)
						
						return;
					
					surveyQuestionTool.close();
				}
			},
			
			_initializeForm: function(){
				
				$('#survey_update_layout').append('<form id="' + Liferay.SurveyToolConstants.FORM_ID + '"><form>');
				
				var instance = this;
				var form = $('#' + Liferay.SurveyToolConstants.FORM_ID);
				var mainSetting = Liferay.SurveyInstanceCollection.surveyMainSetting;
				
				// create main setting input
				instance._createInput(form, "title", mainSetting.title);
				instance._createInput(form, "description", window._LCSurvey_WAR_LCSurveyportlet_description.getHTML());
				instance._createInput(form, "epilog", window._LCSurvey_WAR_LCSurveyportlet_epilog.getHTML());
				instance._createInput(form, "startDate", mainSetting.startDate);
				instance._createInput(form, "endDate",  mainSetting.endDate);
				instance._createInput(form, "needAuth", mainSetting.needAuth);
				instance._createInput(form, "calculateScore", mainSetting.calculateScore);
				instance._createInput(form, "viewAnswer", mainSetting.viewAnswer);
				instance._createInput(form, "color", mainSetting.color);
				
				instance._createInput(form, "pageCount", Liferay.SurveyInstanceCollection.pageArray.length);
				
				// create page input
				$.each(
					Liferay.SurveyInstanceCollection.pageArray, function(pageIndex, page){
						
						instance._createInput(form, "page" + page.no + "_id", page.id);
						if(page.id == 0){
							instance._createInput(form, "page" + page.no + "_elementId", page.elementId);
						}
						instance._createInput(form, "page" + page.no + "_title", page.title);
						instance._createInput(form, "page" + page.no + "_pageDirect", page.pageDirect);
						
						var questions = Liferay.SurveyInstanceCollection.questionArray.filter(
							function(question){
								return question.pageId == page.elementId;
							}
						);
						instance._createInput(form, "questionCount" + page.no, questions.length);
						
						// create quesiton input
						$.each(
							questions, function(questionIndex, question){
								
								instance._createInput(form, "question" + page.no + "_" + question.no + "_id", question.id);
								if(question.id == 0){
									instance._createInput(form, "question" + page.no + "_" + question.no + "_elementId", question.elementId);
								}
								instance._createInput(form, "question" + page.no + "_" + question.no + "_question", question.question);
								instance._createInput(form, "question" + page.no + "_" + question.no + "_type", question.type);
								instance._createInput(form, "question" + page.no + "_" + question.no + "_isRequired", question.isRequired);
								instance._createInput(form, "question" + page.no + "_" + question.no + "_fileId", question.fileId);
								
								if(question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX 
									|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE
									|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST
									|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
									|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
									
									instance._createInput(form, "question" + page.no + "_" + question.no + "_hasOther", question.hasOther);
									instance._createInput(form, "question" + page.no + "_" + question.no + "_optionDirect", question.optionDirect);
									instance._createInput(form, "question" + page.no + "_" + question.no + "_points"
										, mainSetting.calculateScore ? question.points : 0);
									
									// filter option by questionId
									var options = Liferay.SurveyInstanceCollection.optionArray.filter(
										function(option){
											return option.questionId == question.elementId;
										}
									);
									instance._createInput(form, "optionCount" + page.no + "_" + question.no, options.length);
									
									// create option input
									$.each(
										options, function(optionIndex, option){
											
											instance._createInput(form, "option" + page.no + "_" + question.no + "_" + option.no + "_id", option.id);
											if(option.id == 0){
												instance._createInput(form, "option" + page.no + "_" + question.no + "_" + option.no + "_elementId", option.elementId);
											}
											instance._createInput(form, "option" + page.no + "_" + question.no + "_" + option.no + "_option", option.option);
											instance._createInput(form, "option" + page.no + "_" + question.no + "_" + option.no + "_isAns"
												, mainSetting.calculateScore ? option.isAns : false);
											instance._createInput(form, "option" + page.no + "_" + question.no + "_" + option.no + "_pageDirect", option.pageDirect);
											instance._createInput(form, "option" + page.no + "_" + question.no + "_" + option.no + "_fileId", option.fileId);
										}
									);
									
									if(question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
										|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
										
										// filter sub question by parentElementId
										var subQuestions = Liferay.SurveyInstanceCollection.subQuestionArray.filter(
											function(subQuestion){
												return subQuestion.parentElementId == question.elementId;
											}
										);
										instance._createInput(form, "subQuestionCount" + page.no + "_" + question.no, subQuestions.length);
										
										// create sub question input
										$.each(
											subQuestions, function(subQuestionIndex, subQuestion){
												
												instance._createInput(form, "subQuestion" + page.no + "_" + question.no + "_" + subQuestion.no + "_id", subQuestion.id);
												if(subQuestion.id == 0){
													instance._createInput(form, "subQuestion" + page.no + "_" + question.no + "_" + subQuestion.no + "_elementId", subQuestion.elementId);
												}
												instance._createInput(form, "subQuestion" + page.no + "_" + question.no + "_" + subQuestion.no + "_question", subQuestion.question);
											}
										);
									}
									
								}else if(question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR){
									
									instance._createInput(form, "question" + page.no + "_" + question.no + "_starsCount", question.starsCount);
								}
							}
						)
					}
				);
			},
			
			_createInput: function(form, name, value){
				
				$('<input>').attr(
					{
						type: 'hidden', 
						name: Liferay.SurveyToolConstants.PORTLET_NAMESPACE + name, 
						value: value
					}
				).appendTo(form);
			},
			
			_resetInstanceIdAfterSubmit: function(responseArray){
				
				if(responseArray == null || responseArray.length == 0)
					return;
				
				for(var v = 0; v < responseArray.length; v++){
					
					Liferay.SurveyInstanceCollection.getInstanceByElementId(responseArray[v].type
						, responseArray[v].elementId).id = responseArray[v].id;
				}
			}
		}
		
		var QuestionTool = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
		}
		
		QuestionTool.prototype = {
				
			ATTRS: {
				
				ADD_TEXT_BTN_ID: "add_text_btn",
				
				ADD_SINGLE_CHOICE_BTN_ID: "add_single_choice_btn",
				
				ADD_CHECKBOX_BTN_ID: "add_checkbox_btn",
				
				ADD_DROPDOWN_LIST_BTN_ID: "add_dropdown_list_btn",
				
				ADD_DATE_BTN_ID: "add_date_btn",
				
				ADD_STAR_BTN_ID: "add_star_btn",
				
				ADD_SINGLE_CHOICE_LATTICE_BTN_ID: "add_single_choice_lattice_btn",
				
				ADD_CHECKBOX_LATTICE_BTN_ID: "add_checkbox_lattice_btn",
				
				QUESTION_TOOL_UI: function(){
					
					var instance = this;
					
					return '<div id="' + Liferay.SurveyToolConstants.QUESTION_TOOL_ID + '" class="' + Liferay.SurveyToolConstants.SURVEY_TOOL_CLASS_NAME + '">'
							+ '<div id="' + instance.ADD_TEXT_BTN_ID + '"><i class="icon-font"></i>' + Liferay.SurveyInstanceConstants.TEXT_FONT + '</div>'
							+ '<div id="' + instance.ADD_SINGLE_CHOICE_BTN_ID + '"><i class="icon-ok-sign"></i>' + Liferay.SurveyInstanceConstants.SINGLE_CHOICE_FONT + '</div>' 
							+ '<div id="' + instance.ADD_CHECKBOX_BTN_ID + '"><i class="icon-check-sign"></i>' + Liferay.SurveyInstanceConstants.CHECKBOX_FONT + '</div>' 
							+ '<div id="' + instance.ADD_DROPDOWN_LIST_BTN_ID + '"><i class="icon-list-ul"></i>' + Liferay.SurveyInstanceConstants.DROPDOWN_LIST_FONT + '</div>' 
							+ '<div id="' + instance.ADD_DATE_BTN_ID + '"><i class="icon-calendar"></i>' + Liferay.SurveyInstanceConstants.DATE_FONT + '</div>' 
							+ '<div id="' + instance.ADD_STAR_BTN_ID + '"><i class="icon-star"></i>' + Liferay.SurveyInstanceConstants.STAR_FONT + '</div>' 
							+ '<div id="' + instance.ADD_SINGLE_CHOICE_LATTICE_BTN_ID + '"><i class="icon-th"></i>' + Liferay.SurveyInstanceConstants.SINGLE_CHOICE_LATTICE_FONT + '</div>' 
							+ '<div id="' + instance.ADD_CHECKBOX_LATTICE_BTN_ID + '"><i class="icon-th-large"></i>' + Liferay.SurveyInstanceConstants.CHECKBOX_LATTICE_FONT + '</div>' 
							+ '</div>'
				}
			},
			
			show: function(){
				
				var instance = this;
				var toolId = '#' + Liferay.SurveyToolConstants.QUESTION_TOOL_ID;
				var triggerHeight = instance.trigger.height();
				var triggerWidth = instance.trigger.width();
				
				$('#' + PageTool.prototype.ATTRS.SURVEY_ADD_QUESTION_ID).append(instance.ATTRS.QUESTION_TOOL_UI());
				$(toolId).css(
					{
						top: triggerHeight + 10,
						left: -($(toolId).width() / 2) + (triggerWidth / 2)
					}
				)
				instance._initializeItem();
				$(toolId).animate(
					{
						opacity: 1
					}, 150
				)
			},
			
			close: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyToolConstants.QUESTION_TOOL_ID).remove();
				
				surveyQuestionTool = null;
			},
			
			_initializeItem: function(){
				
				var instance = this;
				
				$('#' + Liferay.SurveyToolConstants.QUESTION_TOOL_ID).children().each(
						
					function(index, child){
						
						var $child = $(child);
						var questionType = "";
						
						if($child.attr('id') == instance.ATTRS.ADD_TEXT_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_TEXT;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_SINGLE_CHOICE_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_CHECKBOX_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_DROPDOWN_LIST_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_DATE_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_DATE;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_STAR_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_SINGLE_CHOICE_LATTICE_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE;
							
						}else if($child.attr('id') == instance.ATTRS.ADD_CHECKBOX_LATTICE_BTN_ID){
							
							questionType = Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE;
						}
						$child.on('click', function(){
								instance._addQuestion(questionType);
							}
						)
					}
				)
			},
			
			_addQuestion: function(questionType){
				
				var instance = this;
				var activePage = $('.survey-page.survey-page-active');
				var activePageId = activePage.attr('id');
				
				if(activePageId == 'survey_main_page')
					return;
					
				var pageId = activePageId.substring(activePageId.lastIndexOf("_") + 1, activePageId.length);
				var questionElementId = Liferay.SurveyUtils.createRandomNumber();
				var starsCount = 0;
				
				if(questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR){
					starsCount = 1;
				}
				
				new Liferay.SurveyQuestion(
					{
						id: 0,
						elementId: questionElementId,
						archId:  Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ARCHITECTURE_ITEM_NAMESPACE + questionElementId,
						pageId: pageId,
						no: Liferay.SurveyInstanceCollection.getLastQuestionIndexByPageId(pageId) + 1,
						question: Liferay.SurveyInstanceConstants.UNDEFINED_QUESTION,
						type: questionType,
						isRequired: false,
						hasOther: false,
						optionDirect: 0,
						points: 0,
						starsCount: starsCount,
						fileId: 0,
					}
				).createUI(activePage);
				
				if(questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE 
					|| questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
					|| questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST
					|| questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
					|| questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
					
					var optionElementId = Liferay.SurveyUtils.createRandomNumber();
					
					new Liferay.SurveyOption(
						{
							id: 0,
							elementId: optionElementId,
							pageId: pageId,
							questionId: questionElementId,
							no: 1,
							option: '',
							isAns: false,
							pageDirect: 0,
							pageDirectId: 0,
							fileId: 0
						}
					).createUI();
					
					if(questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
						|| questionType == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE){
						
						var subQuestionElementId = Liferay.SurveyUtils.createRandomNumber();
						
						new Liferay.SurveySubQuestion(
							{
								id: 0,
								elementId: subQuestionElementId,
								pageId: pageId,
								no: 1,
								question: '',
								parentElementId: questionElementId
							}		
						).createUI();
					}
				}
			}
		}
		
		var SurveyQuesSettingTool = function(){
			
			var instance = this;
			
			instance.questionInstance = arguments[0].questionInstance;
			
			if(surveyQuesSettingTool == null){
				surveyQuesSettingTool = new QuesSettingTool(
					{
						question: instance.questionInstance
					}
				);
				surveyQuesSettingTool.show();
			}else{
				surveyQuesSettingTool.close();
			}
		}
		Liferay.SurveyQuesSettingTool = SurveyQuesSettingTool;
		
		var QuesSettingTool = function(){
			
			var instance = this;
			
			instance.question = arguments[0].question;
		}
		
		QuesSettingTool.prototype = {
			
			ATTRS: {
				
				INT_RULE: /^[0-9]*[1-9][0-9]*$/,
				
				FLOAT_RULE: /^(0|[1-9]\d*|[1-9]\d*\.\d+|0\.\d*[1-9]\d*)$/,
				
				IS_REQUIRED: Liferay.Language.get('required'),
				
				OTHER_OPTION: Liferay.Language.get('other-option'),
				
				PAGE_GUIDE: Liferay.Language.get('page-guide'),

				POINTS: Liferay.Language.get('points'),
				
				STARS_COUNT: Liferay.Language.get('stars-count'),
				
				LAYOUT_UI: function(){
					return '<div id="' + Liferay.SurveyToolConstants.QUESTION_SETTING_TOOL_ID + '" class="' 
						+ Liferay.SurveyToolConstants.QUESTION_SETTING_TOOL_CLASS_NAME + '"></div>'
				},
				
				IS_REQUIRED_UI: function(isRequired){
					
					var instance = this;
					var checked = "";
					
					if(isRequired){
						checked = "checked";
					}
					
					return '<div class="survey-question-setting-row"> <font>' 
						+ instance.IS_REQUIRED +'</font> <label class="survey-toggle-container"> <input type="checkbox" name="isRequired" class="survey-hidden-input" '
						+ checked + '> <span class="survey-toggle-checkmark-container"> <span class="survey-toggle-checkmark"></span> </span> </label> </div>';
				},
				
				OTHER_OPTION_UI: function(hasOther){
					
					var instance = this;
					var checked = "";
					
					if(hasOther)
						checked = "checked";
					
					return '<div class="survey-question-setting-row"> <font>' 
						+ instance.OTHER_OPTION +'</font> <label class="survey-toggle-container"> <input type="checkbox" name="otherOption" class="survey-hidden-input" '
						+ checked + '> <span class="survey-toggle-checkmark-container"> <span class="survey-toggle-checkmark"></span> </span> </label> </div>';
				},
				
				PAGE_GUIDE_UI: function(optionDirect){
					
					var instance = this;
					var checked = "";
					
					if(optionDirect)
						checked = "checked";
					
					return '<div class="survey-question-setting-row"> <font>' 
						+ instance.PAGE_GUIDE +'</font> <label class="survey-toggle-container"> <input type="checkbox" name="pageGuide" class="survey-hidden-input" '
						+ checked + '> <span class="survey-toggle-checkmark-container"> <span class="survey-toggle-checkmark"></span> <span> </label> </div>';
				},
				
				POINTS_UI: function(points){
					
					var instance = this;
					
					return '<div class="survey-question-setting-row"> <font>' 
						+ instance.POINTS +'</font> <div class="append-row"> <div class="append-btn minus-btn"> <i class="icon-minus"></i> </div> <input class="number-input" name="points" value="' 
						+ points + '"> <div class="append-btn plus-btn"> <i class="icon-plus"></i> </div> </div> </div>';
				},
				
				STARS_COUNT_UI: function(starsCount){
					
					var instance = this;
					
					return '<div class="survey-question-setting-row"> <font>' 
						+ instance.STARS_COUNT +'(1 ~ 10)</font> <div class="append-row"> <div class="append-btn minus-btn"> <i class="icon-minus"></i> </div> <input class="number-input" name="starsCount" value="' 
						+ starsCount + '"> <div class="append-btn plus-btn"> <i class="icon-plus"></i> </div> </div> </div>';
				}
			},
			
			show: function(){
				
				var instance = this;
				var bindPageGuideInput = false;
				var bindOtherOptionInput = false;
				var bindPointsInput = false;
				var bindStarsCount = false;
				var calculateScore = $("input[name=calculateScore]");
				
				$("#" + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
					.find('.survey-question-tool-bar').append(instance.ATTRS.LAYOUT_UI());
				
				var questionSetting = $("#" + Liferay.SurveyToolConstants.QUESTION_SETTING_TOOL_ID);
				
				questionSetting.append(instance.ATTRS.IS_REQUIRED_UI(instance.question.isRequired));
				
				if(instance.question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE 
					|| instance.question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
					|| instance.question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
					
					bindPageGuideInput = true;
					
					if(instance.question.type != Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST){
						
						questionSetting.append(instance.ATTRS.OTHER_OPTION_UI(instance.question.hasOther));
						
						bindOtherOptionInput = true;
					}
					
					questionSetting.append(instance.ATTRS.PAGE_GUIDE_UI(instance.question.optionDirect));
					
					if(calculateScore.prop('checked')){
						
						questionSetting.append(instance.ATTRS.POINTS_UI(instance.question.points));
					
						bindPointsInput = true;
					}
				}
				
				if(instance.question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR){
					
					questionSetting.append(instance.ATTRS.STARS_COUNT_UI(instance.question.starsCount));
				
					bindStarsCount = true;
				}
				
				questionSetting.css(
					{
						'right': -(questionSetting.outerWidth()) + 15
					}
				)
				
				// bind event
				instance._initializeEvent(bindPageGuideInput, bindOtherOptionInput, bindPointsInput, bindStarsCount);
				
				questionSetting.animate(
					{
						height: 'toggle'
					}, 150
				);
			},
			
			save: function(){
				
				var instance = this;
				
				var pointsInput = $('input[name="points"]');
				var starsCountInput = $('input[name="starsCount"]');
				
				if(pointsInput.length != 0){
					
					var points = pointsInput.val();
					
					if(!instance.ATTRS.FLOAT_RULE.test(points)){
						points = 0;
					}
					
					instance._setPoints(parseFloat(points));
					instance.question.points = points;
				}
				
				if(starsCountInput.length != 0){
					
					var starsCount = starsCountInput.val();
					
					if(!instance.ATTRS.INT_RULE.test(starsCount) || starsCount < 1){
						starsCount = 1;
					}
					
					instance._setStarsCount(parseFloat(starsCount));
				}
			},
			
			close: function(){
				
				$("#" + Liferay.SurveyToolConstants.QUESTION_SETTING_TOOL_ID).remove();
				
				surveyQuesSettingTool = null;
			},
			
			_initializeEvent: function(bindPageGuideInput ,bindOtherOptionInput, bindPointsInput, bindStarsCount){
				
				var instance = this;
				
				// required input on change
				$('input[name="isRequired"]').on(
					'change', function(){
						if($(this).prop('checked')){
							instance.question.isRequired = true;
							$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
								.find('.label-important').removeClass('label-hidden');
						}else{
							instance.question.isRequired = false;
							$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
								.find('.label-important').addClass('label-hidden');
						}
					}
				);
				
				if(bindPageGuideInput){
					// option page guide input on change
					$('input[name="pageGuide"]').on(
						'change', function(){
							if($(this).prop('checked')){
								instance.question.optionDirect = true;
								$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
									.find('.survey-option-direct').removeClass('survey-option-direct-hidden');
							}else{
								instance.question.optionDirect = false;
								// reset options to no setting
								Liferay.SurveyInstanceCollection.resetOptionPageDirect(instance.question.elementId);
								$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
									.find('.survey-option-direct').addClass('survey-option-direct-hidden');
							}
						}
					);
				}
				
				if(bindOtherOptionInput){
					// other option input on change
					$('input[name="otherOption"]').on(
						'change', function(){
							if($(this).prop('checked')){
								instance.question.hasOther = true;
								$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
									.find('.label-warning').removeClass('label-hidden');
							}else{
								instance.question.hasOther = false;
								$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
									.find('.label-warning').addClass('label-hidden');
							}
						}
					);
				}
				
				if(bindPointsInput){
					// points input on change
					$('input[name="points"]').on(
						'change', function(){
					
							var points = $(this).val();
							
							if(!instance.ATTRS.FLOAT_RULE.test(points)){
								points = 0;
							}
							
							instance._setPoints(parseFloat(points));
						}
					);
					
					// minus button event
					$('input[name="points"]').prev().on(
						'click', function(){
							var points = parseFloat($('input[name="points"]').val()) - 1;
							instance._setPoints(parseFloat(points));
							$('input[name="points"]').select();
						}
					);
					
					// plus button event
					$('input[name="points"]').next().on(
						'click', function(){
							var points = parseFloat($('input[name="points"]').val()) + 1;
							instance._setPoints(parseFloat(points));
							$('input[name="points"]').select();
						}
					);
				}
				
				if(bindStarsCount){
					// stars count input on change
					$('input[name="starsCount"]').on(
						'change', function(){
					
							var starsCount = $(this).val();
							
							if(!instance.ATTRS.INT_RULE.test(starsCount) || starsCount < 1){
								starsCount = 1;
							}
							
							instance._setStarsCount(parseFloat(starsCount));
						}
					);
					
					// minus button event
					$('input[name="starsCount"]').prev().on(
						'click', function(){
							var starsCount = parseFloat($('input[name="starsCount"]').val()) - 1;
							instance._setStarsCount(parseFloat(starsCount));
							$('input[name="starsCount"]').select();
						}
					);
					
					// plus button event
					$('input[name="starsCount"]').next().on(
						'click', function(){
							var starsCount = parseFloat($('input[name="starsCount"]').val()) + 1;
							instance._setStarsCount(parseFloat(starsCount));
							$('input[name="starsCount"]').select();
						}
					);
				}
			},
			
			_setPoints: function(points){
				
				var instance = this;
				
				if(points < 0)
					points = 0;
				
				instance.question.points = points;
				
				$('input[name="points"]').val(points);
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
					.find('.label-info').html('<i class="icon-asterisk"></i>' + instance.ATTRS.POINTS + '：' + points);
			},
			
			_setStarsCount: function(starsCount){

				var instance = this;
				
				if(starsCount < 1 || starsCount > 10)
					starsCount = 1;
				
				instance.question.starsCount = starsCount;
				
				$('input[name="starsCount"]').val(starsCount);
				$('#' + Liferay.SurveyInstanceConstants.SURVEY_QUESTION_ITEM_NAMESPACE + instance.question.elementId)
					.find('.label-inverse').html('<i class="icon-sort-by-order"></i>' + instance.ATTRS.STARS_COUNT + '：' + starsCount);
			}
		}
		
		var PageDirectTool = function(){
			
			var instance = this;
			
			instance.pageInstance = arguments[0].pageInstance;
			
			instance.trigger = arguments[0].trigger;
		}
		PageDirectTool.prototype = {
			
			ATTRS: {

				SURVEY_PAGE_DIRECT_BTN_ID: 'survey_page_direct_btn',

				PAGE_DIRECT_TOOL_UI: function(pageTitle){
									
					var instance = this;
					
					return '<div id="' 
						+ Liferay.SurveyToolConstants.PAGE_DIRECT_TOOL_ID + '" class="' 
						+ Liferay.SurveyToolConstants.SURVEY_TOOL_CLASS_NAME + '"> <div id="' 
						+ instance.SURVEY_PAGE_DIRECT_BTN_ID + '">' 
						+ Liferay.SurveyInstanceConstants.GUIDE_TO + pageTitle + '</div> </div>'
				}
			},
			
			show: function(){
				
				var instance = this;
				var toolId = '#' + Liferay.SurveyToolConstants.PAGE_DIRECT_TOOL_ID;
				var pageTitle = Liferay.SurveyInstanceConstants.NO_SETTING;
				
				if(instance.pageInstance.pageDirectId != 0){
					if(instance.pageInstance.pageDirectId == -1){
						pageTitle = Liferay.SurveyInstanceConstants.SUBMIT_FORM;
					}else{
						pageTitle = Liferay.SurveyInstanceCollection.getInstanceByElementId('page'
							, instance.pageInstance.pageDirectId).title;
					}
				}
				
				$('#' + PageTool.prototype.ATTRS.SURVEY_PAGE_GUIDE_BTN_ID).append(instance.ATTRS.PAGE_DIRECT_TOOL_UI(pageTitle));
				
				$(toolId).css(
					{
						'top': instance.trigger.height() + 10,
						'left': -($(toolId).outerWidth() / 2) + instance.trigger.outerWidth() / 2
					}
				)
				
				$(toolId).animate(
					{
						opacity: 1
					}, 150
				);
				
				instance._initializeItem();
			},
			
			close: function(){
				
				var instance = this;
				var toolId = '#' + Liferay.SurveyToolConstants.PAGE_DIRECT_TOOL_ID;
				
				$(toolId).remove();
			
				surveyPageDirectTool = null;
			},
			
			_initializeItem: function(){
				
				var instance = this;
				var toolId = '#' + Liferay.SurveyToolConstants.PAGE_DIRECT_TOOL_ID;
				
				$(toolId).children().each(
					function(index, child){
						$(child).on(
							'click', function(){
								new Liferay.SurveyPageDirect(
									{
										triggerInstance: instance.pageInstance,
										currentPageId: instance.pageInstance.elementId
									}
								);
							}
						)
					}
				)
			}
		}
		
		var SurveyPageDirect = function(){
			
			var instance = this;
			
			instance.triggerInstance = arguments[0].triggerInstance;
			
			instance.currentPageId = arguments[0].currentPageId;
			
			if(surveyPageDirect != null){
				surveyPageDirect = null;
			}
			surveyPageDirect = new PageDirectSetting(
				{
					triggerInstance: instance.triggerInstance,
					currentPageId: instance.currentPageId
				}
			)
		}
		Liferay.SurveyPageDirect = SurveyPageDirect;
		
		var PageDirectSetting = function(){
			
			var instance = this;
			
			instance.triggerInstance = arguments[0].triggerInstance;
			
			instance.currentPageId = arguments[0].currentPageId;
			
			instance.show();
		}
		PageDirectSetting.prototype = {
			
			show: function(){
				
				var instance = this;
				var pages = Liferay.SurveyInstanceCollection.pageArray;
				
				var renderURL = Liferay.PortletURL.createRenderURL();
				renderURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				renderURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				renderURL.setParameter('jspPage', '/html/admin/edit/page_direct.jsp');
				renderURL.setParameter('pagesCount', pages.length);
				renderURL.setParameter('pageDirectId', instance.triggerInstance.pageDirectId);
				renderURL.setParameter('currentPageId', instance.currentPageId);
				
				for(var v = 0; v < pages.length; v++){
					
					renderURL.setParameter('pageElementId' + v, pages[v].elementId);
					renderURL.setParameter('pageTitle' + v, pages[v].title);
				}
				
				if(surveyPageDirectWindow){
					instance.close();
				}
				
				var pageDirectWindowWidth = '500px';
				var pageDirectWindowHeight = '500px';
				
				if(screen.width < 1200){
					pageDirectWindowWidth = '';
					pageDirectWindowHeight = '';
				}
				
				surveyPageDirectWindow = Liferay.Util.Window.getWindow(
					{
						id: Liferay.SurveyToolConstants.PORTLET_NAMESPACE + 'pageDirectWindow',
						dialog: {
				           	draggable: false,
				           	centered: true,
				           	resizable: false,
				           	width: pageDirectWindowWidth,
				           	height: pageDirectWindowHeight,
				           	modal: true,
				           	destroyOnHide: true,
							constrain2view: true,
				       	},
						title: Liferay.Language.get('page-guide')
					}
				).plug(
					A.Plugin.DialogIframe,
					{
						autoLoad: false,
			            iframeCssClass: 'dialog-iframe',
			            uri: renderURL
					}
				).show();
			},
			
			close: function(){
				
				surveyPageDirectWindow.destroy();
				
				surveyPageDirectWindow = null;
			},
			
			setPageDirect: function(pageId){
				
				var instance = this;
				
				instance.triggerInstance.setPageDirect(pageId);
				
				instance.close();
			}
		}
		
		var SurveyColorPicker = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
			
			instance.settingInstance = arguments[0].settingInstance;
			
			if(surveyColorPicker == null){
				surveyColorPicker = new ColorPicker(
					{
						trigger: instance.trigger,
						settingInstance: instance.settingInstance
					}
				);
				surveyColorPicker.show();
			}else{
				surveyColorPicker.close();
			}
		}
		Liferay.SurveyColorPicker = SurveyColorPicker;
		
		var ColorPicker = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
			
			instance.settingInstance = arguments[0].settingInstance;
		}
		ColorPicker.prototype = {
			
			ATTRS: {
				
				COLOR_THEMES:[
					['rgba(183, 28, 28, 1)', 'rgba(211, 47, 47, 1)', 'rgba(244, 67, 54, 1)', 'rgba(229, 115, 115, 1)'],
					['rgba(74, 20, 140, 1)', 'rgba(123, 31, 162, 1)', 'rgba(156, 39, 176, 1)', 'rgba(186, 104, 200, 1)'],
					['rgba(13, 71, 161, 1)', 'rgba(25, 118, 210, 1)', 'rgba(33, 150, 243, 2)', 'rgba(100, 181, 246, 1)'],
					['rgba(27, 94, 32, 1)', 'rgba(56, 142, 60, 1)', 'rgba(76, 175, 80, 1)', 'rgba(129, 199, 132, 1)'],
					['rgba(230, 81, 0, 1)', 'rgba(245, 124, 0, 1)', 'rgba(255, 152, 0, 1)', 'rgba(255, 183, 77, 1)'],
					['rgba(62, 39, 35, 1)', 'rgba(93, 64, 55, 1)', 'rgba(121, 85, 72, 1)', 'rgba(161, 136, 127, 1)']
				],
				
				UI: function(color){
					
					var instance = this;
					var ui = '<div id="' + Liferay.SurveyToolConstants.COLOR_PICKER_ID + '">';
					
					for(var v = 0; v < instance.COLOR_THEMES.length; v++){
						
						var theme = instance.COLOR_THEMES[v];
						
						ui += '<div class="survey-color-row">'
							
						for(var v1 = 0; v1 < theme.length; v1++){
							
							var activeUI = (theme[v1] == color ? '<div class="survey-color-active"></div>' : '');
							
							ui += ('<div class="survey-color" style="background-color: ' 
								+ theme[v1] + '" data-color="' 
								+ theme[v1] + '">'
								+ activeUI + ' </div>');
						}
						ui += '</div>'
					}
					return (ui + '</div>');
				}
			},
			
			show: function(){
				
				var instance = this;
				var toolId = '#' + Liferay.SurveyToolConstants.COLOR_PICKER_ID;
				
				$('html').append(instance.ATTRS.UI(instance.settingInstance.color));
				
				instance._initializeItem();
				
				$(toolId).css(
					{
						'top': instance.trigger.offset().top - ($(toolId).height() + 10),
						'left': instance.trigger.offset().left - ($(toolId).width() / 2 - instance.trigger.width() / 2)
					}
				);
				
				$(toolId).animate(
					{
						opacity: 1
					}, 150
				);
			},
			
			close: function(){
				
				var toolId = '#' + Liferay.SurveyToolConstants.COLOR_PICKER_ID;
				
				$(toolId).remove();
				
				surveyColorPicker = null;
			},
			
			_initializeItem: function(){
				
				var instance = this;
				
				$('.survey-color').on(
						
					'click', function(){
						
						var $this = $(this);
						
						if($this.find('.survey-color-active').length == 0){
							
							$('.survey-color-active').remove();
							
							$this.append('<div class="survey-color-active"></div>');
							
							instance.settingInstance.setColor($this.attr('data-color'));
						}
					}
				);
			}
		}
		
		var SurveyPictureAlbum = function(){
			
			var instance = this;
			
			instance.triggerInstance = arguments[0].triggerInstance;
			
			if(surveyPictureAlbum != null){
				surveyPictureAlbum = null;
			}
			surveyPictureAlbum = new PictureAlbum(
				{
					triggerInstance: instance.triggerInstance
				}
			);
			surveyPictureAlbum.show();
		}
		Liferay.SurveyPictureAlbum = SurveyPictureAlbum;
		
		var PictureAlbum = function(){
			
			var instance = this;
			
			instance.triggerInstance = arguments[0].triggerInstance;
			
			instance.removedFileId = '';
		}
		PictureAlbum.prototype = {
			
			show: function(){
				
				var instance = this;
				
				var renderURL = Liferay.PortletURL.createRenderURL();
				renderURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				renderURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				renderURL.setParameter('jspPage', '/html/admin/edit/album.jsp');
				renderURL.setParameter('selectedFileId', instance.triggerInstance.fileId);
				renderURL.setParameter('mainId', Liferay.SurveyToolConstants.SURVEY_MAIN_ID);
				
				if(surveyPictureAlbumWindow != null){
					instance.close();
				}
				
				surveyPictureAlbumWindow = Liferay.Util.Window.getWindow(
					{
						id: Liferay.SurveyToolConstants.PORTLET_NAMESPACE + 'pictureAlbumWindow',
						dialog: {
				           	draggable: false,
				           	centered: true,
				           	resizable: false,
				           	modal: true,
				           	destroyOnHide: true,
							constrain2view: true,
							after: {
	 				        	destroy: function(event) {
	 				        		Liferay.SurveyInstanceCollection.removeInstanceFileId(instance.removedFileId);
	 				        	}
	 				    	}
				       	},
						title: Liferay.Language.get('picture-album')
					}
				).plug(
					A.Plugin.DialogIframe,
					{
						autoLoad: false,
			            iframeCssClass: 'dialog-iframe',
			            uri: renderURL
					}
				).show();
			},
			
			close: function(){
				
				surveyPictureAlbumWindow.destroy();
				
				surveyPictureAlbumWindow = null;
			},
			
			setFileId: function(fileId, imgURL){
				
				var instance = this;
				
				instance.triggerInstance.setFileId(fileId, imgURL);
				
				instance.close();
			},
			
			setRemovedFileId: function(removedFileId){
				
				var instance = this;
				
				if(instance.removedFileId == ''){
					instance.removedFileId += (removedFileId);
				}else{
					instance.removedFileId += ("," + removedFileId);
				}
			}
		}
		
		var SurveyWriteTool = function(){
			
			var instance = this;
			
			instance.updateTrigger = arguments[0].updateTrigger;
			
			instance.prePageTrigger = arguments[0].prePageTrigger;

			instance.updateURL = arguments[0].updateURL;
			
			instance.prePageURL = arguments[0].prePageURL;
		}
		SurveyWriteTool.prototype = {
			
			initialize: function(){
				
				var instance = this;
				
				instance._updateEvent();
				
				instance._redirectPrePageEvent();
			},
		
			_updateEvent: function(){
				
				var instance = this;
				
				$(instance.updateTrigger).on(
					'click', function(){
						
						var showRequiredQuestion = [];
						var questionArray = Liferay.SurveyInstanceCollection.writeQuestionArray;
						
						// get need show required question instance
						for(var v = 0; v < questionArray.length; v++){
							
							if(!questionArray[v].isRequired)
								continue;
							
							if((questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_TEXT 
								|| questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DATE 
								|| questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR)
								&& questionArray[v].answer == '')
								showRequiredQuestion.push(questionArray[v]);
							
							if((questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE
								|| questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX
								|| questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DROPDOWN_LIST
								|| questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_SINGLE_CHOICE_LATTICE
								|| questionArray[v].type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_CHECKBOX_LATTICE)
								&& questionArray[v].optionIds == '')
								showRequiredQuestion.push(questionArray[v]);
						}
						
						// show required question
						if(showRequiredQuestion.length != 0){
							instance._showRequiredStatus(showRequiredQuestion);
							return;
						}
						
						// create form and input then submit
						instance._submit();
					}	
				);
			},
			
			_redirectPrePageEvent: function(){

				var instance = this;
				
				$(instance.prePageTrigger).on(
					'click', function(){
						location.href = instance.prePageURL;
					}	
				);
			},
			
			_showRequiredStatus: function(questionArray){
				
				var firstQuestion = $('#survey_write_question_' + questionArray[0].no);
				
				// check is question or sub question
				if(!firstQuestion.hasClass('survey-write-question'))
					firstQuestion = firstQuestion.closest('.survey-write-question');
				
				for(var v = 0; v < questionArray.length; v++){
					
					var question = $('#survey_write_question_' + questionArray[v].no);
					
					if(!question.hasClass('survey-write-question'))
						question = question.closest('.survey-write-question');
					
					var title = question.find('.survey-write-question-title');
					
					if(!title.hasClass('survey-write-question-required')){
						title.addClass('survey-write-question-required');
						title.append(Liferay.SurveyInstanceConstants.QUESTION_IS_REQUIRED_UI());
					}
				}
				
				$('html,body').animate(
					{
						scrollTop: firstQuestion.offset().top - 20
					}, 500
				);
			},
			
			_submit: function(){
				
				var instance = this;
				
				instance._initializeForm();
				
				$('#' + Liferay.SurveyToolConstants.FORM_ID).submit();
			},
			
			_initializeForm: function(){
				
				$('#survey_write_layout').append('<form id="' + Liferay.SurveyToolConstants.FORM_ID + '"><form>');
				
				var instance = this;
				var form = $('#' + Liferay.SurveyToolConstants.FORM_ID);
				var questionIds = "";
				
				form.attr('action', instance.updateURL);
				form.attr('method', "post");
				
				$.each(
					Liferay.SurveyInstanceCollection.writeQuestionArray, function(index, question){
						
						questionIds += (question.Id + ",");
						
						if(question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_TEXT
							|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_DATE
							|| question.type == Liferay.SurveyInstanceConstants.QUESTION_TYPE_STAR){
							
							instance._createInput(form, question.Id + "_answer", question.answer);
							
						}else{
							
							instance._createInput(form, question.Id + "_optionIds", question.optionIds);
							instance._createInput(form, question.Id + "_answer", question.answer);
						}
					}
				);
				instance._createInput(form, "questionIds", questionIds);
			},
			
			_createInput: function(form, name, value){
				
				$('<input>').attr(
					{
						type: 'hidden', 
						name: Liferay.SurveyToolConstants.PORTLET_NAMESPACE + name, 
						value: value
					}
				).appendTo(form);
			}
		}
		Liferay.SurveyWriteTool = SurveyWriteTool;
		
		var SurveyResultTool = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
			
			instance.writerId = arguments[0].writerId;
			
			instance.hasResponse = arguments[0].hasResponse;
			
			var toolBtn = $(instance.trigger).find('.survey-result-tool-btn');
			
			toolBtn.on(
				'click', function(){
					
					var $this = $(this);
					var top = $this.offset().top;
					var left = $this.offset().left;
					var width = $this.width();
					var triggerId = $this.closest('.survey-result-list-item').attr('id');
					
					if(surveyResultTool != null){
						var orgTriggerId = surveyResultTool.triggerId;
						surveyResultTool.close();
						if(orgTriggerId == triggerId){
							return false;
						}
					}
					surveyResultTool = new ResultTool(
						{
							triggerId: triggerId,
							writerId: instance.writerId,
							hasResponse: instance.hasResponse,
							top: top,
							left: left,
							width: width
						}
					);
					surveyResultTool.show();
				}
			);
		}
		Liferay.SurveyResultTool = SurveyResultTool;
		
		var ResultTool = function(){
			
			var instance = this;
			
			instance.triggerId = arguments[0].triggerId;
			
			instance.writerId = arguments[0].writerId;
			
			instance.hasResponse = arguments[0].hasResponse;
			
			instance.top = arguments[0].top;
			
			instance.left = arguments[0].left;
			
			instance.width = arguments[0].width;
		}
		
		ResultTool.prototype = {
			
			ATTRS: {
				
				dialogWindow: null,
				
				SURVEY_RESULT_VIEW_RESULT: 'survey_result_view_result',
				
				SURVEY_RESULT_VIEW_FEEDBACK: 'survey_result_view_feedback',
				
				SURVEY_RESULT_VIEW_RESULT_FONT: Liferay.Language.get('view-individual-result'),
				
				SURVEY_RESULT_VIEW_FEEDBACK_FONT: Liferay.Language.get('view-individual-feedback'),
				
				UI: function(hasResponse){
					
					var uiText = '<div id="' + Liferay.SurveyToolConstants.RESULT_TOOL_ID + '" class="' + Liferay.SurveyToolConstants.SURVEY_TOOL_CLASS_NAME + '">'
									+ '<div class="' + this.SURVEY_RESULT_VIEW_RESULT + '"><i class="icon-eye-open"></i>' + this.SURVEY_RESULT_VIEW_RESULT_FONT + '</div>'
					
					if(hasResponse){
						uiText += ('<div class="' + this.SURVEY_RESULT_VIEW_FEEDBACK + '"><i class="icon-comments-alt"></i>' + this.SURVEY_RESULT_VIEW_FEEDBACK_FONT + '</div>');
					}				
					
					uiText += '</div>';
					
					return uiText
				}
			},
			
			show: function(){
				
				var instance = this;
				var toolId = "#" + Liferay.SurveyToolConstants.RESULT_TOOL_ID;
				var sreenWidth = $(window).width();
				var toolLeft = 0;
				
				$('html').append(instance.ATTRS.UI(instance.hasResponse));
				
				var toolWidth = $(toolId).width();
				if((sreenWidth - (instance.left + instance.width + 14)) < toolWidth){
					toolLeft = instance.left - toolWidth - 5;
				}else{
					toolLeft = instance.left + instance.width + 14;
				}
				
				$(toolId).css(
					{
						'top': instance.top,
						'left': toolLeft,
					}		
				);
				instance._initializeItem(toolId);
				$(toolId).animate(
					{
						opacity: 1
					}, 150
				);
			},
			
			close: function(){
				
				var toolId = "#" + Liferay.SurveyToolConstants.RESULT_TOOL_ID;
				
				surveyResultTool = null;
				
				$(toolId).remove()
			},
			
			_initializeItem: function(toolId){
				
				var instance = this;
				
				var children = $(toolId).children();
				
				children.each(
						
					function(index, child){
						
						var childClass = $(child).attr('class');
						
						if (childClass == instance.ATTRS.SURVEY_RESULT_VIEW_RESULT){
							
							$(child).on(
								'click', function(){
									instance._openResultWindow();
								}
							);
							
						} else if (childClass == instance.ATTRS.SURVEY_RESULT_VIEW_FEEDBACK){
							
							$(child).on(
								'click', function(){
									instance._openResponseWindow();
								}
							);
						}
					}
				);
			},
			
			_openResultWindow: function(){
				
				var instance = this;
				
				var viewResultURL = Liferay.PortletURL.createRenderURL();
				viewResultURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				viewResultURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				viewResultURL.setParameter("jspPage", "/html/write/view_answer.jsp");
				viewResultURL.setParameter("writerId", instance.writerId);
				
				window.open(viewResultURL.toString());
			},
			
			_openResponseWindow: function(){
				
				var instance = this;
				var dialogWindow = instance.ATTRS.dialogWindow;
				
				var viewResponseURL = Liferay.PortletURL.createRenderURL();
				viewResponseURL.setWindowState(Liferay.SurveyToolConstants.DIALOG_WINDOW_STATE);
				viewResponseURL.setPortletId(Liferay.SurveyToolConstants.getPortletId());
				viewResponseURL.setParameter("jspPage", "/html/admin/result/view_response.jsp");
				viewResponseURL.setParameter("writerId", instance.writerId);
				
				if(dialogWindow){
					dialogWindow.destroy();
					dialogWindow = null;
				}
				dialogWindow = Liferay.Util.Window.getWindow(
					{
						id: Liferay.SurveyToolConstants.PORTLET_NAMESPACE + 'survey_response_window',
						dialog: {
				           	draggable: false,
				           	centered: true,
				           	resizable: false,
				           	width: 500,
				           	height: 500,
				           	modal: true,
				           	destroyOnHide: true,
							constrain2view: true
				       	},
				       	title: Liferay.Language.get('survey-feedback')
					}
				).plug(
					A.Plugin.DialogIframe,
					{
						autoLoad: false,
			            iframeCssClass: 'dialog-iframe',
			            uri: viewResponseURL
					}
				).show();
			}
		}
		
	}, '',
	{
		requires: ['aui-base', 'liferay-util-window', 'liferay-portlet-url', 'liferay-session', 'survey-instance', 'survey-tips']
	}
);