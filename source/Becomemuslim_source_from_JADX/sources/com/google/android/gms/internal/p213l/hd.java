package com.google.android.gms.internal.p213l;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.content.C0382f;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.l.hd */
public abstract class hd<T> {
    /* renamed from: b */
    private static final Object f17277b = new Object();
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: c */
    private static Context f17278c = null;
    /* renamed from: d */
    private static boolean f17279d = false;
    /* renamed from: e */
    private static volatile Boolean f17280e = null;
    /* renamed from: a */
    final String f17281a;
    /* renamed from: f */
    private final hn f17282f;
    /* renamed from: g */
    private final String f17283g;
    /* renamed from: h */
    private final T f17284h;
    /* renamed from: i */
    private T f17285i;
    /* renamed from: j */
    private volatile ha f17286j;
    /* renamed from: k */
    private volatile SharedPreferences f17287k;

    private hd(hn hnVar, String str, T t) {
        this.f17285i = null;
        this.f17286j = null;
        this.f17287k = null;
        if (hnVar.f17289b != null) {
            this.f17282f = hnVar;
            String valueOf = String.valueOf(hnVar.f17290c);
            String valueOf2 = String.valueOf(str);
            this.f17283g = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(hnVar.f17291d);
            str = String.valueOf(str);
            this.f17281a = str.length() != 0 ? valueOf3.concat(str) : new String(valueOf3);
            this.f17284h = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    /* renamed from: a */
    private static <V> V m21411a(com.google.android.gms.internal.p213l.hm<V> r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r2.mo4765a();	 Catch:{ SecurityException -> 0x0006 }
        r2 = r0;
        goto L_0x0011;
    L_0x0006:
        r0 = android.os.Binder.clearCallingIdentity();
        r2 = r2.mo4765a();	 Catch:{ all -> 0x0012 }
        android.os.Binder.restoreCallingIdentity(r0);
    L_0x0011:
        return r2;
    L_0x0012:
        r2 = move-exception;
        android.os.Binder.restoreCallingIdentity(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.hd.a(com.google.android.gms.internal.l.hm):V");
    }

    /* renamed from: a */
    public static void m21412a(Context context) {
        synchronized (f17277b) {
            if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (f17278c != context) {
                f17280e = null;
            }
            f17278c = context;
        }
        f17279d = false;
    }

    /* renamed from: a */
    static boolean m21413a(String str, boolean z) {
        try {
            return hd.m21422e() ? ((Boolean) hd.m21411a(new hg(str, false))).booleanValue() : false;
        } catch (Throwable e) {
            Log.e("PhenotypeFlag", "Unable to read GServices, returning default value.", e);
            return false;
        }
    }

    /* renamed from: b */
    private static hd<Double> m21414b(hn hnVar, String str, double d) {
        return new hk(hnVar, str, Double.valueOf(d));
    }

    /* renamed from: b */
    private static hd<Integer> m21415b(hn hnVar, String str, int i) {
        return new hi(hnVar, str, Integer.valueOf(i));
    }

    /* renamed from: b */
    private static hd<Long> m21416b(hn hnVar, String str, long j) {
        return new hh(hnVar, str, Long.valueOf(j));
    }

    /* renamed from: b */
    private static hd<String> m21417b(hn hnVar, String str, String str2) {
        return new hl(hnVar, str, str2);
    }

    /* renamed from: b */
    private static hd<Boolean> m21418b(hn hnVar, String str, boolean z) {
        return new hj(hnVar, str, Boolean.valueOf(z));
    }

    @TargetApi(24)
    /* renamed from: c */
    private final T m21420c() {
        String str;
        if (hd.m21413a("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            str = "PhenotypeFlag";
            String str2 = "Bypass reading Phenotype values for flag: ";
            String valueOf = String.valueOf(this.f17281a);
            Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (this.f17282f.f17289b != null) {
            if (this.f17286j == null) {
                this.f17286j = ha.m21399a(f17278c.getContentResolver(), this.f17282f.f17289b);
            }
            str = (String) hd.m21411a(new he(this, this.f17286j));
            if (str != null) {
                return mo4766a(str);
            }
        } else {
            hn hnVar = this.f17282f;
        }
        return null;
    }

    /* renamed from: d */
    private final T m21421d() {
        hn hnVar = this.f17282f;
        if (hd.m21422e()) {
            try {
                String str = (String) hd.m21411a(new hf(this));
                if (str != null) {
                    return mo4766a(str);
                }
            } catch (Throwable e) {
                String str2 = "PhenotypeFlag";
                String str3 = "Unable to read GServices for flag: ";
                String valueOf = String.valueOf(this.f17281a);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
            }
        }
        return null;
    }

    /* renamed from: e */
    private static boolean m21422e() {
        if (f17280e == null) {
            boolean z = false;
            if (f17278c == null) {
                return false;
            }
            if (C0382f.a(f17278c, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            f17280e = Boolean.valueOf(z);
        }
        return f17280e.booleanValue();
    }

    /* renamed from: a */
    public final T m21423a() {
        if (f17278c != null) {
            hn hnVar = this.f17282f;
            T c = m21420c();
            if (c != null) {
                return c;
            }
            c = m21421d();
            return c != null ? c : this.f17284h;
        } else {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
    }

    /* renamed from: a */
    protected abstract T mo4766a(String str);

    /* renamed from: b */
    final /* synthetic */ String m21425b() {
        return gy.m21386a(f17278c.getContentResolver(), this.f17283g, null);
    }
}
