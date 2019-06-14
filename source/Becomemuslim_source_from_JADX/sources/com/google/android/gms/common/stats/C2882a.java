package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.C2894d;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.a */
public class C2882a {
    /* renamed from: a */
    private static final Object f7349a = new Object();
    /* renamed from: b */
    private static volatile C2882a f7350b;
    /* renamed from: c */
    private static boolean f7351c = false;
    /* renamed from: d */
    private final List<String> f7352d = Collections.EMPTY_LIST;
    /* renamed from: e */
    private final List<String> f7353e = Collections.EMPTY_LIST;
    /* renamed from: f */
    private final List<String> f7354f = Collections.EMPTY_LIST;
    /* renamed from: g */
    private final List<String> f7355g = Collections.EMPTY_LIST;

    /* renamed from: a */
    public static C2882a m8407a() {
        if (f7350b == null) {
            synchronized (f7349a) {
                if (f7350b == null) {
                    f7350b = new C2882a();
                }
            }
        }
        return f7350b;
    }

    private C2882a() {
    }

    /* renamed from: a */
    public final boolean m8410a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        str = intent.getComponent();
        if (str == null) {
            str = null;
        } else {
            str = C2894d.m8425b(context, str.getPackageName());
        }
        if (str == null) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    /* renamed from: a */
    public boolean m8409a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m8410a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    /* renamed from: a */
    public void m8408a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
