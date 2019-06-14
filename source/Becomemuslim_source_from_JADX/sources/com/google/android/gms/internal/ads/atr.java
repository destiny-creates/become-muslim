package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.ae;

final class atr implements ae<Object> {
    /* renamed from: a */
    private final /* synthetic */ atq f23795a;

    atr(atq atq) {
        this.f23795a = atq;
    }

    public final void zza(java.lang.Object r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = r2.f23795a;	 Catch:{ NumberFormatException -> 0x0015 }
        r0 = "timestamp";	 Catch:{ NumberFormatException -> 0x0015 }
        r0 = r4.get(r0);	 Catch:{ NumberFormatException -> 0x0015 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0015 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0015 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0015 }
        r3.f14993b = r0;	 Catch:{ NumberFormatException -> 0x0015 }
        goto L_0x001a;
    L_0x0015:
        r3 = "Failed to call parse unconfirmedClickTimestamp.";
        com.google.android.gms.internal.ads.mt.m19920c(r3);
    L_0x001a:
        r3 = r2.f23795a;
        r0 = "id";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r3.f14992a = r0;
        r3 = "asset_id";
        r3 = r4.get(r3);
        r3 = (java.lang.String) r3;
        r4 = r2.f23795a;
        r4 = r4.f14996e;
        if (r4 != 0) goto L_0x003c;
    L_0x0036:
        r3 = "Received unconfirmed click but UnconfirmedClickListener is null.";
        com.google.android.gms.internal.ads.mt.m19918b(r3);
        return;
    L_0x003c:
        r4 = r2.f23795a;	 Catch:{ RemoteException -> 0x0046 }
        r4 = r4.f14996e;	 Catch:{ RemoteException -> 0x0046 }
        r4.mo4061a(r3);	 Catch:{ RemoteException -> 0x0046 }
        return;
    L_0x0046:
        r3 = move-exception;
        r4 = "#007 Could not call remote method.";
        com.google.android.gms.internal.ads.mt.m19923d(r4, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.atr.zza(java.lang.Object, java.util.Map):void");
    }
}
