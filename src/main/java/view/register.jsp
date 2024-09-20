<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký Tài Khoản</title>
    <link rel="stylesheet" href="path/to/bootstrap.min.css"> <!-- Cập nhật đường dẫn -->
    <link rel="stylesheet" href="path/to/font-awesome.min.css"> <!-- Cập nhật đường dẫn -->
</head>
<body>
<div class="container">
    <h2>Tạo Tài Khoản Mới</h2>
    <c:if test="${not empty alert}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    <form action="register" method="post">
        <section>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" placeholder="Xác nhận mật khẩu" name="confirmPassword" class="form-control" required>
                </div>
            </div>
        </section>
        <button type="submit" class="btn btn-primary">Đăng Ký</button>
        <a href="login.jsp" class="btn btn-link">Đã có tài khoản? Đăng nhập</a>
    </form>
</div>
