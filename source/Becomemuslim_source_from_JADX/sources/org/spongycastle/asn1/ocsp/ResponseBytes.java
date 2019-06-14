package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class ResponseBytes extends ASN1Object {
    /* renamed from: a */
    ASN1ObjectIdentifier f30934a;
    /* renamed from: b */
    ASN1OctetString f30935b;

    public ResponseBytes(ASN1Sequence aSN1Sequence) {
        this.f30934a = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(0);
        this.f30935b = (ASN1OctetString) aSN1Sequence.mo6860a(1);
    }

    /* renamed from: a */
    public static ResponseBytes m40038a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return m40037a(ASN1Sequence.m43001a(aSN1TaggedObject, z));
    }

    /* renamed from: a */
    public static ResponseBytes m40037a(Object obj) {
        if (obj instanceof ResponseBytes) {
            return (ResponseBytes) obj;
        }
        return obj != null ? new ResponseBytes(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30934a);
        aSN1EncodableVector.m27141a(this.f30935b);
        return new DERSequence(aSN1EncodableVector);
    }
}
