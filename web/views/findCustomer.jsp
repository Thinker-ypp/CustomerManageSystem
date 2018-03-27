<%--
  Created by IntelliJ IDEA.
  User: yupanpan
  Date: 2018/3/8
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/views/_taglib.jsp" %>

<html>
<br>
<body>
<center>
    <h2>查询客户</h2>
    <br>
    <table border="1px" width="70%">
        <tr align="center">
            <td><h4>序列号</h4></td>
            <td><h4>客户名</h4></td>
            <td><h4>性别</h4></td>
            <td><h4>电话号码</h4></td>
            <td><h4>邮箱</h4></td>
            <td><h4>爱好</h4></td>
            <td><h4>类型</h4></td>
            <td><h4>描述</h4></td>
            <td><h4>操作</h4></td>
        </tr>

        <c:forEach items="${page.customers}" var="customer" varStatus="status" step="1">
            <tr align="center">
                <td>${status.index+1}</td>
                <td>${customer.name}</td>
                <td>${customer.gender}</td>
                <td>${customer.cellPhone}</td>
                <td>${customer.email}</td>
                <td>${customer.preference}</td>
                <td>${customer.type}</td>
                <td>${customer.description}</td>
                <td>
                    <a href="${ctx}/customer/updateCustomer?id=${customer.id}&currentPage=${page.currentPage}" style="text-decoration: none">修改</a> |
                    <a href="${ctx}/customer/deleteCustomer?id=${customer.id}&currentPage=${page.currentPage}"
                       style="text-decoration: none" onclick="return makeSure()">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <%-- 引入分页插件 --%>
    <%@include file="page.jsp" %>
</center>
</body>
<script type="text/javascript">

    /*删除之前进行确认*/
    function makeSure() {
        var sure = window.confirm("确定要删除该对象吗？")
        if (sure) {
            return true;
        } else {
            return false;
        }
    }
</script>


</html>
