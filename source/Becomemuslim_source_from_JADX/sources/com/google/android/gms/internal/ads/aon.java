package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.p174b.C2762f;
import com.google.android.gms.p174b.C4757d;

@cm
public final class aon extends C2762f<apw> {
    public aon() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* renamed from: a */
    public final apt m30055a(Context context, String str, bcy bcy) {
        try {
            IBinder a = ((apw) a(context)).mo3880a(C4757d.a(context), str, bcy, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof apt ? (apt) queryLocalInterface : new apv(a);
        } catch (Throwable e) {
            mt.m19921c("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m30056b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof apw ? (apw) queryLocalInterface : new apx(iBinder);
    }
}
