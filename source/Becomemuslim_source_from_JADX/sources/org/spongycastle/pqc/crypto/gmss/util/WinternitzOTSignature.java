package org.spongycastle.pqc.crypto.gmss.util;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;

public class WinternitzOTSignature {
    /* renamed from: a */
    private Digest f23246a;
    /* renamed from: b */
    private int f23247b = this.f23246a.mo5732b();
    /* renamed from: c */
    private int f23248c;
    /* renamed from: d */
    private byte[][] f23249d;
    /* renamed from: e */
    private int f23250e;
    /* renamed from: f */
    private GMSSRandom f23251f = new GMSSRandom(this.f23246a);
    /* renamed from: g */
    private int f23252g;
    /* renamed from: h */
    private int f23253h;

    /* renamed from: a */
    public int m29085a(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i) {
        this.f23250e = i;
        this.f23246a = digest;
        double d = (double) i;
        this.f23252g = (int) Math.ceil(((double) (this.f23247b << 3)) / d);
        this.f23253h = m29085a((this.f23252g << i) + 1);
        this.f23248c = this.f23252g + ((int) Math.ceil(((double) this.f23253h) / d));
        this.f23249d = (byte[][]) Array.newInstance(byte.class, new int[]{this.f23248c, this.f23247b});
        digest = new byte[this.f23247b];
        int i2 = 0;
        System.arraycopy(bArr, 0, digest, 0, digest.length);
        while (i2 < this.f23248c) {
            this.f23249d[i2] = this.f23251f.m29078a(digest);
            i2++;
        }
    }

    /* renamed from: a */
    public byte[] m29086a() {
        Object obj = new byte[(this.f23248c * this.f23247b)];
        byte[] bArr = new byte[this.f23247b];
        int i = 1 << this.f23250e;
        for (int i2 = 0; i2 < this.f23248c; i2++) {
            this.f23246a.mo5731a(this.f23249d[i2], 0, this.f23249d[i2].length);
            Object obj2 = new byte[this.f23246a.mo5732b()];
            this.f23246a.mo5728a(obj2, 0);
            for (int i3 = 2; i3 < i; i3++) {
                this.f23246a.mo5731a(obj2, 0, obj2.length);
                obj2 = new byte[this.f23246a.mo5732b()];
                this.f23246a.mo5728a(obj2, 0);
            }
            System.arraycopy(obj2, 0, obj, this.f23247b * i2, this.f23247b);
        }
        this.f23246a.mo5731a(obj, 0, obj.length);
        byte[] bArr2 = new byte[this.f23246a.mo5732b()];
        this.f23246a.mo5728a(bArr2, 0);
        return bArr2;
    }

    /* renamed from: a */
    public byte[] m29087a(byte[] bArr) {
        byte[] bArr2 = bArr;
        Object obj = new byte[(this.f23248c * this.f23247b)];
        byte[] bArr3 = new byte[this.f23247b];
        this.f23246a.mo5731a(bArr2, 0, bArr2.length);
        bArr2 = new byte[this.f23246a.mo5732b()];
        this.f23246a.mo5728a(bArr2, 0);
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Object obj2;
        int i6;
        int i7;
        int i8;
        if (8 % this.f23250e == 0) {
            i = 8 / r0.f23250e;
            i2 = (1 << r0.f23250e) - 1;
            Object obj3 = new byte[r0.f23247b];
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (i3 < bArr2.length) {
                obj2 = obj3;
                i6 = i5;
                i5 = i4;
                for (i4 = 0; i4 < i; i4++) {
                    i7 = bArr2[i3] & i2;
                    i5 += i7;
                    System.arraycopy(r0.f23249d[i6], 0, obj2, 0, r0.f23247b);
                    while (i7 > 0) {
                        r0.f23246a.mo5731a(obj2, 0, obj2.length);
                        obj2 = new byte[r0.f23246a.mo5732b()];
                        r0.f23246a.mo5728a(obj2, 0);
                        i7--;
                    }
                    System.arraycopy(obj2, 0, obj, r0.f23247b * i6, r0.f23247b);
                    bArr2[i3] = (byte) (bArr2[i3] >>> r0.f23250e);
                    i6++;
                }
                i3++;
                i4 = i5;
                i5 = i6;
                obj3 = obj2;
            }
            i = (r0.f23252g << r0.f23250e) - i4;
            for (i8 = 0; i8 < r0.f23253h; i8 += r0.f23250e) {
                System.arraycopy(r0.f23249d[i5], 0, obj3, 0, r0.f23247b);
                for (i3 = i & i2; i3 > 0; i3--) {
                    r0.f23246a.mo5731a(obj3, 0, obj3.length);
                    obj3 = new byte[r0.f23246a.mo5732b()];
                    r0.f23246a.mo5728a(obj3, 0);
                }
                System.arraycopy(obj3, 0, obj, r0.f23247b * i5, r0.f23247b);
                i >>>= r0.f23250e;
                i5++;
            }
        } else if (r0.f23250e < 8) {
            i2 = r0.f23247b / r0.f23250e;
            i6 = (1 << r0.f23250e) - 1;
            Object obj4 = new byte[r0.f23247b];
            int i9 = 0;
            i7 = 0;
            int i10 = 0;
            r13 = 0;
            while (i9 < i2) {
                int i11 = i7;
                long j = 0;
                for (i7 = 0; i7 < r0.f23250e; i7++) {
                    j ^= (long) ((bArr2[i11] & JfifUtil.MARKER_FIRST_BYTE) << (i7 << 3));
                    i11++;
                }
                i4 = 0;
                while (i4 < 8) {
                    r20 = i4;
                    i3 = (int) (((long) i6) & j);
                    r13 += i3;
                    System.arraycopy(r0.f23249d[i10], 0, obj4, 0, r0.f23247b);
                    while (i3 > 0) {
                        r0.f23246a.mo5731a(obj4, 0, obj4.length);
                        obj4 = new byte[r0.f23246a.mo5732b()];
                        r0.f23246a.mo5728a(obj4, 0);
                        i3--;
                    }
                    System.arraycopy(obj4, 0, obj, r0.f23247b * i10, r0.f23247b);
                    j >>>= r0.f23250e;
                    i10++;
                    i4 = r20 + 1;
                }
                i9++;
                i7 = i11;
            }
            i2 = r0.f23247b % r0.f23250e;
            long j2 = 0;
            for (i = 0; i < i2; i++) {
                j2 ^= (long) ((bArr2[i7] & JfifUtil.MARKER_FIRST_BYTE) << (i << 3));
                i7++;
            }
            i8 = i2 << 3;
            for (i2 = 0; i2 < i8; i2 += r0.f23250e) {
                i = (int) (j2 & ((long) i6));
                r13 += i;
                System.arraycopy(r0.f23249d[i10], 0, obj4, 0, r0.f23247b);
                while (i > 0) {
                    r0.f23246a.mo5731a(obj4, 0, obj4.length);
                    obj4 = new byte[r0.f23246a.mo5732b()];
                    r0.f23246a.mo5728a(obj4, 0);
                    i--;
                }
                System.arraycopy(obj4, 0, obj, r0.f23247b * i10, r0.f23247b);
                j2 >>>= r0.f23250e;
                i10++;
            }
            i2 = (r0.f23252g << r0.f23250e) - r13;
            for (i8 = 0; i8 < r0.f23253h; i8 += r0.f23250e) {
                System.arraycopy(r0.f23249d[i10], 0, obj4, 0, r0.f23247b);
                for (i = i2 & i6; i > 0; i--) {
                    r0.f23246a.mo5731a(obj4, 0, obj4.length);
                    obj4 = new byte[r0.f23246a.mo5732b()];
                    r0.f23246a.mo5728a(obj4, 0);
                }
                System.arraycopy(obj4, 0, obj, r0.f23247b * i10, r0.f23247b);
                i2 >>>= r0.f23250e;
                i10++;
            }
        } else if (r0.f23250e < 57) {
            long j3;
            i2 = (r0.f23247b << 3) - r0.f23250e;
            i3 = (1 << r0.f23250e) - 1;
            obj2 = new byte[r0.f23247b];
            i4 = 0;
            i5 = 0;
            i6 = 0;
            while (i4 <= i2) {
                int i12 = i4 % 8;
                i4 += r0.f23250e;
                long j4 = 0;
                r20 = 0;
                for (r13 = i4 >>> 3; r13 < ((i4 + 7) >>> 3); r13++) {
                    j4 ^= (long) ((bArr2[r13] & JfifUtil.MARKER_FIRST_BYTE) << (r20 << 3));
                    r20++;
                }
                j3 = (j4 >>> i12) & ((long) i3);
                i5 = (int) (((long) i5) + j3);
                System.arraycopy(r0.f23249d[i6], 0, obj2, 0, r0.f23247b);
                while (j3 > 0) {
                    r0.f23246a.mo5731a(obj2, 0, obj2.length);
                    obj2 = new byte[r0.f23246a.mo5732b()];
                    r0.f23246a.mo5728a(obj2, 0);
                    j3--;
                }
                System.arraycopy(obj2, 0, obj, r0.f23247b * i6, r0.f23247b);
                i6++;
            }
            i2 = i4 >>> 3;
            if (i2 < r0.f23247b) {
                i4 %= 8;
                i = 0;
                j3 = 0;
                while (i2 < r0.f23247b) {
                    j3 ^= (long) ((bArr2[i2] & JfifUtil.MARKER_FIRST_BYTE) << (i << 3));
                    i++;
                    i2++;
                }
                long j5 = (j3 >>> i4) & ((long) i3);
                i5 = (int) (((long) i5) + j5);
                System.arraycopy(r0.f23249d[i6], 0, obj2, 0, r0.f23247b);
                while (j5 > 0) {
                    r0.f23246a.mo5731a(obj2, 0, obj2.length);
                    obj2 = new byte[r0.f23246a.mo5732b()];
                    r0.f23246a.mo5728a(obj2, 0);
                    j5--;
                }
                System.arraycopy(obj2, 0, obj, r0.f23247b * i6, r0.f23247b);
                i6++;
            }
            i2 = (r0.f23252g << r0.f23250e) - i5;
            for (i8 = 0; i8 < r0.f23253h; i8 += r0.f23250e) {
                System.arraycopy(r0.f23249d[i6], 0, obj2, 0, r0.f23247b);
                for (long j6 = (long) (i2 & i3); j6 > 0; j6--) {
                    r0.f23246a.mo5731a(obj2, 0, obj2.length);
                    obj2 = new byte[r0.f23246a.mo5732b()];
                    r0.f23246a.mo5728a(obj2, 0);
                }
                System.arraycopy(obj2, 0, obj, r0.f23247b * i6, r0.f23247b);
                i2 >>>= r0.f23250e;
                i6++;
            }
        }
        return obj;
    }
}
