package io.p347a.p348a.p349a.p350a.p351a;

import android.content.Context;

/* compiled from: AbstractValueCache */
/* renamed from: io.a.a.a.a.a.a */
public abstract class C7597a<T> implements C6415c<T> {
    /* renamed from: a */
    private final C6415c<T> f26293a;

    /* renamed from: a */
    protected abstract T mo6411a(Context context);

    /* renamed from: a */
    protected abstract void mo6412a(Context context, T t);

    public C7597a(C6415c<T> c6415c) {
        this.f26293a = c6415c;
    }

    /* renamed from: a */
    public final synchronized T mo5433a(Context context, C6416d<T> c6416d) {
        T a;
        a = mo6411a(context);
        if (a == null) {
            a = this.f26293a != null ? this.f26293a.mo5433a(context, c6416d) : c6416d.mo5436c(context);
            m34328b(context, a);
        }
        return a;
    }

    /* renamed from: b */
    private void m34328b(Context context, T t) {
        if (t != null) {
            mo6412a(context, (Object) t);
            return;
        }
        throw new NullPointerException();
    }
}
