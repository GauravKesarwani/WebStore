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
<link href="assets/css/bootstrap.css" rel="stylesheet" type=text/css>
<link href="assets/css/bootstrap-glyphicons.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="assets/css/bootstrapValidator.css" type="text/css">
 <link rel="stylesheet" href="assets/css/font-awesome.css" type="text/css" />
<!-- Custom CSS -->
<link href="assets/css/styles.css" rel="stylesheet" type="text/css">

<!-- Include Modernizr in the head, before any other Javascript -->
<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/jquery-1.11.1.js"><\/script>')
	</script>


<script src="assets/js/modernizr-2.6.2.min.js" type="text/javascript"></script>

<!-- If no online access, fallback to our hardcoded version of jQuery -->
		<!-- Bootstrap JS -->
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/bootstrapValidator.js"></script>


<style>

</style>
</head>
<body>
	<div class="container" id="main">
		<nav class="navbar navbar-fixed-top">
			<div class="container">
				<button class="navbar-toggle"
					data-target=".navbar-responsive-collapse" data-toggle="collapse"
					type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/"><img id="logo" src="assets/img/cloudServices.jpg"
					alt="Your logo" /></a>
				 <h3>Shopify - Your dream online shopping experience</h3> 
			</div>
			<!-- end container -->
		</nav>
		<!--end navbar-->

		<form id="signinform" action="view/Catalog.jsp" method="POST">
			<div class="row" id="bigCallout">
				<div class="col-8">
					<div class="well">
						<div class="page-header">
							<h1>Sign In</h1>
						</div>
						<div class="input-group form-group">
							<span class="input-group-addon">@</span> <input type="text" name="userName"
								id="userName" class="form-control" placeholder="Username">
						</div>
						<div class="input-group form-group">
							<span class="input-group-addon"></span> <input type="password" name="passwd"
								id="passwd" class="form-control" placeholder="Password">
						</div>
						<div>
							<input type="hidden" id="data" value="" />
						</div>
						<div class="sign-butt form-group">
							<button type="submit" id="signin" class="btn btn-large btn-primary">Sign In</button> <a
								href="view/Signup.jsp" class="btn btn-large btn-link"> Or
								Sign Up</a>
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
	<!--script src="http://code.jquery.com/jquery.js"></script-->

		<!-- Custom JS -->
	<!-- script src="assets/js/script.js"></script-->
	<script src="assets/js/signIn.js"></script>
</body>
</html>