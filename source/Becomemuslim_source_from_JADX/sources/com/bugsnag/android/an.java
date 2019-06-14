package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.stetho.server.http.HttpStatus;

/* compiled from: Stacktrace */
class an implements C1071a {
    /* renamed from: a */
    final C1091l f9188a;
    /* renamed from: b */
    final StackTraceElement[] f9189b;

    an(C1091l c1091l, StackTraceElement[] stackTraceElementArr) {
        this.f9188a = c1091l;
        this.f9189b = stackTraceElementArr;
    }

    public void toStream(ab abVar) {
        abVar.mo776e();
        int i = 0;
        while (i < this.f9189b.length && i < HttpStatus.HTTP_OK) {
            StackTraceElement stackTraceElement = this.f9189b[i];
            try {
                abVar.mo772c();
                if (stackTraceElement.getClassName().length() > 0) {
                    ab a = abVar.mo764a("method");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(stackTraceElement.getClassName());
                    stringBuilder.append(".");
                    stringBuilder.append(stackTraceElement.getMethodName());
                    a.mo771b(stringBuilder.toString());
                } else {
                    abVar.mo764a("method").mo771b(stackTraceElement.getMethodName());
                }
                abVar.mo764a(UriUtil.LOCAL_FILE_SCHEME).mo771b(stackTraceElement.getFileName() == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : stackTraceElement.getFileName());
                abVar.mo764a(StackTraceHelper.LINE_NUMBER_KEY).mo766a((long) stackTraceElement.getLineNumber());
                if (this.f9188a.m3856i(stackTraceElement.getClassName())) {
                    abVar.mo764a("inProject").mo769a(true);
                }
                abVar.mo770b();
            } catch (Throwable e) {
                ad.m3733a("Failed to serialize stacktrace", e);
            }
            i++;
        }
        abVar.mo775d();
    }
}
