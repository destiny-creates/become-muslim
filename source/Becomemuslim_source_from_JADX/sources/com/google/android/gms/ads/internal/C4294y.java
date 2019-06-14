package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.internal.ads.bdk;
import com.google.android.gms.internal.ads.bdo;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.p174b.C4757d;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.y */
final class C4294y implements ae<qo> {
    /* renamed from: a */
    private final /* synthetic */ bdk f11326a;
    /* renamed from: b */
    private final /* synthetic */ C2641d f11327b;
    /* renamed from: c */
    private final /* synthetic */ bdo f11328c;

    C4294y(bdk bdk, C2641d c2641d, bdo bdo) {
        this.f11326a = bdk;
        this.f11327b = c2641d;
        this.f11328c = bdo;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        Object view = qoVar.getView();
        if (view != null) {
            try {
                if (this.f11326a == null) {
                    if (this.f11328c != null) {
                        if (this.f11328c.i()) {
                            C2674t.m7560b(qoVar);
                        } else {
                            this.f11328c.a(C4757d.m16684a(view));
                            this.f11327b.f6852a.onAdClicked();
                        }
                    }
                } else if (this.f11326a.k()) {
                    C2674t.m7560b(qoVar);
                } else {
                    this.f11326a.a(C4757d.m16684a(view));
                    this.f11327b.f6852a.onAdClicked();
                }
            } catch (Throwable e) {
                jn.c("Unable to call handleClick on mapper", e);
            }
        }
    }
}
