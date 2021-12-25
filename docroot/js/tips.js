AUI.add(
		
	'survey-tips', function(A){
		
		var surveyTips, surveyAlert, surveyChartTips = null;
		
		var SurveyTipsConstants = {
			
			SURVEY_UPDATE_LAYOUT_ID: 'survey_update_layout',	
			
			SURVEY_TIPS_CLASS_NAME: 'survey-tips',
			
			SURVEY_CHART_TIPS_CLASS_NAME: 'survey-chart-tips',
			
			TIPS_ID: 'survey_tips',
			
			CHART_TIPS_ID: 'survey_chart_tips',
			
			ALERT_SUCCESS_CLASSNAME: 'action-success',
			
			ALERT_INFO_CLASSNAME: 'action-info',
			
			ALERT_DANGER_CLASSNAME: 'action-danger'
		}
		Liferay.SurveyTipsConstants = SurveyTipsConstants;
		
		var SurveyTipsUtils = {
			
			closeSurveyTips: function(){
				
				if(surveyTips != null)
					surveyTips.close();
			}
		}
		Liferay.SurveyTipsUtils = SurveyTipsUtils;
		
		var SurveyTips = function(){
			
			var instance = this;
			
			instance.trigger = arguments[0].trigger;
			
			$(document).on(
				'mouseover', instance.trigger,
				function(){
					
					var $this = $(this);
					var height = $this.height();
					var width = $this.width();
					var top = $this.offset().top + $this.height() + 10;
					var left = $this.offset().left + (width / 2);
					var text = $this.attr('data-tips');
					
					if (surveyTips != null) {
						surveyTips.close();
					}
					surveyTips = new Tips(
						{
							top: top,
							left: left,
							text: text
						}
					);
					surveyTips.show();
				}
			);
			
			$(document).on(
				'mouseout', instance.trigger,
				function(){
					surveyTips.close();
				}
			);
		};
		Liferay.SurveyTips = SurveyTips;
		
		var Tips = function(){
			
			this.top = arguments[0].top;
			
			this.left = arguments[0].left;
			
			this.text = arguments[0].text;
		}
		
		Tips.prototype = {
				
			ATTRS: {
				
				UI: function(){
					return '<div id="' + Liferay.SurveyTipsConstants.TIPS_ID + '" class="' + Liferay.SurveyTipsConstants.SURVEY_TIPS_CLASS_NAME + '"></div>'
				}
			},
			
			show: function(){
				var instance = this;
				var tipsId = "#" + Liferay.SurveyTipsConstants.TIPS_ID;
				$('html').append(instance.ATTRS.UI());
				$(tipsId).text(instance.text);
				$(tipsId).css(
					{
						'top': instance.top,
						'left': instance.left - ($(tipsId).outerWidth() / 2)
					}		
				);
				$(tipsId).animate(
					{
						height: 'toggle'
					}, 100
				);
			},
			
			close: function(){
				
				var instance = this;
				var tipsId = "#" + Liferay.SurveyTipsConstants.TIPS_ID;
				
				$(tipsId).remove();
				
				surveyTips = null;
			}
			
		}
		
		var SurveyAlertMessage = function(){
			
			var instance = this;
			
			instance.message = arguments[0].message;
			
			instance.status = arguments[0].status;
			
			instance.autoClose = arguments[0].autoClose;
			
			if(surveyAlert != null){
				surveyAlert.close();
			}
			surveyAlert = new AlertMessage(
				{
					message: instance.message,
					status: instance.status,
					autoClose: instance.autoClose
				}
			);
		}
		
		SurveyAlertMessage.prototype = {
			
			show: function(){
				if(surveyAlert != null){
					surveyAlert.show();
				}
			},
			
			change: function(message, status, delayClose){
				if(surveyAlert != null){
					surveyAlert.change(message, status, delayClose);
				}
			},
			
			close: function(){
				if(surveyAlert != null){
					surveyAlert.close();
				}
			}
		}
		Liferay.SurveyAlertMessage = SurveyAlertMessage;
		
		var AlertMessage = function(){
			
			var instance = this;
			
			instance.timeout = null;
			
			instance.message = arguments[0].message;
			
			instance.status = arguments[0].status;
			
			instance.autoClose = arguments[0].autoClose;
		}
		
		AlertMessage.prototype = {
			
			ATTRS: {
				
				UI: function(message, className){
					return '<div class="survey-action-result-container"> <div class="survey-action-result ' 
						+ className + '">' + message + '</div> </div>';
				}
			},
			
			show: function(){
				
				var instance = this;
				var className = Liferay.SurveyTipsConstants.ALERT_INFO_CLASSNAME;
				
				if(instance.status == 'success'){
					className = Liferay.SurveyTipsConstants.ALERT_SUCCESS_CLASSNAME;
				}else if(instance.status == 'danger'){
					className = Liferay.SurveyTipsConstants.ALERT_DANGER_CLASSNAME;
				}
				
				$('html').append(instance.ATTRS.UI(instance.message, className));
				
				$('.survey-action-result-container').animate(
					{
						height: 'toggle'
					}, 
					{
						duration: 150,
						complete: function(){
							if(instance.autoClose != 0){
								instance.timeout = setTimeout(
									function() {
										instance.close();
									}
								, instance.autoClose);
							}
						}	
					}
				);
			},
			
			change: function(message, status, delayClose){
				
				var instance = this;
				var className = Liferay.SurveyTipsConstants.ALERT_INFO_CLASSNAME;
				var container = $('.survey-action-result-container');
				var messageRow = $('.survey-action-result');
				
				if(status == 'success'){
					className = Liferay.SurveyTipsConstants.ALERT_SUCCESS_CLASSNAME;
				}else if(status == 'danger'){
					className = Liferay.SurveyTipsConstants.ALERT_DANGER_CLASSNAME;
				}
				
				if(instance.timeout != null)
					clearTimeout(instance.timeout);
				
				messageRow.html(message);
				messageRow.attr("class", "survey-action-result " + className);
				
				instance.timeout = setTimeout(
					function(){
						instance.close();
					}, 	delayClose
				);
			},
			
			close: function(){
				
				var instance = this;
				
				if(instance.timeout != null)
					clearTimeout(instance.timeout);
				
				$('.survey-action-result-container').remove();
				
				surveyAlert = null;
			}
		}
		
		var SurveyChartTips = function(){
			
			var instance = this;
			
			instance.event = arguments[0].event;
			
			instance.color = arguments[0].color;
			
			instance.text = arguments[0].text;
		}
		
		SurveyChartTips.prototype = {
			
			show: function(){
				
				var instance = this;
				
				surveyChartTips = new ChartTips(
					{
						color: instance.color,
						text: instance.text,
						top: instance.event.pageY,
						left: instance.event.pageX
					}
				);
				surveyChartTips.show();
			},
			
			resetData: function(event, color, text){
				
				surveyChartTips.resetData(color, text, event.pageY, event.pageX);
			},
			
			close: function(){
				
				surveyChartTips.close();
			}
		}
		Liferay.SurveyChartTips = SurveyChartTips;
		
		var ChartTips = function(){
			
			var instance = this;
			
			instance.color = arguments[0].color;
			
			instance.text = arguments[0].text;
			
			instance.top = arguments[0].top;
			
			instance.left = arguments[0].left;
		}
		
		ChartTips.prototype = {
			
			ATTRS: {
				
				UI: function(){
					return '<div id="' + Liferay.SurveyTipsConstants.CHART_TIPS_ID + '" class="' + Liferay.SurveyTipsConstants.SURVEY_CHART_TIPS_CLASS_NAME + '"></div>'
				} 
			},
				
			show: function(){
				
				var instance = this;
				var tipsId = "#" + Liferay.SurveyTipsConstants.CHART_TIPS_ID;
				
				$('html').append(instance.ATTRS.UI());
				$(tipsId).html(instance.text);
				$(tipsId).css(
					{
						'background-color': instance.color[0],
						'border-color': instance.color[1],
						'top': instance.top - 60,
						'left': instance.left + 15,
						'display': 'block'
					}		
				);
			},
			
			resetData: function(color, text, top, left){
				
				var tipsId = "#" + Liferay.SurveyTipsConstants.CHART_TIPS_ID;
				
				$(tipsId).html(text);
				$(tipsId).css(
					{
						'background-color': color[0],
						'border-color': color[1],
						'top': top - 60,
						'left': left + 15
					}		
				);
			},
			
			close: function(){
				
				$("#" + Liferay.SurveyTipsConstants.CHART_TIPS_ID).remove();
				
				surveyTips = null;
			}
		}
		
	}, '',
	{
		requires: ['aui-base']
	}
)