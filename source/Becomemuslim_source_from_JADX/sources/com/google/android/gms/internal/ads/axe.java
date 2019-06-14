package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.p174b.C2762f;

@cm
public final class axe extends C2762f<avq> {
    public axe() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m30369b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return queryLocalInterface instanceof avq ? (avq) queryLocalInterface : new avr(iBinder);
    }
}
