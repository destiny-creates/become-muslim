package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.internal.ax;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

@cm
public final class azd {
    /* renamed from: a */
    private final Map<aze, azf> f15074a = new HashMap();
    /* renamed from: b */
    private final LinkedList<aze> f15075b = new LinkedList();
    /* renamed from: c */
    private axy f15076c;

    /* renamed from: a */
    static Set<String> m19132a(aoq aoq) {
        Set<String> hashSet = new HashSet();
        hashSet.addAll(aoq.f28263c.keySet());
        Bundle bundle = aoq.f28273m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    /* renamed from: a */
    private static void m19133a(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length != 0) {
                String str2 = split[0];
                if (split.length == 1) {
                    bundle.remove(str2);
                    return;
                }
                bundle = bundle.getBundle(str2);
                if (bundle != null) {
                    str = split[1];
                } else {
                    return;
                }
            }
            return;
        }
    }

    /* renamed from: a */
    private static void m19134a(String str, aze aze) {
        if (mt.m19917a(2)) {
            jn.m30864a(String.format(str, new Object[]{aze}));
        }
    }

    /* renamed from: a */
    private static java.lang.String[] m19135a(java.lang.String r5) {
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
        r0 = 0;
        r1 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r5 = r5.split(r1);	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r1 = 0;	 Catch:{ UnsupportedEncodingException -> 0x001e }
    L_0x0008:
        r2 = r5.length;	 Catch:{ UnsupportedEncodingException -> 0x001e }
        if (r1 >= r2) goto L_0x001d;	 Catch:{ UnsupportedEncodingException -> 0x001e }
    L_0x000b:
        r2 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r3 = r5[r1];	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r3 = android.util.Base64.decode(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r4 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r2.<init>(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r5[r1] = r2;	 Catch:{ UnsupportedEncodingException -> 0x001e }
        r1 = r1 + 1;
        goto L_0x0008;
    L_0x001d:
        return r5;
    L_0x001e:
        r5 = new java.lang.String[r0];
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azd.a(java.lang.String):java.lang.String[]");
    }

    /* renamed from: b */
    static aoq m19136b(aoq aoq) {
        aoq = m19141d(aoq);
        String str = "_skipMediation";
        Bundle bundle = aoq.f28273m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean(str, true);
        }
        aoq.f28263c.putBoolean(str, true);
        return aoq;
    }

    /* renamed from: b */
    private final java.lang.String m19137b() {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r1 = r4.f15075b;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r1 = r1.iterator();	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x000b:
        r2 = r1.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        if (r2 == 0) goto L_0x0035;	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x0011:
        r2 = r1.next();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = (com.google.android.gms.internal.ads.aze) r2;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r3 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = r2.getBytes(r3);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r3 = 0;	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = android.util.Base64.encodeToString(r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r0.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r2 = r1.hasNext();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        if (r2 == 0) goto L_0x000b;	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x002f:
        r2 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x003a }
        r0.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x003a }
        goto L_0x000b;	 Catch:{ UnsupportedEncodingException -> 0x003a }
    L_0x0035:
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x003a }
        return r0;
    L_0x003a:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azd.b():java.lang.String");
    }

    /* renamed from: b */
    private static boolean m19138b(String str) {
        try {
            return Pattern.matches((String) aph.m18688f().m18889a(asp.ba), str);
        } catch (Throwable e) {
            ax.i().m30834a(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    /* renamed from: c */
    private static aoq m19139c(aoq aoq) {
        aoq = m19141d(aoq);
        for (String str : ((String) aph.m18688f().m18889a(asp.aW)).split(",")) {
            m19133a(aoq.f28273m, str);
            String str2 = "com.google.ads.mediation.admob.AdMobAdapter/";
            if (str.startsWith(str2)) {
                m19133a(aoq.f28263c, str.replaceFirst(str2, ""));
            }
        }
        return aoq;
    }

    /* renamed from: c */
    private static java.lang.String m19140c(java.lang.String r2) {
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
        r0 = "([^/]+/[0-9]+).*";	 Catch:{ RuntimeException -> 0x0016 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ RuntimeException -> 0x0016 }
        r0 = r0.matcher(r2);	 Catch:{ RuntimeException -> 0x0016 }
        r1 = r0.matches();	 Catch:{ RuntimeException -> 0x0016 }
        if (r1 == 0) goto L_0x0016;	 Catch:{ RuntimeException -> 0x0016 }
    L_0x0010:
        r1 = 1;	 Catch:{ RuntimeException -> 0x0016 }
        r0 = r0.group(r1);	 Catch:{ RuntimeException -> 0x0016 }
        return r0;
    L_0x0016:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azd.c(java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    private static aoq m19141d(aoq aoq) {
        Parcel obtain = Parcel.obtain();
        aoq.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        aoq = (aoq) aoq.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return ((Boolean) aph.m18688f().m18889a(asp.aN)).booleanValue() ? aoq.m36922a() : aoq;
    }

    /* renamed from: a */
    final azg m19142a(aoq aoq, String str) {
        if (m19138b(str)) {
            return null;
        }
        int i = new fj(this.f15076c.m19102a()).m19435a().f15452n;
        aoq = m19139c(aoq);
        str = m19140c(str);
        aze aze = new aze(aoq, str, i);
        azf azf = (azf) this.f15074a.get(aze);
        if (azf == null) {
            m19134a("Interstitial pool created at %s.", aze);
            azf = new azf(aoq, str, i);
            this.f15074a.put(aze, azf);
        }
        this.f15075b.remove(aze);
        this.f15075b.add(aze);
        azf.m19157g();
        while (true) {
            if (this.f15075b.size() <= ((Integer) aph.m18688f().m18889a(asp.aX)).intValue()) {
                break;
            }
            aze aze2 = (aze) this.f15075b.remove();
            azf azf2 = (azf) this.f15074a.get(aze2);
            m19134a("Evicting interstitial queue for %s.", aze2);
            while (azf2.m19154d() > 0) {
                azg a = azf2.m19149a(null);
                if (a.f15087e) {
                    azi.m19160a().m19163c();
                }
                a.f15083a.J();
            }
            this.f15074a.remove(aze2);
        }
        while (azf.m19154d() > 0) {
            azg a2 = azf.m19149a(aoq);
            if (a2.f15087e) {
                if (ax.l().a() - a2.f15086d > ((long) ((Integer) aph.m18688f().m18889a(asp.aZ)).intValue()) * 1000) {
                    m19134a("Expired interstitial at %s.", aze);
                    azi.m19160a().m19162b();
                }
            }
            String str2 = a2.f15084b != null ? " (inline) " : " ";
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 34);
            stringBuilder.append("Pooled interstitial");
            stringBuilder.append(str2);
            stringBuilder.append("returned at %s.");
            m19134a(stringBuilder.toString(), aze);
            return a2;
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final void m19143a() {
        /*
        r9 = this;
        r0 = r9.f15076c;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r9.f15074a;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x000f:
        r1 = r0.hasNext();
        r2 = 0;
        if (r1 == 0) goto L_0x0089;
    L_0x0016:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r3 = r1.getKey();
        r3 = (com.google.android.gms.internal.ads.aze) r3;
        r1 = r1.getValue();
        r1 = (com.google.android.gms.internal.ads.azf) r1;
        r4 = 2;
        r5 = com.google.android.gms.internal.ads.mt.m19917a(r4);
        if (r5 == 0) goto L_0x0056;
    L_0x002f:
        r5 = r1.m19154d();
        r6 = r1.m19155e();
        if (r6 >= r5) goto L_0x0056;
    L_0x0039:
        r7 = "Loading %s/%s pooled interstitials for %s.";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r6 = r5 - r6;
        r6 = java.lang.Integer.valueOf(r6);
        r8[r2] = r6;
        r5 = java.lang.Integer.valueOf(r5);
        r6 = 1;
        r8[r6] = r5;
        r8[r4] = r3;
        r4 = java.lang.String.format(r7, r8);
        com.google.android.gms.internal.ads.jn.m30864a(r4);
    L_0x0056:
        r4 = r1.m19156f();
        r4 = r4 + r2;
    L_0x005b:
        r2 = r1.m19154d();
        r5 = com.google.android.gms.internal.ads.asp.aY;
        r6 = com.google.android.gms.internal.ads.aph.m18688f();
        r5 = r6.m18889a(r5);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        if (r2 >= r5) goto L_0x0081;
    L_0x0071:
        r2 = "Pooling and loading one new interstitial for %s.";
        m19134a(r2, r3);
        r2 = r9.f15076c;
        r2 = r1.m19151a(r2);
        if (r2 == 0) goto L_0x005b;
    L_0x007e:
        r4 = r4 + 1;
        goto L_0x005b;
    L_0x0081:
        r1 = com.google.android.gms.internal.ads.azi.m19160a();
        r1.m19161a(r4);
        goto L_0x000f;
    L_0x0089:
        r0 = r9.f15076c;
        if (r0 == 0) goto L_0x00ea;
    L_0x008d:
        r0 = r9.f15076c;
        r0 = r0.m19102a();
        r1 = "com.google.android.gms.ads.internal.interstitial.InterstitialAdPool";
        r0 = r0.getSharedPreferences(r1, r2);
        r0 = r0.edit();
        r0.clear();
        r1 = r9.f15074a;
        r1 = r1.entrySet();
        r1 = r1.iterator();
    L_0x00aa:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x00de;
    L_0x00b0:
        r2 = r1.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (com.google.android.gms.internal.ads.aze) r3;
        r2 = r2.getValue();
        r2 = (com.google.android.gms.internal.ads.azf) r2;
        r4 = r2.m19158h();
        if (r4 == 0) goto L_0x00aa;
    L_0x00c8:
        r4 = new com.google.android.gms.internal.ads.azk;
        r4.<init>(r2);
        r2 = r4.m19172a();
        r4 = r3.toString();
        r0.putString(r4, r2);
        r2 = "Saved interstitial queue for %s.";
        m19134a(r2, r3);
        goto L_0x00aa;
    L_0x00de:
        r1 = "PoolKeys";
        r2 = r9.m19137b();
        r0.putString(r1, r2);
        r0.apply();
    L_0x00ea:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azd.a():void");
    }

    /* renamed from: a */
    final void m19144a(axy axy) {
        if (this.f15076c == null) {
            this.f15076c = axy.m19105b();
            if (this.f15076c != null) {
                int i = 0;
                SharedPreferences sharedPreferences = this.f15076c.m19102a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.f15075b.size() > 0) {
                    aze aze = (aze) this.f15075b.remove();
                    azf azf = (azf) this.f15074a.get(aze);
                    m19134a("Flushing interstitial queue for %s.", aze);
                    while (azf.m19154d() > 0) {
                        azf.m19149a(null).f15083a.J();
                    }
                    this.f15074a.remove(aze);
                }
                try {
                    Map hashMap = new HashMap();
                    for (Entry entry : sharedPreferences.getAll().entrySet()) {
                        if (!((String) entry.getKey()).equals("PoolKeys")) {
                            azk a = azk.m19171a((String) entry.getValue());
                            aze aze2 = new aze(a.f15101a, a.f15102b, a.f15103c);
                            if (!this.f15074a.containsKey(aze2)) {
                                this.f15074a.put(aze2, new azf(a.f15101a, a.f15102b, a.f15103c));
                                hashMap.put(aze2.toString(), aze2);
                                m19134a("Restored interstitial queue for %s.", aze2);
                            }
                        }
                    }
                    String[] a2 = m19135a(sharedPreferences.getString("PoolKeys", ""));
                    int length = a2.length;
                    while (i < length) {
                        aze aze3 = (aze) hashMap.get(a2[i]);
                        if (this.f15074a.containsKey(aze3)) {
                            this.f15075b.add(aze3);
                        }
                        i++;
                    }
                } catch (Throwable e) {
                    ax.i().m30834a(e, "InterstitialAdPool.restore");
                    mt.m19921c("Malformed preferences value for InterstitialAdPool.", e);
                    this.f15074a.clear();
                    this.f15075b.clear();
                }
            }
        }
    }

    /* renamed from: b */
    final void m19145b(aoq aoq, String str) {
        if (this.f15076c != null) {
            int i = new fj(this.f15076c.m19102a()).m19435a().f15452n;
            aoq c = m19139c(aoq);
            str = m19140c(str);
            aze aze = new aze(c, str, i);
            azf azf = (azf) this.f15074a.get(aze);
            if (azf == null) {
                m19134a("Interstitial pool created at %s.", aze);
                azf = new azf(c, str, i);
                this.f15074a.put(aze, azf);
            }
            azf.m19150a(this.f15076c, aoq);
            azf.m19157g();
            m19134a("Inline entry added to the queue at %s.", aze);
        }
    }
}
