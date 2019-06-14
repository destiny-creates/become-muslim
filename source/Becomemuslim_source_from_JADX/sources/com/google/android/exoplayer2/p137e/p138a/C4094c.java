package com.google.android.exoplayer2.p137e.p138a;

import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* compiled from: ScriptTagPayloadReader */
/* renamed from: com.google.android.exoplayer2.e.a.c */
final class C4094c extends C2260d {
    /* renamed from: b */
    private long f10373b = -9223372036854775807L;

    /* renamed from: a */
    protected boolean mo2160a(C2529l c2529l) {
        return true;
    }

    public C4094c() {
        super(null);
    }

    /* renamed from: a */
    public long m12819a() {
        return this.f10373b;
    }

    /* renamed from: a */
    protected void mo2159a(C2529l c2529l, long j) {
        if (C4094c.m12811b(c2529l) == 2) {
            if ("onMetaData".equals(C4094c.m12814e(c2529l)) != null && C4094c.m12811b(c2529l) == 8) {
                c2529l = C4094c.m12817h(c2529l);
                if (c2529l.containsKey("duration") != null) {
                    c2529l = ((Double) c2529l.get("duration")).doubleValue();
                    if (c2529l > 0.0d) {
                        this.f10373b = (long) (c2529l * 1000000.0d);
                    }
                }
                return;
            }
            return;
        }
        throw new C2571p();
    }

    /* renamed from: b */
    private static int m12811b(C2529l c2529l) {
        return c2529l.m7103g();
    }

    /* renamed from: c */
    private static Boolean m12812c(C2529l c2529l) {
        boolean z = true;
        if (c2529l.m7103g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: d */
    private static Double m12813d(C2529l c2529l) {
        return Double.valueOf(Double.longBitsToDouble(c2529l.m7113q()));
    }

    /* renamed from: e */
    private static String m12814e(C2529l c2529l) {
        int h = c2529l.m7104h();
        int d = c2529l.m7097d();
        c2529l.m7098d(h);
        return new String(c2529l.f6441a, d, h);
    }

    /* renamed from: f */
    private static ArrayList<Object> m12815f(C2529l c2529l) {
        int u = c2529l.m7117u();
        ArrayList<Object> arrayList = new ArrayList(u);
        for (int i = 0; i < u; i++) {
            arrayList.add(C4094c.m12810a(c2529l, C4094c.m12811b(c2529l)));
        }
        return arrayList;
    }

    /* renamed from: g */
    private static HashMap<String, Object> m12816g(C2529l c2529l) {
        HashMap<String, Object> hashMap = new HashMap();
        while (true) {
            String e = C4094c.m12814e(c2529l);
            int b = C4094c.m12811b(c2529l);
            if (b == 9) {
                return hashMap;
            }
            hashMap.put(e, C4094c.m12810a(c2529l, b));
        }
    }

    /* renamed from: h */
    private static HashMap<String, Object> m12817h(C2529l c2529l) {
        int u = c2529l.m7117u();
        HashMap<String, Object> hashMap = new HashMap(u);
        for (int i = 0; i < u; i++) {
            hashMap.put(C4094c.m12814e(c2529l), C4094c.m12810a(c2529l, C4094c.m12811b(c2529l)));
        }
        return hashMap;
    }

    /* renamed from: i */
    private static Date m12818i(C2529l c2529l) {
        Date date = new Date((long) C4094c.m12813d(c2529l).doubleValue());
        c2529l.m7098d(2);
        return date;
    }

    /* renamed from: a */
    private static Object m12810a(C2529l c2529l, int i) {
        if (i == 8) {
            return C4094c.m12817h(c2529l);
        }
        switch (i) {
            case 0:
                return C4094c.m12813d(c2529l);
            case 1:
                return C4094c.m12812c(c2529l);
            case 2:
                return C4094c.m12814e(c2529l);
            case 3:
                return C4094c.m12816g(c2529l);
            default:
                switch (i) {
                    case 10:
                        return C4094c.m12815f(c2529l);
                    case 11:
                        return C4094c.m12818i(c2529l);
                    default:
                        return null;
                }
        }
    }
}
