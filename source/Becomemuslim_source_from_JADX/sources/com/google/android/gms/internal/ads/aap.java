package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

class aap extends aao {
    /* renamed from: b */
    protected final byte[] f27981b;

    aap(byte[] bArr) {
        this.f27981b = bArr;
    }

    /* renamed from: a */
    public byte mo6035a(int i) {
        return this.f27981b[i];
    }

    /* renamed from: a */
    public int mo6036a() {
        return this.f27981b.length;
    }

    /* renamed from: a */
    protected final int mo6037a(int i, int i2, int i3) {
        return abs.m17930a(i, this.f27981b, mo6626g(), i3);
    }

    /* renamed from: a */
    public final aai mo6038a(int i, int i2) {
        i = aai.m17833b(0, i2, mo6036a());
        return i == 0 ? aai.f14132a : new aal(this.f27981b, mo6626g(), i);
    }

    /* renamed from: a */
    protected final String mo6039a(Charset charset) {
        return new String(this.f27981b, mo6626g(), mo6036a(), charset);
    }

    /* renamed from: a */
    final void mo6040a(aah aah) {
        aah.mo6060a(this.f27981b, mo6626g(), mo6036a());
    }

    /* renamed from: a */
    protected void mo6041a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f27981b, 0, bArr, 0, i3);
    }

    /* renamed from: a */
    final boolean mo6042a(aai aai, int i, int i2) {
        StringBuilder stringBuilder;
        if (i2 > aai.mo6036a()) {
            i = mo6036a();
            stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 > aai.mo6036a()) {
            r6 = aai.mo6036a();
            stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(r6);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!(aai instanceof aap)) {
            return aai.mo6038a(0, i2).equals(mo6038a(0, i2));
        } else {
            aap aap = (aap) aai;
            byte[] bArr = this.f27981b;
            byte[] bArr2 = aap.f27981b;
            int g = mo6626g() + i2;
            i2 = mo6626g();
            r6 = aap.mo6626g();
            while (i2 < g) {
                if (bArr[i2] != bArr2[r6]) {
                    return false;
                }
                i2++;
                r6++;
            }
            return true;
        }
    }

    /* renamed from: d */
    public final boolean mo6043d() {
        int g = mo6626g();
        return aer.m18268a(this.f27981b, g, mo6036a() + g);
    }

    /* renamed from: e */
    public final aar mo6044e() {
        return aar.m17853a(this.f27981b, mo6626g(), mo6036a(), true);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aai) || mo6036a() != ((aai) obj).mo6036a()) {
            return false;
        }
        if (mo6036a() == 0) {
            return true;
        }
        if (!(obj instanceof aap)) {
            return obj.equals(this);
        }
        aap aap = (aap) obj;
        int f = m17847f();
        int f2 = aap.m17847f();
        return (f == 0 || f2 == 0 || f == f2) ? mo6042a(aap, 0, mo6036a()) : false;
    }

    /* renamed from: g */
    protected int mo6626g() {
        return 0;
    }
}
