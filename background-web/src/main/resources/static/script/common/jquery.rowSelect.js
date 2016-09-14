/**
 * Created by GuoXiang on 2016/6/29.
 */
(function (factory) {
    if (typeof module === 'object' && typeof module.exports === 'object') {
        factory(require('jquery'));
    } else if (typeof define === 'function' && define.amd) {
        // AMD. Register as an anonymous module.
        define([], factory(window.jQuery));
    } else {
        factory(window.jQuery);
    }
}(function ($) {
    if (!$) {
        return console.warn('rowSelect Plugin neeed Jquery');
    };
    $.RowSelect = function (context, options) {
        var self = this;
        self._ = 'rowSelect';
        self.defaults = {
            class: 'click-active',            // 选中时的Class样式
            single: true,                     // 选择行是单选还是多选， true是单选， false多选
            operation: 'click',
            selecters: {
            	row: 'tbody tr',              // 行选择器的字符串
            	col: 'td'	
            }
        };
        self.$context = context;             // 给table添加插件的jquery对象
        self.options = {};					
        self.prefix = self._ + '-';          
        self.selectRows = [];
        self.rowlist= [];                   // 找到table表下的所有行       
  //      self.selectRowDataList = [];		
        self.init = function (options) {
       
            self.options = $.extend({}, self.defaults,options);
            self.rowlist = self.$context.find(self.options.selecters.row);
            self.bindEvent(self.options.operation, self.options.class);
          
            
        };
        self.bindEvent = function (event, className) {       //  为所有行添加click事件，为选中行添加data属性和class样式
            self.rowlist.on(event, function () {
                var $this = $(this);
                if ($this.attr("data-selectrow") == 'unselected') {
                    if (self.options.single) {
                    	self.rowlist.removeClass(className).attr("data-selectrow", "unselected");
                    }
                    $this.attr("data-selectrow", "selected").addClass(className);
                } else {
                    $this.attr("data-selectrow", "unselected").removeClass(className);
                };
                self.getSelectRows();
                self.getSelectCeilData();
            })
        };
        self.getSelectIDs = function () {               // 获取当前所有选中的ID
        	self.rowlist = self.$context.find(self.options.selecters.row);
        	self.selectIds = [];
        	self.rowlist.each(function () {
                var $this = $(this);
                
                if ($this.attr("data-selectrow") == 'selected') {
                
                    self.selectIds.push($this.find(self.options.selecters.col).eq(0).html());
                }
            })
           return self.selectIds;
        };
        self.getSelectRows = function () {               // 获取当前所有选中的行
        	self.rowlist = self.$context.find(self.options.selecters.row);
        	self.selectRows = [];
        	self.rowlist.each(function () {
                var $this = $(this);
                
                if ($this.attr("data-selectrow") == 'selected') {
                
                    self.selectRows.push($this.data("rownum"));
                }
            })
           return self.selectRows;
        };
        self.getSelectCeilData = function (dataName) {       // 获取当前所有选中行的列的数据
            var selDataRow = {};
            	allSelRows = [];
            	var selRowObj = {};
            var rowNum = self.selectRows;
//            if(self.selectRows.length>1){
//            	alert("Only one row could be selected");
//            	return;
//            }
            if (!rowNum) {
                alert("No row is selected");
                return;
            }
            self.rowlist.eq(self.selectRows).each(function(){
            	var $this = $(this);
            	$this.children("td").each(function () {
            		var name = $(this).data("name");
            		var value = $(this).html();
            		selRowObj[name] = value;
            		
                });
            	allSelRows.push(selRowObj);
            })
            	
            
        	if(!dataName){                                 // 得到选中行所有列的数据
        		for(var i=0;i<allSelRows.length;i++){
        			var dataAttr = '';
        			for(var j in allSelRows[i]){
        				dataAttr = dataAttr + allSelRows[i][j]+'&';
        			}
        
            		return dataAttr;
        		}
        		
        		
        	}
            else{                                      // 得到选中行指定列的数据
            	for(var i=0;i<allSelRows.length;i++){
           
                	return allSelRows[i][dataName];
            	}
            	
            }
        	  
        }
        return self.init(options);
    }
    $.fn.rowSelect = function (opts) {
        var $this = $(this);
//        if(typeof opts === 'string' && $this.data('rowSelect')) {
//			opts = opts.split(':');
//
//			var call = $this.data('unslider')[opts[0]];
//
//			//  Do we have arguments to pass to the string-function?
//			if($.isFunction(call)) {
//				return call.apply($this, opts[1] ? opts[1].split(',') : null);
//			}
//		}
        return $this.data('rowSelect', new $.RowSelect($this, opts));
    };
}))