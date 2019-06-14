package org.spongycastle.asn1;

import java.util.Enumeration;

class LazyConstructionEnumeration implements Enumeration {
    /* renamed from: a */
    private ASN1InputStream f21457a;
    /* renamed from: b */
    private Object f21458b = m27163a();

    public LazyConstructionEnumeration(byte[] bArr) {
        this.f21457a = new ASN1InputStream(bArr, true);
    }

    public boolean hasMoreElements() {
        return this.f21458b != null;
    }

    public Object nextElement() {
        Object obj = this.f21458b;
        this.f21458b = m27163a();
        return obj;
    }

    /* renamed from: a */
    private Object m27163a() {
        try {
            return this.f21457a.m34595d();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("malformed DER construction: ");
            stringBuilder.append(e);
            throw new ASN1ParsingException(stringBuilder.toString(), e);
        }
    }
}
