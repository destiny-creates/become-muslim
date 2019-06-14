package org.spongycastle.jcajce.provider.asymmetric.ies;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.engines.OldIESEngine;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;

public class CipherSpi extends javax.crypto.CipherSpi {
    /* renamed from: a */
    private final JcaJceHelper f22781a = new BCJcaJceHelper();
    /* renamed from: b */
    private IESEngine f22782b;
    /* renamed from: c */
    private int f22783c = -1;
    /* renamed from: d */
    private ByteArrayOutputStream f22784d = new ByteArrayOutputStream();
    /* renamed from: e */
    private AlgorithmParameters f22785e = null;
    /* renamed from: f */
    private IESParameterSpec f22786f = null;
    /* renamed from: g */
    private Class[] f22787g = new Class[]{IESParameterSpec.class};

    public static class IES extends CipherSpi {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class OldIES extends CipherSpi {
        public OldIES() {
            super(new OldIESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    protected int engineGetBlockSize() {
        return 0;
    }

    protected byte[] engineGetIV() {
        return null;
    }

    public CipherSpi(IESEngine iESEngine) {
        this.f22782b = iESEngine;
    }

    protected int engineGetKeySize(Key key) {
        if (key instanceof IESKey) {
            IESKey iESKey = (IESKey) key;
            if (iESKey.mo5895b() instanceof DHPrivateKey) {
                return ((DHPrivateKey) iESKey.mo5895b()).getX().bitLength();
            }
            if (iESKey.mo5895b() instanceof ECPrivateKey) {
                return ((ECPrivateKey) iESKey.mo5895b()).mo6502d().bitLength();
            }
            throw new IllegalArgumentException("not an IE key!");
        }
        throw new IllegalArgumentException("must be passed IE key");
    }

    protected int engineGetOutputSize(int i) {
        if (this.f22783c != 1) {
            if (this.f22783c != 3) {
                if (this.f22783c != 2) {
                    if (this.f22783c != 4) {
                        throw new IllegalStateException("cipher not initialised");
                    }
                }
                return (this.f22784d.size() + i) - 20;
            }
        }
        return (this.f22784d.size() + i) + 20;
    }

    protected AlgorithmParameters engineGetParameters() {
        if (this.f22785e == null && this.f22786f != null) {
            try {
                this.f22785e = this.f22781a.mo5878c("IES");
                this.f22785e.init(this.f22786f);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f22785e;
    }

    protected void engineSetMode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't support mode ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    protected void engineSetPadding(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" unavailable with RSA.");
        throw new NoSuchPaddingException(stringBuilder.toString());
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (key instanceof IESKey) {
            if (algorithmParameterSpec == null && (i == 1 || i == 3)) {
                byte[] bArr = new byte[16];
                algorithmParameterSpec = new byte[16];
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                secureRandom.nextBytes(bArr);
                secureRandom.nextBytes(algorithmParameterSpec);
                algorithmParameterSpec = new IESParameterSpec(bArr, algorithmParameterSpec, 128);
            } else if ((algorithmParameterSpec instanceof IESParameterSpec) == null) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            IESKey iESKey = (IESKey) key;
            if ((iESKey.mo5894a() instanceof DHPublicKey) != null) {
                secureRandom = DHUtil.m27992a(iESKey.mo5894a());
                key = DHUtil.m27991a(iESKey.mo5895b());
            } else {
                secureRandom = ECUtil.m28010a(iESKey.mo5894a());
                key = ECUtil.m28009a(iESKey.mo5895b());
            }
            this.f22786f = (IESParameterSpec) algorithmParameterSpec;
            algorithmParameterSpec = new IESParameters(this.f22786f.m28334a(), this.f22786f.m28335b(), this.f22786f.m28336c());
            this.f22783c = i;
            this.f22784d.reset();
            switch (i) {
                case 1:
                case 3:
                    this.f22782b.m27421a(true, key, secureRandom, algorithmParameterSpec);
                    return;
                case 2:
                case 4:
                    this.f22782b.m27421a(false, key, secureRandom, algorithmParameterSpec);
                    return;
                default:
                    System.out.println("eeek!");
                    return;
            }
        }
        throw new InvalidKeyException("must be passed IES key");
    }

    protected void engineInit(int r4, java.security.Key r5, java.security.AlgorithmParameters r6, java.security.SecureRandom r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0034;
    L_0x0003:
        r1 = 0;
    L_0x0004:
        r2 = r3.f22787g;
        r2 = r2.length;
        if (r1 == r2) goto L_0x0016;
    L_0x0009:
        r2 = r3.f22787g;	 Catch:{ Exception -> 0x0013 }
        r2 = r2[r1];	 Catch:{ Exception -> 0x0013 }
        r2 = r6.getParameterSpec(r2);	 Catch:{ Exception -> 0x0013 }
        r0 = r2;
        goto L_0x0016;
    L_0x0013:
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x0016:
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x0034;
    L_0x0019:
        r4 = new java.security.InvalidAlgorithmParameterException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = "can't handle parameter ";
        r5.append(r7);
        r6 = r6.toString();
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0034:
        r3.f22785e = r6;
        r3.engineInit(r4, r5, r0, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ies.CipherSpi.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void");
    }

    protected void engineInit(int r2, java.security.Key r3, java.security.SecureRandom r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = 1;
        if (r2 == r0) goto L_0x0006;
    L_0x0003:
        r0 = 3;
        if (r2 != r0) goto L_0x000d;
    L_0x0006:
        r0 = 0;
        r0 = (java.security.spec.AlgorithmParameterSpec) r0;	 Catch:{ InvalidAlgorithmParameterException -> 0x000d }
        r1.engineInit(r2, r3, r0, r4);	 Catch:{ InvalidAlgorithmParameterException -> 0x000d }
        return;
    L_0x000d:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "can't handle null parameter spec in IES";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ies.CipherSpi.engineInit(int, java.security.Key, java.security.SecureRandom):void");
    }

    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f22784d.write(bArr, i, i2);
        return null;
    }

    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f22784d.write(bArr, i, i2);
        return null;
    }

    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.f22784d.write(bArr, i, i2);
        }
        try {
            bArr = this.f22784d.toByteArray();
            this.f22784d.reset();
            return this.f22782b.m27423a(bArr, 0, bArr.length);
        } catch (byte[] bArr2) {
            throw new BadPaddingException(bArr2.getMessage());
        }
    }

    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 != 0) {
            this.f22784d.write(bArr, i, i2);
        }
        try {
            bArr = this.f22784d.toByteArray();
            this.f22784d.reset();
            bArr = this.f22782b.m27423a(bArr, 0, bArr.length);
            System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
            return bArr.length;
        } catch (byte[] bArr3) {
            throw new BadPaddingException(bArr3.getMessage());
        }
    }
}
