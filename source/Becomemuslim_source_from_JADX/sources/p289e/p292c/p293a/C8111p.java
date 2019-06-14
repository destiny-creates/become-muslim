package p289e.p292c.p293a;

import java.util.Arrays;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C7367k;
import p289e.p290a.C5902a;
import p289e.p290a.C5903b;
import p289e.p300f.C5977c;

/* compiled from: OnSubscribeDoOnEach */
/* renamed from: e.c.a.p */
public class C8111p<T> implements C7335a<T> {
    /* renamed from: a */
    private final C5982f<? super T> f30214a;
    /* renamed from: b */
    private final C5974e<T> f30215b;

    /* compiled from: OnSubscribeDoOnEach */
    /* renamed from: e.c.a.p$a */
    private static final class C8110a<T> extends C7367k<T> {
        /* renamed from: a */
        private final C7367k<? super T> f30211a;
        /* renamed from: b */
        private final C5982f<? super T> f30212b;
        /* renamed from: c */
        private boolean f30213c;

        C8110a(C7367k<? super T> c7367k, C5982f<? super T> c5982f) {
            super(c7367k);
            this.f30211a = c7367k;
            this.f30212b = c5982f;
        }

        public void L_() {
            if (!this.f30213c) {
                try {
                    this.f30212b.L_();
                    this.f30213c = true;
                    this.f30211a.L_();
                } catch (Throwable th) {
                    C5903b.m24789a(th, (C5982f) this);
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f30213c) {
                C5977c.m25068a(th);
                return;
            }
            this.f30213c = true;
            try {
                this.f30212b.mo5001a(th);
                this.f30211a.mo5001a(th);
            } catch (Throwable th2) {
                C5903b.m24794b(th2);
                this.f30211a.mo5001a(new C5902a(Arrays.asList(new Throwable[]{th, th2})));
            }
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f30213c) {
                try {
                    this.f30212b.mo5000a((Object) t);
                    this.f30211a.mo5000a((Object) t);
                } catch (Throwable th) {
                    C5903b.m24790a(th, this, t);
                }
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39421a((C7367k) obj);
    }

    public C8111p(C5974e<T> c5974e, C5982f<? super T> c5982f) {
        this.f30215b = c5974e;
        this.f30214a = c5982f;
    }

    /* renamed from: a */
    public void m39421a(C7367k<? super T> c7367k) {
        this.f30215b.m25007a(new C8110a(c7367k, this.f30214a));
    }
}
