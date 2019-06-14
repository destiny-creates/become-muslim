package org.spongycastle.jce.netscape;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class NetscapeCertRequest extends ASN1Object {
    /* renamed from: a */
    AlgorithmIdentifier f31992a;
    /* renamed from: b */
    byte[] f31993b;
    /* renamed from: c */
    String f31994c;
    /* renamed from: d */
    PublicKey f31995d;

    /* renamed from: a */
    private ASN1Primitive m41117a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f31995d.getEncoded());
            byteArrayOutputStream.close();
            return new ASN1InputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).m34595d();
        } catch (IOException e) {
            throw new InvalidKeySpecException(e.getMessage());
        }
    }

    /* renamed from: e */
    public org.spongycastle.asn1.ASN1Primitive mo5709e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new org.spongycastle.asn1.ASN1EncodableVector;
        r0.<init>();
        r1 = new org.spongycastle.asn1.ASN1EncodableVector;
        r1.<init>();
        r2 = r4.m41117a();	 Catch:{ Exception -> 0x0011 }
        r1.m27141a(r2);	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        r2 = new org.spongycastle.asn1.DERIA5String;
        r3 = r4.f31994c;
        r2.<init>(r3);
        r1.m27141a(r2);
        r2 = new org.spongycastle.asn1.DERSequence;
        r2.<init>(r1);
        r0.m27141a(r2);
        r1 = r4.f31992a;
        r0.m27141a(r1);
        r1 = new org.spongycastle.asn1.DERBitString;
        r2 = r4.f31993b;
        r1.<init>(r2);
        r0.m27141a(r1);
        r1 = new org.spongycastle.asn1.DERSequence;
        r1.<init>(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.netscape.NetscapeCertRequest.e():org.spongycastle.asn1.ASN1Primitive");
    }
}
