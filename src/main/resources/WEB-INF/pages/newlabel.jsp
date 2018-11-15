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
    <h1>Create New Record Label</h1>
    <c:url value="/newlabel" var="regUrl"/>

    <form action="${regUrl}" method="POST">
        Record Label Name:<br/><input type="text" name="label_name"><br/>
        Record Label Country:<br/><input type="text" name="label_country"><br/>

        <input type="submit"/>

        <c:if test="${exists ne null}">
            <p>Artist already exists!</p>
        </c:if>
    </form>

    <div>
        <a href="artist_list">Artist List</a>
    </div>
    <div>
        <a href="recordlabel_list">Record Label List</a>
    </div>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>