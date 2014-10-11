<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- script src="product.js" type="text/javascript"></script-->
<link href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css">
<link href="../assets/css/bootstrap.css" rel="stylesheet"
	type="text/css">
</head>
<body>
		<table id="booksCatalog">
			<thead>
				<tr>
					<th>Product Category</th>
					<th>Product Id</th>
					<th>Product Description</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Product Category</th>
					<th>Product Id</th>
					<th>Product Description</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</tfoot>
		</table>

	<div>
		<button type="button" class="btn btn-primary" id="addProduct">Add
			Product</button>
	</div>
	<div class="modal" id="item">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Modal title</h4>
				</div>

				<div class="modal-body">
					<table>
						<tr>
							<td>Product Category</td>
							<td><select id="prodCategory">
									<option value="book">Book</option>
									<option value="laptop">Laptop</option>
									<option value="mobiles">Mobiles</option>
									<option value="games">Games</option>
							</select></td>
						</tr>
						<tr>
							<td>Product Id</td>
							<td><input type="text" id="productId" class="span3"
								placeholder="Enter Product Name" required /></td>
						</tr>

						<tr>
							<td>Price</td>
							<td><input type="text" id="Price" class="span6"
								placeholder="Enter Price" required /></td>
						</tr>

						<tr>
							<td>Product Description</td>
							<td><input type="text" id="prodDesc" class="span3"
								placeholder="ProdDesc" required /></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td><input type="text" id="qty" class="span6"
								placeholder="Enter Number of Books Available" required /></td>
						</tr>
					</table>

				</div>
				<div class="modal-footer">
					<a href="#" class="btn" data-dismiss="modal">Close</a> <a
						id="saveProd" class="btn btn-primary" data-dismiss="modal">Save
						Changes</a>
				</div>
			</div>
		</div>l
	</div>
	<!-- First try for the online version of jQuery-->
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<!-- If no online access, fallback to our hardcoded version of jQuery -->
	<script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/jquery-1.11.1.js"><\/script>')
	</script>

	<!-- Bootstrap JS -->
	<script src="../assets/js/bootstrap.js"></script>

	<!-- Custom JS -->
	<!-- script src="assets/js/script.js"></script-->
	<script src="../assets/js/book.js"></script>
	<script src="../assets/js/error.js"></script>
</body>
</html>