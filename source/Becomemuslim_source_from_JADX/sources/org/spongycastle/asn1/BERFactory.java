package org.spongycastle.asn1;

class BERFactory {
    /* renamed from: a */
    static final BERSequence f21444a = new BERSequence();
    /* renamed from: b */
    static final BERSet f21445b = new BERSet();

    BERFactory() {
    }

    /* renamed from: a */
    static BERSequence m27159a(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.m27139a() < 1 ? f21444a : new BERSequence(aSN1EncodableVector);
    }
}
