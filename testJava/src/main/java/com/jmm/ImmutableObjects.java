package com.jmm;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by dengyayun on 17/10/17.
 */
public class ImmutableObjects {

    public static void main(String[] args) {

        //Integer不可变
//        Integer immutable = 5;
//        System.out.println(immutable);
//
//        immutable = 10;
//        System.out.println(immutable);

        //String 不可变
//        String a1 ="abcddgd";
////        a1 = "23425354";
//        String b1="abcddgd";
//        System.out.println(a1);
//        a1.replace("a","y");
//        System.out.println(a1);


        //StirngBuffer 可变, 但是是线程安全的
        StringBuffer buffer = new StringBuffer("23424243");
        System.out.println(buffer);
        buffer.append("234289473285");
        buffer.replace(0,2,"098");
        System.out.println(buffer);
//
//        //StringBuilder 可变,线程不安全
//        StringBuilder builder =new StringBuilder("qazwsxedc");
//        builder.append("0987");
    }
}

//Integer,String 是不可变的,他只是一个引用,指向不同的地址. 直接debug看即可


//String s = "Hello world!";

//许多人都做过这样的事情，但是，我们到底声明了什么？回答通常是：一个String，内容是“Hello world!”。这样模糊的回答通常是概念不清的根源。如果要准确的回答，一半的人大概会回答错误。
//这个语句声明的是一个指向对象的引用，名为“s”，可以指向类型为String的任何对象，目前指向"Hello world!"这个String类型的对象。这就是真正发生的事情。我们并没有声明一个String对象，我们只是声明了一个只能指向String对象的引用变量。所以，如果在刚才那句语句后面，如果再运行一句：
//
//String string = s;
//
//我们是声明了另外一个只能指向String对象的引用，名为string，并没有第二个对象产生，string还是指向原来那个对象，也就是，和s指向同一个对象
