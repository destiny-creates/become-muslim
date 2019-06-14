package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class DHPublicKey extends ASN1Object {
    /* renamed from: a */
    private ASN1Integer f31522a;

    /* renamed from: a */
    public static DHPublicKey m40488a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof DHPublicKey)) {
                if (obj instanceof ASN1Integer) {
                    return new DHPublicKey((ASN1Integer) obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid DHPublicKey: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (DHPublicKey) obj;
    }

    private DHPublicKey(ASN1Integer aSN1Integer) {
        if (aSN1Integer != null) {
            this.f31522a = aSN1Integer;
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    /* renamed from: a */
    public BigInteger m40489a() {
        return this.f31522a.m42969c();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31522a;
    }
}
