package com.google.android.gms.internal.p210i;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.i.ih */
final class ih {
    /* renamed from: a */
    static final long f16702a = ((long) ih.m20825b(byte[].class));
    /* renamed from: b */
    static final boolean f16703b = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    /* renamed from: c */
    private static final Logger f16704c = Logger.getLogger(ih.class.getName());
    /* renamed from: d */
    private static final Unsafe f16705d = ih.m20831c();
    /* renamed from: e */
    private static final Class<?> f16706e = dv.m20448b();
    /* renamed from: f */
    private static final boolean f16707f = ih.m20839d(Long.TYPE);
    /* renamed from: g */
    private static final boolean f16708g = ih.m20839d(Integer.TYPE);
    /* renamed from: h */
    private static final C5001d f16709h;
    /* renamed from: i */
    private static final boolean f16710i = ih.m20842e();
    /* renamed from: j */
    private static final boolean f16711j = ih.m20838d();
    /* renamed from: k */
    private static final long f16712k = ((long) ih.m20825b(boolean[].class));
    /* renamed from: l */
    private static final long f16713l = ((long) ih.m20830c(boolean[].class));
    /* renamed from: m */
    private static final long f16714m = ((long) ih.m20825b(int[].class));
    /* renamed from: n */
    private static final long f16715n = ((long) ih.m20830c(int[].class));
    /* renamed from: o */
    private static final long f16716o = ((long) ih.m20825b(long[].class));
    /* renamed from: p */
    private static final long f16717p = ((long) ih.m20830c(long[].class));
    /* renamed from: q */
    private static final long f16718q = ((long) ih.m20825b(float[].class));
    /* renamed from: r */
    private static final long f16719r = ((long) ih.m20830c(float[].class));
    /* renamed from: s */
    private static final long f16720s = ((long) ih.m20825b(double[].class));
    /* renamed from: t */
    private static final long f16721t = ((long) ih.m20830c(double[].class));
    /* renamed from: u */
    private static final long f16722u = ((long) ih.m20825b(Object[].class));
    /* renamed from: v */
    private static final long f16723v = ((long) ih.m20830c(Object[].class));
    /* renamed from: w */
    private static final long f16724w;
    /* renamed from: x */
    private static final int f16725x = ((int) (f16702a & 7));

    /* renamed from: com.google.android.gms.internal.i.ih$d */
    static abstract class C5001d {
        /* renamed from: a */
        Unsafe f16701a;

        C5001d(Unsafe unsafe) {
            this.f16701a = unsafe;
        }

        /* renamed from: a */
        public abstract byte mo4607a(Object obj, long j);

        /* renamed from: a */
        public abstract void mo4608a(long j, byte b);

        /* renamed from: a */
        public abstract void mo4609a(Object obj, long j, byte b);

        /* renamed from: a */
        public abstract void mo4610a(Object obj, long j, double d);

        /* renamed from: a */
        public abstract void mo4611a(Object obj, long j, float f);

        /* renamed from: a */
        public abstract void mo4612a(Object obj, long j, boolean z);

        /* renamed from: a */
        public abstract void mo4613a(byte[] bArr, long j, long j2, long j3);

        /* renamed from: b */
        public abstract boolean mo4614b(Object obj, long j);

        /* renamed from: c */
        public abstract float mo4615c(Object obj, long j);

        /* renamed from: d */
        public abstract double mo4616d(Object obj, long j);

        /* renamed from: e */
        public final int m20806e(Object obj, long j) {
            return this.f16701a.getInt(obj, j);
        }

        /* renamed from: a */
        public final void m20799a(Object obj, long j, int i) {
            this.f16701a.putInt(obj, j, i);
        }

        /* renamed from: f */
        public final long m20807f(Object obj, long j) {
            return this.f16701a.getLong(obj, j);
        }

        /* renamed from: a */
        public final void m20800a(Object obj, long j, long j2) {
            this.f16701a.putLong(obj, j, j2);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.ih$a */
    static final class C6794a extends C5001d {
        C6794a(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo4608a(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        /* renamed from: a */
        public final byte mo4607a(Object obj, long j) {
            if (ih.f16703b) {
                return ih.m20849k(obj, j);
            }
            return ih.m20850l(obj, j);
        }

        /* renamed from: a */
        public final void mo4609a(Object obj, long j, byte b) {
            if (ih.f16703b) {
                ih.m20832c(obj, j, b);
            } else {
                ih.m20836d(obj, j, b);
            }
        }

        /* renamed from: b */
        public final boolean mo4614b(Object obj, long j) {
            if (ih.f16703b) {
                return ih.m20851m(obj, j);
            }
            return ih.m20852n(obj, j);
        }

        /* renamed from: a */
        public final void mo4612a(Object obj, long j, boolean z) {
            if (ih.f16703b) {
                ih.m20837d(obj, j, z);
            } else {
                ih.m20841e(obj, j, z);
            }
        }

        /* renamed from: c */
        public final float mo4615c(Object obj, long j) {
            return Float.intBitsToFloat(m20806e(obj, j));
        }

        /* renamed from: a */
        public final void mo4611a(Object obj, long j, float f) {
            m20799a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: d */
        public final double mo4616d(Object obj, long j) {
            return Double.longBitsToDouble(m20807f(obj, j));
        }

        /* renamed from: a */
        public final void mo4610a(Object obj, long j, double d) {
            m20800a(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: a */
        public final void mo4613a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.ih$b */
    static final class C6795b extends C5001d {
        C6795b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo4608a(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        /* renamed from: a */
        public final byte mo4607a(Object obj, long j) {
            if (ih.f16703b) {
                return ih.m20849k(obj, j);
            }
            return ih.m20850l(obj, j);
        }

        /* renamed from: a */
        public final void mo4609a(Object obj, long j, byte b) {
            if (ih.f16703b) {
                ih.m20832c(obj, j, b);
            } else {
                ih.m20836d(obj, j, b);
            }
        }

        /* renamed from: b */
        public final boolean mo4614b(Object obj, long j) {
            if (ih.f16703b) {
                return ih.m20851m(obj, j);
            }
            return ih.m20852n(obj, j);
        }

        /* renamed from: a */
        public final void mo4612a(Object obj, long j, boolean z) {
            if (ih.f16703b) {
                ih.m20837d(obj, j, z);
            } else {
                ih.m20841e(obj, j, z);
            }
        }

        /* renamed from: c */
        public final float mo4615c(Object obj, long j) {
            return Float.intBitsToFloat(m20806e(obj, j));
        }

        /* renamed from: a */
        public final void mo4611a(Object obj, long j, float f) {
            m20799a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: d */
        public final double mo4616d(Object obj, long j) {
            return Double.longBitsToDouble(m20807f(obj, j));
        }

        /* renamed from: a */
        public final void mo4610a(Object obj, long j, double d) {
            m20800a(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: a */
        public final void mo4613a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    /* renamed from: com.google.android.gms.internal.i.ih$c */
    static final class C6796c extends C5001d {
        C6796c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo4608a(long j, byte b) {
            this.a.putByte(j, b);
        }

        /* renamed from: a */
        public final byte mo4607a(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        /* renamed from: a */
        public final void mo4609a(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        /* renamed from: b */
        public final boolean mo4614b(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        /* renamed from: a */
        public final void mo4612a(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        /* renamed from: c */
        public final float mo4615c(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        /* renamed from: a */
        public final void mo4611a(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        /* renamed from: d */
        public final double mo4616d(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        /* renamed from: a */
        public final void mo4610a(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        /* renamed from: a */
        public final void mo4613a(byte[] bArr, long j, long j2, long j3) {
            this.a.copyMemory(bArr, ih.f16702a + j, null, j2, j3);
        }
    }

    private ih() {
    }

    /* renamed from: a */
    static boolean m20824a() {
        return f16711j;
    }

    /* renamed from: b */
    static boolean m20829b() {
        return f16710i;
    }

    /* renamed from: a */
    static <T> T m20812a(Class<T> cls) {
        try {
            return f16705d.allocateInstance(cls);
        } catch (Class<T> cls2) {
            throw new IllegalStateException(cls2);
        }
    }

    /* renamed from: b */
    private static int m20825b(Class<?> cls) {
        return f16711j ? f16709h.f16701a.arrayBaseOffset(cls) : -1;
    }

    /* renamed from: c */
    private static int m20830c(Class<?> cls) {
        return f16711j ? f16709h.f16701a.arrayIndexScale(cls) : -1;
    }

    /* renamed from: a */
    static int m20809a(Object obj, long j) {
        return f16709h.m20806e(obj, j);
    }

    /* renamed from: a */
    static void m20818a(Object obj, long j, int i) {
        f16709h.m20799a(obj, j, i);
    }

    /* renamed from: b */
    static long m20826b(Object obj, long j) {
        return f16709h.m20807f(obj, j);
    }

    /* renamed from: a */
    static void m20819a(Object obj, long j, long j2) {
        f16709h.m20800a(obj, j, j2);
    }

    /* renamed from: c */
    static boolean m20834c(Object obj, long j) {
        return f16709h.mo4614b(obj, j);
    }

    /* renamed from: a */
    static void m20821a(Object obj, long j, boolean z) {
        f16709h.mo4612a(obj, j, z);
    }

    /* renamed from: d */
    static float m20835d(Object obj, long j) {
        return f16709h.mo4615c(obj, j);
    }

    /* renamed from: a */
    static void m20817a(Object obj, long j, float f) {
        f16709h.mo4611a(obj, j, f);
    }

    /* renamed from: e */
    static double m20840e(Object obj, long j) {
        return f16709h.mo4616d(obj, j);
    }

    /* renamed from: a */
    static void m20816a(Object obj, long j, double d) {
        f16709h.mo4610a(obj, j, d);
    }

    /* renamed from: f */
    static Object m20843f(Object obj, long j) {
        return f16709h.f16701a.getObject(obj, j);
    }

    /* renamed from: a */
    static void m20820a(Object obj, long j, Object obj2) {
        f16709h.f16701a.putObject(obj, j, obj2);
    }

    /* renamed from: a */
    static byte m20808a(byte[] bArr, long j) {
        return f16709h.mo4607a((Object) bArr, f16702a + j);
    }

    /* renamed from: a */
    static void m20822a(byte[] bArr, long j, byte b) {
        f16709h.mo4609a((Object) bArr, f16702a + j, b);
    }

    /* renamed from: a */
    static void m20823a(byte[] bArr, long j, long j2, long j3) {
        f16709h.mo4613a(bArr, j, j2, j3);
    }

    /* renamed from: a */
    static void m20814a(long j, byte b) {
        f16709h.mo4608a(j, b);
    }

    /* renamed from: a */
    static long m20811a(ByteBuffer byteBuffer) {
        return f16709h.m20807f(byteBuffer, f16724w);
    }

    /* renamed from: c */
    static sun.misc.Unsafe m20831c() {
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
        r0 = new com.google.android.gms.internal.i.ii;	 Catch:{ Throwable -> 0x000c }
        r0.<init>();	 Catch:{ Throwable -> 0x000c }
        r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = (sun.misc.Unsafe) r0;	 Catch:{ Throwable -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ih.c():sun.misc.Unsafe");
    }

    /* renamed from: d */
    private static boolean m20838d() {
        if (f16705d == null) {
            return false;
        }
        try {
            Class cls = f16705d.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (dv.m20447a()) {
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
            f16704c.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", stringBuilder.toString());
            return false;
        }
    }

    /* renamed from: e */
    private static boolean m20842e() {
        if (f16705d == null) {
            return false;
        }
        try {
            Class cls = f16705d.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (ih.m20844f() == null) {
                return false;
            }
            if (dv.m20447a()) {
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
            f16704c.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", stringBuilder.toString());
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m20839d(java.lang.Class<?> r9) {
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
        r0 = com.google.android.gms.internal.p210i.dv.m20447a();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = f16706e;	 Catch:{ Throwable -> 0x008b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ih.d(java.lang.Class):boolean");
    }

    /* renamed from: f */
    private static Field m20844f() {
        Field a;
        if (dv.m20447a()) {
            a = ih.m20813a(Buffer.class, "effectiveDirectAddress");
            if (a != null) {
                return a;
            }
        }
        a = ih.m20813a(Buffer.class, "address");
        return (a == null || a.getType() != Long.TYPE) ? null : a;
    }

    /* renamed from: a */
    static int m20810a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0 || i + i3 > bArr.length || i2 + i3 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        if (f16711j) {
            int i5 = (f16725x + i) & 7;
            while (i4 < i3 && (i5 & 7) != 0) {
                if (bArr[i + i4] != bArr2[i2 + i4]) {
                    return i4;
                }
                i4++;
                i5++;
            }
            i5 = ((i3 - i4) & -8) + i4;
            while (i4 < i5) {
                long j = (long) i4;
                long b = ih.m20826b(bArr, (f16702a + ((long) i)) + j);
                j = ih.m20826b(bArr2, (f16702a + ((long) i2)) + j);
                if (b != j) {
                    if (f16703b != null) {
                        bArr = Long.numberOfLeadingZeros(b ^ j);
                    } else {
                        bArr = Long.numberOfTrailingZeros(b ^ j);
                    }
                    return i4 + (bArr >> 3);
                }
                i4 += 8;
            }
        }
        while (i4 < i3) {
            if (bArr[i + i4] != bArr2[i2 + i4]) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* renamed from: a */
    private static java.lang.reflect.Field m20813a(java.lang.Class<?> r0, java.lang.String r1) {
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
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r0 = 0;
    L_0x0006:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ih.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* renamed from: k */
    private static byte m20849k(Object obj, long j) {
        return (byte) (ih.m20809a(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* renamed from: l */
    private static byte m20850l(Object obj, long j) {
        return (byte) (ih.m20809a(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* renamed from: c */
    private static void m20832c(Object obj, long j, byte b) {
        long j2 = -4 & j;
        j = ((~((int) j)) & 3) << 3;
        j = (JfifUtil.MARKER_FIRST_BYTE & b) << j;
        ih.m20818a(obj, j2, j | (ih.m20809a(obj, j2) & (~(JfifUtil.MARKER_FIRST_BYTE << j))));
    }

    /* renamed from: d */
    private static void m20836d(Object obj, long j, byte b) {
        long j2 = -4 & j;
        j = (((int) j) & 3) << 3;
        ih.m20818a(obj, j2, ((JfifUtil.MARKER_FIRST_BYTE & b) << j) | (ih.m20809a(obj, j2) & (~(JfifUtil.MARKER_FIRST_BYTE << j))));
    }

    /* renamed from: m */
    private static boolean m20851m(Object obj, long j) {
        return ih.m20849k(obj, j) != null ? true : null;
    }

    /* renamed from: n */
    private static boolean m20852n(Object obj, long j) {
        return ih.m20850l(obj, j) != null ? true : null;
    }

    /* renamed from: d */
    private static void m20837d(Object obj, long j, boolean z) {
        ih.m20832c(obj, j, (byte) z);
    }

    /* renamed from: e */
    private static void m20841e(Object obj, long j, boolean z) {
        ih.m20836d(obj, j, (byte) z);
    }

    static {
        long objectFieldOffset;
        C5001d c5001d = null;
        if (f16705d != null) {
            if (!dv.m20447a()) {
                c5001d = new C6796c(f16705d);
            } else if (f16707f) {
                c5001d = new C6795b(f16705d);
            } else if (f16708g) {
                c5001d = new C6794a(f16705d);
            }
        }
        f16709h = c5001d;
        Field f = ih.m20844f();
        if (f != null) {
            if (f16709h != null) {
                objectFieldOffset = f16709h.f16701a.objectFieldOffset(f);
                f16724w = objectFieldOffset;
            }
        }
        objectFieldOffset = -1;
        f16724w = objectFieldOffset;
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        }
    }
}
