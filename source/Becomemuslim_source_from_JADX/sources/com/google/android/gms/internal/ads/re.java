package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.C2896f;
import java.util.HashMap;
import java.util.Map;

@cm
public final class re extends aqw {
    /* renamed from: a */
    private final pn f28739a;
    /* renamed from: b */
    private final Object f28740b = new Object();
    /* renamed from: c */
    private final boolean f28741c;
    /* renamed from: d */
    private final boolean f28742d;
    /* renamed from: e */
    private final float f28743e;
    /* renamed from: f */
    private int f28744f;
    /* renamed from: g */
    private aqy f28745g;
    /* renamed from: h */
    private boolean f28746h;
    /* renamed from: i */
    private boolean f28747i = true;
    /* renamed from: j */
    private float f28748j;
    /* renamed from: k */
    private float f28749k;
    /* renamed from: l */
    private boolean f28750l = true;
    /* renamed from: m */
    private boolean f28751m;
    /* renamed from: n */
    private boolean f28752n;

    public re(pn pnVar, float f, boolean z, boolean z2) {
        this.f28739a = pnVar;
        this.f28743e = f;
        this.f28741c = z;
        this.f28742d = z2;
    }

    /* renamed from: a */
    private final void m37633a(String str, Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        nu.f15846a.execute(new rf(this, hashMap));
    }

    /* renamed from: a */
    public final void mo3937a() {
        m37633a("play", null);
    }

    /* renamed from: a */
    public final void m37635a(float f, int i, boolean z, float f2) {
        boolean z2;
        int i2;
        synchronized (this.f28740b) {
            this.f28748j = f;
            z2 = this.f28747i;
            this.f28747i = z;
            i2 = this.f28744f;
            this.f28744f = i;
            f = this.f28749k;
            this.f28749k = f2;
            if (Math.abs(this.f28749k - f) > 1.0E-4f) {
                this.f28739a.getView().invalidate();
            }
        }
        nu.f15846a.execute(new rg(this, i2, i, z2, z));
    }

    /* renamed from: a */
    final /* synthetic */ void m37636a(int i, int i2, boolean z, boolean z2) {
        synchronized (this.f28740b) {
            boolean z3 = false;
            Object obj = i != i2 ? 1 : null;
            Object obj2 = (this.f28746h || i2 != 1) ? null : 1;
            Object obj3 = (obj == null || i2 != 1) ? null : 1;
            Object obj4 = (obj == null || i2 != 2) ? null : 1;
            obj = (obj == null || i2 != 3) ? null : 1;
            Object obj5 = z != z2 ? 1 : null;
            if (this.f28746h || obj2 != null) {
                z3 = true;
            }
            this.f28746h = z3;
            if (this.f28745g == null) {
                return;
            }
            if (obj2 != null) {
                try {
                    this.f28745g.mo3949a();
                } catch (Throwable e) {
                    mt.m19921c("Unable to call onVideoStart()", e);
                }
            }
            if (obj3 != null) {
                try {
                    this.f28745g.mo3951b();
                } catch (Throwable e2) {
                    mt.m19921c("Unable to call onVideoPlay()", e2);
                }
            }
            if (obj4 != null) {
                try {
                    this.f28745g.mo3952c();
                } catch (Throwable e22) {
                    mt.m19921c("Unable to call onVideoPause()", e22);
                }
            }
            if (obj != null) {
                try {
                    this.f28745g.mo3953d();
                } catch (Throwable e3) {
                    mt.m19921c("Unable to call onVideoEnd()", e3);
                }
            }
            if (obj5 != null) {
                try {
                    this.f28745g.mo3950a(z2);
                } catch (Throwable e32) {
                    mt.m19921c("Unable to call onVideoMute()", e32);
                }
            }
        }
        return;
    }

    /* renamed from: a */
    public final void mo3938a(aqy aqy) {
        synchronized (this.f28740b) {
            this.f28745g = aqy;
        }
    }

    /* renamed from: a */
    public final void m37638a(ary ary) {
        synchronized (this.f28740b) {
            this.f28750l = ary.f28302a;
            this.f28751m = ary.f28303b;
            this.f28752n = ary.f28304c;
        }
        m37633a("initialState", C2896f.a("muteStart", ary.f28302a ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO, "customControlsRequested", ary.f28303b ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO, "clickToExpandRequested", ary.f28304c ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    /* renamed from: a */
    final /* synthetic */ void m37639a(Map map) {
        this.f28739a.mo6650a("pubVideoCmd", map);
    }

    /* renamed from: a */
    public final void mo3939a(boolean z) {
        m37633a(z ? "mute" : "unmute", null);
    }

    /* renamed from: b */
    public final void mo3940b() {
        m37633a("pause", null);
    }

    /* renamed from: c */
    public final boolean mo3941c() {
        boolean z;
        synchronized (this.f28740b) {
            z = this.f28747i;
        }
        return z;
    }

    /* renamed from: d */
    public final int mo3942d() {
        int i;
        synchronized (this.f28740b) {
            i = this.f28744f;
        }
        return i;
    }

    /* renamed from: e */
    public final float mo3943e() {
        float f;
        synchronized (this.f28740b) {
            f = this.f28749k;
        }
        return f;
    }

    /* renamed from: f */
    public final float mo3944f() {
        return this.f28743e;
    }

    /* renamed from: g */
    public final float mo3945g() {
        float f;
        synchronized (this.f28740b) {
            f = this.f28748j;
        }
        return f;
    }

    /* renamed from: h */
    public final aqy mo3946h() {
        aqy aqy;
        synchronized (this.f28740b) {
            aqy = this.f28745g;
        }
        return aqy;
    }

    /* renamed from: i */
    public final boolean mo3947i() {
        boolean z;
        synchronized (this.f28740b) {
            z = this.f28741c && this.f28751m;
        }
        return z;
    }

    /* renamed from: j */
    public final boolean mo3948j() {
        boolean i = mo3947i();
        synchronized (this.f28740b) {
            if (!i) {
                if (this.f28752n && this.f28742d) {
                    i = true;
                }
            }
            i = false;
        }
        return i;
    }
}
