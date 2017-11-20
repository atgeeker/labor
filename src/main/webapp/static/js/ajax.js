//ajax异步加载数据，把加载到的数据放到主键component中
//var loadPage = function(url){
//	$.ajax({
//		url:url,
//		success:function(response){
//			//$('#main-content').html(response);
//			//$('#main-content').html(response);
//		}
//	});
//}
var loadPage = function(href){
	//$.ajaxSetup({cache:false});
    $('#mainbody').load(href);
}

