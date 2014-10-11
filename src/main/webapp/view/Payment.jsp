<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
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
	<form action="Confirm.jsp">
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
							<li class="active"><a href="#">Home</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Services<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">Web Design</a></li>
									<li><a href="#">Web Development</a></li>
									<li><a href="#">SEO</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">More Services</li>

									<li><a href="#">Content Creation</a></li>
									<li><a href="#">Social Media Marketing</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form pull-left">
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
					</div>
				</div>
				<!-- end container -->
			</div>
			<!--end navbar-->

			<form>
				<div class="row" id="bigCallout">
					<div class="col-8">
						<div class="well">
							<div class="page-header">
								<h1>Enter You Payment details</h1>
							</div>
							<div class="input-group">
								<label>Name</label> <input type="text" id="name"
									class="form-control" placeholder="Username">
							</div>
							<div class="input-group">
								<select>
									<option>Master Card</option>
									<option>Visa Card</option>
								</select>
							</div>
							<div class="input-group">
								<label>Shipping Address</label> <input type="text" id="address"
									class="form-control" placeholder="Enter your Shipping Address">
							</div>
							<div class="input-group">
								<label>Credit Card Number</label> <input type="text" id="ccno"
									pattern="[0-9]{16}" class="form-control"
									placeholder="Enter your Credit Card Number">
							</div>
							<div class="input-group">
								<label>CVV</label> <input type="text" id="cvv"
									class="form-control" placeholder="CVV No">
							</div>
							<input type="hidden" id="userId"
								value='<%=request.getSession().getAttribute("userId")%>' />
							<div class="sign-butt">
								<input type="submit" id="purchase" class="btn btn-large btn-primary"/>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!--end container-->
		<footer> </footer>
	</form>
	<!--HTML 5 -->
	<!-- Your Code Goes Here. Remember to remove this comment once you've started, you don't need it :) -->


	<!-- All Javascript at the bottom of the page for faster page loading -->

	<!-- First try for the online version of jQuery-->
	<script src="http://code.jquery.com/jquery.js"></script>

	<!-- If no online access, fallback to our hardcoded version of jQuery -->
	<script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/jquery-1.11.1.js"><\/script>')
	</script>

	<!-- Bootstrap JS -->
	<script src="../assets/js/bootstrap.min.js"></script>

	<!-- Custom JS -->
	<!-- script src="assets/js/script.js"></script-->
	<script src="../assets/js/payment.js"></script>

</body>
</html>