package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.util.C2904o;

@cm
public final class pf extends oy {
    /* renamed from: a */
    public final ox mo4335a(Context context, pn pnVar, int i, boolean z, atc atc, pm pmVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        Object obj = (!C2904o.b() || (applicationInfo != null && applicationInfo.targetSdkVersion < 11)) ? null : 1;
        if (obj == null) {
            return null;
        }
        return new ol(context, z, pnVar.mo6135t().m20093d(), pmVar, new po(context, pnVar.mo6133k(), pnVar.mo6697i(), atc, pnVar.mo6688c()));
    }
}
