package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.C2787e;
import com.google.android.gms.common.api.internal.C4347a;
import com.google.android.gms.common.internal.C2871u;
import com.google.android.gms.p186f.C2954g;

/* renamed from: com.google.android.gms.location.e */
public class C6832e extends C2787e<Object> {
    public C6832e(Context context) {
        super(context, C5082m.f17381a, null, new C4347a());
    }

    /* renamed from: a */
    public C2954g<Void> m32113a(PendingIntent pendingIntent) {
        return C2871u.a(C5082m.f17382b.mo4630a(i(), pendingIntent));
    }

    /* renamed from: a */
    public C2954g<Void> m32114a(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return C2871u.a(C5082m.f17382b.mo4631a(i(), locationRequest, pendingIntent));
    }
}
