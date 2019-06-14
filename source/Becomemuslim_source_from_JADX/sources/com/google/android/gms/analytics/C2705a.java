package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p210i.C5006n;
import com.google.android.gms.internal.p210i.C5008q;
import com.google.android.gms.internal.p210i.as;
import com.google.android.gms.internal.p210i.bz;

/* renamed from: com.google.android.gms.analytics.a */
public class C2705a extends BroadcastReceiver {
    /* renamed from: a */
    private static Boolean f6954a;

    /* renamed from: a */
    protected void m7708a(Context context, String str) {
    }

    /* renamed from: a */
    public static boolean m7707a(Context context) {
        C2872v.m8380a((Object) context);
        if (f6954a != null) {
            return f6954a.booleanValue();
        }
        context = bz.a(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f6954a = Boolean.valueOf(context);
        return context;
    }

    public void onReceive(Context context, Intent intent) {
        C5008q a = C5008q.a(context);
        C5006n e = a.e();
        if (intent == null) {
            e.h("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        intent = intent.getAction();
        e.a("CampaignTrackingReceiver received", intent);
        if ("com.android.vending.INSTALL_REFERRER".equals(intent) != null) {
            if (TextUtils.isEmpty(stringExtra) == null) {
                m7708a(context, stringExtra);
                Intent c = as.c();
                if (stringExtra.length() > c) {
                    e.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(c));
                    stringExtra = stringExtra.substring(null, c);
                }
                a.h().a(stringExtra, new C2711k(this, goAsync()));
                return;
            }
        }
        e.h("CampaignTrackingReceiver received unexpected intent without referrer extra");
    }
}
