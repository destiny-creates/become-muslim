package com.google.android.exoplayer2.p163k;

import android.content.Context;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;

/* compiled from: DefaultDataSourceFactory */
/* renamed from: com.google.android.exoplayer2.k.n */
public final class C4244n implements C2497a {
    /* renamed from: a */
    private final Context f11203a;
    /* renamed from: b */
    private final C2514v<? super C2498g> f11204b;
    /* renamed from: c */
    private final C2497a f11205c;

    public /* synthetic */ C2498g createDataSource() {
        return m13786a();
    }

    public C4244n(Context context, String str, C2514v<? super C2498g> c2514v) {
        this(context, (C2514v) c2514v, new C4869p(str, c2514v));
    }

    public C4244n(Context context, C2514v<? super C2498g> c2514v, C2497a c2497a) {
        this.f11203a = context.getApplicationContext();
        this.f11204b = c2514v;
        this.f11205c = c2497a;
    }

    /* renamed from: a */
    public C4243m m13786a() {
        return new C4243m(this.f11203a, this.f11204b, this.f11205c.createDataSource());
    }
}
