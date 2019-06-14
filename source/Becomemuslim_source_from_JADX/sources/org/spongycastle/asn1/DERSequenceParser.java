package org.spongycastle.asn1;

import java.io.IOException;

public class DERSequenceParser implements ASN1SequenceParser {
    /* renamed from: a */
    private ASN1StreamParser f30430a;

    DERSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this.f30430a = aSN1StreamParser;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return new DERSequence(this.f30430a.m27157b());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        try {
            return mo5711g();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
