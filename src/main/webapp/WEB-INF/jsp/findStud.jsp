<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h3 class="hello-title">Find student</h3>


<table border="5">
    <tr>
        <th>ID</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Second Name</th>
        <th>Phone Number</th>
        <th>E-mail</th>

    </tr>
    <c:forEach  items="${student}" var ="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.secondName}</td>
            <td>${student.phone}</td>
            <td>${student.email}</td>


        </tr>
    </c:forEach>
</table>

<script src="/js/main.js"></script>
</body>
</html>