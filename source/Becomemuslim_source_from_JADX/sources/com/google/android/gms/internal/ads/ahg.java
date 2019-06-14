package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ahg extends ahf {
    /* renamed from: s */
    private static final Object f28101s = new Object();
    /* renamed from: t */
    private static final String f28102t = ahg.class.getSimpleName();
    /* renamed from: u */
    private static boolean f28103u = false;
    /* renamed from: v */
    private static long f28104v = 0;
    /* renamed from: r */
    protected boolean f28105r = false;
    /* renamed from: w */
    private String f28106w;
    /* renamed from: x */
    private boolean f28107x = false;
    /* renamed from: y */
    private boolean f28108y = false;
    /* renamed from: z */
    private aij f28109z;

    protected ahg(Context context, String str, boolean z) {
        super(context);
        this.f28106w = str;
        this.f28105r = z;
    }

    /* renamed from: a */
    private static aig m36785a(ahz ahz, MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        Method a = ahz.m18455a("ryulhTIO44CH2QVINEPOtPkpQOSdbbq7HgisLeHH33VCs+TjwYWzYttvzJcQiI1k", "dnKLchXhJgI3U7L4th0PQJWe3DOIJJ7MUji5p7t5mjc=");
        if (a == null || motionEvent == null) {
            throw new ahw();
        }
        try {
            return new aig((String) a.invoke(null, new Object[]{motionEvent, displayMetrics}));
        } catch (Throwable e) {
            throw new ahw(e);
        }
    }

    /* renamed from: a */
    protected static synchronized void m36786a(Context context, boolean z) {
        synchronized (ahg.class) {
            if (!f28103u) {
                f28104v = System.currentTimeMillis() / 1000;
                a = m36788b(context, z);
                f28103u = true;
            }
        }
    }

    /* renamed from: a */
    private static void m36787a(List<Callable<Void>> list) {
        if (a != null) {
            ExecutorService c = a.m18460c();
            if (!(c == null || list.isEmpty())) {
                try {
                    c.invokeAll(list, ((Long) aph.m18688f().m18889a(asp.bD)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(f28102t, String.format("class methods got exception: %s", new Object[]{aih.m18480a(e)}));
                }
            }
        }
    }

    /* renamed from: b */
    private static ahz m36788b(Context context, boolean z) {
        if (a == null) {
            synchronized (f28101s) {
                if (a == null) {
                    ahz a = ahz.m18443a(context, "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", z);
                    if (a.m18459b()) {
                        if (((Boolean) aph.m18688f().m18889a(asp.bJ)).booleanValue()) {
                            a.m18457a("4o7tecxtkw7XaNt5hPj+0H1LvOi0SgxCIJTY9VcbazM/HSl/sFlxBFwnc8glnvoB", "RgSY6YxU2k1vLXOV3vapBnQwJDzYDlmX50wbm2tDcnw=", new Class[0]);
                        }
                        a.m18457a("1QeH3Cf7T53ayw17Ebbo9YTdhU+IFx0X5nCtC5gZQym4uicOVPXxYWmMK9k58i8n", "bHJRpFJ+2R5LAbYQUBDMyfYpLd1oiGixlpIqMJOBQPY=", Context.class);
                        a.m18457a("1DzTSPdcTVkbB0cTQEaPo/MU1E1TGypt38nYJILt/8CcQbOuYjF6hLShUHnLb5uw", "dkCo8xze5sFyp7Msrb8F1JKjVIP7LutspgZPYQvsMlo=", Context.class);
                        a.m18457a("+8WN7RfVBrTKK5NXM+y9JA4Ygu2jPZokHNFGgulhBRZ32uCnyKWWGQNTE1weoQCM", "peILYfFejTn8xmazfpiZWeK2eaYjjxEBmAZ8bUD9PWU=", Context.class);
                        a.m18457a("6hrke/fCJ5tLCck7L6DvYxDB/To2PLUVGD3lbM1fdL2y9IScTypVRvrPFLLn4rDM", "+GAY853+DQRMYkeMG8Hbv1THvRgwf43Jh+3p4yQDqGw=", Context.class);
                        a.m18457a("f8J+j+UhiTEjRF3iyDcFnM9Rm6LC/P+2PE2qff5S0gHSDPzrH4HNcnCaI+twvhbv", "MOBosqV6pejtL/WEgsHP3Y2p2WtApcEEa2XyqqRQCo0=", Context.class);
                        a.m18457a("bYi99wWoqjOnUF4nnSWQsu9qLqARRsoauNez1uhJPws2YAlolLPh/xgKDnyI06MJ", "pjeIE8EsMfMk4SIebXHXNWKXTpK8v5vG6YqOxp1QH1M=", Context.class);
                        a.m18457a("ug+duzFNTlMWhYez8qKOR3bxkM8vLOPy9xVUBCCMTrplDFf/BnF2bNmA7hw0iYtI", "ogMtakENM6NAXJL7DCVTIbgawd5T3ZVhEaXugMAz+D4=", Context.class);
                        a.m18457a("PRnAd1qZLf3/u2x/ZslcDq2vQzDbmFHkH/jSij536nFGwYo+g6o8PpQOJcDeuz++", "99eM4BYfXxOCBAhS2wQJENWQ4BMWrR/wKqrfHx1Ws8w=", Context.class);
                        a.m18457a("ryulhTIO44CH2QVINEPOtPkpQOSdbbq7HgisLeHH33VCs+TjwYWzYttvzJcQiI1k", "dnKLchXhJgI3U7L4th0PQJWe3DOIJJ7MUji5p7t5mjc=", MotionEvent.class, DisplayMetrics.class);
                        a.m18457a("oT49Nu6m3oNdAQwbQzvwr/RE4TwZbR8mJKypakrI/GqBgyD2niyVic8N9UaqvU10", "LS3Cw7DlWSqpRsXrajoVsCxXOedCBnQXFZcLjXzD8so=", MotionEvent.class, DisplayMetrics.class);
                        a.m18457a("1GzFbNgtZBsZ6xBrCbOvmw4GuyabWdtXgJqf+Aoik3E00oSTfDga4UiXvbD1YLYB", "1EiWqNFog84woyMiTveFonfDO5rsRz44QrKedC4xw+8=", new Class[0]);
                        a.m18457a("R1L5/7J00Fko/kDi6VDsBhCzpp4/7wzabnzdihUS7rPLvaXLFWrERChyvYYgVJRF", "4WtEOgM4wQ7wiw1OB3pMyAbaplBizcjE6LRBT/nrDgM=", new Class[0]);
                        a.m18457a("uFEr0moMuWuurgrUpfSBjyUksFv6IqKMSuNqo2jCjRmu9JHDaSBf9LDKs2u/XE/B", "hDtufeJTxJSs5qQMCIPuyzc9ZPOtO/34yyf8Kf44rGo=", new Class[0]);
                        a.m18457a("C4t4eP72HKoZsX62gBXGicLgvQbyKikYhXkvESjpMVAOEyUibmrLmpkJ5lZygzZE", "onbJNRechKgg7ilJYzLDEQ07M0uNlDZp05nZ4h6WJ40=", new Class[0]);
                        a.m18457a("YOE4tLd8IhAbsNGoUEFHfu51/79yG0YlK4bMxi/e6gOIrtpqPN+TQgqpfYNBoiRy", "aFY444Zz3/sMYl+Q7uujofvlLWJ37651UMbaKJCFBnU=", new Class[0]);
                        a.m18457a("Q7gHsedaZvBKvqRLQGMIPKihViSMmXus6bBgU0lNdv+Pm9sSlP+Z+JltWG56lF1K", "mrdNgIRzsAu+cEIamFRkeCivuYIijUjvD76p38JyQec=", new Class[0]);
                        a.m18457a("LJD7GILw6ox/o3kYqhR5FF4FDylErrAaJ66Y8V8gtnNGF8DcetGJrYvTlHeK8kyR", "GKdCM/OywOIR4FMFS5XrDdTIpVvhoMFma/KSfRUdsbQ=", Context.class, Boolean.TYPE, Boolean.TYPE);
                        a.m18457a("nXKe8Ev09tosW935mj67BeJvnsHiQzgrotB4vyuZm+aJQgx77SXcf757aVGtnDOm", "yl+F7AaTCLci2yEfPOMTGPVVFLoqw9fKWSf4HTpN46M=", StackTraceElement[].class);
                        a.m18457a("j5/WVRJsgiWNVIg0a6aXYQYocHm4rEEozf0LrIkPezct93ISwgyVBTLRIkEvztpn", "gCYklRkrI0pyKJ3j1u5Yl6Jj12a6PD1K39diuw7+f7o=", View.class, DisplayMetrics.class);
                        a.m18457a("WiMYovSpRj6RF1r6zXON0hYVyLxgllUAYyMyyeBevdbJbdYcoBpd8nDjCwwclcSu", "vpq7z91A+vN3MIS65A+GwiFRgEFOFpQOdK5Z+mjW21w=", Context.class, Boolean.TYPE);
                        a.m18457a("wxabFp8V9bGKut15duzoi2M8ew0t/HWGFw3NoPp8pFanKwQpdIx0WzpFbmJaLX9T", "grSrEy+Ml8J7boJNrN9uNiXpddsqwR6A9NVesV/hHT8=", View.class, Activity.class, Boolean.TYPE);
                        a.m18457a("aH422z6bUtRL57gOABo0AU5IQDHmWvjsQgQZk64bzhjXVYUZmajAsUz/rrnMYVsw", "UAmRxgiWCEqHprf42V+e65VvIvUfFXeXbaMy5B8vzwA=", Long.TYPE);
                    }
                    a = a;
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    protected final long mo6075a(StackTraceElement[] stackTraceElementArr) {
        Method a = a.m18455a("nXKe8Ev09tosW935mj67BeJvnsHiQzgrotB4vyuZm+aJQgx77SXcf757aVGtnDOm", "yl+F7AaTCLci2yEfPOMTGPVVFLoqw9fKWSf4HTpN46M=");
        if (a == null || stackTraceElementArr == null) {
            throw new ahw();
        }
        try {
            return new ahx((String) a.invoke(null, new Object[]{stackTraceElementArr})).f23619a.longValue();
        } catch (Throwable e) {
            throw new ahw(e);
        }
    }

    /* renamed from: a */
    protected final com.google.android.gms.internal.ads.aaa mo6076a(android.content.Context r16, android.view.View r17, android.app.Activity r18) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r15 = this;
        r0 = r15;
        r10 = new com.google.android.gms.internal.ads.aaa;
        r10.<init>();
        r1 = r0.f28106w;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0012;
    L_0x000e:
        r1 = r0.f28106w;
        r10.f27953b = r1;
    L_0x0012:
        r1 = r0.f28105r;
        r2 = r16;
        r11 = m36788b(r2, r1);
        r1 = r11.m18459b();
        r2 = 0;
        r3 = 1;
        if (r1 != 0) goto L_0x003a;
    L_0x0022:
        r4 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r1 = java.lang.Long.valueOf(r4);
        r10.f27962k = r1;
        r1 = new java.util.concurrent.Callable[r3];
        r3 = new com.google.android.gms.internal.ads.aiu;
        r3.<init>(r11, r10);
        r1[r2] = r3;
        r1 = java.util.Arrays.asList(r1);
        r12 = r1;
        goto L_0x0342;
    L_0x003a:
        r1 = r0.b;	 Catch:{ ahw -> 0x005a }
        r4 = r0.q;	 Catch:{ ahw -> 0x005a }
        r1 = m36785a(r11, r1, r4);	 Catch:{ ahw -> 0x005a }
        r4 = r1.f23632a;	 Catch:{ ahw -> 0x005a }
        r10.f27958g = r4;	 Catch:{ ahw -> 0x005a }
        r4 = r1.f23633b;	 Catch:{ ahw -> 0x005a }
        r10.f27959h = r4;	 Catch:{ ahw -> 0x005a }
        r4 = r1.f23634c;	 Catch:{ ahw -> 0x005a }
        r10.f27960i = r4;	 Catch:{ ahw -> 0x005a }
        r4 = r0.p;	 Catch:{ ahw -> 0x005a }
        if (r4 == 0) goto L_0x005a;	 Catch:{ ahw -> 0x005a }
    L_0x0052:
        r4 = r1.f23635d;	 Catch:{ ahw -> 0x005a }
        r10.f27972u = r4;	 Catch:{ ahw -> 0x005a }
        r1 = r1.f23636e;	 Catch:{ ahw -> 0x005a }
        r10.f27973v = r1;	 Catch:{ ahw -> 0x005a }
    L_0x005a:
        r1 = new com.google.android.gms.internal.ads.abb;
        r1.<init>();
        r4 = r0.d;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x010f;
    L_0x0067:
        r4 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18482a(r4);
        if (r4 == 0) goto L_0x010f;
    L_0x006f:
        r4 = r0.k;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r4 = java.lang.Long.valueOf(r4);
        r1.f28002m = r4;
        r4 = r0.n;
        r5 = r0.l;
        r4 = r4 - r5;
        r4 = (double) r4;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r4 = java.lang.Long.valueOf(r4);
        r1.f28003n = r4;
        r4 = r0.o;
        r5 = r0.m;
        r4 = r4 - r5;
        r4 = (double) r4;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r4 = java.lang.Long.valueOf(r4);
        r1.f28004o = r4;
        r4 = r0.l;
        r4 = (double) r4;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r4 = java.lang.Long.valueOf(r4);
        r1.f28007r = r4;
        r4 = r0.m;
        r4 = (double) r4;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r4 = java.lang.Long.valueOf(r4);
        r1.f28008s = r4;
        r4 = r0.p;
        if (r4 == 0) goto L_0x010f;
    L_0x00c3:
        r4 = r0.b;
        if (r4 == 0) goto L_0x010f;
    L_0x00c7:
        r4 = r0.l;
        r5 = r0.n;
        r4 = r4 - r5;
        r5 = r0.b;
        r5 = r5.getRawX();
        r4 = r4 + r5;
        r5 = r0.b;
        r5 = r5.getX();
        r4 = r4 - r5;
        r4 = (double) r4;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x00eb;
    L_0x00e5:
        r4 = java.lang.Long.valueOf(r4);
        r1.f28005p = r4;
    L_0x00eb:
        r4 = r0.m;
        r5 = r0.o;
        r4 = r4 - r5;
        r5 = r0.b;
        r5 = r5.getRawY();
        r4 = r4 + r5;
        r5 = r0.b;
        r5 = r5.getY();
        r4 = r4 - r5;
        r4 = (double) r4;
        r8 = r0.q;
        r4 = com.google.android.gms.internal.ads.aih.m18477a(r4, r8);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x010f;
    L_0x0109:
        r4 = java.lang.Long.valueOf(r4);
        r1.f28006q = r4;
    L_0x010f:
        r4 = 0;
        r5 = r0.b;	 Catch:{ ahw -> 0x018e }
        r5 = r15.mo6078b(r5);	 Catch:{ ahw -> 0x018e }
        r8 = r5.f23632a;	 Catch:{ ahw -> 0x018e }
        r1.f27990a = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r5.f23633b;	 Catch:{ ahw -> 0x018e }
        r1.f27991b = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r5.f23634c;	 Catch:{ ahw -> 0x018e }
        r1.f27997h = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r0.p;	 Catch:{ ahw -> 0x018e }
        if (r8 == 0) goto L_0x018e;	 Catch:{ ahw -> 0x018e }
    L_0x0126:
        r8 = r5.f23636e;	 Catch:{ ahw -> 0x018e }
        r1.f27992c = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r5.f23635d;	 Catch:{ ahw -> 0x018e }
        r1.f27994e = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r5.f23637f;	 Catch:{ ahw -> 0x018e }
        r8 = r8.longValue();	 Catch:{ ahw -> 0x018e }
        r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));	 Catch:{ ahw -> 0x018e }
        if (r8 == 0) goto L_0x013a;	 Catch:{ ahw -> 0x018e }
    L_0x0138:
        r8 = 1;	 Catch:{ ahw -> 0x018e }
        goto L_0x013b;	 Catch:{ ahw -> 0x018e }
    L_0x013a:
        r8 = 0;	 Catch:{ ahw -> 0x018e }
    L_0x013b:
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ ahw -> 0x018e }
        r1.f27996g = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r0.e;	 Catch:{ ahw -> 0x018e }
        r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));	 Catch:{ ahw -> 0x018e }
        if (r8 <= 0) goto L_0x0173;	 Catch:{ ahw -> 0x018e }
    L_0x0147:
        r8 = r0.q;	 Catch:{ ahw -> 0x018e }
        r8 = com.google.android.gms.internal.ads.aih.m18482a(r8);	 Catch:{ ahw -> 0x018e }
        if (r8 == 0) goto L_0x015f;	 Catch:{ ahw -> 0x018e }
    L_0x014f:
        r8 = r0.j;	 Catch:{ ahw -> 0x018e }
        r8 = (double) r8;	 Catch:{ ahw -> 0x018e }
        r12 = r0.e;	 Catch:{ ahw -> 0x018e }
        r12 = (double) r12;	 Catch:{ ahw -> 0x018e }
        r8 = r8 / r12;	 Catch:{ ahw -> 0x018e }
        r8 = java.lang.Math.round(r8);	 Catch:{ ahw -> 0x018e }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ ahw -> 0x018e }
        goto L_0x0160;	 Catch:{ ahw -> 0x018e }
    L_0x015f:
        r8 = r4;	 Catch:{ ahw -> 0x018e }
    L_0x0160:
        r1.f27993d = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r0.i;	 Catch:{ ahw -> 0x018e }
        r8 = (double) r8;	 Catch:{ ahw -> 0x018e }
        r12 = r0.e;	 Catch:{ ahw -> 0x018e }
        r12 = (double) r12;	 Catch:{ ahw -> 0x018e }
        r8 = r8 / r12;	 Catch:{ ahw -> 0x018e }
        r8 = java.lang.Math.round(r8);	 Catch:{ ahw -> 0x018e }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ ahw -> 0x018e }
        r1.f27995f = r8;	 Catch:{ ahw -> 0x018e }
    L_0x0173:
        r8 = r5.f23640i;	 Catch:{ ahw -> 0x018e }
        r1.f27999j = r8;	 Catch:{ ahw -> 0x018e }
        r8 = r5.f23641j;	 Catch:{ ahw -> 0x018e }
        r1.f27998i = r8;	 Catch:{ ahw -> 0x018e }
        r5 = r5.f23642k;	 Catch:{ ahw -> 0x018e }
        r8 = r5.longValue();	 Catch:{ ahw -> 0x018e }
        r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));	 Catch:{ ahw -> 0x018e }
        if (r5 == 0) goto L_0x0187;	 Catch:{ ahw -> 0x018e }
    L_0x0185:
        r5 = 1;	 Catch:{ ahw -> 0x018e }
        goto L_0x0188;	 Catch:{ ahw -> 0x018e }
    L_0x0187:
        r5 = 0;	 Catch:{ ahw -> 0x018e }
    L_0x0188:
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ ahw -> 0x018e }
        r1.f28000k = r5;	 Catch:{ ahw -> 0x018e }
    L_0x018e:
        r8 = r0.h;
        r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x019c;
    L_0x0194:
        r8 = r0.h;
        r5 = java.lang.Long.valueOf(r8);
        r1.f28001l = r5;
    L_0x019c:
        r10.f27938K = r1;
        r8 = r0.d;
        r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x01ac;
    L_0x01a4:
        r8 = r0.d;
        r1 = java.lang.Long.valueOf(r8);
        r10.f27976y = r1;
    L_0x01ac:
        r8 = r0.e;
        r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x01ba;
    L_0x01b2:
        r8 = r0.e;
        r1 = java.lang.Long.valueOf(r8);
        r10.f27975x = r1;
    L_0x01ba:
        r8 = r0.f;
        r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x01c8;
    L_0x01c0:
        r8 = r0.f;
        r1 = java.lang.Long.valueOf(r8);
        r10.f27974w = r1;
    L_0x01c8:
        r8 = r0.g;
        r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x01d6;
    L_0x01ce:
        r5 = r0.g;
        r1 = java.lang.Long.valueOf(r5);
        r10.f27977z = r1;
    L_0x01d6:
        r1 = r0.c;	 Catch:{ ahw -> 0x0209 }
        r1 = r1.size();	 Catch:{ ahw -> 0x0209 }
        r1 = r1 - r3;	 Catch:{ ahw -> 0x0209 }
        if (r1 <= 0) goto L_0x020b;	 Catch:{ ahw -> 0x0209 }
    L_0x01df:
        r3 = new com.google.android.gms.internal.ads.abb[r1];	 Catch:{ ahw -> 0x0209 }
        r10.f27939L = r3;	 Catch:{ ahw -> 0x0209 }
    L_0x01e3:
        if (r2 >= r1) goto L_0x020b;	 Catch:{ ahw -> 0x0209 }
    L_0x01e5:
        r3 = a;	 Catch:{ ahw -> 0x0209 }
        r5 = r0.c;	 Catch:{ ahw -> 0x0209 }
        r5 = r5.get(r2);	 Catch:{ ahw -> 0x0209 }
        r5 = (android.view.MotionEvent) r5;	 Catch:{ ahw -> 0x0209 }
        r6 = r0.q;	 Catch:{ ahw -> 0x0209 }
        r3 = m36785a(r3, r5, r6);	 Catch:{ ahw -> 0x0209 }
        r5 = new com.google.android.gms.internal.ads.abb;	 Catch:{ ahw -> 0x0209 }
        r5.<init>();	 Catch:{ ahw -> 0x0209 }
        r6 = r3.f23632a;	 Catch:{ ahw -> 0x0209 }
        r5.f27990a = r6;	 Catch:{ ahw -> 0x0209 }
        r3 = r3.f23633b;	 Catch:{ ahw -> 0x0209 }
        r5.f27991b = r3;	 Catch:{ ahw -> 0x0209 }
        r3 = r10.f27939L;	 Catch:{ ahw -> 0x0209 }
        r3[r2] = r5;	 Catch:{ ahw -> 0x0209 }
        r2 = r2 + 1;
        goto L_0x01e3;
    L_0x0209:
        r10.f27939L = r4;
    L_0x020b:
        r12 = new java.util.ArrayList;
        r12.<init>();
        r1 = r11.m18460c();
        if (r1 == 0) goto L_0x0342;
    L_0x0216:
        r13 = r11.m18471n();
        r1 = new com.google.android.gms.internal.ads.aiu;
        r1.<init>(r11, r10);
        r12.add(r1);
        r8 = new com.google.android.gms.internal.ads.aix;
        r3 = "uFEr0moMuWuurgrUpfSBjyUksFv6IqKMSuNqo2jCjRmu9JHDaSBf9LDKs2u/XE/B";
        r4 = "hDtufeJTxJSs5qQMCIPuyzc9ZPOtO/34yyf8Kf44rGo=";
        r7 = 1;
        r1 = r8;
        r2 = r11;
        r5 = r10;
        r6 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r14 = new com.google.android.gms.internal.ads.ais;
        r3 = "1GzFbNgtZBsZ6xBrCbOvmw4GuyabWdtXgJqf+Aoik3E00oSTfDga4UiXvbD1YLYB";
        r4 = "1EiWqNFog84woyMiTveFonfDO5rsRz44QrKedC4xw+8=";
        r6 = f28104v;
        r9 = 25;
        r1 = r14;
        r8 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8, r9);
        r12.add(r14);
        r8 = new com.google.android.gms.internal.ads.air;
        r3 = "C4t4eP72HKoZsX62gBXGicLgvQbyKikYhXkvESjpMVAOEyUibmrLmpkJ5lZygzZE";
        r4 = "onbJNRechKgg7ilJYzLDEQ07M0uNlDZp05nZ4h6WJ40=";
        r7 = 44;
        r1 = r8;
        r6 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.aiw;
        r3 = "f8J+j+UhiTEjRF3iyDcFnM9Rm6LC/P+2PE2qff5S0gHSDPzrH4HNcnCaI+twvhbv";
        r4 = "MOBosqV6pejtL/WEgsHP3Y2p2WtApcEEa2XyqqRQCo0=";
        r7 = 12;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.aiy;
        r3 = "bYi99wWoqjOnUF4nnSWQsu9qLqARRsoauNez1uhJPws2YAlolLPh/xgKDnyI06MJ";
        r4 = "pjeIE8EsMfMk4SIebXHXNWKXTpK8v5vG6YqOxp1QH1M=";
        r7 = 3;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.aiv;
        r3 = "YOE4tLd8IhAbsNGoUEFHfu51/79yG0YlK4bMxi/e6gOIrtpqPN+TQgqpfYNBoiRy";
        r4 = "aFY444Zz3/sMYl+Q7uujofvlLWJ37651UMbaKJCFBnU=";
        r7 = 22;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.aiq;
        r3 = "6hrke/fCJ5tLCck7L6DvYxDB/To2PLUVGD3lbM1fdL2y9IScTypVRvrPFLLn4rDM";
        r4 = "+GAY853+DQRMYkeMG8Hbv1THvRgwf43Jh+3p4yQDqGw=";
        r7 = 5;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.ajg;
        r3 = "ug+duzFNTlMWhYez8qKOR3bxkM8vLOPy9xVUBCCMTrplDFf/BnF2bNmA7hw0iYtI";
        r4 = "ogMtakENM6NAXJL7DCVTIbgawd5T3ZVhEaXugMAz+D4=";
        r7 = 48;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.ain;
        r3 = "PRnAd1qZLf3/u2x/ZslcDq2vQzDbmFHkH/jSij536nFGwYo+g6o8PpQOJcDeuz++";
        r4 = "99eM4BYfXxOCBAhS2wQJENWQ4BMWrR/wKqrfHx1Ws8w=";
        r7 = 49;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r8 = new com.google.android.gms.internal.ads.ajd;
        r3 = "Q7gHsedaZvBKvqRLQGMIPKihViSMmXus6bBgU0lNdv+Pm9sSlP+Z+JltWG56lF1K";
        r4 = "mrdNgIRzsAu+cEIamFRkeCivuYIijUjvD76p38JyQec=";
        r7 = 51;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r9 = new com.google.android.gms.internal.ads.ajc;
        r3 = "nXKe8Ev09tosW935mj67BeJvnsHiQzgrotB4vyuZm+aJQgx77SXcf757aVGtnDOm";
        r4 = "yl+F7AaTCLci2yEfPOMTGPVVFLoqw9fKWSf4HTpN46M=";
        r7 = 45;
        r1 = new java.lang.Throwable;
        r1.<init>();
        r8 = r1.getStackTrace();
        r1 = r9;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r12.add(r9);
        r9 = new com.google.android.gms.internal.ads.ajh;
        r3 = "j5/WVRJsgiWNVIg0a6aXYQYocHm4rEEozf0LrIkPezct93ISwgyVBTLRIkEvztpn";
        r4 = "gCYklRkrI0pyKJ3j1u5Yl6Jj12a6PD1K39diuw7+f7o=";
        r7 = 57;
        r1 = r9;
        r8 = r17;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r12.add(r9);
        r8 = new com.google.android.gms.internal.ads.aja;
        r3 = "WiMYovSpRj6RF1r6zXON0hYVyLxgllUAYyMyyeBevdbJbdYcoBpd8nDjCwwclcSu";
        r4 = "vpq7z91A+vN3MIS65A+GwiFRgEFOFpQOdK5Z+mjW21w=";
        r7 = 61;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r12.add(r8);
        r1 = com.google.android.gms.internal.ads.asp.bE;
        r2 = com.google.android.gms.internal.ads.aph.m18688f();
        r1 = r2.m18889a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x031c;
    L_0x0306:
        r14 = new com.google.android.gms.internal.ads.aim;
        r3 = "wxabFp8V9bGKut15duzoi2M8ew0t/HWGFw3NoPp8pFanKwQpdIx0WzpFbmJaLX9T";
        r4 = "grSrEy+Ml8J7boJNrN9uNiXpddsqwR6A9NVesV/hHT8=";
        r7 = 62;
        r1 = r14;
        r2 = r11;
        r5 = r10;
        r6 = r13;
        r8 = r17;
        r9 = r18;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9);
        r12.add(r14);
    L_0x031c:
        r1 = com.google.android.gms.internal.ads.asp.bG;
        r2 = com.google.android.gms.internal.ads.aph.m18688f();
        r1 = r2.m18889a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0342;
    L_0x032e:
        r9 = new com.google.android.gms.internal.ads.aje;
        r3 = "aH422z6bUtRL57gOABo0AU5IQDHmWvjsQgQZk64bzhjXVYUZmajAsUz/rrnMYVsw";
        r4 = "UAmRxgiWCEqHprf42V+e65VvIvUfFXeXbaMy5B8vzwA=";
        r7 = 53;
        r8 = r0.f28109z;
        r1 = r9;
        r2 = r11;
        r5 = r10;
        r6 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r12.add(r9);
    L_0x0342:
        m36787a(r12);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahg.a(android.content.Context, android.view.View, android.app.Activity):com.google.android.gms.internal.ads.aaa");
    }

    /* renamed from: a */
    protected final aaa mo6077a(Context context, ww wwVar) {
        aaa aaa = new aaa();
        if (!TextUtils.isEmpty(this.f28106w)) {
            aaa.f27953b = this.f28106w;
        }
        ahz b = m36788b(context, this.f28105r);
        if (b.m18460c() != null) {
            m36787a(mo6640a(b, aaa, null));
        }
        return aaa;
    }

    /* renamed from: a */
    protected List<Callable<Void>> mo6640a(ahz ahz, aaa aaa, ww wwVar) {
        int n = ahz.m18471n();
        List<Callable<Void>> arrayList = new ArrayList();
        if (ahz.m18459b()) {
            ahz ahz2 = ahz;
            aaa aaa2 = aaa;
            arrayList.add(new aip(ahz2, "LJD7GILw6ox/o3kYqhR5FF4FDylErrAaJ66Y8V8gtnNGF8DcetGJrYvTlHeK8kyR", "GKdCM/OywOIR4FMFS5XrDdTIpVvhoMFma/KSfRUdsbQ=", aaa2, n, 27, wwVar));
            arrayList.add(new ais(ahz2, "1GzFbNgtZBsZ6xBrCbOvmw4GuyabWdtXgJqf+Aoik3E00oSTfDga4UiXvbD1YLYB", "1EiWqNFog84woyMiTveFonfDO5rsRz44QrKedC4xw+8=", aaa2, f28104v, n, 25));
            int i = n;
            arrayList.add(new aix(ahz2, "uFEr0moMuWuurgrUpfSBjyUksFv6IqKMSuNqo2jCjRmu9JHDaSBf9LDKs2u/XE/B", "hDtufeJTxJSs5qQMCIPuyzc9ZPOtO/34yyf8Kf44rGo=", aaa2, i, 1));
            arrayList.add(new aiz(ahz2, "+8WN7RfVBrTKK5NXM+y9JA4Ygu2jPZokHNFGgulhBRZ32uCnyKWWGQNTE1weoQCM", "peILYfFejTn8xmazfpiZWeK2eaYjjxEBmAZ8bUD9PWU=", aaa2, i, 31));
            arrayList.add(new ajf(ahz2, "R1L5/7J00Fko/kDi6VDsBhCzpp4/7wzabnzdihUS7rPLvaXLFWrERChyvYYgVJRF", "4WtEOgM4wQ7wiw1OB3pMyAbaplBizcjE6LRBT/nrDgM=", aaa2, i, 33));
            arrayList.add(new aio(ahz2, "1DzTSPdcTVkbB0cTQEaPo/MU1E1TGypt38nYJILt/8CcQbOuYjF6hLShUHnLb5uw", "dkCo8xze5sFyp7Msrb8F1JKjVIP7LutspgZPYQvsMlo=", aaa2, i, 29));
            arrayList.add(new aiq(ahz2, "6hrke/fCJ5tLCck7L6DvYxDB/To2PLUVGD3lbM1fdL2y9IScTypVRvrPFLLn4rDM", "+GAY853+DQRMYkeMG8Hbv1THvRgwf43Jh+3p4yQDqGw=", aaa2, i, 5));
            arrayList.add(new aiw(ahz2, "f8J+j+UhiTEjRF3iyDcFnM9Rm6LC/P+2PE2qff5S0gHSDPzrH4HNcnCaI+twvhbv", "MOBosqV6pejtL/WEgsHP3Y2p2WtApcEEa2XyqqRQCo0=", aaa2, i, 12));
            arrayList.add(new aiy(ahz2, "bYi99wWoqjOnUF4nnSWQsu9qLqARRsoauNez1uhJPws2YAlolLPh/xgKDnyI06MJ", "pjeIE8EsMfMk4SIebXHXNWKXTpK8v5vG6YqOxp1QH1M=", aaa2, i, 3));
            arrayList.add(new air(ahz2, "C4t4eP72HKoZsX62gBXGicLgvQbyKikYhXkvESjpMVAOEyUibmrLmpkJ5lZygzZE", "onbJNRechKgg7ilJYzLDEQ07M0uNlDZp05nZ4h6WJ40=", aaa2, i, 44));
            arrayList.add(new aiv(ahz2, "YOE4tLd8IhAbsNGoUEFHfu51/79yG0YlK4bMxi/e6gOIrtpqPN+TQgqpfYNBoiRy", "aFY444Zz3/sMYl+Q7uujofvlLWJ37651UMbaKJCFBnU=", aaa2, i, 22));
            arrayList.add(new ajg(ahz2, "ug+duzFNTlMWhYez8qKOR3bxkM8vLOPy9xVUBCCMTrplDFf/BnF2bNmA7hw0iYtI", "ogMtakENM6NAXJL7DCVTIbgawd5T3ZVhEaXugMAz+D4=", aaa2, i, 48));
            arrayList.add(new ain(ahz2, "PRnAd1qZLf3/u2x/ZslcDq2vQzDbmFHkH/jSij536nFGwYo+g6o8PpQOJcDeuz++", "99eM4BYfXxOCBAhS2wQJENWQ4BMWrR/wKqrfHx1Ws8w=", aaa2, i, 49));
            arrayList.add(new ajd(ahz2, "Q7gHsedaZvBKvqRLQGMIPKihViSMmXus6bBgU0lNdv+Pm9sSlP+Z+JltWG56lF1K", "mrdNgIRzsAu+cEIamFRkeCivuYIijUjvD76p38JyQec=", aaa2, i, 51));
            arrayList.add(new aja(ahz2, "WiMYovSpRj6RF1r6zXON0hYVyLxgllUAYyMyyeBevdbJbdYcoBpd8nDjCwwclcSu", "vpq7z91A+vN3MIS65A+GwiFRgEFOFpQOdK5Z+mjW21w=", aaa2, i, 61));
            return arrayList;
        }
        aaa.f27962k = Long.valueOf(16384);
        return arrayList;
    }

    /* renamed from: a */
    public final void mo3815a(View view) {
        if (!((Boolean) aph.m18688f().m18889a(asp.bG)).booleanValue()) {
            return;
        }
        if (this.f28109z == null) {
            this.f28109z = new aij(a, view);
        } else {
            this.f28109z.m18491a(view);
        }
    }

    /* renamed from: b */
    protected final aig mo6078b(MotionEvent motionEvent) {
        Method a = a.m18455a("oT49Nu6m3oNdAQwbQzvwr/RE4TwZbR8mJKypakrI/GqBgyD2niyVic8N9UaqvU10", "LS3Cw7DlWSqpRsXrajoVsCxXOedCBnQXFZcLjXzD8so=");
        if (a == null || motionEvent == null) {
            throw new ahw();
        }
        try {
            return new aig((String) a.invoke(null, new Object[]{motionEvent, this.q}));
        } catch (Throwable e) {
            throw new ahw(e);
        }
    }
}
