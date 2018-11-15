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
    <h1>Create New Artist</h1>
    <c:url value="/newartist" var="regUrl"/>

    <form action="${regUrl}" method="POST">
        Artist First Name:<br/><input type="text" name="artist_firstname"><br/>
        Artist Second Name:<br/><input type="text" name="artist_secondname"><br/>
        Artist Nickname:<br/><input type="text" name="artist_nickname"><br/>

        <div class="menu-down-arrow">
            <select class="selectpicker form-control form-group" name="recordlabel">
                <option value="-1">Record Label List</option>
                <c:forEach items="${recordlabel.id}" var="recordlabel">
                    <option value="${recordlabel.id}">${recordlabel.label_name}</option>
                </c:forEach>
            </select>
        </div>
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