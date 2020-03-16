<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Sector</title>

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
    <h3>Add User</h3>

    <form action="SectorControllerServlet" method="GET">

        <input type="hidden" name="command" value="ADD" />

        <table>
            <tbody>
            <tr>
                <td><label>Sector name</label></td>
                <td><input type="text" name="sectorName" /></td>
            </tr>

            <tr>
                <td><label>Sector department</label></td>
                <td><input type="text" name="sectorDepartmentId" /></td>
            </tr>


            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="SectorControllerServlet">Back to Sector List</a>
    </p>
</div>
</body>
</html>
