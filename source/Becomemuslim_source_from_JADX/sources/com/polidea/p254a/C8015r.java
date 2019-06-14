package com.polidea.p254a;

import android.location.LocationManager;
import com.polidea.p254a.C5550a.C5547b;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideLocationManagerFactory */
/* renamed from: com.polidea.a.r */
public final class C8015r implements C3086c<LocationManager> {
    /* renamed from: a */
    private final C5547b f29771a;

    /* renamed from: a */
    public /* synthetic */ Object m38847a() {
        return m38848b();
    }

    public C8015r(C5547b c5547b) {
        this.f29771a = c5547b;
    }

    /* renamed from: b */
    public LocationManager m38848b() {
        return (LocationManager) C0000d.a(this.f29771a.m23614j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8015r m38846a(C5547b c5547b) {
        return new C8015r(c5547b);
    }
}
