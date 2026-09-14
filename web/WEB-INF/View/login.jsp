<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ĐĂNG NHẬP ADMIN</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f4f6f9; height: 100vh; display: flex; align-items: center; justify-content: center; }
        .card-login { width: 100%; max-width: 400px; border-radius: 10px; border: none; }
    </style>
</head>
<body>

<div class="card card-login shadow-sm p-4">
    <h4 class="text-center fw-bold text-danger mb-4">ĐĂNG NHẬP QUẢN TRỊ</h4>
    
    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null) { %>
        <div class="alert alert-danger text-center p-2"><%= msg %></div>
    <% } %>

    <form action="<%= request.getContextPath() %>/LoginController" method="POST">
        <div class="mb-3">
            <label class="form-label fw-bold">Tên đăng nhập</label>
            <input type="text" name="username" class="form-control" required placeholder="Nhập username">
        </div>
        <div class="mb-3">
            <label class="form-label fw-bold">Mật khẩu</label>
            <input type="password" name="password" class="form-control" required placeholder="Nhập password">
        </div>
        <button type="submit" class="btn btn-danger w-100 fw-bold">Đăng Nhập</button>
    </form>
</div>

</body>
</html>