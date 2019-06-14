package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

@cm
public final class aor {
    /* renamed from: a */
    private long f14778a;
    /* renamed from: b */
    private Bundle f14779b;
    /* renamed from: c */
    private int f14780c;
    /* renamed from: d */
    private List<String> f14781d;
    /* renamed from: e */
    private boolean f14782e;
    /* renamed from: f */
    private int f14783f;
    /* renamed from: g */
    private boolean f14784g;
    /* renamed from: h */
    private String f14785h;
    /* renamed from: i */
    private aru f14786i;
    /* renamed from: j */
    private Location f14787j;
    /* renamed from: k */
    private String f14788k;
    /* renamed from: l */
    private Bundle f14789l;
    /* renamed from: m */
    private Bundle f14790m;
    /* renamed from: n */
    private List<String> f14791n;
    /* renamed from: o */
    private String f14792o;
    /* renamed from: p */
    private String f14793p;
    /* renamed from: q */
    private boolean f14794q;

    public aor() {
        this.f14778a = -1;
        this.f14779b = new Bundle();
        this.f14780c = -1;
        this.f14781d = new ArrayList();
        this.f14782e = false;
        this.f14783f = -1;
        this.f14784g = false;
        this.f14785h = null;
        this.f14786i = null;
        this.f14787j = null;
        this.f14788k = null;
        this.f14789l = new Bundle();
        this.f14790m = new Bundle();
        this.f14791n = new ArrayList();
        this.f14792o = null;
        this.f14793p = null;
        this.f14794q = false;
    }

    public aor(aoq aoq) {
        this.f14778a = aoq.f28262b;
        this.f14779b = aoq.f28263c;
        this.f14780c = aoq.f28264d;
        this.f14781d = aoq.f28265e;
        this.f14782e = aoq.f28266f;
        this.f14783f = aoq.f28267g;
        this.f14784g = aoq.f28268h;
        this.f14785h = aoq.f28269i;
        this.f14786i = aoq.f28270j;
        this.f14787j = aoq.f28271k;
        this.f14788k = aoq.f28272l;
        this.f14789l = aoq.f28273m;
        this.f14790m = aoq.f28274n;
        this.f14791n = aoq.f28275o;
        this.f14792o = aoq.f28276p;
        this.f14793p = aoq.f28277q;
    }

    /* renamed from: a */
    public final aoq m18658a() {
        return new aoq(7, this.f14778a, this.f14779b, this.f14780c, this.f14781d, this.f14782e, this.f14783f, this.f14784g, this.f14785h, this.f14786i, this.f14787j, this.f14788k, this.f14789l, this.f14790m, this.f14791n, this.f14792o, this.f14793p, false);
    }

    /* renamed from: a */
    public final aor m18659a(Location location) {
        this.f14787j = null;
        return this;
    }
}
