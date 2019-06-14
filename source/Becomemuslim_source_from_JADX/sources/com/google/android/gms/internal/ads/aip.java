package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

public final class aip extends ajk {
    /* renamed from: d */
    private static volatile agi f23650d;
    /* renamed from: e */
    private static final Object f23651e = new Object();
    /* renamed from: f */
    private ww f23652f = null;

    public aip(ahz ahz, String str, String str2, aaa aaa, int i, int i2, ww wwVar) {
        super(ahz, str, str2, aaa, i, 27);
        this.f23652f = wwVar;
    }

    /* renamed from: c */
    private final java.lang.String m29958c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.a;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        r0 = r0.m18469l();	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        if (r0 == 0) goto L_0x0011;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
    L_0x0008:
        r0 = r2.a;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        r0 = r0.m18469l();	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        r0.get();	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
    L_0x0011:
        r0 = r2.a;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        r0 = r0.m18468k();	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        if (r0 == 0) goto L_0x0020;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
    L_0x0019:
        r1 = r0.f27965n;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        if (r1 == 0) goto L_0x0020;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
    L_0x001d:
        r0 = r0.f27965n;	 Catch:{ InterruptedException -> 0x0020, InterruptedException -> 0x0020 }
        return r0;
    L_0x0020:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aip.c():java.lang.String");
    }

    /* renamed from: a */
    protected final void mo3820a() {
        Object obj;
        Object obj2;
        agi agi;
        String c;
        boolean z = false;
        if (!(f23650d == null || aih.m18483b(f23650d.f23571a) || f23650d.f23571a.equals("E"))) {
            if (!f23650d.f23571a.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                obj = null;
                if (obj != null) {
                    synchronized (f23651e) {
                        ww wwVar = this.f23652f;
                        if (aih.m18483b(null)) {
                            obj2 = 4;
                        } else {
                            ww wwVar2 = this.f23652f;
                            aih.m18483b(null);
                            if (Boolean.valueOf(false).booleanValue()) {
                                if (this.a.m18466i()) {
                                    if (((Boolean) aph.m18688f().m18889a(asp.bO)).booleanValue()) {
                                        if (((Boolean) aph.m18688f().m18889a(asp.bP)).booleanValue()) {
                                            obj2 = 1;
                                            if (obj2 != null) {
                                                obj2 = 3;
                                            }
                                        }
                                    }
                                }
                                obj2 = null;
                                if (obj2 != null) {
                                    obj2 = 3;
                                }
                            }
                            obj2 = 2;
                        }
                        Method method = this.c;
                        Object[] objArr = new Object[3];
                        objArr[0] = this.a.m18454a();
                        if (obj2 == 2) {
                            z = true;
                        }
                        objArr[1] = Boolean.valueOf(z);
                        objArr[2] = aph.m18688f().m18889a(asp.bI);
                        agi = new agi((String) method.invoke(null, objArr));
                        f23650d = agi;
                        if (aih.m18483b(agi.f23571a) || f23650d.f23571a.equals("E")) {
                            switch (obj2) {
                                case 3:
                                    c = m29958c();
                                    if (!aih.m18483b(c)) {
                                        f23650d.f23571a = c;
                                        break;
                                    }
                                    break;
                                case 4:
                                    f23650d.f23571a = null.f28773a;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                synchronized (this.b) {
                    if (f23650d != null) {
                        this.b.f27965n = f23650d.f23571a;
                        this.b.f27971t = Long.valueOf(f23650d.f23572b);
                        this.b.f27970s = f23650d.f23573c;
                        this.b.f27930C = f23650d.f23574d;
                        this.b.f27931D = f23650d.f23575e;
                    }
                }
            }
        }
        obj = 1;
        if (obj != null) {
            synchronized (f23651e) {
                ww wwVar3 = this.f23652f;
                if (aih.m18483b(null)) {
                    ww wwVar22 = this.f23652f;
                    aih.m18483b(null);
                    if (Boolean.valueOf(false).booleanValue()) {
                        if (this.a.m18466i()) {
                            if (((Boolean) aph.m18688f().m18889a(asp.bO)).booleanValue()) {
                                if (((Boolean) aph.m18688f().m18889a(asp.bP)).booleanValue()) {
                                    obj2 = 1;
                                    if (obj2 != null) {
                                        obj2 = 3;
                                    }
                                }
                            }
                        }
                        obj2 = null;
                        if (obj2 != null) {
                            obj2 = 3;
                        }
                    }
                    obj2 = 2;
                } else {
                    obj2 = 4;
                }
                Method method2 = this.c;
                Object[] objArr2 = new Object[3];
                objArr2[0] = this.a.m18454a();
                if (obj2 == 2) {
                    z = true;
                }
                objArr2[1] = Boolean.valueOf(z);
                objArr2[2] = aph.m18688f().m18889a(asp.bI);
                agi = new agi((String) method2.invoke(null, objArr2));
                f23650d = agi;
                switch (obj2) {
                    case 3:
                        c = m29958c();
                        if (aih.m18483b(c)) {
                            f23650d.f23571a = c;
                            break;
                        }
                        break;
                    case 4:
                        f23650d.f23571a = null.f28773a;
                        break;
                    default:
                        break;
                }
            }
        }
        synchronized (this.b) {
            if (f23650d != null) {
                this.b.f27965n = f23650d.f23571a;
                this.b.f27971t = Long.valueOf(f23650d.f23572b);
                this.b.f27970s = f23650d.f23573c;
                this.b.f27930C = f23650d.f23574d;
                this.b.f27931D = f23650d.f23575e;
            }
        }
    }
}
