package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class LogRedirector {
    private static volatile Logger sLogger;

    public interface Logger {
        boolean isLoggable(String str, int i);

        void log(int i, String str, String str2);
    }

    public static void setLogger(Logger logger) {
        Util.throwIfNull(logger);
        Util.throwIfNotNull(sLogger);
        sLogger = logger;
    }

    /* renamed from: e */
    public static void m5731e(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(formatThrowable(th));
        m5730e(str, stringBuilder.toString());
    }

    /* renamed from: e */
    public static void m5730e(String str, String str2) {
        log(6, str, str2);
    }

    /* renamed from: w */
    public static void m5737w(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(formatThrowable(th));
        m5736w(str, stringBuilder.toString());
    }

    /* renamed from: w */
    public static void m5736w(String str, String str2) {
        log(5, str, str2);
    }

    /* renamed from: i */
    public static void m5733i(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(formatThrowable(th));
        m5732i(str, stringBuilder.toString());
    }

    /* renamed from: i */
    public static void m5732i(String str, String str2) {
        log(4, str, str2);
    }

    /* renamed from: d */
    public static void m5729d(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(formatThrowable(th));
        m5728d(str, stringBuilder.toString());
    }

    /* renamed from: d */
    public static void m5728d(String str, String str2) {
        log(3, str, str2);
    }

    /* renamed from: v */
    public static void m5735v(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(formatThrowable(th));
        m5734v(str, stringBuilder.toString());
    }

    /* renamed from: v */
    public static void m5734v(String str, String str2) {
        log(2, str, str2);
    }

    private static String formatThrowable(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace();
        printWriter.flush();
        return stringWriter.toString();
    }

    private static void log(int i, String str, String str2) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(i, str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }

    public static boolean isLoggable(String str, int i) {
        Logger logger = sLogger;
        if (logger != null) {
            return logger.isLoggable(str, i);
        }
        return Log.isLoggable(str, i);
    }
}
