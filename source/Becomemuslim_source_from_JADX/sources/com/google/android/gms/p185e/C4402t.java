package com.google.android.gms.p185e;

import com.google.android.gms.p185e.C2934c.C2931a;
import java.util.List;

/* renamed from: com.google.android.gms.e.t */
final class C4402t implements C2944u {
    /* renamed from: a */
    private final /* synthetic */ C2934c f11748a;

    C4402t(C2934c c2934c) {
        this.f11748a = c2934c;
    }

    /* renamed from: a */
    public final void mo2573a(List<C2931a> list) {
        for (C2931a c2931a : list) {
            this.f11748a.m8611b(C2934c.m8610b(c2931a.f7484a, c2931a.f7485b));
        }
        this.f11748a.f7494i.countDown();
    }
}
