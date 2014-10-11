$('#purchase').click(function(){
	var id=$("#userId").val();
	var purchaseUrl = '/WebStore/rest/users/purchase/' + id;
	$.ajax({
		type : "POST",
		url : purchaseUrl,
		contentType : "application/json",
		//dataType : "json",
		//redirect : true,
		//success : sucess,
	});
});

/*function confirmation(){
	$(location).attr('href','/WebStore/rest/Confirm.jsp');
}*/