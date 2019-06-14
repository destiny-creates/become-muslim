package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.internal.p215n.C8221b;
import com.google.android.gms.wallet.C5162r.C8229a;

final class ah extends C4337a<C8221b, C8229a> {
    ah() {
    }

    /* renamed from: a */
    public final /* synthetic */ C4340f m38402a(Context context, Looper looper, C2853f c2853f, Object obj, C2775b c2775b, C2776c c2776c) {
        C8229a c8229a = (C8229a) obj;
        if (c8229a == null) {
            c8229a = new C8229a();
        }
        return new C8221b(context, looper, c2853f, c2775b, c2776c, c8229a.f32375a, c8229a.f32376b, c8229a.f32377c);
    }
}
