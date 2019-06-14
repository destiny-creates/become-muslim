package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5547b;
import com.polidea.p254a.p256b.p262f.C5607o;
import com.polidea.p254a.p256b.p262f.C7080p;
import com.polidea.p254a.p256b.p262f.C7081r;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ClientComponent_ClientModule_ProvideLocationServicesStatusFactory */
/* renamed from: com.polidea.a.t */
public final class C8017t implements C3086c<C5607o> {
    /* renamed from: a */
    private final C5547b f29775a;
    /* renamed from: b */
    private final C0003a<Integer> f29776b;
    /* renamed from: c */
    private final C0003a<C7080p> f29777c;
    /* renamed from: d */
    private final C0003a<C7081r> f29778d;

    /* renamed from: a */
    public /* synthetic */ Object m38853a() {
        return m38854b();
    }

    public C8017t(C5547b c5547b, C0003a<Integer> c0003a, C0003a<C7080p> c0003a2, C0003a<C7081r> c0003a3) {
        this.f29775a = c5547b;
        this.f29776b = c0003a;
        this.f29777c = c0003a2;
        this.f29778d = c0003a3;
    }

    /* renamed from: b */
    public C5607o m38854b() {
        return (C5607o) C0000d.a(this.f29775a.m23609a(((Integer) this.f29776b.a()).intValue(), this.f29777c, this.f29778d), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8017t m38852a(C5547b c5547b, C0003a<Integer> c0003a, C0003a<C7080p> c0003a2, C0003a<C7081r> c0003a3) {
        return new C8017t(c5547b, c0003a, c0003a2, c0003a3);
    }
}
