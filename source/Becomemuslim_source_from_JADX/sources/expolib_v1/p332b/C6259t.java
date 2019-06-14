package expolib_v1.p332b;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
/* renamed from: expolib_v1.b.t */
public class C6259t {
    /* renamed from: c */
    public static final C6259t f20394c = new C75071();
    /* renamed from: a */
    private boolean f20395a;
    /* renamed from: b */
    private long f20396b;
    /* renamed from: d */
    private long f20397d;

    /* compiled from: Timeout */
    /* renamed from: expolib_v1.b.t$1 */
    class C75071 extends C6259t {
        /* renamed from: a */
        public C6259t mo5348a(long j) {
            return this;
        }

        /* renamed from: a */
        public C6259t mo5349a(long j, TimeUnit timeUnit) {
            return this;
        }

        /* renamed from: g */
        public void mo5352g() {
        }

        C75071() {
        }
    }

    /* renamed from: a */
    public C6259t mo5349a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("timeout < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            this.f20397d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long N_() {
        return this.f20397d;
    }

    public boolean O_() {
        return this.f20395a;
    }

    /* renamed from: d */
    public long mo5350d() {
        if (this.f20395a) {
            return this.f20396b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: a */
    public C6259t mo5348a(long j) {
        this.f20395a = true;
        this.f20396b = j;
        return this;
    }

    public C6259t P_() {
        this.f20397d = 0;
        return this;
    }

    /* renamed from: f */
    public C6259t mo5351f() {
        this.f20395a = false;
        return this;
    }

    /* renamed from: g */
    public void mo5352g() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (!this.f20395a) {
        } else {
            if (this.f20396b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
        }
    }
}
