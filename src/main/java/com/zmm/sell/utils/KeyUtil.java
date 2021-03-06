package com.zmm.sell.utils;

import java.util.Random;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/9
 * Email:65489469@qq.com
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：当前毫秒数+随机数
     * synchronized:防止多线程下重复
     * @return
     */
    public static synchronized String genUniqueKey(){

        Random random = new Random();

        int i = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(i);

    }
}
