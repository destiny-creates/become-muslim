package com.google.android.gms.p185e;

import android.content.Context;
import com.facebook.common.util.ByteConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.bc.C8331c;
import com.google.android.gms.internal.p210i.cr;
import com.google.android.gms.internal.p210i.ct;
import com.google.android.gms.internal.p210i.cx;
import com.google.android.gms.internal.p210i.cz;
import com.google.android.gms.internal.p210i.db;
import com.google.android.gms.internal.p210i.dd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.e.dm */
final class dm {
    /* renamed from: a */
    private static final cj<ct> f7527a = new cj(eu.m8736g(), true);
    /* renamed from: b */
    private final db f7528b;
    /* renamed from: c */
    private final ao f7529c;
    /* renamed from: d */
    private final Map<String, aq> f7530d;
    /* renamed from: e */
    private final Map<String, aq> f7531e;
    /* renamed from: f */
    private final Map<String, aq> f7532f;
    /* renamed from: g */
    private final fh<cz, cj<ct>> f7533g;
    /* renamed from: h */
    private final fh<String, ds> f7534h;
    /* renamed from: i */
    private final Set<dd> f7535i;
    /* renamed from: j */
    private final C2934c f7536j;
    /* renamed from: k */
    private final Map<String, dt> f7537k;
    /* renamed from: l */
    private volatile String f7538l;
    /* renamed from: m */
    private int f7539m;

    public dm(Context context, db dbVar, C2934c c2934c, C2943r c2943r, C2943r c2943r2, ao aoVar) {
        if (dbVar != null) {
            cz czVar;
            this.f7528b = dbVar;
            this.f7535i = new HashSet(dbVar.b());
            this.f7536j = c2934c;
            this.f7529c = aoVar;
            dbVar = new dn(this);
            aoVar = new fi();
            this.f7533g = fi.m8750a(ByteConstants.MB, dbVar);
            dbVar = new C4392do(this);
            fi fiVar = new fi();
            this.f7534h = fi.m8750a(ByteConstants.MB, dbVar);
            this.f7530d = new HashMap();
            m8664b(new fe(context));
            m8664b(new C4400q(c2943r2));
            m8664b(new ad(c2934c));
            m8664b(new ev(context, c2934c));
            this.f7531e = new HashMap();
            m8665c(new C4889o());
            m8665c(new al());
            m8665c(new am());
            m8665c(new as());
            m8665c(new at());
            m8665c(new bo());
            m8665c(new bp());
            m8665c(new cv());
            m8665c(new ej());
            this.f7532f = new HashMap();
            m8660a(new ck(context));
            m8660a(new dk(context));
            m8660a(new ez(context));
            m8660a(new fa(context));
            m8660a(new fb(context));
            m8660a(new fc(context));
            m8660a(new fd(context));
            m8660a(new fl());
            m8660a(new C4399n(this.f7528b.c()));
            m8660a(new C4400q(c2943r));
            m8660a(new C4403w(c2934c));
            m8660a(new ah(context));
            m8660a(new ai());
            m8660a(new ak());
            m8660a(new ap(this));
            m8660a(new au());
            m8660a(new av());
            m8660a(new be(context));
            m8660a(new bg());
            m8660a(new bn());
            m8660a(new bu());
            m8660a(new bw(context));
            m8660a(new cl());
            m8660a(new cp());
            m8660a(new cs());
            m8660a(new cu());
            m8660a(new cw(context));
            m8660a(new du());
            m8660a(new dv());
            m8660a(new ep());
            m8660a(new ew());
            this.f7537k = new HashMap();
            for (dd ddVar : this.f7535i) {
                for (c2943r = null; c2943r < ddVar.e().size(); c2943r++) {
                    cz czVar2 = (cz) ddVar.e().get(c2943r);
                    String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    dt a = dm.m8658a(this.f7537k, dm.m8659a(czVar2));
                    a.m8677a(ddVar);
                    a.m8678a(ddVar, czVar2);
                    a.m8679a(ddVar, str);
                }
                for (c2934c = null; c2934c < ddVar.f().size(); c2934c++) {
                    czVar = (cz) ddVar.f().get(c2934c);
                    String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    aoVar = dm.m8658a(this.f7537k, dm.m8659a(czVar));
                    aoVar.m8677a(ddVar);
                    aoVar.m8681b(ddVar, czVar);
                    aoVar.m8682b(ddVar, str2);
                }
            }
            for (Entry entry : this.f7528b.d().entrySet()) {
                for (cz czVar3 : (List) entry.getValue()) {
                    if (eu.m8731e((ct) czVar3.b().get(ab.f16287B.toString())).booleanValue() == null) {
                        dm.m8658a(this.f7537k, (String) entry.getKey()).m8676a(czVar3);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("resource cannot be null");
    }

    /* renamed from: a */
    public final synchronized void m8669a(List<cr> list) {
        dm dmVar = this;
        synchronized (this) {
            for (cr crVar : list) {
                if (crVar.f28850a != null) {
                    if (crVar.f28850a.startsWith("gaExperiment:")) {
                        C2934c c2934c = dmVar.f7536j;
                        if (crVar.f28851b == null) {
                            bs.m8584b("supplemental missing experimentSupplemental");
                        } else {
                            Object f;
                            for (ct a : crVar.f28851b.f28830b) {
                                c2934c.m8614a(eu.m8719a(a));
                            }
                            ct[] ctVarArr = crVar.f28851b.f28829a;
                            int length = ctVarArr.length;
                            int i = 0;
                            while (true) {
                                Map map = null;
                                if (i >= length) {
                                    break;
                                }
                                f = eu.m8734f(ctVarArr[i]);
                                if (f instanceof Map) {
                                    map = (Map) f;
                                } else {
                                    String valueOf = String.valueOf(f);
                                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 36);
                                    stringBuilder.append("value: ");
                                    stringBuilder.append(valueOf);
                                    stringBuilder.append(" is not a map value, ignored.");
                                    bs.m8584b(stringBuilder.toString());
                                }
                                if (map != null) {
                                    c2934c.m8617a(map);
                                }
                                i++;
                            }
                            for (C8331c c8331c : crVar.f28851b.f28831c) {
                                if (c8331c.a()) {
                                    f = c2934c.m8618b(c8331c.b());
                                    Long valueOf2;
                                    if (f instanceof Number) {
                                        valueOf2 = Long.valueOf(((Number) f).longValue());
                                    } else {
                                        valueOf2 = null;
                                    }
                                    long c = c8331c.c();
                                    long d = c8331c.d();
                                    if (!c8331c.e() || r10 == null || r10.longValue() < c || r10.longValue() > d) {
                                        if (c <= d) {
                                            f = Long.valueOf(Math.round((Math.random() * ((double) (d - c))) + ((double) c)));
                                        } else {
                                            bs.m8584b("GaExperimentRandom: random range invalid");
                                        }
                                    }
                                    c2934c.m8614a(c8331c.b());
                                    Map b = C2934c.m8610b(c8331c.b(), f);
                                    if (c8331c.f() > 0) {
                                        if (b.containsKey("gtm")) {
                                            Object obj = b.get("gtm");
                                            if (obj instanceof Map) {
                                                ((Map) obj).put("lifetime", Long.valueOf(c8331c.f()));
                                            } else {
                                                bs.m8584b("GaExperimentRandom: gtm not a map");
                                            }
                                        } else {
                                            b.put("gtm", C2934c.m8604a("lifetime", Long.valueOf(c8331c.f())));
                                        }
                                    }
                                    c2934c.m8617a(b);
                                } else {
                                    bs.m8584b("GaExperimentRandom: No key");
                                }
                            }
                        }
                    }
                }
                String valueOf3 = String.valueOf(crVar);
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(valueOf3).length() + 22);
                stringBuilder2.append("Ignored supplemental: ");
                stringBuilder2.append(valueOf3);
                bs.m8588e(stringBuilder2.toString());
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m8668a(String str) {
        m8666c(str);
        str = this.f7529c.mo2521b(str).mo2518b();
        for (cz a : (Set) m8657a(this.f7535i, new HashSet(), new dq(this), str.mo2516b()).m8619a()) {
            m8656a(this.f7530d, a, new HashSet(), str.mo2515a());
        }
        m8666c(null);
    }

    /* renamed from: b */
    public final cj<ct> m8670b(String str) {
        this.f7539m = 0;
        return m8655a(str, new HashSet(), this.f7529c.mo2519a(str).mo2517a());
    }

    /* renamed from: c */
    private final synchronized void m8666c(String str) {
        this.f7538l = str;
    }

    /* renamed from: a */
    final synchronized String m8667a() {
        return this.f7538l;
    }

    /* renamed from: a */
    private static dt m8658a(Map<String, dt> map, String str) {
        dt dtVar = (dt) map.get(str);
        if (dtVar != null) {
            return dtVar;
        }
        dtVar = new dt();
        map.put(str, dtVar);
        return dtVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final com.google.android.gms.p185e.cj<java.util.Set<com.google.android.gms.internal.p210i.cz>> m8657a(java.util.Set<com.google.android.gms.internal.p210i.dd> r12, java.util.Set<java.lang.String> r13, com.google.android.gms.p185e.dr r14, com.google.android.gms.p185e.dl r15) {
        /*
        r11 = this;
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = new java.util.HashSet;
        r1.<init>();
        r12 = r12.iterator();
        r2 = 1;
    L_0x000f:
        r3 = 1;
    L_0x0010:
        r4 = r12.hasNext();
        if (r4 == 0) goto L_0x00df;
    L_0x0016:
        r4 = r12.next();
        r4 = (com.google.android.gms.internal.p210i.dd) r4;
        r5 = r15.mo2533a();
        r6 = r4.b();
        r6 = r6.iterator();
    L_0x0028:
        r7 = 1;
    L_0x0029:
        r8 = r6.hasNext();
        r9 = 0;
        if (r8 == 0) goto L_0x006a;
    L_0x0030:
        r8 = r6.next();
        r8 = (com.google.android.gms.internal.p210i.cz) r8;
        r10 = r5.mo2527a();
        r8 = r11.m8654a(r8, r13, r10);
        r10 = r8.m8619a();
        r10 = (java.lang.Boolean) r10;
        r10 = r10.booleanValue();
        if (r10 == 0) goto L_0x005f;
    L_0x004a:
        r6 = java.lang.Boolean.valueOf(r9);
        com.google.android.gms.p185e.eu.m8716a(r6);
        r6 = new com.google.android.gms.e.cj;
        r7 = java.lang.Boolean.valueOf(r9);
        r8 = r8.m8620b();
        r6.<init>(r7, r8);
        goto L_0x00c3;
    L_0x005f:
        if (r7 == 0) goto L_0x0068;
    L_0x0061:
        r7 = r8.m8620b();
        if (r7 == 0) goto L_0x0068;
    L_0x0067:
        goto L_0x0028;
    L_0x0068:
        r7 = 0;
        goto L_0x0029;
    L_0x006a:
        r6 = r4.a();
        r6 = r6.iterator();
    L_0x0072:
        r8 = r6.hasNext();
        if (r8 == 0) goto L_0x00b3;
    L_0x0078:
        r8 = r6.next();
        r8 = (com.google.android.gms.internal.p210i.cz) r8;
        r10 = r5.mo2528b();
        r8 = r11.m8654a(r8, r13, r10);
        r10 = r8.m8619a();
        r10 = (java.lang.Boolean) r10;
        r10 = r10.booleanValue();
        if (r10 != 0) goto L_0x00a7;
    L_0x0092:
        r6 = java.lang.Boolean.valueOf(r9);
        com.google.android.gms.p185e.eu.m8716a(r6);
        r6 = new com.google.android.gms.e.cj;
        r7 = java.lang.Boolean.valueOf(r9);
        r8 = r8.m8620b();
        r6.<init>(r7, r8);
        goto L_0x00c3;
    L_0x00a7:
        if (r7 == 0) goto L_0x00b1;
    L_0x00a9:
        r7 = r8.m8620b();
        if (r7 == 0) goto L_0x00b1;
    L_0x00af:
        r7 = 1;
        goto L_0x0072;
    L_0x00b1:
        r7 = 0;
        goto L_0x0072;
    L_0x00b3:
        r6 = java.lang.Boolean.valueOf(r2);
        com.google.android.gms.p185e.eu.m8716a(r6);
        r6 = new com.google.android.gms.e.cj;
        r8 = java.lang.Boolean.valueOf(r2);
        r6.<init>(r8, r7);
    L_0x00c3:
        r7 = r6.m8619a();
        r7 = (java.lang.Boolean) r7;
        r7 = r7.booleanValue();
        if (r7 == 0) goto L_0x00d2;
    L_0x00cf:
        r14.mo2548a(r4, r0, r1, r5);
    L_0x00d2:
        if (r3 == 0) goto L_0x00dc;
    L_0x00d4:
        r3 = r6.m8620b();
        if (r3 == 0) goto L_0x00dc;
    L_0x00da:
        goto L_0x000f;
    L_0x00dc:
        r3 = 0;
        goto L_0x0010;
    L_0x00df:
        r0.removeAll(r1);
        r15.mo2534a(r0);
        r12 = new com.google.android.gms.e.cj;
        r12.<init>(r0, r3);
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dm.a(java.util.Set, java.util.Set, com.google.android.gms.e.dr, com.google.android.gms.e.dl):com.google.android.gms.e.cj<java.util.Set<com.google.android.gms.internal.i.cz>>");
    }

    /* renamed from: a */
    private static String m8659a(cz czVar) {
        return eu.m8719a((ct) czVar.b().get(ab.f16334v.toString()));
    }

    /* renamed from: a */
    private static void m8662a(Map<String, aq> map, aq aqVar) {
        if (map.containsKey(aqVar.mo2512b())) {
            String str = "Duplicate function type name: ";
            aqVar = String.valueOf(aqVar.mo2512b());
            throw new IllegalArgumentException(aqVar.length() != 0 ? str.concat(aqVar) : new String(str));
        }
        map.put(aqVar.mo2512b(), aqVar);
    }

    /* renamed from: a */
    private final void m8660a(aq aqVar) {
        dm.m8662a(this.f7532f, aqVar);
    }

    /* renamed from: b */
    private final void m8664b(aq aqVar) {
        dm.m8662a(this.f7530d, aqVar);
    }

    /* renamed from: c */
    private final void m8665c(aq aqVar) {
        dm.m8662a(this.f7531e, aqVar);
    }

    /* renamed from: a */
    private final cj<Boolean> m8654a(cz czVar, Set<String> set, cx cxVar) {
        czVar = m8656a(this.f7531e, czVar, (Set) set, cxVar);
        Object e = eu.m8731e((ct) czVar.m8619a());
        cxVar.mo2525a(eu.m8716a(e));
        return new cj(e, czVar.m8620b());
    }

    /* renamed from: b */
    private final String m8663b() {
        if (this.f7539m <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.f7539m));
        for (int i = 2; i < this.f7539m; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private final cj<ct> m8655a(String str, Set<String> set, bv bvVar) {
        this.f7539m++;
        ds dsVar = (ds) this.f7534h.mo2510a(str);
        if (dsVar != null) {
            this.f7529c.mo2520a();
            m8661a(dsVar.m8673b(), (Set) set);
            this.f7539m -= 1;
            return dsVar.m8672a();
        }
        dt dtVar = (dt) this.f7537k.get(str);
        if (dtVar == null) {
            set = m8663b();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(set).length() + 15) + String.valueOf(str).length());
            stringBuilder.append(set);
            stringBuilder.append("Invalid macro: ");
            stringBuilder.append(str);
            bs.m8582a(stringBuilder.toString());
            this.f7539m -= 1;
            return f7527a;
        }
        cz f;
        cj a = m8657a(dtVar.m8675a(), (Set) set, new dp(this, dtVar.m8680b(), dtVar.m8683c(), dtVar.m8685e(), dtVar.m8684d()), bvVar.mo2523b());
        if (((Set) a.m8619a()).isEmpty()) {
            f = dtVar.m8686f();
        } else {
            if (((Set) a.m8619a()).size() > 1) {
                String b = m8663b();
                StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(b).length() + 37) + String.valueOf(str).length());
                stringBuilder2.append(b);
                stringBuilder2.append("Multiple macros active for macroName ");
                stringBuilder2.append(str);
                bs.m8584b(stringBuilder2.toString());
            }
            f = (cz) ((Set) a.m8619a()).iterator().next();
        }
        if (f == null) {
            this.f7539m -= 1;
            return f7527a;
        }
        bvVar = m8656a(this.f7532f, f, (Set) set, bvVar.mo2522a());
        boolean z = a.m8620b() && bvVar.m8620b();
        if (bvVar == f7527a) {
            bvVar = f7527a;
        } else {
            bvVar = new cj((ct) bvVar.m8619a(), z);
        }
        ct c = f.c();
        if (bvVar.m8620b()) {
            this.f7534h.mo2511a(str, new ds(bvVar, c));
        }
        m8661a(c, (Set) set);
        this.f7539m -= 1;
        return bvVar;
    }

    /* renamed from: a */
    private final void m8661a(ct ctVar, Set<String> set) {
        if (ctVar != null) {
            ctVar = m8653a(ctVar, (Set) set, new ch());
            if (ctVar != f7527a) {
                ctVar = eu.m8734f((ct) ctVar.m8619a());
                if ((ctVar instanceof Map) != null) {
                    this.f7536j.m8617a((Map) ctVar);
                } else if ((ctVar instanceof List) != null) {
                    for (Set<String> set2 : (List) ctVar) {
                        if (set2 instanceof Map) {
                            this.f7536j.m8617a((Map) set2);
                        } else {
                            bs.m8584b("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bs.m8584b("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    /* renamed from: a */
    private final cj<ct> m8653a(ct ctVar, Set<String> set, ex exVar) {
        if (!ctVar.f28868l) {
            return new cj(ctVar, true);
        }
        int i = ctVar.f28857a;
        ct a;
        int i2;
        cj a2;
        if (i != 7) {
            switch (i) {
                case 2:
                    a = cx.a(ctVar);
                    a.f28859c = new ct[ctVar.f28859c.length];
                    for (i2 = 0; i2 < ctVar.f28859c.length; i2++) {
                        a2 = m8653a(ctVar.f28859c[i2], (Set) set, exVar.mo2536a(i2));
                        if (a2 == f7527a) {
                            return f7527a;
                        }
                        a.f28859c[i2] = (ct) a2.m8619a();
                    }
                    return new cj(a, false);
                case 3:
                    a = cx.a(ctVar);
                    if (ctVar.f28860d.length != ctVar.f28861e.length) {
                        set = "Invalid serving value: ";
                        ctVar = String.valueOf(ctVar.toString());
                        bs.m8582a(ctVar.length() != null ? set.concat(ctVar) : new String(set));
                        return f7527a;
                    }
                    a.f28860d = new ct[ctVar.f28860d.length];
                    a.f28861e = new ct[ctVar.f28860d.length];
                    i2 = 0;
                    while (i2 < ctVar.f28860d.length) {
                        a2 = m8653a(ctVar.f28860d[i2], (Set) set, exVar.mo2537b(i2));
                        cj a3 = m8653a(ctVar.f28861e[i2], (Set) set, exVar.mo2538c(i2));
                        if (a2 != f7527a) {
                            if (a3 != f7527a) {
                                a.f28860d[i2] = (ct) a2.m8619a();
                                a.f28861e[i2] = (ct) a3.m8619a();
                                i2++;
                            }
                        }
                        return f7527a;
                    }
                    return new cj(a, false);
                case 4:
                    if (set.contains(ctVar.f28862f)) {
                        ctVar = ctVar.f28862f;
                        set = set.toString();
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(ctVar).length() + 79) + String.valueOf(set).length());
                        stringBuilder.append("Macro cycle detected.  Current macro reference: ");
                        stringBuilder.append(ctVar);
                        stringBuilder.append(".  Previous macro references: ");
                        stringBuilder.append(set);
                        stringBuilder.append(".");
                        bs.m8582a(stringBuilder.toString());
                        return f7527a;
                    }
                    set.add(ctVar.f28862f);
                    exVar = ey.m8743a(m8655a(ctVar.f28862f, (Set) set, exVar.mo2535a()), ctVar.f28867k);
                    set.remove(ctVar.f28862f);
                    return exVar;
                default:
                    ctVar = ctVar.f28857a;
                    exVar = new StringBuilder(25);
                    exVar.append("Unknown type: ");
                    exVar.append(ctVar);
                    bs.m8582a(exVar.toString());
                    return f7527a;
            }
        }
        a = cx.a(ctVar);
        a.f28866j = new ct[ctVar.f28866j.length];
        for (i2 = 0; i2 < ctVar.f28866j.length; i2++) {
            a2 = m8653a(ctVar.f28866j[i2], (Set) set, exVar.mo2539d(i2));
            if (a2 == f7527a) {
                return f7527a;
            }
            a.f28866j[i2] = (ct) a2.m8619a();
        }
        return new cj(a, false);
    }

    /* renamed from: a */
    private final cj<ct> m8656a(Map<String, aq> map, cz czVar, Set<String> set, cx cxVar) {
        ct ctVar = (ct) czVar.b().get(ab.f16329q.toString());
        if (ctVar == null) {
            bs.m8582a("No function id in properties");
            return f7527a;
        }
        String str = ctVar.f28863g;
        aq aqVar = (aq) map.get(str);
        if (aqVar == null) {
            bs.m8582a(String.valueOf(str).concat(" has no backing implementation."));
            return f7527a;
        }
        cj<ct> cjVar = (cj) this.f7533g.mo2510a(czVar);
        if (cjVar != null) {
            this.f7529c.mo2520a();
            return cjVar;
        }
        Map hashMap = new HashMap();
        boolean z = true;
        Object obj = 1;
        for (Entry entry : czVar.b().entrySet()) {
            cj a = m8653a((ct) entry.getValue(), (Set) set, cxVar.mo2524a((String) entry.getKey()).mo2526a((ct) entry.getValue()));
            if (a == f7527a) {
                return f7527a;
            }
            if (a.m8620b()) {
                czVar.a((String) entry.getKey(), (ct) a.m8619a());
            } else {
                obj = null;
            }
            hashMap.put((String) entry.getKey(), (ct) a.m8619a());
        }
        if (aqVar.m8555a(hashMap.keySet()) == null) {
            map = String.valueOf(aqVar.mo2513c());
            czVar = String.valueOf(hashMap.keySet());
            cxVar = new StringBuilder(((String.valueOf(str).length() + 43) + String.valueOf(map).length()) + String.valueOf(czVar).length());
            cxVar.append("Incorrect keys for function ");
            cxVar.append(str);
            cxVar.append(" required ");
            cxVar.append(map);
            cxVar.append(" had ");
            cxVar.append(czVar);
            bs.m8582a(cxVar.toString());
            return f7527a;
        }
        if (obj == null || aqVar.mo2507a() == null) {
            z = false;
        }
        set = new cj(aqVar.mo2506a(hashMap), z);
        if (z) {
            this.f7533g.mo2511a(czVar, set);
        }
        cxVar.mo2525a((ct) set.m8619a());
        return set;
    }
}
