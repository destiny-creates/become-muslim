package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;

public class DSTU4145ECBinary extends ASN1Object {
    /* renamed from: a */
    BigInteger f31104a = BigInteger.valueOf(0);
    /* renamed from: b */
    DSTU4145BinaryField f31105b;
    /* renamed from: c */
    ASN1Integer f31106c;
    /* renamed from: d */
    ASN1OctetString f31107d;
    /* renamed from: e */
    ASN1Integer f31108e;
    /* renamed from: f */
    ASN1OctetString f31109f;

    private DSTU4145ECBinary(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence.mo6860a(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.mo6860a(0);
            if (aSN1TaggedObject.m43031c() && aSN1TaggedObject.m43030b() == 0) {
                this.f31104a = ASN1Integer.m42963a(aSN1TaggedObject.mo5711g()).m42968b();
                i = 1;
            } else {
                throw new IllegalArgumentException("object parse error");
            }
        }
        this.f31105b = DSTU4145BinaryField.m40180a(aSN1Sequence.mo6860a(i));
        i++;
        this.f31106c = ASN1Integer.m42963a(aSN1Sequence.mo6860a(i));
        i++;
        this.f31107d = ASN1OctetString.m42990a(aSN1Sequence.mo6860a(i));
        i++;
        this.f31108e = ASN1Integer.m42963a(aSN1Sequence.mo6860a(i));
        this.f31109f = ASN1OctetString.m42990a(aSN1Sequence.mo6860a(i + 1));
    }

    /* renamed from: a */
    public static DSTU4145ECBinary m40186a(Object obj) {
        if (obj instanceof DSTU4145ECBinary) {
            return (DSTU4145ECBinary) obj;
        }
        return obj != null ? new DSTU4145ECBinary(ASN1Sequence.m43000a(obj)) : null;
    }

    /* renamed from: a */
    public DSTU4145BinaryField m40187a() {
        return this.f31105b;
    }

    /* renamed from: b */
    public BigInteger m40188b() {
        return this.f31106c.m42968b();
    }

    /* renamed from: c */
    public byte[] m40189c() {
        return Arrays.m29373b(this.f31107d.mo6859c());
    }

    /* renamed from: d */
    public BigInteger m40190d() {
        return this.f31108e.m42968b();
    }

    /* renamed from: g */
    public byte[] m40192g() {
        return Arrays.m29373b(this.f31109f.mo6859c());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31104a.compareTo(BigInteger.valueOf(0)) != 0) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, new ASN1Integer(this.f31104a)));
        }
        aSN1EncodableVector.m27141a(this.f31105b);
        aSN1EncodableVector.m27141a(this.f31106c);
        aSN1EncodableVector.m27141a(this.f31107d);
        aSN1EncodableVector.m27141a(this.f31108e);
        aSN1EncodableVector.m27141a(this.f31109f);
        return new DERSequence(aSN1EncodableVector);
    }
}
