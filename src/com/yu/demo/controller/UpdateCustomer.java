package com.yu.demo.controller;

import com.yu.demo.domain.CustomerDomain;
import com.yu.demo.service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改客户信息(显示更新的页面)
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-03-12 11:04
 */
public class UpdateCustomer extends HttpServlet {

    @Override
    public void init() throws ServletException {

        System.out.println(">>>>>>>>>  更新客户！！！ 初始化 <<<<<<<<<");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        //先根据id查询出客户对象
        CustomerDomain customer = new CustomerService().findCustomer(id);
        req.setAttribute("customer", customer);
        //传送一个隐藏的条件当前页
        req.setAttribute("currentPage",req.getParameter("currentPage"));
        //重定向页面，同时把查询的数据回显到页面
        req.getRequestDispatcher("/views/updateCustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet 销毁....");
    }
}
