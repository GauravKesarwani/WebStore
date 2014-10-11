$(document).ready(
		function() {
			var id = $('#userId').val();
			console.log(id);
			$('#custOrders').dataTable(
					{
						"processing" : true,
						"serverSide" : true,
						"ajax" : "/WebStore/rest/users/order/" + id,
						"columns" : [ {
							"data" : "prodCategory"
						}, {
							"data" : "prodId"
						}, {
							"data" : "prodDesc"
						}, {
							"data" : "price"
						}, {
							"data" : "qtyPurchased"
						} 
						]
					});
});