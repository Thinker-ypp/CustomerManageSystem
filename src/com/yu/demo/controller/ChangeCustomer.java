package com.yu.demo.controller;

import com.yu.demo.domain.CustomerDomain;
import com.yu.demo.service.impl.CustomerService;
import com.yu.demo.utils.PageList;
import com.yu.demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 保存更改客户的数据
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-03-12 13:47
 */
public class ChangeCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决数据存储到数据库中文乱码问题
        req.setCharacterEncoding("UTF-8");

        //将表单的数据封装到一个对象
        CustomerDomain customerDomain = WebUtils.request2Bean(req, CustomerDomain.class);
        customerDomain.setId(req.getParameter("id"));
        CustomerService customerService = new CustomerService();
        customerService.updateCustomer(customerDomain);

        //更新完成之后跳转到查看客户信息的页面
        //获取前台页面传入的当前页数
        String currentPage = req.getParameter("currentPage");
        //调用方法查询
        PageList<CustomerDomain> pageList = customerService.getTotalData(currentPage);
        req.setAttribute("page",pageList);
        req.getRequestDispatcher("/views/findCustomer.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("保存更改客户信息的servlet 销毁....");
    }
}
