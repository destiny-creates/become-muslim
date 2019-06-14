package com.google.android.gms.fitness.p187a;

import android.os.Looper;
import com.google.android.gms.common.api.internal.C2804h;
import com.google.android.gms.common.api.internal.C2804h.C2802a;
import com.google.android.gms.common.api.internal.C2805i;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.a.g */
public final class C2973g {
    /* renamed from: a */
    private static final C2973g f7641a = new C2973g();
    /* renamed from: b */
    private final Map<C2802a<C2970c>, C4794e> f7642b = new HashMap();

    private C2973g() {
    }

    /* renamed from: a */
    public static C2973g m8836a() {
        return f7641a;
    }

    /* renamed from: c */
    private static C2804h<C2970c> m8837c(C2970c c2970c) {
        return C2805i.m8085a(c2970c, Looper.getMainLooper(), C2970c.class.getSimpleName());
    }

    /* renamed from: a */
    public final C4794e m8838a(C2804h<C2970c> c2804h) {
        C4794e c4794e;
        synchronized (this.f7642b) {
            c4794e = (C4794e) this.f7642b.get(c2804h.m8082b());
            if (c4794e == null) {
                c4794e = new C4794e(c2804h);
                this.f7642b.put(c2804h.m8082b(), c4794e);
            }
        }
        return c4794e;
    }

    /* renamed from: a */
    public final C4794e m8839a(C2970c c2970c) {
        return m8838a(C2973g.m8837c(c2970c));
    }

    /* renamed from: b */
    public final C4794e m8840b(C2804h<C2970c> c2804h) {
        C4794e c4794e;
        synchronized (this.f7642b) {
            c4794e = (C4794e) this.f7642b.remove(c2804h.m8082b());
            if (c4794e != null) {
                c4794e.m16947a();
            }
        }
        return c4794e;
    }

    /* renamed from: b */
    public final C4794e m8841b(C2970c c2970c) {
        return m8840b(C2973g.m8837c(c2970c));
    }
}
