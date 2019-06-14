package p043b;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

/* compiled from: CancellationTokenSource */
/* renamed from: b.g */
public class C0822g implements Closeable {
    /* renamed from: a */
    private final Object f2285a;
    /* renamed from: b */
    private final List<C0821f> f2286b;
    /* renamed from: c */
    private ScheduledFuture<?> f2287c;
    /* renamed from: d */
    private boolean f2288d;
    /* renamed from: e */
    private boolean f2289e;

    /* renamed from: a */
    public boolean m2975a() {
        boolean z;
        synchronized (this.f2285a) {
            m2972b();
            z = this.f2288d;
        }
        return z;
    }

    public void close() {
        synchronized (this.f2285a) {
            if (this.f2289e) {
                return;
            }
            m2973c();
            for (C0821f close : this.f2286b) {
                close.close();
            }
            this.f2286b.clear();
            this.f2289e = true;
        }
    }

    /* renamed from: a */
    void m2974a(C0821f c0821f) {
        synchronized (this.f2285a) {
            m2972b();
            this.f2286b.remove(c0821f);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m2975a())});
    }

    /* renamed from: b */
    private void m2972b() {
        if (this.f2289e) {
            throw new IllegalStateException("Object already closed");
        }
    }

    /* renamed from: c */
    private void m2973c() {
        if (this.f2287c != null) {
            this.f2287c.cancel(true);
            this.f2287c = null;
        }
    }
}
