package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C2850d;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;

@cm
public final class axl extends C2850d<axq> {
    axl(Context context, Looper looper, C2844a c2844a, C2845b c2845b) {
        super(context, looper, 166, c2844a, c2845b, null);
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface m30370a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        return queryLocalInterface instanceof axq ? (axq) queryLocalInterface : new axr(iBinder);
    }

    /* renamed from: b */
    protected final String m30371b() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    /* renamed from: e */
    public final axq m30372e() {
        return (axq) super.w();
    }

    protected final String q_() {
        return "com.google.android.gms.ads.service.HTTP";
    }
}
