package org.spongycastle.crypto.tls;

import java.io.IOException;

public class TlsFatalAlert extends IOException {
    private static final long serialVersionUID = 3584313123679111168L;
    /* renamed from: a */
    protected short f22591a;
    /* renamed from: b */
    protected Throwable f22592b;

    public TlsFatalAlert(short s) {
        this(s, null);
    }

    public TlsFatalAlert(short s, Throwable th) {
        super(AlertDescription.m27534b(s));
        this.f22591a = s;
        this.f22592b = th;
    }

    /* renamed from: a */
    public short m27700a() {
        return this.f22591a;
    }

    public Throwable getCause() {
        return this.f22592b;
    }
}
