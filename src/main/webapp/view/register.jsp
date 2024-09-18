<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký Tài Khoản</title>
    <link rel="stylesheet" href="path/to/bootstrap.min.css"> <!-- Cập nhật đường dẫn -->
    <link rel="stylesheet" href="path/to/font-awesome.min.css"> <!-- Cập nhật đường dẫn -->
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
            max-width: 600px; /* Đặt chiều rộng tối đa cho container */
            width: 100%; /* Đảm bảo container chiếm toàn bộ chiều rộng */
            padding: 20px; /* Khoảng cách trong container */
            background-color: white; /* Màu nền trắng cho form */
            border-radius: 10px; /* Bo góc cho container */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng cho container */
        }
        .form-group {
            display: flex;
            justify-content: center; /* Căn giữa các input */
            margin-bottom: 15px; /* Khoảng cách giữa các trường */
        }
        .form-control {
            width: 100%; /* Chiếm toàn bộ chiều rộng của form-group */
            max-width: 400px; /* Đặt chiều rộng tối đa cho input */
            height: 50px; /* Chiều cao của các trường nhập */
            font-size: 18px; /* Kích thước chữ trong các trường nhập */
        }
        .input-group-addon {
            width: 50px; /* Chiều rộng của biểu tượng */
            text-align: center; /* Canh giữa biểu tượng */
        }
        .btn {
            font-size: 18px; /* Kích thước chữ cho nút */
            padding: 10px 20px; /* Khoảng cách bên trong nút */
            width: 100%; /* Chiếm toàn bộ chiều rộng */
        }
        h2 {
            text-align: center; /* Canh giữa tiêu đề */
        }
    </style>
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
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <input type="email" placeholder="Email" name="email" class="form-control" required>
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
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                    <input type="text" placeholder="Số điện thoại" name="phone" class="form-control" required>
                </div>
            </div>
        </section>
        <button type="submit" class="btn btn-primary">Đăng Ký</button>
        <a href="/login" class="btn btn-link">Đã có tài khoản? Đăng nhập</a>
    </form>
</div>
<script src="path/to/bootstrap.min.js"></script> <!-- Cập nhật đường dẫn -->
</body>
</html>
