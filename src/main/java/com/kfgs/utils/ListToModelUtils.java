package com.kfgs.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020-04-15-17-30
 * Module:
 * Description:
 *
 * @author:
 */
public class ListToModelUtils {

    public  static Map<String, String> listToMap(List<HashMap<String,String>> list){
        Map<String, String> map = new HashMap<>();
        if(list != null && !list.isEmpty()){
            for(HashMap<String, String> map1 : list){
                String key = null;
                String value = null;
                for(Map.Entry<String, String> entry : map1.entrySet()){
                    if ("key".equals(entry.getKey())) {
                        key =  String.valueOf(entry.getValue());
                    } else if ("value".equals(entry.getKey())) {
                        value = String.valueOf(entry.getValue());
                    }
                }
                map.put(key, value);
            }
        }
        return  map;
    }


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

            method.invoke(t, new Object[] { list.get(k) });
        }
    }
}
