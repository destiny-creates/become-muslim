package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSADigestSigner;

public abstract class TlsDSASigner extends AbstractTlsSigner {
    /* renamed from: a */
    protected CipherParameters m40927a(boolean z, CipherParameters cipherParameters) {
        return cipherParameters;
    }

    /* renamed from: a */
    protected abstract DSA mo6820a(short s);

    /* renamed from: a */
    protected abstract short mo6821a();

    /* renamed from: a */
    public byte[] mo6496a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        asymmetricKeyParameter = m40930a(signatureAndHashAlgorithm, true, true, new ParametersWithRandom(asymmetricKeyParameter, this.a.mo5809b()));
        if (signatureAndHashAlgorithm == null) {
            asymmetricKeyParameter.mo5797a(bArr, 16, 20);
        } else {
            asymmetricKeyParameter.mo5797a(bArr, null, bArr.length);
        }
        return asymmetricKeyParameter.mo5799a();
    }

    /* renamed from: a */
    public boolean mo6495a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr2) {
        asymmetricKeyParameter = m40930a(signatureAndHashAlgorithm, true, false, (CipherParameters) asymmetricKeyParameter);
        if (signatureAndHashAlgorithm == null) {
            asymmetricKeyParameter.mo5797a(bArr2, 16, 20);
        } else {
            asymmetricKeyParameter.mo5797a(bArr2, 0, bArr2.length);
        }
        return asymmetricKeyParameter.mo5798a(bArr);
    }

    /* renamed from: a */
    public Signer mo6494a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter) {
        return m40930a(signatureAndHashAlgorithm, false, false, (CipherParameters) asymmetricKeyParameter);
    }

    /* renamed from: a */
    protected Signer m40930a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, boolean z, boolean z2, CipherParameters cipherParameters) {
        if ((signatureAndHashAlgorithm != null) == TlsUtils.m27860c(this.a)) {
            short s;
            if (signatureAndHashAlgorithm != null) {
                if (signatureAndHashAlgorithm.m27620b() != mo6821a()) {
                    throw new IllegalStateException();
                }
            }
            if (signatureAndHashAlgorithm == null) {
                s = (short) 2;
            } else {
                s = signatureAndHashAlgorithm.m27618a();
            }
            Signer dSADigestSigner = new DSADigestSigner(mo6820a(s), z ? new NullDigest() : TlsUtils.m27855c(s));
            dSADigestSigner.mo5796a(z2, m40927a(z2, cipherParameters));
            return dSADigestSigner;
        }
        throw new IllegalStateException();
    }
}
