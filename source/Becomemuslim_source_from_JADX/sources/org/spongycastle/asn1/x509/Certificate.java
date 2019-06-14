package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;

public class Certificate extends ASN1Object {
    /* renamed from: a */
    ASN1Sequence f31248a;
    /* renamed from: b */
    TBSCertificate f31249b;
    /* renamed from: c */
    AlgorithmIdentifier f31250c;
    /* renamed from: d */
    DERBitString f31251d;

    /* renamed from: a */
    public static Certificate m40273a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40272a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    /* renamed from: a */
    public static Certificate m40272a(Object obj) {
        if (obj instanceof Certificate) {
            return (Certificate) obj;
        }
        return obj != null ? new Certificate(ASN1Sequence.m43000a(obj)) : null;
    }

    private Certificate(ASN1Sequence aSN1Sequence) {
        this.f31248a = aSN1Sequence;
        if (aSN1Sequence.mo6862g() == 3) {
            this.f31249b = TBSCertificate.m40430a(aSN1Sequence.mo6860a(0));
            this.f31250c = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(1));
            this.f31251d = DERBitString.m43051a(aSN1Sequence.mo6860a(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    /* renamed from: a */
    public TBSCertificate m40274a() {
        return this.f31249b;
    }

    /* renamed from: b */
    public int m40275b() {
        return this.f31249b.m40431a();
    }

    /* renamed from: c */
    public ASN1Integer m40276c() {
        return this.f31249b.m40432b();
    }

    /* renamed from: d */
    public X500Name m40277d() {
        return this.f31249b.m40434d();
    }

    /* renamed from: g */
    public Time m40279g() {
        return this.f31249b.m40436g();
    }

    /* renamed from: h */
    public Time m40280h() {
        return this.f31249b.m40437h();
    }

    /* renamed from: i */
    public X500Name m40281i() {
        return this.f31249b.m40438i();
    }

    /* renamed from: j */
    public SubjectPublicKeyInfo m40282j() {
        return this.f31249b.m40439j();
    }

    /* renamed from: k */
    public AlgorithmIdentifier m40283k() {
        return this.f31250c;
    }

    /* renamed from: l */
    public DERBitString m40284l() {
        return this.f31251d;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31248a;
    }
}
