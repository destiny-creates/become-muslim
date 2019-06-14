package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.C0383g;
import android.support.v4.util.C0463l;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.firebase.iid.y */
public final class C5370y {
    /* renamed from: b */
    private static C5370y f18132b;
    /* renamed from: a */
    final Queue<Intent> f18133a = new ArrayDeque();
    /* renamed from: c */
    private final C0463l<String, String> f18134c = new C0463l();
    /* renamed from: d */
    private Boolean f18135d = null;
    /* renamed from: e */
    private final Queue<Intent> f18136e = new ArrayDeque();

    /* renamed from: a */
    public static synchronized C5370y m22798a() {
        C5370y c5370y;
        synchronized (C5370y.class) {
            if (f18132b == null) {
                f18132b = new C5370y();
            }
            c5370y = f18132b;
        }
        return c5370y;
    }

    private C5370y() {
    }

    /* renamed from: a */
    public static PendingIntent m22797a(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, i, C5370y.m22800b(context, "com.google.firebase.MESSAGING_EVENT", intent), 1073741824);
    }

    /* renamed from: a */
    public static void m22799a(Context context, Intent intent) {
        context.sendBroadcast(C5370y.m22800b(context, "com.google.firebase.INSTANCE_ID_EVENT", intent));
    }

    /* renamed from: b */
    public static void m22801b(Context context, Intent intent) {
        context.sendBroadcast(C5370y.m22800b(context, "com.google.firebase.MESSAGING_EVENT", intent));
    }

    /* renamed from: b */
    private static Intent m22800b(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    /* renamed from: b */
    public final Intent m22804b() {
        return (Intent) this.f18136e.poll();
    }

    /* renamed from: a */
    public final int m22803a(Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String str2 = "FirebaseInstanceId";
            String str3 = "Starting service: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704) {
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                }
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            obj = null;
        }
        switch (obj) {
            case null:
                this.f18133a.offer(intent);
                break;
            case 1:
                this.f18136e.offer(intent);
                break;
            default:
                context = "FirebaseInstanceId";
                intent = "Unknown service action: ";
                str = String.valueOf(str);
                Log.w(context, str.length() != 0 ? intent.concat(str) : new String(intent));
                return HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
        }
        intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        return m22802c(context, intent);
    }

    /* renamed from: c */
    private final int m22802c(Context context, Intent intent) {
        String str;
        synchronized (this.f18134c) {
            str = (String) this.f18134c.get(intent.getAction());
        }
        boolean z = false;
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null) {
                if (resolveService.serviceInfo != null) {
                    ServiceInfo serviceInfo = resolveService.serviceInfo;
                    if (context.getPackageName().equals(serviceInfo.packageName)) {
                        if (serviceInfo.name != null) {
                            str = serviceInfo.name;
                            if (str.startsWith(".")) {
                                String valueOf = String.valueOf(context.getPackageName());
                                str = String.valueOf(str);
                                str = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
                            }
                            synchronized (this.f18134c) {
                                this.f18134c.put(intent.getAction(), str);
                            }
                        }
                    }
                    String str2 = serviceInfo.packageName;
                    str = serviceInfo.name;
                    StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 94) + String.valueOf(str).length());
                    stringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                    stringBuilder.append(str2);
                    stringBuilder.append("/");
                    stringBuilder.append(str);
                    Log.e("FirebaseInstanceId", stringBuilder.toString());
                    if (this.f18135d == null) {
                        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                            z = true;
                        }
                        this.f18135d = Boolean.valueOf(z);
                    }
                    if (this.f18135d.booleanValue()) {
                        context = C0383g.a_(context, intent);
                    } else {
                        context = context.startService(intent);
                        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                    }
                    if (context == null) {
                        return -1;
                    }
                    Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                    return HttpStatus.HTTP_NOT_FOUND;
                }
            }
            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            if (this.f18135d == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    z = true;
                }
                this.f18135d = Boolean.valueOf(z);
            }
            if (this.f18135d.booleanValue()) {
                context = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            } else {
                context = C0383g.a_(context, intent);
            }
            if (context == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            str2 = "Restricting intent to a specific service: ";
            String valueOf2 = String.valueOf(str);
            Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        intent.setClassName(context.getPackageName(), str);
        try {
            if (this.f18135d == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    z = true;
                }
                this.f18135d = Boolean.valueOf(z);
            }
            if (this.f18135d.booleanValue()) {
                context = C0383g.a_(context, intent);
            } else {
                context = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (context == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        } catch (Context context2) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", context2);
            return 401;
        } catch (Context context22) {
            context22 = String.valueOf(context22);
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(context22).length() + 45);
            stringBuilder2.append("Failed to start service while in background: ");
            stringBuilder2.append(context22);
            Log.e("FirebaseInstanceId", stringBuilder2.toString());
            return 402;
        }
    }
}
