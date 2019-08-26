package com.bfw.manage.utils;

import com.bfw.common.utils.StringUtils;

/**
 * @author study
 * @date 2019年08月16日
 */
public class LogoUtils {

    private static final String base_url="https://oss.cn-south-1.jcloudcs.com/imgs";

    /**
     * 拼接数据方传过来的URL
     * @param url
     * @return
     */
    public static String getLogoByUrl(String url){
        if (!StringUtils.isEmpty(url)){
            String[] array = url.split("_file");
            if (array.length<2){
                return null;
            }
            return base_url+array[1];
        }
        return null;
    }
}
