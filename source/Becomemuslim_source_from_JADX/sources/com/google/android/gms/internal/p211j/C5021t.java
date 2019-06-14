package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.api.internal.C2804h;
import com.google.android.gms.common.api.internal.C2804h.C2802a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.location.C5080k;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.ap;
import com.google.android.gms.location.as;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.j.t */
public final class C5021t {
    /* renamed from: a */
    private final al<C5019p> f16851a;
    /* renamed from: b */
    private final Context f16852b;
    /* renamed from: c */
    private ContentProviderClient f16853c = null;
    /* renamed from: d */
    private boolean f16854d = false;
    /* renamed from: e */
    private final Map<C2802a<C5081l>, C7824y> f16855e = new HashMap();
    /* renamed from: f */
    private final Map<C2802a<Object>, C7823x> f16856f = new HashMap();
    /* renamed from: g */
    private final Map<C2802a<C5080k>, C7822u> f16857g = new HashMap();

    public C5021t(Context context, al<C5019p> alVar) {
        this.f16852b = context;
        this.f16851a = alVar;
    }

    /* renamed from: a */
    private final C7824y m21112a(C2804h<C5081l> c2804h) {
        C7824y c7824y;
        synchronized (this.f16855e) {
            c7824y = (C7824y) this.f16855e.get(c2804h.b());
            if (c7824y == null) {
                c7824y = new C7824y(c2804h);
            }
            this.f16855e.put(c2804h.b(), c7824y);
        }
        return c7824y;
    }

    /* renamed from: a */
    public final Location m21113a() {
        this.f16851a.mo4628b();
        return ((C5019p) this.f16851a.mo4627a()).mo4641a(this.f16852b.getPackageName());
    }

    /* renamed from: a */
    public final void m21114a(PendingIntent pendingIntent, C5017k c5017k) {
        this.f16851a.mo4628b();
        ((C5019p) this.f16851a.mo4627a()).mo4643a(new ah(2, null, null, pendingIntent, null, c5017k != null ? c5017k.asBinder() : null));
    }

    /* renamed from: a */
    public final void m21115a(C2802a<C5081l> c2802a, C5017k c5017k) {
        this.f16851a.mo4628b();
        C2872v.a(c2802a, "Invalid null listener key");
        synchronized (this.f16855e) {
            as asVar = (C7824y) this.f16855e.remove(c2802a);
            if (asVar != null) {
                asVar.m38029a();
                ((C5019p) this.f16851a.mo4627a()).mo4643a(ah.m38022a(asVar, c5017k));
            }
        }
    }

    /* renamed from: a */
    public final void m21116a(LocationRequest locationRequest, PendingIntent pendingIntent, C5017k c5017k) {
        this.f16851a.mo4628b();
        ((C5019p) this.f16851a.mo4627a()).mo4643a(new ah(1, af.m38020a(locationRequest), null, pendingIntent, null, c5017k != null ? c5017k.asBinder() : null));
    }

    /* renamed from: a */
    public final void m21117a(LocationRequest locationRequest, C2804h<C5081l> c2804h, C5017k c5017k) {
        this.f16851a.mo4628b();
        ((C5019p) this.f16851a.mo4627a()).mo4643a(new ah(1, af.m38020a(locationRequest), m21112a((C2804h) c2804h).asBinder(), null, null, c5017k != null ? c5017k.asBinder() : null));
    }

    /* renamed from: a */
    public final void m21118a(boolean z) {
        this.f16851a.mo4628b();
        ((C5019p) this.f16851a.mo4627a()).mo4648a(z);
        this.f16854d = z;
    }

    /* renamed from: b */
    public final void m21119b() {
        synchronized (this.f16855e) {
            for (as asVar : this.f16855e.values()) {
                if (asVar != null) {
                    ((C5019p) this.f16851a.mo4627a()).mo4643a(ah.m38022a(asVar, null));
                }
            }
            this.f16855e.clear();
        }
        synchronized (this.f16857g) {
            for (ap apVar : this.f16857g.values()) {
                if (apVar != null) {
                    ((C5019p) this.f16851a.mo4627a()).mo4643a(ah.m38021a(apVar, null));
                }
            }
            this.f16857g.clear();
        }
        synchronized (this.f16856f) {
            for (C7823x c7823x : this.f16856f.values()) {
                if (c7823x != null) {
                    ((C5019p) this.f16851a.mo4627a()).mo4644a(new ay(2, null, c7823x.asBinder(), null));
                }
            }
            this.f16856f.clear();
        }
    }

    /* renamed from: c */
    public final void m21120c() {
        if (this.f16854d) {
            m21118a(false);
        }
    }
}
