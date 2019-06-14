package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.app.ac.C0279d;
import android.widget.RemoteViews;
import com.facebook.ads.internal.p088c.C1354a;
import com.facebook.react.uimanager.UIManagerModuleConstants;
import com.facebook.react.uimanager.ViewProps;
import com.onesignal.C5503e.C5501c;
import com.onesignal.am.C5464i;
import com.onesignal.az.C5485a;
import com.onesignal.az.C5486b;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GenerateNotification */
/* renamed from: com.onesignal.l */
class C5512l {
    /* renamed from: a */
    private static Context f18534a;
    /* renamed from: b */
    private static String f18535b;
    /* renamed from: c */
    private static Resources f18536c;
    /* renamed from: d */
    private static Class<?> f18537d;
    /* renamed from: e */
    private static boolean f18538e;

    /* compiled from: GenerateNotification */
    /* renamed from: com.onesignal.l$a */
    private static class C5511a {
        /* renamed from: a */
        C0279d f18532a;
        /* renamed from: b */
        boolean f18533b;

        private C5511a() {
        }
    }

    /* renamed from: d */
    private static int m23487d(int i) {
        return i > 9 ? 2 : i > 7 ? 1 : i > 4 ? 0 : i > 2 ? -1 : -2;
    }

    /* renamed from: a */
    private static void m23462a(Context context) {
        f18534a = context;
        f18535b = f18534a.getPackageName();
        f18536c = f18534a.getResources();
        context = f18534a.getPackageManager();
        Intent intent = new Intent(f18534a, NotificationOpenedReceiver.class);
        intent.setPackage(f18534a.getPackageName());
        if (context.queryBroadcastReceivers(intent, 0).size() > null) {
            f18538e = true;
            f18537d = NotificationOpenedReceiver.class;
            return;
        }
        f18537d = C5539u.class;
    }

    /* renamed from: a */
    static void m23468a(C5538t c5538t) {
        C5512l.m23462a(c5538t.f18576a);
        if (c5538t.f18578c || !c5538t.f18579d || C5440a.f18258b == null) {
            C5512l.m23490d(c5538t);
        } else {
            C5512l.m23471a(c5538t.f18577b, C5440a.f18258b, c5538t.m23565c().intValue());
        }
    }

    /* renamed from: a */
    private static void m23471a(final JSONObject jSONObject, final Activity activity, final int i) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                Builder builder = new Builder(activity);
                builder.setTitle(C5512l.m23478b(jSONObject));
                builder.setMessage(jSONObject.optString("alert"));
                List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                C5512l.m23479b(activity, jSONObject, arrayList, arrayList2);
                final Intent a = C5512l.m23476b(i);
                a.putExtra("action_button", true);
                a.putExtra("from_alert", true);
                a.putExtra("onesignal_data", jSONObject.toString());
                if (jSONObject.has("grp")) {
                    a.putExtra("grp", jSONObject.optString("grp"));
                }
                OnClickListener c55081 = new OnClickListener(this) {
                    /* renamed from: c */
                    final /* synthetic */ C55101 f18526c;

                    public void onClick(android.content.DialogInterface r3, int r4) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r2 = this;
                        r4 = r4 + 3;
                        r3 = r2;
                        r3 = r3.size();
                        r0 = 1;
                        if (r3 <= r0) goto L_0x0038;
                    L_0x000b:
                        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0041 }
                        r0 = r2.f18526c;	 Catch:{ Throwable -> 0x0041 }
                        r0 = r1;	 Catch:{ Throwable -> 0x0041 }
                        r0 = r0.toString();	 Catch:{ Throwable -> 0x0041 }
                        r3.<init>(r0);	 Catch:{ Throwable -> 0x0041 }
                        r0 = "actionSelected";	 Catch:{ Throwable -> 0x0041 }
                        r1 = r2;	 Catch:{ Throwable -> 0x0041 }
                        r4 = r1.get(r4);	 Catch:{ Throwable -> 0x0041 }
                        r3.put(r0, r4);	 Catch:{ Throwable -> 0x0041 }
                        r4 = r3;	 Catch:{ Throwable -> 0x0041 }
                        r0 = "onesignal_data";	 Catch:{ Throwable -> 0x0041 }
                        r3 = r3.toString();	 Catch:{ Throwable -> 0x0041 }
                        r4.putExtra(r0, r3);	 Catch:{ Throwable -> 0x0041 }
                        r3 = r2.f18526c;	 Catch:{ Throwable -> 0x0041 }
                        r3 = r2;	 Catch:{ Throwable -> 0x0041 }
                        r4 = r3;	 Catch:{ Throwable -> 0x0041 }
                        com.onesignal.C5540v.m23573b(r3, r4);	 Catch:{ Throwable -> 0x0041 }
                        goto L_0x0041;
                    L_0x0038:
                        r3 = r2.f18526c;
                        r3 = r2;
                        r4 = r3;
                        com.onesignal.C5540v.m23573b(r3, r4);
                    L_0x0041:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.1.1.onClick(android.content.DialogInterface, int):void");
                    }
                };
                builder.setOnCancelListener(new OnCancelListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C55101 f18528b;

                    public void onCancel(DialogInterface dialogInterface) {
                        C5540v.m23573b(activity, a);
                    }
                });
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i == 0) {
                        builder.setNeutralButton((CharSequence) arrayList.get(i), c55081);
                    } else if (i == 1) {
                        builder.setNegativeButton((CharSequence) arrayList.get(i), c55081);
                    } else if (i == 2) {
                        builder.setPositiveButton((CharSequence) arrayList.get(i), c55081);
                    }
                }
                AlertDialog create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.show();
            }
        });
    }

    /* renamed from: b */
    private static CharSequence m23478b(JSONObject jSONObject) {
        jSONObject = jSONObject.optString("title", null);
        if (jSONObject != null) {
            return jSONObject;
        }
        return f18534a.getPackageManager().getApplicationLabel(f18534a.getApplicationInfo());
    }

    /* renamed from: a */
    private static PendingIntent m23454a(int i, Intent intent) {
        if (f18538e) {
            return PendingIntent.getBroadcast(f18534a, i, intent, 134217728);
        }
        return PendingIntent.getActivity(f18534a, i, intent, 134217728);
    }

    /* renamed from: b */
    private static Intent m23476b(int i) {
        i = new Intent(f18534a, f18537d).putExtra("notificationId", i);
        if (f18538e) {
            return i;
        }
        return i.addFlags(603979776);
    }

    /* renamed from: c */
    private static Intent m23482c(int i) {
        i = new Intent(f18534a, f18537d).putExtra("notificationId", i).putExtra(UIManagerModuleConstants.ACTION_DISMISSED, true);
        if (f18538e) {
            return i;
        }
        return i.addFlags(402718720);
    }

    /* renamed from: c */
    private static com.onesignal.C5512l.C5511a m23485c(com.onesignal.C5538t r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r8.f18577b;
        r1 = new com.onesignal.l$a;
        r2 = 0;
        r1.<init>();
        r3 = com.onesignal.C5530r.m23552a(r8);	 Catch:{ Throwable -> 0x0014 }
        r4 = new android.support.v4.app.ac$d;	 Catch:{ Throwable -> 0x0014 }
        r5 = f18534a;	 Catch:{ Throwable -> 0x0014 }
        r4.<init>(r5, r3);	 Catch:{ Throwable -> 0x0014 }
        goto L_0x001b;
    L_0x0014:
        r4 = new android.support.v4.app.ac$d;
        r3 = f18534a;
        r4.<init>(r3);
    L_0x001b:
        r3 = "alert";
        r3 = r0.optString(r3, r2);
        r5 = 1;
        r6 = r4.d(r5);
        r7 = com.onesignal.C5512l.m23489d(r0);
        r6 = r6.a(r7);
        r7 = new android.support.v4.app.ac$c;
        r7.<init>();
        r7 = r7.a(r3);
        r6 = r6.a(r7);
        r6 = r6.b(r3);
        r6.c(r3);
        r6 = android.os.Build.VERSION.SDK_INT;
        r7 = 24;
        if (r6 < r7) goto L_0x0056;
    L_0x0048:
        r6 = "title";
        r6 = r0.optString(r6);
        r7 = "";
        r6 = r6.equals(r7);
        if (r6 != 0) goto L_0x005d;
    L_0x0056:
        r6 = com.onesignal.C5512l.m23478b(r0);
        r4.a(r6);
    L_0x005d:
        r6 = com.onesignal.C5512l.m23493f(r0);	 Catch:{ Throwable -> 0x006a }
        if (r6 == 0) goto L_0x006a;	 Catch:{ Throwable -> 0x006a }
    L_0x0063:
        r6 = r6.intValue();	 Catch:{ Throwable -> 0x006a }
        r4.e(r6);	 Catch:{ Throwable -> 0x006a }
    L_0x006a:
        r6 = "vis";	 Catch:{ Throwable -> 0x0081 }
        r6 = r0.has(r6);	 Catch:{ Throwable -> 0x0081 }
        if (r6 == 0) goto L_0x007d;	 Catch:{ Throwable -> 0x0081 }
    L_0x0072:
        r6 = "vis";	 Catch:{ Throwable -> 0x0081 }
        r6 = r0.optString(r6);	 Catch:{ Throwable -> 0x0081 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x0081 }
        goto L_0x007e;	 Catch:{ Throwable -> 0x0081 }
    L_0x007d:
        r6 = 1;	 Catch:{ Throwable -> 0x0081 }
    L_0x007e:
        r4.f(r6);	 Catch:{ Throwable -> 0x0081 }
    L_0x0081:
        r6 = com.onesignal.C5512l.m23484c(r0);
        if (r6 == 0) goto L_0x008c;
    L_0x0087:
        r1.f18533b = r5;
        r4.a(r6);
    L_0x008c:
        r5 = "bicon";
        r2 = r0.optString(r5, r2);
        r2 = com.onesignal.C5512l.m23483c(r2);
        if (r2 == 0) goto L_0x00a8;
    L_0x0098:
        r5 = new android.support.v4.app.ac$b;
        r5.<init>();
        r2 = r5.a(r2);
        r2 = r2.a(r3);
        r4.a(r2);
    L_0x00a8:
        r2 = r8.f18580e;
        if (r2 == 0) goto L_0x00b9;
    L_0x00ac:
        r8 = r8.f18580e;	 Catch:{ Throwable -> 0x00b9 }
        r2 = r8.longValue();	 Catch:{ Throwable -> 0x00b9 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Throwable -> 0x00b9 }
        r2 = r2 * r5;	 Catch:{ Throwable -> 0x00b9 }
        r4.a(r2);	 Catch:{ Throwable -> 0x00b9 }
    L_0x00b9:
        com.onesignal.C5512l.m23472a(r0, r4);
        r1.f18532a = r4;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.c(com.onesignal.t):com.onesignal.l$a");
    }

    /* renamed from: a */
    private static void m23472a(org.json.JSONObject r6, android.support.v4.app.ac.C0279d r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "pri";
        r1 = 6;
        r0 = r6.optInt(r0, r1);
        r0 = com.onesignal.C5512l.m23487d(r0);
        r7.d(r0);
        r1 = 0;
        r2 = 1;
        if (r0 >= 0) goto L_0x0014;
    L_0x0012:
        r0 = 1;
        goto L_0x0015;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        if (r0 == 0) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r0 = "ledc";
        r0 = r6.has(r0);
        r3 = 4;
        if (r0 == 0) goto L_0x0044;
    L_0x0021:
        r0 = "led";
        r0 = r6.optInt(r0, r2);
        if (r0 != r2) goto L_0x0044;
    L_0x0029:
        r0 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x0043 }
        r4 = "ledc";	 Catch:{ Throwable -> 0x0043 }
        r4 = r6.optString(r4);	 Catch:{ Throwable -> 0x0043 }
        r5 = 16;	 Catch:{ Throwable -> 0x0043 }
        r0.<init>(r4, r5);	 Catch:{ Throwable -> 0x0043 }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x0043 }
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;	 Catch:{ Throwable -> 0x0043 }
        r5 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ Throwable -> 0x0043 }
        r7.a(r0, r4, r5);	 Catch:{ Throwable -> 0x0043 }
        r3 = 0;
        goto L_0x0044;
    L_0x0044:
        r0 = f18534a;
        r0 = com.onesignal.am.m23208d(r0);
        if (r0 == 0) goto L_0x0068;
    L_0x004c:
        r0 = "vib";
        r0 = r6.optInt(r0, r2);
        if (r0 != r2) goto L_0x0068;
    L_0x0054:
        r0 = "vib_pt";
        r0 = r6.has(r0);
        if (r0 == 0) goto L_0x0066;
    L_0x005c:
        r0 = com.onesignal.al.m23094a(r6);
        if (r0 == 0) goto L_0x0068;
    L_0x0062:
        r7.a(r0);
        goto L_0x0068;
    L_0x0066:
        r3 = r3 | 2;
    L_0x0068:
        r0 = com.onesignal.C5512l.m23492e(r6);
        if (r0 == 0) goto L_0x0083;
    L_0x006e:
        r0 = f18534a;
        r1 = "sound";
        r2 = 0;
        r6 = r6.optString(r1, r2);
        r6 = com.onesignal.al.m23096b(r0, r6);
        if (r6 == 0) goto L_0x0081;
    L_0x007d:
        r7.a(r6);
        goto L_0x0083;
    L_0x0081:
        r3 = r3 | 1;
    L_0x0083:
        r7.c(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.a(org.json.JSONObject, android.support.v4.app.ac$d):void");
    }

    /* renamed from: a */
    private static void m23464a(C0279d c0279d) {
        c0279d.c(true).c(0).a(null).a(null).c(null);
    }

    /* renamed from: d */
    private static void m23490d(com.onesignal.C5538t r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.security.SecureRandom;
        r0.<init>();
        r1 = r9.m23565c();
        r1 = r1.intValue();
        r2 = r9.f18577b;
        r3 = "grp";
        r4 = 0;
        r3 = r2.optString(r3, r4);
        r5 = com.onesignal.C5512l.m23485c(r9);
        r6 = r5.f18532a;
        com.onesignal.C5512l.m23473a(r2, r6, r1, r4);
        com.onesignal.C5512l.m23481b(r2, r6);	 Catch:{ Throwable -> 0x0023 }
        goto L_0x002b;
    L_0x0023:
        r4 = move-exception;
        r7 = com.onesignal.am.C5464i.ERROR;
        r8 = "Could not set background notification image!";
        com.onesignal.am.m23161a(r7, r8, r4);
    L_0x002b:
        com.onesignal.C5512l.m23469a(r9, r6);
        r4 = r9.f18578c;
        if (r4 == 0) goto L_0x0035;
    L_0x0032:
        com.onesignal.C5512l.m23464a(r6);
    L_0x0035:
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r4 = r0.nextInt();
        r7 = com.onesignal.C5512l.m23476b(r1);
        r8 = "onesignal_data";
        r2 = r2.toString();
        r2 = r7.putExtra(r8, r2);
        r7 = "grp";
        r2 = r2.putExtra(r7, r3);
        r2 = com.onesignal.C5512l.m23454a(r4, r2);
        r6.a(r2);
        r0 = r0.nextInt();
        r2 = com.onesignal.C5512l.m23482c(r1);
        r4 = "grp";
        r2 = r2.putExtra(r4, r3);
        r0 = com.onesignal.C5512l.m23454a(r0, r2);
        r6.b(r0);
        r6.a(r3);
        r0 = 1;
        r6.g(r0);	 Catch:{ Throwable -> 0x0072 }
    L_0x0072:
        r0 = com.onesignal.C5512l.m23475b(r9, r6);
        com.onesignal.C5512l.m23470a(r9, r5);
        goto L_0x00a6;
    L_0x007a:
        r9 = r0.nextInt();
        r4 = com.onesignal.C5512l.m23476b(r1);
        r7 = "onesignal_data";
        r2 = r2.toString();
        r2 = r4.putExtra(r7, r2);
        r9 = com.onesignal.C5512l.m23454a(r9, r2);
        r6.a(r9);
        r9 = r0.nextInt();
        r0 = com.onesignal.C5512l.m23482c(r1);
        r9 = com.onesignal.C5512l.m23454a(r9, r0);
        r6.b(r9);
        r0 = r6.a();
    L_0x00a6:
        if (r3 == 0) goto L_0x00ae;
    L_0x00a8:
        r9 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r9 <= r2) goto L_0x00ba;
    L_0x00ae:
        com.onesignal.C5512l.m23467a(r5, r0);
        r9 = f18534a;
        r9 = android.support.v4.app.af.a(r9);
        r9.a(r1, r0);
    L_0x00ba:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.d(com.onesignal.t):void");
    }

    /* renamed from: a */
    private static void m23469a(C5538t c5538t, C0279d c0279d) {
        if (c5538t.f18587l != null) {
            if (c5538t.f18587l.f18569a != null) {
                try {
                    Field declaredField = C0279d.class.getDeclaredField("M");
                    declaredField.setAccessible(true);
                    Notification notification = (Notification) declaredField.get(c0279d);
                    c5538t.f18585j = Integer.valueOf(notification.flags);
                    c5538t.f18586k = notification.sound;
                    c0279d.a(c5538t.f18587l.f18569a);
                    Notification notification2 = (Notification) declaredField.get(c0279d);
                    Field declaredField2 = C0279d.class.getDeclaredField("d");
                    declaredField2.setAccessible(true);
                    CharSequence charSequence = (CharSequence) declaredField2.get(c0279d);
                    Field declaredField3 = C0279d.class.getDeclaredField("c");
                    declaredField3.setAccessible(true);
                    CharSequence charSequence2 = (CharSequence) declaredField3.get(c0279d);
                    c5538t.f18581f = charSequence;
                    c5538t.f18582g = charSequence2;
                    if (c5538t.f18578c == null) {
                        c5538t.f18584i = Integer.valueOf(notification2.flags);
                        c5538t.f18583h = notification2.sound;
                    }
                } catch (C5538t c5538t2) {
                    c5538t2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private static Notification m23475b(C5538t c5538t, C0279d c0279d) {
        Object obj = (VERSION.SDK_INT <= 17 || VERSION.SDK_INT >= 24 || c5538t.f18578c) ? null : 1;
        if (!(obj == null || c5538t.f18583h == null || c5538t.f18583h.equals(c5538t.f18586k))) {
            c0279d.a(null);
        }
        Notification a = c0279d.a();
        if (obj != null) {
            c0279d.a(c5538t.f18583h);
        }
        return a;
    }

    /* renamed from: a */
    private static void m23467a(com.onesignal.C5512l.C5511a r3, android.app.Notification r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = r3.f18533b;
        if (r3 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r3 = "android.app.MiuiNotification";	 Catch:{ Throwable -> 0x0034 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0034 }
        r3 = r3.newInstance();	 Catch:{ Throwable -> 0x0034 }
        r0 = r3.getClass();	 Catch:{ Throwable -> 0x0034 }
        r1 = "customizedIcon";	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0034 }
        r1 = 1;	 Catch:{ Throwable -> 0x0034 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0034 }
        r2 = java.lang.Boolean.valueOf(r1);	 Catch:{ Throwable -> 0x0034 }
        r0.set(r3, r2);	 Catch:{ Throwable -> 0x0034 }
        r0 = r4.getClass();	 Catch:{ Throwable -> 0x0034 }
        r2 = "extraNotification";	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.getField(r2);	 Catch:{ Throwable -> 0x0034 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0034 }
        r0.set(r4, r3);	 Catch:{ Throwable -> 0x0034 }
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.a(com.onesignal.l$a, android.app.Notification):void");
    }

    /* renamed from: b */
    static void m23480b(C5538t c5538t) {
        C5512l.m23462a(c5538t.f18576a);
        C5512l.m23470a(c5538t, null);
    }

    /* renamed from: a */
    private static void m23470a(com.onesignal.C5538t r19, com.onesignal.C5512l.C5511a r20) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r19;
        r2 = r20;
        r3 = r1.f18578c;
        r4 = r1.f18577b;
        r0 = "grp";
        r5 = 0;
        r6 = r4.optString(r0, r5);
        r7 = new java.security.SecureRandom;
        r7.<init>();
        r0 = r7.nextInt();
        r8 = 0;
        r9 = com.onesignal.C5512l.m23482c(r8);
        r10 = "summary";
        r9 = r9.putExtra(r10, r6);
        r9 = com.onesignal.C5512l.m23454a(r0, r9);
        r0 = f18534a;
        r10 = com.onesignal.ao.m23264a(r0);
        r11 = r10.m23267b();	 Catch:{ all -> 0x02bf }
        r0 = "android_notification_id";	 Catch:{ all -> 0x02bf }
        r12 = "full_data";	 Catch:{ all -> 0x02bf }
        r13 = "is_summary";	 Catch:{ all -> 0x02bf }
        r14 = "title";	 Catch:{ all -> 0x02bf }
        r15 = "message";	 Catch:{ all -> 0x02bf }
        r13 = new java.lang.String[]{r0, r12, r13, r14, r15};	 Catch:{ all -> 0x02bf }
        r0 = "group_id = ? AND dismissed = 0 AND opened = 0";	 Catch:{ all -> 0x02bf }
        r15 = 1;	 Catch:{ all -> 0x02bf }
        r14 = new java.lang.String[r15];	 Catch:{ all -> 0x02bf }
        r14[r8] = r6;	 Catch:{ all -> 0x02bf }
        if (r3 != 0) goto L_0x006b;	 Catch:{ all -> 0x02bf }
    L_0x0048:
        r12 = r19.m23565c();	 Catch:{ all -> 0x02bf }
        r12 = r12.intValue();	 Catch:{ all -> 0x02bf }
        r15 = -1;	 Catch:{ all -> 0x02bf }
        if (r12 == r15) goto L_0x006b;	 Catch:{ all -> 0x02bf }
    L_0x0053:
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02bf }
        r12.<init>();	 Catch:{ all -> 0x02bf }
        r12.append(r0);	 Catch:{ all -> 0x02bf }
        r0 = " AND android_notification_id <> ";	 Catch:{ all -> 0x02bf }
        r12.append(r0);	 Catch:{ all -> 0x02bf }
        r0 = r19.m23565c();	 Catch:{ all -> 0x02bf }
        r12.append(r0);	 Catch:{ all -> 0x02bf }
        r0 = r12.toString();	 Catch:{ all -> 0x02bf }
    L_0x006b:
        r12 = "notification";	 Catch:{ all -> 0x02bf }
        r16 = 0;	 Catch:{ all -> 0x02bf }
        r17 = 0;	 Catch:{ all -> 0x02bf }
        r18 = "_id DESC";	 Catch:{ all -> 0x02bf }
        r15 = r14;
        r14 = r0;
        r5 = 1;
        r11 = r11.query(r12, r13, r14, r15, r16, r17, r18);	 Catch:{ all -> 0x02bc }
        r0 = r11.moveToFirst();	 Catch:{ all -> 0x02ba }
        if (r0 == 0) goto L_0x011d;	 Catch:{ all -> 0x02ba }
    L_0x0080:
        r12 = new java.util.ArrayList;	 Catch:{ all -> 0x02ba }
        r12.<init>();	 Catch:{ all -> 0x02ba }
        r0 = 0;	 Catch:{ all -> 0x02ba }
        r13 = 0;	 Catch:{ all -> 0x02ba }
    L_0x0087:
        r14 = "is_summary";	 Catch:{ all -> 0x02ba }
        r14 = r11.getColumnIndex(r14);	 Catch:{ all -> 0x02ba }
        r14 = r11.getInt(r14);	 Catch:{ all -> 0x02ba }
        if (r14 != r5) goto L_0x00a2;	 Catch:{ all -> 0x02ba }
    L_0x0093:
        r13 = "android_notification_id";	 Catch:{ all -> 0x02ba }
        r13 = r11.getColumnIndex(r13);	 Catch:{ all -> 0x02ba }
        r13 = r11.getInt(r13);	 Catch:{ all -> 0x02ba }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x02ba }
        goto L_0x0103;	 Catch:{ all -> 0x02ba }
    L_0x00a2:
        r14 = "title";	 Catch:{ all -> 0x02ba }
        r14 = r11.getColumnIndex(r14);	 Catch:{ all -> 0x02ba }
        r14 = r11.getString(r14);	 Catch:{ all -> 0x02ba }
        if (r14 != 0) goto L_0x00b1;	 Catch:{ all -> 0x02ba }
    L_0x00ae:
        r14 = "";	 Catch:{ all -> 0x02ba }
        goto L_0x00c2;	 Catch:{ all -> 0x02ba }
    L_0x00b1:
        r15 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ba }
        r15.<init>();	 Catch:{ all -> 0x02ba }
        r15.append(r14);	 Catch:{ all -> 0x02ba }
        r14 = " ";	 Catch:{ all -> 0x02ba }
        r15.append(r14);	 Catch:{ all -> 0x02ba }
        r14 = r15.toString();	 Catch:{ all -> 0x02ba }
    L_0x00c2:
        r15 = "message";	 Catch:{ all -> 0x02ba }
        r15 = r11.getColumnIndex(r15);	 Catch:{ all -> 0x02ba }
        r15 = r11.getString(r15);	 Catch:{ all -> 0x02ba }
        r8 = new android.text.SpannableString;	 Catch:{ all -> 0x02ba }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ba }
        r5.<init>();	 Catch:{ all -> 0x02ba }
        r5.append(r14);	 Catch:{ all -> 0x02ba }
        r5.append(r15);	 Catch:{ all -> 0x02ba }
        r5 = r5.toString();	 Catch:{ all -> 0x02ba }
        r8.<init>(r5);	 Catch:{ all -> 0x02ba }
        r5 = r14.length();	 Catch:{ all -> 0x02ba }
        if (r5 <= 0) goto L_0x00f4;	 Catch:{ all -> 0x02ba }
    L_0x00e6:
        r5 = new android.text.style.StyleSpan;	 Catch:{ all -> 0x02ba }
        r15 = 1;	 Catch:{ all -> 0x02ba }
        r5.<init>(r15);	 Catch:{ all -> 0x02ba }
        r14 = r14.length();	 Catch:{ all -> 0x02ba }
        r15 = 0;	 Catch:{ all -> 0x02ba }
        r8.setSpan(r5, r15, r14, r15);	 Catch:{ all -> 0x02ba }
    L_0x00f4:
        r12.add(r8);	 Catch:{ all -> 0x02ba }
        if (r0 != 0) goto L_0x0103;	 Catch:{ all -> 0x02ba }
    L_0x00f9:
        r0 = "full_data";	 Catch:{ all -> 0x02ba }
        r0 = r11.getColumnIndex(r0);	 Catch:{ all -> 0x02ba }
        r0 = r11.getString(r0);	 Catch:{ all -> 0x02ba }
    L_0x0103:
        r5 = r11.moveToNext();	 Catch:{ all -> 0x02ba }
        if (r5 != 0) goto L_0x0119;
    L_0x0109:
        if (r3 == 0) goto L_0x011f;
    L_0x010b:
        if (r0 == 0) goto L_0x011f;
    L_0x010d:
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0114 }
        r5.<init>(r0);	 Catch:{ JSONException -> 0x0114 }
        r4 = r5;
        goto L_0x011f;
    L_0x0114:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x02ba }
        goto L_0x011f;
    L_0x0119:
        r5 = 1;
        r8 = 0;
        goto L_0x0087;
    L_0x011d:
        r12 = 0;
        r13 = 0;
    L_0x011f:
        if (r11 == 0) goto L_0x012a;
    L_0x0121:
        r0 = r11.isClosed();
        if (r0 != 0) goto L_0x012a;
    L_0x0127:
        r11.close();
    L_0x012a:
        if (r13 != 0) goto L_0x013b;
    L_0x012c:
        r0 = r7.nextInt();
        r13 = java.lang.Integer.valueOf(r0);
        r0 = r13.intValue();
        com.onesignal.C5512l.m23466a(r10, r6, r0);
    L_0x013b:
        r0 = r7.nextInt();
        r5 = r13.intValue();
        r5 = com.onesignal.C5512l.m23456a(r5, r4, r6);
        r0 = com.onesignal.C5512l.m23454a(r0, r5);
        if (r12 == 0) goto L_0x0280;
    L_0x014d:
        if (r3 == 0) goto L_0x0156;
    L_0x014f:
        r5 = r12.size();
        r7 = 1;
        if (r5 > r7) goto L_0x015e;
    L_0x0156:
        if (r3 != 0) goto L_0x0280;
    L_0x0158:
        r5 = r12.size();
        if (r5 <= 0) goto L_0x0280;
    L_0x015e:
        r2 = r12.size();
        r5 = r3 ^ 1;
        r2 = r2 + r5;
        r5 = "grp_msg";
        r11 = 0;
        r4 = r4.optString(r5, r11);
        if (r4 != 0) goto L_0x0180;
    L_0x016e:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r2);
        r5 = " new messages";
        r4.append(r5);
        r4 = r4.toString();
        goto L_0x0197;
    L_0x0180:
        r5 = "$[notif_count]";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "";
        r7.append(r8);
        r7.append(r2);
        r7 = r7.toString();
        r4 = r4.replace(r5, r7);
    L_0x0197:
        r5 = com.onesignal.C5512l.m23485c(r19);
        r5 = r5.f18532a;
        if (r3 == 0) goto L_0x01a3;
    L_0x019f:
        com.onesignal.C5512l.m23464a(r5);
        goto L_0x01b9;
    L_0x01a3:
        r7 = r1.f18583h;
        if (r7 == 0) goto L_0x01ac;
    L_0x01a7:
        r7 = r1.f18583h;
        r5.a(r7);
    L_0x01ac:
        r7 = r1.f18584i;
        if (r7 == 0) goto L_0x01b9;
    L_0x01b0:
        r7 = r1.f18584i;
        r7 = r7.intValue();
        r5.c(r7);
    L_0x01b9:
        r0 = r5.a(r0);
        r0 = r0.b(r9);
        r7 = f18534a;
        r7 = r7.getPackageManager();
        r8 = f18534a;
        r8 = r8.getApplicationInfo();
        r7 = r7.getApplicationLabel(r8);
        r0 = r0.a(r7);
        r0 = r0.b(r4);
        r0 = r0.b(r2);
        r2 = com.onesignal.C5512l.m23474b();
        r0 = r0.a(r2);
        r2 = com.onesignal.C5512l.m23457a();
        r0 = r0.a(r2);
        r0 = r0.c(r3);
        r0 = r0.a(r6);
        r2 = 1;
        r0.f(r2);
        r5.g(r2);	 Catch:{ Throwable -> 0x01fc }
    L_0x01fc:
        if (r3 != 0) goto L_0x0201;
    L_0x01fe:
        r5.c(r4);
    L_0x0201:
        r0 = new android.support.v4.app.ac$f;
        r0.<init>();
        if (r3 != 0) goto L_0x0261;
    L_0x0208:
        r2 = r19.m23562a();
        if (r2 == 0) goto L_0x0217;
    L_0x020e:
        r2 = r19.m23562a();
        r2 = r2.toString();
        goto L_0x0218;
    L_0x0217:
        r2 = r11;
    L_0x0218:
        if (r2 != 0) goto L_0x021d;
    L_0x021a:
        r2 = "";
        goto L_0x022e;
    L_0x021d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r2);
        r2 = " ";
        r3.append(r2);
        r2 = r3.toString();
    L_0x022e:
        r1 = r19.m23564b();
        r1 = r1.toString();
        r3 = new android.text.SpannableString;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r6.append(r2);
        r6.append(r1);
        r1 = r6.toString();
        r3.<init>(r1);
        r1 = r2.length();
        if (r1 <= 0) goto L_0x025e;
    L_0x0250:
        r1 = new android.text.style.StyleSpan;
        r6 = 1;
        r1.<init>(r6);
        r2 = r2.length();
        r6 = 0;
        r3.setSpan(r1, r6, r2, r6);
    L_0x025e:
        r0.b(r3);
    L_0x0261:
        r1 = r12.iterator();
    L_0x0265:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0275;
    L_0x026b:
        r2 = r1.next();
        r2 = (android.text.SpannableString) r2;
        r0.b(r2);
        goto L_0x0265;
    L_0x0275:
        r0.a(r4);
        r5.a(r0);
        r0 = r5.a();
        goto L_0x02ac;
    L_0x0280:
        r1 = r2.f18532a;
        r5 = r1.f705b;
        r5.clear();
        r5 = r13.intValue();
        com.onesignal.C5512l.m23473a(r4, r1, r5, r6);
        r0 = r1.a(r0);
        r0 = r0.b(r9);
        r0 = r0.c(r3);
        r0 = r0.a(r6);
        r3 = 1;
        r0.f(r3);
        r1.g(r3);	 Catch:{ Throwable -> 0x02a5 }
    L_0x02a5:
        r0 = r1.a();
        com.onesignal.C5512l.m23467a(r2, r0);
    L_0x02ac:
        r1 = f18534a;
        r1 = android.support.v4.app.af.a(r1);
        r2 = r13.intValue();
        r1.a(r2, r0);
        return;
    L_0x02ba:
        r0 = move-exception;
        goto L_0x02c1;
    L_0x02bc:
        r0 = move-exception;
        r11 = 0;
        goto L_0x02c1;
    L_0x02bf:
        r0 = move-exception;
        r11 = r5;
    L_0x02c1:
        if (r11 == 0) goto L_0x02cc;
    L_0x02c3:
        r1 = r11.isClosed();
        if (r1 != 0) goto L_0x02cc;
    L_0x02c9:
        r11.close();
    L_0x02cc:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.a(com.onesignal.t, com.onesignal.l$a):void");
    }

    /* renamed from: a */
    private static Intent m23456a(int i, JSONObject jSONObject, String str) {
        return C5512l.m23476b(i).putExtra("onesignal_data", jSONObject.toString()).putExtra("summary", str);
    }

    /* renamed from: a */
    private static void m23466a(ao aoVar, String str, int i) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            aoVar = aoVar.m23266a();
            try {
                aoVar.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("android_notification_id", Integer.valueOf(i));
                contentValues.put("group_id", str);
                contentValues.put("is_summary", Integer.valueOf(1));
                aoVar.insertOrThrow("notification", null, contentValues);
                aoVar.setTransactionSuccessful();
                if (aoVar != null) {
                    try {
                        aoVar.endTransaction();
                    } catch (Throwable th2) {
                        am.m23161a(C5464i.ERROR, "Error closing transaction! ", th2);
                    }
                }
            } catch (Throwable th3) {
                str = th3;
                if (aoVar != null) {
                    aoVar.endTransaction();
                }
                throw str;
            }
        } catch (Throwable th4) {
            th = th4;
            am.m23161a(C5464i.ERROR, "Error adding summary notification record! ", th);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* renamed from: b */
    private static void m23481b(JSONObject jSONObject, C0279d c0279d) {
        if (VERSION.SDK_INT >= 16) {
            JSONObject jSONObject2;
            Bitmap c;
            String optString = jSONObject.optString("bg_img", null);
            if (optString != null) {
                jSONObject2 = new JSONObject(optString);
                c = C5512l.m23483c(jSONObject2.optString("img", null));
            } else {
                c = null;
                jSONObject2 = c;
            }
            if (c == null) {
                c = C5512l.m23459a("onesignal_bgimage_default_image");
            }
            if (c != null) {
                RemoteViews remoteViews = new RemoteViews(f18534a.getPackageName(), C5486b.onesignal_bgimage_notif_layout);
                remoteViews.setTextViewText(C5485a.os_bgimage_notif_title, C5512l.m23478b(jSONObject));
                remoteViews.setTextViewText(C5485a.os_bgimage_notif_body, jSONObject.optString("alert"));
                C5512l.m23465a(remoteViews, jSONObject2, C5485a.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
                C5512l.m23465a(remoteViews, jSONObject2, C5485a.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
                if (jSONObject2 == null || jSONObject2.has("img_align") == null) {
                    jSONObject = f18536c.getIdentifier("onesignal_bgimage_notif_image_align", "string", f18535b);
                    jSONObject = jSONObject != null ? f18536c.getString(jSONObject) : null;
                } else {
                    jSONObject = jSONObject2.getString("img_align");
                }
                if (ViewProps.RIGHT.equals(jSONObject) != null) {
                    remoteViews.setViewPadding(C5485a.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                    remoteViews.setImageViewBitmap(C5485a.os_bgimage_notif_bgimage_right_aligned, c);
                    remoteViews.setViewVisibility(C5485a.os_bgimage_notif_bgimage_right_aligned, 0);
                    remoteViews.setViewVisibility(C5485a.os_bgimage_notif_bgimage, 2);
                } else {
                    remoteViews.setImageViewBitmap(C5485a.os_bgimage_notif_bgimage, c);
                }
                c0279d.a(remoteViews);
                c0279d.a(null);
            }
        }
    }

    /* renamed from: a */
    private static void m23465a(RemoteViews remoteViews, JSONObject jSONObject, int i, String str, String str2) {
        jSONObject = C5512l.m23461a(jSONObject, str);
        if (jSONObject != null) {
            remoteViews.setTextColor(i, jSONObject.intValue());
            return;
        }
        int identifier = f18536c.getIdentifier(str2, ViewProps.COLOR, f18535b);
        if (identifier != null) {
            remoteViews.setTextColor(i, C5501c.m23438a(f18534a, identifier));
        }
    }

    /* renamed from: a */
    private static java.lang.Integer m23461a(org.json.JSONObject r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x001c;
    L_0x0002:
        r0 = r1.has(r2);	 Catch:{ Throwable -> 0x001c }
        if (r0 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x001c }
    L_0x0008:
        r0 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x001c }
        r1 = r1.optString(r2);	 Catch:{ Throwable -> 0x001c }
        r2 = 16;	 Catch:{ Throwable -> 0x001c }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x001c }
        r1 = r0.intValue();	 Catch:{ Throwable -> 0x001c }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x001c }
        return r1;
    L_0x001c:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.a(org.json.JSONObject, java.lang.String):java.lang.Integer");
    }

    /* renamed from: c */
    private static Bitmap m23484c(JSONObject jSONObject) {
        Bitmap c = C5512l.m23483c(jSONObject.optString("licon"));
        if (c == null) {
            c = C5512l.m23459a("ic_onesignal_large_icon_default");
        }
        if (c == null) {
            return null;
        }
        return C5512l.m23458a(c);
    }

    /* renamed from: a */
    private static Bitmap m23457a() {
        return C5512l.m23458a(C5512l.m23459a("ic_onesignal_large_icon_default"));
    }

    /* renamed from: a */
    private static android.graphics.Bitmap m23458a(android.graphics.Bitmap r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 != 0) goto L_0x0004;
    L_0x0002:
        r4 = 0;
        return r4;
    L_0x0004:
        r0 = f18536c;	 Catch:{ Throwable -> 0x003d }
        r1 = 17104902; // 0x1050006 float:2.442826E-38 double:8.4509445E-317;	 Catch:{ Throwable -> 0x003d }
        r0 = r0.getDimension(r1);	 Catch:{ Throwable -> 0x003d }
        r0 = (int) r0;	 Catch:{ Throwable -> 0x003d }
        r1 = f18536c;	 Catch:{ Throwable -> 0x003d }
        r2 = 17104901; // 0x1050005 float:2.4428256E-38 double:8.450944E-317;	 Catch:{ Throwable -> 0x003d }
        r1 = r1.getDimension(r2);	 Catch:{ Throwable -> 0x003d }
        r1 = (int) r1;	 Catch:{ Throwable -> 0x003d }
        r2 = r4.getHeight();	 Catch:{ Throwable -> 0x003d }
        r3 = r4.getWidth();	 Catch:{ Throwable -> 0x003d }
        if (r3 > r1) goto L_0x0024;	 Catch:{ Throwable -> 0x003d }
    L_0x0022:
        if (r2 <= r0) goto L_0x003d;	 Catch:{ Throwable -> 0x003d }
    L_0x0024:
        if (r2 <= r3) goto L_0x002e;	 Catch:{ Throwable -> 0x003d }
    L_0x0026:
        r1 = (float) r3;	 Catch:{ Throwable -> 0x003d }
        r2 = (float) r2;	 Catch:{ Throwable -> 0x003d }
        r1 = r1 / r2;	 Catch:{ Throwable -> 0x003d }
        r2 = (float) r0;	 Catch:{ Throwable -> 0x003d }
        r2 = r2 * r1;	 Catch:{ Throwable -> 0x003d }
        r1 = (int) r2;	 Catch:{ Throwable -> 0x003d }
        goto L_0x0037;	 Catch:{ Throwable -> 0x003d }
    L_0x002e:
        if (r3 <= r2) goto L_0x0037;	 Catch:{ Throwable -> 0x003d }
    L_0x0030:
        r0 = (float) r2;	 Catch:{ Throwable -> 0x003d }
        r2 = (float) r3;	 Catch:{ Throwable -> 0x003d }
        r0 = r0 / r2;	 Catch:{ Throwable -> 0x003d }
        r2 = (float) r1;	 Catch:{ Throwable -> 0x003d }
        r2 = r2 * r0;	 Catch:{ Throwable -> 0x003d }
        r0 = (int) r2;	 Catch:{ Throwable -> 0x003d }
    L_0x0037:
        r2 = 1;	 Catch:{ Throwable -> 0x003d }
        r0 = android.graphics.Bitmap.createScaledBitmap(r4, r1, r0, r2);	 Catch:{ Throwable -> 0x003d }
        return r0;
    L_0x003d:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.a(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static android.graphics.Bitmap m23459a(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = f18534a;	 Catch:{ Throwable -> 0x0010 }
        r1 = r1.getAssets();	 Catch:{ Throwable -> 0x0010 }
        r1 = r1.open(r7);	 Catch:{ Throwable -> 0x0010 }
        r1 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r1 = r0;
    L_0x0011:
        if (r1 == 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r2 = ".png";	 Catch:{ Throwable -> 0x0064 }
        r3 = ".webp";	 Catch:{ Throwable -> 0x0064 }
        r4 = ".jpg";	 Catch:{ Throwable -> 0x0064 }
        r5 = ".gif";	 Catch:{ Throwable -> 0x0064 }
        r6 = ".bmp";	 Catch:{ Throwable -> 0x0064 }
        r2 = new java.lang.String[]{r2, r3, r4, r5, r6};	 Catch:{ Throwable -> 0x0064 }
        r2 = java.util.Arrays.asList(r2);	 Catch:{ Throwable -> 0x0064 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x0064 }
    L_0x002a:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x0064 }
        if (r3 == 0) goto L_0x0057;	 Catch:{ Throwable -> 0x0064 }
    L_0x0030:
        r3 = r2.next();	 Catch:{ Throwable -> 0x0064 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0064 }
        r4 = f18534a;	 Catch:{ Throwable -> 0x0054 }
        r4 = r4.getAssets();	 Catch:{ Throwable -> 0x0054 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0054 }
        r5.<init>();	 Catch:{ Throwable -> 0x0054 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0054 }
        r5.append(r3);	 Catch:{ Throwable -> 0x0054 }
        r3 = r5.toString();	 Catch:{ Throwable -> 0x0054 }
        r3 = r4.open(r3);	 Catch:{ Throwable -> 0x0054 }
        r3 = android.graphics.BitmapFactory.decodeStream(r3);	 Catch:{ Throwable -> 0x0054 }
        r1 = r3;
    L_0x0054:
        if (r1 == 0) goto L_0x002a;
    L_0x0056:
        return r1;
    L_0x0057:
        r7 = com.onesignal.C5512l.m23488d(r7);	 Catch:{ Throwable -> 0x0064 }
        if (r7 == 0) goto L_0x0064;	 Catch:{ Throwable -> 0x0064 }
    L_0x005d:
        r1 = f18536c;	 Catch:{ Throwable -> 0x0064 }
        r7 = android.graphics.BitmapFactory.decodeResource(r1, r7);	 Catch:{ Throwable -> 0x0064 }
        return r7;
    L_0x0064:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.a(java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: b */
    private static Bitmap m23477b(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            am.m23161a(C5464i.WARN, "Could not download image!", th);
            return null;
        }
    }

    /* renamed from: c */
    private static Bitmap m23483c(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (!trim.startsWith("http://")) {
            if (!trim.startsWith("https://")) {
                return C5512l.m23459a(str);
            }
        }
        return C5512l.m23477b(trim);
    }

    /* renamed from: d */
    private static int m23488d(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r3.trim();
        r2 = com.onesignal.al.m23097b(r1);
        if (r2 != 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r1 = com.onesignal.C5512l.m23491e(r1);
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r1;
    L_0x0016:
        r1 = android.R.drawable.class;	 Catch:{ Throwable -> 0x0022 }
        r3 = r1.getField(r3);	 Catch:{ Throwable -> 0x0022 }
        r1 = 0;	 Catch:{ Throwable -> 0x0022 }
        r3 = r3.getInt(r1);	 Catch:{ Throwable -> 0x0022 }
        return r3;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.d(java.lang.String):int");
    }

    /* renamed from: d */
    private static int m23489d(JSONObject jSONObject) {
        jSONObject = C5512l.m23488d(jSONObject.optString("sicon", null));
        if (jSONObject != null) {
            return jSONObject;
        }
        return C5512l.m23474b();
    }

    /* renamed from: b */
    private static int m23474b() {
        int e = C5512l.m23491e("ic_stat_onesignal_default");
        if (e != 0) {
            return e;
        }
        e = C5512l.m23491e("corona_statusbar_icon_default");
        if (e != 0) {
            return e;
        }
        e = C5512l.m23491e("ic_os_notification_fallback_white_24dp");
        return e != 0 ? e : 17301598;
    }

    /* renamed from: e */
    private static int m23491e(String str) {
        return f18536c.getIdentifier(str, "drawable", f18535b);
    }

    /* renamed from: e */
    private static boolean m23492e(JSONObject jSONObject) {
        jSONObject = jSONObject.optString("sound", null);
        if (!"null".equals(jSONObject)) {
            if ("nil".equals(jSONObject) == null) {
                return am.m23214e(f18534a);
            }
        }
        return null;
    }

    /* renamed from: f */
    private static java.math.BigInteger m23493f(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r1 = 0;
        r2 = "bgac";	 Catch:{ Throwable -> 0x0017 }
        r2 = r4.has(r2);	 Catch:{ Throwable -> 0x0017 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Throwable -> 0x0017 }
    L_0x000b:
        r2 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x0017 }
        r3 = "bgac";	 Catch:{ Throwable -> 0x0017 }
        r4 = r4.optString(r3, r1);	 Catch:{ Throwable -> 0x0017 }
        r2.<init>(r4, r0);	 Catch:{ Throwable -> 0x0017 }
        return r2;
    L_0x0017:
        r4 = f18534a;	 Catch:{ Throwable -> 0x0027 }
        r2 = "com.onesignal.NotificationAccentColor.DEFAULT";	 Catch:{ Throwable -> 0x0027 }
        r4 = com.onesignal.al.m23086a(r4, r2);	 Catch:{ Throwable -> 0x0027 }
        if (r4 == 0) goto L_0x0027;	 Catch:{ Throwable -> 0x0027 }
    L_0x0021:
        r2 = new java.math.BigInteger;	 Catch:{ Throwable -> 0x0027 }
        r2.<init>(r4, r0);	 Catch:{ Throwable -> 0x0027 }
        return r2;
    L_0x0027:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.l.f(org.json.JSONObject):java.math.BigInteger");
    }

    /* renamed from: a */
    private static void m23473a(JSONObject jSONObject, C0279d c0279d, int i, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            if (jSONObject2.has(C1354a.f3934a)) {
                jSONObject2 = jSONObject2.getJSONObject(C1354a.f3934a);
                if (jSONObject2.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("actionButtons");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                        Intent b = C5512l.m23476b(i);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("");
                        stringBuilder.append(i2);
                        b.setAction(stringBuilder.toString());
                        b.putExtra("action_button", true);
                        jSONObject3.put("actionSelected", optJSONObject.optString("id"));
                        b.putExtra("onesignal_data", jSONObject3.toString());
                        if (str != null) {
                            b.putExtra("summary", str);
                        } else if (jSONObject.has("grp")) {
                            b.putExtra("grp", jSONObject.optString("grp"));
                        }
                        c0279d.a(optJSONObject.has("icon") ? C5512l.m23488d(optJSONObject.optString("icon")) : 0, optJSONObject.optString("text"), C5512l.m23454a(i, b));
                    }
                }
            }
        } catch (JSONObject jSONObject4) {
            jSONObject4.printStackTrace();
        }
    }

    /* renamed from: b */
    private static void m23479b(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            C5512l.m23486c(context, jSONObject, list, list2);
        } catch (Throwable th) {
            am.m23161a(C5464i.ERROR, "Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (list.size() == null || list.size() < 3) {
            list.add(al.m23087a(context, "onesignal_in_app_alert_ok_button_text", "Ok"));
            list2.add("__DEFAULT__");
        }
    }

    /* renamed from: c */
    private static void m23486c(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        context = new JSONObject(jSONObject.optString("custom"));
        if (context.has(C1354a.f3934a) != null) {
            context = context.getJSONObject(C1354a.f3934a);
            if (context.has("actionButtons") != null) {
                context = context.optJSONArray("actionButtons");
                for (jSONObject = null; jSONObject < context.length(); jSONObject++) {
                    JSONObject jSONObject2 = context.getJSONObject(jSONObject);
                    list.add(jSONObject2.optString("text"));
                    list2.add(jSONObject2.optString("id"));
                }
            }
        }
    }
}
