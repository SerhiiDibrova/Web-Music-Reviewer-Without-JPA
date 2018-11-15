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
    <h1>Record Label List</h1>

    <c:if test="${!empty recordLabelList}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Record Label List</th>
                <th width="120">Contry</th>
            </tr>
            <c:forEach items="${recordLabelList}" var="recordlabel">
                <tr>
                    <td><a href="/newlabel/${recordlabel.id}" target="_blank">${recordlabel.id}</a></td>
                    <td>${recordlabel.label_name}</td>
                    <td>${recordlabel.label_country}</td>
                    <td><a href="<c:url value='label/remove/${recordlabel.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div>
        <a href="newartist">New Artist</a>
    </div>
    <div>
        <a href="newlabel">New Record Label</a>
    </div>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>