package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.aqr;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.bch;
import com.google.android.gms.internal.ads.bci;
import com.google.android.gms.internal.ads.bdb;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.fz;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.kq;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@cm
/* renamed from: com.google.android.gms.ads.internal.z */
public final class C4745z extends aqr {
    /* renamed from: b */
    private static final Object f13082b = new Object();
    /* renamed from: c */
    private static C4745z f13083c;
    /* renamed from: a */
    private final Context f13084a;
    /* renamed from: d */
    private final Object f13085d = new Object();
    /* renamed from: e */
    private boolean f13086e;
    /* renamed from: f */
    private mv f13087f;

    private C4745z(Context context, mv mvVar) {
        this.f13084a = context;
        this.f13087f = mvVar;
        this.f13086e = false;
    }

    /* renamed from: a */
    public static C4745z m16599a(Context context, mv mvVar) {
        C4745z c4745z;
        synchronized (f13082b) {
            if (f13083c == null) {
                f13083c = new C4745z(context.getApplicationContext(), mvVar);
            }
            c4745z = f13083c;
        }
        return c4745z;
    }

    /* renamed from: a */
    public final void m16600a() {
        synchronized (f13082b) {
            if (this.f13086e) {
                jn.e("Mobile ads is initialized already.");
                return;
            }
            this.f13086e = true;
            asp.a(this.f13084a);
            ax.m7468i().a(this.f13084a, this.f13087f);
            ax.m7470k().a(this.f13084a);
        }
    }

    /* renamed from: a */
    public final void m16601a(float f) {
        ax.m7457D().a(f);
    }

    /* renamed from: a */
    public final void m16602a(C2758b c2758b, String str) {
        if (c2758b == null) {
            jn.c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) C4757d.m16685a(c2758b);
        if (context == null) {
            jn.c("Context is null. Failed to open debug menu.");
            return;
        }
        kq kqVar = new kq(context);
        kqVar.a(str);
        kqVar.b(this.f13087f.f28709a);
        kqVar.a();
    }

    /* renamed from: a */
    final /* synthetic */ void m16603a(Runnable runnable) {
        Object obj = this.f13084a;
        C2872v.m8389b("Adapters must be initialized on the main thread.");
        Map e = ax.m7468i().l().h().e();
        if (e != null) {
            if (!e.isEmpty()) {
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        jn.c("Could not initialize rewarded ads.", th);
                        return;
                    }
                }
                fz I = fz.I();
                if (I != null) {
                    Collection<bci> values = e.values();
                    Map hashMap = new HashMap();
                    C2758b a = C4757d.m16684a(obj);
                    for (bci bci : values) {
                        for (bch bch : bci.f15194a) {
                            String str = bch.f15183k;
                            for (String str2 : bch.f15175c) {
                                if (!hashMap.containsKey(str2)) {
                                    hashMap.put(str2, new ArrayList());
                                }
                                if (str != null) {
                                    ((Collection) hashMap.get(str2)).add(str);
                                }
                            }
                        }
                    }
                    for (Entry entry : hashMap.entrySet()) {
                        String str3 = (String) entry.getKey();
                        try {
                            hl b = I.b(str3);
                            if (b != null) {
                                bdb a2 = b.a();
                                if (!a2.g()) {
                                    if (a2.m()) {
                                        a2.a(a, b.b(), (List) entry.getValue());
                                        String str4 = "Initialized rewarded video mediation adapter ";
                                        String valueOf = String.valueOf(str3);
                                        jn.b(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str3).length() + 56);
                            stringBuilder.append("Failed to initialize rewarded video mediation adapter \"");
                            stringBuilder.append(str3);
                            stringBuilder.append("\"");
                            jn.c(stringBuilder.toString(), th2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m16604a(String str) {
        asp.a(this.f13084a);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) aph.f().a(asp.cs)).booleanValue()) {
                ax.m7472m().m7509a(this.f13084a, this.f13087f, str, null);
            }
        }
    }

    /* renamed from: a */
    public final void m16605a(String str, C2758b c2758b) {
        if (!TextUtils.isEmpty(str)) {
            asp.a(this.f13084a);
            int booleanValue = ((Boolean) aph.f().a(asp.cs)).booleanValue() | ((Boolean) aph.f().a(asp.aD)).booleanValue();
            Runnable runnable = null;
            if (((Boolean) aph.f().a(asp.aD)).booleanValue()) {
                booleanValue = 1;
                runnable = new aa(this, (Runnable) C4757d.m16685a(c2758b));
            }
            if (booleanValue != 0) {
                ax.m7472m().m7509a(this.f13084a, this.f13087f, str, runnable);
            }
        }
    }

    /* renamed from: a */
    public final void m16606a(boolean z) {
        ax.m7457D().a(z);
    }

    /* renamed from: b */
    public final float m16607b() {
        return ax.m7457D().a();
    }

    /* renamed from: c */
    public final boolean m16608c() {
        return ax.m7457D().b();
    }
}
