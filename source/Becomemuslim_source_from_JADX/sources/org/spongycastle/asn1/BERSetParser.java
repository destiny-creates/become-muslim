package org.spongycastle.asn1;

public class BERSetParser implements ASN1SetParser {
    /* renamed from: a */
    private ASN1StreamParser f30425a;

    BERSetParser(ASN1StreamParser aSN1StreamParser) {
        this.f30425a = aSN1StreamParser;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return new BERSet(this.f30425a.m27157b());
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        try {
            return mo5711g();
        } catch (Throwable e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
