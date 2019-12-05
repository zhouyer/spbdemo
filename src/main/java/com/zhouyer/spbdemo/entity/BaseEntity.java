package com.zhouyer.spbdemo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Description TODO
 * @Author zhouyer
 * @Date 2019/12/4 23:12
 * @Version 1.0
 **/
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @LastModifiedDate
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }
}
