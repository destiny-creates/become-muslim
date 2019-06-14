package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;

public class CertificateList extends ASN1Object {
    /* renamed from: a */
    TBSCertList f31252a;
    /* renamed from: b */
    AlgorithmIdentifier f31253b;
    /* renamed from: c */
    DERBitString f31254c;
    /* renamed from: d */
    boolean f31255d = false;
    /* renamed from: e */
    int f31256e;

    /* renamed from: a */
    public static CertificateList m40285a(Object obj) {
        if (obj instanceof CertificateList) {
            return (CertificateList) obj;
        }
        return obj != null ? new CertificateList(ASN1Sequence.m43000a(obj)) : null;
    }

    public CertificateList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 3) {
            this.f31252a = TBSCertList.m40421a(aSN1Sequence.mo6860a(0));
            this.f31253b = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(1));
            this.f31254c = DERBitString.m43051a(aSN1Sequence.mo6860a(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for CertificateList");
    }

    /* renamed from: a */
    public TBSCertList m40286a() {
        return this.f31252a;
    }

    /* renamed from: b */
    public Enumeration m40287b() {
        return this.f31252a.m40428h();
    }

    /* renamed from: c */
    public AlgorithmIdentifier m40288c() {
        return this.f31253b;
    }

    /* renamed from: d */
    public DERBitString m40289d() {
        return this.f31254c;
    }

    /* renamed from: g */
    public int m40291g() {
        return this.f31252a.m40422a();
    }

    /* renamed from: h */
    public X500Name m40292h() {
        return this.f31252a.m40424c();
    }

    /* renamed from: i */
    public Time m40293i() {
        return this.f31252a.m40425d();
    }

    /* renamed from: j */
    public Time m40294j() {
        return this.f31252a.m40427g();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31252a);
        aSN1EncodableVector.m27141a(this.f31253b);
        aSN1EncodableVector.m27141a(this.f31254c);
        return new DERSequence(aSN1EncodableVector);
    }

    public int hashCode() {
        if (!this.f31255d) {
            this.f31256e = super.hashCode();
            this.f31255d = true;
        }
        return this.f31256e;
    }
}
