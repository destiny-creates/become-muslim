package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.p174b.C2762f;
import com.google.android.gms.p174b.C4757d;

@cm
public final class aoo extends C2762f<aqb> {
    public aoo() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* renamed from: a */
    public final apy m30057a(Context context, aou aou, String str, bcy bcy, int i) {
        try {
            IBinder a = ((aqb) a(context)).mo3914a(C4757d.a(context), aou, str, bcy, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE, i);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return queryLocalInterface instanceof apy ? (apy) queryLocalInterface : new aqa(a);
        } catch (Throwable e) {
            mt.m19916a("Could not create remote AdManager.", e);
            return null;
        }
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m30058b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof aqb ? (aqb) queryLocalInterface : new aqc(iBinder);
    }
}
