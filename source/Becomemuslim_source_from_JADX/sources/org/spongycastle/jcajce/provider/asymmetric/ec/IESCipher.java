package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.NoSuchPaddingException;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.engines.OldIESEngine;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.parsers.ECIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Strings;

public class IESCipher extends CipherSpi {
    /* renamed from: a */
    private final JcaJceHelper f22749a = new BCJcaJceHelper();
    /* renamed from: b */
    private int f22750b;
    /* renamed from: c */
    private IESEngine f22751c;
    /* renamed from: d */
    private int f22752d = -1;
    /* renamed from: e */
    private ByteArrayOutputStream f22753e = new ByteArrayOutputStream();
    /* renamed from: f */
    private AlgorithmParameters f22754f = null;
    /* renamed from: g */
    private IESParameterSpec f22755g = null;
    /* renamed from: h */
    private AsymmetricKeyParameter f22756h;
    /* renamed from: i */
    private SecureRandom f22757i;
    /* renamed from: j */
    private boolean f22758j = false;
    /* renamed from: k */
    private AsymmetricKeyParameter f22759k = null;

    public static class ECIES extends IESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class ECIESwithCipher extends IESCipher {
        public ECIESwithCipher(BlockCipher blockCipher) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(blockCipher)));
        }

        public ECIESwithCipher(BlockCipher blockCipher, int i) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(blockCipher)), i);
        }
    }

    public static class OldECIES extends IESCipher {
        public OldECIES() {
            super(new OldIESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class OldECIESwithCipher extends IESCipher {
        public OldECIESwithCipher(BlockCipher blockCipher) {
            super(new OldIESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(blockCipher)));
        }

        public OldECIESwithCipher(BlockCipher blockCipher, int i) {
            super(new OldIESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(blockCipher)), i);
        }
    }

    public static class ECIESwithAES extends ECIESwithCipher {
        public ECIESwithAES() {
            super(new AESEngine());
        }
    }

    public static class ECIESwithAESCBC extends ECIESwithCipher {
        public ECIESwithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16);
        }
    }

    public static class ECIESwithDESede extends ECIESwithCipher {
        public ECIESwithDESede() {
            super(new DESedeEngine());
        }
    }

    public static class ECIESwithDESedeCBC extends ECIESwithCipher {
        public ECIESwithDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8);
        }
    }

    public static class OldECIESwithAES extends OldECIESwithCipher {
        public OldECIESwithAES() {
            super(new AESEngine());
        }
    }

    public static class OldECIESwithAESCBC extends OldECIESwithCipher {
        public OldECIESwithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16);
        }
    }

    public static class OldECIESwithDESede extends OldECIESwithCipher {
        public OldECIESwithDESede() {
            super(new DESedeEngine());
        }
    }

    public static class OldECIESwithDESedeCBC extends OldECIESwithCipher {
        public OldECIESwithDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8);
        }
    }

    public byte[] engineGetIV() {
        return null;
    }

    public IESCipher(IESEngine iESEngine) {
        this.f22751c = iESEngine;
        this.f22750b = 0;
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.f22751c = iESEngine;
        this.f22750b = i;
    }

    public int engineGetBlockSize() {
        return this.f22751c.m27418a() != null ? this.f22751c.m27418a().m27303b() : 0;
    }

    public int engineGetKeySize(Key key) {
        if (key instanceof ECKey) {
            return ((ECKey) key).mo6501b().m28315b().mo6540a();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.f22754f == null && this.f22755g != null) {
            try {
                this.f22754f = this.f22749a.mo5878c("IES");
                this.f22754f.init(this.f22755g);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f22754f;
    }

    public void engineSetMode(String str) {
        String b = Strings.m29424b(str);
        if (b.equals("NONE")) {
            this.f22758j = null;
        } else if (b.equals("DHAES")) {
            this.f22758j = true;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("can't support mode ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public int engineGetOutputSize(int i) {
        int b = this.f22751c.m27424b().mo5766b();
        if (this.f22756h != null) {
            int a = (((((ECKey) this.f22756h).mo6501b().m28315b().mo6540a() + 7) * 2) / 8) + 1;
            if (this.f22751c.m27418a() != null) {
                if (this.f22752d != 1) {
                    if (this.f22752d != 3) {
                        if (this.f22752d != 2) {
                            if (this.f22752d != 4) {
                                throw new IllegalStateException("cipher not initialised");
                            }
                        }
                        i = this.f22751c.m27418a().mo5778b((i - b) - a);
                    }
                }
                i = this.f22751c.m27418a().mo5778b(i);
            }
            if (this.f22752d != 1) {
                if (this.f22752d != 3) {
                    if (this.f22752d != 2) {
                        if (this.f22752d != 4) {
                            throw new IllegalStateException("cipher not initialised");
                        }
                    }
                    return ((this.f22753e.size() - b) - a) + i;
                }
            }
            return ((this.f22753e.size() + b) + a) + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public void engineSetPadding(String str) {
        str = Strings.m29424b(str);
        if (!str.equals("NOPADDING")) {
            if (!str.equals("PKCS5PADDING")) {
                if (str.equals("PKCS7PADDING") == null) {
                    throw new NoSuchPaddingException("padding not available with IESCipher");
                }
            }
        }
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (int i2) {
                algorithmParameters = new StringBuilder();
                algorithmParameters.append("cannot recognise parameters: ");
                algorithmParameters.append(i2.toString());
                throw new InvalidAlgorithmParameterException(algorithmParameters.toString());
            }
        }
        parameterSpec = null;
        this.f22754f = algorithmParameters;
        engineInit(i2, key, parameterSpec, secureRandom);
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.f22759k = null;
        if (algorithmParameterSpec == null) {
            this.f22755g = IESUtil.m28016a(this.f22751c.m27418a());
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.f22755g = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        algorithmParameterSpec = this.f22755g.m28338e();
        if (algorithmParameterSpec != null) {
            if (this.f22750b == 0) {
                throw new InvalidAlgorithmParameterException("NONCE present in IES Parameters when none required");
            } else if (algorithmParameterSpec.length != this.f22750b) {
                key = new StringBuilder();
                key.append("NONCE in IES Parameters needs to be ");
                key.append(this.f22750b);
                key.append(" bytes long");
                throw new InvalidAlgorithmParameterException(key.toString());
            }
        }
        if (i != 1) {
            if (i != 3) {
                if (i != 2) {
                    if (i != 4) {
                        throw new InvalidKeyException("must be passed EC key");
                    }
                }
                if ((key instanceof PrivateKey) != null) {
                    this.f22756h = ECUtil.m28009a((PrivateKey) key);
                } else if ((key instanceof IESKey) != null) {
                    IESKey iESKey = (IESKey) key;
                    this.f22759k = ECUtil.m28010a(iESKey.mo5894a());
                    this.f22756h = ECUtil.m28009a(iESKey.mo5895b());
                } else {
                    throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
                }
                this.f22757i = secureRandom;
                this.f22752d = i;
                this.f22753e.reset();
            }
        }
        if ((key instanceof PublicKey) != null) {
            this.f22756h = ECUtil.m28010a((PublicKey) key);
        } else if ((key instanceof IESKey) != null) {
            iESKey = (IESKey) key;
            this.f22756h = ECUtil.m28010a(iESKey.mo5894a());
            this.f22759k = ECUtil.m28009a(iESKey.mo5895b());
        } else {
            throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
        }
        this.f22757i = secureRandom;
        this.f22752d = i;
        this.f22753e.reset();
    }

    public void engineInit(int r2, java.security.Key r3, java.security.SecureRandom r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = 0;
        r0 = (java.security.spec.AlgorithmParameterSpec) r0;	 Catch:{ InvalidAlgorithmParameterException -> 0x0007 }
        r1.engineInit(r2, r3, r0, r4);	 Catch:{ InvalidAlgorithmParameterException -> 0x0007 }
        return;
    L_0x0007:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "can't handle supplied parameter spec";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.IESCipher.engineInit(int, java.security.Key, java.security.SecureRandom):void");
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f22753e.write(bArr, i, i2);
        return null;
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f22753e.write(bArr, i, i2);
        return null;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.f22753e.write(bArr, i, i2);
        }
        bArr = this.f22753e.toByteArray();
        this.f22753e.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.f22755g.m28334a(), this.f22755g.m28335b(), this.f22755g.m28336c(), this.f22755g.m28337d());
        if (this.f22755g.m28338e() != 0) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, this.f22755g.m28338e());
        }
        i2 = ((ECKeyParameters) this.f22756h).m40792b();
        if (this.f22759k != null) {
            try {
                if (this.f22752d != 1) {
                    if (this.f22752d != 3) {
                        this.f22751c.m27421a(false, this.f22756h, this.f22759k, iESWithCipherParameters);
                        return this.f22751c.m27423a(bArr, 0, bArr.length);
                    }
                }
                this.f22751c.m27421a(true, this.f22759k, this.f22756h, iESWithCipherParameters);
                return this.f22751c.m27423a(bArr, 0, bArr.length);
            } catch (byte[] bArr2) {
                throw new BadPaddingException(bArr2.getMessage());
            }
        }
        if (this.f22752d != 1) {
            if (this.f22752d != 3) {
                if (this.f22752d != 2) {
                    if (this.f22752d != 4) {
                        throw new IllegalStateException("cipher not initialised");
                    }
                }
                try {
                    this.f22751c.m27419a(this.f22756h, iESWithCipherParameters, new ECIESPublicKeyParser(i2));
                    return this.f22751c.m27423a(bArr2, 0, bArr2.length);
                } catch (byte[] bArr22) {
                    throw new BadPaddingException(bArr22.getMessage());
                }
            }
        }
        AsymmetricCipherKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
        eCKeyPairGenerator.m35332a(new ECKeyGenerationParameters(i2, this.f22757i));
        i2 = this.f22755g.m28339f();
        try {
            this.f22751c.m27420a(this.f22756h, iESWithCipherParameters, new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder(this) {
                /* renamed from: b */
                final /* synthetic */ IESCipher f27391b;

                /* renamed from: a */
                public byte[] mo5852a(AsymmetricKeyParameter asymmetricKeyParameter) {
                    return ((ECPublicKeyParameters) asymmetricKeyParameter).m43370c().m28398a(i2);
                }
            }));
            return this.f22751c.m27423a(bArr22, 0, bArr22.length);
        } catch (byte[] bArr222) {
            throw new BadPaddingException(bArr222.getMessage());
        }
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        bArr = engineDoFinal(bArr, i, i2);
        System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
        return bArr.length;
    }
}
