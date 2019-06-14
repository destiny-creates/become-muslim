package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C7367k;

/* compiled from: OperatorSkip */
/* renamed from: e.c.a.au */
public final class au<T> implements C7336b<T, T> {
    /* renamed from: a */
    final int f30080a;

    public au(int i) {
        if (i >= 0) {
            this.f30080a = i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("n >= 0 required but it was ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public C7367k<? super T> m39262a(final C7367k<? super T> c7367k) {
        return new C7367k<T>(this, c7367k) {
            /* renamed from: a */
            int f30077a;
            /* renamed from: c */
            final /* synthetic */ au f30079c;

            public void L_() {
                c7367k.L_();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c7367k.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                if (this.f30077a >= this.f30079c.f30080a) {
                    c7367k.mo5000a((Object) t);
                } else {
                    this.f30077a++;
                }
            }

            /* renamed from: a */
            public void mo6324a(C5984g c5984g) {
                c7367k.mo6324a(c5984g);
                c5984g.mo5119a((long) this.f30079c.f30080a);
            }
        };
    }
}
