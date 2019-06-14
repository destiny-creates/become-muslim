package com.google.p127a;

import com.google.p127a.p129b.C2128a;
import com.google.p127a.p129b.C4034d;
import com.google.p127a.p129b.p130a.C2127m;
import com.google.p127a.p131c.C2150a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder */
/* renamed from: com.google.a.g */
public final class C2158g {
    /* renamed from: a */
    private C4034d f5185a = C4034d.f10096a;
    /* renamed from: b */
    private C2166u f5186b = C2166u.DEFAULT;
    /* renamed from: c */
    private C2156e f5187c = C4042d.IDENTITY;
    /* renamed from: d */
    private final Map<Type, C2159h<?>> f5188d = new HashMap();
    /* renamed from: e */
    private final List<C2169x> f5189e = new ArrayList();
    /* renamed from: f */
    private final List<C2169x> f5190f = new ArrayList();
    /* renamed from: g */
    private boolean f5191g;
    /* renamed from: h */
    private String f5192h;
    /* renamed from: i */
    private int f5193i = 2;
    /* renamed from: j */
    private int f5194j = 2;
    /* renamed from: k */
    private boolean f5195k;
    /* renamed from: l */
    private boolean f5196l;
    /* renamed from: m */
    private boolean f5197m = true;
    /* renamed from: n */
    private boolean f5198n;
    /* renamed from: o */
    private boolean f5199o;

    /* renamed from: a */
    public C2158g m5987a(String str) {
        this.f5192h = str;
        return this;
    }

    /* renamed from: a */
    public C2158g m5988a(Type type, Object obj) {
        boolean z;
        boolean z2 = obj instanceof C2165s;
        if (!(z2 || (obj instanceof C2161k) || (obj instanceof C2159h))) {
            if (!(obj instanceof C2168w)) {
                z = false;
                C2128a.m5835a(z);
                if (obj instanceof C2159h) {
                    this.f5188d.put(type, (C2159h) obj);
                }
                if (z2 || (obj instanceof C2161k)) {
                    this.f5189e.add(C4058v.m12491b(C2150a.m5888a(type), obj));
                }
                if (obj instanceof C2168w) {
                    this.f5189e.add(C2127m.m5829a(C2150a.m5888a(type), (C2168w) obj));
                }
                return this;
            }
        }
        z = true;
        C2128a.m5835a(z);
        if (obj instanceof C2159h) {
            this.f5188d.put(type, (C2159h) obj);
        }
        this.f5189e.add(C4058v.m12491b(C2150a.m5888a(type), obj));
        if (obj instanceof C2168w) {
            this.f5189e.add(C2127m.m5829a(C2150a.m5888a(type), (C2168w) obj));
        }
        return this;
    }

    /* renamed from: a */
    public C2157f m5986a() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f5189e);
        Collections.reverse(arrayList);
        arrayList.addAll(this.f5190f);
        m5985a(this.f5192h, this.f5193i, this.f5194j, arrayList);
        return new C2157f(this.f5185a, this.f5187c, this.f5188d, this.f5191g, this.f5195k, this.f5199o, this.f5197m, this.f5198n, this.f5196l, this.f5186b, arrayList);
    }

    /* renamed from: a */
    private void m5985a(String str, int i, int i2, List<C2169x> list) {
        Object c3991a;
        if (str != null && !"".equals(str.trim())) {
            c3991a = new C3991a(str);
        } else if (i != 2 && i2 != 2) {
            c3991a = new C3991a(i, i2);
        } else {
            return;
        }
        list.add(C4058v.m12490a(C2150a.m5890b(Date.class), c3991a));
        list.add(C4058v.m12490a(C2150a.m5890b(Timestamp.class), c3991a));
        list.add(C4058v.m12490a(C2150a.m5890b(java.sql.Date.class), c3991a));
    }
}
