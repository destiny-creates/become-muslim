package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.List;

@cm
public final class aub extends axa implements auj {
    /* renamed from: a */
    private String f28363a;
    /* renamed from: b */
    private List<att> f28364b;
    /* renamed from: c */
    private String f28365c;
    /* renamed from: d */
    private avd f28366d;
    /* renamed from: e */
    private String f28367e;
    /* renamed from: f */
    private String f28368f;
    /* renamed from: g */
    private double f28369g;
    /* renamed from: h */
    private String f28370h;
    /* renamed from: i */
    private String f28371i;
    /* renamed from: j */
    private atp f28372j;
    /* renamed from: k */
    private aqv f28373k;
    /* renamed from: l */
    private View f28374l;
    /* renamed from: m */
    private C2758b f28375m;
    /* renamed from: n */
    private String f28376n;
    /* renamed from: o */
    private Bundle f28377o;
    /* renamed from: p */
    private Object f28378p = new Object();
    /* renamed from: q */
    private auf f28379q;

    public aub(String str, List<att> list, String str2, avd avd, String str3, String str4, double d, String str5, String str6, atp atp, aqv aqv, View view, C2758b c2758b, String str7, Bundle bundle) {
        this.f28363a = str;
        this.f28364b = list;
        this.f28365c = str2;
        this.f28366d = avd;
        this.f28367e = str3;
        this.f28368f = str4;
        this.f28369g = d;
        this.f28370h = str5;
        this.f28371i = str6;
        this.f28372j = atp;
        this.f28373k = aqv;
        this.f28374l = view;
        this.f28375m = c2758b;
        this.f28376n = str7;
        this.f28377o = bundle;
    }

    /* renamed from: a */
    public final String mo4062a() {
        return this.f28363a;
    }

    /* renamed from: a */
    public final void mo4063a(Bundle bundle) {
        synchronized (this.f28378p) {
            if (this.f28379q == null) {
                mt.m19920c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.f28379q.mo3979b(bundle);
        }
    }

    /* renamed from: a */
    public final void mo6084a(auf auf) {
        synchronized (this.f28378p) {
            this.f28379q = auf;
        }
    }

    /* renamed from: a */
    public final void mo4064a(awx awx) {
        this.f28379q.mo3976a(awx);
    }

    /* renamed from: b */
    public final List mo4011b() {
        return this.f28364b;
    }

    /* renamed from: b */
    public final boolean mo4066b(Bundle bundle) {
        synchronized (this.f28378p) {
            if (this.f28379q == null) {
                mt.m19920c("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            boolean a = this.f28379q.mo3978a(bundle);
            return a;
        }
    }

    /* renamed from: c */
    public final String mo4067c() {
        return this.f28365c;
    }

    /* renamed from: c */
    public final void mo4068c(Bundle bundle) {
        synchronized (this.f28378p) {
            if (this.f28379q == null) {
                mt.m19920c("#003 Attempt to report touch event before native ad initialized.");
                return;
            }
            this.f28379q.mo3984c(bundle);
        }
    }

    /* renamed from: d */
    public final avd mo4069d() {
        return this.f28366d;
    }

    /* renamed from: e */
    public final String mo4070e() {
        return this.f28367e;
    }

    /* renamed from: f */
    public final String mo4071f() {
        return this.f28368f;
    }

    /* renamed from: g */
    public final double mo4072g() {
        return this.f28369g;
    }

    /* renamed from: h */
    public final String mo4073h() {
        return this.f28370h;
    }

    /* renamed from: i */
    public final String mo4074i() {
        return this.f28371i;
    }

    /* renamed from: j */
    public final aqv mo4075j() {
        return this.f28373k;
    }

    /* renamed from: k */
    public final String mo6085k() {
        return "6";
    }

    /* renamed from: l */
    public final String mo6086l() {
        return "";
    }

    /* renamed from: m */
    public final atp mo6087m() {
        return this.f28372j;
    }

    /* renamed from: n */
    public final C2758b mo4076n() {
        return C4757d.a(this.f28379q);
    }

    /* renamed from: o */
    public final View mo6088o() {
        return this.f28374l;
    }

    /* renamed from: p */
    public final C2758b mo4077p() {
        return this.f28375m;
    }

    /* renamed from: q */
    public final String mo4078q() {
        return this.f28376n;
    }

    /* renamed from: r */
    public final Bundle mo4079r() {
        return this.f28377o;
    }

    /* renamed from: s */
    public final auz mo4080s() {
        return this.f28372j;
    }

    /* renamed from: t */
    public final void mo4081t() {
        jw.f15691a.post(new auc(this));
    }

    /* renamed from: u */
    public final void mo4082u() {
        this.f28379q.mo3983c();
    }
}
