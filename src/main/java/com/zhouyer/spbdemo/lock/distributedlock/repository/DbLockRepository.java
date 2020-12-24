package com.zhouyer.spbdemo.lock.distributedlock.repository;

import com.zhouyer.spbdemo.entity.DbLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName DbLockRepository
 * @Description TODO
 * @Author zhouyer
 * @Date 2020/6/3 21:50
 * @Version 1.0
 **/
@Repository
public interface DbLockRepository extends JpaRepository<DbLock, Integer> {
}
