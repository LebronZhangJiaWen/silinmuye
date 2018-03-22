package com.muyenet.muye.core.utils;

import java.util.UUID;

/**
 * Created by zchuanzhao on 2017/7/15.
 */
public class TokenUtil {

    public static String getToken(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
