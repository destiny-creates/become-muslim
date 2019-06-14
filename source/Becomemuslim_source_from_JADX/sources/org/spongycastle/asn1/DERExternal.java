package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;

public class DERExternal extends ASN1Primitive {
    /* renamed from: a */
    private ASN1ObjectIdentifier f32500a;
    /* renamed from: b */
    private ASN1Integer f32501b;
    /* renamed from: c */
    private ASN1Primitive f32502c;
    /* renamed from: d */
    private int f32503d;
    /* renamed from: e */
    private ASN1Primitive f32504e;

    /* renamed from: a */
    boolean mo6788a() {
        return true;
    }

    public DERExternal(ASN1EncodableVector aSN1EncodableVector) {
        int i = 0;
        ASN1Primitive a = m43063a(aSN1EncodableVector, 0);
        if (a instanceof ASN1ObjectIdentifier) {
            this.f32500a = (ASN1ObjectIdentifier) a;
            a = m43063a(aSN1EncodableVector, 1);
            i = 1;
        }
        if (a instanceof ASN1Integer) {
            this.f32501b = (ASN1Integer) a;
            i++;
            a = m43063a(aSN1EncodableVector, i);
        }
        if (!(a instanceof DERTaggedObject)) {
            this.f32502c = a;
            i++;
            a = m43063a(aSN1EncodableVector, i);
        }
        if (aSN1EncodableVector.m27139a() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if ((a instanceof DERTaggedObject) != null) {
            DERTaggedObject dERTaggedObject = (DERTaggedObject) a;
            m43064a(dERTaggedObject.m43030b());
            this.f32504e = dERTaggedObject.m43036k();
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    /* renamed from: a */
    private ASN1Primitive m43063a(ASN1EncodableVector aSN1EncodableVector, int i) {
        if (aSN1EncodableVector.m27139a() > i) {
            return aSN1EncodableVector.m27140a(i).mo5709e();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    public int hashCode() {
        int hashCode = this.f32500a != null ? this.f32500a.hashCode() : 0;
        if (this.f32501b != null) {
            hashCode ^= this.f32501b.hashCode();
        }
        if (this.f32502c != null) {
            hashCode ^= this.f32502c.hashCode();
        }
        return hashCode ^ this.f32504e.hashCode();
    }

    /* renamed from: d */
    int mo6790d() {
        return mo6822f().length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f32500a != null) {
            byteArrayOutputStream.write(this.f32500a.m34596a("DER"));
        }
        if (this.f32501b != null) {
            byteArrayOutputStream.write(this.f32501b.m34596a("DER"));
        }
        if (this.f32502c != null) {
            byteArrayOutputStream.write(this.f32502c.m34596a("DER"));
        }
        byteArrayOutputStream.write(new DERTaggedObject(true, this.f32503d, this.f32504e).m34596a("DER"));
        aSN1OutputStream.m27145a(32, 8, byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERExternal)) {
            return false;
        }
        if (this == aSN1Primitive) {
            return true;
        }
        DERExternal dERExternal = (DERExternal) aSN1Primitive;
        if (this.f32500a != null && (dERExternal.f32500a == null || !dERExternal.f32500a.equals(this.f32500a))) {
            return false;
        }
        if (this.f32501b != null && (dERExternal.f32501b == null || !dERExternal.f32501b.equals(this.f32501b))) {
            return false;
        }
        if (this.f32502c == null || (dERExternal.f32502c != null && dERExternal.f32502c.equals(this.f32502c))) {
            return this.f32504e.equals(dERExternal.f32504e);
        }
        return false;
    }

    /* renamed from: b */
    public ASN1Primitive m43068b() {
        return this.f32502c;
    }

    /* renamed from: c */
    public ASN1ObjectIdentifier m43069c() {
        return this.f32500a;
    }

    /* renamed from: g */
    public int m43071g() {
        return this.f32503d;
    }

    /* renamed from: j */
    public ASN1Primitive m43072j() {
        return this.f32504e;
    }

    /* renamed from: k */
    public ASN1Integer m43073k() {
        return this.f32501b;
    }

    /* renamed from: a */
    private void m43064a(int i) {
        if (i < 0 || i > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid encoding value: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f32503d = i;
    }
}
