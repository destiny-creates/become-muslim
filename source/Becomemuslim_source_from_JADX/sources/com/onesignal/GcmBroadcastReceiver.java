package com.onesignal;

import android.annotation.TargetApi;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.C0383g;
import com.facebook.appevents.AppEventsConstants;
import com.onesignal.C5529q.C5528a;
import java.security.SecureRandom;

public class GcmBroadcastReceiver extends C0383g {
    /* renamed from: b */
    private static boolean m32583b(Intent intent) {
        boolean z = false;
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return false;
        }
        intent = intent.getStringExtra("message_type");
        if (intent == null || "gcm".equals(intent) != null) {
            z = true;
        }
        return z;
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (!"google.com/iid".equals(extras.getString("from"))) {
                am.m23152a(context);
                intent = m32578a(context, intent, extras);
                if (intent == null) {
                    m32579a();
                    return;
                }
                if (!intent.f18568c) {
                    if (!intent.f18567b) {
                        if (intent.f18566a == null || am.m23192b(context) == null) {
                            m32579a();
                            return;
                        } else {
                            m32581b();
                            return;
                        }
                    }
                }
                m32581b();
            }
        }
    }

    /* renamed from: a */
    private void m32579a() {
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    /* renamed from: b */
    private void m32581b() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
    }

    /* renamed from: a */
    private static C5528a m32578a(Context context, Intent intent, Bundle bundle) {
        if (m32583b(intent) == null) {
            return null;
        }
        intent = C5529q.m23531a(context, bundle);
        if (intent.m23528a()) {
            return intent;
        }
        m32580a(context, bundle);
        return intent;
    }

    /* renamed from: a */
    private static void m32580a(Context context, Bundle bundle) {
        if (C5529q.m23544b(bundle)) {
            if ((Integer.parseInt(bundle.getString("pri", AppEventsConstants.EVENT_PARAM_VALUE_NO)) > 9 ? 1 : null) != null || VERSION.SDK_INT < 26) {
                try {
                    m32584c(context, bundle);
                } catch (IllegalStateException e) {
                    if (VERSION.SDK_INT >= 21) {
                        m32582b(context, bundle);
                    } else {
                        throw e;
                    }
                }
            }
            m32582b(context, bundle);
            return;
        }
        C5529q.m23534a(context, m32577a(bundle, C5506i.m23453a()), null);
    }

    @TargetApi(21)
    /* renamed from: b */
    private static void m32582b(Context context, Bundle bundle) {
        bundle = m32577a(bundle, C5506i.m23453a());
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new Builder(new SecureRandom().nextInt(), new ComponentName(context.getPackageName(), GcmIntentJobService.class.getName())).setOverrideDeadline(0).setExtras((PersistableBundle) bundle.mo4961a()).build());
    }

    /* renamed from: c */
    private static void m32584c(Context context, Bundle bundle) {
        a_(context, new Intent().replaceExtras((Bundle) m32577a(bundle, new C6961h()).mo4961a()).setComponent(new ComponentName(context.getPackageName(), GcmIntentService.class.getName())));
    }

    /* renamed from: a */
    private static C5505g m32577a(Bundle bundle, C5505g c5505g) {
        c5505g.mo4964a("json_payload", C5529q.m23532a(bundle).toString());
        c5505g.mo4963a("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return c5505g;
    }
}
