package p289e;

import com.facebook.common.time.Clock;
import p289e.p292c.p295e.C7329m;

/* compiled from: Subscriber */
/* renamed from: e.k */
public abstract class C7367k<T> implements C5982f<T>, C5989l {
    /* renamed from: a */
    private final C7329m f25768a;
    /* renamed from: b */
    private final C7367k<?> f25769b;
    /* renamed from: c */
    private C5984g f25770c;
    /* renamed from: d */
    private long f25771d;

    /* renamed from: c */
    public void mo6323c() {
    }

    protected C7367k() {
        this(null, false);
    }

    protected C7367k(C7367k<?> c7367k) {
        this(c7367k, true);
    }

    protected C7367k(C7367k<?> c7367k, boolean z) {
        this.f25771d = Long.MIN_VALUE;
        this.f25769b = c7367k;
        c7367k = (!z || c7367k == null) ? new C7329m() : c7367k.f25768a;
        this.f25768a = c7367k;
    }

    /* renamed from: a */
    public final void m33781a(C5989l c5989l) {
        this.f25768a.m33693a(c5989l);
    }

    public final void U_() {
        this.f25768a.U_();
    }

    /* renamed from: b */
    public final boolean mo5121b() {
        return this.f25768a.mo5121b();
    }

    /* renamed from: a */
    protected final void m33779a(long j) {
        if (j >= 0) {
            synchronized (this) {
                if (this.f25770c != null) {
                    C5984g c5984g = this.f25770c;
                    c5984g.mo5119a(j);
                    return;
                }
                mo6325b(j);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("number requested cannot be negative: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: b */
    private void mo6325b(long j) {
        if (this.f25771d == Long.MIN_VALUE) {
            this.f25771d = j;
            return;
        }
        long j2 = this.f25771d + j;
        if (j2 < 0) {
            this.f25771d = Clock.MAX_TIME;
        } else {
            this.f25771d = j2;
        }
    }

    /* renamed from: a */
    public void mo6324a(C5984g c5984g) {
        synchronized (this) {
            long j = this.f25771d;
            this.f25770c = c5984g;
            c5984g = (this.f25769b == null || j != Long.MIN_VALUE) ? null : true;
        }
        if (c5984g != null) {
            this.f25769b.mo6324a(this.f25770c);
        } else if (j == Long.MIN_VALUE) {
            this.f25770c.mo5119a(Clock.MAX_TIME);
        } else {
            this.f25770c.mo5119a(j);
        }
    }
}
