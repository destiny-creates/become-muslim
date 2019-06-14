package p289e.p290a;

import java.util.Collection;
import java.util.List;
import p289e.C5982f;
import p289e.C7366j;

/* compiled from: Exceptions */
/* renamed from: e.a.b */
public final class C5903b {
    /* renamed from: a */
    public static RuntimeException m24788a(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new RuntimeException(th);
        }
    }

    /* renamed from: b */
    public static void m24794b(Throwable th) {
        if (th instanceof C5907f) {
            throw ((C5907f) th);
        } else if (th instanceof C5906e) {
            throw ((C5906e) th);
        } else if (th instanceof C5905d) {
            throw ((C5905d) th);
        } else if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    /* renamed from: a */
    public static void m24792a(java.lang.Throwable r4, java.lang.Throwable r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = 0;
    L_0x0006:
        r2 = r4.getCause();
        if (r2 == 0) goto L_0x002b;
    L_0x000c:
        r2 = r1 + 1;
        r3 = 25;
        if (r1 < r3) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r4 = r4.getCause();
        r1 = r4.getCause();
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x0022;
    L_0x0021:
        goto L_0x002b;
    L_0x0022:
        r1 = r4.getCause();
        r0.add(r1);
        r1 = r2;
        goto L_0x0006;
    L_0x002b:
        r4.initCause(r5);	 Catch:{ Throwable -> 0x002e }
    L_0x002e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.b.a(java.lang.Throwable, java.lang.Throwable):void");
    }

    /* renamed from: c */
    public static Throwable m24795c(Throwable th) {
        int i = 0;
        while (th.getCause() != null) {
            int i2 = i + 1;
            if (i >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i = i2;
        }
        return th;
    }

    /* renamed from: a */
    public static void m24793a(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th = (Throwable) list.get(0);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                } else if (th instanceof Error) {
                    throw ((Error) th);
                } else {
                    throw new RuntimeException(th);
                }
            }
            throw new C5902a((Collection) list);
        }
    }

    /* renamed from: a */
    public static void m24790a(Throwable th, C5982f<?> c5982f, Object obj) {
        C5903b.m24794b(th);
        c5982f.mo5001a(C5910g.m24799a(th, obj));
    }

    /* renamed from: a */
    public static void m24789a(Throwable th, C5982f<?> c5982f) {
        C5903b.m24794b(th);
        c5982f.mo5001a(th);
    }

    /* renamed from: a */
    public static void m24791a(Throwable th, C7366j<?> c7366j) {
        C5903b.m24794b(th);
        c7366j.mo6329a(th);
    }
}
