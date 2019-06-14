package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import com.facebook.internal.ServerProtocol;

/* compiled from: Notifier */
public class ag implements C1071a {
    /* renamed from: d */
    private static final ag f9166d = new ag();
    /* renamed from: a */
    private String f9167a = "Android Bugsnag Notifier";
    /* renamed from: b */
    private String f9168b = "4.12.0";
    /* renamed from: c */
    private String f9169c = "https://bugsnag.com";

    /* renamed from: a */
    public static ag m11035a() {
        return f9166d;
    }

    public void toStream(ab abVar) {
        abVar.mo772c();
        abVar.mo764a("name").mo771b(this.f9167a);
        abVar.mo764a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).mo771b(this.f9168b);
        abVar.mo764a("url").mo771b(this.f9169c);
        abVar.mo770b();
    }

    /* renamed from: a */
    public void m11036a(String str) {
        this.f9168b = str;
    }

    /* renamed from: b */
    public void m11037b(String str) {
        this.f9169c = str;
    }

    /* renamed from: c */
    public void m11038c(String str) {
        this.f9167a = str;
    }
}
