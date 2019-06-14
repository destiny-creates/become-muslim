package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;

/* renamed from: com.google.android.gms.common.j */
public class C2873j {
    /* renamed from: a */
    private static C2873j f7336a;
    /* renamed from: b */
    private final Context f7337b;

    private C2873j(Context context) {
        this.f7337b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C2873j m8395a(Context context) {
        C2872v.m8380a((Object) context);
        synchronized (C2873j.class) {
            if (f7336a == null) {
                C2880q.m8405a(context);
                f7336a = new C2873j(context);
            }
        }
        return f7336a;
    }

    /* renamed from: a */
    public boolean m8399a(int i) {
        aa aaVar;
        String[] a = C2829c.m8131a(this.f7337b).m8128a(i);
        if (a != null) {
            if (a.length != 0) {
                aaVar = null;
                for (String a2 : a) {
                    aaVar = m8394a(a2, i);
                    if (aaVar.f7074a) {
                        break;
                    }
                }
                aaVar.m7898c();
                return aaVar.f7074a;
            }
        }
        aaVar = aa.m7893a("no pkgs");
        aaVar.m7898c();
        return aaVar.f7074a;
    }

    /* renamed from: a */
    public static boolean m8397a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                packageInfo = C2873j.m8396a(packageInfo, C2914v.f7408a);
            } else {
                packageInfo = C2873j.m8396a(packageInfo, C2914v.f7408a[0]);
            }
            if (packageInfo != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m8400a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (C2873j.m8397a(packageInfo, false)) {
            return true;
        }
        if (C2873j.m8397a(packageInfo, true) != null) {
            if (C2832i.honorsDebugCertificates(this.f7337b) != null) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    /* renamed from: a */
    private final com.google.android.gms.common.aa m8394a(java.lang.String r3, int r4) {
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
        r0 = r2.f7337b;	 Catch:{ NameNotFoundException -> 0x0011 }
        r0 = com.google.android.gms.common.p180d.C2829c.m8131a(r0);	 Catch:{ NameNotFoundException -> 0x0011 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0011 }
        r4 = r0.m8125a(r3, r1, r4);	 Catch:{ NameNotFoundException -> 0x0011 }
        r4 = r2.m8398b(r4);	 Catch:{ NameNotFoundException -> 0x0011 }
        return r4;
        r4 = "no pkg ";
        r3 = java.lang.String.valueOf(r3);
        r0 = r3.length();
        if (r0 == 0) goto L_0x0023;
    L_0x001e:
        r3 = r4.concat(r3);
        goto L_0x0028;
    L_0x0023:
        r3 = new java.lang.String;
        r3.<init>(r4);
    L_0x0028:
        r3 = com.google.android.gms.common.aa.m7893a(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.j.a(java.lang.String, int):com.google.android.gms.common.aa");
    }

    /* renamed from: b */
    private final aa m8398b(PackageInfo packageInfo) {
        boolean honorsDebugCertificates = C2832i.honorsDebugCertificates(this.f7337b);
        if (packageInfo == null) {
            return aa.m7893a("null pkg");
        }
        if (packageInfo.signatures.length != 1) {
            return aa.m7893a("single cert required");
        }
        C4789s c4887t = new C4887t(packageInfo.signatures[0].toByteArray());
        String str = packageInfo.packageName;
        aa a = C2880q.m8403a(str, c4887t, honorsDebugCertificates);
        return (!a.f7074a || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == null || (honorsDebugCertificates && C2880q.m8403a(str, c4887t, false).f7074a == null)) ? a : aa.m7893a("debuggable release cert app rejected");
    }

    /* renamed from: a */
    private static C4789s m8396a(PackageInfo packageInfo, C4789s... c4789sArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        int i = 0;
        C4887t c4887t = new C4887t(packageInfo.signatures[0].toByteArray());
        while (i < c4789sArr.length) {
            if (c4789sArr[i].equals(c4887t) != null) {
                return c4789sArr[i];
            }
            i++;
        }
        return null;
    }
}
