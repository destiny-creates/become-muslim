package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Arrays;

public class ASN1Boolean extends ASN1Primitive {
    /* renamed from: a */
    public static final ASN1Boolean f32475a = new ASN1Boolean(false);
    /* renamed from: b */
    public static final ASN1Boolean f32476b = new ASN1Boolean(true);
    /* renamed from: c */
    private static final byte[] f32477c = new byte[]{(byte) -1};
    /* renamed from: d */
    private static final byte[] f32478d = new byte[]{(byte) 0};
    /* renamed from: e */
    private final byte[] f32479e;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: d */
    int mo6790d() {
        return 3;
    }

    /* renamed from: a */
    public static ASN1Boolean m42937a(Object obj) {
        StringBuilder stringBuilder;
        if (obj != null) {
            if (!(obj instanceof ASN1Boolean)) {
                if (obj instanceof byte[]) {
                    try {
                        return (ASN1Boolean) ASN1Primitive.m39798b((byte[]) obj);
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("failed to construct boolean from byte[]: ");
                        stringBuilder.append(obj2.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1Boolean) obj2;
    }

    /* renamed from: a */
    public static ASN1Boolean m42939a(boolean z) {
        return z ? f32476b : f32475a;
    }

    /* renamed from: a */
    public static ASN1Boolean m42938a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        Object k = aSN1TaggedObject.m43036k();
        if (!z) {
            if (!(k instanceof ASN1Boolean)) {
                return m42940a(((ASN1OctetString) k).mo6859c());
            }
        }
        return m42937a(k);
    }

    ASN1Boolean(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else if (bArr[0] == (byte) 0) {
            this.f32479e = f32478d;
        } else if ((bArr[0] & JfifUtil.MARKER_FIRST_BYTE) == JfifUtil.MARKER_FIRST_BYTE) {
            this.f32479e = f32477c;
        } else {
            this.f32479e = Arrays.m29373b(bArr);
        }
    }

    public ASN1Boolean(boolean z) {
        this.f32479e = z ? f32477c : f32478d;
    }

    /* renamed from: b */
    public boolean m42944b() {
        return this.f32479e[0] != (byte) 0;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(1, this.f32479e);
    }

    /* renamed from: a */
    protected boolean mo6789a(ASN1Primitive aSN1Primitive) {
        boolean z = false;
        if (!(aSN1Primitive instanceof ASN1Boolean)) {
            return false;
        }
        if (this.f32479e[0] == ((ASN1Boolean) aSN1Primitive).f32479e[0]) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f32479e[0];
    }

    public String toString() {
        return this.f32479e[0] != (byte) 0 ? "TRUE" : "FALSE";
    }

    /* renamed from: a */
    static ASN1Boolean m42940a(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        } else if (bArr[0] == (byte) 0) {
            return f32475a;
        } else {
            if ((bArr[0] & JfifUtil.MARKER_FIRST_BYTE) == JfifUtil.MARKER_FIRST_BYTE) {
                return f32476b;
            }
            return new ASN1Boolean(bArr);
        }
    }
}
