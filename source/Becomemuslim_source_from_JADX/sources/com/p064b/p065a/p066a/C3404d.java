package com.p064b.p065a.p066a;

import android.app.Activity;
import android.os.Bundle;
import com.p064b.p065a.p066a.C0999s.C0998b;
import io.p347a.p348a.p349a.C6512a.C6414b;

/* compiled from: AnswersLifecycleCallbacks */
/* renamed from: com.b.a.a.d */
class C3404d extends C6414b {
    /* renamed from: a */
    private final C3411q f9061a;
    /* renamed from: b */
    private final C0992g f9062b;

    /* renamed from: a */
    public void m10847a(Activity activity, Bundle bundle) {
    }

    /* renamed from: b */
    public void m10849b(Activity activity, Bundle bundle) {
    }

    /* renamed from: e */
    public void m10852e(Activity activity) {
    }

    public C3404d(C3411q c3411q, C0992g c0992g) {
        this.f9061a = c3411q;
        this.f9062b = c0992g;
    }

    /* renamed from: a */
    public void m10846a(Activity activity) {
        this.f9061a.m10866a(activity, C0998b.START);
    }

    /* renamed from: b */
    public void m10848b(Activity activity) {
        this.f9061a.m10866a(activity, C0998b.RESUME);
        this.f9062b.m3433a();
    }

    /* renamed from: c */
    public void m10850c(Activity activity) {
        this.f9061a.m10866a(activity, C0998b.PAUSE);
        this.f9062b.m3436b();
    }

    /* renamed from: d */
    public void m10851d(Activity activity) {
        this.f9061a.m10866a(activity, C0998b.STOP);
    }
}
