package com.google.android.gms.p184d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p179c.C2825a;
import com.google.android.gms.common.util.C2908s;
import com.google.android.gms.common.util.C2910u;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.d.b */
public class C2917b {
    /* renamed from: n */
    private static ScheduledExecutorService f7409n;
    /* renamed from: o */
    private static volatile C2916a f7410o = new C4378c();
    /* renamed from: a */
    private final Object f7411a;
    /* renamed from: b */
    private final WakeLock f7412b;
    /* renamed from: c */
    private WorkSource f7413c;
    /* renamed from: d */
    private final int f7414d;
    /* renamed from: e */
    private final String f7415e;
    /* renamed from: f */
    private final String f7416f;
    /* renamed from: g */
    private final String f7417g;
    /* renamed from: h */
    private final Context f7418h;
    /* renamed from: i */
    private boolean f7419i;
    /* renamed from: j */
    private final Map<String, Integer[]> f7420j;
    /* renamed from: k */
    private final Set<Future<?>> f7421k;
    /* renamed from: l */
    private int f7422l;
    /* renamed from: m */
    private AtomicInteger f7423m;

    /* renamed from: com.google.android.gms.d.b$a */
    public interface C2916a {
    }

    public C2917b(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    private C2917b(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private C2917b(Context context, int i, String str, String str2, String str3, String str4) {
        this.f7411a = this;
        this.f7419i = true;
        this.f7420j = new HashMap();
        this.f7421k = Collections.synchronizedSet(new HashSet());
        this.f7423m = new AtomicInteger(null);
        C2872v.m8381a((Object) context, (Object) "WakeLock: context must not be null");
        C2872v.m8383a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f7414d = i;
        this.f7416f = null;
        this.f7417g = null;
        this.f7418h = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName()) == null) {
            str2 = String.valueOf("*gcore*:");
            str4 = String.valueOf(str);
            this.f7415e = str4.length() != 0 ? str2.concat(str4) : new String(str2);
        } else {
            this.f7415e = str;
        }
        this.f7412b = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (C2910u.m8482a(context) != 0) {
            if (C2908s.m8473a(str3) != 0) {
                str3 = context.getPackageName();
            }
            this.f7413c = C2910u.m8477a(context, str3);
            context = this.f7413c;
            if (!(context == null || C2910u.m8482a(this.f7418h) == 0)) {
                if (this.f7413c != 0) {
                    this.f7413c.add(context);
                } else {
                    this.f7413c = context;
                }
                try {
                    this.f7412b.setWorkSource(this.f7413c);
                } catch (Context context2) {
                    Log.wtf("WakeLock", context2.toString());
                }
            }
        }
        if (f7409n == null) {
            f7409n = C2825a.m8119a().mo2454a();
        }
    }

    /* renamed from: c */
    private final List<String> m8497c() {
        return C2910u.m8480a(this.f7413c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m8499a(long r14) {
        /*
        r13 = this;
        r0 = r13.f7423m;
        r0.incrementAndGet();
        r0 = 0;
        r6 = r13.m8494a(r0);
        r0 = r13.f7411a;
        monitor-enter(r0);
        r1 = r13.f7420j;	 Catch:{ all -> 0x0096 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0096 }
        r2 = 0;
        if (r1 == 0) goto L_0x001a;
    L_0x0016:
        r1 = r13.f7422l;	 Catch:{ all -> 0x0096 }
        if (r1 <= 0) goto L_0x0029;
    L_0x001a:
        r1 = r13.f7412b;	 Catch:{ all -> 0x0096 }
        r1 = r1.isHeld();	 Catch:{ all -> 0x0096 }
        if (r1 != 0) goto L_0x0029;
    L_0x0022:
        r1 = r13.f7420j;	 Catch:{ all -> 0x0096 }
        r1.clear();	 Catch:{ all -> 0x0096 }
        r13.f7422l = r2;	 Catch:{ all -> 0x0096 }
    L_0x0029:
        r1 = r13.f7419i;	 Catch:{ all -> 0x0096 }
        r12 = 1;
        if (r1 == 0) goto L_0x0056;
    L_0x002e:
        r1 = r13.f7420j;	 Catch:{ all -> 0x0096 }
        r1 = r1.get(r6);	 Catch:{ all -> 0x0096 }
        r1 = (java.lang.Integer[]) r1;	 Catch:{ all -> 0x0096 }
        if (r1 != 0) goto L_0x0047;
    L_0x0038:
        r1 = r13.f7420j;	 Catch:{ all -> 0x0096 }
        r3 = new java.lang.Integer[r12];	 Catch:{ all -> 0x0096 }
        r4 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x0096 }
        r3[r2] = r4;	 Catch:{ all -> 0x0096 }
        r1.put(r6, r3);	 Catch:{ all -> 0x0096 }
        r2 = 1;
        goto L_0x0054;
    L_0x0047:
        r3 = r1[r2];	 Catch:{ all -> 0x0096 }
        r3 = r3.intValue();	 Catch:{ all -> 0x0096 }
        r3 = r3 + r12;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0096 }
        r1[r2] = r3;	 Catch:{ all -> 0x0096 }
    L_0x0054:
        if (r2 != 0) goto L_0x005e;
    L_0x0056:
        r1 = r13.f7419i;	 Catch:{ all -> 0x0096 }
        if (r1 != 0) goto L_0x007d;
    L_0x005a:
        r1 = r13.f7422l;	 Catch:{ all -> 0x0096 }
        if (r1 != 0) goto L_0x007d;
    L_0x005e:
        r1 = com.google.android.gms.common.stats.C2885d.m8412a();	 Catch:{ all -> 0x0096 }
        r2 = r13.f7418h;	 Catch:{ all -> 0x0096 }
        r3 = r13.f7412b;	 Catch:{ all -> 0x0096 }
        r3 = com.google.android.gms.common.stats.C2884c.m8411a(r3, r6);	 Catch:{ all -> 0x0096 }
        r4 = 7;
        r5 = r13.f7415e;	 Catch:{ all -> 0x0096 }
        r7 = 0;
        r8 = r13.f7414d;	 Catch:{ all -> 0x0096 }
        r9 = r13.m8497c();	 Catch:{ all -> 0x0096 }
        r10 = r14;
        r1.m8414a(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0096 }
        r1 = r13.f7422l;	 Catch:{ all -> 0x0096 }
        r1 = r1 + r12;
        r13.f7422l = r1;	 Catch:{ all -> 0x0096 }
    L_0x007d:
        monitor-exit(r0);	 Catch:{ all -> 0x0096 }
        r0 = r13.f7412b;
        r0.acquire();
        r0 = 0;
        r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0095;
    L_0x0089:
        r0 = f7409n;
        r1 = new com.google.android.gms.d.d;
        r1.<init>(r13);
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r0.schedule(r1, r14, r2);
    L_0x0095:
        return;
    L_0x0096:
        r14 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0096 }
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.d.b.a(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m8498a() {
        /*
        r12 = this;
        r0 = r12.f7423m;
        r0 = r0.decrementAndGet();
        if (r0 >= 0) goto L_0x0019;
    L_0x0008:
        r0 = "WakeLock";
        r1 = r12.f7415e;
        r1 = java.lang.String.valueOf(r1);
        r2 = " release without a matched acquire!";
        r1 = r1.concat(r2);
        android.util.Log.e(r0, r1);
    L_0x0019:
        r0 = 0;
        r6 = r12.m8494a(r0);
        r0 = r12.f7411a;
        monitor-enter(r0);
        r1 = r12.f7419i;	 Catch:{ all -> 0x007e }
        r10 = 1;
        r11 = 0;
        if (r1 == 0) goto L_0x0052;
    L_0x0027:
        r1 = r12.f7420j;	 Catch:{ all -> 0x007e }
        r1 = r1.get(r6);	 Catch:{ all -> 0x007e }
        r1 = (java.lang.Integer[]) r1;	 Catch:{ all -> 0x007e }
        if (r1 != 0) goto L_0x0033;
    L_0x0031:
        r1 = 0;
        goto L_0x0050;
    L_0x0033:
        r2 = r1[r11];	 Catch:{ all -> 0x007e }
        r2 = r2.intValue();	 Catch:{ all -> 0x007e }
        if (r2 != r10) goto L_0x0042;
    L_0x003b:
        r1 = r12.f7420j;	 Catch:{ all -> 0x007e }
        r1.remove(r6);	 Catch:{ all -> 0x007e }
        r1 = 1;
        goto L_0x0050;
    L_0x0042:
        r2 = r1[r11];	 Catch:{ all -> 0x007e }
        r2 = r2.intValue();	 Catch:{ all -> 0x007e }
        r2 = r2 - r10;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x007e }
        r1[r11] = r2;	 Catch:{ all -> 0x007e }
        goto L_0x0031;
    L_0x0050:
        if (r1 != 0) goto L_0x005a;
    L_0x0052:
        r1 = r12.f7419i;	 Catch:{ all -> 0x007e }
        if (r1 != 0) goto L_0x0079;
    L_0x0056:
        r1 = r12.f7422l;	 Catch:{ all -> 0x007e }
        if (r1 != r10) goto L_0x0079;
    L_0x005a:
        r1 = com.google.android.gms.common.stats.C2885d.m8412a();	 Catch:{ all -> 0x007e }
        r2 = r12.f7418h;	 Catch:{ all -> 0x007e }
        r3 = r12.f7412b;	 Catch:{ all -> 0x007e }
        r3 = com.google.android.gms.common.stats.C2884c.m8411a(r3, r6);	 Catch:{ all -> 0x007e }
        r4 = 8;
        r5 = r12.f7415e;	 Catch:{ all -> 0x007e }
        r7 = 0;
        r8 = r12.f7414d;	 Catch:{ all -> 0x007e }
        r9 = r12.m8497c();	 Catch:{ all -> 0x007e }
        r1.m8413a(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x007e }
        r1 = r12.f7422l;	 Catch:{ all -> 0x007e }
        r1 = r1 - r10;
        r12.f7422l = r1;	 Catch:{ all -> 0x007e }
    L_0x0079:
        monitor-exit(r0);	 Catch:{ all -> 0x007e }
        r12.m8495a(r11);
        return;
    L_0x007e:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x007e }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.d.b.a():void");
    }

    /* renamed from: a */
    private final void m8495a(int i) {
        if (this.f7412b.isHeld() != 0) {
            try {
                this.f7412b.release();
            } catch (int i2) {
                if (i2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f7415e).concat(" was already released!"), i2);
                } else {
                    throw i2;
                }
            }
            this.f7412b.isHeld();
        }
    }

    /* renamed from: a */
    private final String m8494a(String str) {
        if (this.f7419i) {
            return !TextUtils.isEmpty(str) ? str : this.f7416f;
        } else {
            return this.f7416f;
        }
    }

    /* renamed from: a */
    public void m8500a(boolean z) {
        this.f7412b.setReferenceCounted(z);
        this.f7419i = z;
    }

    /* renamed from: b */
    public boolean m8501b() {
        return this.f7412b.isHeld();
    }
}
