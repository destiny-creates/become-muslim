package org.spongycastle.jce.interfaces;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface PKCS12BagAttributeCarrier {
    /* renamed from: a */
    Enumeration mo5849a();

    /* renamed from: a */
    ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    /* renamed from: a */
    void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable);
}
