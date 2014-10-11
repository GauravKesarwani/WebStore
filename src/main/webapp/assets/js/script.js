/*
My Custom JS
============

Author:  Gaurav Kesarwani
Updated: September 2014
Notes:	 CMPE282 Lab2
 */

$(document).ready(function() {
							$('#signup').click(
									function() {
										
									
									

										$.ajax({
													type : "POST",
													url : "/WebStore/rest/users/signup",
													data : formToJSON(),
													contentType : "application/json",
													dataType : "json",
													success : successsignup,
													error : function(jqXHR,
															status) {
														$("#addToCart").click(
																function() {

																});
														alert(jqXHR + " "
																+ status);

													}
												});
									});

					function successsignup(data, status, jqXHR) {
						alert(data.message);
						if (data.message.localeCompare('User Created') == 0) {
							var redirectUrl = "http://localhost:8080/WebStore/welcome-file.jsp";
							$(location).attr('href', redirectUrl);
						} else if (data.message
								.localeCompare('Email already exists') == 0) {
							console.log("email already exists!!");
							$('#alreadyexists')
									.html(
											"<span><h3 style=\"color:red\">Email Already Exists!! Please sign in to continue..!</h3></span>");
						}
					}

					function formToJSON() {
						return JSON.stringify({
							"firstName" : $('#firstName').val(),
							"lastName" : $('#lastName').val(),
							"email" : $('#email').val(),
							"passwd" : $('#passwd').val(),
						});
					}
});					
				
