package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.style.BCStyle;

public class X500Name extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private static X500NameStyle f31119a = BCStyle.f31134K;
    /* renamed from: b */
    private boolean f31120b;
    /* renamed from: c */
    private int f31121c;
    /* renamed from: d */
    private X500NameStyle f31122d;
    /* renamed from: e */
    private RDN[] f31123e;

    public X500Name(X500NameStyle x500NameStyle, X500Name x500Name) {
        this.f31123e = x500Name.f31123e;
        this.f31122d = x500NameStyle;
    }

    /* renamed from: a */
    public static X500Name m40213a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40212a(ASN1Sequence.m43001a(aSN1TaggedObject, true));
    }

    /* renamed from: a */
    public static X500Name m40212a(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        return obj != null ? new X500Name(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public static X500Name m40214a(X500NameStyle x500NameStyle, Object obj) {
        if (obj instanceof X500Name) {
            return new X500Name(x500NameStyle, (X500Name) obj);
        }
        return obj != null ? new X500Name(x500NameStyle, ASN1Sequence.m43000a(obj)) : null;
    }

    private X500Name(ASN1Sequence aSN1Sequence) {
        this(f31119a, aSN1Sequence);
    }

    private X500Name(X500NameStyle x500NameStyle, ASN1Sequence aSN1Sequence) {
        this.f31122d = x500NameStyle;
        this.f31123e = new RDN[aSN1Sequence.mo6862g()];
        x500NameStyle = aSN1Sequence.mo6861c();
        aSN1Sequence = null;
        while (x500NameStyle.hasMoreElements()) {
            int i = aSN1Sequence + 1;
            this.f31123e[aSN1Sequence] = RDN.m40207a(x500NameStyle.nextElement());
            aSN1Sequence = i;
        }
    }

    public X500Name(RDN[] rdnArr) {
        this(f31119a, rdnArr);
    }

    public X500Name(X500NameStyle x500NameStyle, RDN[] rdnArr) {
        this.f31123e = rdnArr;
        this.f31122d = x500NameStyle;
    }

    public X500Name(String str) {
        this(f31119a, str);
    }

    public X500Name(X500NameStyle x500NameStyle, String str) {
        this(x500NameStyle.mo6444b(str));
        this.f31122d = x500NameStyle;
    }

    /* renamed from: a */
    public RDN[] m40215a() {
        Object obj = new RDN[this.f31123e.length];
        System.arraycopy(this.f31123e, 0, obj, 0, obj.length);
        return obj;
    }

    /* renamed from: a */
    public RDN[] m40216a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Object obj = new RDN[this.f31123e.length];
        int i = 0;
        for (int i2 = 0; i2 != this.f31123e.length; i2++) {
            int i3;
            RDN rdn = this.f31123e[i2];
            if (rdn.m40208a()) {
                AttributeTypeAndValue[] c = rdn.m40210c();
                int i4 = 0;
                while (i4 != c.length) {
                    if (c[i4].m40202a().equals(aSN1ObjectIdentifier)) {
                        i3 = i + 1;
                        obj[i] = rdn;
                    } else {
                        i4++;
                    }
                }
            } else if (rdn.m40209b().m40202a().equals(aSN1ObjectIdentifier)) {
                i3 = i + 1;
                obj[i] = rdn;
            } else {
            }
            i = i3;
        }
        aSN1ObjectIdentifier = new RDN[i];
        System.arraycopy(obj, 0, aSN1ObjectIdentifier, 0, aSN1ObjectIdentifier.length);
        return aSN1ObjectIdentifier;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERSequence(this.f31123e);
    }

    public int hashCode() {
        if (this.f31120b) {
            return this.f31121c;
        }
        this.f31120b = true;
        this.f31121c = this.f31122d.mo5717a(this);
        return this.f31121c;
    }

    public boolean equals(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 1;
        if (r5 != r4) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof org.spongycastle.asn1.x500.X500Name;
        r2 = 0;
        if (r1 != 0) goto L_0x000e;
    L_0x0009:
        r1 = r5 instanceof org.spongycastle.asn1.ASN1Sequence;
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return r2;
    L_0x000e:
        r1 = r5;
        r1 = (org.spongycastle.asn1.ASN1Encodable) r1;
        r1 = r1.mo5709e();
        r3 = r4.mo5709e();
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = r4.f31122d;	 Catch:{ Exception -> 0x0036 }
        r1 = new org.spongycastle.asn1.x500.X500Name;	 Catch:{ Exception -> 0x0036 }
        r5 = (org.spongycastle.asn1.ASN1Encodable) r5;	 Catch:{ Exception -> 0x0036 }
        r5 = r5.mo5709e();	 Catch:{ Exception -> 0x0036 }
        r5 = org.spongycastle.asn1.ASN1Sequence.m43000a(r5);	 Catch:{ Exception -> 0x0036 }
        r1.<init>(r5);	 Catch:{ Exception -> 0x0036 }
        r5 = r0.mo5719a(r4, r1);	 Catch:{ Exception -> 0x0036 }
        return r5;
    L_0x0036:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x500.X500Name.equals(java.lang.Object):boolean");
    }

    public String toString() {
        return this.f31122d.mo6442b(this);
    }
}
