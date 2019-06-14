package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertList extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f31382a;
    /* renamed from: b */
    AlgorithmIdentifier f31383b;
    /* renamed from: c */
    X500Name f31384c;
    /* renamed from: d */
    Time f31385d;
    /* renamed from: e */
    Time f31386e;
    /* renamed from: f */
    ASN1Sequence f31387f;
    /* renamed from: g */
    Extensions f31388g;

    private class EmptyEnumeration implements Enumeration {
        /* renamed from: a */
        final /* synthetic */ TBSCertList f22024a;

        public boolean hasMoreElements() {
            return false;
        }

        private EmptyEnumeration(TBSCertList tBSCertList) {
            this.f22024a = tBSCertList;
        }

        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    private class RevokedCertificatesEnumeration implements Enumeration {
        /* renamed from: a */
        final /* synthetic */ TBSCertList f22025a;
        /* renamed from: b */
        private final Enumeration f22026b;

        RevokedCertificatesEnumeration(TBSCertList tBSCertList, Enumeration enumeration) {
            this.f22025a = tBSCertList;
            this.f22026b = enumeration;
        }

        public boolean hasMoreElements() {
            return this.f22026b.hasMoreElements();
        }

        public Object nextElement() {
            return CRLEntry.m40415a(this.f22026b.nextElement());
        }
    }

    public static class CRLEntry extends ASN1Object {
        /* renamed from: a */
        ASN1Sequence f31380a;
        /* renamed from: b */
        Extensions f31381b;

        private CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.mo6862g() < 2 || aSN1Sequence.mo6862g() > 3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad sequence size: ");
                stringBuilder.append(aSN1Sequence.mo6862g());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f31380a = aSN1Sequence;
        }

        /* renamed from: a */
        public static CRLEntry m40415a(Object obj) {
            if (obj instanceof CRLEntry) {
                return (CRLEntry) obj;
            }
            return obj != null ? new CRLEntry(ASN1Sequence.m43000a(obj)) : null;
        }

        /* renamed from: a */
        public ASN1Integer m40416a() {
            return ASN1Integer.m42963a(this.f31380a.mo6860a(0));
        }

        /* renamed from: b */
        public Time m40417b() {
            return Time.m40457a(this.f31380a.mo6860a(1));
        }

        /* renamed from: c */
        public Extensions m40418c() {
            if (this.f31381b == null && this.f31380a.mo6862g() == 3) {
                this.f31381b = Extensions.m40330a(this.f31380a.mo6860a(2));
            }
            return this.f31381b;
        }

        /* renamed from: e */
        public ASN1Primitive mo5709e() {
            return this.f31380a;
        }

        /* renamed from: d */
        public boolean m40419d() {
            return this.f31380a.mo6862g() == 3;
        }
    }

    /* renamed from: a */
    public static TBSCertList m40421a(Object obj) {
        if (obj instanceof TBSCertList) {
            return (TBSCertList) obj;
        }
        return obj != null ? new TBSCertList(ASN1Sequence.m43000a(obj)) : null;
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() < 3 || aSN1Sequence.mo6862g() > 7) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        if (aSN1Sequence.mo6860a(0) instanceof ASN1Integer) {
            this.f31382a = ASN1Integer.m42963a(aSN1Sequence.mo6860a(0));
            i = 1;
        } else {
            this.f31382a = null;
        }
        int i2 = i + 1;
        this.f31383b = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(i));
        i = i2 + 1;
        this.f31384c = X500Name.m40212a(aSN1Sequence.mo6860a(i2));
        i2 = i + 1;
        this.f31385d = Time.m40457a(aSN1Sequence.mo6860a(i));
        if (i2 >= aSN1Sequence.mo6862g() || !((aSN1Sequence.mo6860a(i2) instanceof ASN1UTCTime) || (aSN1Sequence.mo6860a(i2) instanceof ASN1GeneralizedTime) || (aSN1Sequence.mo6860a(i2) instanceof Time))) {
            i = i2;
        } else {
            i = i2 + 1;
            this.f31386e = Time.m40457a(aSN1Sequence.mo6860a(i2));
        }
        if (i < aSN1Sequence.mo6862g() && !(aSN1Sequence.mo6860a(i) instanceof DERTaggedObject)) {
            i2 = i + 1;
            this.f31387f = ASN1Sequence.m43000a(aSN1Sequence.mo6860a(i));
            i = i2;
        }
        if (i < aSN1Sequence.mo6862g() && (aSN1Sequence.mo6860a(i) instanceof DERTaggedObject)) {
            this.f31388g = Extensions.m40330a(ASN1Sequence.m43001a((ASN1TaggedObject) aSN1Sequence.mo6860a(i), true));
        }
    }

    /* renamed from: a */
    public int m40422a() {
        if (this.f31382a == null) {
            return 1;
        }
        return this.f31382a.m42968b().intValue() + 1;
    }

    /* renamed from: b */
    public AlgorithmIdentifier m40423b() {
        return this.f31383b;
    }

    /* renamed from: c */
    public X500Name m40424c() {
        return this.f31384c;
    }

    /* renamed from: d */
    public Time m40425d() {
        return this.f31385d;
    }

    /* renamed from: g */
    public Time m40427g() {
        return this.f31386e;
    }

    /* renamed from: h */
    public Enumeration m40428h() {
        if (this.f31387f == null) {
            return new EmptyEnumeration();
        }
        return new RevokedCertificatesEnumeration(this, this.f31387f.mo6861c());
    }

    /* renamed from: i */
    public Extensions m40429i() {
        return this.f31388g;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31382a != null) {
            aSN1EncodableVector.m27141a(this.f31382a);
        }
        aSN1EncodableVector.m27141a(this.f31383b);
        aSN1EncodableVector.m27141a(this.f31384c);
        aSN1EncodableVector.m27141a(this.f31385d);
        if (this.f31386e != null) {
            aSN1EncodableVector.m27141a(this.f31386e);
        }
        if (this.f31387f != null) {
            aSN1EncodableVector.m27141a(this.f31387f);
        }
        if (this.f31388g != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(0, this.f31388g));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
