package com.onlyone.common.util;

import java.util.List;

/**
 * 创建者：许方镇
 * 日期：2016/11/8
 * 功能模块：
 */
public class ListUtils {

    public static boolean isValid(List sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }

    public static boolean isInvalid(List sourceList) {
        return !isValid(sourceList);
    }
}
