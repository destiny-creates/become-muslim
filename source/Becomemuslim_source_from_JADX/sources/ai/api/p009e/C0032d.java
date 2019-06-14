package ai.api.p009e;

import ai.api.p005a.C0007d;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: VersionConfig */
/* renamed from: ai.api.e.d */
public class C0032d {
    /* renamed from: a */
    private static final String f105a = "ai.api.e.d";
    /* renamed from: b */
    private static final Pattern f106b = Pattern.compile(".", 16);
    /* renamed from: c */
    private static final Map<String, C0032d> f107c = new HashMap();
    /* renamed from: d */
    private boolean f108d = true;
    /* renamed from: e */
    private boolean f109e = false;

    static {
        f107c.put("5.9.26", new C0032d(true, true));
        f107c.put("4.7.13", new C0032d(false, false));
    }

    private C0032d() {
    }

    private C0032d(boolean z, boolean z2) {
        this.f108d = z;
        this.f109e = z2;
    }

    /* renamed from: a */
    public static C0032d m91a(Context context) {
        return C0032d.m92b(context);
    }

    /* renamed from: b */
    private static C0032d m92b(Context context) {
        long a = C0032d.m90a(C0030b.m88b(context));
        context = new C0032d();
        long j = 0;
        for (Entry entry : f107c.entrySet()) {
            String str = (String) entry.getKey();
            if (!TextUtils.isEmpty(str)) {
                long a2 = C0032d.m90a(str);
                if (a >= a2 && r3 < a2) {
                    context.f108d = ((C0032d) entry.getValue()).f108d;
                    context.f109e = ((C0032d) entry.getValue()).f109e;
                    j = a2;
                }
            }
        }
        return context;
    }

    /* renamed from: a */
    public boolean m93a() {
        return this.f108d;
    }

    /* renamed from: b */
    public boolean m94b() {
        return this.f109e;
    }

    /* renamed from: a */
    private static long m90a(java.lang.String r6) {
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
        r0 = android.text.TextUtils.isEmpty(r6);
        r1 = 0;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = f106b;
        r6 = r0.split(r6);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = 0;
    L_0x0015:
        r4 = 3;
        r5 = r6.length;
        r4 = java.lang.Math.min(r4, r5);
        if (r3 >= r4) goto L_0x0025;
    L_0x001d:
        r4 = r6[r3];
        r0.append(r4);
        r3 = r3 + 1;
        goto L_0x0015;
    L_0x0025:
        r6 = r0.toString();	 Catch:{ NumberFormatException -> 0x002e }
        r3 = java.lang.Long.parseLong(r6);	 Catch:{ NumberFormatException -> 0x002e }
        return r3;
    L_0x002e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.e.d.a(java.lang.String):long");
    }

    public String toString() {
        return C0007d.m22a().m5979a((Object) this);
    }
}
