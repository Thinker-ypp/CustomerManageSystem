package com.yu.demo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库工具类
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 9:08
 */
public class DataSouceUtils {

    private static ComboPooledDataSource comboPooledDataSource = null;

    static {
        //会自动寻找数据库，节点就是mysql数据库（默认的也是mysql）
        comboPooledDataSource = new ComboPooledDataSource();
    }

    /*获取数据库*/
    public static DataSource getDataSource(){
        return comboPooledDataSource;
    }

    /*获取连接初始化数据库*/
    public static Connection getConnection(){
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库初始化失败！！！");
        }
    }
}
