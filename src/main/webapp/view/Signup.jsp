<!DOCTYPE html>
<html>
<head>
<!-- Website Title & Description for Search Engine purposes -->
<title></title>
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
<script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/jquery-1.8.2.min.js"><\/script>')
	</script>

<!-- Include Modernizr in the head, before any other Javascript -->
<script src="../assets/js/modernizr-2.6.2.min.js" type="text/javascript"></script>

<script type="text/javascript" src="../assets/js/bootstrapValidator.js"></script>
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

				<a class="navbar-brand" href="/"><img id="logo"
					src="../assets/img/logo2.jpg" alt="Your logo" /></a>
				<h3>Shopify - Your dream online shopping experience</h3>
			</div>
			<!-- end container -->
		</div>
	
	<!-- end container -->
	
	<!--end navbar-->
<form id="signupform">
	<div class="row" id="bigCallout">
		<div class="col-8">
			<div class="well">
				<div class="page-header">
					<h1>Sign Up</h1>
				</div>
				<div class="input-group">
					<span class="input-group-addon"></span> <input type="text"
						id="firstName" name="firstName" class="form-control error"
						placeholder="FirstName">

				</div>
				<div class="input-group">
					<span class="input-group-addon"></span> <input type="text"
						id="lastName" name="lastName" class="form-control"
						placeholder="LastName">

				</div>
				<div class="input-group">
					<span class="input-group-addon">@</span> <input type="email"
						id="email" name="email" class="form-control" placeholder="Email"
						>
				</div>
				<div class="input-group">
					<span class="input-group-addon"></span> <input type="password"
						id="passwd" class="form-control" placeholder="Password" >
				</div>
				<div class="input-group">
					<span class="input-group-addon"></span> <input type="password"
						id="cnfmpasswd" class="form-control" placeholder="Confirm Password">
						<p id="passwderr">Passsword Error</p>
				</div>
				<div class="sign-butt">
					<button type="submit" id="signup" class="btn btn-large btn-primary">Sign
						Up</button>
					<a href="../welcome-file.jsp" class="btn btn-large btn-link">
						Already have an account? Click Here to Login</a>
				</div>
				<div id="alreadyexists"></div>
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
	<!-- <script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/jquery-1.8.2.min.js"><\/script>')
	</script> -->

	<!-- Bootstrap JS -->
	<script src="../assets/js/bootstrap.min.js"></script>

	<!-- Custom JS -->
	<script src="../assets/js/script.js"></script>
</body>
</html>
