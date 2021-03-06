<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of users</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Sector app</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button: Add user-->

        <input type="button" value="Add User"
               onclick="window.location.href='add-user-form.jsp'; return false;"
               class="add-user-button"
        />

        <table>

            <tr>
                <th>User name</th>
                <th>User surname</th>
                <th>User login</th>
                <th>User password</th>
                <th>User birthday</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="tempUser" items="${USER_LIST}">

                <!-- set up a link for each user -->
                <c:url var="tempLink" value="UserControllerServlet">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="userId" value="${tempUser.userId}"/>
                </c:url>

                <!-- set up a link to delete a user -->
                <c:url var="deleteLink" value="UserControllerServlet">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="userId" value="${tempUser.userId}"/>
                </c:url>


                <td> ${tempUser.userName} </td>
                <td> ${tempUser.userSurname} </td>
                <td> ${tempUser.login} </td>
                <td> ${tempUser.password} </td>
                <td> ${tempUser.birthDate} </td>

                <td>
                    <a href="${tempLink}">Update</a></td>

                <td>
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">
                        Delete</a>
                </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>
