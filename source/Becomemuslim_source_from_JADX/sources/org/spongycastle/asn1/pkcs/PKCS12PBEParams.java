package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class PKCS12PBEParams extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f30999a;
    /* renamed from: b */
    ASN1OctetString f31000b;

    public PKCS12PBEParams(byte[] bArr, int i) {
        this.f31000b = new DEROctetString(bArr);
        this.f30999a = new ASN1Integer((long) i);
    }

    private PKCS12PBEParams(ASN1Sequence aSN1Sequence) {
        this.f31000b = (ASN1OctetString) aSN1Sequence.mo6860a(0);
        this.f30999a = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1));
    }

    /* renamed from: a */
    public static PKCS12PBEParams m40103a(Object obj) {
        if (obj instanceof PKCS12PBEParams) {
            return (PKCS12PBEParams) obj;
        }
        return obj != null ? new PKCS12PBEParams(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public BigInteger m40104a() {
        return this.f30999a.m42968b();
    }

    /* renamed from: b */
    public byte[] m40105b() {
        return this.f31000b.mo6859c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f31000b);
        aSN1EncodableVector.m27141a(this.f30999a);
        return new DERSequence(aSN1EncodableVector);
    }
}
