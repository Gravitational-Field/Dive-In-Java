package com.lzj.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName I18nTest
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/1/6 14:52
 * @Version 1.0
 **/
public class I18nTest {

    @Test
    public void testLocale() {
        // 获取你系统默认的语言。国家信息
        /*Locale locale = Locale.getDefault();
        System.out.println(locale); //zh_CN */

        //
        // 获取中文，中文的常量的 Locale 对象
        System.out.println(Locale.CHINA); //zh_CN
        // 获取英文，美国的常量的 Locale 对象
        System.out.println(Locale.US); //en_US

    }

    @Test
    public void testI18n() {
        // 得到我们需要的 Locale 对象
        Locale locale = Locale.CHINA;
        // 通过指定的 basename 和 Locale 对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale); //找到src根目录下的对应命名的文件
        System.out.println("username：" + bundle.getString("username")); //username：用户名
        System.out.println("password：" + bundle.getString("password")); //password：密码
        System.out.println("Sex：" + bundle.getString("sex"));  //Sex：性别
        System.out.println("age：" + bundle.getString("age"));  //age：年龄

    }
}
