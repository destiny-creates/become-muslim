package com.p064b.p065a.p066a;

import android.annotation.SuppressLint;
import android.content.Context;
import io.p347a.p348a.p349a.p350a.p357f.C6490c;
import io.p347a.p348a.p349a.p350a.p357f.C7619d;

/* compiled from: AnswersPreferenceManager */
/* renamed from: com.b.a.a.e */
class C0989e {
    /* renamed from: a */
    private final C6490c f2755a;

    /* renamed from: a */
    public static C0989e m3427a(Context context) {
        return new C0989e(new C7619d(context, "settings"));
    }

    C0989e(C6490c c6490c) {
        this.f2755a = c6490c;
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public void m3428a() {
        this.f2755a.a(this.f2755a.b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public boolean m3429b() {
        return this.f2755a.a().getBoolean("analytics_launched", false);
    }
}
