/*
My Custom JS
============

Author:  Gaurav Kesarwani
Updated: September 2014
Notes:	 CMPE282 Lab2
 */

$(document)
		.ready(
				function() {
					$('#signup').bootstrapValidator({
				        message: 'This value is not valid',
				        feedbackIcons: {
				            valid: 'glyphicon glyphicon-ok',
				            invalid: 'glyphicon glyphicon-remove',
				            validating: 'glyphicon glyphicon-refresh'
				        },
				        fields: {
				            firstName: {
				                message: 'The username is not valid',
				                validators: {
				                    notEmpty: {
				                        message: 'The username is required and cannot be empty'
				                    },
				                    stringLength: {
				                        min: 6,
				                        max: 30,
				                        message: 'The username must be more than 6 and less than 30 characters long'
				                    },
				                    regexp: {
				                        regexp: /^[a-zA-Z0-9_]+$/,
				                        message: 'The username can only consist of alphabetical, number and underscore'
				                    }
				                }
				            },
				            email: {
				                validators: {
				                    notEmpty: {
				                        message: 'The email is required and cannot be empty'
				                    },
				                    emailAddress: {
				                        message: 'The input is not a valid email address'
				                    }
				                }
				            }
				        }
				    });
					$('#signup')
							.click(
									function() {
										
									
										/*if ($('#passwd').val() != $(
												'#cnfmpasswd').val()) {
											$('#passwderr')
													.html(
															"<strong>Password do not match</strong>");
										}*/
									/*	else{*/

										$
												.ajax({
													type : "POST",
													url : "http://localhost:8080/WebStore/rest/users/signup",
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
