package com.facebook.react.modules.network;

import expolib_v1.p321a.C6228l;
import expolib_v1.p321a.C6229m;
import expolib_v1.p321a.C6237r;
import java.util.List;

public class ReactCookieJarContainer implements CookieJarContainer {
    private C6229m cookieJar = null;

    public void setCookieJar(C6229m c6229m) {
        this.cookieJar = c6229m;
    }

    public void removeCookieJar() {
        this.cookieJar = null;
    }

    public void saveFromResponse(C6237r c6237r, List<C6228l> list) {
        if (this.cookieJar != null) {
            this.cookieJar.saveFromResponse(c6237r, list);
        }
    }

    public java.util.List<expolib_v1.p321a.C6228l> loadForRequest(expolib_v1.p321a.C6237r r6) {
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
        r0 = r5.cookieJar;
        if (r0 == 0) goto L_0x0034;
    L_0x0004:
        r0 = r5.cookieJar;
        r6 = r0.loadForRequest(r6);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r6 = r6.iterator();
    L_0x0013:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0033;
    L_0x0019:
        r1 = r6.next();
        r1 = (expolib_v1.p321a.C6228l) r1;
        r2 = new expolib_v1.a.q$a;	 Catch:{ IllegalArgumentException -> 0x0013 }
        r2.<init>();	 Catch:{ IllegalArgumentException -> 0x0013 }
        r3 = r1.a();	 Catch:{ IllegalArgumentException -> 0x0013 }
        r4 = r1.b();	 Catch:{ IllegalArgumentException -> 0x0013 }
        r2.a(r3, r4);	 Catch:{ IllegalArgumentException -> 0x0013 }
        r0.add(r1);	 Catch:{ IllegalArgumentException -> 0x0013 }
        goto L_0x0013;
    L_0x0033:
        return r0;
    L_0x0034:
        r6 = java.util.Collections.emptyList();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.ReactCookieJarContainer.loadForRequest(expolib_v1.a.r):java.util.List<expolib_v1.a.l>");
    }
}
