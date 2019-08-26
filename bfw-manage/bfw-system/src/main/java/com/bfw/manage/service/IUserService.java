package com.bfw.manage.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author study
 * @date 2019年08月10日
 */
public interface IUserService {
     JSONObject userList(int page,
                         int size,
                         String lockStatus,
                         String regdatetimeStart,
                         String regdatetimeEnd,
                         String searchKey);

    JSONObject userDetail(long userId);

    JSONObject userLock(Long userId, int lockdays);

    JSONObject userUnLock(Long userId);
}
