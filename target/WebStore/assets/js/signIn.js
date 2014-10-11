$(document).ready(function(){

	 $('#signinform').bootstrapValidator({
	        message: 'This value is not valid',
	        fields: {
	           
	            userName: {
	                validators: {
	                    notEmpty: {
	                        message: 'The username is required and cannot be empty'
	                    },
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: 'The username must be more than 6 and less than 20 characters long'
	                    },
	                    different: {
	                        field: 'password',
	                        message: 'The username and password cannot be the same as each other'
	                    }
	                    
	                }
	            },
	            passwd: {
	                validators: {
	                    notEmpty: {
	                        message: 'The password is required and cannot be empty'
	                    },
	                    different: {
	                        field: 'username',
	                        message: 'The password cannot be the same as username'
	                    },
	                    stringLength: {
	                        min: 8,
	                        message: 'The password must have at least 8 characters'
	                    }
	                }
	            }
	        }
	    }); 
	 
	 $('#signin').submit(function() {
			var URL = "/WebStore/rest/users/signin";
			$.ajax({
				type : "POST",
				url : URL,
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify({
					"email" : $('#userName').val(),
					"passwd" : $('#passwd').val()
				}),
				//redirect : true,
				success : loadBooks,
				error : ajaxError
			});
		});

		function loadBooks(data, textStatus, jqXHR) {
			var cond1 = data.message.localeCompare('Invalid Password');
			var cond2 = data.message.localeCompare('Not Exists');
			if (cond1 != 0 && cond2 != 0) {

				var redirectUrl = "/WebStore/view/Catalog.jsp";
				$(location).attr('href', redirectUrl);
			} else {
				alert("code to be implemented");
				//Code to be Implemented
			}
		}

		function ajaxError(jqXHR, status) {
			alert(status + " " + jqXHR);
		}


	});	
	
