<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

<style type="text/css">
.submit {
	background-color: #83CE8E;
	border: none;
	color: white;
	padding: 3px 3px;
	text-align: center;
	text-decoration: none;
	display: inline-table;
	font-size: 13px;
	margin: 1px 1px;
	cursor: pointer;
	font-family: proxima nova regular;
}
</style>

<script type="text/javascript">

function validate(visitor)
{
	var firstname = document.getElementById('firstname').value;
	var lastname = document.getElementById('lastname').value;
/* 	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value; */
	var phoneno = document.getElementById('phonenumber').value;
	var email = document.getElementById('email').value;
	
	var atposition=email.indexOf("@");  
	var dotposition=email.lastIndexOf("."); 
	var letters = /^[A-Za-z]+$/;
	var numbers = /^[0-9]+$/;
	var uname = /^[0-9]+$/;
		
	if(!(firstname.match(letters))){
	 	alert("FirstName should be alphabets only");
		return false;
	}

	if(!(lastname.match(letters))){
	 	alert("LastName should be alphabets only");
	 	return false;
	}
	
	/* if(!(username.match(uname))){
	 	alert("UserName should be digits only");
	 	return false;
	}
	if(password.length<8){
	 	alert("Password should be minimum 8 characters");
		return false;
	}  */
	if (!(phoneno.match(numbers))||(phoneno.length!=10)){  
		alert("PhoneNumber should be of 10 Digits");
		return false;  
	}
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
		alert("Please enter a valid e-mail address");  
		return false;  
	} 
	
  	return true;
  	
  
}
</script>

</head>
<body>

	<h2 style="color: #39B54A" align="center">Login App</h2>
	<hr>
	<h3 style="color: Green" align="center">Register</h3>

	<h4 style="color: red" align="center">${error}</h4>

	<form name="visitor" action="create.htm" method="post"
		onsubmit="return validate()">
		<table align="center">
			<tr>
				<td align="center">First Name :
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" name="firstname" id="firstname" required>
				</td>
			</tr>
			<tr>
				<td align="center">Last Name :
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" name="lastname" id="lastname" required>
				</td>
			</tr>

			<!-- <tr>
				<td align="center">Username<sup>(EmpID)</sup> : &nbsp;&nbsp;<input
					type="text" name="username" id="username" required>
				</td>
			</tr>
			<tr>
				<td align="center">Password :
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="password" name="password" id="password" required>
				</td>
			</tr> -->
			<tr>
				<td align="center">Mobile Number :&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" name="mobile" id="phonenumber" required>
				</td>
			</tr>
			<tr>
				<td align="center">Email Id :
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="emailId" id="email" required>
				</td>
			</tr>
			<tr id="timer">
				<td align="center">DOB :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="dob" required>
				</td>
			</tr>
			<tr>
				<td>Sex
					:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="M" required>Male <input
					type="radio" name="sex" value="F" required>Female
				</td>
			</tr>
			<tr>
				<!-- <td>Is Admin?? :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="isAdmin"
					value="1" required>yes <input type="radio" name="isAdmin"
					value="0" required>no
				</td> -->
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td><input type="submit" class="submit" value="SignUp">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>