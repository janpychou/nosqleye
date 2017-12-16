$(function($) {
	var username=$.cookie('DBEYE-FOR-NOSQL-ADMIN');
	if(username=="null"||username==null){
		$(window).attr('location','login.html');
	}
	else{
		$("#login_admin").html(username);
	}
			
	$("#logout").click(function(){
		$.cookie("DBEYE-FOR-NOSQL-ADMIN", null, { path: '/' });
		$(window).attr('location','login.html');
	});
});
