package p289e.p292c.p293a;

import p289e.C7367k;
import p289e.p300f.C5977c;

/* compiled from: DeferredScalarSubscriberSafe */
/* renamed from: e.c.a.e */
public abstract class C8249e<T, R> extends C8095d<T, R> {
    /* renamed from: e */
    protected boolean f32436e;

    public C8249e(C7367k<? super R> c7367k) {
        super(c7367k);
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        if (this.f32436e) {
            C5977c.m25068a(th);
            return;
        }
        this.f32436e = true;
        super.mo5001a(th);
    }

    public void L_() {
        if (!this.f32436e) {
            this.f32436e = true;
            super.L_();
        }
    }
}
