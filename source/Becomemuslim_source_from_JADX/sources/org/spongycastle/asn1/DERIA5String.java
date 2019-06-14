package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERIA5String extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private final byte[] f32506a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: a */
    public static DERIA5String m43079a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof DERIA5String)) {
                StringBuilder stringBuilder;
                if (obj instanceof byte[]) {
                    try {
                        return (DERIA5String) ASN1Primitive.m39798b((byte[]) obj);
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
        return (DERIA5String) obj2;
    }

    /* renamed from: a */
    public static DERIA5String m43080a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        Object k = aSN1TaggedObject.m43036k();
        if (!z) {
            if (!(k instanceof DERIA5String)) {
                return new DERIA5String(((ASN1OctetString) k).mo6859c());
            }
        }
        return m43079a(k);
    }

    DERIA5String(byte[] bArr) {
        this.f32506a = bArr;
    }

    public DERIA5String(String str) {
        this(str, false);
    }

    public DERIA5String(String str, boolean z) {
        if (str != null) {
            if (z) {
                if (!m43081b(str)) {
                    throw new IllegalArgumentException("string contains illegal characters");
                }
            }
            this.f32506a = Strings.m29429d(str);
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    /* renamed from: b */
    public String mo6440b() {
        return Strings.m29425b(this.f32506a);
    }

    public String toString() {
        return mo6440b();
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32506a.length) + 1) + this.f32506a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(22, this.f32506a);
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32506a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERIA5String)) {
            return null;
        }
        return Arrays.m29353a(this.f32506a, ((DERIA5String) aSN1Primitive).f32506a);
    }

    /* renamed from: b */
    public static boolean m43081b(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > '') {
                return null;
            }
        }
        return true;
    }
}
