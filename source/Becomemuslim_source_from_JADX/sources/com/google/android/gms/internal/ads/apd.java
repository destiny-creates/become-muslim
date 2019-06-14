package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.aoy.C4921a;
import com.google.android.gms.p174b.C4757d;

final class apd extends C4921a<avi> {
    /* renamed from: a */
    private final /* synthetic */ FrameLayout f23779a;
    /* renamed from: b */
    private final /* synthetic */ FrameLayout f23780b;
    /* renamed from: c */
    private final /* synthetic */ Context f23781c;
    /* renamed from: d */
    private final /* synthetic */ aoy f23782d;

    apd(aoy aoy, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f23782d = aoy;
        this.f23779a = frameLayout;
        this.f23780b = frameLayout2;
        this.f23781c = context;
        super(aoy);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3854a() {
        avi a = this.f23782d.f14804f.m30367a(this.f23781c, this.f23779a, this.f23780b);
        if (a != null) {
            return a;
        }
        aoy.m18671a(this.f23781c, "native_ad_view_delegate");
        return new arr();
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3855a(aqk aqk) {
        return aqk.createNativeAdViewDelegate(C4757d.a(this.f23779a), C4757d.a(this.f23780b));
    }
}
