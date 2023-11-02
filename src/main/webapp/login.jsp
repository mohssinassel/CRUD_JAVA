<%--
  Created by IntelliJ IDEA.
  User: mohss
  Date: 11/2/2023
  Time: 1:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' id='qasa-style-css' href='css/style.css' type='text/css' media='all' />
</head>
<body>
<div align="center">
    <h1>User Login Form</h1>
    <form action="<%= request.getContextPath() %>/login" method="post">
        <table style="with: 80%" class="form">

            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" /></td>
            </tr>


        </table>
        <input type="submit" value="Submit" />
    </form>
</div>

</body>
</html>
