$(document).ready(
		function() {
			var id = $('#userId').val();
			console.log(id);
			$('#shopCart').dataTable(
					{
						"processing" : true,
						"serverSide" : true,
						"ajax" : "/WebStore/rest/cart/" + id,
						"columns" : [ {
							"data" : "prodCategory"
						}, {
							"data" : "prodId"
						}, {
							"data" : "prodDesc"
						}, {
							"data" : "price"
						}, {
							"data" : "qtyBought"
						}, 
						{
							"data" : "remove"
						}],
						"columnDefs" : [ 
						{
							"render" : function(data, type, row) {
								return '<input type="button" class="btn btn-primary" id="updItem'
										+ '" value="Update"/>';
							},
							"targets" : 5
						}
						]

					});
		});

$('#shopCart tbody').on('click', 'input', function(event) {
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#shopCart").dataTable();
	var aData = oTable.fnGetData(nTr);
	//console.log(aData.prodId);

	$('#item').modal({
		show : true
	});
	
	$('#sprodId').val(aData.prodId);
	$('#sprodDesc').val(aData.prodDesc);
	$('#sprice').val(aData.price);
	$('#sqty').val(aData.qtyBought);
	
	//aData.qtyBought = $('#sqty');
});

$('#saveProd').click(function() {
	console.log("saveProd button clicked");
	var id = $('#userId').val();
	var savebookUrl = "/WebStore/rest/cart/updCart";
	$.ajax({
		type : "POST",
		url : savebookUrl,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			"userId" : id,
			"prodCategory" : $('#sprodCategory').val(),
			"prodId" : $('#sprodId').val(),
			"price" : $('#sprice').val(),
			"prodDesc" : $('#sprodDesc').val(),
			"qtyBought" : $('#sqty').val()
		}),
		// redirect : true,
		success : saveBook,
		error : ajaxError
	});
});

function saveBook(){
	//console.log("success");
	location.reload();
}

$("#checkOut").click(function() {
	$(location).attr('href',"/WebStore/view/Payment.jsp");
});