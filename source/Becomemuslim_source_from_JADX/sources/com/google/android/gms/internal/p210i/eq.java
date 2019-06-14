package com.google.android.gms.internal.p210i;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.i.eq */
public abstract class eq extends dx {
    /* renamed from: b */
    private static final Logger f24485b = Logger.getLogger(eq.class.getName());
    /* renamed from: c */
    private static final boolean f24486c = ih.m20824a();
    /* renamed from: a */
    es f24487a = this;

    /* renamed from: com.google.android.gms.internal.i.eq$c */
    public static class C4994c extends IOException {
        C4994c() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        C4994c(String str) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            str = String.valueOf(str);
            super(str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
        }

        C4994c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        C4994c(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            str = String.valueOf(str);
            super(str.length() != 0 ? valueOf.concat(str) : new String(valueOf), th);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.eq$a */
    static class C7813a extends eq {
        /* renamed from: b */
        private final byte[] f28885b;
        /* renamed from: c */
        private final int f28886c;
        /* renamed from: d */
        private final int f28887d;
        /* renamed from: e */
        private int f28888e;

        C7813a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i + i2;
                if (((i | i2) | (bArr.length - i3)) >= 0) {
                    this.f28885b = bArr;
                    this.f28886c = i;
                    this.f28888e = i;
                    this.f28887d = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        /* renamed from: a */
        public void mo6169a() {
        }

        /* renamed from: a */
        public final void mo6172a(int i, int i2) {
            mo6186b((i << 3) | i2);
        }

        /* renamed from: b */
        public final void mo6187b(int i, int i2) {
            mo6172a(i, 0);
            mo6171a(i2);
        }

        /* renamed from: c */
        public final void mo6191c(int i, int i2) {
            mo6172a(i, 0);
            mo6186b(i2);
        }

        /* renamed from: e */
        public final void mo6196e(int i, int i2) {
            mo6172a(i, 5);
            mo6195d(i2);
        }

        /* renamed from: a */
        public final void mo6173a(int i, long j) {
            mo6172a(i, 0);
            mo6179a(j);
        }

        /* renamed from: c */
        public final void mo6192c(int i, long j) {
            mo6172a(i, 1);
            mo6193c(j);
        }

        /* renamed from: a */
        public final void mo6178a(int i, boolean z) {
            mo6172a(i, 0);
            mo6170a((byte) z);
        }

        /* renamed from: a */
        public final void mo6177a(int i, String str) {
            mo6172a(i, 2);
            mo6183a(str);
        }

        /* renamed from: a */
        public final void mo6174a(int i, dy dyVar) {
            mo6172a(i, 2);
            mo6180a(dyVar);
        }

        /* renamed from: a */
        public final void mo6180a(dy dyVar) {
            mo6186b(dyVar.mo6160a());
            dyVar.mo6164a((dx) this);
        }

        /* renamed from: c */
        public final void mo6194c(byte[] bArr, int i, int i2) {
            mo6186b(i2);
            mo6190b(bArr, 0, i2);
        }

        /* renamed from: a */
        public final void mo6175a(int i, gt gtVar) {
            mo6172a(i, 2);
            mo6181a(gtVar);
        }

        /* renamed from: a */
        final void mo6176a(int i, gt gtVar, hi hiVar) {
            mo6172a(i, 2);
            dr drVar = (dr) gtVar;
            int n = drVar.mo6735n();
            if (n == -1) {
                n = hiVar.mo4573b(drVar);
                drVar.mo6733a(n);
            }
            mo6186b(n);
            hiVar.mo4571a((Object) gtVar, this.a);
        }

        /* renamed from: b */
        public final void mo6189b(int i, gt gtVar) {
            mo6172a(1, 3);
            mo6191c(2, i);
            mo6175a(3, gtVar);
            mo6172a(1, 4);
        }

        /* renamed from: b */
        public final void mo6188b(int i, dy dyVar) {
            mo6172a(1, 3);
            mo6191c(2, i);
            mo6174a(3, dyVar);
            mo6172a(1, 4);
        }

        /* renamed from: a */
        public final void mo6181a(gt gtVar) {
            mo6186b(gtVar.mo6736r());
            gtVar.mo6734a(this);
        }

        /* renamed from: a */
        final void mo6182a(gt gtVar, hi hiVar) {
            dr drVar = (dr) gtVar;
            int n = drVar.mo6735n();
            if (n == -1) {
                n = hiVar.mo4573b(drVar);
                drVar.mo6733a(n);
            }
            mo6186b(n);
            hiVar.mo4571a((Object) gtVar, this.a);
        }

        /* renamed from: a */
        public final void mo6170a(byte b) {
            try {
                byte[] bArr = this.f28885b;
                int i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = b;
            } catch (byte b2) {
                throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f28888e), Integer.valueOf(this.f28887d), Integer.valueOf(1)}), b2);
            }
        }

        /* renamed from: a */
        public final void mo6171a(int i) {
            if (i >= 0) {
                mo6186b(i);
            } else {
                mo6179a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo6186b(int i) {
            byte[] bArr;
            int i2;
            if (!eq.f24486c || dv.m20447a() || mo6185b() < 5) {
                while ((i & -128) != 0) {
                    bArr = this.f28885b;
                    i2 = this.f28888e;
                    this.f28888e = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    bArr = this.f28885b;
                    i2 = this.f28888e;
                    this.f28888e = i2 + 1;
                    bArr[i2] = (byte) i;
                } catch (int i3) {
                    throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f28888e), Integer.valueOf(this.f28887d), Integer.valueOf(1)}), i3);
                }
            } else if ((i3 & -128) == 0) {
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                ih.m20822a(bArr, (long) i2, (byte) i3);
            } else {
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                ih.m20822a(bArr, (long) i2, (byte) (i3 | 128));
                i3 >>>= 7;
                if ((i3 & -128) == 0) {
                    bArr = this.f28885b;
                    i2 = this.f28888e;
                    this.f28888e = i2 + 1;
                    ih.m20822a(bArr, (long) i2, (byte) i3);
                    return;
                }
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                ih.m20822a(bArr, (long) i2, (byte) (i3 | 128));
                i3 >>>= 7;
                if ((i3 & -128) == 0) {
                    bArr = this.f28885b;
                    i2 = this.f28888e;
                    this.f28888e = i2 + 1;
                    ih.m20822a(bArr, (long) i2, (byte) i3);
                    return;
                }
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                ih.m20822a(bArr, (long) i2, (byte) (i3 | 128));
                i3 >>>= 7;
                if ((i3 & -128) == 0) {
                    bArr = this.f28885b;
                    i2 = this.f28888e;
                    this.f28888e = i2 + 1;
                    ih.m20822a(bArr, (long) i2, (byte) i3);
                    return;
                }
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                ih.m20822a(bArr, (long) i2, (byte) (i3 | 128));
                i3 >>>= 7;
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                ih.m20822a(bArr, (long) i2, (byte) i3);
            }
        }

        /* renamed from: d */
        public final void mo6195d(int i) {
            try {
                byte[] bArr = this.f28885b;
                int i2 = this.f28888e;
                this.f28888e = i2 + 1;
                bArr[i2] = (byte) i;
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                bArr[i2] = (byte) (i >> 16);
                bArr = this.f28885b;
                i2 = this.f28888e;
                this.f28888e = i2 + 1;
                bArr[i2] = (byte) (i >>> 24);
            } catch (int i3) {
                throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f28888e), Integer.valueOf(this.f28887d), Integer.valueOf(1)}), i3);
            }
        }

        /* renamed from: a */
        public final void mo6179a(long j) {
            byte[] bArr;
            if (!eq.f24486c || mo6185b() < 10) {
                while ((j & -128) != 0) {
                    bArr = this.f28885b;
                    int i = this.f28888e;
                    this.f28888e = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    bArr = this.f28885b;
                    int i2 = this.f28888e;
                    this.f28888e = i2 + 1;
                    bArr[i2] = (byte) ((int) j);
                    return;
                } catch (long j2) {
                    throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f28888e), Integer.valueOf(this.f28887d), Integer.valueOf(1)}), j2);
                }
            }
            while ((j2 & -128) != 0) {
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                ih.m20822a(bArr, (long) i, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            bArr = this.f28885b;
            i2 = this.f28888e;
            this.f28888e = i2 + 1;
            ih.m20822a(bArr, (long) i2, (byte) ((int) j2));
        }

        /* renamed from: c */
        public final void mo6193c(long j) {
            try {
                byte[] bArr = this.f28885b;
                int i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) j);
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 8));
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 16));
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 24));
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 32));
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 40));
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 48));
                bArr = this.f28885b;
                i = this.f28888e;
                this.f28888e = i + 1;
                bArr[i] = (byte) ((int) (j >> 56));
            } catch (long j2) {
                throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f28888e), Integer.valueOf(this.f28887d), Integer.valueOf(1)}), j2);
            }
        }

        /* renamed from: b */
        public final void mo6190b(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f28885b, this.f28888e, i2);
                this.f28888e += i2;
            } catch (byte[] bArr2) {
                throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f28888e), Integer.valueOf(this.f28887d), Integer.valueOf(i2)}), bArr2);
            }
        }

        /* renamed from: a */
        public final void mo6184a(byte[] bArr, int i, int i2) {
            mo6190b(bArr, i, i2);
        }

        /* renamed from: a */
        public final void mo6183a(String str) {
            int i = this.f28888e;
            try {
                int g = eq.m31468g(str.length() * 3);
                int g2 = eq.m31468g(str.length());
                if (g2 == g) {
                    this.f28888e = i + g2;
                    g = ij.m20857a(str, this.f28885b, this.f28888e, mo6185b());
                    this.f28888e = i;
                    mo6186b((g - i) - g2);
                    this.f28888e = g;
                    return;
                }
                mo6186b(ij.m20856a((CharSequence) str));
                this.f28888e = ij.m20857a(str, this.f28885b, this.f28888e, mo6185b());
            } catch (io e) {
                this.f28888e = i;
                m31504a(str, e);
            } catch (Throwable e2) {
                throw new C4994c(e2);
            }
        }

        /* renamed from: b */
        public final int mo6185b() {
            return this.f28887d - this.f28888e;
        }

        /* renamed from: d */
        public final int m37867d() {
            return this.f28888e - this.f28886c;
        }
    }

    /* renamed from: com.google.android.gms.internal.i.eq$d */
    static final class C7814d extends eq {
        /* renamed from: b */
        private final ByteBuffer f28889b;
        /* renamed from: c */
        private final ByteBuffer f28890c;
        /* renamed from: d */
        private final int f28891d;

        C7814d(ByteBuffer byteBuffer) {
            super();
            this.f28889b = byteBuffer;
            this.f28890c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f28891d = byteBuffer.position();
        }

        /* renamed from: a */
        public final void mo6172a(int i, int i2) {
            mo6186b((i << 3) | i2);
        }

        /* renamed from: b */
        public final void mo6187b(int i, int i2) {
            mo6172a(i, 0);
            mo6171a(i2);
        }

        /* renamed from: c */
        public final void mo6191c(int i, int i2) {
            mo6172a(i, 0);
            mo6186b(i2);
        }

        /* renamed from: e */
        public final void mo6196e(int i, int i2) {
            mo6172a(i, 5);
            mo6195d(i2);
        }

        /* renamed from: a */
        public final void mo6173a(int i, long j) {
            mo6172a(i, 0);
            mo6179a(j);
        }

        /* renamed from: c */
        public final void mo6192c(int i, long j) {
            mo6172a(i, 1);
            mo6193c(j);
        }

        /* renamed from: a */
        public final void mo6178a(int i, boolean z) {
            mo6172a(i, 0);
            mo6170a((byte) z);
        }

        /* renamed from: a */
        public final void mo6177a(int i, String str) {
            mo6172a(i, 2);
            mo6183a(str);
        }

        /* renamed from: a */
        public final void mo6174a(int i, dy dyVar) {
            mo6172a(i, 2);
            mo6180a(dyVar);
        }

        /* renamed from: a */
        public final void mo6175a(int i, gt gtVar) {
            mo6172a(i, 2);
            mo6181a(gtVar);
        }

        /* renamed from: a */
        final void mo6176a(int i, gt gtVar, hi hiVar) {
            mo6172a(i, 2);
            mo6182a(gtVar, hiVar);
        }

        /* renamed from: b */
        public final void mo6189b(int i, gt gtVar) {
            mo6172a(1, 3);
            mo6191c(2, i);
            mo6175a(3, gtVar);
            mo6172a(1, 4);
        }

        /* renamed from: b */
        public final void mo6188b(int i, dy dyVar) {
            mo6172a(1, 3);
            mo6191c(2, i);
            mo6174a(3, dyVar);
            mo6172a(1, 4);
        }

        /* renamed from: a */
        public final void mo6181a(gt gtVar) {
            mo6186b(gtVar.mo6736r());
            gtVar.mo6734a(this);
        }

        /* renamed from: a */
        final void mo6182a(gt gtVar, hi hiVar) {
            dr drVar = (dr) gtVar;
            int n = drVar.mo6735n();
            if (n == -1) {
                n = hiVar.mo4573b(drVar);
                drVar.mo6733a(n);
            }
            mo6186b(n);
            hiVar.mo4571a((Object) gtVar, this.a);
        }

        /* renamed from: a */
        public final void mo6170a(byte b) {
            try {
                this.f28890c.put(b);
            } catch (Throwable e) {
                throw new C4994c(e);
            }
        }

        /* renamed from: a */
        public final void mo6180a(dy dyVar) {
            mo6186b(dyVar.mo6160a());
            dyVar.mo6164a((dx) this);
        }

        /* renamed from: c */
        public final void mo6194c(byte[] bArr, int i, int i2) {
            mo6186b(i2);
            mo6190b(bArr, 0, i2);
        }

        /* renamed from: a */
        public final void mo6171a(int i) {
            if (i >= 0) {
                mo6186b(i);
            } else {
                mo6179a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo6186b(int i) {
            while ((i & -128) != 0) {
                this.f28890c.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.f28890c.put((byte) i);
            } catch (Throwable e) {
                throw new C4994c(e);
            }
        }

        /* renamed from: d */
        public final void mo6195d(int i) {
            try {
                this.f28890c.putInt(i);
            } catch (Throwable e) {
                throw new C4994c(e);
            }
        }

        /* renamed from: a */
        public final void mo6179a(long j) {
            while ((-128 & j) != 0) {
                this.f28890c.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.f28890c.put((byte) ((int) j));
            } catch (Throwable e) {
                throw new C4994c(e);
            }
        }

        /* renamed from: c */
        public final void mo6193c(long j) {
            try {
                this.f28890c.putLong(j);
            } catch (Throwable e) {
                throw new C4994c(e);
            }
        }

        /* renamed from: b */
        public final void mo6190b(byte[] bArr, int i, int i2) {
            try {
                this.f28890c.put(bArr, i, i2);
            } catch (Throwable e) {
                throw new C4994c(e);
            } catch (Throwable e2) {
                throw new C4994c(e2);
            }
        }

        /* renamed from: a */
        public final void mo6184a(byte[] bArr, int i, int i2) {
            mo6190b(bArr, i, i2);
        }

        /* renamed from: a */
        public final void mo6183a(String str) {
            int position = this.f28890c.position();
            try {
                int g = eq.m31468g(str.length() * 3);
                int g2 = eq.m31468g(str.length());
                if (g2 == g) {
                    g = this.f28890c.position() + g2;
                    this.f28890c.position(g);
                    m37870c(str);
                    g2 = this.f28890c.position();
                    this.f28890c.position(position);
                    mo6186b(g2 - g);
                    this.f28890c.position(g2);
                    return;
                }
                mo6186b(ij.m20856a((CharSequence) str));
                m37870c(str);
            } catch (io e) {
                this.f28890c.position(position);
                m31504a(str, e);
            } catch (Throwable e2) {
                throw new C4994c(e2);
            }
        }

        /* renamed from: a */
        public final void mo6169a() {
            this.f28889b.position(this.f28890c.position());
        }

        /* renamed from: b */
        public final int mo6185b() {
            return this.f28890c.remaining();
        }

        /* renamed from: c */
        private final void m37870c(String str) {
            try {
                ij.m20858a((CharSequence) str, this.f28890c);
            } catch (Throwable e) {
                throw new C4994c(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.i.eq$e */
    static final class C7815e extends eq {
        /* renamed from: b */
        private final ByteBuffer f28892b;
        /* renamed from: c */
        private final ByteBuffer f28893c;
        /* renamed from: d */
        private final long f28894d;
        /* renamed from: e */
        private final long f28895e;
        /* renamed from: f */
        private final long f28896f;
        /* renamed from: g */
        private final long f28897g = (this.f28896f - 10);
        /* renamed from: h */
        private long f28898h = this.f28895e;

        C7815e(ByteBuffer byteBuffer) {
            super();
            this.f28892b = byteBuffer;
            this.f28893c = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f28894d = ih.m20811a(byteBuffer);
            this.f28895e = this.f28894d + ((long) byteBuffer.position());
            this.f28896f = this.f28894d + ((long) byteBuffer.limit());
        }

        /* renamed from: a */
        public final void mo6172a(int i, int i2) {
            mo6186b((i << 3) | i2);
        }

        /* renamed from: b */
        public final void mo6187b(int i, int i2) {
            mo6172a(i, 0);
            mo6171a(i2);
        }

        /* renamed from: c */
        public final void mo6191c(int i, int i2) {
            mo6172a(i, 0);
            mo6186b(i2);
        }

        /* renamed from: e */
        public final void mo6196e(int i, int i2) {
            mo6172a(i, 5);
            mo6195d(i2);
        }

        /* renamed from: a */
        public final void mo6173a(int i, long j) {
            mo6172a(i, 0);
            mo6179a(j);
        }

        /* renamed from: c */
        public final void mo6192c(int i, long j) {
            mo6172a(i, 1);
            mo6193c(j);
        }

        /* renamed from: a */
        public final void mo6178a(int i, boolean z) {
            mo6172a(i, 0);
            mo6170a((byte) z);
        }

        /* renamed from: a */
        public final void mo6177a(int i, String str) {
            mo6172a(i, 2);
            mo6183a(str);
        }

        /* renamed from: a */
        public final void mo6174a(int i, dy dyVar) {
            mo6172a(i, 2);
            mo6180a(dyVar);
        }

        /* renamed from: a */
        public final void mo6175a(int i, gt gtVar) {
            mo6172a(i, 2);
            mo6181a(gtVar);
        }

        /* renamed from: a */
        final void mo6176a(int i, gt gtVar, hi hiVar) {
            mo6172a(i, 2);
            mo6182a(gtVar, hiVar);
        }

        /* renamed from: b */
        public final void mo6189b(int i, gt gtVar) {
            mo6172a(1, 3);
            mo6191c(2, i);
            mo6175a(3, gtVar);
            mo6172a(1, 4);
        }

        /* renamed from: b */
        public final void mo6188b(int i, dy dyVar) {
            mo6172a(1, 3);
            mo6191c(2, i);
            mo6174a(3, dyVar);
            mo6172a(1, 4);
        }

        /* renamed from: a */
        public final void mo6181a(gt gtVar) {
            mo6186b(gtVar.mo6736r());
            gtVar.mo6734a(this);
        }

        /* renamed from: a */
        final void mo6182a(gt gtVar, hi hiVar) {
            dr drVar = (dr) gtVar;
            int n = drVar.mo6735n();
            if (n == -1) {
                n = hiVar.mo4573b(drVar);
                drVar.mo6733a(n);
            }
            mo6186b(n);
            hiVar.mo4571a((Object) gtVar, this.a);
        }

        /* renamed from: a */
        public final void mo6170a(byte b) {
            if (this.f28898h < this.f28896f) {
                long j = this.f28898h;
                this.f28898h = 1 + j;
                ih.m20814a(j, b);
                return;
            }
            throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f28898h), Long.valueOf(this.f28896f), Integer.valueOf(1)}));
        }

        /* renamed from: a */
        public final void mo6180a(dy dyVar) {
            mo6186b(dyVar.mo6160a());
            dyVar.mo6164a((dx) this);
        }

        /* renamed from: c */
        public final void mo6194c(byte[] bArr, int i, int i2) {
            mo6186b(i2);
            mo6190b(bArr, 0, i2);
        }

        /* renamed from: a */
        public final void mo6171a(int i) {
            if (i >= 0) {
                mo6186b(i);
            } else {
                mo6179a((long) i);
            }
        }

        /* renamed from: b */
        public final void mo6186b(int i) {
            long j;
            if (this.f28898h <= this.f28897g) {
                while ((i & -128) != 0) {
                    j = this.f28898h;
                    this.f28898h = j + 1;
                    ih.m20814a(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                j = this.f28898h;
                this.f28898h = 1 + j;
                ih.m20814a(j, (byte) i);
                return;
            }
            while (this.f28898h < this.f28896f) {
                if ((i & -128) == 0) {
                    j = this.f28898h;
                    this.f28898h = 1 + j;
                    ih.m20814a(j, (byte) i);
                    return;
                }
                j = this.f28898h;
                this.f28898h = j + 1;
                ih.m20814a(j, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f28898h), Long.valueOf(this.f28896f), Integer.valueOf(1)}));
        }

        /* renamed from: d */
        public final void mo6195d(int i) {
            this.f28893c.putInt((int) (this.f28898h - this.f28894d), i);
            this.f28898h += 4;
        }

        /* renamed from: a */
        public final void mo6179a(long j) {
            long j2;
            if (this.f28898h <= this.f28897g) {
                while ((j & -128) != 0) {
                    j2 = this.f28898h;
                    this.f28898h = j2 + 1;
                    ih.m20814a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                j2 = this.f28898h;
                this.f28898h = 1 + j2;
                ih.m20814a(j2, (byte) ((int) j));
                return;
            }
            while (this.f28898h < this.f28896f) {
                if ((j & -128) == 0) {
                    j2 = this.f28898h;
                    this.f28898h = 1 + j2;
                    ih.m20814a(j2, (byte) ((int) j));
                    return;
                }
                j2 = this.f28898h;
                this.f28898h = j2 + 1;
                ih.m20814a(j2, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f28898h), Long.valueOf(this.f28896f), Integer.valueOf(1)}));
        }

        /* renamed from: c */
        public final void mo6193c(long j) {
            this.f28893c.putLong((int) (this.f28898h - this.f28894d), j);
            this.f28898h += 8;
        }

        /* renamed from: b */
        public final void mo6190b(byte[] bArr, int i, int i2) {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                if (this.f28896f - j >= this.f28898h) {
                    ih.m20823a(bArr, (long) i, this.f28898h, j);
                    this.f28898h += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new C4994c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f28898h), Long.valueOf(this.f28896f), Integer.valueOf(i2)}));
        }

        /* renamed from: a */
        public final void mo6184a(byte[] bArr, int i, int i2) {
            mo6190b(bArr, i, i2);
        }

        /* renamed from: a */
        public final void mo6183a(String str) {
            long j = this.f28898h;
            try {
                int g = eq.m31468g(str.length() * 3);
                int g2 = eq.m31468g(str.length());
                if (g2 == g) {
                    g = ((int) (this.f28898h - this.f28894d)) + g2;
                    this.f28893c.position(g);
                    ij.m20858a((CharSequence) str, this.f28893c);
                    g2 = this.f28893c.position() - g;
                    mo6186b(g2);
                    this.f28898h += (long) g2;
                    return;
                }
                g = ij.m20856a((CharSequence) str);
                mo6186b(g);
                m37899i(this.f28898h);
                ij.m20858a((CharSequence) str, this.f28893c);
                this.f28898h += (long) g;
            } catch (io e) {
                this.f28898h = j;
                m37899i(this.f28898h);
                m31504a(str, e);
            } catch (Throwable e2) {
                throw new C4994c(e2);
            } catch (Throwable e22) {
                throw new C4994c(e22);
            }
        }

        /* renamed from: a */
        public final void mo6169a() {
            this.f28892b.position((int) (this.f28898h - this.f28894d));
        }

        /* renamed from: b */
        public final int mo6185b() {
            return (int) (this.f28896f - this.f28898h);
        }

        /* renamed from: i */
        private final void m37899i(long j) {
            this.f28893c.position((int) (j - this.f28894d));
        }
    }

    /* renamed from: com.google.android.gms.internal.i.eq$b */
    static final class C8217b extends C7813a {
        /* renamed from: b */
        private final ByteBuffer f32299b;
        /* renamed from: c */
        private int f32300c;

        C8217b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f32299b = byteBuffer;
            this.f32300c = byteBuffer.position();
        }

        /* renamed from: a */
        public final void mo6169a() {
            this.f32299b.position(this.f32300c + m37867d());
        }
    }

    /* renamed from: a */
    public static eq m31437a(byte[] bArr) {
        return new C7813a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static int m31438b(double d) {
        return 8;
    }

    /* renamed from: b */
    public static int m31439b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m31450b(boolean z) {
        return 1;
    }

    /* renamed from: e */
    public static int m31463e(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    /* renamed from: g */
    public static int m31468g(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: g */
    public static int m31471g(long j) {
        return 8;
    }

    /* renamed from: h */
    public static int m31475h(long j) {
        return 8;
    }

    /* renamed from: i */
    public static int m31476i(int i) {
        return 4;
    }

    /* renamed from: i */
    private static long m31478i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: j */
    public static int m31479j(int i) {
        return 4;
    }

    /* renamed from: m */
    private static int m31484m(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: a */
    public abstract void mo6169a();

    /* renamed from: a */
    public abstract void mo6170a(byte b);

    /* renamed from: a */
    public abstract void mo6171a(int i);

    /* renamed from: a */
    public abstract void mo6172a(int i, int i2);

    /* renamed from: a */
    public abstract void mo6173a(int i, long j);

    /* renamed from: a */
    public abstract void mo6174a(int i, dy dyVar);

    /* renamed from: a */
    public abstract void mo6175a(int i, gt gtVar);

    /* renamed from: a */
    abstract void mo6176a(int i, gt gtVar, hi hiVar);

    /* renamed from: a */
    public abstract void mo6177a(int i, String str);

    /* renamed from: a */
    public abstract void mo6178a(int i, boolean z);

    /* renamed from: a */
    public abstract void mo6179a(long j);

    /* renamed from: a */
    public abstract void mo6180a(dy dyVar);

    /* renamed from: a */
    public abstract void mo6181a(gt gtVar);

    /* renamed from: a */
    abstract void mo6182a(gt gtVar, hi hiVar);

    /* renamed from: a */
    public abstract void mo6183a(String str);

    /* renamed from: b */
    public abstract int mo6185b();

    /* renamed from: b */
    public abstract void mo6186b(int i);

    /* renamed from: b */
    public abstract void mo6187b(int i, int i2);

    /* renamed from: b */
    public abstract void mo6188b(int i, dy dyVar);

    /* renamed from: b */
    public abstract void mo6189b(int i, gt gtVar);

    /* renamed from: b */
    public abstract void mo6190b(byte[] bArr, int i, int i2);

    /* renamed from: c */
    public abstract void mo6191c(int i, int i2);

    /* renamed from: c */
    public abstract void mo6192c(int i, long j);

    /* renamed from: c */
    public abstract void mo6193c(long j);

    /* renamed from: c */
    abstract void mo6194c(byte[] bArr, int i, int i2);

    /* renamed from: d */
    public abstract void mo6195d(int i);

    /* renamed from: e */
    public abstract void mo6196e(int i, int i2);

    /* renamed from: a */
    public static eq m31436a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new C8217b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (ih.m20829b()) {
            return new C7815e(byteBuffer);
        } else {
            return new C7814d(byteBuffer);
        }
    }

    private eq() {
    }

    /* renamed from: d */
    public final void m31520d(int i, int i2) {
        mo6191c(i, eq.m31484m(i2));
    }

    /* renamed from: b */
    public final void m31509b(int i, long j) {
        mo6173a(i, eq.m31478i(j));
    }

    /* renamed from: a */
    public final void m31491a(int i, float f) {
        mo6196e(i, Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void m31490a(int i, double d) {
        mo6192c(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: c */
    public final void m31514c(int i) {
        mo6186b(eq.m31484m(i));
    }

    /* renamed from: b */
    public final void m31512b(long j) {
        mo6179a(eq.m31478i(j));
    }

    /* renamed from: a */
    public final void m31488a(float f) {
        mo6195d(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void m31487a(double d) {
        mo6193c(Double.doubleToRawLongBits(d));
    }

    /* renamed from: a */
    public final void m31505a(boolean z) {
        mo6170a((byte) z);
    }

    /* renamed from: f */
    public static int m31465f(int i, int i2) {
        return eq.m31461e(i) + eq.m31464f(i2);
    }

    /* renamed from: g */
    public static int m31469g(int i, int i2) {
        return eq.m31461e(i) + eq.m31468g(i2);
    }

    /* renamed from: h */
    public static int m31473h(int i, int i2) {
        return eq.m31461e(i) + eq.m31468g(eq.m31484m(i2));
    }

    /* renamed from: i */
    public static int m31477i(int i, int i2) {
        return eq.m31461e(i) + 4;
    }

    /* renamed from: j */
    public static int m31480j(int i, int i2) {
        return eq.m31461e(i) + 4;
    }

    /* renamed from: d */
    public static int m31457d(int i, long j) {
        return eq.m31461e(i) + eq.m31463e(j);
    }

    /* renamed from: e */
    public static int m31462e(int i, long j) {
        return eq.m31461e(i) + eq.m31463e(j);
    }

    /* renamed from: f */
    public static int m31466f(int i, long j) {
        return eq.m31461e(i) + eq.m31463e(eq.m31478i(j));
    }

    /* renamed from: g */
    public static int m31470g(int i, long j) {
        return eq.m31461e(i) + 8;
    }

    /* renamed from: h */
    public static int m31474h(int i, long j) {
        return eq.m31461e(i) + 8;
    }

    /* renamed from: b */
    public static int m31441b(int i, float f) {
        return eq.m31461e(i) + 4;
    }

    /* renamed from: b */
    public static int m31440b(int i, double d) {
        return eq.m31461e(i) + 8;
    }

    /* renamed from: b */
    public static int m31445b(int i, boolean z) {
        return eq.m31461e(i) + 1;
    }

    /* renamed from: k */
    public static int m31482k(int i, int i2) {
        return eq.m31461e(i) + eq.m31464f(i2);
    }

    /* renamed from: b */
    public static int m31444b(int i, String str) {
        return eq.m31461e(i) + eq.m31449b(str);
    }

    /* renamed from: c */
    public static int m31452c(int i, dy dyVar) {
        i = eq.m31461e(i);
        int a = dyVar.mo6160a();
        return i + (eq.m31468g(a) + a);
    }

    /* renamed from: a */
    public static int m31434a(int i, fz fzVar) {
        i = eq.m31461e(i);
        int b = fzVar.m20581b();
        return i + (eq.m31468g(b) + b);
    }

    /* renamed from: c */
    public static int m31453c(int i, gt gtVar) {
        return eq.m31461e(i) + eq.m31447b(gtVar);
    }

    /* renamed from: b */
    static int m31443b(int i, gt gtVar, hi hiVar) {
        return eq.m31461e(i) + eq.m31448b(gtVar, hiVar);
    }

    /* renamed from: d */
    public static int m31459d(int i, gt gtVar) {
        return ((eq.m31461e(1) << 1) + eq.m31469g(2, i)) + eq.m31453c(3, gtVar);
    }

    /* renamed from: d */
    public static int m31458d(int i, dy dyVar) {
        return ((eq.m31461e(1) << 1) + eq.m31469g(2, i)) + eq.m31452c(3, dyVar);
    }

    /* renamed from: b */
    public static int m31442b(int i, fz fzVar) {
        return ((eq.m31461e(1) << 1) + eq.m31469g(2, i)) + eq.m31434a(3, fzVar);
    }

    /* renamed from: e */
    public static int m31461e(int i) {
        return eq.m31468g(i << 3);
    }

    /* renamed from: f */
    public static int m31464f(int i) {
        return i >= 0 ? eq.m31468g(i) : 10;
    }

    /* renamed from: h */
    public static int m31472h(int i) {
        return eq.m31468g(eq.m31484m(i));
    }

    /* renamed from: d */
    public static int m31460d(long j) {
        return eq.m31463e(j);
    }

    /* renamed from: f */
    public static int m31467f(long j) {
        return eq.m31463e(eq.m31478i(j));
    }

    /* renamed from: k */
    public static int m31481k(int i) {
        return eq.m31464f(i);
    }

    /* renamed from: b */
    public static int m31449b(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = com.google.android.gms.internal.p210i.ij.m20856a(r1);	 Catch:{ io -> 0x0005 }
        goto L_0x000c;
    L_0x0005:
        r0 = com.google.android.gms.internal.p210i.fm.f16617a;
        r1 = r1.getBytes(r0);
        r0 = r1.length;
    L_0x000c:
        r1 = com.google.android.gms.internal.p210i.eq.m31468g(r0);
        r1 = r1 + r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.eq.b(java.lang.String):int");
    }

    /* renamed from: a */
    public static int m31435a(fz fzVar) {
        int b = fzVar.m20581b();
        return eq.m31468g(b) + b;
    }

    /* renamed from: b */
    public static int m31446b(dy dyVar) {
        int a = dyVar.mo6160a();
        return eq.m31468g(a) + a;
    }

    /* renamed from: b */
    public static int m31451b(byte[] bArr) {
        int length = bArr.length;
        return eq.m31468g(length) + length;
    }

    /* renamed from: b */
    public static int m31447b(gt gtVar) {
        int r = gtVar.mo6736r();
        return eq.m31468g(r) + r;
    }

    /* renamed from: b */
    static int m31448b(gt gtVar, hi hiVar) {
        dr drVar = (dr) gtVar;
        int n = drVar.mo6735n();
        if (n == -1) {
            n = hiVar.mo4573b(drVar);
            drVar.mo6733a(n);
        }
        return eq.m31468g(n) + n;
    }

    /* renamed from: a */
    final void m31504a(String str, io ioVar) {
        f24485b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", ioVar);
        str = str.getBytes(fm.f16617a);
        try {
            mo6186b(str.length);
            mo6184a(str, null, str.length);
        } catch (Throwable e) {
            throw new C4994c(e);
        } catch (String str2) {
            throw str2;
        }
    }

    @Deprecated
    /* renamed from: c */
    static int m31454c(int i, gt gtVar, hi hiVar) {
        i = eq.m31461e(i) << 1;
        dr drVar = (dr) gtVar;
        int n = drVar.mo6735n();
        if (n == -1) {
            n = hiVar.mo4573b(drVar);
            drVar.mo6733a(n);
        }
        return i + n;
    }

    @Deprecated
    /* renamed from: c */
    public static int m31455c(gt gtVar) {
        return gtVar.mo6736r();
    }

    @Deprecated
    /* renamed from: l */
    public static int m31483l(int i) {
        return eq.m31468g(i);
    }
}
