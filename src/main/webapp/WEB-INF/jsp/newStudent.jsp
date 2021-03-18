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
            <textarea class="form-control" name="surname">
                   Surname
            </textarea>
            <textarea class="form-control" name="name">
                   Name
            </textarea>
            <textarea class="form-control" name="secondName">
                   Second name
            </textarea>
            <textarea class="form-control" name="phone">
                   Phone number
            </textarea>
            <textarea class="form-control" name="email">
                   E-mail
            </textarea>
        </div>
    </div>
    <br>
    <input type="submit" value="Create">
</form>

<script src="/js/main.js"></script>
</body>
</html>