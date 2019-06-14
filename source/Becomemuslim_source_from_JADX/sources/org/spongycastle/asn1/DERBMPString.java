package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;

public class DERBMPString extends ASN1Primitive implements ASN1String {
    /* renamed from: a */
    private final char[] f32496a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    DERBMPString(char[] cArr) {
        this.f32496a = cArr;
    }

    public DERBMPString(String str) {
        this.f32496a = str.toCharArray();
    }

    /* renamed from: b */
    public String mo6440b() {
        return new String(this.f32496a);
    }

    public String toString() {
        return mo6440b();
    }

    public int hashCode() {
        return Arrays.m29343a(this.f32496a);
    }

    /* renamed from: a */
    protected boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return null;
        }
        return Arrays.m29354a(this.f32496a, ((DERBMPString) aSN1Primitive).f32496a);
    }

    /* renamed from: d */
    int mo6790d() {
        return (StreamUtil.m27168a(this.f32496a.length * 2) + 1) + (this.f32496a.length * 2);
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.mo5710b(30);
        aSN1OutputStream.m27143a(this.f32496a.length * 2);
        for (int i = 0; i != this.f32496a.length; i++) {
            char c = this.f32496a[i];
            aSN1OutputStream.mo5710b((byte) (c >> 8));
            aSN1OutputStream.mo5710b((byte) c);
        }
    }
}
