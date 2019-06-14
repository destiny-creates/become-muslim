package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.C2683b;
import com.google.android.gms.ads.p168b.C2611d;
import com.google.android.gms.ads.p168b.C2611d.C2610a;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@cm
public final class bcm implements bcq {
    /* renamed from: a */
    private final String f23899a;
    /* renamed from: b */
    private final bcy f23900b;
    /* renamed from: c */
    private final long f23901c;
    /* renamed from: d */
    private final bci f23902d;
    /* renamed from: e */
    private final bch f23903e;
    /* renamed from: f */
    private aoq f23904f;
    /* renamed from: g */
    private final aou f23905g;
    /* renamed from: h */
    private final Context f23906h;
    /* renamed from: i */
    private final Object f23907i = new Object();
    /* renamed from: j */
    private final mv f23908j;
    /* renamed from: k */
    private final boolean f23909k;
    /* renamed from: l */
    private final aus f23910l;
    /* renamed from: m */
    private final List<String> f23911m;
    /* renamed from: n */
    private final List<String> f23912n;
    /* renamed from: o */
    private final List<String> f23913o;
    /* renamed from: p */
    private final boolean f23914p;
    /* renamed from: q */
    private final boolean f23915q;
    /* renamed from: r */
    private bdb f23916r;
    /* renamed from: s */
    private int f23917s = -2;
    /* renamed from: t */
    private bdh f23918t;

    public bcm(Context context, String str, bcy bcy, bci bci, bch bch, aoq aoq, aou aou, mv mvVar, boolean z, boolean z2, aus aus, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        String str2 = str;
        bci bci2 = bci;
        bch bch2 = bch;
        this.f23906h = context;
        this.f23900b = bcy;
        this.f23903e = bch2;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            str2 = m30446b();
        }
        r0.f23899a = str2;
        r0.f23902d = bci2;
        long j = bch2.f15192t != -1 ? bch2.f15192t : bci2.f15195b != -1 ? bci2.f15195b : 10000;
        r0.f23901c = j;
        r0.f23904f = aoq;
        r0.f23905g = aou;
        r0.f23908j = mvVar;
        r0.f23909k = z;
        r0.f23914p = z2;
        r0.f23910l = aus;
        r0.f23911m = list;
        r0.f23912n = list2;
        r0.f23913o = list3;
        r0.f23915q = z3;
    }

    /* renamed from: a */
    private static bdb m30437a(C2683b c2683b) {
        return new bdw(c2683b);
    }

    /* renamed from: a */
    private final java.lang.String m30440a(java.lang.String r3) {
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
        if (r3 == 0) goto L_0x0024;
    L_0x0002:
        r0 = r2.m30452e();
        if (r0 == 0) goto L_0x0024;
    L_0x0008:
        r0 = 2;
        r0 = r2.m30447b(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0024;
    L_0x0010:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001f }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x001f }
        r1 = "cpm_floor_cents";	 Catch:{ JSONException -> 0x001f }
        r0.remove(r1);	 Catch:{ JSONException -> 0x001f }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x001f }
        return r0;
    L_0x001f:
        r0 = "Could not remove field. Returning the original value";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
    L_0x0024:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcm.a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private final void m30441a(bcl bcl) {
        String a = m30440a(this.f23903e.f15183k);
        try {
            if (this.f23908j.f28711c >= 4100000) {
                if (!this.f23909k) {
                    if (!this.f23903e.m19221b()) {
                        if (this.f23905g.f28282d) {
                            this.f23916r.mo4109a(C4757d.a(this.f23906h), this.f23904f, a, this.f23903e.f15173a, (bde) bcl);
                            return;
                        } else if (!this.f23914p) {
                            this.f23916r.mo4112a(C4757d.a(this.f23906h), this.f23905g, this.f23904f, a, this.f23903e.f15173a, bcl);
                            return;
                        } else if (this.f23903e.f15187o != null) {
                            this.f23916r.mo4110a(C4757d.a(this.f23906h), this.f23904f, a, this.f23903e.f15173a, bcl, new aus(m30445b(this.f23903e.f15191s)), this.f23903e.f15190r);
                            return;
                        } else {
                            this.f23916r.mo4112a(C4757d.a(this.f23906h), this.f23905g, this.f23904f, a, this.f23903e.f15173a, bcl);
                            return;
                        }
                    }
                }
                List arrayList = new ArrayList(this.f23911m);
                if (this.f23912n != null) {
                    for (String str : this.f23912n) {
                        String str2 = ":false";
                        if (this.f23913o != null && this.f23913o.contains(str)) {
                            str2 = ":true";
                        }
                        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length());
                        stringBuilder.append("custom:");
                        stringBuilder.append(str);
                        stringBuilder.append(str2);
                        arrayList.add(stringBuilder.toString());
                    }
                }
                this.f23916r.mo4110a(C4757d.a(this.f23906h), this.f23904f, a, this.f23903e.f15173a, bcl, this.f23910l, arrayList);
            } else if (this.f23905g.f28282d) {
                this.f23916r.mo4107a(C4757d.a(this.f23906h), this.f23904f, a, bcl);
            } else {
                this.f23916r.mo4111a(C4757d.a(this.f23906h), this.f23905g, this.f23904f, a, (bde) bcl);
            }
        } catch (Throwable e) {
            mt.m19921c("Could not request ad from mediation adapter.", e);
            mo4097a(5);
        }
    }

    /* renamed from: b */
    private static C2611d m30445b(String str) {
        C2610a c2610a = new C2610a();
        if (str == null) {
            return c2610a.a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            c2610a.b(jSONObject.optBoolean("multiple_images", false));
            c2610a.a(jSONObject.optBoolean("only_urls", false));
            str = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(str)) {
                i = 2;
            } else if ("portrait".equals(str)) {
                i = 1;
            } else if (!"any".equals(str)) {
                i = -1;
            }
            c2610a.a(i);
        } catch (Throwable e) {
            mt.m19921c("Exception occurred when creating native ad options", e);
        }
        return c2610a.a();
    }

    /* renamed from: b */
    private final java.lang.String m30446b() {
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
        r0 = r2.f23903e;	 Catch:{ RemoteException -> 0x001c }
        r0 = r0.f15177e;	 Catch:{ RemoteException -> 0x001c }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ RemoteException -> 0x001c }
        if (r0 != 0) goto L_0x0021;	 Catch:{ RemoteException -> 0x001c }
    L_0x000a:
        r0 = r2.f23900b;	 Catch:{ RemoteException -> 0x001c }
        r1 = r2.f23903e;	 Catch:{ RemoteException -> 0x001c }
        r1 = r1.f15177e;	 Catch:{ RemoteException -> 0x001c }
        r0 = r0.mo4103b(r1);	 Catch:{ RemoteException -> 0x001c }
        if (r0 == 0) goto L_0x0019;	 Catch:{ RemoteException -> 0x001c }
    L_0x0016:
        r0 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";	 Catch:{ RemoteException -> 0x001c }
        return r0;	 Catch:{ RemoteException -> 0x001c }
    L_0x0019:
        r0 = "com.google.ads.mediation.customevent.CustomEventAdapter";	 Catch:{ RemoteException -> 0x001c }
        return r0;
    L_0x001c:
        r0 = "Fail to determine the custom event's version, assuming the old one.";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
    L_0x0021:
        r0 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcm.b():java.lang.String");
    }

    /* renamed from: b */
    private final boolean m30447b(int r4) {
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
        r3 = this;
        r0 = 0;
        r1 = r3.f23909k;	 Catch:{ RemoteException -> 0x002d }
        if (r1 == 0) goto L_0x000c;	 Catch:{ RemoteException -> 0x002d }
    L_0x0005:
        r1 = r3.f23916r;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.mo4127l();	 Catch:{ RemoteException -> 0x002d }
        goto L_0x001f;	 Catch:{ RemoteException -> 0x002d }
    L_0x000c:
        r1 = r3.f23905g;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.f28282d;	 Catch:{ RemoteException -> 0x002d }
        if (r1 == 0) goto L_0x0019;	 Catch:{ RemoteException -> 0x002d }
    L_0x0012:
        r1 = r3.f23916r;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.mo4126k();	 Catch:{ RemoteException -> 0x002d }
        goto L_0x001f;	 Catch:{ RemoteException -> 0x002d }
    L_0x0019:
        r1 = r3.f23916r;	 Catch:{ RemoteException -> 0x002d }
        r1 = r1.mo4125j();	 Catch:{ RemoteException -> 0x002d }
    L_0x001f:
        if (r1 == 0) goto L_0x002c;
    L_0x0021:
        r2 = "capabilities";
        r1 = r1.getInt(r2, r0);
        r1 = r1 & r4;
        if (r1 != r4) goto L_0x002c;
    L_0x002a:
        r4 = 1;
        return r4;
    L_0x002c:
        return r0;
    L_0x002d:
        r4 = "Could not get adapter info. Returning false";
        com.google.android.gms.internal.ads.mt.m19924e(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcm.b(int):boolean");
    }

    /* renamed from: c */
    private final com.google.android.gms.internal.ads.bdh m30449c() {
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
        r0 = r2.f23917s;
        if (r0 != 0) goto L_0x0030;
    L_0x0004:
        r0 = r2.m30452e();
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        goto L_0x0030;
    L_0x000b:
        r0 = 4;
        r0 = r2.m30447b(r0);	 Catch:{ RemoteException -> 0x0021 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0021 }
    L_0x0012:
        r0 = r2.f23918t;	 Catch:{ RemoteException -> 0x0021 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0021 }
    L_0x0016:
        r0 = r2.f23918t;	 Catch:{ RemoteException -> 0x0021 }
        r0 = r0.mo4144a();	 Catch:{ RemoteException -> 0x0021 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0021 }
    L_0x001e:
        r0 = r2.f23918t;	 Catch:{ RemoteException -> 0x0021 }
        return r0;
    L_0x0021:
        r0 = "Could not get cpm value from MediationResponseMetadata";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
    L_0x0026:
        r0 = r2.m30454f();
        r1 = new com.google.android.gms.internal.ads.bco;
        r1.<init>(r0);
        return r1;
    L_0x0030:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcm.c():com.google.android.gms.internal.ads.bdh");
    }

    /* renamed from: d */
    private final bdb m30450d() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.f23899a);
        mt.m19922d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!(this.f23909k || this.f23903e.m19221b())) {
            if (((Boolean) aph.m18688f().m18889a(asp.bw)).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f23899a)) {
                return m30437a(new AdMobAdapter());
            }
            if (((Boolean) aph.m18688f().m18889a(asp.bx)).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f23899a)) {
                return m30437a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f23899a)) {
                return new bdw(new zzzv());
            }
        }
        try {
            return this.f23900b.mo4102a(this.f23899a);
        } catch (Throwable e) {
            valueOf = "Could not instantiate mediation adapter: ";
            String valueOf2 = String.valueOf(this.f23899a);
            mt.m19916a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), e);
            return null;
        }
    }

    /* renamed from: e */
    private final boolean m30452e() {
        return this.f23902d.f15206m != -1;
    }

    /* renamed from: f */
    private final int m30454f() {
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
        r0 = r4.f23903e;
        r0 = r0.f15183k;
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003a }
        r2 = r4.f23903e;	 Catch:{ JSONException -> 0x003a }
        r2 = r2.f15183k;	 Catch:{ JSONException -> 0x003a }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x003a }
        r2 = "com.google.ads.mediation.admob.AdMobAdapter";
        r3 = r4.f23899a;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0022;
    L_0x001b:
        r2 = "cpm_cents";
        r0 = r0.optInt(r2, r1);
        return r0;
    L_0x0022:
        r2 = 2;
        r2 = r4.m30447b(r2);
        if (r2 == 0) goto L_0x0030;
    L_0x0029:
        r2 = "cpm_floor_cents";
        r2 = r0.optInt(r2, r1);
        goto L_0x0031;
    L_0x0030:
        r2 = 0;
    L_0x0031:
        if (r2 != 0) goto L_0x0039;
    L_0x0033:
        r2 = "penalized_average_cpm_cents";
        r2 = r0.optInt(r2, r1);
    L_0x0039:
        return r2;
    L_0x003a:
        r0 = "Could not convert to json. Returning 0";
        com.google.android.gms.internal.ads.mt.m19924e(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcm.f():int");
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.ads.bcp m30456a(long r17, long r19) {
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
        r16 = this;
        r1 = r16;
        r2 = r1.f23907i;
        monitor-enter(r2);
        r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x006d }
        r9 = new com.google.android.gms.internal.ads.bcl;	 Catch:{ all -> 0x006d }
        r9.<init>();	 Catch:{ all -> 0x006d }
        r0 = com.google.android.gms.internal.ads.jw.f15691a;	 Catch:{ all -> 0x006d }
        r5 = new com.google.android.gms.internal.ads.bcn;	 Catch:{ all -> 0x006d }
        r5.<init>(r1, r9);	 Catch:{ all -> 0x006d }
        r0.post(r5);	 Catch:{ all -> 0x006d }
        r5 = r1.f23901c;	 Catch:{ all -> 0x006d }
    L_0x001a:
        r0 = r1.f23917s;	 Catch:{ all -> 0x006d }
        r7 = -2;	 Catch:{ all -> 0x006d }
        if (r0 == r7) goto L_0x003e;	 Catch:{ all -> 0x006d }
    L_0x001f:
        r0 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ all -> 0x006d }
        r5 = r0.b();	 Catch:{ all -> 0x006d }
        r0 = 0;	 Catch:{ all -> 0x006d }
        r12 = r5 - r3;	 Catch:{ all -> 0x006d }
        r0 = new com.google.android.gms.internal.ads.bcp;	 Catch:{ all -> 0x006d }
        r6 = r1.f23903e;	 Catch:{ all -> 0x006d }
        r7 = r1.f23916r;	 Catch:{ all -> 0x006d }
        r8 = r1.f23899a;	 Catch:{ all -> 0x006d }
        r10 = r1.f23917s;	 Catch:{ all -> 0x006d }
        r11 = r16.m30449c();	 Catch:{ all -> 0x006d }
        r5 = r0;	 Catch:{ all -> 0x006d }
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x006d }
        monitor-exit(r2);	 Catch:{ all -> 0x006d }
        return r0;	 Catch:{ all -> 0x006d }
    L_0x003e:
        r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x006d }
        r0 = 0;
        r10 = r7 - r3;
        r10 = r5 - r10;
        r7 = r7 - r17;
        r7 = r19 - r7;
        r14 = 0;
        r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r0 <= 0) goto L_0x0064;
    L_0x0051:
        r0 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1));
        if (r0 > 0) goto L_0x0056;
    L_0x0055:
        goto L_0x0064;
    L_0x0056:
        r0 = r1.f23907i;	 Catch:{ InterruptedException -> 0x0060 }
        r7 = java.lang.Math.min(r10, r7);	 Catch:{ InterruptedException -> 0x0060 }
        r0.wait(r7);	 Catch:{ InterruptedException -> 0x0060 }
        goto L_0x001a;
    L_0x0060:
        r0 = 5;
        r1.f23917s = r0;	 Catch:{ all -> 0x006d }
        goto L_0x001a;	 Catch:{ all -> 0x006d }
    L_0x0064:
        r0 = "Timed out waiting for adapter.";	 Catch:{ all -> 0x006d }
        com.google.android.gms.internal.ads.mt.m19922d(r0);	 Catch:{ all -> 0x006d }
        r0 = 3;	 Catch:{ all -> 0x006d }
        r1.f23917s = r0;	 Catch:{ all -> 0x006d }
        goto L_0x001a;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r0 = move-exception;	 Catch:{ all -> 0x006d }
        monitor-exit(r2);	 Catch:{ all -> 0x006d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcm.a(long, long):com.google.android.gms.internal.ads.bcp");
    }

    /* renamed from: a */
    public final void m30457a() {
        synchronized (this.f23907i) {
            try {
                if (this.f23916r != null) {
                    this.f23916r.mo4118c();
                }
            } catch (Throwable e) {
                mt.m19921c("Could not destroy mediation adapter.", e);
            }
            this.f23917s = -1;
            this.f23907i.notify();
        }
    }

    /* renamed from: a */
    public final void mo4097a(int i) {
        synchronized (this.f23907i) {
            this.f23917s = i;
            this.f23907i.notify();
        }
    }

    /* renamed from: a */
    public final void mo4098a(int i, bdh bdh) {
        synchronized (this.f23907i) {
            this.f23917s = 0;
            this.f23918t = bdh;
            this.f23907i.notify();
        }
    }
}
