<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>�����������</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/style.css">
</head>

<body>
<h1>����</h1>
<div id="wrapper">
    <form id="signin" method="get" action="/Lab2_OOP_war/Servlet" autocomplete="off">
        <input type="text" id="user" name="login" placeholder="�����"/>
        <input type="password" id="pass" name="password" placeholder="������">
        <%
            Integer tr = (Integer) request.getSession().getAttribute("tryAutorize");
            if (tr == null || tr < 3) {
        %>
        <button type='submit'>&#xf0da;</button>
        <% if (tr != null) {
            response.getWriter().printf("<p style='color:#FFFFFF;'>������� ����� %d</p>", tr);
        }
        } else {
            response.getWriter().println("<p style='color:#FFFFFF;'>��������� ���-�� �������</p>");
        }%>


        <p>��� ��������: <a href="${pageContext.request.contextPath}/signUp">������������������</a></p>
    </form>
</div>


</body>
</html>