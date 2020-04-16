package com.kfgs.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * Date: 2020-04-15-17-30
 * Module:
 * Description:
 *
 * @author:
 */
public class ListToModelUtils {
    //把list内容逐个取出来放进User实体类中
    public static <T> void listToModel(List<Object> list, T t) throws Exception {
        Field[] fields = t.getClass().getDeclaredFields();
        if (list.size() != fields.length) {
            return;
        }
        for (int k = 0, len = fields.length; k < len; k++) {
            // 根据属性名称,找寻合适的set方法
            String fieldName = fields[k].getName();
            String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            Method method = null;
            Class<?> clazz = t.getClass();
            try {
                /*if("id".equals(fieldName) || "isdelete".equals(fieldName) ){
                    method = clazz.getMethod(setMethodName, new Class[] { Integer.class });
                }else if( "createTime".equals(fieldName)){
                    method = clazz.getMethod(setMethodName, new Class[] { Date.class });
                }else {
                    method = clazz.getMethod(setMethodName, new Class[] { list.get(k).getClass() });
                }*/
                method = clazz.getMethod(setMethodName, new Class[] { list.get(k).getClass() });
                System.out.println("list.get("+k+").getClass():"+list.get(k).getClass());
            } catch (SecurityException e1) {
                e1.printStackTrace();
                return;
            } catch (NoSuchMethodException e1) {
                String newMethodName = "set" + fieldName.substring(0, 1).toLowerCase()
                        + fieldName.substring(1);
                try {
                    method = clazz.getMethod(newMethodName, new Class[] { list.get(k).getClass() });
                } catch (SecurityException e) {
                    e.printStackTrace();
                    return;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (method == null) {
                return;
            }
           /* if("id".equals(fieldName) || "isdelete".equals(fieldName) ){
                method.invoke(t, new Integer[] {Integer.getInteger( list.get(k).toString() )}   );
            }else if( "createTime".equals(fieldName)){
                method.invoke(t, new Date[] { new Date(  list.get(k).toString() ) });
            }else {
                method.invoke(t, new Object[] { list.get(k) });
            }*/
            method.invoke(t, new Object[] { list.get(k) });
        }
    }
}
