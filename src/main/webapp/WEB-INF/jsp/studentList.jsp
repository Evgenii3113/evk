<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Students List</title>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>--%>
</head>
<body>

<h1>Create a Student:</h1>

<!--
         In Thymeleaf the equivalent of
         JSP's ${pageContext.request.contextPath}/edit.html
         would be @{/edit.html}
         -->

<form th:action="@{/addPerson}"
      th:th:object="${personForm}" method="POST">
    First Name:
    <input type="text" th:field="*{surname}" />
    <br/>
    Last Name:
    <input type="text" th:field="*{name}" />
    <br/>
    <input type="submit" value="Create" />
</form>

<br/>

<!-- Check if errorMessage is not null and not empty -->

<div th:if="${errorMessage}" th:utext="${errorMessage}"
     style="color:red;font-style:italic;">
    ...
</div>



<h3>STUDENTS LIST</h3>

<br/><br/>
<div>
    <table border="5">
        <tr>
            <th>Surname</th>
            <th>Name</th>
            <th>Second Name</th>
            <th>Phone Number</th>
            <th>E-mail</th>
                    </tr>
        <c:forEach  items="${student}" var ="student">
            <tr>
                <td>${student.surname}</td>
                <td>${student.name}</td>
                <td>${student.secondName}</td>
                <td>${student.phone}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>