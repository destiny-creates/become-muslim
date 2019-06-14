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

public class RC2CBCParameter extends ASN1Object {
    /* renamed from: a */
    ASN1Integer f31004a;
    /* renamed from: b */
    ASN1OctetString f31005b;

    /* renamed from: a */
    public static RC2CBCParameter m40116a(Object obj) {
        if (obj instanceof RC2CBCParameter) {
            return (RC2CBCParameter) obj;
        }
        return obj != null ? new RC2CBCParameter(ASN1Sequence.m43000a(obj)) : null;
    }

    public RC2CBCParameter(byte[] bArr) {
        this.f31004a = null;
        this.f31005b = new DEROctetString(bArr);
    }

    public RC2CBCParameter(int i, byte[] bArr) {
        this.f31004a = new ASN1Integer((long) i);
        this.f31005b = new DEROctetString(bArr);
    }

    private RC2CBCParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo6862g() == 1) {
            this.f31004a = null;
            this.f31005b = (ASN1OctetString) aSN1Sequence.mo6860a(0);
            return;
        }
        this.f31004a = (ASN1Integer) aSN1Sequence.mo6860a(0);
        this.f31005b = (ASN1OctetString) aSN1Sequence.mo6860a(1);
    }

    /* renamed from: a */
    public BigInteger m40117a() {
        if (this.f31004a == null) {
            return null;
        }
        return this.f31004a.m42968b();
    }

    /* renamed from: b */
    public byte[] m40118b() {
        return this.f31005b.mo6859c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.f31004a != null) {
            aSN1EncodableVector.m27141a(this.f31004a);
        }
        aSN1EncodableVector.m27141a(this.f31005b);
        return new DERSequence(aSN1EncodableVector);
    }
}
