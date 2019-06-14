package com.raizlabs.android.dbflow.p273c.p274a;

import com.raizlabs.android.dbflow.p273c.C5667b;

/* compiled from: BaseResultTransaction */
/* renamed from: com.raizlabs.android.dbflow.c.a.a */
public abstract class C7116a<ResultClass> extends C5664b<ResultClass> {
    /* renamed from: e */
    private C5665d<ResultClass> f25255e;

    public C7116a(C5667b c5667b, C5665d<ResultClass> c5665d) {
        super(c5667b);
        this.f25255e = c5665d;
    }

    /* renamed from: a */
    public boolean mo5047a(ResultClass resultClass) {
        return (this.f25255e == null || this.f25255e.mo5044a(this, resultClass) == null) ? null : true;
    }

    /* renamed from: b */
    public void mo5048b(ResultClass resultClass) {
        if (this.f25255e != null) {
            this.f25255e.mo5042a((Object) resultClass);
        }
    }

    /* renamed from: a */
    public boolean mo5046a() {
        return this.f25255e != null && this.f25255e.mo5043a((C5664b) this);
    }
}
