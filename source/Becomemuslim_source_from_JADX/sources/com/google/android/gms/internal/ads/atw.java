package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.List;

@cm
public final class atw extends avx implements auj {
    /* renamed from: a */
    private String f28341a;
    /* renamed from: b */
    private List<att> f28342b;
    /* renamed from: c */
    private String f28343c;
    /* renamed from: d */
    private avd f28344d;
    /* renamed from: e */
    private String f28345e;
    /* renamed from: f */
    private String f28346f;
    /* renamed from: g */
    private atp f28347g;
    /* renamed from: h */
    private Bundle f28348h;
    /* renamed from: i */
    private aqv f28349i;
    /* renamed from: j */
    private View f28350j;
    /* renamed from: k */
    private C2758b f28351k;
    /* renamed from: l */
    private String f28352l;
    /* renamed from: m */
    private Object f28353m = new Object();
    /* renamed from: n */
    private auf f28354n;

    public atw(String str, List<att> list, String str2, avd avd, String str3, String str4, atp atp, Bundle bundle, aqv aqv, View view, C2758b c2758b, String str5) {
        this.f28341a = str;
        this.f28342b = list;
        this.f28343c = str2;
        this.f28344d = avd;
        this.f28345e = str3;
        this.f28346f = str4;
        this.f28347g = atp;
        this.f28348h = bundle;
        this.f28349i = aqv;
        this.f28350j = view;
        this.f28351k = c2758b;
        this.f28352l = str5;
    }

    /* renamed from: a */
    public final String mo4027a() {
        return this.f28341a;
    }

    /* renamed from: a */
    public final void mo4028a(Bundle bundle) {
        synchronized (this.f28353m) {
            if (this.f28354n == null) {
                mt.m19920c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.f28354n.mo3979b(bundle);
        }
    }

    /* renamed from: a */
    public final void mo6084a(auf auf) {
        synchronized (this.f28353m) {
            this.f28354n = auf;
        }
    }

    /* renamed from: b */
    public final List mo4011b() {
        return this.f28342b;
    }

    /* renamed from: b */
    public final boolean mo4030b(Bundle bundle) {
        synchronized (this.f28353m) {
            if (this.f28354n == null) {
                mt.m19920c("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            boolean a = this.f28354n.mo3978a(bundle);
            return a;
        }
    }

    /* renamed from: c */
    public final C2758b mo4031c() {
        return this.f28351k;
    }

    /* renamed from: c */
    public final void mo4032c(Bundle bundle) {
        synchronized (this.f28353m) {
            if (this.f28354n == null) {
                mt.m19920c("#003 Attempt to report touch event before native ad initialized.");
                return;
            }
            this.f28354n.mo3984c(bundle);
        }
    }

    /* renamed from: d */
    public final String mo4033d() {
        return this.f28352l;
    }

    /* renamed from: e */
    public final String mo4034e() {
        return this.f28343c;
    }

    /* renamed from: f */
    public final avd mo4035f() {
        return this.f28344d;
    }

    /* renamed from: g */
    public final String mo4036g() {
        return this.f28345e;
    }

    /* renamed from: h */
    public final String mo4037h() {
        return this.f28346f;
    }

    /* renamed from: i */
    public final aqv mo4038i() {
        return this.f28349i;
    }

    /* renamed from: j */
    public final C2758b mo4039j() {
        return C4757d.a(this.f28354n);
    }

    /* renamed from: k */
    public final String mo6085k() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    /* renamed from: l */
    public final String mo6086l() {
        return "";
    }

    /* renamed from: m */
    public final atp mo6087m() {
        return this.f28347g;
    }

    /* renamed from: n */
    public final Bundle mo4040n() {
        return this.f28348h;
    }

    /* renamed from: o */
    public final View mo6088o() {
        return this.f28350j;
    }

    /* renamed from: p */
    public final auz mo4041p() {
        return this.f28347g;
    }

    /* renamed from: q */
    public final void mo4042q() {
        jw.f15691a.post(new atx(this));
        this.f28341a = null;
        this.f28342b = null;
        this.f28343c = null;
        this.f28344d = null;
        this.f28345e = null;
        this.f28346f = null;
        this.f28347g = null;
        this.f28348h = null;
        this.f28353m = null;
        this.f28349i = null;
        this.f28350j = null;
    }
}
