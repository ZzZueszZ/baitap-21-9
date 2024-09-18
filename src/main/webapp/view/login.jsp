<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="path/to/bootstrap.min.css"> <!-- Thay đổi đường dẫn cho phù hợp -->
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Chiều cao toàn màn hình */
            margin: 0; /* Bỏ margin mặc định */
        }
        .container {
            max-width: 400px; /* Đặt chiều rộng tối đa cho container */
            width: 100%; /* Đảm bảo container chiếm toàn bộ chiều rộng */
            padding: 20px; /* Khoảng cách trong container */
            background-color: white; /* Màu nền trắng cho form */
            border-radius: 10px; /* Bo góc cho container */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng cho container */
        }
        .form-group {
            display: flex;
            flex-direction: column; /* Xếp dọc các trường nhập */
            margin-bottom: 15px; /* Khoảng cách giữa các trường */
        }
        .form-control {
            height: 50px; /* Chiều cao của các trường nhập */
            font-size: 18px; /* Kích thước chữ trong các trường nhập */
        }
        .btn {
            font-size: 18px; /* Kích thước chữ cho nút */
            padding: 10px 20px; /* Khoảng cách bên trong nút */
            width: 100%; /* Chiếm toàn bộ chiều rộng */
            margin-top: 10px; /* Khoảng cách phía trên nút */
        }
        h2 {
            text-align: center; /* Canh giữa tiêu đề */
        }
    </style>
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
        <a href="/forgot-password" class="btn btn-link">Quên mật khẩu?</a>
        <a href="/register" class="btn btn-link">Đăng ký</a>
    </form>
</div>
<script src="path/to/bootstrap.min.js"></script> <!-- Thay đổi đường dẫn cho phù hợp -->
</body>
</html>
