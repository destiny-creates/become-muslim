package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSTU4145Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECKey;

public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private static byte[] bH = new byte[]{(byte) 10, (byte) 9, (byte) 13, (byte) 6, (byte) 14, (byte) 11, (byte) 4, (byte) 5, (byte) 15, (byte) 1, (byte) 3, (byte) 12, (byte) 7, (byte) 0, (byte) 8, (byte) 2, (byte) 8, (byte) 0, (byte) 12, (byte) 4, (byte) 9, (byte) 6, (byte) 7, (byte) 11, (byte) 2, (byte) 3, (byte) 1, (byte) 15, (byte) 5, (byte) 14, (byte) 10, (byte) 13, (byte) 15, (byte) 6, (byte) 5, (byte) 8, (byte) 14, (byte) 11, (byte) 10, (byte) 4, (byte) 12, (byte) 0, (byte) 3, (byte) 7, (byte) 2, (byte) 9, (byte) 1, (byte) 13, (byte) 3, (byte) 8, (byte) 13, (byte) 9, (byte) 6, (byte) 11, (byte) 15, (byte) 0, (byte) 2, (byte) 5, (byte) 12, (byte) 10, (byte) 4, (byte) 14, (byte) 1, (byte) 7, (byte) 15, (byte) 8, (byte) 14, (byte) 9, (byte) 7, (byte) 2, (byte) 0, (byte) 13, (byte) 12, (byte) 6, (byte) 1, (byte) 5, (byte) 11, (byte) 4, (byte) 3, (byte) 10, (byte) 2, (byte) 8, (byte) 9, (byte) 7, (byte) 5, (byte) 15, (byte) 0, (byte) 11, (byte) 12, (byte) 1, (byte) 13, (byte) 14, (byte) 10, (byte) 3, (byte) 6, (byte) 4, (byte) 3, (byte) 8, (byte) 11, (byte) 5, (byte) 6, (byte) 4, (byte) 14, (byte) 10, (byte) 2, (byte) 12, (byte) 1, (byte) 7, (byte) 9, (byte) 15, (byte) 13, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 14, (byte) 6, (byte) 13, (byte) 11, (byte) 8, (byte) 15, (byte) 10, (byte) 12, (byte) 5, (byte) 7, (byte) 9, (byte) 0, (byte) 4};
    private Digest bF;
    private DSA bG = new DSTU4145Signer();

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
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28010a(r3);
        goto L_0x001d;
    L_0x0009:
        r3 = r3.getEncoded();	 Catch:{ Exception -> 0x003d }
        r3 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.m40409a(r3);	 Catch:{ Exception -> 0x003d }
        r3 = org.spongycastle.jce.provider.BouncyCastleProvider.m36189a(r3);	 Catch:{ Exception -> 0x003d }
        r0 = r3 instanceof org.spongycastle.jce.interfaces.ECPublicKey;	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x003d }
    L_0x0019:
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28010a(r3);	 Catch:{ Exception -> 0x003d }
    L_0x001d:
        r1 = new org.spongycastle.crypto.digests.GOST3411Digest;
        r3 = (org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey) r3;
        r3 = r3.m41016a();
        r3 = r2.m35991a(r3);
        r1.<init>(r3);
        r2.bF = r1;
        r3 = r2.bG;
        r1 = 0;
        r3.mo5800a(r1, r0);
        return;
    L_0x0035:
        r3 = new java.security.InvalidKeyException;	 Catch:{ Exception -> 0x003d }
        r0 = "can't recognise key type in DSA based signer";	 Catch:{ Exception -> 0x003d }
        r3.<init>(r0);	 Catch:{ Exception -> 0x003d }
        throw r3;	 Catch:{ Exception -> 0x003d }
    L_0x003d:
        r3 = new java.security.InvalidKeyException;
        r0 = "can't recognise key type in DSA based signer";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi.engineInitVerify(java.security.PublicKey):void");
    }

    /* renamed from: a */
    byte[] m35991a(byte[] bArr) {
        byte[] bArr2 = new byte[128];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr2[i2] = (byte) ((bArr[i] >> 4) & 15);
            bArr2[i2 + 1] = (byte) (bArr[i] & 15);
        }
        return bArr2;
    }

    protected void engineInitSign(PrivateKey privateKey) {
        privateKey = privateKey instanceof ECKey ? ECUtil.m28009a(privateKey) : null;
        this.bF = new GOST3411Digest(bH);
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
            BigInteger[] a = this.bG.mo5802a(bArr);
            Object toByteArray = a[0].toByteArray();
            Object toByteArray2 = a[1].toByteArray();
            Object obj = new byte[((toByteArray.length > toByteArray2.length ? toByteArray.length : toByteArray2.length) * 2)];
            System.arraycopy(toByteArray2, 0, obj, (obj.length / 2) - toByteArray2.length, toByteArray2.length);
            System.arraycopy(toByteArray, 0, obj, obj.length - toByteArray.length, toByteArray.length);
            return new DEROctetString(obj).mo6822f();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.bF;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r7.bF;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r8 = org.spongycastle.asn1.ASN1Primitive.m39798b(r8);	 Catch:{ Exception -> 0x0049 }
        r8 = (org.spongycastle.asn1.ASN1OctetString) r8;	 Catch:{ Exception -> 0x0049 }
        r8 = r8.mo6859c();	 Catch:{ Exception -> 0x0049 }
        r1 = r8.length;	 Catch:{ Exception -> 0x0049 }
        r3 = 2;	 Catch:{ Exception -> 0x0049 }
        r1 = r1 / r3;	 Catch:{ Exception -> 0x0049 }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0049 }
        r4 = r8.length;	 Catch:{ Exception -> 0x0049 }
        r4 = r4 / r3;	 Catch:{ Exception -> 0x0049 }
        r4 = new byte[r4];	 Catch:{ Exception -> 0x0049 }
        r5 = r8.length;	 Catch:{ Exception -> 0x0049 }
        r5 = r5 / r3;	 Catch:{ Exception -> 0x0049 }
        java.lang.System.arraycopy(r8, r2, r4, r2, r5);	 Catch:{ Exception -> 0x0049 }
        r5 = r8.length;	 Catch:{ Exception -> 0x0049 }
        r5 = r5 / r3;	 Catch:{ Exception -> 0x0049 }
        r6 = r8.length;	 Catch:{ Exception -> 0x0049 }
        r6 = r6 / r3;	 Catch:{ Exception -> 0x0049 }
        java.lang.System.arraycopy(r8, r5, r1, r2, r6);	 Catch:{ Exception -> 0x0049 }
        r8 = new java.math.BigInteger[r3];	 Catch:{ Exception -> 0x0049 }
        r3 = new java.math.BigInteger;	 Catch:{ Exception -> 0x0049 }
        r5 = 1;	 Catch:{ Exception -> 0x0049 }
        r3.<init>(r5, r1);	 Catch:{ Exception -> 0x0049 }
        r8[r2] = r3;	 Catch:{ Exception -> 0x0049 }
        r1 = new java.math.BigInteger;	 Catch:{ Exception -> 0x0049 }
        r1.<init>(r5, r4);	 Catch:{ Exception -> 0x0049 }
        r8[r5] = r1;	 Catch:{ Exception -> 0x0049 }
        r1 = r7.bG;
        r2 = r8[r2];
        r8 = r8[r5];
        r8 = r1.mo5801a(r0, r2, r8);
        return r8;
    L_0x0049:
        r8 = new java.security.SignatureException;
        r0 = "error decoding signature bytes.";
        r8.<init>(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi.engineVerify(byte[]):boolean");
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
