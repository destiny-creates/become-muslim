package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
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
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McEliecePointchevalCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest bF;
    private McEliecePointchevalCipher bG;
    private ByteArrayOutputStream bH = new ByteArrayOutputStream();

    public static class McEliecePointcheval224 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval224() {
            super(new SHA224Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval256 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval256() {
            super(new SHA256Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval384 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval384() {
            super(new SHA384Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval512 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval512() {
            super(new SHA512Digest(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval() {
            super(new SHA1Digest(), new McEliecePointchevalCipher());
        }
    }

    /* renamed from: a */
    protected int mo6581a(int i) {
        return 0;
    }

    /* renamed from: b */
    protected int mo6585b(int i) {
        return 0;
    }

    protected McEliecePointchevalCipherSpi(Digest digest, McEliecePointchevalCipher mcEliecePointchevalCipher) {
        this.bF = digest;
        this.bG = mcEliecePointchevalCipher;
        this.bH = new ByteArrayOutputStream();
    }

    /* renamed from: a */
    public byte[] mo5921a(byte[] bArr, int i, int i2) {
        this.bH.write(bArr, i, i2);
        return new byte[null];
    }

    /* renamed from: b */
    public byte[] mo5927b(byte[] bArr, int i, int i2) {
        mo5921a(bArr, i, i2);
        bArr = this.bH.toByteArray();
        this.bH.reset();
        if (this.w_ == 1) {
            try {
                return this.bG.m36376a(bArr);
            } catch (byte[] bArr2) {
                bArr2.printStackTrace();
            }
        } else {
            if (this.w_ == 2) {
                try {
                    return this.bG.m36377b(bArr2);
                } catch (byte[] bArr22) {
                    bArr22.printStackTrace();
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    protected void mo6584a(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        algorithmParameterSpec = new ParametersWithRandom(McElieceCCA2KeysToParams.m29140a((PublicKey) key), secureRandom);
        this.bF.mo5733c();
        this.bG.m36375a(true, algorithmParameterSpec);
    }

    /* renamed from: a */
    protected void mo6583a(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        key = McElieceCCA2KeysToParams.m29139a((PrivateKey) key);
        this.bF.mo5733c();
        this.bG.m36375a(false, key);
    }

    /* renamed from: a */
    public int mo6582a(Key key) {
        McElieceCCA2KeyParameters mcElieceCCA2KeyParameters;
        if (key instanceof PublicKey) {
            mcElieceCCA2KeyParameters = (McElieceCCA2KeyParameters) McElieceCCA2KeysToParams.m29140a((PublicKey) key);
        } else {
            mcElieceCCA2KeyParameters = (McElieceCCA2KeyParameters) McElieceCCA2KeysToParams.m29139a((PrivateKey) key);
        }
        return this.bG.m36372a(mcElieceCCA2KeyParameters);
    }
}
