<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>RoleForm</title>
</head>
<body>
<%--${pageContext.request.contextPath}/role/addRole6--%>
<form action="addRole6" id="form" method="post">
    <table>
        <tr>
            <td>名称</td>
            <td><input id="roleName" name="roleName" value=""/></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input id="note" name="note" value=""/></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input id="commit" type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
