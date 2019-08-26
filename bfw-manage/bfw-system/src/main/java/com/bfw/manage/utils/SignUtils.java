package com.bfw.manage.utils;

import java.util.*;

/**
 * @author study
 * @date 2019年08月10日
 */
public class SignUtils {
    public static String getSign(Map<String,Object> map){
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Object>>() {
            //升序排序
            public int compare(Map.Entry<String, Object> o1,
                               Map.Entry<String, Object> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });
        StringBuilder sb=new StringBuilder();
        sb.append("appSecret");
        for(Map.Entry<String,Object> mapping:list){
            Object value=mapping.getValue();
            String key=mapping.getKey();
            sb.append(key).append(value);
        }
        return MD5Util.getMD5Code(sb.toString());
    }
}
