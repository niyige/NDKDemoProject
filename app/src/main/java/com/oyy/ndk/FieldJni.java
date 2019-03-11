package com.oyy.ndk;

/**
 * create by ouyangyi@manqian.cn
 * on 2019/3/1 14:16
 * Description: jni测试类
 */
public class FieldJni {

    public int number = 10;

    public native int addNum();

    public String name = "EGan";

    public native String getStr();

}
