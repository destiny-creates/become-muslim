package org.spongycastle.asn1;

public abstract class ASN1Primitive extends ASN1Object {
    /* renamed from: a */
    abstract void mo6787a(ASN1OutputStream aSN1OutputStream);

    /* renamed from: a */
    abstract boolean mo6788a();

    /* renamed from: a */
    abstract boolean mo6789a(ASN1Primitive aSN1Primitive);

    /* renamed from: d */
    abstract int mo6790d();

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this;
    }

    /* renamed from: h */
    ASN1Primitive mo6791h() {
        return this;
    }

    public abstract int hashCode();

    /* renamed from: i */
    ASN1Primitive mo6792i() {
        return this;
    }

    ASN1Primitive() {
    }

    /* renamed from: b */
    public static org.spongycastle.asn1.ASN1Primitive m39798b(byte[] r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.spongycastle.asn1.ASN1InputStream;
        r0.<init>(r1);
        r1 = r0.m34595d();	 Catch:{ ClassCastException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = new java.io.IOException;
        r0 = "cannot recognise object in stream";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1Primitive.b(byte[]):org.spongycastle.asn1.ASN1Primitive");
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASN1Encodable) || mo6789a(((ASN1Encodable) obj).mo5709e()) == null) {
            z = false;
        }
        return z;
    }
}
