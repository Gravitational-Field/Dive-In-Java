package com.lzj.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author: Keen
 * @Description: web层的操作
 */
public class WebUtils {

    /**
    * @Description: 将map注入到bean中
    * @Params: map 参数来源
     * bean：注入到的bean
    * @Return: 返回实体类对象
    */
    public static <T> T  copyParamToBean(Map map, T bean) {
        try {
            //System.out.println("注入前：" + bean);
            BeanUtils.populate(bean, map);
            //System.out.println("注入后：" + bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }

}
