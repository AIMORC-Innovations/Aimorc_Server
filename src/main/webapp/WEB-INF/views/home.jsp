<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<!-------------------------------------scrool bar and footer----------------------------------->
body {
data-spy="scroll";
overflow: hidden;
font-family: "Amazon Ember",Arial,sans-serif;
height: 100%;
}
#content {
max-height: calc(108.6% - 120px);
overflow-y: scroll;
padding: 0px 10% !important;
margin-top: 0px !important;
}
html, body {
	height: 100%;
	width: 100%;
	margin: 0;
	padding: 0;
}

footer {
	width: 100%;
	height: 0px;
	background: #004d80;
	position: fixed;
	bottom: 0;
}

<!------------------------------------css for cart display button------------------------------ --> 
 body {
	margin: 0;
	font-family: Helvetica, Arial;
	font-size: .8125rem;
	font-weight: 400;
	line-height: 1.5385;
	color: #333;
	text-align: left; /
	background-color: #2196F3;
}
.mt-50 {
	margin-top: 50px;
}

.mb-50 {
	margin-bottom: 50px;
}
#category_id {
	background-color: #004d80;
	color: #fff
}
.card {
	position: relative;
	display: -ms-flexbox;
	display: flex;
	-ms-flex-direction: column;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border-radius: .1875rem;
}

#product_description {
	font-size: 12px;
}

.card-img-actions {
	position: relative;
}

.card-body {
	-ms-flex: 1 1 auto;
	flex: 1 1 auto;
	padding: 1.25rem;
	text-align: center;
}

.card-img {
	width: 350px;
}
.a {
	text-decoration: none !important;
}
/*----------side bar------------------ */
.text-justify {
	height: 80px;
	responsive-font-size: 4rem;
	overflow-y: scroll;
}
#dropdown-item {
	background-color: #004d80;
	border-color: #004d80;
	color: white;
	font-color: white;
}

#text {
	color: white;
}

#text:hover {
	background: #3c78b3;
}

.fa_custom {
	color: #f9f9f9
}
::-webkit-scrollbar {
	width: 4px;
	height: 12px;
}

::-webkit-scrollbar-track {
	border: 1px solid grey;
	border-radius: 10px;
}

::-webkit-scrollbar-thumb {
	background: grey;
	border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
	background: grey;
}

#dropdownMenuButton {
	background: #004d80;
	border-color: #004d80;
}

</style>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="$1">
<title>Home Page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script>
<!-------------------------------------callback function------------------------------ -->
	$(document)
			.ready(
					function() {

						var cartValue;
						var data2;
						var data1;

						function cart() {
							/*----------display cart ajax---------------- */
							$
									.ajax({
										type : "GET",
										url : "cartTotalServlet",
										contentType : "application/json", // NOT dataType!
										success : function(data) {
											let responseData = JSON.parse(data);
											
											let allProdsCount = 0;

											Object.keys(responseData).forEach((eachCategoryId, index) => {
											console.log(eachCategoryId, " --- ", responseData[eachCategoryId]);

											let currCat = responseData[eachCategoryId].products.length;
											allProdsCount = allProdsCount + currCat;
											cartValue = allProdsCount;

											document.getElementById('Value').innerHTML = "[" + cartValue + "]";
											}); 

										}
									});

						}
						cart();

						/*------dynamic box------------ */
						function displayCategory() {
							$
									.ajax({

										type : "GET",
										url : "homeCategoryServlet",
										contentType : "application/json", // NOT dataType!

										success : function(data) {
											var userJSON = JSON.parse(data);
                                             
											console.log(userJSON);

											for (var i = 0; i < userJSON.length; i++) {

												var parentDiv = document
														.createElement('div');
												parentDiv.className = 'col-md-4 mt-2';
												parentDiv.id = 'block';
												document
														.getElementsByClassName('row')[0]
														.appendChild(parentDiv);

												var innerDiv = document
														.createElement('div');
												innerDiv.className = 'card';
												parentDiv.appendChild(innerDiv);

												var bodyDiv = document
														.createElement('div');
												bodyDiv.className = 'card-body';
												innerDiv.appendChild(bodyDiv);

												var childDiv = document
														.createElement('div');
												childDiv.className = 'card-body bg-light text-center';
												innerDiv.appendChild(childDiv);

												var imageDiv = document
														.createElement('div');
												imageDiv.className = 'card-img-actions';
												bodyDiv.appendChild(imageDiv);

												var img = document
														.createElement('img');
												img.src = "images/Party_wear.jpg";
												img.className = 'card-img img-fluid';
												img.id = "images" + i;
												img.width = "96";
												img.height = "350";
												imageDiv.onload = myImages;
												imageDiv.appendChild(img);

												var addDiv = document
														.createElement('div');
												addDiv.className = 'mb-2';
												childDiv.appendChild(addDiv);

												var category_name = document
														.createElement('h1');
												category_name.className = 'font-weight-semibold mb-2';
												category_name.id = "category_name";
												category_name.innerHTML = userJSON[i].category_name;
												addDiv
														.appendChild(category_name);

												var category_desc = document
														.createElement('p');
												category_desc.className = 'text-justify';
												category_desc.id = "product_description";
												category_desc.innerHTML = userJSON[i].category_description;
												category_desc.href = "#";
												addDiv
														.appendChild(category_desc);

												var btn = document
														.createElement('button');
												btn.type = "button"
												btn.className = 'btn btn-primary';
												btn.id = "category_id";
												btn.value = userJSON[i].category_id;
												childDiv.appendChild(btn);

												var fontawsome = document
														.createElement('i');
												//fontawsome.className="fa fa-cart-plus mr-2";
												fontawsome.innerHTML = " View Category ";
												btn.appendChild(fontawsome);

											}

											var images = [
													"images/Anarkali Gown.jpg",
													"images/Flared Skirt.jpg",
													"images/Jump Suit.jpg" ];

											function myImages() {
												for (var i = 0; i < userJSON.length; i++) {
													document
															.getElementById("images"
																	+ i).src = images[i];
												}
											}
											images.forEach(myImages)
											// -------------------on click of view category -------------------- //
											$(document)
													.on(
															'click',
															'button[id]',
															function(e) {

																if (this.id == "dropdownMenuButton") {

																	return false;
																}

																category_id = $(
																		this)
																		.val();

																localStorage
																		.clear();
																localStorage
																		.setItem(
																				'categoryId',
																				JSON
																						.stringify(category_id));
																console
																		.log(category_id);

																var data = {
																	category_id : $(
																			this)
																			.val(),
																};

																// --------------------------------inside success 2nd ajax------------------------------------------------------- /

																$
																		.ajax({
																			type : "POST",
																			url : "homeCategoryServlet",
																			contentType : "application/json", // NOT dataType!
																			data : JSON
																					.stringify(data),

																			statusCode : {
																				409 : function() {

																					$(
																							'#notadded')
																							.slideDown();
																					window.location.href = "http://localhost:9979/AIMORCProject/productimage.jsp";
																				},
																				200 : function(
																						response) {

																					$(
																							'#added')
																							.slideDown();
																					console
																							.log("Removed Successfully");

																					window.location.href = "http://localhost:9979/AIMORCProject/productimage.jsp";

																				}
																			},
																		});
															});
										},
									});
						}
						displayCategory();
					});
</script>
</head>
<body data-spy="scroll">
	<!--------------------- ----------------header------------------------------ -->
	<nav class="navbar navbar-dark navbar-expand-md"
		style="background-color:#004d80;" style="position:relative">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">AIMORC Innovations </a>
		</div>
		<button data-toggle="collapse" data-target="#navbarToggler"
			type="button" class="navbar-toggler">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarToggler">
			<ul class="nav navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/home">
						Home</a></li>
			</ul>
			<a class="navbar-brand" href="#">Welcome ${username}</a>
			<ul class="nav navbar-nav navbar-right">
				<div class="dropdown ">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false ">
						<i class="fa fa-user" aria-hidden="true"
							style="padding: 5px; margin-top: 5px;"></i> Account
					</button>
					<div class="dropdown-menu dropdown-menu-right" id="dropdown-item">
						<a class="dropdown-item " id="text" href="/profilePage"><i
							class="fa fa-user" aria-hidden="true" style="padding: 5px;"></i>
							Profile</a><a class="dropdown-item " id="text"
								href="productimage.jsp"><i class="fa fa-list-alt"
								aria-hidden="true" style="padding: 5px;"></i> Product</a>
								 <a class="dropdown-item " id="text"
							href="datepicker.jsp"><i class="fa fa-calendar"
							aria-hidden="true" style="padding: 5px;"></i> Schedule Pick Up</a>  <a class="dropdown-item " id="text"
							href="/loginSecurityQuestion"><i class="fa fa-edit"
							aria-hidden="true" style="padding: 5px;"></i> Change Password</a> <a
							class="dropdown-item " id="text" href="LogoutServlet"><i
							class="fa fa-sign-out" aria-hidden="true" style="padding: 5px;"></i>
							Logout</a>
					</div>
				</div>

				<div class="nav-item active">
					<a class="nav-link" href="cartdisplay.jsp"><i
						class="fa fa-shopping-cart fa_custom fa-2x"></i> <i id="Value">
					</i> </a>
				</div>

			</ul>
		</div>
	</div>
	</nav>

	<!------------------ ----------------form------------------------------ -->
	<div id="content">
	<div>
		<h1 align="center">Select Category</h1>

		<div class="container d-flex justify-content-center mt-50 mb-50">
			<div class="row" id="form"></div>
		</div>
	</div>
	</div>


</body>
</html>