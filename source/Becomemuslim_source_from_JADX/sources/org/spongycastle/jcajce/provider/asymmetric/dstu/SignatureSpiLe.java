package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.security.SignatureException;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DEROctetString;

public class SignatureSpiLe extends SignatureSpi {
    /* renamed from: b */
    void m41023b(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    protected byte[] engineSign() {
        byte[] c = ASN1OctetString.m42990a(super.engineSign()).mo6859c();
        m41023b(c);
        try {
            return new DEROctetString(c).mo6822f();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = org.spongycastle.asn1.ASN1Primitive.m39798b(r2);	 Catch:{ IOException -> 0x0028 }
        r2 = (org.spongycastle.asn1.ASN1OctetString) r2;	 Catch:{ IOException -> 0x0028 }
        r2 = r2.mo6859c();	 Catch:{ IOException -> 0x0028 }
        r1.m41023b(r2);
        r0 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ SignatureException -> 0x0026, Exception -> 0x001b }
        r0.<init>(r2);	 Catch:{ SignatureException -> 0x0026, Exception -> 0x001b }
        r2 = r0.mo6822f();	 Catch:{ SignatureException -> 0x0026, Exception -> 0x001b }
        r2 = super.engineVerify(r2);	 Catch:{ SignatureException -> 0x0026, Exception -> 0x001b }
        return r2;
    L_0x001b:
        r2 = move-exception;
        r0 = new java.security.SignatureException;
        r2 = r2.toString();
        r0.<init>(r2);
        throw r0;
    L_0x0026:
        r2 = move-exception;
        throw r2;
    L_0x0028:
        r2 = new java.security.SignatureException;
        r0 = "error decoding signature bytes.";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe.engineVerify(byte[]):boolean");
    }
}
