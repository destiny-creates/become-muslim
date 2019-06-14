package org.spongycastle.asn1;

import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class BEROctetStringParser implements ASN1OctetStringParser {
    /* renamed from: a */
    private ASN1StreamParser f30423a;

    BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this.f30423a = aSN1StreamParser;
    }

    /* renamed from: b */
    public InputStream mo6439b() {
        return new ConstructedOctetStream(this.f30423a);
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return new BEROctetString(Streams.m29442a(mo6439b()));
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        try {
            return mo5711g();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IOException converting stream to byte array: ");
            stringBuilder.append(e.getMessage());
            throw new ASN1ParsingException(stringBuilder.toString(), e);
        }
    }
}
