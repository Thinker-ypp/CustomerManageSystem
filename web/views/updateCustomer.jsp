<%--
  Created by IntelliJ IDEA.
  User: yupanpan
  Date: 2018/3/12
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/views/_taglib.jsp" %>
<html>
<script type="text/javascript" src="/static/js/customer.js"></script>
<br>
<br>
<body>
<form action="${ctx}/customer/changeCustomer?id=${customer.id}"
      method="post" id="form" onsubmit="return makeForm()">
    <center>
        <h2>更改客户信息</h2>
        <table border="1px" width="72%">
            <tr>
                <input type="hidden" name="currentPage" value="${currentPage}">
                <td>用户名：</td>
                <td><input type="text" value="${customer.name}" name="name"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="gender" value="男" ${customer.gender == '男'?'checked':''}>男
                    <input type="radio" name="gender" value="女" ${customer.gender == '女'?'checked':''}>女
                </td>
            </tr>
            <%-- <tr>
               <td>生日：</td>
               <td>
                 <select id="year"></select>
                 <select id="month" onchange="makeDay()"></select>
                 <select id="day"></select>
               </td>
             </tr>--%>
            <tr>
                <td>电话号码:</td>
                <td><input type="text" name="cellPhone" value="${customer.cellPhone}"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="email" value="${customer.email}"></td>
            </tr>
            <tr>
                <td>爱好：</td>
                <td>
                    <input type="checkbox" name="preference1" value="唱歌" ${fn:contains(customer.preference,'唱歌')==true?'checked':''}>唱歌
                    <input type="checkbox" name="preference1" value="跳舞" ${fn:contains(customer.preference,'跳舞')==true?'checked':''}>跳舞
                    <input type="checkbox" name="preference1" value="打代码" ${fn:contains(customer.preference,'打代码')==true?'checked':''}>打代码
                </td>
            </tr>
            <tr>
                <td>客户类型：</td>
                <td>
                    <input type="radio" name="type" value="VIP" ${fn:contains(customer.type,'VIP')==true?'checked':''}>VIP
                    <input type="radio" name="type" value="普通客户" ${fn:contains(customer.type,'普通客户')==true?'checked':''}>普通客户
                    <input type="radio" name="type" value="黑名单客户" ${fn:contains(customer.type,'黑名单客户')==true?'checked':''}>黑名单客户
                </td>
            </tr>
            <tr>
                <td>描述：</td>
                <td>
                    <textarea name="description" cols="179" rows="10">${customer.description}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <center>
                        <input type="submit" value="保存客户">&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="重置">
                    </center>
                </td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
