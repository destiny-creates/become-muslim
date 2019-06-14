package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.aq;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;
import java.util.concurrent.Callable;

final /* synthetic */ class qx implements Callable {
    /* renamed from: a */
    private final Context f15964a;
    /* renamed from: b */
    private final sc f15965b;
    /* renamed from: c */
    private final String f15966c;
    /* renamed from: d */
    private final boolean f15967d;
    /* renamed from: e */
    private final boolean f15968e;
    /* renamed from: f */
    private final ahi f15969f;
    /* renamed from: g */
    private final mv f15970g;
    /* renamed from: h */
    private final atc f15971h;
    /* renamed from: i */
    private final aq f15972i;
    /* renamed from: j */
    private final bu f15973j;
    /* renamed from: k */
    private final amx f15974k;

    qx(Context context, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        this.f15964a = context;
        this.f15965b = scVar;
        this.f15966c = str;
        this.f15967d = z;
        this.f15968e = z2;
        this.f15969f = ahi;
        this.f15970g = mvVar;
        this.f15971h = atc;
        this.f15972i = aqVar;
        this.f15973j = buVar;
        this.f15974k = amx;
    }

    public final Object call() {
        Context context = this.f15964a;
        sc scVar = this.f15965b;
        String str = this.f15966c;
        boolean z = this.f15967d;
        boolean z2 = this.f15968e;
        qo raVar = new ra(rb.m42312a(context, scVar, str, z, z2, this.f15969f, this.f15970g, this.f15971h, this.f15972i, this.f15973j, this.f15974k));
        raVar.setWebViewClient(ax.g().mo6101a(raVar, z2));
        raVar.setWebChromeClient(new qg(raVar));
        return raVar;
    }
}
