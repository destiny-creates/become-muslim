package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.util.Arrays;

public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    /* renamed from: a */
    protected int f27499a;
    /* renamed from: b */
    protected int f27500b;
    /* renamed from: c */
    protected AlgorithmParameters f27501c;
    /* renamed from: d */
    protected Wrapper f27502d;
    /* renamed from: e */
    private Class[] f27503e;
    /* renamed from: f */
    private int f27504f;
    /* renamed from: g */
    private byte[] f27505g;
    /* renamed from: h */
    private final JcaJceHelper f27506h;

    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return 0;
    }

    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        return null;
    }

    protected int engineGetBlockSize() {
        return 0;
    }

    protected int engineGetOutputSize(int i) {
        return -1;
    }

    protected AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected BaseWrapCipher() {
        this.f27503e = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.f27499a = 2;
        this.f27500b = 1;
        this.f27501c = null;
        this.f27502d = null;
        this.f27506h = new BCJcaJceHelper();
    }

    protected BaseWrapCipher(Wrapper wrapper) {
        this(wrapper, 0);
    }

    protected BaseWrapCipher(Wrapper wrapper, int i) {
        this.f27503e = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.f27499a = 2;
        this.f27500b = 1;
        this.f27501c = null;
        this.f27502d = null;
        this.f27506h = new BCJcaJceHelper();
        this.f27502d = wrapper;
        this.f27504f = i;
    }

    protected byte[] engineGetIV() {
        return Arrays.m29373b(this.f27505g);
    }

    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    /* renamed from: b */
    protected final AlgorithmParameters m36121b(String str) {
        return this.f27506h.mo5878c(str);
    }

    protected void engineSetMode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("can't support mode ");
        stringBuilder.append(str);
        throw new NoSuchAlgorithmException(stringBuilder.toString());
    }

    protected void engineSetPadding(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Padding ");
        stringBuilder.append(str);
        stringBuilder.append(" unknown.");
        throw new NoSuchPaddingException(stringBuilder.toString());
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                key = Util.m28093a(bCPBEKey, algorithmParameterSpec, this.f27502d.mo5745a());
            } else if (bCPBEKey.m28073e() != null) {
                key = bCPBEKey.m28073e();
            } else {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        }
        key = new KeyParameter(key.getEncoded());
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            key = new ParametersWithIV(key, ((IvParameterSpec) algorithmParameterSpec).getIV());
        }
        if (!((key instanceof KeyParameter) == null || this.f27504f == null)) {
            this.f27505g = new byte[this.f27504f];
            secureRandom.nextBytes(this.f27505g);
            key = new ParametersWithIV(key, this.f27505g);
        }
        if (secureRandom != null) {
            key = new ParametersWithRandom(key, secureRandom);
        }
        switch (i) {
            case 1:
            case 2:
                throw new IllegalArgumentException("engine only valid for wrapping");
            case 3:
                this.f27502d.mo5746a(true, key);
                return;
            case 4:
                this.f27502d.mo5746a(null, key);
                return;
            default:
                System.out.println("eeek!");
                return;
        }
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
        r2 = r3.f27503e;
        r2 = r2.length;
        if (r1 == r2) goto L_0x0016;
    L_0x0009:
        r2 = r3.f27503e;	 Catch:{ Exception -> 0x0013 }
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
        r3.f27501c = r6;
        r3.engineInit(r4, r5, r0, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void");
    }

    protected void engineInit(int i, Key key, SecureRandom secureRandom) {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (int i2) {
            throw new IllegalArgumentException(i2.getMessage());
        }
    }

    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        throw new RuntimeException("not supported for wrapping");
    }

    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        throw new RuntimeException("not supported for wrapping");
    }

    protected byte[] engineWrap(Key key) {
        key = key.getEncoded();
        if (key != null) {
            try {
                if (this.f27502d == null) {
                    return engineDoFinal(key, 0, key.length);
                }
                return this.f27502d.mo5747a(key, 0, key.length);
            } catch (Key key2) {
                throw new IllegalBlockSizeException(key2.getMessage());
            }
        }
        throw new InvalidKeyException("Cannot wrap key, null encoding.");
    }

    protected java.security.Key engineUnwrap(byte[] r4, java.lang.String r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f27502d;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
        r1 = 0;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
        if (r0 != 0) goto L_0x000b;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
    L_0x0005:
        r0 = r4.length;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
        r4 = r3.engineDoFinal(r4, r1, r0);	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
        goto L_0x0012;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
    L_0x000b:
        r0 = r3.f27502d;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
        r2 = r4.length;	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
        r4 = r0.mo5748b(r4, r1, r2);	 Catch:{ InvalidCipherTextException -> 0x00e1, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00cb }
    L_0x0012:
        r0 = 3;
        if (r6 != r0) goto L_0x001b;
    L_0x0015:
        r6 = new javax.crypto.spec.SecretKeySpec;
        r6.<init>(r4, r5);
        return r6;
    L_0x001b:
        r0 = "";
        r0 = r5.equals(r0);
        r1 = 2;
        if (r0 == 0) goto L_0x005d;
    L_0x0024:
        if (r6 != r1) goto L_0x005d;
    L_0x0026:
        r4 = org.spongycastle.asn1.pkcs.PrivateKeyInfo.m40111a(r4);	 Catch:{ Exception -> 0x0055 }
        r5 = org.spongycastle.jce.provider.BouncyCastleProvider.m36188a(r4);	 Catch:{ Exception -> 0x0055 }
        if (r5 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0055 }
    L_0x0030:
        return r5;	 Catch:{ Exception -> 0x0055 }
    L_0x0031:
        r5 = new java.security.InvalidKeyException;	 Catch:{ Exception -> 0x0055 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0055 }
        r6.<init>();	 Catch:{ Exception -> 0x0055 }
        r0 = "algorithm ";	 Catch:{ Exception -> 0x0055 }
        r6.append(r0);	 Catch:{ Exception -> 0x0055 }
        r4 = r4.m40112a();	 Catch:{ Exception -> 0x0055 }
        r4 = r4.m40230a();	 Catch:{ Exception -> 0x0055 }
        r6.append(r4);	 Catch:{ Exception -> 0x0055 }
        r4 = " not supported";	 Catch:{ Exception -> 0x0055 }
        r6.append(r4);	 Catch:{ Exception -> 0x0055 }
        r4 = r6.toString();	 Catch:{ Exception -> 0x0055 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x0055 }
        throw r5;	 Catch:{ Exception -> 0x0055 }
    L_0x0055:
        r4 = new java.security.InvalidKeyException;
        r5 = "Invalid key encoding.";
        r4.<init>(r5);
        throw r4;
    L_0x005d:
        r0 = r3.f27506h;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        r5 = r0.mo5879d(r5);	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        r0 = 1;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        if (r6 != r0) goto L_0x0070;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
    L_0x0066:
        r6 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        r6.<init>(r4);	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        r4 = r5.generatePublic(r6);	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        return r4;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
    L_0x0070:
        if (r6 != r1) goto L_0x007c;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
    L_0x0072:
        r6 = new java.security.spec.PKCS8EncodedKeySpec;	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        r6.<init>(r4);	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        r4 = r5.generatePrivate(r6);	 Catch:{ NoSuchProviderException -> 0x00af, InvalidKeySpecException -> 0x0093 }
        return r4;
    L_0x007c:
        r4 = new java.security.InvalidKeyException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = "Unknown key type ";
        r5.append(r0);
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0093:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = "Unknown key type ";
        r6.append(r0);
        r4 = r4.getMessage();
        r6.append(r4);
        r4 = r6.toString();
        r5.<init>(r4);
        throw r5;
    L_0x00af:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = "Unknown key type ";
        r6.append(r0);
        r4 = r4.getMessage();
        r6.append(r4);
        r4 = r6.toString();
        r5.<init>(r4);
        throw r5;
    L_0x00cb:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r4 = r4.getMessage();
        r5.<init>(r4);
        throw r5;
    L_0x00d6:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r4 = r4.getMessage();
        r5.<init>(r4);
        throw r5;
    L_0x00e1:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r4 = r4.getMessage();
        r5.<init>(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher.engineUnwrap(byte[], java.lang.String, int):java.security.Key");
    }
}
