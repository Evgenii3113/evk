<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <title>New Student</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>
</head>
<body>
<h1>Create a Student:</h1>

<!--
         In Thymeleaf the equivalent of
         JSP's ${pageContext.request.contextPath}/edit.html
         would be @{/edit.html}
         -->

<form th:action="@{/newStudent}"
      th:object="${studentForm}" method="POST">
    Surname:
    <input type="text" th:field="*{studentSurname}" />
    <br/>
    Name:
    <input type="text" th:field="*{studentName}" />
    <br/>
    Second Name:
    <input type="text" th:field="*{studentSecondName}" />
    <br/>
    Phone number:
    <input type="text" th:field="*{studentPhone}" />
    <br/>
    E-mail:
    <input type="text" th:field="*{studentEmail}" />
    <br/>
    Course:
    <input type="text" th:field="*{studentCourse}" />
    <br/>
    Start Date:
    <input type="text" th:field="*{courseStartDate}" />
    <br/>
    <br/>
    <br/>

    <input type="submit" value="Create" />
</form>

<br/>

<!-- Check if errorMessage is not null and not empty -->

<div th:if="${errorMessage}" th:utext="${errorMessage}"
     style="color:red;font-style:italic;">
    ...
</div>

</body>
</html>