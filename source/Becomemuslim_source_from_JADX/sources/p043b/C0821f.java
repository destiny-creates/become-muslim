package p043b;

import java.io.Closeable;

/* compiled from: CancellationTokenRegistration */
/* renamed from: b.f */
public class C0821f implements Closeable {
    /* renamed from: a */
    private final Object f2281a;
    /* renamed from: b */
    private C0822g f2282b;
    /* renamed from: c */
    private Runnable f2283c;
    /* renamed from: d */
    private boolean f2284d;

    public void close() {
        synchronized (this.f2281a) {
            if (this.f2284d) {
                return;
            }
            this.f2284d = true;
            this.f2282b.m2974a(this);
            this.f2282b = null;
            this.f2283c = null;
        }
    }
}
