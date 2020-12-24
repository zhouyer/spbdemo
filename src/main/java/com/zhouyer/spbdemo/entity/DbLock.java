package com.zhouyer.spbdemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName DbLock
 * @Description TODO
 * @Author zhouyer
 * @Date 2020/6/3 21:48
 * @Version 1.0
 **/
@Entity
@Table(name = "t_lock")
@Data
public class DbLock {
    @Id
    private int id;
}
