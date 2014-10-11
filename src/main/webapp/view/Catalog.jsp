<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Website Title & Description for Search Engine purposes -->
<title>Index Page</title>
<meta charset="utf-8">

<!-- Mobile viewport optimized -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

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
					src="../assets/img/cloudServices.jpg" id="logo" alt="Your logo" /></a>
				<div class="collapse nav-collapse navbar-responsive-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="Catalog.jsp">Catalog</a></li>
					</ul>
					<form class="navbar-form pull-right">
						<input type="text" class="form-control"
							placeholder="Search this site..!" id="SearchInput" />
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</form>
					<ul class="nav navbar-nav pull-right">
						<li><a href='#'><span class="glyphicon glyphicon-user">
									My Account<strong class="caret"></strong>
							</span></a></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<li>You last logged in at <%=request.getSession().getAttribute("llogin")%></li>
					</ul>
					
				</div>
			</div>
			<!-- end container -->
		</div>
		<!--end navbar-->

<br><br><br><br>

		<table id="catalogTable" class="row-border hover">
			<thead>
				<tr>
					<th>Catalog Name</th>
					<th>Catalog Description</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<th>Catalog Name</th>
					<th>Catalog Description</th>
				</tr>
			</tfoot>
		</table>
<button type="button" class="btn btn-primary" id="addCatalog">Create
				Catalog</button>
<input type="hidden" id="userId" value= <%=request.getSession().getAttribute("userId")%>	/>
	<!--HTML 5 -->
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
	<script src="../assets/js/listCatalog.js"></script>
	<script src="../assets/js/error.js"></script>
</body>
</html>