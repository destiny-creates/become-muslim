package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.C3211a;
import com.amplitude.api.AmplitudeClient;
import com.google.android.gms.common.api.internal.C2799e;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p213l.cg;
import com.google.android.gms.internal.p213l.dz;
import com.google.android.gms.internal.p213l.ft;
import com.google.android.gms.internal.p213l.fw;
import com.google.firebase.analytics.FirebaseAnalytics.C5325a;
import com.google.firebase.analytics.FirebaseAnalytics.C5326b;
import com.google.firebase.analytics.FirebaseAnalytics.C5327c;
import expo.modules.contacts.EXColumns;
import java.util.List;
import java.util.Map;

@Keep
@Deprecated
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private final cg zzacv;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            C2872v.a(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = fw.m42647b(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.AppMeasurement$b */
    public interface C5149b {
        /* renamed from: a */
        void m21831a(String str, String str2, Bundle bundle, long j);
    }

    /* renamed from: com.google.android.gms.measurement.AppMeasurement$c */
    public interface C5150c {
        /* renamed from: a */
        void m21832a(String str, String str2, Bundle bundle, long j);
    }

    /* renamed from: com.google.android.gms.measurement.AppMeasurement$a */
    public static final class C6846a extends C5325a {
        /* renamed from: a */
        public static final String[] f24652a = new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", AmplitudeClient.START_SESSION_EVENT, "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};
        /* renamed from: b */
        public static final String[] f24653b = new String[]{"_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep"};

        /* renamed from: a */
        public static String m32210a(String str) {
            return fw.m42638a(str, f24652a, f24653b);
        }
    }

    /* renamed from: com.google.android.gms.measurement.AppMeasurement$d */
    public static final class C6847d extends C5326b {
        /* renamed from: a */
        public static final String[] f24654a = new String[]{"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection"};
        /* renamed from: b */
        public static final String[] f24655b = new String[]{"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac"};

        /* renamed from: a */
        public static String m32211a(String str) {
            return fw.m42638a(str, f24654a, f24655b);
        }
    }

    /* renamed from: com.google.android.gms.measurement.AppMeasurement$e */
    public static final class C6848e extends C5327c {
        /* renamed from: a */
        public static final String[] f24656a = new String[]{"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement"};
        /* renamed from: b */
        public static final String[] f24657b = new String[]{"_ln", "_fot", "_fvt", "_ldl", EXColumns.ID, "_fi", "_lte"};

        /* renamed from: a */
        public static String m32212a(String str) {
            return fw.m42638a(str, f24656a, f24657b);
        }
    }

    public AppMeasurement(cg cgVar) {
        C2872v.a(cgVar);
        this.zzacv = cgVar;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return cg.m31947a(context, null, null).m31967i();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzacv.m31982x().m42704a(str);
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzacv.m31966h().m44113c(str, str2, bundle);
    }

    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zzacv.m31966h().m44103a(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzacv.m31982x().m42706b(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzacv.m31969k().m42680g();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzacv.m31966h().m44086H();
    }

    public Boolean getBoolean() {
        return this.zzacv.m31966h().m44080B();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zzacv.m31966h().m44089a(str, str2);
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zzacv.m31966h().m44090a(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        dz C = this.zzacv.m31977s().m44140C();
        return C != null ? C.f17146b : null;
    }

    @Keep
    public String getCurrentScreenName() {
        dz C = this.zzacv.m31977s().m44140C();
        return C != null ? C.f17145a : null;
    }

    public Double getDouble() {
        return this.zzacv.m31966h().m44084F();
    }

    @Keep
    public String getGmpAppId() {
        if (this.zzacv.m31974p() != null) {
            return this.zzacv.m31974p();
        }
        try {
            return C2799e.a();
        } catch (IllegalStateException e) {
            this.zzacv.mo4754r().I_().m21308a("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public Integer getInteger() {
        return this.zzacv.m31966h().m44083E();
    }

    public Long getLong() {
        return this.zzacv.m31966h().m44082D();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        this.zzacv.m31966h();
        C2872v.a(str);
        return 25;
    }

    public String getString() {
        return this.zzacv.m31966h().m44081C();
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzacv.m31966h().m44092a(str, str2, z);
    }

    public Map<String, Object> getUserProperties(boolean z) {
        List<ft> b = this.zzacv.m31966h().m44105b(z);
        Map<String, Object> c3211a = new C3211a(b.size());
        for (ft ftVar : b) {
            c3211a.put(ftVar.f28979a, ftVar.m38105a());
        }
        return c3211a;
    }

    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.zzacv.m31966h().m44091a(str, str2, str3, z);
    }

    public final void logEvent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacv.m31966h().m44101a("app", str, bundle, true);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacv.m31966h().m44099a(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacv.m31966h().m44100a(str, str2, bundle, j);
    }

    public void registerOnMeasurementEventListener(C5150c c5150c) {
        this.zzacv.m31966h().m44097a(c5150c);
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zzacv.m31966h().m44095a(conditionalUserProperty);
    }

    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zzacv.m31966h().m44108b(conditionalUserProperty);
    }

    public void setEventInterceptor(C5149b c5149b) {
        this.zzacv.m31966h().m44096a(c5149b);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zzacv.m31966h().m44104a(z);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzacv.m31966h().m44094a(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzacv.m31966h().m44107b(j);
    }

    public final void setUserProperty(String str, String str2) {
        int c = this.zzacv.m31969k().m42671c(str);
        if (c != 0) {
            this.zzacv.m31969k();
            this.zzacv.m31969k().m42662a(c, "_ev", fw.m42637a(str, 24, true), str != null ? str.length() : 0);
            return;
        }
        setUserPropertyInternal("app", str, str2);
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zzacv.m31966h().m44102a(str, str2, obj);
    }

    public void unregisterOnMeasurementEventListener(C5150c c5150c) {
        this.zzacv.m31966h().m44109b(c5150c);
    }
}
