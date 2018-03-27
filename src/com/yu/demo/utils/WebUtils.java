package com.yu.demo.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * web工具类
 *
 * @version v0.0.1
 * @author: yupanpan
 * @since: 2018-02-27 9:21
 */
public class WebUtils<T> {

    /*
     *设置随机Id
     * @author: yupanpan
     * @since : 2018/2/27 9:23
     * @version v0.0.1
     */

    public static String makeId() {
        return UUID.randomUUID().toString();
    }


    /*
     *设置bean对象来封装表单提交的数据
     * @author: yupanpan
     * @since : 2018/2/28 10:36
     * @version v0.0.1
     */

    public static <T> T request2Bean(HttpServletRequest request, Class<T> tClass) {

        try {
            //获取Bean的对象
            T bean = tClass.newInstance();
            //获取表单所有的名称数据
            Enumeration<String> enumeration = request.getParameterNames();
            //遍历这些数据,获取每一个名字
            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement();
                //获取得到的名字的值
                String value = request.getParameter(name);
                System.out.println(">>>>>>"+name+"-----"+value+"<<<<<<<");
                //判断该值是否为空，若不为空则封装到Bean对象中
                if (!value.equals("") && value != null) {
                    BeanUtils.setProperty(bean,name,value);
                }
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("封装数据到Bean中出现异常！！！");
        }
    }
}
