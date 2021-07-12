<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="$1">


<title>Registration Page</title>
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

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/resources/css/style.css">

<style type="text/css">
#form {
	margin: 2% auto;
}

.bgBox .inputRow select, dropdown {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
	overflow: auto;
	height: 46px;
}

.bgBox .radiobutton {
	padding: 6px 0;
	margin-bottom: 4px;
}

.group label {
	font-size: 16px;
}

<!-------------------------------------scrool button and footer------------------------------ -->
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

#userregister {
	font-size: 16px;
	color: #155724;
	text-align: center;
	width: 1200px;
	height: 50px;
	position: relative;
	margin: 2% auto;
	background: #d4edda;
	border-color: #c3e6cb;
}

#userfail {
	font-size: 16px;
	color: #721c24;
	text-align: center;
	width: 1200px;
	height: 50px;
	position: relative;
	margin: 2% auto;
	background: #f8d7da;
	border-color: #f5c6cb;
}
</style>

<script type="text/javascript">
$(document).ready(function() {

<!--------------------- ----------------user validation check------------------------------ -->
$('#usercheck').hide();
$('#passcheck').hide();
$('#conpasscheck').hide();
$('#firstnamecheck').hide();
$('#lastnamecheck').hide();
$('#phonenumcheck').hide();
$('#addresscheck').hide();

var user_err = true;
var pass_err = true;
var conpass_err = true;
var firstname_err = true;
var lastname_err = true;
var phonenum_err = true;
var address_err = true;

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
user_err = false;
return false;
} else {
$('#usercheck').hide();
document.getElementById('sign_in').disabled = false;
}
if (!regex.test(username)) {
$('#usercheck').show();
$('#usercheck').html(
"** username format: abc@xyz.com");
$('#usercheck').focus();
$('#usercheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
user_err = false;
return false;
} else {
$('#usercheck').hide();
document.getElementById('sign_in').disabled = false;
}

}
//--------------------------------------password check -------------------------------------------------------
$('#password').keyup(function() {
password_check();
});

function password_check() {
var password = $('#password').val();
var pattern = /^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/;
if (password == '') {
$('#passcheck').show();
$('#passcheck').html(
"**Please Fill the password");
$('#passcheck').focus();
$('#passcheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
pass_err = false;
return false;
} else {
$('#passcheck').hide();
document.getElementById('sign_in').disabled = false;
}
if (!pattern.test(password)) {
$('#passcheck').show();
$('#passcheck')
.html(
"**Password Must be at least 8 characters length which include 1 number, 1 lowercase, 1 uppercase letter, 1 Special Character ");
$('#passcheck').focus();
$('#passcheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
pass_err = false;
return false;
} else {
$('#passcheck').hide();
document.getElementById('sign_in').disabled = false;
}
}
//--------------------------------------confirm password check -------------------------------------------------------
$('#ConfirmPassword').keyup(function() {
conpassword_check();
});

function conpassword_check() {
var password = $('#password').val();
var confirmpassword = $('#ConfirmPassword').val();

if (password != confirmpassword) {
$('#conpasscheck').show();
$('#conpasscheck').html(
"**Password not Matching ");
$('#conpasscheck').focus();
$('#conpasscheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
conpass_err = false;
return false;
} else {
$('#conpasscheck').hide();
document.getElementById('sign_in').disabled = false;
}

}
//---------------------------------firstname check -------------------------------------------------------

$('#firstname').keyup(function() {
firstname_check();
});

function firstname_check() {
var firstname = $('#firstname').val();
var regName = /^[a-zA-Z]+$/;
if (firstname == '') {
$('#firstnamecheck').show();
$('#firstnamecheck').html(
"**Please Fill the firstname");
$('#firstnamecheck').focus();
$('#firstnamecheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
firstname_err = false;
return false;
} else {
$('#firstnamecheck').hide();
document.getElementById('sign_in').disabled = false;
}
if (!regName.test(firstname)) {
$('#firstnamecheck').show();
$('#firstnamecheck')
.html(
"**Please fill the firstname with correct ");
$('#firstnamecheck').focus();
$('#firstnamecheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
firstname_err = false;
return false;
} else {
$('#firstnamecheck').hide();
document.getElementById('sign_in').disabled = false;
}
}
//---------------------------------lastname check -------------------------------------------------------

$('#lastname').keyup(function() {
lastname_check();
});

function lastname_check() {
var lastname = $('#lastname').val();
var regName = /^[a-zA-Z]+$/;
if (lastname == '') {
$('#lastnamecheck').show();
$('#lastnamecheck').html(
"**Please Fill the lastname");
$('#lastnamecheck').focus();
$('#lastnamecheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
lastname_err = false;
return false;
} else {
$('#lastnamecheck').hide();
document.getElementById('sign_in').disabled = false;
}

if (!regName.test(lastname)) {
$('#lastnamecheck').show();
$('#lastnamecheck')
.html(
"**Please Fill the lastname correctly ");
$('#lastnamecheck').focus();
$('#lastnamecheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
lastname_err = false;
return false;
} else {
$('#lastnamecheck').hide();
document.getElementById('sign_in').disabled = false;
}
}

$('#phonenum').keyup(function() {
phonenum_check();
});
function phonenum_check() {
var phonenum = $('#phonenum').val();
var regex = /^\d{10}$/;
if (!regex.test(phonenum) || phonenum == '') {
$('#phonenumcheck').show();
$('#phonenumcheck').html(
"**Please Fill the phone correctly ");
$('#phonenumcheck').focus();
$('#phonenumcheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
phonenum_err = false;
return false;
} else {
$('#phonenumcheck').hide();
document.getElementById('sign_in').disabled = false;
}
}

$('#address').keyup(function() {
address_check();
});
function address_check() {
var address = $('#address').val();
if (address == '') {
$('#addresscheck').show();
$('#addresscheck').html(
"**Please Fill the field ")
$('#addresscheck').css("color", "red");
document.getElementById('sign_in').disabled = true;
address_err = false;
return false;
} else {
$('#addresscheck').hide();
document.getElementById('sign_in').disabled = false;
}
}
<!--------------------- ----------------callback function------------------------------ -->
$('#sign_in').click(function() {



var username = $('#email').val();
var password = $('#password').val();
var confirmpassword = $(
'#ConfirmPassword').val();
var firstname = $('#firstname')
.val();
var lastname = $('#lastname').val();
var phonenum = $('#phonenum').val();
var address = $('#address').val();
var dob = $('#dob').val();
var gender = $('#gender').val();
if (username == ''
|| password == ''
|| confirmpassword == ''
|| firstname == ''
|| lastname == ''
|| phonenum == ''
|| address == ''
|| security_id =='0'
|| security_answer =='') {
document.getElementById('sign_in').disabled = true;
return false;
}

var today = new Date();
var date = today.getDate() + '-'
+ (today.getMonth() + 1)
+ '-' + today.getFullYear();
var time = today.getHours() + ":"
+ today.getMinutes() + ":"
+ today.getSeconds();
var dateTime = date + ' ' + time;

var data = {
username : $('#email').val(),
password : $('#password').val(),
confirm_password : $(
'#confirm_password')
.val(),
firstname : $('#firstname')
.val(),
lastname : $('#lastname').val(),
dob : $('#dob').val(),
gender : $("input[type='radio'][name='customRadioInline']:checked").val(),
phonenum : $('#phonenum').val(),
address : $('#address').val(),
security_id : $('#security_id').val(),
security_answer : $('#security_answer').val(),
created_on : dateTime
};


<!--------------------- ----------------ajax-------------------------------->
$.ajax({
type : "POST",
url : "/newregistration",
contentType : "application/json", // NOT dataType!
data : JSON.stringify(data),
statusCode : {
409 : function() {
alert("Registration Failed");
$('#form').hide();
$('#userfail').slideDown();

setTimeout(function()
		{
	window.location.href = "/registersuccess" },3000);
},
200: function(){
localStorage.clear();
localStorage.setItem('data',JSON.stringify(data));


$('#form').hide();
$('#userregister').slideDown();

console.log("User Registered successfully");
setTimeout(function()
		{ 
	window.location.href = "/registersuccess" }, 3000);
}

},

error : function(error) {
console.log(error);
}
});
});
});
</script>

</head>
<body>

	<!-- ----------------header-------------- -->

	<nav class="navbar navbar-dark navbar-expand-md"
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
			<ul class="nav navbar-nav mr-auto">
		
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item active"><a class="nav-link"
					href="/login"><i class="fa fa-sign-in" aria-hidden="true"></i>
						Login</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- ----------------------------form------------------------------ -->
	<div id="content">
		<!-- scrool button id -->

		<div id="form">
			<form>
				<div class="bgBox ">
					<h2>Register</h2>
					<div class="inputRow">
						<label for="email">Username :</label> <input type="email"
							name="login" id="email" placeholder="Enter your email" value=""
							autofocus> <small id="usercheck"></small>
					</div>

					<div class="inputRow">
						<label for="password">Password :</label> <input type="password"
							name="password" id="password" value=""
							placeholder="Enter your password"> <small id="passcheck"></small>
					</div>

					<div class="inputRow">
						<label for="ConfirmPassword">Confirm Password :</label> <input
							type="password" name="password" id="ConfirmPassword" value=""
							placeholder="ConfirmPassword"> <small id="conpasscheck"></small>
					</div>

					<div class="inputRow">
						<label for="firstname">First Name :</label> <input type="text"
							name="firstname" id="firstname" placeholder="Enter firstname"
							id="firstname"> <small id='firstnamecheck'></small>
					</div>

					<div class="inputRow">
						<label for="lastname">Last Name :</label> <input type="text"
							name="lastname" placeholder="Enter lastname" id="lastname">
						<small id='lastnamecheck'></small>
					</div>

					<div class="inputRow">
						<label for="dob">Date-of-Birth :</label> <input type="date"
							name="dob" placeholder="Enter Date_of_birth" id="dob">
					</div>

					<div class="radiobutton">
						<label for="gender">Gender : </label>
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
					</div>

					<div class="inputRow">
						<label for="phonenum">Phone Number :</label> <input type="tel"
							name="phonenum" placeholder="Enter phonenum" id="phonenum">
						<small id='phonenumcheck'></small>
					</div>

					<div class="inputRow">
						<label for="address">Address :</label>
						<textarea name="address" placeholder="Enter Address" id="address"
							style="height: 45px"></textarea>
						<small id='addresscheck'><small>
					</div>

					<div class="inputRow">
						<div class="group ">
							<div class="dropdown">
								<label for="security_id">Security Question :</label> <select
									class="combobox input-large form-control" name="security_id"
									id="security_id">
									<option value="0">Select security question?</option>
									<option value="1">What is your pet name?</option>
									<option value="2">Which city were you born?</option>
									<option value="3">Favorite place to vacation?</option>
									<option value="4">What is your school name?</option>
									<option value="5">What is your nick name?</option>
								</select>
							</div>
						</div>
					</div>

					<div class="inputRow">
						<div class="group">
							<label for="security_answer">Security Answer :</label> <input
								type="text" name="security_answer"
								placeholder="Enter Your Security Answer" id="security_answer">
							<small id='addresscheck'><small>
						</div>
					</div>

					<div class="inputRow submit ">
						<input type="button" value="Register" class="signIn" id="sign_in">


					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="container" id="statusDiv">
		<div class="alert alert-success " id="userregister" role="alert"
			style="display: none;">
			<strong>Registered Successfully!</strong>
		</div>
		<div class="alert alert-danger alert-dismissible" id="userfail"
			role="alert" style="display: none;">
			<strong>Registration Failed!</strong>
		</div>
	</div>


</body>
</html>