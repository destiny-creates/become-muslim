package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@cm
public final class aue extends auk {
    /* renamed from: c */
    private bdk f28380c;
    /* renamed from: d */
    private bdo f28381d;
    /* renamed from: e */
    private bdr f28382e;
    /* renamed from: f */
    private final auh f28383f;
    /* renamed from: g */
    private auf f28384g;
    /* renamed from: h */
    private boolean f28385h;
    /* renamed from: i */
    private Object f28386i;

    private aue(Context context, auh auh, ahi ahi, aui aui) {
        super(context, auh, null, ahi, null, aui, null, null);
        this.f28385h = false;
        this.f28386i = new Object();
        this.f28383f = auh;
    }

    public aue(Context context, auh auh, ahi ahi, bdk bdk, aui aui) {
        this(context, auh, ahi, aui);
        this.f28380c = bdk;
    }

    public aue(Context context, auh auh, ahi ahi, bdo bdo, aui aui) {
        this(context, auh, ahi, aui);
        this.f28381d = bdo;
    }

    public aue(Context context, auh auh, ahi ahi, bdr bdr, aui aui) {
        this(context, auh, ahi, aui);
        this.f28382e = bdr;
    }

    /* renamed from: b */
    private static HashMap<String, View> m37123b(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public final View mo3969a(OnClickListener onClickListener, boolean z) {
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                View a = this.f28384g.mo3969a(onClickListener, z);
                return a;
            }
            C2758b l;
            try {
                if (this.f28382e != null) {
                    l = this.f28382e.mo4199l();
                } else if (this.f28380c != null) {
                    l = this.f28380c.mo4162n();
                } else {
                    if (this.f28381d != null) {
                        l = this.f28381d.mo4180k();
                    }
                    l = null;
                }
            } catch (Throwable e) {
                mt.m19921c("Failed to call getAdChoicesContent", e);
            }
            if (l != null) {
                a = (View) C4757d.a(l);
                return a;
            }
            return null;
        }
    }

    /* renamed from: a */
    public final void mo3971a(View view) {
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                this.f28384g.mo3971a(view);
            }
        }
    }

    /* renamed from: a */
    public final void mo3974a(View view, Map<String, WeakReference<View>> map) {
        C2872v.b("recordImpression must be called on the main UI thread.");
        synchronized (this.f28386i) {
            this.f23797a = true;
            if (this.f28384g != null) {
                this.f28384g.mo3974a(view, (Map) map);
                this.f28383f.ab();
            } else {
                try {
                    auh auh;
                    if (this.f28382e != null && !this.f28382e.mo4203p()) {
                        this.f28382e.mo4205r();
                        auh = this.f28383f;
                    } else if (this.f28380c != null && !this.f28380c.mo4158j()) {
                        this.f28380c.mo4157i();
                        auh = this.f28383f;
                    } else if (!(this.f28381d == null || this.f28381d.mo4177h())) {
                        this.f28381d.mo4176g();
                        auh = this.f28383f;
                    }
                    auh.ab();
                } catch (Throwable e) {
                    mt.m19921c("Failed to call recordImpression", e);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo3975a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        C2872v.b("performClick must be called on the main UI thread.");
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                this.f28384g.mo3975a(view, map, bundle, view2);
                this.f28383f.onAdClicked();
            } else {
                try {
                    auh auh;
                    if (this.f28382e != null && !this.f28382e.mo4204q()) {
                        this.f28382e.mo4186a(C4757d.a(view));
                        auh = this.f28383f;
                    } else if (this.f28380c != null && !this.f28380c.mo4159k()) {
                        this.f28380c.mo4146a(C4757d.a(view));
                        auh = this.f28383f;
                    } else if (!(this.f28381d == null || this.f28381d.mo4178i())) {
                        this.f28381d.mo4167a(C4757d.a(view));
                        auh = this.f28383f;
                    }
                    auh.onAdClicked();
                } catch (Throwable e) {
                    mt.m19921c("Failed to call performClick", e);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo6089a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.f28386i) {
            this.f28385h = true;
            HashMap b = m37123b(map);
            HashMap b2 = m37123b(map2);
            try {
                if (this.f28382e != null) {
                    this.f28382e.mo4187a(C4757d.a(view), C4757d.a(b), C4757d.a(b2));
                } else if (this.f28380c != null) {
                    this.f28380c.mo4147a(C4757d.a(view), C4757d.a(b), C4757d.a(b2));
                    this.f28380c.mo4149b(C4757d.a(view));
                } else if (this.f28381d != null) {
                    this.f28381d.mo4168a(C4757d.a(view), C4757d.a(b), C4757d.a(b2));
                    this.f28381d.mo4170b(C4757d.a(view));
                }
            } catch (Throwable e) {
                mt.m19921c("Failed to call prepareAd", e);
            }
            this.f28385h = false;
        }
    }

    /* renamed from: a */
    public final void m37129a(auf auf) {
        synchronized (this.f28386i) {
            this.f28384g = auf;
        }
    }

    /* renamed from: a */
    public final void mo3976a(awx awx) {
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                this.f28384g.mo3976a(awx);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo3977a() {
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                boolean a = this.f28384g.mo3977a();
                return a;
            }
            a = this.f28383f.m18971R();
            return a;
        }
    }

    /* renamed from: b */
    public final void mo3981b(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f28386i) {
            try {
                if (this.f28382e != null) {
                    this.f28382e.mo4189b(C4757d.a(view));
                } else if (this.f28380c != null) {
                    this.f28380c.mo4151c(C4757d.a(view));
                } else if (this.f28381d != null) {
                    this.f28381d.mo4172c(C4757d.a(view));
                }
            } catch (Throwable e) {
                mt.m19921c("Failed to call untrackView", e);
            }
        }
    }

    /* renamed from: b */
    public final boolean mo3982b() {
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                boolean b = this.f28384g.mo3982b();
                return b;
            }
            b = this.f28383f.m18972S();
            return b;
        }
    }

    /* renamed from: c */
    public final void mo3983c() {
        synchronized (this.f28386i) {
            if (this.f28384g != null) {
                this.f28384g.mo3983c();
            }
        }
    }

    /* renamed from: d */
    public final void mo3987d() {
        C2872v.b("recordDownloadedImpression must be called on main UI thread.");
        synchronized (this.f28386i) {
            this.b = true;
            if (this.f28384g != null) {
                this.f28384g.mo3987d();
            }
        }
    }

    /* renamed from: e */
    public final boolean m37136e() {
        boolean z;
        synchronized (this.f28386i) {
            z = this.f28385h;
        }
        return z;
    }

    /* renamed from: f */
    public final auf m37137f() {
        auf auf;
        synchronized (this.f28386i) {
            auf = this.f28384g;
        }
        return auf;
    }

    /* renamed from: g */
    public final qo mo6090g() {
        return null;
    }

    /* renamed from: h */
    public final void mo3988h() {
    }

    /* renamed from: i */
    public final void mo3989i() {
    }

    /* renamed from: j */
    public final void mo3990j() {
        if (this.f28384g != null) {
            this.f28384g.mo3990j();
        }
    }

    /* renamed from: k */
    public final void mo3991k() {
        if (this.f28384g != null) {
            this.f28384g.mo3991k();
        }
    }
}
