package com.yu.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加客户
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-03-08 14:46
 */
public class AddCustomer extends HttpServlet {

    @Override
    public void init() throws ServletException {

        System.out.println(">>>>>>> 添加客户   初始化！！！<<<<<<<");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/addCustomer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
