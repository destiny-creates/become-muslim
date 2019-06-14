package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.PolynomialExtensionField;

public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    private static final BigInteger ap = BigInteger.valueOf(1);
    private X9FieldID aq;
    private ECCurve ar;
    private X9ECPoint as;
    private BigInteger at;
    private BigInteger au;
    private byte[] av;

    private X9ECParameters(ASN1Sequence aSN1Sequence) {
        if ((aSN1Sequence.mo6860a(0) instanceof ASN1Integer) && ((ASN1Integer) aSN1Sequence.mo6860a(0)).m42968b().equals(ap)) {
            X9Curve x9Curve = new X9Curve(X9FieldID.m40526a(aSN1Sequence.mo6860a(1)), ASN1Sequence.m43000a(aSN1Sequence.mo6860a(2)));
            this.ar = x9Curve.m40512a();
            ASN1Encodable a = aSN1Sequence.mo6860a(3);
            if (a instanceof X9ECPoint) {
                this.as = (X9ECPoint) a;
            } else {
                this.as = new X9ECPoint(this.ar, (ASN1OctetString) a);
            }
            this.at = ((ASN1Integer) aSN1Sequence.mo6860a(4)).m42968b();
            this.av = x9Curve.m40513b();
            if (aSN1Sequence.mo6862g() == 6) {
                this.au = ((ASN1Integer) aSN1Sequence.mo6860a(5)).m42968b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("bad version in X9ECParameters");
    }

    /* renamed from: a */
    public static X9ECParameters m40515a(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        return obj != null ? new X9ECParameters(ASN1Sequence.m43000a(obj)) : null;
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, x9ECPoint, bigInteger, bigInteger2, null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this(eCCurve, new X9ECPoint(eCPoint), bigInteger, bigInteger2, bArr);
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.ar = eCCurve;
        this.as = x9ECPoint;
        this.at = bigInteger;
        this.au = bigInteger2;
        this.av = bArr;
        if (ECAlgorithms.m28354b(eCCurve) != null) {
            this.aq = new X9FieldID(eCCurve.m28382f().mo5911a());
        } else if (ECAlgorithms.m28351a(eCCurve) != null) {
            eCCurve = ((PolynomialExtensionField) eCCurve.m28382f()).mo6823c().mo5910b();
            if (eCCurve.length == 3) {
                this.aq = new X9FieldID(eCCurve[2], eCCurve[1]);
            } else if (eCCurve.length == 5) {
                this.aq = new X9FieldID(eCCurve[4], eCCurve[1], eCCurve[2], eCCurve[3]);
            } else {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }

    /* renamed from: a */
    public ECCurve m40516a() {
        return this.ar;
    }

    /* renamed from: b */
    public ECPoint m40517b() {
        return this.as.m40522a();
    }

    /* renamed from: c */
    public BigInteger m40518c() {
        return this.at;
    }

    /* renamed from: d */
    public BigInteger m40519d() {
        return this.au;
    }

    /* renamed from: g */
    public byte[] m40521g() {
        return this.av;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new ASN1Integer(ap));
        aSN1EncodableVector.m27141a(this.aq);
        aSN1EncodableVector.m27141a(new X9Curve(this.ar, this.av));
        aSN1EncodableVector.m27141a(this.as);
        aSN1EncodableVector.m27141a(new ASN1Integer(this.at));
        if (this.au != null) {
            aSN1EncodableVector.m27141a(new ASN1Integer(this.au));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
