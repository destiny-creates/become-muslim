package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

@cm
public final class avg extends C2608b {
    /* renamed from: a */
    private final avd f23831a;
    /* renamed from: b */
    private final Drawable f23832b;
    /* renamed from: c */
    private final Uri f23833c;
    /* renamed from: d */
    private final double f23834d;

    public avg(avd avd) {
        Drawable drawable;
        double d;
        this.f23831a = avd;
        Uri uri = null;
        try {
            C2758b a = this.f23831a.mo3996a();
            if (a != null) {
                drawable = (Drawable) C4757d.a(a);
                this.f23832b = drawable;
                uri = this.f23831a.mo3997b();
                this.f23833c = uri;
                d = 1.0d;
                d = this.f23831a.mo3998c();
                this.f23834d = d;
            }
        } catch (Throwable e) {
            mt.m19919b("", e);
        }
        drawable = null;
        this.f23832b = drawable;
        try {
            uri = this.f23831a.mo3997b();
        } catch (Throwable e2) {
            mt.m19919b("", e2);
        }
        this.f23833c = uri;
        d = 1.0d;
        try {
            d = this.f23831a.mo3998c();
        } catch (Throwable e3) {
            mt.m19919b("", e3);
        }
        this.f23834d = d;
    }

    /* renamed from: a */
    public final Drawable m30255a() {
        return this.f23832b;
    }

    /* renamed from: b */
    public final Uri m30256b() {
        return this.f23833c;
    }

    /* renamed from: c */
    public final double m30257c() {
        return this.f23834d;
    }
}
