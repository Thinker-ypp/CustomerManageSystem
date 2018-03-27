package com.yu.demo.controller;

import com.yu.demo.domain.CustomerDomain;
import com.yu.demo.service.impl.CustomerService;
import com.yu.demo.utils.PageList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除客户
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-03-12 10:09
 */
public class DeleteCustomer extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println(">>>>>>>>>>>  删除客户!!!  初始化 <<<<<<<<<<<");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        CustomerService customerService = new CustomerService();
        customerService.deleteCustomer(id);

        //删除成功之后进行查询操作
        //获取前台页面传入的当前页数
        String currentPage = request.getParameter("currentPage");
        //调用方法查询
        PageList<CustomerDomain> pageList = customerService.getTotalData(currentPage);
        request.setAttribute("page",pageList);
        request.getRequestDispatcher("/views/findCustomer.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
