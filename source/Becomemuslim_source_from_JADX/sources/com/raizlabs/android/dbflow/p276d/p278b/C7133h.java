package com.raizlabs.android.dbflow.p276d.p278b;

import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p271a.C5655b;
import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: Update */
/* renamed from: com.raizlabs.android.dbflow.d.b.h */
public class C7133h<ModelClass extends C5698h> implements C5687a {
    /* renamed from: a */
    private C5655b f25282a;
    /* renamed from: b */
    private final Class<ModelClass> f25283b;

    /* renamed from: a */
    public String mo5061a() {
        C7135b c7135b = new C7135b("UPDATE ");
        if (!(this.f25282a == null || this.f25282a.equals(C5655b.NONE))) {
            c7135b.m33189b((Object) "OR").m33183a(this.f25282a.name());
        }
        c7135b.m33184a(C5680f.m24082a(this.f25283b)).m33188b();
        return c7135b.mo5061a();
    }
}
