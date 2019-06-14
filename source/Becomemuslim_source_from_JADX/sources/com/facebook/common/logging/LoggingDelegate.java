package com.facebook.common.logging;

public interface LoggingDelegate {
    /* renamed from: d */
    void mo1151d(String str, String str2);

    /* renamed from: d */
    void mo1152d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo1153e(String str, String str2);

    /* renamed from: e */
    void mo1154e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* renamed from: i */
    void mo1156i(String str, String str2);

    /* renamed from: i */
    void mo1157i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* renamed from: v */
    void mo1161v(String str, String str2);

    /* renamed from: v */
    void mo1162v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo1163w(String str, String str2);

    /* renamed from: w */
    void mo1164w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
