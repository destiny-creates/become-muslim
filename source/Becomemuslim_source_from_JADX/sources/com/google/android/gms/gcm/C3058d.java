package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.ac.C0279d;
import android.support.v4.app.ac.C3171c;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.gcm.C3057c.C3056a;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.gcm.d */
final class C3058d {
    /* renamed from: a */
    static C3058d f7790a;
    /* renamed from: b */
    private final Context f7791b;
    /* renamed from: c */
    private String f7792c;
    /* renamed from: d */
    private final AtomicInteger f7793d = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: a */
    static synchronized C3058d m8926a(Context context) {
        synchronized (C3058d.class) {
            if (f7790a == null) {
                f7790a = new C3058d(context);
            }
            context = f7790a;
        }
        return context;
    }

    /* renamed from: a */
    static String m8927a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private C3058d(Context context) {
        this.f7791b = context.getApplicationContext();
    }

    /* renamed from: a */
    final boolean m8929a(Bundle bundle) {
        int identifier;
        Object a;
        String a2;
        String str;
        Uri uri;
        Object a3;
        Intent intent;
        PendingIntent pendingIntent;
        String a4;
        NotificationManager notificationManager;
        StringBuilder stringBuilder;
        C0279d a5;
        Notification a6;
        NotificationManager notificationManager2;
        long uptimeMillis;
        StringBuilder stringBuilder2;
        Bundle bundle2;
        CharSequence b = m8928b(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(b)) {
            b = this.f7791b.getApplicationInfo().loadLabel(this.f7791b.getPackageManager());
        }
        CharSequence b2 = m8928b(bundle, "gcm.n.body");
        String a7 = C3058d.m8927a(bundle, "gcm.n.icon");
        if (!TextUtils.isEmpty(a7)) {
            Resources resources = this.f7791b.getResources();
            identifier = resources.getIdentifier(a7, "drawable", this.f7791b.getPackageName());
            if (identifier == 0) {
                identifier = resources.getIdentifier(a7, "mipmap", this.f7791b.getPackageName());
                if (identifier == 0) {
                    StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(a7).length() + 57);
                    stringBuilder3.append("Icon resource ");
                    stringBuilder3.append(a7);
                    stringBuilder3.append(" not found. Notification will use app icon.");
                    Log.w("GcmNotification", stringBuilder3.toString());
                }
            }
            a = C3058d.m8927a(bundle, "gcm.n.color");
            a2 = C3058d.m8927a(bundle, "gcm.n.sound2");
            str = null;
            if (TextUtils.isEmpty(a2)) {
                uri = null;
            } else if (!"default".equals(a2) || this.f7791b.getResources().getIdentifier(a2, "raw", this.f7791b.getPackageName()) == 0) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String packageName = this.f7791b.getPackageName();
                StringBuilder stringBuilder4 = new StringBuilder((String.valueOf(packageName).length() + 24) + String.valueOf(a2).length());
                stringBuilder4.append("android.resource://");
                stringBuilder4.append(packageName);
                stringBuilder4.append("/raw/");
                stringBuilder4.append(a2);
                uri = Uri.parse(stringBuilder4.toString());
            }
            a3 = C3058d.m8927a(bundle, "gcm.n.click_action");
            if (TextUtils.isEmpty(a3)) {
                intent = new Intent(a3);
                intent.setPackage(this.f7791b.getPackageName());
                intent.setFlags(268435456);
            } else {
                intent = this.f7791b.getPackageManager().getLaunchIntentForPackage(this.f7791b.getPackageName());
                if (intent == null) {
                    Log.w("GcmNotification", "No activity found to launch app");
                    pendingIntent = null;
                    a4 = C3058d.m8927a(bundle, "gcm.n.android_channel_id");
                    if (C2904o.m8466l()) {
                        if (this.f7791b.getApplicationInfo().targetSdkVersion >= 26) {
                            notificationManager = (NotificationManager) this.f7791b.getSystemService(NotificationManager.class);
                            if (!TextUtils.isEmpty(a4)) {
                                if (notificationManager.getNotificationChannel(a4) == null) {
                                    str = a4;
                                } else {
                                    stringBuilder = new StringBuilder(String.valueOf(a4).length() + 122);
                                    stringBuilder.append("Notification Channel requested (");
                                    stringBuilder.append(a4);
                                    stringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                                    Log.w("GcmNotification", stringBuilder.toString());
                                }
                            }
                            if (this.f7792c == null) {
                                str = this.f7792c;
                            } else {
                                this.f7792c = m8925a().getString("com.google.android.gms.gcm.default_notification_channel_id");
                                if (TextUtils.isEmpty(this.f7792c)) {
                                    Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                                } else if (notificationManager.getNotificationChannel(this.f7792c) == null) {
                                    str = this.f7792c;
                                } else {
                                    Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                                }
                                if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                                    notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.f7791b.getString(C3056a.gcm_fallback_notification_channel_label), 3));
                                }
                                this.f7792c = "fcm_fallback_notification_channel";
                                str = this.f7792c;
                            }
                        }
                    }
                    a5 = new C0279d(this.f7791b).m796d(true).m772a(identifier);
                    if (!TextUtils.isEmpty(b)) {
                        a5.m783a(b);
                    }
                    if (!TextUtils.isEmpty(b2)) {
                        a5.m789b(b2);
                        a5.m781a(new C3171c().m9438a(b2));
                    }
                    if (!TextUtils.isEmpty(a)) {
                        a5.m797e(Color.parseColor(a));
                    }
                    if (uri != null) {
                        a5.m778a(uri);
                    }
                    if (pendingIntent != null) {
                        a5.m776a(pendingIntent);
                    }
                    if (str != null) {
                        a5.m790b(str);
                    }
                    a6 = a5.m771a();
                    bundle = C3058d.m8927a(bundle, "gcm.n.tag");
                    if (Log.isLoggable("GcmNotification", 3)) {
                        Log.d("GcmNotification", "Showing notification");
                    }
                    notificationManager2 = (NotificationManager) this.f7791b.getSystemService("notification");
                    if (TextUtils.isEmpty(bundle)) {
                        uptimeMillis = SystemClock.uptimeMillis();
                        stringBuilder2 = new StringBuilder(37);
                        stringBuilder2.append("GCM-Notification:");
                        stringBuilder2.append(uptimeMillis);
                        bundle = stringBuilder2.toString();
                    }
                    notificationManager2.notify(bundle, 0, a6);
                    return true;
                }
            }
            bundle2 = new Bundle(bundle);
            C4426a.m14706a(bundle2);
            intent.putExtras(bundle2);
            for (String str2 : bundle2.keySet()) {
                if (!str2.startsWith("gcm.n.") || str2.startsWith("gcm.notification.")) {
                    intent.removeExtra(str2);
                }
            }
            pendingIntent = PendingIntent.getActivity(this.f7791b, this.f7793d.getAndIncrement(), intent, 1073741824);
            a4 = C3058d.m8927a(bundle, "gcm.n.android_channel_id");
            if (C2904o.m8466l()) {
                if (this.f7791b.getApplicationInfo().targetSdkVersion >= 26) {
                    notificationManager = (NotificationManager) this.f7791b.getSystemService(NotificationManager.class);
                    if (TextUtils.isEmpty(a4)) {
                        if (notificationManager.getNotificationChannel(a4) == null) {
                            stringBuilder = new StringBuilder(String.valueOf(a4).length() + 122);
                            stringBuilder.append("Notification Channel requested (");
                            stringBuilder.append(a4);
                            stringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                            Log.w("GcmNotification", stringBuilder.toString());
                        } else {
                            str = a4;
                        }
                    }
                    if (this.f7792c == null) {
                        this.f7792c = m8925a().getString("com.google.android.gms.gcm.default_notification_channel_id");
                        if (TextUtils.isEmpty(this.f7792c)) {
                            Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(this.f7792c) == null) {
                            Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        } else {
                            str = this.f7792c;
                        }
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.f7791b.getString(C3056a.gcm_fallback_notification_channel_label), 3));
                        }
                        this.f7792c = "fcm_fallback_notification_channel";
                        str = this.f7792c;
                    } else {
                        str = this.f7792c;
                    }
                }
            }
            a5 = new C0279d(this.f7791b).m796d(true).m772a(identifier);
            if (TextUtils.isEmpty(b)) {
                a5.m783a(b);
            }
            if (TextUtils.isEmpty(b2)) {
                a5.m789b(b2);
                a5.m781a(new C3171c().m9438a(b2));
            }
            if (TextUtils.isEmpty(a)) {
                a5.m797e(Color.parseColor(a));
            }
            if (uri != null) {
                a5.m778a(uri);
            }
            if (pendingIntent != null) {
                a5.m776a(pendingIntent);
            }
            if (str != null) {
                a5.m790b(str);
            }
            a6 = a5.m771a();
            bundle = C3058d.m8927a(bundle, "gcm.n.tag");
            if (Log.isLoggable("GcmNotification", 3)) {
                Log.d("GcmNotification", "Showing notification");
            }
            notificationManager2 = (NotificationManager) this.f7791b.getSystemService("notification");
            if (TextUtils.isEmpty(bundle)) {
                uptimeMillis = SystemClock.uptimeMillis();
                stringBuilder2 = new StringBuilder(37);
                stringBuilder2.append("GCM-Notification:");
                stringBuilder2.append(uptimeMillis);
                bundle = stringBuilder2.toString();
            }
            notificationManager2.notify(bundle, 0, a6);
            return true;
        }
        int i = this.f7791b.getApplicationInfo().icon;
        identifier = i == 0 ? 17301651 : i;
        a = C3058d.m8927a(bundle, "gcm.n.color");
        a2 = C3058d.m8927a(bundle, "gcm.n.sound2");
        str = null;
        if (TextUtils.isEmpty(a2)) {
            uri = null;
        } else {
            if ("default".equals(a2)) {
            }
            uri = RingtoneManager.getDefaultUri(2);
        }
        a3 = C3058d.m8927a(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(a3)) {
            intent = this.f7791b.getPackageManager().getLaunchIntentForPackage(this.f7791b.getPackageName());
            if (intent == null) {
                Log.w("GcmNotification", "No activity found to launch app");
                pendingIntent = null;
                a4 = C3058d.m8927a(bundle, "gcm.n.android_channel_id");
                if (C2904o.m8466l()) {
                    if (this.f7791b.getApplicationInfo().targetSdkVersion >= 26) {
                        notificationManager = (NotificationManager) this.f7791b.getSystemService(NotificationManager.class);
                        if (TextUtils.isEmpty(a4)) {
                            if (notificationManager.getNotificationChannel(a4) == null) {
                                str = a4;
                            } else {
                                stringBuilder = new StringBuilder(String.valueOf(a4).length() + 122);
                                stringBuilder.append("Notification Channel requested (");
                                stringBuilder.append(a4);
                                stringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                                Log.w("GcmNotification", stringBuilder.toString());
                            }
                        }
                        if (this.f7792c == null) {
                            str = this.f7792c;
                        } else {
                            this.f7792c = m8925a().getString("com.google.android.gms.gcm.default_notification_channel_id");
                            if (TextUtils.isEmpty(this.f7792c)) {
                                Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                            } else if (notificationManager.getNotificationChannel(this.f7792c) == null) {
                                str = this.f7792c;
                            } else {
                                Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                            }
                            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.f7791b.getString(C3056a.gcm_fallback_notification_channel_label), 3));
                            }
                            this.f7792c = "fcm_fallback_notification_channel";
                            str = this.f7792c;
                        }
                    }
                }
                a5 = new C0279d(this.f7791b).m796d(true).m772a(identifier);
                if (TextUtils.isEmpty(b)) {
                    a5.m783a(b);
                }
                if (TextUtils.isEmpty(b2)) {
                    a5.m789b(b2);
                    a5.m781a(new C3171c().m9438a(b2));
                }
                if (TextUtils.isEmpty(a)) {
                    a5.m797e(Color.parseColor(a));
                }
                if (uri != null) {
                    a5.m778a(uri);
                }
                if (pendingIntent != null) {
                    a5.m776a(pendingIntent);
                }
                if (str != null) {
                    a5.m790b(str);
                }
                a6 = a5.m771a();
                bundle = C3058d.m8927a(bundle, "gcm.n.tag");
                if (Log.isLoggable("GcmNotification", 3)) {
                    Log.d("GcmNotification", "Showing notification");
                }
                notificationManager2 = (NotificationManager) this.f7791b.getSystemService("notification");
                if (TextUtils.isEmpty(bundle)) {
                    uptimeMillis = SystemClock.uptimeMillis();
                    stringBuilder2 = new StringBuilder(37);
                    stringBuilder2.append("GCM-Notification:");
                    stringBuilder2.append(uptimeMillis);
                    bundle = stringBuilder2.toString();
                }
                notificationManager2.notify(bundle, 0, a6);
                return true;
            }
        }
        intent = new Intent(a3);
        intent.setPackage(this.f7791b.getPackageName());
        intent.setFlags(268435456);
        bundle2 = new Bundle(bundle);
        C4426a.m14706a(bundle2);
        intent.putExtras(bundle2);
        for (String str22 : bundle2.keySet()) {
            if (str22.startsWith("gcm.n.")) {
            }
            intent.removeExtra(str22);
        }
        pendingIntent = PendingIntent.getActivity(this.f7791b, this.f7793d.getAndIncrement(), intent, 1073741824);
        a4 = C3058d.m8927a(bundle, "gcm.n.android_channel_id");
        if (C2904o.m8466l()) {
            if (this.f7791b.getApplicationInfo().targetSdkVersion >= 26) {
                notificationManager = (NotificationManager) this.f7791b.getSystemService(NotificationManager.class);
                if (TextUtils.isEmpty(a4)) {
                    if (notificationManager.getNotificationChannel(a4) == null) {
                        stringBuilder = new StringBuilder(String.valueOf(a4).length() + 122);
                        stringBuilder.append("Notification Channel requested (");
                        stringBuilder.append(a4);
                        stringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                        Log.w("GcmNotification", stringBuilder.toString());
                    } else {
                        str = a4;
                    }
                }
                if (this.f7792c == null) {
                    this.f7792c = m8925a().getString("com.google.android.gms.gcm.default_notification_channel_id");
                    if (TextUtils.isEmpty(this.f7792c)) {
                        Log.w("GcmNotification", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                    } else if (notificationManager.getNotificationChannel(this.f7792c) == null) {
                        Log.w("GcmNotification", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                    } else {
                        str = this.f7792c;
                    }
                    if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.f7791b.getString(C3056a.gcm_fallback_notification_channel_label), 3));
                    }
                    this.f7792c = "fcm_fallback_notification_channel";
                    str = this.f7792c;
                } else {
                    str = this.f7792c;
                }
            }
        }
        a5 = new C0279d(this.f7791b).m796d(true).m772a(identifier);
        if (TextUtils.isEmpty(b)) {
            a5.m783a(b);
        }
        if (TextUtils.isEmpty(b2)) {
            a5.m789b(b2);
            a5.m781a(new C3171c().m9438a(b2));
        }
        if (TextUtils.isEmpty(a)) {
            a5.m797e(Color.parseColor(a));
        }
        if (uri != null) {
            a5.m778a(uri);
        }
        if (pendingIntent != null) {
            a5.m776a(pendingIntent);
        }
        if (str != null) {
            a5.m790b(str);
        }
        a6 = a5.m771a();
        bundle = C3058d.m8927a(bundle, "gcm.n.tag");
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        notificationManager2 = (NotificationManager) this.f7791b.getSystemService("notification");
        if (TextUtils.isEmpty(bundle)) {
            uptimeMillis = SystemClock.uptimeMillis();
            stringBuilder2 = new StringBuilder(37);
            stringBuilder2.append("GCM-Notification:");
            stringBuilder2.append(uptimeMillis);
            bundle = stringBuilder2.toString();
        }
        notificationManager2.notify(bundle, 0, a6);
        return true;
    }

    /* renamed from: b */
    private final java.lang.String m8928b(android.os.Bundle r10, java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r9 = this;
        r0 = com.google.android.gms.gcm.C3058d.m8927a(r10, r11);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = java.lang.String.valueOf(r11);
        r1 = "_loc_key";
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x0020;
    L_0x001b:
        r0 = r0.concat(r1);
        goto L_0x0026;
    L_0x0020:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0026:
        r0 = com.google.android.gms.gcm.C3058d.m8927a(r10, r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x0032;
    L_0x0031:
        return r2;
    L_0x0032:
        r1 = r9.f7791b;
        r1 = r1.getResources();
        r3 = "string";
        r4 = r9.f7791b;
        r4 = r4.getPackageName();
        r3 = r1.getIdentifier(r0, r3, r4);
        r4 = 6;
        if (r3 != 0) goto L_0x0098;
    L_0x0047:
        r10 = "GcmNotification";
        r11 = java.lang.String.valueOf(r11);
        r1 = "_loc_key";
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x005e;
    L_0x0059:
        r11 = r11.concat(r1);
        goto L_0x0064;
    L_0x005e:
        r1 = new java.lang.String;
        r1.<init>(r11);
        r11 = r1;
    L_0x0064:
        r11 = r11.substring(r4);
        r1 = java.lang.String.valueOf(r11);
        r1 = r1.length();
        r1 = r1 + 49;
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r1 = r1 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r3.append(r11);
        r11 = " resource not found: ";
        r3.append(r11);
        r3.append(r0);
        r11 = " Default value will be used.";
        r3.append(r11);
        r11 = r3.toString();
        android.util.Log.w(r10, r11);
        return r2;
    L_0x0098:
        r5 = java.lang.String.valueOf(r11);
        r6 = "_loc_args";
        r6 = java.lang.String.valueOf(r6);
        r7 = r6.length();
        if (r7 == 0) goto L_0x00ad;
    L_0x00a8:
        r5 = r5.concat(r6);
        goto L_0x00b3;
    L_0x00ad:
        r6 = new java.lang.String;
        r6.<init>(r5);
        r5 = r6;
    L_0x00b3:
        r10 = com.google.android.gms.gcm.C3058d.m8927a(r10, r5);
        r5 = android.text.TextUtils.isEmpty(r10);
        if (r5 == 0) goto L_0x00c2;
    L_0x00bd:
        r10 = r1.getString(r3);
        return r10;
    L_0x00c2:
        r5 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        r5.<init>(r10);	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        r6 = r5.length();	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        r6 = new java.lang.String[r6];	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        r7 = 0;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
    L_0x00ce:
        r8 = r6.length;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        if (r7 >= r8) goto L_0x00da;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
    L_0x00d1:
        r8 = r5.opt(r7);	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        r6[r7] = r8;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        r7 = r7 + 1;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        goto L_0x00ce;	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
    L_0x00da:
        r1 = r1.getString(r3, r6);	 Catch:{ JSONException -> 0x0117, MissingFormatArgumentException -> 0x00df }
        return r1;
    L_0x00df:
        r11 = move-exception;
        r1 = "GcmNotification";
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r3 = r3 + 58;
        r4 = java.lang.String.valueOf(r10);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Missing format argument for ";
        r4.append(r3);
        r4.append(r0);
        r0 = ": ";
        r4.append(r0);
        r4.append(r10);
        r10 = " Default value will be used.";
        r4.append(r10);
        r10 = r4.toString();
        android.util.Log.w(r1, r10, r11);
        goto L_0x016d;
        r0 = "GcmNotification";
        r11 = java.lang.String.valueOf(r11);
        r1 = "_loc_args";
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x012f;
    L_0x012a:
        r11 = r11.concat(r1);
        goto L_0x0135;
    L_0x012f:
        r1 = new java.lang.String;
        r1.<init>(r11);
        r11 = r1;
    L_0x0135:
        r11 = r11.substring(r4);
        r1 = java.lang.String.valueOf(r11);
        r1 = r1.length();
        r1 = r1 + 41;
        r3 = java.lang.String.valueOf(r10);
        r3 = r3.length();
        r1 = r1 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r1 = "Malformed ";
        r3.append(r1);
        r3.append(r11);
        r11 = ": ";
        r3.append(r11);
        r3.append(r10);
        r10 = "  Default value will be used.";
        r3.append(r10);
        r10 = r3.toString();
        android.util.Log.w(r0, r10);
    L_0x016d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.d.b(android.os.Bundle, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private final android.os.Bundle m8925a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f7791b;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0013 }
        r1 = r3.f7791b;	 Catch:{ NameNotFoundException -> 0x0013 }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x0013 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.getApplicationInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r0 = 0;
    L_0x0014:
        if (r0 == 0) goto L_0x001d;
    L_0x0016:
        r1 = r0.metaData;
        if (r1 == 0) goto L_0x001d;
    L_0x001a:
        r0 = r0.metaData;
        return r0;
    L_0x001d:
        r0 = android.os.Bundle.EMPTY;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.d.a():android.os.Bundle");
    }
}
