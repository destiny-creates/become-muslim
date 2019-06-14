package com.google.android.gms.internal.p210i;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.gy */
final class gy<T> implements hi<T> {
    /* renamed from: a */
    private final gt f24524a;
    /* renamed from: b */
    private final ib<?, ?> f24525b;
    /* renamed from: c */
    private final boolean f24526c;
    /* renamed from: d */
    private final ex<?> f24527d;

    private gy(ib<?, ?> ibVar, ex<?> exVar, gt gtVar) {
        this.f24525b = ibVar;
        this.f24526c = exVar.mo4549a(gtVar);
        this.f24527d = exVar;
        this.f24524a = gtVar;
    }

    /* renamed from: a */
    static <T> gy<T> m31673a(ib<?, ?> ibVar, ex<?> exVar, gt gtVar) {
        return new gy(ibVar, exVar, gtVar);
    }

    /* renamed from: a */
    public final T mo4569a() {
        return this.f24524a.mo6738u().mo6729d();
    }

    /* renamed from: a */
    public final boolean mo4572a(T t, T t2) {
        if (this.f24525b.mo4594b(t).equals(this.f24525b.mo4594b(t2))) {
            return this.f24526c ? this.f24527d.mo4543a((Object) t).equals(this.f24527d.mo4543a((Object) t2)) : true;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public final int mo4568a(T t) {
        int hashCode = this.f24525b.mo4594b(t).hashCode();
        return this.f24526c ? (hashCode * 53) + this.f24527d.mo4543a((Object) t).hashCode() : hashCode;
    }

    /* renamed from: b */
    public final void mo4574b(T t, T t2) {
        hl.m20697a(this.f24525b, (Object) t, (Object) t2);
        if (this.f24526c) {
            hl.m20695a(this.f24527d, (Object) t, (Object) t2);
        }
    }

    /* renamed from: a */
    public final void mo4571a(T t, ix ixVar) {
        Iterator d = this.f24527d.mo4543a((Object) t).m20538d();
        while (d.hasNext()) {
            Entry entry = (Entry) d.next();
            fc fcVar = (fc) entry.getKey();
            if (fcVar.m20546c() != iw.MESSAGE || fcVar.m20547d() || fcVar.m20548e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof fx) {
                ixVar.mo4509a(fcVar.m20542a(), ((fx) entry).m20578a().m20582c());
            } else {
                ixVar.mo4509a(fcVar.m20542a(), entry.getValue());
            }
        }
        ib ibVar = this.f24525b;
        ibVar.mo4596b(ibVar.mo4594b(t), ixVar);
    }

    /* renamed from: a */
    public final void mo4570a(T t, hh hhVar, ew ewVar) {
        ib ibVar = this.f24525b;
        ex exVar = this.f24527d;
        Object c = ibVar.mo4598c(t);
        fa b = exVar.mo4550b(t);
        while (hhVar.mo4459a() != Integer.MAX_VALUE) {
            try {
                boolean a;
                int b2 = hhVar.mo4464b();
                if (b2 != 11) {
                    if ((b2 & 7) == 2) {
                        Object a2 = exVar.mo4544a(ewVar, this.f24524a, b2 >>> 3);
                        if (a2 != null) {
                            exVar.mo4547a(hhVar, a2, ewVar, b);
                        } else {
                            a = ibVar.m20773a(c, hhVar);
                            continue;
                        }
                    } else {
                        a = hhVar.mo4469c();
                        continue;
                    }
                    if (!a) {
                        return;
                    }
                }
                Object obj = null;
                dy dyVar = null;
                int i = 0;
                while (hhVar.mo4459a() != Integer.MAX_VALUE) {
                    int b3 = hhVar.mo4464b();
                    if (b3 == 16) {
                        i = hhVar.mo4492o();
                        obj = exVar.mo4544a(ewVar, this.f24524a, i);
                    } else if (b3 == 26) {
                        if (obj != null) {
                            exVar.mo4547a(hhVar, obj, ewVar, b);
                        } else {
                            dyVar = hhVar.mo4490n();
                        }
                    } else if (!hhVar.mo4469c()) {
                        break;
                    }
                }
                if (hhVar.mo4464b() != 12) {
                    throw fs.m20571d();
                } else if (dyVar != null) {
                    if (obj != null) {
                        exVar.mo4546a(dyVar, obj, ewVar, b);
                    } else {
                        ibVar.mo4589a(c, i, dyVar);
                    }
                }
                a = true;
                continue;
                if (a) {
                    return;
                }
            } finally {
                ibVar.mo4597b((Object) t, c);
            }
        }
        ibVar.mo4597b((Object) t, c);
    }

    /* renamed from: c */
    public final void mo4575c(T t) {
        this.f24525b.mo4600d(t);
        this.f24527d.mo4551c(t);
    }

    /* renamed from: d */
    public final boolean mo4576d(T t) {
        return this.f24527d.mo4543a((Object) t).m20540f();
    }

    /* renamed from: b */
    public final int mo4573b(T t) {
        ib ibVar = this.f24525b;
        int e = ibVar.mo4601e(ibVar.mo4594b(t)) + 0;
        return this.f24526c ? e + this.f24527d.mo4543a((Object) t).m20541g() : e;
    }
}
