package com.google.android.gms.internal.ads;

import java.util.List;

final class aau implements adp {
    /* renamed from: a */
    private final aar f23526a;
    /* renamed from: b */
    private int f23527b;
    /* renamed from: c */
    private int f23528c;
    /* renamed from: d */
    private int f23529d = 0;

    private aau(aar aar) {
        this.f23526a = (aar) abs.m17935a((Object) aar, "input");
        this.f23526a.f14143c = this;
    }

    /* renamed from: a */
    public static aau m29541a(aar aar) {
        return aar.f14143c != null ? aar.f14143c : new aau(aar);
    }

    /* renamed from: a */
    private final Object m29542a(aex aex, Class<?> cls, abd abd) {
        switch (aav.f14146a[aex.ordinal()]) {
            case 1:
                return Boolean.valueOf(mo3669k());
            case 2:
                return mo3674n();
            case 3:
                return Double.valueOf(mo3654d());
            case 4:
                return Integer.valueOf(mo3678p());
            case 5:
                return Integer.valueOf(mo3666j());
            case 6:
                return Long.valueOf(mo3664i());
            case 7:
                return Float.valueOf(mo3656e());
            case 8:
                return Integer.valueOf(mo3662h());
            case 9:
                return Long.valueOf(mo3660g());
            case 10:
                m29543a(2);
                return m29546c(adk.m18007a().m18009a((Class) cls), abd);
            case 11:
                return Integer.valueOf(mo3680q());
            case 12:
                return Long.valueOf(mo3682r());
            case 13:
                return Integer.valueOf(mo3683s());
            case 14:
                return Long.valueOf(mo3684t());
            case 15:
                return mo3672m();
            case 16:
                return Integer.valueOf(mo3676o());
            case 17:
                return Long.valueOf(mo3658f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* renamed from: a */
    private final void m29543a(int i) {
        if ((this.f23527b & 7) != i) {
            throw abw.m17950f();
        }
    }

    /* renamed from: a */
    private final void m29544a(List<String> list, boolean z) {
        if ((this.f23527b & 7) != 2) {
            throw abw.m17950f();
        } else if (!(list instanceof acg) || z) {
            int a;
            do {
                list.add(z ? mo3672m() : mo3670l());
                if (!this.f23526a.mo3641t()) {
                    a = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (a == this.f23527b);
            this.f23529d = a;
        } else {
            int a2;
            acg acg = (acg) list;
            do {
                acg.mo3789a(mo3674n());
                if (!this.f23526a.mo3641t()) {
                    a2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (a2 == this.f23527b);
            this.f23529d = a2;
        }
    }

    /* renamed from: b */
    private static void m29545b(int i) {
        if ((i & 7) != 0) {
            throw abw.m17951g();
        }
    }

    /* renamed from: c */
    private final <T> T m29546c(adq<T> adq, abd abd) {
        int m = this.f23526a.mo3634m();
        if (this.f23526a.f14141a < this.f23526a.f14142b) {
            m = this.f23526a.mo3622c(m);
            T a = adq.mo3754a();
            aar aar = this.f23526a;
            aar.f14141a++;
            adq.mo3755a(a, this, abd);
            adq.mo3761c(a);
            this.f23526a.mo3618a(0);
            aar aar2 = this.f23526a;
            aar2.f14141a--;
            this.f23526a.mo3624d(m);
            return a;
        }
        throw new abw("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: c */
    private static void m29547c(int i) {
        if ((i & 3) != 0) {
            throw abw.m17951g();
        }
    }

    /* renamed from: d */
    private final <T> T m29548d(adq<T> adq, abd abd) {
        int i = this.f23528c;
        T t = ((this.f23527b >>> 3) << 3) | 4;
        this.f23528c = t;
        try {
            t = adq.mo3754a();
            adq.mo3755a(t, this, abd);
            adq.mo3761c(t);
            if (this.f23527b == this.f23528c) {
                return t;
            }
            throw abw.m17951g();
        } finally {
            this.f23528c = i;
        }
    }

    /* renamed from: d */
    private final void m29549d(int i) {
        if (this.f23526a.mo3642u() != i) {
            throw abw.m17945a();
        }
    }

    /* renamed from: a */
    public final int mo3643a() {
        if (this.f23529d != 0) {
            this.f23527b = this.f23529d;
            this.f23529d = 0;
        } else {
            this.f23527b = this.f23526a.mo3617a();
        }
        if (this.f23527b != 0) {
            if (this.f23527b != this.f23528c) {
                return this.f23527b >>> 3;
            }
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public final <T> T mo3644a(adq<T> adq, abd abd) {
        m29543a(2);
        return m29546c(adq, abd);
    }

    /* renamed from: a */
    public final void mo3645a(List<Double> list) {
        int m;
        int u;
        if (list instanceof aaz) {
            aaz aaz = (aaz) list;
            switch (this.f23527b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.f23526a.mo3634m();
                    m29545b(m);
                    u = this.f23526a.mo3642u() + m;
                    do {
                        aaz.m36701a(this.f23526a.mo3619b());
                    } while (this.f23526a.mo3642u() < u);
                    return;
                default:
                    throw abw.m17950f();
            }
            do {
                aaz.m36701a(this.f23526a.mo3619b());
                if (!this.f23526a.mo3641t()) {
                    m = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (m == this.f23527b);
            this.f23529d = m;
            return;
        }
        switch (this.f23527b & 7) {
            case 1:
                break;
            case 2:
                m = this.f23526a.mo3634m();
                m29545b(m);
                u = this.f23526a.mo3642u() + m;
                do {
                    list.add(Double.valueOf(this.f23526a.mo3619b()));
                } while (this.f23526a.mo3642u() < u);
                return;
            default:
                throw abw.m17950f();
        }
        do {
            list.add(Double.valueOf(this.f23526a.mo3619b()));
            if (!this.f23526a.mo3641t()) {
                m = this.f23526a.mo3617a();
            } else {
                return;
            }
        } while (m == this.f23527b);
        this.f23529d = m;
    }

    /* renamed from: a */
    public final <T> void mo3646a(List<T> list, adq<T> adq, abd abd) {
        if ((this.f23527b & 7) == 2) {
            int a;
            int i = this.f23527b;
            do {
                list.add(m29546c(adq, abd));
                if (!this.f23526a.mo3641t()) {
                    if (this.f23529d == 0) {
                        a = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                }
                return;
            } while (a == i);
            this.f23529d = a;
            return;
        }
        throw abw.m17950f();
    }

    /* renamed from: a */
    public final <K, V> void mo3647a(java.util.Map<K, V> r6, com.google.android.gms.internal.ads.acq<K, V> r7, com.google.android.gms.internal.ads.abd r8) {
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
        r5 = this;
        r0 = 2;
        r5.m29543a(r0);
        r0 = r5.f23526a;
        r0 = r0.mo3634m();
        r1 = r5.f23526a;
        r0 = r1.mo3622c(r0);
        r1 = r7.f14265b;
        r2 = r7.f14267d;
    L_0x0014:
        r3 = r5.mo3643a();	 Catch:{ all -> 0x0067 }
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;	 Catch:{ all -> 0x0067 }
        if (r3 == r4) goto L_0x005e;	 Catch:{ all -> 0x0067 }
    L_0x001d:
        r4 = r5.f23526a;	 Catch:{ all -> 0x0067 }
        r4 = r4.mo3641t();	 Catch:{ all -> 0x0067 }
        if (r4 != 0) goto L_0x005e;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x003b;
            case 2: goto L_0x002d;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5.mo3653c();	 Catch:{ abx -> 0x004f }
        goto L_0x0044;	 Catch:{ abx -> 0x004f }
    L_0x002d:
        r3 = r7.f14266c;	 Catch:{ abx -> 0x004f }
        r4 = r7.f14267d;	 Catch:{ abx -> 0x004f }
        r4 = r4.getClass();	 Catch:{ abx -> 0x004f }
        r3 = r5.m29542a(r3, r4, r8);	 Catch:{ abx -> 0x004f }
        r2 = r3;	 Catch:{ abx -> 0x004f }
        goto L_0x0014;	 Catch:{ abx -> 0x004f }
    L_0x003b:
        r3 = r7.f14264a;	 Catch:{ abx -> 0x004f }
        r4 = 0;	 Catch:{ abx -> 0x004f }
        r3 = r5.m29542a(r3, r4, r4);	 Catch:{ abx -> 0x004f }
        r1 = r3;	 Catch:{ abx -> 0x004f }
        goto L_0x0014;	 Catch:{ abx -> 0x004f }
    L_0x0044:
        if (r3 == 0) goto L_0x0047;	 Catch:{ abx -> 0x004f }
    L_0x0046:
        goto L_0x0014;	 Catch:{ abx -> 0x004f }
    L_0x0047:
        r3 = new com.google.android.gms.internal.ads.abw;	 Catch:{ abx -> 0x004f }
        r4 = "Unable to parse map entry.";	 Catch:{ abx -> 0x004f }
        r3.<init>(r4);	 Catch:{ abx -> 0x004f }
        throw r3;	 Catch:{ abx -> 0x004f }
    L_0x004f:
        r3 = r5.mo3653c();	 Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x0056;	 Catch:{ all -> 0x0067 }
    L_0x0055:
        goto L_0x0014;	 Catch:{ all -> 0x0067 }
    L_0x0056:
        r6 = new com.google.android.gms.internal.ads.abw;	 Catch:{ all -> 0x0067 }
        r7 = "Unable to parse map entry.";	 Catch:{ all -> 0x0067 }
        r6.<init>(r7);	 Catch:{ all -> 0x0067 }
        throw r6;	 Catch:{ all -> 0x0067 }
    L_0x005e:
        r6.put(r1, r2);	 Catch:{ all -> 0x0067 }
        r6 = r5.f23526a;
        r6.mo3624d(r0);
        return;
    L_0x0067:
        r6 = move-exception;
        r7 = r5.f23526a;
        r7.mo3624d(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aau.a(java.util.Map, com.google.android.gms.internal.ads.acq, com.google.android.gms.internal.ads.abd):void");
    }

    /* renamed from: b */
    public final int mo3648b() {
        return this.f23527b;
    }

    /* renamed from: b */
    public final <T> T mo3649b(adq<T> adq, abd abd) {
        m29543a(3);
        return m29548d(adq, abd);
    }

    /* renamed from: b */
    public final void mo3650b(List<Float> list) {
        if (list instanceof abo) {
            abo abo = (abo) list;
            int i = this.f23527b & 7;
            if (i == 2) {
                i = this.f23526a.mo3634m();
                m29547c(i);
                int u = this.f23526a.mo3642u() + i;
                do {
                    abo.m36711a(this.f23526a.mo3621c());
                } while (this.f23526a.mo3642u() < u);
                return;
            } else if (i == 5) {
                do {
                    abo.m36711a(this.f23526a.mo3621c());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 2) {
            i2 = this.f23526a.mo3634m();
            m29547c(i2);
            int u2 = this.f23526a.mo3642u() + i2;
            do {
                list.add(Float.valueOf(this.f23526a.mo3621c()));
            } while (this.f23526a.mo3642u() < u2);
        } else if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.f23526a.mo3621c()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: b */
    public final <T> void mo3651b(List<T> list, adq<T> adq, abd abd) {
        if ((this.f23527b & 7) == 3) {
            int a;
            int i = this.f23527b;
            do {
                list.add(m29548d(adq, abd));
                if (!this.f23526a.mo3641t()) {
                    if (this.f23529d == 0) {
                        a = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                }
                return;
            } while (a == i);
            this.f23529d = a;
            return;
        }
        throw abw.m17950f();
    }

    /* renamed from: c */
    public final void mo3652c(List<Long> list) {
        int u;
        if (list instanceof acl) {
            acl acl = (acl) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    acl.m36732a(this.f23526a.mo3623d());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    acl.m36732a(this.f23526a.mo3623d());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.f23526a.mo3623d()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Long.valueOf(this.f23526a.mo3623d()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: c */
    public final boolean mo3653c() {
        if (!this.f23526a.mo3641t()) {
            if (this.f23527b != this.f23528c) {
                return this.f23526a.mo3620b(this.f23527b);
            }
        }
        return false;
    }

    /* renamed from: d */
    public final double mo3654d() {
        m29543a(1);
        return this.f23526a.mo3619b();
    }

    /* renamed from: d */
    public final void mo3655d(List<Long> list) {
        if (list instanceof acl) {
            acl acl = (acl) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    acl.m36732a(this.f23526a.mo3625e());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                int u;
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    acl.m36732a(this.f23526a.mo3625e());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.f23526a.mo3625e()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Long.valueOf(this.f23526a.mo3625e()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: e */
    public final float mo3656e() {
        m29543a(5);
        return this.f23526a.mo3621c();
    }

    /* renamed from: e */
    public final void mo3657e(List<Integer> list) {
        if (list instanceof abr) {
            abr abr = (abr) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    abr.m36717c(this.f23526a.mo3627f());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                int u;
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    abr.m36717c(this.f23526a.mo3627f());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f23526a.mo3627f()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Integer.valueOf(this.f23526a.mo3627f()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: f */
    public final long mo3658f() {
        m29543a(0);
        return this.f23526a.mo3623d();
    }

    /* renamed from: f */
    public final void mo3659f(List<Long> list) {
        int m;
        int u;
        if (list instanceof acl) {
            acl acl = (acl) list;
            switch (this.f23527b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.f23526a.mo3634m();
                    m29545b(m);
                    u = this.f23526a.mo3642u() + m;
                    do {
                        acl.m36732a(this.f23526a.mo3628g());
                    } while (this.f23526a.mo3642u() < u);
                    return;
                default:
                    throw abw.m17950f();
            }
            do {
                acl.m36732a(this.f23526a.mo3628g());
                if (!this.f23526a.mo3641t()) {
                    m = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (m == this.f23527b);
            this.f23529d = m;
            return;
        }
        switch (this.f23527b & 7) {
            case 1:
                break;
            case 2:
                m = this.f23526a.mo3634m();
                m29545b(m);
                u = this.f23526a.mo3642u() + m;
                do {
                    list.add(Long.valueOf(this.f23526a.mo3628g()));
                } while (this.f23526a.mo3642u() < u);
                return;
            default:
                throw abw.m17950f();
        }
        do {
            list.add(Long.valueOf(this.f23526a.mo3628g()));
            if (!this.f23526a.mo3641t()) {
                m = this.f23526a.mo3617a();
            } else {
                return;
            }
        } while (m == this.f23527b);
        this.f23529d = m;
    }

    /* renamed from: g */
    public final long mo3660g() {
        m29543a(0);
        return this.f23526a.mo3625e();
    }

    /* renamed from: g */
    public final void mo3661g(List<Integer> list) {
        if (list instanceof abr) {
            abr abr = (abr) list;
            int i = this.f23527b & 7;
            if (i == 2) {
                i = this.f23526a.mo3634m();
                m29547c(i);
                int u = this.f23526a.mo3642u() + i;
                do {
                    abr.m36717c(this.f23526a.mo3629h());
                } while (this.f23526a.mo3642u() < u);
                return;
            } else if (i == 5) {
                do {
                    abr.m36717c(this.f23526a.mo3629h());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 2) {
            i2 = this.f23526a.mo3634m();
            m29547c(i2);
            int u2 = this.f23526a.mo3642u() + i2;
            do {
                list.add(Integer.valueOf(this.f23526a.mo3629h()));
            } while (this.f23526a.mo3642u() < u2);
        } else if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.f23526a.mo3629h()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: h */
    public final int mo3662h() {
        m29543a(0);
        return this.f23526a.mo3627f();
    }

    /* renamed from: h */
    public final void mo3663h(List<Boolean> list) {
        int u;
        if (list instanceof aag) {
            aag aag = (aag) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    aag.m36660a(this.f23526a.mo3630i());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    aag.m36660a(this.f23526a.mo3630i());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.f23526a.mo3630i()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Boolean.valueOf(this.f23526a.mo3630i()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: i */
    public final long mo3664i() {
        m29543a(1);
        return this.f23526a.mo3628g();
    }

    /* renamed from: i */
    public final void mo3665i(List<String> list) {
        m29544a((List) list, false);
    }

    /* renamed from: j */
    public final int mo3666j() {
        m29543a(5);
        return this.f23526a.mo3629h();
    }

    /* renamed from: j */
    public final void mo3667j(List<String> list) {
        m29544a((List) list, true);
    }

    /* renamed from: k */
    public final void mo3668k(List<aai> list) {
        if ((this.f23527b & 7) == 2) {
            int a;
            do {
                list.add(mo3674n());
                if (!this.f23526a.mo3641t()) {
                    a = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (a == this.f23527b);
            this.f23529d = a;
            return;
        }
        throw abw.m17950f();
    }

    /* renamed from: k */
    public final boolean mo3669k() {
        m29543a(0);
        return this.f23526a.mo3630i();
    }

    /* renamed from: l */
    public final String mo3670l() {
        m29543a(2);
        return this.f23526a.mo3631j();
    }

    /* renamed from: l */
    public final void mo3671l(List<Integer> list) {
        int u;
        if (list instanceof abr) {
            abr abr = (abr) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    abr.m36717c(this.f23526a.mo3634m());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    abr.m36717c(this.f23526a.mo3634m());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f23526a.mo3634m()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Integer.valueOf(this.f23526a.mo3634m()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: m */
    public final String mo3672m() {
        m29543a(2);
        return this.f23526a.mo3632k();
    }

    /* renamed from: m */
    public final void mo3673m(List<Integer> list) {
        int u;
        if (list instanceof abr) {
            abr abr = (abr) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    abr.m36717c(this.f23526a.mo3635n());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    abr.m36717c(this.f23526a.mo3635n());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f23526a.mo3635n()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Integer.valueOf(this.f23526a.mo3635n()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: n */
    public final aai mo3674n() {
        m29543a(2);
        return this.f23526a.mo3633l();
    }

    /* renamed from: n */
    public final void mo3675n(List<Integer> list) {
        if (list instanceof abr) {
            abr abr = (abr) list;
            int i = this.f23527b & 7;
            if (i == 2) {
                i = this.f23526a.mo3634m();
                m29547c(i);
                int u = this.f23526a.mo3642u() + i;
                do {
                    abr.m36717c(this.f23526a.mo3636o());
                } while (this.f23526a.mo3642u() < u);
                return;
            } else if (i == 5) {
                do {
                    abr.m36717c(this.f23526a.mo3636o());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 2) {
            i2 = this.f23526a.mo3634m();
            m29547c(i2);
            int u2 = this.f23526a.mo3642u() + i2;
            do {
                list.add(Integer.valueOf(this.f23526a.mo3636o()));
            } while (this.f23526a.mo3642u() < u2);
        } else if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.f23526a.mo3636o()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: o */
    public final int mo3676o() {
        m29543a(0);
        return this.f23526a.mo3634m();
    }

    /* renamed from: o */
    public final void mo3677o(List<Long> list) {
        int m;
        int u;
        if (list instanceof acl) {
            acl acl = (acl) list;
            switch (this.f23527b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.f23526a.mo3634m();
                    m29545b(m);
                    u = this.f23526a.mo3642u() + m;
                    do {
                        acl.m36732a(this.f23526a.mo3637p());
                    } while (this.f23526a.mo3642u() < u);
                    return;
                default:
                    throw abw.m17950f();
            }
            do {
                acl.m36732a(this.f23526a.mo3637p());
                if (!this.f23526a.mo3641t()) {
                    m = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (m == this.f23527b);
            this.f23529d = m;
            return;
        }
        switch (this.f23527b & 7) {
            case 1:
                break;
            case 2:
                m = this.f23526a.mo3634m();
                m29545b(m);
                u = this.f23526a.mo3642u() + m;
                do {
                    list.add(Long.valueOf(this.f23526a.mo3637p()));
                } while (this.f23526a.mo3642u() < u);
                return;
            default:
                throw abw.m17950f();
        }
        do {
            list.add(Long.valueOf(this.f23526a.mo3637p()));
            if (!this.f23526a.mo3641t()) {
                m = this.f23526a.mo3617a();
            } else {
                return;
            }
        } while (m == this.f23527b);
        this.f23529d = m;
    }

    /* renamed from: p */
    public final int mo3678p() {
        m29543a(0);
        return this.f23526a.mo3635n();
    }

    /* renamed from: p */
    public final void mo3679p(List<Integer> list) {
        if (list instanceof abr) {
            abr abr = (abr) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    abr.m36717c(this.f23526a.mo3638q());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                int u;
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    abr.m36717c(this.f23526a.mo3638q());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.f23526a.mo3638q()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Integer.valueOf(this.f23526a.mo3638q()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: q */
    public final int mo3680q() {
        m29543a(5);
        return this.f23526a.mo3636o();
    }

    /* renamed from: q */
    public final void mo3681q(List<Long> list) {
        if (list instanceof acl) {
            acl acl = (acl) list;
            int i = this.f23527b & 7;
            if (i == 0) {
                do {
                    acl.m36732a(this.f23526a.mo3639r());
                    if (!this.f23526a.mo3641t()) {
                        i = this.f23526a.mo3617a();
                    } else {
                        return;
                    }
                } while (i == this.f23527b);
                this.f23529d = i;
                return;
            } else if (i == 2) {
                int u;
                u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
                do {
                    acl.m36732a(this.f23526a.mo3639r());
                } while (this.f23526a.mo3642u() < u);
                m29549d(u);
                return;
            } else {
                throw abw.m17950f();
            }
        }
        int i2 = this.f23527b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.f23526a.mo3639r()));
                if (!this.f23526a.mo3641t()) {
                    i2 = this.f23526a.mo3617a();
                } else {
                    return;
                }
            } while (i2 == this.f23527b);
            this.f23529d = i2;
        } else if (i2 == 2) {
            u = this.f23526a.mo3642u() + this.f23526a.mo3634m();
            do {
                list.add(Long.valueOf(this.f23526a.mo3639r()));
            } while (this.f23526a.mo3642u() < u);
            m29549d(u);
        } else {
            throw abw.m17950f();
        }
    }

    /* renamed from: r */
    public final long mo3682r() {
        m29543a(1);
        return this.f23526a.mo3637p();
    }

    /* renamed from: s */
    public final int mo3683s() {
        m29543a(0);
        return this.f23526a.mo3638q();
    }

    /* renamed from: t */
    public final long mo3684t() {
        m29543a(0);
        return this.f23526a.mo3639r();
    }
}
