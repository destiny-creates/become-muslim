package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class DigestInfo extends ASN1Object {
    /* renamed from: a */
    private byte[] f31263a;
    /* renamed from: b */
    private AlgorithmIdentifier f31264b;

    /* renamed from: a */
    public static DigestInfo m40305a(Object obj) {
        if (obj instanceof DigestInfo) {
            return (DigestInfo) obj;
        }
        return obj != null ? new DigestInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    public DigestInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f31263a = bArr;
        this.f31264b = algorithmIdentifier;
    }

    public DigestInfo(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.f31264b = AlgorithmIdentifier.m40228a(aSN1Sequence.nextElement());
        this.f31263a = ASN1OctetString.m42990a(aSN1Sequence.nextElement()).mo6859c();
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40306a() {
        return this.f31264b;
    }

    /* renamed from: b */
    public byte[] m40307b() {
        return this.f31263a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31264b);
        aSN1EncodableVector.m27141a(new DEROctetString(this.f31263a));
        return new DERSequence(aSN1EncodableVector);
    }
}
