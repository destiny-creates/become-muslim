package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.C6767s;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.p174b.C2758b;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.s */
public final class C4742s extends C6767s {
    /* renamed from: a */
    private AdOverlayInfoParcel f13067a;
    /* renamed from: b */
    private Activity f13068b;
    /* renamed from: c */
    private boolean f13069c = false;
    /* renamed from: d */
    private boolean f13070d = false;

    public C4742s(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f13067a = adOverlayInfoParcel;
        this.f13068b = activity;
    }

    /* renamed from: a */
    private final synchronized void m16584a() {
        if (!this.f13070d) {
            if (this.f13067a.f13023c != null) {
                this.f13067a.f13023c.u_();
            }
            this.f13070d = true;
        }
    }

    /* renamed from: a */
    public final void m16585a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public final void m16586a(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        if (this.f13067a != null) {
            if (!z) {
                if (bundle == null) {
                    if (this.f13067a.f13022b != null) {
                        this.f13067a.f13022b.onAdClicked();
                    }
                    if (!(this.f13068b.getIntent() == null || !this.f13068b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || this.f13067a.f13023c == null)) {
                        this.f13067a.f13023c.v_();
                    }
                }
                ax.m7461b();
                if (!C2656a.m7542a(this.f13068b, this.f13067a.f13021a, this.f13067a.f13029i)) {
                    this.f13068b.finish();
                }
                return;
            }
        }
        this.f13068b.finish();
    }

    /* renamed from: a */
    public final void m16587a(C2758b c2758b) {
    }

    /* renamed from: b */
    public final void m16588b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f13069c);
    }

    /* renamed from: d */
    public final void m16589d() {
    }

    /* renamed from: e */
    public final boolean m16590e() {
        return false;
    }

    /* renamed from: f */
    public final void m16591f() {
    }

    /* renamed from: g */
    public final void m16592g() {
    }

    /* renamed from: h */
    public final void m16593h() {
        if (this.f13069c) {
            this.f13068b.finish();
            return;
        }
        this.f13069c = true;
        if (this.f13067a.f13023c != null) {
            this.f13067a.f13023c.mo3439e();
        }
    }

    /* renamed from: i */
    public final void m16594i() {
        if (this.f13067a.f13023c != null) {
            this.f13067a.f13023c.mo3438d();
        }
        if (this.f13068b.isFinishing()) {
            m16584a();
        }
    }

    /* renamed from: j */
    public final void m16595j() {
        if (this.f13068b.isFinishing()) {
            m16584a();
        }
    }

    /* renamed from: k */
    public final void m16596k() {
        if (this.f13068b.isFinishing()) {
            m16584a();
        }
    }

    /* renamed from: l */
    public final void m16597l() {
    }
}
