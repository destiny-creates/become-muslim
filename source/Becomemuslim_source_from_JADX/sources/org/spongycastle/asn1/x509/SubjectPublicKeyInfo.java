package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class SubjectPublicKeyInfo extends ASN1Object {
    /* renamed from: a */
    private AlgorithmIdentifier f31378a;
    /* renamed from: b */
    private DERBitString f31379b;

    /* renamed from: a */
    public static SubjectPublicKeyInfo m40409a(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        return obj != null ? new SubjectPublicKeyInfo(ASN1Sequence.m43000a(obj)) : null;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Encodable aSN1Encodable) {
        this.f31379b = new DERBitString(aSN1Encodable);
        this.f31378a = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f31379b = new DERBitString(bArr);
        this.f31378a = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 2) {
            aSN1Sequence = aSN1Sequence.mo6861c();
            this.f31378a = AlgorithmIdentifier.m40228a(aSN1Sequence.nextElement());
            this.f31379b = DERBitString.m43051a(aSN1Sequence.nextElement());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad sequence size: ");
        stringBuilder.append(aSN1Sequence.mo6862g());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40410a() {
        return this.f31378a;
    }

    /* renamed from: b */
    public AlgorithmIdentifier m40411b() {
        return this.f31378a;
    }

    /* renamed from: c */
    public ASN1Primitive m40412c() {
        return new ASN1InputStream(this.f31379b.m43059c()).m34595d();
    }

    /* renamed from: d */
    public DERBitString m40413d() {
        return this.f31379b;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31378a);
        aSN1EncodableVector.m27141a(this.f31379b);
        return new DERSequence(aSN1EncodableVector);
    }
}
