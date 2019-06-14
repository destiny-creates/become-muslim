package com.p064b.p065a.p068c;

import android.util.Log;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;

/* compiled from: BuildIdValidator */
/* renamed from: com.b.a.c.a */
class C1015a {
    /* renamed from: a */
    private final String f2848a;
    /* renamed from: b */
    private final boolean f2849b;

    /* renamed from: b */
    protected String m3453b(String str, String str2) {
        return "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    }

    public C1015a(String str, boolean z) {
        this.f2848a = str;
        this.f2849b = z;
    }

    /* renamed from: a */
    public void m3452a(String str, String str2) {
        if (C6428i.c(this.f2848a)) {
            if (this.f2849b) {
                str = m3453b(str, str2);
                Log.e("CrashlyticsCore", ".");
                Log.e("CrashlyticsCore", ".     |  | ");
                Log.e("CrashlyticsCore", ".     |  |");
                Log.e("CrashlyticsCore", ".     |  |");
                Log.e("CrashlyticsCore", ".   \\ |  | /");
                Log.e("CrashlyticsCore", ".    \\    /");
                Log.e("CrashlyticsCore", ".     \\  /");
                Log.e("CrashlyticsCore", ".      \\/");
                Log.e("CrashlyticsCore", ".");
                Log.e("CrashlyticsCore", str);
                Log.e("CrashlyticsCore", ".");
                Log.e("CrashlyticsCore", ".      /\\");
                Log.e("CrashlyticsCore", ".     /  \\");
                Log.e("CrashlyticsCore", ".    /    \\");
                Log.e("CrashlyticsCore", ".   / |  | \\");
                Log.e("CrashlyticsCore", ".     |  |");
                Log.e("CrashlyticsCore", ".     |  |");
                Log.e("CrashlyticsCore", ".     |  |");
                Log.e("CrashlyticsCore", ".");
                throw new C1038j(str);
            }
        }
        if (this.f2849b == null) {
            C6514c.h().a("CrashlyticsCore", "Configured not to require a build ID.");
        }
    }
}
