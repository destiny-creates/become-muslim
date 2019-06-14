package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DigestingMessageSigner implements Signer {
    /* renamed from: a */
    private final Digest f27648a;
    /* renamed from: b */
    private final MessageSigner f27649b;
    /* renamed from: c */
    private boolean f27650c;

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.f27650c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z) {
            if (!asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("Signing Requires Private Key.");
            }
        }
        if (!z) {
            if (asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("Verification Requires Public Key.");
            }
        }
        m36324b();
        this.f27649b.mo5913a(z, cipherParameters);
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        if (this.f27650c) {
            byte[] bArr = new byte[this.f27648a.mo5732b()];
            this.f27648a.mo5728a(bArr, 0);
            return this.f27649b.mo5915a(bArr);
        }
        throw new IllegalStateException("RainbowDigestSigner not initialised for signature generation.");
    }

    /* renamed from: b */
    public boolean m36325b(byte[] bArr) {
        if (this.f27650c) {
            throw new IllegalStateException("RainbowDigestSigner not initialised for verification");
        }
        byte[] bArr2 = new byte[this.f27648a.mo5732b()];
        this.f27648a.mo5728a(bArr2, 0);
        return this.f27649b.mo5914a(bArr2, bArr);
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f27648a.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        this.f27648a.mo5731a(bArr, i, i2);
    }

    /* renamed from: b */
    public void m36324b() {
        this.f27648a.mo5733c();
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] bArr) {
        return m36325b(bArr);
    }
}
