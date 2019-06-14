package com.facebook.ads.internal.p085a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.p098m.C1412c;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.a.e */
public class C1301e {

    /* renamed from: com.facebook.ads.internal.a.e$a */
    public interface C1300a {
        /* renamed from: a */
        C1299d mo934a();

        /* renamed from: b */
        Collection<String> mo935b();

        /* renamed from: c */
        String mo936c();
    }

    /* renamed from: a */
    public static Collection<String> m4450a(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                Collection hashSet = new HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(jSONArray.optString(i));
                }
                return hashSet;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m4451a(Context context, C1300a c1300a, C1412c c1412c) {
        C1299d a = c1300a.mo934a();
        if (a != null) {
            if (a != C1299d.NONE) {
                Collection<String> b = c1300a.mo935b();
                if (b != null) {
                    if (!b.isEmpty()) {
                        Object obj;
                        for (String a2 : b) {
                            if (C1301e.m4452a(context, a2)) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == (a == C1299d.INSTALLED ? 1 : null)) {
                            obj = c1300a.mo936c();
                            if (!TextUtils.isEmpty(obj)) {
                                c1412c.mo947b(obj, null);
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m4452a(android.content.Context r2, java.lang.String r3) {
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
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r2.getPackageManager();
        r0 = 1;
        r2.getPackageInfo(r3, r0);	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        return r0;
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.a.e.a(android.content.Context, java.lang.String):boolean");
    }
}
