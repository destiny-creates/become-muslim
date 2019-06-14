package p289e.p299e;

import java.util.Arrays;
import p289e.C5982f;
import p289e.C7367k;
import p289e.p290a.C5902a;
import p289e.p290a.C5903b;
import p289e.p290a.C5906e;
import p289e.p290a.C5907f;
import p289e.p290a.C5911h;
import p289e.p300f.C5977c;
import p289e.p300f.C5979f;

/* compiled from: SafeSubscriber */
/* renamed from: e.e.b */
public class C8145b<T> extends C7367k<T> {
    /* renamed from: a */
    boolean f30306a;
    /* renamed from: b */
    private final C7367k<? super T> f30307b;

    public C8145b(C7367k<? super T> c7367k) {
        super(c7367k);
        this.f30307b = c7367k;
    }

    public void L_() {
        C5911h c5911h;
        if (!this.f30306a) {
            this.f30306a = true;
            try {
                this.f30307b.L_();
                try {
                    U_();
                } catch (Throwable th) {
                    C5977c.m25068a(th);
                    c5911h = new C5911h(th.getMessage(), th);
                }
            } catch (Throwable th2) {
                C5977c.m25068a(th2);
                c5911h = new C5911h(th2.getMessage(), th2);
            }
        }
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        C5903b.m24794b(th);
        if (!this.f30306a) {
            this.f30306a = true;
            m39527b(th);
        }
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        try {
            if (!this.f30306a) {
                this.f30307b.mo5000a((Object) t);
            }
        } catch (Throwable th) {
            C5903b.m24789a(th, (C5982f) this);
        }
    }

    /* renamed from: b */
    protected void m39527b(Throwable th) {
        C5979f.m25082a().m25084b().m25055a(th);
        try {
            this.f30307b.mo5001a(th);
            try {
                U_();
            } catch (Throwable th2) {
                C5977c.m25068a(th2);
                C5906e c5906e = new C5906e(th2);
            }
        } catch (C5907f e) {
            U_();
            throw e;
        } catch (Throwable th3) {
            C5977c.m25068a(th3);
            C5907f c5907f = new C5907f("Observer.onError not implemented and error while unsubscribing.", new C5902a(Arrays.asList(new Throwable[]{th2, th3})));
        }
    }
}
