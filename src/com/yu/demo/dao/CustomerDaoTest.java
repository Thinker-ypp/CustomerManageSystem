package com.yu.demo.dao;

import com.yu.demo.domain.CustomerDomain;
import org.junit.Test;

import java.util.List;

/**
 * dao层的测试类
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 10:07
 */
public class CustomerDaoTest {

    /*增加客户测试*/
    @Test
    public void addCustomer() {

        CustomerDomain customer = new CustomerDomain("4", "xiaoqiu", "女","123456", "113445@qq.com", "旅游", "尊享VIP", "好人");
        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(customer);
    }


    /*查询客户测试*/
    @Test
    public void searchAll(){

        //用static静态变量修饰的方法可以直接用类名调用
        List<CustomerDomain> customers = CustomerDao.getAll();
        //遍历集合
        for(CustomerDomain customer : customers) {
            System.out.println(customer.getName());
        }
    }


    /*修改客户信息测试*/
    @Test
    public void update(){

        String id = "9299299e-9417-4b02-a6d6-86c6c7b337f5";
        CustomerDao customerDao = new CustomerDao();
        //根据id查询
        CustomerDomain customer = customerDao.findCustomer(id);
        customer.setDescription("她是个坏人！！！");
        //更新信息
        customerDao.updateCustomer(customer);
    }

    /*删除用户信息测试*/
    @Test
    public void delete(){
        String id = "23e3886a-2bba-4408-ad0b-4c151f57018c";
        CustomerDao.deleteCustomer(id);
    }
}



