<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="path/to/bootstrap.min.css"> <!-- Thay đổi đường dẫn cho phù hợp -->
</head>
<body>
<div class="container">
    <h2>Đăng Nhập</h2>
    <c:if test="${not empty alert}">
        <div class="alert alert-danger">${alert}</div>
    </c:if>
    <form action="login" method="post">
        <div class="form-group">
            <label for="username">Tài khoản</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tài khoản" required>
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="remember" name="remember">
            <label class="form-check-label" for="remember">Ghi nhớ mật khẩu</label>
        </div>
        <button type="submit" class="btn btn-primary">Đăng Nhập</button>
        <a href="forgot-password.jsp" class="btn btn-link">Quên mật khẩu?</a>
        <a href="register.jsp" class="btn btn-link">Đăng ký</a>
    </form>
</div>
<script src="path/to/bootstrap.min.js"></script> <!-- Thay đổi đường dẫn cho phù hợp -->
</body>
</html>
