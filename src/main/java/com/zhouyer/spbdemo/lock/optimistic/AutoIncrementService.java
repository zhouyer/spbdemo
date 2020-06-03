package com.zhouyer.spbdemo.lock.optimistic;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AutoIncrementService
 * @Description 自增ID生成服务
 * @Author zhouyer
 * @Date 2020/5/10 14:24
 * @Version 1.0
 **/
@Service
public class AutoIncrementService implements Runnable {
    @Autowired
    private GenKeyService genKeyService;

    @Override
    public void run() {
        buildAutoIncrementId();
    }

    /**
     * 生成自增id
     */
    private int buildAutoIncrementId() {
        int incrementId = 0;
        int num = 0;
        while (num == 0) {
            List<GenKey> genKeyList = genKeyService.getGenKeyEntity();
            GenKey genKey;
            if (CollectionUtils.isNotEmpty(genKeyList)) {
                genKey = genKeyList.get(0);
            } else {
                genKey = GenKey.builder().value(1).build();
            }
            num = genKeyService.updateValueUseCas(genKey);
            if (num > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("发送冲突");
            }
            incrementId = genKey.getValue();
        }
        System.out.println(incrementId);
        return incrementId;
    }
}
