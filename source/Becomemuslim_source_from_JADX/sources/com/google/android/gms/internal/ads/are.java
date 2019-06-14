package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.C2683b;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class are {
    /* renamed from: a */
    private final HashSet<String> f14837a = new HashSet();
    /* renamed from: b */
    private final Bundle f14838b = new Bundle();
    /* renamed from: c */
    private final HashMap<Class<? extends Object>, Object> f14839c = new HashMap();
    /* renamed from: d */
    private final HashSet<String> f14840d = new HashSet();
    /* renamed from: e */
    private final Bundle f14841e = new Bundle();
    /* renamed from: f */
    private final HashSet<String> f14842f = new HashSet();
    /* renamed from: g */
    private Date f14843g;
    /* renamed from: h */
    private String f14844h;
    /* renamed from: i */
    private int f14845i = -1;
    /* renamed from: j */
    private Location f14846j;
    /* renamed from: k */
    private boolean f14847k = false;
    /* renamed from: l */
    private String f14848l;
    /* renamed from: m */
    private String f14849m;
    /* renamed from: n */
    private int f14850n = -1;
    /* renamed from: o */
    private boolean f14851o;

    /* renamed from: a */
    public final void m18809a(int i) {
        this.f14845i = i;
    }

    /* renamed from: a */
    public final void m18810a(Location location) {
        this.f14846j = location;
    }

    /* renamed from: a */
    public final void m18811a(Class<? extends C2683b> cls, Bundle bundle) {
        this.f14838b.putBundle(cls.getName(), bundle);
    }

    /* renamed from: a */
    public final void m18812a(String str) {
        this.f14837a.add(str);
    }

    /* renamed from: a */
    public final void m18813a(Date date) {
        this.f14843g = date;
    }

    /* renamed from: a */
    public final void m18814a(boolean z) {
        this.f14850n = z;
    }

    /* renamed from: b */
    public final void m18815b(String str) {
        this.f14840d.add(str);
    }

    /* renamed from: b */
    public final void m18816b(boolean z) {
        this.f14851o = z;
    }

    /* renamed from: c */
    public final void m18817c(String str) {
        this.f14840d.remove(str);
    }
}
