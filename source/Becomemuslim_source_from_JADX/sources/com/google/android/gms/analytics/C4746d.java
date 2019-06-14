package com.google.android.gms.analytics;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.p210i.C5008q;
import com.google.android.gms.internal.p210i.C6797o;
import com.google.android.gms.internal.p210i.ba;
import com.google.android.gms.internal.p210i.bk;
import com.google.android.gms.internal.p210i.cb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.d */
public final class C4746d extends C4308i {
    /* renamed from: b */
    private static List<Runnable> f13092b = new ArrayList();
    /* renamed from: c */
    private boolean f13093c;
    /* renamed from: d */
    private Set<Object> f13094d = new HashSet();
    /* renamed from: e */
    private boolean f13095e;
    /* renamed from: f */
    private volatile boolean f13096f;
    /* renamed from: g */
    private boolean f13097g;

    /* renamed from: a */
    public final void m16613a() {
        cb k = m13988g().k();
        k.d();
        if (k.e()) {
            m16616a(k.f());
        }
        k.d();
        this.f13093c = true;
    }

    /* renamed from: b */
    public final boolean m16618b() {
        return this.f13093c;
    }

    public C4746d(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    public static C4746d m16610a(Context context) {
        return C5008q.a(context).j();
    }

    /* renamed from: c */
    public static void m16611c() {
        synchronized (C4746d.class) {
            if (f13092b != null) {
                for (Runnable run : f13092b) {
                    run.run();
                }
                f13092b = null;
            }
        }
    }

    /* renamed from: a */
    public final void m16616a(boolean z) {
        this.f13095e = z;
    }

    /* renamed from: d */
    public final boolean m16619d() {
        return this.f13095e;
    }

    /* renamed from: a */
    public final C4748h m16612a(String str) {
        C6797o c4748h;
        synchronized (this) {
            c4748h = new C4748h(m13988g(), str, null);
            c4748h.A();
        }
        return c4748h;
    }

    /* renamed from: b */
    public final void m16617b(boolean z) {
        this.f13096f = z;
        if (this.f13096f) {
            m13988g().h().c();
        }
    }

    /* renamed from: e */
    public final boolean m16620e() {
        return this.f13096f;
    }

    @Deprecated
    /* renamed from: a */
    public final void m16615a(C2710f c2710f) {
        bk.a(c2710f);
        if (this.f13097g == null) {
            String str = (String) ba.f16383b.a();
            String str2 = (String) ba.f16383b.a();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 112);
            stringBuilder.append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            stringBuilder.append(str2);
            stringBuilder.append(" DEBUG");
            Log.i(str, stringBuilder.toString());
            this.f13097g = true;
        }
    }

    /* renamed from: a */
    public final void m16614a(int i) {
        m13988g().h().a(i);
    }

    /* renamed from: f */
    public final void m16621f() {
        m13988g().h().d();
    }
}
