package org.spongycastle.jcajce.provider.asymmetric.rsa;

import com.facebook.appevents.AppEventsConstants;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.util.Strings;

public class CipherSpi extends BaseCipherSpi {
    /* renamed from: c */
    private final JcaJceHelper f27426c = new BCJcaJceHelper();
    /* renamed from: d */
    private AsymmetricBlockCipher f27427d;
    /* renamed from: e */
    private AlgorithmParameterSpec f27428e;
    /* renamed from: f */
    private AlgorithmParameters f27429f;
    /* renamed from: g */
    private boolean f27430g = false;
    /* renamed from: h */
    private boolean f27431h = false;
    /* renamed from: i */
    private ByteArrayOutputStream f27432i = new ByteArrayOutputStream();

    public static class ISO9796d1Padding extends CipherSpi {
        public ISO9796d1Padding() {
            super(new ISO9796d1Encoding(new RSABlindedEngine()));
        }
    }

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new RSABlindedEngine());
        }
    }

    public static class OAEPPadding extends CipherSpi {
        public OAEPPadding() {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends CipherSpi {
        public PKCS1v1_5Padding_PrivateOnly() {
            super(false, true, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends CipherSpi {
        public PKCS1v1_5Padding_PublicOnly() {
            super(true, false, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f27427d = asymmetricBlockCipher;
    }

    public CipherSpi(OAEPParameterSpec oAEPParameterSpec) {
        try {
            m36012a(oAEPParameterSpec);
        } catch (OAEPParameterSpec oAEPParameterSpec2) {
            throw new IllegalArgumentException(oAEPParameterSpec2.getMessage());
        }
    }

    public CipherSpi(boolean z, boolean z2, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f27430g = z;
        this.f27431h = z2;
        this.f27427d = asymmetricBlockCipher;
    }

    /* renamed from: a */
    private void m36012a(OAEPParameterSpec oAEPParameterSpec) {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        Digest a = DigestFactory.m28100a(mGF1ParameterSpec.getDigestAlgorithm());
        if (a != null) {
            this.f27427d = new OAEPEncoding(new RSABlindedEngine(), a, ((PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.f27428e = oAEPParameterSpec;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("no match on OAEP constructor for digest algorithm: ");
        stringBuilder.append(mGF1ParameterSpec.getDigestAlgorithm());
        throw new NoSuchPaddingException(stringBuilder.toString());
    }

    protected int engineGetBlockSize() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f27427d;	 Catch:{ NullPointerException -> 0x0007 }
        r0 = r0.mo5736a();	 Catch:{ NullPointerException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = new java.lang.IllegalStateException;
        r1 = "RSA Cipher not initialised";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi.engineGetBlockSize():int");
    }

    protected int engineGetKeySize(Key key) {
        if (key instanceof RSAPrivateKey) {
            return ((RSAPrivateKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPublicKey) {
            return ((RSAPublicKey) key).getModulus().bitLength();
        }
        throw new IllegalArgumentException("not an RSA key!");
    }

    protected int engineGetOutputSize(int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = r1.f27427d;	 Catch:{ NullPointerException -> 0x0007 }
        r2 = r2.mo5739b();	 Catch:{ NullPointerException -> 0x0007 }
        return r2;
    L_0x0007:
        r2 = new java.lang.IllegalStateException;
        r0 = "RSA Cipher not initialised";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi.engineGetOutputSize(int):int");
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.f27429f == null && this.f27428e != null) {
            try {
                this.f27429f = this.f27426c.mo5878c("OAEP");
                this.f27429f.init(this.f27428e);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f27429f;
    }

    protected void engineSetMode(String str) {
        String b = Strings.m29424b(str);
        if (!b.equals("NONE")) {
            if (!b.equals("ECB")) {
                if (b.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                    this.f27431h = true;
                    this.f27430g = false;
                } else if (b.equals("2")) {
                    this.f27431h = false;
                    this.f27430g = true;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("can't support mode ");
                    stringBuilder.append(str);
                    throw new NoSuchAlgorithmException(stringBuilder.toString());
                }
            }
        }
    }

    protected void engineSetPadding(String str) {
        String b = Strings.m29424b(str);
        if (b.equals("NOPADDING")) {
            this.f27427d = new RSABlindedEngine();
        } else if (b.equals("PKCS1PADDING")) {
            this.f27427d = new PKCS1Encoding(new RSABlindedEngine());
        } else if (b.equals("ISO9796-1PADDING")) {
            this.f27427d = new ISO9796d1Encoding(new RSABlindedEngine());
        } else if (b.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            m36012a(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSpecified.DEFAULT));
        } else if (b.equals("OAEPPADDING")) {
            m36012a(OAEPParameterSpec.DEFAULT);
        } else {
            if (!b.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
                if (!b.equals("OAEPWITHSHA-1ANDMGF1PADDING")) {
                    if (!b.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
                        if (!b.equals("OAEPWITHSHA-224ANDMGF1PADDING")) {
                            if (!b.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
                                if (!b.equals("OAEPWITHSHA-256ANDMGF1PADDING")) {
                                    if (!b.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
                                        if (!b.equals("OAEPWITHSHA-384ANDMGF1PADDING")) {
                                            if (!b.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
                                                if (!b.equals("OAEPWITHSHA-512ANDMGF1PADDING")) {
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append(str);
                                                    stringBuilder.append(" unavailable with RSA.");
                                                    throw new NoSuchPaddingException(stringBuilder.toString());
                                                }
                                            }
                                            m36012a(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSpecified.DEFAULT));
                                            return;
                                        }
                                    }
                                    m36012a(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSpecified.DEFAULT));
                                    return;
                                }
                            }
                            m36012a(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSpecified.DEFAULT));
                            return;
                        }
                    }
                    m36012a(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSpecified.DEFAULT));
                    return;
                }
            }
            m36012a(OAEPParameterSpec.DEFAULT);
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec != null) {
            if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                key = new StringBuilder();
                key.append("unknown parameter type: ");
                key.append(algorithmParameterSpec.getClass().getName());
                throw new InvalidAlgorithmParameterException(key.toString());
            }
        }
        if (key instanceof RSAPublicKey) {
            if (this.f27431h) {
                if (i == 1) {
                    throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
                }
            }
            key = RSAUtil.m27985a((RSAPublicKey) key);
        } else if (key instanceof RSAPrivateKey) {
            if (this.f27430g) {
                if (i == 1) {
                    throw new InvalidKeyException("mode 2 requires RSAPublicKey");
                }
            }
            key = RSAUtil.m27984a((RSAPrivateKey) key);
        } else {
            throw new InvalidKeyException("unknown key type passed to RSA");
        }
        if (algorithmParameterSpec != null) {
            OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            this.f27428e = algorithmParameterSpec;
            if (oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") == null) {
                if (oAEPParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.l_.m42986b()) == null) {
                    throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
                }
            }
            if ((oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) != null) {
                algorithmParameterSpec = DigestFactory.m28100a(oAEPParameterSpec.getDigestAlgorithm());
                if (algorithmParameterSpec != null) {
                    MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                    Digest a = DigestFactory.m28100a(mGF1ParameterSpec.getDigestAlgorithm());
                    if (a != null) {
                        this.f27427d = new OAEPEncoding(new RSABlindedEngine(), algorithmParameterSpec, a, ((PSpecified) oAEPParameterSpec.getPSource()).getValue());
                    } else {
                        key = new StringBuilder();
                        key.append("no match on MGF digest algorithm: ");
                        key.append(mGF1ParameterSpec.getDigestAlgorithm());
                        throw new InvalidAlgorithmParameterException(key.toString());
                    }
                }
                key = new StringBuilder();
                key.append("no match on digest algorithm: ");
                key.append(oAEPParameterSpec.getDigestAlgorithm());
                throw new InvalidAlgorithmParameterException(key.toString());
            }
            throw new InvalidAlgorithmParameterException("unkown MGF parameters");
        }
        algorithmParameterSpec = (this.f27427d instanceof RSABlindedEngine) == null ? secureRandom != null ? new ParametersWithRandom(key, secureRandom) : new ParametersWithRandom(key, new SecureRandom()) : key;
        this.f27432i.reset();
        switch (i) {
            case 1:
            case 3:
                this.f27427d.mo5737a(true, algorithmParameterSpec);
                return;
            case 2:
            case 4:
                this.f27427d.mo5737a(null, algorithmParameterSpec);
                return;
            default:
                algorithmParameterSpec = new StringBuilder();
                algorithmParameterSpec.append("unknown opmode ");
                algorithmParameterSpec.append(i);
                algorithmParameterSpec.append(" passed to RSA");
                throw new InvalidParameterException(algorithmParameterSpec.toString());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
            } catch (int i2) {
                algorithmParameters = new StringBuilder();
                algorithmParameters.append("cannot recognise parameters: ");
                algorithmParameters.append(i2.toString());
                throw new InvalidAlgorithmParameterException(algorithmParameters.toString(), i2);
            }
        }
        parameterSpec = null;
        this.f27429f = algorithmParameters;
        engineInit(i2, key, parameterSpec, secureRandom);
    }

    protected void engineInit(int i, Key key, SecureRandom secureRandom) {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (int i2) {
            secureRandom = new StringBuilder();
            secureRandom.append("Eeeek! ");
            secureRandom.append(i2.toString());
            throw new InvalidKeyException(secureRandom.toString(), i2);
        }
    }

    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f27432i.write(bArr, i, i2);
        if ((this.f27427d instanceof RSABlindedEngine) != null) {
            if (this.f27432i.size() > this.f27427d.mo5736a() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.f27432i.size() > this.f27427d.mo5736a()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return null;
    }

    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f27432i.write(bArr, i, i2);
        if ((this.f27427d instanceof RSABlindedEngine) != null) {
            if (this.f27432i.size() > this.f27427d.mo5736a() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.f27432i.size() > this.f27427d.mo5736a()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return null;
    }

    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.f27432i.write(bArr, i, i2);
        }
        if ((this.f27427d instanceof RSABlindedEngine) != null) {
            if (this.f27432i.size() > this.f27427d.mo5736a() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.f27432i.size() > this.f27427d.mo5736a()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try {
            bArr = this.f27432i.toByteArray();
            this.f27432i.reset();
            return this.f27427d.mo5738a(bArr, 0, bArr.length);
        } catch (byte[] bArr2) {
            throw new BadPaddingException(bArr2.getMessage());
        }
    }

    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr != null) {
            this.f27432i.write(bArr, i, i2);
        }
        if ((this.f27427d instanceof RSABlindedEngine) != null) {
            if (this.f27432i.size() > this.f27427d.mo5736a() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.f27432i.size() > this.f27427d.mo5736a()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try {
            bArr = this.f27432i.toByteArray();
            int i4 = 0;
            bArr = this.f27427d.mo5738a(bArr, 0, bArr.length);
            this.f27432i.reset();
            while (i4 != bArr.length) {
                bArr2[i3 + i4] = bArr[i4];
                i4++;
            }
            return bArr.length;
        } catch (byte[] bArr3) {
            throw new BadPaddingException(bArr3.getMessage());
        } catch (Throwable th) {
            this.f27432i.reset();
        }
    }
}
