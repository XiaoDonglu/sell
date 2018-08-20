package com.xdl.utils;

import java.util.Random;

/**
 * 随机数
 *
 * @author: xdl
 * @date: 2018-08-20
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 时间+6位随机数
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(num);
    }

}
