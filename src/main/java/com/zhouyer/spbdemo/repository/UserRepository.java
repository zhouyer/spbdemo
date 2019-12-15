package com.zhouyer.spbdemo.repository;

import com.zhouyer.spbdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description 用户数据 Repository
 * @Author zhouyer
 * @Date 2019/12/1 22:38
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User findByUsernameAndPassword(String username, String password);
}
