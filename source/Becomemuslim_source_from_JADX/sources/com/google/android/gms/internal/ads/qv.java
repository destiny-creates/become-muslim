package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.aq;
import com.google.android.gms.ads.internal.bu;

@cm
public final class qv {
    /* renamed from: a */
    public static no<qo> m20038a(Context context, mv mvVar, String str, ahi ahi, bu buVar) {
        return nd.m19940a(nd.m19938a(null), new qw(context, ahi, mvVar, buVar, str), nu.f15846a);
    }

    /* renamed from: a */
    public static qo m20039a(Context context, sc scVar, String str, boolean z, boolean z2, ahi ahi, mv mvVar, atc atc, aq aqVar, bu buVar, amx amx) {
        asp.m18892a(context);
        if (((Boolean) aph.m18688f().m18889a(asp.az)).booleanValue()) {
            return si.m20096a(context, scVar, str, z2, z, ahi, mvVar, atc, aqVar, buVar, amx);
        }
        try {
            return (qo) lz.m19846a(new qx(context, scVar, str, z, z2, ahi, mvVar, atc, aqVar, buVar, amx));
        } catch (Throwable th) {
            qz qzVar = new qz("Webview initialization failed.", th);
        }
    }
}
