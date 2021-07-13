
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<!-------------------------------------scrool bar and footer------------------------------ -->
body {
data-spy="scroll";
overflow: hidden;
font-family: "Amazon Ember",Arial,sans-serif;
height: 100%;
}

#content {
	max-height: calc(110% - 120px);
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

#dropdownMenuButton {
	background: #004d80;
	border-color: #004d80;
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

.bgBoxeditprofile {
	background-color: #f9f9f9;
	padding: 50px;
	border-radius: 5px;
	border: 2px solid #3c78b3;
	max-width: 900px;
	margin: 0 auto;
	margin-top: 15px;
	margin-bottom: 100px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	position: relative;
}
}
</style>

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="$1">

<title>Edit profile Page</title>

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


</head>

<body>

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
						href="home.jsp">Home</a></li>
				</ul>

				<div class="navbar-header">
					<a class="navbar-brand" href="/home">Welcome ${username}</a>
				</div>
	
				<ul class="nav navbar-nav navbar-right">
					<div class="dropdown ">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false ">
							<i class="fa fa-user" aria-hidden="true" style="padding: 5px;"></i>
							Account
						</button>
						<div class="dropdown-menu dropdown-menu-right" id="dropdown-item">
							<a class="dropdown-item " id="text"
								href="/loginSecurityQuestion"><i class="fa fa-edit"
								aria-hidden="true" style="padding: 5px;"></i> Change Password</a> <a class="dropdown-item " id="text" href="/logout"><i
								class="fa fa-sign-out" aria-hidden="true" style="padding: 5px;"></i>
								Logout</a>
						</div>
					</div>
					
				</ul>
			</div>
		</div>
	</nav>
	<div class="container" id="statusDiv">
		<div class="alert alert-success " id="useredited" role="alert"
			style="display: none; text-align: center; margin-top: 10px;">
			<strong>Profile Updated Successfully!</strong>
		</div>
		<div class="alert alert-danger alert-dismissible" id="usereditfail"
			role="alert"
			style="display: none; text-align: center; margin-top: 10px;">
			<strong>Profile Update Failed!</strong>
		</div>
	</div>

	<!--------------------- ----------------form------------------------------ -->
	<div id="content">


		<form class="editform">

		<div class="table-responsive" class="bgBoxeditprofile ">
				<table class="table table-striped">

					<h2>Edit Profile</h2>
					<tr>
						<th>First Name</th>
						<td><input type="text" class="form-control" id="firstname"
							value=""></td>
					</tr>

					<tr>
						<th scope="row">Last Name</th>
						<td><input type="text" class="form-control" id="lastname"
							value=""></td>

					</tr>

					<tr>
						<th scope="row">Date_Of_Birth</th>
						<td><input type="date" class="form-control" id="dob" value=""></td>
					</tr>

					<tr>
						<th scope="row">Gender</th>

						<td><div class="radiobutton">

								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" id="customRadioInline1"
										name="customRadioInline" class="custom-control-input"
										value="Male"> <label class="custom-control-label"
										for="customRadioInline1"> Male </label>
								</div>
								<div
									class="custom-control custom-radio custom-control-inline mt-2">
									<input type="radio" id="customRadioInline2"
										name="customRadioInline" class="custom-control-input"
										value="Female"> <label class="custom-control-label"
										for="customRadioInline2"> Female </label>
								</div>
							</div></td>
					</tr>

					<tr>
						<th scope="row">Phone</th>
						<td><input type="text" class="form-control" id="phonenum"
							value=""></td>
					</tr>

					<tr>
						<th scope="row">Address</th>
						<td><textarea type="textarea" class="form-control"
								id="address" value=""></textarea></td>
					</tr>
					</div>
				</table>

				<button type="button" id="save-profile-button"
					class="btn btn-primary">Save</button>

				

				<a href="/profilePage">
					<button type="button" id="edit-profile-button"
						class="btn btn-primary">Cancel</button>
				</a>

			</div>
	</div>
	</form>
	</div>
	
	<!--------------------- ----------------Script------------------------------ -->

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#useredited').hide();
							$('#usereditfail').hide();

							var getObj = JSON.parse(localStorage
									.getItem('userJSON'));
							var x = getObj.gender;
							document.getElementById("firstname").value = getObj.firstname;
							document.getElementById("lastname").value = getObj.lastname;
							document.getElementById("dob").value = getObj.dob;
							document.getElementById("address").value = getObj.address;
							document.getElementById("phonenum").value = getObj.phonenum;
							$(function() {
								{
									$(
											"input[name=customRadioInline][value="
													+ x + "]").prop('checked',
											true);
								}
							});

							$('#save-profile-button')
									.click(
											function() {
												var data = {
													firstname : $('#firstname')
															.val(),
													lastname : $('#lastname')
															.val(),
													dob : $('#dob').val(),
													address : $('#address')
															.val(),
													phonenum : $('#phonenum ')
															.val(),
													gender : $(
															"input[type='radio'][name='customRadioInline']:checked")
															.val()
												};
												$
														.ajax({
															type : "POST",
															url : '/updateProfileDetails',
															contentType : "application/json",
															data : JSON
																	.stringify(data),
															statusCode : {
																304 : function() {
																
																	$(
																			'#editform')
																			.hide();
																	$(
																			'#usereditfail')
																			.slideDown();
																	setTimeout(
																			function() {
																				window.location.href = "/updateProfile";
																			},
																			3000);
																},
																200 : function() {
																	localStorage
																			.clear();
																	localStorage
																			.setItem(
																					'data',
																					JSON
																							.stringify(data));

																
																	$(
																			'#editform')
																			.hide();
																	$(
																			'#useredited')
																			.slideDown();

																	console
																			.log("successfully profile updated");
																	setTimeout(
																			function() {
																				window.location.href = "/profilePage";
																			},
																			3000);

																}
															},

															error : function(
																	error) {
																console
																		.log(error);
															}
														});

											});
						});
	</script>
	

</body>
</html>