<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h3 class="hello-title">Create a student</h3>

<form action="/newStudent" method="POST">

        <div class="form-group">


        <div class="col-md-4">



            <span style="font-family:'Courier New', monospace; padding-right:48px";>Surname:</span>
            <input type="text" textarea class="form-control" name="surname">
        </textarea>

            <br>

            <span style="font-family:'Courier New', monospace; padding-right:77px";>Name:</span>
            <input type="text" textarea class="form-control" name="name">
            </textarea>

            <br>

            <span style="font-family:'Courier New', monospace; padding-right:10px";>Second name:</span>
            <input type="text" textarea class="form-control" name="secondName">
            </textarea>

            <br>

            <span style="font-family:'Courier New', monospace; padding-right:0px";>Phone number:</span>
            <input type="tel" textarea class="form-control" name="phone">
            </textarea>

            <br>

            <span style="font-family:'Courier New', monospace; padding-right:58px";>E-mail:</span>
            <input type="email" textarea class="form-control" name="email">
            </textarea>

            <br>

            <span style="font-family:'Courier New', monospace; padding-right:58px";>Course:</span>
            <select type="text" textarea class="form-control" name="courseName">
            <option>Select course</option>
            <option>Management</option>
            <option>Coach</option>
            <option>Developer</option>
            <option>Sports</option>
            </select>
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