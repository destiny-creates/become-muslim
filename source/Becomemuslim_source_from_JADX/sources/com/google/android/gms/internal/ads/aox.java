package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.C2676j.C2675a;

@cm
public final class aox {
    /* renamed from: a */
    private final C2631d[] f14796a;
    /* renamed from: b */
    private final String f14797b;

    public aox(Context context, AttributeSet attributeSet) {
        C2631d[] a;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C2675a.AdsAttrs);
        String string = obtainAttributes.getString(C2675a.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C2675a.AdsAttrs_adSizes);
        int isEmpty = TextUtils.isEmpty(string) ^ 1;
        int isEmpty2 = TextUtils.isEmpty(string2) ^ 1;
        if (isEmpty != 0 && isEmpty2 == 0) {
            a = m18661a(string);
        } else if (isEmpty == 0 && isEmpty2 != 0) {
            a = m18661a(string2);
        } else if (isEmpty != 0) {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.f14796a = a;
        this.f14797b = obtainAttributes.getString(C2675a.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.f14797b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    /* renamed from: a */
    private static com.google.android.gms.ads.C2631d[] m18661a(java.lang.String r10) {
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
        r0 = "\\s*,\\s*";
        r0 = r10.split(r0);
        r1 = r0.length;
        r1 = new com.google.android.gms.ads.C2631d[r1];
        r2 = 0;
        r3 = 0;
    L_0x000b:
        r4 = r0.length;
        if (r3 >= r4) goto L_0x0115;
    L_0x000e:
        r4 = r0[r3];
        r4 = r4.trim();
        r5 = "^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$";
        r5 = r4.matches(r5);
        if (r5 == 0) goto L_0x007f;
    L_0x001c:
        r5 = "[xX]";
        r5 = r4.split(r5);
        r6 = r5[r2];
        r6 = r6.trim();
        r5[r2] = r6;
        r6 = 1;
        r7 = r5[r6];
        r7 = r7.trim();
        r5[r6] = r7;
        r7 = "FULL_WIDTH";	 Catch:{ NumberFormatException -> 0x0061 }
        r8 = r5[r2];	 Catch:{ NumberFormatException -> 0x0061 }
        r7 = r7.equals(r8);	 Catch:{ NumberFormatException -> 0x0061 }
        if (r7 == 0) goto L_0x003f;	 Catch:{ NumberFormatException -> 0x0061 }
    L_0x003d:
        r7 = -1;	 Catch:{ NumberFormatException -> 0x0061 }
        goto L_0x0045;	 Catch:{ NumberFormatException -> 0x0061 }
    L_0x003f:
        r7 = r5[r2];	 Catch:{ NumberFormatException -> 0x0061 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x0061 }
    L_0x0045:
        r8 = "AUTO_HEIGHT";	 Catch:{ NumberFormatException -> 0x0061 }
        r9 = r5[r6];	 Catch:{ NumberFormatException -> 0x0061 }
        r8 = r8.equals(r9);	 Catch:{ NumberFormatException -> 0x0061 }
        if (r8 == 0) goto L_0x0051;	 Catch:{ NumberFormatException -> 0x0061 }
    L_0x004f:
        r4 = -2;	 Catch:{ NumberFormatException -> 0x0061 }
        goto L_0x0058;	 Catch:{ NumberFormatException -> 0x0061 }
    L_0x0051:
        r5 = r5[r6];	 Catch:{ NumberFormatException -> 0x0061 }
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x0061 }
        r4 = r5;
    L_0x0058:
        r5 = new com.google.android.gms.ads.d;
        r5.<init>(r7, r4);
        r1[r3] = r5;
        goto L_0x00f4;
        r10 = new java.lang.IllegalArgumentException;
        r0 = "Could not parse XML attribute \"adSize\": ";
        r1 = java.lang.String.valueOf(r4);
        r2 = r1.length();
        if (r2 == 0) goto L_0x0075;
    L_0x0070:
        r0 = r0.concat(r1);
        goto L_0x007b;
    L_0x0075:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x007b:
        r10.<init>(r0);
        throw r10;
    L_0x007f:
        r5 = "BANNER";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x008d;
    L_0x0087:
        r4 = com.google.android.gms.ads.C2631d.f6669a;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x008d:
        r5 = "LARGE_BANNER";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x009a;
    L_0x0095:
        r4 = com.google.android.gms.ads.C2631d.f6671c;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x009a:
        r5 = "FULL_BANNER";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00a7;
    L_0x00a2:
        r4 = com.google.android.gms.ads.C2631d.f6670b;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x00a7:
        r5 = "LEADERBOARD";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00b4;
    L_0x00af:
        r4 = com.google.android.gms.ads.C2631d.f6672d;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x00b4:
        r5 = "MEDIUM_RECTANGLE";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00c1;
    L_0x00bc:
        r4 = com.google.android.gms.ads.C2631d.f6673e;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x00c1:
        r5 = "SMART_BANNER";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00ce;
    L_0x00c9:
        r4 = com.google.android.gms.ads.C2631d.f6675g;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x00ce:
        r5 = "WIDE_SKYSCRAPER";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00db;
    L_0x00d6:
        r4 = com.google.android.gms.ads.C2631d.f6674f;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x00db:
        r5 = "FLUID";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00e8;
    L_0x00e3:
        r4 = com.google.android.gms.ads.C2631d.f6676h;
        r1[r3] = r4;
        goto L_0x00f4;
    L_0x00e8:
        r5 = "ICON";
        r5 = r5.equals(r4);
        if (r5 == 0) goto L_0x00f8;
    L_0x00f0:
        r4 = com.google.android.gms.ads.C2631d.f6677i;
        r1[r3] = r4;
    L_0x00f4:
        r3 = r3 + 1;
        goto L_0x000b;
    L_0x00f8:
        r10 = new java.lang.IllegalArgumentException;
        r0 = "Could not parse XML attribute \"adSize\": ";
        r1 = java.lang.String.valueOf(r4);
        r2 = r1.length();
        if (r2 == 0) goto L_0x010b;
    L_0x0106:
        r0 = r0.concat(r1);
        goto L_0x0111;
    L_0x010b:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0111:
        r10.<init>(r0);
        throw r10;
    L_0x0115:
        r0 = r1.length;
        if (r0 != 0) goto L_0x0134;
    L_0x0118:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Could not parse XML attribute \"adSize\": ";
        r10 = java.lang.String.valueOf(r10);
        r2 = r10.length();
        if (r2 == 0) goto L_0x012b;
    L_0x0126:
        r10 = r1.concat(r10);
        goto L_0x0130;
    L_0x012b:
        r10 = new java.lang.String;
        r10.<init>(r1);
    L_0x0130:
        r0.<init>(r10);
        throw r0;
    L_0x0134:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aox.a(java.lang.String):com.google.android.gms.ads.d[]");
    }

    /* renamed from: a */
    public final String m18662a() {
        return this.f14797b;
    }

    /* renamed from: a */
    public final C2631d[] m18663a(boolean z) {
        if (!z) {
            if (this.f14796a.length != 1) {
                throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
            }
        }
        return this.f14796a;
    }
}
