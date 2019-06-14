package io.p347a.p348a.p349a.p350a.p352b;

import android.content.Context;

/* compiled from: AdvertisingInfoReflectionStrategy */
/* renamed from: io.a.a.a.a.b.d */
class C7599d implements C6423f {
    /* renamed from: a */
    private final Context f26296a;

    public C7599d(Context context) {
        this.f26296a = context.getApplicationContext();
    }

    /* renamed from: a */
    boolean m34337a(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = "com.google.android.gms.common.GooglePlayServicesUtil";	 Catch:{ Exception -> 0x0027 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0027 }
        r2 = "isGooglePlayServicesAvailable";	 Catch:{ Exception -> 0x0027 }
        r3 = 1;	 Catch:{ Exception -> 0x0027 }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0027 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0027 }
        r4[r0] = r5;	 Catch:{ Exception -> 0x0027 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0027 }
        r2 = 0;	 Catch:{ Exception -> 0x0027 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0027 }
        r4[r0] = r7;	 Catch:{ Exception -> 0x0027 }
        r7 = r1.invoke(r2, r4);	 Catch:{ Exception -> 0x0027 }
        r7 = (java.lang.Integer) r7;	 Catch:{ Exception -> 0x0027 }
        r7 = r7.intValue();	 Catch:{ Exception -> 0x0027 }
        if (r7 != 0) goto L_0x0026;
    L_0x0025:
        r0 = 1;
    L_0x0026:
        return r0;
    L_0x0027:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.b.d.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    public C6418b mo5435a() {
        return m34337a(this.f26296a) ? new C6418b(m34333b(), m34334c()) : null;
    }

    /* renamed from: b */
    private java.lang.String m34333b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";	 Catch:{ Exception -> 0x001c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x001c }
        r1 = "getId";	 Catch:{ Exception -> 0x001c }
        r2 = 0;	 Catch:{ Exception -> 0x001c }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x001c }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x001c }
        r1 = r4.m34335d();	 Catch:{ Exception -> 0x001c }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x001c }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x001c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001c }
        return r0;
    L_0x001c:
        r0 = io.p347a.p348a.p349a.C6514c.m26634h();
        r1 = "Fabric";
        r2 = "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";
        r0.mo5477d(r1, r2);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.b.d.b():java.lang.String");
    }

    /* renamed from: c */
    private boolean m34334c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";	 Catch:{ Exception -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0020 }
        r2 = "isLimitAdTrackingEnabled";	 Catch:{ Exception -> 0x0020 }
        r3 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x0020 }
        r1 = r1.getMethod(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r2 = r4.m34335d();	 Catch:{ Exception -> 0x0020 }
        r3 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0020 }
        r1 = r1.invoke(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0020 }
        return r1;
    L_0x0020:
        r1 = io.p347a.p348a.p349a.C6514c.m26634h();
        r2 = "Fabric";
        r3 = "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";
        r1.mo5477d(r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.b.d.c():boolean");
    }

    /* renamed from: d */
    private java.lang.Object m34335d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";	 Catch:{ Exception -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0020 }
        r2 = "getAdvertisingIdInfo";	 Catch:{ Exception -> 0x0020 }
        r3 = 1;	 Catch:{ Exception -> 0x0020 }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0020 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0020 }
        r6 = 0;	 Catch:{ Exception -> 0x0020 }
        r4[r6] = r5;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0020 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0020 }
        r3 = r7.f26296a;	 Catch:{ Exception -> 0x0020 }
        r2[r6] = r3;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x0020 }
        return r1;
    L_0x0020:
        r1 = io.p347a.p348a.p349a.C6514c.m26634h();
        r2 = "Fabric";
        r3 = "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient";
        r1.mo5477d(r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.b.d.d():java.lang.Object");
    }
}
