package com.google.android.gms.internal.p213l;

import android.content.Context;
import com.google.android.gms.common.util.C2895e;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.l.ak */
public final class ak extends dc {
    /* renamed from: a */
    private long f32306a;
    /* renamed from: b */
    private String f32307b;
    /* renamed from: c */
    private Boolean f32308c;

    ak(cg cgVar) {
        super(cgVar);
    }

    public final long H_() {
        m38104z();
        return this.f32306a;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final boolean m42506a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f32308c;
        if (r0 != 0) goto L_0x0022;
    L_0x0004:
        r2.mo4755u();
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.f32308c = r0;
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0022 }
        if (r3 == 0) goto L_0x0022;	 Catch:{ NameNotFoundException -> 0x0022 }
    L_0x0014:
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x0022 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0022 }
        r3.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0022 }
        r3 = 1;	 Catch:{ NameNotFoundException -> 0x0022 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ NameNotFoundException -> 0x0022 }
        r2.f32308c = r3;	 Catch:{ NameNotFoundException -> 0x0022 }
    L_0x0022:
        r3 = r2.f32308c;
        r3 = r3.booleanValue();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ak.a(android.content.Context):boolean");
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    protected final boolean mo6739e() {
        Calendar instance = Calendar.getInstance();
        this.f32306a = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String toLowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String toLowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(toLowerCase).length() + 1) + String.valueOf(toLowerCase2).length());
        stringBuilder.append(toLowerCase);
        stringBuilder.append("-");
        stringBuilder.append(toLowerCase2);
        this.f32307b = stringBuilder.toString();
        return false;
    }

    /* renamed from: g */
    public final String m42511g() {
        m38104z();
        return this.f32307b;
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }
}
