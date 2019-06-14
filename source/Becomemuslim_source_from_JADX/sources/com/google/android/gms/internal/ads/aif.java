package com.google.android.gms.internal.ads;

final class aif {
    /* renamed from: a */
    static tz f14565a;

    /* renamed from: a */
    static boolean m18476a(com.google.android.gms.internal.ads.ahz r8) {
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
        r0 = f14565a;
        r1 = 1;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = com.google.android.gms.internal.ads.asp.bK;
        r2 = com.google.android.gms.internal.ads.aph.m18688f();
        r0 = r2.m18889a(r0);
        r0 = (java.lang.String) r0;
        r2 = 0;
        if (r0 == 0) goto L_0x001b;
    L_0x0015:
        r3 = r0.length();
        if (r3 != 0) goto L_0x0036;
    L_0x001b:
        r0 = 0;
        if (r8 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0033;
    L_0x001f:
        r3 = "4o7tecxtkw7XaNt5hPj+0H1LvOi0SgxCIJTY9VcbazM/HSl/sFlxBFwnc8glnvoB";
        r4 = "RgSY6YxU2k1vLXOV3vapBnQwJDzYDlmX50wbm2tDcnw=";
        r8 = r8.m18455a(r3, r4);
        if (r8 != 0) goto L_0x002a;
    L_0x0029:
        goto L_0x0033;
    L_0x002a:
        r3 = new java.lang.Object[r2];
        r8 = r8.invoke(r0, r3);
        r8 = (java.lang.String) r8;
        r0 = r8;
    L_0x0033:
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        return r2;
    L_0x0036:
        r8 = com.google.android.gms.internal.ads.agh.m18406a(r0, r1);	 Catch:{ IllegalArgumentException -> 0x00b9 }
        r8 = com.google.android.gms.internal.ads.uf.m20140a(r8);	 Catch:{  }
        r0 = com.google.android.gms.internal.ads.ux.f16059a;	 Catch:{  }
        r0 = r0.m43817a();	 Catch:{  }
        r0 = r0.iterator();	 Catch:{  }
    L_0x0048:
        r3 = r0.hasNext();	 Catch:{  }
        if (r3 == 0) goto L_0x00ae;	 Catch:{  }
    L_0x004e:
        r3 = r0.next();	 Catch:{  }
        r3 = (com.google.android.gms.internal.ads.xm) r3;	 Catch:{  }
        r4 = r3.m43732b();	 Catch:{  }
        r4 = r4.isEmpty();	 Catch:{  }
        if (r4 != 0) goto L_0x00a6;	 Catch:{  }
    L_0x005e:
        r4 = r3.m43731a();	 Catch:{  }
        r4 = r4.isEmpty();	 Catch:{  }
        if (r4 != 0) goto L_0x009e;	 Catch:{  }
    L_0x0068:
        r4 = r3.m43735e();	 Catch:{  }
        r4 = r4.isEmpty();	 Catch:{  }
        if (r4 != 0) goto L_0x0096;	 Catch:{  }
    L_0x0072:
        r4 = r3.m43735e();	 Catch:{  }
        r4 = com.google.android.gms.internal.ads.ui.m20147a(r4);	 Catch:{  }
        r5 = r3.m43732b();	 Catch:{  }
        r6 = r3.m43731a();	 Catch:{  }
        r7 = r3.m43733c();	 Catch:{  }
        r4 = r4.mo4378a(r5, r6, r7);	 Catch:{  }
        r5 = r3.m43732b();	 Catch:{  }
        r3 = r3.m43734d();	 Catch:{  }
        com.google.android.gms.internal.ads.ui.m20154a(r5, r4, r3);	 Catch:{  }
        goto L_0x0048;	 Catch:{  }
    L_0x0096:
        r8 = new java.security.GeneralSecurityException;	 Catch:{  }
        r0 = "Missing catalogue_name.";	 Catch:{  }
        r8.<init>(r0);	 Catch:{  }
        throw r8;	 Catch:{  }
    L_0x009e:
        r8 = new java.security.GeneralSecurityException;	 Catch:{  }
        r0 = "Missing primitive_name.";	 Catch:{  }
        r8.<init>(r0);	 Catch:{  }
        throw r8;	 Catch:{  }
    L_0x00a6:
        r8 = new java.security.GeneralSecurityException;	 Catch:{  }
        r0 = "Missing type_url.";	 Catch:{  }
        r8.<init>(r0);	 Catch:{  }
        throw r8;	 Catch:{  }
    L_0x00ae:
        r8 = com.google.android.gms.internal.ads.va.m20161a(r8);	 Catch:{  }
        f14565a = r8;	 Catch:{  }
        r8 = f14565a;
        if (r8 == 0) goto L_0x00b9;
    L_0x00b8:
        return r1;
    L_0x00b9:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aif.a(com.google.android.gms.internal.ads.ahz):boolean");
    }
}
