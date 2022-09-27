<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<h1>Регистрация</h1>
<div id="wrapper">
    <form id="signin" method="post" action="/Lab2_OOP_war/Servlet" autocomplete="off">
    <input type="text" id="user" name="login" placeholder="Логин"/>
        <input type="password" id="pass" name="password" placeholder="Пароль" />
        <input type="password" id="сpass" name="confrimPassword" placeholder="Подтвердите пароль" />
        <button type="submit">&#xf0da;</button>
        <p>Есть аккаунт: <a href="${pageContext.request.contextPath}/login">Войти</a></p>
    </form>
</div>


</body>
</html>