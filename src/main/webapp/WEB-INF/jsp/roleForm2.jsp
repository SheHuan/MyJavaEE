<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RoleForm2</title>
    <%--<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            // $("#commit").click(function () {
            //     var data = {
            //         id: 1,
            //         roleName: $("#roleName").val(),
            //         note: $("#note").val()
            //     }
            //
            //     $.post({
            //         url: "./jsonParams",
            //         contentType: "application/json",
            //         data: JSON.stringify(data),
            //         success: function (result) {
            //             alert("名称：" + result.roleName + "\n" + "备注：" + result.note)
            //         }
            //     });
            // });

            // $("#commit").click(function () {
            //     var data = [
            //         {
            //             id: 1,
            //             roleName: $("#roleName").val(),
            //             note: $("#note").val()
            //         }
            //     ]
            //
            //     $.post({
            //         url: "./jsonParams2",
            //         contentType: "application/json",
            //         data: JSON.stringify(data),
            //         success: function (result) {
            //             alert("名称：" + result.roleName + "\n" + "备注：" + result.note)
            //         }
            //     });
            // });

            $("#commit").click(function () {
                //提交表单
                var data = $("form").serialize();
                $.post({
                    url: "./serializeParams",
                    data: data,
                    success: function (result) {
                        var s =  $.parseJSON(result);
                        alert("名称：" + s.roleName + "\n" + "备注：" + s.note);
                    }
                });
            });
        });
    </script>
</head>
<body>
<form id="form">
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
            <td align="right"><input id="commit" type="button" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
