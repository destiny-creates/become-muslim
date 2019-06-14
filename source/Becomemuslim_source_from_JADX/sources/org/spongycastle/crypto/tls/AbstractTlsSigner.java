package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public abstract class AbstractTlsSigner implements TlsSigner {
    /* renamed from: a */
    protected TlsContext f27301a;

    /* renamed from: a */
    public void mo5825a(TlsContext tlsContext) {
        this.f27301a = tlsContext;
    }

    /* renamed from: a */
    public byte[] mo5826a(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        return mo6496a(null, asymmetricKeyParameter, bArr);
    }
}
