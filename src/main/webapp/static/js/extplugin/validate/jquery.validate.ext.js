define(function(require, exports, module){
    var jQuery = require('jquery');
    (function($){
        //校验手机号码
        $.validator.addMethod('mobile',function(value,element,params){
            var myreg = /^1[3|5|7|8]\d{9}$/;
            if(!myreg.test(value))
                return false;
            return true;
        },'请输入有效的手机号码');

        //只能输入字母或者数字
        $.validator.addMethod('charAndNum', function(value, element, params){
            var myreg = /^[A-Za-z0-9]+$/;
            if(!myreg.test(value))
                return false;
            return true;
        },'请输入字母或者数字');

        //校验金额，小数点后最多只能两位
        $.validator.addMethod('money', function(value, element, params){
            var myreg = /^(0|[1-9][0-9]*)([.]\d{1,2})?$/;
            if(!myreg.test(value))
                return false;
            return true;
        },'请输入数字，且小数点后最多保留两位');

        //字符验证，只能包含中文、英文字母、数字和下划线
        $.validator.addMethod('string',function(value, element, params){
            return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
        },'只能输入中文、字母、数字和下划线');

        //只能输入字母、数字和下划线
        $.validator.addMethod('char',function(value, element, params){
            return this.optional(element) || /^[A-Za-z0-9_]+$/.test(value);
        },'只能输入字母、数字和下划线');

        //只能输入字母
        $.validator.addMethod('alphabet',function(value, element, params){
            return this.optional(element) || /^[A-Za-z]+$/.test(value);
        },'只能输入字母');

        //只能输入固定长度的字符
        $.validator.addMethod('length',function(value, element, params){
            var length = value.length;
            return this.optional(element) || (length == params);
        },$.validator.format("只能输入{0}个字符"));
    })(jQuery);
    return jQuery;
})