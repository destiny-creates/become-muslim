package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class CCMParameters extends ASN1Object {
    /* renamed from: a */
    private byte[] f30546a;
    /* renamed from: b */
    private int f30547b;

    /* renamed from: a */
    public static CCMParameters m39873a(Object obj) {
        if (obj instanceof CCMParameters) {
            return (CCMParameters) obj;
        }
        return obj != null ? new CCMParameters(ASN1Sequence.m43000a(obj)) : null;
    }

    private CCMParameters(ASN1Sequence aSN1Sequence) {
        this.f30546a = ASN1OctetString.m42990a(aSN1Sequence.mo6860a(0)).mo6859c();
        if (aSN1Sequence.mo6862g() == 2) {
            this.f30547b = ASN1Integer.m42963a(aSN1Sequence.mo6860a(1)).m42968b().intValue();
        } else {
            this.f30547b = 12;
        }
    }

    public CCMParameters(byte[] bArr, int i) {
        this.f30546a = Arrays.m29373b(bArr);
        this.f30547b = i;
    }

    /* renamed from: a */
    public byte[] m39874a() {
        return Arrays.m29373b(this.f30546a);
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(new DEROctetString(this.f30546a));
        if (this.f30547b != 12) {
            aSN1EncodableVector.m27141a(new ASN1Integer((long) this.f30547b));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
