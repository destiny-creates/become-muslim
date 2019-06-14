package p289e.p292c.p386b;

import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5984g;
import p289e.C7367k;
import p289e.p290a.C5903b;

/* compiled from: SingleDelayedProducer */
/* renamed from: e.c.b.b */
public final class C7285b<T> extends AtomicInteger implements C5984g {
    private static final long serialVersionUID = -2873467947112093874L;
    /* renamed from: a */
    final C7367k<? super T> f25637a;
    /* renamed from: b */
    T f25638b;

    public C7285b(C7367k<? super T> c7367k) {
        this.f25637a = c7367k;
    }

    /* renamed from: a */
    public void mo5119a(long j) {
        j = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (j < null) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j != null) {
            while (true) {
                j = get();
                if (j == null) {
                    if (compareAndSet(0, 2) != null) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == 1 && compareAndSet(1, 3) != null) {
                C7285b.m33601a(this.f25637a, this.f25638b);
            }
        }
    }

    /* renamed from: a */
    public void m33603a(T t) {
        while (true) {
            int i = get();
            if (i != 0) {
                break;
            }
            this.f25638b = t;
            if (compareAndSet(0, 1)) {
                return;
            }
        }
        if (i == 2 && compareAndSet(2, 3)) {
            C7285b.m33601a(this.f25637a, t);
        }
    }

    /* renamed from: a */
    private static <T> void m33601a(C7367k<? super T> c7367k, T t) {
        if (!c7367k.mo5121b()) {
            try {
                c7367k.mo5000a((Object) t);
                if (c7367k.mo5121b() == null) {
                    c7367k.L_();
                }
            } catch (Throwable th) {
                C5903b.m24790a(th, c7367k, t);
            }
        }
    }
}
