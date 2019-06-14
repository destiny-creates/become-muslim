package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@cm
public final class fk {
    /* renamed from: a */
    private WeakHashMap<Context, fm> f15493a = new WeakHashMap();

    /* renamed from: a */
    public final Future<fi> m19437a(Context context) {
        return ju.m19679a(new fl(this, context));
    }
}
