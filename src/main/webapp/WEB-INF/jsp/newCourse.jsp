<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h3 class="hello-title">Create a course</h3>

<form action="/newCourse" method="POST">

        <div class="form-group">


        <div class="col-md-4">

            <span style="font-family:'Courier New', monospace; padding-right:0px";>Course name:</span>
            <input type="text" textarea class="form-control" name="courseName">
            </textarea>

            <br>

            <span style="font-family:'Courier New', monospace; padding-right:10px";>Start date:</span>
            <input type="text" textarea class="form-control" name="startDate">
            </textarea>

            <br>


    </div>
        </div>
    <br>
    <input type="submit" value="Create">

</form>

<script src="/js/main.js"></script>
</body>
</html>