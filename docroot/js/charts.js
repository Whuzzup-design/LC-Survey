AUI.add(
		
	'survey-charts', function(A){
		
		var SurveyChart = function(){
			
			var instance = this;
			
			instance.container = arguments[0].container;
			
			instance.data = arguments[0].data;
			
			instance.total = 0;
			
			instance.chartTips = null;
			
			for(var v in instance.data){
				
				instance.total += instance.data[v].amount;
			}
		}
		
		SurveyChart.prototype = {
			
			ATTRS: {
				
				COLOR: ["#f44336", "#9C27B0", "#3F51B5", "#03A9F4", "#009688", "#8BC34A", "#FFC107", "#FF5722", "#795548", "#607D8B"
					, "#E91E63", "#673AB7", "#2196F3", "#00BCD4", "#4CAF50", "#CDDC39", "#FFC107", "#FF5722", "#607D8B"],
				
				BORDER_COLOR: ["#b71c1c", "#4A148C", "#1A237E", "#01579B", "#1B5E20", "#33691E", "#FF6F00", "#BF360C", "#3E2723", "#263238"
					, "#880E4F", "#311B92", "#0D47A1", "#006064", "#1B5E20", "#827717", "#FF6F00", "#BF360C", "#263238"]
			},
				
			show: function(){
				
				var instance = this;
				
				if(instance.total != 0) {
					instance._initializePieChart();
				} else {
					instance._showNoDataMessage();
				}
			},
			
			_initializePieChart: function(){
				
				var instance = this;
				
				var canvas = document.getElementById(instance.container);
				
				var context = canvas.getContext("2d");
				
				var lastPosition = 0, listPositionY = 25;
				
				for(var v in instance.data){
					
					// draw pie
					context.fillStyle = instance.ATTRS.COLOR[v % 10];
					
					context.beginPath();
					
					context.moveTo(125, 125);
					
					context.arc(125, 125, 100, lastPosition, lastPosition + (Math.PI * 2 *(instance.data[v].amount / instance.total)), false);
					
					context.fill();
					
					// draw data list
					context.rect(275, listPositionY, 12, 12);
					
					context.fill();
					
					listPositionY = instance._drawListText(300, listPositionY
							, instance.data[v].text + " - " + instance.data[v].amount + " (" + instance._calculatePercent(instance.data[v].amount, instance.total) + "%)", context, canvas);
					
					// set pie slice start angle
					instance.data[v].startAngle = lastPosition;
					
					lastPosition += Math.PI*2*(instance.data[v].amount/instance.total);
					
					// set pie slice end angle
					instance.data[v].endAngle = lastPosition;
				}
				
				$('#' + instance.container).on(
					"mousemove", function(e){
						instance._showPieSliceMessage(e);
					}
				);
			},
			
			_showNoDataMessage: function(){
				
				var instance = this;
				
				$('#' + instance.container).closest('.survey-result-chart-container')
					.html('<div class="portlet-msg-info">' + Liferay.Language.get("there-are-no-results") + '</div>');
			},
			
			_calculatePercent: function(amount, total){
				
				var percent = (amount / total * 100).toString();
				
				if(percent.lastIndexOf(".") != -1)
					percent = percent.substring(0, percent.lastIndexOf(".") + 3);
				
				return percent;
			},
			
			_drawListText: function(x, y, text, context, canvas){
				
				// 每行30個字,計算總行數
				var rowCount = Math.ceil(text.length / 30);
				var listY = y;
				var instance = this;
				
				context.font = "13px sans-serif";
				
				for(var v = 0; v < rowCount; v++){
					
					context.fillText(text.substring(v * 30, (v + 1) * 30), x, listY + 11);
					
					// 同一個選項每行高度14
					listY += 14;
				}
				
				// 預先把下個選項的間距加上
				return listY + 30;
			},
			
			_showPieSliceMessage: function(event){
				
				var instance = this;
				
				// 目前滑鼠指標相對於canvas的x, y軸
			    var mouseX = event.pageX - $('#' + instance.container).offset().left;
			    var mouseY = event.pageY - $('#' + instance.container).offset().top;

			    // 計算目前滑鼠指標位置到圓餅圖中心點距離，小於半徑表示在圓餅圖內
			    var xFromCentre = mouseX - 125;
			    var yFromCentre = mouseY - 125;
			    
			    var distanceFromCentre = Math.sqrt(Math.pow(Math.abs(xFromCentre), 2) + Math.pow(Math.abs(yFromCentre), 2));
			    
			    if(distanceFromCentre <= 100) {
			    	
			    	var tipsText = "";
			    	var angle = Math.atan2(yFromCentre, xFromCentre);
			      
			    	if(angle < 0)
			    		angle += 2 * Math.PI;
			      
			    	for(var v in instance.data){
			    		
			    		if(angle > instance.data[v].startAngle && angle <= instance.data[v].endAngle){
			    			
			    			var optionText = instance.data[v].text.length > 10 ? instance.data[v].text.substring(0, 10) + "..." : instance.data[v].text;
			    			
			    			tipsText = optionText + "<br>" + instance.data[v].amount + " (" + instance._calculatePercent(instance.data[v].amount, instance.total) + "%)";
			    			
			    			if(instance.chartTips != null){
			    				instance.chartTips.resetData(event, [instance.ATTRS.COLOR[v % 10], instance.ATTRS.BORDER_COLOR[v % 10]], tipsText);
			    			}else{
			    				instance.chartTips = new Liferay.SurveyChartTips(
			    					{
			    						event: event,
			    						color: [instance.ATTRS.COLOR[v % 10], instance.ATTRS.BORDER_COLOR[v % 10]],
			    						text: tipsText
			    					}
			    				);
			    				instance.chartTips.show();
			    			}
			    			return;
			    		}
			    	}
			    }else{
			    	if(instance.chartTips != null){
			    		instance.chartTips.close();
			    		instance.chartTips = null;
			    	}
			    }
			}
		}
		Liferay.SurveyChart = SurveyChart;
		
	}, '',
	{
		requires: ['survey-tips']
	}
);