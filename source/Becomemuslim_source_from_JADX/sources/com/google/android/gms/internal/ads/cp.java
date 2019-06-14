package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.amz.C8283a.C6762b;
import org.json.JSONObject;

@cm
public final class cp extends ji implements dc {
    /* renamed from: a */
    kp f28501a;
    /* renamed from: b */
    private final co f28502b;
    /* renamed from: c */
    private final dm f28503c;
    /* renamed from: d */
    private final Object f28504d = new Object();
    /* renamed from: e */
    private final Context f28505e;
    /* renamed from: f */
    private final amx f28506f;
    /* renamed from: g */
    private final anc f28507g;
    /* renamed from: h */
    private dl f28508h;
    /* renamed from: i */
    private Runnable f28509i;
    /* renamed from: j */
    private dp f28510j;
    /* renamed from: k */
    private bci f28511k;

    public cp(Context context, dm dmVar, co coVar, anc anc) {
        amx amx;
        amy amy;
        this.f28502b = coVar;
        this.f28505e = context;
        this.f28503c = dmVar;
        this.f28507g = anc;
        this.f28506f = new amx(this.f28507g);
        this.f28506f.m18648a(new cq(this));
        anz anz = new anz();
        anz.f28211a = Integer.valueOf(this.f28503c.f15311j.f28710b);
        anz.f28212b = Integer.valueOf(this.f28503c.f15311j.f28711c);
        anz.f28213c = Integer.valueOf(this.f28503c.f15311j.f28712d ? 0 : 2);
        this.f28506f.m18648a(new cr(anz));
        if (this.f28503c.f15307f != null) {
            this.f28506f.m18648a(new cs(this));
        }
        aou aou = this.f28503c.f15304c;
        if (aou.f28282d && "interstitial_mb".equals(aou.f28279a)) {
            amx = this.f28506f;
            amy = ct.f24038a;
        } else if (aou.f28282d && "reward_mb".equals(aou.f28279a)) {
            amx = this.f28506f;
            amy = cu.f24039a;
        } else if (aou.f28286h || aou.f28282d) {
            amx = this.f28506f;
            amy = cw.f24041a;
        } else {
            amx = this.f28506f;
            amy = cv.f24040a;
        }
        amx.m18648a(amy);
        this.f28506f.m18649a(C6762b.AD_REQUEST);
    }

    /* renamed from: a */
    private final com.google.android.gms.internal.ads.aou m37440a(com.google.android.gms.internal.ads.dl r12) {
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
        r11 = this;
        r0 = r11.f28508h;
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0018;
    L_0x0006:
        r0 = r11.f28508h;
        r0 = r0.f28540V;
        if (r0 == 0) goto L_0x0018;
    L_0x000c:
        r0 = r11.f28508h;
        r0 = r0.f28540V;
        r0 = r0.size();
        if (r0 <= r1) goto L_0x0018;
    L_0x0016:
        r0 = 1;
        goto L_0x0019;
    L_0x0018:
        r0 = 0;
    L_0x0019:
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        r0 = r11.f28511k;
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r0 = r11.f28511k;
        r0 = r0.f15213t;
        if (r0 != 0) goto L_0x0027;
    L_0x0025:
        r12 = 0;
        return r12;
    L_0x0027:
        r0 = r11.f28510j;
        r0 = r0.f28620y;
        if (r0 == 0) goto L_0x0048;
    L_0x002d:
        r0 = r12.f28548d;
        r0 = r0.f28285g;
        r3 = r0.length;
        r4 = 0;
    L_0x0033:
        if (r4 >= r3) goto L_0x0048;
    L_0x0035:
        r5 = r0[r4];
        r6 = r5.f28287i;
        if (r6 == 0) goto L_0x0045;
    L_0x003b:
        r0 = new com.google.android.gms.internal.ads.aou;
        r12 = r12.f28548d;
        r12 = r12.f28285g;
        r0.<init>(r5, r12);
        return r0;
    L_0x0045:
        r4 = r4 + 1;
        goto L_0x0033;
    L_0x0048:
        r0 = r11.f28510j;
        r0 = r0.f28607l;
        if (r0 == 0) goto L_0x0111;
    L_0x004e:
        r0 = r11.f28510j;
        r0 = r0.f28607l;
        r3 = "x";
        r0 = r0.split(r3);
        r3 = r0.length;
        r4 = 2;
        if (r3 == r4) goto L_0x007d;
    L_0x005c:
        r12 = new com.google.android.gms.internal.ads.cz;
        r0 = "Invalid ad size format from the ad response: ";
        r1 = r11.f28510j;
        r1 = r1.f28607l;
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0073;
    L_0x006e:
        r0 = r0.concat(r1);
        goto L_0x0079;
    L_0x0073:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0079:
        r12.<init>(r0, r2);
        throw r12;
    L_0x007d:
        r3 = r0[r2];	 Catch:{ NumberFormatException -> 0x00ef }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x00ef }
        r0 = r0[r1];	 Catch:{ NumberFormatException -> 0x00ef }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x00ef }
        r1 = r12.f28548d;
        r1 = r1.f28285g;
        r4 = r1.length;
        r5 = 0;
    L_0x008f:
        if (r5 >= r4) goto L_0x00ce;
    L_0x0091:
        r6 = r1[r5];
        r7 = r11.f28505e;
        r7 = r7.getResources();
        r7 = r7.getDisplayMetrics();
        r7 = r7.density;
        r8 = r6.f28283e;
        r9 = -1;
        if (r8 != r9) goto L_0x00aa;
    L_0x00a4:
        r8 = r6.f28284f;
        r8 = (float) r8;
        r8 = r8 / r7;
        r8 = (int) r8;
        goto L_0x00ac;
    L_0x00aa:
        r8 = r6.f28283e;
    L_0x00ac:
        r9 = r6.f28280b;
        r10 = -2;
        if (r9 != r10) goto L_0x00b7;
    L_0x00b1:
        r9 = r6.f28281c;
        r9 = (float) r9;
        r9 = r9 / r7;
        r7 = (int) r9;
        goto L_0x00b9;
    L_0x00b7:
        r7 = r6.f28280b;
    L_0x00b9:
        if (r3 != r8) goto L_0x00cb;
    L_0x00bb:
        if (r0 != r7) goto L_0x00cb;
    L_0x00bd:
        r7 = r6.f28287i;
        if (r7 != 0) goto L_0x00cb;
    L_0x00c1:
        r0 = new com.google.android.gms.internal.ads.aou;
        r12 = r12.f28548d;
        r12 = r12.f28285g;
        r0.<init>(r6, r12);
        return r0;
    L_0x00cb:
        r5 = r5 + 1;
        goto L_0x008f;
    L_0x00ce:
        r12 = new com.google.android.gms.internal.ads.cz;
        r0 = "The ad size from the ad response was not one of the requested sizes: ";
        r1 = r11.f28510j;
        r1 = r1.f28607l;
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x00e5;
    L_0x00e0:
        r0 = r0.concat(r1);
        goto L_0x00eb;
    L_0x00e5:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x00eb:
        r12.<init>(r0, r2);
        throw r12;
        r12 = new com.google.android.gms.internal.ads.cz;
        r0 = "Invalid ad size number from the ad response: ";
        r1 = r11.f28510j;
        r1 = r1.f28607l;
        r1 = java.lang.String.valueOf(r1);
        r3 = r1.length();
        if (r3 == 0) goto L_0x0107;
    L_0x0102:
        r0 = r0.concat(r1);
        goto L_0x010d;
    L_0x0107:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x010d:
        r12.<init>(r0, r2);
        throw r12;
    L_0x0111:
        r12 = new com.google.android.gms.internal.ads.cz;
        r0 = "The ad response must specify one of the supported ad sizes.";
        r12.<init>(r0, r2);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.cp.a(com.google.android.gms.internal.ads.dl):com.google.android.gms.internal.ads.aou");
    }

    /* renamed from: a */
    private final void m37442a(int i, String str) {
        dl dlVar;
        cp cpVar = this;
        int i2 = i;
        if (i2 != 3) {
            if (i2 != -1) {
                mt.m19924e(str);
                cpVar.f28510j = cpVar.f28510j != null ? new dp(i2) : new dp(i2, cpVar.f28510j.f28605j);
                if (cpVar.f28508h == null) {
                    dlVar = cpVar.f28508h;
                } else {
                    dl dlVar2 = new dl(cpVar.f28503c, -1, null, null, null);
                }
                cpVar.f28502b.m19374a(new it(dlVar, cpVar.f28510j, cpVar.f28511k, null, i, -1, cpVar.f28510j.f28608m, null, cpVar.f28506f, null));
            }
        }
        mt.m19922d(str);
        if (cpVar.f28510j != null) {
        }
        cpVar.f28510j = cpVar.f28510j != null ? new dp(i2) : new dp(i2, cpVar.f28510j.f28605j);
        if (cpVar.f28508h == null) {
            dl dlVar22 = new dl(cpVar.f28503c, -1, null, null, null);
        } else {
            dlVar = cpVar.f28508h;
        }
        cpVar.f28502b.m19374a(new it(dlVar, cpVar.f28510j, cpVar.f28511k, null, i, -1, cpVar.f28510j.f28608m, null, cpVar.f28506f, null));
    }

    /* renamed from: a */
    final kp m37446a(mv mvVar, ob<dl> obVar) {
        Context context = this.f28505e;
        if (new db(context).mo4234a(mvVar)) {
            mt.m19918b("Fetching ad response from local ad request service.");
            kp diVar = new di(context, obVar, this);
            diVar.mo3819c();
            return diVar;
        }
        mt.m19918b("Fetching ad response from remote ad request service.");
        aph.m18683a();
        if (mi.m19880c(context)) {
            return new dj(context, mvVar, obVar, this);
        }
        mt.m19924e("Failed to connect to remote ad request service.");
        return null;
    }

    /* renamed from: a */
    public final void mo6079a() {
        mt.m19918b("AdLoaderBackgroundTask started.");
        this.f28509i = new cx(this);
        jw.f15691a.postDelayed(this.f28509i, ((Long) aph.m18688f().m18889a(asp.bA)).longValue());
        long b = ax.l().b();
        if (((Boolean) aph.m18688f().m18889a(asp.by)).booleanValue() && this.f28503c.f15303b.f28263c != null) {
            String string = this.f28503c.f15303b.f28263c.getString("_ad");
            if (string != null) {
                this.f28508h = new dl(this.f28503c, b, null, null, null);
                mo4235a(ez.m19396a(this.f28505e, this.f28508h, string));
                return;
            }
        }
        ob ofVar = new of();
        ju.m19678a(new cy(this, ofVar));
        String h = ax.B().m19553h(this.f28505e);
        String i = ax.B().m19554i(this.f28505e);
        String j = ax.B().m19555j(this.f28505e);
        ax.B().m19550f(this.f28505e, j);
        this.f28508h = new dl(this.f28503c, b, h, i, j);
        ofVar.mo4321a(this.f28508h);
    }

    /* renamed from: a */
    final /* synthetic */ void m37448a(ano ano) {
        ano.f28167c.f28153a = this.f28503c.f15307f.packageName;
    }

    /* renamed from: a */
    public final void mo4235a(dp dpVar) {
        mt.m19918b("Received ad response.");
        this.f28510j = dpVar;
        long b = ax.l().b();
        synchronized (this.f28504d) {
            kp kpVar = null;
            this.f28501a = null;
        }
        ax.i().m30847l().m19664d(this.f28510j.f28577F);
        if (((Boolean) aph.m18688f().m18889a(asp.aT)).booleanValue()) {
            if (this.f28510j.f28585N) {
                ax.i().m30847l().m19661c(this.f28508h.f28549e);
            } else {
                ax.i().m30847l().m19663d(this.f28508h.f28549e);
            }
        }
        try {
            JSONObject jSONObject;
            aoq aoq;
            Bundle bundle;
            Bundle bundle2;
            if (this.f28510j.f28599d != -2) {
                if (this.f28510j.f28599d != -3) {
                    int i = this.f28510j.f28599d;
                    StringBuilder stringBuilder = new StringBuilder(66);
                    stringBuilder.append("There was a problem getting an ad response. ErrorCode: ");
                    stringBuilder.append(i);
                    throw new cz(stringBuilder.toString(), this.f28510j.f28599d);
                }
            }
            if (this.f28510j.f28599d != -3) {
                if (TextUtils.isEmpty(this.f28510j.f28597b)) {
                    throw new cz("No fill from ad server.", 3);
                }
                ax.i().m30847l().m19653a(this.f28510j.f28615t);
                if (this.f28510j.f28602g) {
                    this.f28511k = new bci(this.f28510j.f28597b);
                    ax.i().m30835a(this.f28511k.f15201h);
                } else {
                    ax.i().m30835a(this.f28510j.f28580I);
                }
                if (!TextUtils.isEmpty(this.f28510j.f28578G)) {
                    if (((Boolean) aph.m18688f().m18889a(asp.cC)).booleanValue()) {
                        mt.m19918b("Received cookie from server. Setting webview cookie in CookieManager.");
                        CookieManager c = ax.g().mo6908c(this.f28505e);
                        if (c != null) {
                            c.setCookie("googleads.g.doubleclick.net", this.f28510j.f28578G);
                        }
                    }
                }
            }
            aou a = this.f28508h.f28548d.f28285g != null ? m37440a(this.f28508h) : null;
            ax.i().m30847l().m19658b(this.f28510j.f28616u);
            ax.i().m30847l().m19662c(this.f28510j.f28584M);
            if (!TextUtils.isEmpty(this.f28510j.f28612q)) {
                try {
                    jSONObject = new JSONObject(this.f28510j.f28612q);
                } catch (Throwable e) {
                    mt.m19919b("Error parsing the JSON for Active View.", e);
                }
                if (this.f28510j.f28587P == 2) {
                    kpVar = Boolean.valueOf(true);
                    aoq = this.f28508h.f28547c;
                    bundle = aoq.f28273m == null ? aoq.f28273m : new Bundle();
                    if (bundle.getBundle(AdMobAdapter.class.getName()) == null) {
                        bundle = bundle.getBundle(AdMobAdapter.class.getName());
                    } else {
                        bundle2 = new Bundle();
                        bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
                        bundle = bundle2;
                    }
                    bundle.putBoolean("render_test_label", true);
                }
                if (this.f28510j.f28587P == 1) {
                    kpVar = Boolean.valueOf(false);
                }
                this.f28502b.m19374a(new it(this.f28508h, this.f28510j, this.f28511k, a, -2, b, this.f28510j.f28608m, jSONObject, this.f28506f, this.f28510j.f28587P != 0 ? Boolean.valueOf(ma.m19847a(this.f28508h.f28547c)) : kpVar));
                jw.f15691a.removeCallbacks(this.f28509i);
            }
            jSONObject = null;
            if (this.f28510j.f28587P == 2) {
                kpVar = Boolean.valueOf(true);
                aoq = this.f28508h.f28547c;
                if (aoq.f28273m == null) {
                }
                if (bundle.getBundle(AdMobAdapter.class.getName()) == null) {
                    bundle2 = new Bundle();
                    bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
                    bundle = bundle2;
                } else {
                    bundle = bundle.getBundle(AdMobAdapter.class.getName());
                }
                bundle.putBoolean("render_test_label", true);
            }
            if (this.f28510j.f28587P == 1) {
                kpVar = Boolean.valueOf(false);
            }
            if (this.f28510j.f28587P != 0) {
            }
            this.f28502b.m19374a(new it(this.f28508h, this.f28510j, this.f28511k, a, -2, b, this.f28510j.f28608m, jSONObject, this.f28506f, this.f28510j.f28587P != 0 ? Boolean.valueOf(ma.m19847a(this.f28508h.f28547c)) : kpVar));
        } catch (Throwable e2) {
            mt.m19919b("Could not parse mediation config.", e2);
            String str = "Could not parse mediation config: ";
            String valueOf = String.valueOf(this.f28510j.f28597b);
            throw new cz(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (cz e3) {
            m37442a(e3.m19375a(), e3.getMessage());
        }
        jw.f15691a.removeCallbacks(this.f28509i);
    }

    /* renamed from: b */
    final /* synthetic */ void m37450b(ano ano) {
        ano.f28165a = this.f28503c.f15323v;
    }

    public final void h_() {
        synchronized (this.f28504d) {
            if (this.f28501a != null) {
                this.f28501a.mo3818b();
            }
        }
    }
}
