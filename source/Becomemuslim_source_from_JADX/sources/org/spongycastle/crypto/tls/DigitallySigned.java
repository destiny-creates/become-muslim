package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;

public class DigitallySigned {
    /* renamed from: a */
    protected SignatureAndHashAlgorithm f22507a;
    /* renamed from: b */
    protected byte[] f22508b;

    public DigitallySigned(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr) {
        if (bArr != null) {
            this.f22507a = signatureAndHashAlgorithm;
            this.f22508b = bArr;
            return;
        }
        throw new IllegalArgumentException("'signature' cannot be null");
    }

    /* renamed from: a */
    public SignatureAndHashAlgorithm m27556a() {
        return this.f22507a;
    }

    /* renamed from: b */
    public byte[] m27558b() {
        return this.f22508b;
    }

    /* renamed from: a */
    public void m27557a(OutputStream outputStream) {
        if (this.f22507a != null) {
            this.f22507a.m27619a(outputStream);
        }
        TlsUtils.m27844b(this.f22508b, outputStream);
    }

    /* renamed from: a */
    public static DigitallySigned m27555a(TlsContext tlsContext, InputStream inputStream) {
        return new DigitallySigned(TlsUtils.m27860c(tlsContext) != null ? SignatureAndHashAlgorithm.m27617a(inputStream) : null, TlsUtils.m27875f(inputStream));
    }
}
