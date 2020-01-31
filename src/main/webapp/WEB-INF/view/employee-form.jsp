<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Employee form</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>

<i>Fill out of the form. Asterisk (*) means requires

<br><br>


<form:form action="processForm" modelAttribute="employee">

    First name(*): <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
    <br><br>

    Last name(*): <form:input path="surname"/>
    <form:errors path="surname" cssClass="error"/>

    <br><br>

    <input type="submit" value="Submit" />
</form:form>

</body>
</html>
