package com.bfw.common.utils.code;

public class IdUtil {


    private IdUtil() {
    }

    public static long generateId() {
        return IdUtil.SingletonInstance.idWorker.nextId();
    }

    private static class SingletonInstance {
        private static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1L, 1L);

        private SingletonInstance() {
        }
    }
}
