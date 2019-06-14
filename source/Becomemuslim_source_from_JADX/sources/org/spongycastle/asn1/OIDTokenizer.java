package org.spongycastle.asn1;

public class OIDTokenizer {
    /* renamed from: a */
    private String f21461a;
    /* renamed from: b */
    private int f21462b = null;

    public OIDTokenizer(String str) {
        this.f21461a = str;
    }

    /* renamed from: a */
    public boolean m27166a() {
        return this.f21462b != -1;
    }

    /* renamed from: b */
    public String m27167b() {
        if (this.f21462b == -1) {
            return null;
        }
        int indexOf = this.f21461a.indexOf(46, this.f21462b);
        if (indexOf == -1) {
            String substring = this.f21461a.substring(this.f21462b);
            this.f21462b = -1;
            return substring;
        }
        String substring2 = this.f21461a.substring(this.f21462b, indexOf);
        this.f21462b = indexOf + 1;
        return substring2;
    }
}
