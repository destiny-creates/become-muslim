package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.C0383g;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.C2904o;

public final class FirebaseInstanceIdReceiver extends C0383g {
    /* renamed from: a */
    private static boolean f24731a = false;
    /* renamed from: b */
    private static ak f24732b;
    /* renamed from: c */
    private static ak f24733c;

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                m32378a(context, intent2, intent.getAction());
            } else {
                m32378a(context, intent, intent.getAction());
            }
        }
    }

    /* renamed from: a */
    private final void m32378a(Context context, Intent intent, String str) {
        String str2 = null;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (!"google.com/iid".equals(intent.getStringExtra("from"))) {
            if (!"com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
                if (!"com.google.android.c2dm.intent.RECEIVE".equals(str)) {
                    if ("com.google.firebase.MESSAGING_EVENT".equals(str) == null) {
                        Log.d("FirebaseInstanceId", "Unexpected intent");
                        str = -1;
                        if (str2 != null) {
                            str = m32376a(this, context, str2, intent);
                        }
                        if (isOrderedBroadcast() == null) {
                            setResultCode(str);
                        }
                    }
                }
                str2 = "com.google.firebase.MESSAGING_EVENT";
                str = -1;
                if (str2 != null) {
                    str = m32376a(this, context, str2, intent);
                }
                if (isOrderedBroadcast() == null) {
                    setResultCode(str);
                }
            }
        }
        str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        str = -1;
        if (str2 != null) {
            str = m32376a(this, context, str2, intent);
        }
        if (isOrderedBroadcast() == null) {
            setResultCode(str);
        }
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static int m32376a(BroadcastReceiver broadcastReceiver, Context context, String str, Intent intent) {
        Object obj = 1;
        Object obj2 = (!C2904o.l() || context.getApplicationInfo().targetSdkVersion < 26) ? null : 1;
        if ((intent.getFlags() & 268435456) == 0) {
            obj = null;
        }
        if (obj2 != null && r1 == null) {
            return m32379b(broadcastReceiver, context, str, intent);
        }
        int a = C5370y.m22798a().m22803a(context, str, intent);
        if (!C2904o.l() || a != 402) {
            return a;
        }
        m32379b(broadcastReceiver, context, str, intent);
        return 403;
    }

    /* renamed from: b */
    private static int m32379b(BroadcastReceiver broadcastReceiver, Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String str2 = "FirebaseInstanceId";
            String str3 = "Binding to service: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        m32377a(context, str).m22720a(intent, broadcastReceiver.goAsync());
        return -1;
    }

    /* renamed from: a */
    private static synchronized ak m32377a(Context context, String str) {
        synchronized (FirebaseInstanceIdReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (f24733c == null) {
                    f24733c = new ak(context, str);
                }
                context = f24733c;
                return context;
            }
            if (f24732b == null) {
                f24732b = new ak(context, str);
            }
            context = f24732b;
            return context;
        }
    }
}
