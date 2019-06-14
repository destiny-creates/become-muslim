package org.spongycastle.asn1;

public class DERSetParser implements ASN1SetParser {
    /* renamed from: a */
    private ASN1StreamParser f30431a;

    DERSetParser(ASN1StreamParser aSN1StreamParser) {
        this.f30431a = aSN1StreamParser;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return new DERSet(this.f30431a.m27157b(), false);
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
