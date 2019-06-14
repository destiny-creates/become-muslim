package com.google.android.exoplayer2.p157i.p159b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DvbParser */
/* renamed from: com.google.android.exoplayer2.i.b.b */
final class C2457b {
    /* renamed from: a */
    private static final byte[] f6197a = new byte[]{(byte) 0, (byte) 7, (byte) 8, (byte) 15};
    /* renamed from: b */
    private static final byte[] f6198b = new byte[]{(byte) 0, (byte) 119, (byte) -120, (byte) -1};
    /* renamed from: c */
    private static final byte[] f6199c = new byte[]{(byte) 0, (byte) 17, (byte) 34, (byte) 51, (byte) 68, (byte) 85, (byte) 102, (byte) 119, (byte) -120, (byte) -103, (byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
    /* renamed from: d */
    private final Paint f6200d = new Paint();
    /* renamed from: e */
    private final Paint f6201e;
    /* renamed from: f */
    private final Canvas f6202f;
    /* renamed from: g */
    private final C2450b f6203g;
    /* renamed from: h */
    private final C2449a f6204h;
    /* renamed from: i */
    private final C2456h f6205i;
    /* renamed from: j */
    private Bitmap f6206j;

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$a */
    private static final class C2449a {
        /* renamed from: a */
        public final int f6151a;
        /* renamed from: b */
        public final int[] f6152b;
        /* renamed from: c */
        public final int[] f6153c;
        /* renamed from: d */
        public final int[] f6154d;

        public C2449a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f6151a = i;
            this.f6152b = iArr;
            this.f6153c = iArr2;
            this.f6154d = iArr3;
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$b */
    private static final class C2450b {
        /* renamed from: a */
        public final int f6155a;
        /* renamed from: b */
        public final int f6156b;
        /* renamed from: c */
        public final int f6157c;
        /* renamed from: d */
        public final int f6158d;
        /* renamed from: e */
        public final int f6159e;
        /* renamed from: f */
        public final int f6160f;

        public C2450b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f6155a = i;
            this.f6156b = i2;
            this.f6157c = i3;
            this.f6158d = i4;
            this.f6159e = i5;
            this.f6160f = i6;
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$c */
    private static final class C2451c {
        /* renamed from: a */
        public final int f6161a;
        /* renamed from: b */
        public final boolean f6162b;
        /* renamed from: c */
        public final byte[] f6163c;
        /* renamed from: d */
        public final byte[] f6164d;

        public C2451c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f6161a = i;
            this.f6162b = z;
            this.f6163c = bArr;
            this.f6164d = bArr2;
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$d */
    private static final class C2452d {
        /* renamed from: a */
        public final int f6165a;
        /* renamed from: b */
        public final int f6166b;
        /* renamed from: c */
        public final int f6167c;
        /* renamed from: d */
        public final SparseArray<C2453e> f6168d;

        public C2452d(int i, int i2, int i3, SparseArray<C2453e> sparseArray) {
            this.f6165a = i;
            this.f6166b = i2;
            this.f6167c = i3;
            this.f6168d = sparseArray;
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$e */
    private static final class C2453e {
        /* renamed from: a */
        public final int f6169a;
        /* renamed from: b */
        public final int f6170b;

        public C2453e(int i, int i2) {
            this.f6169a = i;
            this.f6170b = i2;
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$f */
    private static final class C2454f {
        /* renamed from: a */
        public final int f6171a;
        /* renamed from: b */
        public final boolean f6172b;
        /* renamed from: c */
        public final int f6173c;
        /* renamed from: d */
        public final int f6174d;
        /* renamed from: e */
        public final int f6175e;
        /* renamed from: f */
        public final int f6176f;
        /* renamed from: g */
        public final int f6177g;
        /* renamed from: h */
        public final int f6178h;
        /* renamed from: i */
        public final int f6179i;
        /* renamed from: j */
        public final int f6180j;
        /* renamed from: k */
        public final SparseArray<C2455g> f6181k;

        public C2454f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<C2455g> sparseArray) {
            this.f6171a = i;
            this.f6172b = z;
            this.f6173c = i2;
            this.f6174d = i3;
            this.f6175e = i4;
            this.f6176f = i5;
            this.f6177g = i6;
            this.f6178h = i7;
            this.f6179i = i8;
            this.f6180j = i9;
            this.f6181k = sparseArray;
        }

        /* renamed from: a */
        public void m6770a(C2454f c2454f) {
            if (c2454f != null) {
                c2454f = c2454f.f6181k;
                for (int i = 0; i < c2454f.size(); i++) {
                    this.f6181k.put(c2454f.keyAt(i), c2454f.valueAt(i));
                }
            }
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$g */
    private static final class C2455g {
        /* renamed from: a */
        public final int f6182a;
        /* renamed from: b */
        public final int f6183b;
        /* renamed from: c */
        public final int f6184c;
        /* renamed from: d */
        public final int f6185d;
        /* renamed from: e */
        public final int f6186e;
        /* renamed from: f */
        public final int f6187f;

        public C2455g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f6182a = i;
            this.f6183b = i2;
            this.f6184c = i3;
            this.f6185d = i4;
            this.f6186e = i5;
            this.f6187f = i6;
        }
    }

    /* compiled from: DvbParser */
    /* renamed from: com.google.android.exoplayer2.i.b.b$h */
    private static final class C2456h {
        /* renamed from: a */
        public final int f6188a;
        /* renamed from: b */
        public final int f6189b;
        /* renamed from: c */
        public final SparseArray<C2454f> f6190c = new SparseArray();
        /* renamed from: d */
        public final SparseArray<C2449a> f6191d = new SparseArray();
        /* renamed from: e */
        public final SparseArray<C2451c> f6192e = new SparseArray();
        /* renamed from: f */
        public final SparseArray<C2449a> f6193f = new SparseArray();
        /* renamed from: g */
        public final SparseArray<C2451c> f6194g = new SparseArray();
        /* renamed from: h */
        public C2450b f6195h;
        /* renamed from: i */
        public C2452d f6196i;

        public C2456h(int i, int i2) {
            this.f6188a = i;
            this.f6189b = i2;
        }

        /* renamed from: a */
        public void m6771a() {
            this.f6190c.clear();
            this.f6191d.clear();
            this.f6192e.clear();
            this.f6193f.clear();
            this.f6194g.clear();
            this.f6195h = null;
            this.f6196i = null;
        }
    }

    /* renamed from: a */
    private static int m6772a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    public C2457b(int i, int i2) {
        this.f6200d.setStyle(Style.FILL_AND_STROKE);
        this.f6200d.setXfermode(new PorterDuffXfermode(Mode.SRC));
        this.f6200d.setPathEffect(null);
        this.f6201e = new Paint();
        this.f6201e.setStyle(Style.FILL);
        this.f6201e.setXfermode(new PorterDuffXfermode(Mode.DST_OVER));
        this.f6201e.setPathEffect(null);
        this.f6202f = new Canvas();
        this.f6203g = new C2450b(719, 575, 0, 719, 0, 575);
        this.f6204h = new C2449a(0, C2457b.m6783b(), C2457b.m6786c(), C2457b.m6787d());
        this.f6205i = new C2456h(i, i2);
    }

    /* renamed from: a */
    public void m6789a() {
        this.f6205i.m6771a();
    }

    /* renamed from: a */
    public List<C2458b> m6788a(byte[] bArr, int i) {
        C2457b c2457b = this;
        C2528k c2528k = new C2528k(bArr, i);
        while (c2528k.m7072a() >= 48 && c2528k.m7081c(8) == 15) {
            C2457b.m6777a(c2528k, c2457b.f6205i);
        }
        if (c2457b.f6205i.f6196i == null) {
            return Collections.emptyList();
        }
        C2450b c2450b = c2457b.f6205i.f6195h != null ? c2457b.f6205i.f6195h : c2457b.f6203g;
        if (!(c2457b.f6206j != null && c2450b.f6155a + 1 == c2457b.f6206j.getWidth() && c2450b.f6156b + 1 == c2457b.f6206j.getHeight())) {
            c2457b.f6206j = Bitmap.createBitmap(c2450b.f6155a + 1, c2450b.f6156b + 1, Config.ARGB_8888);
            c2457b.f6202f.setBitmap(c2457b.f6206j);
        }
        List<C2458b> arrayList = new ArrayList();
        SparseArray sparseArray = c2457b.f6205i.f6196i.f6168d;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            C2453e c2453e = (C2453e) sparseArray.valueAt(i2);
            C2454f c2454f = (C2454f) c2457b.f6205i.f6190c.get(sparseArray.keyAt(i2));
            int i3 = c2453e.f6169a + c2450b.f6157c;
            int i4 = c2453e.f6170b + c2450b.f6159e;
            float f = (float) i3;
            float f2 = (float) i4;
            float f3 = f2;
            float f4 = f;
            c2457b.f6202f.clipRect(f, f2, (float) Math.min(c2454f.f6173c + i3, c2450b.f6158d), (float) Math.min(c2454f.f6174d + i4, c2450b.f6160f), Op.REPLACE);
            C2449a c2449a = (C2449a) c2457b.f6205i.f6191d.get(c2454f.f6177g);
            if (c2449a == null) {
                c2449a = (C2449a) c2457b.f6205i.f6193f.get(c2454f.f6177g);
                if (c2449a == null) {
                    c2449a = c2457b.f6204h;
                }
            }
            SparseArray sparseArray2 = c2454f.f6181k;
            int i5 = 0;
            while (i5 < sparseArray2.size()) {
                int i6;
                SparseArray sparseArray3;
                int keyAt = sparseArray2.keyAt(i5);
                C2455g c2455g = (C2455g) sparseArray2.valueAt(i5);
                C2451c c2451c = (C2451c) c2457b.f6205i.f6192e.get(keyAt);
                C2451c c2451c2 = c2451c == null ? (C2451c) c2457b.f6205i.f6194g.get(keyAt) : c2451c;
                if (c2451c2 != null) {
                    i6 = i5;
                    sparseArray3 = sparseArray2;
                    C2457b.m6776a(c2451c2, c2449a, c2454f.f6176f, c2455g.f6184c + i3, i4 + c2455g.f6185d, c2451c2.f6162b ? null : c2457b.f6200d, c2457b.f6202f);
                } else {
                    i6 = i5;
                    sparseArray3 = sparseArray2;
                }
                i5 = i6 + 1;
                sparseArray2 = sparseArray3;
            }
            if (c2454f.f6172b) {
                int i7;
                if (c2454f.f6176f == 3) {
                    i7 = c2449a.f6154d[c2454f.f6178h];
                } else if (c2454f.f6176f == 2) {
                    i7 = c2449a.f6153c[c2454f.f6179i];
                } else {
                    i7 = c2449a.f6152b[c2454f.f6180j];
                }
                c2457b.f6201e.setColor(i7);
                c2457b.f6202f.drawRect(f4, f3, (float) (c2454f.f6173c + i3), (float) (c2454f.f6174d + i4), c2457b.f6201e);
            }
            arrayList.add(new C2458b(Bitmap.createBitmap(c2457b.f6206j, i3, i4, c2454f.f6173c, c2454f.f6174d), f4 / ((float) c2450b.f6155a), 0, f3 / ((float) c2450b.f6156b), 0, ((float) c2454f.f6173c) / ((float) c2450b.f6155a), ((float) c2454f.f6174d) / ((float) c2450b.f6156b)));
            c2457b.f6202f.drawColor(0, Mode.CLEAR);
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m6777a(C2528k c2528k, C2456h c2456h) {
        int c = c2528k.m7081c(8);
        int c2 = c2528k.m7081c(16);
        int c3 = c2528k.m7081c(16);
        int c4 = c2528k.m7080c() + c3;
        if (c3 * 8 > c2528k.m7072a()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            c2528k.m7078b(c2528k.m7072a());
            return;
        }
        C2452d c2452d;
        switch (c) {
            case 16:
                if (c2 == c2456h.f6188a) {
                    c2452d = c2456h.f6196i;
                    C2452d a = C2457b.m6775a(c2528k, c3);
                    if (a.f6167c == 0) {
                        if (!(c2452d == null || c2452d.f6166b == a.f6166b)) {
                            c2456h.f6196i = a;
                            break;
                        }
                    }
                    c2456h.f6196i = a;
                    c2456h.f6190c.clear();
                    c2456h.f6191d.clear();
                    c2456h.f6192e.clear();
                    break;
                }
                break;
            case 17:
                c2452d = c2456h.f6196i;
                if (c2 == c2456h.f6188a && c2452d != null) {
                    C2454f b = C2457b.m6782b(c2528k, c3);
                    if (c2452d.f6167c == 0) {
                        b.m6770a((C2454f) c2456h.f6190c.get(b.f6171a));
                    }
                    c2456h.f6190c.put(b.f6171a, b);
                    break;
                }
            case 18:
                C2449a c5;
                if (c2 != c2456h.f6188a) {
                    if (c2 == c2456h.f6189b) {
                        c5 = C2457b.m6785c(c2528k, c3);
                        c2456h.f6193f.put(c5.f6151a, c5);
                        break;
                    }
                }
                c5 = C2457b.m6785c(c2528k, c3);
                c2456h.f6191d.put(c5.f6151a, c5);
                break;
                break;
            case 19:
                C2451c b2;
                if (c2 != c2456h.f6188a) {
                    if (c2 == c2456h.f6189b) {
                        b2 = C2457b.m6781b(c2528k);
                        c2456h.f6194g.put(b2.f6161a, b2);
                        break;
                    }
                }
                b2 = C2457b.m6781b(c2528k);
                c2456h.f6192e.put(b2.f6161a, b2);
                break;
                break;
            case 20:
                if (c2 == c2456h.f6188a) {
                    c2456h.f6195h = C2457b.m6774a(c2528k);
                    break;
                }
                break;
            default:
                break;
        }
        c2528k.m7083d(c4 - c2528k.m7080c());
    }

    /* renamed from: a */
    private static C2450b m6774a(C2528k c2528k) {
        int c;
        int c2;
        int i;
        int i2;
        c2528k.m7078b(4);
        boolean e = c2528k.m7084e();
        c2528k.m7078b(3);
        int c3 = c2528k.m7081c(16);
        int c4 = c2528k.m7081c(16);
        if (e) {
            int c5 = c2528k.m7081c(16);
            int c6 = c2528k.m7081c(16);
            c = c2528k.m7081c(16);
            c2 = c2528k.m7081c(16);
            i = c6;
            i2 = c;
            c = c5;
        } else {
            i = c3;
            c2 = c4;
            c = 0;
            i2 = 0;
        }
        return new C2450b(c3, c4, c, i, i2, c2);
    }

    /* renamed from: a */
    private static C2452d m6775a(C2528k c2528k, int i) {
        int c = c2528k.m7081c(8);
        int c2 = c2528k.m7081c(4);
        int c3 = c2528k.m7081c(2);
        c2528k.m7078b(2);
        i -= 2;
        SparseArray sparseArray = new SparseArray();
        while (i > 0) {
            int c4 = c2528k.m7081c(8);
            c2528k.m7078b(8);
            i -= 6;
            sparseArray.put(c4, new C2453e(c2528k.m7081c(16), c2528k.m7081c(16)));
        }
        return new C2452d(c, c2, c3, sparseArray);
    }

    /* renamed from: b */
    private static C2454f m6782b(C2528k c2528k, int i) {
        C2528k c2528k2 = c2528k;
        int c = c2528k2.m7081c(8);
        c2528k2.m7078b(4);
        boolean e = c2528k.m7084e();
        c2528k2.m7078b(3);
        int i2 = 16;
        int c2 = c2528k2.m7081c(16);
        int c3 = c2528k2.m7081c(16);
        int c4 = c2528k2.m7081c(3);
        int c5 = c2528k2.m7081c(3);
        int i3 = 2;
        c2528k2.m7078b(2);
        int c6 = c2528k2.m7081c(8);
        int c7 = c2528k2.m7081c(8);
        int c8 = c2528k2.m7081c(4);
        int c9 = c2528k2.m7081c(2);
        c2528k2.m7078b(2);
        int i4 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i4 > 0) {
            int i5;
            int i6;
            int c10 = c2528k2.m7081c(i2);
            i2 = c2528k2.m7081c(i3);
            int c11 = c2528k2.m7081c(i3);
            int c12 = c2528k2.m7081c(12);
            int i7 = c9;
            c2528k2.m7078b(4);
            int c13 = c2528k2.m7081c(12);
            i4 -= 6;
            if (i2 != 1) {
                if (i2 != 2) {
                    i5 = 0;
                    i6 = 0;
                    sparseArray.put(c10, new C2455g(i2, c11, c12, c13, i5, i6));
                    c9 = i7;
                    i3 = 2;
                    i2 = 16;
                }
            }
            i4 -= 2;
            i5 = c2528k2.m7081c(8);
            i6 = c2528k2.m7081c(8);
            sparseArray.put(c10, new C2455g(i2, c11, c12, c13, i5, i6));
            c9 = i7;
            i3 = 2;
            i2 = 16;
        }
        return new C2454f(c, e, c2, c3, c4, c5, c6, c7, c8, c9, sparseArray);
    }

    /* renamed from: c */
    private static C2449a m6785c(C2528k c2528k, int i) {
        C2528k c2528k2 = c2528k;
        int i2 = 8;
        int c = c2528k2.m7081c(8);
        c2528k2.m7078b(8);
        int i3 = 2;
        int i4 = i - 2;
        int[] b = C2457b.m6783b();
        int[] c2 = C2457b.m6786c();
        int[] d = C2457b.m6787d();
        while (i4 > 0) {
            int c3;
            int c4;
            int c5;
            int c6 = c2528k2.m7081c(i2);
            int c7 = c2528k2.m7081c(i2);
            i4 -= 2;
            int[] iArr = (c7 & 128) != 0 ? b : (c7 & 64) != 0 ? c2 : d;
            if ((c7 & 1) != 0) {
                c7 = c2528k2.m7081c(i2);
                c3 = c2528k2.m7081c(i2);
                c4 = c2528k2.m7081c(i2);
                c5 = c2528k2.m7081c(i2);
                i4 -= 4;
            } else {
                c4 = c2528k2.m7081c(4) << 4;
                i4 -= 2;
                c5 = c2528k2.m7081c(i3) << 6;
                c7 = c2528k2.m7081c(6) << i3;
                c3 = c2528k2.m7081c(4) << 4;
            }
            if (c7 == 0) {
                c3 = 0;
                c4 = 0;
                c5 = JfifUtil.MARKER_FIRST_BYTE;
            }
            int i5 = i4;
            double d2 = (double) c7;
            int i6 = c;
            double d3 = (double) (c3 - 128);
            double d4 = (double) (c4 - 128);
            iArr[c6] = C2457b.m6772a((byte) (255 - (c5 & JfifUtil.MARKER_FIRST_BYTE)), C2541v.m7164a((int) (d2 + (1.402d * d3)), 0, (int) JfifUtil.MARKER_FIRST_BYTE), C2541v.m7164a((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, (int) JfifUtil.MARKER_FIRST_BYTE), C2541v.m7164a((int) (d2 + (d4 * 1.772d)), 0, (int) JfifUtil.MARKER_FIRST_BYTE));
            i4 = i5;
            c = i6;
            i2 = 8;
            i3 = 2;
        }
        return new C2449a(c, b, c2, d);
    }

    /* renamed from: b */
    private static C2451c m6781b(C2528k c2528k) {
        byte[] bArr;
        int c = c2528k.m7081c(16);
        c2528k.m7078b(4);
        int c2 = c2528k.m7081c(2);
        boolean e = c2528k.m7084e();
        c2528k.m7078b(1);
        byte[] bArr2 = null;
        if (c2 == 1) {
            c2528k.m7078b(c2528k.m7081c(8) * 16);
        } else if (c2 == 0) {
            c2 = c2528k.m7081c(16);
            int c3 = c2528k.m7081c(16);
            if (c2 > 0) {
                bArr2 = new byte[c2];
                c2528k.m7079b(bArr2, 0, c2);
            }
            if (c3 > 0) {
                bArr = new byte[c3];
                c2528k.m7079b(bArr, 0, c3);
                return new C2451c(c, e, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new C2451c(c, e, bArr2, bArr);
    }

    /* renamed from: b */
    private static int[] m6783b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    /* renamed from: c */
    private static int[] m6786c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                iArr[i] = C2457b.m6772a(JfifUtil.MARKER_FIRST_BYTE, (i & 1) != 0 ? JfifUtil.MARKER_FIRST_BYTE : 0, (i & 2) != 0 ? JfifUtil.MARKER_FIRST_BYTE : 0, (i & 4) != 0 ? JfifUtil.MARKER_FIRST_BYTE : 0);
            } else {
                int i2 = 127;
                int i3 = (i & 1) != 0 ? 127 : 0;
                int i4 = (i & 2) != 0 ? 127 : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = C2457b.m6772a(JfifUtil.MARKER_FIRST_BYTE, i3, i4, i2);
            }
        }
        return iArr;
    }

    /* renamed from: d */
    private static int[] m6787d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = JfifUtil.MARKER_FIRST_BYTE;
            int i3;
            int i4;
            if (i < 8) {
                i3 = (i & 1) != 0 ? JfifUtil.MARKER_FIRST_BYTE : 0;
                i4 = (i & 2) != 0 ? JfifUtil.MARKER_FIRST_BYTE : 0;
                if ((i & 4) == 0) {
                    i2 = 0;
                }
                iArr[i] = C2457b.m6772a(63, i3, i4, i2);
            } else {
                i3 = i & 136;
                i4 = 170;
                int i5 = 85;
                int i6;
                if (i3 == 0) {
                    i6 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    i3 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i5 = 0;
                    }
                    if ((i & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i] = C2457b.m6772a(JfifUtil.MARKER_FIRST_BYTE, i6, i3, i5 + i4);
                } else if (i3 != 8) {
                    i4 = 43;
                    if (i3 == 128) {
                        i6 = (((i & 1) != 0 ? 43 : 0) + 127) + ((i & 16) != 0 ? 85 : 0);
                        i3 = (((i & 2) != 0 ? 43 : 0) + 127) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i4 = 0;
                        }
                        i4 += 127;
                        if ((i & 64) == 0) {
                            i5 = 0;
                        }
                        iArr[i] = C2457b.m6772a(JfifUtil.MARKER_FIRST_BYTE, i6, i3, i4 + i5);
                    } else if (i3 == 136) {
                        i6 = ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0);
                        i3 = ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0);
                        if ((i & 4) == 0) {
                            i4 = 0;
                        }
                        if ((i & 64) == 0) {
                            i5 = 0;
                        }
                        iArr[i] = C2457b.m6772a(JfifUtil.MARKER_FIRST_BYTE, i6, i3, i4 + i5);
                    }
                } else {
                    i6 = ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0);
                    i2 = ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0);
                    if ((i & 4) == 0) {
                        i5 = 0;
                    }
                    if ((i & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i] = C2457b.m6772a(127, i6, i2, i5 + i4);
                }
            }
        }
        return iArr;
    }

    /* renamed from: a */
    private static void m6776a(C2451c c2451c, C2449a c2449a, int i, int i2, int i3, Paint paint, Canvas canvas) {
        if (i == 3) {
            c2449a = c2449a.f6154d;
        } else if (i == 2) {
            c2449a = c2449a.f6153c;
        } else {
            c2449a = c2449a.f6152b;
        }
        int[] iArr = c2449a;
        int i4 = i;
        int i5 = i2;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        C2457b.m6778a(c2451c.f6163c, iArr, i4, i5, i3, paint2, canvas2);
        C2457b.m6778a(c2451c.f6164d, iArr, i4, i5, i3 + 1, paint2, canvas2);
    }

    /* renamed from: a */
    private static void m6778a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int i4 = i;
        byte[] bArr2 = bArr;
        C2528k c2528k = new C2528k(bArr);
        int i5 = i2;
        int i6 = i3;
        byte[] bArr3 = null;
        byte[] bArr4 = bArr3;
        while (c2528k.m7072a() != 0) {
            int c = c2528k.m7081c(8);
            if (c != 240) {
                int a;
                switch (c) {
                    case 16:
                        byte[] bArr5;
                        if (i4 != 3) {
                            if (i4 != 2) {
                                bArr5 = null;
                                a = C2457b.m6773a(c2528k, iArr, bArr5, i5, i6, paint, canvas);
                                c2528k.m7085f();
                                break;
                            }
                            bArr2 = bArr4 == null ? f6197a : bArr4;
                        } else {
                            bArr2 = bArr3 == null ? f6198b : bArr3;
                        }
                        bArr5 = bArr2;
                        a = C2457b.m6773a(c2528k, iArr, bArr5, i5, i6, paint, canvas);
                        c2528k.m7085f();
                    case 17:
                        a = C2457b.m6780b(c2528k, iArr, i4 == 3 ? f6199c : null, i5, i6, paint, canvas);
                        c2528k.m7085f();
                        break;
                    case 18:
                        a = C2457b.m6784c(c2528k, iArr, null, i5, i6, paint, canvas);
                        break;
                    default:
                        switch (c) {
                            case 32:
                                bArr4 = C2457b.m6779a(4, 4, c2528k);
                                continue;
                            case 33:
                                bArr2 = C2457b.m6779a(4, 8, c2528k);
                                break;
                            case 34:
                                bArr2 = C2457b.m6779a(16, 8, c2528k);
                                break;
                            default:
                                continue;
                                continue;
                        }
                        bArr3 = bArr2;
                        break;
                }
                i5 = a;
            } else {
                i6 += 2;
                i5 = i2;
            }
        }
    }

    /* renamed from: a */
    private static int m6773a(C2528k c2528k, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        C2528k c2528k2 = c2528k;
        int i3 = i2;
        Paint paint2 = paint;
        int i4 = i;
        Object obj = null;
        while (true) {
            Object obj2;
            int i5;
            int i6;
            Canvas canvas2;
            int c = c2528k.m7081c(2);
            if (c != 0) {
                obj2 = obj;
                i5 = c;
            } else {
                if (!c2528k.m7084e()) {
                    if (!c2528k.m7084e()) {
                        switch (c2528k.m7081c(2)) {
                            case 0:
                                i5 = 0;
                                i6 = 0;
                                obj2 = 1;
                                break;
                            case 1:
                                obj2 = obj;
                                i5 = 0;
                                i6 = 2;
                                break;
                            case 2:
                                c = c2528k.m7081c(4) + 12;
                                i5 = c2528k.m7081c(2);
                                break;
                            case 3:
                                c = c2528k.m7081c(8) + 29;
                                i5 = c2528k.m7081c(2);
                                break;
                            default:
                                obj2 = obj;
                                i5 = 0;
                                i6 = 0;
                                break;
                        }
                    }
                    obj2 = obj;
                    i5 = 0;
                } else {
                    c = 3 + c2528k.m7081c(3);
                    i5 = c2528k.m7081c(2);
                }
                obj2 = obj;
                i6 = c;
                if (!(i6 == 0 || paint2 == null)) {
                    if (bArr != null) {
                        i5 = bArr[i5];
                    }
                    paint2.setColor(iArr[i5]);
                    canvas2 = canvas;
                    canvas2.drawRect((float) i4, (float) i3, (float) (i4 + i6), (float) (i3 + 1), paint);
                }
                i4 += i6;
                if (obj2 != null) {
                    return i4;
                }
                obj = obj2;
            }
            i6 = 1;
            if (bArr != null) {
                i5 = bArr[i5];
            }
            paint2.setColor(iArr[i5]);
            canvas2 = canvas;
            canvas2.drawRect((float) i4, (float) i3, (float) (i4 + i6), (float) (i3 + 1), paint);
            i4 += i6;
            if (obj2 != null) {
                return i4;
            }
            obj = obj2;
        }
    }

    /* renamed from: b */
    private static int m6780b(C2528k c2528k, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        C2528k c2528k2 = c2528k;
        int i3 = i2;
        Paint paint2 = paint;
        int i4 = i;
        Object obj = null;
        while (true) {
            Object obj2;
            int i5;
            int i6;
            Canvas canvas2;
            int c = c2528k.m7081c(4);
            if (c != 0) {
                obj2 = obj;
                i5 = c;
            } else {
                if (c2528k.m7084e()) {
                    if (c2528k.m7084e()) {
                        switch (c2528k.m7081c(2)) {
                            case 0:
                                obj2 = obj;
                                i5 = 0;
                                break;
                            case 1:
                                obj2 = obj;
                                i5 = 0;
                                i6 = 2;
                                break;
                            case 2:
                                c = c2528k.m7081c(4) + 9;
                                i5 = c2528k.m7081c(4);
                                break;
                            case 3:
                                c = c2528k.m7081c(8) + 25;
                                i5 = c2528k.m7081c(4);
                                break;
                            default:
                                obj2 = obj;
                                i5 = 0;
                                i6 = 0;
                                break;
                        }
                    }
                    c = c2528k.m7081c(2) + 4;
                    i5 = c2528k.m7081c(4);
                    obj2 = obj;
                    i6 = c;
                } else {
                    i5 = c2528k.m7081c(3);
                    if (i5 != 0) {
                        obj2 = obj;
                        i6 = i5 + 2;
                        i5 = 0;
                    } else {
                        i5 = 0;
                        i6 = 0;
                        obj2 = 1;
                    }
                }
                if (!(i6 == 0 || paint2 == null)) {
                    if (bArr != null) {
                        i5 = bArr[i5];
                    }
                    paint2.setColor(iArr[i5]);
                    canvas2 = canvas;
                    canvas2.drawRect((float) i4, (float) i3, (float) (i4 + i6), (float) (i3 + 1), paint);
                }
                i4 += i6;
                if (obj2 != null) {
                    return i4;
                }
                obj = obj2;
            }
            i6 = 1;
            if (bArr != null) {
                i5 = bArr[i5];
            }
            paint2.setColor(iArr[i5]);
            canvas2 = canvas;
            canvas2.drawRect((float) i4, (float) i3, (float) (i4 + i6), (float) (i3 + 1), paint);
            i4 += i6;
            if (obj2 != null) {
                return i4;
            }
            obj = obj2;
        }
    }

    /* renamed from: c */
    private static int m6784c(C2528k c2528k, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        C2528k c2528k2 = c2528k;
        int i3 = i2;
        Paint paint2 = paint;
        int i4 = i;
        Object obj = null;
        while (true) {
            Object obj2;
            int i5;
            int i6;
            int c = c2528k.m7081c(8);
            if (c != 0) {
                obj2 = obj;
                i5 = c;
                i6 = 1;
            } else if (c2528k.m7084e()) {
                c = c2528k.m7081c(7);
                i5 = c2528k.m7081c(8);
                obj2 = obj;
                i6 = c;
            } else {
                i5 = c2528k.m7081c(7);
                if (i5 != 0) {
                    obj2 = obj;
                    i6 = i5;
                    i5 = 0;
                } else {
                    i5 = 0;
                    i6 = 0;
                    obj2 = 1;
                }
            }
            if (!(i6 == 0 || paint2 == null)) {
                if (bArr != null) {
                    i5 = bArr[i5];
                }
                paint2.setColor(iArr[i5]);
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) i4, (float) i3, (float) (i4 + i6), (float) (i3 + 1), paint);
            }
            i4 += i6;
            if (obj2 != null) {
                return i4;
            }
            obj = obj2;
        }
    }

    /* renamed from: a */
    private static byte[] m6779a(int i, int i2, C2528k c2528k) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c2528k.m7081c(i2);
        }
        return bArr;
    }
}
