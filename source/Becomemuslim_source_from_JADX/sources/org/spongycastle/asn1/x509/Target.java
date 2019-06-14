package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

public class Target extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    private GeneralName f31401a;
    /* renamed from: b */
    private GeneralName f31402b;

    /* renamed from: a */
    public static Target m40447a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof Target)) {
                if (obj instanceof ASN1TaggedObject) {
                    return new Target((ASN1TaggedObject) obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown object in factory: ");
                stringBuilder.append(obj.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (Target) obj;
    }

    private Target(ASN1TaggedObject aSN1TaggedObject) {
        switch (aSN1TaggedObject.m43030b()) {
            case 0:
                this.f31401a = GeneralName.m40336a(aSN1TaggedObject, true);
                return;
            case 1:
                this.f31402b = GeneralName.m40336a(aSN1TaggedObject, true);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown tag: ");
                stringBuilder.append(aSN1TaggedObject.m43030b());
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public GeneralName m40448a() {
        return this.f31402b;
    }

    /* renamed from: b */
    public GeneralName m40449b() {
        return this.f31401a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f31401a != null) {
            return new DERTaggedObject(true, 0, this.f31401a);
        }
        return new DERTaggedObject(true, 1, this.f31402b);
    }
}
