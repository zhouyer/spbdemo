package com.zhouyer.spbdemo.proxy;

import com.zhouyer.spbdemo.proxy.dynamicproxy.DataPoolProxy;
import com.zhouyer.spbdemo.proxy.dynamicproxy.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author zhouyer
 * @Date 2020/6/2 20:30
 * @Version 1.0
 **/
public class ProxyTest {

    public static void main(String[] args) throws SQLException {
        DataPoolProxy dataPoolProxy = new DataPoolProxy(10,3);
        Connection con1 = dataPoolProxy.getConnection();
        Connection con2 = dataPoolProxy.getConnection();
        Connection con3 = dataPoolProxy.getConnection();
        Connection con4 = dataPoolProxy.getConnection();
        Connection con5 = dataPoolProxy.getConnection();
        Connection con6 = dataPoolProxy.getConnection();
        Connection con7 = dataPoolProxy.getConnection();
        Connection con8 = dataPoolProxy.getConnection();

        System.out.println("剩余连接数"+dataPoolProxy.dataPool.size());

        JdbcUtil.releaseCon(con6);
        System.out.println("剩余连接数"+dataPoolProxy.dataPool.size());
    }

}
