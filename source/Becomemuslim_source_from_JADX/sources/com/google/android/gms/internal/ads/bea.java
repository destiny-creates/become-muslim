package com.google.android.gms.internal.ads;

import android.location.Location;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.C2679l;
import com.google.android.gms.ads.mediation.C4301i;
import com.google.android.gms.ads.p168b.C2611d;
import com.google.android.gms.ads.p168b.C2611d.C2610a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@cm
public final class bea implements C4301i {
    /* renamed from: a */
    private final Date f28484a;
    /* renamed from: b */
    private final int f28485b;
    /* renamed from: c */
    private final Set<String> f28486c;
    /* renamed from: d */
    private final boolean f28487d;
    /* renamed from: e */
    private final Location f28488e;
    /* renamed from: f */
    private final int f28489f;
    /* renamed from: g */
    private final aus f28490g;
    /* renamed from: h */
    private final List<String> f28491h = new ArrayList();
    /* renamed from: i */
    private final boolean f28492i;
    /* renamed from: j */
    private final Map<String, Boolean> f28493j = new HashMap();

    public bea(Date date, int i, Set<String> set, Location location, boolean z, int i2, aus aus, List<String> list, boolean z2) {
        this.f28484a = date;
        this.f28485b = i;
        this.f28486c = set;
        this.f28488e = location;
        this.f28487d = z;
        this.f28489f = i2;
        this.f28490g = aus;
        this.f28492i = z2;
        String str = "custom:";
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith(str)) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        Map map;
                        Object obj;
                        Object valueOf;
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(split[2])) {
                            map = this.f28493j;
                            obj = split[1];
                            valueOf = Boolean.valueOf(true);
                        } else if ("false".equals(split[2])) {
                            map = this.f28493j;
                            obj = split[1];
                            valueOf = Boolean.valueOf(false);
                        }
                        map.put(obj, valueOf);
                    }
                } else {
                    this.f28491h.add(str2);
                }
            }
        }
    }

    /* renamed from: a */
    public final Date m37368a() {
        return this.f28484a;
    }

    /* renamed from: b */
    public final int m37369b() {
        return this.f28485b;
    }

    /* renamed from: c */
    public final Set<String> m37370c() {
        return this.f28486c;
    }

    /* renamed from: d */
    public final Location m37371d() {
        return this.f28488e;
    }

    /* renamed from: e */
    public final int m37372e() {
        return this.f28489f;
    }

    /* renamed from: f */
    public final boolean m37373f() {
        return this.f28487d;
    }

    /* renamed from: g */
    public final boolean m37374g() {
        return this.f28492i;
    }

    /* renamed from: h */
    public final C2611d m37375h() {
        if (this.f28490g == null) {
            return null;
        }
        C2610a b = new C2610a().a(this.f28490g.f28388b).a(this.f28490g.f28389c).b(this.f28490g.f28390d);
        if (this.f28490g.f28387a >= 2) {
            b.b(this.f28490g.f28391e);
        }
        if (this.f28490g.f28387a >= 3 && this.f28490g.f28392f != null) {
            b.a(new C2679l(this.f28490g.f28392f));
        }
        return b.a();
    }

    /* renamed from: i */
    public final boolean m37376i() {
        return this.f28491h != null && (this.f28491h.contains("2") || this.f28491h.contains("6"));
    }

    /* renamed from: j */
    public final boolean m37377j() {
        return this.f28491h != null && this.f28491h.contains("6");
    }

    /* renamed from: k */
    public final boolean m37378k() {
        return this.f28491h != null && (this.f28491h.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || this.f28491h.contains("6"));
    }

    /* renamed from: l */
    public final boolean m37379l() {
        return this.f28491h != null && this.f28491h.contains("3");
    }

    /* renamed from: m */
    public final Map<String, Boolean> m37380m() {
        return this.f28493j;
    }
}
