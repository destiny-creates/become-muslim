package com.google.android.gms.p175c;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.p175c.p176a.C4881a;

/* renamed from: com.google.android.gms.c.c */
final class C4762c extends C4337a<C4881a, C4882a> {
    C4762c() {
    }

    /* renamed from: a */
    public final /* synthetic */ C4340f mo3263a(Context context, Looper looper, C2853f c2853f, Object obj, C2775b c2775b, C2776c c2776c) {
        C4882a c4882a = (C4882a) obj;
        if (c4882a == null) {
            c4882a = C4882a.f13966a;
        }
        return new C4881a(context, looper, true, c2853f, c4882a, c2775b, c2776c);
    }
}
