package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2779d;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.C2787e;
import com.google.android.gms.common.api.internal.C2798d.C4771a;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;

public final class cu<O extends C2779d> extends C2787e<O> {
    /* renamed from: b */
    private final C4340f f11517b;
    /* renamed from: c */
    private final co f11518c;
    /* renamed from: d */
    private final C2853f f11519d;
    /* renamed from: e */
    private final C4337a<? extends C4764e, C4882a> f11520e;

    public cu(Context context, C2781a<O> c2781a, Looper looper, C4340f c4340f, co coVar, C2853f c2853f, C4337a<? extends C4764e, C4882a> c4337a) {
        super(context, c2781a, looper);
        this.f11517b = c4340f;
        this.f11518c = coVar;
        this.f11519d = c2853f;
        this.f11520e = c4337a;
        this.a.m8057a((C2787e) this);
    }

    /* renamed from: a */
    public final C4340f m14252a() {
        return this.f11517b;
    }

    /* renamed from: a */
    public final C4340f mo2446a(Looper looper, C4771a<O> c4771a) {
        this.f11518c.m14212a(c4771a);
        return this.f11517b;
    }

    /* renamed from: a */
    public final br mo2447a(Context context, Handler handler) {
        return new br(context, handler, this.f11519d, this.f11520e);
    }
}
