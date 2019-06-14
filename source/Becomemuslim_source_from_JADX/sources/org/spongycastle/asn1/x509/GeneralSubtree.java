package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class GeneralSubtree extends ASN1Object {
    /* renamed from: a */
    private static final BigInteger f31311a = BigInteger.valueOf(0);
    /* renamed from: b */
    private GeneralName f31312b;
    /* renamed from: c */
    private ASN1Integer f31313c;
    /* renamed from: d */
    private ASN1Integer f31314d;

    private GeneralSubtree(ASN1Sequence aSN1Sequence) {
        this.f31312b = GeneralName.m40335a(aSN1Sequence.mo6860a(0));
        StringBuilder stringBuilder;
        switch (aSN1Sequence.mo6862g()) {
            case 1:
                return;
            case 2:
                aSN1Sequence = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(1));
                switch (aSN1Sequence.m43030b()) {
                    case 0:
                        this.f31313c = ASN1Integer.m42964a(aSN1Sequence, false);
                        return;
                    case 1:
                        this.f31314d = ASN1Integer.m42964a(aSN1Sequence, false);
                        return;
                    default:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Bad tag number: ");
                        stringBuilder.append(aSN1Sequence.m43030b());
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            case 3:
                ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(1));
                if (a.m43030b() == 0) {
                    this.f31313c = ASN1Integer.m42964a(a, false);
                    aSN1Sequence = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(2));
                    if (aSN1Sequence.m43030b() == 1) {
                        this.f31314d = ASN1Integer.m42964a(aSN1Sequence, false);
                        return;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Bad tag number for 'maximum': ");
                    stringBuilder.append(aSN1Sequence.m43030b());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Bad tag number for 'minimum': ");
                stringBuilder2.append(a.m43030b());
                throw new IllegalArgumentException(stringBuilder2.toString());
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Bad sequence size: ");
                stringBuilder.append(aSN1Sequence.mo6862g());
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static GeneralSubtree m40350a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof GeneralSubtree) {
            return (GeneralSubtree) obj;
        }
        return new GeneralSubtree(ASN1Sequence.m43000a(obj));
    }

    /* renamed from: a */
    public GeneralName m40351a() {
        return this.f31312b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31312b);
        if (!(this.f31313c == null || this.f31313c.m42968b().equals(f31311a))) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 0, this.f31313c));
        }
        if (this.f31314d != null) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(false, 1, this.f31314d));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
