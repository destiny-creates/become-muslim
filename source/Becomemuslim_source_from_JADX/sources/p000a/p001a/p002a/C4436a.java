package p000a.p001a.p002a;

import p000a.p003b.p004a.C0003a;

/* compiled from: DelegateFactory */
/* renamed from: a.a.a.a */
public final class C4436a<T> implements C3086c<T> {
    /* renamed from: a */
    private C0003a<T> f11799a;

    /* renamed from: a */
    public T mo1a() {
        if (this.f11799a != null) {
            return this.f11799a.mo1a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public void m14725a(C0003a<T> c0003a) {
        if (c0003a == null) {
            throw new IllegalArgumentException();
        } else if (this.f11799a == null) {
            this.f11799a = c0003a;
        } else {
            throw new IllegalStateException();
        }
    }
}
