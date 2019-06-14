package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;

public class SignatureAndHashAlgorithm {
    /* renamed from: a */
    protected short f22570a;
    /* renamed from: b */
    protected short f22571b;

    public SignatureAndHashAlgorithm(short s, short s2) {
        if (!TlsUtils.m27848b(s)) {
            throw new IllegalArgumentException("'hash' should be a uint8");
        } else if (!TlsUtils.m27848b(s2)) {
            throw new IllegalArgumentException("'signature' should be a uint8");
        } else if (s2 != (short) 0) {
            this.f22570a = s;
            this.f22571b = s2;
        } else {
            throw new IllegalArgumentException("'signature' MUST NOT be \"anonymous\"");
        }
    }

    /* renamed from: a */
    public short m27618a() {
        return this.f22570a;
    }

    /* renamed from: b */
    public short m27620b() {
        return this.f22571b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof SignatureAndHashAlgorithm)) {
            return false;
        }
        SignatureAndHashAlgorithm signatureAndHashAlgorithm = (SignatureAndHashAlgorithm) obj;
        if (signatureAndHashAlgorithm.m27618a() == m27618a() && signatureAndHashAlgorithm.m27620b() == m27620b()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (m27618a() << 16) | m27620b();
    }

    /* renamed from: a */
    public void m27619a(OutputStream outputStream) {
        TlsUtils.m27817a(m27618a(), outputStream);
        TlsUtils.m27817a(m27620b(), outputStream);
    }

    /* renamed from: a */
    public static SignatureAndHashAlgorithm m27617a(InputStream inputStream) {
        return new SignatureAndHashAlgorithm(TlsUtils.m27802a(inputStream), TlsUtils.m27802a(inputStream));
    }
}
