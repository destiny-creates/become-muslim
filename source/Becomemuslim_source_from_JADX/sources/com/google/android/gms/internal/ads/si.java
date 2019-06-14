package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.aq;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;

@cm
public final class si {
    /* renamed from: a */
    public static qo m20096a(Context context, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        try {
            return (qo) lz.m19846a(new sj(context, scVar, str, z, z2, ahi, mvVar, atc, aqVar, buVar, amx));
        } catch (Throwable th) {
            ax.i().m30834a(th, "AdWebViewFactory.newAdWebView2");
            qz qzVar = new qz("Webview initialization failed.", th);
        }
    }
}
