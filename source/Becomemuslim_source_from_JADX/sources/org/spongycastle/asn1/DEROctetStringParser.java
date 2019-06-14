package org.spongycastle.asn1;

import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
    /* renamed from: a */
    private DefiniteLengthInputStream f30429a;

    DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.f30429a = definiteLengthInputStream;
    }

    /* renamed from: b */
    public InputStream mo6439b() {
        return this.f30429a;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return new DEROctetString(this.f30429a.m34609b());
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
