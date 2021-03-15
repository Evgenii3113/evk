<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Student List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Second Name</th>
                    </tr>
        <c:forEach  items="${student}" var ="student">
            <tr>
                <td>${student.lastName}</td>
                <td>${student.firstName}</td>
                <td>${student.secondName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>