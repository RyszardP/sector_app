<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title>Add user</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Sector App</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add User</h3>
		
		<form action="UserControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>User name</label></td>
						<td><input type="text" name="userName" /></td>
					</tr>

					<tr>
						<td><label>User surname</label></td>
						<td><input type="text" name="userSurname" /></td>
					</tr>

					<tr>
						<td><label>User login</label></td>
						<td><input type="text" name="login" /></td>
					</tr>

					<tr>
						<td><label>User password</label></td>
						<td><input type="text" name="password" /></td>
					</tr>

					<tr>
						<td><label>User birthday</label></td>
						<td><input type="text" name="birthDate" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="UserControllerServlet">Back to User List</a>
		</p>
	</div>
</body>

</html>











