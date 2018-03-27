<%--
  Created by IntelliJ IDEA.
  User: yupanpan
  Date: 2018/3/8
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/_taglib.jsp"%>
<html>
<head>
    <center><h1>欢迎来到客户管理系统</h1></center><br>
    <center>
        <a href="${ctx}/customer/addCustomer" target="body">添加客户</a>&nbsp;&nbsp;&nbsp;
        <a href="${ctx}/customer/findCustomer" target="body">查看客户</a>
    </center>
</head>
</html>
