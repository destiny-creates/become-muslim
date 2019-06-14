package org.apache.p378b.p379a.p382d;

import java.io.Serializable;
import org.apache.p378b.p379a.C6649a;
import org.apache.p378b.p379a.p380a.C6647b;

/* compiled from: StatusData */
/* renamed from: org.apache.b.a.d.a */
public class C6658a implements Serializable {
    private static final long serialVersionUID = -4341916115118014017L;
    /* renamed from: a */
    private final long f21398a = System.currentTimeMillis();
    /* renamed from: b */
    private final StackTraceElement f21399b;
    /* renamed from: c */
    private final C6649a f21400c;
    /* renamed from: d */
    private final C6647b f21401d;
    /* renamed from: e */
    private final Throwable f21402e;

    public C6658a(StackTraceElement stackTraceElement, C6649a c6649a, C6647b c6647b, Throwable th) {
        this.f21399b = stackTraceElement;
        this.f21400c = c6649a;
        this.f21401d = c6647b;
        this.f21402e = th;
    }

    /* renamed from: a */
    public C6649a m27103a() {
        return this.f21400c;
    }
}
