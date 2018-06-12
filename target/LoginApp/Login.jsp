<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

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
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
	<div>
		<h2 style="color: #39B54A" align="center">Login App</h2>
		<hr>
	</div>

	<h3 style="color: #39B54A" align="center">LOGIN</h3>

	<h4 style="color: red" align="center">${message}</h4>
	<h4 style="color: #3366ff" align="center">${register}</h4>
	<h4 style="color: red" align="center">${session}</h4>
	<h4 style="color: #3366ff" align="center">${delete}</h4>

	<c:if test="${username!=null}">
		<h3 align="center">UserName : ${username}</h3>
	</c:if>
	<c:if test="${password!=null}">
		<h3 align="center">Password : ${password}</h3>
	</c:if>

	<form action="authenticate.htm" method="post">
		<table align="center">
			<tr>
				<td align="center">Username : <input type="text"
					name="username" required>
				</td>
			</tr>
			<tr>
				<td align="center">&nbsp;Password : <input type="password"
					name="password" required>
				</td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align="center"><input type="submit" class="submit"
					value="LOGIN"></td>
			</tr>

			<tr align="right">
				<td><a href="Register.jsp">New Visitor?</a></td>
			</tr>

		</table>
	</form>

</body>
</html>



