package org.spongycastle.asn1.x500.style;

public class X500NameTokenizer {
    /* renamed from: a */
    private String f22017a;
    /* renamed from: b */
    private int f22018b;
    /* renamed from: c */
    private char f22019c;
    /* renamed from: d */
    private StringBuffer f22020d;

    public X500NameTokenizer(String str) {
        this(str, ',');
    }

    public X500NameTokenizer(String str, char c) {
        this.f22020d = new StringBuffer();
        this.f22017a = str;
        this.f22018b = -1;
        this.f22019c = c;
    }

    /* renamed from: a */
    public boolean m27252a() {
        return this.f22018b != this.f22017a.length();
    }

    /* renamed from: b */
    public String m27253b() {
        if (this.f22018b == this.f22017a.length()) {
            return null;
        }
        int i = this.f22018b + 1;
        this.f22020d.setLength(0);
        Object obj = null;
        int i2 = 0;
        while (i != this.f22017a.length()) {
            char charAt = this.f22017a.charAt(i);
            if (charAt == '\"') {
                if (obj == null) {
                    i2 ^= 1;
                }
                this.f22020d.append(charAt);
            } else {
                if (obj == null) {
                    if (i2 == 0) {
                        if (charAt == '\\') {
                            this.f22020d.append(charAt);
                            obj = 1;
                        } else if (charAt == this.f22019c) {
                            break;
                        } else {
                            this.f22020d.append(charAt);
                        }
                        i++;
                    }
                }
                this.f22020d.append(charAt);
            }
            obj = null;
            i++;
        }
        this.f22018b = i;
        return this.f22020d.toString();
    }
}
