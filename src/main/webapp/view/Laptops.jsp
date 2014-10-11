<%@page language="java" contentType="text/html; charset=UTF-8"
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
<link
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"
	rel="stylesheet" type="text/css"></link>
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/jqueryui/dataTables.jqueryui.css"
	rel="stylesheet" type="text/css"></link>

<!-- Custom CSS -->
<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">


<script src="../assets/js/modernizr-2.6.2.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container" id="main">
		<div class="navbar navbar-fixed-top">
			<div class="container">
				<button class="navbar-toggle"
					data-target=".navbar-responsive-collapse" data-toggle="collapse"
					type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/"><img
					src="../assets/img/logo.png" alt="Your logo" /></a>
				<div class="collapse nav-collapse navbar-responsive-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="Catalog.jsp">Home</a></li>

					</ul>

					<form class="navbar-form pull-right">
						<ul class="nav navbar-nav pull-right">
							<li><strong>Last Login : <%=request.getSession().getAttribute("llogin")%></strong></li>
							<li><button type="button" id="cart" class="btn btn-default">
									<span class="glyphicon glyphicon-shopping-cart"></span>
								</button></li>
						</ul>


					</form>
					<ul class="nav navbar-nav pull-right">
						<li><a href='Orders.jsp'><span
								class="glyphicon glyphicon-user"> My Account<strong
									class="caret"></strong>
							</span></a></li>
					</ul>

				</div>
			</div>
			<!-- end container -->
		</div>
		<br> <br> <br>
		<table id="laptopsCatalog" class="display row-border hover">
			<thead>
				<tr>
					<th>Product Category</th>
					<th>Product Id</th>
					<th>Product Description</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Add to cart</th>
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
					<th>Add to cart</th>
				</tr>
			</tfoot>
		</table>

		<div>
			<input type="hidden" id="hiddencategory" value="Laptops" />
			<button type="button" class="btn btn-primary" id="addProduct">Add
				Product</button>
		</div>
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
								<td><select id="prodCategory">
										<option value="Books">Books</option>
										<option value="Laptops">Laptops</option>
										<option value="Mobiles">Mobiles</option>
										<option value="Games">Games</option>
								</select></td>
							</tr>
							<tr>
								<td>Product Id</td>
								<td><input type="text" id="productId" class="span3"
									placeholder="Enter Product Name" required /></td>
							</tr>

							<tr>
								<td>Price</td>
								<td><input type="text" id="price" class="span6"
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
			</div>
		</div>
		<div class="modal fade" id="addToShopCart">
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
								<td><input type="hidden" id="userId"
									value='<%=request.getSession().getAttribute("userId")%>' /></td>
							</tr>
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
								<td><input type="text" id="sprodId" class="span3"
									placeholder="Enter Product Id" required /></td>
							</tr>

							<tr>
								<td>Price</td>
								<td><input type="text" id="sPrice" class="span6"
									placeholder="Enter Price" required /></td>
							</tr>

							<tr>
								<td>Product Description</td>
								<td><input type="text" id="sprodDesc" class="span3"
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
							id="saveProdCart" class="btn btn-primary" data-dismiss="modal">Save
							Changes</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->
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
	<script src="../assets/js/laptop.js"></script>
	<script src="../assets/js/error.js"></script>
</body>
</html>