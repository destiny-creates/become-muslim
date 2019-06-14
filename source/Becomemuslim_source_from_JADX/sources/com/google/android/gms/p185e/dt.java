package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.cz;
import com.google.android.gms.internal.p210i.dd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.e.dt */
final class dt {
    /* renamed from: a */
    private final Set<dd> f7542a = new HashSet();
    /* renamed from: b */
    private final Map<dd, List<cz>> f7543b = new HashMap();
    /* renamed from: c */
    private final Map<dd, List<cz>> f7544c = new HashMap();
    /* renamed from: d */
    private final Map<dd, List<String>> f7545d = new HashMap();
    /* renamed from: e */
    private final Map<dd, List<String>> f7546e = new HashMap();
    /* renamed from: f */
    private cz f7547f;

    /* renamed from: a */
    public final Set<dd> m8675a() {
        return this.f7542a;
    }

    /* renamed from: a */
    public final void m8677a(dd ddVar) {
        this.f7542a.add(ddVar);
    }

    /* renamed from: b */
    public final Map<dd, List<cz>> m8680b() {
        return this.f7543b;
    }

    /* renamed from: c */
    public final Map<dd, List<String>> m8683c() {
        return this.f7545d;
    }

    /* renamed from: d */
    public final Map<dd, List<String>> m8684d() {
        return this.f7546e;
    }

    /* renamed from: a */
    public final void m8678a(dd ddVar, cz czVar) {
        List list = (List) this.f7543b.get(ddVar);
        if (list == null) {
            list = new ArrayList();
            this.f7543b.put(ddVar, list);
        }
        list.add(czVar);
    }

    /* renamed from: a */
    public final void m8679a(dd ddVar, String str) {
        List list = (List) this.f7545d.get(ddVar);
        if (list == null) {
            list = new ArrayList();
            this.f7545d.put(ddVar, list);
        }
        list.add(str);
    }

    /* renamed from: e */
    public final Map<dd, List<cz>> m8685e() {
        return this.f7544c;
    }

    /* renamed from: b */
    public final void m8681b(dd ddVar, cz czVar) {
        List list = (List) this.f7544c.get(ddVar);
        if (list == null) {
            list = new ArrayList();
            this.f7544c.put(ddVar, list);
        }
        list.add(czVar);
    }

    /* renamed from: b */
    public final void m8682b(dd ddVar, String str) {
        List list = (List) this.f7546e.get(ddVar);
        if (list == null) {
            list = new ArrayList();
            this.f7546e.put(ddVar, list);
        }
        list.add(str);
    }

    /* renamed from: f */
    public final cz m8686f() {
        return this.f7547f;
    }

    /* renamed from: a */
    public final void m8676a(cz czVar) {
        this.f7547f = czVar;
    }
}
