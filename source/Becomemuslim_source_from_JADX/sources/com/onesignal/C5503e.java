package com.onesignal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: AndroidSupportV4Compat */
/* renamed from: com.onesignal.e */
class C5503e {

    /* compiled from: AndroidSupportV4Compat */
    /* renamed from: com.onesignal.e$a */
    static class C5499a {
        /* renamed from: a */
        static void m23436a(Activity activity, String[] strArr, int i) {
            C5500b.m23437a(activity, strArr, i);
        }
    }

    @TargetApi(23)
    /* compiled from: AndroidSupportV4Compat */
    /* renamed from: com.onesignal.e$b */
    static class C5500b {
        /* renamed from: a */
        static void m23437a(Activity activity, String[] strArr, int i) {
            if (activity instanceof C5502d) {
                ((C5502d) activity).m23440a(i);
            }
            activity.requestPermissions(strArr, i);
        }
    }

    /* compiled from: AndroidSupportV4Compat */
    /* renamed from: com.onesignal.e$c */
    static class C5501c {
        /* renamed from: a */
        static int m23439a(android.content.Context r2, java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x000d }
            r1 = android.os.Process.myUid();	 Catch:{ Throwable -> 0x000d }
            r2 = r2.checkPermission(r3, r0, r1);	 Catch:{ Throwable -> 0x000d }
            return r2;
        L_0x000d:
            r2 = "OneSignal";
            r3 = "checkSelfPermission failed, returning PERMISSION_DENIED";
            android.util.Log.e(r2, r3);
            r2 = -1;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.e.c.a(android.content.Context, java.lang.String):int");
        }

        /* renamed from: a */
        static int m23438a(Context context, int i) {
            if (VERSION.SDK_INT > 22) {
                return context.getColor(i);
            }
            return context.getResources().getColor(i);
        }
    }

    /* compiled from: AndroidSupportV4Compat */
    /* renamed from: com.onesignal.e$d */
    interface C5502d {
        /* renamed from: a */
        void m23440a(int i);
    }
}
