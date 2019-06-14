package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DHBasicAgreement implements BasicAgreement {
    /* renamed from: a */
    private DHPrivateKeyParameters f26471a;
    /* renamed from: b */
    private DHParameters f26472b;

    /* renamed from: a */
    public void mo5724a(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            cipherParameters = (AsymmetricKeyParameter) cipherParameters;
        }
        if (cipherParameters instanceof DHPrivateKeyParameters) {
            this.f26471a = (DHPrivateKeyParameters) cipherParameters;
            this.f26472b = this.f26471a.m40790b();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }

    /* renamed from: a */
    public int mo5723a() {
        return (this.f26471a.m40790b().m35638a().bitLength() + 7) / 8;
    }

    /* renamed from: b */
    public BigInteger mo5725b(CipherParameters cipherParameters) {
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters) cipherParameters;
        if (dHPublicKeyParameters.m40790b().equals(this.f26472b)) {
            return dHPublicKeyParameters.m43366c().modPow(this.f26471a.m43365c(), this.f26472b.m35638a());
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }
}
