package p289e.p292c.p294c;

import java.util.concurrent.TimeUnit;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p303i.C5987e;
import p289e.p303i.C7361a;

/* compiled from: ImmediateScheduler */
/* renamed from: e.c.c.f */
public final class C7296f extends C5986h {
    /* renamed from: a */
    public static final C7296f f25670a = new C7296f();

    /* compiled from: ImmediateScheduler */
    /* renamed from: e.c.c.f$a */
    final class C8133a extends C7353a implements C5989l {
        /* renamed from: a */
        final C7361a f30277a = new C7361a();
        /* renamed from: b */
        final /* synthetic */ C7296f f30278b;

        C8133a(C7296f c7296f) {
            this.f30278b = c7296f;
        }

        /* renamed from: a */
        public C5989l mo6333a(C5913a c5913a, long j, TimeUnit timeUnit) {
            return mo6332a(new C7303l(c5913a, this, this.f30278b.m25116b() + timeUnit.toMillis(j)));
        }

        /* renamed from: a */
        public C5989l mo6332a(C5913a c5913a) {
            c5913a.mo4985a();
            return C5987e.m25119b();
        }

        public void U_() {
            this.f30277a.U_();
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f30277a.mo5121b();
        }
    }

    private C7296f() {
    }

    /* renamed from: a */
    public C7353a mo5127a() {
        return new C8133a(this);
    }
}
