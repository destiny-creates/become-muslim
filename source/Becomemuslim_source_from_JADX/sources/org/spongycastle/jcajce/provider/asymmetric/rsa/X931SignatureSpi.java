package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.crypto.digests.WhirlpoolDigest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.signers.X931Signer;

public class X931SignatureSpi extends SignatureSpi {
    /* renamed from: a */
    private X931Signer f22811a;

    public static class RIPEMD128WithRSAEncryption extends X931SignatureSpi {
        public RIPEMD128WithRSAEncryption() {
            super(new RIPEMD128Digest(), new RSABlindedEngine());
        }
    }

    public static class RIPEMD160WithRSAEncryption extends X931SignatureSpi {
        public RIPEMD160WithRSAEncryption() {
            super(new RIPEMD160Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA1WithRSAEncryption extends X931SignatureSpi {
        public SHA1WithRSAEncryption() {
            super(new SHA1Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA224WithRSAEncryption extends X931SignatureSpi {
        public SHA224WithRSAEncryption() {
            super(new SHA224Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA256WithRSAEncryption extends X931SignatureSpi {
        public SHA256WithRSAEncryption() {
            super(new SHA256Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA384WithRSAEncryption extends X931SignatureSpi {
        public SHA384WithRSAEncryption() {
            super(new SHA384Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA512WithRSAEncryption extends X931SignatureSpi {
        public SHA512WithRSAEncryption() {
            super(new SHA512Digest(), new RSABlindedEngine());
        }
    }

    public static class SHA512_224WithRSAEncryption extends X931SignatureSpi {
        public SHA512_224WithRSAEncryption() {
            super(new SHA512tDigest(224), new RSABlindedEngine());
        }
    }

    public static class SHA512_256WithRSAEncryption extends X931SignatureSpi {
        public SHA512_256WithRSAEncryption() {
            super(new SHA512tDigest(256), new RSABlindedEngine());
        }
    }

    public static class WhirlpoolWithRSAEncryption extends X931SignatureSpi {
        public WhirlpoolWithRSAEncryption() {
            super(new WhirlpoolDigest(), new RSABlindedEngine());
        }
    }

    protected X931SignatureSpi(Digest digest, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f22811a = new X931Signer(asymmetricBlockCipher, digest);
    }

    protected void engineInitVerify(PublicKey publicKey) {
        this.f22811a.mo5796a(false, RSAUtil.m27985a((RSAPublicKey) publicKey));
    }

    protected void engineInitSign(PrivateKey privateKey) {
        this.f22811a.mo5796a(true, RSAUtil.m27984a((RSAPrivateKey) privateKey));
    }

    protected void engineUpdate(byte b) {
        this.f22811a.mo5795a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f22811a.mo5797a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        try {
            return this.f22811a.mo5799a();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] bArr) {
        return this.f22811a.mo5798a(bArr);
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
