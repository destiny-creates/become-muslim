package org.spongycastle.asn1.cryptopro;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class GOST3410PublicKeyAlgParameters extends ASN1Object {
    /* renamed from: a */
    private ASN1ObjectIdentifier f30714a;
    /* renamed from: b */
    private ASN1ObjectIdentifier f30715b;
    /* renamed from: c */
    private ASN1ObjectIdentifier f30716c;

    /* renamed from: a */
    public static GOST3410PublicKeyAlgParameters m39948a(Object obj) {
        if (obj instanceof GOST3410PublicKeyAlgParameters) {
            return (GOST3410PublicKeyAlgParameters) obj;
        }
        return obj != null ? new GOST3410PublicKeyAlgParameters(ASN1Sequence.m43000a(obj)) : null;
    }

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.f30714a = aSN1ObjectIdentifier;
        this.f30715b = aSN1ObjectIdentifier2;
        this.f30716c = null;
    }

    public GOST3410PublicKeyAlgParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, ASN1ObjectIdentifier aSN1ObjectIdentifier3) {
        this.f30714a = aSN1ObjectIdentifier;
        this.f30715b = aSN1ObjectIdentifier2;
        this.f30716c = aSN1ObjectIdentifier3;
    }

    public GOST3410PublicKeyAlgParameters(ASN1Sequence aSN1Sequence) {
        this.f30714a = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(0);
        this.f30715b = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(1);
        if (aSN1Sequence.mo6862g() > 2) {
            this.f30716c = (ASN1ObjectIdentifier) aSN1Sequence.mo6860a(2);
        }
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier m39949a() {
        return this.f30714a;
    }

    /* renamed from: b */
    public ASN1ObjectIdentifier m39950b() {
        return this.f30715b;
    }

    /* renamed from: c */
    public ASN1ObjectIdentifier m39951c() {
        return this.f30716c;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30714a);
        aSN1EncodableVector.m27141a(this.f30715b);
        if (this.f30716c != null) {
            aSN1EncodableVector.m27141a(this.f30716c);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
