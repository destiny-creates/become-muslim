package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;

public class RSAEngine implements AsymmetricBlockCipher {
    /* renamed from: a */
    private RSACoreEngine f26746a;

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        if (this.f26746a == null) {
            this.f26746a = new RSACoreEngine();
        }
        this.f26746a.m27427a(z, cipherParameters);
    }

    /* renamed from: a */
    public int mo5736a() {
        return this.f26746a.m27425a();
    }

    /* renamed from: b */
    public int mo5739b() {
        return this.f26746a.m27429b();
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26746a != null) {
            return this.f26746a.m27428a(this.f26746a.m27430b(this.f26746a.m27426a(bArr, i, i2)));
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
