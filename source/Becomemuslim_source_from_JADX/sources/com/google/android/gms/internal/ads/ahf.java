package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

public abstract class ahf implements ahe {
    /* renamed from: a */
    protected static volatile ahz f23588a;
    /* renamed from: b */
    protected MotionEvent f23589b;
    /* renamed from: c */
    protected LinkedList<MotionEvent> f23590c = new LinkedList();
    /* renamed from: d */
    protected long f23591d = 0;
    /* renamed from: e */
    protected long f23592e = 0;
    /* renamed from: f */
    protected long f23593f = 0;
    /* renamed from: g */
    protected long f23594g = 0;
    /* renamed from: h */
    protected long f23595h = 0;
    /* renamed from: i */
    protected long f23596i = 0;
    /* renamed from: j */
    protected long f23597j = 0;
    /* renamed from: k */
    protected double f23598k;
    /* renamed from: l */
    protected float f23599l;
    /* renamed from: m */
    protected float f23600m;
    /* renamed from: n */
    protected float f23601n;
    /* renamed from: o */
    protected float f23602o;
    /* renamed from: p */
    protected boolean f23603p = false;
    /* renamed from: q */
    protected DisplayMetrics f23604q;
    /* renamed from: r */
    private double f23605r;
    /* renamed from: s */
    private double f23606s;
    /* renamed from: t */
    private boolean f23607t = false;

    protected ahf(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = new java.util.LinkedList;
        r0.<init>();
        r2.f23590c = r0;
        r0 = 0;
        r2.f23591d = r0;
        r2.f23592e = r0;
        r2.f23593f = r0;
        r2.f23594g = r0;
        r2.f23595h = r0;
        r2.f23596i = r0;
        r2.f23597j = r0;
        r0 = 0;
        r2.f23607t = r0;
        r2.f23603p = r0;
        r0 = com.google.android.gms.internal.ads.asp.bL;	 Catch:{ Throwable -> 0x0044 }
        r1 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ Throwable -> 0x0044 }
        r0 = r1.m18889a(r0);	 Catch:{ Throwable -> 0x0044 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Throwable -> 0x0044 }
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x0044 }
        if (r0 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0044 }
    L_0x0031:
        com.google.android.gms.internal.ads.agj.m18411a();	 Catch:{ Throwable -> 0x0044 }
        goto L_0x003a;	 Catch:{ Throwable -> 0x0044 }
    L_0x0035:
        r0 = f23588a;	 Catch:{ Throwable -> 0x0044 }
        com.google.android.gms.internal.ads.aif.m18476a(r0);	 Catch:{ Throwable -> 0x0044 }
    L_0x003a:
        r3 = r3.getResources();	 Catch:{ Throwable -> 0x0044 }
        r3 = r3.getDisplayMetrics();	 Catch:{ Throwable -> 0x0044 }
        r2.f23604q = r3;	 Catch:{ Throwable -> 0x0044 }
    L_0x0044:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahf.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    private final java.lang.String m29921a(android.content.Context r1, java.lang.String r2, boolean r3, android.view.View r4, android.app.Activity r5, byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r3 == 0) goto L_0x000a;
    L_0x0002:
        r1 = r0.mo6076a(r1, r4, r5);	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        r3 = 1;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        r0.f23607t = r3;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        goto L_0x000f;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
    L_0x000a:
        r3 = 0;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        r1 = r0.mo6077a(r1, r3);	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
    L_0x000f:
        if (r1 == 0) goto L_0x001d;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
    L_0x0011:
        r3 = r1.m18393d();	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        if (r3 != 0) goto L_0x0018;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
    L_0x0017:
        goto L_0x001d;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
    L_0x0018:
        r1 = com.google.android.gms.internal.ads.agj.m18408a(r1, r2);	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        goto L_0x002a;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
    L_0x001d:
        r1 = 5;	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        r1 = java.lang.Integer.toString(r1);	 Catch:{ GeneralSecurityException -> 0x0025, GeneralSecurityException -> 0x0025, Throwable -> 0x0023 }
        goto L_0x002a;
    L_0x0023:
        r1 = 3;
        goto L_0x0026;
    L_0x0025:
        r1 = 7;
    L_0x0026:
        r1 = java.lang.Integer.toString(r1);
    L_0x002a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahf.a(android.content.Context, java.lang.String, boolean, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    /* renamed from: a */
    protected abstract long mo6075a(StackTraceElement[] stackTraceElementArr);

    /* renamed from: a */
    protected abstract aaa mo6076a(Context context, View view, Activity activity);

    /* renamed from: a */
    protected abstract aaa mo6077a(Context context, ww wwVar);

    /* renamed from: a */
    public final String mo3810a(Context context) {
        if (aih.m18481a()) {
            if (((Boolean) aph.m18688f().m18889a(asp.bN)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return m29921a(context, null, false, null, null, null);
    }

    /* renamed from: a */
    public final String mo3811a(Context context, String str, View view) {
        return mo3812a(context, str, view, null);
    }

    /* renamed from: a */
    public final String mo3812a(Context context, String str, View view, Activity activity) {
        return m29921a(context, str, true, view, activity, null);
    }

    /* renamed from: a */
    public final void mo3813a(int i, int i2, int i3) {
        MotionEvent obtain;
        if (this.f23589b != null) {
            r0.f23589b.recycle();
        }
        if (r0.f23604q != null) {
            obtain = MotionEvent.obtain(0, (long) i3, 1, r0.f23604q.density * ((float) i), r0.f23604q.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            obtain = null;
        }
        r0.f23589b = obtain;
        r0.f23603p = false;
    }

    /* renamed from: a */
    public final void mo3814a(android.view.MotionEvent r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = r12.f23607t;
        r1 = 0;
        if (r0 == 0) goto L_0x0035;
    L_0x0005:
        r2 = 0;
        r12.f23594g = r2;
        r12.f23593f = r2;
        r12.f23592e = r2;
        r12.f23591d = r2;
        r12.f23595h = r2;
        r12.f23597j = r2;
        r12.f23596i = r2;
        r0 = r12.f23590c;
        r0 = r0.iterator();
    L_0x001b:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x002b;
    L_0x0021:
        r2 = r0.next();
        r2 = (android.view.MotionEvent) r2;
        r2.recycle();
        goto L_0x001b;
    L_0x002b:
        r0 = r12.f23590c;
        r0.clear();
        r0 = 0;
        r12.f23589b = r0;
        r12.f23607t = r1;
    L_0x0035:
        r0 = r13.getAction();
        switch(r0) {
            case 0: goto L_0x0062;
            case 1: goto L_0x003d;
            case 2: goto L_0x003d;
            default: goto L_0x003c;
        };
    L_0x003c:
        goto L_0x0074;
    L_0x003d:
        r0 = r13.getRawX();
        r2 = (double) r0;
        r0 = r13.getRawY();
        r4 = (double) r0;
        r6 = r12.f23605r;
        r6 = r2 - r6;
        r8 = r12.f23606s;
        r8 = r4 - r8;
        r10 = r12.f23598k;
        r6 = r6 * r6;
        r8 = r8 * r8;
        r6 = r6 + r8;
        r6 = java.lang.Math.sqrt(r6);
        r10 = r10 + r6;
        r12.f23598k = r10;
        r12.f23605r = r2;
        r12.f23606s = r4;
        goto L_0x0074;
    L_0x0062:
        r2 = 0;
        r12.f23598k = r2;
        r0 = r13.getRawX();
        r2 = (double) r0;
        r12.f23605r = r2;
        r0 = r13.getRawY();
        r2 = (double) r0;
        r12.f23606s = r2;
    L_0x0074:
        r0 = r13.getAction();
        r2 = 1;
        r4 = 1;
        switch(r0) {
            case 0: goto L_0x0113;
            case 1: goto L_0x00dd;
            case 2: goto L_0x0087;
            case 3: goto L_0x0080;
            default: goto L_0x007e;
        };
    L_0x007e:
        goto L_0x0130;
    L_0x0080:
        r0 = r12.f23594g;
        r0 = r0 + r2;
        r12.f23594g = r0;
        goto L_0x0130;
    L_0x0087:
        r2 = r12.f23592e;
        r0 = r13.getHistorySize();
        r0 = r0 + r4;
        r5 = (long) r0;
        r2 = r2 + r5;
        r12.f23592e = r2;
        r13 = r12.mo6078b(r13);	 Catch:{ ahw -> 0x0130 }
        if (r13 == 0) goto L_0x00a2;	 Catch:{ ahw -> 0x0130 }
    L_0x0098:
        r0 = r13.f23635d;	 Catch:{ ahw -> 0x0130 }
        if (r0 == 0) goto L_0x00a2;	 Catch:{ ahw -> 0x0130 }
    L_0x009c:
        r0 = r13.f23638g;	 Catch:{ ahw -> 0x0130 }
        if (r0 == 0) goto L_0x00a2;	 Catch:{ ahw -> 0x0130 }
    L_0x00a0:
        r0 = 1;	 Catch:{ ahw -> 0x0130 }
        goto L_0x00a3;	 Catch:{ ahw -> 0x0130 }
    L_0x00a2:
        r0 = 0;	 Catch:{ ahw -> 0x0130 }
    L_0x00a3:
        if (r0 == 0) goto L_0x00b8;	 Catch:{ ahw -> 0x0130 }
    L_0x00a5:
        r2 = r12.f23596i;	 Catch:{ ahw -> 0x0130 }
        r0 = r13.f23635d;	 Catch:{ ahw -> 0x0130 }
        r5 = r0.longValue();	 Catch:{ ahw -> 0x0130 }
        r0 = r13.f23638g;	 Catch:{ ahw -> 0x0130 }
        r7 = r0.longValue();	 Catch:{ ahw -> 0x0130 }
        r0 = 0;	 Catch:{ ahw -> 0x0130 }
        r5 = r5 + r7;	 Catch:{ ahw -> 0x0130 }
        r2 = r2 + r5;	 Catch:{ ahw -> 0x0130 }
        r12.f23596i = r2;	 Catch:{ ahw -> 0x0130 }
    L_0x00b8:
        r0 = r12.f23604q;	 Catch:{ ahw -> 0x0130 }
        if (r0 == 0) goto L_0x00c7;	 Catch:{ ahw -> 0x0130 }
    L_0x00bc:
        if (r13 == 0) goto L_0x00c7;	 Catch:{ ahw -> 0x0130 }
    L_0x00be:
        r0 = r13.f23636e;	 Catch:{ ahw -> 0x0130 }
        if (r0 == 0) goto L_0x00c7;	 Catch:{ ahw -> 0x0130 }
    L_0x00c2:
        r0 = r13.f23639h;	 Catch:{ ahw -> 0x0130 }
        if (r0 == 0) goto L_0x00c7;	 Catch:{ ahw -> 0x0130 }
    L_0x00c6:
        r1 = 1;	 Catch:{ ahw -> 0x0130 }
    L_0x00c7:
        if (r1 == 0) goto L_0x0130;	 Catch:{ ahw -> 0x0130 }
    L_0x00c9:
        r0 = r12.f23597j;	 Catch:{ ahw -> 0x0130 }
        r2 = r13.f23636e;	 Catch:{ ahw -> 0x0130 }
        r2 = r2.longValue();	 Catch:{ ahw -> 0x0130 }
        r13 = r13.f23639h;	 Catch:{ ahw -> 0x0130 }
        r5 = r13.longValue();	 Catch:{ ahw -> 0x0130 }
        r13 = 0;	 Catch:{ ahw -> 0x0130 }
        r2 = r2 + r5;	 Catch:{ ahw -> 0x0130 }
        r0 = r0 + r2;	 Catch:{ ahw -> 0x0130 }
        r12.f23597j = r0;	 Catch:{ ahw -> 0x0130 }
        goto L_0x0130;
    L_0x00dd:
        r13 = android.view.MotionEvent.obtain(r13);
        r12.f23589b = r13;
        r13 = r12.f23590c;
        r0 = r12.f23589b;
        r13.add(r0);
        r13 = r12.f23590c;
        r13 = r13.size();
        r0 = 6;
        if (r13 <= r0) goto L_0x00fe;
    L_0x00f3:
        r13 = r12.f23590c;
        r13 = r13.remove();
        r13 = (android.view.MotionEvent) r13;
        r13.recycle();
    L_0x00fe:
        r0 = r12.f23593f;
        r0 = r0 + r2;
        r12.f23593f = r0;
        r13 = new java.lang.Throwable;	 Catch:{ ahw -> 0x0130 }
        r13.<init>();	 Catch:{ ahw -> 0x0130 }
        r13 = r13.getStackTrace();	 Catch:{ ahw -> 0x0130 }
        r0 = r12.mo6075a(r13);	 Catch:{ ahw -> 0x0130 }
        r12.f23595h = r0;	 Catch:{ ahw -> 0x0130 }
        goto L_0x0130;
    L_0x0113:
        r0 = r13.getX();
        r12.f23599l = r0;
        r0 = r13.getY();
        r12.f23600m = r0;
        r0 = r13.getRawX();
        r12.f23601n = r0;
        r13 = r13.getRawY();
        r12.f23602o = r13;
        r0 = r12.f23591d;
        r0 = r0 + r2;
        r12.f23591d = r0;
    L_0x0130:
        r12.f23603p = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahf.a(android.view.MotionEvent):void");
    }

    /* renamed from: a */
    public void mo3815a(View view) {
    }

    /* renamed from: b */
    protected abstract aig mo6078b(MotionEvent motionEvent);
}
