package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import com.polidea.p254a.p256b.p260d.C5589i;
import com.polidea.p254a.p256b.p260d.C7042j;
import com.polidea.p254a.p256b.p260d.C7043l;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory */
/* renamed from: com.polidea.a.u */
public final class C8018u implements C3086c<C5589i> {
    /* renamed from: a */
    private final C0003a<Integer> f29779a;
    /* renamed from: b */
    private final C0003a<C7042j> f29780b;
    /* renamed from: c */
    private final C0003a<C7043l> f29781c;

    /* renamed from: a */
    public /* synthetic */ Object m38856a() {
        return m38857b();
    }

    public C8018u(C0003a<Integer> c0003a, C0003a<C7042j> c0003a2, C0003a<C7043l> c0003a3) {
        this.f29779a = c0003a;
        this.f29780b = c0003a2;
        this.f29781c = c0003a3;
    }

    /* renamed from: b */
    public C5589i m38857b() {
        return (C5589i) C0000d.a(C5547b.m23597b(((Integer) this.f29779a.a()).intValue(), this.f29780b, this.f29781c), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8018u m38855a(C0003a<Integer> c0003a, C0003a<C7042j> c0003a2, C0003a<C7043l> c0003a3) {
        return new C8018u(c0003a, c0003a2, c0003a3);
    }
}
