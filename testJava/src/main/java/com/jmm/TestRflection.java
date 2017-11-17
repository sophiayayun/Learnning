package com.jmm;

import java.lang.reflect.Field;

/**
 * Created by dengyayun on 17/10/17.
 */
public class TestRflection {

        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
                //创建字符串"Hello World"， 并赋给引用s
                String s = "Hello World";

                System.out.println("s = " + s); //Hello World

                //获取String类中的value字段
                Field valueFieldOfString = String.class.getDeclaredField("value");

                //改变value属性的访问权限
                valueFieldOfString.setAccessible(true);

                //获取s对象上的value属性的值
                char[] value = (char[]) valueFieldOfString.get(s);

                //改变value所引用的数组中的第5个字符
                value[5] = '_';

                System.out.println("s = " + s);  //Hello_World
        }

}

//String 是不可变的,但是不可变真的么? 通过这种反射非正常手段可以达到变.

