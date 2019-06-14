package p289e.p292c.p293a;

import java.util.NoSuchElementException;
import p289e.C5974e.C7336b;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p292c.p386b.C7286c;
import p289e.p300f.C5977c;

/* compiled from: OperatorSingle */
/* renamed from: e.c.a.at */
public final class at<T> implements C7336b<T, T> {
    /* renamed from: a */
    private final boolean f30075a;
    /* renamed from: b */
    private final T f30076b;

    /* compiled from: OperatorSingle */
    /* renamed from: e.c.a.at$a */
    static final class C5930a {
        /* renamed from: a */
        static final at<?> f19651a = new at();
    }

    /* compiled from: OperatorSingle */
    /* renamed from: e.c.a.at$b */
    static final class C8074b<T> extends C7367k<T> {
        /* renamed from: a */
        private final C7367k<? super T> f30069a;
        /* renamed from: b */
        private final boolean f30070b;
        /* renamed from: c */
        private final T f30071c;
        /* renamed from: d */
        private T f30072d;
        /* renamed from: e */
        private boolean f30073e;
        /* renamed from: f */
        private boolean f30074f;

        C8074b(C7367k<? super T> c7367k, boolean z, T t) {
            this.f30069a = c7367k;
            this.f30070b = z;
            this.f30071c = t;
            m33779a((long) 2);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f30074f) {
                if (this.f30073e) {
                    this.f30074f = true;
                    this.f30069a.mo5001a(new IllegalArgumentException("Sequence contains too many elements"));
                    U_();
                    return;
                }
                this.f30072d = t;
                this.f30073e = true;
            }
        }

        public void L_() {
            if (!this.f30074f) {
                if (this.f30073e) {
                    this.f30069a.mo6324a(new C7286c(this.f30069a, this.f30072d));
                } else if (this.f30070b) {
                    this.f30069a.mo6324a(new C7286c(this.f30069a, this.f30071c));
                } else {
                    this.f30069a.mo5001a(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f30074f) {
                C5977c.m25068a(th);
            } else {
                this.f30069a.mo5001a(th);
            }
        }
    }

    /* renamed from: a */
    public static <T> at<T> m39256a() {
        return C5930a.f19651a;
    }

    at() {
        this(false, null);
    }

    private at(boolean z, T t) {
        this.f30075a = z;
        this.f30076b = t;
    }

    /* renamed from: a */
    public C7367k<? super T> m39257a(C7367k<? super T> c7367k) {
        C5989l c8074b = new C8074b(c7367k, this.f30075a, this.f30076b);
        c7367k.m33781a(c8074b);
        return c8074b;
    }
}
