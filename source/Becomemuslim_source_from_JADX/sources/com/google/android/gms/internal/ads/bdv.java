package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.C2681a;
import java.util.Date;
import java.util.Set;

@cm
public final class bdv implements C2681a {
    /* renamed from: a */
    private final Date f23949a;
    /* renamed from: b */
    private final int f23950b;
    /* renamed from: c */
    private final Set<String> f23951c;
    /* renamed from: d */
    private final boolean f23952d;
    /* renamed from: e */
    private final Location f23953e;
    /* renamed from: f */
    private final int f23954f;
    /* renamed from: g */
    private final boolean f23955g;

    public bdv(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.f23949a = date;
        this.f23950b = i;
        this.f23951c = set;
        this.f23953e = location;
        this.f23952d = z;
        this.f23954f = i2;
        this.f23955g = z2;
    }

    /* renamed from: a */
    public final Date m30580a() {
        return this.f23949a;
    }

    /* renamed from: b */
    public final int m30581b() {
        return this.f23950b;
    }

    /* renamed from: c */
    public final Set<String> m30582c() {
        return this.f23951c;
    }

    /* renamed from: d */
    public final Location m30583d() {
        return this.f23953e;
    }

    /* renamed from: e */
    public final int m30584e() {
        return this.f23954f;
    }

    /* renamed from: f */
    public final boolean m30585f() {
        return this.f23952d;
    }

    /* renamed from: g */
    public final boolean m30586g() {
        return this.f23955g;
    }
}
