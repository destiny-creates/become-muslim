package com.polidea.p254a;

import android.content.ContentResolver;
import com.polidea.p254a.C5550a.C5547b;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideContentResolverFactory */
/* renamed from: com.polidea.a.k */
public final class C8008k implements C3086c<ContentResolver> {
    /* renamed from: a */
    private final C5547b f29761a;

    /* renamed from: a */
    public /* synthetic */ Object m38826a() {
        return m38827b();
    }

    public C8008k(C5547b c5547b) {
        this.f29761a = c5547b;
    }

    /* renamed from: b */
    public ContentResolver m38827b() {
        return (ContentResolver) C0000d.a(this.f29761a.m23613f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8008k m38825a(C5547b c5547b) {
        return new C8008k(c5547b);
    }
}
