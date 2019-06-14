package com.google.android.gms.common.internal;

import android.accounts.Account;
import com.google.android.gms.common.internal.C2862o.C4371a;

/* renamed from: com.google.android.gms.common.internal.a */
public class C4777a extends C4371a {
    /* renamed from: a */
    public static android.accounts.Account m16832a(com.google.android.gms.common.internal.C2862o r3) {
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
        if (r3 == 0) goto L_0x001f;
    L_0x0002:
        r0 = android.os.Binder.clearCallingIdentity();
        r3 = r3.mo2479a();	 Catch:{ RemoteException -> 0x0010 }
        android.os.Binder.restoreCallingIdentity(r0);
        goto L_0x0020;
    L_0x000e:
        r3 = move-exception;
        goto L_0x001b;
    L_0x0010:
        r3 = "AccountAccessor";	 Catch:{ all -> 0x000e }
        r2 = "Remote account accessor probably died";	 Catch:{ all -> 0x000e }
        android.util.Log.w(r3, r2);	 Catch:{ all -> 0x000e }
        android.os.Binder.restoreCallingIdentity(r0);
        goto L_0x001f;
    L_0x001b:
        android.os.Binder.restoreCallingIdentity(r0);
        throw r3;
    L_0x001f:
        r3 = 0;
    L_0x0020:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.a.a(com.google.android.gms.common.internal.o):android.accounts.Account");
    }

    /* renamed from: a */
    public final Account mo2479a() {
        throw new NoSuchMethodError();
    }

    public boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }
}
