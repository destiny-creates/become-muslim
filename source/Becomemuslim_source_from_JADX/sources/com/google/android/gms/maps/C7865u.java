package com.google.android.gms.maps;

import android.graphics.Bitmap;
import com.google.android.gms.maps.C5125c.C5124q;
import com.google.android.gms.maps.p216a.ah;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.maps.u */
final class C7865u extends ah {
    /* renamed from: a */
    private final /* synthetic */ C5124q f29326a;

    C7865u(C5125c c5125c, C5124q c5124q) {
        this.f29326a = c5124q;
    }

    /* renamed from: a */
    public final void mo6248a(Bitmap bitmap) {
        this.f29326a.onSnapshotReady(bitmap);
    }

    /* renamed from: a */
    public final void mo6249a(C2758b c2758b) {
        this.f29326a.onSnapshotReady((Bitmap) C4757d.a(c2758b));
    }
}
