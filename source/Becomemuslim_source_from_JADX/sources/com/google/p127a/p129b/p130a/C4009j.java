package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.C4054t;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
/* renamed from: com.google.a.b.a.j */
public final class C4009j extends C2168w<Date> {
    /* renamed from: a */
    public static final C2169x f10046a = new C40081();
    /* renamed from: b */
    private final DateFormat f10047b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter */
    /* renamed from: com.google.a.b.a.j$1 */
    static class C40081 implements C2169x {
        C40081() {
        }

        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            return c2150a.m5891a() == Date.class ? new C4009j() : null;
        }
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1992b(C2152a c2152a) {
        return m12289a(c2152a);
    }

    /* renamed from: a */
    public synchronized Date m12289a(C2152a c2152a) {
        if (c2152a.mo1999f() == C2153b.NULL) {
            c2152a.mo2003j();
            return null;
        }
        try {
            return new Date(this.f10047b.parse(c2152a.mo2001h()).getTime());
        } catch (Throwable e) {
            throw new C4054t(e);
        }
    }

    /* renamed from: a */
    public synchronized void m12291a(C2154c c2154c, Date date) {
        c2154c.mo2016b(date == null ? null : this.f10047b.format(date));
    }
}
