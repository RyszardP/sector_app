<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of sectors</title>

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

        <!-- put new button: Add sector-->

        <input type="button" value="Add User"
               onclick="window.location.href='add-sector-form.jsp'; return false;"
               class="add-user-button"
        />

        <table>

            <tr>
                <th>Sector name</th>
                <th>Sector department id</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="tempSector" items="${SECTOR_LIST}">


                <!-- set up a link for each sector -->
                <c:url var="tempLink" value="SectorControllerServlet">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="sectorId" value="${tempSector.sectorId}"/>
                </c:url>

                <!-- set up a link to delete a sector -->
                <c:url var="deleteLink" value="SectorControllerServlet">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="sectorId" value="${tempSector.sectorId}"/>
                </c:url>

                <tr>
                    <td> ${tempSector.sectorName} </td>
                    <td> ${tempSector.sectorDepartmentId} </td>


                    <td>
                        <a href="${tempLink}">Update</a>
                    </td>
                    <td>
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this sector?'))) return false">
                            Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>
