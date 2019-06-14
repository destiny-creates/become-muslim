package org.spongycastle.asn1;

public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    /* renamed from: a */
    private final int f30421a;
    /* renamed from: b */
    private final ASN1StreamParser f30422b;

    BERApplicationSpecificParser(int i, ASN1StreamParser aSN1StreamParser) {
        this.f30421a = i;
        this.f30422b = aSN1StreamParser;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return new BERApplicationSpecific(this.f30421a, this.f30422b.m27157b());
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
