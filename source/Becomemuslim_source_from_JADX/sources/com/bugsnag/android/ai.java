package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import java.io.File;

/* compiled from: Report */
public class ai implements C1071a {
    /* renamed from: a */
    private final File f9170a;
    /* renamed from: b */
    private final C3448s f9171b;
    /* renamed from: c */
    private final ag f9172c;
    /* renamed from: d */
    private String f9173d;

    ai(String str, File file) {
        this.f9171b = null;
        this.f9170a = file;
        this.f9172c = ag.m11035a();
        this.f9173d = str;
    }

    ai(String str, C3448s c3448s) {
        this.f9171b = c3448s;
        this.f9170a = null;
        this.f9172c = ag.m11035a();
        this.f9173d = str;
    }

    public void toStream(ab abVar) {
        abVar.mo772c();
        abVar.mo764a("apiKey").mo771b(this.f9173d);
        abVar.mo764a("payloadVersion").mo771b("4.0");
        abVar.mo764a("notifier").m11021a(this.f9172c);
        abVar.mo764a("events").mo776e();
        if (this.f9171b != null) {
            abVar.m11021a(this.f9171b);
        } else if (this.f9170a != null) {
            abVar.m11022a(this.f9170a);
        } else {
            ad.m3736b("Expected error or errorFile, found empty payload instead");
        }
        abVar.mo775d();
        abVar.mo770b();
    }

    /* renamed from: a */
    public C3448s m11039a() {
        return this.f9171b;
    }

    /* renamed from: b */
    public ag m11040b() {
        return this.f9172c;
    }
}
