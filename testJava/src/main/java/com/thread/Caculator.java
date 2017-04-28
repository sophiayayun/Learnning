package com.thread;

/**
 * Created by dengyayun on 17/4/12.
 */
//引用不是线程安全
//通过 setValue()方法和 add()方法可能会改变这个引用
//即使 Calculator 类内部使用了一个不可变对象，但 Calculator 类本身还是可变的，因此 Calculator 类不是线程安全的
public class Caculator {

    private ImmutableValue currentValue = null;

    public ImmutableValue getValue() {

        return currentValue;
    }

    public void setValue(ImmutableValue value) {
        this.currentValue = value;
    }

    public void add(int newValue) {
        this.currentValue = this.currentValue.add(newValue);
    }
}
