package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.util.C2904o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class hs implements id {
    /* renamed from: a */
    private static List<Future<Void>> f24089a = Collections.synchronizedList(new ArrayList());
    /* renamed from: b */
    private static ScheduledExecutorService f24090b = Executors.newSingleThreadScheduledExecutor();
    /* renamed from: c */
    private final afs f24091c;
    /* renamed from: d */
    private final LinkedHashMap<String, aga> f24092d;
    /* renamed from: e */
    private final List<String> f24093e = new ArrayList();
    /* renamed from: f */
    private final List<String> f24094f = new ArrayList();
    /* renamed from: g */
    private final Context f24095g;
    /* renamed from: h */
    private final C4929if f24096h;
    /* renamed from: i */
    private boolean f24097i;
    /* renamed from: j */
    private final ia f24098j;
    /* renamed from: k */
    private final ig f24099k;
    /* renamed from: l */
    private final Object f24100l = new Object();
    /* renamed from: m */
    private HashSet<String> f24101m = new HashSet();
    /* renamed from: n */
    private boolean f24102n = false;
    /* renamed from: o */
    private boolean f24103o = false;
    /* renamed from: p */
    private boolean f24104p = false;

    public hs(Context context, mv mvVar, ia iaVar, String str, C4929if c4929if) {
        C2872v.a(iaVar, "SafeBrowsing config is not present.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f24095g = context;
        this.f24092d = new LinkedHashMap();
        this.f24096h = c4929if;
        this.f24098j = iaVar;
        for (String toLowerCase : this.f24098j.f28697e) {
            this.f24101m.add(toLowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.f24101m.remove("cookie".toLowerCase(Locale.ENGLISH));
        afs afs = new afs();
        afs.f28042a = Integer.valueOf(8);
        afs.f28043b = str;
        afs.f28044c = str;
        afs.f28045d = new aft();
        afs.f28045d.f28060a = this.f24098j.f28693a;
        agb agb = new agb();
        agb.f28094a = mvVar.f28709a;
        agb.f28096c = Boolean.valueOf(C2829c.a(this.f24095g).a());
        long d = (long) C2830f.b().d(this.f24095g);
        if (d > 0) {
            agb.f28095b = Long.valueOf(d);
        }
        afs.f28049h = agb;
        this.f24091c = afs;
        this.f24099k = new ig(this.f24095g, this.f24098j.f28700h, this);
    }

    /* renamed from: e */
    private final aga m30793e(String str) {
        aga aga;
        synchronized (this.f24100l) {
            aga = (aga) this.f24092d.get(str);
        }
        return aga;
    }

    /* renamed from: f */
    private final no<Void> m30795f() {
        int i = 0;
        Object obj = (!(this.f24097i && this.f24098j.f28699g) && (!(this.f24104p && this.f24098j.f28698f) && (this.f24097i || !this.f24098j.f28696d))) ? null : 1;
        if (obj == null) {
            return nd.m19938a(null);
        }
        no<Void> a;
        synchronized (this.f24100l) {
            this.f24091c.f28046e = new aga[this.f24092d.size()];
            this.f24092d.values().toArray(this.f24091c.f28046e);
            this.f24091c.f28050i = (String[]) this.f24093e.toArray(new String[0]);
            this.f24091c.f28051j = (String[]) this.f24094f.toArray(new String[0]);
            if (ic.m19516a()) {
                String str = this.f24091c.f28043b;
                String str2 = this.f24091c.f28047f;
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 53) + String.valueOf(str2).length());
                stringBuilder.append("Sending SB report\n  url: ");
                stringBuilder.append(str);
                stringBuilder.append("\n  clickUrl: ");
                stringBuilder.append(str2);
                stringBuilder.append("\n  resources: \n");
                StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
                aga[] agaArr = this.f24091c.f28046e;
                int length = agaArr.length;
                while (i < length) {
                    aga aga = agaArr[i];
                    stringBuilder2.append("    [");
                    stringBuilder2.append(aga.f28089e.length);
                    stringBuilder2.append("] ");
                    stringBuilder2.append(aga.f28086b);
                    i++;
                }
                ic.m19515a(stringBuilder2.toString());
            }
            no a2 = new lg(this.f24095g).m19831a(1, this.f24098j.f28694b, null, afo.m18388a(this.f24091c));
            if (ic.m19516a()) {
                a2.mo4319a(new hx(this), ju.f15687a);
            }
            a = nd.m19941a(a2, hu.f24106a, nu.f15847b);
        }
        return a;
    }

    /* renamed from: a */
    public final ia mo4288a() {
        return this.f24098j;
    }

    /* renamed from: a */
    final /* synthetic */ no m30797a(Map map) {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    String str2;
                    JSONArray optJSONArray = new JSONObject((String) map.get(str2)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.f24100l) {
                            int length = optJSONArray.length();
                            aga e = m30793e(str2);
                            if (e == null) {
                                String str3 = "Cannot find the corresponding resource object for ";
                                str2 = String.valueOf(str2);
                                ic.m19515a(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                            } else {
                                e.f28089e = new String[length];
                                int i = 0;
                                for (int i2 = 0; i2 < length; i2++) {
                                    e.f28089e[i2] = optJSONArray.getJSONObject(i2).getString("threat_type");
                                }
                                boolean z = this.f24097i;
                                if (length > 0) {
                                    i = 1;
                                }
                                this.f24097i = i | z;
                            }
                        }
                    }
                }
            } catch (Throwable e2) {
                r0 = "Failed to get SafeBrowsing metadata";
                if (((Boolean) aph.m18688f().m18889a(asp.cB)).booleanValue()) {
                    String str4;
                    mt.m19916a(str4, e2);
                }
                return nd.m19937a(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.f24097i) {
            synchronized (this.f24100l) {
                this.f24091c.f28042a = Integer.valueOf(9);
            }
        }
        return m30795f();
    }

    /* renamed from: a */
    public final void mo4289a(View view) {
        if (this.f24098j.f28695c && !this.f24103o) {
            ax.e();
            Bitmap b = jw.m19712b(view);
            if (b == null) {
                ic.m19515a("Failed to capture the webview bitmap.");
                return;
            }
            this.f24103o = true;
            jw.m19701a(new hv(this, b));
        }
    }

    /* renamed from: a */
    public final void mo4290a(String str) {
        synchronized (this.f24100l) {
            this.f24091c.f28047f = str;
        }
    }

    /* renamed from: a */
    public final void mo4291a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
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
        r6 = this;
        r0 = r6.f24100l;
        monitor-enter(r0);
        r1 = 3;
        if (r9 != r1) goto L_0x000d;
    L_0x0006:
        r2 = 1;
        r6.f24104p = r2;	 Catch:{ all -> 0x000a }
        goto L_0x000d;	 Catch:{ all -> 0x000a }
    L_0x000a:
        r7 = move-exception;	 Catch:{ all -> 0x000a }
        goto L_0x00ca;	 Catch:{ all -> 0x000a }
    L_0x000d:
        r2 = r6.f24092d;	 Catch:{ all -> 0x000a }
        r2 = r2.containsKey(r7);	 Catch:{ all -> 0x000a }
        if (r2 == 0) goto L_0x0027;	 Catch:{ all -> 0x000a }
    L_0x0015:
        if (r9 != r1) goto L_0x0025;	 Catch:{ all -> 0x000a }
    L_0x0017:
        r8 = r6.f24092d;	 Catch:{ all -> 0x000a }
        r7 = r8.get(r7);	 Catch:{ all -> 0x000a }
        r7 = (com.google.android.gms.internal.ads.aga) r7;	 Catch:{ all -> 0x000a }
        r8 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x000a }
        r7.f28088d = r8;	 Catch:{ all -> 0x000a }
    L_0x0025:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;	 Catch:{ all -> 0x000a }
    L_0x0027:
        r1 = new com.google.android.gms.internal.ads.aga;	 Catch:{ all -> 0x000a }
        r1.<init>();	 Catch:{ all -> 0x000a }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x000a }
        r1.f28088d = r9;	 Catch:{ all -> 0x000a }
        r9 = r6.f24092d;	 Catch:{ all -> 0x000a }
        r9 = r9.size();	 Catch:{ all -> 0x000a }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x000a }
        r1.f28085a = r9;	 Catch:{ all -> 0x000a }
        r1.f28086b = r7;	 Catch:{ all -> 0x000a }
        r9 = new com.google.android.gms.internal.ads.afv;	 Catch:{ all -> 0x000a }
        r9.<init>();	 Catch:{ all -> 0x000a }
        r1.f28087c = r9;	 Catch:{ all -> 0x000a }
        r9 = r6.f24101m;	 Catch:{ all -> 0x000a }
        r9 = r9.size();	 Catch:{ all -> 0x000a }
        if (r9 <= 0) goto L_0x00c3;	 Catch:{ all -> 0x000a }
    L_0x004f:
        if (r8 == 0) goto L_0x00c3;	 Catch:{ all -> 0x000a }
    L_0x0051:
        r9 = new java.util.ArrayList;	 Catch:{ all -> 0x000a }
        r9.<init>();	 Catch:{ all -> 0x000a }
        r8 = r8.entrySet();	 Catch:{ all -> 0x000a }
        r8 = r8.iterator();	 Catch:{ all -> 0x000a }
    L_0x005e:
        r2 = r8.hasNext();	 Catch:{ all -> 0x000a }
        if (r2 == 0) goto L_0x00b6;	 Catch:{ all -> 0x000a }
    L_0x0064:
        r2 = r8.next();	 Catch:{ all -> 0x000a }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x000a }
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        if (r3 == 0) goto L_0x0077;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0070:
        r3 = r2.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r3 = (java.lang.String) r3;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        goto L_0x0079;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0077:
        r3 = "";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0079:
        r4 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        if (r4 == 0) goto L_0x0086;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x007f:
        r2 = r2.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r2 = (java.lang.String) r2;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        goto L_0x0088;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0086:
        r2 = "";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0088:
        r4 = java.util.Locale.ENGLISH;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4 = r3.toLowerCase(r4);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r5 = r6.f24101m;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4 = r5.contains(r4);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        if (r4 != 0) goto L_0x0097;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0096:
        goto L_0x005e;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
    L_0x0097:
        r4 = new com.google.android.gms.internal.ads.afu;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r5 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r3 = r3.getBytes(r5);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4.f28062a = r3;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r3 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r2 = r2.getBytes(r3);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r4.f28063b = r2;	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        r9.add(r4);	 Catch:{ UnsupportedEncodingException -> 0x00b0 }
        goto L_0x005e;
    L_0x00b0:
        r2 = "Cannot convert string to bytes, skip header.";	 Catch:{ all -> 0x000a }
        com.google.android.gms.internal.ads.ic.m19515a(r2);	 Catch:{ all -> 0x000a }
        goto L_0x005e;	 Catch:{ all -> 0x000a }
    L_0x00b6:
        r8 = r9.size();	 Catch:{ all -> 0x000a }
        r8 = new com.google.android.gms.internal.ads.afu[r8];	 Catch:{ all -> 0x000a }
        r9.toArray(r8);	 Catch:{ all -> 0x000a }
        r9 = r1.f28087c;	 Catch:{ all -> 0x000a }
        r9.f28064a = r8;	 Catch:{ all -> 0x000a }
    L_0x00c3:
        r8 = r6.f24092d;	 Catch:{ all -> 0x000a }
        r8.put(r7, r1);	 Catch:{ all -> 0x000a }
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        return;	 Catch:{ all -> 0x000a }
    L_0x00ca:
        monitor-exit(r0);	 Catch:{ all -> 0x000a }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hs.a(java.lang.String, java.util.Map, int):void");
    }

    /* renamed from: a */
    public final String[] mo4292a(String[] strArr) {
        return (String[]) this.f24099k.m19527a(strArr).toArray(new String[0]);
    }

    /* renamed from: b */
    final void m30802b(String str) {
        synchronized (this.f24100l) {
            this.f24093e.add(str);
        }
    }

    /* renamed from: b */
    public final boolean mo4293b() {
        return C2904o.g() && this.f24098j.f28695c && !this.f24103o;
    }

    /* renamed from: c */
    public final void mo4294c() {
        this.f24102n = true;
    }

    /* renamed from: c */
    final void m30805c(String str) {
        synchronized (this.f24100l) {
            this.f24094f.add(str);
        }
    }

    /* renamed from: d */
    public final void mo4295d() {
        synchronized (this.f24100l) {
            no a = nd.m19940a(this.f24096h.mo4297a(this.f24095g, this.f24092d.keySet()), new ht(this), nu.f15847b);
            no a2 = nd.m19939a(a, 10, TimeUnit.SECONDS, f24090b);
            nd.m19945a(a, new hw(this, a2), nu.f15847b);
            f24089a.add(a2);
        }
    }
}
