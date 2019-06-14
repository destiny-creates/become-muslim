package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12KeyWithParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE.Util;

public class BaseStreamCipher extends BaseWrapCipher implements PBE {
    /* renamed from: e */
    private Class[] f31978e;
    /* renamed from: f */
    private StreamCipher f31979f;
    /* renamed from: g */
    private int f31980g;
    /* renamed from: h */
    private int f31981h;
    /* renamed from: i */
    private ParametersWithIV f31982i;
    /* renamed from: j */
    private int f31983j;
    /* renamed from: k */
    private PBEParameterSpec f31984k;
    /* renamed from: l */
    private String f31985l;

    protected int engineGetBlockSize() {
        return 0;
    }

    protected int engineGetOutputSize(int i) {
        return i;
    }

    protected BaseStreamCipher(StreamCipher streamCipher, int i) {
        this(streamCipher, i, -1, -1);
    }

    protected BaseStreamCipher(StreamCipher streamCipher, int i, int i2, int i3) {
        this.f31978e = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f31983j = 0;
        this.f31984k = null;
        this.f31985l = null;
        this.f31979f = streamCipher;
        this.f31983j = i;
        this.f31980g = i2;
        this.f31981h = i3;
    }

    protected byte[] engineGetIV() {
        return this.f31982i != null ? this.f31982i.m35695a() : null;
    }

    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    protected java.security.AlgorithmParameters engineGetParameters() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.c;
        if (r0 != 0) goto L_0x0016;
    L_0x0004:
        r0 = r2.f31984k;
        if (r0 == 0) goto L_0x0016;
    L_0x0008:
        r0 = r2.f31985l;	 Catch:{ Exception -> 0x0014 }
        r0 = r2.m36121b(r0);	 Catch:{ Exception -> 0x0014 }
        r1 = r2.f31984k;	 Catch:{ Exception -> 0x0014 }
        r0.init(r1);	 Catch:{ Exception -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = 0;
        return r0;
    L_0x0016:
        r0 = r2.c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher.engineGetParameters():java.security.AlgorithmParameters");
    }

    protected void engineSetMode(String str) {
        if (!str.equalsIgnoreCase("ECB")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("can't support mode ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected void engineSetPadding(String str) {
        if (!str.equalsIgnoreCase("NoPadding")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Padding ");
            stringBuilder.append(str);
            stringBuilder.append(" unknown.");
            throw new NoSuchPaddingException(stringBuilder.toString());
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.f31984k = null;
        this.f31985l = null;
        this.c = null;
        if (key instanceof SecretKey) {
            if (key instanceof PKCS12Key) {
                PKCS12Key pKCS12Key = (PKCS12Key) key;
                this.f31984k = (PBEParameterSpec) algorithmParameterSpec;
                if ((pKCS12Key instanceof PKCS12KeyWithParameters) != null && this.f31984k == null) {
                    PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                    this.f31984k = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
                }
                algorithmParameterSpec = Util.m28094a(pKCS12Key.getEncoded(), 2, this.f31981h, this.f31980g, this.f31983j * 8, this.f31984k, this.f31979f.mo5749a());
            } else if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                if (bCPBEKey.m28074f() != null) {
                    this.f31985l = bCPBEKey.m28074f().m42986b();
                } else {
                    this.f31985l = bCPBEKey.getAlgorithm();
                }
                if (bCPBEKey.m28073e() != null) {
                    algorithmParameterSpec = bCPBEKey.m28073e();
                    this.f31984k = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                    CipherParameters a = Util.m28093a(bCPBEKey, algorithmParameterSpec, this.f31979f.mo5749a());
                    this.f31984k = (PBEParameterSpec) algorithmParameterSpec;
                    algorithmParameterSpec = a;
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                if (bCPBEKey.m28072d() != null) {
                    this.f31982i = (ParametersWithIV) algorithmParameterSpec;
                }
            } else if (algorithmParameterSpec == null) {
                if (this.f31981h <= null) {
                    algorithmParameterSpec = new KeyParameter(key.getEncoded());
                } else {
                    throw new InvalidKeyException("Algorithm requires a PBE key");
                }
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                ParametersWithIV parametersWithIV = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                this.f31982i = parametersWithIV;
                algorithmParameterSpec = parametersWithIV;
            } else {
                throw new InvalidAlgorithmParameterException("unknown parameter type.");
            }
            if (this.f31983j != null && (algorithmParameterSpec instanceof ParametersWithIV) == null) {
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                if (i != 1) {
                    if (i != 3) {
                        throw new InvalidAlgorithmParameterException("no IV set when one expected");
                    }
                }
                key = new byte[this.f31983j];
                secureRandom.nextBytes(key);
                secureRandom = new ParametersWithIV(algorithmParameterSpec, key);
                this.f31982i = (ParametersWithIV) secureRandom;
                algorithmParameterSpec = secureRandom;
            }
            switch (i) {
                case 1:
                case 3:
                    this.f31979f.mo5750a(true, algorithmParameterSpec);
                    return;
                case 2:
                case 4:
                    this.f31979f.mo5750a(null, algorithmParameterSpec);
                    return;
                default:
                    try {
                        algorithmParameterSpec = new StringBuilder();
                        algorithmParameterSpec.append("unknown opmode ");
                        algorithmParameterSpec.append(i);
                        algorithmParameterSpec.append(" passed");
                        throw new InvalidParameterException(algorithmParameterSpec.toString());
                    } catch (int i2) {
                        throw new InvalidKeyException(i2.getMessage());
                    }
            }
        }
        algorithmParameterSpec = new StringBuilder();
        algorithmParameterSpec.append("Key for algorithm ");
        algorithmParameterSpec.append(key.getAlgorithm());
        algorithmParameterSpec.append(" not suitable for symmetric enryption.");
        throw new InvalidKeyException(algorithmParameterSpec.toString());
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
        r2 = r3.f31978e;
        r2 = r2.length;
        if (r1 == r2) goto L_0x0016;
    L_0x0009:
        r2 = r3.f31978e;	 Catch:{ Exception -> 0x0013 }
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
        r3.engineInit(r4, r5, r0, r7);
        r3.c = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseStreamCipher.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void");
    }

    protected void engineInit(int i, Key key, SecureRandom secureRandom) {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (int i2) {
            throw new InvalidKeyException(i2.getMessage());
        }
    }

    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f31979f.mo5722a(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i3 + i2 <= bArr2.length) {
            try {
                this.f31979f.mo5722a(bArr, i, i2, bArr2, i3);
                return i2;
            } catch (byte[] bArr3) {
                throw new IllegalStateException(bArr3.getMessage());
            }
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            bArr = engineUpdate(bArr, i, i2);
            this.f31979f.mo5751c();
            return bArr;
        }
        this.f31979f.mo5751c();
        return new byte[null];
    }

    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i3 + i2 <= bArr2.length) {
            if (i2 != 0) {
                this.f31979f.mo5722a(bArr, i, i2, bArr2, i3);
            }
            this.f31979f.mo5751c();
            return i2;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }
}
