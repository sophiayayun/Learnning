package com.thread;

/**
 * Created by dengyayun on 17/4/12.
 */
//这个对象是线程安全的, 这里的value 成员变量 只在初始化对象时设置,之后没有办法变更

public class ImmutableValue {

    private int value = 0;

    public ImmutableValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    //这个方法也是线程安全的, 以加法操作的结果作为一个新的 ImmutableValue 类实例返回，而不是直接对它自己的 value 变量进行操作
    public ImmutableValue add(int valuetoAdd) {
        return new ImmutableValue(this.getValue() + valuetoAdd);
    }



}
