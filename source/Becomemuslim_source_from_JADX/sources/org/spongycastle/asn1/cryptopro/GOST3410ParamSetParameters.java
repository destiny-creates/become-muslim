package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class GOST3410ParamSetParameters extends ASN1Object {
    /* renamed from: a */
    int f30710a;
    /* renamed from: b */
    ASN1Integer f30711b;
    /* renamed from: c */
    ASN1Integer f30712c;
    /* renamed from: d */
    ASN1Integer f30713d;

    public GOST3410ParamSetParameters(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f30710a = i;
        this.f30711b = new ASN1Integer(bigInteger);
        this.f30712c = new ASN1Integer(bigInteger2);
        this.f30713d = new ASN1Integer(bigInteger3);
    }

    /* renamed from: a */
    public BigInteger m39944a() {
        return this.f30711b.m42969c();
    }

    /* renamed from: b */
    public BigInteger m39945b() {
        return this.f30712c.m42969c();
    }

    /* renamed from: c */
    public BigInteger m39946c() {
        return this.f30713d.m42969c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f30710a));
        aSN1EncodableVector.m27141a(this.f30711b);
        aSN1EncodableVector.m27141a(this.f30712c);
        aSN1EncodableVector.m27141a(this.f30713d);
        return new DERSequence(aSN1EncodableVector);
    }
}
