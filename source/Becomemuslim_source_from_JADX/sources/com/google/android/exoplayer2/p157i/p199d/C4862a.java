package com.google.android.exoplayer2.p157i.p199d;

import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C4725c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SubripDecoder */
/* renamed from: com.google.android.exoplayer2.i.d.a */
public final class C4862a extends C4725c {
    /* renamed from: a */
    private static final Pattern f13889a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    /* renamed from: b */
    private final StringBuilder f13890b = new StringBuilder();

    /* renamed from: a */
    protected /* synthetic */ C2464e mo3431a(byte[] bArr, int i, boolean z) {
        return m17370b(bArr, i, z);
    }

    public C4862a() {
        super("SubripDecoder");
    }

    /* renamed from: b */
    protected com.google.android.exoplayer2.p157i.p199d.C4227b m17370b(byte[] r6, int r7, boolean r8) {
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
        r5 = this;
        r8 = new java.util.ArrayList;
        r8.<init>();
        r0 = new com.google.android.exoplayer2.l.g;
        r0.<init>();
        r1 = new com.google.android.exoplayer2.l.l;
        r1.<init>(r6, r7);
    L_0x000f:
        r6 = r1.m7122z();
        if (r6 == 0) goto L_0x00c9;
    L_0x0015:
        r7 = r6.length();
        if (r7 != 0) goto L_0x001c;
    L_0x001b:
        goto L_0x000f;
    L_0x001c:
        java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x00b1 }
        r6 = r1.m7122z();
        if (r6 != 0) goto L_0x002e;
    L_0x0025:
        r6 = "SubripDecoder";
        r7 = "Unexpected end";
        android.util.Log.w(r6, r7);
        goto L_0x00c9;
    L_0x002e:
        r7 = f13889a;
        r7 = r7.matcher(r6);
        r2 = r7.matches();
        if (r2 == 0) goto L_0x0099;
    L_0x003a:
        r6 = 1;
        r2 = com.google.android.exoplayer2.p157i.p199d.C4862a.m17368a(r7, r6);
        r0.m7045a(r2);
        r2 = 6;
        r3 = r7.group(r2);
        r3 = android.text.TextUtils.isEmpty(r3);
        r4 = 0;
        if (r3 != 0) goto L_0x0056;
    L_0x004e:
        r2 = com.google.android.exoplayer2.p157i.p199d.C4862a.m17368a(r7, r2);
        r0.m7045a(r2);
        goto L_0x0057;
    L_0x0056:
        r6 = 0;
    L_0x0057:
        r7 = r5.f13890b;
        r7.setLength(r4);
    L_0x005c:
        r7 = r1.m7122z();
        r2 = android.text.TextUtils.isEmpty(r7);
        if (r2 != 0) goto L_0x007f;
    L_0x0066:
        r2 = r5.f13890b;
        r2 = r2.length();
        if (r2 <= 0) goto L_0x0075;
    L_0x006e:
        r2 = r5.f13890b;
        r3 = "<br>";
        r2.append(r3);
    L_0x0075:
        r2 = r5.f13890b;
        r7 = r7.trim();
        r2.append(r7);
        goto L_0x005c;
    L_0x007f:
        r7 = r5.f13890b;
        r7 = r7.toString();
        r7 = android.text.Html.fromHtml(r7);
        r2 = new com.google.android.exoplayer2.i.b;
        r2.<init>(r7);
        r8.add(r2);
        if (r6 == 0) goto L_0x000f;
    L_0x0093:
        r6 = 0;
        r8.add(r6);
        goto L_0x000f;
    L_0x0099:
        r7 = "SubripDecoder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Skipping invalid timing: ";
        r2.append(r3);
        r2.append(r6);
        r6 = r2.toString();
        android.util.Log.w(r7, r6);
        goto L_0x000f;
    L_0x00b1:
        r7 = "SubripDecoder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Skipping invalid index: ";
        r2.append(r3);
        r2.append(r6);
        r6 = r2.toString();
        android.util.Log.w(r7, r6);
        goto L_0x000f;
    L_0x00c9:
        r6 = r8.size();
        r6 = new com.google.android.exoplayer2.p157i.C2458b[r6];
        r8.toArray(r6);
        r7 = r0.m7046b();
        r8 = new com.google.android.exoplayer2.i.d.b;
        r8.<init>(r6, r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.d.a.b(byte[], int, boolean):com.google.android.exoplayer2.i.d.b");
    }

    /* renamed from: a */
    private static long m17368a(Matcher matcher, int i) {
        return ((((((Long.parseLong(matcher.group(i + 1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(i + 2)) * 60) * 1000)) + (Long.parseLong(matcher.group(i + 3)) * 1000)) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }
}
