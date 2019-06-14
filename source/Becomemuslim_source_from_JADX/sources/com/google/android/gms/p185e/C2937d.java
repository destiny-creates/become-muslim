package com.google.android.gms.p185e;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C2789g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.e.d */
public class C2937d {
    /* renamed from: g */
    private static C2937d f7509g;
    /* renamed from: a */
    private final C2936a f7510a;
    /* renamed from: b */
    private final Context f7511b;
    /* renamed from: c */
    private final C2934c f7512c;
    /* renamed from: d */
    private final dx f7513d;
    /* renamed from: e */
    private final ConcurrentMap<String, fn> f7514e;
    /* renamed from: f */
    private final C2942p f7515f;

    /* renamed from: com.google.android.gms.e.d$a */
    public interface C2936a {
        /* renamed from: a */
        fq mo2560a(Context context, C2937d c2937d, Looper looper, String str, int i, C2942p c2942p);
    }

    private C2937d(Context context, C2936a c2936a, C2934c c2934c, dx dxVar) {
        if (context != null) {
            this.f7511b = context.getApplicationContext();
            this.f7513d = dxVar;
            this.f7510a = c2936a;
            this.f7514e = new ConcurrentHashMap();
            this.f7512c = c2934c;
            this.f7512c.m8613a(new em(this));
            this.f7512c.m8613a(new el(this.f7511b));
            this.f7515f = new C2942p();
            this.f7511b.registerComponentCallbacks(new eo(this));
            C2938e.m8691a(this.f7511b);
            return;
        }
        throw new NullPointerException("context cannot be null");
    }

    /* renamed from: a */
    public static C2937d m8631a(Context context) {
        synchronized (C2937d.class) {
            if (f7509g == null) {
                if (context != null) {
                    f7509g = new C2937d(context, new en(), new C2934c(new C4404x(context)), dy.m14545c());
                } else {
                    bs.m8582a("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
            }
            context = f7509g;
        }
        return context;
    }

    /* renamed from: a */
    public C2934c m8636a() {
        return this.f7512c;
    }

    /* renamed from: a */
    public C2789g<C4391b> m8635a(String str, int i) {
        str = this.f7510a.mo2560a(this.f7511b, this, null, str, i, this.f7515f);
        str.mo3282d();
        return str;
    }

    /* renamed from: b */
    public void m8638b() {
        this.f7513d.mo2549a();
    }

    /* renamed from: a */
    public void m8637a(boolean z) {
        bs.m8581a(z ? true : true);
    }

    /* renamed from: a */
    public final int m8634a(fn fnVar) {
        this.f7514e.put(fnVar.m16913d(), fnVar);
        return this.f7514e.size();
    }

    /* renamed from: b */
    public final boolean m8639b(fn fnVar) {
        return this.f7514e.remove(fnVar.m16913d()) != null ? true : null;
    }

    /* renamed from: a */
    private final void m8633a(String str) {
        for (fn a : this.f7514e.values()) {
            a.m16910a(str);
        }
    }
}
