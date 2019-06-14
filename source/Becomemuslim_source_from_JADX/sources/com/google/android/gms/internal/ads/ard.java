package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.C2683b;
import com.google.android.gms.ads.p170d.C2629a;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@cm
public final class ard {
    /* renamed from: a */
    private final Date f14821a;
    /* renamed from: b */
    private final String f14822b;
    /* renamed from: c */
    private final int f14823c;
    /* renamed from: d */
    private final Set<String> f14824d;
    /* renamed from: e */
    private final Location f14825e;
    /* renamed from: f */
    private final boolean f14826f;
    /* renamed from: g */
    private final Bundle f14827g;
    /* renamed from: h */
    private final Map<Class<? extends Object>, Object> f14828h;
    /* renamed from: i */
    private final String f14829i;
    /* renamed from: j */
    private final String f14830j;
    /* renamed from: k */
    private final C2629a f14831k;
    /* renamed from: l */
    private final int f14832l;
    /* renamed from: m */
    private final Set<String> f14833m;
    /* renamed from: n */
    private final Bundle f14834n;
    /* renamed from: o */
    private final Set<String> f14835o;
    /* renamed from: p */
    private final boolean f14836p;

    public ard(are are) {
        this(are, null);
    }

    public ard(are are, C2629a c2629a) {
        this.f14821a = are.f14843g;
        this.f14822b = are.f14844h;
        this.f14823c = are.f14845i;
        this.f14824d = Collections.unmodifiableSet(are.f14837a);
        this.f14825e = are.f14846j;
        this.f14826f = are.f14847k;
        this.f14827g = are.f14838b;
        this.f14828h = Collections.unmodifiableMap(are.f14839c);
        this.f14829i = are.f14848l;
        this.f14830j = are.f14849m;
        this.f14831k = c2629a;
        this.f14832l = are.f14850n;
        this.f14833m = Collections.unmodifiableSet(are.f14840d);
        this.f14834n = are.f14841e;
        this.f14835o = Collections.unmodifiableSet(are.f14842f);
        this.f14836p = are.f14851o;
    }

    /* renamed from: a */
    public final Bundle m18777a(Class<? extends C2683b> cls) {
        return this.f14827g.getBundle(cls.getName());
    }

    /* renamed from: a */
    public final Date m18778a() {
        return this.f14821a;
    }

    /* renamed from: a */
    public final boolean m18779a(Context context) {
        Set set = this.f14833m;
        aph.m18683a();
        return set.contains(mi.m19866a(context));
    }

    /* renamed from: b */
    public final String m18780b() {
        return this.f14822b;
    }

    /* renamed from: c */
    public final int m18781c() {
        return this.f14823c;
    }

    /* renamed from: d */
    public final Set<String> m18782d() {
        return this.f14824d;
    }

    /* renamed from: e */
    public final Location m18783e() {
        return this.f14825e;
    }

    /* renamed from: f */
    public final boolean m18784f() {
        return this.f14826f;
    }

    /* renamed from: g */
    public final String m18785g() {
        return this.f14829i;
    }

    /* renamed from: h */
    public final String m18786h() {
        return this.f14830j;
    }

    /* renamed from: i */
    public final C2629a m18787i() {
        return this.f14831k;
    }

    /* renamed from: j */
    public final Map<Class<? extends Object>, Object> m18788j() {
        return this.f14828h;
    }

    /* renamed from: k */
    public final Bundle m18789k() {
        return this.f14827g;
    }

    /* renamed from: l */
    public final int m18790l() {
        return this.f14832l;
    }

    /* renamed from: m */
    public final Bundle m18791m() {
        return this.f14834n;
    }

    /* renamed from: n */
    public final Set<String> m18792n() {
        return this.f14835o;
    }

    /* renamed from: o */
    public final boolean m18793o() {
        return this.f14836p;
    }
}
