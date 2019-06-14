package com.google.android.exoplayer2.p164l;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

/* compiled from: ParsableByteArray */
/* renamed from: com.google.android.exoplayer2.l.l */
public final class C2529l {
    /* renamed from: a */
    public byte[] f6441a;
    /* renamed from: b */
    private int f6442b;
    /* renamed from: c */
    private int f6443c;

    public C2529l(int i) {
        this.f6441a = new byte[i];
        this.f6443c = i;
    }

    public C2529l(byte[] bArr) {
        this.f6441a = bArr;
        this.f6443c = bArr.length;
    }

    public C2529l(byte[] bArr, int i) {
        this.f6441a = bArr;
        this.f6443c = i;
    }

    /* renamed from: a */
    public void m7089a(int i) {
        m7091a(m7099e() < i ? new byte[i] : this.f6441a, i);
    }

    /* renamed from: a */
    public void m7091a(byte[] bArr, int i) {
        this.f6441a = bArr;
        this.f6443c = i;
        this.f6442b = null;
    }

    /* renamed from: a */
    public void m7088a() {
        this.f6442b = 0;
        this.f6443c = 0;
    }

    /* renamed from: b */
    public int m7093b() {
        return this.f6443c - this.f6442b;
    }

    /* renamed from: c */
    public int m7095c() {
        return this.f6443c;
    }

    /* renamed from: b */
    public void m7094b(int i) {
        boolean z = i >= 0 && i <= this.f6441a.length;
        C2516a.m7017a(z);
        this.f6443c = i;
    }

    /* renamed from: d */
    public int m7097d() {
        return this.f6442b;
    }

    /* renamed from: e */
    public int m7099e() {
        return this.f6441a == null ? 0 : this.f6441a.length;
    }

    /* renamed from: c */
    public void m7096c(int i) {
        boolean z = i >= 0 && i <= this.f6443c;
        C2516a.m7017a(z);
        this.f6442b = i;
    }

    /* renamed from: d */
    public void m7098d(int i) {
        m7096c(this.f6442b + i);
    }

    /* renamed from: a */
    public void m7090a(C2528k c2528k, int i) {
        m7092a(c2528k.f6437a, 0, i);
        c2528k.m7073a(0);
    }

    /* renamed from: a */
    public void m7092a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f6441a, this.f6442b, bArr, i, i2);
        this.f6442b += i2;
    }

    /* renamed from: f */
    public char m7101f() {
        return (char) (((this.f6441a[this.f6442b] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (this.f6441a[this.f6442b + 1] & JfifUtil.MARKER_FIRST_BYTE));
    }

    /* renamed from: g */
    public int m7103g() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        return bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: h */
    public int m7104h() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return i2 | (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: i */
    public int m7105i() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return i2 | ((bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8);
    }

    /* renamed from: j */
    public short m7106j() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return (short) (i2 | (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE));
    }

    /* renamed from: k */
    public int m7107k() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        bArr2 = this.f6441a;
        i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return i2 | (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: l */
    public int m7108l() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) >> 8;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        bArr2 = this.f6441a;
        i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return i2 | (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: m */
    public long m7109m() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.f6441a;
        int i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        return j | (255 & ((long) bArr2[i2]));
    }

    /* renamed from: n */
    public long m7110n() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f6441a;
        int i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        return j | ((255 & ((long) bArr2[i2])) << 24);
    }

    /* renamed from: o */
    public int m7111o() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        bArr2 = this.f6441a;
        i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        bArr2 = this.f6441a;
        i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return i2 | (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: p */
    public int m7112p() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        bArr2 = this.f6441a;
        i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= (bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        bArr2 = this.f6441a;
        i3 = this.f6442b;
        this.f6442b = i3 + 1;
        return i2 | ((bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE) << 24);
    }

    /* renamed from: q */
    public long m7113q() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.f6441a;
        int i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        return j | (255 & ((long) bArr2[i2]));
    }

    /* renamed from: r */
    public long m7114r() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        long j = ((long) bArr[i]) & 255;
        byte[] bArr2 = this.f6441a;
        int i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.f6441a;
        i2 = this.f6442b;
        this.f6442b = i2 + 1;
        return j | ((255 & ((long) bArr2[i2])) << 56);
    }

    /* renamed from: s */
    public int m7115s() {
        byte[] bArr = this.f6441a;
        int i = this.f6442b;
        this.f6442b = i + 1;
        int i2 = (bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        byte[] bArr2 = this.f6441a;
        int i3 = this.f6442b;
        this.f6442b = i3 + 1;
        i2 |= bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE;
        this.f6442b += 2;
        return i2;
    }

    /* renamed from: t */
    public int m7116t() {
        return (((m7103g() << 21) | (m7103g() << 14)) | (m7103g() << 7)) | m7103g();
    }

    /* renamed from: u */
    public int m7117u() {
        int o = m7111o();
        if (o >= 0) {
            return o;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(o);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: v */
    public int m7118v() {
        int p = m7112p();
        if (p >= 0) {
            return p;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(p);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: w */
    public long m7119w() {
        long q = m7113q();
        if (q >= 0) {
            return q;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(q);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: x */
    public double m7120x() {
        return Double.longBitsToDouble(m7113q());
    }

    /* renamed from: e */
    public String m7100e(int i) {
        return m7087a(i, Charset.forName(Utf8Charset.NAME));
    }

    /* renamed from: a */
    public String m7087a(int i, Charset charset) {
        String str = new String(this.f6441a, this.f6442b, i, charset);
        this.f6442b += i;
        return str;
    }

    /* renamed from: f */
    public String m7102f(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = (this.f6442b + i) - 1;
        i2 = (i2 >= this.f6443c || this.f6441a[i2] != (byte) 0) ? i : i - 1;
        String str = new String(this.f6441a, this.f6442b, i2);
        this.f6442b += i;
        return str;
    }

    /* renamed from: y */
    public String m7121y() {
        if (m7093b() == 0) {
            return null;
        }
        int i = this.f6442b;
        while (i < this.f6443c && this.f6441a[i] != (byte) 0) {
            i++;
        }
        String str = new String(this.f6441a, this.f6442b, i - this.f6442b);
        this.f6442b = i;
        if (this.f6442b < this.f6443c) {
            this.f6442b++;
        }
        return str;
    }

    /* renamed from: z */
    public String m7122z() {
        if (m7093b() == 0) {
            return null;
        }
        int i = this.f6442b;
        while (i < this.f6443c && !C2541v.m7177a(this.f6441a[i])) {
            i++;
        }
        if (i - this.f6442b >= 3 && this.f6441a[this.f6442b] == (byte) -17 && this.f6441a[this.f6442b + 1] == (byte) -69 && this.f6441a[this.f6442b + 2] == (byte) -65) {
            this.f6442b += 3;
        }
        String str = new String(this.f6441a, this.f6442b, i - this.f6442b);
        this.f6442b = i;
        if (this.f6442b == this.f6443c) {
            return str;
        }
        if (this.f6441a[this.f6442b] == (byte) 13) {
            this.f6442b++;
            if (this.f6442b == this.f6443c) {
                return str;
            }
        }
        if (this.f6441a[this.f6442b] == (byte) 10) {
            this.f6442b++;
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: A */
    public long m7086A() {
        /*
        r11 = this;
        r0 = r11.f6441a;
        r1 = r11.f6442b;
        r0 = r0[r1];
        r0 = (long) r0;
        r2 = 7;
        r3 = 7;
    L_0x0009:
        r4 = 6;
        r5 = 1;
        if (r3 < 0) goto L_0x0025;
    L_0x000d:
        r6 = r5 << r3;
        r7 = (long) r6;
        r7 = r7 & r0;
        r9 = 0;
        r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r7 != 0) goto L_0x0022;
    L_0x0017:
        if (r3 >= r4) goto L_0x001e;
    L_0x0019:
        r6 = r6 - r5;
        r6 = (long) r6;
        r0 = r0 & r6;
        r2 = r2 - r3;
        goto L_0x0026;
    L_0x001e:
        if (r3 != r2) goto L_0x0025;
    L_0x0020:
        r2 = 1;
        goto L_0x0026;
    L_0x0022:
        r3 = r3 + -1;
        goto L_0x0009;
    L_0x0025:
        r2 = 0;
    L_0x0026:
        if (r2 == 0) goto L_0x005c;
    L_0x0028:
        if (r5 >= r2) goto L_0x0056;
    L_0x002a:
        r3 = r11.f6441a;
        r6 = r11.f6442b;
        r6 = r6 + r5;
        r3 = r3[r6];
        r6 = r3 & 192;
        r7 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r6 != r7) goto L_0x003f;
    L_0x0037:
        r0 = r0 << r4;
        r3 = r3 & 63;
        r6 = (long) r3;
        r0 = r0 | r6;
        r5 = r5 + 1;
        goto L_0x0028;
    L_0x003f:
        r2 = new java.lang.NumberFormatException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Invalid UTF-8 sequence continuation byte: ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0);
        throw r2;
    L_0x0056:
        r3 = r11.f6442b;
        r3 = r3 + r2;
        r11.f6442b = r3;
        return r0;
    L_0x005c:
        r2 = new java.lang.NumberFormatException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Invalid UTF-8 sequence first byte: ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.l.A():long");
    }
}
