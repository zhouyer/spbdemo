package com.zhouyer.spbdemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;
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
    @Column(name = "username")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;
    /**
     * 性别
     */
    @Column(name = "sex")
    private Integer sex;
    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private Date birthday;
}
