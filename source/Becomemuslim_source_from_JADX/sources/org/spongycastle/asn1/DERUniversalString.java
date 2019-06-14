package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;

public class DERUniversalString extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private static final char[] f32512a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private final byte[] f32513b;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    public DERUniversalString(byte[] bArr) {
        this.f32513b = bArr;
    }

    /* renamed from: b */
    public java.lang.String mo6440b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new java.lang.StringBuffer;
        r1 = "#";
        r0.<init>(r1);
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r2 = new org.spongycastle.asn1.ASN1OutputStream;
        r2.<init>(r1);
        r2.mo5713a(r5);	 Catch:{ IOException -> 0x003c }
        r1 = r1.toByteArray();
        r2 = 0;
    L_0x0019:
        r3 = r1.length;
        if (r2 == r3) goto L_0x0037;
    L_0x001c:
        r3 = f32512a;
        r4 = r1[r2];
        r4 = r4 >>> 4;
        r4 = r4 & 15;
        r3 = r3[r4];
        r0.append(r3);
        r3 = f32512a;
        r4 = r1[r2];
        r4 = r4 & 15;
        r3 = r3[r4];
        r0.append(r3);
        r2 = r2 + 1;
        goto L_0x0019;
    L_0x0037:
        r0 = r0.toString();
        return r0;
    L_0x003c:
        r0 = new java.lang.RuntimeException;
        r1 = "internal error encoding BitString";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.DERUniversalString.b():java.lang.String");
    }

    public String toString() {
        return mo6440b();
    }

    /* renamed from: c */
    public byte[] m43117c() {
        return this.f32513b;
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32513b.length) + 1) + this.f32513b.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(28, m43117c());
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERUniversalString) {
            return Arrays.m29353a(this.f32513b, ((DERUniversalString) aSN1Primitive).f32513b);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32513b);
    }
}
