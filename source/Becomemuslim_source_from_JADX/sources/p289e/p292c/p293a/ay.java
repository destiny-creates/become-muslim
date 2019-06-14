package p289e.p292c.p293a;

import java.util.concurrent.TimeUnit;
import p289e.C5974e.C7336b;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p299e.C8146d;

/* compiled from: OperatorTakeTimed */
/* renamed from: e.c.a.ay */
public final class ay<T> implements C7336b<T, T> {
    /* renamed from: a */
    final long f30111a;
    /* renamed from: b */
    final TimeUnit f30112b;
    /* renamed from: c */
    final C5986h f30113c;

    /* compiled from: OperatorTakeTimed */
    /* renamed from: e.c.a.ay$a */
    static final class C8080a<T> extends C7367k<T> implements C5913a {
        /* renamed from: a */
        final C7367k<? super T> f30110a;

        public C8080a(C7367k<? super T> c7367k) {
            super(c7367k);
            this.f30110a = c7367k;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f30110a.mo5000a((Object) t);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f30110a.mo5001a(th);
            U_();
        }

        public void L_() {
            this.f30110a.L_();
            U_();
        }

        /* renamed from: a */
        public void mo4985a() {
            L_();
        }
    }

    public ay(long j, TimeUnit timeUnit, C5986h c5986h) {
        this.f30111a = j;
        this.f30112b = timeUnit;
        this.f30113c = c5986h;
    }

    /* renamed from: a */
    public C7367k<? super T> m39299a(C7367k<? super T> c7367k) {
        C5989l a = this.f30113c.mo5127a();
        c7367k.m33781a(a);
        Object c8080a = new C8080a(new C8146d(c7367k));
        a.mo6333a(c8080a, this.f30111a, this.f30112b);
        return c8080a;
    }
}
