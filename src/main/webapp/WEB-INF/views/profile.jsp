<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="$1">

<title>Profile Details</title>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">

<!-- -------------------------------------css---------------------------------------------------- -->

<style type="text/css">
body {
data-spy="scroll";
overflow: hidden;
font-family: "Amazon Ember",Arial,sans-serif;
height: 100%;
}

#content {
	max-height: calc(100% - 120px);
	overflow-y: scroll;
	padding: 0px 10% !important;
	margin-top: 60px !important;
}

html, body {
	height: 100%;
	width: 100%;
	margin: 0;
	padding: 0;
}

footer {
	width: 100%;
	height: 30px;
	background: #004d80;
	position: fixed;
	bottom: 0;
}

	
			#dropdownMenuButton{
			background:#004d80;
			border-color:#004d80;
			}
			
			#dropdown-item  {
			 background-color:#004d80; 
			border-color:#004d80; 
			color:white;
			font-color:white;
			}
			#text{
			color:white;
			}
			#text:hover {
    		background: #3c78b3;
			}

</style>

</head>
<body >

	<!--------------------- ----------------header------------------------------ -->

	<nav class="navbar navbar-dark navbar-expand-md"
		style="background-color: #004d80;">
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

					<li class="nav-item active"><a class="nav-link"
						href="/home"> Home</a></li>
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
							 <a class="dropdown-item " id="text"
								href="productimage.jsp"><i class="fa fa-list-alt"
								aria-hidden="true" style="padding: 5px;"></i> Product</a> <a
								class="dropdown-item " id="text"
								href="loginsecurityquestion.jsp"><i class="fa fa-edit"
								aria-hidden="true" style="padding: 5px;"></i> Change Password</a> 
								 <a class="dropdown-item " id="text" href="logoutServlet"><i
							class="fa fa-sign-out" aria-hidden="true" style="padding: 5px;"></i>
							Logout</a>
					
						</div>
					</div>
	</nav>

<!--------------------- ----------------form------------------------------ -->

	<p id="demo" align="center"></p>
	<form>
		<div class="container">

			<div class="table-responsive">
				<table class="table table-striped">

					<tr>
						<th>First Name</th>
						<td id="firstName"></td>
					</tr>

					<tr>
						<th scope="row">Last Name</th>
						<td id="lastName"></td>
					</tr>

					<tr>
						<th scope="row">Date-Of-Birth</th>
						<td id="dob"></td>
					</tr>

					<tr>
						<th scope="row">Gender</th>
						<td id="gender"></td>
					</tr>

					<tr>
						<th scope="row">Phone Number</th>
						<td id="phonenum"></td>
					</tr>

					<tr>
						<th scope="row">Address</th>
						<td id="address"></td>
					</tr>

				</table>
				<a href="editprofile.jsp">
					<button type="button" id="edit-profile-button"
						class="btn btn-primary">Edit</button>
				</a>
			</div>
		</div>
	</form>

<!--------------------- ----------------ajax------------------------------ -->

	<script type="text/javascript">
		$(document)
				.ready(function() {
					$.ajax({
										type : "GET",
										url : "/profile",
										contentType : "application/json",
										success : function(data) {
											var userJSON = JSON.parse(data);
											document.getElementById("firstName").innerHTML = userJSON.firstName;
											document.getElementById("lastName").innerHTML = userJSON.lastName;
											document.getElementById("dob").innerHTML = userJSON.dob;
											document.getElementById("gender").innerHTML = userJSON.gender;
											document.getElementById("phonenum").innerHTML = userJSON.phonenum;
											document.getElementById("address").innerHTML = userJSON.address;
											localStorage.setItem('userJSON', JSON.stringify(userJSON));
											console.log(userJSON);
										},
										error : function(error) {
											console.log(error);
										}
									});
						});
	</script>



</body>
</html>