package com.google.android.gms.p185e;

import android.util.Log;

/* renamed from: com.google.android.gms.e.af */
public final class af implements bt {
    /* renamed from: a */
    private int f11603a = 5;

    /* renamed from: a */
    public final void mo2498a(String str) {
        if (this.f11603a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    /* renamed from: a */
    public final void mo2499a(String str, Throwable th) {
        if (this.f11603a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    /* renamed from: b */
    public final void mo2500b(String str) {
        if (this.f11603a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    /* renamed from: b */
    public final void mo2501b(String str, Throwable th) {
        if (this.f11603a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    /* renamed from: c */
    public final void mo2502c(String str) {
        if (this.f11603a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: d */
    public final void mo2503d(String str) {
        if (this.f11603a <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    /* renamed from: e */
    public final void mo2504e(String str) {
        if (this.f11603a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    /* renamed from: a */
    public final void mo2497a(int i) {
        this.f11603a = i;
    }
}
