package org.spongycastle.jcajce.provider.asymmetric.ecgost;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.ECGOST3410Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.spongycastle.jce.interfaces.ECKey;

public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest bF = new GOST3411Digest();
    private DSA bG = new ECGOST3410Signer();

    protected void engineInitVerify(java.security.PublicKey r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3 instanceof org.spongycastle.jce.interfaces.ECPublicKey;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28010a(r3);
        goto L_0x0022;
    L_0x0009:
        r0 = r3 instanceof org.spongycastle.jce.interfaces.GOST3410Key;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.GOST3410Util.m28015a(r3);
        goto L_0x0022;
    L_0x0012:
        r3 = r3.getEncoded();	 Catch:{ Exception -> 0x002e }
        r3 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.m40409a(r3);	 Catch:{ Exception -> 0x002e }
        r3 = org.spongycastle.jce.provider.BouncyCastleProvider.m36189a(r3);	 Catch:{ Exception -> 0x002e }
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28010a(r3);	 Catch:{ Exception -> 0x002e }
    L_0x0022:
        r0 = r2.bF;
        r0.mo5733c();
        r0 = r2.bG;
        r1 = 0;
        r0.mo5800a(r1, r3);
        return;
    L_0x002e:
        r3 = new java.security.InvalidKeyException;
        r0 = "can't recognise key type in DSA based signer";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi.engineInitVerify(java.security.PublicKey):void");
    }

    protected void engineInitSign(PrivateKey privateKey) {
        if (privateKey instanceof ECKey) {
            privateKey = ECUtil.m28009a(privateKey);
        } else {
            privateKey = GOST3410Util.m28014a(privateKey);
        }
        this.bF.mo5733c();
        if (this.appRandom != null) {
            this.bG.mo5800a(true, new ParametersWithRandom(privateKey, this.appRandom));
        } else {
            this.bG.mo5800a(true, privateKey);
        }
    }

    protected void engineUpdate(byte b) {
        this.bF.mo5730a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.bF.mo5731a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        byte[] bArr = new byte[this.bF.mo5732b()];
        this.bF.mo5728a(bArr, 0);
        try {
            Object obj = new byte[64];
            BigInteger[] a = this.bG.mo5802a(bArr);
            Object toByteArray = a[0].toByteArray();
            Object toByteArray2 = a[1].toByteArray();
            if (toByteArray2[0] != (byte) 0) {
                System.arraycopy(toByteArray2, 0, obj, 32 - toByteArray2.length, toByteArray2.length);
            } else {
                System.arraycopy(toByteArray2, 1, obj, 32 - (toByteArray2.length - 1), toByteArray2.length - 1);
            }
            if (toByteArray[0] != (byte) 0) {
                System.arraycopy(toByteArray, 0, obj, 64 - toByteArray.length, toByteArray.length);
            } else {
                System.arraycopy(toByteArray, 1, obj, 64 - (toByteArray.length - 1), toByteArray.length - 1);
            }
            return obj;
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.bF;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r6.bF;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = 32;
        r3 = new byte[r1];	 Catch:{ Exception -> 0x0037 }
        r4 = new byte[r1];	 Catch:{ Exception -> 0x0037 }
        java.lang.System.arraycopy(r7, r2, r4, r2, r1);	 Catch:{ Exception -> 0x0037 }
        java.lang.System.arraycopy(r7, r1, r3, r2, r1);	 Catch:{ Exception -> 0x0037 }
        r7 = 2;	 Catch:{ Exception -> 0x0037 }
        r7 = new java.math.BigInteger[r7];	 Catch:{ Exception -> 0x0037 }
        r1 = new java.math.BigInteger;	 Catch:{ Exception -> 0x0037 }
        r5 = 1;	 Catch:{ Exception -> 0x0037 }
        r1.<init>(r5, r3);	 Catch:{ Exception -> 0x0037 }
        r7[r2] = r1;	 Catch:{ Exception -> 0x0037 }
        r1 = new java.math.BigInteger;	 Catch:{ Exception -> 0x0037 }
        r1.<init>(r5, r4);	 Catch:{ Exception -> 0x0037 }
        r7[r5] = r1;	 Catch:{ Exception -> 0x0037 }
        r1 = r6.bG;
        r2 = r7[r2];
        r7 = r7[r5];
        r7 = r1.mo5801a(r0, r2, r7);
        return r7;
    L_0x0037:
        r7 = new java.security.SignatureException;
        r0 = "error decoding signature bytes.";
        r7.<init>(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi.engineVerify(byte[]):boolean");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
