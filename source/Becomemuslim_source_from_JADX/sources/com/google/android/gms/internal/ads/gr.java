package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.p174b.C2762f;
import com.google.android.gms.p174b.C4757d;

@cm
public final class gr extends C2762f<gl> {
    public gr() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    /* renamed from: a */
    public final gh m30758a(Context context, bcy bcy) {
        try {
            IBinder a = ((gl) a(context)).mo4266a(C4757d.a(context), bcy, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            return queryLocalInterface instanceof gh ? (gh) queryLocalInterface : new gk(a);
        } catch (Throwable e) {
            mt.m19921c("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m30759b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return queryLocalInterface instanceof gl ? (gl) queryLocalInterface : new gm(iBinder);
    }
}
