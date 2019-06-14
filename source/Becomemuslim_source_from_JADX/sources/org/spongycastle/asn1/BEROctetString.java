package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class BEROctetString extends ASN1OctetString {
    /* renamed from: b */
    private ASN1OctetString[] f32849b;

    /* renamed from: org.spongycastle.asn1.BEROctetString$1 */
    class C66751 implements Enumeration {
        /* renamed from: a */
        int f21446a = null;
        /* renamed from: b */
        final /* synthetic */ BEROctetString f21447b;

        C66751(BEROctetString bEROctetString) {
            this.f21447b = bEROctetString;
        }

        public boolean hasMoreElements() {
            return this.f21446a < this.f21447b.f32849b.length;
        }

        public Object nextElement() {
            ASN1OctetString[] a = this.f21447b.f32849b;
            int i = this.f21446a;
            this.f21446a = i + 1;
            return a[i];
        }
    }

    /* renamed from: a */
    boolean mo6788a() {
        return true;
    }

    /* renamed from: a */
    private static byte[] m44359a(org.spongycastle.asn1.ASN1OctetString[] r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
    L_0x0006:
        r2 = r3.length;
        if (r1 == r2) goto L_0x0054;
    L_0x0009:
        r2 = r3[r1];	 Catch:{ ClassCastException -> 0x0033, IOException -> 0x0017 }
        r2 = (org.spongycastle.asn1.DEROctetString) r2;	 Catch:{ ClassCastException -> 0x0033, IOException -> 0x0017 }
        r2 = r2.mo6859c();	 Catch:{ ClassCastException -> 0x0033, IOException -> 0x0017 }
        r0.write(r2);	 Catch:{ ClassCastException -> 0x0033, IOException -> 0x0017 }
        r1 = r1 + 1;
        goto L_0x0006;
    L_0x0017:
        r3 = move-exception;
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "exception converting octets ";
        r1.append(r2);
        r3 = r3.toString();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x0033:
        r0 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r3[r1];
        r3 = r3.getClass();
        r3 = r3.getName();
        r2.append(r3);
        r3 = " found in input should only contain DEROctetString";
        r2.append(r3);
        r3 = r2.toString();
        r0.<init>(r3);
        throw r0;
    L_0x0054:
        r3 = r0.toByteArray();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.BEROctetString.a(org.spongycastle.asn1.ASN1OctetString[]):byte[]");
    }

    public BEROctetString(byte[] bArr) {
        super(bArr);
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        super(m44359a(aSN1OctetStringArr));
        this.f32849b = aSN1OctetStringArr;
    }

    /* renamed from: c */
    public byte[] mo6859c() {
        return this.a;
    }

    /* renamed from: j */
    public Enumeration mo6872j() {
        if (this.f32849b == null) {
            return m44361k().elements();
        }
        return new C66751(this);
    }

    /* renamed from: k */
    private Vector m44361k() {
        Vector vector = new Vector();
        int i = 0;
        while (i < this.a.length) {
            int i2 = i + 1000;
            Object obj = new byte[((i2 > this.a.length ? this.a.length : i2) - i)];
            System.arraycopy(this.a, i, obj, 0, obj.length);
            vector.addElement(new DEROctetString(obj));
            i = i2;
        }
        return vector;
    }

    /* renamed from: d */
    int mo6790d() {
        Enumeration j = mo6872j();
        int i = 0;
        while (j.hasMoreElements()) {
            i += ((ASN1Encodable) j.nextElement()).mo5709e().mo6790d();
        }
        return (i + 2) + 2;
    }

    /* renamed from: a */
    public void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.mo5710b(36);
        aSN1OutputStream.mo5710b(128);
        Enumeration j = mo6872j();
        while (j.hasMoreElements()) {
            aSN1OutputStream.mo5713a((ASN1Encodable) j.nextElement());
        }
        aSN1OutputStream.mo5710b(0);
        aSN1OutputStream.mo5710b(0);
    }

    /* renamed from: a */
    static BEROctetString m44358a(ASN1Sequence aSN1Sequence) {
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[aSN1Sequence.mo6862g()];
        aSN1Sequence = aSN1Sequence.mo6861c();
        int i = 0;
        while (aSN1Sequence.hasMoreElements()) {
            int i2 = i + 1;
            aSN1OctetStringArr[i] = (ASN1OctetString) aSN1Sequence.nextElement();
            i = i2;
        }
        return new BEROctetString(aSN1OctetStringArr);
    }
}
