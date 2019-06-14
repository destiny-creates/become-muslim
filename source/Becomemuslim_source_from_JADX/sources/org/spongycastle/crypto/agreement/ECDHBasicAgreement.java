package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;

public class ECDHBasicAgreement implements BasicAgreement {
    /* renamed from: a */
    private ECPrivateKeyParameters f26473a;

    /* renamed from: a */
    public void mo5724a(CipherParameters cipherParameters) {
        this.f26473a = (ECPrivateKeyParameters) cipherParameters;
    }

    /* renamed from: a */
    public int mo5723a() {
        return (this.f26473a.m40792b().m35647a().mo6540a() + 7) / 8;
    }

    /* renamed from: b */
    public BigInteger mo5725b(CipherParameters cipherParameters) {
        cipherParameters = ((ECPublicKeyParameters) cipherParameters).m43370c().m28393a(this.f26473a.m43369c()).m28418p();
        if (!cipherParameters.m28419q()) {
            return cipherParameters.m28409g().mo6549a();
        }
        throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
    }
}
