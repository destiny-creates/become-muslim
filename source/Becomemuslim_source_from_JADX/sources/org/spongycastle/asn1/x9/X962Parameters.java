package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;

public class X962Parameters extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private ASN1Primitive f31537a = null;

    /* renamed from: a */
    public static X962Parameters m40506a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof X962Parameters)) {
                if (obj instanceof ASN1Primitive) {
                    return new X962Parameters((ASN1Primitive) obj);
                }
                if (obj instanceof byte[]) {
                    try {
                        return new X962Parameters(ASN1Primitive.m39798b((byte[]) obj));
                    } catch (Object obj2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unable to parse encoded data: ");
                        stringBuilder.append(obj2.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                throw new IllegalArgumentException("unknown object in getInstance()");
            }
        }
        return (X962Parameters) obj2;
    }

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.f31537a = x9ECParameters.mo5709e();
    }

    public X962Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f31537a = aSN1ObjectIdentifier;
    }

    public X962Parameters(ASN1Null aSN1Null) {
        this.f31537a = aSN1Null;
    }

    public X962Parameters(ASN1Primitive aSN1Primitive) {
        this.f31537a = aSN1Primitive;
    }

    /* renamed from: a */
    public boolean m40507a() {
        return this.f31537a instanceof ASN1ObjectIdentifier;
    }

    /* renamed from: b */
    public boolean m40508b() {
        return this.f31537a instanceof ASN1Null;
    }

    /* renamed from: c */
    public ASN1Primitive m40509c() {
        return this.f31537a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31537a;
    }
}
