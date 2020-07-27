package com.lzj.test;

public class AutoboxingAndUnboxing {

    public static void main(MyString[] args) {

        //
        Integer x = 123;  //进行了自动装箱,调用了valeOf(123),存进了cache中
        Integer y = x;  //地址引用

        System.out.println(x==y);  //true

        Integer a = 123;  //进行了自动装箱，直接读取得cache中的对象。
        int b = a;  //进行了自动拆箱

        System.out.println(a==b);  //true    直接进行数值的比较。

        Integer c = 123;
        Integer d = 123;
        System.out.println(c==d);  //true

        Integer e = 128;
        Integer f = 128;
        System.out.println(e==f);  //false

    }


}
