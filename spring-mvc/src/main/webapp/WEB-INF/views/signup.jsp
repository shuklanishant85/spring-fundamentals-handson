<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/resources/styles/modules.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="">
	<form action="signup" method="post" class="form-builder-style"
		class="bg-text">
		<fieldset>
			<legend>SIGN UP</legend>
			<div class="inner-table">
				<table>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>First Name:</td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td>Age:</td>
						<td><input type="text" name="age" /></td>
					</tr>
					<tr />
					<tr />
					<tr>
						<td colspan="2"><input type="submit" name="submit" /></td>
					</tr>
					
				</table>
			</div>
		</fieldset>
	</form>
</body>
</html>