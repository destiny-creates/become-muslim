package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.p169c.C2627a.C2626a;
import java.util.Map;

@cm
public final class bfb extends C4933n {
    /* renamed from: a */
    private final Map<String, String> f23980a;
    /* renamed from: b */
    private final Context f23981b;
    /* renamed from: c */
    private String f23982c = m30636d("description");
    /* renamed from: d */
    private long f23983d = m30637e("start_ticks");
    /* renamed from: e */
    private long f23984e = m30637e("end_ticks");
    /* renamed from: f */
    private String f23985f = m30636d("summary");
    /* renamed from: g */
    private String f23986g = m30636d(PlaceFields.LOCATION);

    public bfb(qo qoVar, Map<String, String> map) {
        super(qoVar, "createCalendarEvent");
        this.f23980a = map;
        this.f23981b = qoVar.mo6128d();
    }

    /* renamed from: d */
    private final String m30636d(String str) {
        return TextUtils.isEmpty((CharSequence) this.f23980a.get(str)) ? "" : (String) this.f23980a.get(str);
    }

    /* renamed from: e */
    private final long m30637e(java.lang.String r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.f23980a;
        r5 = r0.get(r5);
        r5 = (java.lang.String) r5;
        r0 = -1;
        if (r5 != 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2 = java.lang.Long.parseLong(r5);	 Catch:{ NumberFormatException -> 0x0012 }
        return r2;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bfb.e(java.lang.String):long");
    }

    /* renamed from: a */
    public final void m30638a() {
        if (this.f23981b == null) {
            m19930a("Activity context is not available.");
            return;
        }
        ax.e();
        if (jw.m19728f(this.f23981b).m18865d()) {
            ax.e();
            Builder e = jw.m19724e(this.f23981b);
            Resources h = ax.i().m30843h();
            e.setTitle(h != null ? h.getString(C2626a.s5) : "Create calendar event");
            e.setMessage(h != null ? h.getString(C2626a.s6) : "Allow Ad to create a calendar event?");
            e.setPositiveButton(h != null ? h.getString(C2626a.s3) : "Accept", new bfc(this));
            e.setNegativeButton(h != null ? h.getString(C2626a.s4) : "Decline", new C4923c(this));
            e.create().show();
            return;
        }
        m19930a("This feature is not available on the device.");
    }

    @TargetApi(14)
    /* renamed from: b */
    final Intent m30639b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.f23982c);
        data.putExtra("eventLocation", this.f23986g);
        data.putExtra("description", this.f23985f);
        if (this.f23983d > -1) {
            data.putExtra("beginTime", this.f23983d);
        }
        if (this.f23984e > -1) {
            data.putExtra("endTime", this.f23984e);
        }
        data.setFlags(268435456);
        return data;
    }
}
