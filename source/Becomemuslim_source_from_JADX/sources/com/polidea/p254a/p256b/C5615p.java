package com.polidea.p254a.p256b;

import android.util.Log;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RxBleLog */
/* renamed from: com.polidea.a.b.p */
public class C5615p {
    /* renamed from: a */
    private static final Pattern f18750a = Pattern.compile("\\$\\d+$");
    /* renamed from: b */
    private static final ThreadLocal<String> f18751b = new ThreadLocal();
    /* renamed from: c */
    private static C5614a f18752c = new C70881();
    /* renamed from: d */
    private static int f18753d = Integer.MAX_VALUE;
    /* renamed from: e */
    private static C5614a f18754e = f18752c;

    /* compiled from: RxBleLog */
    /* renamed from: com.polidea.a.b.p$a */
    public interface C5614a {
        /* renamed from: a */
        void mo5027a(int i, String str, String str2);
    }

    /* compiled from: RxBleLog */
    /* renamed from: com.polidea.a.b.p$1 */
    static class C70881 implements C5614a {
        C70881() {
        }

        /* renamed from: a */
        public void mo5027a(int i, String str, String str2) {
            Log.println(i, str, str2);
        }
    }

    /* renamed from: a */
    public static void m23860a(int i) {
        f18753d = i;
    }

    /* renamed from: a */
    private static String m23859a() {
        String str = (String) f18751b.get();
        if (str != null) {
            f18751b.remove();
            return str;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length >= 5) {
            str = stackTrace[4].getClassName();
            Matcher matcher = f18750a.matcher(str);
            if (matcher.find()) {
                str = matcher.replaceAll("");
            }
            str = str.replace("Impl", "").replace("RxBle", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RxBle#");
            stringBuilder.append(str.substring(str.lastIndexOf(46) + 1));
            return stringBuilder.toString();
        }
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
    }

    /* renamed from: f */
    private static String m23872f(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    /* renamed from: a */
    public static void m23863a(String str, Object... objArr) {
        C5615p.m23862a(2, null, str, objArr);
    }

    /* renamed from: b */
    public static void m23865b(String str, Object... objArr) {
        C5615p.m23862a(3, null, str, objArr);
    }

    /* renamed from: a */
    public static void m23864a(Throwable th, String str, Object... objArr) {
        C5615p.m23862a(3, th, str, objArr);
    }

    /* renamed from: c */
    public static void m23868c(String str, Object... objArr) {
        C5615p.m23862a(4, null, str, objArr);
    }

    /* renamed from: d */
    public static void m23870d(String str, Object... objArr) {
        C5615p.m23862a(5, null, str, objArr);
    }

    /* renamed from: b */
    public static void m23866b(Throwable th, String str, Object... objArr) {
        C5615p.m23862a(5, th, str, objArr);
    }

    /* renamed from: e */
    public static void m23871e(String str, Object... objArr) {
        C5615p.m23862a(6, null, str, objArr);
    }

    /* renamed from: c */
    public static void m23869c(Throwable th, String str, Object... objArr) {
        C5615p.m23862a(6, th, str, objArr);
    }

    /* renamed from: a */
    private static void m23862a(int i, Throwable th, String str, Object... objArr) {
        if (i >= f18753d) {
            str = C5615p.m23872f(str, objArr);
            if (str != null) {
                if (str.length() != null) {
                    if (th != null) {
                        objArr = new StringBuilder();
                        objArr.append(str);
                        objArr.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                        objArr.append(Log.getStackTraceString(th));
                        str = objArr.toString();
                    }
                    C5615p.m23861a(i, C5615p.m23859a(), str);
                }
            }
            if (th != null) {
                str = Log.getStackTraceString(th);
                C5615p.m23861a(i, C5615p.m23859a(), str);
            }
        }
    }

    /* renamed from: a */
    private static void m23861a(int i, String str, String str2) {
        if (str2.length() < 4000) {
            f18754e.mo5027a(i, str, str2);
            return;
        }
        for (String a : str2.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            f18754e.mo5027a(i, str, a);
        }
    }

    /* renamed from: b */
    public static boolean m23867b(int i) {
        return f18753d <= i;
    }
}
