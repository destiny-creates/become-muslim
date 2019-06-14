package org.spongycastle.asn1;

public abstract class ASN1Null extends ASN1Primitive {
    /* renamed from: a */
    abstract void mo6787a(ASN1OutputStream aSN1OutputStream);

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Null) == null ? null : true;
    }
}
