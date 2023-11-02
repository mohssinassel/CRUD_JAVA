<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <link rel='stylesheet' id='qasa-style-css' href='css/style.css' type='text/css' media='all' />
</head>
<body>


        <div align="center">
            <h1>User Register Form</h1>
            <form action="<%= request.getContextPath() %>/register" method="post">
                <table style="with: 80%" class="form">

                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td> &nbsp;&nbsp;&nbsp;Mobile    :</td>
                        <td><input type="text" name="mobile" /></td>
                    </tr>

                </table>
                <input type="submit" value="Submit" />
            </form>
        </div>


</body>
</html>
