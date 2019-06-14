package com.onesignal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: GooglePlayServicesUpgradePrompt */
/* renamed from: com.onesignal.n */
class C5517n {

    /* compiled from: GooglePlayServicesUpgradePrompt */
    /* renamed from: com.onesignal.n$1 */
    static class C55161 implements Runnable {

        /* compiled from: GooglePlayServicesUpgradePrompt */
        /* renamed from: com.onesignal.n$1$1 */
        class C55141 implements OnClickListener {
            /* renamed from: a */
            final /* synthetic */ C55161 f18541a;

            C55141(C55161 c55161) {
                this.f18541a = c55161;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                aq.m23280a(aq.f18435a, "GT_DO_NOT_SHOW_MISSING_GPS", true);
            }
        }

        C55161() {
        }

        public void run() {
            final Context context = C5440a.f18258b;
            if (context != null) {
                if (!am.f18408i.f18343d) {
                    CharSequence a = al.m23087a(context, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
                    CharSequence a2 = al.m23087a(context, "onesignal_gms_missing_alert_button_update", "Update");
                    CharSequence a3 = al.m23087a(context, "onesignal_gms_missing_alert_button_skip", "Skip");
                    new Builder(context).setMessage(a).setPositiveButton(a2, new OnClickListener(this) {
                        /* renamed from: b */
                        final /* synthetic */ C55161 f18543b;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            C5517n.m23500b(context);
                        }
                    }).setNegativeButton(a3, new C55141(this)).setNeutralButton(al.m23087a(context, "onesignal_gms_missing_alert_button_close", "Close"), null).create().show();
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m23498a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.onesignal.am.f18401b;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0013 }
        r1 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x0013 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0013 }
        r0 = r0.enabled;	 Catch:{ NameNotFoundException -> 0x0013 }
        return r0;
    L_0x0013:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.n.a():boolean");
    }

    /* renamed from: c */
    private static boolean m23501c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = com.onesignal.am.f18401b;	 Catch:{ Throwable -> 0x0023 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0023 }
        r2 = "com.google.android.gms";	 Catch:{ Throwable -> 0x0023 }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Throwable -> 0x0023 }
        r2 = r1.getPackageInfo(r2, r3);	 Catch:{ Throwable -> 0x0023 }
        r2 = r2.applicationInfo;	 Catch:{ Throwable -> 0x0023 }
        r1 = r2.loadLabel(r1);	 Catch:{ Throwable -> 0x0023 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0023 }
        if (r1 == 0) goto L_0x0022;	 Catch:{ Throwable -> 0x0023 }
    L_0x0019:
        r2 = "Market";	 Catch:{ Throwable -> 0x0023 }
        r1 = r1.equals(r2);	 Catch:{ Throwable -> 0x0023 }
        if (r1 != 0) goto L_0x0022;
    L_0x0021:
        r0 = 1;
    L_0x0022:
        return r0;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.n.c():boolean");
    }

    /* renamed from: b */
    static void m23499b() {
        if (!C5517n.m23498a()) {
            if (C5517n.m23501c()) {
                if (!aq.m23285b(aq.f18435a, "GT_DO_NOT_SHOW_MISSING_GPS", false)) {
                    al.m23090a(new C55161());
                }
            }
        }
    }

    /* renamed from: b */
    private static void m23500b(android.app.Activity r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.google.android.gms.common.C4361e.a();	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r1 = com.onesignal.am.f18401b;	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r1 = r0.a(r1);	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r2 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r3 = r0.a(r3, r1, r2);	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        r3.send();	 Catch:{ CanceledException -> 0x0018, Throwable -> 0x0014 }
        goto L_0x0018;
    L_0x0014:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0018:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.n.b(android.app.Activity):void");
    }
}
