package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERPrintableString extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private final byte[] f32508a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    DERPrintableString(byte[] bArr) {
        this.f32508a = bArr;
    }

    public DERPrintableString(String str) {
        this(str, false);
    }

    public DERPrintableString(String str, boolean z) {
        if (z) {
            if (!m43092b(str)) {
                throw new IllegalArgumentException("string contains illegal characters");
            }
        }
        this.f32508a = Strings.m29429d(str);
    }

    /* renamed from: b */
    public String mo6440b() {
        return Strings.m29425b(this.f32508a);
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32508a.length) + 1) + this.f32508a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(19, this.f32508a);
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32508a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERPrintableString)) {
            return null;
        }
        return Arrays.m29353a(this.f32508a, ((DERPrintableString) aSN1Primitive).f32508a);
    }

    public String toString() {
        return mo6440b();
    }

    /* renamed from: b */
    public static boolean m43092b(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt > '') {
                return false;
            }
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' > charAt || charAt > '9') {
                        if (!(charAt == ' ' || charAt == ':' || charAt == '=' || charAt == '?')) {
                            switch (charAt) {
                                case '\'':
                                case '(':
                                case ')':
                                    continue;
                                default:
                                    switch (charAt) {
                                        case '+':
                                        case ',':
                                        case '-':
                                        case '.':
                                        case '/':
                                            break;
                                        default:
                                            return false;
                                    }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
