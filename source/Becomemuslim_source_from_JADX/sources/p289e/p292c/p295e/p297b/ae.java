package p289e.p292c.p295e.p297b;

import sun.misc.Unsafe;

/* compiled from: UnsafeAccess */
/* renamed from: e.c.e.b.ae */
public final class ae {
    /* renamed from: a */
    public static final Unsafe f19707a;
    /* renamed from: b */
    private static final boolean f19708b;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "rx.unsafe-disable";
        r0 = java.lang.System.getProperty(r0);
        r1 = 1;
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        r0 = 1;
        goto L_0x000c;
    L_0x000b:
        r0 = 0;
    L_0x000c:
        f19708b = r0;
        r0 = 0;
        r2 = sun.misc.Unsafe.class;	 Catch:{ Throwable -> 0x0021 }
        r3 = "theUnsafe";	 Catch:{ Throwable -> 0x0021 }
        r2 = r2.getDeclaredField(r3);	 Catch:{ Throwable -> 0x0021 }
        r2.setAccessible(r1);	 Catch:{ Throwable -> 0x0021 }
        r1 = r2.get(r0);	 Catch:{ Throwable -> 0x0021 }
        r1 = (sun.misc.Unsafe) r1;	 Catch:{ Throwable -> 0x0021 }
        r0 = r1;
    L_0x0021:
        f19707a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e.b.ae.<clinit>():void");
    }

    /* renamed from: a */
    public static boolean m24923a() {
        return (f19707a == null || f19708b) ? false : true;
    }

    /* renamed from: a */
    public static long m24922a(Class<?> cls, String str) {
        try {
            return f19707a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (Class<?> cls2) {
            str = new InternalError();
            str.initCause(cls2);
            throw str;
        }
    }
}
