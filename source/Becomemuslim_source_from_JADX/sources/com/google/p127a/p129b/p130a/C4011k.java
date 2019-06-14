package com.google.p127a.p129b.p130a;

import com.google.p127a.C2157f;
import com.google.p127a.C2168w;
import com.google.p127a.C2169x;
import com.google.p127a.C4054t;
import com.google.p127a.p131c.C2150a;
import com.google.p127a.p132d.C2152a;
import com.google.p127a.p132d.C2153b;
import com.google.p127a.p132d.C2154c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: TimeTypeAdapter */
/* renamed from: com.google.a.b.a.k */
public final class C4011k extends C2168w<Time> {
    /* renamed from: a */
    public static final C2169x f10048a = new C40101();
    /* renamed from: b */
    private final DateFormat f10049b = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter */
    /* renamed from: com.google.a.b.a.k$1 */
    static class C40101 implements C2169x {
        C40101() {
        }

        /* renamed from: a */
        public <T> C2168w<T> mo1990a(C2157f c2157f, C2150a<T> c2150a) {
            return c2150a.m5891a() == Time.class ? new C4011k() : null;
        }
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1992b(C2152a c2152a) {
        return m12294a(c2152a);
    }

    /* renamed from: a */
    public synchronized Time m12294a(C2152a c2152a) {
        if (c2152a.mo1999f() == C2153b.NULL) {
            c2152a.mo2003j();
            return null;
        }
        try {
            return new Time(this.f10049b.parse(c2152a.mo2001h()).getTime());
        } catch (Throwable e) {
            throw new C4054t(e);
        }
    }

    /* renamed from: a */
    public synchronized void m12296a(C2154c c2154c, Time time) {
        c2154c.mo2016b(time == null ? null : this.f10049b.format(time));
    }
}
