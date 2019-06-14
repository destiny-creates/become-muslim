package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@cm
public final class hg extends ji implements hf {
    /* renamed from: a */
    private final it f28683a;
    /* renamed from: b */
    private final Context f28684b;
    /* renamed from: c */
    private final ArrayList<gw> f28685c;
    /* renamed from: d */
    private final List<gz> f28686d;
    /* renamed from: e */
    private final HashSet<String> f28687e;
    /* renamed from: f */
    private final Object f28688f;
    /* renamed from: g */
    private final fw f28689g;
    /* renamed from: h */
    private final long f28690h;

    public hg(Context context, it itVar, fw fwVar) {
        Context context2 = context;
        it itVar2 = itVar;
        fw fwVar2 = fwVar;
        this(context2, itVar2, fwVar2, ((Long) aph.m18688f().m18889a(asp.aE)).longValue());
    }

    private hg(Context context, it itVar, fw fwVar, long j) {
        this.f28685c = new ArrayList();
        this.f28686d = new ArrayList();
        this.f28687e = new HashSet();
        this.f28688f = new Object();
        this.f28684b = context;
        this.f28683a = itVar;
        this.f28689g = fwVar;
        this.f28690h = j;
    }

    /* renamed from: a */
    private final is m37540a(int i, String str, bch bch) {
        String stringBuilder;
        aou aou;
        boolean z;
        String str2;
        long j;
        aoq aoq = this.f28683a.f15600a.f28547c;
        List list = this.f28683a.f15601b.f28598c;
        List list2 = this.f28683a.f15601b.f28600e;
        List list3 = this.f28683a.f15601b.f28604i;
        int i2 = this.f28683a.f15601b.f28606k;
        long j2 = this.f28683a.f15601b.f28605j;
        String str3 = this.f28683a.f15600a.f28553i;
        boolean z2 = this.f28683a.f15601b.f28602g;
        bci bci = this.f28683a.f15602c;
        long j3 = this.f28683a.f15601b.f28603h;
        aou aou2 = this.f28683a.f15603d;
        long j4 = j3;
        bci bci2 = bci;
        long j5 = this.f28683a.f15601b.f28601f;
        long j6 = this.f28683a.f15605f;
        long j7 = this.f28683a.f15601b.f28608m;
        String str4 = this.f28683a.f15601b.f28609n;
        JSONObject jSONObject = this.f28683a.f15607h;
        hq hqVar = this.f28683a.f15601b.f28572A;
        JSONObject jSONObject2 = jSONObject;
        List list4 = this.f28683a.f15601b.f28573B;
        List list5 = this.f28683a.f15601b.f28574C;
        boolean z3 = this.f28683a.f15601b.f28575D;
        dr drVar = this.f28683a.f15601b.f28576E;
        hq hqVar2 = hqVar;
        StringBuilder stringBuilder2 = new StringBuilder("");
        if (this.f28686d == null) {
            stringBuilder = stringBuilder2.toString();
            aou = aou2;
            z = z2;
            str2 = str4;
            j = j7;
        } else {
            Iterator it = r0.f28686d.iterator();
            while (true) {
                aou = aou2;
                if (it.hasNext()) {
                    gz gzVar = (gz) it.next();
                    if (gzVar != null) {
                        Iterator it2 = it;
                        if (TextUtils.isEmpty(gzVar.f15518a)) {
                            aou2 = aou;
                            it = it2;
                        } else {
                            int i3;
                            String str5 = gzVar.f15518a;
                            str2 = str4;
                            switch (gzVar.f15519b) {
                                case 3:
                                    j = j7;
                                    i3 = 1;
                                    break;
                                case 4:
                                    j = j7;
                                    i3 = 2;
                                    break;
                                case 5:
                                    j = j7;
                                    i3 = 4;
                                    break;
                                case 6:
                                    j = j7;
                                    i3 = 0;
                                    break;
                                case 7:
                                    j = j7;
                                    i3 = 3;
                                    break;
                                default:
                                    j = j7;
                                    i3 = 6;
                                    break;
                            }
                            j7 = gzVar.f15520c;
                            z = z2;
                            StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(str5).length() + 33);
                            stringBuilder3.append(str5);
                            stringBuilder3.append(".");
                            stringBuilder3.append(i3);
                            stringBuilder3.append(".");
                            stringBuilder3.append(j7);
                            stringBuilder2.append(String.valueOf(stringBuilder3.toString()).concat("_"));
                            aou2 = aou;
                            it = it2;
                            str4 = str2;
                            j7 = j;
                            z2 = z;
                        }
                    } else {
                        aou2 = aou;
                    }
                } else {
                    z = z2;
                    str2 = str4;
                    j = j7;
                    stringBuilder = stringBuilder2.substring(0, Math.max(0, stringBuilder2.length() - 1));
                }
            }
        }
        return new is(aoq, null, list, i, list2, list3, i2, j2, str3, z, bch, null, str, bci2, null, j4, aou, j5, j6, j, str2, jSONObject2, null, hqVar2, list4, list5, z3, drVar, stringBuilder, r0.f28683a.f15601b.f28579H, r0.f28683a.f15601b.f28583L, r0.f28683a.f15608i, r0.f28683a.f15601b.f28586O, r0.f28683a.f15609j, r0.f28683a.f15601b.f28588Q, r0.f28683a.f15601b.f28589R, r0.f28683a.f15601b.f28590S, r0.f28683a.f15601b.f28591T);
    }

    /* renamed from: a */
    public final void mo6079a() {
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
        r19 = this;
        r11 = r19;
        r0 = r11.f28683a;
        r0 = r0.f15602c;
        r0 = r0.f15194a;
        r12 = r0.iterator();
    L_0x000c:
        r0 = r12.hasNext();
        if (r0 == 0) goto L_0x00bf;
    L_0x0012:
        r0 = r12.next();
        r13 = r0;
        r13 = (com.google.android.gms.internal.ads.bch) r13;
        r14 = r13.f15183k;
        r0 = r13.f15175c;
        r15 = r0.iterator();
    L_0x0021:
        r0 = r15.hasNext();
        if (r0 == 0) goto L_0x000c;
    L_0x0027:
        r0 = r15.next();
        r0 = (java.lang.String) r0;
        r1 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0040;
    L_0x0035:
        r1 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x003e;
    L_0x003d:
        goto L_0x0040;
    L_0x003e:
        r3 = r0;
        goto L_0x004c;
    L_0x0040:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b7 }
        r0.<init>(r14);	 Catch:{ JSONException -> 0x00b7 }
        r1 = "class_name";	 Catch:{ JSONException -> 0x00b7 }
        r0 = r0.getString(r1);	 Catch:{ JSONException -> 0x00b7 }
        goto L_0x003e;
    L_0x004c:
        r9 = r11.f28688f;
        monitor-enter(r9);
        r0 = r11.f28689g;	 Catch:{ all -> 0x00b0 }
        r7 = r0.m19444a(r3);	 Catch:{ all -> 0x00b0 }
        if (r7 == 0) goto L_0x008a;	 Catch:{ all -> 0x00b0 }
    L_0x0057:
        r0 = r7.m19502b();	 Catch:{ all -> 0x00b0 }
        if (r0 == 0) goto L_0x008a;	 Catch:{ all -> 0x00b0 }
    L_0x005d:
        r0 = r7.m19501a();	 Catch:{ all -> 0x00b0 }
        if (r0 != 0) goto L_0x0064;	 Catch:{ all -> 0x00b0 }
    L_0x0063:
        goto L_0x008a;	 Catch:{ all -> 0x00b0 }
    L_0x0064:
        r0 = new com.google.android.gms.internal.ads.gw;	 Catch:{ all -> 0x00b0 }
        r2 = r11.f28684b;	 Catch:{ all -> 0x00b0 }
        r6 = r11.f28683a;	 Catch:{ all -> 0x00b0 }
        r4 = r11.f28690h;	 Catch:{ all -> 0x00b0 }
        r1 = r0;
        r16 = r4;
        r4 = r14;
        r5 = r13;
        r8 = r19;
        r18 = r9;
        r9 = r16;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x00b5 }
        r1 = r11.f28689g;	 Catch:{ all -> 0x00b5 }
        r1 = r1.m19443a();	 Catch:{ all -> 0x00b5 }
        r0.m37518a(r1);	 Catch:{ all -> 0x00b5 }
        r1 = r11.f28685c;	 Catch:{ all -> 0x00b5 }
        r1.add(r0);	 Catch:{ all -> 0x00b5 }
    L_0x0088:
        monitor-exit(r18);	 Catch:{ all -> 0x00b5 }
        goto L_0x0021;	 Catch:{ all -> 0x00b5 }
    L_0x008a:
        r18 = r9;	 Catch:{ all -> 0x00b5 }
        r0 = r11.f28686d;	 Catch:{ all -> 0x00b5 }
        r1 = new com.google.android.gms.internal.ads.hb;	 Catch:{ all -> 0x00b5 }
        r1.<init>();	 Catch:{ all -> 0x00b5 }
        r2 = r13.f15176d;	 Catch:{ all -> 0x00b5 }
        r1 = r1.m19491b(r2);	 Catch:{ all -> 0x00b5 }
        r1 = r1.m19490a(r3);	 Catch:{ all -> 0x00b5 }
        r2 = 0;	 Catch:{ all -> 0x00b5 }
        r1 = r1.m19489a(r2);	 Catch:{ all -> 0x00b5 }
        r2 = 7;	 Catch:{ all -> 0x00b5 }
        r1 = r1.m19488a(r2);	 Catch:{ all -> 0x00b5 }
        r1 = r1.m19487a();	 Catch:{ all -> 0x00b5 }
        r0.add(r1);	 Catch:{ all -> 0x00b5 }
        goto L_0x0088;	 Catch:{ all -> 0x00b5 }
    L_0x00b0:
        r0 = move-exception;	 Catch:{ all -> 0x00b5 }
        r18 = r9;	 Catch:{ all -> 0x00b5 }
    L_0x00b3:
        monitor-exit(r18);	 Catch:{ all -> 0x00b5 }
        throw r0;
    L_0x00b5:
        r0 = move-exception;
        goto L_0x00b3;
    L_0x00b7:
        r0 = move-exception;
        r1 = "Unable to determine custom event class name, skipping...";
        com.google.android.gms.internal.ads.mt.m19919b(r1, r0);
        goto L_0x0021;
    L_0x00bf:
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = r11.f28685c;
        r1 = (java.util.ArrayList) r1;
        r2 = r1.size();
        r3 = 0;
        r4 = 0;
    L_0x00ce:
        if (r4 >= r2) goto L_0x00e4;
    L_0x00d0:
        r5 = r1.get(r4);
        r4 = r4 + 1;
        r5 = (com.google.android.gms.internal.ads.gw) r5;
        r6 = r5.f28665a;
        r6 = r0.add(r6);
        if (r6 == 0) goto L_0x00ce;
    L_0x00e0:
        r5.m37521d();
        goto L_0x00ce;
    L_0x00e4:
        r0 = r11.f28685c;
        r1 = r0;
        r1 = (java.util.ArrayList) r1;
        r2 = r1.size();
    L_0x00ed:
        if (r3 >= r2) goto L_0x019a;
    L_0x00ef:
        r0 = r1.get(r3);
        r3 = r3 + 1;
        r4 = r0;
        r4 = (com.google.android.gms.internal.ads.gw) r4;
        r0 = r4.m37521d();	 Catch:{ InterruptedException -> 0x0161, Exception -> 0x0142 }
        r0.get();	 Catch:{ InterruptedException -> 0x0161, Exception -> 0x0142 }
        r5 = r11.f28688f;
        monitor-enter(r5);
        r0 = r4.f28665a;	 Catch:{ all -> 0x013d }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x013d }
        if (r0 != 0) goto L_0x0113;	 Catch:{ all -> 0x013d }
    L_0x010a:
        r0 = r11.f28686d;	 Catch:{ all -> 0x013d }
        r6 = r4.m37522e();	 Catch:{ all -> 0x013d }
        r0.add(r6);	 Catch:{ all -> 0x013d }
    L_0x0113:
        monitor-exit(r5);	 Catch:{ all -> 0x013d }
        r6 = r11.f28688f;
        monitor-enter(r6);
        r0 = r11.f28687e;	 Catch:{ all -> 0x013a }
        r5 = r4.f28665a;	 Catch:{ all -> 0x013a }
        r0 = r0.contains(r5);	 Catch:{ all -> 0x013a }
        if (r0 == 0) goto L_0x0138;	 Catch:{ all -> 0x013a }
    L_0x0121:
        r0 = r4.f28665a;	 Catch:{ all -> 0x013a }
        r1 = r4.m37523f();	 Catch:{ all -> 0x013a }
        r2 = -2;	 Catch:{ all -> 0x013a }
        r0 = r11.m37540a(r2, r0, r1);	 Catch:{ all -> 0x013a }
        r1 = com.google.android.gms.internal.ads.mi.f15796a;	 Catch:{ all -> 0x013a }
        r2 = new com.google.android.gms.internal.ads.hh;	 Catch:{ all -> 0x013a }
        r2.<init>(r11, r0);	 Catch:{ all -> 0x013a }
        r1.post(r2);	 Catch:{ all -> 0x013a }
        monitor-exit(r6);	 Catch:{ all -> 0x013a }
        return;	 Catch:{ all -> 0x013a }
    L_0x0138:
        monitor-exit(r6);	 Catch:{ all -> 0x013a }
        goto L_0x00ed;	 Catch:{ all -> 0x013a }
    L_0x013a:
        r0 = move-exception;	 Catch:{ all -> 0x013a }
        monitor-exit(r6);	 Catch:{ all -> 0x013a }
        throw r0;
    L_0x013d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x013d }
        throw r0;
    L_0x0140:
        r0 = move-exception;
        goto L_0x0181;
    L_0x0142:
        r0 = move-exception;
        r5 = "Unable to resolve rewarded adapter.";	 Catch:{ all -> 0x0140 }
        com.google.android.gms.internal.ads.mt.m19921c(r5, r0);	 Catch:{ all -> 0x0140 }
        r5 = r11.f28688f;
        monitor-enter(r5);
        r0 = r4.f28665a;	 Catch:{ all -> 0x015e }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x015e }
        if (r0 != 0) goto L_0x015c;	 Catch:{ all -> 0x015e }
    L_0x0153:
        r0 = r11.f28686d;	 Catch:{ all -> 0x015e }
        r4 = r4.m37522e();	 Catch:{ all -> 0x015e }
        r0.add(r4);	 Catch:{ all -> 0x015e }
    L_0x015c:
        monitor-exit(r5);	 Catch:{ all -> 0x015e }
        goto L_0x00ed;	 Catch:{ all -> 0x015e }
    L_0x015e:
        r0 = move-exception;	 Catch:{ all -> 0x015e }
        monitor-exit(r5);	 Catch:{ all -> 0x015e }
        throw r0;
    L_0x0161:
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0140 }
        r0.interrupt();	 Catch:{ all -> 0x0140 }
        r1 = r11.f28688f;
        monitor-enter(r1);
        r0 = r4.f28665a;	 Catch:{ all -> 0x017e }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x017e }
        if (r0 != 0) goto L_0x017c;	 Catch:{ all -> 0x017e }
    L_0x0173:
        r0 = r11.f28686d;	 Catch:{ all -> 0x017e }
        r2 = r4.m37522e();	 Catch:{ all -> 0x017e }
        r0.add(r2);	 Catch:{ all -> 0x017e }
    L_0x017c:
        monitor-exit(r1);	 Catch:{ all -> 0x017e }
        goto L_0x019a;	 Catch:{ all -> 0x017e }
    L_0x017e:
        r0 = move-exception;	 Catch:{ all -> 0x017e }
        monitor-exit(r1);	 Catch:{ all -> 0x017e }
        throw r0;
    L_0x0181:
        r1 = r11.f28688f;
        monitor-enter(r1);
        r2 = r4.f28665a;	 Catch:{ all -> 0x0197 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0197 }
        if (r2 != 0) goto L_0x0195;	 Catch:{ all -> 0x0197 }
    L_0x018c:
        r2 = r11.f28686d;	 Catch:{ all -> 0x0197 }
        r3 = r4.m37522e();	 Catch:{ all -> 0x0197 }
        r2.add(r3);	 Catch:{ all -> 0x0197 }
    L_0x0195:
        monitor-exit(r1);	 Catch:{ all -> 0x0197 }
        throw r0;
    L_0x0197:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0197 }
        throw r0;
    L_0x019a:
        r0 = 3;
        r1 = 0;
        r0 = r11.m37540a(r0, r1, r1);
        r1 = com.google.android.gms.internal.ads.mi.f15796a;
        r2 = new com.google.android.gms.internal.ads.hi;
        r2.<init>(r11, r0);
        r1.post(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hg.a():void");
    }

    /* renamed from: a */
    final /* synthetic */ void m37542a(is isVar) {
        this.f28689g.m19448b().m18682b(isVar);
    }

    /* renamed from: a */
    public final void mo6098a(String str) {
        synchronized (this.f28688f) {
            this.f28687e.add(str);
        }
    }

    /* renamed from: a */
    public final void mo6099a(String str, int i) {
    }

    /* renamed from: b */
    final /* synthetic */ void m37545b(is isVar) {
        this.f28689g.m19448b().m18682b(isVar);
    }

    public final void h_() {
    }
}
