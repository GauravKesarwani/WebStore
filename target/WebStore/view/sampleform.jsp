<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form class="cmxform" id="commentForm" method="get" action="">
  <fieldset>
    <legend>Please provide your name, email address (won't be published) and a comment</legend>
    <p>
      <label for="cname">Name (required, at least 2 characters)</label>
      <input id="cname" name="name" minlength="2" type="text" required/>
    </p>
    <p>
      <label for="cemail">E-Mail (required)</label>
      <input id="cemail" type="email" name="email" required/>
    </p>
    <p>
      <label for="curl">URL (optional)</label>
      <input id="curl" type="url" name="url"/>
    </p>
    <p>
      <label for="ccomment">Your comment (required)</label>
      <textarea id="ccomment" name="comment" required></textarea>
    </p>
    <p>
      <input class="submit" type="submit" value="Submit"/>
    </p>
  </fieldset>
</form>
	<script src="http://code.jquery.com/jquery.js"></script>

	<!-- If no online access, fallback to our hardcoded version of jQuery -->
	<script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/jquery-1.8.2.min.js"><\/script>')
	</script>

	<!-- Bootstrap JS -->
	<script src="../assets/js/bootstrap.min.js"></script>

	<!-- Custom JS -->
	<script src="../assets/js/script.js"></script>
	<script src="../assets/js/jquery.validate.js"></script>
	
<script>
$("#commentForm").validate();
</script>
</body>
</html>