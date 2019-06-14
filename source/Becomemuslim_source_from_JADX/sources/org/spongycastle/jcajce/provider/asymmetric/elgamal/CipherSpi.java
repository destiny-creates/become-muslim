package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.BufferedAsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.ElGamalEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jce.interfaces.ElGamalKey;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.util.Strings;

public class CipherSpi extends BaseCipherSpi {
    /* renamed from: c */
    private BufferedAsymmetricBlockCipher f27416c;
    /* renamed from: d */
    private AlgorithmParameterSpec f27417d;
    /* renamed from: e */
    private AlgorithmParameters f27418e;

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f27416c = new BufferedAsymmetricBlockCipher(asymmetricBlockCipher);
    }

    /* renamed from: a */
    private void m36006a(OAEPParameterSpec oAEPParameterSpec) {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        Digest a = DigestFactory.m28100a(mGF1ParameterSpec.getDigestAlgorithm());
        if (a != null) {
            this.f27416c = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), a, ((PSpecified) oAEPParameterSpec.getPSource()).getValue()));
            this.f27417d = oAEPParameterSpec;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("no match on OAEP constructor for digest algorithm: ");
        stringBuilder.append(mGF1ParameterSpec.getDigestAlgorithm());
        throw new NoSuchPaddingException(stringBuilder.toString());
    }

    protected int engineGetBlockSize() {
        return this.f27416c.m27292a();
    }

    protected int engineGetKeySize(Key key) {
        if (key instanceof ElGamalKey) {
            return ((ElGamalKey) key).mo6506b().m28321a().bitLength();
        }
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not an ElGamal key!");
    }

    protected int engineGetOutputSize(int i) {
        return this.f27416c.m27295b();
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.f27418e == null && this.f27417d != null) {
            try {
                this.f27418e = m27990a("OAEP");
                this.f27418e.init(this.f27417d);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f27418e;
    }

    protected void engineSetMode(String str) {
        String b = Strings.m29424b(str);
        if (!b.equals("NONE")) {
            if (!b.equals("ECB")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("can't support mode ");
                stringBuilder.append(str);
                throw new NoSuchAlgorithmException(stringBuilder.toString());
            }
        }
    }

    protected void engineSetPadding(String str) {
        String b = Strings.m29424b(str);
        if (b.equals("NOPADDING")) {
            this.f27416c = new BufferedAsymmetricBlockCipher(new ElGamalEngine());
        } else if (b.equals("PKCS1PADDING")) {
            this.f27416c = new BufferedAsymmetricBlockCipher(new PKCS1Encoding(new ElGamalEngine()));
        } else if (b.equals("ISO9796-1PADDING")) {
            this.f27416c = new BufferedAsymmetricBlockCipher(new ISO9796d1Encoding(new ElGamalEngine()));
        } else if (b.equals("OAEPPADDING")) {
            m36006a(OAEPParameterSpec.DEFAULT);
        } else if (b.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            m36006a(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSpecified.DEFAULT));
        } else if (b.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
            m36006a(OAEPParameterSpec.DEFAULT);
        } else if (b.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
            m36006a(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSpecified.DEFAULT));
        } else if (b.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
            m36006a(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSpecified.DEFAULT));
        } else if (b.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
            m36006a(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSpecified.DEFAULT));
        } else if (b.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            m36006a(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSpecified.DEFAULT));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" unavailable with ElGamal.");
            throw new NoSuchPaddingException(stringBuilder.toString());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec == null) {
            if ((key instanceof ElGamalPublicKey) != null) {
                key = ElGamalUtil.m27971a((PublicKey) key);
            } else if ((key instanceof ElGamalPrivateKey) != null) {
                key = ElGamalUtil.m27970a((PrivateKey) key);
            } else {
                throw new InvalidKeyException("unknown key type passed to ElGamal");
            }
            if (secureRandom != null) {
                key = new ParametersWithRandom(key, secureRandom);
            }
            switch (i) {
                case 1:
                case 3:
                    this.f27416c.m27293a(true, key);
                    return;
                case 2:
                case 4:
                    this.f27416c.m27293a(null, key);
                    return;
                default:
                    algorithmParameterSpec = new StringBuilder();
                    algorithmParameterSpec.append("unknown opmode ");
                    algorithmParameterSpec.append(i);
                    algorithmParameterSpec.append(" passed to ElGamal");
                    throw new InvalidParameterException(algorithmParameterSpec.toString());
            }
        }
        throw new IllegalArgumentException("unknown parameter type.");
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
    }

    protected void engineInit(int i, Key key, SecureRandom secureRandom) {
        engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
    }

    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f27416c.m27294a(bArr, i, i2);
        return null;
    }

    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f27416c.m27294a(bArr, i, i2);
        return null;
    }

    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        this.f27416c.m27294a(bArr, i, i2);
        try {
            return this.f27416c.m27296c();
        } catch (byte[] bArr2) {
            throw new BadPaddingException(bArr2.getMessage());
        }
    }

    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f27416c.m27294a(bArr, i, i2);
        try {
            bArr = this.f27416c.m27296c();
            for (i = 0; i != bArr.length; i++) {
                bArr2[i3 + i] = bArr[i];
            }
            return bArr.length;
        } catch (byte[] bArr3) {
            throw new BadPaddingException(bArr3.getMessage());
        }
    }
}
