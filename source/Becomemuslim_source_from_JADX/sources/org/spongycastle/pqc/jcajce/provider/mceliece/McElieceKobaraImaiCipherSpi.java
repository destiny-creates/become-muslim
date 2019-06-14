package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
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
import org.spongycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McElieceKobaraImaiCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest bF;
    private McElieceKobaraImaiCipher bG;
    private ByteArrayOutputStream bH;

    public static class McElieceKobaraImai224 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai224() {
            super(new SHA224Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai256 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai256() {
            super(new SHA256Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai384 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai384() {
            super(new SHA384Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai512 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai512() {
            super(new SHA512Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai() {
            super(new SHA1Digest(), new McElieceKobaraImaiCipher());
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

    public McElieceKobaraImaiCipherSpi() {
        this.bH = new ByteArrayOutputStream();
        this.bH = new ByteArrayOutputStream();
    }

    protected McElieceKobaraImaiCipherSpi(Digest digest, McElieceKobaraImaiCipher mcElieceKobaraImaiCipher) {
        this.bH = new ByteArrayOutputStream();
        this.bF = digest;
        this.bG = mcElieceKobaraImaiCipher;
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
        if (this.w_ == 1) {
            try {
                return this.bG.m36358a(m42109c());
            } catch (byte[] bArr2) {
                bArr2.printStackTrace();
            }
        } else {
            if (this.w_ == 2) {
                bArr2 = this.bH.toByteArray();
                this.bH.reset();
                try {
                    return m42108a(this.bG.m36359b(bArr2));
                } catch (byte[] bArr22) {
                    bArr22.printStackTrace();
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    protected void mo6584a(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.bH.reset();
        algorithmParameterSpec = new ParametersWithRandom(McElieceCCA2KeysToParams.m29140a((PublicKey) key), secureRandom);
        this.bF.mo5733c();
        this.bG.m36357a(true, algorithmParameterSpec);
    }

    /* renamed from: a */
    protected void mo6583a(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.bH.reset();
        key = McElieceCCA2KeysToParams.m29139a((PrivateKey) key);
        this.bF.mo5733c();
        this.bG.m36357a(false, key);
    }

    /* renamed from: a */
    public int mo6582a(Key key) {
        if (key instanceof PublicKey) {
            return this.bG.m36355a((McElieceCCA2KeyParameters) McElieceCCA2KeysToParams.m29140a((PublicKey) key));
        } else if (key instanceof PrivateKey) {
            return this.bG.m36355a((McElieceCCA2KeyParameters) McElieceCCA2KeysToParams.m29139a((PrivateKey) key));
        } else {
            throw new InvalidKeyException();
        }
    }

    /* renamed from: c */
    private byte[] m42109c() {
        this.bH.write(1);
        byte[] toByteArray = this.bH.toByteArray();
        this.bH.reset();
        return toByteArray;
    }

    /* renamed from: a */
    private byte[] m42108a(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == (byte) 0) {
            length--;
        }
        if (bArr[length] == (byte) 1) {
            Object obj = new byte[length];
            System.arraycopy(bArr, 0, obj, 0, length);
            return obj;
        }
        throw new BadPaddingException("invalid ciphertext");
    }
}
