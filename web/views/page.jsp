<%--
  Created by IntelliJ IDEA.
  User: yupanpan
  Date: 2018/3/9
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页插件页面</title>
</head>
<body>
    当前页数：【${page.currentPage}/${page.totalPage}】&nbsp;&nbsp;&nbsp;&nbsp;
    <%-- 分页的页码显示 --%>
    <c:if test="${page.currentPage > 1}">
        <a href="${ctx}/customer/findCustomer?currentPage=${page.currentPage - 1}" style="text-decoration: none">
            上一页&nbsp;&nbsp;
        </a>
    </c:if>
    <c:if test="${page.currentPage == 1}">
        上一页&nbsp;&nbsp;
    </c:if>
    <c:if test="${page.currentPage >=4}">
        ....
    </c:if>
    <c:forEach var="pageNum" begin="${page.startPage}" end="${page.endPage}">
        <a href="${ctx}/customer/findCustomer?currentPage=${pageNum}"
           style="text-decoration: none">[${pageNum}]&nbsp;</a>
    </c:forEach>
    <c:if test="${page.currentPage < page.totalPage - 2}">
        ....
    </c:if>
    <c:if test="${page.currentPage < page.totalPage}">
        <a href="${ctx}/customer/findCustomer?currentPage=${page.currentPage + 1}" style="text-decoration: none">
            下一页&nbsp;&nbsp;
        </a>
    </c:if>
    <c:if test="${page.currentPage == page.totalPage}">
        下一页&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <input type="text" id="goPage" size="2"/>
    <input type="button" value="跳转" onclick=" return goPage()"/>&nbsp;&nbsp;&nbsp;
    总页数：【${page.totalPage}】&nbsp;&nbsp;&nbsp;
    总记录数：【${page.totalRecord}】
</body>
<script type="text/javascript">

    /*跳转页面 */
    function goPage() {
        var value = document.getElementById("goPage").value;
        //校验输入框里面的值是否合法
        if (value == null || value == "") {
            alert("请输入页码！")
            return false;
        }
        if (!value.match("\\d+")) {
            alert("请输入数字！")
            return false;
        }
        if (value < 1 || value > ${page.totalPage}) {
            alert("请输入合法数据！！")
            return false;
        }
        window.location.href = "${ctx}/customer/findCustomer?currentPage=" + value;
        return true;
    }
</script>
</html>
