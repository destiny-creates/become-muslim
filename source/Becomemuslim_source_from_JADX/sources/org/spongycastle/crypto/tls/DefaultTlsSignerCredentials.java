package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class DefaultTlsSignerCredentials extends AbstractTlsSignerCredentials {
    /* renamed from: a */
    protected TlsContext f32655a;
    /* renamed from: b */
    protected Certificate f32656b;
    /* renamed from: c */
    protected AsymmetricKeyParameter f32657c;
    /* renamed from: d */
    protected SignatureAndHashAlgorithm f32658d;
    /* renamed from: e */
    protected TlsSigner f32659e;

    /* renamed from: a */
    public Certificate mo6811a() {
        return this.f32656b;
    }

    /* renamed from: a */
    public byte[] mo6814a(byte[] bArr) {
        try {
            if (TlsUtils.m27860c(this.f32655a)) {
                return this.f32659e.mo6496a(this.f32658d, this.f32657c, bArr);
            }
            return this.f32659e.mo5826a(this.f32657c, bArr);
        } catch (byte[] bArr2) {
            throw new TlsFatalAlert((short) 80, bArr2);
        }
    }

    public SignatureAndHashAlgorithm S_() {
        return this.f32658d;
    }
}
