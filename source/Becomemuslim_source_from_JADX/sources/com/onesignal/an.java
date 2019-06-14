package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.p015c.C0098a;
import android.support.p015c.C0104b;
import android.support.p015c.C0108d;

/* compiled from: OneSignalChromeTab */
class an {
    /* renamed from: a */
    private static boolean f18426a;

    /* compiled from: OneSignalChromeTab */
    /* renamed from: com.onesignal.an$a */
    private static class C6951a extends C0108d {
        /* renamed from: a */
        private Context f24810a;
        /* renamed from: b */
        private String f24811b;

        /* compiled from: OneSignalChromeTab */
        /* renamed from: com.onesignal.an$a$1 */
        class C69501 extends C0098a {
            /* renamed from: a */
            final /* synthetic */ C6951a f24809a;

            C69501(C6951a c6951a) {
                this.f24809a = c6951a;
            }

            /* renamed from: a */
            public void m32602a(int i, Bundle bundle) {
                super.a(i, bundle);
            }

            /* renamed from: a */
            public void m32603a(String str, Bundle bundle) {
                super.a(str, bundle);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        C6951a(Context context, String str) {
            this.f24810a = context;
            this.f24811b = str;
        }

        /* renamed from: a */
        public void m32604a(ComponentName componentName, C0104b c0104b) {
            if (c0104b != null) {
                c0104b.a(0);
                componentName = c0104b.a(new C69501(this));
                if (componentName != null) {
                    c0104b = new StringBuilder();
                    c0104b.append("https://onesignal.com/android_frame.html");
                    c0104b.append(this.f24811b);
                    componentName.a(Uri.parse(c0104b.toString()), null, null);
                }
            }
        }
    }

    /* renamed from: a */
    static void m23263a(android.content.Context r2, java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = f18426a;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = com.onesignal.am.f18409j;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        if (r4 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = "android.support.c.d";	 Catch:{ ClassNotFoundException -> 0x006f }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x006f }
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "?app_id=";
        r0.append(r1);
        r0.append(r3);
        r3 = "&user_id=";
        r0.append(r3);
        r0.append(r4);
        r3 = r0.toString();
        if (r5 == 0) goto L_0x0041;
    L_0x002d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "&ad_id=";
        r4.append(r3);
        r4.append(r5);
        r3 = r4.toString();
    L_0x0041:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = "&cbs_id=";
        r4.append(r3);
        r3 = new java.security.SecureRandom;
        r3.<init>();
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r3 = r3.nextInt(r5);
        r4.append(r3);
        r3 = r4.toString();
        r4 = new com.onesignal.an$a;
        r4.<init>(r2, r3);
        r3 = "com.android.chrome";
        r2 = android.support.p015c.C0104b.a(r2, r3, r4);
        f18426a = r2;
        return;
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.an.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
