package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class ad extends ajm implements ab {
    /* renamed from: a */
    public static ab m29766a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        return queryLocalInterface instanceof ab ? (ab) queryLocalInterface : new ae(iBinder);
    }
}
