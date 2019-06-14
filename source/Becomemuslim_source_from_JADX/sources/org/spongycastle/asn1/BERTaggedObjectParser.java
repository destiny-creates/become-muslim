package org.spongycastle.asn1;

import java.io.IOException;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    /* renamed from: a */
    private boolean f30426a;
    /* renamed from: b */
    private int f30427b;
    /* renamed from: c */
    private ASN1StreamParser f30428c;

    BERTaggedObjectParser(boolean z, int i, ASN1StreamParser aSN1StreamParser) {
        this.f30426a = z;
        this.f30427b = i;
        this.f30428c = aSN1StreamParser;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return this.f30428c.m27156a(this.f30426a, this.f30427b);
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        try {
            return mo5711g();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage());
        }
    }
}
