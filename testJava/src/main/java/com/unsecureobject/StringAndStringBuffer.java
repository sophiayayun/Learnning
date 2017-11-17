package com.unsecureobject;

import java.util.HashSet;

/**
 * Created by dengyayun on 17/10/17.
 */
public class StringAndStringBuffer {

    public static void main(String[] args) {
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();

        StringBuilder sb1 = new StringBuilder("aaaaa");
        StringBuilder sb2 = new StringBuilder("bbbbb");

        hs.add(sb1);
        hs.add(sb2);

        StringBuilder sb3 = sb1;
        sb3.append("cccc");
        System.out.println(hs);

    }

}
