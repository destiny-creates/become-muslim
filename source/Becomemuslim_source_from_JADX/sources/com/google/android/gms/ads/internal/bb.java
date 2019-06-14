package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.C2665n;
import com.google.android.gms.internal.ads.alo;
import com.google.android.gms.internal.ads.amz.C8283a.C6762b;
import com.google.android.gms.internal.ads.anc;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.awa;
import com.google.android.gms.internal.ads.awl;
import com.google.android.gms.internal.ads.bcj;
import com.google.android.gms.internal.ads.bcr;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.cp;
import com.google.android.gms.internal.ads.dm;
import com.google.android.gms.internal.ads.eh;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.iw;
import com.google.android.gms.internal.ads.ji;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.nu;
import java.util.concurrent.Executor;

@cm
public abstract class bb extends C4736a implements aq, C2665n, bcj {
    /* renamed from: j */
    protected final bcy f13935j;
    /* renamed from: k */
    private transient boolean f13936k;

    public bb(Context context, aou aou, String str, bcy bcy, mv mvVar, bu buVar) {
        this(new ay(context, aou, str, mvVar), bcy, null, buVar);
    }

    private bb(ay ayVar, bcy bcy, an anVar, bu buVar) {
        super(ayVar, null, buVar);
        this.f13935j = bcy;
        this.f13936k = false;
    }

    /* renamed from: a */
    private final com.google.android.gms.internal.ads.dm m17414a(com.google.android.gms.internal.ads.aoq r55, android.os.Bundle r56, com.google.android.gms.internal.ads.iw r57, int r58) {
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
        r54 = this;
        r0 = r54;
        r1 = r0.e;
        r1 = r1.f6792c;
        r7 = r1.getApplicationInfo();
        r1 = 0;
        r2 = r0.e;	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = r2.f6792c;	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = com.google.android.gms.common.p180d.C2829c.m8131a(r2);	 Catch:{ NameNotFoundException -> 0x001b }
        r4 = r7.packageName;	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = r2.m8129b(r4, r1);	 Catch:{ NameNotFoundException -> 0x001b }
        r8 = r2;
        goto L_0x001c;
    L_0x001b:
        r8 = 0;
    L_0x001c:
        r2 = r0.e;
        r2 = r2.f6792c;
        r2 = r2.getResources();
        r4 = r2.getDisplayMetrics();
        r2 = r0.e;
        r2 = r2.f6795f;
        if (r2 == 0) goto L_0x0094;
    L_0x002e:
        r2 = r0.e;
        r2 = r2.f6795f;
        r2 = r2.getParent();
        if (r2 == 0) goto L_0x0094;
    L_0x0038:
        r2 = 2;
        r2 = new int[r2];
        r5 = r0.e;
        r5 = r5.f6795f;
        r5.getLocationOnScreen(r2);
        r5 = r2[r1];
        r6 = 1;
        r2 = r2[r6];
        r9 = r0.e;
        r9 = r9.f6795f;
        r9 = r9.getWidth();
        r10 = r0.e;
        r10 = r10.f6795f;
        r10 = r10.getHeight();
        r11 = r0.e;
        r11 = r11.f6795f;
        r11 = r11.isShown();
        if (r11 == 0) goto L_0x0072;
    L_0x0061:
        r11 = r5 + r9;
        if (r11 <= 0) goto L_0x0072;
    L_0x0065:
        r11 = r2 + r10;
        if (r11 <= 0) goto L_0x0072;
    L_0x0069:
        r11 = r4.widthPixels;
        if (r5 > r11) goto L_0x0072;
    L_0x006d:
        r11 = r4.heightPixels;
        if (r2 > r11) goto L_0x0072;
    L_0x0071:
        goto L_0x0073;
    L_0x0072:
        r6 = 0;
    L_0x0073:
        r11 = new android.os.Bundle;
        r12 = 5;
        r11.<init>(r12);
        r12 = "x";
        r11.putInt(r12, r5);
        r5 = "y";
        r11.putInt(r5, r2);
        r2 = "width";
        r11.putInt(r2, r9);
        r2 = "height";
        r11.putInt(r2, r10);
        r2 = "visible";
        r11.putInt(r2, r6);
        r9 = r11;
        goto L_0x0095;
    L_0x0094:
        r9 = 0;
    L_0x0095:
        r2 = com.google.android.gms.ads.internal.ax.m7468i();
        r2 = r2.a();
        r12 = r2.a();
        r2 = r0.e;
        r5 = new com.google.android.gms.internal.ads.iu;
        r6 = r0.e;
        r6 = r6.f6791b;
        r5.<init>(r12, r6);
        r2.f6801l = r5;
        r2 = r0.e;
        r2 = r2.f6801l;
        r14 = r55;
        r2.a(r14);
        com.google.android.gms.ads.internal.ax.m7464e();
        r2 = r0.e;
        r2 = r2.f6792c;
        r5 = r0.e;
        r5 = r5.f6795f;
        r6 = r0.e;
        r6 = r6.f6798i;
        r20 = com.google.android.gms.internal.ads.jw.a(r2, r5, r6);
        r5 = 0;
        r2 = r0.e;
        r2 = r2.f6806q;
        if (r2 == 0) goto L_0x00e2;
    L_0x00d2:
        r2 = r0.e;	 Catch:{ RemoteException -> 0x00dd }
        r2 = r2.f6806q;	 Catch:{ RemoteException -> 0x00dd }
        r10 = r2.a();	 Catch:{ RemoteException -> 0x00dd }
        r21 = r10;
        goto L_0x00e4;
    L_0x00dd:
        r2 = "Cannot get correlation id, default to 0.";
        com.google.android.gms.internal.ads.jn.e(r2);
    L_0x00e2:
        r21 = r5;
    L_0x00e4:
        r2 = java.util.UUID.randomUUID();
        r23 = r2.toString();
        r2 = com.google.android.gms.ads.internal.ax.m7469j();
        r5 = r0.e;
        r5 = r5.f6792c;
        r15 = r2.a(r5, r0, r12);
        r13 = new java.util.ArrayList;
        r13.<init>();
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = 0;
    L_0x0103:
        r5 = r0.e;
        r5 = r5.f6811v;
        r5 = r5.size();
        if (r2 >= r5) goto L_0x0134;
    L_0x010d:
        r5 = r0.e;
        r5 = r5.f6811v;
        r5 = r5.m1462b(r2);
        r5 = (java.lang.String) r5;
        r13.add(r5);
        r6 = r0.e;
        r6 = r6.f6810u;
        r6 = r6.containsKey(r5);
        if (r6 == 0) goto L_0x0131;
    L_0x0124:
        r6 = r0.e;
        r6 = r6.f6810u;
        r6 = r6.get(r5);
        if (r6 == 0) goto L_0x0131;
    L_0x012e:
        r11.add(r5);
    L_0x0131:
        r2 = r2 + 1;
        goto L_0x0103;
    L_0x0134:
        r2 = new com.google.android.gms.ads.internal.be;
        r2.<init>(r0);
        r34 = com.google.android.gms.internal.ads.ju.a(r2);
        r2 = new com.google.android.gms.ads.internal.bf;
        r2.<init>(r0);
        r44 = com.google.android.gms.internal.ads.ju.a(r2);
        if (r57 == 0) goto L_0x014f;
    L_0x0148:
        r2 = r57.c();
        r35 = r2;
        goto L_0x0151;
    L_0x014f:
        r35 = 0;
    L_0x0151:
        r2 = r0.e;
        r2 = r2.f6778F;
        if (r2 == 0) goto L_0x01a9;
    L_0x0157:
        r2 = r0.e;
        r2 = r2.f6778F;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x01a9;
    L_0x0161:
        if (r8 == 0) goto L_0x0165;
    L_0x0163:
        r1 = r8.versionCode;
    L_0x0165:
        r2 = com.google.android.gms.ads.internal.ax.m7468i();
        r2 = r2.l();
        r2 = r2.g();
        if (r1 <= r2) goto L_0x018a;
    L_0x0173:
        r2 = com.google.android.gms.ads.internal.ax.m7468i();
        r2 = r2.l();
        r2.m();
        r2 = com.google.android.gms.ads.internal.ax.m7468i();
        r2 = r2.l();
        r2.a(r1);
        goto L_0x01a9;
    L_0x018a:
        r1 = com.google.android.gms.ads.internal.ax.m7468i();
        r1 = r1.l();
        r1 = r1.l();
        if (r1 == 0) goto L_0x01a9;
    L_0x0198:
        r2 = r0.e;
        r2 = r2.f6791b;
        r1 = r1.optJSONArray(r2);
        if (r1 == 0) goto L_0x01a9;
    L_0x01a2:
        r1 = r1.toString();
        r46 = r1;
        goto L_0x01ab;
    L_0x01a9:
        r46 = 0;
    L_0x01ab:
        r1 = new com.google.android.gms.internal.ads.dm;
        r2 = r1;
        r5 = r0.e;
        r5 = r5.f6798i;
        r6 = r0.e;
        r6 = r6.f6791b;
        r10 = com.google.android.gms.internal.ads.aph.c();
        r3 = r0.e;
        r3 = r3.f6794e;
        r47 = r11;
        r11 = r3;
        r3 = r0.e;
        r3 = r3.f6778F;
        r48 = r13;
        r13 = r3;
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r3 = r3.l();
        r16 = r3.a();
        r3 = r4.widthPixels;
        r17 = r3;
        r3 = r4.heightPixels;
        r18 = r3;
        r3 = r4.density;
        r19 = r3;
        r24 = com.google.android.gms.internal.ads.asp.a();
        r3 = r0.e;
        r3 = r3.f6790a;
        r25 = r3;
        r3 = r0.e;
        r3 = r3.f6812w;
        r26 = r3;
        r3 = r0.e;
        r27 = r3.m7495f();
        r3 = com.google.android.gms.ads.internal.ax.m7457D();
        r28 = r3.a();
        r3 = com.google.android.gms.ads.internal.ax.m7457D();
        r29 = r3.b();
        com.google.android.gms.ads.internal.ax.m7464e();
        r3 = r0.e;
        r3 = r3.f6792c;
        r30 = com.google.android.gms.internal.ads.jw.i(r3);
        com.google.android.gms.ads.internal.ax.m7464e();
        r3 = r0.e;
        r3 = r3.f6795f;
        r31 = com.google.android.gms.internal.ads.jw.d(r3);
        r3 = r0.e;
        r3 = r3.f6792c;
        r3 = r3 instanceof android.app.Activity;
        r32 = r3;
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r3 = r3.l();
        r33 = r3.f();
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r36 = r3.d();
        r3 = com.google.android.gms.ads.internal.ax.m7485z();
        r37 = r3.a();
        com.google.android.gms.ads.internal.ax.m7464e();
        r38 = com.google.android.gms.internal.ads.jw.c();
        r3 = com.google.android.gms.ads.internal.ax.m7474o();
        r39 = r3.a();
        r3 = r0.e;
        r3 = r3.f6814y;
        r40 = r3;
        r3 = com.google.android.gms.ads.internal.ax.m7474o();
        r41 = r3.b();
        r3 = com.google.android.gms.internal.ads.azi.a();
        r42 = r3.j();
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r3 = r3.l();
        r4 = r0.e;
        r4 = r4.f6791b;
        r43 = r3.e(r4);
        r3 = r0.e;
        r3 = r3.f6773A;
        r45 = r3;
        r3 = r0.e;
        r3 = r3.f6792c;
        r3 = com.google.android.gms.common.p180d.C2829c.m8131a(r3);
        r49 = r3.m8126a();
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r50 = r3.e();
        com.google.android.gms.ads.internal.ax.m7466g();
        r51 = com.google.android.gms.internal.ads.kc.e();
        r3 = com.google.android.gms.ads.internal.ax.m7468i();
        r3 = r3.n();
        r53 = r1;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r14 = 0;
        r0 = com.google.android.gms.internal.ads.nd.a(r3, r14, r0, r4);
        r52 = r0;
        r52 = (java.util.ArrayList) r52;
        r3 = r9;
        r4 = r55;
        r9 = r12;
        r12 = r15;
        r14 = r48;
        r15 = r56;
        r48 = r58;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
        return r53;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bb.a(com.google.android.gms.internal.ads.aoq, android.os.Bundle, com.google.android.gms.internal.ads.iw, int):com.google.android.gms.internal.ads.dm");
    }

    /* renamed from: c */
    static java.lang.String m17415c(com.google.android.gms.internal.ads.is r2) {
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
        if (r2 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
        return r2;
    L_0x0004:
        r0 = r2.f15590q;
        r1 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0019;
    L_0x000e:
        r1 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0019;
    L_0x0017:
        r1 = 0;
        goto L_0x001a;
    L_0x0019:
        r1 = 1;
    L_0x001a:
        if (r1 == 0) goto L_0x0030;
    L_0x001c:
        r1 = r2.f15588o;
        if (r1 == 0) goto L_0x0030;
    L_0x0020:
        r2 = r2.f15588o;
        r2 = r2.f15183k;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        r2 = "class_name";	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        r2 = r1.getString(r2);	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        return r2;
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bb.c(com.google.android.gms.internal.ads.is):java.lang.String");
    }

    /* renamed from: H */
    public void mo3534H() {
        jn.e("showInterstitial is not supported for current ad type");
    }

    /* renamed from: T */
    public void mo3535T() {
        onAdClicked();
    }

    /* renamed from: U */
    public void mo3536U() {
        ab();
    }

    /* renamed from: V */
    public void mo3537V() {
        jn.e("Mediated ad does not support onVideoEnd callback");
    }

    /* renamed from: W */
    protected boolean mo3585W() {
        ax.m7464e();
        if (jw.a(this.e.f6792c, "android.permission.INTERNET")) {
            ax.m7464e();
            if (jw.a(this.e.f6792c)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: X */
    public final void m17421X() {
        u_();
    }

    /* renamed from: Y */
    public final void m17422Y() {
        m16474u();
    }

    /* renamed from: Z */
    public final void m17423Z() {
        v_();
    }

    /* renamed from: a */
    public final String m17424a() {
        return this.e.f6799j == null ? null : this.e.f6799j.f15590q;
    }

    /* renamed from: a */
    public final void m17425a(awa awa, String str) {
        awl awl = null;
        if (awa != null) {
            try {
                Object l = awa.l();
            } catch (Throwable e) {
                jn.c("Unable to call onCustomClick.", e);
                return;
            }
        }
        l = null;
        if (!(this.e.f6810u == null || l == null)) {
            awl = (awl) this.e.f6810u.get(l);
        }
        if (awl == null) {
            jn.e("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            awl.a(awa, str);
        }
    }

    /* renamed from: a */
    protected void mo3587a(is isVar, boolean z) {
        if (isVar == null) {
            jn.e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (isVar == null) {
            jn.e("Ad state was null when trying to ping impression URLs.");
        } else {
            jn.b("Pinging Impression URLs.");
            if (this.f12969e.f6801l != null) {
                this.f12969e.f6801l.a();
            }
            isVar.f15565K.a(C6762b.f23737e);
            if (!(isVar.f15578e == null || isVar.f15558D)) {
                ax.m7464e();
                jw.a(this.f12969e.f6792c, this.f12969e.f6794e.f28709a, m16452b(isVar.f15578e));
                isVar.f15558D = true;
            }
        }
        if (!isVar.f15560F || z) {
            if (!(isVar.f15591r == null || isVar.f15591r.f15197d == null)) {
                ax.m7483x();
                bcr.a(this.e.f6792c, this.e.f6794e.f28709a, isVar, this.e.f6791b, z, m16452b(isVar.f15591r.f15197d));
            }
            if (!(isVar.f15588o == null || isVar.f15588o.f15179g == null)) {
                ax.m7483x();
                bcr.a(this.e.f6792c, this.e.f6794e.f28709a, isVar, this.e.f6791b, z, isVar.f15588o.f15179g);
            }
            isVar.f15560F = true;
        }
    }

    /* renamed from: a */
    public boolean mo3433a(aoq aoq, atc atc) {
        return m17428a(aoq, atc, 1);
    }

    /* renamed from: a */
    public final boolean m17428a(aoq aoq, atc atc, int i) {
        if (!mo3585W()) {
            return false;
        }
        iw h;
        ax.m7464e();
        alo a = ax.m7468i().a(this.e.f6792c);
        String str = null;
        Bundle a2 = a == null ? null : jw.a(a);
        this.d.m7438a();
        this.e.f6781I = 0;
        if (((Boolean) aph.f().a(asp.cs)).booleanValue()) {
            h = ax.m7468i().l().h();
            C2642e m = ax.m7472m();
            Context context = this.e.f6792c;
            mv mvVar = this.e.f6794e;
            String str2 = this.e.f6791b;
            if (h != null) {
                str = h.d();
            }
            m.m7510a(context, mvVar, false, h, str, str2, null);
        } else {
            h = null;
        }
        return m17430a(m17414a(aoq, a2, h, i), atc);
    }

    /* renamed from: a */
    protected boolean mo3543a(aoq aoq, is isVar, boolean z) {
        if (!z && this.e.m7493d()) {
            an anVar;
            long j;
            if (isVar.f15582i > 0) {
                anVar = this.d;
                j = isVar.f15582i;
            } else if (isVar.f15591r != null && isVar.f15591r.f15203j > 0) {
                anVar = this.d;
                j = isVar.f15591r.f15203j;
            } else if (!isVar.f15587n && isVar.f15577d == 2) {
                this.d.m7442b(aoq);
            }
            anVar.m7440a(aoq, j);
        }
        return this.d.m7445e();
    }

    /* renamed from: a */
    public final boolean m17430a(dm dmVar, atc atc) {
        this.a = atc;
        atc.a("seq_num", dmVar.f15308g);
        atc.a("request_id", dmVar.f15323v);
        atc.a("session_id", dmVar.f15309h);
        if (dmVar.f15307f != null) {
            atc.a("app_version", String.valueOf(dmVar.f15307f.versionCode));
        }
        ay ayVar = this.e;
        ax.m7460a();
        Context context = this.e.f6792c;
        anc anc = this.i.f6846d;
        ji ehVar = dmVar.f15303b.f28263c.getBundle("sdk_less_server_data") != null ? new eh(context, dmVar, this, anc) : new cp(context, dmVar, this, anc);
        ehVar.h();
        ayVar.f6796g = ehVar;
        return true;
    }

    /* renamed from: a */
    final boolean mo3434a(is isVar) {
        aoq aoq;
        boolean z = false;
        if (this.f != null) {
            aoq = this.f;
            this.f = null;
        } else {
            aoq = isVar.f15574a;
            if (aoq.f28263c != null) {
                z = aoq.f28263c.getBoolean("_noRefresh", false);
            }
        }
        return mo3543a(aoq, isVar, z);
    }

    /* renamed from: a */
    protected boolean mo3435a(is isVar, is isVar2) {
        int i;
        if (!(isVar == null || isVar.f15592s == null)) {
            isVar.f15592s.a(null);
        }
        if (isVar2.f15592s != null) {
            isVar2.f15592s.a(this);
        }
        int i2 = 0;
        if (isVar2.f15591r != null) {
            i2 = isVar2.f15591r.f15211r;
            i = isVar2.f15591r.f15212s;
        } else {
            i = 0;
        }
        this.e.f6779G.a(i2, i);
        return true;
    }

    public final void aa() {
        if (this.e.f6799j != null) {
            String str = this.e.f6799j.f15590q;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 74);
            stringBuilder.append("Mediation adapter ");
            stringBuilder.append(str);
            stringBuilder.append(" refreshed, but mediation adapters should never refresh.");
            jn.e(stringBuilder.toString());
        }
        mo3587a(this.e.f6799j, true);
        m17434b(this.e.f6799j, true);
        mo3546w();
    }

    public final void ab() {
        mo3587a(this.e.f6799j, false);
    }

    /* renamed from: b */
    public final void mo3436b(is isVar) {
        super.mo3436b(isVar);
        if (isVar.f15588o != null) {
            jn.b("Disable the debug gesture detector on the mediation ad frame.");
            if (this.e.f6795f != null) {
                this.e.f6795f.m7499d();
            }
            jn.b("Pinging network fill URLs.");
            ax.m7483x();
            bcr.a(this.e.f6792c, this.e.f6794e.f28709a, isVar, this.e.f6791b, false, isVar.f15588o.f15182j);
            if (!(isVar.f15591r == null || isVar.f15591r.f15200g == null || isVar.f15591r.f15200g.size() <= 0)) {
                jn.b("Pinging urls remotely");
                ax.m7464e().a(this.e.f6792c, isVar.f15591r.f15200g);
            }
        } else {
            jn.b("Enable the debug gesture detector on the admob ad frame.");
            if (this.e.f6795f != null) {
                this.e.f6795f.m7498c();
            }
        }
        if (isVar.f15577d == 3 && isVar.f15591r != null && isVar.f15591r.f15199f != null) {
            jn.b("Pinging no fill URLs.");
            ax.m7483x();
            bcr.a(this.e.f6792c, this.e.f6794e.f28709a, isVar, this.e.f6791b, false, isVar.f15591r.f15199f);
        }
    }

    /* renamed from: b */
    protected final void m17434b(is isVar, boolean z) {
        if (isVar != null) {
            if (!(isVar == null || isVar.f15579f == null || isVar.f15559E)) {
                ax.m7464e();
                jw.a(this.f12969e.f6792c, this.f12969e.f6794e.f28709a, m16425a(isVar.f15579f));
                isVar.f15559E = true;
            }
            if (!isVar.f15561G || z) {
                if (!(isVar.f15591r == null || isVar.f15591r.f15198e == null)) {
                    ax.m7483x();
                    bcr.a(this.e.f6792c, this.e.f6794e.f28709a, isVar, this.e.f6791b, z, m16425a(isVar.f15591r.f15198e));
                }
                if (!(isVar.f15588o == null || isVar.f15588o.f15180h == null)) {
                    ax.m7483x();
                    bcr.a(this.e.f6792c, this.e.f6794e.f28709a, isVar, this.e.f6791b, z, isVar.f15588o.f15180h);
                }
                isVar.f15561G = true;
            }
        }
    }

    /* renamed from: b */
    public final void m17435b(String str, String str2) {
        mo3252a(str, str2);
    }

    /* renamed from: c */
    protected final boolean mo3437c(aoq aoq) {
        return super.mo3437c(aoq) && !this.f13936k;
    }

    /* renamed from: d */
    public final void mo3438d() {
        this.g.c(this.e.f6799j);
    }

    /* renamed from: e */
    public final void mo3439e() {
        this.g.d(this.e.f6799j);
    }

    public final void m_() {
        Executor executor = nu.f15846a;
        an anVar = this.d;
        anVar.getClass();
        executor.execute(bc.m7500a(anVar));
    }

    /* renamed from: n */
    public void mo3441n() {
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
        r0 = "pause must be called on the main UI thread.";
        com.google.android.gms.common.internal.C2872v.m8389b(r0);
        r0 = r2.e;
        r0 = r0.f6799j;
        if (r0 == 0) goto L_0x0027;
    L_0x000b:
        r0 = r2.e;
        r0 = r0.f6799j;
        r0 = r0.f15575b;
        if (r0 == 0) goto L_0x0027;
    L_0x0013:
        r0 = r2.e;
        r0 = r0.m7493d();
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        com.google.android.gms.ads.internal.ax.m7466g();
        r0 = r2.e;
        r0 = r0.f6799j;
        r0 = r0.f15575b;
        com.google.android.gms.internal.ads.kc.a(r0);
    L_0x0027:
        r0 = r2.e;
        r0 = r0.f6799j;
        if (r0 == 0) goto L_0x0044;
    L_0x002d:
        r0 = r2.e;
        r0 = r0.f6799j;
        r0 = r0.f15589p;
        if (r0 == 0) goto L_0x0044;
    L_0x0035:
        r0 = r2.e;	 Catch:{ RemoteException -> 0x003f }
        r0 = r0.f6799j;	 Catch:{ RemoteException -> 0x003f }
        r0 = r0.f15589p;	 Catch:{ RemoteException -> 0x003f }
        r0.d();	 Catch:{ RemoteException -> 0x003f }
        goto L_0x0044;
    L_0x003f:
        r0 = "Could not pause mediation adapter.";
        com.google.android.gms.internal.ads.jn.e(r0);
    L_0x0044:
        r0 = r2.g;
        r1 = r2.e;
        r1 = r1.f6799j;
        r0.c(r1);
        r0 = r2.d;
        r0.m7441b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bb.n():void");
    }

    public final void n_() {
        Executor executor = nu.f15846a;
        an anVar = this.d;
        anVar.getClass();
        executor.execute(bd.m7501a(anVar));
    }

    /* renamed from: o */
    public void mo3443o() {
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
        r0 = "resume must be called on the main UI thread.";
        com.google.android.gms.common.internal.C2872v.m8389b(r0);
        r0 = r2.e;
        r0 = r0.f6799j;
        if (r0 == 0) goto L_0x001a;
    L_0x000b:
        r0 = r2.e;
        r0 = r0.f6799j;
        r0 = r0.f15575b;
        if (r0 == 0) goto L_0x001a;
    L_0x0013:
        r0 = r2.e;
        r0 = r0.f6799j;
        r0 = r0.f15575b;
        goto L_0x001b;
    L_0x001a:
        r0 = 0;
    L_0x001b:
        if (r0 == 0) goto L_0x0031;
    L_0x001d:
        r1 = r2.e;
        r1 = r1.m7493d();
        if (r1 == 0) goto L_0x0031;
    L_0x0025:
        com.google.android.gms.ads.internal.ax.m7466g();
        r1 = r2.e;
        r1 = r1.f6799j;
        r1 = r1.f15575b;
        com.google.android.gms.internal.ads.kc.b(r1);
    L_0x0031:
        r1 = r2.e;
        r1 = r1.f6799j;
        if (r1 == 0) goto L_0x004e;
    L_0x0037:
        r1 = r2.e;
        r1 = r1.f6799j;
        r1 = r1.f15589p;
        if (r1 == 0) goto L_0x004e;
    L_0x003f:
        r1 = r2.e;	 Catch:{ RemoteException -> 0x0049 }
        r1 = r1.f6799j;	 Catch:{ RemoteException -> 0x0049 }
        r1 = r1.f15589p;	 Catch:{ RemoteException -> 0x0049 }
        r1.e();	 Catch:{ RemoteException -> 0x0049 }
        goto L_0x004e;
    L_0x0049:
        r1 = "Could not resume mediation adapter.";
        com.google.android.gms.internal.ads.jn.e(r1);
    L_0x004e:
        if (r0 == 0) goto L_0x0056;
    L_0x0050:
        r0 = r0.D();
        if (r0 != 0) goto L_0x005b;
    L_0x0056:
        r0 = r2.d;
        r0.m7443c();
    L_0x005b:
        r0 = r2.g;
        r1 = r2.e;
        r1 = r1.f6799j;
        r0.d(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bb.o():void");
    }

    public void onAdClicked() {
        if (this.e.f6799j == null) {
            jn.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.e.f6799j.f15591r == null || this.e.f6799j.f15591r.f15196c == null)) {
            ax.m7483x();
            bcr.a(this.e.f6792c, this.e.f6794e.f28709a, this.e.f6799j, this.e.f6791b, false, m16452b(this.e.f6799j.f15591r.f15196c));
        }
        if (!(this.e.f6799j.f15588o == null || this.e.f6799j.f15588o.f15178f == null)) {
            ax.m7483x();
            bcr.a(this.e.f6792c, this.e.f6794e.f28709a, this.e.f6799j, this.e.f6791b, false, this.e.f6799j.f15588o.f15178f);
        }
        super.onAdClicked();
    }

    public void u_() {
        this.f13936k = false;
        mo3594t();
        this.e.f6801l.c();
    }

    public void v_() {
        this.f13936k = true;
        m16475v();
    }

    public final String w_() {
        return this.e.f6799j == null ? null : m17415c(this.e.f6799j);
    }
}
