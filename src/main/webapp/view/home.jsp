<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home - Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Welcome to the Manager Home Page</h1>
    <p>This is the landing page for managers.</p>

    <form action="/logout" method="post">
        <button type="submit" class="btn btn-danger">Logout</button>
    </form>
</div>
</body>
</html>
