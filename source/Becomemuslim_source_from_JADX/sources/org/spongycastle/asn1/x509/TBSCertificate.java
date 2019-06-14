package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificate extends ASN1Object {
    /* renamed from: a */
    ASN1Sequence f31389a;
    /* renamed from: b */
    ASN1Integer f31390b;
    /* renamed from: c */
    ASN1Integer f31391c;
    /* renamed from: d */
    AlgorithmIdentifier f31392d;
    /* renamed from: e */
    X500Name f31393e;
    /* renamed from: f */
    Time f31394f;
    /* renamed from: g */
    Time f31395g;
    /* renamed from: h */
    X500Name f31396h;
    /* renamed from: i */
    SubjectPublicKeyInfo f31397i;
    /* renamed from: j */
    DERBitString f31398j;
    /* renamed from: k */
    DERBitString f31399k;
    /* renamed from: l */
    Extensions f31400l;

    /* renamed from: a */
    public static TBSCertificate m40430a(Object obj) {
        if (obj instanceof TBSCertificate) {
            return (TBSCertificate) obj;
        }
        return obj != null ? new TBSCertificate(ASN1Sequence.m43000a(obj)) : null;
    }

    private TBSCertificate(ASN1Sequence aSN1Sequence) {
        int i;
        this.f31389a = aSN1Sequence;
        if (aSN1Sequence.mo6860a(0) instanceof DERTaggedObject) {
            this.f31390b = ASN1Integer.m42964a((ASN1TaggedObject) aSN1Sequence.mo6860a(0), true);
            i = 0;
        } else {
            this.f31390b = new ASN1Integer(0);
            i = -1;
        }
        this.f31391c = ASN1Integer.m42963a(aSN1Sequence.mo6860a(i + 1));
        this.f31392d = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(i + 2));
        this.f31393e = X500Name.m40212a(aSN1Sequence.mo6860a(i + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.mo6860a(i + 4);
        this.f31394f = Time.m40457a(aSN1Sequence2.mo6860a(0));
        this.f31395g = Time.m40457a(aSN1Sequence2.mo6860a(1));
        this.f31396h = X500Name.m40212a(aSN1Sequence.mo6860a(i + 5));
        i += 6;
        this.f31397i = SubjectPublicKeyInfo.m40409a(aSN1Sequence.mo6860a(i));
        for (int g = (aSN1Sequence.mo6862g() - i) - 1; g > 0; g--) {
            ASN1TaggedObject aSN1TaggedObject = (DERTaggedObject) aSN1Sequence.mo6860a(i + g);
            switch (aSN1TaggedObject.m43030b()) {
                case 1:
                    this.f31398j = DERBitString.m43052a(aSN1TaggedObject, false);
                    break;
                case 2:
                    this.f31399k = DERBitString.m43052a(aSN1TaggedObject, false);
                    break;
                case 3:
                    this.f31400l = Extensions.m40330a(ASN1Sequence.m43001a(aSN1TaggedObject, true));
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    public int m40431a() {
        return this.f31390b.m42968b().intValue() + 1;
    }

    /* renamed from: b */
    public ASN1Integer m40432b() {
        return this.f31391c;
    }

    /* renamed from: c */
    public AlgorithmIdentifier m40433c() {
        return this.f31392d;
    }

    /* renamed from: d */
    public X500Name m40434d() {
        return this.f31393e;
    }

    /* renamed from: g */
    public Time m40436g() {
        return this.f31394f;
    }

    /* renamed from: h */
    public Time m40437h() {
        return this.f31395g;
    }

    /* renamed from: i */
    public X500Name m40438i() {
        return this.f31396h;
    }

    /* renamed from: j */
    public SubjectPublicKeyInfo m40439j() {
        return this.f31397i;
    }

    /* renamed from: k */
    public DERBitString m40440k() {
        return this.f31398j;
    }

    /* renamed from: l */
    public DERBitString m40441l() {
        return this.f31399k;
    }

    /* renamed from: m */
    public Extensions m40442m() {
        return this.f31400l;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31389a;
    }
}
