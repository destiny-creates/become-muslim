package com.google.android.gms.internal.ads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class oq {
    /* renamed from: a */
    private static long m19971a(String str) {
        try {
            return m19974a().parse(str).getTime();
        } catch (Throwable e) {
            eg.m19389a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    /* renamed from: a */
    public static com.google.android.gms.internal.ads.agz m19972a(com.google.android.gms.internal.ads.aug r21) {
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
        r0 = r21;
        r1 = java.lang.System.currentTimeMillis();
        r3 = r0.f15006c;
        r4 = "Date";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r7 = m19971a(r4);
        goto L_0x0019;
    L_0x0017:
        r7 = 0;
    L_0x0019:
        r4 = "Cache-Control";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        r10 = 0;
        if (r4 == 0) goto L_0x008b;
    L_0x0024:
        r11 = ",";
        r4 = r4.split(r11);
        r11 = 0;
        r13 = 0;
        r14 = 0;
    L_0x002f:
        r9 = r4.length;
        if (r10 >= r9) goto L_0x0087;
    L_0x0032:
        r9 = r4[r10];
        r9 = r9.trim();
        r5 = "no-cache";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0085;
    L_0x0040:
        r5 = "no-store";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0049;
    L_0x0048:
        goto L_0x0085;
    L_0x0049:
        r5 = "max-age=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x005d;
    L_0x0051:
        r5 = 8;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0082 }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0082 }
        r11 = r5;
        goto L_0x0082;
    L_0x005d:
        r5 = "stale-while-revalidate=";
        r5 = r9.startsWith(r5);
        if (r5 == 0) goto L_0x0071;
    L_0x0065:
        r5 = 23;
        r5 = r9.substring(r5);	 Catch:{ Exception -> 0x0082 }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0082 }
        r14 = r5;
        goto L_0x0082;
    L_0x0071:
        r5 = "must-revalidate";
        r5 = r9.equals(r5);
        if (r5 != 0) goto L_0x0081;
    L_0x0079:
        r5 = "proxy-revalidate";
        r5 = r9.equals(r5);
        if (r5 == 0) goto L_0x0082;
    L_0x0081:
        r13 = 1;
    L_0x0082:
        r10 = r10 + 1;
        goto L_0x002f;
    L_0x0085:
        r0 = 0;
        return r0;
    L_0x0087:
        r10 = r13;
        r16 = 1;
        goto L_0x0091;
    L_0x008b:
        r11 = 0;
        r14 = 0;
        r16 = 0;
    L_0x0091:
        r4 = "Expires";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00a0;
    L_0x009b:
        r5 = m19971a(r4);
        goto L_0x00a2;
    L_0x00a0:
        r5 = 0;
    L_0x00a2:
        r4 = "Last-Modified";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00b3;
    L_0x00ac:
        r17 = m19971a(r4);
        r19 = r17;
        goto L_0x00b5;
    L_0x00b3:
        r19 = 0;
    L_0x00b5:
        r4 = "ETag";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        if (r16 == 0) goto L_0x00cd;
    L_0x00bf:
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 * r5;
        r1 = r1 + r11;
        if (r10 == 0) goto L_0x00c7;
    L_0x00c6:
        goto L_0x00dc;
    L_0x00c7:
        r14 = r14 * r5;
        r5 = 0;
        r14 = r14 + r1;
        r5 = r14;
        goto L_0x00dd;
    L_0x00cd:
        r9 = 0;
        r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r11 <= 0) goto L_0x00db;
    L_0x00d3:
        r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r11 < 0) goto L_0x00db;
    L_0x00d7:
        r5 = r5 - r7;
        r5 = r5 + r1;
        r1 = r5;
        goto L_0x00dd;
    L_0x00db:
        r1 = r9;
    L_0x00dc:
        r5 = r1;
    L_0x00dd:
        r9 = new com.google.android.gms.internal.ads.agz;
        r9.<init>();
        r10 = r0.f15005b;
        r9.f14505a = r10;
        r9.f14506b = r4;
        r9.f14510f = r1;
        r9.f14509e = r5;
        r9.f14507c = r7;
        r1 = r19;
        r9.f14508d = r1;
        r9.f14511g = r3;
        r0 = r0.f15007d;
        r9.f14512h = r0;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.oq.a(com.google.android.gms.internal.ads.aug):com.google.android.gms.internal.ads.agz");
    }

    /* renamed from: a */
    static String m19973a(long j) {
        return m19974a().format(new Date(j));
    }

    /* renamed from: a */
    private static SimpleDateFormat m19974a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
