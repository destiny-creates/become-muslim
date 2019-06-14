package p289e.p292c.p387d;

import java.util.concurrent.atomic.AtomicReference;
import p289e.C5989l;
import p289e.p303i.C5987e;

/* compiled from: SequentialSubscription */
/* renamed from: e.c.d.b */
public final class C7307b extends AtomicReference<C5989l> implements C5989l {
    private static final long serialVersionUID = 995205034283130269L;

    public C7307b(C5989l c5989l) {
        lazySet(c5989l);
    }

    /* renamed from: c */
    public C5989l m33640c() {
        C5989l c5989l = (C5989l) super.get();
        return c5989l == C7308c.INSTANCE ? C5987e.m25119b() : c5989l;
    }

    /* renamed from: a */
    public boolean m33637a(C5989l c5989l) {
        C5989l c5989l2;
        do {
            c5989l2 = (C5989l) get();
            if (c5989l2 == C7308c.INSTANCE) {
                if (c5989l != null) {
                    c5989l.U_();
                }
                return null;
            }
        } while (!compareAndSet(c5989l2, c5989l));
        if (c5989l2 != null) {
            c5989l2.U_();
        }
        return true;
    }

    /* renamed from: b */
    public boolean m33639b(C5989l c5989l) {
        C5989l c5989l2;
        do {
            c5989l2 = (C5989l) get();
            if (c5989l2 == C7308c.INSTANCE) {
                if (c5989l != null) {
                    c5989l.U_();
                }
                return null;
            }
        } while (!compareAndSet(c5989l2, c5989l));
        return true;
    }

    public void U_() {
        if (((C5989l) get()) != C7308c.INSTANCE) {
            C5989l c5989l = (C5989l) getAndSet(C7308c.INSTANCE);
            if (c5989l != null && c5989l != C7308c.INSTANCE) {
                c5989l.U_();
            }
        }
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return get() == C7308c.INSTANCE;
    }
}
