package com.p064b.p065a.p068c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6436o.C6435a;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: SessionProtobufHelper */
/* renamed from: com.b.a.c.ab */
class ab {
    /* renamed from: a */
    private static final C1017b f2856a = C1017b.m3494a(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    /* renamed from: b */
    private static final C1017b f2857b = C1017b.m3494a("Unity");

    /* renamed from: a */
    public static void m3480a(C1022e c1022e, String str, String str2, long j) {
        c1022e.m3533a(1, C1017b.m3494a(str2));
        c1022e.m3533a(2, C1017b.m3494a(str));
        c1022e.m3532a(3, j);
    }

    /* renamed from: a */
    public static void m3482a(C1022e c1022e, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        C1017b a = C1017b.m3494a(str);
        C1017b a2 = C1017b.m3494a(str2);
        C1017b a3 = C1017b.m3494a(str3);
        C1017b a4 = C1017b.m3494a(str4);
        C1017b a5 = C1017b.m3494a(str5);
        C1017b a6 = str6 != null ? C1017b.m3494a(str6) : null;
        c1022e.m3548g(7, 2);
        c1022e.m3550k(ab.m3465a(a, a2, a3, a4, a5, i, a6));
        c1022e.m3533a(1, a);
        c1022e.m3533a(2, a3);
        c1022e.m3533a(3, a4);
        c1022e.m3548g(5, 2);
        c1022e.m3550k(ab.m3463a(a2));
        c1022e.m3533a(1, a2);
        c1022e.m3533a(6, a5);
        if (a6 != null) {
            c1022e.m3533a(8, f2857b);
            c1022e.m3533a(9, a6);
        }
        c1022e.m3542b(10, i);
    }

    /* renamed from: a */
    public static void m3488a(C1022e c1022e, boolean z) {
        C1017b a = C1017b.m3494a(VERSION.RELEASE);
        C1017b a2 = C1017b.m3494a(VERSION.CODENAME);
        c1022e.m3548g(8, 2);
        c1022e.m3550k(ab.m3466a(a, a2, z));
        c1022e.m3542b(1, 3);
        c1022e.m3533a(2, a);
        c1022e.m3533a(3, a2);
        c1022e.m3534a(4, z);
    }

    /* renamed from: a */
    public static void m3479a(C1022e c1022e, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<C6435a, String> map, int i3, String str3, String str4) {
        C1022e c1022e2 = c1022e;
        C1017b a = C1017b.m3494a(str);
        C1017b a2 = ab.m3474a(str2);
        C1017b a3 = ab.m3474a(str4);
        C1017b a4 = ab.m3474a(str3);
        c1022e2.m3548g(9, 2);
        C1017b c1017b = a4;
        C1017b c1017b2 = a3;
        c1022e2.m3550k(ab.m3461a(i, a, a2, i2, j, j2, z, (Map) map, i3, a4, a3));
        c1022e2.m3533a(1, a);
        c1022e2.m3542b(3, i);
        c1022e2.m3533a(4, a2);
        c1022e2.m3531a(5, i2);
        c1022e2.m3532a(6, j);
        c1022e2.m3532a(7, j2);
        c1022e2.m3534a(10, z);
        for (Entry entry : map.entrySet()) {
            c1022e2.m3548g(11, 2);
            c1022e2.m3550k(ab.m3467a((C6435a) entry.getKey(), (String) entry.getValue()));
            c1022e2.m3542b(1, ((C6435a) entry.getKey()).f20788h);
            c1022e2.m3533a(2, C1017b.m3494a((String) entry.getValue()));
        }
        c1022e2.m3531a(12, i3);
        C1017b c1017b3 = c1017b;
        if (c1017b3 != null) {
            c1022e2.m3533a(13, c1017b3);
        }
        c1017b3 = c1017b2;
        if (c1017b3 != null) {
            c1022e2.m3533a(14, c1017b3);
        }
    }

    /* renamed from: a */
    public static void m3481a(C1022e c1022e, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        C1017b a = C1017b.m3494a(str);
        C1017b a2 = ab.m3474a(str2);
        C1017b a3 = ab.m3474a(str3);
        int b = C1022e.m3511b(1, a) + 0;
        if (str2 != null) {
            b += C1022e.m3511b(2, a2);
        }
        if (str3 != null) {
            b += C1022e.m3511b(3, a3);
        }
        c1022e.m3548g(6, 2);
        c1022e.m3550k(b);
        c1022e.m3533a(1, a);
        if (str2 != null) {
            c1022e.m3533a(2, a2);
        }
        if (str3 != null) {
            c1022e.m3533a(3, a3);
        }
    }

    /* renamed from: a */
    public static void m3477a(C1022e c1022e, long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, C1062t c1062t, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, float f, int i2, boolean z, long j2, long j3) {
        C1017b c1017b;
        C1022e c1022e2 = c1022e;
        String str4 = str3;
        C1017b a = C1017b.m3494a(str2);
        if (str4 == null) {
            c1017b = null;
        } else {
            c1017b = C1017b.m3494a(str4.replace("-", ""));
        }
        C1017b c1017b2 = c1017b;
        C1017b a2 = c1062t.m3657a();
        if (a2 == null) {
            C6514c.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        c1062t.m3661b();
        c1022e2.m3548g(10, 2);
        c1022e2.m3550k(ab.m3462a(j, str, th, thread, stackTraceElementArr, threadArr, (List) list, 8, (Map) map, runningAppProcessInfo, i, a, c1017b2, f, i2, z, j2, j3, a2));
        c1022e2.m3532a(1, j);
        c1022e2.m3533a(2, C1017b.m3494a(str));
        C1017b c1017b3 = a2;
        ab.m3486a(c1022e, th, thread, stackTraceElementArr, threadArr, (List) list, 8, a, c1017b2, (Map) map, runningAppProcessInfo, i);
        ab.m3475a(c1022e, f, i2, z, i, j2, j3);
        ab.m3478a(c1022e2, c1017b3);
    }

    /* renamed from: a */
    private static void m3486a(C1022e c1022e, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1017b c1017b, C1017b c1017b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        c1022e.m3548g(3, 2);
        c1022e.m3550k(ab.m3473a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1017b, c1017b2, (Map) map, runningAppProcessInfo, i2));
        ab.m3485a(c1022e, th, thread, stackTraceElementArr, threadArr, list, i, c1017b, c1017b2);
        if (map != null && map.isEmpty() == null) {
            ab.m3487a(c1022e, (Map) map);
        }
        if (runningAppProcessInfo != null) {
            c1022e.m3534a(3, runningAppProcessInfo.importance != 100 ? true : null);
        }
        c1022e.m3531a(4, i2);
    }

    /* renamed from: a */
    private static void m3485a(C1022e c1022e, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1017b c1017b, C1017b c1017b2) {
        c1022e.m3548g(1, 2);
        c1022e.m3550k(ab.m3472a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1017b, c1017b2));
        ab.m3483a(c1022e, thread, stackTraceElementArr, 4, true);
        thread = threadArr.length;
        for (int i2 = 0; i2 < thread; i2++) {
            ab.m3483a(c1022e, threadArr[i2], (StackTraceElement[]) list.get(i2), 0, false);
        }
        ab.m3484a(c1022e, th, 1, i, 2);
        c1022e.m3548g(3, 2);
        c1022e.m3550k(ab.m3459a());
        c1022e.m3533a(1, f2856a);
        c1022e.m3533a(2, f2856a);
        c1022e.m3532a(3, 0);
        c1022e.m3548g(4, 2);
        c1022e.m3550k(ab.m3464a(c1017b, c1017b2));
        c1022e.m3532a(1, 0);
        c1022e.m3532a(2, 0);
        c1022e.m3533a(3, c1017b);
        if (c1017b2 != null) {
            c1022e.m3533a(4, c1017b2);
        }
    }

    /* renamed from: a */
    private static void m3487a(C1022e c1022e, Map<String, String> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            c1022e.m3548g(2, 2);
            c1022e.m3550k(ab.m3469a((String) entry.getKey(), (String) entry.getValue()));
            c1022e.m3533a(1, C1017b.m3494a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            c1022e.m3533a(2, C1017b.m3494a(str));
        }
    }

    /* renamed from: a */
    private static void m3484a(C1022e c1022e, Throwable th, int i, int i2, int i3) {
        c1022e.m3548g(i3, 2);
        c1022e.m3550k(ab.m3471a(th, 1, i2));
        c1022e.m3533a(1, C1017b.m3494a(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            c1022e.m3533a(3, C1017b.m3494a(localizedMessage));
        }
        int i4 = 0;
        for (StackTraceElement a : th.getStackTrace()) {
            ab.m3476a(c1022e, 4, a, true);
        }
        th = th.getCause();
        if (th == null) {
            return;
        }
        if (i < i2) {
            ab.m3484a(c1022e, th, i + 1, i2, 6);
            return;
        }
        while (th != null) {
            th = th.getCause();
            i4++;
        }
        c1022e.m3531a(7, i4);
    }

    /* renamed from: a */
    private static void m3483a(C1022e c1022e, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        c1022e.m3548g(1, 2);
        c1022e.m3550k(ab.m3470a(thread, stackTraceElementArr, i, z));
        c1022e.m3533a(1, C1017b.m3494a(thread.getName()));
        c1022e.m3531a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            ab.m3476a(c1022e, 3, a, z);
        }
    }

    /* renamed from: a */
    private static void m3476a(C1022e c1022e, int i, StackTraceElement stackTraceElement, boolean z) {
        c1022e.m3548g(i, 2);
        c1022e.m3550k(ab.m3468a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod() != 0) {
            c1022e.m3532a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            c1022e.m3532a(1, 0);
        }
        i = new StringBuilder();
        i.append(stackTraceElement.getClassName());
        i.append(".");
        i.append(stackTraceElement.getMethodName());
        c1022e.m3533a(2, C1017b.m3494a(i.toString()));
        if (stackTraceElement.getFileName() != 0) {
            c1022e.m3533a(3, C1017b.m3494a(stackTraceElement.getFileName()));
        }
        int i2 = 4;
        if (stackTraceElement.isNativeMethod() == 0 && stackTraceElement.getLineNumber() > 0) {
            c1022e.m3532a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        c1022e.m3531a(5, i2);
    }

    /* renamed from: a */
    private static void m3475a(C1022e c1022e, float f, int i, boolean z, int i2, long j, long j2) {
        c1022e.m3548g(5, 2);
        c1022e.m3550k(ab.m3460a(f, i, z, i2, j, j2));
        c1022e.m3530a(1, f);
        c1022e.m3544c(2, i);
        c1022e.m3534a((int) 4.2E-45f, z);
        c1022e.m3531a((int) 5.6E-45f, i2);
        c1022e.m3532a(5, j);
        c1022e.m3532a((int) 8.4E-45f, j2);
    }

    /* renamed from: a */
    private static void m3478a(C1022e c1022e, C1017b c1017b) {
        if (c1017b != null) {
            c1022e.m3548g(6, 2);
            c1022e.m3550k(ab.m3489b(c1017b));
            c1022e.m3533a(1, c1017b);
        }
    }

    /* renamed from: a */
    private static int m3465a(C1017b c1017b, C1017b c1017b2, C1017b c1017b3, C1017b c1017b4, C1017b c1017b5, int i, C1017b c1017b6) {
        c1017b = ((C1022e.m3511b(1, c1017b) + 0) + C1022e.m3511b(2, c1017b3)) + C1022e.m3511b(3, c1017b4);
        c1017b2 = ab.m3463a(c1017b2);
        c1017b = (c1017b + ((C1022e.m3524j(5) + C1022e.m3525l(c1017b2)) + c1017b2)) + C1022e.m3511b(6, c1017b5);
        if (c1017b6 != null) {
            c1017b = (c1017b + C1022e.m3511b(8, f2857b)) + C1022e.m3511b(9, c1017b6);
        }
        return c1017b + C1022e.m3519e(10, i);
    }

    /* renamed from: a */
    private static int m3463a(C1017b c1017b) {
        return C1022e.m3511b(1, c1017b) + 0;
    }

    /* renamed from: a */
    private static int m3466a(C1017b c1017b, C1017b c1017b2, boolean z) {
        return (((C1022e.m3519e(1, 3) + 0) + C1022e.m3511b(2, c1017b)) + C1022e.m3511b(3, c1017b2)) + C1022e.m3512b(4, z);
    }

    /* renamed from: a */
    private static int m3467a(C6435a c6435a, String str) {
        return C1022e.m3519e(1, c6435a.f20788h) + C1022e.m3511b(2, C1017b.m3494a(str));
    }

    /* renamed from: a */
    private static int m3461a(int i, C1017b c1017b, C1017b c1017b2, int i2, long j, long j2, boolean z, Map<C6435a, String> map, int i3, C1017b c1017b3, C1017b c1017b4) {
        int i4 = 0;
        c1017b = (C1022e.m3511b(1, c1017b) + null) + C1022e.m3519e(3, i);
        if (c1017b2 == null) {
            i = 0;
        } else {
            i = C1022e.m3511b(4, c1017b2);
        }
        c1017b = ((((c1017b + i) + C1022e.m3516d(5, i2)) + C1022e.m3510b(6, j)) + C1022e.m3510b(7, j2)) + C1022e.m3512b(10, z);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                c1017b2 = ab.m3467a((C6435a) entry.getKey(), (String) entry.getValue());
                c1017b += (C1022e.m3524j(11) + C1022e.m3525l(c1017b2)) + c1017b2;
            }
        }
        c1017b += C1022e.m3516d(12, i3);
        if (c1017b3 == null) {
            i = 0;
        } else {
            i = C1022e.m3511b(13, c1017b3);
        }
        c1017b += i;
        if (c1017b4 != null) {
            i4 = C1022e.m3511b(14, c1017b4);
        }
        return c1017b + i4;
    }

    /* renamed from: a */
    private static int m3464a(C1017b c1017b, C1017b c1017b2) {
        int b = ((C1022e.m3510b(1, 0) + 0) + C1022e.m3510b(2, 0)) + C1022e.m3511b(3, c1017b);
        return c1017b2 != null ? b + C1022e.m3511b(4, c1017b2) : b;
    }

    /* renamed from: a */
    private static int m3462a(long j, String str, Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2, C1017b c1017b, C1017b c1017b2, float f, int i3, boolean z, long j2, long j3, C1017b c1017b3) {
        long j4 = j;
        int b = (C1022e.m3510b(1, j) + 0) + C1022e.m3511b(2, C1017b.m3494a(str));
        int a = ab.m3473a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1017b, c1017b2, (Map) map, runningAppProcessInfo, i2);
        b += (C1022e.m3524j(3) + C1022e.m3525l(a)) + a;
        a = ab.m3460a(f, i3, z, i2, j2, j3);
        b += (C1022e.m3524j(5) + C1022e.m3525l(a)) + a;
        if (c1017b3 == null) {
            return b;
        }
        a = ab.m3489b(c1017b3);
        return b + ((C1022e.m3524j(6) + C1022e.m3525l(a)) + a);
    }

    /* renamed from: a */
    private static int m3473a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1017b c1017b, C1017b c1017b2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        th = ab.m3472a(th, thread, stackTraceElementArr, threadArr, (List) list, i, c1017b, c1017b2);
        stackTraceElementArr = (C1022e.m3524j(1) + C1022e.m3525l(th)) + th;
        boolean z = null;
        stackTraceElementArr += null;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                list = ab.m3469a((String) entry.getKey(), (String) entry.getValue());
                stackTraceElementArr += (C1022e.m3524j(2) + C1022e.m3525l(list)) + list;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance != 100) {
                z = true;
            }
            stackTraceElementArr += C1022e.m3512b((int) 3, z);
        }
        return stackTraceElementArr + C1022e.m3516d(4, i2);
    }

    /* renamed from: a */
    private static int m3472a(Throwable th, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1017b c1017b, C1017b c1017b2) {
        thread = ab.m3470a(thread, stackTraceElementArr, 4, true);
        stackTraceElementArr = ((C1022e.m3524j(1) + C1022e.m3525l(thread)) + thread) + null;
        int length = threadArr.length;
        int i2 = stackTraceElementArr;
        for (stackTraceElementArr = null; stackTraceElementArr < length; stackTraceElementArr++) {
            int a = ab.m3470a(threadArr[stackTraceElementArr], (StackTraceElement[]) list.get(stackTraceElementArr), 0, false);
            i2 += (C1022e.m3524j(1) + C1022e.m3525l(a)) + a;
        }
        th = ab.m3471a(th, 1, i);
        i2 += (C1022e.m3524j(2) + C1022e.m3525l(th)) + th;
        th = ab.m3459a();
        i2 += (C1022e.m3524j(3) + C1022e.m3525l(th)) + th;
        th = ab.m3464a(c1017b, c1017b2);
        return i2 + ((C1022e.m3524j(3) + C1022e.m3525l(th)) + th);
    }

    /* renamed from: a */
    private static int m3469a(String str, String str2) {
        str = C1022e.m3511b(1, C1017b.m3494a(str));
        if (str2 == null) {
            str2 = "";
        }
        return str + C1022e.m3511b(2, C1017b.m3494a(str2));
    }

    /* renamed from: a */
    private static int m3460a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((C1022e.m3509b(1, f) + 0) + C1022e.m3521f(2, i)) + C1022e.m3512b(3, z)) + C1022e.m3516d(4, i2)) + C1022e.m3510b(5, j)) + C1022e.m3510b(6, j2);
    }

    /* renamed from: b */
    private static int m3489b(C1017b c1017b) {
        return C1022e.m3511b(1, c1017b);
    }

    /* renamed from: a */
    private static int m3471a(Throwable th, int i, int i2) {
        int i3 = 0;
        int b = C1022e.m3511b(1, C1017b.m3494a(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += C1022e.m3511b(3, C1017b.m3494a(localizedMessage));
        }
        int i4 = b;
        for (StackTraceElement a : th.getStackTrace()) {
            int a2 = ab.m3468a(a, true);
            i4 += (C1022e.m3524j(4) + C1022e.m3525l(a2)) + a2;
        }
        th = th.getCause();
        if (th == null) {
            return i4;
        }
        if (i < i2) {
            th = ab.m3471a(th, i + 1, i2);
            return i4 + ((C1022e.m3524j(6) + C1022e.m3525l(th)) + th);
        }
        while (th != null) {
            th = th.getCause();
            i3++;
        }
        return i4 + C1022e.m3516d(7, i3);
    }

    /* renamed from: a */
    private static int m3459a() {
        return ((C1022e.m3511b(1, f2856a) + 0) + C1022e.m3511b(2, f2856a)) + C1022e.m3510b(3, 0);
    }

    /* renamed from: a */
    private static int m3468a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i = 0;
        if (stackTraceElement.isNativeMethod()) {
            b = C1022e.m3510b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = C1022e.m3510b(1, 0) + 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        b += C1022e.m3511b(2, C1017b.m3494a(stringBuilder.toString()));
        if (stackTraceElement.getFileName() != null) {
            b += C1022e.m3511b(3, C1017b.m3494a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            b += C1022e.m3510b(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i = 2;
        }
        return b + C1022e.m3516d(5, i);
    }

    /* renamed from: a */
    private static int m3470a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        thread = C1022e.m3511b(1, C1017b.m3494a(thread.getName())) + C1022e.m3516d(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = ab.m3468a(a, z);
            thread += (C1022e.m3524j(3) + C1022e.m3525l(a2)) + a2;
        }
        return thread;
    }

    /* renamed from: a */
    private static C1017b m3474a(String str) {
        return str == null ? null : C1017b.m3494a(str);
    }
}
