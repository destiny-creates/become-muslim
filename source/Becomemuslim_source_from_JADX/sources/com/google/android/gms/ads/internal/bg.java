package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.C4934o;
import com.google.android.gms.internal.ads.ao;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.atj;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.id;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.internal.ads.qv;
import com.google.android.gms.internal.ads.sc;

@cm
public abstract class bg extends bb implements C2643g, C4934o {
    /* renamed from: k */
    private boolean f14096k;

    public bg(Context context, aou aou, String str, bcy bcy, mv mvVar, bu buVar) {
        super(context, aou, str, bcy, mvVar, buVar);
    }

    /* renamed from: L */
    protected final boolean m17679L() {
        return (this.e.f6800k == null || this.e.f6800k.f15601b == null || !this.e.f6800k.f15601b.f28588Q) ? false : true;
    }

    /* renamed from: M */
    public final void m17680M() {
        mo3594t();
    }

    /* renamed from: a */
    protected qo mo3586a(it itVar, bv bvVar, id idVar) {
        it itVar2 = itVar;
        View nextView = this.e.f6795f.getNextView();
        if (nextView instanceof qo) {
            ((qo) nextView).destroy();
        }
        if (nextView != null) {
            r11.e.f6795f.removeView(nextView);
        }
        ax.m7465f();
        qo a = qv.a(r11.e.f6792c, sc.a(r11.e.f6798i), r11.e.f6798i.f28279a, false, false, r11.e.f6793d, r11.e.f6794e, r11.a, this, r11.i, itVar2.f15608i);
        if (r11.e.f6798i.f28285g == null) {
            m16428a(a.getView());
        }
        a.v().a(this, this, this, this, this, false, null, bvVar, this, idVar);
        m17685a(a);
        a.a(itVar2.f15600a.f28566v);
        return a;
    }

    /* renamed from: a */
    public final void m17682a(int i, int i2, int i3, int i4) {
        m16475v();
    }

    /* renamed from: a */
    public final void mo3540a(atj atj) {
        C2872v.m8389b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.e.f6774B = atj;
    }

    /* renamed from: a */
    protected void mo3541a(it itVar, atc atc) {
        if (itVar.f15604e != -2) {
            jw.f15691a.post(new bi(this, itVar));
            return;
        }
        if (itVar.f15603d != null) {
            this.e.f6798i = itVar.f15603d;
        }
        if (!itVar.f15601b.f28602g || itVar.f15601b.f28621z) {
            jw.f15691a.post(new bj(this, itVar, this.i.f6845c.a(this.e.f6792c, this.e.f6794e, itVar.f15601b), atc));
            return;
        }
        this.e.f6781I = 0;
        ay ayVar = this.e;
        ax.m7463d();
        ayVar.f6797h = ao.a(this.e.f6792c, this, itVar, this.e.f6793d, null, this.j, this, atc);
    }

    /* renamed from: a */
    protected final void m17685a(qo qoVar) {
        qoVar.a("/trackActiveViewUnit", new bh(this));
    }

    /* renamed from: a */
    protected boolean mo3435a(com.google.android.gms.internal.ads.is r3, com.google.android.gms.internal.ads.is r4) {
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
        r2 = this;
        r0 = r2.e;
        r0 = r0.m7493d();
        if (r0 == 0) goto L_0x001b;
    L_0x0008:
        r0 = r2.e;
        r0 = r0.f6795f;
        if (r0 == 0) goto L_0x001b;
    L_0x000e:
        r0 = r2.e;
        r0 = r0.f6795f;
        r0 = r0.m7496a();
        r1 = r4.f15555A;
        r0.c(r1);
    L_0x001b:
        r0 = r4.f15575b;	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 == 0) goto L_0x0056;	 Catch:{ RuntimeException -> 0x0051 }
    L_0x001f:
        r0 = r4.f15587n;	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 != 0) goto L_0x0056;	 Catch:{ RuntimeException -> 0x0051 }
    L_0x0023:
        r0 = r4.f15567M;	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 == 0) goto L_0x0056;	 Catch:{ RuntimeException -> 0x0051 }
    L_0x0027:
        r0 = com.google.android.gms.internal.ads.asp.dl;	 Catch:{ RuntimeException -> 0x0051 }
        r1 = com.google.android.gms.internal.ads.aph.f();	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r1.a(r0);	 Catch:{ RuntimeException -> 0x0051 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.booleanValue();	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 == 0) goto L_0x0056;	 Catch:{ RuntimeException -> 0x0051 }
    L_0x0039:
        r0 = r4.f15574a;	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.f28263c;	 Catch:{ RuntimeException -> 0x0051 }
        r1 = "sdk_less_server_data";	 Catch:{ RuntimeException -> 0x0051 }
        r0 = r0.containsKey(r1);	 Catch:{ RuntimeException -> 0x0051 }
        if (r0 != 0) goto L_0x0056;
    L_0x0045:
        r0 = r4.f15575b;	 Catch:{ Throwable -> 0x004b }
        r0.J();	 Catch:{ Throwable -> 0x004b }
        goto L_0x0056;
    L_0x004b:
        r0 = "Could not render test Ad label.";	 Catch:{ RuntimeException -> 0x0051 }
        com.google.android.gms.internal.ads.jn.a(r0);	 Catch:{ RuntimeException -> 0x0051 }
        goto L_0x0056;
    L_0x0051:
        r0 = "Could not render test AdLabel.";
        com.google.android.gms.internal.ads.jn.a(r0);
    L_0x0056:
        r3 = super.mo3435a(r3, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bg.a(com.google.android.gms.internal.ads.is, com.google.android.gms.internal.ads.is):boolean");
    }

    public final void a_(View view) {
        this.e.f6780H = view;
        mo3436b(new is(this.e.f6800k, null, null, null, null, null, null, null));
    }

    /* renamed from: b */
    final void m17687b(qo qoVar) {
        if (this.e.f6799j != null) {
            this.g.a(this.e.f6798i, this.e.f6799j, qoVar.getView(), qoVar);
            this.f14096k = false;
            return;
        }
        this.f14096k = true;
        jn.e("Request to enable ActiveView before adState is available.");
    }

    public final void k_() {
        onAdClicked();
    }

    public final void l_() {
        ab();
        m16466m();
    }

    /* renamed from: w */
    protected void mo3546w() {
        super.mo3546w();
        if (this.f14096k) {
            if (((Boolean) aph.f().a(asp.cg)).booleanValue()) {
                m17687b(this.e.f6799j.f15575b);
            }
        }
    }
}
