package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class DERVisibleString extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private final byte[] f32514a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    DERVisibleString(byte[] bArr) {
        this.f32514a = bArr;
    }

    /* renamed from: b */
    public String mo6440b() {
        return Strings.m29425b(this.f32514a);
    }

    public String toString() {
        return mo6440b();
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32514a.length) + 1) + this.f32514a.length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(26, this.f32514a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERVisibleString) {
            return Arrays.m29353a(this.f32514a, ((DERVisibleString) aSN1Primitive).f32514a);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32514a);
    }
}
