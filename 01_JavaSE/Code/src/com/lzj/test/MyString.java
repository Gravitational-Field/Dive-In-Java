package com.lzj.test;

public class MyString {

    /**
    * @Description: 对String类型进行探究
    *
    */
    public static void main(String[] args) {
        //String str1 = "Hello";
        //String str2 = "Hello";
        //System.out.println(str1==str2); //true  ==: 对象只比较地址,取用的字符串常量池中的同一份。
        //System.out.println(str1.equals(str2)); //true   先比地址，再比值

        String str3 = new String("Hello"); //未存进常量池
        String str4 = new String("Hello");
        System.out.println(str3==str4); //false    // str3与str4的地址不同
        System.out.println(str3.equals(str4)); //true

        String str5 = "World";
        String str6 = str5;  //对象的引用
        System.out.println(str5==str6); //true
        System.out.println(str5.equals(str6)); //true

        String str7 = "World";
        String str8 = str7+"!";
        System.out.println(str7==str8); //false
        System.out.println(str7.equals(str8)); //false

        str7 = str7+"!";
        System.out.println(str7);  // World!

        String str9 = "china";
        String str10 = "china";
        str9 = str9+"!";
        System.out.println(str9);
        System.out.println(str10);


    }
}
