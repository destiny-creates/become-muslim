package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.C2643g;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

@cm
public final class atd extends ath {
    /* renamed from: a */
    private final C2643g f28305a;
    /* renamed from: b */
    private final String f28306b;
    /* renamed from: c */
    private final String f28307c;

    public atd(C2643g c2643g, String str, String str2) {
        this.f28305a = c2643g;
        this.f28306b = str;
        this.f28307c = str2;
    }

    /* renamed from: a */
    public final String mo3959a() {
        return this.f28306b;
    }

    /* renamed from: a */
    public final void mo3960a(C2758b c2758b) {
        if (c2758b != null) {
            this.f28305a.a_((View) C4757d.a(c2758b));
        }
    }

    /* renamed from: b */
    public final String mo3961b() {
        return this.f28307c;
    }

    /* renamed from: c */
    public final void mo3962c() {
        this.f28305a.k_();
    }

    /* renamed from: d */
    public final void mo3963d() {
        this.f28305a.l_();
    }
}
