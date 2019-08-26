package com.bfw.manage.utils;

/**
 * @author study
 * @date 2019年08月10日
 */
public class RequestUrlUtils {

    private static UrlConfig config;

    static {
        config=SpringContextHolder.getBean(UrlConfig.class);
    }

    public static String USER_LIST="v1/admin/users";//查询用户列表

    public static String USER_DETAIL="v1/admin/user/info/";//查询用户详情

    public static String USER_LOCK="v1/admin/lock";//锁定用户

    public static String USER_UNLOCK="v1/admin/unlock";//解锁用户

    public static String getUserList() {
        return config.getBaseUrl()+USER_LIST;
    }

    public static String getUserDetail() {
        return config.getBaseUrl()+USER_DETAIL;
    }

    public static String getUserLock() {
        return config.getBaseUrl()+USER_LOCK;
    }

    public static String getUserUnlock() {
        return config.getBaseUrl()+USER_UNLOCK;
    }
}
