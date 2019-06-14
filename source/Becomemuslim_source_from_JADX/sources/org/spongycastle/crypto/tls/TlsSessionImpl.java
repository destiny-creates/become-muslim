package org.spongycastle.crypto.tls;

import org.spongycastle.util.Arrays;

class TlsSessionImpl implements TlsSession {
    /* renamed from: a */
    final byte[] f27351a;
    /* renamed from: b */
    SessionParameters f27352b;

    TlsSessionImpl(byte[] bArr, SessionParameters sessionParameters) {
        if (bArr == null) {
            throw new IllegalArgumentException("'sessionID' cannot be null");
        } else if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("'sessionID' must have length between 1 and 32 bytes, inclusive");
        } else {
            this.f27351a = Arrays.m29373b(bArr);
            this.f27352b = sessionParameters;
        }
    }

    /* renamed from: a */
    public synchronized byte[] mo5845a() {
        return this.f27351a;
    }

    /* renamed from: b */
    public synchronized void mo5846b() {
        if (this.f27352b != null) {
            this.f27352b.m27612a();
            this.f27352b = null;
        }
    }
}
