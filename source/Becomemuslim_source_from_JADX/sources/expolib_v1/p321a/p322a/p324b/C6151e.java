package expolib_v1.p321a.p322a.p324b;

import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: RouteException */
/* renamed from: expolib_v1.a.a.b.e */
public final class C6151e extends RuntimeException {
    /* renamed from: a */
    private static final Method f19874a;
    /* renamed from: b */
    private IOException f19875b;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Throwable.class;	 Catch:{ Exception -> 0x0011 }
        r1 = "addSuppressed";	 Catch:{ Exception -> 0x0011 }
        r2 = 1;	 Catch:{ Exception -> 0x0011 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0011 }
        r3 = 0;	 Catch:{ Exception -> 0x0011 }
        r4 = java.lang.Throwable.class;	 Catch:{ Exception -> 0x0011 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0011 }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ Exception -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        f19874a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.b.e.<clinit>():void");
    }

    public C6151e(IOException iOException) {
        super(iOException);
        this.f19875b = iOException;
    }

    /* renamed from: a */
    public IOException m25237a() {
        return this.f19875b;
    }

    /* renamed from: a */
    public void m25238a(IOException iOException) {
        m25236a(iOException, this.f19875b);
        this.f19875b = iOException;
    }

    /* renamed from: a */
    private void m25236a(java.io.IOException r4, java.io.IOException r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = f19874a;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = f19874a;	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r1 = 1;	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r1 = new java.lang.Object[r1];	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r2 = 0;	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r1[r2] = r5;	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
        r0.invoke(r4, r1);	 Catch:{ InvocationTargetException -> 0x000f, InvocationTargetException -> 0x000f }
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.b.e.a(java.io.IOException, java.io.IOException):void");
    }
}
