package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERUTF8String extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private final byte[] f32511a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    DERUTF8String(byte[] bArr) {
        this.f32511a = bArr;
    }

    public DERUTF8String(String str) {
        this.f32511a = Strings.m29421a(str);
    }

    /* renamed from: b */
    public String mo6440b() {
        return Strings.m29419a(this.f32511a);
    }

    public String toString() {
        return mo6440b();
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32511a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTF8String)) {
            return null;
        }
        return Arrays.m29353a(this.f32511a, ((DERUTF8String) aSN1Primitive).f32511a);
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32511a.length) + 1) + this.f32511a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(12, this.f32511a);
    }
}
