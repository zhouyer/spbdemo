package com.zhouyer.spbdemo.lock.distributedlock.service.impl;

import com.zhouyer.spbdemo.entity.DbLock;
import com.zhouyer.spbdemo.lock.distributedlock.repository.DbLockRepository;
import com.zhouyer.spbdemo.lock.distributedlock.service.ILockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName DbLockService
 * @Description 数据库实现分布式锁
 * @Author zhouyer
 * @Date 2020/6/3 21:47
 * @Version 1.0
 **/
@Service
public class DbLockService implements ILockService {
    @Autowired
    private DbLockRepository dbLockRepository;

    /**
     * 根据主键删除
     *
     * @param id 主键值
     * @return 操作成功记录数量
     */
    @Override
    public int deleteByKey(int id) {
        try {
            dbLockRepository.deleteById(id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    /**
     * 插入数据
     *
     * @param id 主键
     * @return 操作成功记录数量
     */
    @Override
    public int insert(int id) {
        DbLock dbLock = new DbLock();
        dbLock.setId(id);
        DbLock result = dbLockRepository.save(dbLock);
        if (null != result) {
            return 1;
        }
        return 0;
    }
}
