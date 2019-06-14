package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class DefaultTlsEncryptionCredentials extends AbstractTlsEncryptionCredentials {
    /* renamed from: a */
    protected TlsContext f32652a;
    /* renamed from: b */
    protected Certificate f32653b;
    /* renamed from: c */
    protected AsymmetricKeyParameter f32654c;

    /* renamed from: a */
    public Certificate mo6811a() {
        return this.f32653b;
    }

    /* renamed from: a */
    public byte[] mo6813a(byte[] bArr) {
        return TlsRSAUtils.m27776a(this.f32652a, (RSAKeyParameters) this.f32654c, bArr);
    }
}
