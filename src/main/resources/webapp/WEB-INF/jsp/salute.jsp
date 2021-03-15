<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Salut, ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2 class="hello-title">Salut, ${name}!</h2>

<form action="/translate" method="POST">
    <div class="form-group">
        <div class="col-md-4">
            <textarea class="form-control" name="textForm">
                   default text
            </textarea>
        </div>
    </div>
    <input type="submit" value="Click">
</form>

<script src="/js/main.js"></script>
</body>
</html>