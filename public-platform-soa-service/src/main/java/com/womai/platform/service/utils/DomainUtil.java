package com.womai.platform.service.utils;

import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: qingyunzhang
 * Date: 12-12-25
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 */
public class DomainUtil {
   /* private static Log log = LogFactory.getLog(DomainUtil.class);*/

    /**
     * object 旧对象，copy 新对�?
     * 相同结构对象值对应拷�?
     */
    public void copy(Object object, Object copy) throws Exception {
        if(object==null){
            return;
        }
        Class<?> classType = object.getClass();

        // 获得对象的所有成员变�?
        Field[] fields = (Field[]) ArrayUtils.addAll(classType.getSuperclass().getDeclaredFields(), classType.getDeclaredFields());
        for (Field field : fields) {
            String name = field.getName();
            String firstLetter = name.substring(0, 1).toUpperCase();// 将属性的首字母转换为大写
            String getMethodName = "get" + firstLetter + name.substring(1);
            String setMethodName = "set" + firstLetter + name.substring(1);

            Method getMethod = classType.getMethod(getMethodName,
                    new Class[]{});
            Method setMethod = copy.getClass().getMethod(setMethodName,
                    new Class[]{field.getType()});
            Object value = getMethod.invoke(object, new Object[]{}); //invoke()方法的第�?个参数是指调用Method的对�?,第二个参数是Method的参�? 详见API
            if (value != null) {
                setMethod.invoke(copy, new Object[]{value});
            }
        }
    }

    /**
     * object 旧对象，copy 新对象，escapeField 忽略拷贝字段
     * 相同结构对象值对应拷�?
     */
    public void copy2(Object object, Object copy, List<String> escapeField) throws Exception {
        if(object==null){
            return;
        }
        Class<?> classType = object.getClass();

        // 获得对象的所有成员变�?

        Field[] fields = (Field[]) ArrayUtils.addAll(classType.getSuperclass().getDeclaredFields(), classType.getDeclaredFields());//.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            if (!escapeField.contains(name)) {
                String firstLetter = name.substring(0, 1).toUpperCase();// 将属性的首字母转换为大写
                String getMethodName = "get" + firstLetter + name.substring(1);
                String setMethodName = "set" + firstLetter + name.substring(1);

                Method getMethod = classType.getMethod(getMethodName,
                        new Class[]{});
                Method setMethod = copy.getClass().getMethod(setMethodName,
                        new Class[]{field.getType()});

                Object value = getMethod.invoke(object, new Object[]{}); //invoke()方法的第�?个参数是指调用Method的对�?,第二个参数是Method的参�? 详见API
                if (value != null) {
                    setMethod.invoke(copy, new Object[]{value});
                }
            }
        }
    }
}
