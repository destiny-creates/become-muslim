package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class X9ECPoint extends ASN1Object {
    /* renamed from: a */
    private final ASN1OctetString f31538a;
    /* renamed from: b */
    private ECCurve f31539b;
    /* renamed from: c */
    private ECPoint f31540c;

    public X9ECPoint(ECPoint eCPoint) {
        this(eCPoint, false);
    }

    public X9ECPoint(ECPoint eCPoint, boolean z) {
        this.f31540c = eCPoint.m28418p();
        this.f31538a = new DEROctetString(eCPoint.m28398a(z));
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.f31539b = eCCurve;
        this.f31538a = new DEROctetString(Arrays.m29373b(bArr));
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.mo6859c());
    }

    /* renamed from: a */
    public ECPoint m40522a() {
        if (this.f31540c == null) {
            this.f31540c = this.f31539b.m28367a(this.f31538a.mo6859c()).m28418p();
        }
        return this.f31540c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31538a;
    }
}
