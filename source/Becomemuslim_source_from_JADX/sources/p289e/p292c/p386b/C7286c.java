package p289e.p292c.p386b;

import java.util.concurrent.atomic.AtomicBoolean;
import p289e.C5984g;
import p289e.C7367k;
import p289e.p290a.C5903b;

/* compiled from: SingleProducer */
/* renamed from: e.c.b.c */
public final class C7286c<T> extends AtomicBoolean implements C5984g {
    private static final long serialVersionUID = -3353584923995471404L;
    /* renamed from: a */
    final C7367k<? super T> f25639a;
    /* renamed from: b */
    final T f25640b;

    public C7286c(C7367k<? super T> c7367k, T t) {
        this.f25639a = c7367k;
        this.f25640b = t;
    }

    /* renamed from: a */
    public void mo5119a(long j) {
        j = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (j >= null) {
            if (!(j == null || compareAndSet(0, true) == null)) {
                j = this.f25639a;
                if (!j.mo5121b()) {
                    Object obj = this.f25640b;
                    try {
                        j.mo5000a(obj);
                        if (!j.mo5121b()) {
                            j.L_();
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        C5903b.m24790a(th, j, obj);
                        return;
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
