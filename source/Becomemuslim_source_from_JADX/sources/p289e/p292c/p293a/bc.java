package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p289e.C5974e.C7336b;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p292c.p386b.C7285b;

/* compiled from: OperatorToObservableList */
/* renamed from: e.c.a.bc */
public final class bc<T> implements C7336b<List<T>, T> {

    /* compiled from: OperatorToObservableList */
    /* renamed from: e.c.a.bc$a */
    static final class C5933a {
        /* renamed from: a */
        static final bc<Object> f19654a = new bc();
    }

    /* renamed from: a */
    public static <T> bc<T> m39324a() {
        return C5933a.f19654a;
    }

    bc() {
    }

    /* renamed from: a */
    public C7367k<? super T> m39325a(final C7367k<? super List<T>> c7367k) {
        final C5984g c7285b = new C7285b(c7367k);
        C5989l c80871 = new C7367k<T>(this) {
            /* renamed from: a */
            boolean f30130a;
            /* renamed from: b */
            List<T> f30131b = new LinkedList();
            /* renamed from: e */
            final /* synthetic */ bc f30134e;

            /* renamed from: c */
            public void mo6323c() {
                m33779a((long) Clock.MAX_TIME);
            }

            public void L_() {
                if (!this.f30130a) {
                    this.f30130a = true;
                    try {
                        Object arrayList = new ArrayList(this.f30131b);
                        this.f30131b = null;
                        c7285b.m33603a(arrayList);
                    } catch (Throwable th) {
                        C5903b.m24789a(th, (C5982f) this);
                    }
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c7367k.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                if (!this.f30130a) {
                    this.f30131b.add(t);
                }
            }
        };
        c7367k.m33781a(c80871);
        c7367k.mo6324a(c7285b);
        return c80871;
    }
}
