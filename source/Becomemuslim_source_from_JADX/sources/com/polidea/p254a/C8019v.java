package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import com.polidea.p254a.p256b.p260d.C5592s;
import com.polidea.p254a.p256b.p260d.C7056t;
import com.polidea.p254a.p256b.p260d.C7057v;
import com.polidea.p254a.p256b.p260d.C7058x;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ClientComponent_ClientModule_ProvideScanSetupProviderFactory */
/* renamed from: com.polidea.a.v */
public final class C8019v implements C3086c<C5592s> {
    /* renamed from: a */
    private final C0003a<Integer> f29782a;
    /* renamed from: b */
    private final C0003a<C7056t> f29783b;
    /* renamed from: c */
    private final C0003a<C7057v> f29784c;
    /* renamed from: d */
    private final C0003a<C7058x> f29785d;

    /* renamed from: a */
    public /* synthetic */ Object m38859a() {
        return m38860b();
    }

    public C8019v(C0003a<Integer> c0003a, C0003a<C7056t> c0003a2, C0003a<C7057v> c0003a3, C0003a<C7058x> c0003a4) {
        this.f29782a = c0003a;
        this.f29783b = c0003a2;
        this.f29784c = c0003a3;
        this.f29785d = c0003a4;
    }

    /* renamed from: b */
    public C5592s m38860b() {
        return (C5592s) C0000d.a(C5547b.m23595a(((Integer) this.f29782a.a()).intValue(), this.f29783b, this.f29784c, this.f29785d), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8019v m38858a(C0003a<Integer> c0003a, C0003a<C7056t> c0003a2, C0003a<C7057v> c0003a3, C0003a<C7058x> c0003a4) {
        return new C8019v(c0003a, c0003a2, c0003a3, c0003a4);
    }
}
