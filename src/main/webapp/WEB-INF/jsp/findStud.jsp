<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h4 class="hello-title">Found student</h4>
<h5>ID : ${id}</h5>
<h5>Surname : ${surname}</h5>
<h5>Name : ${name}</h5>
<h5>Second name : ${secondName}</h5>
<h5>Phone : ${phone}</h5>
<h5>E-mail : ${email}</h5>


<script src="/js/main.js"></script>
</body>
</html>