package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.p174b.C2762f;

@cm
public final class ark extends C2762f<aqt> {
    public ark() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m30163b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof aqt ? (aqt) queryLocalInterface : new aqu(iBinder);
    }
}
