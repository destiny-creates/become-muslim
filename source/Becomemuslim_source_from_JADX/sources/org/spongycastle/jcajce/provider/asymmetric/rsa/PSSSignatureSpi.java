package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;

public class PSSSignatureSpi extends SignatureSpi {
    /* renamed from: a */
    private final JcaJceHelper f22799a;
    /* renamed from: b */
    private AlgorithmParameters f22800b;
    /* renamed from: c */
    private PSSParameterSpec f22801c;
    /* renamed from: d */
    private PSSParameterSpec f22802d;
    /* renamed from: e */
    private AsymmetricBlockCipher f22803e;
    /* renamed from: f */
    private Digest f22804f;
    /* renamed from: g */
    private Digest f22805g;
    /* renamed from: h */
    private int f22806h;
    /* renamed from: i */
    private byte f22807i;
    /* renamed from: j */
    private boolean f22808j;
    /* renamed from: k */
    private PSSSigner f22809k;

    private class NullPssDigest implements Digest {
        /* renamed from: a */
        final /* synthetic */ PSSSignatureSpi f27433a;
        /* renamed from: b */
        private ByteArrayOutputStream f27434b = new ByteArrayOutputStream();
        /* renamed from: c */
        private Digest f27435c;
        /* renamed from: d */
        private boolean f27436d = true;

        /* renamed from: a */
        public String mo5729a() {
            return "NULL";
        }

        public NullPssDigest(PSSSignatureSpi pSSSignatureSpi, Digest digest) {
            this.f27433a = pSSSignatureSpi;
            this.f27435c = digest;
        }

        /* renamed from: b */
        public int mo5732b() {
            return this.f27435c.mo5732b();
        }

        /* renamed from: a */
        public void mo5730a(byte b) {
            this.f27434b.write(b);
        }

        /* renamed from: a */
        public void mo5731a(byte[] bArr, int i, int i2) {
            this.f27434b.write(bArr, i, i2);
        }

        /* renamed from: a */
        public int mo5728a(byte[] bArr, int i) {
            Object toByteArray = this.f27434b.toByteArray();
            if (this.f27436d) {
                System.arraycopy(toByteArray, 0, bArr, i, toByteArray.length);
            } else {
                this.f27435c.mo5731a(toByteArray, 0, toByteArray.length);
                this.f27435c.mo5728a(bArr, i);
            }
            mo5733c();
            this.f27436d ^= 1;
            return toByteArray.length;
        }

        /* renamed from: c */
        public void mo5733c() {
            this.f27434b.reset();
            this.f27435c.mo5733c();
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-384", "MGF1", new MGF1ParameterSpec("SHA-384"), 48, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new RSABlindedEngine(), null, true);
        }
    }

    /* renamed from: a */
    private byte m27982a(int i) {
        if (i == 1) {
            return (byte) -68;
        }
        throw new IllegalArgumentException("unknown trailer field");
    }

    /* renamed from: a */
    private void m27983a() {
        if (this.f22808j) {
            this.f22804f = new NullPssDigest(this, this.f22805g);
        } else {
            this.f22804f = this.f22805g;
        }
    }

    protected PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec) {
        this(asymmetricBlockCipher, pSSParameterSpec, false);
    }

    protected PSSSignatureSpi(AsymmetricBlockCipher asymmetricBlockCipher, PSSParameterSpec pSSParameterSpec, boolean z) {
        this.f22799a = new BCJcaJceHelper();
        this.f22803e = asymmetricBlockCipher;
        this.f22802d = pSSParameterSpec;
        if (pSSParameterSpec == null) {
            this.f22801c = PSSParameterSpec.DEFAULT;
        } else {
            this.f22801c = pSSParameterSpec;
        }
        this.f22805g = DigestFactory.m28100a(this.f22801c.getDigestAlgorithm());
        this.f22806h = this.f22801c.getSaltLength();
        this.f22807i = m27982a(this.f22801c.getTrailerField());
        this.f22808j = z;
        m27983a();
    }

    protected void engineInitVerify(PublicKey publicKey) {
        if (publicKey instanceof RSAPublicKey) {
            this.f22809k = new PSSSigner(this.f22803e, this.f22804f, this.f22805g, this.f22806h, this.f22807i);
            this.f22809k.mo5796a(false, RSAUtil.m27985a((RSAPublicKey) publicKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    protected void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) {
        if (privateKey instanceof RSAPrivateKey) {
            this.f22809k = new PSSSigner(this.f22803e, this.f22804f, this.f22805g, this.f22806h, this.f22807i);
            this.f22809k.mo5796a(true, new ParametersWithRandom(RSAUtil.m27984a((RSAPrivateKey) privateKey), secureRandom));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    protected void engineInitSign(PrivateKey privateKey) {
        if (privateKey instanceof RSAPrivateKey) {
            this.f22809k = new PSSSigner(this.f22803e, this.f22804f, this.f22805g, this.f22806h, this.f22807i);
            this.f22809k.mo5796a(true, RSAUtil.m27984a((RSAPrivateKey) privateKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    protected void engineUpdate(byte b) {
        this.f22809k.mo5795a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f22809k.mo5797a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        try {
            return this.f22809k.mo5799a();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    protected boolean engineVerify(byte[] bArr) {
        return this.f22809k.mo5798a(bArr);
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            PSSParameterSpec pSSParameterSpec = (PSSParameterSpec) algorithmParameterSpec;
            if (this.f22802d != null) {
                if (!DigestFactory.m28101a(this.f22802d.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("parameter must be using ");
                    stringBuilder.append(this.f22802d.getDigestAlgorithm());
                    throw new InvalidAlgorithmParameterException(stringBuilder.toString());
                }
            }
            if (!pSSParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1")) {
                if (!pSSParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.l_.m42986b())) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                }
            }
            if (pSSParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
                if (DigestFactory.m28101a(mGF1ParameterSpec.getDigestAlgorithm(), pSSParameterSpec.getDigestAlgorithm())) {
                    Digest a = DigestFactory.m28100a(mGF1ParameterSpec.getDigestAlgorithm());
                    if (a != null) {
                        this.f22800b = null;
                        this.f22801c = pSSParameterSpec;
                        this.f22805g = a;
                        this.f22806h = this.f22801c.getSaltLength();
                        this.f22807i = m27982a(this.f22801c.getTrailerField());
                        m27983a();
                        return;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("no match on MGF digest algorithm: ");
                    stringBuilder2.append(mGF1ParameterSpec.getDigestAlgorithm());
                    throw new InvalidAlgorithmParameterException(stringBuilder2.toString());
                }
                throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
            }
            throw new InvalidAlgorithmParameterException("unknown MGF parameters");
        }
        throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.f22800b == null && this.f22801c != null) {
            try {
                this.f22800b = this.f22799a.mo5878c("PSS");
                this.f22800b.init(this.f22801c);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f22800b;
    }

    protected void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }
}
