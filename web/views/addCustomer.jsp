<%--
  Created by IntelliJ IDEA.
  User: yupanpan
  Date: 2018/3/8
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/views/_taglib.jsp"%>
<html>
<script type="text/javascript" src="/static/js/customer.js"></script>
<br>
<br>
<body onload="pageInit()">
<form action="${ctx}/customer/saveCustomer"
      method="post" id="form"  onsubmit="return makeForm()">
    <center>
        <h2>新增客户</h2>
        <table border="1px" width="72%">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <input type="radio" name="gender" value="男">男
                    <input type="radio" name="gender" value="女">女
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
                <td><input type="text" name="cellPhone"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>爱好：</td>
                <td>
                    <input type="checkbox" name="preference1" value="唱歌">唱歌
                    <input type="checkbox" name="preference1" value="跳舞">跳舞
                    <input type="checkbox" name="preference1" value="打代码">打代码
                </td>
            </tr>
            <tr>
                <td>客户类型：</td>
                <td>
                    <input type="radio" name="type" value="VIP">VIP
                    <input type="radio" name="type" value="普通客户">普通客户
                    <input type="radio" name="type" value="黑名单客户">黑名单客户
                </td>
            </tr>
            <tr>
                <td>描述：</td>
                <td>
                    <textarea name="description" cols="179" rows="10"></textarea>
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
