package p289e.p292c.p293a;

import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5912a;
import p289e.C5912a.C7228a;
import p289e.C5921b;
import p289e.C5989l;
import p289e.p303i.C7364d;

/* compiled from: CompletableOnSubscribeConcatArray */
/* renamed from: e.c.a.c */
public final class C8094c implements C7228a {
    /* renamed from: a */
    final C5912a[] f30163a;

    /* compiled from: CompletableOnSubscribeConcatArray */
    /* renamed from: e.c.a.c$a */
    static final class C7267a extends AtomicInteger implements C5921b {
        private static final long serialVersionUID = -7965400327305809232L;
        /* renamed from: a */
        final C5921b f25583a;
        /* renamed from: b */
        final C5912a[] f25584b;
        /* renamed from: c */
        int f25585c;
        /* renamed from: d */
        final C7364d f25586d = new C7364d();

        public C7267a(C5921b c5921b, C5912a[] c5912aArr) {
            this.f25583a = c5921b;
            this.f25584b = c5912aArr;
        }

        /* renamed from: a */
        public void mo5115a(C5989l c5989l) {
            this.f25586d.m33770a(c5989l);
        }

        /* renamed from: a */
        public void mo5116a(Throwable th) {
            this.f25583a.mo5116a(th);
        }

        /* renamed from: a */
        public void mo5114a() {
            m33572b();
        }

        /* renamed from: b */
        void m33572b() {
            if (!this.f25586d.mo5121b() && getAndIncrement() == 0) {
                C5912a[] c5912aArr = this.f25584b;
                while (!this.f25586d.mo5121b()) {
                    int i = this.f25585c;
                    this.f25585c = i + 1;
                    if (i == c5912aArr.length) {
                        this.f25583a.mo5114a();
                        return;
                    }
                    c5912aArr[i].m24815a((C5921b) this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39361a((C5921b) obj);
    }

    public C8094c(C5912a[] c5912aArr) {
        this.f30163a = c5912aArr;
    }

    /* renamed from: a */
    public void m39361a(C5921b c5921b) {
        C7267a c7267a = new C7267a(c5921b, this.f30163a);
        c5921b.mo5115a(c7267a.f25586d);
        c7267a.m33572b();
    }
}
