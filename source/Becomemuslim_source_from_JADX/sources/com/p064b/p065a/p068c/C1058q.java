package com.p064b.p065a.p068c;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p358g.C6499o;

/* compiled from: DialogStringResolver */
/* renamed from: com.b.a.c.q */
class C1058q {
    /* renamed from: a */
    private final Context f2953a;
    /* renamed from: b */
    private final C6499o f2954b;

    public C1058q(Context context, C6499o c6499o) {
        this.f2953a = context;
        this.f2954b = c6499o;
    }

    /* renamed from: a */
    public String m3641a() {
        return m3638a("com.crashlytics.CrashSubmissionPromptTitle", this.f2954b.f20944a);
    }

    /* renamed from: b */
    public String m3642b() {
        return m3638a("com.crashlytics.CrashSubmissionPromptMessage", this.f2954b.f20945b);
    }

    /* renamed from: c */
    public String m3643c() {
        return m3638a("com.crashlytics.CrashSubmissionSendTitle", this.f2954b.f20946c);
    }

    /* renamed from: d */
    public String m3644d() {
        return m3638a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f2954b.f20950g);
    }

    /* renamed from: e */
    public String m3645e() {
        return m3638a("com.crashlytics.CrashSubmissionCancelTitle", this.f2954b.f20948e);
    }

    /* renamed from: a */
    private String m3638a(String str, String str2) {
        return m3640b(C6428i.b(this.f2953a, str), str2);
    }

    /* renamed from: b */
    private String m3640b(String str, String str2) {
        return m3639a(str) ? str2 : str;
    }

    /* renamed from: a */
    private boolean m3639a(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }
}
