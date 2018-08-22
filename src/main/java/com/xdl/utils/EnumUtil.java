package com.xdl.utils;

import com.xdl.enums.CodeEnum;

/**
 * 枚举工具类
 *
 * @author xdl
 * @date 2018-08-21
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
