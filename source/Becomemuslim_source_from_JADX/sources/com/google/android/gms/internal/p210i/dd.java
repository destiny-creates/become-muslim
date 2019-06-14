package com.google.android.gms.internal.p210i;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.i.dd */
public final class dd {
    /* renamed from: a */
    private final List<cz> f16481a;
    /* renamed from: b */
    private final List<cz> f16482b;
    /* renamed from: c */
    private final List<cz> f16483c;
    /* renamed from: d */
    private final List<cz> f16484d;
    /* renamed from: e */
    private final List<cz> f16485e;
    /* renamed from: f */
    private final List<cz> f16486f;
    /* renamed from: g */
    private final List<String> f16487g;
    /* renamed from: h */
    private final List<String> f16488h;
    /* renamed from: i */
    private final List<String> f16489i;
    /* renamed from: j */
    private final List<String> f16490j;

    private dd(List<cz> list, List<cz> list2, List<cz> list3, List<cz> list4, List<cz> list5, List<cz> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
        this.f16481a = Collections.unmodifiableList(list);
        this.f16482b = Collections.unmodifiableList(list2);
        this.f16483c = Collections.unmodifiableList(list3);
        this.f16484d = Collections.unmodifiableList(list4);
        this.f16485e = Collections.unmodifiableList(list5);
        this.f16486f = Collections.unmodifiableList(list6);
        this.f16487g = Collections.unmodifiableList(list7);
        this.f16488h = Collections.unmodifiableList(list8);
        this.f16489i = Collections.unmodifiableList(list9);
        this.f16490j = Collections.unmodifiableList(list10);
    }

    /* renamed from: a */
    public final List<cz> m20422a() {
        return this.f16481a;
    }

    /* renamed from: b */
    public final List<cz> m20423b() {
        return this.f16482b;
    }

    /* renamed from: c */
    public final List<cz> m20424c() {
        return this.f16483c;
    }

    /* renamed from: d */
    public final List<cz> m20425d() {
        return this.f16484d;
    }

    /* renamed from: e */
    public final List<cz> m20426e() {
        return this.f16485e;
    }

    /* renamed from: f */
    public final List<cz> m20427f() {
        return this.f16486f;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f16481a);
        String valueOf2 = String.valueOf(this.f16482b);
        String valueOf3 = String.valueOf(this.f16483c);
        String valueOf4 = String.valueOf(this.f16484d);
        String valueOf5 = String.valueOf(this.f16485e);
        String valueOf6 = String.valueOf(this.f16486f);
        StringBuilder stringBuilder = new StringBuilder((((((String.valueOf(valueOf).length() + 102) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length());
        stringBuilder.append("Positive predicates: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("  Negative predicates: ");
        stringBuilder.append(valueOf2);
        stringBuilder.append("  Add tags: ");
        stringBuilder.append(valueOf3);
        stringBuilder.append("  Remove tags: ");
        stringBuilder.append(valueOf4);
        stringBuilder.append("  Add macros: ");
        stringBuilder.append(valueOf5);
        stringBuilder.append("  Remove macros: ");
        stringBuilder.append(valueOf6);
        return stringBuilder.toString();
    }
}
