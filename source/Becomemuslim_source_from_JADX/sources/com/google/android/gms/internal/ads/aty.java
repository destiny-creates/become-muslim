package com.google.android.gms.internal.ads;

import android.support.v4.util.C0463l;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.Arrays;
import java.util.List;

@cm
public final class aty extends awb implements aui {
    /* renamed from: a */
    private final atp f28355a;
    /* renamed from: b */
    private final String f28356b;
    /* renamed from: c */
    private final C0463l<String, att> f28357c;
    /* renamed from: d */
    private final C0463l<String, String> f28358d;
    /* renamed from: e */
    private aqv f28359e;
    /* renamed from: f */
    private View f28360f;
    /* renamed from: g */
    private final Object f28361g = new Object();
    /* renamed from: h */
    private auf f28362h;

    public aty(String str, C0463l<String, att> c0463l, C0463l<String, String> c0463l2, atp atp, aqv aqv, View view) {
        this.f28356b = str;
        this.f28357c = c0463l;
        this.f28358d = c0463l2;
        this.f28355a = atp;
        this.f28359e = aqv;
        this.f28360f = view;
    }

    /* renamed from: a */
    public final String mo4043a(String str) {
        return (String) this.f28358d.get(str);
    }

    /* renamed from: a */
    public final List<String> mo4044a() {
        String[] strArr = new String[(this.f28357c.size() + this.f28358d.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f28357c.size()) {
            strArr[i3] = (String) this.f28357c.b(i2);
            i2++;
            i3++;
        }
        while (i < this.f28358d.size()) {
            strArr[i3] = (String) this.f28358d.b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    /* renamed from: a */
    public final void mo6084a(auf auf) {
        synchronized (this.f28361g) {
            this.f28362h = auf;
        }
    }

    /* renamed from: a */
    public final boolean mo4045a(C2758b c2758b) {
        if (this.f28362h == null) {
            mt.m19920c("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.f28360f == null) {
            return false;
        } else {
            View view = (FrameLayout) C4757d.a(c2758b);
            this.f28362h.mo3972a(view, new atz(this));
            return true;
        }
    }

    /* renamed from: b */
    public final C2758b mo4046b() {
        return C4757d.a(this.f28362h);
    }

    /* renamed from: b */
    public final avd mo4047b(String str) {
        return (avd) this.f28357c.get(str);
    }

    /* renamed from: c */
    public final aqv mo4048c() {
        return this.f28359e;
    }

    /* renamed from: c */
    public final void mo4049c(String str) {
        synchronized (this.f28361g) {
            if (this.f28362h == null) {
                mt.m19920c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.f28362h.mo3973a(null, str, null, null, null);
        }
    }

    /* renamed from: d */
    public final void mo4050d() {
        synchronized (this.f28361g) {
            if (this.f28362h == null) {
                mt.m19920c("#002 Attempt to record impression before native ad initialized.");
                return;
            }
            this.f28362h.mo3974a(null, null);
        }
    }

    /* renamed from: e */
    public final C2758b mo4051e() {
        return C4757d.a(this.f28362h.mo3993m().getApplicationContext());
    }

    /* renamed from: f */
    public final void mo4052f() {
        jw.f15691a.post(new aua(this));
        this.f28359e = null;
        this.f28360f = null;
    }

    /* renamed from: k */
    public final String mo6085k() {
        return "3";
    }

    /* renamed from: l */
    public final String mo6086l() {
        return this.f28356b;
    }

    /* renamed from: m */
    public final atp mo6087m() {
        return this.f28355a;
    }

    /* renamed from: o */
    public final View mo6088o() {
        return this.f28360f;
    }
}
