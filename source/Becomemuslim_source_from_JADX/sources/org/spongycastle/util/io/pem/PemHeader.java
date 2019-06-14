package org.spongycastle.util.io.pem;

public class PemHeader {
    /* renamed from: a */
    private String f23451a;
    /* renamed from: b */
    private String f23452b;

    /* renamed from: a */
    public String m29445a() {
        return this.f23451a;
    }

    /* renamed from: b */
    public String m29446b() {
        return this.f23452b;
    }

    public int hashCode() {
        return m29443a(this.f23451a) + (m29443a(this.f23452b) * 31);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof PemHeader)) {
            return false;
        }
        PemHeader pemHeader = (PemHeader) obj;
        if (pemHeader == this || (m29444a(this.f23451a, pemHeader.f23451a) && m29444a(this.f23452b, pemHeader.f23452b) != null)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private int m29443a(String str) {
        return str == null ? 1 : str.hashCode();
    }

    /* renamed from: a */
    private boolean m29444a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null) {
            if (str2 != null) {
                return str.equals(str2);
            }
        }
        return null;
    }
}
