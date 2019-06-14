package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePKCSCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher;

public class McEliecePKCSCipherSpi extends AsymmetricBlockCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest bF;
    private McEliecePKCSCipher bG;

    public static class McEliecePKCS224 extends McEliecePKCSCipherSpi {
        public McEliecePKCS224() {
            super(new SHA224Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS256 extends McEliecePKCSCipherSpi {
        public McEliecePKCS256() {
            super(new SHA256Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS384 extends McEliecePKCSCipherSpi {
        public McEliecePKCS384() {
            super(new SHA384Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS512 extends McEliecePKCSCipherSpi {
        public McEliecePKCS512() {
            super(new SHA512Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS extends McEliecePKCSCipherSpi {
        public McEliecePKCS() {
            super(new SHA1Digest(), new McEliecePKCSCipher());
        }
    }

    public McEliecePKCSCipherSpi(Digest digest, McEliecePKCSCipher mcEliecePKCSCipher) {
        this.bF = digest;
        this.bG = mcEliecePKCSCipher;
    }

    /* renamed from: a */
    protected void mo6587a(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        algorithmParameterSpec = new ParametersWithRandom(McElieceKeysToParams.m29142a((PublicKey) key), secureRandom);
        this.bF.mo5733c();
        this.bG.m36365a(true, algorithmParameterSpec);
        this.x_ = this.bG.f27709a;
        this.c = this.bG.f27710b;
    }

    /* renamed from: a */
    protected void mo6586a(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        key = McElieceKeysToParams.m29141a((PrivateKey) key);
        this.bF.mo5733c();
        this.bG.m36365a(false, key);
        this.x_ = this.bG.f27709a;
        this.c = this.bG.f27710b;
    }

    /* renamed from: a */
    protected byte[] mo6588a(byte[] bArr) {
        try {
            return this.bG.m36366a(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    protected byte[] mo6589b(byte[] bArr) {
        try {
            return this.bG.m36367b(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public int mo6582a(Key key) {
        McElieceKeyParameters mcElieceKeyParameters;
        if (key instanceof PublicKey) {
            mcElieceKeyParameters = (McElieceKeyParameters) McElieceKeysToParams.m29142a((PublicKey) key);
        } else {
            mcElieceKeyParameters = (McElieceKeyParameters) McElieceKeysToParams.m29141a((PrivateKey) key);
        }
        return this.bG.m36362a(mcElieceKeyParameters);
    }
}
