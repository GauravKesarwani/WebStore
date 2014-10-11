$(document)
		.ready(
				function() {
					$('#catalogTable')
							.dataTable(
									{
										"processing" : true,
										"serverSide" : true,
										"ajax" : "/WebStore/rest/catalog/catalogs",
										"columns" : [ {
											"data" : "catalogName"
										}, {
											"data" : "catalogDesc"
										} ],

										"columnDefs" : [ {
											"render" : function(data, type, row) {
												return '<input type="button" class="btn btn-primary" id="'
														+ data
														+ '" value="'
														+ data + '"/>';
											},
											"targets" : 0
										} ]

									});

					if ($('#userId').val() != '3')
						$('#addCatalog').hide();

					$('#catalogTable tbody').on(
							'click',
							'input',
							function(event) {
								if (this.id == 'Books') {
									console.log("Redirecting to books jsp");

									$(location).attr('href',
											"/WebStore/view/Books.jsp"); 							
								} else if (this.id == 'Mobiles') {
									$(location).attr('href',
											"/WebStore/view/Mobiles.jsp");
								} else if (this.id == 'Laptops') {
									$(location).attr('href',
									"/WebStore/view/Laptops.jsp");
								} else if (this.id == 'Games') {
									$(location).attr('href',
									"/WebStore/view/Games.jsp");
								}
							});

					$('#addCatalog').click(function() {
						$(location).attr('href', 'CreateCatalog.jsp');
					});

				});
