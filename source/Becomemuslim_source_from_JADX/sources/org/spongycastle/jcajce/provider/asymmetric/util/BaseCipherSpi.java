package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;

public abstract class BaseCipherSpi extends CipherSpi {
    /* renamed from: a */
    protected AlgorithmParameters f22816a = null;
    /* renamed from: b */
    protected Wrapper f22817b = null;
    /* renamed from: c */
    private Class[] f22818c = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
    /* renamed from: d */
    private final JcaJceHelper f22819d = new BCJcaJceHelper();

    protected int engineGetBlockSize() {
        return 0;
    }

    protected byte[] engineGetIV() {
        return null;
    }

    protected int engineGetOutputSize(int i) {
        return -1;
    }

    protected AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected BaseCipherSpi() {
    }

    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    /* renamed from: a */
    protected final AlgorithmParameters m27990a(String str) {
        return this.f22819d.mo5878c(str);
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

    protected byte[] engineWrap(Key key) {
        key = key.getEncoded();
        if (key != null) {
            try {
                if (this.f22817b == null) {
                    return engineDoFinal(key, 0, key.length);
                }
                return this.f22817b.mo5747a(key, 0, key.length);
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
        r0 = r3.f22817b;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
        r1 = 0;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
        if (r0 != 0) goto L_0x000b;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
    L_0x0005:
        r0 = r4.length;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
        r4 = r3.engineDoFinal(r4, r1, r0);	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
        goto L_0x0012;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
    L_0x000b:
        r0 = r3.f22817b;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
        r2 = r4.length;	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
        r4 = r0.mo5748b(r4, r1, r2);	 Catch:{ InvalidCipherTextException -> 0x00fd, BadPaddingException -> 0x00f2, IllegalBlockSizeException -> 0x00e7 }
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
        r0 = r3.f22819d;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        r5 = r0.mo5879d(r5);	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        r0 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        if (r6 != r0) goto L_0x0070;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
    L_0x0066:
        r6 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        r6.<init>(r4);	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        r4 = r5.generatePublic(r6);	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        return r4;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
    L_0x0070:
        if (r6 != r1) goto L_0x007c;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
    L_0x0072:
        r6 = new java.security.spec.PKCS8EncodedKeySpec;	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        r6.<init>(r4);	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
        r4 = r5.generatePrivate(r6);	 Catch:{ NoSuchAlgorithmException -> 0x00cb, InvalidKeySpecException -> 0x00af, NoSuchProviderException -> 0x0093 }
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
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = "Unknown key type ";
        r6.append(r0);
        r4 = r4.getMessage();
        r6.append(r4);
        r4 = r6.toString();
        r5.<init>(r4);
        throw r5;
    L_0x00e7:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r4 = r4.getMessage();
        r5.<init>(r4);
        throw r5;
    L_0x00f2:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r4 = r4.getMessage();
        r5.<init>(r4);
        throw r5;
    L_0x00fd:
        r4 = move-exception;
        r5 = new java.security.InvalidKeyException;
        r4 = r4.getMessage();
        r5.<init>(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi.engineUnwrap(byte[], java.lang.String, int):java.security.Key");
    }
}
