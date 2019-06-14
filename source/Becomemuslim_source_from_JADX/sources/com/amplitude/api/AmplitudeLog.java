package com.amplitude.api;

import android.util.Log;

public class AmplitudeLog {
    protected static AmplitudeLog instance = new AmplitudeLog();
    private volatile boolean enableLogging = true;
    private volatile int logLevel = 4;

    public static AmplitudeLog getLogger() {
        return instance;
    }

    private AmplitudeLog() {
    }

    AmplitudeLog setEnableLogging(boolean z) {
        this.enableLogging = z;
        return instance;
    }

    AmplitudeLog setLogLevel(int i) {
        this.logLevel = i;
        return instance;
    }

    /* renamed from: d */
    int m3413d(String str, String str2) {
        return (!this.enableLogging || this.logLevel > 3) ? null : Log.d(str, str2);
    }

    /* renamed from: d */
    int m3414d(String str, String str2, Throwable th) {
        return (!this.enableLogging || this.logLevel > 3) ? null : Log.d(str, str2, th);
    }

    /* renamed from: e */
    int m3415e(String str, String str2) {
        return (!this.enableLogging || this.logLevel > 6) ? null : Log.e(str, str2);
    }

    /* renamed from: e */
    int m3416e(String str, String str2, Throwable th) {
        return (!this.enableLogging || this.logLevel > 6) ? null : Log.e(str, str2, th);
    }

    String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    /* renamed from: i */
    int m3417i(String str, String str2) {
        return (!this.enableLogging || this.logLevel > 4) ? null : Log.i(str, str2);
    }

    /* renamed from: i */
    int m3418i(String str, String str2, Throwable th) {
        return (!this.enableLogging || this.logLevel > 4) ? null : Log.i(str, str2, th);
    }

    boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }

    int println(int i, String str, String str2) {
        return Log.println(i, str, str2);
    }

    /* renamed from: v */
    int m3419v(String str, String str2) {
        return (!this.enableLogging || this.logLevel > 2) ? null : Log.v(str, str2);
    }

    /* renamed from: v */
    int m3420v(String str, String str2, Throwable th) {
        return (!this.enableLogging || this.logLevel > 2) ? null : Log.v(str, str2, th);
    }

    /* renamed from: w */
    int m3421w(String str, String str2) {
        return (!this.enableLogging || this.logLevel > 5) ? null : Log.w(str, str2);
    }

    /* renamed from: w */
    int m3423w(String str, Throwable th) {
        return (!this.enableLogging || this.logLevel > 5) ? null : Log.w(str, th);
    }

    /* renamed from: w */
    int m3422w(String str, String str2, Throwable th) {
        return (!this.enableLogging || this.logLevel > 5) ? null : Log.w(str, str2, th);
    }

    int wtf(String str, String str2) {
        return (!this.enableLogging || this.logLevel > 7) ? null : Log.wtf(str, str2);
    }

    int wtf(String str, Throwable th) {
        return (!this.enableLogging || this.logLevel > 7) ? null : Log.wtf(str, th);
    }

    int wtf(String str, String str2, Throwable th) {
        return (!this.enableLogging || this.logLevel > 7) ? null : Log.wtf(str, str2, th);
    }
}
