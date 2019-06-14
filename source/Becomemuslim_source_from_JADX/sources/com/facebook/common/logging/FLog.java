package com.facebook.common.logging;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    /* renamed from: v */
    public static void m5702v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m5703v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(str, formatString(str2, obj));
        }
    }

    /* renamed from: v */
    public static void m5704v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m5705v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m5706v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m5694v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(getTag(cls), str);
        }
    }

    /* renamed from: v */
    public static void m5695v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: v */
    public static void m5696v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: v */
    public static void m5697v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            m5694v((Class) cls, formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: v */
    public static void m5698v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: v */
    public static void m5708v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(str, formatString(str2, objArr));
        }
    }

    /* renamed from: v */
    public static void m5709v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1162v(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m5700v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1161v(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: v */
    public static void m5701v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1162v(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: v */
    public static void m5707v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1162v(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m5699v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.mo1162v(getTag(cls), str, th);
        }
    }

    /* renamed from: d */
    public static void m5662d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m5663d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(str, formatString(str2, obj));
        }
    }

    /* renamed from: d */
    public static void m5664d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m5665d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m5666d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m5654d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(getTag(cls), str);
        }
    }

    /* renamed from: d */
    public static void m5655d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: d */
    public static void m5656d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: d */
    public static void m5657d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: d */
    public static void m5658d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: d */
    public static void m5668d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m5662d(str, formatString(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m5669d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            m5667d(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m5660d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1151d(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m5661d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1152d(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: d */
    public static void m5667d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1152d(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m5659d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.mo1152d(getTag(cls), str, th);
        }
    }

    /* renamed from: i */
    public static void m5686i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m5687i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(str, formatString(str2, obj));
        }
    }

    /* renamed from: i */
    public static void m5688i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(str, formatString(str2, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m5689i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m5690i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m5678i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(getTag(cls), str);
        }
    }

    /* renamed from: i */
    public static void m5679i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(getTag(cls), formatString(str, obj));
        }
    }

    /* renamed from: i */
    public static void m5680i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    /* renamed from: i */
    public static void m5681i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    /* renamed from: i */
    public static void m5682i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    /* renamed from: i */
    public static void m5692i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(str, formatString(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m5693i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1157i(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m5684i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1156i(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: i */
    public static void m5685i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.mo1157i(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: i */
    public static void m5691i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1157i(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m5683i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.mo1157i(getTag(cls), str, th);
        }
    }

    /* renamed from: w */
    public static void m5714w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1163w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m5710w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1163w(getTag(cls), str);
        }
    }

    /* renamed from: w */
    public static void m5716w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1163w(str, formatString(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m5717w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1164w(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m5712w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1163w(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: w */
    public static void m5713w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            m5711w((Class) cls, formatString(str, objArr), th);
        }
    }

    /* renamed from: w */
    public static void m5715w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1164w(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m5711w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.mo1164w(getTag(cls), str, th);
        }
    }

    /* renamed from: e */
    public static void m5674e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1153e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m5670e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1153e(getTag(cls), str);
        }
    }

    /* renamed from: e */
    public static void m5676e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1153e(str, formatString(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m5677e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1154e(str, formatString(str2, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m5672e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1153e(getTag(cls), formatString(str, objArr));
        }
    }

    /* renamed from: e */
    public static void m5673e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1154e(getTag(cls), formatString(str, objArr), th);
        }
    }

    /* renamed from: e */
    public static void m5675e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1154e(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m5671e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.mo1154e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
