package com.raizlabs.android.dbflow.p273c.p274a;

import com.raizlabs.android.dbflow.p273c.C5667b;
import com.raizlabs.android.dbflow.p276d.p277a.C5686d;
import com.raizlabs.android.dbflow.p276d.p277a.C8023b;
import com.raizlabs.android.dbflow.p276d.p278b.C7132g;
import com.raizlabs.android.dbflow.p276d.p280d.C5691a;
import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: SelectSingleModelTransaction */
/* renamed from: com.raizlabs.android.dbflow.c.a.c */
public class C8022c<ModelClass extends C5698h> extends C7116a<ModelClass> {
    /* renamed from: e */
    private C5691a<ModelClass> f29792e;

    /* renamed from: b */
    public /* synthetic */ Object mo6273b() {
        return m38873c();
    }

    public C8022c(Class<ModelClass> cls, C5665d<ModelClass> c5665d, C8023b... c8023bArr) {
        this(new C7132g().m33176a(cls).m38893a((C5686d[]) c8023bArr), c5665d);
    }

    public C8022c(C5691a<ModelClass> c5691a, C5665d<ModelClass> c5665d) {
        super(C5667b.m24038b(), c5665d);
        this.f29792e = c5691a;
    }

    /* renamed from: c */
    public ModelClass m38873c() {
        return this.f29792e.mo5060c();
    }
}
