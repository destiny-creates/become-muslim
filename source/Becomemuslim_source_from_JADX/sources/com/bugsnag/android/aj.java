package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Session */
class aj implements C1071a {
    /* renamed from: a */
    final AtomicBoolean f9174a = new AtomicBoolean(false);
    /* renamed from: b */
    private final String f9175b;
    /* renamed from: c */
    private final Date f9176c;
    /* renamed from: d */
    private final aq f9177d;
    /* renamed from: e */
    private AtomicBoolean f9178e;
    /* renamed from: f */
    private AtomicInteger f9179f = new AtomicInteger();
    /* renamed from: g */
    private AtomicInteger f9180g = new AtomicInteger();
    /* renamed from: h */
    private AtomicBoolean f9181h = new AtomicBoolean(false);

    /* renamed from: a */
    static aj m11041a(aj ajVar) {
        aj ajVar2 = new aj(ajVar.f9175b, ajVar.f9176c, ajVar.f9177d, ajVar.f9179f.get(), ajVar.f9180g.get());
        ajVar2.f9181h.set(ajVar.f9181h.get());
        ajVar2.f9178e.set(ajVar.m11049h());
        return ajVar2;
    }

    public aj(String str, Date date, aq aqVar, boolean z) {
        this.f9175b = str;
        this.f9176c = new Date(date.getTime());
        this.f9177d = aqVar;
        this.f9178e = new AtomicBoolean(z);
    }

    aj(String str, Date date, aq aqVar, int i, int i2) {
        this.f9175b = str;
        this.f9176c = new Date(date.getTime());
        this.f9177d = aqVar;
        this.f9178e = new AtomicBoolean(false);
        this.f9179f = new AtomicInteger(i);
        this.f9180g = new AtomicInteger(i2);
        this.f9181h = new AtomicBoolean(true);
    }

    /* renamed from: a */
    String m11042a() {
        return this.f9175b;
    }

    /* renamed from: b */
    Date m11043b() {
        return new Date(this.f9176c.getTime());
    }

    /* renamed from: c */
    int m11044c() {
        return this.f9179f.intValue();
    }

    /* renamed from: d */
    int m11045d() {
        return this.f9180g.intValue();
    }

    /* renamed from: e */
    aj m11046e() {
        this.f9180g.incrementAndGet();
        return m11041a(this);
    }

    /* renamed from: f */
    aj m11047f() {
        this.f9179f.incrementAndGet();
        return m11041a(this);
    }

    /* renamed from: g */
    AtomicBoolean m11048g() {
        return this.f9181h;
    }

    /* renamed from: h */
    boolean m11049h() {
        return this.f9178e.get();
    }

    public void toStream(ab abVar) {
        abVar.mo772c().mo773c("id").mo771b(this.f9175b).mo773c("startedAt").mo771b(C1093m.m3874a(this.f9176c));
        if (this.f9177d != null) {
            abVar.mo764a("user").m11021a(this.f9177d);
        }
        abVar.mo770b();
    }
}
