package expolib_v1.p332b;

import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
/* renamed from: expolib_v1.b.i */
public class C7500i extends C6259t {
    /* renamed from: a */
    private C6259t f26038a;

    public C7500i(C6259t c6259t) {
        if (c6259t != null) {
            this.f26038a = c6259t;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C6259t m34064a() {
        return this.f26038a;
    }

    /* renamed from: a */
    public final C7500i m34063a(C6259t c6259t) {
        if (c6259t != null) {
            this.f26038a = c6259t;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public C6259t mo5349a(long j, TimeUnit timeUnit) {
        return this.f26038a.mo5349a(j, timeUnit);
    }

    public long N_() {
        return this.f26038a.N_();
    }

    public boolean O_() {
        return this.f26038a.O_();
    }

    /* renamed from: d */
    public long mo5350d() {
        return this.f26038a.mo5350d();
    }

    /* renamed from: a */
    public C6259t mo5348a(long j) {
        return this.f26038a.mo5348a(j);
    }

    public C6259t P_() {
        return this.f26038a.P_();
    }

    /* renamed from: f */
    public C6259t mo5351f() {
        return this.f26038a.mo5351f();
    }

    /* renamed from: g */
    public void mo5352g() {
        this.f26038a.mo5352g();
    }
}
