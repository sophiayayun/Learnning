package com.unsecureobject;

/**
 * Created by dengyayun on 17/11/21.
 */
public class Practice {
    public static void main(String[] args) {
        /*
         * 声明个字符串s，用下划线和井号是因为两个比较好区分。 分别实例化sf和sd两个对象
         */
        String s = "####____";
        StringBuffer sf = new StringBuffer(s);
        StringBuilder sd = new StringBuilder(s);
        /*
         * 对sf和sd各自实例化两个反转他们的类
         */
        ThreadReverseString sfr1 = new ThreadReverseString(sf);
        ThreadReverseString sfr2 = new ThreadReverseString(sf);
        ThreadReverseString sdr1 = new ThreadReverseString(sd);
        ThreadReverseString sdr2 = new ThreadReverseString(sd);
        /*
         * 启动这四个线程，此时sf和sd各自有两个线程在对他们进行字符串反转操作
         */
        new Thread(sfr1).start();
        new Thread(sfr2).start();
        new Thread(sdr1).start();
        new Thread(sdr2).start();
    }
}
