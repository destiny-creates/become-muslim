package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;

final /* synthetic */ class qw implements my {
    /* renamed from: a */
    private final Context f24279a;
    /* renamed from: b */
    private final ahi f24280b;
    /* renamed from: c */
    private final mv f24281c;
    /* renamed from: d */
    private final bu f24282d;
    /* renamed from: e */
    private final String f24283e;

    qw(Context context, ahi ahi, mv mvVar, bu buVar, String str) {
        this.f24279a = context;
        this.f24280b = ahi;
        this.f24281c = mvVar;
        this.f24282d = buVar;
        this.f24283e = str;
    }

    /* renamed from: a */
    public final no mo4228a(Object obj) {
        Context context = this.f24279a;
        ahi ahi = this.f24280b;
        mv mvVar = this.f24281c;
        bu buVar = this.f24282d;
        String str = this.f24283e;
        ax.f();
        qo a = qv.m20039a(context, sc.m20088a(), "", false, false, ahi, mvVar, null, null, buVar, amx.m18642a());
        no a2 = ny.m37567a(a);
        a.mo6718v().mo4343a(new qy(a2));
        a.loadUrl(str);
        return a2;
    }
}
