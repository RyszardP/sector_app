<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>User registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="user">
    First name: <form:input path="userName"/>


    <br>
    Last name: <form:input path="userSurname"/>

    <br>

    <input type="submit" value="Submit" />

</form:form>

</body>
</html>
