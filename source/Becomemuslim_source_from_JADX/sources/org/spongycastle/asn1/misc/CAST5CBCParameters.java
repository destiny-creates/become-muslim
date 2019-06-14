package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class CAST5CBCParameters extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30908a;
    /* renamed from: b */
    ASN1OctetString f30909b;

    /* renamed from: a */
    public static CAST5CBCParameters m40018a(Object obj) {
        if (obj instanceof CAST5CBCParameters) {
            return (CAST5CBCParameters) obj;
        }
        return obj != null ? new CAST5CBCParameters(ASN1Sequence.m43000a(obj)) : null;
    }

    public CAST5CBCParameters(byte[] bArr, int i) {
        this.f30909b = new DEROctetString(bArr);
        this.f30908a = new ASN1Integer((long) i);
    }

    public CAST5CBCParameters(ASN1Sequence aSN1Sequence) {
        this.f30909b = (ASN1OctetString) aSN1Sequence.mo6860a(0);
        this.f30908a = (ASN1Integer) aSN1Sequence.mo6860a(1);
    }

    /* renamed from: a */
    public byte[] m40019a() {
        return this.f30909b.mo6859c();
    }

    /* renamed from: b */
    public int m40020b() {
        return this.f30908a.m42968b().intValue();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30909b);
        aSN1EncodableVector.m27141a(this.f30908a);
        return new DERSequence(aSN1EncodableVector);
    }
}
