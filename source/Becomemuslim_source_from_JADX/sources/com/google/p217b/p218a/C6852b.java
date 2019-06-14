package com.google.p217b.p218a;

import com.google.p217b.C5193a;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5312o;
import com.google.p217b.C5313p;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C5317t;
import com.google.p217b.C6891h;
import com.google.p217b.C6894l;
import com.google.p217b.p218a.p219a.C5184a;
import com.google.p217b.p218a.p220b.C5186a;
import com.google.p217b.p222b.C5205e;
import java.util.Map;

/* compiled from: AztecReader */
/* renamed from: com.google.b.a.b */
public final class C6852b implements C5312o {
    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        C5316s[] e;
        C5316s[] c5316sArr;
        C6894l c6894l;
        C6894l c6894l2;
        C6851a a;
        C5316s[] c5316sArr2;
        C5317t c5317t;
        int length;
        C5232c c5314q;
        C5313p e2;
        C5186a c5186a = new C5186a(c5232c.m22164c());
        c5232c = null;
        C5205e c5205e = null;
        try {
            C6851a a2 = c5186a.m21908a(false);
            e = a2.m22034e();
            try {
                C5205e a3 = new C5184a().m21887a(a2);
                c5316sArr = e;
                c6894l = null;
                c5205e = a3;
                c6894l2 = c6894l;
            } catch (C6894l e3) {
                c6894l2 = e3;
                c5316sArr = e;
                c6894l = null;
                if (c5205e == null) {
                    try {
                        a = c5186a.m21908a(true);
                        c5316sArr = a.m22034e();
                        c5205e = new C5184a().m21887a(a);
                    } catch (C5232c c5232c2) {
                        if (c6894l2 != null) {
                            throw c6894l2;
                        } else if (c6894l == null) {
                            throw c5232c2;
                        } else {
                            throw c6894l;
                        }
                    }
                }
                c5316sArr2 = c5316sArr;
                if (map != null) {
                    c5317t = (C5317t) map.get(C5254e.NEED_RESULT_POINT_CALLBACK);
                    if (c5317t != null) {
                        length = c5316sArr2.length;
                        while (c5232c2 < length) {
                            c5317t.m22584a(c5316sArr2[c5232c2]);
                            c5232c2++;
                        }
                    }
                }
                c5314q = new C5314q(c5205e.m22026c(), c5205e.m22023a(), c5205e.m22024b(), c5316sArr2, C5193a.AZTEC, System.currentTimeMillis());
                map = c5205e.m22027d();
                if (map != null) {
                    c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
                }
                map = c5205e.m22028e();
                if (map != null) {
                    c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, map);
                }
                return c5314q;
            } catch (C6891h e4) {
                e2 = e4;
                c5316sArr = e;
                c6894l = e2;
                c6894l2 = null;
                if (c5205e == null) {
                    a = c5186a.m21908a(true);
                    c5316sArr = a.m22034e();
                    c5205e = new C5184a().m21887a(a);
                }
                c5316sArr2 = c5316sArr;
                if (map != null) {
                    c5317t = (C5317t) map.get(C5254e.NEED_RESULT_POINT_CALLBACK);
                    if (c5317t != null) {
                        length = c5316sArr2.length;
                        while (c5232c2 < length) {
                            c5317t.m22584a(c5316sArr2[c5232c2]);
                            c5232c2++;
                        }
                    }
                }
                c5314q = new C5314q(c5205e.m22026c(), c5205e.m22023a(), c5205e.m22024b(), c5316sArr2, C5193a.AZTEC, System.currentTimeMillis());
                map = c5205e.m22027d();
                if (map != null) {
                    c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
                }
                map = c5205e.m22028e();
                if (map != null) {
                    c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, map);
                }
                return c5314q;
            }
        } catch (C6894l e5) {
            c6894l2 = e5;
            e = null;
            c5316sArr = e;
            c6894l = null;
            if (c5205e == null) {
                a = c5186a.m21908a(true);
                c5316sArr = a.m22034e();
                c5205e = new C5184a().m21887a(a);
            }
            c5316sArr2 = c5316sArr;
            if (map != null) {
                c5317t = (C5317t) map.get(C5254e.NEED_RESULT_POINT_CALLBACK);
                if (c5317t != null) {
                    length = c5316sArr2.length;
                    while (c5232c2 < length) {
                        c5317t.m22584a(c5316sArr2[c5232c2]);
                        c5232c2++;
                    }
                }
            }
            c5314q = new C5314q(c5205e.m22026c(), c5205e.m22023a(), c5205e.m22024b(), c5316sArr2, C5193a.AZTEC, System.currentTimeMillis());
            map = c5205e.m22027d();
            if (map != null) {
                c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
            }
            map = c5205e.m22028e();
            if (map != null) {
                c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, map);
            }
            return c5314q;
        } catch (C6891h e6) {
            e2 = e6;
            e = null;
            c5316sArr = e;
            c6894l = e2;
            c6894l2 = null;
            if (c5205e == null) {
                a = c5186a.m21908a(true);
                c5316sArr = a.m22034e();
                c5205e = new C5184a().m21887a(a);
            }
            c5316sArr2 = c5316sArr;
            if (map != null) {
                c5317t = (C5317t) map.get(C5254e.NEED_RESULT_POINT_CALLBACK);
                if (c5317t != null) {
                    length = c5316sArr2.length;
                    while (c5232c2 < length) {
                        c5317t.m22584a(c5316sArr2[c5232c2]);
                        c5232c2++;
                    }
                }
            }
            c5314q = new C5314q(c5205e.m22026c(), c5205e.m22023a(), c5205e.m22024b(), c5316sArr2, C5193a.AZTEC, System.currentTimeMillis());
            map = c5205e.m22027d();
            if (map != null) {
                c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
            }
            map = c5205e.m22028e();
            if (map != null) {
                c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, map);
            }
            return c5314q;
        }
        if (c5205e == null) {
            a = c5186a.m21908a(true);
            c5316sArr = a.m22034e();
            c5205e = new C5184a().m21887a(a);
        }
        c5316sArr2 = c5316sArr;
        if (map != null) {
            c5317t = (C5317t) map.get(C5254e.NEED_RESULT_POINT_CALLBACK);
            if (c5317t != null) {
                length = c5316sArr2.length;
                while (c5232c2 < length) {
                    c5317t.m22584a(c5316sArr2[c5232c2]);
                    c5232c2++;
                }
            }
        }
        c5314q = new C5314q(c5205e.m22026c(), c5205e.m22023a(), c5205e.m22024b(), c5316sArr2, C5193a.AZTEC, System.currentTimeMillis());
        map = c5205e.m22027d();
        if (map != null) {
            c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
        }
        map = c5205e.m22028e();
        if (map != null) {
            c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, map);
        }
        return c5314q;
    }
}
