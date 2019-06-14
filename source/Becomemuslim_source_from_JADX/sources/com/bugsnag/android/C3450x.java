package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import com.facebook.share.internal.ShareConstants;

/* compiled from: Exceptions */
/* renamed from: com.bugsnag.android.x */
class C3450x implements C1071a {
    /* renamed from: a */
    private final C1091l f9219a;
    /* renamed from: b */
    private final Throwable f9220b;
    /* renamed from: c */
    private String f9221c = "android";

    C3450x(C1091l c1091l, Throwable th) {
        this.f9219a = c1091l;
        this.f9220b = th;
    }

    public void toStream(ab abVar) {
        abVar.mo776e();
        for (Throwable th = this.f9220b; th != null; th = th.getCause()) {
            if (th instanceof C1071a) {
                ((C1071a) th).toStream(abVar);
            } else {
                m11088a(abVar, m11087a(th), th.getLocalizedMessage(), th.getStackTrace());
            }
        }
        abVar.mo775d();
    }

    /* renamed from: a */
    Throwable m11089a() {
        return this.f9220b;
    }

    /* renamed from: b */
    String m11091b() {
        return this.f9221c;
    }

    /* renamed from: a */
    void m11090a(String str) {
        this.f9221c = str;
    }

    /* renamed from: a */
    private String m11087a(Throwable th) {
        if (th instanceof C1081g) {
            return ((C1081g) th).m3781a();
        }
        return th.getClass().getName();
    }

    /* renamed from: a */
    private void m11088a(ab abVar, String str, String str2, StackTraceElement[] stackTraceElementArr) {
        abVar.mo772c();
        abVar.mo764a("errorClass").mo771b(str);
        abVar.mo764a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE).mo771b(str2);
        abVar.mo764a("type").mo771b(this.f9221c);
        abVar.mo764a("stacktrace").m11021a(new an(this.f9219a, stackTraceElementArr));
        abVar.mo770b();
    }
}
