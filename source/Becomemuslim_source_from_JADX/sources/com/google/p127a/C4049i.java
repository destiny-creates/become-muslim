package com.google.p127a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray */
/* renamed from: com.google.a.i */
public final class C4049i extends C2162l implements Iterable<C2162l> {
    /* renamed from: a */
    private final List<C2162l> f10122a = new ArrayList();

    /* renamed from: a */
    public void m12466a(C2162l c2162l) {
        if (c2162l == null) {
            c2162l = C4051n.f10123a;
        }
        this.f10122a.add(c2162l);
    }

    public Iterator<C2162l> iterator() {
        return this.f10122a.iterator();
    }

    /* renamed from: a */
    public Number mo2031a() {
        if (this.f10122a.size() == 1) {
            return ((C2162l) this.f10122a.get(0)).mo2031a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public String mo2032b() {
        if (this.f10122a.size() == 1) {
            return ((C2162l) this.f10122a.get(0)).mo2032b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    public double mo2033c() {
        if (this.f10122a.size() == 1) {
            return ((C2162l) this.f10122a.get(0)).mo2033c();
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public long mo2034d() {
        if (this.f10122a.size() == 1) {
            return ((C2162l) this.f10122a.get(0)).mo2034d();
        }
        throw new IllegalStateException();
    }

    /* renamed from: e */
    public int mo2035e() {
        if (this.f10122a.size() == 1) {
            return ((C2162l) this.f10122a.get(0)).mo2035e();
        }
        throw new IllegalStateException();
    }

    /* renamed from: f */
    public boolean mo2036f() {
        if (this.f10122a.size() == 1) {
            return ((C2162l) this.f10122a.get(0)).mo2036f();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof C4049i) || ((C4049i) obj).f10122a.equals(this.f10122a) == null) {
                return null;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f10122a.hashCode();
    }
}
