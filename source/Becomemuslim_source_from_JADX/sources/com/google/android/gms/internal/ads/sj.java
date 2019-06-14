package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.aq;
import com.google.android.gms.ads.internal.bu;
import java.util.concurrent.Callable;

final /* synthetic */ class sj implements Callable {
    /* renamed from: a */
    private final Context f16001a;
    /* renamed from: b */
    private final sc f16002b;
    /* renamed from: c */
    private final String f16003c;
    /* renamed from: d */
    private final boolean f16004d;
    /* renamed from: e */
    private final boolean f16005e;
    /* renamed from: f */
    private final ahi f16006f;
    /* renamed from: g */
    private final mv f16007g;
    /* renamed from: h */
    private final atc f16008h;
    /* renamed from: i */
    private final aq f16009i;
    /* renamed from: j */
    private final bu f16010j;
    /* renamed from: k */
    private final amx f16011k;

    sj(Context context, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        this.f16001a = context;
        this.f16002b = scVar;
        this.f16003c = str;
        this.f16004d = z;
        this.f16005e = z2;
        this.f16006f = ahi;
        this.f16007g = mvVar;
        this.f16008h = atc;
        this.f16009i = aqVar;
        this.f16010j = buVar;
        this.f16011k = amx;
    }

    public final Object call() {
        Context context = this.f16001a;
        sc scVar = this.f16002b;
        String str = this.f16003c;
        boolean z = this.f16004d;
        boolean z2 = this.f16005e;
        sm a = sk.m42389a(context, scVar, str, z, z2, this.f16006f, this.f16007g, this.f16008h, this.f16009i, this.f16010j, this.f16011k);
        qo raVar = new ra(a);
        sd sdVar = new sd(raVar, z2);
        a.setWebChromeClient(new qg(raVar));
        a.m31091a((sr) sdVar);
        a.m31094a((sw) sdVar);
        a.m31093a((sv) sdVar);
        a.m31092a((st) sdVar);
        a.m42408a(sdVar);
        return raVar;
    }
}
