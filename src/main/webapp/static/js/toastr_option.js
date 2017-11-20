/**
 * bootstrap消息警告框
 */
toastr.options = {  
	    closeButton: false,  
	    debug: false,  
	    progressBar: true,  
	    positionClass: "toast-top-center",  
	    onclick: null,  
	    showDuration: "300",  
	    hideDuration: "1000",  
	    timeOut: "2500",  
	    extendedTimeOut: "1000",  
	    showEasing: "swing",  
	    hideEasing: "linear",  
	    showMethod: "fadeIn",  
	    hideMethod: "fadeOut"  
	};
/**
 * 校验特殊字符,有特殊字符返回true
 */
function checks(t){
   szMsg="[#@$￥——*（）！【】……{}+、。，·\\_%&'/\",;:=!^]";
   var flag = false;
   for(i=1;i<szMsg.length+1;i++){
	   if(t.indexOf(szMsg.substring(i-1,i))>-1){
		   flag = true;
		   break;
	   }
   }
   return flag;
}
/**
 * Decimal类型校验特殊字符,有特殊字符返回true
 */
function checksDecimal(t){
	szMsg="[#@$￥——*（）！【】……{}()-+、。，·\\_%&'/\",;:=!^]";
	var flag = false;
	for(i=1;i<szMsg.length+1;i++){
		if(t.indexOf(szMsg.substring(i-1,i))>-1){
			flag = true;
			break;
		}
	}
	return flag;
}
