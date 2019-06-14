package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class RSABlindingEngine implements AsymmetricBlockCipher {
    /* renamed from: a */
    private RSACoreEngine f26742a = new RSACoreEngine();
    /* renamed from: b */
    private RSAKeyParameters f26743b;
    /* renamed from: c */
    private BigInteger f26744c;
    /* renamed from: d */
    private boolean f26745d;

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = (RSABlindingParameters) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            cipherParameters = (RSABlindingParameters) cipherParameters;
        }
        this.f26742a.m27427a(z, cipherParameters.m35705a());
        this.f26745d = z;
        this.f26743b = cipherParameters.m35705a();
        this.f26744c = cipherParameters.m35706b();
    }

    /* renamed from: a */
    public int mo5736a() {
        return this.f26742a.m27425a();
    }

    /* renamed from: b */
    public int mo5739b() {
        return this.f26742a.m27429b();
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        bArr = this.f26742a.m27426a(bArr, i, i2);
        if (this.f26745d != 0) {
            bArr = m35129a(bArr);
        } else {
            bArr = m35130b(bArr);
        }
        return this.f26742a.m27428a(bArr);
    }

    /* renamed from: a */
    private BigInteger m35129a(BigInteger bigInteger) {
        return bigInteger.multiply(this.f26744c.modPow(this.f26743b.m40801c(), this.f26743b.m40800b())).mod(this.f26743b.m40800b());
    }

    /* renamed from: b */
    private BigInteger m35130b(BigInteger bigInteger) {
        BigInteger b = this.f26743b.m40800b();
        return bigInteger.multiply(this.f26744c.modInverse(b)).mod(b);
    }
}
