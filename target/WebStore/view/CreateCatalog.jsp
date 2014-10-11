<!DOCTYPE html>
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

<!-- Custom CSS -->
<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">

<!-- Include Modernizr in the head, before any other Javascript -->
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
				</div>
			</div>
			<!-- end container -->
		</div>
		<!--end navbar-->
		<form action="view/Catalog.jsp" method="POST">
			<div class="row" id="bigCallout">
				<div class="col-8">
					<div class="well">
						<div class="page-header">
							<h1>Add Catalog</h1>
						</div>
						<div class="row">
							<div class="col-2">
								<label for="catalogName" type="label">Catalog Name</label>
							</div>
							<div class="input-group col-6">
								<input type="text" id="catalogName" class="form-control"
									placeholder="Enter Catalog Name">
							</div>
						</div>
						<div class="row">
							<div class="col-2">
								<label for="catalogDesc" type="label">Catalog
									Description</label>
							</div>
							<div class="input-group col-6">
								<input type="text" id="catalogDesc" class="form-control"
									placeholder="Enter Catalog Description">
							</div>
						</div>
						<div>
							<input type="hidden" id="data" value="" />
						</div>
						<div class="sign-butt">
							<a id="createCatalog" class="btn btn-large btn-primary">Create</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!--end container-->
	<footer> </footer>
	<!--HTML 5 -->
	<!-- Your Code Goes Here. Remember to remove this comment once you've started, you don't need it :) -->


	<!-- All Javascript at the bottom of the page for faster page loading -->

	<!-- First try for the online version of jQuery-->
	<script src="http://code.jquery.com/jquery.js"></script>

	<!-- If no online access, fallback to our hardcoded version of jQuery -->
	<script>window.jQuery || document.write('<script src="../assets/js/jquery-1.11.1.js"><\/script>')</script>

	<!-- Bootstrap JS -->
	<script src="../assets/js/bootstrap.min.js"></script>
	
	<script src="../assets/js/catalog.js" type="text/javascript"></script>
	<script src="../assets/js/error.js" type="text/javascript"></script>
	</body>
	</html>