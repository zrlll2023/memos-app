package com.memos.memosapp.utils;

public class UserContext {

    // ThreadLocal：每个请求线程有自己独立的存储空间，互不干扰
    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        USER_ID.set(userId);
    }

    public static Long getUserId() {
        return USER_ID.get();
    }

    // 请求结束后必须清理，否则会内存泄漏
    public static void clear() {
        USER_ID.remove();
    }
}