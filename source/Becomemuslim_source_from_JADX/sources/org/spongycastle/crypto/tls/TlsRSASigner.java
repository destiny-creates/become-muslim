package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.signers.GenericSigner;
import org.spongycastle.crypto.signers.RSADigestSigner;

public class TlsRSASigner extends AbstractTlsSigner {
    /* renamed from: a */
    public byte[] mo6496a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        signatureAndHashAlgorithm = m40968a(signatureAndHashAlgorithm, true, true, new ParametersWithRandom(asymmetricKeyParameter, this.a.mo5809b()));
        signatureAndHashAlgorithm.mo5797a(bArr, 0, bArr.length);
        return signatureAndHashAlgorithm.mo5799a();
    }

    /* renamed from: a */
    public boolean mo6495a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr2) {
        signatureAndHashAlgorithm = m40968a(signatureAndHashAlgorithm, true, false, (CipherParameters) asymmetricKeyParameter);
        signatureAndHashAlgorithm.mo5797a(bArr2, 0, bArr2.length);
        return signatureAndHashAlgorithm.mo5798a(bArr);
    }

    /* renamed from: a */
    public Signer mo6494a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter) {
        return m40968a(signatureAndHashAlgorithm, false, false, (CipherParameters) asymmetricKeyParameter);
    }

    /* renamed from: a */
    public boolean mo6497a(AsymmetricKeyParameter asymmetricKeyParameter) {
        return ((asymmetricKeyParameter instanceof RSAKeyParameters) && asymmetricKeyParameter.m35630a() == null) ? true : null;
    }

    /* renamed from: a */
    protected Signer m40968a(SignatureAndHashAlgorithm signatureAndHashAlgorithm, boolean z, boolean z2, CipherParameters cipherParameters) {
        if ((signatureAndHashAlgorithm != null) == TlsUtils.m27860c(this.a)) {
            Signer rSADigestSigner;
            if (signatureAndHashAlgorithm != null) {
                if (signatureAndHashAlgorithm.m27620b() != (short) 1) {
                    throw new IllegalStateException();
                }
            }
            if (z) {
                z = new NullDigest();
            } else if (signatureAndHashAlgorithm == null) {
                z = new CombinedHash();
            } else {
                z = TlsUtils.m27855c(signatureAndHashAlgorithm.m27618a());
            }
            if (signatureAndHashAlgorithm != null) {
                rSADigestSigner = new RSADigestSigner(z, TlsUtils.m27864d(signatureAndHashAlgorithm.m27618a()));
            } else {
                rSADigestSigner = new GenericSigner(m40966a(), z);
            }
            rSADigestSigner.mo5796a(z2, cipherParameters);
            return rSADigestSigner;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    protected AsymmetricBlockCipher m40966a() {
        return new PKCS1Encoding(new RSABlindedEngine());
    }
}
