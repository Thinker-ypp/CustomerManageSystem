package com.yu.demo.service.impl;

import com.yu.demo.dao.CustomerDao;
import com.yu.demo.domain.CustomerDomain;
import com.yu.demo.service.ICustomerService;
import com.yu.demo.utils.PageList;

import java.util.List;

/**
 * 业务层实现类
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 14:48
 */
public class CustomerService implements ICustomerService {

    private static CustomerDao customerDao = null;

    static {
        customerDao = new CustomerDao();
    }

    @Override
    public void addCustomer(CustomerDomain customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public List<CustomerDomain> findAll() {
        return CustomerDao.getAll();
    }

    @Override
    public CustomerDomain findCustomer(String id) {
        return customerDao.findCustomer(id);
    }

    @Override
    public void updateCustomer(CustomerDomain customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        CustomerDao.deleteCustomer(id);
    }


    /*
     * 分页显示当前页的数据
     *
     * @author: yupanpan
     * @since : 2018/3/8 16:53
     * @version v0.0.1
     */

    public PageList<CustomerDomain> getTotalData(String currentPage) {

        PageList<CustomerDomain> pageList = null;
        //查询总记录数
        Long totalRecord = customerDao.getTotalRecord();

        //查询数据的时候就会分两种情况，一种是首次进入查询，传进来的currentPage值为null；另一种是再次点击页数查询
        //第一种情况
        if (currentPage == null) {
            pageList = new PageList<>(1,totalRecord);
            List<CustomerDomain> pageData = customerDao.getPageData(pageList.getStartIndex(), pageList.getPageSize());
            pageList.setCustomers(pageData);
            return pageList;
        } else {
            //第二种情况，获取传进来的当前页数
            pageList = new PageList<>(Integer.parseInt(currentPage),totalRecord);
            List<CustomerDomain> pageData = customerDao.getPageData(pageList.getStartIndex(), pageList.getPageSize());
            pageList.setCustomers(pageData);
        }
            return pageList;
    }
}
