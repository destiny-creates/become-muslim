package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class aaw extends aah {
    /* renamed from: b */
    private static final Logger f23530b = Logger.getLogger(aaw.class.getName());
    /* renamed from: c */
    private static final boolean f23531c = aep.m18232a();
    /* renamed from: a */
    aay f23532a = this;

    /* renamed from: com.google.android.gms.internal.ads.aaw$b */
    public static class C4917b extends IOException {
        C4917b() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        C4917b(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            str = String.valueOf(str);
            super(str.length() != 0 ? valueOf.concat(str) : new String(valueOf), th);
        }

        C4917b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.aaw$a */
    static class C7801a extends aaw {
        /* renamed from: b */
        private final byte[] f27982b;
        /* renamed from: c */
        private final int f27983c;
        /* renamed from: d */
        private final int f27984d;
        /* renamed from: e */
        private int f27985e;

        C7801a(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if (((i2 | 0) | (bArr.length - i3)) >= 0) {
                    this.f27982b = bArr;
                    this.f27983c = 0;
                    this.f27985e = 0;
                    this.f27984d = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        /* renamed from: a */
        public final int mo6046a() {
            return this.f27984d - this.f27985e;
        }

        /* renamed from: a */
        public final void mo6047a(byte b) {
            try {
                byte[] bArr = this.f27982b;
                int i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = b;
            } catch (Throwable e) {
                throw new C4917b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27985e), Integer.valueOf(this.f27984d), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: a */
        public final void mo6048a(int i) {
            if (i >= 0) {
                mo6061b(i);
            } else {
                mo6056a((long) i);
            }
        }

        /* renamed from: a */
        public final void mo6049a(int i, int i2) {
            mo6061b((i << 3) | i2);
        }

        /* renamed from: a */
        public final void mo6050a(int i, long j) {
            mo6049a(i, 0);
            mo6056a(j);
        }

        /* renamed from: a */
        public final void mo6051a(int i, aai aai) {
            mo6049a(i, 2);
            mo6057a(aai);
        }

        /* renamed from: a */
        public final void mo6052a(int i, acx acx) {
            mo6049a(1, 3);
            mo6065c(2, i);
            mo6049a(3, 2);
            mo6058a(acx);
            mo6049a(1, 4);
        }

        /* renamed from: a */
        final void mo6053a(int i, acx acx, adq adq) {
            mo6049a(i, 2);
            zx zxVar = (zx) acx;
            int j = zxVar.mo6636j();
            if (j == -1) {
                j = adq.mo3759b(zxVar);
                zxVar.mo6634a(j);
            }
            mo6061b(j);
            adq.mo3756a((Object) acx, this.a);
        }

        /* renamed from: a */
        public final void mo6054a(int i, String str) {
            mo6049a(i, 2);
            mo6059a(str);
        }

        /* renamed from: a */
        public final void mo6055a(int i, boolean z) {
            mo6049a(i, 0);
            mo6047a((byte) z);
        }

        /* renamed from: a */
        public final void mo6056a(long j) {
            byte[] bArr;
            if (!aaw.f23531c || mo6046a() < 10) {
                while ((j & -128) != 0) {
                    bArr = this.f27982b;
                    int i = this.f27985e;
                    this.f27985e = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    bArr = this.f27982b;
                    int i2 = this.f27985e;
                    this.f27985e = i2 + 1;
                    bArr[i2] = (byte) ((int) j);
                    return;
                } catch (Throwable e) {
                    throw new C4917b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27985e), Integer.valueOf(this.f27984d), Integer.valueOf(1)}), e);
                }
            }
            while ((j & -128) != 0) {
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                aep.m18231a(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            bArr = this.f27982b;
            i2 = this.f27985e;
            this.f27985e = i2 + 1;
            aep.m18231a(bArr, (long) i2, (byte) ((int) j));
        }

        /* renamed from: a */
        public final void mo6057a(aai aai) {
            mo6061b(aai.mo6036a());
            aai.mo6040a((aah) this);
        }

        /* renamed from: a */
        public final void mo6058a(acx acx) {
            mo6061b(acx.mo6637l());
            acx.mo6635a(this);
        }

        /* renamed from: a */
        public final void mo6059a(String str) {
            int i = this.f27985e;
            try {
                int g = aaw.m29624g(str.length() * 3);
                int g2 = aaw.m29624g(str.length());
                if (g2 == g) {
                    this.f27985e = i + g2;
                    g = aer.m18266a(str, this.f27982b, this.f27985e, mo6046a());
                    this.f27985e = i;
                    mo6061b((g - i) - g2);
                    this.f27985e = g;
                    return;
                }
                mo6061b(aer.m18265a((CharSequence) str));
                this.f27985e = aer.m18266a(str, this.f27982b, this.f27985e, mo6046a());
            } catch (aeu e) {
                this.f27985e = i;
                m29659a(str, e);
            } catch (Throwable e2) {
                throw new C4917b(e2);
            }
        }

        /* renamed from: a */
        public final void mo6060a(byte[] bArr, int i, int i2) {
            mo6064b(bArr, i, i2);
        }

        /* renamed from: b */
        public final void mo6061b(int i) {
            byte[] bArr;
            int i2;
            if (!aaw.f23531c || mo6046a() < 10) {
                while ((i & -128) != 0) {
                    bArr = this.f27982b;
                    i2 = this.f27985e;
                    this.f27985e = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    bArr = this.f27982b;
                    i2 = this.f27985e;
                    this.f27985e = i2 + 1;
                    bArr[i2] = (byte) i;
                    return;
                } catch (Throwable e) {
                    throw new C4917b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27985e), Integer.valueOf(this.f27984d), Integer.valueOf(1)}), e);
                }
            }
            while ((i & -128) != 0) {
                bArr = this.f27982b;
                i2 = this.f27985e;
                this.f27985e = i2 + 1;
                aep.m18231a(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            bArr = this.f27982b;
            i2 = this.f27985e;
            this.f27985e = i2 + 1;
            aep.m18231a(bArr, (long) i2, (byte) i);
        }

        /* renamed from: b */
        public final void mo6062b(int i, int i2) {
            mo6049a(i, 0);
            mo6048a(i2);
        }

        /* renamed from: b */
        public final void mo6063b(int i, aai aai) {
            mo6049a(1, 3);
            mo6065c(2, i);
            mo6051a(3, aai);
            mo6049a(1, 4);
        }

        /* renamed from: b */
        public final void mo6064b(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.f27982b, this.f27985e, i2);
                this.f27985e += i2;
            } catch (Throwable e) {
                throw new C4917b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27985e), Integer.valueOf(this.f27984d), Integer.valueOf(i2)}), e);
            }
        }

        /* renamed from: c */
        public final void mo6065c(int i, int i2) {
            mo6049a(i, 0);
            mo6061b(i2);
        }

        /* renamed from: c */
        public final void mo6066c(int i, long j) {
            mo6049a(i, 1);
            mo6067c(j);
        }

        /* renamed from: c */
        public final void mo6067c(long j) {
            try {
                byte[] bArr = this.f27982b;
                int i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) j);
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 8));
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 16));
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 24));
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 32));
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 40));
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 48));
                bArr = this.f27982b;
                i = this.f27985e;
                this.f27985e = i + 1;
                bArr[i] = (byte) ((int) (j >> 56));
            } catch (Throwable e) {
                throw new C4917b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27985e), Integer.valueOf(this.f27984d), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: c */
        public final void mo6068c(byte[] bArr, int i, int i2) {
            mo6061b(i2);
            mo6064b(bArr, 0, i2);
        }

        /* renamed from: d */
        public final void mo6069d(int i) {
            try {
                byte[] bArr = this.f27982b;
                int i2 = this.f27985e;
                this.f27985e = i2 + 1;
                bArr[i2] = (byte) i;
                bArr = this.f27982b;
                i2 = this.f27985e;
                this.f27985e = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                bArr = this.f27982b;
                i2 = this.f27985e;
                this.f27985e = i2 + 1;
                bArr[i2] = (byte) (i >> 16);
                bArr = this.f27982b;
                i2 = this.f27985e;
                this.f27985e = i2 + 1;
                bArr[i2] = i >> 24;
            } catch (Throwable e) {
                throw new C4917b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f27985e), Integer.valueOf(this.f27984d), Integer.valueOf(1)}), e);
            }
        }

        /* renamed from: e */
        public final void mo6070e(int i, int i2) {
            mo6049a(i, 5);
            mo6069d(i2);
        }
    }

    private aaw() {
    }

    /* renamed from: a */
    public static int m29592a(int i, ace ace) {
        i = m29617e(i);
        int b = ace.m17961b();
        return i + (m29624g(b) + b);
    }

    /* renamed from: a */
    public static int m29593a(ace ace) {
        int b = ace.m17961b();
        return m29624g(b) + b;
    }

    /* renamed from: a */
    static int m29594a(acx acx, adq adq) {
        zx zxVar = (zx) acx;
        int j = zxVar.mo6636j();
        if (j == -1) {
            j = adq.mo3759b(zxVar);
            zxVar.mo6634a(j);
        }
        return m29624g(j) + j;
    }

    /* renamed from: a */
    public static aaw m29595a(byte[] bArr) {
        return new C7801a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static int m29596b(double d) {
        return 8;
    }

    /* renamed from: b */
    public static int m29597b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m29598b(int i, double d) {
        return m29617e(i) + 8;
    }

    /* renamed from: b */
    public static int m29599b(int i, float f) {
        return m29617e(i) + 4;
    }

    /* renamed from: b */
    public static int m29600b(int i, ace ace) {
        return ((m29617e(1) << 1) + m29625g(2, i)) + m29592a(3, ace);
    }

    /* renamed from: b */
    public static int m29601b(int i, acx acx) {
        return ((m29617e(1) << 1) + m29625g(2, i)) + (m29617e(3) + m29606b(acx));
    }

    /* renamed from: b */
    static int m29602b(int i, acx acx, adq adq) {
        return m29617e(i) + m29594a(acx, adq);
    }

    /* renamed from: b */
    public static int m29603b(int i, String str) {
        return m29617e(i) + m29607b(str);
    }

    /* renamed from: b */
    public static int m29604b(int i, boolean z) {
        return m29617e(i) + 1;
    }

    /* renamed from: b */
    public static int m29605b(aai aai) {
        int a = aai.mo6036a();
        return m29624g(a) + a;
    }

    /* renamed from: b */
    public static int m29606b(acx acx) {
        int l = acx.mo6637l();
        return m29624g(l) + l;
    }

    /* renamed from: b */
    public static int m29607b(java.lang.String r1) {
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
        r0 = com.google.android.gms.internal.ads.aer.m18265a(r1);	 Catch:{ aeu -> 0x0005 }
        goto L_0x000c;
    L_0x0005:
        r0 = com.google.android.gms.internal.ads.abs.f14236a;
        r1 = r1.getBytes(r0);
        r0 = r1.length;
    L_0x000c:
        r1 = m29624g(r0);
        r1 = r1 + r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aaw.b(java.lang.String):int");
    }

    /* renamed from: b */
    public static int m29608b(boolean z) {
        return 1;
    }

    /* renamed from: b */
    public static int m29609b(byte[] bArr) {
        int length = bArr.length;
        return m29624g(length) + length;
    }

    /* renamed from: c */
    public static int m29610c(int i, aai aai) {
        i = m29617e(i);
        int a = aai.mo6036a();
        return i + (m29624g(a) + a);
    }

    @Deprecated
    /* renamed from: c */
    static int m29611c(int i, acx acx, adq adq) {
        i = m29617e(i) << 1;
        zx zxVar = (zx) acx;
        int j = zxVar.mo6636j();
        if (j == -1) {
            j = adq.mo3759b(zxVar);
            zxVar.mo6634a(j);
        }
        return i + j;
    }

    @Deprecated
    /* renamed from: c */
    public static int m29612c(acx acx) {
        return acx.mo6637l();
    }

    /* renamed from: d */
    public static int m29614d(int i, long j) {
        return m29617e(i) + m29619e(j);
    }

    /* renamed from: d */
    public static int m29615d(int i, aai aai) {
        return ((m29617e(1) << 1) + m29625g(2, i)) + m29610c(3, aai);
    }

    /* renamed from: d */
    public static int m29616d(long j) {
        return m29619e(j);
    }

    /* renamed from: e */
    public static int m29617e(int i) {
        return m29624g(i << 3);
    }

    /* renamed from: e */
    public static int m29618e(int i, long j) {
        return m29617e(i) + m29619e(j);
    }

    /* renamed from: e */
    public static int m29619e(long j) {
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

    /* renamed from: f */
    public static int m29620f(int i) {
        return i >= 0 ? m29624g(i) : 10;
    }

    /* renamed from: f */
    public static int m29621f(int i, int i2) {
        return m29617e(i) + m29620f(i2);
    }

    /* renamed from: f */
    public static int m29622f(int i, long j) {
        return m29617e(i) + m29619e(m29634i(j));
    }

    /* renamed from: f */
    public static int m29623f(long j) {
        return m29619e(m29634i(j));
    }

    /* renamed from: g */
    public static int m29624g(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: g */
    public static int m29625g(int i, int i2) {
        return m29617e(i) + m29624g(i2);
    }

    /* renamed from: g */
    public static int m29626g(int i, long j) {
        return m29617e(i) + 8;
    }

    /* renamed from: g */
    public static int m29627g(long j) {
        return 8;
    }

    /* renamed from: h */
    public static int m29628h(int i) {
        return m29624g(m29640m(i));
    }

    /* renamed from: h */
    public static int m29629h(int i, int i2) {
        return m29617e(i) + m29624g(m29640m(i2));
    }

    /* renamed from: h */
    public static int m29630h(int i, long j) {
        return m29617e(i) + 8;
    }

    /* renamed from: h */
    public static int m29631h(long j) {
        return 8;
    }

    /* renamed from: i */
    public static int m29632i(int i) {
        return 4;
    }

    /* renamed from: i */
    public static int m29633i(int i, int i2) {
        return m29617e(i) + 4;
    }

    /* renamed from: i */
    private static long m29634i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: j */
    public static int m29635j(int i) {
        return 4;
    }

    /* renamed from: j */
    public static int m29636j(int i, int i2) {
        return m29617e(i) + 4;
    }

    /* renamed from: k */
    public static int m29637k(int i) {
        return m29620f(i);
    }

    /* renamed from: k */
    public static int m29638k(int i, int i2) {
        return m29617e(i) + m29620f(i2);
    }

    @Deprecated
    /* renamed from: l */
    public static int m29639l(int i) {
        return m29624g(i);
    }

    /* renamed from: m */
    private static int m29640m(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: a */
    public abstract int mo6046a();

    /* renamed from: a */
    public abstract void mo6047a(byte b);

    /* renamed from: a */
    public final void m29643a(double d) {
        mo6067c(Double.doubleToRawLongBits(d));
    }

    /* renamed from: a */
    public final void m29644a(float f) {
        mo6069d(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public abstract void mo6048a(int i);

    /* renamed from: a */
    public final void m29646a(int i, double d) {
        mo6066c(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: a */
    public final void m29647a(int i, float f) {
        mo6070e(i, Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public abstract void mo6049a(int i, int i2);

    /* renamed from: a */
    public abstract void mo6050a(int i, long j);

    /* renamed from: a */
    public abstract void mo6051a(int i, aai aai);

    /* renamed from: a */
    public abstract void mo6052a(int i, acx acx);

    /* renamed from: a */
    abstract void mo6053a(int i, acx acx, adq adq);

    /* renamed from: a */
    public abstract void mo6054a(int i, String str);

    /* renamed from: a */
    public abstract void mo6055a(int i, boolean z);

    /* renamed from: a */
    public abstract void mo6056a(long j);

    /* renamed from: a */
    public abstract void mo6057a(aai aai);

    /* renamed from: a */
    public abstract void mo6058a(acx acx);

    /* renamed from: a */
    public abstract void mo6059a(String str);

    /* renamed from: a */
    final void m29659a(String str, aeu aeu) {
        f23530b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", aeu);
        byte[] bytes = str.getBytes(abs.f14236a);
        try {
            mo6061b(bytes.length);
            mo6060a(bytes, 0, bytes.length);
        } catch (Throwable e) {
            throw new C4917b(e);
        } catch (C4917b e2) {
            throw e2;
        }
    }

    /* renamed from: a */
    public final void m29660a(boolean z) {
        mo6047a((byte) z);
    }

    /* renamed from: b */
    public final void m29661b() {
        if (mo6046a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b */
    public abstract void mo6061b(int i);

    /* renamed from: b */
    public abstract void mo6062b(int i, int i2);

    /* renamed from: b */
    public final void m29664b(int i, long j) {
        mo6050a(i, m29634i(j));
    }

    /* renamed from: b */
    public abstract void mo6063b(int i, aai aai);

    /* renamed from: b */
    public final void m29666b(long j) {
        mo6056a(m29634i(j));
    }

    /* renamed from: b */
    public abstract void mo6064b(byte[] bArr, int i, int i2);

    /* renamed from: c */
    public final void m29668c(int i) {
        mo6061b(m29640m(i));
    }

    /* renamed from: c */
    public abstract void mo6065c(int i, int i2);

    /* renamed from: c */
    public abstract void mo6066c(int i, long j);

    /* renamed from: c */
    public abstract void mo6067c(long j);

    /* renamed from: c */
    abstract void mo6068c(byte[] bArr, int i, int i2);

    /* renamed from: d */
    public abstract void mo6069d(int i);

    /* renamed from: d */
    public final void m29674d(int i, int i2) {
        mo6065c(i, m29640m(i2));
    }

    /* renamed from: e */
    public abstract void mo6070e(int i, int i2);
}
