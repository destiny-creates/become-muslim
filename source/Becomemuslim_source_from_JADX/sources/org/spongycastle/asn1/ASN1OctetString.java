package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    /* renamed from: a */
    byte[] f32487a;

    /* renamed from: a */
    abstract void mo6787a(ASN1OutputStream aSN1OutputStream);

    /* renamed from: a */
    public static ASN1OctetString m42991a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        Object k = aSN1TaggedObject.m43036k();
        if (!z) {
            if (!(k instanceof ASN1OctetString)) {
                return BEROctetString.m44358a(ASN1Sequence.m43000a(k));
            }
        }
        return m42990a(k);
    }

    /* renamed from: a */
    public static ASN1OctetString m42990a(Object obj) {
        StringBuilder stringBuilder;
        if (obj != null) {
            if (!(obj instanceof ASN1OctetString)) {
                if (obj instanceof byte[]) {
                    try {
                        return m42990a(ASN1Primitive.m39798b((byte[]) obj));
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("failed to construct OCTET STRING from byte[]: ");
                        stringBuilder.append(obj2.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                if (obj2 instanceof ASN1Encodable) {
                    ASN1Primitive e = ((ASN1Encodable) obj2).mo5709e();
                    if (e instanceof ASN1OctetString) {
                        return (ASN1OctetString) e;
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1OctetString) obj2;
    }

    public ASN1OctetString(byte[] bArr) {
        if (bArr != null) {
            this.f32487a = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    /* renamed from: b */
    public InputStream mo6439b() {
        return new ByteArrayInputStream(this.f32487a);
    }

    /* renamed from: c */
    public byte[] mo6859c() {
        return this.f32487a;
    }

    public int hashCode() {
        return Arrays.m29342a(mo6859c());
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return null;
        }
        return Arrays.m29353a(this.f32487a, ((ASN1OctetString) aSN1Primitive).f32487a);
    }

    /* renamed from: g */
    public ASN1Primitive mo5711g() {
        return mo5709e();
    }

    /* renamed from: h */
    ASN1Primitive mo6791h() {
        return new DEROctetString(this.f32487a);
    }

    /* renamed from: i */
    ASN1Primitive mo6792i() {
        return new DEROctetString(this.f32487a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(new String(Hex.m29437a(this.f32487a)));
        return stringBuilder.toString();
    }
}
