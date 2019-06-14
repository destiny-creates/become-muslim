package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

public class ASN1Enumerated extends ASN1Primitive {
    /* renamed from: b */
    private static ASN1Enumerated[] f32480b = new ASN1Enumerated[12];
    /* renamed from: a */
    private final byte[] f32481a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: a */
    public static ASN1Enumerated m42946a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof ASN1Enumerated)) {
                StringBuilder stringBuilder;
                if (obj instanceof byte[]) {
                    try {
                        return (ASN1Enumerated) ASN1Primitive.m39798b((byte[]) obj);
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
        return (ASN1Enumerated) obj2;
    }

    public ASN1Enumerated(int i) {
        this.f32481a = BigInteger.valueOf((long) i).toByteArray();
    }

    public ASN1Enumerated(byte[] bArr) {
        this.f32481a = bArr;
    }

    /* renamed from: b */
    public BigInteger m42951b() {
        return new BigInteger(this.f32481a);
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32481a.length) + 1) + this.f32481a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(10, this.f32481a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return null;
        }
        return Arrays.m29353a(this.f32481a, ((ASN1Enumerated) aSN1Primitive).f32481a);
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32481a);
    }

    /* renamed from: a */
    static ASN1Enumerated m42947a(byte[] bArr) {
        if (bArr.length > 1) {
            return new ASN1Enumerated(Arrays.m29373b(bArr));
        }
        if (bArr.length != 0) {
            int i = bArr[0] & JfifUtil.MARKER_FIRST_BYTE;
            if (i >= f32480b.length) {
                return new ASN1Enumerated(Arrays.m29373b(bArr));
            }
            ASN1Enumerated aSN1Enumerated = f32480b[i];
            if (aSN1Enumerated == null) {
                ASN1Enumerated[] aSN1EnumeratedArr = f32480b;
                ASN1Enumerated aSN1Enumerated2 = new ASN1Enumerated(Arrays.m29373b(bArr));
                aSN1EnumeratedArr[i] = aSN1Enumerated2;
                aSN1Enumerated = aSN1Enumerated2;
            }
            return aSN1Enumerated;
        }
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }
}
