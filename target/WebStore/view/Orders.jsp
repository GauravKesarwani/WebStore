<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../assets/css/bootstrap.css" rel="stylesheet" type=text/css>
<link href="../assets/css/bootstrap-glyphicons.css" rel="stylesheet"
	type="text/css">
<link href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">


<script src="../assets/js/modernizr-2.6.2.min.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<table id="custOrders">
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
				<th>Quantity Purchased</th>
			</tr>
		</tfoot>
	</table>
	<input type="hidden" id="userId"
		value='<%=request.getSession().getAttribute("userId")%>' />
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
	<script src="../assets/js/orders.js"></script>
	<script src="../assets/js/error.js"></script>
</body>
</html>