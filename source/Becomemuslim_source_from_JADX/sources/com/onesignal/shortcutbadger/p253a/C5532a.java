package com.onesignal.shortcutbadger.p253a;

import android.content.Context;
import android.content.Intent;

/* compiled from: BroadcastHelper */
/* renamed from: com.onesignal.shortcutbadger.a.a */
public class C5532a {
    /* renamed from: a */
    public static boolean m23555a(Context context, Intent intent) {
        context = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (context == null || context.size() <= null) {
            return false;
        }
        return true;
    }
}
