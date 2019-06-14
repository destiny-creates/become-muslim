package com.polidea.p254a.p256b;

import com.p071c.p072a.C4535a;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.p256b.p258b.C5570m;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: DeviceModule_ProvideConnectionStateChangeListenerFactory */
/* renamed from: com.polidea.a.b.e */
public final class C7982e implements C3086c<C5570m> {
    /* renamed from: a */
    private final C0003a<C4535a<C5554a>> f29720a;

    /* renamed from: a */
    public /* synthetic */ Object m38742a() {
        return m38743b();
    }

    public C7982e(C0003a<C4535a<C5554a>> c0003a) {
        this.f29720a = c0003a;
    }

    /* renamed from: b */
    public C5570m m38743b() {
        return (C5570m) C0000d.a(C5584c.m23765a((C4535a) this.f29720a.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7982e m38741a(C0003a<C4535a<C5554a>> c0003a) {
        return new C7982e(c0003a);
    }
}
