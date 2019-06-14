package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

public class ASN1Integer extends ASN1Primitive {
    /* renamed from: a */
    private final byte[] f32483a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: a */
    public static ASN1Integer m42963a(Object obj) {
        StringBuilder stringBuilder;
        if (obj != null) {
            if (!(obj instanceof ASN1Integer)) {
                if (obj instanceof byte[]) {
                    try {
                        return (ASN1Integer) ASN1Primitive.m39798b((byte[]) obj);
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("encoding error in getInstance: ");
                        stringBuilder.append(obj2.toString());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1Integer) obj2;
    }

    /* renamed from: a */
    public static ASN1Integer m42964a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        Object k = aSN1TaggedObject.m43036k();
        if (!z) {
            if (!(k instanceof ASN1Integer)) {
                return new ASN1Integer(ASN1OctetString.m42990a(aSN1TaggedObject.m43036k()).mo6859c());
            }
        }
        return m42963a(k);
    }

    public ASN1Integer(long j) {
        this.f32483a = BigInteger.valueOf(j).toByteArray();
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.f32483a = bigInteger.toByteArray();
    }

    public ASN1Integer(byte[] bArr) {
        this(bArr, true);
    }

    ASN1Integer(byte[] bArr, boolean z) {
        if (z) {
            bArr = Arrays.m29373b(bArr);
        }
        this.f32483a = bArr;
    }

    /* renamed from: b */
    public BigInteger m42968b() {
        return new BigInteger(this.f32483a);
    }

    /* renamed from: c */
    public BigInteger m42969c() {
        return new BigInteger(1, this.f32483a);
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32483a.length) + 1) + this.f32483a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(2, this.f32483a);
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 != this.f32483a.length; i2++) {
            i ^= (this.f32483a[i2] & JfifUtil.MARKER_FIRST_BYTE) << (i2 % 4);
        }
        return i;
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return null;
        }
        return Arrays.m29353a(this.f32483a, ((ASN1Integer) aSN1Primitive).f32483a);
    }

    public String toString() {
        return m42968b().toString();
    }
}
