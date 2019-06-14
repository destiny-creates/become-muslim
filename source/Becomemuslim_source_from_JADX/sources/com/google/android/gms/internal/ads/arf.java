package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.C2633g;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.C2679l;
import com.google.android.gms.ads.p167a.C2595a;
import com.google.android.gms.ads.p167a.C2597c;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.concurrent.atomic.AtomicBoolean;

@cm
public final class arf {
    /* renamed from: a */
    private final bcx f14852a;
    /* renamed from: b */
    private final aot f14853b;
    /* renamed from: c */
    private final AtomicBoolean f14854c;
    /* renamed from: d */
    private final C2678k f14855d;
    /* renamed from: e */
    private final apj f14856e;
    /* renamed from: f */
    private aok f14857f;
    /* renamed from: g */
    private C2603a f14858g;
    /* renamed from: h */
    private C2631d[] f14859h;
    /* renamed from: i */
    private C2595a f14860i;
    /* renamed from: j */
    private C2633g f14861j;
    /* renamed from: k */
    private apy f14862k;
    /* renamed from: l */
    private C2597c f14863l;
    /* renamed from: m */
    private C2679l f14864m;
    /* renamed from: n */
    private String f14865n;
    /* renamed from: o */
    private ViewGroup f14866o;
    /* renamed from: p */
    private int f14867p;
    /* renamed from: q */
    private boolean f14868q;

    public arf(ViewGroup viewGroup) {
        this(viewGroup, null, false, aot.f14795a, 0);
    }

    public arf(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, aot.f14795a, i);
    }

    private arf(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, aot aot, int i) {
        this(viewGroup, attributeSet, z, aot, null, i);
    }

    private arf(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, aot aot, apy apy, int i) {
        this.f14852a = new bcx();
        this.f14855d = new C2678k();
        this.f14856e = new arg(this);
        this.f14866o = viewGroup;
        this.f14853b = aot;
        this.f14862k = null;
        this.f14854c = new AtomicBoolean(false);
        this.f14867p = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                aox aox = new aox(context, attributeSet);
                this.f14859h = aox.m18663a(z);
                this.f14865n = aox.m18662a();
                if (viewGroup.isInEditMode()) {
                    mi a = aph.m18683a();
                    C2631d c2631d = this.f14859h[0];
                    int i2 = this.f14867p;
                    aou aou = new aou(context, c2631d);
                    aou.f28288j = m18820a(i2);
                    a.m19888a(viewGroup, aou, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                aph.m18683a().m19889a(viewGroup, new aou(context, C2631d.f6669a), e.getMessage(), e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private static aou m18819a(Context context, C2631d[] c2631dArr, int i) {
        aou aou = new aou(context, c2631dArr);
        aou.f28288j = m18820a(i);
        return aou;
    }

    /* renamed from: a */
    private static boolean m18820a(int i) {
        return i == 1;
    }

    /* renamed from: a */
    public final void m18821a() {
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3902i();
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18822a(C2595a c2595a) {
        try {
            this.f14860i = c2595a;
            if (this.f14862k != null) {
                this.f14862k.mo3891a(c2595a != null ? new aow(c2595a) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18823a(C2597c c2597c) {
        this.f14863l = c2597c;
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3895a(c2597c != null ? new atm(c2597c) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18824a(C2603a c2603a) {
        this.f14858g = c2603a;
        this.f14856e.m30073a(c2603a);
    }

    /* renamed from: a */
    public final void m18825a(C2633g c2633g) {
        this.f14861j = c2633g;
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3892a(this.f14861j == null ? null : this.f14861j.a());
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18826a(C2679l c2679l) {
        this.f14864m = c2679l;
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3894a(c2679l == null ? null : new ary(c2679l));
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18827a(aok aok) {
        try {
            this.f14857f = aok;
            if (this.f14862k != null) {
                this.f14862k.mo3888a(aok != null ? new aol(aok) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18828a(ard ard) {
        try {
            if (this.f14862k == null) {
                if ((this.f14859h == null || this.f14865n == null) && this.f14862k == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Object a;
                Context context = this.f14866o.getContext();
                aou a2 = m18819a(context, this.f14859h, this.f14867p);
                if ("search_v2".equals(a2.f28279a)) {
                    a = aoy.m18670a(context, false, new apa(aph.m18684b(), context, a2, this.f14865n));
                } else {
                    a = aoy.m18670a(context, false, new aoz(aph.m18684b(), context, a2, this.f14865n, this.f14852a));
                }
                this.f14862k = (apy) a;
                this.f14862k.mo3889a(new aom(this.f14856e));
                if (this.f14857f != null) {
                    this.f14862k.mo3888a(new aol(this.f14857f));
                }
                if (this.f14860i != null) {
                    this.f14862k.mo3891a(new aow(this.f14860i));
                }
                if (this.f14863l != null) {
                    this.f14862k.mo3895a(new atm(this.f14863l));
                }
                if (this.f14861j != null) {
                    this.f14862k.mo3892a(this.f14861j.a());
                }
                if (this.f14864m != null) {
                    this.f14862k.mo3894a(new ary(this.f14864m));
                }
                this.f14862k.mo3899b(this.f14868q);
                try {
                    C2758b j = this.f14862k.mo3903j();
                    if (j != null) {
                        this.f14866o.addView((View) C4757d.a(j));
                    }
                } catch (Throwable e) {
                    mt.m19923d("#007 Could not call remote method.", e);
                }
            }
            if (this.f14862k.mo3900b(aot.m18660a(this.f14866o.getContext(), ard))) {
                this.f14852a.m37284a(ard.m18788j());
            }
        } catch (Throwable e2) {
            mt.m19923d("#007 Could not call remote method.", e2);
        }
    }

    /* renamed from: a */
    public final void m18829a(String str) {
        if (this.f14865n == null) {
            this.f14865n = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    /* renamed from: a */
    public final void m18830a(boolean z) {
        this.f14868q = z;
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3899b(this.f14868q);
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m18831a(C2631d... c2631dArr) {
        if (this.f14859h == null) {
            m18833b(c2631dArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    /* renamed from: b */
    public final C2603a m18832b() {
        return this.f14858g;
    }

    /* renamed from: b */
    public final void m18833b(C2631d... c2631dArr) {
        this.f14859h = c2631dArr;
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3887a(m18819a(this.f14866o.getContext(), this.f14859h, this.f14867p));
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
        this.f14866o.requestLayout();
    }

    /* renamed from: c */
    public final C2631d m18834c() {
        try {
            if (this.f14862k != null) {
                aou k = this.f14862k.mo3904k();
                if (k != null) {
                    return k.m36928b();
                }
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
        return this.f14859h != null ? this.f14859h[0] : null;
    }

    /* renamed from: d */
    public final C2631d[] m18835d() {
        return this.f14859h;
    }

    /* renamed from: e */
    public final String m18836e() {
        if (this.f14865n == null && this.f14862k != null) {
            try {
                this.f14865n = this.f14862k.mo3881C();
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
        return this.f14865n;
    }

    /* renamed from: f */
    public final C2595a m18837f() {
        return this.f14860i;
    }

    /* renamed from: g */
    public final C2597c m18838g() {
        return this.f14863l;
    }

    /* renamed from: h */
    public final void m18839h() {
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3907n();
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: i */
    public final void m18840i() {
        try {
            if (this.f14862k != null) {
                this.f14862k.mo3908o();
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: j */
    public final String m18841j() {
        try {
            if (this.f14862k != null) {
                return this.f14862k.w_();
            }
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
        return null;
    }

    /* renamed from: k */
    public final C2678k m18842k() {
        return this.f14855d;
    }

    /* renamed from: l */
    public final aqv m18843l() {
        if (this.f14862k == null) {
            return null;
        }
        try {
            return this.f14862k.mo3912s();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
            return null;
        }
    }

    /* renamed from: m */
    public final C2679l m18844m() {
        return this.f14864m;
    }
}
