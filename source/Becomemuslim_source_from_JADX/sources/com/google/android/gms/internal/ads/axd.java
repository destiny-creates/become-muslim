package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.widget.FrameLayout;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.p174b.C2762f;
import com.google.android.gms.p174b.C4757d;

@cm
public final class axd extends C2762f<avl> {
    public axd() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* renamed from: a */
    public final avi m30367a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder a = ((avl) a(context)).mo4005a(C4757d.a(context), C4757d.a(frameLayout), C4757d.a(frameLayout2), C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return queryLocalInterface instanceof avi ? (avi) queryLocalInterface : new avk(a);
        } catch (Throwable e) {
            mt.m19921c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m30368b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return queryLocalInterface instanceof avl ? (avl) queryLocalInterface : new avm(iBinder);
    }
}
