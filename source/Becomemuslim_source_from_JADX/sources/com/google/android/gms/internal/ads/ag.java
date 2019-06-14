package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class ag extends ajm implements af {
    /* renamed from: a */
    public static af m29905a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        return queryLocalInterface instanceof af ? (af) queryLocalInterface : new ah(iBinder);
    }
}
