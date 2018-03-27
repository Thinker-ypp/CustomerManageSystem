package com.yu.demo.dao;

import com.yu.demo.domain.CustomerDomain;
import com.yu.demo.utils.DataSouceUtils;
import com.yu.demo.utils.WebUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 客户管理系统的Dao层
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 9:30
 */
public class CustomerDao {

    /*增加客户*/

    public void addCustomer(CustomerDomain customer) {

        //初始化数据库
        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());

        String sql = "insert into customer(id,name,gender,cellPhone,email,preference,type,description)" +
                "values(?,?,?,?,?,?,?,?)";
        /*获取传递来的数据*/
//        String id = customer.getId();
        String id = WebUtils.makeId();
        String name = customer.getName();
        String gender = customer.getGender();
        String cellPhone = customer.getCellPhone();
        String prefernce = customer.getPreference();
        String type = customer.getType();
        String description = customer.getDescription();
        String email = customer.getEmail();

        /*转换生日的日期类型*/
//        Date date = customer.getBirthday();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String birthday = simpleDateFormat.format(date);

        /*将数据插入到数据库*/
        try {
            queryRunner.update(sql, new Object[]{id, name, gender, cellPhone, email, prefernce, type, description});
            //添加成功
            System.out.println(">>>>>>>  添加客户成功！！！ <<<<<<<");
        } catch (SQLException e) {
            //添加数据失败
            e.printStackTrace();
            throw new RuntimeException("添加客户失败！！！");
        }
    }


    /*查询客户*/

    public static List<CustomerDomain> getAll() {

        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());
        String sql = "select * from customer";

        /*查询数据库*/
        try {
            List<CustomerDomain> customers = queryRunner.query(sql, new BeanListHandler<CustomerDomain>(CustomerDomain.class));
            return customers.size() > 0 ? customers : null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询数据异常！！！");
        }
    }


    /*修改客户信息*/

    // 1. 先根据id查询出客户信息

    public CustomerDomain findCustomer(String id) {

        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());
        String sql = "select * from customer where id = ?";
        try {
            CustomerDomain customer = (CustomerDomain) queryRunner.query(sql,
                    new BeanHandler<CustomerDomain>(CustomerDomain.class), new Object[]{id});
            if (customer == null) {
                System.out.println("该客户不存在！！！《《《《");
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询异常！！！");
        }
    }

    // 2. 修改查询出来的客户的信息

    public void updateCustomer(CustomerDomain customer) {
        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());
        String sql = "update customer set name = ?,gender = ?," +
                "cellPhone = ?,email = ?,preference = ?,type = ?,description = ? where id = ?";
        try {
            queryRunner.update(sql, new Object[]{customer.getName(), customer.getGender(), customer.getCellPhone(),
                    customer.getEmail(), customer.getPreference(), customer.getType(), customer.getDescription(), customer.getId()});
            System.out.println("》》》》》》 修改成功！！！《《《《《《");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改失败！！！");
        }
    }

    /*删除客户*/

    public static void deleteCustomer(String id) {
        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());
        String sql = "delete from customer where id = ?";
        try {
            queryRunner.update(sql, new Object[]{id});
            System.out.println("》》》》》》 删除成功！！！《《《《《《");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败！！！");
        }
    }


    /**
     * 分页数据处理
     *
     * @author: yupanpan
     * @version v0.0.1
     * @since : 2018/3/8 15:43
     */


    /*获取总的记录数*/
    public Long getTotalRecord() {
        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());
        String sql = "select count(0) from customer";
        try {
            Long record =(Long)queryRunner.query(sql, new ScalarHandler());
            return record;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询总记录数异常！！！");
        }
    }

    /*查询分页数据
    * 需要start 和 end 两个变量
    * */

    public List<CustomerDomain> getPageData(int start, int end) {
        QueryRunner queryRunner = new QueryRunner(DataSouceUtils.getDataSource());
        String sql = "select * from customer limit ?,?";
        try {
            List<CustomerDomain> customerDomains = queryRunner.query(sql,
                    new BeanListHandler<CustomerDomain>(CustomerDomain.class),
                    new Object[]{start, end});
            if (customerDomains.size()==0) {
                return null;
            }
            return customerDomains;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询分页数据异常！！！");
        }
    }
}
