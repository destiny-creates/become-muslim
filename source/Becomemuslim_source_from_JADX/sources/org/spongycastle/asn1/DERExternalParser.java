package org.spongycastle.asn1;

public class DERExternalParser implements ASN1Encodable, InMemoryRepresentable {
    /* renamed from: a */
    private ASN1StreamParser f26452a;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this.f26452a = aSN1StreamParser;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        try {
            return new DERExternal(this.f26452a.m27157b());
        } catch (Throwable e) {
            throw new ASN1Exception(e.getMessage(), e);
        }
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        try {
            return mo5711g();
        } catch (Throwable e) {
            throw new ASN1ParsingException("unable to get DER object", e);
        } catch (Throwable e2) {
            throw new ASN1ParsingException("unable to get DER object", e2);
        }
    }
}
