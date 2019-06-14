package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.C0383g;
import android.util.Base64;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.iid.C3075u;

@Deprecated
public class GcmReceiver extends C0383g {
    /* renamed from: a */
    private static boolean f11790a = false;
    /* renamed from: b */
    private static C3075u f11791b;
    /* renamed from: c */
    private static C3075u f11792c;

    public void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        int i = 0;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (isOrderedBroadcast()) {
            setResultCode(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        }
        Object obj = (!C2904o.m8466l() || context.getApplicationInfo().targetSdkVersion < 26) ? null : 1;
        if ((intent.getFlags() & 268435456) != 0) {
            i = 1;
        }
        if (obj == null || r1 != 0) {
            int c;
            if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
                c = m14705c(context, intent);
            } else {
                c = m14705c(context, intent);
            }
            if (C2904o.m8466l() && c == 402) {
                m14704b(context, intent);
                context = 403;
            } else {
                context = c;
            }
        } else {
            context = m14704b(context, intent);
        }
        if (isOrderedBroadcast() != null) {
            setResultCode(context);
        }
    }

    /* renamed from: b */
    private final int m14704b(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Binding to service");
        }
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
        m14703a(context, intent.getAction()).m8995a(intent, goAsync());
        return -1;
    }

    /* renamed from: a */
    private final synchronized C3075u m14703a(Context context, String str) {
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (f11792c == null) {
                f11792c = new C3075u(context, str);
            }
            return f11792c;
        }
        if (f11791b == null) {
            f11791b = new C3075u(context, str);
        }
        return f11791b;
    }

    /* renamed from: c */
    private static int m14705c(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Starting service");
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            if (resolveService.serviceInfo != null) {
                String str;
                String valueOf;
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    if (serviceInfo.name != null) {
                        str = serviceInfo.name;
                        if (str.startsWith(".")) {
                            valueOf = String.valueOf(context.getPackageName());
                            str = String.valueOf(str);
                            str = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
                        }
                        if (Log.isLoggable("GcmReceiver", 3)) {
                            String str2 = "GcmReceiver";
                            valueOf = "Restricting intent to a specific service: ";
                            String valueOf2 = String.valueOf(str);
                            Log.d(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                        }
                        intent.setClassName(context.getPackageName(), str);
                        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                            context = C0383g.a_(context, intent);
                        } else {
                            context = context.startService(intent);
                            Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
                        }
                        if (context == null) {
                            return -1;
                        }
                        Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
                        return HttpStatus.HTTP_NOT_FOUND;
                    }
                }
                valueOf = serviceInfo.packageName;
                str = serviceInfo.name;
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(str).length());
                stringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                stringBuilder.append(valueOf);
                stringBuilder.append("/");
                stringBuilder.append(str);
                Log.e("GcmReceiver", stringBuilder.toString());
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    context = context.startService(intent);
                    Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
                } else {
                    context = C0383g.a_(context, intent);
                }
                if (context == null) {
                    return -1;
                }
                Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
                return HttpStatus.HTTP_NOT_FOUND;
            }
        }
        Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                context = C0383g.a_(context, intent);
            } else {
                context = context.startService(intent);
                Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            }
            if (context == null) {
                return -1;
            }
            Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        } catch (Context context2) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", context2);
            return 401;
        } catch (Context context22) {
            context22 = String.valueOf(context22);
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(context22).length() + 45);
            stringBuilder2.append("Failed to start service while in background: ");
            stringBuilder2.append(context22);
            Log.e("GcmReceiver", stringBuilder2.toString());
            return 402;
        }
    }
}
