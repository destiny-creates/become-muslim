package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.p174b.C2762f;
import com.google.android.gms.p174b.C4757d;

@cm
/* renamed from: com.google.android.gms.internal.ads.q */
public final class C6766q extends C2762f<C4937u> {
    public C6766q() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: a */
    public final C4936r m31000a(Activity activity) {
        try {
            IBinder a = ((C4937u) a(activity)).mo4386a(C4757d.a(activity));
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return queryLocalInterface instanceof C4936r ? (C4936r) queryLocalInterface : new C6768t(a);
        } catch (Throwable e) {
            mt.m19921c("Could not create remote AdOverlay.", e);
            return null;
        }
    }

    /* renamed from: b */
    protected final /* synthetic */ Object m31001b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return queryLocalInterface instanceof C4937u ? (C4937u) queryLocalInterface : new C6769v(iBinder);
    }
}
