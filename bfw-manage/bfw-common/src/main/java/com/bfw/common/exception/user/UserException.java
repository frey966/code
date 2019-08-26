package com.bfw.common.exception.user;

import com.bfw.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author sailboat
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
