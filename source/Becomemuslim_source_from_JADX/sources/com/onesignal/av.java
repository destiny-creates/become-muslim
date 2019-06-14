package com.onesignal;

import android.content.Context;
import com.onesignal.au.C5482a;

/* compiled from: PushRegistratorADM */
public class av implements au {
    /* renamed from: a */
    private static C5482a f24816a = null;
    /* renamed from: b */
    private static boolean f24817b = false;

    /* renamed from: a */
    public void mo4942a(final Context context, String str, final C5482a c5482a) {
        f24816a = c5482a;
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ av f18465c;

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r0 = new com.amazon.device.messaging.ADM;
                r1 = r2;
                r0.<init>(r1);
                r1 = r0.getRegistrationId();
                if (r1 != 0) goto L_0x0011;
            L_0x000d:
                r0.startRegister();
                goto L_0x002d;
            L_0x0011:
                r0 = com.onesignal.am.C5464i.DEBUG;
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "ADM Already registered with ID:";
                r2.append(r3);
                r2.append(r1);
                r2 = r2.toString();
                com.onesignal.am.m23187b(r0, r2);
                r0 = r4;
                r2 = 1;
                r0.mo4939a(r1, r2);
            L_0x002d:
                r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
                java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0032 }
            L_0x0032:
                r0 = com.onesignal.av.f24817b;
                if (r0 != 0) goto L_0x0043;
            L_0x0038:
                r0 = com.onesignal.am.C5464i.ERROR;
                r1 = "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.";
                com.onesignal.am.m23187b(r0, r1);
                r0 = 0;
                com.onesignal.av.m32609a(r0);
            L_0x0043:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.onesignal.av.1.run():void");
            }
        }).start();
    }

    /* renamed from: a */
    public static void m32609a(String str) {
        if (f24816a != null) {
            f24817b = true;
            f24816a.mo4939a(str, 1);
        }
    }
}
