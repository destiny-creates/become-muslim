package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.C5335b;
import com.google.firebase.analytics.connector.C5328a;

/* renamed from: com.google.firebase.messaging.b */
public class C5373b {
    /* renamed from: a */
    public static void m22815a(Intent intent) {
        C5373b.m22816a("_nr", intent);
    }

    /* renamed from: b */
    public static void m22817b(Intent intent) {
        if (intent != null) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(intent.getStringExtra("google.c.a.tc"))) {
                C5328a c5328a = (C5328a) C5335b.m22606d().m22612a(C5328a.class);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (c5328a != null) {
                    Object stringExtra = intent.getStringExtra("google.c.a.c_id");
                    c5328a.mo4875a(AppMeasurement.FCM_ORIGIN, "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    c5328a.mo4874a(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        C5373b.m22816a("_no", intent);
    }

    /* renamed from: c */
    public static void m22818c(Intent intent) {
        C5373b.m22816a("_nd", intent);
    }

    /* renamed from: d */
    public static void m22819d(Intent intent) {
        C5373b.m22816a("_nf", intent);
    }

    /* renamed from: e */
    public static boolean m22820e(Intent intent) {
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction())) {
            return false;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(intent.getStringExtra("google.c.a.e"));
    }

    /* renamed from: a */
    private static void m22816a(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        stringExtra = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra != null) {
            bundle.putString("_nmn", stringExtra);
        }
        Object stringExtra2 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString("label", stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString("message_channel", stringExtra2);
        }
        stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            stringExtra = null;
        }
        if (stringExtra != null) {
            bundle.putString("_nt", stringExtra);
        }
        if (intent.hasExtra("google.c.a.ts")) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(intent.getStringExtra("google.c.a.ts")));
            } catch (Throwable e) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
            }
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(intent.getStringExtra("google.c.a.udt")));
            } catch (Intent intent2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", intent2);
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3) != null) {
            stringExtra = String.valueOf(bundle);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 22) + String.valueOf(stringExtra).length());
            stringBuilder.append("Sending event=");
            stringBuilder.append(str);
            stringBuilder.append(" params=");
            stringBuilder.append(stringExtra);
            Log.d("FirebaseMessaging", stringBuilder.toString());
        }
        C5328a c5328a = (C5328a) C5335b.m22606d().m22612a(C5328a.class);
        if (c5328a != null) {
            c5328a.mo4874a(AppMeasurement.FCM_ORIGIN, str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }
}
