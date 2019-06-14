package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class aep {
    /* renamed from: a */
    private static final Logger f14349a = Logger.getLogger(aep.class.getName());
    /* renamed from: b */
    private static final Unsafe f14350b = m18239c();
    /* renamed from: c */
    private static final Class<?> f14351c = aad.m17814b();
    /* renamed from: d */
    private static final boolean f14352d = m18242c(Long.TYPE);
    /* renamed from: e */
    private static final boolean f14353e = m18242c(Integer.TYPE);
    /* renamed from: f */
    private static final C4919d f14354f;
    /* renamed from: g */
    private static final boolean f14355g = m18252f();
    /* renamed from: h */
    private static final boolean f14356h = m18250e();
    /* renamed from: i */
    private static final long f14357i = ((long) m18220a(byte[].class));
    /* renamed from: j */
    private static final long f14358j = ((long) m18220a(boolean[].class));
    /* renamed from: k */
    private static final long f14359k = ((long) m18233b(boolean[].class));
    /* renamed from: l */
    private static final long f14360l = ((long) m18220a(int[].class));
    /* renamed from: m */
    private static final long f14361m = ((long) m18233b(int[].class));
    /* renamed from: n */
    private static final long f14362n = ((long) m18220a(long[].class));
    /* renamed from: o */
    private static final long f14363o = ((long) m18233b(long[].class));
    /* renamed from: p */
    private static final long f14364p = ((long) m18220a(float[].class));
    /* renamed from: q */
    private static final long f14365q = ((long) m18233b(float[].class));
    /* renamed from: r */
    private static final long f14366r = ((long) m18220a(double[].class));
    /* renamed from: s */
    private static final long f14367s = ((long) m18233b(double[].class));
    /* renamed from: t */
    private static final long f14368t = ((long) m18220a(Object[].class));
    /* renamed from: u */
    private static final long f14369u = ((long) m18233b(Object[].class));
    /* renamed from: v */
    private static final long f14370v = m18235b(m18254g());
    /* renamed from: w */
    private static final long f14371w;
    /* renamed from: x */
    private static final boolean f14372x = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    /* renamed from: com.google.android.gms.internal.ads.aep$d */
    static abstract class C4919d {
        /* renamed from: a */
        Unsafe f14348a;

        C4919d(Unsafe unsafe) {
            this.f14348a = unsafe;
        }

        /* renamed from: a */
        public abstract byte mo3793a(Object obj, long j);

        /* renamed from: a */
        public final long m18207a(Field field) {
            return this.f14348a.objectFieldOffset(field);
        }

        /* renamed from: a */
        public abstract void mo3794a(Object obj, long j, byte b);

        /* renamed from: a */
        public abstract void mo3795a(Object obj, long j, double d);

        /* renamed from: a */
        public abstract void mo3796a(Object obj, long j, float f);

        /* renamed from: a */
        public final void m18211a(Object obj, long j, int i) {
            this.f14348a.putInt(obj, j, i);
        }

        /* renamed from: a */
        public final void m18212a(Object obj, long j, long j2) {
            this.f14348a.putLong(obj, j, j2);
        }

        /* renamed from: a */
        public abstract void mo3797a(Object obj, long j, boolean z);

        /* renamed from: b */
        public abstract boolean mo3798b(Object obj, long j);

        /* renamed from: c */
        public abstract float mo3799c(Object obj, long j);

        /* renamed from: d */
        public abstract double mo3800d(Object obj, long j);

        /* renamed from: e */
        public final int m18217e(Object obj, long j) {
            return this.f14348a.getInt(obj, j);
        }

        /* renamed from: f */
        public final long m18218f(Object obj, long j) {
            return this.f14348a.getLong(obj, j);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.aep$a */
    static final class C6759a extends C4919d {
        C6759a(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final byte mo3793a(Object obj, long j) {
            return aep.f14372x ? aep.m18258k(obj, j) : aep.m18259l(obj, j);
        }

        /* renamed from: a */
        public final void mo3794a(Object obj, long j, byte b) {
            if (aep.f14372x) {
                aep.m18240c(obj, j, b);
            } else {
                aep.m18245d(obj, j, b);
            }
        }

        /* renamed from: a */
        public final void mo3795a(Object obj, long j, double d) {
            m18212a(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: a */
        public final void mo3796a(Object obj, long j, float f) {
            m18211a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: a */
        public final void mo3797a(Object obj, long j, boolean z) {
            if (aep.f14372x) {
                aep.m18246d(obj, j, z);
            } else {
                aep.m18249e(obj, j, z);
            }
        }

        /* renamed from: b */
        public final boolean mo3798b(Object obj, long j) {
            return aep.f14372x ? aep.m18260m(obj, j) : aep.m18261n(obj, j);
        }

        /* renamed from: c */
        public final float mo3799c(Object obj, long j) {
            return Float.intBitsToFloat(m18217e(obj, j));
        }

        /* renamed from: d */
        public final double mo3800d(Object obj, long j) {
            return Double.longBitsToDouble(m18218f(obj, j));
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.aep$b */
    static final class C6760b extends C4919d {
        C6760b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final byte mo3793a(Object obj, long j) {
            return aep.f14372x ? aep.m18258k(obj, j) : aep.m18259l(obj, j);
        }

        /* renamed from: a */
        public final void mo3794a(Object obj, long j, byte b) {
            if (aep.f14372x) {
                aep.m18240c(obj, j, b);
            } else {
                aep.m18245d(obj, j, b);
            }
        }

        /* renamed from: a */
        public final void mo3795a(Object obj, long j, double d) {
            m18212a(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: a */
        public final void mo3796a(Object obj, long j, float f) {
            m18211a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: a */
        public final void mo3797a(Object obj, long j, boolean z) {
            if (aep.f14372x) {
                aep.m18246d(obj, j, z);
            } else {
                aep.m18249e(obj, j, z);
            }
        }

        /* renamed from: b */
        public final boolean mo3798b(Object obj, long j) {
            return aep.f14372x ? aep.m18260m(obj, j) : aep.m18261n(obj, j);
        }

        /* renamed from: c */
        public final float mo3799c(Object obj, long j) {
            return Float.intBitsToFloat(m18217e(obj, j));
        }

        /* renamed from: d */
        public final double mo3800d(Object obj, long j) {
            return Double.longBitsToDouble(m18218f(obj, j));
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.aep$c */
    static final class C6761c extends C4919d {
        C6761c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final byte mo3793a(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        /* renamed from: a */
        public final void mo3794a(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        /* renamed from: a */
        public final void mo3795a(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        /* renamed from: a */
        public final void mo3796a(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        /* renamed from: a */
        public final void mo3797a(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        /* renamed from: b */
        public final boolean mo3798b(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        /* renamed from: c */
        public final float mo3799c(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        /* renamed from: d */
        public final double mo3800d(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }
    }

    static {
        C4919d c6761c;
        Field a;
        if (f14350b != null) {
            if (!aad.m17813a()) {
                c6761c = new C6761c(f14350b);
            } else if (f14352d) {
                c6761c = new C6760b(f14350b);
            } else if (f14353e) {
                c6761c = new C6759a(f14350b);
            }
            f14354f = c6761c;
            a = m18223a(String.class, "value");
            if (a != null || a.getType() != char[].class) {
                a = null;
            }
            f14371w = m18235b(a);
        }
        c6761c = null;
        f14354f = c6761c;
        a = m18223a(String.class, "value");
        if (a != null) {
        }
        a = null;
        f14371w = m18235b(a);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        }
    }

    private aep() {
    }

    /* renamed from: a */
    static byte m18219a(byte[] bArr, long j) {
        return f14354f.mo3793a(bArr, f14357i + j);
    }

    /* renamed from: a */
    private static int m18220a(Class<?> cls) {
        return f14356h ? f14354f.f14348a.arrayBaseOffset(cls) : -1;
    }

    /* renamed from: a */
    static int m18221a(Object obj, long j) {
        return f14354f.m18217e(obj, j);
    }

    /* renamed from: a */
    static long m18222a(Field field) {
        return f14354f.m18207a(field);
    }

    /* renamed from: a */
    private static java.lang.reflect.Field m18223a(java.lang.Class<?> r0, java.lang.String r1) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0009 }
        r1 = 1;	 Catch:{ Throwable -> 0x0009 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aep.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* renamed from: a */
    static void m18225a(Object obj, long j, double d) {
        f14354f.mo3795a(obj, j, d);
    }

    /* renamed from: a */
    static void m18226a(Object obj, long j, float f) {
        f14354f.mo3796a(obj, j, f);
    }

    /* renamed from: a */
    static void m18227a(Object obj, long j, int i) {
        f14354f.m18211a(obj, j, i);
    }

    /* renamed from: a */
    static void m18228a(Object obj, long j, long j2) {
        f14354f.m18212a(obj, j, j2);
    }

    /* renamed from: a */
    static void m18229a(Object obj, long j, Object obj2) {
        f14354f.f14348a.putObject(obj, j, obj2);
    }

    /* renamed from: a */
    static void m18230a(Object obj, long j, boolean z) {
        f14354f.mo3797a(obj, j, z);
    }

    /* renamed from: a */
    static void m18231a(byte[] bArr, long j, byte b) {
        f14354f.mo3794a((Object) bArr, f14357i + j, b);
    }

    /* renamed from: a */
    static boolean m18232a() {
        return f14356h;
    }

    /* renamed from: b */
    private static int m18233b(Class<?> cls) {
        return f14356h ? f14354f.f14348a.arrayIndexScale(cls) : -1;
    }

    /* renamed from: b */
    static long m18234b(Object obj, long j) {
        return f14354f.m18218f(obj, j);
    }

    /* renamed from: b */
    private static long m18235b(Field field) {
        if (field != null) {
            if (f14354f != null) {
                return f14354f.m18207a(field);
            }
        }
        return -1;
    }

    /* renamed from: b */
    static boolean m18238b() {
        return f14355g;
    }

    /* renamed from: c */
    static sun.misc.Unsafe m18239c() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = new com.google.android.gms.internal.ads.aeq;	 Catch:{ Throwable -> 0x000c }
        r0.<init>();	 Catch:{ Throwable -> 0x000c }
        r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = (sun.misc.Unsafe) r0;	 Catch:{ Throwable -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aep.c():sun.misc.Unsafe");
    }

    /* renamed from: c */
    private static void m18240c(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((~((int) j)) & 3) << 3;
        i = (JfifUtil.MARKER_FIRST_BYTE & b) << i;
        m18227a(obj, j2, i | (m18221a(obj, j2) & (~(JfifUtil.MARKER_FIRST_BYTE << i))));
    }

    /* renamed from: c */
    private static boolean m18242c(java.lang.Class<?> r9) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = com.google.android.gms.internal.ads.aad.m17813a();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = f14351c;	 Catch:{ Throwable -> 0x008b }
        r2 = "peekLong";	 Catch:{ Throwable -> 0x008b }
        r3 = 2;	 Catch:{ Throwable -> 0x008b }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008b }
        r4[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r6 = 1;	 Catch:{ Throwable -> 0x008b }
        r4[r6] = r5;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r4);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeLong";	 Catch:{ Throwable -> 0x008b }
        r4 = 3;	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r3] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeInt";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r3] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "peekInt";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeByte";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r7 = java.lang.Byte.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "peekByte";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        r2 = "pokeByteArray";	 Catch:{ Throwable -> 0x008b }
        r5 = 4;	 Catch:{ Throwable -> 0x008b }
        r7 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x008b }
        r7[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r8 = byte[].class;	 Catch:{ Throwable -> 0x008b }
        r7[r6] = r8;	 Catch:{ Throwable -> 0x008b }
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r7[r3] = r8;	 Catch:{ Throwable -> 0x008b }
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r7[r4] = r8;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r7);	 Catch:{ Throwable -> 0x008b }
        r2 = "peekByteArray";	 Catch:{ Throwable -> 0x008b }
        r5 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x008b }
        r5[r1] = r9;	 Catch:{ Throwable -> 0x008b }
        r9 = byte[].class;	 Catch:{ Throwable -> 0x008b }
        r5[r6] = r9;	 Catch:{ Throwable -> 0x008b }
        r9 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r3] = r9;	 Catch:{ Throwable -> 0x008b }
        r9 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008b }
        r5[r4] = r9;	 Catch:{ Throwable -> 0x008b }
        r0.getMethod(r2, r5);	 Catch:{ Throwable -> 0x008b }
        return r6;
    L_0x008b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aep.c(java.lang.Class):boolean");
    }

    /* renamed from: c */
    static boolean m18243c(Object obj, long j) {
        return f14354f.mo3798b(obj, j);
    }

    /* renamed from: d */
    static float m18244d(Object obj, long j) {
        return f14354f.mo3799c(obj, j);
    }

    /* renamed from: d */
    private static void m18245d(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        m18227a(obj, j2, ((JfifUtil.MARKER_FIRST_BYTE & b) << i) | (m18221a(obj, j2) & (~(JfifUtil.MARKER_FIRST_BYTE << i))));
    }

    /* renamed from: d */
    private static void m18246d(Object obj, long j, boolean z) {
        m18240c(obj, j, (byte) z);
    }

    /* renamed from: e */
    static double m18248e(Object obj, long j) {
        return f14354f.mo3800d(obj, j);
    }

    /* renamed from: e */
    private static void m18249e(Object obj, long j, boolean z) {
        m18245d(obj, j, (byte) z);
    }

    /* renamed from: e */
    private static boolean m18250e() {
        if (f14350b == null) {
            return false;
        }
        try {
            Class cls = f14350b.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (aad.m17813a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 71);
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(valueOf);
            f14349a.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", stringBuilder.toString());
            return false;
        }
    }

    /* renamed from: f */
    static Object m18251f(Object obj, long j) {
        return f14354f.f14348a.getObject(obj, j);
    }

    /* renamed from: f */
    private static boolean m18252f() {
        if (f14350b == null) {
            return false;
        }
        try {
            Class cls = f14350b.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (m18254g() == null) {
                return false;
            }
            if (aad.m17813a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 71);
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(valueOf);
            f14349a.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", stringBuilder.toString());
            return false;
        }
    }

    /* renamed from: g */
    private static Field m18254g() {
        Field a;
        if (aad.m17813a()) {
            a = m18223a(Buffer.class, "effectiveDirectAddress");
            if (a != null) {
                return a;
            }
        }
        a = m18223a(Buffer.class, "address");
        return (a == null || a.getType() != Long.TYPE) ? null : a;
    }

    /* renamed from: k */
    private static byte m18258k(Object obj, long j) {
        return (byte) (m18221a(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* renamed from: l */
    private static byte m18259l(Object obj, long j) {
        return (byte) (m18221a(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* renamed from: m */
    private static boolean m18260m(Object obj, long j) {
        return m18258k(obj, j) != (byte) 0;
    }

    /* renamed from: n */
    private static boolean m18261n(Object obj, long j) {
        return m18259l(obj, j) != (byte) 0;
    }
}
