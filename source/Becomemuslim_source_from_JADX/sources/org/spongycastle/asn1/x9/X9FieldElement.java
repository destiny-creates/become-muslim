package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECFieldElement.F2m;
import org.spongycastle.math.ec.ECFieldElement.Fp;

public class X9FieldElement extends ASN1Object {
    /* renamed from: b */
    private static X9IntegerConverter f31541b = new X9IntegerConverter();
    /* renamed from: a */
    protected ECFieldElement f31542a;

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f31542a = eCFieldElement;
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new Fp(bigInteger, new BigInteger(1, aSN1OctetString.mo6859c())));
    }

    public X9FieldElement(int i, int i2, int i3, int i4, ASN1OctetString aSN1OctetString) {
        this(new F2m(i, i2, i3, i4, new BigInteger(1, aSN1OctetString.mo6859c())));
    }

    /* renamed from: a */
    public ECFieldElement m40524a() {
        return this.f31542a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DEROctetString(f31541b.m27276a(this.f31542a.mo6549a(), f31541b.m27275a(this.f31542a)));
    }
}
