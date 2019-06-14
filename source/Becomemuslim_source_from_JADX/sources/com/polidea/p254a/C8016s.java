package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import com.polidea.p254a.p256b.p262f.C7079m;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;
import p289e.C5974e;

/* compiled from: ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory */
/* renamed from: com.polidea.a.s */
public final class C8016s implements C3086c<C5974e<Boolean>> {
    /* renamed from: a */
    private final C5547b f29772a;
    /* renamed from: b */
    private final C0003a<Integer> f29773b;
    /* renamed from: c */
    private final C0003a<C7079m> f29774c;

    /* renamed from: a */
    public /* synthetic */ Object m38850a() {
        return m38851b();
    }

    public C8016s(C5547b c5547b, C0003a<Integer> c0003a, C0003a<C7079m> c0003a2) {
        this.f29772a = c5547b;
        this.f29773b = c0003a;
        this.f29774c = c0003a2;
    }

    /* renamed from: b */
    public C5974e<Boolean> m38851b() {
        return (C5974e) C0000d.a(this.f29772a.m23610a(((Integer) this.f29773b.a()).intValue(), this.f29774c), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8016s m38849a(C5547b c5547b, C0003a<Integer> c0003a, C0003a<C7079m> c0003a2) {
        return new C8016s(c5547b, c0003a, c0003a2);
    }
}
