package p289e.p292c.p387d;

import java.util.concurrent.atomic.AtomicReference;
import p289e.C5989l;
import p289e.p290a.C5903b;
import p289e.p291b.C5917e;
import p289e.p300f.C5977c;

/* compiled from: CancellableSubscription */
/* renamed from: e.c.d.a */
public final class C7306a extends AtomicReference<C5917e> implements C5989l {
    private static final long serialVersionUID = 5718521705281392066L;

    public C7306a(C5917e c5917e) {
        super(c5917e);
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return get() == null;
    }

    public void U_() {
        if (get() != null) {
            C5917e c5917e = (C5917e) getAndSet(null);
            if (c5917e != null) {
                try {
                    c5917e.mo4973a();
                } catch (Throwable e) {
                    C5903b.m24794b(e);
                    C5977c.m25068a(e);
                }
            }
        }
    }
}
