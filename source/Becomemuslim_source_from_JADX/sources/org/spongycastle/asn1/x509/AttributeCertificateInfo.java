package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class AttributeCertificateInfo extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f31227a;
    /* renamed from: b */
    private Holder f31228b;
    /* renamed from: c */
    private AttCertIssuer f31229c;
    /* renamed from: d */
    private AlgorithmIdentifier f31230d;
    /* renamed from: e */
    private ASN1Integer f31231e;
    /* renamed from: f */
    private AttCertValidityPeriod f31232f;
    /* renamed from: g */
    private ASN1Sequence f31233g;
    /* renamed from: h */
    private DERBitString f31234h;
    /* renamed from: i */
    private Extensions f31235i;

    /* renamed from: a */
    public static AttributeCertificateInfo m40246a(Object obj) {
        if (obj instanceof AttributeCertificateInfo) {
            return (AttributeCertificateInfo) obj;
        }
        return obj != null ? new AttributeCertificateInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    private AttributeCertificateInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() < 6 || aSN1Sequence.mo6862g() > 9) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad sequence size: ");
            stringBuilder.append(aSN1Sequence.mo6862g());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        if (aSN1Sequence.mo6860a(0) instanceof ASN1Integer) {
            this.f31227a = ASN1Integer.m42963a(aSN1Sequence.mo6860a(0));
            i = 1;
        } else {
            this.f31227a = new ASN1Integer(0);
        }
        this.f31228b = Holder.m40353a(aSN1Sequence.mo6860a(i));
        this.f31229c = AttCertIssuer.m40233a(aSN1Sequence.mo6860a(i + 1));
        this.f31230d = AlgorithmIdentifier.m40228a(aSN1Sequence.mo6860a(i + 2));
        this.f31231e = ASN1Integer.m42963a(aSN1Sequence.mo6860a(i + 3));
        this.f31232f = AttCertValidityPeriod.m40236a(aSN1Sequence.mo6860a(i + 4));
        this.f31233g = ASN1Sequence.m43000a(aSN1Sequence.mo6860a(i + 5));
        for (i += 6; i < aSN1Sequence.mo6862g(); i++) {
            ASN1Encodable a = aSN1Sequence.mo6860a(i);
            if (a instanceof DERBitString) {
                this.f31234h = DERBitString.m43051a(aSN1Sequence.mo6860a(i));
            } else if ((a instanceof ASN1Sequence) || (a instanceof Extensions)) {
                this.f31235i = Extensions.m40330a(aSN1Sequence.mo6860a(i));
            }
        }
    }

    /* renamed from: a */
    public Holder m40247a() {
        return this.f31228b;
    }

    /* renamed from: b */
    public AttCertIssuer m40248b() {
        return this.f31229c;
    }

    /* renamed from: c */
    public ASN1Integer m40249c() {
        return this.f31231e;
    }

    /* renamed from: d */
    public AttCertValidityPeriod m40250d() {
        return this.f31232f;
    }

    /* renamed from: g */
    public ASN1Sequence m40252g() {
        return this.f31233g;
    }

    /* renamed from: h */
    public Extensions m40253h() {
        return this.f31235i;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31227a.m42968b().intValue() != 0) {
            aSN1EncodableVector.m27141a(this.f31227a);
        }
        aSN1EncodableVector.m27141a(this.f31228b);
        aSN1EncodableVector.m27141a(this.f31229c);
        aSN1EncodableVector.m27141a(this.f31230d);
        aSN1EncodableVector.m27141a(this.f31231e);
        aSN1EncodableVector.m27141a(this.f31232f);
        aSN1EncodableVector.m27141a(this.f31233g);
        if (this.f31234h != null) {
            aSN1EncodableVector.m27141a(this.f31234h);
        }
        if (this.f31235i != null) {
            aSN1EncodableVector.m27141a(this.f31235i);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
