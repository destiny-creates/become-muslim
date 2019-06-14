package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.analytics.r */
public class C2717r<T extends C2717r> {
    /* renamed from: a */
    protected final C2714o f6977a;
    /* renamed from: b */
    private final C2721s f6978b;
    /* renamed from: c */
    private final List<C2715p> f6979c = new ArrayList();

    protected C2717r(C2721s c2721s, C2895e c2895e) {
        C2872v.m8380a((Object) c2721s);
        this.f6978b = c2721s;
        c2721s = new C2714o(this, c2895e);
        c2721s.m7755j();
        this.f6977a = c2721s;
    }

    /* renamed from: a */
    protected void mo2355a(C2714o c2714o) {
    }

    /* renamed from: h */
    public C2714o mo2356h() {
        C2714o a = this.f6977a.m7742a();
        m7762b(a);
        return a;
    }

    /* renamed from: b */
    protected final void m7762b(C2714o c2714o) {
        for (C2715p a : this.f6979c) {
            a.m7756a(this, c2714o);
        }
    }

    /* renamed from: i */
    protected final C2721s m7764i() {
        return this.f6978b;
    }
}
