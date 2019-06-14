package com.onesignal;

import android.content.Context;
import com.onesignal.am.C5464i;
import com.onesignal.au.C5482a;

/* compiled from: PushRegistratorAbstractGoogle */
abstract class aw implements au {
    /* renamed from: b */
    private static int f24818b = 5;
    /* renamed from: c */
    private static int f24819c = 10000;
    /* renamed from: a */
    private C5482a f24820a;
    /* renamed from: d */
    private Thread f24821d;
    /* renamed from: e */
    private boolean f24822e;

    /* renamed from: a */
    abstract String mo6269a();

    /* renamed from: a */
    abstract String mo6270a(String str);

    aw() {
    }

    /* renamed from: a */
    public void mo4942a(Context context, String str, C5482a c5482a) {
        this.f24820a = c5482a;
        if (m32614a(str, c5482a) != null) {
            m32616b(str);
        }
    }

    /* renamed from: b */
    private void m32616b(String str) {
        try {
            if (C5517n.m23498a()) {
                m32618c(str);
                return;
            }
            C5517n.m23499b();
            am.m23187b(C5464i.ERROR, "'Google Play services' app not installed or disabled on the device.");
            this.f24820a.mo4939a(null, -7);
        } catch (Throwable th) {
            C5464i c5464i = C5464i.ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not register with ");
            stringBuilder.append(mo6269a());
            stringBuilder.append(" due to an issue with your AndroidManifest.xml or with 'Google Play services'.");
            am.m23161a(c5464i, stringBuilder.toString(), th);
            this.f24820a.mo4939a(null, -8);
        }
    }

    /* renamed from: c */
    private synchronized void m32618c(final String str) {
        if (this.f24821d == null || !this.f24821d.isAlive()) {
            this.f24821d = new Thread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ aw f18467b;

                public void run() {
                    int i = 0;
                    while (i < aw.f24818b && !this.f18467b.m32613a(str, i)) {
                        i++;
                        al.m23089a(aw.f24819c * i);
                    }
                }
            });
            this.f24821d.start();
        }
    }

    /* renamed from: a */
    private boolean m32613a(String str, int i) {
        C5464i c5464i;
        StringBuilder stringBuilder;
        C5464i c5464i2;
        StringBuilder stringBuilder2;
        try {
            str = mo6270a(str);
            c5464i = C5464i.INFO;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Device registered, push token = ");
            stringBuilder.append(str);
            am.m23187b(c5464i, stringBuilder.toString());
            this.f24820a.mo4939a(str, 1);
            return true;
        } catch (Throwable e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage())) {
                if (i >= f24818b - 1) {
                    c5464i2 = C5464i.ERROR;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Retry count of ");
                    stringBuilder3.append(f24818b);
                    stringBuilder3.append(" exceed! Could not get a ");
                    stringBuilder3.append(mo6269a());
                    stringBuilder3.append(" Token.");
                    am.m23161a(c5464i2, stringBuilder3.toString(), e);
                } else {
                    c5464i = C5464i.INFO;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("'Google Play services' returned SERVICE_NOT_AVAILABLE error. Current retry count: ");
                    stringBuilder.append(i);
                    am.m23161a(c5464i, stringBuilder.toString(), e);
                    if (i == 2) {
                        this.f24820a.mo4939a(null, -9);
                        this.f24822e = true;
                        return true;
                    }
                }
                return null;
            }
            c5464i2 = C5464i.ERROR;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error Getting ");
            stringBuilder2.append(mo6269a());
            stringBuilder2.append(" Token");
            am.m23161a(c5464i2, stringBuilder2.toString(), e);
            if (this.f24822e == null) {
                this.f24820a.mo4939a(null, -11);
            }
            return true;
        } catch (Throwable e2) {
            c5464i2 = C5464i.ERROR;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unknown error getting ");
            stringBuilder2.append(mo6269a());
            stringBuilder2.append(" Token");
            am.m23161a(c5464i2, stringBuilder2.toString(), e2);
            this.f24820a.mo4939a(null, -12);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m32614a(java.lang.String r3, com.onesignal.au.C5482a r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r1 = 1;
        java.lang.Float.parseFloat(r3);	 Catch:{ Throwable -> 0x0007 }
        r3 = 1;
        goto L_0x0008;
    L_0x0007:
        r3 = 0;
    L_0x0008:
        if (r3 != 0) goto L_0x0017;
    L_0x000a:
        r3 = com.onesignal.am.C5464i.ERROR;
        r1 = "Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.";
        com.onesignal.am.m23187b(r3, r1);
        r3 = 0;
        r1 = -6;
        r4.mo4939a(r3, r1);
        return r0;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.aw.a(java.lang.String, com.onesignal.au$a):boolean");
    }
}
