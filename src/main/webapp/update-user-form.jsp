<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update user</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-user-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>FooBar University</h2>
    </div>
</div>

<div id="container">
    <h3>Update User</h3>

    <form action="UserControllerServlet" method="GET">

        <input type="hidden" name="command" value="UPDATE" />

        <input type="hidden" name="userId" value="${THE_USER.userId}" />

        <table>
            <tbody>
            <tr>
                <td><label>User name:</label></td>
                <td><input type="text" name="userName"
                           value="${THE_USER.userName}" /></td>
            </tr>

            <tr>
                <td><label>User surname:</label></td>
                <td><input type="text" name="userSurname"
                           value="${THE_USER.userSurname}" /></td>
            </tr>

            <tr>
                <td><label>login</label></td>
                <td><input type="text" name="login"
                           value="${THE_USER.login}" /></td>
            </tr>

            <tr>
                <td><label>password</label></td>
                <td><input type="text" name="password"
                           value="${THE_USER.password}" /></td>
            </tr>

            <tr>
                <td><label>birthday</label></td>
                <td><input type="text" name="birthDate"
                           value="${THE_USER.birthDate}" /></td>
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
        <a href="UserControllerServlet">Back to List</a>
    </p>
</div>

</body>
</html>
