package com.onesignal;

import com.google.firebase.C5335b;
import com.google.firebase.C5337c.C5336a;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: PushRegistratorFCM */
class ax extends aw {
    /* renamed from: a */
    private C5335b f29541a;

    /* renamed from: a */
    String mo6269a() {
        return "FCM";
    }

    ax() {
    }

    /* renamed from: a */
    static void m38542a(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "gcm_defaultSenderId";
        r1 = 0;
        r0 = com.onesignal.al.m23087a(r5, r0, r1);
        r1 = 1;
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 2;
        goto L_0x000d;
    L_0x000c:
        r0 = 1;
    L_0x000d:
        r2 = r5.getPackageManager();
        r3 = new android.content.ComponentName;	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
        r4 = com.google.firebase.iid.FirebaseInstanceIdService.class;	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
        r3.<init>(r5, r4);	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
        r2.setComponentEnabledSetting(r3, r0, r1);	 Catch:{ NoClassDefFoundError -> 0x001b, NoClassDefFoundError -> 0x001b }
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ax.a(android.content.Context):void");
    }

    /* renamed from: a */
    String mo6270a(String str) {
        m38543b(str);
        return FirebaseInstanceId.getInstance(this.f29541a).m22677a(str, "FCM");
    }

    /* renamed from: b */
    private void m38543b(String str) {
        if (this.f29541a == null) {
            this.f29541a = C5335b.m22600a(am.f18401b, new C5336a().m22620c(str).m22619b("OMIT_ID").m22617a("OMIT_KEY").m22618a(), "ONESIGNAL_SDK_FCM_APP_NAME");
        }
    }
}
