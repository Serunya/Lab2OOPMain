<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>�����������</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<h1>�����������</h1>
<div id="wrapper">
    <form id="signin" method="post" action="/Lab2_OOP_war/Servlet" autocomplete="off">
    <input type="text" id="user" name="login" placeholder="�����"/>
        <input type="password" id="pass" name="password" placeholder="������" />
        <input type="password" id="�pass" name="confrimPassword" placeholder="����������� ������" />
        <button type="submit">&#xf0da;</button>
        <p>���� �������: <a href="${pageContext.request.contextPath}/login">�����</a></p>
    </form>
</div>


</body>
</html>