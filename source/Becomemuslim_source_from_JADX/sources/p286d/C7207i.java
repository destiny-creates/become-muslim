package p286d;

import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
/* renamed from: d.i */
public class C7207i extends C5877u {
    /* renamed from: a */
    private C5877u f25474a;

    public C7207i(C5877u c5877u) {
        if (c5877u != null) {
            this.f25474a = c5877u;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a */
    public final C5877u m33456a() {
        return this.f25474a;
    }

    /* renamed from: a */
    public final C7207i m33455a(C5877u c5877u) {
        if (c5877u != null) {
            this.f25474a = c5877u;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public C5877u timeout(long j, TimeUnit timeUnit) {
        return this.f25474a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f25474a.timeoutNanos();
    }

    public boolean hasDeadline() {
        return this.f25474a.hasDeadline();
    }

    public long deadlineNanoTime() {
        return this.f25474a.deadlineNanoTime();
    }

    public C5877u deadlineNanoTime(long j) {
        return this.f25474a.deadlineNanoTime(j);
    }

    public C5877u clearTimeout() {
        return this.f25474a.clearTimeout();
    }

    public C5877u clearDeadline() {
        return this.f25474a.clearDeadline();
    }

    public void throwIfReached() {
        this.f25474a.throwIfReached();
    }
}
