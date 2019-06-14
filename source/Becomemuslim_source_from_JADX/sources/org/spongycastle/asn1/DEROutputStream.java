package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class DEROutputStream extends ASN1OutputStream {
    /* renamed from: a */
    ASN1OutputStream mo5712a() {
        return this;
    }

    /* renamed from: b */
    ASN1OutputStream mo5714b() {
        return this;
    }

    public DEROutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* renamed from: a */
    public void mo5713a(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1Encodable.mo5709e().mo6791h().mo6787a((ASN1OutputStream) this);
            return;
        }
        throw new IOException("null object detected");
    }
}
