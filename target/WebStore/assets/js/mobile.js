$(document).ready(
		function() {
			var id = $('#hiddencategory').val();
			// alert(id);
			$('#mobilesCatalog').dataTable(
					{
						"processing" : true,
						"serverSide" : true,
						"ajax" : "/WebStore/rest/product/" + id,
						"columns" : [ {
							"data" : "productCategory"
						}, {
							"data" : "prodId"
						}, {
							"data" : "prodDescription"
						}, {
							"data" : "price"
						}, {
							"data" : "qtyAvailable"
						}, {
							"data" : "addToCart"
						} ],
						"columnDefs" : [ {
							"render" : function(data, type, row) {
								return '<input type="button" class="btn btn-primary" id="addToCart'
										+ '" value="Add To Cart"/>';
							},
							"targets" : 5
						} ]

					});
			if($('#userId').val() != '3')
				$('#addProduct').hide();
		});

$('#addProduct').click(function() {
	$('#item').modal({
		show : true
	});
});


$('#cart').click(function(){
	$(location).attr('href', "/WebStore/view/ShopCart.jsp");
});
/*
 * $('#addToShopCart').click(function(){ $('') });
 */

$('#mobilesCatalog tbody').on('click', 'input', function(event) {
	var nTr = $(this).parents('tr')[0];
	var oTable = $("#mobilesCatalog").dataTable();
	var aData = oTable.fnGetData(nTr);
	//console.log(aData.prodId);

	$('#addToShopCart').modal({
		show : true
	});
	
	$('#sprodId').val(aData.prodId);
	$('#sprodDesc').val(aData.prodDescription);
	$('#sPrice').val(aData.price);
	$('#sqty').val(aData.qtyAvailable);
});

/*
 * $('#booksCatalog').click(function(){ var nTr = $(this).parents('tr')[0]; var
 * oTable = $("#booksCatalog").dataTable(); var aData = oTable.fnGetData(nTr);
 * console.log(aData); //var id = aData.id; });
 */

$('#saveProd').click(function() {
	var savebookUrl = "/WebStore/rest/product/addProd";
	$.ajax({
		type : "POST",
		url : savebookUrl,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			"productCategory" : $('#prodCategory').val(),
			"prodId" : $('#productId').val(),
			"price" : $('#price').val(),
			"prodDescription" : $('#prodDesc').val(),
			"qtyAvailable" : $('#qty').val()
		}),
		// redirect : true,
		success : saveLaptop,
		error : ajaxError
	});
});

$('#saveProdCart').click(function() {
	console.log("Inside Book jsp " + $('#userId').val());
	var savebookUrl = "/WebStore/rest/cart";
	$.ajax({
		type : "POST",
		url : savebookUrl,
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
			"userId" : $('#userId').val(),
			"prodId" : $('#sprodId').val(),
			"price" : $('#sPrice').val(),
			"prodCategory" : $("#sprodCategory").val(),
			"prodDesc" : $('#sprodDesc').val(),
			"qtyBought" : $('#sqty').val()
		}),
		// redirect : true,
		success : saveToCart,
		error : ajaxError
	});
});

function saveToCart(){
	console.log("Saved To Cart");
}

function saveLaptop() {
	console.log("Laptop Saved in DB");
	location.reload();
}

$('#mobilesCatalog tbody').on('click', 'tr', function(event) {
	// alert($(this).id);
	// alert($(this).parent.id);
	if ($(this).hasClass('selected')) {
		$(this).removeClass('selected');
	} else {
		$('tr.selected').removeClass('selected');
		$(this).addClass('selected');
	}
});


/*
 * $('tr').click(function(event){ alert(event.target.id); });
 */

