package com.polidea.p254a.p256b;

import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: DeviceModule_ProvideMacAddressFactory */
/* renamed from: com.polidea.a.b.g */
public final class C7993g implements C3086c<String> {
    /* renamed from: a */
    private final C5584c f29740a;

    /* renamed from: a */
    public /* synthetic */ Object m38777a() {
        return m38778b();
    }

    public C7993g(C5584c c5584c) {
        this.f29740a = c5584c;
    }

    /* renamed from: b */
    public String m38778b() {
        return (String) C0000d.a(this.f29740a.m23770a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7993g m38776a(C5584c c5584c) {
        return new C7993g(c5584c);
    }
}
