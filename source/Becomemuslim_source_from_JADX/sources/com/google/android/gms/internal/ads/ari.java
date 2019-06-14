package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2633g;
import com.google.android.gms.ads.p167a.C2595a;
import com.google.android.gms.ads.p167a.C2597c;
import com.google.android.gms.ads.p167a.C2601f;
import com.google.android.gms.ads.reward.C2699c;
import com.google.android.gms.ads.reward.C2700d;

@cm
public final class ari {
    /* renamed from: a */
    private final bcx f14869a;
    /* renamed from: b */
    private final Context f14870b;
    /* renamed from: c */
    private final aot f14871c;
    /* renamed from: d */
    private C2603a f14872d;
    /* renamed from: e */
    private aok f14873e;
    /* renamed from: f */
    private apy f14874f;
    /* renamed from: g */
    private String f14875g;
    /* renamed from: h */
    private C2700d f14876h;
    /* renamed from: i */
    private C2595a f14877i;
    /* renamed from: j */
    private C2597c f14878j;
    /* renamed from: k */
    private C2633g f14879k;
    /* renamed from: l */
    private C2699c f14880l;
    /* renamed from: m */
    private boolean f14881m;
    /* renamed from: n */
    private boolean f14882n;

    public ari(Context context) {
        this(context, aot.f14795a, null);
    }

    private ari(Context context, aot aot, C2601f c2601f) {
        this.f14869a = new bcx();
        this.f14870b = context;
        this.f14871c = aot;
    }

    /* renamed from: b */
    private final void m18846b(String str) {
        if (this.f14874f == null) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 63);
            stringBuilder.append("The ad unit ID must be set on InterstitialAd before ");
            stringBuilder.append(str);
            stringBuilder.append(" is called.");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public final void m18847a(C2603a c2603a) {
        try {
            this.f14872d = c2603a;
            if (this.f14874f != null) {
                this.f14874f.mo3889a(c2603a != null ? new aom(c2603a) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void m18848a(C2699c c2699c) {
        try {
            this.f14880l = c2699c;
            if (this.f14874f != null) {
                this.f14874f.mo3896a(c2699c != null ? new gs(c2699c) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void m18849a(C2700d c2700d) {
        try {
            this.f14876h = c2700d;
            if (this.f14874f != null) {
                this.f14874f.mo3890a(c2700d != null ? new aop(c2700d) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void m18850a(aok aok) {
        try {
            this.f14873e = aok;
            if (this.f14874f != null) {
                this.f14874f.mo3888a(aok != null ? new aol(aok) : null);
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void m18851a(ard ard) {
        try {
            if (this.f14874f == null) {
                String str = "loadAd";
                if (this.f14875g == null) {
                    m18846b(str);
                }
                aou a = this.f14881m ? aou.m36924a() : new aou();
                aoy b = aph.m18684b();
                Context context = this.f14870b;
                this.f14874f = (apy) aoy.m18670a(context, false, new apb(b, context, a, this.f14875g, this.f14869a));
                if (this.f14872d != null) {
                    this.f14874f.mo3889a(new aom(this.f14872d));
                }
                if (this.f14873e != null) {
                    this.f14874f.mo3888a(new aol(this.f14873e));
                }
                if (this.f14876h != null) {
                    this.f14874f.mo3890a(new aop(this.f14876h));
                }
                if (this.f14877i != null) {
                    this.f14874f.mo3891a(new aow(this.f14877i));
                }
                if (this.f14878j != null) {
                    this.f14874f.mo3895a(new atm(this.f14878j));
                }
                if (this.f14879k != null) {
                    this.f14874f.mo3892a(this.f14879k.a());
                }
                if (this.f14880l != null) {
                    this.f14874f.mo3896a(new gs(this.f14880l));
                }
                this.f14874f.mo3901c(this.f14882n);
            }
            if (this.f14874f.mo3900b(aot.m18660a(this.f14870b, ard))) {
                this.f14869a.m37284a(ard.m18788j());
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void m18852a(String str) {
        if (this.f14875g == null) {
            this.f14875g = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    /* renamed from: a */
    public final void m18853a(boolean z) {
        this.f14881m = true;
    }

    /* renamed from: a */
    public final boolean m18854a() {
        try {
            return this.f14874f == null ? false : this.f14874f.mo3905l();
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    /* renamed from: b */
    public final void m18855b(boolean z) {
        try {
            this.f14882n = z;
            if (this.f14874f != null) {
                this.f14874f.mo3901c(z);
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: b */
    public final boolean m18856b() {
        try {
            return this.f14874f == null ? false : this.f14874f.mo3911r();
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    /* renamed from: c */
    public final Bundle m18857c() {
        try {
            if (this.f14874f != null) {
                return this.f14874f.mo3909p();
            }
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    /* renamed from: d */
    public final void m18858d() {
        try {
            m18846b("show");
            this.f14874f.mo3884H();
        } catch (Throwable e) {
            mt.m19923d("#008 Must be called on the main UI thread.", e);
        }
    }
}
