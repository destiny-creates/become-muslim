package com.google.android.gms.common.internal.p182b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;

/* renamed from: com.google.android.gms.common.internal.b.j */
public final class C4885j extends C4785j<C2841m> {
    public C4885j(Context context, Looper looper, C2853f c2853f, C2775b c2775b, C2776c c2776c) {
        super(context, looper, 39, c2853f, c2775b, c2776c);
    }

    /* renamed from: b */
    protected final String mo3449b() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    public final String q_() {
        return "com.google.android.gms.common.service.START";
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface mo3448a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        if (queryLocalInterface instanceof C2841m) {
            return (C2841m) queryLocalInterface;
        }
        return new C4366n(iBinder);
    }
}
