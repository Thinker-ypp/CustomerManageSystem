<%--
  Created by IntelliJ IDEA.
  User: yupanpan
  Date: 2018/2/26
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/views/_taglib.jsp"%>

<html>
<head>
  <title>客户管理系统</title>
</head>
<frameset rows="13%,*">
  <frame src="${ctx }/views/_head.jsp" name="head">
  <frame src="${ctx }/views/addCustomer.jsp" name="body">
</frameset>
</html>
