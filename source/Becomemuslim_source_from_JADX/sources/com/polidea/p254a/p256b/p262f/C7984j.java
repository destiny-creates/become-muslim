package com.polidea.p254a.p256b.p262f;

import android.content.ContentResolver;
import android.location.LocationManager;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: CheckerLocationProvider_Factory */
/* renamed from: com.polidea.a.b.f.j */
public final class C7984j implements C3086c<C5605i> {
    /* renamed from: a */
    private final C0003a<ContentResolver> f29723a;
    /* renamed from: b */
    private final C0003a<LocationManager> f29724b;

    /* renamed from: a */
    public /* synthetic */ Object m38751a() {
        return m38752b();
    }

    public C7984j(C0003a<ContentResolver> c0003a, C0003a<LocationManager> c0003a2) {
        this.f29723a = c0003a;
        this.f29724b = c0003a2;
    }

    /* renamed from: b */
    public C5605i m38752b() {
        return new C5605i((ContentResolver) this.f29723a.a(), (LocationManager) this.f29724b.a());
    }

    /* renamed from: a */
    public static C7984j m38750a(C0003a<ContentResolver> c0003a, C0003a<LocationManager> c0003a2) {
        return new C7984j(c0003a, c0003a2);
    }
}
