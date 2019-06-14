package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.List;

@cm
public final class atu extends avt implements auj {
    /* renamed from: a */
    private String f28325a;
    /* renamed from: b */
    private List<att> f28326b;
    /* renamed from: c */
    private String f28327c;
    /* renamed from: d */
    private avd f28328d;
    /* renamed from: e */
    private String f28329e;
    /* renamed from: f */
    private double f28330f;
    /* renamed from: g */
    private String f28331g;
    /* renamed from: h */
    private String f28332h;
    /* renamed from: i */
    private atp f28333i;
    /* renamed from: j */
    private Bundle f28334j;
    /* renamed from: k */
    private aqv f28335k;
    /* renamed from: l */
    private View f28336l;
    /* renamed from: m */
    private C2758b f28337m;
    /* renamed from: n */
    private String f28338n;
    /* renamed from: o */
    private Object f28339o = new Object();
    /* renamed from: p */
    private auf f28340p;

    public atu(String str, List<att> list, String str2, avd avd, String str3, double d, String str4, String str5, atp atp, Bundle bundle, aqv aqv, View view, C2758b c2758b, String str6) {
        this.f28325a = str;
        this.f28326b = list;
        this.f28327c = str2;
        this.f28328d = avd;
        this.f28329e = str3;
        this.f28330f = d;
        this.f28331g = str4;
        this.f28332h = str5;
        this.f28333i = atp;
        this.f28334j = bundle;
        this.f28335k = aqv;
        this.f28336l = view;
        this.f28337m = c2758b;
        this.f28338n = str6;
    }

    /* renamed from: a */
    public final String mo4009a() {
        return this.f28325a;
    }

    /* renamed from: a */
    public final void mo4010a(Bundle bundle) {
        synchronized (this.f28339o) {
            if (this.f28340p == null) {
                mt.m19920c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.f28340p.mo3979b(bundle);
        }
    }

    /* renamed from: a */
    public final void mo6084a(auf auf) {
        synchronized (this.f28339o) {
            this.f28340p = auf;
        }
    }

    /* renamed from: b */
    public final List mo4011b() {
        return this.f28326b;
    }

    /* renamed from: b */
    public final boolean mo4012b(Bundle bundle) {
        synchronized (this.f28339o) {
            if (this.f28340p == null) {
                mt.m19920c("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            boolean a = this.f28340p.mo3978a(bundle);
            return a;
        }
    }

    /* renamed from: c */
    public final String mo4013c() {
        return this.f28327c;
    }

    /* renamed from: c */
    public final void mo4014c(Bundle bundle) {
        synchronized (this.f28339o) {
            if (this.f28340p == null) {
                mt.m19920c("#003 Attempt to report touch event before native ad initialized.");
                return;
            }
            this.f28340p.mo3984c(bundle);
        }
    }

    /* renamed from: d */
    public final avd mo4015d() {
        return this.f28328d;
    }

    /* renamed from: e */
    public final String mo4016e() {
        return this.f28329e;
    }

    /* renamed from: f */
    public final double mo4017f() {
        return this.f28330f;
    }

    /* renamed from: g */
    public final String mo4018g() {
        return this.f28331g;
    }

    /* renamed from: h */
    public final String mo4019h() {
        return this.f28332h;
    }

    /* renamed from: i */
    public final aqv mo4020i() {
        return this.f28335k;
    }

    /* renamed from: j */
    public final C2758b mo4021j() {
        return C4757d.a(this.f28340p);
    }

    /* renamed from: k */
    public final String mo6085k() {
        return "2";
    }

    /* renamed from: l */
    public final String mo6086l() {
        return "";
    }

    /* renamed from: m */
    public final atp mo6087m() {
        return this.f28333i;
    }

    /* renamed from: n */
    public final Bundle mo4022n() {
        return this.f28334j;
    }

    /* renamed from: o */
    public final View mo6088o() {
        return this.f28336l;
    }

    /* renamed from: p */
    public final C2758b mo4023p() {
        return this.f28337m;
    }

    /* renamed from: q */
    public final String mo4024q() {
        return this.f28338n;
    }

    /* renamed from: r */
    public final auz mo4025r() {
        return this.f28333i;
    }

    /* renamed from: s */
    public final void mo4026s() {
        jw.f15691a.post(new atv(this));
        this.f28325a = null;
        this.f28326b = null;
        this.f28327c = null;
        this.f28328d = null;
        this.f28329e = null;
        this.f28330f = 0.0d;
        this.f28331g = null;
        this.f28332h = null;
        this.f28333i = null;
        this.f28334j = null;
        this.f28339o = null;
        this.f28335k = null;
        this.f28336l = null;
    }
}
