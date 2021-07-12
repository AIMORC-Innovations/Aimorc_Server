<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>forgot password</title>
<style type="text/css">

<!--------------------- ----------------scrool bar and footer------------------------------ -->

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

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="$1">



<link rel="stylesheet" type="text/css" href="/resources/css/style.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<!--------------------- ----------------Login eye button icon style------------------------------ -->

<script type="text/javascript">

	$(document).ready(function() {	
		
		
		<!--------------------- ----------------user validation check------------------------------ -->
	$('#usercheck').hide();
						$('#passcheck').hide();

						var user_err = true;
						var pass_err = true;

						$('#email').keyup(function() {
							email_check();
						});

						function email_check() {
							var username = $('#email').val();
							var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
							if (username == '') {
								$('#usercheck').show();
								$('#usercheck').html(
										"**Please Fill the username");
								$('#usercheck').focus();
								$('#usercheck').css("color", "red");
								document.getElementById('sign_in').disabled = true;
								$('#sign_in').css("background", "grey");
								user_err = false;
								return false;
							} else {
								$('#usercheck').hide();
								document.getElementById('sign_in').disabled = false;
								$('#sign_in').css("background", "blue");
							}
							if (!regex.test(username)) {
								$('#usercheck').show();
								$('#usercheck').html(
										"** username format: abc@xyz.com");
								$('#usercheck').focus();
								$('#usercheck').css("color", "red");
								document.getElementById('sign_in').disabled = true;
								$('#sign_in').css("background", "grey");
								user_err = false;
								return false;
							} else {
								$('#usercheck').hide();
								document.getElementById('sign_in').disabled = false;
								$('#sign_in').css("background", "blue");
							}

						}

	<!--------------------- ----------------login on click------------------------------ -->
						$('#sign_in').click(
										function() {
											
											var username = $('#email').val();
											if ( security_id == '0'
													|| security_answer == '') {
												document.getElementById('sign_in').disabled = true;
												
												$('#sign_in').css(
														"background", "grey");
												return false;
											}

											var data = {
												security_id : $('#security_id').val(),
												security_answer : $('#security_answer').val()
											};
											
										
			<!--------------------- ----------------callback function------------------------------ -->									
											$.ajax({
														type : "POST",
														url : "/getSecurityIdAndAns",
														contentType : "application/json", // NOT dataType!
														data : JSON.stringify(data),
														statusCode : {
															400 : function() {
																$('#securitynomatch').slideDown();
																$(".alert").fadeTo(2000, 500).slideUp(500, function(){
															    $(".alert").slideUp(500);
															}); 
															}
														},
														success : function(responseText) {
															window.location.href = "/loginChangePassword";
														}

													});
										});
					});
</script>
</head>
<body data-spy="scroll">
<!--------------------- ----------------header------------------------------ -->
	<nav class="navbar navbar-dark navbar-expand-md mb-3" 
		style="background-color:#004d80;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">AIMORC Innovations </a>
		</div>
		<button data-toggle="collapse" data-target="#navbarToggler"
			type="button" class="navbar-toggler">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarToggler">
			<ul class="nav navbar-nav  mr-auto">
				<li class="nav-item active"><a class="nav-link"
						href="/home"> Home</a></li>
				</ul>
			<a class="navbar-brand" href="#">Welcome ${username}</a>
			<ul class="nav navbar-nav navbar-right" >
				<div class="dropdown " >
  				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" 
  				aria-haspopup="true" aria-expanded="false "><i class="fa fa-user" aria-hidden="true" style="padding:5px;"></i> Account
  				</button>
 				 <div class="dropdown-menu dropdown-menu-right"  id="dropdown-item" >
  				  <a class="dropdown-item "  id="text" href="profile.jsp"><i class="fa fa-user" aria-hidden="true" style="padding:5px;"></i> Profile</a> <a class="dropdown-item " id="text" href="logoutServlet"><i
							class="fa fa-sign-out" aria-hidden="true" style="padding: 5px;"></i>
							Logout</a>
					</div>
					</div>
				
			</ul>
		</div>
		</div>
	</nav>

 <!--------------------- ----------------form------------------------------ -->

	<form>
		<div class="bgBox  ">
			<h2>Security Question</h2>

				<div class="inputRow">
						 <label for="security_id">Enter Security Question :</label>
						  <select name="security_id" id="security_id">
							<option value="0">Select Security Question?</option>
							<option value="1">What is your pet name?</option>
							<option value="2">Which city were you born?</option>
							<option value="3">Favorite place to vacation?</option>
							<option value="4">What is your school name?</option>
							<option value="5">What is your nick name?</option>
						</select>
					</div> 

					 <div class="inputRow">
						<label for="security_answer">Enter Security Answer :</label> 
						 <input type="text" name="security_answer" placeholder="Enter Your Security Answer" 
						 id="security_answer">
					</div> 
			

			<div class="inputRow submit">
				<input type="button" value="Submit" class="signIn" id="sign_in">
			</div>

			<div class="alert alert-danger alert-dismissible"
				id="securitynomatch" role="alert" style="display: none;">
				<strong>Invalid Authenication !</strong>
			</div>

		</div>
		</div>
	</form>
	


</body>
</html>