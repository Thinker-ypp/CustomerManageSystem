package com.yu.demo.service;

import com.yu.demo.domain.CustomerDomain;

import java.util.List;

/**
 * 业务层接口
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 14:47
 */
public interface ICustomerService {

    /*新增客户*/
    void addCustomer(CustomerDomain customer);

    /*查询所有客户*/
    List<CustomerDomain> findAll();

    /*查询一个客户*/
    CustomerDomain findCustomer(String id);

    /*修改客户信息*/
    void updateCustomer(CustomerDomain customer);

    /*删除客户信息*/
    void deleteCustomer(String id);
}
