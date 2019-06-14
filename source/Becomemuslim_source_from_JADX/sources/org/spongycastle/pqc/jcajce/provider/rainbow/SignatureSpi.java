package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.rainbow.RainbowSigner;

public class SignatureSpi extends java.security.SignatureSpi {
    /* renamed from: a */
    private Digest f23343a;
    /* renamed from: b */
    private RainbowSigner f23344b;
    /* renamed from: c */
    private SecureRandom f23345c;

    public static class withSha224 extends SignatureSpi {
        public withSha224() {
            super(new SHA224Digest(), new RainbowSigner());
        }
    }

    public static class withSha256 extends SignatureSpi {
        public withSha256() {
            super(new SHA256Digest(), new RainbowSigner());
        }
    }

    public static class withSha384 extends SignatureSpi {
        public withSha384() {
            super(new SHA384Digest(), new RainbowSigner());
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), new RainbowSigner());
        }
    }

    protected SignatureSpi(Digest digest, RainbowSigner rainbowSigner) {
        this.f23343a = digest;
        this.f23344b = rainbowSigner;
    }

    protected void engineInitVerify(PublicKey publicKey) {
        CipherParameters a = RainbowKeysToParams.m29154a(publicKey);
        this.f23343a.mo5733c();
        this.f23344b.mo5913a(false, a);
    }

    protected void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) {
        this.f23345c = secureRandom;
        engineInitSign(privateKey);
    }

    protected void engineInitSign(PrivateKey privateKey) {
        CipherParameters a = RainbowKeysToParams.m29153a(privateKey);
        if (this.f23345c != null) {
            a = new ParametersWithRandom(a, this.f23345c);
        }
        this.f23343a.mo5733c();
        this.f23344b.mo5913a(true, a);
    }

    protected void engineUpdate(byte b) {
        this.f23343a.mo5730a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23343a.mo5731a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        byte[] bArr = new byte[this.f23343a.mo5732b()];
        this.f23343a.mo5728a(bArr, 0);
        try {
            return this.f23344b.mo5915a(bArr);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23343a.mo5732b()];
        this.f23343a.mo5728a(bArr2, 0);
        return this.f23344b.mo5914a(bArr2, bArr);
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
