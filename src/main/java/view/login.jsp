<form action="login" method="post">
    <h2>Tạo tài khoản mới</h2>
    <c:if test="${not empty alert}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    <section>
        <div class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
            </div>
        </div>
    </section>
</form>
