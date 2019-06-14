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
import org.spongycastle.asn1.x509.DigestInfo;

public class MacData extends ASN1Object {
    /* renamed from: d */
    private static final BigInteger f30988d = BigInteger.valueOf(1);
    /* renamed from: a */
    DigestInfo f30989a;
    /* renamed from: b */
    byte[] f30990b;
    /* renamed from: c */
    BigInteger f30991c;

    /* renamed from: a */
    public static MacData m40087a(Object obj) {
        if (obj instanceof MacData) {
            return (MacData) obj;
        }
        return obj != null ? new MacData(ASN1Sequence.m43000a(obj)) : null;
    }

    private MacData(ASN1Sequence aSN1Sequence) {
        this.f30989a = DigestInfo.m40305a(aSN1Sequence.mo6860a(0));
        this.f30990b = ((ASN1OctetString) aSN1Sequence.mo6860a(1)).mo6859c();
        if (aSN1Sequence.mo6862g() == 3) {
            this.f30991c = ((ASN1Integer) aSN1Sequence.mo6860a(2)).m42968b();
        } else {
            this.f30991c = f30988d;
        }
    }

    public MacData(DigestInfo digestInfo, byte[] bArr, int i) {
        this.f30989a = digestInfo;
        this.f30990b = bArr;
        this.f30991c = BigInteger.valueOf((long) i);
    }

    /* renamed from: a */
    public DigestInfo m40088a() {
        return this.f30989a;
    }

    /* renamed from: b */
    public byte[] m40089b() {
        return this.f30990b;
    }

    /* renamed from: c */
    public BigInteger m40090c() {
        return this.f30991c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30989a);
        aSN1EncodableVector.m27141a(new DEROctetString(this.f30990b));
        if (!this.f30991c.equals(f30988d)) {
            aSN1EncodableVector.m27141a(new ASN1Integer(this.f30991c));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
