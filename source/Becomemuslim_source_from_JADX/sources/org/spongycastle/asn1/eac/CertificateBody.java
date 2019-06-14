package org.spongycastle.asn1.eac;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;

public class CertificateBody extends ASN1Object {
    /* renamed from: a */
    private DERApplicationSpecific f30773a;
    /* renamed from: b */
    private DERApplicationSpecific f30774b;
    /* renamed from: c */
    private PublicKeyDataObject f30775c;
    /* renamed from: d */
    private DERApplicationSpecific f30776d;
    /* renamed from: e */
    private CertificateHolderAuthorization f30777e;
    /* renamed from: f */
    private DERApplicationSpecific f30778f;
    /* renamed from: g */
    private DERApplicationSpecific f30779g;
    /* renamed from: h */
    private int f30780h;

    /* renamed from: a */
    private ASN1Primitive m39967a() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30773a);
        aSN1EncodableVector.m27141a(this.f30774b);
        aSN1EncodableVector.m27141a(new DERApplicationSpecific(false, 73, this.f30775c));
        aSN1EncodableVector.m27141a(this.f30776d);
        aSN1EncodableVector.m27141a(this.f30777e);
        aSN1EncodableVector.m27141a(this.f30778f);
        aSN1EncodableVector.m27141a(this.f30779g);
        return new DERApplicationSpecific(78, aSN1EncodableVector);
    }

    /* renamed from: b */
    private ASN1Primitive m39968b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30773a);
        aSN1EncodableVector.m27141a(new DERApplicationSpecific(false, 73, this.f30775c));
        aSN1EncodableVector.m27141a(this.f30776d);
        return new DERApplicationSpecific(78, aSN1EncodableVector);
    }

    /* renamed from: e */
    public org.spongycastle.asn1.ASN1Primitive mo5709e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.f30780h;	 Catch:{ IOException -> 0x0018 }
        r2 = 127; // 0x7f float:1.78E-43 double:6.27E-322;	 Catch:{ IOException -> 0x0018 }
        if (r1 != r2) goto L_0x000c;	 Catch:{ IOException -> 0x0018 }
    L_0x0007:
        r1 = r3.m39967a();	 Catch:{ IOException -> 0x0018 }
        return r1;	 Catch:{ IOException -> 0x0018 }
    L_0x000c:
        r1 = r3.f30780h;	 Catch:{ IOException -> 0x0018 }
        r2 = 13;	 Catch:{ IOException -> 0x0018 }
        if (r1 != r2) goto L_0x0017;	 Catch:{ IOException -> 0x0018 }
    L_0x0012:
        r1 = r3.m39968b();	 Catch:{ IOException -> 0x0018 }
        return r1;
    L_0x0017:
        return r0;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.eac.CertificateBody.e():org.spongycastle.asn1.ASN1Primitive");
    }
}
