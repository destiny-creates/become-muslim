package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.F2m;
import org.spongycastle.math.ec.ECCurve.Fp;

public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    private ECCurve ap;
    private byte[] aq;
    private ASN1ObjectIdentifier ar = null;

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.ap = eCCurve;
        this.aq = bArr;
        m40511c();
    }

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        this.ar = x9FieldID.m40527a();
        if (this.ar.equals(c)) {
            x9FieldID = ((ASN1Integer) x9FieldID.m40528b()).m42968b();
            this.ap = new Fp(x9FieldID, new X9FieldElement(x9FieldID, (ASN1OctetString) aSN1Sequence.mo6860a(0)).m40524a().mo6549a(), new X9FieldElement(x9FieldID, (ASN1OctetString) aSN1Sequence.mo6860a(1)).m40524a().mo6549a());
        } else if (this.ar.equals(d)) {
            int i;
            X9FieldID x9FieldID2;
            int intValue;
            x9FieldID = ASN1Sequence.m43000a(x9FieldID.m40528b());
            int intValue2 = ((ASN1Integer) x9FieldID.mo6860a(0)).m42968b().intValue();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x9FieldID.mo6860a(1);
            if (aSN1ObjectIdentifier.equals(f)) {
                x9FieldID = ASN1Integer.m42963a(x9FieldID.mo6860a(2)).m42968b().intValue();
                i = 0;
                x9FieldID2 = null;
            } else if (aSN1ObjectIdentifier.equals(g)) {
                x9FieldID = ASN1Sequence.m43000a(x9FieldID.mo6860a(2));
                int intValue3 = ASN1Integer.m42963a(x9FieldID.mo6860a(0)).m42968b().intValue();
                intValue = ASN1Integer.m42963a(x9FieldID.mo6860a(1)).m42968b().intValue();
                x9FieldID2 = ASN1Integer.m42963a(x9FieldID.mo6860a(2)).m42968b().intValue();
                x9FieldID = intValue3;
                i = intValue;
            } else {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            intValue = intValue2;
            int i2 = x9FieldID;
            int i3 = i;
            int i4 = x9FieldID2;
            this.ap = new F2m(intValue, i2, i3, i4, new X9FieldElement(intValue, i2, i3, i4, (ASN1OctetString) aSN1Sequence.mo6860a(0)).m40524a().mo6549a(), new X9FieldElement(intValue, i2, i3, i4, (ASN1OctetString) aSN1Sequence.mo6860a(1)).m40524a().mo6549a());
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        if (aSN1Sequence.mo6862g() == 3) {
            this.aq = ((DERBitString) aSN1Sequence.mo6860a(2)).m43059c();
        }
    }

    /* renamed from: c */
    private void m40511c() {
        if (ECAlgorithms.m28354b(this.ap)) {
            this.ar = c;
        } else if (ECAlgorithms.m28351a(this.ap)) {
            this.ar = d;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    /* renamed from: a */
    public ECCurve m40512a() {
        return this.ap;
    }

    /* renamed from: b */
    public byte[] m40513b() {
        return this.aq;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.ar.equals(c)) {
            aSN1EncodableVector.m27141a(new X9FieldElement(this.ap.m28383g()).mo5709e());
            aSN1EncodableVector.m27141a(new X9FieldElement(this.ap.m28384h()).mo5709e());
        } else if (this.ar.equals(d)) {
            aSN1EncodableVector.m27141a(new X9FieldElement(this.ap.m28383g()).mo5709e());
            aSN1EncodableVector.m27141a(new X9FieldElement(this.ap.m28384h()).mo5709e());
        }
        if (this.aq != null) {
            aSN1EncodableVector.m27141a(new DERBitString(this.aq));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
