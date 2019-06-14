package com.facebook.common.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
    private String mApplicationTag = "unknown";
    private int mMinimumLoggingLevel = 5;

    public static FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    private FLogDefaultLoggingDelegate() {
    }

    public void setApplicationTag(String str) {
        this.mApplicationTag = str;
    }

    public void setMinimumLoggingLevel(int i) {
        this.mMinimumLoggingLevel = i;
    }

    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public boolean isLoggable(int i) {
        return this.mMinimumLoggingLevel <= i;
    }

    /* renamed from: v */
    public void mo1161v(String str, String str2) {
        println(2, str, str2);
    }

    /* renamed from: v */
    public void mo1162v(String str, String str2, Throwable th) {
        println(2, str, str2, th);
    }

    /* renamed from: d */
    public void mo1151d(String str, String str2) {
        println(3, str, str2);
    }

    /* renamed from: d */
    public void mo1152d(String str, String str2, Throwable th) {
        println(3, str, str2, th);
    }

    /* renamed from: i */
    public void mo1156i(String str, String str2) {
        println(4, str, str2);
    }

    /* renamed from: i */
    public void mo1157i(String str, String str2, Throwable th) {
        println(4, str, str2, th);
    }

    /* renamed from: w */
    public void mo1163w(String str, String str2) {
        println(5, str, str2);
    }

    /* renamed from: w */
    public void mo1164w(String str, String str2, Throwable th) {
        println(5, str, str2, th);
    }

    /* renamed from: e */
    public void mo1153e(String str, String str2) {
        println(6, str, str2);
    }

    /* renamed from: e */
    public void mo1154e(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    public void wtf(String str, String str2) {
        println(6, str, str2);
    }

    public void wtf(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    public void log(int i, String str, String str2) {
        println(i, str, str2);
    }

    private void println(int i, String str, String str2) {
        Log.println(i, prefixTag(str), str2);
    }

    private void println(int i, String str, String str2, Throwable th) {
        Log.println(i, prefixTag(str), getMsg(str2, th));
    }

    private String prefixTag(String str) {
        if (this.mApplicationTag == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mApplicationTag);
        stringBuilder.append(":");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String getMsg(String str, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('\n');
        stringBuilder.append(getStackTraceString(th));
        return stringBuilder.toString();
    }

    private static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
