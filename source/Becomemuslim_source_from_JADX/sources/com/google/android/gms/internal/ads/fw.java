package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.ay;
import com.google.android.gms.ads.internal.gmsg.C2651k;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p174b.C4757d;
import java.util.HashMap;
import java.util.Map;

@cm
public final class fw {
    /* renamed from: a */
    private static final bcx f15501a = new bcx();
    /* renamed from: b */
    private final bcy f15502b;
    /* renamed from: c */
    private final ay f15503c;
    /* renamed from: d */
    private final Map<String, hl> f15504d = new HashMap();
    /* renamed from: e */
    private final hd f15505e;
    /* renamed from: f */
    private final C2651k f15506f;
    /* renamed from: g */
    private final ap f15507g;

    public fw(ay ayVar, bcy bcy, hd hdVar, C2651k c2651k, ap apVar) {
        this.f15503c = ayVar;
        this.f15502b = bcy;
        this.f15505e = hdVar;
        this.f15506f = c2651k;
        this.f15507g = apVar;
    }

    /* renamed from: a */
    public static boolean m19442a(is isVar, is isVar2) {
        return true;
    }

    /* renamed from: a */
    public final C2651k m19443a() {
        return this.f15506f;
    }

    /* renamed from: a */
    public final hl m19444a(String str) {
        Throwable e;
        String str2;
        hl hlVar = (hl) this.f15504d.get(str);
        if (hlVar != null) {
            return hlVar;
        }
        try {
            bcy bcy = this.f15502b;
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                bcy = f15501a;
            }
            hl hlVar2 = new hl(bcy.mo4102a(str), this.f15505e);
            try {
                this.f15504d.put(str, hlVar2);
                return hlVar2;
            } catch (Exception e2) {
                e = e2;
                hlVar = hlVar2;
                str2 = "Fail to instantiate adapter ";
                str = String.valueOf(str);
                mt.m19921c(str.length() == 0 ? new String(str2) : str2.concat(str), e);
                return hlVar;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "Fail to instantiate adapter ";
            str = String.valueOf(str);
            if (str.length() == 0) {
            }
            mt.m19921c(str.length() == 0 ? new String(str2) : str2.concat(str), e);
            return hlVar;
        }
    }

    /* renamed from: a */
    public final hq m19445a(hq hqVar) {
        if (!(this.f15503c.f6799j == null || this.f15503c.f6799j.f15591r == null || TextUtils.isEmpty(this.f15503c.f6799j.f15591r.f15204k))) {
            hqVar = new hq(this.f15503c.f6799j.f15591r.f15204k, this.f15503c.f6799j.f15591r.f15205l);
        }
        if (!(this.f15503c.f6799j == null || this.f15503c.f6799j.f15588o == null)) {
            ax.x();
            bcr.m19237a(this.f15503c.f6792c, this.f15503c.f6794e.f28709a, this.f15503c.f6799j.f15588o.f15185m, this.f15503c.f6777E, hqVar);
        }
        return hqVar;
    }

    /* renamed from: a */
    public final void m19446a(Context context) {
        for (hl a : this.f15504d.values()) {
            try {
                a.m19501a().mo4106a(C4757d.a(context));
            } catch (Throwable e) {
                mt.m19919b("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    /* renamed from: a */
    public final void m19447a(boolean z) {
        hl a = m19444a(this.f15503c.f6799j.f15590q);
        if (!(a == null || a.m19501a() == null)) {
            try {
                a.m19501a().mo4116a(z);
                a.m19501a().mo4121f();
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: b */
    public final ap m19448b() {
        return this.f15507g;
    }

    /* renamed from: c */
    public final void m19449c() {
        this.f15503c.f6781I = 0;
        ay ayVar = this.f15503c;
        ax.d();
        kp hgVar = new hg(this.f15503c.f6792c, this.f15503c.f6800k, this);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(hgVar.getClass().getName());
        mt.m19918b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        hgVar.mo3819c();
        ayVar.f6797h = hgVar;
    }

    /* renamed from: d */
    public final void m19450d() {
        C2872v.b("pause must be called on the main UI thread.");
        for (String str : this.f15504d.keySet()) {
            try {
                hl hlVar = (hl) this.f15504d.get(str);
                if (!(hlVar == null || hlVar.m19501a() == null)) {
                    hlVar.m19501a().mo4119d();
                }
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: e */
    public final void m19451e() {
        C2872v.b("resume must be called on the main UI thread.");
        for (String str : this.f15504d.keySet()) {
            try {
                hl hlVar = (hl) this.f15504d.get(str);
                if (!(hlVar == null || hlVar.m19501a() == null)) {
                    hlVar.m19501a().mo4120e();
                }
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: f */
    public final void m19452f() {
        C2872v.b("destroy must be called on the main UI thread.");
        for (String str : this.f15504d.keySet()) {
            try {
                hl hlVar = (hl) this.f15504d.get(str);
                if (!(hlVar == null || hlVar.m19501a() == null)) {
                    hlVar.m19501a().mo4118c();
                }
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: g */
    public final void m19453g() {
        if (this.f15503c.f6799j != null && this.f15503c.f6799j.f15588o != null) {
            ax.x();
            bcr.m19236a(this.f15503c.f6792c, this.f15503c.f6794e.f28709a, this.f15503c.f6799j, this.f15503c.f6791b, false, this.f15503c.f6799j.f15588o.f15184l);
        }
    }

    /* renamed from: h */
    public final void m19454h() {
        if (this.f15503c.f6799j != null && this.f15503c.f6799j.f15588o != null) {
            ax.x();
            bcr.m19236a(this.f15503c.f6792c, this.f15503c.f6794e.f28709a, this.f15503c.f6799j, this.f15503c.f6791b, false, this.f15503c.f6799j.f15588o.f15186n);
        }
    }
}
