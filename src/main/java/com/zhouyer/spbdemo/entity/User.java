package com.zhouyer.spbdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName User
 * @Description 用户实体
 * @Author zhouyer
 * @Date 2019/12/2 23:54
 * @Version 1.0
 **/
@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private Date birthday;
}
