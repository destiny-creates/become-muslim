package com.polidea.p254a.p256b.p258b;

import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ConnectionModule_ProvideIllegalOperationHandlerFactory */
/* renamed from: com.polidea.a.b.b.k */
public final class C7945k implements C3086c<aa> {
    /* renamed from: a */
    private final C5568d f29610a;
    /* renamed from: b */
    private final C0003a<ae> f29611b;
    /* renamed from: c */
    private final C0003a<az> f29612c;

    /* renamed from: a */
    public /* synthetic */ Object m38616a() {
        return m38617b();
    }

    public C7945k(C5568d c5568d, C0003a<ae> c0003a, C0003a<az> c0003a2) {
        this.f29610a = c5568d;
        this.f29611b = c0003a;
        this.f29612c = c0003a2;
    }

    /* renamed from: b */
    public aa m38617b() {
        return (aa) C0000d.a(this.f29610a.m23738a(this.f29611b, this.f29612c), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7945k m38615a(C5568d c5568d, C0003a<ae> c0003a, C0003a<az> c0003a2) {
        return new C7945k(c5568d, c0003a, c0003a2);
    }
}
