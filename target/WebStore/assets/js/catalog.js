$(document).ready(function() {
	
	$('#createCatalog').click(function() {
		console.log("Create Catalog ajax call");
		$.ajax({
			type : "POST",
			url : "/WebStore/rest/catalog/addCatalog",
			data : catalogformToJson(),
			contentType: "application/json",
			success: catalogCreated(),
			error: ajaxError()
		});
	});
	
	
});

function listCatalogs(){
	console.log("List Catalog Successfull");
}
function catalogCreated(){
	console.log("Catalog created successfully");
}
function catalogformToJson() {
	return JSON.stringify({
		'catalogName' : $('#catalogName').val(),
		'catalogDesc' : $('#catalogDesc').val()
	});
}

