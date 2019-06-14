package org.spongycastle.jcajce.provider.asymmetric.dh;

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
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.engines.OldIESEngine;
import org.spongycastle.crypto.generators.DHKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.parsers.DHIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Strings;

public class IESCipher extends CipherSpi {
    /* renamed from: a */
    private final JcaJceHelper f22713a = new BCJcaJceHelper();
    /* renamed from: b */
    private IESEngine f22714b;
    /* renamed from: c */
    private int f22715c = -1;
    /* renamed from: d */
    private ByteArrayOutputStream f22716d = new ByteArrayOutputStream();
    /* renamed from: e */
    private AlgorithmParameters f22717e = null;
    /* renamed from: f */
    private IESParameterSpec f22718f = null;
    /* renamed from: g */
    private AsymmetricKeyParameter f22719g;
    /* renamed from: h */
    private SecureRandom f22720h;
    /* renamed from: i */
    private boolean f22721i = false;
    /* renamed from: j */
    private AsymmetricKeyParameter f22722j = null;

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$1 */
    class C77291 implements KeyEncoder {
        /* renamed from: a */
        final /* synthetic */ IESCipher f27379a;

        C77291(IESCipher iESCipher) {
            this.f27379a = iESCipher;
        }

        /* renamed from: a */
        public byte[] mo5852a(AsymmetricKeyParameter asymmetricKeyParameter) {
            Object obj = new byte[((((DHKeyParameters) asymmetricKeyParameter).m40790b().m35638a().bitLength() + 7) / 8)];
            asymmetricKeyParameter = BigIntegers.m29389a(((DHPublicKeyParameters) asymmetricKeyParameter).m43366c());
            if (asymmetricKeyParameter.length <= obj.length) {
                System.arraycopy(asymmetricKeyParameter, 0, obj, obj.length - asymmetricKeyParameter.length, asymmetricKeyParameter.length);
                return obj;
            }
            throw new IllegalArgumentException("Senders's public key longer than expected.");
        }
    }

    public static class IES extends IESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class IESwithAES extends IESCipher {
        public IESwithAES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new AESEngine())));
        }
    }

    public static class IESwithDESede extends IESCipher {
        public IESwithDESede() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new DESedeEngine())));
        }
    }

    public static class OldIES extends IESCipher {
        public OldIES() {
            super(new OldIESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class OldIESwithCipher extends IESCipher {
        public OldIESwithCipher(BlockCipher blockCipher) {
            super(new OldIESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(blockCipher)));
        }
    }

    public static class OldIESwithAES extends OldIESwithCipher {
        public OldIESwithAES() {
            super(new AESEngine());
        }
    }

    public static class OldIESwithDESede extends OldIESwithCipher {
        public OldIESwithDESede() {
            super(new DESedeEngine());
        }
    }

    public byte[] engineGetIV() {
        return null;
    }

    public IESCipher(IESEngine iESEngine) {
        this.f22714b = iESEngine;
    }

    public IESCipher(OldIESEngine oldIESEngine) {
        this.f22714b = oldIESEngine;
    }

    public int engineGetBlockSize() {
        return this.f22714b.m27418a() != null ? this.f22714b.m27418a().m27303b() : 0;
    }

    public int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.f22717e == null && this.f22718f != null) {
            try {
                this.f22717e = this.f22713a.mo5878c("IES");
                this.f22717e.init(this.f22718f);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f22717e;
    }

    public void engineSetMode(String str) {
        String b = Strings.m29424b(str);
        if (b.equals("NONE")) {
            this.f22721i = null;
        } else if (b.equals("DHAES")) {
            this.f22721i = true;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("can't support mode ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public int engineGetOutputSize(int i) {
        int b = this.f22714b.m27424b().mo5766b();
        if (this.f22719g != null) {
            int bitLength = (((DHKey) this.f22719g).getParams().getP().bitLength() / 8) + 1;
            if (this.f22714b.m27418a() != null) {
                if (this.f22715c != 1) {
                    if (this.f22715c != 3) {
                        if (this.f22715c != 2) {
                            if (this.f22715c != 4) {
                                throw new IllegalStateException("cipher not initialised");
                            }
                        }
                        i = this.f22714b.m27418a().mo5778b((i - b) - bitLength);
                    }
                }
                i = this.f22714b.m27418a().mo5778b(i);
            }
            if (this.f22715c != 1) {
                if (this.f22715c != 3) {
                    if (this.f22715c != 2) {
                        if (this.f22715c != 4) {
                            throw new IllegalStateException("IESCipher not initialised");
                        }
                    }
                    return ((this.f22716d.size() - b) - bitLength) + i;
                }
            }
            return ((this.f22716d.size() + b) + bitLength) + i;
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
        this.f22717e = algorithmParameters;
        engineInit(i2, key, parameterSpec, secureRandom);
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec == null) {
            this.f22718f = IESUtil.m28016a(this.f22714b.m27418a());
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.f22718f = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        if (i != 1) {
            if (i != 3) {
                if (i != 2) {
                    if (i != 4) {
                        throw new InvalidKeyException("must be passed EC key");
                    }
                }
                if ((key instanceof DHPrivateKey) != null) {
                    this.f22719g = DHUtil.m27991a((PrivateKey) key);
                } else if ((key instanceof IESKey) != null) {
                    IESKey iESKey = (IESKey) key;
                    this.f22722j = DHUtil.m27992a(iESKey.mo5894a());
                    this.f22719g = DHUtil.m27991a(iESKey.mo5895b());
                } else {
                    throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
                }
                this.f22720h = secureRandom;
                this.f22715c = i;
                this.f22716d.reset();
            }
        }
        if ((key instanceof DHPublicKey) != null) {
            this.f22719g = DHUtil.m27992a((PublicKey) key);
        } else if ((key instanceof IESKey) != null) {
            iESKey = (IESKey) key;
            this.f22719g = DHUtil.m27992a(iESKey.mo5894a());
            this.f22722j = DHUtil.m27991a(iESKey.mo5895b());
        } else {
            throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
        }
        this.f22720h = secureRandom;
        this.f22715c = i;
        this.f22716d.reset();
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher.engineInit(int, java.security.Key, java.security.SecureRandom):void");
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f22716d.write(bArr, i, i2);
        return null;
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f22716d.write(bArr, i, i2);
        return null;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.f22716d.write(bArr, i, i2);
        }
        bArr = this.f22716d.toByteArray();
        this.f22716d.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.f22718f.m28334a(), this.f22718f.m28335b(), this.f22718f.m28336c(), this.f22718f.m28337d());
        i2 = ((DHKeyParameters) this.f22719g).m40790b();
        if (this.f22722j != null) {
            try {
                if (this.f22715c != 1) {
                    if (this.f22715c != 3) {
                        this.f22714b.m27421a(false, this.f22719g, this.f22722j, iESWithCipherParameters);
                        return this.f22714b.m27423a(bArr, 0, bArr.length);
                    }
                }
                this.f22714b.m27421a(true, this.f22722j, this.f22719g, iESWithCipherParameters);
                return this.f22714b.m27423a(bArr, 0, bArr.length);
            } catch (byte[] bArr2) {
                throw new BadPaddingException(bArr2.getMessage());
            }
        }
        if (this.f22715c != 1) {
            if (this.f22715c != 3) {
                if (this.f22715c != 2) {
                    if (this.f22715c != 4) {
                        throw new IllegalStateException("IESCipher not initialised");
                    }
                }
                try {
                    this.f22714b.m27419a(this.f22719g, iESWithCipherParameters, new DHIESPublicKeyParser(((DHKeyParameters) this.f22719g).m40790b()));
                    return this.f22714b.m27423a(bArr2, 0, bArr2.length);
                } catch (byte[] bArr22) {
                    throw new BadPaddingException(bArr22.getMessage());
                }
            }
        }
        AsymmetricCipherKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
        dHKeyPairGenerator.m35326a(new DHKeyGenerationParameters(this.f22720h, i2));
        try {
            this.f22714b.m27420a(this.f22719g, iESWithCipherParameters, new EphemeralKeyPairGenerator(dHKeyPairGenerator, new C77291(this)));
            return this.f22714b.m27423a(bArr22, 0, bArr22.length);
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
