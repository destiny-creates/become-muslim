package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.r */
public final class C4871r extends C4740d {
    public C4871r(Activity activity) {
        super(activity);
    }

    /* renamed from: a */
    public final void mo3447a(Bundle bundle) {
        jn.a("AdOverlayParcel is null or does not contain valid overlay type.");
        this.d = 3;
        this.a.finish();
    }
}
