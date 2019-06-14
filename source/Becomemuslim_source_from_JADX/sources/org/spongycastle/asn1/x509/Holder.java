package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Object {
    /* renamed from: a */
    IssuerSerial f31315a;
    /* renamed from: b */
    GeneralNames f31316b;
    /* renamed from: c */
    ObjectDigestInfo f31317c;
    /* renamed from: d */
    private int f31318d = 1;

    /* renamed from: a */
    public static Holder m40353a(Object obj) {
        if (obj instanceof Holder) {
            return (Holder) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Holder(ASN1TaggedObject.m43026a(obj));
        }
        return obj != null ? new Holder(ASN1Sequence.m43000a(obj)) : null;
    }

    private Holder(ASN1TaggedObject aSN1TaggedObject) {
        switch (aSN1TaggedObject.m43030b()) {
            case 0:
                this.f31315a = IssuerSerial.m40360a(aSN1TaggedObject, true);
                break;
            case 1:
                this.f31316b = GeneralNames.m40347a(aSN1TaggedObject, true);
                break;
            default:
                throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.f31318d = null;
    }

    private Holder(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() <= 3) {
            for (int i = 0; i != aSN1Sequence.mo6862g(); i++) {
                ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(i));
                switch (a.m43030b()) {
                    case 0:
                        this.f31315a = IssuerSerial.m40360a(a, false);
                        break;
                    case 1:
                        this.f31316b = GeneralNames.m40347a(a, false);
                        break;
                    case 2:
                        this.f31317c = ObjectDigestInfo.m40386a(a, false);
                        break;
                    default:
                        throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.f31318d = 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public IssuerSerial m40354a() {
        return this.f31315a;
    }

    /* renamed from: b */
    public GeneralNames m40355b() {
        return this.f31316b;
    }

    /* renamed from: c */
    public ObjectDigestInfo m40356c() {
        return this.f31317c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f31318d == 1) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (this.f31315a != null) {
                aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31315a));
            }
            if (this.f31316b != null) {
                aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31316b));
            }
            if (this.f31317c != null) {
                aSN1EncodableVector.m27141a(new DERTaggedObject(false, 2, this.f31317c));
            }
            return new DERSequence(aSN1EncodableVector);
        } else if (this.f31316b != null) {
            return new DERTaggedObject(true, 1, this.f31316b);
        } else {
            return new DERTaggedObject(true, 0, this.f31315a);
        }
    }
}
