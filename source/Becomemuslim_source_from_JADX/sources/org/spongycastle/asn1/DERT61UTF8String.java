package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERT61UTF8String extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private byte[] f32510a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: b */
    public String mo6440b() {
        return Strings.m29419a(this.f32510a);
    }

    public String toString() {
        return mo6440b();
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32510a.length) + 1) + this.f32510a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(20, this.f32510a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERT61UTF8String) {
            return Arrays.m29353a(this.f32510a, ((DERT61UTF8String) aSN1Primitive).f32510a);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32510a);
    }
}
