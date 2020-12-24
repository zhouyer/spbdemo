package com.zhouyer.spbdemo.lock.distributedlock.service;

/**
 * @ClassName ILockService
 * @Description 锁相关服务
 * @Author zhouyer
 * @Date 2020/6/3 21:44
 * @Version 1.0
 **/
public interface ILockService {
    /**
     * 根据主键删除
     *
     * @param id 主键值
     * @return 操作成功记录数量
     */
    int deleteByKey(int id);

    /**
     * 插入数据
     *
     * @param id 主键
     * @return 操作成功记录数量
     */
    int insert(int id);
}
