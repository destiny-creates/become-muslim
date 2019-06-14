package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p213l.cg;
import com.google.android.gms.p186f.C2954g;
import expo.modules.contacts.EXColumns;

@Keep
public final class FirebaseAnalytics {
    private final cg zzacv;

    /* renamed from: com.google.firebase.analytics.FirebaseAnalytics$a */
    public static class C5325a {
    }

    /* renamed from: com.google.firebase.analytics.FirebaseAnalytics$b */
    public static class C5326b {
    }

    /* renamed from: com.google.firebase.analytics.FirebaseAnalytics$c */
    public static class C5327c {
    }

    public FirebaseAnalytics(cg cgVar) {
        C2872v.a(cgVar);
        this.zzacv = cgVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return cg.m31947a(context, null, null).m31968j();
    }

    public final C2954g<String> getAppInstanceId() {
        return this.zzacv.m31966h().m44085G();
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zzacv.m31967i().logEvent(str, bundle);
    }

    public final void resetAnalyticsData() {
        this.zzacv.m31966h().m44087I();
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.zzacv.m31967i().setMeasurementEnabled(z);
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzacv.m31977s().m44144a(activity, str, str2);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzacv.m31967i().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzacv.m31967i().setSessionTimeoutDuration(j);
    }

    public final void setUserId(String str) {
        this.zzacv.m31967i().setUserPropertyInternal("app", EXColumns.ID, str);
    }

    public final void setUserProperty(String str, String str2) {
        this.zzacv.m31967i().setUserProperty(str, str2);
    }
}
