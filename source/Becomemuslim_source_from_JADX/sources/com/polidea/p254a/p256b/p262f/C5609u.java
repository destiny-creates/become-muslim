package com.polidea.p254a.p256b.p262f;

import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p259c.C5578j;

/* compiled from: OperationLogger */
/* renamed from: com.polidea.a.b.f.u */
public class C5609u {
    /* renamed from: a */
    public static void m23832a(C5578j c5578j) {
        if (C5615p.m23867b(3)) {
            C5615p.m23865b("STARTED  %s(%d)", c5578j.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(c5578j)));
        }
    }

    /* renamed from: b */
    public static void m23834b(C5578j c5578j) {
        if (C5615p.m23867b(3)) {
            C5615p.m23865b("REMOVED  %s(%d)", c5578j.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(c5578j)));
        }
    }

    /* renamed from: c */
    public static void m23835c(C5578j c5578j) {
        if (C5615p.m23867b(3)) {
            C5615p.m23865b("QUEUED   %s(%d)", c5578j.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(c5578j)));
        }
    }

    /* renamed from: a */
    public static void m23833a(C5578j c5578j, long j, long j2) {
        if (C5615p.m23867b(3)) {
            C5615p.m23865b("FINISHED %s(%d) in %d ms", c5578j.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(c5578j)), Long.valueOf(j2 - j));
        }
    }
}
