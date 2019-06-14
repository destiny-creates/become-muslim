package p289e.p292c.p293a;

import p289e.C5988i;
import p289e.C5988i.C7359a;
import p289e.C5989l;
import p289e.C7366j;
import p289e.p290a.C5903b;
import p289e.p290a.C5910g;
import p289e.p291b.C5919g;
import p289e.p300f.C5977c;

/* compiled from: SingleOnSubscribeMap */
/* renamed from: e.c.a.bh */
public final class bh<T, R> implements C7359a<R> {
    /* renamed from: a */
    final C5988i<T> f30160a;
    /* renamed from: b */
    final C5919g<? super T, ? extends R> f30161b;

    /* compiled from: SingleOnSubscribeMap */
    /* renamed from: e.c.a.bh$a */
    static final class C8093a<T, R> extends C7366j<T> {
        /* renamed from: a */
        final C7366j<? super R> f30157a;
        /* renamed from: b */
        final C5919g<? super T, ? extends R> f30158b;
        /* renamed from: c */
        boolean f30159c;

        public C8093a(C7366j<? super R> c7366j, C5919g<? super T, ? extends R> c5919g) {
            this.f30157a = c7366j;
            this.f30158b = c5919g;
        }

        /* renamed from: a */
        public void mo6328a(T t) {
            try {
                this.f30157a.mo6328a(this.f30158b.mo4976a(t));
            } catch (Throwable th) {
                C5903b.m24794b(th);
                U_();
                mo6329a(C5910g.m24799a(th, t));
            }
        }

        /* renamed from: a */
        public void mo6329a(Throwable th) {
            if (this.f30159c) {
                C5977c.m25068a(th);
                return;
            }
            this.f30159c = true;
            this.f30157a.mo6329a(th);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39357a((C7366j) obj);
    }

    public bh(C5988i<T> c5988i, C5919g<? super T, ? extends R> c5919g) {
        this.f30160a = c5988i;
        this.f30161b = c5919g;
    }

    /* renamed from: a */
    public void m39357a(C7366j<? super R> c7366j) {
        C7366j c8093a = new C8093a(c7366j, this.f30161b);
        c7366j.m33774a((C5989l) c8093a);
        this.f30160a.m25123a(c8093a);
    }
}
