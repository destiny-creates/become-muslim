package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5919g;
import p289e.p292c.p386b.C7285b;
import p289e.p300f.C5977c;

/* compiled from: OperatorAny */
/* renamed from: e.c.a.ah */
public final class ah<T> implements C7336b<Boolean, T> {
    /* renamed from: a */
    final C5919g<? super T, Boolean> f29925a;
    /* renamed from: b */
    final boolean f29926b;

    public ah(C5919g<? super T, Boolean> c5919g, boolean z) {
        this.f29925a = c5919g;
        this.f29926b = z;
    }

    /* renamed from: a */
    public C7367k<? super T> m39131a(final C7367k<? super Boolean> c7367k) {
        final C5984g c7285b = new C7285b(c7367k);
        C5989l c80561 = new C7367k<T>(this) {
            /* renamed from: a */
            boolean f29920a;
            /* renamed from: b */
            boolean f29921b;
            /* renamed from: e */
            final /* synthetic */ ah f29924e;

            /* renamed from: a */
            public void mo5000a(T t) {
                if (!this.f29921b) {
                    this.f29920a = true;
                    try {
                        if (((Boolean) this.f29924e.f29925a.mo4976a(t)).booleanValue()) {
                            this.f29921b = true;
                            c7285b.m33603a(Boolean.valueOf(true ^ this.f29924e.f29926b));
                            U_();
                        }
                    } catch (Throwable th) {
                        C5903b.m24790a(th, this, t);
                    }
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                if (this.f29921b) {
                    C5977c.m25068a(th);
                    return;
                }
                this.f29921b = true;
                c7367k.mo5001a(th);
            }

            public void L_() {
                if (!this.f29921b) {
                    this.f29921b = true;
                    if (this.f29920a) {
                        c7285b.m33603a(Boolean.valueOf(false));
                    } else {
                        c7285b.m33603a(Boolean.valueOf(this.f29924e.f29926b));
                    }
                }
            }
        };
        c7367k.m33781a(c80561);
        c7367k.mo6324a(c7285b);
        return c80561;
    }
}
