package org.spongycastle.pqc.crypto.gmss;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.encoders.Hex;

public class GMSSRootSig {
    /* renamed from: a */
    private Digest f23211a;
    /* renamed from: b */
    private int f23212b = this.f23211a.mo5732b();
    /* renamed from: c */
    private int f23213c;
    /* renamed from: d */
    private byte[] f23214d;
    /* renamed from: e */
    private byte[] f23215e;
    /* renamed from: f */
    private byte[] f23216f;
    /* renamed from: g */
    private int f23217g;
    /* renamed from: h */
    private GMSSRandom f23218h = new GMSSRandom(this.f23211a);
    /* renamed from: i */
    private int f23219i;
    /* renamed from: j */
    private int f23220j;
    /* renamed from: k */
    private int f23221k;
    /* renamed from: l */
    private int f23222l;
    /* renamed from: m */
    private int f23223m;
    /* renamed from: n */
    private int f23224n;
    /* renamed from: o */
    private long f23225o;
    /* renamed from: p */
    private long f23226p;
    /* renamed from: q */
    private int f23227q;
    /* renamed from: r */
    private int f23228r;
    /* renamed from: s */
    private int f23229s;
    /* renamed from: t */
    private byte[] f23230t;

    /* renamed from: a */
    public int m29063a(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public GMSSRootSig(Digest digest, int i, int i2) {
        this.f23211a = digest;
        this.f23217g = i;
        this.f23229s = i2;
        this.f23220j = (1 << i) - 1;
        this.f23219i = (int) Math.ceil(((double) (this.f23212b << 3)) / ((double) i));
    }

    /* renamed from: a */
    public void m29064a(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] bArr3 = bArr2;
        this.f23215e = new byte[this.f23212b];
        this.f23211a.mo5731a(bArr3, 0, bArr3.length);
        this.f23215e = new byte[this.f23211a.mo5732b()];
        this.f23211a.mo5728a(this.f23215e, 0);
        Object obj = new byte[this.f23212b];
        System.arraycopy(this.f23215e, 0, obj, 0, this.f23212b);
        int a = m29063a((this.f23219i << this.f23217g) + 1);
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (8 % this.f23217g == 0) {
            i2 = 8 / r0.f23217g;
            i3 = 0;
            i4 = 0;
            while (i3 < r0.f23212b) {
                i5 = i4;
                for (i4 = 0; i4 < i2; i4++) {
                    i5 += obj[i3] & r0.f23220j;
                    obj[i3] = (byte) (obj[i3] >>> r0.f23217g);
                }
                i3++;
                i4 = i5;
            }
            r0.f23228r = (r0.f23219i << r0.f23217g) - i4;
            i3 = r0.f23228r;
            for (i6 = 0; i6 < a; i6 += r0.f23217g) {
                i4 += r0.f23220j & i3;
                i3 >>>= r0.f23217g;
            }
            i = i4;
        } else if (r0.f23217g < 8) {
            i3 = r0.f23212b / r0.f23217g;
            i4 = 0;
            i5 = 0;
            int i7 = 0;
            while (i4 < i3) {
                int i8 = i5;
                long j = 0;
                for (i5 = 0; i5 < r0.f23217g; i5++) {
                    j ^= (long) ((obj[i8] & JfifUtil.MARKER_FIRST_BYTE) << (i5 << 3));
                    i8++;
                }
                r7 = 0;
                while (r7 < 8) {
                    i7 += (int) (((long) r0.f23220j) & j);
                    j >>>= r0.f23217g;
                    r7++;
                    i3 = i3;
                }
                int i9 = i3;
                i4++;
                i5 = i8;
            }
            i = r0.f23212b % r0.f23217g;
            long j2 = 0;
            for (i3 = 0; i3 < i; i3++) {
                j2 ^= (long) ((obj[i5] & JfifUtil.MARKER_FIRST_BYTE) << (i3 << 3));
                i5++;
            }
            i6 = i << 3;
            for (i = 0; i < i6; i += r0.f23217g) {
                i7 += (int) (((long) r0.f23220j) & j2);
                j2 >>>= r0.f23217g;
            }
            r0.f23228r = (r0.f23219i << r0.f23217g) - i7;
            i3 = r0.f23228r;
            i = i7;
            for (i6 = 0; i6 < a; i6 += r0.f23217g) {
                i += r0.f23220j & i3;
                i3 >>>= r0.f23217g;
            }
        } else if (r0.f23217g < 57) {
            i = 0;
            i3 = 0;
            while (i <= (r0.f23212b << 3) - r0.f23217g) {
                int i10 = i % 8;
                i += r0.f23217g;
                long j3 = 0;
                int i11 = 0;
                for (r7 = i >>> 3; r7 < ((i + 7) >>> 3); r7++) {
                    j3 ^= (long) ((obj[r7] & JfifUtil.MARKER_FIRST_BYTE) << (i11 << 3));
                    i11++;
                }
                i3 = (int) (((long) i3) + ((j3 >>> i10) & ((long) r0.f23220j)));
            }
            r7 = i >>> 3;
            if (r7 < r0.f23212b) {
                i %= 8;
                i2 = 0;
                long j4 = 0;
                while (r7 < r0.f23212b) {
                    j4 ^= (long) ((obj[r7] & JfifUtil.MARKER_FIRST_BYTE) << (i2 << 3));
                    i2++;
                    r7++;
                }
                i3 = (int) (((long) i3) + ((j4 >>> i) & ((long) r0.f23220j)));
            }
            r0.f23228r = (r0.f23219i << r0.f23217g) - i3;
            i = i3;
            i3 = r0.f23228r;
            for (i6 = 0; i6 < a; i6 += r0.f23217g) {
                i += r0.f23220j & i3;
                i3 >>>= r0.f23217g;
            }
        } else {
            i = 0;
        }
        r0.f23213c = r0.f23219i + ((int) Math.ceil(((double) a) / ((double) r0.f23217g)));
        r0.f23227q = (int) Math.ceil(((double) (r0.f23213c + i)) / ((double) (1 << r0.f23229s)));
        r0.f23216f = new byte[(r0.f23213c * r0.f23212b)];
        r0.f23223m = 0;
        r0.f23222l = 0;
        r0.f23224n = 0;
        r0.f23225o = 0;
        r0.f23221k = 0;
        r0.f23214d = new byte[r0.f23212b];
        r0.f23230t = new byte[r0.f23212b];
        System.arraycopy(bArr, 0, r0.f23230t, 0, r0.f23212b);
    }

    /* renamed from: a */
    public byte[][] m29065a() {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{5, this.f23212b});
        bArr[0] = this.f23214d;
        bArr[1] = this.f23230t;
        bArr[2] = this.f23215e;
        bArr[3] = this.f23216f;
        bArr[4] = m29067c();
        return bArr;
    }

    /* renamed from: b */
    public int[] m29066b() {
        return new int[]{this.f23223m, this.f23222l, this.f23224n, this.f23221k, this.f23227q, this.f23213c, this.f23229s, this.f23217g, this.f23228r};
    }

    /* renamed from: c */
    public byte[] m29067c() {
        return new byte[]{(byte) ((int) (this.f23225o & 255)), (byte) ((int) ((this.f23225o >> 8) & 255)), (byte) ((int) ((this.f23225o >> 16) & 255)), (byte) ((int) ((this.f23225o >> 24) & 255)), (byte) ((int) ((this.f23225o >> 32) & 255)), (byte) ((int) ((this.f23225o >> 40) & 255)), (byte) ((int) ((this.f23225o >> 48) & 255)), (byte) ((int) ((this.f23225o >> 56) & 255)), (byte) ((int) (this.f23226p & 255)), (byte) ((int) ((this.f23226p >> 8) & 255)), (byte) ((int) ((this.f23226p >> 16) & 255)), (byte) ((int) ((this.f23226p >> 24) & 255)), (byte) ((int) ((this.f23226p >> 32) & 255)), (byte) ((int) ((this.f23226p >> 40) & 255)), (byte) ((int) ((this.f23226p >> 48) & 255)), (byte) ((int) ((this.f23226p >> 56) & 255))};
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.f23226p);
        stringBuilder.append("  ");
        String stringBuilder2 = stringBuilder.toString();
        int[] iArr = new int[9];
        iArr = m29066b();
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{5, this.f23212b});
        bArr = m29065a();
        String str = stringBuilder2;
        for (int i = 0; i < 9; i++) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append(iArr[i]);
            stringBuilder3.append(" ");
            str = stringBuilder3.toString();
        }
        for (int i2 = 0; i2 < 5; i2++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(new String(Hex.m29437a(bArr[i2])));
            stringBuilder.append(" ");
            str = stringBuilder.toString();
        }
        return str;
    }
}
