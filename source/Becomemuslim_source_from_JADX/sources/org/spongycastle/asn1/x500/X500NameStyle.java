package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface X500NameStyle {
    /* renamed from: a */
    int mo5717a(X500Name x500Name);

    /* renamed from: a */
    ASN1Encodable mo5718a(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str);

    /* renamed from: a */
    ASN1ObjectIdentifier mo6441a(String str);

    /* renamed from: a */
    boolean mo5719a(X500Name x500Name, X500Name x500Name2);

    /* renamed from: b */
    String mo6442b(X500Name x500Name);

    /* renamed from: b */
    RDN[] mo6444b(String str);
}
