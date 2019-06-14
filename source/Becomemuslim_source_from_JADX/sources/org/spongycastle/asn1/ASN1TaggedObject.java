package org.spongycastle.asn1;

public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    /* renamed from: a */
    int f32491a;
    /* renamed from: b */
    boolean f32492b = false;
    /* renamed from: c */
    boolean f32493c = true;
    /* renamed from: d */
    ASN1Encodable f32494d = null;

    /* renamed from: a */
    abstract void mo6787a(ASN1OutputStream aSN1OutputStream);

    /* renamed from: a */
    public static ASN1TaggedObject m43027a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return (ASN1TaggedObject) aSN1TaggedObject.m43036k();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    /* renamed from: a */
    public static ASN1TaggedObject m43026a(Object obj) {
        StringBuilder stringBuilder;
        if (obj != null) {
            if (!(obj instanceof ASN1TaggedObject)) {
                if (obj instanceof byte[]) {
                    try {
                        return m43026a(ASN1Primitive.m39798b((byte[]) obj));
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("failed to construct tagged object from byte[]: ");
                        stringBuilder.append(obj2.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("unknown object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1TaggedObject) obj2;
    }

    public ASN1TaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof ASN1Choice) {
            this.f32493c = true;
        } else {
            this.f32493c = z;
        }
        this.f32491a = i;
        if (this.f32493c) {
            this.f32494d = aSN1Encodable;
            return;
        }
        z = aSN1Encodable.mo5709e() instanceof ASN1Set;
        this.f32494d = aSN1Encodable;
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        if (this.f32491a == aSN1TaggedObject.f32491a && this.f32492b == aSN1TaggedObject.f32492b) {
            if (this.f32493c == aSN1TaggedObject.f32493c) {
                if (this.f32494d == null) {
                    if (aSN1TaggedObject.f32494d != null) {
                        return false;
                    }
                } else if (this.f32494d.mo5709e().equals(aSN1TaggedObject.f32494d.mo5709e()) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f32491a;
        return this.f32494d != null ? i ^ this.f32494d.hashCode() : i;
    }

    /* renamed from: b */
    public int m43030b() {
        return this.f32491a;
    }

    /* renamed from: c */
    public boolean m43031c() {
        return this.f32493c;
    }

    /* renamed from: j */
    public boolean m43035j() {
        return this.f32492b;
    }

    /* renamed from: k */
    public ASN1Primitive m43036k() {
        return this.f32494d != null ? this.f32494d.mo5709e() : null;
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return mo5709e();
    }

    /* renamed from: h */
    ASN1Primitive mo6791h() {
        return new DERTaggedObject(this.f32493c, this.f32491a, this.f32494d);
    }

    /* renamed from: i */
    ASN1Primitive mo6792i() {
        return new DLTaggedObject(this.f32493c, this.f32491a, this.f32494d);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.f32491a);
        stringBuilder.append("]");
        stringBuilder.append(this.f32494d);
        return stringBuilder.toString();
    }
}
