package com.p073d.p074a;

import com.p073d.p074a.C1152j.C1151a;
import com.p073d.p074a.p075a.C3460b;
import java.util.List;

/* compiled from: RealMiddlewareChain */
/* renamed from: com.d.a.p */
class C3485p implements C1151a {
    /* renamed from: a */
    private int f9274a;
    /* renamed from: b */
    private final C3460b f9275b;
    /* renamed from: c */
    private final List<C1152j> f9276c;
    /* renamed from: d */
    private final C1133a f9277d;

    C3485p(int i, C3460b c3460b, List<C1152j> list, C1133a c1133a) {
        this.f9274a = i;
        this.f9275b = c3460b;
        this.f9276c = list;
        this.f9277d = c1133a;
    }

    /* renamed from: a */
    public void mo794a(C3460b c3460b) {
        if (this.f9274a < this.f9276c.size()) {
            ((C1152j) this.f9276c.get(this.f9274a)).m4081a(new C3485p(this.f9274a + 1, c3460b, this.f9276c, this.f9277d));
            return;
        }
        this.f9277d.m3994b(c3460b);
    }
}
