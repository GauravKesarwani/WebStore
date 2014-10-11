<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link href="../assets/css/bootstrap.css" rel="stylesheet" type=text/css>
<link href="../assets/css/bootstrap-glyphicons.css" rel="stylesheet"
	type="text/css">
<link href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">
<script src="../assets/js/modernizr-2.6.2.min.js" type="text/javascript"></script>

</head>
<body>
<table id="shopCart">
		<thead>
			<tr>
				<th>Product Category</th>
				<th>Product Id</th>
				<th>Product Description</th>
				<th>Price</th>
				<th>Quantity</th>
				
				<th>Remove</th>
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
				
				<th>Remove</th>
			</tr>
		</tfoot>
	</table>
	<input type="hidden" id="userId" value='<%=request.getSession().getAttribute("userId") %>' />
	
	<div class="modal fade" id="item">
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
								<td><select id="sprodCategory">
										<option value="Books">Books</option>
										<option value="laptop">Laptop</option>
										<option value="mobiles">Mobiles</option>
										<option value="games">Games</option>
								</select></td>
							</tr>
							<tr>
								<td>Product Id</td>
								<td><input type="text" id="sprodId" class="span3" readonly
									placeholder="Enter Product Name" required /></td>
							</tr>

							<tr>
								<td>Price</td>
								<td><input type="text" id="sprice" class="span6" readonly
									placeholder="Enter Price" required /></td>
							</tr>

							<tr>
								<td>Product Description</td>
								<td><input type="text" id="sprodDesc" class="span3" readonly
									placeholder="ProdDesc" required /></td>
							</tr>
							<tr>
								<td>Quantity</td>
								<td><input type="text" id="sqty" class="span6"
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
			</div>
		</div>
	
		<!-- Bootstrap JS -->
	<script src="../assets/js/bootstrap.js"></script>
	<input type="button" id="checkOut" class="btn btn-primary" value="CheckOut"/>
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
	<script src="../assets/js/shopcart.js"></script>
	<script src="../assets/js/error.js"></script>
</body>
</html>