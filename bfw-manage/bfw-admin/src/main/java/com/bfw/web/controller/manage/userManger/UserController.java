package com.bfw.web.controller.manage.userManger;

import com.alibaba.fastjson.JSONObject;
import com.bfw.manage.service.IUserService;
import com.bfw.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author study
 * @date 2019年08月10日
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public JSONObject userList(@RequestParam("page")int page,
                               @RequestParam(value = "size")int size,
                               @RequestParam(value = "lockStatus",required = false)String lockStatus,
                               @RequestParam(value = "regdatetimeStart",required = false)String regdatetimeStart,
                               @RequestParam(value = "regdatetimeEnd",required = false)String regdatetimeEnd,
                               @RequestParam(value = "searchKey",required = false)String searchKey){
        return userService.userList(page,size,lockStatus,regdatetimeStart,regdatetimeEnd,searchKey);
    }

    @GetMapping("/detail/{userId}")
    public Result<Object> userDetail(@PathVariable("userId")Long userId){
        return Result.buildResult(Result.Status.OK,userService.userDetail(userId));
    }

    @PostMapping("/lock/{userId}")
    public Result<Object> userLock(@PathVariable("userId")Long userId, @RequestParam("lockdays")int lockdays){
        return Result.buildResult(Result.Status.OK,userService.userLock(userId,lockdays));
    }

    @PostMapping("/unlock/{userId}")
    public Result<Object> userUnLock(@PathVariable("userId")Long userId){
        return Result.buildResult(Result.Status.OK,userService.userUnLock(userId));
    }
}
