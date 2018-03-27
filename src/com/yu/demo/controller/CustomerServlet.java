package com.yu.demo.controller;

import com.yu.demo.domain.CustomerDomain;
import com.yu.demo.service.impl.CustomerService;
import com.yu.demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户管理系统
 * <p>
 * 控制层
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 14:50
 */
public class CustomerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("》》》》》 servlet 初始化 《《《《《");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //解决数据存储到数据库中文乱码问题
            request.setCharacterEncoding("UTF-8");
            //将表单的数据弄到Bean对象中
            CustomerDomain customer = WebUtils.request2Bean(request, CustomerDomain.class);
            //调用CustomerService层的方法，添加客户
            CustomerService customerService = new CustomerService();
            customerService.addCustomer(customer);

            //如果执行到这里，说明成功了，如果被catch了，说明失败了。
            request.setAttribute("message", "添加成功！");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加失败！！！");
        }
        request.getRequestDispatcher("/views/message.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void destroy() {
        System.out.println(">>>>>>servlet 销毁了<<<<<<");
        super.destroy();
    }
}
