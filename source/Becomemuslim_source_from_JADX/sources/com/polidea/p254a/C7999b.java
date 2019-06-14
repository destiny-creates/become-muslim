package com.polidea.p254a;

import android.content.Context;
import com.polidea.p254a.C5550a.C5547b;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideApplicationContextFactory */
/* renamed from: com.polidea.a.b */
public final class C7999b implements C3086c<Context> {
    /* renamed from: a */
    private final C5547b f29752a;

    /* renamed from: a */
    public /* synthetic */ Object m38798a() {
        return m38799b();
    }

    public C7999b(C5547b c5547b) {
        this.f29752a = c5547b;
    }

    /* renamed from: b */
    public Context m38799b() {
        return (Context) C0000d.a(this.f29752a.m23608a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7999b m38796a(C5547b c5547b) {
        return new C7999b(c5547b);
    }

    /* renamed from: b */
    public static Context m38797b(C5547b c5547b) {
        return (Context) C0000d.a(c5547b.m23608a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
