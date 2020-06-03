package com.zhouyer.spbdemo.lock.optimistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GenKeyService
 * @Description 生成自增ID的相关服务
 * @Author zhouyer
 * @Date 2020/5/10 0:12
 * @Version 1.0
 **/
@Service
public class GenKeyService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String SQL_USE_CAS = "UPDATE t_increa_genkey " +
                                 "   set n_value = n_value+1," +
                                 "       n_version = n_version+1 " +
                                 " where n_version = ?";

    private String SQL_UPDATE = "UPDATE t_increa_genkey set n_value = n_value+1";

    private String SQL_SELECT = "SELECT id as id,n_value as value,n_version as version,n_status as status " +
            "FROM t_increa_genkey";

    /**
     * 更新自增值,使用CAS(Compare And Swap)更新
     *
     * @param genKey 生成自增ID的对象
     * @return 返回更新数据条数
     */
    public int updateValueUseCas(GenKey genKey) {
        return jdbcTemplate.update(SQL_USE_CAS, genKey.getVersion());
    }

    /**
     * 更新值
     *
     * @param genKey 生成自增ID的对象
     * @return 返回更新数据条数
     */
    public int updateValue(GenKey genKey) {
        return jdbcTemplate.update(SQL_UPDATE);
    }

    public List<GenKey> getGenKeyEntity() {
        return jdbcTemplate.query(SQL_SELECT, new BeanPropertyRowMapper<GenKey>(GenKey.class));
    }
}
