package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.spongycastle.util.Encodable;

public abstract class ASN1Object implements ASN1Encodable, Encodable {
    /* renamed from: e */
    public abstract ASN1Primitive mo5709e();

    /* renamed from: f */
    public byte[] mo6822f() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).mo5713a((ASN1Encodable) this);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public byte[] m34596a(String str) {
        if (str.equals("DER")) {
            str = new ByteArrayOutputStream();
            new DEROutputStream(str).mo5713a(this);
            return str.toByteArray();
        } else if (str.equals("DL") == null) {
            return mo6822f();
        } else {
            str = new ByteArrayOutputStream();
            new DLOutputStream(str).mo5713a(this);
            return str.toByteArray();
        }
    }

    public int hashCode() {
        return mo5709e().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ASN1Encodable)) {
            return null;
        }
        return mo5709e().equals(((ASN1Encodable) obj).mo5709e());
    }
}
