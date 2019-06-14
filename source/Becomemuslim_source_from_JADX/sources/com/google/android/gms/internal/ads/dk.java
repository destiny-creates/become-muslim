package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C2850d;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;

@cm
public final class dk extends C2850d<dt> {
    public dk(Context context, Looper looper, C2844a c2844a, C2845b c2845b) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        super(context, looper, 8, c2844a, c2845b, null);
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface m30703a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return queryLocalInterface instanceof dt ? (dt) queryLocalInterface : new dv(iBinder);
    }

    /* renamed from: b */
    protected final String m30704b() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* renamed from: e */
    public final dt m30705e() {
        return (dt) super.w();
    }

    protected final String q_() {
        return "com.google.android.gms.ads.service.START";
    }
}
