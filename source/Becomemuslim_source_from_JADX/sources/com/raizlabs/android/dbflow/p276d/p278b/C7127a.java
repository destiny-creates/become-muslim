package com.raizlabs.android.dbflow.p276d.p278b;

import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C5690c;
import com.raizlabs.android.dbflow.p276d.p280d.C5691a;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.List;

/* compiled from: BaseModelQueriable */
/* renamed from: com.raizlabs.android.dbflow.d.b.a */
public abstract class C7127a<ModelClass extends C5698h> implements C5687a, C5691a<ModelClass> {
    /* renamed from: a */
    private final Class<ModelClass> f25264a;

    protected C7127a(Class<ModelClass> cls) {
        this.f25264a = cls;
    }

    /* renamed from: b */
    public List<ModelClass> mo6280b() {
        return C5690c.m24121a(this.f25264a, mo5061a(), new String[0]);
    }

    /* renamed from: c */
    public ModelClass mo5060c() {
        return C5690c.m24127b(this.f25264a, mo5061a(), new String[0]);
    }

    /* renamed from: d */
    public Class<ModelClass> m33166d() {
        return this.f25264a;
    }

    public String toString() {
        return mo5061a();
    }
}
