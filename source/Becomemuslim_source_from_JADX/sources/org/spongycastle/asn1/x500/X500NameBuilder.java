package org.spongycastle.asn1.x500;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x500.style.BCStyle;

public class X500NameBuilder {
    /* renamed from: a */
    private X500NameStyle f22015a;
    /* renamed from: b */
    private Vector f22016b;

    public X500NameBuilder() {
        this(BCStyle.f31134K);
    }

    public X500NameBuilder(X500NameStyle x500NameStyle) {
        this.f22016b = new Vector();
        this.f22015a = x500NameStyle;
    }

    /* renamed from: a */
    public X500NameBuilder m27224a(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        m27225a(aSN1ObjectIdentifier, this.f22015a.mo5718a(aSN1ObjectIdentifier, str));
        return this;
    }

    /* renamed from: a */
    public X500NameBuilder m27225a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f22016b.addElement(new RDN(aSN1ObjectIdentifier, aSN1Encodable));
        return this;
    }

    /* renamed from: a */
    public X500NameBuilder m27226a(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, String[] strArr) {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[strArr.length];
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            aSN1EncodableArr[i] = this.f22015a.mo5718a(aSN1ObjectIdentifierArr[i], strArr[i]);
        }
        return m27227a(aSN1ObjectIdentifierArr, aSN1EncodableArr);
    }

    /* renamed from: a */
    public X500NameBuilder m27227a(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, ASN1Encodable[] aSN1EncodableArr) {
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[aSN1ObjectIdentifierArr.length];
        for (int i = 0; i != aSN1ObjectIdentifierArr.length; i++) {
            attributeTypeAndValueArr[i] = new AttributeTypeAndValue(aSN1ObjectIdentifierArr[i], aSN1EncodableArr[i]);
        }
        return m27228a(attributeTypeAndValueArr);
    }

    /* renamed from: a */
    public X500NameBuilder m27228a(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.f22016b.addElement(new RDN(attributeTypeAndValueArr));
        return this;
    }

    /* renamed from: a */
    public X500Name m27223a() {
        RDN[] rdnArr = new RDN[this.f22016b.size()];
        for (int i = 0; i != rdnArr.length; i++) {
            rdnArr[i] = (RDN) this.f22016b.elementAt(i);
        }
        return new X500Name(this.f22015a, rdnArr);
    }
}
