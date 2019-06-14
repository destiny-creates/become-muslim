package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0373d;
import com.facebook.ads.internal.view.C4630j;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3652f;
import com.facebook.ads.internal.view.p120f.p122b.C3653g;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3662p;
import java.io.Serializable;

public class ae extends BroadcastReceiver {
    /* renamed from: a */
    private Context f3845a;
    /* renamed from: b */
    private C4630j f3846b;
    /* renamed from: c */
    private boolean f3847c = false;

    public ae(C4630j c4630j, Context context) {
        this.f3846b = c4630j;
        this.f3845a = context.getApplicationContext();
    }

    /* renamed from: a */
    public void m4589a() {
        IntentFilter intentFilter = new IntentFilter();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.facebook.ads.interstitial.displayed:");
        stringBuilder.append(this.f3846b.getUniqueId());
        intentFilter.addAction(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("videoInterstitalEvent:");
        stringBuilder.append(this.f3846b.getUniqueId());
        intentFilter.addAction(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("performCtaClick:");
        stringBuilder.append(this.f3846b.getUniqueId());
        intentFilter.addAction(stringBuilder.toString());
        C0373d.m1138a(this.f3845a).m1142a(this, intentFilter);
    }

    /* renamed from: b */
    public void m4590b() {
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
        r1 = this;
        r0 = r1.f3845a;	 Catch:{ Exception -> 0x0009 }
        r0 = android.support.v4.content.C0373d.m1138a(r0);	 Catch:{ Exception -> 0x0009 }
        r0.m1141a(r1);	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.ae.b():void");
    }

    public void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(":");
        if (split.length == 2 && split[1].equals(this.f3846b.getUniqueId())) {
            if (split[0].equals("com.facebook.ads.interstitial.displayed")) {
                if (this.f3846b.getListener() != null) {
                    this.f3846b.getListener().mo876g();
                    this.f3846b.getListener().mo870a();
                }
            } else if (split[0].equals("videoInterstitalEvent")) {
                Serializable serializableExtra = intent.getSerializableExtra("event");
                if (serializableExtra instanceof C3662p) {
                    if (this.f3846b.getListener() != null) {
                        this.f3846b.getListener().mo875f();
                        this.f3846b.getListener().mo870a();
                    }
                    if (this.f3847c) {
                        this.f3846b.m11912a(1);
                    } else {
                        this.f3846b.m11912a(((C3662p) serializableExtra).m11966b());
                    }
                    this.f3846b.setVisibility(0);
                    this.f3846b.m11914a(C1624a.USER_STARTED);
                } else if (serializableExtra instanceof C3652f) {
                    if (this.f3846b.getListener() != null) {
                        this.f3846b.getListener().mo873d();
                    }
                } else if (serializableExtra instanceof C3653g) {
                    if (this.f3846b.getListener() != null) {
                        this.f3846b.getListener().mo874e();
                    }
                } else if (serializableExtra instanceof C3648b) {
                    if (this.f3846b.getListener() != null) {
                        this.f3846b.getListener().mo877h();
                    }
                    this.f3847c = true;
                } else if (serializableExtra instanceof C3656j) {
                    if (this.f3846b.getListener() != null) {
                        this.f3846b.getListener().mo872c();
                    }
                    this.f3847c = false;
                } else if ((serializableExtra instanceof C3654h) && this.f3846b.getListener() != null) {
                    this.f3846b.getListener().mo871b();
                }
            } else if (split[0].equals("performCtaClick")) {
                this.f3846b.mo2892b();
            }
        }
    }
}
