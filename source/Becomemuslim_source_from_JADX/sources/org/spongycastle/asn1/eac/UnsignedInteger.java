package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;

public class UnsignedInteger extends ASN1Object {
    /* renamed from: a */
    private int f30787a;
    /* renamed from: b */
    private BigInteger f30788b;

    public UnsignedInteger(int i, BigInteger bigInteger) {
        this.f30787a = i;
        this.f30788b = bigInteger;
    }

    /* renamed from: a */
    private byte[] m39971a() {
        Object toByteArray = this.f30788b.toByteArray();
        if (toByteArray[0] != (byte) 0) {
            return toByteArray;
        }
        Object obj = new byte[(toByteArray.length - 1)];
        System.arraycopy(toByteArray, 1, obj, 0, obj.length);
        return obj;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return new DERTaggedObject(false, this.f30787a, new DEROctetString(m39971a()));
    }
}
