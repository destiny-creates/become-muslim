package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.ads.z */
public final class C6772z extends ajm implements C4939y {
    /* renamed from: a */
    public static C4939y m31244a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        return queryLocalInterface instanceof C4939y ? (C4939y) queryLocalInterface : new aa(iBinder);
    }
}
