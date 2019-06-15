<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色信息</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>备注</td>
    </tr>
    </thead>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td><c:out value="${role.id}"/></td>
            <td><c:out value="${role.roleName}"/></td>
            <td><c:out value="${role.note}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
