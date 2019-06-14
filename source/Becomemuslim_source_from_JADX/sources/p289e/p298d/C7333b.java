package p289e.p298d;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5989l;
import p289e.p291b.C5914b;
import p289e.p291b.C5916d;
import p289e.p292c.p293a.C8100j;
import p289e.p292c.p293a.C8129z;

/* compiled from: ConnectableObservable */
/* renamed from: e.d.b */
public abstract class C7333b<T> extends C5974e<T> {
    /* renamed from: d */
    public abstract void mo6326d(C5914b<? super C5989l> c5914b);

    protected C7333b(C7335a<T> c7335a) {
        super(c7335a);
    }

    /* renamed from: c */
    public C5974e<T> m33703c() {
        return C5974e.m24972a(new C8129z(this));
    }

    /* renamed from: a */
    public C5974e<T> m33701a(int i) {
        return m33702a(i, C5916d.m24828a());
    }

    /* renamed from: a */
    public C5974e<T> m33702a(int i, C5914b<? super C5989l> c5914b) {
        if (i > 0) {
            return C5974e.m24972a(new C8100j(this, i, c5914b));
        }
        mo6326d(c5914b);
        return this;
    }
}
