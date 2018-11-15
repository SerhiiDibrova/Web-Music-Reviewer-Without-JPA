<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>webmusicreviewer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div align="center">
        <c:url value="/j_spring_security_check" var="loginUrl" />

        <form action="${loginUrl}" method="POST">
            Login:<br/><input type="text" name="j_login"><br/>
            Password:<br/><input type="password" name="j_password"><br/>

            <input type="submit" name="Submit"/>

            <p><a href="/register">Register new user</a></p>

            <c:if test="${param.error ne null}">
                <p>Wrong login or password!</p>
            </c:if>

            <c:if test="${param.logout ne null}">
                <p>Chao!</p>
            </c:if>
        </form>
    </div>
    <script>
        $('.selectpicker').selectpicker();
    </script>
</body>
</html>
