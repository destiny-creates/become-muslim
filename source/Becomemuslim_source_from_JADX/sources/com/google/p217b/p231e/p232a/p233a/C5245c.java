package com.google.p217b.p231e.p232a.p233a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow */
/* renamed from: com.google.b.e.a.a.c */
final class C5245c {
    /* renamed from: a */
    private final List<C5244b> f17697a;
    /* renamed from: b */
    private final int f17698b;
    /* renamed from: c */
    private final boolean f17699c;

    C5245c(List<C5244b> list, int i, boolean z) {
        this.f17697a = new ArrayList(list);
        this.f17698b = i;
        this.f17699c = z;
    }

    /* renamed from: a */
    List<C5244b> m22221a() {
        return this.f17697a;
    }

    /* renamed from: b */
    int m22223b() {
        return this.f17698b;
    }

    /* renamed from: a */
    boolean m22222a(List<C5244b> list) {
        return this.f17697a.equals(list);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");
        stringBuilder.append(this.f17697a);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5245c)) {
            return false;
        }
        C5245c c5245c = (C5245c) obj;
        if (this.f17697a.equals(c5245c.m22221a()) && this.f17699c == c5245c.f17699c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f17697a.hashCode() ^ Boolean.valueOf(this.f17699c).hashCode();
    }
}
